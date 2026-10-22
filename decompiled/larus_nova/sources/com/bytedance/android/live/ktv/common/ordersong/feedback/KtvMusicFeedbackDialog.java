package com.bytedance.android.live.ktv.common.ordersong.feedback;

import android.app.Dialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.bytedance.android.live.core.utils.a1;
import com.bytedance.android.live.core.utils.s1;
import com.bytedance.android.live.ktv.common.ordersong.theme.KtvOrderSongThemeManager;
import com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment;
import com.bytedance.android.livesdk.utils.x0;
import com.bytedance.ies.sdk.widgets.NextLiveData;
import com.larus.nova.R;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes45.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvMusicFeedbackDialog;", "Lcom/bytedance/android/live/ktv/common/view/BaseKtvDialogFragment;", "<init>", "()V", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "FeedbackType", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class KtvMusicFeedbackDialog extends BaseKtvDialogFragment {

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public static final /* synthetic */ int f70149o = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Map<Integer, View> f70150g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public int f70151h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public String f70152i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public boolean f70153j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public p f70154k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public FeedbackType f70155l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public com.bytedance.android.live.ktv.common.ordersong.feedback.a f70156m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final b f70157n;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/bytedance/android/live/ktv/common/ordersong/feedback/KtvMusicFeedbackDialog$FeedbackType;", "", "", "thirdParty", "Ljava/lang/String;", "getThirdParty", "()Ljava/lang/String;", "", "scene", "I", "getScene", "()I", "KSONG_SONG_INFO", "PERSONAL_KARAOKE", "livektv-common_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final enum FeedbackType extends Enum<FeedbackType> {
        public static final FeedbackType KSONG_SONG_INFO = null;
        public static final FeedbackType PERSONAL_KARAOKE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ FeedbackType[] f70158a = null;
        private final int scene;
        private final String thirdParty;

        static {
            FeedbackType r100 = new FeedbackType("KSONG_SONG_INFO", 0, "ksong_song_info");
            KSONG_SONG_INFO = r100;
            FeedbackType r101 = new FeedbackType("PERSONAL_KARAOKE", 1, "personal_karaoke");
            PERSONAL_KARAOKE = r101;
            f70158a = new FeedbackType[]{r100, r101};
        }

        public static FeedbackType valueOf(String r100) {
            return (FeedbackType) r27.a.a(FeedbackType.class, r100);
        }

        public static FeedbackType[] values() {
            return (FeedbackType[]) f70158a.clone();
        }

        public final int getScene() {
            return this.scene;
        }

        public final String getThirdParty() {
            return this.thirdParty;
        }

        public FeedbackType(String r100, int r101, String r102) {
            super(r100, r101);
            this.thirdParty = r102;
            this.scene = 0;
        }
    }

    public static final class a {
        public a() {
        }

        public static /* synthetic */ KtvMusicFeedbackDialog b(FeedbackType r100, com.bytedance.android.live.ktv.common.ordersong.feedback.a r101, String r102) {
            return a(r100, r101, r102, s1.f(484.0f), Boolean.FALSE);
        }

        public static KtvMusicFeedbackDialog a(FeedbackType r100, com.bytedance.android.live.ktv.common.ordersong.feedback.a r101, String r102, int r103, Boolean r104) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r101, "predicateContent");
            Intrinsics.checkNotNullParameter(r102, "requestPage");
            KtvMusicFeedbackDialog r105 = new KtvMusicFeedbackDialog();
            r105.f70155l = r100;
            r105.f70156m = r101;
            r105.f70152i = r102;
            r105.f70151h = r103;
            if (r104 == null) goto L5;
            boolean r106 = r104.booleanValue();
        L6:
            r105.f70153j = r106;
            return r105;
        L5:
            r106 = false;
            goto L6
        }
    }

    public static final class b implements TextWatcher {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ KtvMusicFeedbackDialog f70159a;

        @Override // android.text.TextWatcher
        public final void beforeTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        @Override // android.text.TextWatcher
        public final void onTextChanged(CharSequence r100, int r101, int r102, int r103) {
        }

        public b(KtvMusicFeedbackDialog r100) {
            this.f70159a = r100;
        }

        @Override // android.text.TextWatcher
        public final void afterTextChanged(Editable r100) {
            KtvMusicFeedbackDialog r101 = this.f70159a;
            int r102 = KtvMusicFeedbackDialog.f70149o;
            r101.Y90();
        }
    }

    static {
        new a();
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final String S90() {
        return "KtvMusicFeedbackDialog";
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment
    public final int getLayoutId() {
        if (this.f70153j == false) goto L6;
        return R.layout.ttlive_dialog_ktv_music_feedback_light_adapt;
    L6:
        return KtvOrderSongThemeManager.a(400);
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onDestroyView() {
        p r100 = this.f70154k;
        if (r100 == null) goto L5;
        r100.f70176a.clear();
    L5:
        super.onDestroyView();
        ((LinkedHashMap) this.f70150g).clear();
    }

    public KtvMusicFeedbackDialog() {
        this.f70150g = new LinkedHashMap();
        this.f70151h = s1.f(484.0f);
        this.f70152i = "";
        this.f70155l = FeedbackType.KSONG_SONG_INFO;
        this.f70156m = new com.bytedance.android.live.ktv.common.ordersong.feedback.a("", "");
        this.f70157n = new b(this);
    }

    public final void Y90() {
        TextView r100 = (TextView) X90(R.id.ktv_music_feedback_submit);
        if (Z90() == true) goto L5;
    L7:
        float r101 = 0.5f;
    L8:
        r100.setAlpha(r101);
        ((TextView) X90(R.id.ktv_music_feedback_submit)).setOnClickListener(x0.a(new KtvMusicFeedbackDialog$checkSubmitEnable$1(this)));
        return;
    L5:
        if ((!((KtvFeedbackComponentView) X90(R.id.feedback_categories)).getSelectedSet().isEmpty()) == false) goto L7;
        r101 = 1.0f;
        goto L8
    }

    public final boolean Z90() {
        Editable r100 = ((EditText) X90(R.id.music_name)).getText();
        if (r100 == null) goto L5;
        String r101 = r100.toString();
    L7:
        if (r101 != null) goto L9;
    L12:
        boolean r102 = true;
    L14:
        return !r102;
    L9:
        if (r101.length() == 0) goto L12;
        r102 = false;
        goto L14
    L5:
        r101 = null;
        goto L7
    }

    public final View X90(int r100) {
        if (this.f70150g != null) goto L5;
        this.f70150g = new LinkedHashMap();
    L5:
        View r101 = this.f70150g.get(Integer.valueOf(r100));
        if (r101 != null) goto L14;
        View r102 = getView();
        if (r102 == null) goto L12;
        View r103 = r102.findViewById(r100);
        if (r103 == null) goto L12;
        this.f70150g.put(Integer.valueOf(r100), r103);
        return r103;
    L12:
        return null;
    L14:
        return r101;
    }

    @Override // com.bytedance.android.live.ktv.common.view.BaseKtvDialogFragment, com.bytedance.android.livesdk.LiveDialogFragment, androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public final void onActivityCreated(Bundle r100) {
        super.onActivityCreated(r100);
        if (this.f70151h != (-1)) goto L10;
        Dialog r101 = getDialog();
        if (r101 == null) goto L11;
        Window r102 = r101.getWindow();
        if (r102 == null) goto L12;
        WindowManager.LayoutParams r103 = r102.getAttributes();
        r103.height = -1;
        r102.setAttributes(r103);
        return;
    L12:
        return;
    L11:
        return;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.DialogFragment
    public final Dialog onCreateDialog(Bundle r100) {
        Dialog r101 = super.onCreateDialog(r100);
        Window r102 = r101.getWindow();
        if (r102 == null) goto L5;
        r102.setSoftInputMode(32);
    L5:
        return r101;
    }

    @Override // com.bytedance.android.livesdk.LiveDialogFragment, com.bytedance.android.livesdk.widget.LiveBottomSheetDialogFragment, androidx.fragment.app.Fragment
    public final void onViewCreated(View r100, Bundle r101) {
        Intrinsics.checkNotNullParameter(r100, "view");
        super.onViewCreated(r100, r101);
        ((EditText) X90(R.id.music_name)).setText(this.f70156m.f70160a);
        ((EditText) X90(R.id.music_singer)).setText(this.f70156m.f70161b);
        ((EditText) X90(R.id.music_name)).addTextChangedListener(this.f70157n);
        ((EditText) X90(R.id.music_name)).setCursorVisible(false);
        ((EditText) X90(R.id.music_singer)).setCursorVisible(false);
        ((EditText) X90(R.id.music_name)).setOnTouchListener(new j(this));
        ((EditText) X90(R.id.music_singer)).setOnTouchListener(new k(this));
        ((EditText) X90(R.id.music_name)).setOnEditorActionListener(l.f70172a);
        ((EditText) X90(R.id.music_singer)).setOnEditorActionListener(m.f70173a);
        X90(R.id.ktv_feedback_dialog_back).setOnClickListener(new n(this));
        ((KtvFeedbackComponentView) X90(R.id.feedback_categories)).setOnIssueSelectListener(new KtvMusicFeedbackDialog$initView$6(this));
        Y90();
        X90(R.id.close_mask).setOnClickListener(new o(this));
        View r102 = this.f70707f;
        ScrollView r103 = null;
        if (r102 == null) goto L5;
        LinearLayout r104 = (LinearLayout) r102.findViewById(R.id.content_ll);
    L6:
        if (r104 == null) goto L8;
        a1.k(r104, this.f70151h);
    L8:
        View r105 = this.f70707f;
        if (r105 == null) goto L12;
        r103 = (ScrollView) r105.findViewById(R.id.main_content_sv);
    L12:
        if (this.f70151h != (-1)) goto L15;
        if (r103 == null) goto L15;
        a1.k(r103, -2);
    L15:
        p r106 = new p();
        this.f70154k = r106;
        NextLiveData<List<com.bytedance.android.livesdk.rank.model.b>> r107 = r106.f70177b;
        if (r107 == null) goto L18;
        r107.observe(this, new h(this));
    L18:
        p r108 = this.f70154k;
        if (r108 == null) goto L23;
        NextLiveData<Boolean> r109 = r108.f70178c;
        if (r109 == null) goto L23;
        r109.observe(this, new i(this));
    L23:
        p r110 = this.f70154k;
        if (r110 == null) goto L26;
        r110.b(this.f70155l.getScene(), this.f70155l.getThirdParty());
    L26:
        String r111 = this.f70152i;
        pb0.a r112 = pb0.b.f528406a;
        Intrinsics.checkNotNullParameter(r111, "requestPage");
        pb0.a r113 = pb0.b.f528406a;
        if (r113 == null) goto L30;
        r113.u(r111);
        return;
    L30:
        return;
    L5:
        r104 = null;
        goto L6
    }
}
