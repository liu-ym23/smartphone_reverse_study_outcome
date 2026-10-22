package com.obric.capabilitykit.common.intent;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import androidx.annotation.Keep;
import com.bytedance.apm.constant.CommonKey;
import com.bytedance.apm.constant.SlardarConfigConsts;
import com.google.gson.Gson;
import com.obric.capabilitykit.common.CardView;
import com.obric.capabilitykit.common.FloatingIntentParams;
import com.obric.capabilitykit.common.RemoteCard;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.versionedparcelable.AddField;
import com.obric.versionedparcelable.VersionedParcelable;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.q;
import kotlin.text.StringsKt__StringsKt;
import kotlin.text.o;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes3.dex */
@Keep
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\"\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u0002\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 S*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001SB\u0081\u0001\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00018\u0000\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\u000b\u0012\b\b\u0002\u0010\r\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011\u0012\u0016\b\u0002\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013¢\u0006\u0002\u0010\u0014J\b\u0010G\u001a\u00020\u0004H\u0016J/\u0010H\u001a\u00020I2\b\u0010\u0005\u001a\u0004\u0018\u00010J2\n\b\u0002\u0010K\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0002\u0010MJ\b\u0010N\u001a\u00020\tH\u0016J\u0018\u0010O\u001a\u00020I2\u0006\u0010P\u001a\u00020Q2\u0006\u0010R\u001a\u00020\u0004H\u0016R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R*\u0010\u0005\u001a\u0004\u0018\u00018\u00002\b\u0010\u0019\u001a\u0004\u0018\u00018\u0000@FX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t\u0018\u00010\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010\n\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u001e\u00100\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010)\"\u0004\b1\u0010+R\u0014\u00102\u001a\u00020\u000b8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b2\u0010)R\u001a\u0010\f\u001a\u00020\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010)\"\u0004\b4\u0010+R \u00105\u001a\u0004\u0018\u0001068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b;\u0010<\"\u0004\b=\u0010>R\u001a\u0010\r\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b?\u0010<\"\u0004\b@\u0010>R&\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\bA\u0010B\u001a\u0004\bC\u0010D\"\u0004\bE\u0010F¨\u0006T"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult;", "E", "Landroid/os/Parcelable;", SlardarConfigConsts.CONFIG_RET, "", "entity", "view", "Lcom/obric/capabilitykit/common/CardView;", "details", "", "inquireFurther", "", "needToSummarize", "uiType", MemorySourceLinkType.INTENT, "Landroid/content/Intent;", "floatingIntentParams", "Lcom/obric/capabilitykit/common/FloatingIntentParams;", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "(ILjava/lang/Object;Lcom/obric/capabilitykit/common/CardView;Ljava/lang/String;ZZILandroid/content/Intent;Lcom/obric/capabilitykit/common/FloatingIntentParams;Ljava/util/concurrent/ConcurrentHashMap;)V", "getDetails", "()Ljava/lang/String;", "setDetails", "(Ljava/lang/String;)V", CommonKey.KEY_VALUE, "getEntity", "()Ljava/lang/Object;", "setEntity", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "entityWrittenToFallbackOnly", "getExt", "()Ljava/util/concurrent/ConcurrentHashMap;", "setExt", "(Ljava/util/concurrent/ConcurrentHashMap;)V", "getFloatingIntentParams", "()Lcom/obric/capabilitykit/common/FloatingIntentParams;", "setFloatingIntentParams", "(Lcom/obric/capabilitykit/common/FloatingIntentParams;)V", "getInquireFurther", "()Z", "setInquireFurther", "(Z)V", "getIntent", "()Landroid/content/Intent;", "setIntent", "(Landroid/content/Intent;)V", "isFinal", "setFinal", "isParcelableArray", "getNeedToSummarize", "setNeedToSummarize", "remoteCard", "Lcom/obric/capabilitykit/common/RemoteCard;", "getRemoteCard", "()Lcom/obric/capabilitykit/common/RemoteCard;", "setRemoteCard", "(Lcom/obric/capabilitykit/common/RemoteCard;)V", "getRet", "()I", "setRet", "(I)V", "getUiType", "setUiType", "getView$annotations", "()V", "getView", "()Lcom/obric/capabilitykit/common/CardView;", "setView", "(Lcom/obric/capabilitykit/common/CardView;)V", "describeContents", "putEntityFallback", "", "", "elementClassName", "array", "(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Boolean;)V", "toString", "writeToParcel", "parcel", "Landroid/os/Parcel;", "flags", "CREATOR", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
@VersionedParcelable
public final class IntentResult<E> implements Parcelable {

    @NotNull
    public static final b CREATOR = null;
    private static final int FLAG_INQUIRE_FURTHER = 1;
    private static final int FLAG_NEED_TO_SUMMARIZE = 2;

    @NotNull
    public static final String KEY_ENTITY_FALLBACK_JSON = "__entity_fallback_json_v1__";

    @NotNull
    public static final String KEY_ENTITY_FALLBACK_TYPE = "__entity_fallback_type_v1__";
    private static final int PARCELABLE = 0;
    private static final int PARCELABLE_ARRAY = 1;

    @NotNull
    private static final String TAG = "IntentResult";

    @NotNull
    private static final Lazy<Gson> sGson$delegate = null;

    @Nullable
    private String details;

    @Nullable
    private E entity;
    private transient boolean entityWrittenToFallbackOnly;

    @Nullable
    private ConcurrentHashMap<String, String> ext;

    @Nullable
    private FloatingIntentParams floatingIntentParams;
    private boolean inquireFurther;

    @Nullable
    private Intent intent;

    @AddField
    public boolean isFinal;
    private boolean needToSummarize;

    @AddField
    @Nullable
    public RemoteCard remoteCard;
    private int ret;
    private int uiType;

    @Nullable
    private CardView view;

    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Lcom/google/gson/Gson;", "E", "invoke"}, k = 3, mv = {1, 7, 1}, xi = 48)
    public static final class a extends Lambda implements Function0<Gson> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f11288a = null;

        static {
            f11288a = new a();
        }

        public a() {
            super(0);
        }

        @NotNull
        public final Gson a() {
            return new Gson();
        }

        @Override // kotlin.jvm.functions.Function0
        public /* bridge */ /* synthetic */ Gson invoke() {
            return a();
        }
    }

    @Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\u0014\u0010\u0013\u001a\u0006\u0012\u0002\b\u00030\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J!\u0010\u0016\u001a\u000e\u0012\n\u0012\b\u0012\u0002\b\u0003\u0018\u00010\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\u0019J \u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0014\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0018\u00010\u001dH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\bX\u0082T¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001e"}, d2 = {"Lcom/obric/capabilitykit/common/intent/IntentResult$CREATOR;", "Landroid/os/Parcelable$Creator;", "Lcom/obric/capabilitykit/common/intent/IntentResult;", "()V", "FLAG_INQUIRE_FURTHER", "", "FLAG_NEED_TO_SUMMARIZE", "KEY_ENTITY_FALLBACK_JSON", "", "KEY_ENTITY_FALLBACK_TYPE", "PARCELABLE", "PARCELABLE_ARRAY", "TAG", "sGson", "Lcom/google/gson/Gson;", "getSGson", "()Lcom/google/gson/Gson;", "sGson$delegate", "Lkotlin/Lazy;", "createFromParcel", "parcel", "Landroid/os/Parcel;", "newArray", "", "size", "(I)[Lcom/obric/capabilitykit/common/intent/IntentResult;", "resolveEntityFromFallback", "", "ext", "Ljava/util/concurrent/ConcurrentHashMap;", "capabilitykitcommon_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class b implements Parcelable.Creator<IntentResult<?>> {
        private b() {
        }

        private final Gson a() {
            return (Gson) IntentResult.access$getSGson$delegate$cp().getValue();
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentResult<?> createFromParcel(Parcel r10) {
            return a(r10);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ IntentResult<?>[] newArray(int r10) {
            return a(r10);
        }

        public /* synthetic */ b(DefaultConstructorMarker r10) {
            this();
        }

        public static final /* synthetic */ Gson a(b r10) {
            return r10.a();
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r3v18 */
        /* JADX WARN: Type inference failed for: r5v2 */
        /* JADX WARN: Type inference failed for: r5v3, types: [java.lang.Object] */
        /* JADX WARN: Type inference failed for: r5v9 */
        /* JADX WARN: Type inference failed for: r6v0, types: [android.os.Parcelable] */
        /* JADX WARN: Type inference failed for: r6v1 */
        /* JADX WARN: Type inference failed for: r6v9, types: [android.os.Parcelable[]] */
        @NotNull
        public IntentResult<?> a(@NotNull Parcel r18) {
            int r10 = r18.readInt();
            q.g(r18, "parcel");
            int r11 = r18.readInt();
            if (r18.readInt() != 1) goto L7;
            int r12 = r18.readInt();
            ?? r13 = new Parcelable[r12];
            int r14 = 0;
        L5:
            if (r14 >= r12) goto L8;
            r13[r14] = r18.readParcelable(IntentResult.class.getClassLoader());
            r14 = r14 + 1;
        L8:
            CardView r15 = (CardView) r18.readParcelable(CardView.class.getClassLoader());
            String r16 = r18.readString();
            Intent r17 = (Intent) r18.readParcelable(Intent.class.getClassLoader());
            FloatingIntentParams r19 = (FloatingIntentParams) r18.readParcelable(FloatingIntentParams.class.getClassLoader());
            int r20 = r18.readInt();
            if ((r20 & 1) == 0) goto L11;
            boolean r21 = true;
        L13:
            if ((r20 & 2) == 0) goto L15;
            boolean r22 = true;
        L16:
            int r110 = r18.readInt();
            Serializable r23 = r18.readSerializable();
            if ((r23 instanceof ConcurrentHashMap) == false) goto L20;
            ConcurrentHashMap<String, String> r24 = (ConcurrentHashMap) r23;
        L19:
            ConcurrentHashMap<String, String> r111 = r24;
            if (r13 == 0) goto L28;
            if ((r13 instanceof Object[]) == true) goto L25;
        L27:
            ?? r25 = r13;
        L29:
            IntentResult<?> r112 = r6;
            IntentResult<?> r26 = new IntentResult(r11, r25, r15, r16, r21, r22, r110, r17, r19, r111);
            int r27 = Math.min(r10, 2);
            ClassLoader r28 = b.class.getClassLoader();
            int r29 = 1;
        L30:
            if (r29 > r27) goto L42;
            if (r29 != 1) goto L36;
            Object r30 = be.a.c(r18, r28);
            if (r30 == null) goto L35;
            IntentResult<?> r31 = r112;
            r31.isFinal = ((Boolean) r30).booleanValue();
        L41:
            r29 = r29 + 1;
            r112 = r31;
            goto L30
        L35:
            r31 = r112;
            goto L41
        L36:
            r31 = r112;
            if (r29 != 2) goto L41;
            Object r32 = be.a.c(r18, r28);
            if (r32 == null) goto L41;
            r31.remoteCard = (RemoteCard) r32;
            goto L41
        L42:
            IntentResult<?> r33 = r112;
        L43:
            if (r29 > r10) goto L45;
            be.a.d(r18, r28);
            r29 = r29 + 1;
            goto L43
        L45:
            return r33;
        L25:
            if (((Object[]) r13).length != 0) goto L27;
        L28:
            r25 = a(r111);
            goto L29
        L20:
            r24 = null;
            goto L19
        L15:
            r22 = false;
            goto L16
        L11:
            r21 = false;
            goto L13
        L7:
            r13 = r18.readParcelable(IntentResult.class.getClassLoader());
            goto L8
        }

        private final Object a(ConcurrentHashMap<String, String> r10) {
            if (r10 != null) goto L5;
            return null;
        L5:
            String r11 = r10.get(IntentResult.KEY_ENTITY_FALLBACK_JSON);
            if (r11 != null) goto L8;
            return null;
        L8:
            if (r11.length() > 0) goto L11;
            r11 = null;
        L11:
            if (r11 == null) goto L39;
            String r12 = r10.get(IntentResult.KEY_ENTITY_FALLBACK_TYPE);
            if (r12 != null) goto L16;
            return null;
        L16:
            if (r12.length() > 0) goto L19;
            r12 = null;
        L19:
            if (r12 != null) goto L35;
            return null;
        L35:
            boolean r13 = o.o(r12, "[]", false, 2, null);     // Catch: Throwable -> L25
            if (r13 == false) goto L27;
            r12 = StringsKt__StringsKt.g0(r12, "[]");     // Catch: Throwable -> L25
        L27:
            Class<?> r14 = Class.forName(r12);     // Catch: Throwable -> L25
            if (r13 == false) goto L31;
            Object r15 = a().fromJson(r11, Array.newInstance(r14, 0).getClass());     // Catch: Throwable -> L25
        L38:
            return r15;
        L31:
            r15 = a().fromJson(r11, r14);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Log.w(IntentResult.TAG, "resolveEntityFromFallback failed (silent): " + th.getMessage());
            return null;
        L39:
            return null;
        }

        @NotNull
        public IntentResult<?>[] a(int r10) {
            return new IntentResult[r10];
        }
    }

    static {
        CREATOR = new b(null);
        sGson$delegate = kotlin.b.b(a.f11288a);
    }

    public IntentResult() {
        int r10 = 0;
        Object r11 = null;
        CardView r12 = null;
        String r13 = null;
        boolean r14 = false;
        boolean r15 = false;
        int r16 = 0;
        Intent r17 = null;
        FloatingIntentParams r18 = null;
        ConcurrentHashMap r19 = null;
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, 1023, null);
    }

    public static final /* synthetic */ Lazy access$getSGson$delegate$cp() {
        return sGson$delegate;
    }

    @Deprecated(message = "use [RemoteCard] instead")
    public static /* synthetic */ void getView$annotations() {
    }

    private final boolean isParcelableArray() {
        return this.entity instanceof Object[];
    }

    public static /* synthetic */ void putEntityFallback$default(IntentResult r10, Object r11, String r12, Boolean r13, int r14, Object r15) {
        if ((r14 & 2) == 0) goto L6;
        r12 = null;
    L6:
        if ((r14 & 4) == 0) goto L8;
        r13 = null;
    L8:
        r10.putEntityFallback(r11, r12, r13);
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Nullable
    public final String getDetails() {
        return this.details;
    }

    @Nullable
    public final E getEntity() {
        return this.entity;
    }

    @Nullable
    public final ConcurrentHashMap<String, String> getExt() {
        return this.ext;
    }

    @Nullable
    public final FloatingIntentParams getFloatingIntentParams() {
        return this.floatingIntentParams;
    }

    public final boolean getInquireFurther() {
        return this.inquireFurther;
    }

    @Nullable
    public final Intent getIntent() {
        return this.intent;
    }

    public final boolean getNeedToSummarize() {
        return this.needToSummarize;
    }

    @Nullable
    public final RemoteCard getRemoteCard() {
        return this.remoteCard;
    }

    public final int getRet() {
        return this.ret;
    }

    public final int getUiType() {
        return this.uiType;
    }

    @Nullable
    public final CardView getView() {
        return this.view;
    }

    public final boolean isFinal() {
        return this.isFinal;
    }

    @JvmOverloads
    public final void putEntityFallback(@Nullable Object r10) {
        putEntityFallback$default(this, r10, null, null, 6, null);
    }

    public final void setDetails(@Nullable String r10) {
        this.details = r10;
    }

    public final void setEntity(@Nullable E r10) {
        if (r10 != null) goto L4;
    L10:
        this.entity = r10;
        return;
    L4:
        if ((r10 instanceof Parcelable) == true) goto L10;
        if ((r10 instanceof Serializable) == true) goto L10;
        throw new RuntimeException("entity must be Parcelable or Serializable");
    }

    public final void setExt(@Nullable ConcurrentHashMap<String, String> r10) {
        this.ext = r10;
    }

    public final void setFinal(boolean r10) {
        this.isFinal = r10;
    }

    public final void setFloatingIntentParams(@Nullable FloatingIntentParams r10) {
        this.floatingIntentParams = r10;
    }

    public final void setInquireFurther(boolean r10) {
        this.inquireFurther = r10;
    }

    public final void setIntent(@Nullable Intent r10) {
        this.intent = r10;
    }

    public final void setNeedToSummarize(boolean r10) {
        this.needToSummarize = r10;
    }

    public final void setRemoteCard(@Nullable RemoteCard r10) {
        this.remoteCard = r10;
    }

    public final void setRet(int r10) {
        this.ret = r10;
    }

    public final void setUiType(int r10) {
        this.uiType = r10;
    }

    public final void setView(@Nullable CardView r10) {
        this.view = r10;
    }

    @NotNull
    public String toString() {
        return "IntentResult(ret=" + this.ret + ", view=" + this.view + ", details=" + this.details + ", uiType=" + this.uiType + ", ext=" + this.ext + ", inquireFurther=" + this.inquireFurther + ", needToSummarize=" + this.needToSummarize + ", entity=" + this.entity + ", intent=" + this.intent + ", floatingIntentParams=" + this.floatingIntentParams + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.os.Parcelable
    public void writeToParcel(@NotNull Parcel r10, int r11) {
        r10.writeInt(2);
        q.g(r10, "parcel");
        r10.writeInt(this.ret);
        Parcelable r12 = null;
        Parcelable[] r13 = null;
        if (this.entityWrittenToFallbackOnly == false) goto L5;
        E r14 = null;
    L6:
        int r15 = 0;
        if ((r14 instanceof Object[]) == true) goto L9;
        r10.writeInt(0);
        if ((r14 instanceof Parcelable) == false) goto L23;
        r12 = (Parcelable) r14;
    L23:
        r10.writeParcelable(r12, r11);
    L24:
        r10.writeParcelable(this.view, r11);
        r10.writeString(this.details);
        r10.writeParcelable(this.intent, r11);
        r10.writeParcelable(this.floatingIntentParams, r11);
        boolean r16 = this.inquireFurther;
        int r17 = r16;
        if (this.needToSummarize == false) goto L27;
        r17 = (r16 ? 1 : 0) | 2;
    L27:
        r10.writeInt(r17);
        r10.writeInt(this.uiType);
        r10.writeSerializable(this.ext);
        r10.writeValue(Boolean.valueOf(this.isFinal));
        r10.writeValue(this.remoteCard);
        return;
    L9:
        if ((r14 instanceof Parcelable[]) == false) goto L11;
        r13 = (Parcelable[]) r14;
    L11:
        r10.writeInt(1);
        if (r13 == null) goto L14;
        int r18 = r13.length;
    L15:
        r10.writeInt(r18);
        if (r13 == null) goto L24;
        int r19 = r13.length;
    L18:
        if (r15 >= r19) goto L24;
        r10.writeParcelable(r13[r15], r11);
        r15 = r15 + 1;
        goto L18
    L14:
        r18 = 0;
        goto L15
    L5:
        r14 = this.entity;
        goto L6
    }

    public IntentResult(int r10, @Nullable E r11, @Nullable CardView r12, @Nullable String r13, boolean r14, boolean r15, int r16, @Nullable Intent r17, @Nullable FloatingIntentParams r18, @Nullable ConcurrentHashMap<String, String> r19) {
        this.ret = r10;
        this.view = r12;
        this.details = r13;
        this.inquireFurther = r14;
        this.needToSummarize = r15;
        this.uiType = r16;
        this.intent = r17;
        this.floatingIntentParams = r18;
        this.ext = r19;
        this.isFinal = true;
        setEntity(r11);
    }

    @JvmOverloads
    public final void putEntityFallback(@Nullable Object r10, @Nullable String r11) {
        putEntityFallback$default(this, r10, r11, null, 4, null);
    }

    public /* synthetic */ IntentResult(int r10, Object r11, CardView r12, String r13, boolean r14, boolean r15, int r16, Intent r17, FloatingIntentParams r18, ConcurrentHashMap r19, int r110, DefaultConstructorMarker r111) {
        if ((r110 & 1) == 0) goto L6;
        r10 = 1;
    L6:
        if ((r110 & 2) == 0) goto L9;
        r11 = null;
    L9:
        if ((r110 & 4) == 0) goto L12;
        r12 = null;
    L12:
        if ((r110 & 8) == 0) goto L15;
        r13 = null;
    L15:
        if ((r110 & 16) == 0) goto L18;
        r14 = false;
    L18:
        if ((r110 & 32) == 0) goto L21;
        r15 = false;
    L21:
        if ((r110 & 64) == 0) goto L24;
        r16 = 1;
    L24:
        if ((r110 & 128) == 0) goto L27;
        r17 = null;
    L27:
        if ((r110 & 256) == 0) goto L30;
        r18 = null;
    L30:
        if ((r110 & 512) == 0) goto L32;
        r19 = null;
    L32:
        this(r10, r11, r12, r13, r14, r15, r16, r17, r18, r19);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public final void putEntityFallback(@Nullable Object r10, @Nullable String r11, @Nullable Boolean r12) {
        if (r10 != null) goto L5;
        Object r13 = null;
    L6:
        setEntity(r13);
        int r14 = 0;
        if (r10 != null) goto L15;
        this.entityWrittenToFallbackOnly = false;
        ConcurrentHashMap<String, String> r15 = this.ext;
        if (r15 == null) goto L11;
        String r16 = r15.remove(KEY_ENTITY_FALLBACK_JSON);
    L11:
        ConcurrentHashMap<String, String> r17 = this.ext;
        if (r17 == null) goto L56;
        String r18 = r17.remove(KEY_ENTITY_FALLBACK_TYPE);
        return;
    L56:
        return;
    L15:
        if (r12 == null) goto L17;
        boolean r19 = r12.booleanValue();
    L18:
        if (r11 != null) goto L41;
        if (r19 == true) goto L21;
    L40:
        Class<?> r20 = r10.getClass();
    L34:
        r11 = r20.getName();
        goto L41
    L21:
        if ((r10 instanceof Object[]) == false) goto L23;
        Object[] r21 = (Object[]) r10;
    L24:
        if (r21 == null) goto L35;
        int r22 = r21.length;
    L26:
        if (r14 >= r22) goto L31;
        Object r23 = r21[r14];
        if (r23 != null) goto L32;
        r14 = r14 + 1;
    L32:
        if (r23 == null) goto L35;
        r20 = r23.getClass();
        goto L34
    L31:
        r23 = null;
    L35:
        Class<?> r24 = r10.getClass().getComponentType();
        if (r24 == null) goto L38;
        r11 = r24.getName();
    L39:
        if (r11 != null) goto L41;
    L38:
        r11 = null;
        goto L39
    L23:
        r21 = null;
    L41:
        if (r19 == false) goto L52;
        r11 = r11 + "[]";
    L52:
        String r25 = b.a(CREATOR).toJson(r10);     // Catch: Throwable -> L49
        ConcurrentHashMap<String, String> r26 = this.ext;
        if (r26 != null) goto L47;
        r26 = new ConcurrentHashMap();
        this.ext = r26;
    L47:
        q.f(r25, "json");
        r26.put(KEY_ENTITY_FALLBACK_JSON, r25);
        q.f(r11, "typeTag");
        r26.put(KEY_ENTITY_FALLBACK_TYPE, r11);
        this.entityWrittenToFallbackOnly = true;
        return;
    L49:
        th = move-exception;
        Log.e(TAG, "putEntityFallback toJson failed: " + th.getMessage());
        return;
    L17:
        r19 = r10 instanceof Object[];
        goto L18
    L5:
        r13 = r10;
        goto L6
    }
}
