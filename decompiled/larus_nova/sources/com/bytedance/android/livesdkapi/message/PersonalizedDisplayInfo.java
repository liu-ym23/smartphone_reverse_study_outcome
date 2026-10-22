package com.bytedance.android.livesdkapi.message;

import am3.g;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import vh7.h;

/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\b\u0007\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002R\"\u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000f\u001a\u0004\b\n\u0010\f\"\u0004\b\r\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/PersonalizedDisplayInfo;", "", "()V", "foldType", "", "getFoldType", "()Ljava/lang/Long;", "setFoldType", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "isPersonalized", "", "()Ljava/lang/Boolean;", "setPersonalized", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "Companion", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
public final class PersonalizedDisplayInfo implements h {
    public static final Companion Companion = null;
    public static final long FOLD = 0;
    public static final long SCROLL = 1;

    @SerializedName("fold_type")
    protected Long foldType;

    @SerializedName("is_personalized")
    protected Boolean isPersonalized;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/bytedance/android/livesdkapi/message/PersonalizedDisplayInfo$Companion;", "", "()V", "FOLD", "", "SCROLL", "live-model-api_saasRelease"}, k = 1, mv = {1, 5, 1})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    static {
        Companion = new Companion(null);
    }

    public PersonalizedDisplayInfo() {
        this.isPersonalized = Boolean.FALSE;
        this.foldType = 0L;
    }

    public final Long getFoldType() {
        return this.foldType;
    }

    public final Boolean isPersonalized() {
        return this.isPersonalized;
    }

    public PersonalizedDisplayInfo(g r100) {
        long r101 = r100.c();
    L3:
        int r102 = r100.f();
        if (r102 == (-1)) goto L12;
        if (r102 != 1) goto L8;
        this.isPersonalized = Boolean.valueOf(am3.h.a(r100));
        goto L3
    L8:
        if (r102 != 2) goto L9;
        this.foldType = Long.valueOf(r100.j());
        goto L3
    L9:
        am3.h.e(r100);
        goto L3
    L12:
        r100.d(r101);
        if (this.isPersonalized != null) goto L16;
        this.isPersonalized = Boolean.FALSE;
    L16:
        if (this.foldType != null) goto L28;
        this.foldType = 0L;
        return;
    }

    public final void setFoldType(Long r100) {
        this.foldType = r100;
    }

    public final void setPersonalized(Boolean r100) {
        this.isPersonalized = r100;
    }
}
