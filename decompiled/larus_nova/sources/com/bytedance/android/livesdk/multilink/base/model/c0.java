package com.bytedance.android.livesdk.multilink.base.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\t\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u001a\u0010\u0007\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0003\u0010\u0004R\u001a\u0010\n\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0006\u001a\u0004\b\b\u0010\u0004R\u0014\u0010\u000e\u001a\u00020\u000b8&X¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001a\u0010\u0011\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0006\u001a\u0004\b\u000f\u0010\u0004R\u001a\u0010\u0012\u001a\u00020\u00028&X§\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0006\u001a\u0004\b\u0012\u0010\u0004¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/livesdk/multilink/base/model/c0;", "Lvh7/c;", "", "getUsed", "()Z", "getUsed$annotations", "()V", "used", "getLocked", "getLocked$annotations", "locked", "", "getUserId", "()Ljava/lang/String;", "userId", "getEnable", "getEnable$annotations", "enable", "isEnlarged", "isEnlarged$annotations", "multilink-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface c0 extends vh7.c<c0> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "enable")
    boolean getEnable();

    @FieldName(name = "locked")
    boolean getLocked();

    @FieldName(name = "used")
    boolean getUsed();

    String getUserId();

    @FieldName(name = "is_enlarged")
    boolean isEnlarged();
}
