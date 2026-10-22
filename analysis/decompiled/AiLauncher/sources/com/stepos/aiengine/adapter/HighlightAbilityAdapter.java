package com.stepos.aiengine.adapter;

import M5.b;
import Y8.t;
import android.os.Bundle;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.adapter.HighlightAbilityAdapter;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.aiengine.algorithm.highlight.IHighlight;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.AbilityHandle;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import com.stepos.statsapp.v3.lib.plugin.net.multipart.e;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5074l;
import p9.q;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010\u0015¨\u0006\u0016"}, d2 = {"Lcom/stepos/aiengine/adapter/HighlightAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/highlight/IHighlight;", "Lcom/stepos/core/AbilityHandle;", "handle", "<init>", "(Lcom/stepos/core/AbilityHandle;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", b.CREDENTIAL_TOKEN, "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "highlight", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", e.f30860s, "", "cancel", "(J)Z", Const.INTENT_KEY_APIKEY, "Lcom/stepos/core/AbilityHandle;", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class HighlightAbilityAdapter implements IHighlight {

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final AbilityHandle handle;

    public HighlightAbilityAdapter(AbilityHandle handle) {
        p.i(handle, "handle");
        this.handle = handle;
    }

    public static final t d(IBundleCallback iBundleCallback, String str, TextContent r10) {
        p.i(str, "<unused var>");
        p.i(r10, "r");
        Bundle bundle = new Bundle();
        bundle.putString("token_next", r10.getText());
        bundle.putBoolean("done", false);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t e(IBundleCallback iBundleCallback, String str, int i10, String msg) {
        p.i(str, "<unused var>");
        p.i(msg, "msg");
        Bundle bundle = new Bundle();
        bundle.putString("exception", msg);
        bundle.putInt("error_code", i10);
        bundle.putBoolean("done", true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    public static final t f(IBundleCallback iBundleCallback, String str) {
        p.i(str, "<unused var>");
        Bundle bundle = new Bundle();
        bundle.putBoolean("done", true);
        iBundleCallback.onCall(bundle);
        return t.f7040a;
    }

    @Override // com.stepos.aiengine.algorithm.highlight.IHighlight
    public boolean cancel(long identity) {
        return this.handle.cancel(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.highlight.IHighlight
    public int highlight(AlgorithmToken token, Bundle args, final IBundleCallback callback) {
        p.i(token, "token");
        p.i(args, "args");
        p.i(callback, "callback");
        String string = args.getString(HighlightArgsBundle.KEY_VIDEO_PATH, "");
        String string2 = args.getString(HighlightArgsBundle.KEY_PROMPT, "");
        int i10 = args.getInt(HighlightCallback.ARG_VIDEO_FILTER_FPS, 2);
        int i11 = i10 > 0 ? i10 : 2;
        int i12 = args.getInt("max_new_tokens", 256);
        int i13 = i12 > 0 ? i12 : 256;
        p.f(string2);
        TextContent textContent = new TextContent(string2);
        p.f(string);
        MixedContent mixedContent = new MixedContent(textContent, new FileContent(string, "video/mp4", null, 4, null));
        ContentParams.Builder builderPutInt = new ContentParams.Builder().putInt(HighlightCallback.ARG_VIDEO_FILTER_FPS, i11).putInt("max_new_tokens", i13);
        TaskPriorityArg.INSTANCE.applyTo(builderPutInt, args);
        mixedContent.setParams(builderPutInt.build());
        AbilityHandle.infer$default(this.handle, String.valueOf(token.getIdentity()), mixedContent, new p9.p() { // from class: O4.L
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return HighlightAbilityAdapter.d(callback, (String) obj, (TextContent) obj2);
            }
        }, new q() { // from class: O4.M
            @Override // p9.q
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return HighlightAbilityAdapter.e(callback, (String) obj, ((Integer) obj2).intValue(), (String) obj3);
            }
        }, new InterfaceC5074l() { // from class: O4.N
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return HighlightAbilityAdapter.f(callback, (String) obj);
            }
        }, (q) null, (p9.p) null, 96, (Object) null);
        return 0;
    }
}
