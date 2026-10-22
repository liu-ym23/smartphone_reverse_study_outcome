package com.obric.capabilitykit.common.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.exifinterface.media.ExifInterface;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.obric.capabilitykit.common.CardView;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.RemoteCard;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.versionedparcelable.ParcelUtils;
import java.io.Serializable;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 M*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001MB\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010F\u001a\u00020\u0004H\u0016J\b\u0010G\u001a\u00020\tH\u0016J\u0018\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020K2\u0006\u0010L\u001a\u00020\u0004H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010 \"\u0004\b!\u0010\"R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010,\"\u0004\b-\u0010.R\u001e\u0010/\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010(\"\u0004\b0\u0010*R\u0014\u00101\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u0010(R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b2\u0010(\"\u0004\b3\u0010*R \u00104\u001a\u0004\u0018\u0001058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010;\"\u0004\b?\u0010=R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b@\u0010A\u001a\u0004\bB\u0010C\"\u0004\bD\u0010E¨\u0006N"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult;", ExifInterface.LONGITUDE_EAST, "Landroid/os/Parcelable;", SlardarConfigConsts.CONFIG_RET, "", "entity", "view", "Lcom/obric/capabilitykit/common/CardView;", "details", "", "inquireFurther", "", "needToSummarize", "uiType", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "floatingIntentParams", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(ILjava/lang/Object;Lcom/obric/capabilitykit/common/CardView;Ljava/lang/String;ZZILandroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", "value", "getEntity", "()Ljava/lang/Object;", "setEntity", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFloatingIntentParams", "()Lcom/obric/capabilitykit/common/FloatingIntentParams;", "setFloatingIntentParams", "(Lcom/obric/capabilitykit/common/FloatingIntentParams;)V", "getInquireFurther", "()Z", "setInquireFurther", "(Z)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isFinal", "setFinal", "isParcelableArray", "getNeedToSummarize", "setNeedToSummarize", "remoteCard", "Lcom/obric/capabilitykit/common/RemoteCard;", "getRemoteCard", "()Lcom/obric/capabilitykit/common/RemoteCard;", "setRemoteCard", "(Lcom/obric/capabilitykit/common/RemoteCard;)V", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "getView$annotations", "()V", "getView", "()Lcom/obric/capabilitykit/common/CardView;", "setView", "(Lcom/obric/capabilitykit/common/CardView;)V", "describeContents", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public final class IntentResult<E> implements Parcelable {
    public static final a CREATOR = null;
    private static final int FLAG_INQUIRE_FURTHER = 1;
    private static final int FLAG_NEED_TO_SUMMARIZE = 2;
    private static final int PARCELABLE = 0;
    private static final int PARCELABLE_ARRAY = 1;
    private String details;
    private E entity;
    private ConcurrentHashMap<String, String> ext;
    private FloatingIntentParams floatingIntentParams;
    private boolean inquireFurther;
    private Intent intent;
    public boolean isFinal;
    private boolean needToSummarize;
    public RemoteCard remoteCard;
    private int ret;
    private int uiType;
    private CardView view;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0014\u0010\t\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\n\u001a\u00020\u000bH\u0016J!\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "()V", "FLAG_INQUIRE_FURTHER", "", "FLAG_NEED_TO_SUMMARIZE", "PARCELABLE", "PARCELABLE_ARRAY", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", PerfConsts.PERF_DISK_FILE_SIZE, "(I)[Lcom/obric/capabilitykit/common/intent/IntentResult;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class a implements Parcelable.Creator<IntentResult<?>> {
        private a() {
        }

        public /* synthetic */ a(DefaultConstructorMarker r1) {
            this();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v0 */
        /* JADX WARN: Type inference failed for: r3v1, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r3v7, types: [android.os.Parcelable[]] */
        public IntentResult<?> a(Parcel r15) {
            int r14 = r15.readInt();
            Intrinsics.checkNotNullParameter(r15, "parcel");
            int r2 = r15.readInt();
            if (r15.readInt() != 1) goto L7;
            int r0 = r15.readInt();
            ?? r3 = new Parcelable[r0];
            int r4 = 0;
        L5:
            if (r4 >= r0) goto L8;
            r3[r4] = r15.readParcelable(IntentResult.class.getClassLoader());
            r4 = r4 + 1;
        L8:
            CardView r5 = (CardView) r15.readParcelable(CardView.class.getClassLoader());
            String r6 = r15.readString();
            Intent r9 = (Intent) r15.readParcelable(Intent.class.getClassLoader());
            FloatingIntentParams r10 = (FloatingIntentParams) r15.readParcelable(FloatingIntentParams.class.getClassLoader());
            int r1 = r15.readInt();
            if ((r1 & 1) == 0) goto L11;
            boolean r7 = true;
        L13:
            if ((r1 & 2) == 0) goto L15;
            boolean r8 = true;
        L16:
            int r11 = r15.readInt();
            Serializable r12 = r15.readSerializable();
            if ((r12 instanceof ConcurrentHashMap) == false) goto L19;
            ConcurrentHashMap r13 = (ConcurrentHashMap) r12;
        L20:
            IntentResult<?> r16 = new IntentResult(r2, r3, r5, r6, r7, r8, r11, r9, r10, r13);
            int r17 = Math.min(r14, 2);
            ClassLoader r18 = a.class.getClassLoader();
            int r19 = 1;
        L21:
            if (r19 > r17) goto L31;
            if (r19 != 1) goto L26;
            Object r20 = ParcelUtils.readValueSafely(r15, r18);
            if (r20 == null) goto L30;
            r16.isFinal = ((Boolean) r20).booleanValue();
        L30:
            r19 = r19 + 1;
            goto L21
        L26:
            if (r19 != 2) goto L30;
            Object r21 = ParcelUtils.readValueSafely(r15, r18);
            if (r21 == null) goto L30;
            r16.remoteCard = (RemoteCard) r21;
        L31:
            if (r19 > r14) goto L33;
            ParcelUtils.skipValueSafely(r15, r18);
            r19 = r19 + 1;
            goto L31
        L33:
            return r16;
        L19:
            r13 = null;
            goto L20
        L15:
            r8 = false;
            goto L16
        L11:
            r7 = false;
            goto L13
        L7:
            r3 = r15.readParcelable(IntentResult.class.getClassLoader());
            goto L8
        }

        public IntentResult<?>[] a(int r1) {
            return new IntentResult[r1];
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentResult<?> createFromParcel(Parcel r1) {
            return a(r1);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentResult<?>[] newArray(int r1) {
            return a(r1);
        }
    }

    static {
        CREATOR = new a(null);
    }

    public IntentResult() {
        this(0, null, null, null, false, false, 0, null, null, null, 1023, null);
    }

    public IntentResult(int r1, E r2, CardView r3, String r4, boolean r5, boolean r6, int r7, Intent r8, FloatingIntentParams r9, ConcurrentHashMap<String, String> r10) {
        this.ret = r1;
        this.view = r3;
        this.details = r4;
        this.inquireFurther = r5;
        this.needToSummarize = r6;
        this.uiType = r7;
        this.intent = r8;
        this.floatingIntentParams = r9;
        this.ext = r10;
        this.isFinal = true;
        setEntity(r2);
    }

    public /* synthetic */ IntentResult(int r4, Object r5, CardView r6, String r7, boolean r8, boolean r9, int r10, Intent r11, FloatingIntentParams r12, ConcurrentHashMap r13, int r14, DefaultConstructorMarker r15) {
        if ((r14 & 1) == 0) goto L6;
        r4 = 1;
    L6:
        if ((r14 & 2) == 0) goto L9;
        r5 = null;
    L9:
        if ((r14 & 4) == 0) goto L12;
        r6 = null;
    L12:
        if ((r14 & 8) == 0) goto L15;
        r7 = null;
    L15:
        if ((r14 & 16) == 0) goto L18;
        r8 = false;
    L18:
        if ((r14 & 32) == 0) goto L21;
        r9 = false;
    L21:
        if ((r14 & 64) == 0) goto L24;
        r10 = 1;
    L24:
        if ((r14 & 128) == 0) goto L27;
        r11 = null;
    L27:
        if ((r14 & 256) == 0) goto L30;
        r12 = null;
    L30:
        if ((r14 & 512) == 0) goto L32;
        r13 = null;
    L32:
        this(r4, r5, r6, r7, r8, r9, r10, r11, r12, r13);
    }

    @Deprecated(message = "use [RemoteCard] instead")
    public static /* synthetic */ void getView$annotations() {
    }

    private final boolean isParcelableArray() {
        return this.entity instanceof Object[];
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public final String getDetails() {
        return this.details;
    }

    public final E getEntity() {
        return this.entity;
    }

    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    public final FloatingIntentParams getFloatingIntentParams() {
        return this.floatingIntentParams;
    }

    public final boolean getInquireFurther() {
        return this.inquireFurther;
    }

    public final Intent getIntent() {
        return this.intent;
    }

    public final boolean getNeedToSummarize() {
        return this.needToSummarize;
    }

    public final RemoteCard getRemoteCard() {
        return this.remoteCard;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    public final CardView getView() {
        return this.view;
    }

    public final boolean isFinal() {
        return this.isFinal;
    }

    public final void setDetails(String r1) {
        this.details = r1;
    }

    public final void setEntity(E r2) {
        if (r2 != null) goto L4;
    L10:
        this.entity = r2;
        return;
    L4:
        if ((r2 instanceof Parcelable) == true) goto L10;
        if ((r2 instanceof Serializable) == true) goto L10;
        throw new RuntimeException("entity must be Parcelable or Serializable");
    }

    public final void setExt(ConcurrentHashMap<String, String> r1) {
        this.ext = r1;
    }

    public final void setFinal(boolean r1) {
        this.isFinal = r1;
    }

    public final void setFloatingIntentParams(FloatingIntentParams r1) {
        this.floatingIntentParams = r1;
    }

    public final void setInquireFurther(boolean r1) {
        this.inquireFurther = r1;
    }

    public final void setIntent(Intent r1) {
        this.intent = r1;
    }

    public final void setNeedToSummarize(boolean r1) {
        this.needToSummarize = r1;
    }

    public final void setRemoteCard(RemoteCard r1) {
        this.remoteCard = r1;
    }

    public final void setRet(int r1) {
        this.ret = r1;
    }

    public final void setUiType(int r1) {
        this.uiType = r1;
    }

    public final void setView(CardView r1) {
        this.view = r1;
    }

    public String toString() {
        return "IntentResult(ret=" + this.ret + ", view=" + this.view + ", details=" + this.details + ", uiType=" + this.uiType + ", ext=" + this.ext + ", inquireFurther=" + this.inquireFurther + ", needToSummarize=" + this.needToSummarize + ", entity=" + this.entity + ", intent=" + this.intent + ", floatingIntentParams=" + this.floatingIntentParams + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(Parcel r5, int r6) {
        r5.writeInt(2);
        Intrinsics.checkNotNullParameter(r5, "parcel");
        r5.writeInt(this.ret);
        Parcelable r1 = null;
        Parcelable[] r2 = null;
        int r3 = 0;
        if (isParcelableArray() == false) goto L16;
        E r0 = this.entity;
        if ((r0 instanceof Parcelable[]) == false) goto L7;
        r2 = (Parcelable[]) r0;
    L7:
        r5.writeInt(1);
        if (r2 == null) goto L10;
        int r4 = r2.length;
    L11:
        r5.writeInt(r4);
        if (r2 == null) goto L20;
        int r7 = r2.length;
    L14:
        if (r3 >= r7) goto L20;
        r5.writeParcelable(r2[r3], r6);
        r3 = r3 + 1;
    L20:
        r5.writeParcelable(this.view, r6);
        r5.writeString(this.details);
        r5.writeParcelable(this.intent, r6);
        r5.writeParcelable(this.floatingIntentParams, r6);
        boolean r8 = this.inquireFurther;
        int r9 = r8;
        if (this.needToSummarize == false) goto L23;
        r9 = (r8 ? 1 : 0) | 2;
    L23:
        r5.writeInt(r9);
        r5.writeInt(this.uiType);
        r5.writeSerializable(this.ext);
        r5.writeValue(Boolean.valueOf(this.isFinal));
        r5.writeValue(this.remoteCard);
        return;
    L10:
        r4 = 0;
        goto L11
    L16:
        r5.writeInt(0);
        E r10 = this.entity;
        if ((r10 instanceof Parcelable) == false) goto L19;
        r1 = (Parcelable) r10;
    L19:
        r5.writeParcelable(r1, r6);
        goto L20
    }
}
