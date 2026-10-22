package com.bytedance.android.livesdk.interactivity.roomnotice.view;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import com.bytedance.android.live.core.utils.f2;
import com.bytedance.android.livesdkapi.depend.model.live.Room;
import com.bytedance.mt.protector.impl.color.ColorProtector;
import com.larus.nova.R;
import com.obric.assistant.interaction.impl.window.helpers.DialogFragmentLancet;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.Intrinsics;
import ya2.d;

/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b&\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0005B\u0007¢\u0006\u0004\b\u0003\u0010\u0004¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdk/interactivity/roomnotice/view/RoomNoticeBaseDialog;", "Landroidx/fragment/app/DialogFragment;", "Landroid/view/View$OnClickListener;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "interactivity-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public abstract class RoomNoticeBaseDialog extends DialogFragment implements View.OnClickListener {

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static Pair<Long, String> f140752f;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Map<Integer, View> f140753d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Room f140754e;

    public static final class a {
    }

    public static final class b implements ya2.c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomNoticeBaseDialog f140755a;

        @Override // ya2.c
        public final void a() {
            String r100 = rm3.c.f538539a;
            rm3.c.g(this.f140755a.getContext(), "请勿输入表情字符", 0, false, 28);
        }

        public b(RoomNoticeBaseDialog r100) {
            this.f140755a = r100;
        }
    }

    public static final class c implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RoomNoticeBaseDialog f140756a;

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
        }

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public c(RoomNoticeBaseDialog r100) {
            this.f140756a = r100;
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
            if (r100 == null) goto L29;
            boolean r104 = false;
            if (r100.length() <= d.a()) goto L6;
            int r105 = r101 + r103;
            ((Editable) r100).delete(r105 - (r100.length() - d.a()), r105);
            String r106 = rm3.c.f538539a;
            rm3.c.g(this.f140756a.getContext(), "介绍文案最多" + d.a() + 23383, 0, false, 28);
            RoomNoticeBaseDialog r107 = this.f140756a;
            int r108 = d.a();
            Pair<Long, String> r109 = RoomNoticeBaseDialog.f140752f;
            r107.W90(r108);
        L7:
            String r110 = ((EditText) this.f140756a.T90(R.id.notice_edit_view)).getText().toString();
            Intrinsics.checkNotNullParameter(r110, "content");
            int r111 = 0;
            int r112 = 0;
        L9:
            if (r111 >= r110.length()) goto L15;
            if (r110.charAt(r111) != '\n') goto L13;
            r112 = r112 + 1;
        L13:
            r111 = r111 + 1;
            goto L9
        L15:
            if (r112 < 5) goto L18;
            f2.c("换行不能超过5个", 0);
            ((Editable) r100).delete(r101, r103 + r101);
            return;
        L18:
            this.f140756a.getClass();
            Room r113 = this.f140756a.f140754e;
            if (r113 == null) goto L21;
            long r114 = r113.f162599id;
            Pair<Long, String> r115 = RoomNoticeBaseDialog.f140752f;
            Pair<Long, String> r116 = new Pair(Long.valueOf(r114), r100.toString());
            Intrinsics.checkNotNullParameter(r116, "<set-?>");
            RoomNoticeBaseDialog.f140752f = r116;
        L21:
            RoomNoticeBaseDialog r117 = this.f140756a;
            if (r100.length() <= 0) goto L24;
            r104 = true;
        L24:
            r117.V90(r104);
            return;
        L6:
            RoomNoticeBaseDialog r118 = this.f140756a;
            int r119 = r100.length();
            Pair<Long, String> r120 = RoomNoticeBaseDialog.f140752f;
            r118.W90(r119);
            goto L7
        }
    }

    public abstract String U90();

    static {
        f140752f = new Pair(0L, "");
    }

    public void S90() {
        this.f140753d.clear();
    }

    public RoomNoticeBaseDialog() {
        this.f140753d = new LinkedHashMap();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        S90();
    }

    public View T90(int r100) {
        if (this.f140753d != null) goto L5;
        this.f140753d = new LinkedHashMap();
    L5:
        View r101 = this.f140753d.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f140753d.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    public final void V90(boolean r100) {
        ((TextView) T90(R.id.notice_save)).setEnabled(r100);
        TextView r101 = (TextView) T90(R.id.notice_save);
        if (r100 == false) goto L5;
        String r102 = "#FFF04142";
    L6:
        r101.setTextColor(ColorProtector.parseColor(r102));
        return;
    L5:
        r102 = "#4CF04142";
        goto L6
    }

    public final void W90(int r100) {
        int r101 = d.f567017a;
        StringBuilder r102 = new StringBuilder();
        r102.append(r100);
        r102.append('/');
        r102.append(d.a());
        String r103 = r102.toString();
        ((TextView) T90(R.id.notice_text_length)).setText(r103);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r100) {
        super.onCreate(r100);
        setStyle(1, R.style.ttlive_common_bottom_dialog);
    }

    @Override // androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        r101.requestWindowFeature(1);
        r101.setCanceledOnTouchOutside(true);
        return r101;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ((TextView) T90(R.id.notice_cancel)).setOnClickListener(this);
        ((TextView) T90(R.id.notice_save)).setOnClickListener(this);
        boolean r102 = true;
        ((EditText) T90(R.id.notice_edit_view)).setFilters(new ya2.a[]{new ya2.a(new b(this))});
        String r103 = U90();
        ((EditText) T90(R.id.notice_edit_view)).setText(r103);
        W90(r103.length());
        if (((EditText) T90(R.id.notice_edit_view)).getText().toString().length() == 0) goto L6;
        r102 = false;
    L6:
        if (r102 == false) goto L8;
        V90(false);
    L8:
        ((EditText) T90(R.id.notice_edit_view)).addTextChangedListener(new c(this));
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r100, ViewGroup r101, Bundle r102) {
        Intrinsics.checkNotNullParameter(r100, "inflater");
        if (r102 == null) goto L11;
        dismiss();     // Catch: Exception -> L6
    L6:
        e = move-exception;
        com.bytedance.crash.d.d(e, "DIALOG_FRAGMENT_DISMISS_EXCEPTION");
        Throwable r103 = DialogFragmentLancet.sLastShowStack;
        if (r103 == null) goto L11;
        com.bytedance.crash.d.d(r103, "DIALOG_FRAGMENT_SHOW_STACK_TRACE");
    L11:
        return r100.inflate(R.layout.ttlive_dialog_room_notice, r101, false);
    }
}
