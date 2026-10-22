package com.obric.Intelligentcall;

import android.content.Context;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.provider.CallLog;
import com.GlobalProxyLancet;
import com.android.contacts.R;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.obric.network.request.intelligentvoice.ConversationSceneConf;
import com.obric.network.request.intelligentvoice.SoundListGetResponseDetail;
import com.obric.settings.SettingsProviderHelper;
import com.obric.utils.GlobalUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.io.CloseableKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import obric.widget.search.data.GloableSearchConfig;

/* JADX INFO: compiled from: IntelligentUtils.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u001e\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fH\u0002J\u000e\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ3\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2!\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u00020\u000e0\u0011H\u0002J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00190\u00162\u0006\u0010\u000b\u001a\u00020\fJ\"\u0010 \u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010!\u001a\u0004\u0018\u00010\u00042\b\u0010\"\u001a\u0004\u0018\u00010\u0004J\u000e\u0010#\u001a\u00020\u001b2\u0006\u0010$\u001a\u00020\u001bJ\u000e\u0010%\u001a\u00020\u001b2\u0006\u0010&\u001a\u00020\u001bJ\u0012\u0010'\u001a\u00020\b2\b\u0010(\u001a\u0004\u0018\u00010\u0004H\u0002J\u000e\u0010)\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0006\u0010\u000b\u001a\u00020\fJ\u001a\u0010+\u001a\u0004\u0018\u00010\u00042\u0006\u0010\u000b\u001a\u00020\f2\b\u0010,\u001a\u0004\u0018\u00010\u0004J(\u0010-\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010.\u001a\u00020\u00042\u0006\u0010/\u001a\u00020\u00042\b\u00100\u001a\u0004\u0018\u00010\u0004J.\u00101\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u000e\u00102\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u00162\u000e\u00103\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0016J\u000e\u00104\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u0016\u00105\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00106\u001a\u00020\u001bJ\u0016\u00107\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u00106\u001a\u00020\u001bJ\u0010\u00108\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\b8B@BX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00069"}, d2 = {"Lcom/obric/Intelligentcall/IntelligentUtils;", "", "()V", "SPEAKER_ID_DFHR", "", "SPEAKER_ID_SJXM", "TAG", "<set-?>", "", "canShowIntelligentCallNotification", "canShowCallNotification", "context", "Landroid/content/Context;", "clearConversationScene", "", "findFirstCallLog", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "showNotification", "getConversationSceneList", "", "Lcom/obric/network/request/intelligentvoice/ConversationSceneConf;", "getCustomSoundList", "Lcom/obric/network/request/intelligentvoice/SoundListGetResponseDetail;", "getFullEnableTypes", "", "getIntelligentEnableTypes", "getPhoneInterceptTypes", "getSelectedSoundName", "getSysSoundList", "getSystemDisplayName", "speakerId", "rawName", "intelligentAnswerTimeSettingsIndex2Value", "index", "intelligentAnswerTimeSettingsValue2Index", "value", "isHarassmentCall", "number", "isNetworkAvailable", "migrateConversationScenesIfNeeded", "resolveConversationKeyFromLegacyType", "type", "saveConversationScene", "conversationKey", "sceneType", "message", "saveSoundList", "systemSoundList", "customSoundList", "sendIntelligentNotification", "setIntelligentEnableTypes", GloableSearchConfig.KEY_CONFIGS, "setPhoneInterceptTypes", "showCallNotification", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class IntelligentUtils {
    public static final IntelligentUtils INSTANCE = null;
    public static final String SPEAKER_ID_DFHR = "zh_male_dongfanghaoran_moon_bigtts";
    public static final String SPEAKER_ID_SJXM = "zh_female_yuanqinvyou_wvae_bigtts";
    private static final String TAG = "IntelligentUtils";
    private static boolean canShowIntelligentCallNotification;

    /* JADX INFO: renamed from: com.obric.Intelligentcall.IntelligentUtils$findFirstCallLog$1, reason: invalid class name */
    /* JADX INFO: compiled from: IntelligentUtils.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.Intelligentcall.IntelligentUtils$findFirstCallLog$1", f = "IntelligentUtils.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Function1<Boolean, Unit> $callback;
        final /* synthetic */ Context $context;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(Context r1, Function1<? super Boolean, Unit> r2, Continuation<? super AnonymousClass1> r3) {
            this.$context = r1;
            this.$callback = r2;
            super(2, r3);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r3, Continuation<?> r4) {
            AnonymousClass1 r0 = new AnonymousClass1(this.$context, this.$callback, r4);
            r0.L$0 = r3;
            return r0;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r1, Continuation<? super Unit> r2) {
            return invoke2(r1, r2);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r1, Continuation<? super Unit> r2) {
            return ((AnonymousClass1) create(r1, r2)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r10) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L37;
            ResultKt.throwOnFailure(r10);
            CoroutineScope r11 = (CoroutineScope) this.L$0;
            Cursor r2 = this.$context.getContentResolver().query(CallLog.Calls.CONTENT_URI, new String[]{"number", "type", "date"}, null, null, "date DESC LIMIT 1");     // Catch: Exception -> L32
            Unit r3 = null;
            if (r2 == null) goto L29;
            Cursor r4 = r2;     // Catch: Exception -> L32
            Function1<Boolean, Unit> r5 = this.$callback;     // Catch: Exception -> L32
            Cursor r6 = r4;     // Catch: Throwable -> L24
            if (r6.moveToFirst() == false) goto L20;
            String r1 = r6.getString(r6.getColumnIndexOrThrow("number"));     // Catch: Throwable -> L24
            int r0 = r6.getInt(r6.getColumnIndexOrThrow("type"));     // Catch: Throwable -> L24
            boolean r7 = IntelligentUtils.access$isHarassmentCall(IntelligentUtils.INSTANCE, r1);     // Catch: Throwable -> L24
            boolean r8 = true;
            if (r0 == 3) goto L15;
            if (r7 == true) goto L15;
            boolean r9 = false;
        L16:
            if (r9 == true) goto L19;
            r8 = false;
        L19:
            r5.invoke(Boxing.boxBoolean(r8));     // Catch: Throwable -> L24
        L21:
            Unit r12 = Unit.INSTANCE;     // Catch: Throwable -> L24
            CloseableKt.closeFinally(r4, null);     // Catch: Exception -> L32
            r3 = Unit.INSTANCE;     // Catch: Exception -> L32
            goto L29
        L15:
            r9 = true;
            goto L16
        L20:
            r5.invoke(Boxing.boxBoolean(false));     // Catch: Throwable -> L24
        L24:
            th = move-exception;
            throw th;     // Catch: Throwable -> L26
        L26:
            th = move-exception;
            CloseableKt.closeFinally(r4, th);     // Catch: Exception -> L32
            throw th;     // Catch: Exception -> L32
        L29:
            if (r3 != null) goto L35;
            this.$callback.invoke(Boxing.boxBoolean(false));     // Catch: Exception -> L32
        L35:
            return Unit.INSTANCE;
        L32:
            e = move-exception;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(IntelligentUtils.TAG, "query call log error: " + e.getMessage());
            this.$callback.invoke(Boxing.boxBoolean(false));
            goto L35
        L37:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final int getFullEnableTypes() {
        return 13311;
    }

    public final int intelligentAnswerTimeSettingsIndex2Value(int r2) {
        if (r2 != 0) goto L4;
        return 0;
    L4:
        if (r2 != 1) goto L6;
        return 5;
    L6:
        if (r2 != 2) goto L8;
        return 15;
    L8:
        if (r2 != 3) goto L17;
        return 30;
    L17:
        return 5;
    }

    public final int intelligentAnswerTimeSettingsValue2Index(int r2) {
        if (r2 != 0) goto L4;
        return 0;
    L4:
        if (r2 != 5) goto L6;
        return 1;
    L6:
        if (r2 != 15) goto L8;
        return 2;
    L8:
        if (r2 != 30) goto L17;
        return 3;
    L17:
        return 1;
    }

    private IntelligentUtils() {
    }

    public static final /* synthetic */ boolean access$canShowCallNotification(IntelligentUtils r0, Context r1) {
        return r0.canShowCallNotification(r1);
    }

    public static final /* synthetic */ boolean access$isHarassmentCall(IntelligentUtils r0, String r1) {
        return r0.isHarassmentCall(r1);
    }

    public static final /* synthetic */ void access$showCallNotification(IntelligentUtils r0, Context r1) {
        r0.showCallNotification(r1);
    }

    static {
        INSTANCE = new IntelligentUtils();
        canShowIntelligentCallNotification = true;
    }

    public final String getSelectedSoundName(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        String r0 = SettingsProviderHelper.INSTANCE.getIntelligentVoiceCheckId(r6);
        if (Intrinsics.areEqual(r0, "defaultSound") == true) goto L5;
        Iterator<T> r1 = getSysSoundList(r6).iterator();
    L8:
        if (r1.hasNext() == false) goto L12;
        Object r2 = r1.next();
        if (Intrinsics.areEqual(((SoundListGetResponseDetail) r2).getSpeakerId(), r0) == false) goto L8;
    L13:
        SoundListGetResponseDetail r3 = (SoundListGetResponseDetail) r2;
        if (r3 == null) goto L19;
        String r4 = INSTANCE.getSystemDisplayName(r6, r3.getSpeakerId(), r3.getName());
        if (r4 == null) goto L19;
        return r4;
    L19:
        Iterator<T> r5 = getCustomSoundList(r6).iterator();
    L21:
        if (r5.hasNext() == false) goto L25;
        Object r7 = r5.next();
        if (Intrinsics.areEqual(((SoundListGetResponseDetail) r7).getSpeakerId(), r0) == false) goto L21;
    L26:
        SoundListGetResponseDetail r8 = (SoundListGetResponseDetail) r7;
        if (r8 != null) goto L29;
        return null;
    L29:
        return r8.getName();
    L25:
        r7 = null;
        goto L26
    L12:
        r2 = null;
        goto L13
    L5:
        return r6.getString(R.string.common_default_tone);
    }

    public final String getSystemDisplayName(Context r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 == null) goto L23;
        int r1 = r3.hashCode();
        if (r1 == (-977739836)) goto L20;
        if (r1 == (-661470386)) goto L16;
        if (r1 != 828824084) goto L23;
        if (r3.equals(SPEAKER_ID_DFHR) == false) goto L23;
        String r5 = r2.getString(R.string.intelligent_sound_panel_record_sys_dfhr);
        Intrinsics.checkNotNullExpressionValue(r5, "context.getString(R.stri…nd_panel_record_sys_dfhr)");
        return r5;
    L16:
        if (r3.equals("defaultSound") == false) goto L23;
        String r6 = r2.getString(R.string.common_default_tone);
        Intrinsics.checkNotNullExpressionValue(r6, "context.getString(R.string.common_default_tone)");
        return r6;
    L20:
        if (r3.equals(SPEAKER_ID_SJXM) == false) goto L23;
        String r7 = r2.getString(R.string.intelligent_sound_panel_record_sys_sjxm);
        Intrinsics.checkNotNullExpressionValue(r7, "context.getString(R.stri…nd_panel_record_sys_sjxm)");
        return r7;
    L23:
        if (r4 != null) goto L29;
        return "";
    L29:
        return r4;
    }

    public final List<SoundListGetResponseDetail> getSysSoundList(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r1 = SettingsProviderHelper.INSTANCE.getIntelligentVoiceSysList(r2);
        if (r1 == null) goto L7;
        Object r3 = GlobalUtils.INSTANCE.getGson().fromJson(r1, SoundListGetResponseDetail[].class);
        Intrinsics.checkNotNullExpressionValue(r3, "GlobalUtils.gson.fromJso…ponseDetail>::class.java)");
        return ArraysKt.toList((Object[]) r3);
    L7:
        return CollectionsKt.emptyList();
    }

    public final List<SoundListGetResponseDetail> getCustomSoundList(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r1 = SettingsProviderHelper.INSTANCE.getIntelligentVoiceCusList(r2);
        if (r1 == null) goto L7;
        Object r3 = GlobalUtils.INSTANCE.getGson().fromJson(r1, SoundListGetResponseDetail[].class);
        Intrinsics.checkNotNullExpressionValue(r3, "GlobalUtils.gson.fromJso…ponseDetail>::class.java)");
        return ArraysKt.toList((Object[]) r3);
    L7:
        return CollectionsKt.emptyList();
    }

    public final void saveSoundList(Context r2, List<SoundListGetResponseDetail> r3, List<SoundListGetResponseDetail> r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (r3 == null) goto L5;
        SettingsProviderHelper.INSTANCE.setIntelligentVoiceSysList(r2, GlobalUtils.INSTANCE.getGson().toJson(r3));
    L5:
        if (r4 == null) goto L8;
        SettingsProviderHelper.INSTANCE.setIntelligentVoiceCusList(r2, GlobalUtils.INSTANCE.getGson().toJson(r4));
        return;
    }

    public final void saveConversationScene(Context r4, String r5, String r6, String r7) {
        Intrinsics.checkNotNullParameter(r4, "context");
        Intrinsics.checkNotNullParameter(r5, "conversationKey");
        Intrinsics.checkNotNullParameter(r6, "sceneType");
        if (r7 != null) goto L6;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "saveConversationScene: message is null");
        return;
    L6:
        List<ConversationSceneConf> r3 = getConversationSceneList(r4);
        List r0 = CollectionsKt.toMutableList(r3);
        Iterator<T> r8 = r3.iterator();
    L8:
        if (r8.hasNext() == false) goto L12;
        Object r1 = r8.next();
        if (Intrinsics.areEqual(((ConversationSceneConf) r1).getConversationKey(), r5) == false) goto L8;
    L13:
        ConversationSceneConf r2 = (ConversationSceneConf) r1;
        if (r2 == null) goto L16;
        r2.setMessage(r7);
    L17:
        SettingsProviderHelper.INSTANCE.setIntelligentSceneList(r4, GlobalUtils.INSTANCE.getGson().toJson(r0));
        return;
    L16:
        r0.add(new ConversationSceneConf(r5, r6, r7));
        goto L17
    L12:
        r1 = null;
        goto L13
    }

    public final void clearConversationScene(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        SettingsProviderHelper.INSTANCE.setIntelligentSceneList(r2, null);
    }

    public final List<ConversationSceneConf> getConversationSceneList(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        String r1 = SettingsProviderHelper.INSTANCE.getIntelligentSceneList(r2);
        if (r1 == null) goto L7;
        Object r3 = GlobalUtils.INSTANCE.getGson().fromJson(r1, ConversationSceneConf[].class);
        Intrinsics.checkNotNullExpressionValue(r3, "GlobalUtils.gson.fromJso…onSceneConf>::class.java)");
        return ArraysKt.toList((Object[]) r3);
    L7:
        return CollectionsKt.emptyList();
    }

    public final String resolveConversationKeyFromLegacyType(Context r3, String r4) {
        Intrinsics.checkNotNullParameter(r3, "context");
        if (r4 != null) goto L5;
        return null;
    L5:
        String[] r0 = r3.getResources().getStringArray(R.array.intelligent_scene_legacy_express_types);
        Intrinsics.checkNotNullExpressionValue(r0, "context.resources.getStr…y_express_types\n        )");
        Set r1 = ArraysKt.toSet(r0);
        String[] r5 = r3.getResources().getStringArray(R.array.intelligent_scene_legacy_taxi_types);
        Intrinsics.checkNotNullExpressionValue(r5, "context.resources.getStr…gacy_taxi_types\n        )");
        Set r6 = ArraysKt.toSet(r5);
        if (r1.contains(r4) == false) goto L9;
        return MarkInfoUtil.MARK_TYPE_EXPRESS;
    L9:
        if (r6.contains(r4) == false) goto L13;
        return MarkInfoUtil.MARK_TYPE_TAXI;
    L13:
        return null;
    }

    public final List<ConversationSceneConf> migrateConversationScenesIfNeeded(Context r13) {
        Intrinsics.checkNotNullParameter(r13, "context");
        List<ConversationSceneConf> r12 = getConversationSceneList(r13);
        if (r12.isEmpty() == true) goto L5;
        ArrayList r0 = new ArrayList();
        LinkedHashMap r1 = new LinkedHashMap();
        Iterator<T> r14 = r12.iterator();
        boolean r3 = false;
    L8:
        if (r14.hasNext() == false) goto L36;
        ConversationSceneConf r5 = (ConversationSceneConf) r14.next();
        String r4 = r5.getConversationKey();
        boolean r11 = true;
        if (r4 != null) goto L12;
    L15:
        boolean r6 = true;
    L16:
        if (r6 == true) goto L18;
        String r7 = r5.getConversationKey();
    L20:
        if (Intrinsics.areEqual(r5.getConversationKey(), r7) == true) goto L22;
        r5 = ConversationSceneConf.copy$default(r5, r7, null, null, 6, null);
        r3 = true;
    L22:
        String r8 = r7;
        if (r8 != null) goto L25;
    L28:
        boolean r9 = true;
    L29:
        if (r9 == true) goto L30;
        if (r1.containsKey(r7) == true) goto L35;
        r11 = r3;
    L35:
        r1.put(r7, r5);
        r3 = r11;
        goto L8
    L30:
        r0.add(r5);
        goto L8
    L25:
        if (r8.length() == 0) goto L28;
        r9 = false;
        goto L29
    L18:
        r7 = INSTANCE.resolveConversationKeyFromLegacyType(r13, r5.getConversationType());
        goto L20
    L12:
        if (r4.length() == 0) goto L15;
        r6 = false;
        goto L16
    L36:
        Collection r15 = r1.values();
        Intrinsics.checkNotNullExpressionValue(r15, "deduplicatedScenes.values");
        List<ConversationSceneConf> r16 = CollectionsKt.plus(r0, r15);
        if (r3 == false) goto L39;
        SettingsProviderHelper.INSTANCE.setIntelligentSceneList(r13, GlobalUtils.INSTANCE.getGson().toJson(r16));
    L39:
        return r16;
    L5:
        return CollectionsKt.emptyList();
    }

    public final boolean isNetworkAvailable(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Object r1 = r2.getSystemService("connectivity");
        NetworkCapabilities r0 = null;
        if ((r1 instanceof ConnectivityManager) == false) goto L5;
        ConnectivityManager r3 = (ConnectivityManager) r1;
    L6:
        if (r3 == null) goto L8;
        Network r4 = r3.getActiveNetwork();
    L9:
        if (r3 == null) goto L12;
        r0 = r3.getNetworkCapabilities(r4);
    L12:
        if (r0 != null) goto L14;
        return false;
    L14:
        if (r0.hasCapability(12) == true) goto L16;
        return false;
    L16:
        return true;
    L8:
        r4 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    public final int getIntelligentEnableTypes(Context r6) {
        Intrinsics.checkNotNullParameter(r6, "context");
        Integer r0 = SettingsProviderHelper.INSTANCE.getIntelligentCallEnableTypes(r6);
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getIntelligentEnableTypes: enableTypes=" + r0);
        if (r0 != null) goto L5;
        String r1 = SettingsProviderHelper.INSTANCE.getIntelligentTypeList(r6);
        if (r1 == null) goto L9;
        Object r2 = GlobalUtils.INSTANCE.getGson().fromJson(r1, Integer[].class);
        Intrinsics.checkNotNullExpressionValue(r2, "GlobalUtils.gson.fromJso…, Array<Int>::class.java)");
        List r3 = ArraysKt.toList((Object[]) r2);
    L10:
        StringBuilder r4 = new StringBuilder("getIntelligentEnableTypes: legacy typeList size=");
        if (r3 == null) goto L13;
        Integer r5 = Integer.valueOf(r3.size());
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, r4.append(r5).toString());
        SettingsProviderHelper.INSTANCE.setIntelligentTypeList(r6, null);
        List r7 = r3;
        int r8 = 0;
        if (r7 != null) goto L17;
    L20:
        boolean r9 = true;
    L21:
        if (r9 == true) goto L40;
        Iterator r10 = r3.iterator();
    L24:
        if (r10.hasNext() == false) goto L39;
        switch(((Number) r10.next()).intValue()) {
            case -2: goto L36;
            case -1: goto L35;
            case 0: goto L24;
            case 1: goto L34;
            case 2: goto L33;
            case 3: goto L32;
            case 4: goto L31;
            case 5: goto L30;
            case 6: goto L29;
            case 7: goto L24;
            case 8: goto L28;
            default: goto L24;
        };
    L28:
        int r11 = r8 | 64;
    L38:
        r8 = r11;
        goto L24
    L29:
        r11 = r8 | 8;
        goto L38
    L30:
        r11 = r8 | 4;
        goto L38
    L31:
        r11 = r8 | 1;
        goto L38
    L32:
        r11 = r8 | 128;
        goto L38
    L33:
        r11 = r8 | 256;
        goto L38
    L34:
        r11 = r8 | 2;
        goto L38
    L35:
        int r12 = 134217728;
    L37:
        r11 = r12 | r8;
        goto L38
    L36:
        r12 = 268435456;
        goto L37
    L39:
        int r13 = ((((r8 | 16) | 32) | 512) | 4096) | 8192;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getIntelligentEnableTypes: migrate legacy, defaultTypes=" + r13);
        setIntelligentEnableTypes(r6, r13);
        return r13;
    L40:
        int r14 = getFullEnableTypes();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getIntelligentEnableTypes: first init, fullEnableTypes=" + r14);
        setIntelligentEnableTypes(r6, r14);
        return r14;
    L17:
        if (r7.isEmpty() == true) goto L20;
        r9 = false;
        goto L21
    L13:
        r5 = null;
        goto L14
    L9:
        r3 = null;
        goto L10
    L5:
        return r0.intValue();
    }

    public final void setIntelligentEnableTypes(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        SettingsProviderHelper.INSTANCE.setIntelligentCallEnableTypes(r1, r2);
    }

    public final int getPhoneInterceptTypes(Context r1) {
        Intrinsics.checkNotNullParameter(r1, "context");
        return SettingsProviderHelper.INSTANCE.getPhoneInterceptTypes(r1);
    }

    public final void setPhoneInterceptTypes(Context r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "context");
        SettingsProviderHelper.INSTANCE.setPhoneInterceptTypes(r1, r2);
    }

    public final void sendIntelligentNotification(final Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        if (canShowCallNotification(r2) == true) goto L5;
        return;
    L5:
        findFirstCallLog(r2, new C02141(r2));
    }

    private final void findFirstCallLog(Context r7, Function1<? super Boolean, Unit> r8) {
        BuildersKt.launch$default(GlobalUtils.INSTANCE.getGlobalIOCoroutineScope(), null, null, new AnonymousClass1(r7, r8, null), 3, null);
    }

    private final boolean isHarassmentCall(String r4) {
        final CountDownLatch r3 = new CountDownLatch(1);
        final Ref.BooleanRef r0 = new Ref.BooleanRef();
        NumberInfosManager.getInstance().getBaseAndMarkInfosAsync(r4, new C02131(r0, r3));
        r3.await(1, TimeUnit.SECONDS);
        return r0.element;
    }

    private final synchronized boolean canShowCallNotification(Context r3) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        boolean r1 = false;
        if (canShowIntelligentCallNotification == true) goto L9;
        monitor-exit(this);
        return false;
    L9:
        if (SettingsProviderHelper.INSTANCE.canSendIntelligentNotification(r3) == true) goto L11;
    L13:
        canShowIntelligentCallNotification = r1;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r1;
    L11:
        if (SettingsProviderHelper.INSTANCE.isAutoIntelligentEnabled(r3, false) == false) goto L13;
        r1 = true;
        goto L13
    }

    private final void showCallNotification(Context r1) {
        SettingsProviderHelper.INSTANCE.setIntelligentNotificationShowed(r1);
        canShowIntelligentCallNotification = false;
    }
}
