package androidx.compose.runtime;

import C7.r;
import D7.v;
import S7.n;
import androidx.collection.MutableScatterMap;
import androidx.collection.MutableScatterSet;
import androidx.collection.ScatterSetKt;
import androidx.compose.runtime.RecomposeScopeImpl;
import androidx.compose.runtime.collection.MultiValueMap;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;

@Metadata(d1 = {"\u0000Æ\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0001\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a5\u0010\u0007\u001a\u00028\u0000\"\u0004\b\u0000\u0010\u0000*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00022\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\b\u0005H\u0087\b¢\u0006\u0004\b\u0007\u0010\b\u001a\u001f\u0010\u000b\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\r\u001a'\u0010\u0010\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0010\u0010\u0011\u001a\u000f\u0010\u0012\u001a\u00020\u0002H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\u001f\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0015\u0010\u0016\u001a/\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\nH\u0007¢\u0006\u0004\b\u0015\u0010\u0019\u001a\u000f\u0010\u001a\u001a\u00020\fH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u0017\u0010\u001c\u001a\u00020\f2\u0006\u0010\t\u001a\u00020\u0001H\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001b\u0010!\u001a\u00020\f*\u00020\u001e2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b!\u0010\"\u001a>\u0010(\u001a\u00020\f\"\u0004\b\u0000\u0010#*\u00020\u001e2\b\u0010%\u001a\u0004\u0018\u00010$2\u0018\u0010'\u001a\u0014\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00028\u00000&H\u0080\b¢\u0006\u0004\b(\u0010)\u001a\u001b\u0010*\u001a\u00020\f*\u00020\u001e2\u0006\u0010 \u001a\u00020\u001fH\u0000¢\u0006\u0004\b*\u0010\"\u001a%\u0010.\u001a\u00020\f*\u00020\u001e2\u0006\u0010+\u001a\u00020\u000e2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/\u001a7\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000103\"\b\b\u0000\u00100*\u00020,\"\b\b\u0001\u00101*\u00020,2\u0006\u00102\u001a\u00020\u000eH\u0002¢\u0006\u0004\b4\u00105\u001a/\u00109\u001a\u0004\u0018\u00010,2\b\u00106\u001a\u0004\u0018\u00010,2\b\u00107\u001a\u0004\u0018\u00010,2\b\u00108\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b9\u0010:\u001a!\u0010>\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b>\u0010?\u001a!\u0010@\u001a\u00020\u000e*\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\b@\u0010?\u001a3\u0010E\u001a\u00020\f*\b\u0012\u0004\u0012\u00020<0A2\u0006\u0010=\u001a\u00020\u000e2\u0006\u0010C\u001a\u00020B2\b\u0010D\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\bE\u0010F\u001a+\u0010I\u001a\u0004\u0018\u00010<*\b\u0012\u0004\u0012\u00020<0A2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000eH\u0002¢\u0006\u0004\bI\u0010J\u001a#\u0010K\u001a\u0004\u0018\u00010<*\b\u0012\u0004\u0012\u00020<0A2\u0006\u0010=\u001a\u00020\u000eH\u0002¢\u0006\u0004\bK\u0010L\u001a)\u0010M\u001a\u00020\f*\b\u0012\u0004\u0012\u00020<0A2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000eH\u0002¢\u0006\u0004\bM\u0010N\u001a>\u0010P\u001a\u00020\f*\b\u0012\u0004\u0012\u00020<0;2\u0006\u0010G\u001a\u00020\u000e2\u0006\u0010H\u001a\u00020\u000e2\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\f0OH\u0082\b¢\u0006\u0004\bP\u0010Q\u001a\u0013\u0010R\u001a\u00020\u000e*\u00020\u0002H\u0002¢\u0006\u0004\bR\u0010S\u001a\u0013\u0010T\u001a\u00020\u0002*\u00020\u000eH\u0002¢\u0006\u0004\bT\u0010U\u001a#\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010,0;*\u00020V2\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\bW\u0010X\u001a#\u0010[\u001a\u00020\u000e*\u00020Y2\u0006\u0010+\u001a\u00020\u000e2\u0006\u0010Z\u001a\u00020\u000eH\u0002¢\u0006\u0004\b[\u0010\\\u001a+\u0010`\u001a\u00020\u000e*\u00020Y2\u0006\u0010]\u001a\u00020\u000e2\u0006\u0010^\u001a\u00020\u000e2\u0006\u0010_\u001a\u00020\u000eH\u0002¢\u0006\u0004\b`\u0010a\u001a1\u0010c\u001a\u00020\f2\u0006\u00106\u001a\u00020\u00022\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0080\b\u0082\u0002\b\n\u0006\b\u0000\u001a\u0002\u0010\u0001¢\u0006\u0004\bc\u0010d\u001a&\u0010e\u001a\u00020\f2\u0006\u00106\u001a\u00020\u00022\f\u0010b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0080\b¢\u0006\u0004\be\u0010d\u001a\u0018\u0010e\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\be\u0010f\u001a\u0018\u0010c\u001a\u00020\f2\u0006\u00106\u001a\u00020\u0002H\u0080\b¢\u0006\u0004\bc\u0010f\u001a\u0017\u0010i\u001a\u00020h2\u0006\u0010g\u001a\u00020\nH\u0000¢\u0006\u0004\bi\u0010j\u001a\u0017\u0010k\u001a\u00020\f2\u0006\u0010g\u001a\u00020\nH\u0000¢\u0006\u0004\bk\u0010l\u001a5\u0010u\u001a\u00020t2\u0006\u0010n\u001a\u00020m2\u0006\u0010p\u001a\u00020o2\u0006\u0010q\u001a\u00020\u001e2\f\u0010s\u001a\b\u0012\u0002\b\u0003\u0018\u00010rH\u0000¢\u0006\u0004\bu\u0010v\"\u001e\u0010x\u001a\u0004\u0018\u00010w8\u0002@\u0002X\u0082\u000e¢\u0006\f\n\u0004\bx\u0010y\u0012\u0004\bz\u0010\u001b\"\"\u0010{\u001a\u00020\u00028\u0000@\u0000X\u0080\u000e¢\u0006\u0012\n\u0004\b{\u0010|\u001a\u0004\b}\u0010\u0013\"\u0004\b~\u0010f\"\u0015\u0010\u007f\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\u0007\n\u0005\b\u007f\u0010\u0080\u0001\"\u0017\u0010\u0081\u0001\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\b\n\u0006\b\u0081\u0001\u0010\u0080\u0001\"\u0017\u0010\u0082\u0001\u001a\u00020\u000e8\u0000X\u0080T¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0080\u0001\"\u001e\u0010\u0083\u0001\u001a\u00020\u000e8\u0000X\u0081T¢\u0006\u000f\n\u0006\b\u0083\u0001\u0010\u0080\u0001\u0012\u0005\b\u0084\u0001\u0010\u001b\"&\u0010\u0085\u0001\u001a\u00020,8\u0000X\u0081\u0004¢\u0006\u0017\n\u0006\b\u0085\u0001\u0010\u0086\u0001\u0012\u0005\b\u0089\u0001\u0010\u001b\u001a\u0006\b\u0087\u0001\u0010\u0088\u0001\"\u001e\u0010\u008a\u0001\u001a\u00020\u000e8\u0000X\u0081T¢\u0006\u000f\n\u0006\b\u008a\u0001\u0010\u0080\u0001\u0012\u0005\b\u008b\u0001\u0010\u001b\"&\u0010\u008c\u0001\u001a\u00020,8\u0000X\u0081\u0004¢\u0006\u0017\n\u0006\b\u008c\u0001\u0010\u0086\u0001\u0012\u0005\b\u008e\u0001\u0010\u001b\u001a\u0006\b\u008d\u0001\u0010\u0088\u0001\"\u001e\u0010\u008f\u0001\u001a\u00020\u000e8\u0000X\u0081T¢\u0006\u000f\n\u0006\b\u008f\u0001\u0010\u0080\u0001\u0012\u0005\b\u0090\u0001\u0010\u001b\"&\u0010\u0091\u0001\u001a\u00020,8\u0000X\u0081\u0004¢\u0006\u0017\n\u0006\b\u0091\u0001\u0010\u0086\u0001\u0012\u0005\b\u0093\u0001\u0010\u001b\u001a\u0006\b\u0092\u0001\u0010\u0088\u0001\"\u001e\u0010\u0094\u0001\u001a\u00020\u000e8\u0000X\u0081T¢\u0006\u000f\n\u0006\b\u0094\u0001\u0010\u0080\u0001\u0012\u0005\b\u0095\u0001\u0010\u001b\"&\u0010\u0096\u0001\u001a\u00020,8\u0000X\u0081\u0004¢\u0006\u0017\n\u0006\b\u0096\u0001\u0010\u0086\u0001\u0012\u0005\b\u0098\u0001\u0010\u001b\u001a\u0006\b\u0097\u0001\u0010\u0088\u0001\"\u001e\u0010\u0099\u0001\u001a\u00020\u000e8\u0000X\u0081T¢\u0006\u000f\n\u0006\b\u0099\u0001\u0010\u0080\u0001\u0012\u0005\b\u009a\u0001\u0010\u001b\"&\u0010\u009b\u0001\u001a\u00020,8\u0000X\u0081\u0004¢\u0006\u0017\n\u0006\b\u009b\u0001\u0010\u0086\u0001\u0012\u0005\b\u009d\u0001\u0010\u001b\u001a\u0006\b\u009c\u0001\u0010\u0088\u0001\"\u001e\u0010\u009e\u0001\u001a\u00020\u000e8\u0000X\u0081T¢\u0006\u000f\n\u0006\b\u009e\u0001\u0010\u0080\u0001\u0012\u0005\b\u009f\u0001\u0010\u001b\"$\u0010p\u001a\u00020,8\u0000X\u0081\u0004¢\u0006\u0016\n\u0005\bp\u0010\u0086\u0001\u0012\u0005\b¡\u0001\u0010\u001b\u001a\u0006\b \u0001\u0010\u0088\u0001\"\u001e\u0010¢\u0001\u001a\u00020\u000e8\u0000X\u0081T¢\u0006\u000f\n\u0006\b¢\u0001\u0010\u0080\u0001\u0012\u0005\b£\u0001\u0010\u001b\"\u0017\u0010¤\u0001\u001a\u00020\u000e8\u0002X\u0082T¢\u0006\b\n\u0006\b¤\u0001\u0010\u0080\u0001\"\u0016\u0010¥\u0001\u001a\u00020\u00028\u0000X\u0080T¢\u0006\u0007\n\u0005\b¥\u0001\u0010|\")\u0010¨\u0001\u001a\u0014\u0012\u0004\u0012\u00020<0¦\u0001j\t\u0012\u0004\u0012\u00020<`§\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¨\u0001\u0010©\u0001\"\u001b\u0010¬\u0001\u001a\u00020\u000e*\u00020\u001e8BX\u0082\u0004¢\u0006\b\u001a\u0006\bª\u0001\u0010«\u0001\"\u001b\u0010\u00ad\u0001\u001a\u00020\u0002*\u00020\u001e8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010®\u0001\"\u001b\u0010\u00ad\u0001\u001a\u00020\u0002*\u00020Y8@X\u0080\u0004¢\u0006\b\u001a\u0006\b\u00ad\u0001\u0010¯\u0001\"\u001c\u0010³\u0001\u001a\u00020,*\u00030°\u00018BX\u0082\u0004¢\u0006\b\u001a\u0006\b±\u0001\u0010²\u0001¨\u0006´\u0001"}, d2 = {ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/Composer;", "", "invalid", "Lkotlin/Function0;", "Landroidx/compose/runtime/DisallowComposableCalls;", "block", "cache", "(Landroidx/compose/runtime/Composer;ZLS7/a;)Ljava/lang/Object;", "composer", "", "sourceInformation", "LC7/r;", "(Landroidx/compose/runtime/Composer;Ljava/lang/String;)V", "", "key", "sourceInformationMarkerStart", "(Landroidx/compose/runtime/Composer;ILjava/lang/String;)V", "isTraceInProgress", "()Z", "info", "traceEventStart", "(ILjava/lang/String;)V", "dirty1", "dirty2", "(IIILjava/lang/String;)V", "traceEventEnd", "()V", "sourceInformationMarkerEnd", "(Landroidx/compose/runtime/Composer;)V", "Landroidx/compose/runtime/SlotWriter;", "Landroidx/compose/runtime/RememberManager;", "rememberManager", "removeCurrentGroup", "(Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/RememberManager;)V", "R", "Landroidx/compose/runtime/Anchor;", "anchor", "Lkotlin/Function2;", "cb", "withAfterAnchorInfo", "(Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/Anchor;LS7/n;)V", "deactivateCurrentGroup", "index", "", SettingsConfig.KEY_DATA, "removeData", "(Landroidx/compose/runtime/SlotWriter;ILjava/lang/Object;)V", "K", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "initialCapacity", "Landroidx/compose/runtime/collection/MultiValueMap;", "multiMap", "(I)Landroidx/collection/MutableScatterMap;", "value", "left", "right", "getKey", "(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "", "Landroidx/compose/runtime/Invalidation;", "location", "findLocation", "(Ljava/util/List;I)I", "findInsertLocation", "", "Landroidx/compose/runtime/RecomposeScopeImpl;", "scope", "instance", "insertIfMissing", "(Ljava/util/List;ILandroidx/compose/runtime/RecomposeScopeImpl;Ljava/lang/Object;)V", "start", "end", "firstInRange", "(Ljava/util/List;II)Landroidx/compose/runtime/Invalidation;", "removeLocation", "(Ljava/util/List;I)Landroidx/compose/runtime/Invalidation;", "removeRange", "(Ljava/util/List;II)V", "Lkotlin/Function1;", "forEachInRange", "(Ljava/util/List;IILS7/k;)V", "asInt", "(Z)I", "asBool", "(I)Z", "Landroidx/compose/runtime/SlotTable;", "collectNodesFrom", "(Landroidx/compose/runtime/SlotTable;Landroidx/compose/runtime/Anchor;)Ljava/util/List;", "Landroidx/compose/runtime/SlotReader;", "root", "distanceFrom", "(Landroidx/compose/runtime/SlotReader;II)I", "a", "b", "common", "nearestCommonRootOf", "(Landroidx/compose/runtime/SlotReader;III)I", "lazyMessage", "runtimeCheck", "(ZLS7/a;)V", "debugRuntimeCheck", "(Z)V", "message", "", "composeRuntimeError", "(Ljava/lang/String;)Ljava/lang/Void;", "composeImmediateRuntimeError", "(Ljava/lang/String;)V", "Landroidx/compose/runtime/ControlledComposition;", "composition", "Landroidx/compose/runtime/MovableContentStateReference;", TypedValues.Custom.S_REFERENCE, "slots", "Landroidx/compose/runtime/Applier;", "applier", "Landroidx/compose/runtime/MovableContentState;", "extractMovableContentAtCurrent", "(Landroidx/compose/runtime/ControlledComposition;Landroidx/compose/runtime/MovableContentStateReference;Landroidx/compose/runtime/SlotWriter;Landroidx/compose/runtime/Applier;)Landroidx/compose/runtime/MovableContentState;", "Landroidx/compose/runtime/CompositionTracer;", "compositionTracer", "Landroidx/compose/runtime/CompositionTracer;", "getCompositionTracer$annotations", "composeStackTraceEnabled", "Z", "getComposeStackTraceEnabled", "setComposeStackTraceEnabled", "rootKey", "I", "nodeKey", "defaultsKey", "invocationKey", "getInvocationKey$annotations", "invocation", "Ljava/lang/Object;", "getInvocation", "()Ljava/lang/Object;", "getInvocation$annotations", "providerKey", "getProviderKey$annotations", "provider", "getProvider", "getProvider$annotations", "compositionLocalMapKey", "getCompositionLocalMapKey$annotations", "compositionLocalMap", "getCompositionLocalMap", "getCompositionLocalMap$annotations", "providerValuesKey", "getProviderValuesKey$annotations", "providerValues", "getProviderValues", "getProviderValues$annotations", "providerMapsKey", "getProviderMapsKey$annotations", "providerMaps", "getProviderMaps", "getProviderMaps$annotations", "referenceKey", "getReferenceKey$annotations", "getReference", "getReference$annotations", "reuseKey", "getReuseKey$annotations", "invalidGroupLocation", "EnableDebugRuntimeChecks", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "InvalidationLocationAscending", "Ljava/util/Comparator;", "getNextGroup", "(Landroidx/compose/runtime/SlotWriter;)I", "nextGroup", "isAfterFirstChild", "(Landroidx/compose/runtime/SlotWriter;)Z", "(Landroidx/compose/runtime/SlotReader;)Z", "Landroidx/compose/runtime/KeyInfo;", "getJoinedKey", "(Landroidx/compose/runtime/KeyInfo;)Ljava/lang/Object;", "joinedKey", "runtime"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ComposerKt {
    public static final boolean EnableDebugRuntimeChecks = false;
    private static boolean composeStackTraceEnabled = false;
    public static final int compositionLocalMapKey = 202;
    private static CompositionTracer compositionTracer = null;
    public static final int defaultsKey = -127;
    private static final int invalidGroupLocation = -2;
    public static final int invocationKey = 200;
    private static final int nodeKey = 125;
    public static final int providerKey = 201;
    public static final int providerMapsKey = 204;
    public static final int providerValuesKey = 203;
    public static final int referenceKey = 206;
    public static final int reuseKey = 207;
    private static final int rootKey = 100;
    private static final Object invocation = new OpaqueKey("provider");
    private static final Object provider = new OpaqueKey("provider");
    private static final Object compositionLocalMap = new OpaqueKey("compositionLocalMap");
    private static final Object providerValues = new OpaqueKey("providerValues");
    private static final Object providerMaps = new OpaqueKey("providers");
    private static final Object reference = new OpaqueKey(TypedValues.Custom.S_REFERENCE);
    private static final Comparator<Invalidation> InvalidationLocationAscending = new d();

    /* JADX INFO: Access modifiers changed from: private */
    public static final int InvalidationLocationAscending$lambda$13(Invalidation invalidation, Invalidation invalidation2) {
        return kotlin.jvm.internal.k.g(invalidation.getLocation(), invalidation2.getLocation());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean asBool(int i) {
        return i != 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int asInt(boolean z10) {
        return z10 ? 1 : 0;
    }

    @ComposeCompilerApi
    public static final <T> T cache(Composer composer, boolean z10, S7.a aVar) {
        T t9 = (T) composer.rememberedValue();
        if (!z10 && t9 != Composer.INSTANCE.getEmpty()) {
            return t9;
        }
        T t10 = (T) aVar.invoke();
        composer.updateRememberedValue(t10);
        return t10;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List<Object> collectNodesFrom(SlotTable slotTable, Anchor anchor) {
        ArrayList arrayList = new ArrayList();
        SlotReader slotReaderOpenReader = slotTable.openReader();
        try {
            collectNodesFrom$lambda$8$collectFromGroup(slotReaderOpenReader, arrayList, slotTable.anchorIndex(anchor));
            return arrayList;
        } finally {
            slotReaderOpenReader.close();
        }
    }

    private static final void collectNodesFrom$lambda$8$collectFromGroup(SlotReader slotReader, List<Object> list, int i) {
        if (slotReader.isNode(i)) {
            list.add(slotReader.node(i));
            return;
        }
        int iGroupSize = i + 1;
        int iGroupSize2 = slotReader.groupSize(i) + i;
        while (iGroupSize < iGroupSize2) {
            collectNodesFrom$lambda$8$collectFromGroup(slotReader, list, iGroupSize);
            iGroupSize += slotReader.groupSize(iGroupSize);
        }
    }

    public static final void composeImmediateRuntimeError(String str) {
        throw new ComposeRuntimeError(B7.a.m("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final Void composeRuntimeError(String str) {
        throw new ComposeRuntimeError(B7.a.m("Compose Runtime internal error. Unexpected or incorrect use of the Compose internal runtime API (", str, "). Please report to Google or use https://goo.gle/compose-feedback"));
    }

    public static final void deactivateCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        slotWriter.forAllDataInRememberOrder(slotWriter.getCurrentGroup(), new H4.l(2, rememberManager, slotWriter));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r deactivateCurrentGroup$lambda$3(RememberManager rememberManager, SlotWriter slotWriter, int i, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            rememberManager.deactivating((ComposeNodeLifecycleCallback) obj);
        } else if (obj instanceof RememberObserverHolder) {
            RememberObserverHolder rememberObserverHolder = (RememberObserverHolder) obj;
            if (!(rememberObserverHolder.getWrapped() instanceof ReusableRememberObserver)) {
                removeData(slotWriter, i, obj);
                rememberManager.forgetting(rememberObserverHolder);
            }
        } else if (obj instanceof RecomposeScopeImpl) {
            removeData(slotWriter, i, obj);
            ((RecomposeScopeImpl) obj).release();
        }
        return r.f317a;
    }

    public static final void debugRuntimeCheck(boolean z10) {
    }

    private static final int distanceFrom(SlotReader slotReader, int i, int i6) {
        int i10 = 0;
        while (i > 0 && i != i6) {
            i = slotReader.parent(i);
            i10++;
        }
        return i10;
    }

    public static final MovableContentState extractMovableContentAtCurrent(final ControlledComposition controlledComposition, final MovableContentStateReference movableContentStateReference, SlotWriter slotWriter, Applier<?> applier) {
        SlotTable slotTable = new SlotTable();
        if (slotWriter.getCollectingSourceInformation()) {
            slotTable.collectSourceInformation();
        }
        if (slotWriter.getCollectingCalledInformation()) {
            slotTable.collectCalledByInformation();
        }
        int currentGroup = slotWriter.getCurrentGroup();
        if (applier != null && slotWriter.nodeCount(currentGroup) > 0) {
            int parent = slotWriter.getParent();
            while (parent > 0 && !slotWriter.isNode(parent)) {
                parent = slotWriter.parent(parent);
            }
            if (parent >= 0 && slotWriter.isNode(parent)) {
                Object objNode = slotWriter.node(parent);
                int i = parent + 1;
                int iGroupSize = slotWriter.groupSize(parent) + parent;
                int iNodeCount = 0;
                while (i < iGroupSize) {
                    int iGroupSize2 = slotWriter.groupSize(i) + i;
                    if (iGroupSize2 > currentGroup) {
                        break;
                    }
                    iNodeCount += slotWriter.isNode(i) ? 1 : slotWriter.nodeCount(i);
                    i = iGroupSize2;
                }
                int iNodeCount2 = slotWriter.isNode(currentGroup) ? 1 : slotWriter.nodeCount(currentGroup);
                applier.down(objNode);
                applier.remove(iNodeCount, iNodeCount2);
                applier.up();
            }
        }
        SlotWriter slotWriterOpenWriter = slotTable.openWriter();
        try {
            slotWriterOpenWriter.beginInsert();
            slotWriterOpenWriter.startGroup(MovableContentKt.movableContentKey, movableContentStateReference.getContent$runtime());
            SlotWriter.markGroup$default(slotWriterOpenWriter, 0, 1, null);
            slotWriterOpenWriter.update(movableContentStateReference.getParameter());
            List<Anchor> listMoveTo = slotWriter.moveTo(movableContentStateReference.getAnchor(), 1, slotWriterOpenWriter);
            slotWriterOpenWriter.skipGroup();
            slotWriterOpenWriter.endGroup();
            slotWriterOpenWriter.endInsert();
            slotWriterOpenWriter.close(true);
            MovableContentState movableContentState = new MovableContentState(slotTable);
            RecomposeScopeImpl.Companion companion = RecomposeScopeImpl.INSTANCE;
            if (!companion.hasAnchoredRecomposeScopes$runtime(slotTable, listMoveTo)) {
                return movableContentState;
            }
            RecomposeScopeOwner recomposeScopeOwner = new RecomposeScopeOwner() { // from class: androidx.compose.runtime.ComposerKt$extractMovableContentAtCurrent$movableContentRecomposeScopeOwner$1
                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public InvalidationResult invalidate(RecomposeScopeImpl scope, Object instance) {
                    InvalidationResult invalidationResultInvalidate;
                    ControlledComposition controlledComposition2 = controlledComposition;
                    RecomposeScopeOwner recomposeScopeOwner2 = controlledComposition2 instanceof RecomposeScopeOwner ? (RecomposeScopeOwner) controlledComposition2 : null;
                    if (recomposeScopeOwner2 == null || (invalidationResultInvalidate = recomposeScopeOwner2.invalidate(scope, instance)) == null) {
                        invalidationResultInvalidate = InvalidationResult.IGNORED;
                    }
                    if (invalidationResultInvalidate != InvalidationResult.IGNORED) {
                        return invalidationResultInvalidate;
                    }
                    MovableContentStateReference movableContentStateReference2 = movableContentStateReference;
                    movableContentStateReference2.setInvalidations$runtime(v.R0(movableContentStateReference2.getInvalidations$runtime(), new Pair(scope, instance)));
                    return InvalidationResult.SCHEDULED;
                }

                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public void recomposeScopeReleased(RecomposeScopeImpl scope) {
                }

                @Override // androidx.compose.runtime.RecomposeScopeOwner
                public void recordReadOf(Object value) {
                }
            };
            slotWriterOpenWriter = slotTable.openWriter();
            try {
                companion.adoptAnchoredScopes$runtime(slotWriterOpenWriter, listMoveTo, recomposeScopeOwner);
                slotWriterOpenWriter.close(true);
                return movableContentState;
            } finally {
            }
        } finally {
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int findInsertLocation(List<Invalidation> list, int i) {
        int iFindLocation = findLocation(list, i);
        return iFindLocation < 0 ? -(iFindLocation + 1) : iFindLocation;
    }

    private static final int findLocation(List<Invalidation> list, int i) {
        int size = list.size() - 1;
        int i6 = 0;
        while (i6 <= size) {
            int i10 = (i6 + size) >>> 1;
            int iG = kotlin.jvm.internal.k.g(list.get(i10).getLocation(), i);
            if (iG < 0) {
                i6 = i10 + 1;
            } else {
                if (iG <= 0) {
                    return i10;
                }
                size = i10 - 1;
            }
        }
        return -(i6 + 1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation firstInRange(List<Invalidation> list, int i, int i6) {
        int iFindInsertLocation = findInsertLocation(list, i);
        if (iFindInsertLocation >= list.size()) {
            return null;
        }
        Invalidation invalidation = list.get(iFindInsertLocation);
        if (invalidation.getLocation() < i6) {
            return invalidation;
        }
        return null;
    }

    private static final void forEachInRange(List<Invalidation> list, int i, int i6, S7.k kVar) {
        for (int iFindInsertLocation = findInsertLocation(list, i); iFindInsertLocation < list.size(); iFindInsertLocation++) {
            Invalidation invalidation = list.get(iFindInsertLocation);
            if (invalidation.getLocation() >= i6) {
                return;
            }
            kVar.invoke(invalidation);
        }
    }

    public static final boolean getComposeStackTraceEnabled() {
        return composeStackTraceEnabled;
    }

    public static final Object getCompositionLocalMap() {
        return compositionLocalMap;
    }

    public static /* synthetic */ void getCompositionLocalMap$annotations() {
    }

    public static /* synthetic */ void getCompositionLocalMapKey$annotations() {
    }

    private static /* synthetic */ void getCompositionTracer$annotations() {
    }

    public static final Object getInvocation() {
        return invocation;
    }

    public static /* synthetic */ void getInvocation$annotations() {
    }

    public static /* synthetic */ void getInvocationKey$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getJoinedKey(KeyInfo keyInfo) {
        return keyInfo.getObjectKey() != null ? new JoinedKey(Integer.valueOf(keyInfo.getKey()), keyInfo.getObjectKey()) : Integer.valueOf(keyInfo.getKey());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object getKey(Object obj, Object obj2, Object obj3) {
        JoinedKey joinedKey = obj instanceof JoinedKey ? (JoinedKey) obj : null;
        if (joinedKey == null) {
            return null;
        }
        if (kotlin.jvm.internal.k.b(joinedKey.getLeft(), obj2) && kotlin.jvm.internal.k.b(joinedKey.getRight(), obj3)) {
            return obj;
        }
        Object key = getKey(joinedKey.getLeft(), obj2, obj3);
        return key == null ? getKey(joinedKey.getRight(), obj2, obj3) : key;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int getNextGroup(SlotWriter slotWriter) {
        return slotWriter.groupSize(slotWriter.getCurrentGroup()) + slotWriter.getCurrentGroup();
    }

    public static final Object getProvider() {
        return provider;
    }

    public static /* synthetic */ void getProvider$annotations() {
    }

    public static /* synthetic */ void getProviderKey$annotations() {
    }

    public static final Object getProviderMaps() {
        return providerMaps;
    }

    public static /* synthetic */ void getProviderMaps$annotations() {
    }

    public static /* synthetic */ void getProviderMapsKey$annotations() {
    }

    public static final Object getProviderValues() {
        return providerValues;
    }

    public static /* synthetic */ void getProviderValues$annotations() {
    }

    public static /* synthetic */ void getProviderValuesKey$annotations() {
    }

    public static final Object getReference() {
        return reference;
    }

    public static /* synthetic */ void getReference$annotations() {
    }

    public static /* synthetic */ void getReferenceKey$annotations() {
    }

    public static /* synthetic */ void getReuseKey$annotations() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void insertIfMissing(List<Invalidation> list, int i, RecomposeScopeImpl recomposeScopeImpl, Object obj) {
        int iFindLocation = findLocation(list, i);
        if (iFindLocation < 0) {
            int i6 = -(iFindLocation + 1);
            if (!(obj instanceof DerivedState)) {
                obj = null;
            }
            list.add(i6, new Invalidation(recomposeScopeImpl, i, obj));
            return;
        }
        Invalidation invalidation = list.get(iFindLocation);
        if (!(obj instanceof DerivedState)) {
            invalidation.setInstances(null);
            return;
        }
        Object instances = invalidation.getInstances();
        if (instances == null) {
            invalidation.setInstances(obj);
        } else if (instances instanceof MutableScatterSet) {
            ((MutableScatterSet) instances).add(obj);
        } else {
            invalidation.setInstances(ScatterSetKt.mutableScatterSetOf(instances, obj));
        }
    }

    public static final boolean isAfterFirstChild(SlotWriter slotWriter) {
        return slotWriter.getCurrentGroup() > slotWriter.getParent() + 1;
    }

    @ComposeCompilerApi
    public static final boolean isTraceInProgress() {
        CompositionTracer compositionTracer2 = compositionTracer;
        return compositionTracer2 != null && compositionTracer2.isTraceInProgress();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final <K, V> MutableScatterMap<Object, Object> multiMap(int i) {
        return MultiValueMap.m3552constructorimpl(new MutableScatterMap(i));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int nearestCommonRootOf(SlotReader slotReader, int i, int i6, int i10) {
        if (i != i6) {
            if (i == i10 || i6 == i10) {
                return i10;
            }
            if (slotReader.parent(i) == i6) {
                return i6;
            }
            if (slotReader.parent(i6) != i) {
                if (slotReader.parent(i) == slotReader.parent(i6)) {
                    return slotReader.parent(i);
                }
                int iDistanceFrom = distanceFrom(slotReader, i, i10);
                int iDistanceFrom2 = distanceFrom(slotReader, i6, i10);
                int i11 = iDistanceFrom - iDistanceFrom2;
                for (int i12 = 0; i12 < i11; i12++) {
                    i = slotReader.parent(i);
                }
                int i13 = iDistanceFrom2 - iDistanceFrom;
                for (int i14 = 0; i14 < i13; i14++) {
                    i6 = slotReader.parent(i6);
                }
                while (i != i6) {
                    i = slotReader.parent(i);
                    i6 = slotReader.parent(i6);
                }
                return i;
            }
        }
        return i;
    }

    public static final void removeCurrentGroup(SlotWriter slotWriter, RememberManager rememberManager) {
        slotWriter.forAllDataInRememberOrder(slotWriter.getCurrentGroup(), new j(rememberManager, 2));
        slotWriter.removeGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final r removeCurrentGroup$lambda$2(RememberManager rememberManager, int i, Object obj) {
        if (obj instanceof ComposeNodeLifecycleCallback) {
            rememberManager.releasing((ComposeNodeLifecycleCallback) obj);
        }
        if (obj instanceof RememberObserverHolder) {
            rememberManager.forgetting((RememberObserverHolder) obj);
        }
        if (obj instanceof RecomposeScopeImpl) {
            ((RecomposeScopeImpl) obj).release();
        }
        return r.f317a;
    }

    private static final void removeData(SlotWriter slotWriter, int i, Object obj) {
        Object objClear = slotWriter.clear(i);
        if (obj == objClear) {
            return;
        }
        composeImmediateRuntimeError("Slot table is out of sync (expected " + obj + ", got " + objClear + ')');
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Invalidation removeLocation(List<Invalidation> list, int i) {
        int iFindLocation = findLocation(list, i);
        if (iFindLocation >= 0) {
            return list.remove(iFindLocation);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void removeRange(List<Invalidation> list, int i, int i6) {
        int iFindInsertLocation = findInsertLocation(list, i);
        while (iFindInsertLocation < list.size() && list.get(iFindInsertLocation).getLocation() < i6) {
            list.remove(iFindInsertLocation);
        }
    }

    public static final void runtimeCheck(boolean z10, S7.a aVar) {
        if (z10) {
            return;
        }
        composeImmediateRuntimeError((String) aVar.invoke());
    }

    public static final void setComposeStackTraceEnabled(boolean z10) {
        composeStackTraceEnabled = z10;
    }

    @ComposeCompilerApi
    public static final void sourceInformation(Composer composer, String str) {
        composer.sourceInformation(str);
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerEnd(Composer composer) {
        composer.sourceInformationMarkerEnd();
    }

    @ComposeCompilerApi
    public static final void sourceInformationMarkerStart(Composer composer, int i, String str) {
        composer.sourceInformationMarkerStart(i, str);
    }

    @ComposeCompilerApi
    public static final void traceEventEnd() {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventEnd();
        }
    }

    public static final <R> void withAfterAnchorInfo(SlotWriter slotWriter, Anchor anchor, n nVar) {
        int iAnchorIndex;
        int slotsSize;
        if (anchor == null || !anchor.getValid()) {
            iAnchorIndex = -1;
            slotsSize = -1;
        } else {
            iAnchorIndex = slotWriter.anchorIndex(anchor);
            slotsSize = slotWriter.getSlotsSize() - slotWriter.slotsEndAllIndex$runtime(iAnchorIndex);
        }
        nVar.invoke(Integer.valueOf(iAnchorIndex), Integer.valueOf(slotsSize));
    }

    public static final void debugRuntimeCheck(boolean z10, S7.a aVar) {
    }

    public static final boolean isAfterFirstChild(SlotReader slotReader) {
        return slotReader.getCurrentGroup() > slotReader.getParent() + 1;
    }

    public static final void runtimeCheck(boolean z10) {
        if (z10) {
            return;
        }
        composeImmediateRuntimeError("Check failed");
    }

    @ComposeCompilerApi
    public static final void traceEventStart(int i, int i6, int i10, String str) {
        CompositionTracer compositionTracer2 = compositionTracer;
        if (compositionTracer2 != null) {
            compositionTracer2.traceEventStart(i, i6, i10, str);
        }
    }
}
