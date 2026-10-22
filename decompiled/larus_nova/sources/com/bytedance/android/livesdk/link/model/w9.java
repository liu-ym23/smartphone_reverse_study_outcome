package com.bytedance.android.livesdk.link.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes10.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0014\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\b\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0006\u0010\u0007\u001a\u0004\b\u0004\u0010\u0005R\u001c\u0010\r\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0007\u001a\u0004\b\n\u0010\u000bR\"\u0010\u0010\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u0007\u001a\u0004\b\u000e\u0010\u0005R\"\u0010\u0013\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0007\u001a\u0004\b\u0011\u0010\u0005R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0007\u001a\u0004\b\u0014\u0010\u000bR\u001c\u0010\u0019\u001a\u0004\u0018\u00010\t8&X§\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0007\u001a\u0004\b\u0017\u0010\u000bR\"\u0010\u001c\u001a\n\u0018\u00010\u0002j\u0004\u0018\u0001`\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u001b\u0010\u0007\u001a\u0004\b\u001a\u0010\u0005¨\u0006\u001d"}, d2 = {"Lcom/bytedance/android/livesdk/link/model/w9;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getUpgradeImg", "()Lpy/k;", "getUpgradeImg$annotations", "()V", "upgradeImg", "", "getUpradeDesc", "()Ljava/lang/String;", "getUpradeDesc$annotations", "upradeDesc", "getGradeImg", "getGradeImg$annotations", "gradeImg", "getDescBgImg", "getDescBgImg$annotations", "descBgImg", "getPreGradeDesc", "getPreGradeDesc$annotations", "preGradeDesc", "getAfterGradeDesc", "getAfterGradeDesc$annotations", "afterGradeDesc", "getBeforeGradeImg", "getBeforeGradeImg$annotations", "beforeGradeImg", "revenue-model_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface w9 extends vh7.c<w9> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "after_grade_desc")
    String getAfterGradeDesc();

    @FieldName(name = "before_upgrade_img")
    py.k getBeforeGradeImg();

    @FieldName(name = "desc_bg_img")
    py.k getDescBgImg();

    @FieldName(name = "grade_img")
    py.k getGradeImg();

    @FieldName(name = "pre_grade_desc")
    String getPreGradeDesc();

    @FieldName(name = "upgrade_img")
    py.k getUpgradeImg();

    @FieldName(name = "upgrade_desc")
    String getUpradeDesc();
}
