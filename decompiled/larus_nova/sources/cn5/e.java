package cn5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.subpanel.OfficeSheetDateKeyboardFragment;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class e implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeSheetDateKeyboardFragment f24518a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f24519b;

    public /* synthetic */ e(OfficeSheetDateKeyboardFragment r100, String r101) {
        this.f24518a = r100;
        this.f24519b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        OfficeSheetDateKeyboardFragment r101 = this.f24518a;
        String r102 = this.f24519b;
        List<BaseSegment> r103 = (List) r100;
        int r104 = OfficeSheetDateKeyboardFragment.f238036n;
        r101.Y90(3, r103, r101.f238035e.getFormat().getValue(), r102, r101.f238035e.getCellInfo());
    }
}
