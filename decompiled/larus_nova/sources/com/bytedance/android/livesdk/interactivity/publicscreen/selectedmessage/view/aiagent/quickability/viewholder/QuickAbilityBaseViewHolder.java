package com.bytedance.android.livesdk.interactivity.publicscreen.selectedmessage.view.aiagent.quickability.viewholder;

import am2.x;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.p;
import com.bytedance.android.livesdk.log.j0;
import com.bytedance.android.livesdkapi.depend.model.live.Ability;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import ia2.b;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b&\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/publicscreen/selectedmessage/view/aiagent/quickability/viewholder/QuickAbilityBaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "interactivity-platform-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class QuickAbilityBaseViewHolder extends RecyclerView.ViewHolder {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public ia2.a f139527a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f139528b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final View f139529c;

    public static final class a implements View.OnClickListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ QuickAbilityBaseViewHolder f139530a;

        public a(QuickAbilityBaseViewHolder r100) {
            this.f139530a = r100;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r100) {
            QuickAbilityBaseViewHolder r101 = this.f139530a;
            b r102 = r101.f139528b;
            LinkedHashMap r103 = new LinkedHashMap();
            ia2.a r104 = r101.f139527a;
            if (r104 != null) goto L5;
        L7:
            String r105 = "expand#1";
        L8:
            r103.put("show_type", r105);
            r103.put("msg_show_area", "ai_assistant");
            String r106 = "";
            if (r102 == null) goto L14;
            Ability r107 = r102.f488847a;
            if (r107 == null) goto L14;
            String r108 = r107.getText();
            if (r108 == null) goto L14;
        L15:
            r103.put("hotkey_text", r108);
            if (r102 == null) goto L23;
            Ability r109 = r102.f488847a;
            if (r109 == null) goto L23;
            String r110 = String.valueOf(r109.getType());
            if (r110 == null) goto L23;
            r106 = r110;
        L23:
            r103.put("hotkey_type", r106);
            Boolean r111 = p.f133647a;
            ia2.a r112 = r101.f139527a;
            if (r112 == null) goto L28;
            WeakReference<DataCenter> r113 = r112.getDataCenter();
            if (r113 == null) goto L28;
            DataCenter r114 = r113.get();
        L29:
            p.c("hotkey", r103, r114);
            r101.V3(r102);
            return;
        L28:
            r114 = null;
        L14:
            r108 = "";
            goto L15
        L5:
            if (r104.isMessageListEmpty() != true) goto L7;
            r105 = "expand#0";
            goto L8
        }
    }

    public void U3(b r100) {
        Intrinsics.checkNotNullParameter(r100, "data");
    }

    public abstract boolean V3(b r100);

    public QuickAbilityBaseViewHolder(View r100) {
        Intrinsics.checkNotNullParameter(r100, "rootView");
        super(r100);
        this.f139529c = r100;
        r100.setOnClickListener(new a(this));
    }

    public final void T3(DataCenter r100) {
        b r101 = this.f139528b;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.f488849c == true) goto L8;
        return;
    L8:
        r101.f488849c = false;
        LinkedHashMap r102 = new LinkedHashMap();
        String r103 = r101.f488847a.getText();
        if (r103 != null) goto L11;
        r103 = "";
    L11:
        r102.put("hotkey_text", r103);
        r102.put(MonitorConstants.EXTRA_DOWNLOAD_PAGE, "live_take_detail");
        r102.put("module_name", "selected_message_layer");
        r102.put("element_name", "ai_assistant_hotkey");
        com.bytedance.android.livesdk.interactivity.api.publicscreen.utils.b.a(r102, r100);
        j0.l().sendLog("livesdk_selected_message_layer_ai_assistant_hotkey_show", r102, new Object[]{x.class, Room.class});
    }
}
