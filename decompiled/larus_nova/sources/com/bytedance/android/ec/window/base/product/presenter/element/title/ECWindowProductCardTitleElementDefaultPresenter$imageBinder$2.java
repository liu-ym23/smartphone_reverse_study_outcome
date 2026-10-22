package com.bytedance.android.ec.window.base.product.presenter.element.title;

import android.widget.TextView;
import com.bytedance.android.ec.core.utils.p1;
import com.bytedance.android.ec.model.response.ECRitTag;
import com.bytedance.mira.hook.proxy.AbsMethodDelegate;
import com.tencent.qqmusic.third.api.contract.CommonCmd;
import io.reactivex.disposables.Disposable;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0015\u0010\u0002\u001a\u00110\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062+\u0010\u0007\u001a'\u0012\u0004\u0012\u00020\u0003\u0012\f\u0012\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0018\u00010\b¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u000b2\u0017\u0010\f\u001a\u0013\u0018\u00010\u0003¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\r2\u0015\u0010\u000e\u001a\u00110\u000f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00102\u0015\u0010\u0011\u001a\u00110\u000f¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00122\u0015\u0010\u0013\u001a\u00110\u0014¢\u0006\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0015¢\u0006\u0002\b\u0016"}, d2 = {"<anonymous>", "Lio/reactivex/disposables/Disposable;", "p1", "", "Lkotlin/ParameterName;", "name", "ritTagKey", "p2", "", "", "Lcom/bytedance/android/ec/model/response/ECRitTag;", "mapRitTags", "p3", "appendString", "p4", "", "rightMargin", "p5", "lineHeight", "p6", "Landroid/widget/TextView;", CommonCmd.AIDL_PLATFORM_TYPE_TV, AbsMethodDelegate.TAG_INVOKE}, k = 3, mv = {1, 4, 3})
public final /* synthetic */ class ECWindowProductCardTitleElementDefaultPresenter$imageBinder$2 extends FunctionReferenceImpl implements Function6<String, Map<String, ? extends List<? extends ECRitTag>>, String, Float, Float, TextView, Disposable> {
    public ECWindowProductCardTitleElementDefaultPresenter$imageBinder$2(p1 r100) {
        super(6, r100, p1.class, "buildPicturesTextSpanNew", "buildPicturesTextSpanNew(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;FFLandroid/widget/TextView;)Lio/reactivex/disposables/Disposable;", 0);
    }

    @Override // kotlin.jvm.functions.Function6
    public /* bridge */ /* synthetic */ Disposable invoke(String r100, Map<String, ? extends List<? extends ECRitTag>> r101, String r110, Float r111, Float r112, TextView r113) {
        return invoke(r100, r101, r110, r111.floatValue(), r112.floatValue(), r113);
    }

    public final Disposable invoke(String r100, Map<String, ? extends List<ECRitTag>> r110, String r111, float r112, float r113, TextView r114) {
        Intrinsics.checkNotNullParameter(r100, "p1");
        Intrinsics.checkNotNullParameter(r114, "p6");
        return ((p1) this.receiver).d(r100, r110, r111, r112, r113, r114);
    }
}
