package androidx.compose.runtime;

import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.compose.runtime.collection.ScopeMap;
import androidx.exifinterface.media.ExifInterface;
import com.byted.cast.linkcommon.cybergarage.upnp.RootDescription;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import com.ss.android.ugc.aweme.shortvideo.ShortVideoSegments;
import com.ss.android.ugc.effectmanager.effect.model.ComposerHelper;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000Ä\u0001\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b,\n\u0002\u0010\u0001\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u001a3\u0010\u0005\u001a\u0002H\u0006\"\u0004\b\u0000\u0010\u0006*\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u0002H\u00060\u000b¢\u0006\u0002\b\fH\u0087\b¢\u0006\u0002\u0010\r\u001a\u0018\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u0011H\u0007\u001a \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u0011H\u0007\u001a\b\u0010\u001d\u001a\u00020\tH\u0007\u001a\u0018\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0011H\u0007\u001a(\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u00012\u0006\u0010 \u001a\u00020\u00012\u0006\u0010!\u001a\u00020\u00012\u0006\u0010\u001f\u001a\u00020\u0011H\u0007\u001a\b\u0010\"\u001a\u00020\u000fH\u0007\u001a\u0010\u0010#\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0007H\u0007\u001a\u0014\u0010$\u001a\u00020\u000f*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0000\u001a7\u0010'\u001a\u00020\u000f\"\u0004\b\u0000\u0010(*\u00020\u00022\b\u0010)\u001a\u0004\u0018\u00010*2\u0018\u0010+\u001a\u0014\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u0002H(0,H\u0080\b\u001a\u0014\u00101\u001a\u00020\u000f*\u00020\u00022\u0006\u0010%\u001a\u00020&H\u0000\u001a\u001e\u00102\u001a\u00020\u000f*\u00020\u00022\u0006\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u000105H\u0002\u001a5\u00106\u001a\u000e\u0012\u0004\u0012\u0002H8\u0012\u0004\u0012\u0002H907\"\b\b\u0000\u00108*\u000205\"\b\b\u0001\u00109*\u0002052\u0006\u0010:\u001a\u00020\u0001H\u0002¢\u0006\u0002\u0010;\u001a(\u0010<\u001a\u0004\u0018\u0001052\b\u0010=\u001a\u0004\u0018\u0001052\b\u0010>\u001a\u0004\u0018\u0001052\b\u0010?\u001a\u0004\u0018\u000105H\u0002\u001a\u001a\u0010@\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010C\u001a\u00020\u0001H\u0002\u001a\u001a\u0010D\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010C\u001a\u00020\u0001H\u0002\u001a,\u0010E\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020B0F2\u0006\u0010C\u001a\u00020\u00012\u0006\u0010G\u001a\u00020H2\b\u0010I\u001a\u0004\u0018\u000105H\u0002\u001a$\u0010J\u001a\u0004\u0018\u00010B*\b\u0012\u0004\u0012\u00020B0F2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0002\u001a\u001c\u0010M\u001a\u0004\u0018\u00010B*\b\u0012\u0004\u0012\u00020B0F2\u0006\u0010C\u001a\u00020\u0001H\u0002\u001a\"\u0010N\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020B0F2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u0001H\u0002\u001a7\u0010O\u001a\u00020\u000f*\b\u0012\u0004\u0012\u00020B0A2\u0006\u0010K\u001a\u00020\u00012\u0006\u0010L\u001a\u00020\u00012\u0012\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u000f0PH\u0082\b\u001a\f\u0010Q\u001a\u00020\u0001*\u00020\tH\u0002\u001a\f\u0010R\u001a\u00020\t*\u00020\u0001H\u0002\u001a\u001c\u0010S\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001050A*\u00020T2\u0006\u0010)\u001a\u00020*H\u0002\u001a\u001c\u0010U\u001a\u00020\u0001*\u00020/2\u0006\u00103\u001a\u00020\u00012\u0006\u0010V\u001a\u00020\u0001H\u0002\u001a$\u0010W\u001a\u00020\u0001*\u00020/2\u0006\u0010X\u001a\u00020\u00012\u0006\u0010Y\u001a\u00020\u00012\u0006\u0010Z\u001a\u00020\u0001H\u0002\u001a,\u0010\u0084\u0001\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\t2\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001\u001a!\u0010\u0087\u0001\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\t2\r\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u00110\u000bH\u0080\b\u001a\u0012\u0010\u0087\u0001\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\tH\u0080\b\u001a\u0012\u0010\u0084\u0001\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020\tH\u0080\b\u001a\u0013\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0007\u0010\u008a\u0001\u001a\u00020\u0011H\u0000\u001a\u0012\u0010\u008b\u0001\u001a\u00020\u000f2\u0007\u0010\u008a\u0001\u001a\u00020\u0011H\u0000\u001a6\u0010\u008f\u0001\u001a\u00030\u0090\u00012\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\u0007\u0010~\u001a\u00030\u0093\u00012\u0007\u0010\u0094\u0001\u001a\u00020\u00022\u000e\u0010\u0095\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0096\u0001H\u0000\"\u0018\u0010\u0000\u001a\u00020\u0001*\u00020\u00028BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u0015X\u0082\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0016\u0010\u0017\"\u001a\u0010\u0018\u001a\u00020\tX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c\"\u0018\u0010-\u001a\u00020\t*\u00020\u00028@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.\"\u0018\u0010-\u001a\u00020\t*\u00020/8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b-\u00100\"\u0018\u0010[\u001a\u000205*\u00020\\8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b]\u0010^\"\u000e\u0010_\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010`\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010a\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010b\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bc\u0010\u0017\"\u001c\u0010d\u001a\u0002058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\be\u0010\u0017\u001a\u0004\bf\u0010g\"\u0016\u0010h\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bi\u0010\u0017\"\u001c\u0010j\u001a\u0002058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bk\u0010\u0017\u001a\u0004\bl\u0010g\"\u0016\u0010m\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bn\u0010\u0017\"\u001c\u0010o\u001a\u0002058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bp\u0010\u0017\u001a\u0004\bq\u0010g\"\u0016\u0010r\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bs\u0010\u0017\"\u001c\u0010t\u001a\u0002058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bu\u0010\u0017\u001a\u0004\bv\u0010g\"\u0016\u0010w\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\bx\u0010\u0017\"\u001c\u0010y\u001a\u0002058\u0000X\u0081\u0004¢\u0006\u000e\n\u0000\u0012\u0004\bz\u0010\u0017\u001a\u0004\b{\u0010g\"\u0016\u0010|\u001a\u00020\u00018\u0000X\u0081T¢\u0006\b\n\u0000\u0012\u0004\b}\u0010\u0017\"\u001d\u0010~\u001a\u0002058\u0000X\u0081\u0004¢\u0006\u000f\n\u0000\u0012\u0004\b\u007f\u0010\u0017\u001a\u0005\b\u0080\u0001\u0010g\"\u0018\u0010\u0081\u0001\u001a\u00020\u00018\u0000X\u0081T¢\u0006\t\n\u0000\u0012\u0005\b\u0082\u0001\u0010\u0017\"\u000f\u0010\u0083\u0001\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000f\u0010\u0086\u0001\u001a\u00020\tX\u0080T¢\u0006\u0002\n\u0000\"!\u0010\u008c\u0001\u001a\u0014\u0012\u0004\u0012\u00020B0\u008d\u0001j\t\u0012\u0004\u0012\u00020B`\u008e\u0001X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0097\u0001"}, d2 = {"nextGroup", "", "Landroidx/compose/runtime/SlotWriter;", "getNextGroup", "(Landroidx/compose/runtime/SlotWriter;)I", "cache", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Composer;", "invalid", "", "block", "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "(Landroidx/compose/runtime/Composer;ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "sourceInformation", "", ComposerHelper.CONFIG_TYPE_COMPOSER, "", "sourceInformationMarkerStart", "key", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "()V", "composeStackTraceEnabled", "getComposeStackTraceEnabled", "()Z", "setComposeStackTraceEnabled", "(Z)V", "isTraceInProgress", "traceEventStart", "info", "dirty1", "dirty2", "traceEventEnd", "sourceInformationMarkerEnd", "removeCurrentGroup", "rememberManager", "Landroidx/compose/runtime/RememberManager;", "withAfterAnchorInfo", "R", "anchor", "Landroidx/compose/runtime/Anchor;", "cb", "Lkotlin/Function2;", "isAfterFirstChild", "(Landroidx/compose/runtime/SlotWriter;)Z", "Landroidx/compose/runtime/SlotReader;", "(Landroidx/compose/runtime/SlotReader;)Z", "deactivateCurrentGroup", "removeData", "index", "data", "", "multiMap", "Landroidx/compose/runtime/collection/MultiValueMap;", "K", "V", "initialCapacity", "(I)Landroidx/collection/MutableScatterMap;", "getKey", "value", "left", "right", "findLocation", "", "Landroidx/compose/runtime/Invalidation;", "location", "findInsertLocation", "insertIfMissing", "", "scope", "Landroidx/compose/runtime/RecomposeScopeImpl;", "instance", "firstInRange", "start", "end", "removeLocation", "removeRange", "forEachInRange", "Lkotlin/Function1;", "asInt", "asBool", "collectNodesFrom", "Landroidx/compose/runtime/SlotTable;", "distanceFrom", RootDescription.ROOT_ELEMENT, "nearestCommonRootOf", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "b", "common", "joinedKey", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "rootKey", "nodeKey", "defaultsKey", "invocationKey", "getInvocationKey$annotations", "invocation", "getInvocation$annotations", "getInvocation", "()Ljava/lang/Object;", "providerKey", "getProviderKey$annotations", ShortVideoSegments.KEY_PROP_PROVIDER, "getProvider$annotations", "getProvider", "compositionLocalMapKey", "getCompositionLocalMapKey$annotations", "compositionLocalMap", "getCompositionLocalMap$annotations", "getCompositionLocalMap", "providerValuesKey", "getProviderValuesKey$annotations", "providerValues", "getProviderValues$annotations", "getProviderValues", "providerMapsKey", "getProviderMapsKey$annotations", "providerMaps", "getProviderMaps$annotations", "getProviderMaps", "referenceKey", "getReferenceKey$annotations", "reference", "getReference$annotations", "getReference", "reuseKey", "getReuseKey$annotations", "invalidGroupLocation", "runtimeCheck", "lazyMessage", "EnableDebugRuntimeChecks", "debugRuntimeCheck", "composeRuntimeError", "", "message", "composeImmediateRuntimeError", "InvalidationLocationAscending", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "extractMovableContentAtCurrent", "Landroidx/compose/runtime/MovableContentState;", "composition", "Landroidx/compose/runtime/ControlledComposition;", "Landroidx/compose/runtime/MovableContentStateReference;", "slots", "applier", "Landroidx/compose/runtime/Applier;", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ComposerKt {
    public static final boolean EnableDebugRuntimeChecks = false;
    private static final Comparator<Invalidation> InvalidationLocationAscending = null;
    private static boolean composeStackTraceEnabled = false;
    private static final Object compositionLocalMap = null;
    public static final int compositionLocalMapKey = 202;
    private static CompositionTracer compositionTracer = null;
    public static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    private static final Object invocation = null;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    private static final Object provider = null;
    public static final int providerKey = 201;
    private static final Object providerMaps = null;
    public static final int providerMapsKey = 204;
    private static final Object providerValues = null;
    public static final int providerValuesKey = 203;
    private static final Object reference = null;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;

    public static /* synthetic */ Unit a(RememberManager r100, int r101, Object r102) {
        return removeCurrentGroup$lambda$2(r100, r101, r102);
    }

    private static final boolean asBool(int r100) {
        if (r100 == 0) goto L4;
        return true;
    L4:
        return false;
    }

    private static final int asInt(boolean r100) {
        return r100 ? 1 : 0;
    }

    public static /* synthetic */ Unit b(RememberManager r100, SlotWriter r101, int r102, Object r103) {
        return deactivateCurrentGroup$lambda$3(r100, r101, r102, r103);
    }

    public static /* synthetic */ int c(Invalidation r100, Invalidation r101) {
        return InvalidationLocationAscending$lambda$13(r100, r101);
    }

    public static final void debugRuntimeCheck(boolean r100) {
    }

    public static final void debugRuntimeCheck(boolean r100, Function0<String> r101) {
    }

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    static {
        invocation = new OpaqueKey(ShortVideoSegments.KEY_PROP_PROVIDER);
        provider = new OpaqueKey(ShortVideoSegments.KEY_PROP_PROVIDER);
        compositionLocalMap = new OpaqueKey("compositionLocalMap");
        providerValues = new OpaqueKey("providerValues");
        providerMaps = new OpaqueKey("providers");
        reference = new OpaqueKey("reference");
        InvalidationLocationAscending = new h();
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer r100 = compositionTracer;
        if (r100 != null) goto L5;
    L7:
        return false;
    L5:
        if (r100.isTraceInProgress() == false) goto L7;
        return true;
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer r100 = compositionTracer;
        if (r100 == null) goto L6;
        r100.traceEventEnd();
        return;
    }

    public static final /* synthetic */ Comparator access$getInvalidationLocationAscending$p() {
        return InvalidationLocationAscending;
    }

    public static final boolean getComposeStackTraceEnabled() {
        return composeStackTraceEnabled;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static final Object getProvider() {
        return provider;
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    public static final Object getReference() {
        return reference;
    }

    public static final /* synthetic */ boolean access$asBool(int r100) {
        return asBool(r100);
    }

    public static final /* synthetic */ int access$asInt(boolean r100) {
        return asInt(r100);
    }

    public static final /* synthetic */ Object access$getJoinedKey(KeyInfo r100) {
        return getJoinedKey(r100);
    }

    public static final /* synthetic */ int access$getNextGroup(SlotWriter r100) {
        return getNextGroup(r100);
    }

    public static final /* synthetic */ MutableScatterMap access$multiMap(int r100) {
        return multiMap(r100);
    }

    public static final /* synthetic */ void access$setCompositionTracer$p(CompositionTracer r100) {
        compositionTracer = r100;
    }

    public static final void composeImmediateRuntimeError(String r100) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + r100 + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    public static final Void composeRuntimeError(String r100) {
        throw new ComposeRuntimeError("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (" + r100 + "). Please report to Google or use https://goo.gle/compose-feedback");
    }

    private static final Object getJoinedKey(KeyInfo r100) {
        if (r100.getObjectKey() == null) goto L6;
        return new JoinedKey(Integer.valueOf(r100.getKey()), r100.getObjectKey());
    L6:
        return Integer.valueOf(r100.getKey());
    }

    private static final int getNextGroup(SlotWriter r100) {
        return r100.getCurrentGroup() + r100.groupSize(r100.getCurrentGroup());
    }

    public static final boolean isAfterFirstChild(SlotReader r100) {
        if (r100.getCurrentGroup() > (r100.getParent() + 1)) goto L7;
        return false;
    L7:
        return true;
    }

    private static final <K, V> MutableScatterMap<Object, Object> multiMap(int r100) {
        return MultiValueMap.m4244constructorimpl(new MutableScatterMap(r100));
    }

    public static final void runtimeCheck(boolean r100) {
        if (r100 == true) goto L5;
        composeImmediateRuntimeError("Check failed");
        return;
    }

    public static final void setComposeStackTraceEnabled(boolean r100) {
        composeStackTraceEnabled = r100;
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer r100) {
        r100.sourceInformationMarkerEnd();
    }

    public static final boolean isAfterFirstChild(SlotWriter r100) {
        if (r100.getCurrentGroup() > (r100.getParent() + 1)) goto L7;
        return false;
    L7:
        return true;
    }

    private static final int InvalidationLocationAscending$lambda$13(Invalidation r100, Invalidation r101) {
        return Intrinsics.compare(r100.getLocation(), r101.getLocation());
    }

    public static final /* synthetic */ List access$collectNodesFrom(SlotTable r100, Anchor r101) {
        return collectNodesFrom(r100, r101);
    }

    public static final /* synthetic */ int access$findInsertLocation(List r100, int r101) {
        return findInsertLocation(r100, r101);
    }

    public static final /* synthetic */ Invalidation access$removeLocation(List r100, int r101) {
        return removeLocation(r100, r101);
    }

    private static final List<Object> collectNodesFrom(SlotTable r100, Anchor r101) {
        ArrayList r102 = new ArrayList();
        SlotReader r103 = r100.openReader();
        collectNodesFrom$lambda$8$collectFromGroup(r103, r102, r100.anchorIndex(r101));     // Catch: Throwable -> L6
        Unit r104 = Unit.INSTANCE;     // Catch: Throwable -> L6
        r103.close();
        return r102;
    L6:
        th = move-exception;
        r103.close();
        throw th;
    }

    public static final void deactivateCurrentGroup(final SlotWriter r100, final RememberManager r101) {
        r100.forAllDataInRememberOrder(r100.getCurrentGroup(), new i(r101, r100));
    }

    private static final int findInsertLocation(List<Invalidation> r100, int r101) {
        int r102 = findLocation(r100, r101);
        if (r102 < 0) goto L5;
        return r102;
    L5:
        return -(r102 + 1);
    }

    private static final int findLocation(List<Invalidation> r100, int r101) {
        int r102 = r100.size() - 1;
        int r103 = 0;
    L3:
        if (r103 > r102) goto L11;
        int r104 = (r103 + r102) >>> 1;
        int r105 = Intrinsics.compare(((Invalidation) ListProtector.get(r100, r104)).getLocation(), r101);
        if (r105 < 0) goto L6;
        if (r105 <= 0) goto L9;
        r102 = r104 - 1;
        goto L3
    L9:
        return r104;
    L6:
        r103 = r104 + 1;
        goto L3
    L11:
        return -(r103 + 1);
    }

    public static final void removeCurrentGroup(SlotWriter r100, final RememberManager r101) {
        r100.forAllDataInRememberOrder(r100.getCurrentGroup(), new g(r101));
        r100.removeGroup();
    }

    private static final Invalidation removeLocation(List<Invalidation> r100, int r101) {
        int r102 = findLocation(r100, r101);
        if (r102 >= 0) goto L7;
        return null;
    L7:
        return (Invalidation) ListProtector.remove(r100, r102);
    }

    public static final void runtimeCheck(boolean r100, Function0<String> r101) {
        if (r100 == true) goto L5;
        composeImmediateRuntimeError(r101.invoke());
        return;
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer r100, String r101) {
        r100.sourceInformation(r101);
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Use the overload with $dirty metadata instead", replaceWith = @ReplaceWith(expression = "traceEventStart(key, dirty1, dirty2, info)", imports = {}))
    @ComposeCompilerApi
    public static final /* synthetic */ void traceEventStart(int r100, String r101) {
        traceEventStart(r100, -1, -1, r101);
    }

    public static final /* synthetic */ Invalidation access$firstInRange(List r100, int r101, int r102) {
        return firstInRange(r100, r101, r102);
    }

    public static final /* synthetic */ Object access$getKey(Object r100, Object r101, Object r102) {
        return getKey(r100, r101, r102);
    }

    public static final /* synthetic */ void access$removeRange(List r100, int r101, int r102) {
        removeRange(r100, r101, r102);
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer r100, boolean r101, Function0<? extends T> r102) {
        T r103 = (T) r100.rememberedValue();
        if (r101 == false) goto L5;
    L6:
        T r104 = r102.invoke();
        r100.updateRememberedValue(r104);
        return r104;
    L5:
        if (r103 == Composer.Companion.getEmpty()) goto L6;
        return r103;
    }

    private static final void collectNodesFrom$lambda$8$collectFromGroup(SlotReader r100, List<Object> r101, int r102) {
        if (r100.isNode(r102) == false) goto L5;
        r101.add(r100.node(r102));
        return;
    L5:
        int r103 = r102 + 1;
        int r104 = r102 + r100.groupSize(r102);
    L6:
        if (r103 >= r104) goto L10;
        collectNodesFrom$lambda$8$collectFromGroup(r100, r101, r103);
        r103 = r103 + r100.groupSize(r103);
        goto L6
    }

    private static final int distanceFrom(SlotReader r100, int r101, int r102) {
        int r103 = 0;
    L3:
        if (r101 <= 0) goto L6;
        if (r101 == r102) goto L6;
        r101 = r100.parent(r101);
        r103 = r103 + 1;
    L6:
        return r103;
    }

    private static final Invalidation firstInRange(List<Invalidation> r100, int r101, int r102) {
        int r103 = findInsertLocation(r100, r101);
        if (r103 >= r100.size()) goto L7;
        Invalidation r104 = (Invalidation) ListProtector.get(r100, r103);
        if (r104.getLocation() >= r102) goto L9;
        return r104;
    L9:
        return null;
    L7:
        return null;
    }

    private static final Object getKey(Object r100, Object r101, Object r102) {
        if ((r100 instanceof JoinedKey) == false) goto L5;
        JoinedKey r103 = (JoinedKey) r100;
    L6:
        if (r103 != null) goto L8;
        return null;
    L8:
        if (Intrinsics.areEqual(r103.getLeft(), r101) == true) goto L10;
    L12:
        r100 = getKey(r103.getLeft(), r101, r102);
        if (r100 != null) goto L16;
        r100 = getKey(r103.getRight(), r101, r102);
    L16:
        return r100;
    L10:
        if (Intrinsics.areEqual(r103.getRight(), r102) == false) goto L12;
    L5:
        r103 = null;
        goto L6
    }

    private static final Unit removeCurrentGroup$lambda$2(RememberManager r100, int r101, Object r102) {
        if ((r102 instanceof ComposeNodeLifecycleCallback) == false) goto L6;
        r100.releasing((ComposeNodeLifecycleCallback) r102);
    L6:
        if ((r102 instanceof RememberObserverHolder) == false) goto L9;
        r100.forgetting((RememberObserverHolder) r102);
    L9:
        if ((r102 instanceof RecomposeScopeImpl) == false) goto L12;
        ((RecomposeScopeImpl) r102).release();
    L12:
        return Unit.INSTANCE;
    }

    private static final void removeData(SlotWriter r100, int r101, Object r102) {
        Object r103 = r100.clear(r101);
        if (r102 != r103) goto L5;
        boolean r104 = true;
    L6:
        if (r104 == true) goto L9;
        composeImmediateRuntimeError("Slot table is out of sync (expected " + r102 + ", got " + r103 + ')');
        return;
    L9:
        return;
    L5:
        r104 = false;
        goto L6
    }

    private static final void removeRange(List<Invalidation> r100, int r101, int r102) {
        int r103 = findInsertLocation(r100, r101);
    L4:
        if (r103 >= r100.size()) goto L8;
        if (((Invalidation) ListProtector.get(r100, r103)).getLocation() >= r102) goto L11;
        Invalidation r104 = (Invalidation) ListProtector.remove(r100, r103);
        goto L4
    L11:
        return;
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer r100, int r101, String r102) {
        r100.sourceInformationMarkerStart(r101, r102);
    }

    public static final <R> void withAfterAnchorInfo(SlotWriter r100, Anchor r101, Function2<? super Integer, ? super Integer, ? extends R> r102) {
        if (r101 != null) goto L4;
    L6:
        int r103 = -1;
        int r104 = -1;
    L7:
        r102.invoke(Integer.valueOf(r103), Integer.valueOf(r104));
        return;
    L4:
        if (r101.getValid() == false) goto L6;
        r103 = r100.anchorIndex(r101);
        r104 = r100.getSlotsSize() - r100.slotsEndAllIndex$runtime(r103);
        goto L7
    }

    public static final /* synthetic */ void access$insertIfMissing(List r100, int r101, RecomposeScopeImpl r102, Object r103) {
        insertIfMissing(r100, r101, r102, r103);
    }

    public static final /* synthetic */ int access$nearestCommonRootOf(SlotReader r100, int r101, int r102, int r103) {
        return nearestCommonRootOf(r100, r101, r102, r103);
    }

    private static final Unit deactivateCurrentGroup$lambda$3(RememberManager r100, SlotWriter r101, int r102, Object r103) {
        if ((r103 instanceof ComposeNodeLifecycleCallback) == false) goto L6;
        r100.deactivating((ComposeNodeLifecycleCallback) r103);
    L14:
        return Unit.INSTANCE;
    L6:
        if ((r103 instanceof RememberObserverHolder) == false) goto L11;
        RememberObserverHolder r104 = (RememberObserverHolder) r103;
        if ((r104.getWrapped() instanceof ReusableRememberObserver) == true) goto L14;
        removeData(r101, r102, r103);
        r100.forgetting(r104);
        goto L14
    L11:
        if ((r103 instanceof RecomposeScopeImpl) == false) goto L14;
        removeData(r101, r102, r103);
        ((RecomposeScopeImpl) r103).release();
        goto L14
    }

    public static final MovableContentState extractMovableContentAtCurrent(final ControlledComposition r310, MovableContentStateReference r311, SlotWriter r312, Applier<?> r313) {
        final MovableContentStateReference r100 = r311;
        SlotTable r101 = new SlotTable();
        if (r312.getCollectingSourceInformation() == false) goto L6;
        r101.collectSourceInformation();
    L6:
        if (r312.getCollectingCalledInformation() == false) goto L8;
        r101.collectCalledByInformation();
    L8:
        int r102 = r312.getCurrentGroup();
        if (r313 != null) goto L11;
    L35:
        Anchor r103 = r311.getAnchor$runtime();
        if (r103.getValid() == false) goto L103;
        Intrinsics.checkNotNull(r310, "null cannot be cast to non-null type androidx.compose.runtime.CompositionImpl");
        CompositionImpl r104 = (CompositionImpl) r310;
        if (ScopeMap.m4271getSizeimpl(CompositionImpl.access$getInvalidations$p(r104)) <= 0) goto L101;
        List r105 = new ArrayList();
        MutableScatterMap r106 = CompositionImpl.access$getInvalidations$p(r104);
        long[] r107 = r106.metadata;
        int r110 = r107.length - 2;
        if (r110 < 0) goto L100;
        int r111 = 0;
    L42:
        long r112 = r107[r111];
        if (((((~r112) << 7) & r112) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L97;
        int r113 = 8 - ((~(r111 - r110)) >>> 31);
        int r108 = 0;
    L45:
        if (r108 >= r113) goto L94;
        if ((r112 & 255) >= 128) goto L49;
        boolean r210 = true;
    L50:
        if (r210 == false) goto L92;
        int r109 = (r111 << 3) + r108;
        Object r114 = r106.keys[r109];
        long[] r211 = r107;
        Object r115 = r106.values[r109];
        Intrinsics.checkNotNull(r114, "null cannot be cast to non-null type Key of androidx.compose.runtime.collection.ScopeMap");
        if ((r115 instanceof MutableScatterSet) == false) goto L83;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type androidx.collection.MutableScatterSet<Scope of androidx.compose.runtime.collection.ScopeMap>");
        MutableScatterSet r116 = (MutableScatterSet) r115;
        Object[] r117 = r116.elements;
        SlotTable r212 = r101;
        long[] r118 = r116.metadata;
        int r119 = r118.length - 2;
        if (r119 < 0) goto L81;
        int r213 = r110;
        int r214 = r111;
        long r215 = r112;
        int r120 = 0;
    L56:
        long r121 = r118[r120];
        int r314 = r113;
        if (((((~r121) << 7) & r121) & (-9187201950435737472L)) == (-9187201950435737472L)) goto L78;
        int r122 = 8 - ((~(r120 - r119)) >>> 31);
        int r123 = 0;
    L59:
        if (r123 >= r122) goto L75;
        if ((r121 & 255) >= 128) goto L63;
        boolean r315 = true;
    L64:
        if (r315 == false) goto L73;
        long[] r316 = r118;
        int r124 = (r120 << 3) + r123;
        int r317 = r108;
        Object r125 = r117[r124];
        Object[] r318 = r117;
        RecomposeScopeImpl r126 = (RecomposeScopeImpl) r114;
        MutableScatterMap r319 = r106;
        Anchor r127 = r126.getAnchor();
        if (r127 != null) goto L68;
    L70:
        boolean r128 = false;
    L71:
        if (r128 == false) goto L74;
        r116.removeElementAt(r124);
    L74:
        r121 = r121 >> 8;
        r123 = r123 + 1;
        r108 = r317;
        r118 = r316;
        r117 = r318;
        r106 = r319;
        goto L59
    L68:
        if (r312.inGroup(r103, r127) == false) goto L70;
        r105.add(TuplesKt.to(r126, r125));
        r128 = true;
        goto L71
    L73:
        r318 = r117;
        r316 = r118;
        r319 = r106;
        r317 = r108;
        goto L74
    L63:
        r315 = false;
        goto L64
    L75:
        Object[] r320 = r117;
        long[] r321 = r118;
        MutableScatterMap r322 = r106;
        int r323 = r108;
        if (r122 != 8) goto L82;
    L79:
        if (r120 == r119) goto L82;
        r120 = r120 + 1;
        r113 = r314;
        r108 = r323;
        r118 = r321;
        r117 = r320;
        r106 = r322;
    L82:
        boolean r129 = r116.isEmpty();
    L89:
        if (r129 == false) goto L91;
        MutableScatterMap r130 = r322;
        r130.removeValueAt(r109);
    L93:
        r112 = r215 >> 8;
        r108 = r323 + 1;
        r106 = r130;
        r107 = r211;
        r101 = r212;
        r110 = r213;
        r111 = r214;
        r113 = r314;
        goto L45
    L91:
        r130 = r322;
        goto L93
    L78:
        r320 = r117;
        r321 = r118;
        r322 = r106;
        r323 = r108;
        goto L79
    L81:
        r322 = r106;
        r323 = r108;
        r213 = r110;
        r214 = r111;
        r215 = r112;
        r314 = r113;
        goto L82
    L83:
        r212 = r101;
        r322 = r106;
        r323 = r108;
        r213 = r110;
        r214 = r111;
        r215 = r112;
        r314 = r113;
        Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type Scope of androidx.compose.runtime.collection.ScopeMap");
        RecomposeScopeImpl r131 = (RecomposeScopeImpl) r114;
        Anchor r132 = r131.getAnchor();
        if (r132 != null) goto L86;
    L88:
        r129 = false;
        goto L89
    L86:
        if (r312.inGroup(r103, r132) == false) goto L88;
        r105.add(TuplesKt.to(r131, r115));
        r129 = true;
        goto L89
    L92:
        r212 = r101;
        r130 = r106;
        r323 = r108;
        r211 = r107;
        r213 = r110;
        r214 = r111;
        r215 = r112;
        r314 = r113;
        goto L93
    L49:
        r210 = false;
        goto L50
    L94:
        SlotTable r216 = r101;
        MutableScatterMap r133 = r106;
        long[] r217 = r107;
        int r218 = r110;
        int r219 = r111;
        if (r113 != 8) goto L102;
        r110 = r218;
        int r134 = r219;
    L98:
        if (r134 == r110) goto L102;
        r111 = r134 + 1;
        r106 = r133;
        r107 = r217;
        r101 = r216;
    L102:
        r100 = r311;
        r100.setInvalidations$runtime(CollectionsKt.plus(r311.getInvalidations$runtime(), r105));
    L104:
        SlotWriter r135 = r216.openWriter();
        r135.beginInsert();     // Catch: Throwable -> L115
        r135.startGroup(MovableContentKt.movableContentKey, r311.getContent$runtime());     // Catch: Throwable -> L115
        SlotWriter.markGroup$default(r135, 0, 1, null);     // Catch: Throwable -> L115
        r135.update(r311.getParameter$runtime());     // Catch: Throwable -> L115
        List<Anchor> r136 = r312.moveTo(r311.getAnchor$runtime(), 1, r135);     // Catch: Throwable -> L115
        r135.skipGroup();     // Catch: Throwable -> L115
        r135.endGroup();     // Catch: Throwable -> L115
        r135.endInsert();     // Catch: Throwable -> L115
        r135.close(true);
        SlotTable r137 = r216;
        MovableContentState r138 = new MovableContentState(r137);
        RecomposeScopeImpl.Companion r139 = RecomposeScopeImpl.Companion;
        if (r139.hasAnchoredRecomposeScopes$runtime(r137, r136) == false) goto L114;
        RecomposeScopeOwner r140 = new ComposerKt$extractMovableContentAtCurrent$movableContentRecomposeScopeOwner$1(r310, r100);
        SlotWriter r141 = r137.openWriter();
        r139.adoptAnchoredScopes$runtime(r141, r136, r140);     // Catch: Throwable -> L111
        Unit r142 = Unit.INSTANCE;     // Catch: Throwable -> L111
        r141.close(true);
    L111:
        th = move-exception;
        r141.close(false);
        throw th;
    L114:
        return r138;
    L115:
        th = move-exception;
        r135.close(false);
        throw th;
    L97:
        r216 = r101;
        r133 = r106;
        r217 = r107;
        r134 = r111;
        goto L98
    L100:
        r216 = r101;
        goto L102
    L101:
        r216 = r101;
        r105 = CollectionsKt.emptyList();
        goto L102
    L103:
        r216 = r101;
        goto L104
    L11:
        if (r312.nodeCount(r102) <= 0) goto L35;
        int r143 = r312.getParent();
    L13:
        if (r143 <= 0) goto L17;
        if (r312.isNode(r143) == true) goto L17;
        r143 = r312.parent(r143);
    L17:
        if (r143 < 0) goto L35;
        if (r312.isNode(r143) == false) goto L35;
        Object r144 = r312.node(r143);
        int r145 = r143 + 1;
        int r146 = r143 + r312.groupSize(r143);
        int r147 = 0;
    L21:
        if (r145 >= r146) goto L31;
        int r148 = r312.groupSize(r145) + r145;
        if (r148 > r102) goto L31;
        if (r312.isNode(r145) == false) goto L28;
        int r149 = 1;
    L29:
        r147 = r147 + r149;
        r145 = r148;
        goto L21
    L28:
        r149 = r312.nodeCount(r145);
    L31:
        if (r312.isNode(r102) == false) goto L33;
        int r150 = 1;
    L34:
        r313.down(r144);
        r313.remove(r147, r150);
        r313.up();
        goto L35
    L33:
        r150 = r312.nodeCount(r102);
        goto L34
    }

    private static final void forEachInRange(List<Invalidation> r100, int r101, int r102, Function1<? super Invalidation, Unit> r103) {
        int r104 = access$findInsertLocation(r100, r101);
    L4:
        if (r104 >= r100.size()) goto L8;
        Invalidation r105 = (Invalidation) ListProtector.get(r100, r104);
        if (r105.getLocation() >= r102) goto L11;
        r103.invoke(r105);
        r104 = r104 + 1;
        goto L4
    L11:
        return;
    }

    private static final void insertIfMissing(List<Invalidation> r100, int r101, RecomposeScopeImpl r102, Object r103) {
        int r104 = findLocation(r100, r101);
        if (r104 >= 0) goto L9;
        int r105 = -(r104 + 1);
        if ((r103 instanceof DerivedState) == true) goto L8;
        r103 = null;
    L8:
        ListProtector.add(r100, r105, new Invalidation(r102, r101, r103));
        return;
    L9:
        Invalidation r106 = (Invalidation) ListProtector.get(r100, r104);
        if ((r103 instanceof DerivedState) == false) goto L18;
        Object r107 = r106.getInstances();
        if (r107 != null) goto L15;
        r106.setInstances(r103);
        return;
    L15:
        if ((r107 instanceof MutableScatterSet) == false) goto L17;
        ((MutableScatterSet) r107).add(r103);
        return;
    L17:
        r106.setInstances(ScatterSetKt.mutableScatterSetOf(r107, r103));
        return;
    L18:
        r106.setInstances(null);
    }

    private static final int nearestCommonRootOf(SlotReader r100, int r101, int r102, int r103) {
        if (r101 != r102) goto L4;
        return r101;
    L4:
        if (r101 == r103) goto L26;
        if (r102 == r103) goto L26;
        if (r100.parent(r101) != r102) goto L11;
        return r102;
    L11:
        if (r100.parent(r102) != r101) goto L14;
        return r101;
    L14:
        if (r100.parent(r101) == r100.parent(r102)) goto L16;
        int r104 = distanceFrom(r100, r101, r103);
        int r105 = distanceFrom(r100, r102, r103);
        int r106 = r104 - r105;
        int r107 = 0;
        int r108 = 0;
    L18:
        if (r108 >= r106) goto L20;
        r101 = r100.parent(r101);
        r108 = r108 + 1;
        goto L18
    L20:
        int r109 = r105 - r104;
    L21:
        if (r107 >= r109) goto L23;
        r102 = r100.parent(r102);
        r107 = r107 + 1;
    L23:
        if (r101 == r102) goto L25;
        r101 = r100.parent(r101);
        r102 = r100.parent(r102);
        goto L23
    L25:
        return r101;
    L16:
        return r100.parent(r101);
    L26:
        return r103;
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int r100, int r101, int r102, String r103) {
        CompositionTracer r104 = compositionTracer;
        if (r104 == null) goto L6;
        r104.traceEventStart(r100, r101, r102, r103);
        return;
    }
}
