package com.stepos.aiengine.adapter;

import La.H;
import M5.b;
import Y8.t;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.ParcelFileDescriptor;
import android.util.Log;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.CompSmoothAbilityAdapter;
import com.stepos.aiengine.algorithm.chat.LlmRuntimeArgsBundle;
import com.stepos.aiengine.algorithm.compsmooth.CompSmoothCallback;
import com.stepos.aiengine.algorithm.compsmooth.ICompSmooth;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.ImageContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import com.stepos.core.error.AIEngineError;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import io.ktor.http.LinkHeader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nJY\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\b2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\f2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00110\f2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\b\u0017\u0010\u0018J\u0017\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u001a\u001a\u00020\u0019H\u0016¢\u0006\u0004\b\u001c\u0010\u001dJ\u000f\u0010\u001e\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020!2\u0006\u0010 \u001a\u00020\u000fH\u0002¢\u0006\u0004\b\"\u0010#J'\u0010&\u001a\u00020\u00162\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010'R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010)R\u0014\u0010,\u001a\u00020\u000f8\u0002X\u0082D¢\u0006\u0006\n\u0004\b*\u0010+¨\u0006-"}, d2 = {"Lcom/stepos/aiengine/adapter/CompSmoothAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/compsmooth/ICompSmooth;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", LinkHeader.Rel.PreLoad, "(Landroid/os/Bundle;)Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "", "Landroid/os/ParcelFileDescriptor;", "imageFds", "", "imagePaths", "Landroid/graphics/Bitmap;", "imageBitmaps", "userPrompt", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "analyzeComposition", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/lang/String;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", e.f30860s, "", "cancel", "(J)Z", "getMaxTokenLimit", "()I", "pathOrUri", "Lcom/stepos/core/data/FileContent;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/lang/String;)Lcom/stepos/core/data/FileContent;", "code", "message", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/aiengine/api/task/IBundleCallback;ILjava/lang/String;)I", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", Const.INTENT_KEY_PKGNAME, "Ljava/lang/String;", "TAG", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CompSmoothAbilityAdapter implements ICompSmooth {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final String TAG;

    public CompSmoothAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
        this.TAG = "CompSmoothAdapter";
    }

    public static final t e(IBundleCallback iBundleCallback, String str, int i10, String message) {
        p.i(str, "<unused var>");
        p.i(message, "message");
        Bundle bundle = new Bundle();
        bundle.putString(CompSmoothCallback.KEY_EXCEPTION, message);
        bundle.putInt(CompSmoothCallback.KEY_ERROR_CODE, -100);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t f(IBundleCallback iBundleCallback, String str, TextContent result) {
        p.i(str, "<unused var>");
        p.i(result, "result");
        Bundle bundle = new Bundle();
        bundle.putString(CompSmoothCallback.KEY_TOKEN_NEXT, result.getText());
        bundle.putBoolean(CompSmoothCallback.KEY_DONE, false);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t g(IBundleCallback iBundleCallback, String str, int i10, String message) {
        p.i(str, "<unused var>");
        p.i(message, "message");
        Bundle bundle = new Bundle();
        bundle.putString(CompSmoothCallback.KEY_EXCEPTION, message);
        bundle.putInt(CompSmoothCallback.KEY_ERROR_CODE, i10);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t h(IBundleCallback iBundleCallback, String it) {
        p.i(it, "it");
        Bundle bundle = new Bundle();
        bundle.putBoolean(CompSmoothCallback.KEY_DONE, true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.compsmooth.ICompSmooth
    public int analyzeComposition(AlgorithmToken algorithmToken, List<? extends ParcelFileDescriptor> list, String str, Bundle bundle, IBundleCallback iBundleCallback) {
        return ICompSmooth.DefaultImpls.analyzeComposition(this, algorithmToken, list, str, bundle, iBundleCallback);
    }

    @Override // com.stepos.aiengine.algorithm.compsmooth.ICompSmooth
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.compsmooth.ICompSmooth
    public int getMaxTokenLimit() {
        return 4096;
    }

    public final FileContent i(String pathOrUri) {
        try {
            return FileContent.Companion.fromPath$default(FileContent.INSTANCE, pathOrUri, null, 2, null);
        } catch (Exception e10) {
            Log.e(this.TAG, "Failed to open file, fallback to path-only: " + pathOrUri, e10);
            return new FileContent(pathOrUri, "image/*", null, 4, null);
        }
    }

    public final int j(IBundleCallback callback, int code, String message) {
        Bundle bundle = new Bundle();
        bundle.putString(CompSmoothCallback.KEY_EXCEPTION, message);
        bundle.putInt(CompSmoothCallback.KEY_ERROR_CODE, code);
        callback.onCall(bundle);
        return code;
    }

    @Override // com.stepos.aiengine.algorithm.compsmooth.ICompSmooth
    public AlgorithmToken preload(Bundle args) {
        p.i(args, "args");
        return this.handle.prepare() ? AlgorithmToken.INSTANCE.submit() : AlgorithmToken.Companion.failed$default(AlgorithmToken.INSTANCE, "acquire failed", 0, 2, null);
    }

    @Override // com.stepos.aiengine.algorithm.compsmooth.ICompSmooth
    public String analyzeComposition(AlgorithmToken algorithmToken, List<? extends ParcelFileDescriptor> list, String str, Bundle bundle) {
        return ICompSmooth.DefaultImpls.analyzeComposition(this, algorithmToken, list, str, bundle);
    }

    @Override // com.stepos.aiengine.algorithm.compsmooth.ICompSmooth
    public String analyzeComposition(AlgorithmToken algorithmToken, List<? extends ParcelFileDescriptor> list, List<String> list2, List<Bitmap> list3, String str, Bundle bundle) {
        return ICompSmooth.DefaultImpls.analyzeComposition(this, algorithmToken, list, list2, list3, str, bundle);
    }

    @Override // com.stepos.aiengine.algorithm.compsmooth.ICompSmooth
    public int analyzeComposition(AlgorithmToken token, List<? extends ParcelFileDescriptor> imageFds, List<String> imagePaths, List<Bitmap> imageBitmaps, String userPrompt, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(imageFds, "imageFds");
        p.i(imagePaths, "imagePaths");
        p.i(imageBitmaps, "imageBitmaps");
        p.i(userPrompt, "userPrompt");
        p.i(args, "args");
        p.i(callback, "callback");
        if (H.x0(userPrompt)) {
            return j(callback, AIEngineError.INVALID_ARGUMENT, "userPrompt must not be blank");
        }
        int size = imageFds.size() + imagePaths.size() + imageBitmaps.size();
        if (size != 1) {
            return j(callback, AIEngineError.INPUT_DATA_INVALID, "CompSmooth requires exactly one image, got " + size);
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new TextContent(userPrompt));
        Iterator<T> it = imageFds.iterator();
        while (it.hasNext()) {
            arrayList.add(new FileContent("", "image/*", (ParcelFileDescriptor) it.next()));
        }
        Iterator<T> it2 = imagePaths.iterator();
        while (it2.hasNext()) {
            arrayList.add(i((String) it2.next()));
        }
        Iterator<T> it3 = imageBitmaps.iterator();
        while (it3.hasNext()) {
            arrayList.add(ImageContent.Companion.fromBitmap$default(ImageContent.INSTANCE, (Bitmap) it3.next(), 0, 0, 0, 0, 30, null));
        }
        MixedContent mixedContent = new MixedContent(arrayList);
        mixedContent.setParams(LlmRuntimeArgsBundle.INSTANCE.from(args).toContentParams());
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), mixedContent, new p9.p() { // from class: O4.s
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return CompSmoothAbilityAdapter.f(callback, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.t
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CompSmoothAbilityAdapter.g(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.u
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return CompSmoothAbilityAdapter.h(callback, (String) obj);
            }
        }, new q() { // from class: O4.v
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return CompSmoothAbilityAdapter.e(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, (p9.p) null, 64, (Object) null);
        return 0;
    }
}
