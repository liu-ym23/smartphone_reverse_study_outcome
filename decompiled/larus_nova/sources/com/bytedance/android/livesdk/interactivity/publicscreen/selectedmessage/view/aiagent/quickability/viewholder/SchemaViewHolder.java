package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder;

import android.content.Context;
import android.view.View;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.android.livesdk.schema.interfaces.IBaseLiveActionHandler;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import ia2.b;
import jc1.k;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/SchemaViewHolder;", "Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityTextViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SchemaViewHolder extends QuickAbilityTextViewHolder {
    public SchemaViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, RootDescription.ROOT_ELEMENT);
        super(r100);
    }

    @Override // com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityTextViewHolder, com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder.QuickAbilityBaseViewHolder
    public final boolean V3(b r100) {
        Context r101 = this.f139529c.getContext();
        if (r100 == null) goto L7;
        Ability r102 = r100.f488847a;
        if (r102 == null) goto L7;
        String r103 = r102.getSchema();
    L9:
        if (r103 != null) goto L11;
    L14:
        boolean r104 = true;
    L15:
        if (r104 == true) goto L20;
        if (r101 == null) goto L20;
        IBaseLiveActionHandler r105 = (IBaseLiveActionHandler) k.f(IBaseLiveActionHandler.class);
        if (r105 == null) goto L20;
        r105.handle(r101, r103);
    L20:
        return true;
    L11:
        if (r103.length() == 0) goto L14;
        r104 = false;
    L7:
        r103 = null;
        goto L9
    }
}
