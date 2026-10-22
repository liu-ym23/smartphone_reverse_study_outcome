package com.bytedance.android.live.base.model.user;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes45.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u000b\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\"\u0010\t\u001a\u00020\u00028&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0007\u0010\b\u001a\u0004\b\u0003\u0010\u0004\"\u0004\b\u0005\u0010\u0006R\"\u0010\u0010\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u000f\u0010\b\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u0014\u001a\u00020\n8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0013\u0010\b\u001a\u0004\b\u0011\u0010\f\"\u0004\b\u0012\u0010\u000eR\"\u0010\u001b\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001a\u0010\b\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R&\u0010#\u001a\u00060\u001cj\u0002`\u001d8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\"\u0010\b\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\"\u0010'\u001a\u00020\u00158&@&X§\u000e¢\u0006\u0012\u0012\u0004\b&\u0010\b\u001a\u0004\b$\u0010\u0017\"\u0004\b%\u0010\u0019¨\u0006("}, d2 = {"Lcom/bytedance/android/live/base/model/user/e;", "Lvh7/c;", "", "getStatus", "()I", "setStatus", "(I)V", "getStatus$annotations", "()V", "status", "", "getIcon", "()Ljava/lang/String;", "setIcon", "(Ljava/lang/String;)V", "getIcon$annotations", "icon", "getSchema", "setSchema", "getSchema$annotations", "schema", "", "getMysteryMan", "()Z", "setMysteryMan", "(Z)V", "getMysteryMan$annotations", "mysteryMan", "", "Lcom/bytedance/revenue/platform/api/core/UnsafeLong;", "getGradeLevel", "()J", "setGradeLevel", "(J)V", "getGradeLevel$annotations", "gradeLevel", "getHideGradeLevel", "setHideGradeLevel", "getHideGradeLevel$annotations", "hideGradeLevel", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface e extends vh7.c<e> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "grade_level")
    long getGradeLevel();

    @FieldName(name = "hide_grade_level")
    boolean getHideGradeLevel();

    @FieldName(name = "icon")
    String getIcon();

    @FieldName(name = "mystery_man")
    boolean getMysteryMan();

    @FieldName(name = "schema")
    String getSchema();

    @FieldName(name = "status")
    int getStatus();

    @FieldName(name = "grade_level#setter")
    void setGradeLevel(long r100);

    @FieldName(name = "hide_grade_level#setter")
    void setHideGradeLevel(boolean r100);

    @FieldName(name = "icon#setter")
    void setIcon(String r100);

    @FieldName(name = "mystery_man#setter")
    void setMysteryMan(boolean r100);

    @FieldName(name = "schema#setter")
    void setSchema(String r100);

    @FieldName(name = "status#setter")
    void setStatus(int r100);
}
