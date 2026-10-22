package bu9;

import com.larus.common.apphost.AppHost;
import com.larus.nova.R;

/* JADX INFO: loaded from: classes.dex */
public final class s {
    public s() {
    }

    public static oq9.h a() {
        AppHost.Companion r100 = AppHost.f326268a;
        String r101 = r100.getApplication().getString(R.string.larus_default_capture_general_tip_title);
        String r102 = r100.getApplication().getString(R.string.larus_default_capture_general_tip_sub_title);
        String r103 = r100.getApplication().getString(R.string.larus_default_capture_calculation_tip_title);
        String r104 = r100.getApplication().getString(R.string.larus_default_capture_calculation_tip_sub_title);
        String r105 = r100.getApplication().getString(R.string.larus_default_capture_article_tip_title);
        String r106 = r100.getApplication().getString(R.string.larus_default_capture_article_tip_sub_title);
        String r210 = r100.getApplication().getString(R.string.larus_photo_hint_flat);
        String r211 = r100.getApplication().getString(R.string.larus_photo_hint_parallel);
        String r212 = r100.getApplication().getString(R.string.larus_actionTab_checkHomework);
        String r110 = r100.getApplication().getString(R.string.larus_default_clip_toast);
        String r111 = r100.getApplication().getString(R.string.larus_default_capture_general_icon_tip);
        String r112 = r100.getApplication().getString(R.string.larus_default_capture_article_icon_tip);
        String r113 = r100.getApplication().getString(R.string.larus_default_capture_calculation_icon_tip);
        return new oq9.h(r101, r102, r103, r104, r105, r106, r110, 70, 1000, 0.05f, 5, r111, r112, r100.getApplication().getString(R.string.larus_gaokao_pad_problem_solving), r113, Boolean.FALSE, r210, r211, r212);
    }
}
