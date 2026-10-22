package com.stepos.aiengine.adapter;

import Q4.f;
import Q4.g;
import Q4.h;
import android.os.Bundle;
import androidx.annotation.RequiresApi;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.task.executor.e;
import com.stepos.aiengine.algorithm.imagematting.IImageMatting;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.args.MattingOptionBundle;
import com.stepos.aiengine.args.SingleImageBundle;
import com.stepos.core.c;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.base.Content;
import d5.d;
import d5.i;
import java.util.LinkedHashMap;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.b;
import kotlin.collections.a;
import kotlin.jvm.internal.Ref$ObjectRef;
import kotlin.jvm.internal.k;

@RequiresApi(26)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\f\u0010\rJ'\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/aiengine/adapter/ImageMattingAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/imagematting/IImageMatting;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "image", "", MattingOptionBundle.KEY_ROTATE_ANGLE, "cutImage", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;I)Landroid/os/Bundle;", "options", "mattingWith", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Landroid/os/Bundle;)Landroid/os/Bundle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class ImageMattingAbilityAdapter implements IImageMatting {

    /* renamed from: a, reason: collision with root package name */
    public final c f3470a;

    public ImageMattingAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3470a = handle;
    }

    public final Bundle a(String str, Content content) throws InterruptedException {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        CountDownLatch countDownLatch = new CountDownLatch(1);
        c.i(this.f3470a, str, content, new f(ref$ObjectRef, countDownLatch, 2), new g(ref$ObjectRef, countDownLatch, 5), new h(countDownLatch, 5));
        countDownLatch.await(30L, TimeUnit.SECONDS);
        ImageContent imageContent = content instanceof ImageContent ? (ImageContent) content : null;
        if (imageContent != null) {
            imageContent.releaseSharedMemory();
        }
        Bundle bundle = (Bundle) ref$ObjectRef.f4920a;
        if (bundle != null) {
            return bundle;
        }
        Bundle bundle2 = new Bundle();
        bundle2.putString("exception", "infer timeout");
        return bundle2;
    }

    @Override // com.stepos.aiengine.algorithm.imagematting.IImageMatting
    public Bundle cutImage(AlgorithmToken token, Bundle image, int rotateAngle) {
        Object objA;
        k.f(token, "token");
        k.f(image, "image");
        try {
            objA = e.A(image);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA == null) {
            Content content = (Content) objA;
            if (content instanceof ImageContent) {
                LinkedHashMap linkedHashMap = new LinkedHashMap();
                linkedHashMap.put(SingleImageBundle.KEY_ROTATE_ANGLE, new i(rotateAngle));
                ((ImageContent) content).setParams(new ContentParams(a.Y(linkedHashMap), null));
            }
            return a(String.valueOf(token.getIdentity()), content);
        }
        Bundle bundle = new Bundle();
        bundle.putString("exception", "cutImage: " + thA.getMessage());
        return bundle;
    }

    @Override // com.stepos.aiengine.algorithm.imagematting.IImageMatting
    public Bundle mattingWith(AlgorithmToken token, Bundle image, Bundle options) {
        Object objA;
        k.f(token, "token");
        k.f(image, "image");
        k.f(options, "options");
        try {
            objA = e.A(image);
        } catch (Throwable th) {
            objA = b.a(th);
        }
        Throwable thA = Result.a(objA);
        if (thA != null) {
            Bundle bundle = new Bundle();
            bundle.putString("exception", "mattingWith: " + thA.getMessage());
            return bundle;
        }
        Content content = (Content) objA;
        if (content instanceof ImageContent) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            Set<String> setKeySet = options.keySet();
            k.e(setKeySet, "keySet(...)");
            for (String str : setKeySet) {
                Object obj = options.get(str);
                if (obj instanceof Integer) {
                    k.c(str);
                    linkedHashMap.put(str, new i(((Number) obj).intValue()));
                } else if (obj instanceof Boolean) {
                    k.c(str);
                    linkedHashMap.put(str, new d(((Boolean) obj).booleanValue()));
                } else if (obj instanceof String) {
                    k.c(str);
                    String value = (String) obj;
                    k.f(value, "value");
                    linkedHashMap.put(str, new d5.k(value));
                } else if (obj instanceof Float) {
                    k.c(str);
                    linkedHashMap.put(str, new d5.g(((Number) obj).floatValue()));
                }
            }
            ((ImageContent) content).setParams(new ContentParams(a.Y(linkedHashMap), null));
        }
        return a(String.valueOf(token.getIdentity()), content);
    }
}
