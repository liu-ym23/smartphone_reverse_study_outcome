package com.android.ttcjpaysdk.kmp.common.view.page.protocol;

import com.alipay.sdk.m.x.d;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.SerialName;
import kotlinx.serialization.Serializable;
import luc.f;
import nuc.b2;
import nuc.q2;
import nuc.v2;

/* JADX INFO: loaded from: classes39.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0087\b\u0018\u0000 *2\u00020\u0001:\u0002)*B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bB7\b\u0010\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f¢\u0006\u0004\b\u0007\u0010\rJ\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u00052\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001f\u001a\u00020\nHÖ\u0001J\t\u0010 \u001a\u00020\u0003HÖ\u0001J%\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00002\u0006\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0001¢\u0006\u0002\b(R\u001e\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u000e\u0010\u000f\u001a\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0012\u0010\u000f\u001a\u0004\b\u0013\u0010\u0014R&\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0015\u0010\u000f\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0018¨\u0006+"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/page/protocol/UserAgreement;", "", "contentURL", "", "defaultChoose", "", "title", "<init>", "(Ljava/lang/String;ZLjava/lang/String;)V", "seen0", "", "serializationConstructorMarker", "Lkotlinx/serialization/internal/SerializationConstructorMarker;", "(ILjava/lang/String;ZLjava/lang/String;Lkotlinx/serialization/internal/SerializationConstructorMarker;)V", "getContentURL$annotations", "()V", "getContentURL", "()Ljava/lang/String;", "getDefaultChoose$annotations", "getDefaultChoose", "()Z", "getTitle$annotations", "getTitle", d.f25925o, "(Ljava/lang/String;)V", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "toString", "write$Self", "", "self", BdpAppEventConstant.PARAMS_OUTPUT, "Lkotlinx/serialization/encoding/CompositeEncoder;", "serialDesc", "Lkotlinx/serialization/descriptors/SerialDescriptor;", "write$Self$cj_common_release", "$serializer", "Companion", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
@Serializable
public final class UserAgreement {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private final String contentURL;
    private final boolean defaultChoose;
    private String title;

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¨\u0006\u0007"}, d2 = {"Lcom/android/ttcjpaysdk/kmp/common/view/page/protocol/UserAgreement$Companion;", "", "<init>", "()V", "serializer", "Lkotlinx/serialization/KSerializer;", "Lcom/android/ttcjpaysdk/kmp/common/view/page/protocol/UserAgreement;", "cj_common_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final juc.d<UserAgreement> serializer() {
            return UserAgreement$$serializer.INSTANCE;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
    }

    public UserAgreement() {
        this(null, false, null, 7, null);
    }

    public static /* synthetic */ UserAgreement copy$default(UserAgreement r100, String r101, boolean r102, String r103, int r104, Object r105) {
        if ((r104 & 1) == 0) goto L6;
        r101 = r100.contentURL;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r102 = r100.defaultChoose;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r103 = r100.title;
    L12:
        return r100.copy(r101, r102, r103);
    }

    @SerialName("content_url")
    public static /* synthetic */ void getContentURL$annotations() {
    }

    @SerialName("default_choose")
    public static /* synthetic */ void getDefaultChoose$annotations() {
    }

    @SerialName("title")
    public static /* synthetic */ void getTitle$annotations() {
    }

    public final String component1() {
        return this.contentURL;
    }

    public final boolean component2() {
        return this.defaultChoose;
    }

    public final String component3() {
        return this.title;
    }

    public final UserAgreement copy(String r100, boolean r101, String r102) {
        return new UserAgreement(r100, r101, r102);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof UserAgreement) == true) goto L8;
        return false;
    L8:
        UserAgreement r101 = (UserAgreement) r100;
        if (Intrinsics.areEqual(this.contentURL, r101.contentURL) == true) goto L12;
        return false;
    L12:
        if (this.defaultChoose == r101.defaultChoose) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.title, r101.title) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public int hashCode() {
        String r100 = this.contentURL;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.defaultChoose == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        String r106 = this.title;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return r105 + r101;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "UserAgreement(contentURL=" + this.contentURL + ", defaultChoose=" + this.defaultChoose + ", title=" + this.title + ')';
    }

    public final String getContentURL() {
        return this.contentURL;
    }

    public final boolean getDefaultChoose() {
        return this.defaultChoose;
    }

    public final String getTitle() {
        return this.title;
    }

    public final void setTitle(String r100) {
        this.title = r100;
    }

    public UserAgreement(String r100, boolean r101, String r102) {
        this.contentURL = r100;
        this.defaultChoose = r101;
        this.title = r102;
    }

    @JvmStatic
    public static final /* synthetic */ void write$Self$cj_common_release(UserAgreement r100, muc.d r101, f r102) {
        boolean r103 = false;
        if (r101.shouldEncodeElementDefault(r102, 0) == false) goto L6;
    L4:
        boolean r104 = true;
    L9:
        if (r104 == false) goto L12;
        r101.encodeNullableSerializableElement(r102, 0, v2.f520790a, r100.contentURL);
    L12:
        if (r101.shouldEncodeElementDefault(r102, 1) == false) goto L15;
    L13:
        boolean r105 = true;
    L18:
        if (r105 == false) goto L21;
        r101.encodeBooleanElement(r102, 1, r100.defaultChoose);
    L21:
        if (r101.shouldEncodeElementDefault(r102, 2) == false) goto L24;
    L22:
        r103 = true;
    L26:
        if (r103 == false) goto L29;
        r101.encodeNullableSerializableElement(r102, 2, v2.f520790a, r100.title);
        return;
    L29:
        return;
    L24:
        if (r100.title == null) goto L26;
    L15:
        if (r100.defaultChoose == true) goto L13;
        r105 = false;
        goto L18
    L6:
        if (r100.contentURL != null) goto L4;
        r104 = false;
        goto L9
    }

    public /* synthetic */ UserAgreement(int r100, String r101, boolean r102, String r103, q2 r104) {
        if ((r100 & 0) == 0) goto L5;
        b2.b(r100, 0, UserAgreement$$serializer.INSTANCE.getDescriptor());
        throw null;
    L5:
        if ((r100 & 1) != 0) goto L7;
        this.contentURL = null;
    L9:
        if ((r100 & 2) != 0) goto L11;
        this.defaultChoose = false;
    L13:
        if ((r100 & 4) != 0) goto L15;
        this.title = null;
        return;
    L15:
        this.title = r103;
        return;
    L11:
        this.defaultChoose = r102;
        goto L13
    L7:
        this.contentURL = r101;
        goto L9
    }

    public /* synthetic */ UserAgreement(String r100, boolean r101, String r102, int r103, DefaultConstructorMarker r104) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = false;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this(r100, r101, r102);
    }
}
