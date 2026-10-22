package com.bytedance.android.livesdk.message.model;

import com.bytedance.tools.kcp.modelx.runtime.FieldName;
import com.bytedance.tools.kcp.modelx.runtime.internal.decode.FlexModelJsonAdapter;
import com.google.gson.annotations.JsonAdapter;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes11.dex */
@JsonAdapter(FlexModelJsonAdapter.class)
@Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u001a\n\u0002\u0010\u000b\n\u0002\b\u0007\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R&\u0010\n\u001a\u00060\u0002j\u0002`\u00038&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\b\u0010\t\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\"\u0010\u0011\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0010\u0010\t\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\"\u0010\u0015\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0014\u0010\t\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000fR\"\u0010\u0019\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000fR\"\u0010\u001d\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b\u001c\u0010\t\u001a\u0004\b\u001a\u0010\r\"\u0004\b\u001b\u0010\u000fR\"\u0010!\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b \u0010\t\u001a\u0004\b\u001e\u0010\r\"\u0004\b\u001f\u0010\u000fR\"\u0010%\u001a\u00020\u000b8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b$\u0010\t\u001a\u0004\b\"\u0010\r\"\u0004\b#\u0010\u000fR\"\u0010,\u001a\u00020&8&@&X§\u000e¢\u0006\u0012\u0012\u0004\b+\u0010\t\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*¨\u0006-"}, d2 = {"Lcom/bytedance/android/livesdk/message/model/a8;", "Lvh7/c;", "Lpy/k;", "Lcom/bytedance/android/live/api/IImageModelKt;", "getImg", "()Lpy/k;", "setImg", "(Lpy/k;)V", "getImg$annotations", "()V", "img", "", "getStart", "()I", "setStart", "(I)V", "getStart$annotations", "start", "getDuration", "setDuration", "getDuration$annotations", "duration", "getX", "setX", "getX$annotations", "x", "getY", "setY", "getY$annotations", "y", "getWidth", "setWidth", "getWidth$annotations", "width", "getHeight", "setHeight", "getHeight$annotations", "height", "", "getNeedCircle", "()Z", "setNeedCircle", "(Z)V", "getNeedCircle$annotations", "needCircle", "revenue-base_saasRelease"}, k = 1, mv = {1, 5, 1})
public interface a8 extends vh7.c<a8> {

    @JsonAdapter(FlexModelJsonAdapter.class)
    @Metadata(k = 3, mv = {1, 5, 1})
    public static final class a {
    }

    @Override // vh7.c
    /* synthetic */ vh7.e castTo(Class r100);

    @Override // vh7.c
    /* synthetic */ vh7.e castToOrNull(Class r100);

    @FieldName(name = "duration")
    int getDuration();

    @FieldName(name = "height")
    int getHeight();

    @FieldName(name = "img")
    py.k getImg();

    @FieldName(name = "need_circle")
    boolean getNeedCircle();

    @FieldName(name = "start")
    int getStart();

    @FieldName(name = "width")
    int getWidth();

    @FieldName(name = "x")
    int getX();

    @FieldName(name = "y")
    int getY();

    @FieldName(name = "duration#setter")
    void setDuration(int r100);

    @FieldName(name = "height#setter")
    void setHeight(int r100);

    @FieldName(name = "img#setter")
    void setImg(py.k r100);

    @FieldName(name = "need_circle#setter")
    void setNeedCircle(boolean r100);

    @FieldName(name = "start#setter")
    void setStart(int r100);

    @FieldName(name = "width#setter")
    void setWidth(int r100);

    @FieldName(name = "x#setter")
    void setX(int r100);

    @FieldName(name = "y#setter")
    void setY(int r100);
}
