package com.bytedance.android.livesdk.chatroom.liverecord;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.live.core.utils.UtilityKotlinExtentionsKt;
import com.bytedance.android.livesdk.chatroom.VideoPlayDataContext;
import com.bytedance.android.livesdk.chatroom.model.i2;
import com.bytedance.android.livesdk.chatroom.model.n2;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kh1.b;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001:\u0001\u0004B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0005"}, d2 = {"Lcom/bytedance/android/livesdk/chatroom/liverecord/RecordEntranceDialog;", "Landroidx/fragment/app/DialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "livesdk_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class RecordEntranceDialog extends DialogFragment {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f106828h = 0;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f106829d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public boolean f106830e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public List<i2> f106831f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public n2 f106832g;

    public static final class a {
        @JvmStatic
        public static void a(FragmentActivity r100, List r101, n2 r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            if ((r100 instanceof FragmentActivity) == false) goto L13;
            FragmentManager r104 = r100.getSupportFragmentManager();
            RecordEntranceDialog r105 = new RecordEntranceDialog();
            r105.f106831f = r101;
            r105.f106832g = r102;
            r105.f106830e = r103;
            LandscapeRestrictionOperation r106 = LandscapeRestrictionOperation.DIALOG_FRAGMENT_SHOW_NOW;
            LandscapeRestrictionGuard.markDialogFragmentIfAllowed(r105, "RecordEntranceDialog", r106);
            if (LandscapeRestrictionGuard.shouldBlockDialogFragmentShow(r104, r105, r106) == true) goto L14;
            DialogFragmentLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L10
        L8:
            r105.showNow(r104, "RecordEntranceDialog");
            return;
        L14:
            return;
        }
    }

    static {
    }

    public RecordEntranceDialog() {
        this.f106829d = new LinkedHashMap();
        this.f106830e = true;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        ((LinkedHashMap) this.f106829d).clear();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        Dialog r101 = getDialog();
        if (r101 == null) goto L12;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L13;
        r102.setBackgroundDrawable(new ColorDrawable(0));
        if (this.f106830e == false) goto L9;
        r102.setLayout(-1, -2);
        r102.setGravity(80);
    L10:
        r102.setDimAmount(0.0f);
        return;
    L9:
        r102.setGravity(VideoPlayDataContext.PLAYING_GRAVITY);
        r102.setLayout((int) UtilityKotlinExtentionsKt.h(MediaPlayer.MEDIA_PLAYER_OPTION_SET_FORCE_RENDER_MS_GAPS), -1);
        goto L10
    L13:
        return;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        if (this.f106830e == false) goto L5;
        int r101 = R.style.ttlive_CommonBottomDialog;
    L6:
        setStyle(1, r101);
        return;
    L5:
        r101 = R.style.ttlive_CommonRightDialog;
        goto L6
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.requestWindowFeature(1);
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        Context r112 = r110.getContext();
        List<i2> r113 = this.f106831f;
        if (r113 == null) goto L31;
        Iterator<T> r114 = r113.iterator();
        int r100 = 0;
    L6:
        if (r114.hasNext() == false) goto L35;
        Object r101 = r114.next();
        int r102 = r100 + 1;
        if (r100 >= 0) goto L10;
        CollectionsKt.throwIndexOverflow();
    L10:
        i2 r103 = (i2) r101;
        View r104 = null;
        View r105 = LayoutInflater.from(r112).inflate(R.layout.ttlive_record_entrance_item, null);
        ((TextView) r105.findViewById(R.id.tv_entrance_name)).setText(r103.f106920b);
        ((ImageView) r105.findViewById(R.id.iv_entrance_icon)).setImageDrawable(r103.f106921c);
        if (this.f106830e == false) goto L15;
        LinearLayout.LayoutParams r106 = new LinearLayout.LayoutParams(0, UtilityKotlinExtentionsKt.i(115), 1.0f);
        if (r100 == 0) goto L17;
        r106.leftMargin = UtilityKotlinExtentionsKt.i(15);
    L17:
        if (this.f106829d != null) goto L19;
        this.f106829d = new LinkedHashMap();
    L19:
        Map<Integer, View> r107 = this.f106829d;
        LinkedHashMap r108 = (LinkedHashMap) r107;
        View r109 = (View) r108.get(Integer.valueOf(R.id.action_sheet_container));
        if (r109 != null) goto L26;
        View r115 = getView();
        if (r115 == null) goto L27;
        r109 = r115.findViewById(R.id.action_sheet_container);
        if (r109 == null) goto L27;
        this.f106829d.put(Integer.valueOf(R.id.action_sheet_container), r109);
    L27:
        LinearLayout r116 = (LinearLayout) r104;
        if (r116 == null) goto L30;
        r116.addView(r105, r106);
    L30:
        r105.setOnClickListener(new b(r103, this));
        r100 = r102;
    L26:
        r104 = r109;
        goto L27
    L15:
        r106 = new LinearLayout.LayoutParams(UtilityKotlinExtentionsKt.i(80), 0, 1.0f);
        goto L17
    L35:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (this.f106830e == false) goto L5;
        int r103 = R.layout.ttlive_dialog_live_record_select;
    L7:
        return r100.inflate(r103, r101, false);
    L5:
        r103 = R.layout.ttlive_dialog_live_record_select_land;
        goto L7
    }
}
