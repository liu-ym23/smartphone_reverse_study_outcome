package com.stepos.aiengine.adapter;

import M5.b;
import Y8.t;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.GuiAgentAbilityAdapter;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.algorithm.guiagent.GuiAgentCallback;
import com.stepos.aiengine.algorithm.guiagent.IGuiAgent;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJc\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0006\u0010\u0013\u001a\u00020\u000f2\b\u0010\u0014\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0016¢\u0006\u0004\b\u0018\u0010\u0019J\u0017\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u0017H\u0016¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010#\u001a\u00020\"2\u0006\u0010!\u001a\u00020\u000fH\u0002¢\u0006\u0004\b#\u0010$R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b%\u0010&R\u0014\u0010)\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b'\u0010(¨\u0006*"}, d2 = {"Lcom/stepos/aiengine/adapter/GuiAgentAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/guiagent/IGuiAgent;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", LinkHeader.Rel.PreLoad, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "", "Landroid/os/ParcelFileDescriptor;", "imageFds", "", "imagePaths", "Landroid/graphics/Bitmap;", "imageBitmaps", "userPrompt", "systemPromptOverride", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "decide", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", e.f30860s, "", "cancel", "(J)Z", "getMaxTokenLimit", "()I", "pathOrUri", "Lcom/stepos/core/data/FileContent;", Const.INTENT_KEY_UMID, "(Ljava/lang/String;)Lcom/stepos/core/data/FileContent;", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "TAG", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class GuiAgentAbilityAdapter implements IGuiAgent {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String TAG;

    public GuiAgentAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
        this.TAG = "GuiAgentAdapter";
    }

    public static final t e(IBundleCallback iBundleCallback, String str) {
        p.i(str, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean(GuiAgentCallback.KEY_DONE, true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t f(IBundleCallback iBundleCallback, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        Bundle bundle = new Bundle();
        bundle.putString(GuiAgentCallback.KEY_TOKEN_NEXT, r10.getText());
        bundle.putBoolean(GuiAgentCallback.KEY_DONE, false);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t g(IBundleCallback iBundleCallback, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Bundle bundle = new Bundle();
        bundle.putString(GuiAgentCallback.KEY_EXCEPTION, msg);
        bundle.putInt(GuiAgentCallback.KEY_ERROR_CODE, i10);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.guiagent.IGuiAgent
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    public final FileContent d(String pathOrUri) {
        try {
            return FileContent.Companion.fromPath$default(FileContent.INSTANCE, pathOrUri, null, 2, null);
        } catch (Exception e10) {
            Log.e(this.TAG, "Failed to open file, fallback to path-only: " + pathOrUri, e10);
            return new FileContent(pathOrUri, "image/*", null, 4, null);
        }
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
        p.i(args, "args");
        return this.handle.prepare() ? AlgorithmToken.INSTANCE.submit() : AlgorithmToken.Companion.failed$default(AlgorithmToken.INSTANCE, "acquire failed", 0, 2, null);
    }

    @Override // com.stepos.aiengine.algorithm.guiagent.IGuiAgent
    public int decide(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String userPrompt, String systemPromptOverride, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(imageFds, "imageFds");
        p.i(imagePaths, "imagePaths");
        p.i(imageBitmaps, "imageBitmaps");
        p.i(userPrompt, "userPrompt");
        p.i(args, "args");
        p.i(callback, "callback");
        ArrayList arrayList = new ArrayList();
        if (systemPromptOverride != null) {
            String str = systemPromptOverride.length() > 0 ? systemPromptOverride : null;
            if (str != null) {
                arrayList.add(new TextContent(str));
            }
        }
        if (userPrompt.length() > 0) {
            arrayList.add(new TextContent(userPrompt));
        }
        Iterator<T> it = imageFds.iterator();
        while (it.hasNext()) {
            arrayList.add(new FileContent("", "image/*", (ParcelFileDescriptor) it.next()));
        }
        Iterator<T> it2 = imagePaths.iterator();
        while (it2.hasNext()) {
            arrayList.add(d((String) it2.next()));
        }
        Iterator<T> it3 = imageBitmaps.iterator();
        while (it3.hasNext()) {
            arrayList.add(ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, (Bitmap) it3.next(), 0, 0, 0, 0, 30, null));
        }
        MixedContent mixedContent = new MixedContent(arrayList);
        mixedContent.setParams(LlmRuntimeArgsBundle.INSTANCE.from(args).toContentParams());
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), mixedContent, new p9.p() { // from class: O4.I
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return GuiAgentAbilityAdapter.f(callback, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.J
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return GuiAgentAbilityAdapter.g(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.K
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return GuiAgentAbilityAdapter.e(callback, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        return 0;
    }
}
