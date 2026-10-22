package com.stepos.deepbinder.client.channel.remote;

import ai.onnxruntime.BuildConfig;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.IContentProvider;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import java.lang.reflect.Field;
import kotlin.jvm.internal.g;
import mb.l;
import w9.e;

/* compiled from: r8-map-id-111c466502ad74cb356cc021579a8ddb0a2e23c510d1cc7af75a11a7c889eebb */
/* loaded from: classes.dex */
public final class b extends a {

    /* renamed from: a, reason: collision with root package name */
    public final Uri f7621a;

    /* renamed from: b, reason: collision with root package name */
    public final ContentResolver f7622b;

    /* renamed from: c, reason: collision with root package name */
    public ContentProviderClient f7623c;

    /* renamed from: d, reason: collision with root package name */
    public Field f7624d;

    public b(ComponentName componentName) {
        g.f(componentName, "componentName");
        Uri uri = x9.c.c(componentName).f13761c;
        a.Companion.getClass();
        a.cacheUri = uri;
        g.c(uri);
        this.f7621a = uri;
        ContentResolver contentResolver = DeepBinderClient.INSTANCE.getContext().getContentResolver();
        g.e(contentResolver, "getContentResolver(...)");
        this.f7622b = contentResolver;
        i9.a.b(uri);
    }

    public final Reply a(String str, Bundle bundle, boolean z, boolean z3, int i10) {
        try {
            bundle.putInt("protocolVersion", i10);
            if (z && z3) {
                e.f13612e.b(new com.stepos.statsapp.v3.lib.plugin.emitter.remote.c(this, str, bundle, 7), false, false);
                Reply replyObtain = Reply.CREATOR.obtain();
                replyObtain.setResult(null);
                return replyObtain;
            }
            Bundle bundleB = b(bundle, str);
            bundleB.setClassLoader(b.class.getClassLoader());
            Reply reply = (Reply) bundleB.getParcelable("reply");
            if (reply != null) {
                return reply;
            }
            Reply replyObtain2 = Reply.CREATOR.obtain();
            replyObtain2.setResult(null);
            return replyObtain2;
        } catch (Throwable th) {
            throw new IPCException(9, th);
        }
    }

    public final Bundle b(Bundle bundle, String str) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Bundle bundleCall;
        try {
            if (this.f7624d == null) {
                Field declaredField = ContentProviderClient.class.getDeclaredField("mContentProvider");
                declaredField.setAccessible(true);
                this.f7624d = declaredField;
            }
            Field field = this.f7624d;
            g.c(field);
            Object obj = field.get(this.f7623c);
            IContentProvider iContentProvider = obj instanceof IContentProvider ? (IContentProvider) obj : null;
            if (iContentProvider != null && !iContentProvider.asBinder().isBinderAlive()) {
                release();
            }
        } catch (Exception e10) {
            IPCLog.INSTANCE.w("DefaultRemoteChannel", "[releaseUnliveContentProviderClient] exception: " + e10, new Object[0]);
        }
        if (this.f7623c == null) {
            this.f7623c = this.f7622b.acquireUnstableContentProviderClient(this.f7621a);
        }
        ContentProviderClient contentProviderClient = this.f7623c;
        if (contentProviderClient == null || (bundleCall = contentProviderClient.call(str, "", bundle)) == null) {
            throw new IPCException(54, "acquire UnstableContentProviderClient failed");
        }
        return bundleCall;
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public final void internalConnect() {
        a("connect", new Bundle(), true, true, 2);
    }

    @Override // o9.b
    public final void internalRecycle(Long[] lArr) {
        Bundle bundle = new Bundle();
        bundle.putInt("pid", Process.myPid());
        bundle.putLongArray("timeStamps", l.r0(lArr));
        a("recycle_remote", bundle, true, true, 2);
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public final Reply internalSendCall(Call call) {
        g.f(call, "call");
        Bundle bundle = new Bundle();
        bundle.putParcelable("call", call);
        MethodWrapper methodWrapper = call.getMethodWrapper();
        boolean zIsOneway = methodWrapper != null ? methodWrapper.isOneway() : false;
        MethodWrapper methodWrapper2 = call.getMethodWrapper();
        return a("call", bundle, zIsOneway, methodWrapper2 != null ? methodWrapper2.isVoid() : false, call.getProtocolVersion());
    }

    @Override // com.stepos.deepbinder.client.channel.remote.a
    public final void release() {
        ContentProviderClient contentProviderClient = this.f7623c;
        if (contentProviderClient != null) {
            IPCLog.INSTANCE.i("DefaultRemoteChannel", BuildConfig.BUILD_TYPE, new Object[0]);
            contentProviderClient.close();
            this.f7623c = null;
        }
    }
}
