package com.stepos.aiengine.adapter;

import Q4.d;
import Q4.e;
import android.os.Bundle;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.aiengine.algorithm.highlight.HighlightArgsBundle;
import com.stepos.aiengine.algorithm.highlight.HighlightCallback;
import com.stepos.aiengine.algorithm.highlight.IHighlight;
import com.stepos.aiengine.api.task.AlgorithmToken;
import com.stepos.aiengine.api.task.IBundleCallback;
import com.stepos.core.c;
import com.stepos.core.data.ContentParams;
import com.stepos.core.data.FileContent;
import com.stepos.core.data.MixedContent;
import com.stepos.core.data.TextContent;
import d5.i;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.collections.a;
import kotlin.jvm.internal.k;

@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0000\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J'\u0010\r\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0016¢\u0006\u0004\b\u0012\u0010\u0013¨\u0006\u0014"}, d2 = {"Lcom/stepos/aiengine/adapter/HighlightAbilityAdapter;", "Lcom/stepos/aiengine/algorithm/highlight/IHighlight;", "Lcom/stepos/core/c;", "handle", AppAgent.CONSTRUCT, "(Lcom/stepos/core/c;)V", "Lcom/stepos/aiengine/api/task/AlgorithmToken;", "token", "Landroid/os/Bundle;", "args", "Lcom/stepos/aiengine/api/task/IBundleCallback;", "callback", "", "highlight", "(Lcom/stepos/aiengine/api/task/AlgorithmToken;Landroid/os/Bundle;Lcom/stepos/aiengine/api/task/IBundleCallback;)I", "", "identity", "", "cancel", "(J)Z", "aiengine-api_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class HighlightAbilityAdapter implements IHighlight {

    /* renamed from: a, reason: collision with root package name */
    public final c f3464a;

    public HighlightAbilityAdapter(c handle) {
        k.f(handle, "handle");
        this.f3464a = handle;
    }

    @Override // com.stepos.aiengine.algorithm.highlight.IHighlight
    public boolean cancel(long identity) {
        return this.f3464a.a(String.valueOf(identity));
    }

    @Override // com.stepos.aiengine.algorithm.highlight.IHighlight
    public int highlight(AlgorithmToken token, Bundle args, IBundleCallback callback) {
        k.f(token, "token");
        k.f(args, "args");
        k.f(callback, "callback");
        String string = args.getString(HighlightArgsBundle.KEY_VIDEO_PATH, "");
        String string2 = args.getString(HighlightArgsBundle.KEY_PROMPT, "");
        int i = args.getInt(HighlightCallback.ARG_VIDEO_FILTER_FPS, 2);
        int i6 = i > 0 ? i : 2;
        int i10 = args.getInt(HighlightCallback.ARG_MAX_TOKENS, 256);
        if (i10 <= 0) {
            i10 = 256;
        }
        k.c(string2);
        TextContent textContent = new TextContent(string2);
        k.c(string);
        MixedContent mixedContent = new MixedContent(textContent, new FileContent(string, "video/mp4", null, 4, null));
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put(HighlightCallback.ARG_VIDEO_FILTER_FPS, new i(i6));
        linkedHashMap.put(HighlightCallback.ARG_MAX_TOKENS, new i(i10));
        mixedContent.setParams(new ContentParams(a.Y(linkedHashMap), null));
        c.i(this.f3464a, String.valueOf(token.getIdentity()), mixedContent, new Q4.c(callback, 3), new d(callback, 3), new e(callback, 3));
        return 0;
    }
}
