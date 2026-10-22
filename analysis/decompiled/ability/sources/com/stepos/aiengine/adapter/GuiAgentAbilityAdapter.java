package com.stepos.aiengine.adapter;

import B7.a;
import Q4.d;
import Q4.e;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.algorithm.guiagent.IGuiAgent;
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

@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJc\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 ¨\u0006!"}, d2 = {"Lcom/stepos/aiengine/adapter/GuiAgentAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "preload", "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "", "Landroid/os/ParcelFileDescriptor;", "imageFds", "", "imagePaths", "Landroid/graphics/Bitmap;", "imageBitmaps", "userPrompt", "systemPromptOverride", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "decide", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", "identity", "", "cancel", "(J)Z", "getMaxTokenLimit", "()I", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class GuiAgentAbilityAdapter implements IGuiAgent {

    /* renamed from: a, reason: collision with root package name */
    public final c f3463a;

    public GuiAgentAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3463a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.guiagent.IGuiAgent
    public boolean cancel(long identity) {
        return this.f3463a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.guiagent.IGuiAgent
    public int decide(AlgorithmToken algorithmToken, List<? extends ParcelFileDescriptor> list, String str, String str2, Bundle bundle, IBundleCallback iBundleCallback) {
        return IGuiAgent.DefaultImpls.decide(this, algorithmToken, list, str, str2, bundle, iBundleCallback);
    }

    @Override // com.stepos.aiengine.algorithm.guiagent.IGuiAgent
    public int getMaxTokenLimit() {
        return 2048;
    }

    @Override // com.stepos.aiengine.algorithm.guiagent.IGuiAgent
    public AlgorithmToken preload(Bundle args) {
        k.f(args, "args");
        return this.f3463a.f3825a.acquire() ? AlgorithmToken.INSTANCE.submit() : AlgorithmToken.Companion.failed$default(AlgorithmToken.INSTANCE, "acquire failed", 0, 2, null);
    }

    @Override // com.stepos.aiengine.algorithm.guiagent.IGuiAgent
    public int decide(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String userPrompt, String systemPromptOverride, Bundle args, IBundleCallback callback) {
        FileContent fileContent;
        String userPrompt2 = userPrompt;
        k.f(token, "token");
        k.f(imageFds, "imageFds");
        k.f(imagePaths, "imagePaths");
        k.f(imageBitmaps, "imageBitmaps");
        k.f(userPrompt2, "userPrompt");
        k.f(args, "args");
        k.f(callback, "callback");
        ArrayList arrayList = new ArrayList();
        if (systemPromptOverride != null && systemPromptOverride.length() != 0) {
            userPrompt2 = a.n("System:\n", systemPromptOverride, "\n\nUser:\n", userPrompt2);
        }
        if (userPrompt2.length() > 0) {
            arrayList.add(new TextContent(userPrompt2));
        }
        Iterator<T> it = imageFds.iterator();
        while (it.hasNext()) {
            arrayList.add(new FileContent("", "image/*", (ParcelFileDescriptor) it.next()));
        }
        for (String str : imagePaths) {
            try {
                fileContent = m.a(FileContent.Companion, str);
            } catch (Exception e) {
                Log.e("GuiAgentAdapter", "Failed to open file, fallback to path-only: " + str, e);
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
        c.i(this.f3463a, String.valueOf(token.getIdentity()), mixedContent, new Q4.c(callback, 2), new d(callback, 2), new e(callback, 2));
        return 0;
    }
}
