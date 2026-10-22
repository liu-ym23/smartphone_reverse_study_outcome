package ca5;

import android.graphics.RectF;
import com.bytedance.ee.bear.onboarding.export.Direction;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectF;
import com.bytedance.ee.bear.scaleimageview.areacomment.CommentRectLayout;
import com.larus.nova.R;
import com.ss.android.lark.picker.base.widget.reporter.PickerReporterConstants;
import kotlin.jvm.internal.Intrinsics;
import uk5.e;

/* JADX INFO: loaded from: classes16.dex */
public final class c implements tk5.d<vk5.a> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f22946b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CommentRectLayout f22947a;

    public static final class a {
    }

    static {
    }

    @Override // tk5.d
    public final String getBiz() {
        return "drive";
    }

    @Override // tk5.d
    public final /* synthetic */ String getDependency() {
        return null;
    }

    @Override // tk5.d
    public final String getId() {
        return "ccm_mobile_drive_pdf_area_box_comment_intro";
    }

    public c(CommentRectLayout r100) {
        Intrinsics.checkNotNullParameter(r100, PickerReporterConstants.KEY.TARGET);
        this.f22947a = r100;
    }

    @Override // tk5.d
    public final boolean b(vk5.c r110) {
        vk5.a r111 = (vk5.a) r110;
        Intrinsics.checkNotNullParameter(r111, "ui");
        tt5.a.h("DrivePdfCommentOnboardMission", "show");
        String r100 = r111.getActivity().getResources().getString(R.string.LarkCCM_Slides_DragBorderResizeCommentArea_Desc);
        CommentRectF r101 = this.f22947a.getCurrentAreaRect();
        if (r101 != null) goto L5;
        tt5.a.k("DrivePdfCommentOnboardMission", "show: currentAreaRect is null");
        return false;
    L5:
        RectF r102 = this.f22947a.getHostWholeRectF();
        int[] r103 = new int[2];
        this.f22947a.getLocationOnScreen(r103);
        float r104 = r103[0] + r102.left;
        float r105 = r103[1] + r102.top;
        float r106 = r102.width();
        float r107 = r102.height();
        e r108 = new e(r100, new RectF((((RectF) r101).left * r106) + r104, (((RectF) r101).top * r107) + r105, r104 + (((RectF) r101).right * r106), r105 + (((RectF) r101).bottom * r107)));
        r108.f550524j = true;
        r108.f550521g = Direction.UP;
        r111.d(r111.getActivity().getWindow(), r108, new d(this));
        return true;
    }
}
