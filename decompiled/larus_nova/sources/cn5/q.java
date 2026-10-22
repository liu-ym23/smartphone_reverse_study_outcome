package cn5;

import com.bytedance.ee.bear.sheet.inputbar.at.segment.BaseSegment;
import com.bytedance.ee.bear.sheet.inputbar.subpanel.SheetDateKeyboardFragment;
import io.reactivex.functions.Consumer;
import java.util.List;

/* JADX INFO: loaded from: classes18.dex */
public final /* synthetic */ class q implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SheetDateKeyboardFragment f24533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ String f24534b;

    public /* synthetic */ q(SheetDateKeyboardFragment r100, String r101) {
        this.f24533a = r100;
        this.f24534b = r101;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        SheetDateKeyboardFragment r101 = this.f24533a;
        String r102 = this.f24534b;
        List<BaseSegment> r103 = (List) r100;
        int r104 = SheetDateKeyboardFragment.f238056n;
        r101.Y90(3, r103, r101.f238034e.getFormat().getValue(), r102, r101.f238034e.getCellInfo());
    }
}
