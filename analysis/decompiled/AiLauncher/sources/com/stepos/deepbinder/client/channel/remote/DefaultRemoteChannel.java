package com.stepos.deepbinder.client.channel.remote;

import Z8.r;
import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.ContentProviderClient;
import android.content.ContentResolver;
import android.content.IContentProvider;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import com.stepos.deepbinder.client.DeepBinderClient;
import com.stepos.deepbinder.client.cache.ListenerCache;
import com.stepos.deepbinder.client.channel.remote.DefaultRemoteChannel;
import com.stepos.deepbinder.core.constant.Constants;
import com.stepos.deepbinder.core.entity.Call;
import com.stepos.deepbinder.core.entity.Reply;
import com.stepos.deepbinder.core.entity.wrapper.MethodWrapper;
import com.stepos.deepbinder.core.exception.IPCException;
import com.stepos.deepbinder.core.log.IPCLog;
import com.stepos.deepbinder.core.tools.IPCThreadCaller;
import com.stepos.deepbinder.core.utils.IPCUtils;
import java.lang.reflect.Field;
import kotlin.Metadata;
import kotlin.jvm.internal.p;

@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 -2\u00020\u0001:\u0001-B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J7\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u0011J\u001f\u0010\u0012\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u000f\u0010\u0015\u001a\u00020\u0014H\u0003¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0016J\u001d\u0010\u001b\u001a\u00020\u00142\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018H\u0016¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u001dH\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u000f\u0010 \u001a\u00020\u0014H\u0016¢\u0006\u0004\b \u0010\u0016R\u0014\u0010\"\u001a\u00020!8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\"\u0010#R\u0014\u0010%\u001a\u00020$8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0018\u0010(\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b(\u0010)R\u0018\u0010+\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b+\u0010,¨\u0006."}, d2 = {"Lcom/stepos/deepbinder/client/channel/remote/DefaultRemoteChannel;", "Lcom/stepos/deepbinder/client/channel/remote/BaseRemoteChannel;", "Landroid/content/ComponentName;", "componentName", "<init>", "(Landroid/content/ComponentName;)V", "", "method", "Landroid/os/Bundle;", "extras", "", "isOneway", "isVoid", "", Constants.PARAM_PROTOCOL_VERSION, "Lcom/stepos/deepbinder/core/entity/Reply;", "call", "(Ljava/lang/String;Landroid/os/Bundle;ZZI)Lcom/stepos/deepbinder/core/entity/Reply;", "internalCall", "(Ljava/lang/String;Landroid/os/Bundle;)Landroid/os/Bundle;", "LY8/t;", "releaseUnliveContentProviderClient", "()V", "internalConnect", "", "", "ids", "internalRecycle", "([Ljava/lang/Long;)V", "Lcom/stepos/deepbinder/core/entity/Call;", "internalSendCall", "(Lcom/stepos/deepbinder/core/entity/Call;)Lcom/stepos/deepbinder/core/entity/Reply;", "release", "Landroid/net/Uri;", "remoteProviderUri", "Landroid/net/Uri;", "Landroid/content/ContentResolver;", "contentResolver", "Landroid/content/ContentResolver;", "Landroid/content/ContentProviderClient;", "contentProviderClient", "Landroid/content/ContentProviderClient;", "Ljava/lang/reflect/Field;", "contentProviderField", "Ljava/lang/reflect/Field;", "Companion", "deepbinder-client_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DefaultRemoteChannel extends BaseRemoteChannel {
    private static final String TAG = "DefaultRemoteChannel";
    private ContentProviderClient contentProviderClient;
    private Field contentProviderField;
    private final ContentResolver contentResolver;
    private final Uri remoteProviderUri;

    public DefaultRemoteChannel(ComponentName componentName) {
        p.i(componentName, "componentName");
        Uri authority = IPCUtils.INSTANCE.queryComponentInternalInfoFromProvider(componentName).getAuthority();
        BaseRemoteChannel.INSTANCE.setCacheUri(authority);
        p.f(authority);
        this.remoteProviderUri = authority;
        ContentResolver contentResolver = DeepBinderClient.INSTANCE.getContext().getContentResolver();
        p.h(contentResolver, "getContentResolver(...)");
        this.contentResolver = contentResolver;
        ListenerCache.INSTANCE.getInstance().registerProviderObserver(authority);
    }

    private final Reply call(final String method, final Bundle extras, boolean isOneway, boolean isVoid, int protocolVersion) {
        try {
            extras.putInt(Constants.PARAM_PROTOCOL_VERSION, protocolVersion);
            if (isOneway && isVoid) {
                IPCThreadCaller.INSTANCE.post(false, false, new Runnable() { // from class: g7.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        DefaultRemoteChannel.call$lambda$1(this.f32703a, method, extras);
                    }
                });
                Reply replyObtain = Reply.INSTANCE.obtain();
                replyObtain.setResult(null);
                return replyObtain;
            }
            Bundle bundleInternalCall = internalCall(method, extras);
            bundleInternalCall.setClassLoader(DefaultRemoteChannel.class.getClassLoader());
            Reply reply = (Reply) bundleInternalCall.getParcelable(Constants.PARAM_REPLY);
            if (reply != null) {
                return reply;
            }
            Reply replyObtain2 = Reply.INSTANCE.obtain();
            replyObtain2.setResult(null);
            return replyObtain2;
        } catch (Throwable th) {
            throw new IPCException(9, th);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void call$lambda$1(DefaultRemoteChannel defaultRemoteChannel, String str, Bundle bundle) {
        try {
            defaultRemoteChannel.internalCall(str, bundle);
        } catch (Throwable th) {
            IPCLog.INSTANCE.w(TAG, "[call] exception: " + th, new Object[0]);
        }
    }

    private final Bundle internalCall(String method, Bundle extras) throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        Bundle bundleCall;
        releaseUnliveContentProviderClient();
        if (this.contentProviderClient == null) {
            this.contentProviderClient = this.contentResolver.acquireUnstableContentProviderClient(this.remoteProviderUri);
        }
        ContentProviderClient contentProviderClient = this.contentProviderClient;
        if (contentProviderClient == null || (bundleCall = contentProviderClient.call(method, "", extras)) == null) {
            throw new IPCException(54, "acquire UnstableContentProviderClient failed");
        }
        return bundleCall;
    }

    @SuppressLint({"DiscouragedPrivateApi"})
    private final void releaseUnliveContentProviderClient() throws IllegalAccessException, NoSuchFieldException, SecurityException, IllegalArgumentException {
        try {
            if (this.contentProviderField == null) {
                Field declaredField = ContentProviderClient.class.getDeclaredField(Constants.CONTENT_PROVIDER);
                declaredField.setAccessible(true);
                this.contentProviderField = declaredField;
            }
            Field field = this.contentProviderField;
            p.f(field);
            Object obj = field.get(this.contentProviderClient);
            IContentProvider iContentProvider = obj instanceof IContentProvider ? (IContentProvider) obj : null;
            if (iContentProvider == null || iContentProvider.asBinder().isBinderAlive()) {
                return;
            }
            release();
        } catch (Exception e10) {
            IPCLog.INSTANCE.w(TAG, "[releaseUnliveContentProviderClient] exception: " + e10, new Object[0]);
        }
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public void internalConnect() {
        call(Constants.METHOD_CONNECT, new Bundle(), true, true, 2);
    }

    @Override // com.stepos.deepbinder.core.channel.IChannel
    public void internalRecycle(Long[] ids) {
        p.i(ids, "ids");
        Bundle bundle = new Bundle();
        bundle.putInt("pid", Process.myPid());
        bundle.putLongArray(Constants.PARAM_TIMESTAMPS, r.W0(ids));
        call(Constants.METHOD_RECYCLE_REMOTE, bundle, true, true, 2);
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public Reply internalSendCall(Call call) {
        p.i(call, "call");
        Bundle bundle = new Bundle();
        bundle.putParcelable("call", call);
        MethodWrapper methodWrapper = call.getMethodWrapper();
        boolean isOneway = methodWrapper != null ? methodWrapper.getIsOneway() : false;
        MethodWrapper methodWrapper2 = call.getMethodWrapper();
        return call("call", bundle, isOneway, methodWrapper2 != null ? methodWrapper2.getIsVoid() : false, call.getProtocolVersion());
    }

    @Override // com.stepos.deepbinder.client.channel.remote.BaseRemoteChannel
    public void release() {
        ContentProviderClient contentProviderClient = this.contentProviderClient;
        if (contentProviderClient != null) {
            IPCLog.INSTANCE.i(TAG, "release", new Object[0]);
            contentProviderClient.close();
            this.contentProviderClient = null;
        }
    }
}
