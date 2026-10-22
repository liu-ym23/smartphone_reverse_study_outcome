package com.stepos.aiengine.adapter;

import Q4.d;
import Q4.e;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.c;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import d5.m;
import d5.n;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJY\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/stepos/aiengine/adapter/PrivacyGuardAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/privacyguard/IPrivacyGuard;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "preload", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "", "Landroid/os/ParcelFileDescriptor;", "imageFds", "", "imagePaths", "Landroid/graphics/Bitmap;", "imageBitmaps", HighlightArgsBundle.KEY_PROMPT, "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "analyze", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", "identity", "", "cancel", "(J)Z", "getMaxTokenLimit", "()I", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class PrivacyGuardAbilityAdapter implements IPrivacyGuard {

    /* renamed from: a, reason: collision with root package name */
    public final c f3472a;

    public PrivacyGuardAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3472a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard
    public int analyze(AlgorithmToken algorithmToken, List<? extends ParcelFileDescriptor> list, String str, Bundle bundle, IBundleCallback iBundleCallback) {
        return IPrivacyGuard.DefaultImpls.analyze(this, algorithmToken, list, str, bundle, iBundleCallback);
    }

    @Override // com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard
    public boolean cancel(long identity) {
        return this.f3472a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard
    public int getMaxTokenLimit() {
        return 2048;
    }

    @Override // com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard
    public AlgorithmToken preload(Bundle args) {
        k.f(args, "args");
        return this.f3472a.f3825a.acquire() ? AlgorithmToken.INSTANCE.submit() : AlgorithmToken.Companion.failed$default(AlgorithmToken.INSTANCE, "acquire failed", 0, 2, null);
    }

    @Override // com.stepos.aiengine.algorithm.privacyguard.IPrivacyGuard
    public int analyze(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String prompt, Bundle args, IBundleCallback callback) {
        FileContent fileContent;
        k.f(token, "token");
        k.f(imageFds, "imageFds");
        k.f(imagePaths, "imagePaths");
        k.f(imageBitmaps, "imageBitmaps");
        k.f(prompt, "prompt");
        k.f(args, "args");
        k.f(callback, "callback");
        ArrayList arrayList = new ArrayList();
        if (prompt.length() > 0) {
            arrayList.add(new TextContent(prompt));
        }
        Iterator<T> it = imageFds.iterator();
        while (it.hasNext()) {
            arrayList.add(new FileContent("", "image/*", (ParcelFileDescriptor) it.next()));
        }
        for (String str : imagePaths) {
            try {
                fileContent = m.a(FileContent.Companion, str);
            } catch (Exception e) {
                Log.e("PrivacyGuardAdapter", "Failed to open file, fallback to path-only: " + str, e);
                fileContent = new FileContent(str, "image/*", null, 4, null);
            }
            arrayList.add(fileContent);
        }
        Iterator<T> it2 = imageBitmaps.iterator();
        while (it2.hasNext()) {
            arrayList.add(n.b(ImageContent.Companion, (Bitmap) it2.next(), 0, 0, 0, 0, 30));
        }
        MixedContent mixedContent = new MixedContent(arrayList);
        mixedContent.setParams(LlmRuntimeArgsBundle.INSTANCE.from(args).toContentParams());
        c.i(this.f3472a, String.valueOf(token.getIdentity()), mixedContent, new Q4.c(callback, 4), new d(callback, 4), new e(callback, 4));
        return 0;
    }
}
