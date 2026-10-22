package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.ss.android.socialbase.downloader.constants.MonitorConstants;
import com.ss.bytertc.base.media.screen.RXScreenCaptureService;
import faceverify.w;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b-\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0001\u0018\u0000 ~*\u0004\b\u0000\u0010\u0001*\u0004\b\u0001\u0010\u00022\u00020\u0003:\u0002}~B1\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0004\b\u000b\u0010\fB)\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b¢\u0006\u0004\b\u000b\u0010\rJ\u0014\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0002J\u0014\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u000fH\u0002J\r\u0010\u0015\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0016J\u0015\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001aJ\u0010\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001dJ\u0015\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u001fJ\u0015\u0010 \u001a\u00028\u00002\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\"J\u0015\u0010#\u001a\u00028\u00012\u0006\u0010!\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010\"J!\u0010$\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u0005H\u0000¢\u0006\u0002\b%J1\u0010&\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010(J9\u0010)\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010*\u001a\u00020\nH\u0002¢\u0006\u0002\u0010+J)\u0010,\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010-J=\u0010.\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00028\u00012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u00101J8\u00102\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J8\u00104\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0012\u00103\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010*\u001a\u00020\nH\u0002J&\u00105\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J.\u00106\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\nH\u0002JO\u00107\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010<JI\u0010=\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u0005H\u0002¢\u0006\u0002\u0010>JQ\u0010?\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u00108\u001a\u00020\u00052\u0006\u00109\u001a\u00028\u00002\u0006\u0010:\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\nH\u0002¢\u0006\u0002\u0010@J[\u0010A\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010B\u001a\u00020\u00052\u0006\u0010C\u001a\u00028\u00002\u0006\u0010D\u001a\u00028\u00012\u0006\u0010E\u001a\u00020\u00052\u0006\u0010F\u001a\u00028\u00002\u0006\u0010G\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u00052\b\u0010*\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0002\u0010HJ&\u0010I\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002J:\u0010J\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010!\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\u001e\u0010K\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010L\u001a\u00020\u0005H\u0002J2\u0010M\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010L\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\u0015\u0010N\u001a\u00020\u00182\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010OJ\u0017\u0010P\u001a\u0004\u0018\u00018\u00012\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010QJ+\u0010R\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010SJ=\u0010T\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010UJ#\u0010V\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010WJ7\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010YJ+\u0010V\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u0001H\u0002¢\u0006\u0002\u0010ZJ?\u0010X\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002¢\u0006\u0002\u0010UJ8\u0010[\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010]\u001a\u00020^2\u0006\u0010*\u001a\u00020\nH\u0002JT\u0010_\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u00052\u0006\u0010]\u001a\u00020^2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100H\u0002J\b\u0010`\u001a\u00020\u0005H\u0002J\u001c\u0010a\u001a\u00020\u00182\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000H\u0002J#\u0010b\u001a\u00020\u00182\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\u0005¢\u0006\u0002\u0010dJ%\u0010e\u001a\u0004\u0018\u00018\u00012\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\u0005¢\u0006\u0002\u0010fJJ\u0010g\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\\\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010;\u001a\u00020\u00052\u0006\u0010]\u001a\u00020^2\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100J9\u0010h\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u0005¢\u0006\u0002\u0010iJK\u0010j\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010kJ1\u0010l\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\u0005¢\u0006\u0002\u0010mJP\u0010n\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u0005H\u0002JE\u0010p\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010;\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010qJX\u0010r\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0012\u0010o\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010\u001e\u001a\u00020\u00052\u0006\u0010\u0019\u001a\u00020\u00052\u0006\u0010*\u001a\u00020\nH\u0002J9\u0010l\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u0005¢\u0006\u0002\u0010sJM\u0010p\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00002\u0006\u0010c\u001a\u00020\u00052\u0006\u0010'\u001a\u00028\u00002\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010;\u001a\u00020\u00052\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u000100¢\u0006\u0002\u0010kJ\u0091\u0001\u0010t\u001a\u00020u2\u0081\u0001\u0010v\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(z\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b({\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020u0wH\u0000¢\u0006\u0002\b|J\u009c\u0001\u0010t\u001a\u00020u2\u0081\u0001\u0010v\u001a}\u0012\u001f\u0012\u001d\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0000¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(z\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(;\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b({\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0004\u0012\u0013\u0012\u00110\u0005¢\u0006\f\bx\u0012\b\by\u0012\u0004\b\b(\u0006\u0012\u0004\u0012\u00020u0w2\u0006\u0010{\u001a\u00020\u00052\u0006\u0010;\u001a\u00020\u0005H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R0\u0010\u0007\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b2\u000e\u0010\u0011\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030\b@BX\u0080\u000e¢\u0006\n\n\u0002\u0010\u0014\u001a\u0004\b\u0012\u0010\u0013¨\u0006\u007f"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "K", "V", "", "dataMap", "", "nodeMap", "buffer", "", "ownedBy", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;", "<init>", "(II[Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)V", "(II[Ljava/lang/Object;)V", "asInsertResult", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "asUpdateResult", "value", "getBuffer$runtime", "()[Ljava/lang/Object;", "[Ljava/lang/Object;", "entryCount", "entryCount$runtime", "hasEntryAt", "", "positionMask", "hasEntryAt$runtime", "hasNodeAt", "entryKeyIndex", "entryKeyIndex$runtime", "nodeIndex", "nodeIndex$runtime", "keyAtIndex", "keyIndex", "(I)Ljava/lang/Object;", "valueAtKeyIndex", "nodeAtIndex", "nodeAtIndex$runtime", "insertEntryAt", "key", "(ILjava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableInsertEntryAt", "owner", "(ILjava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "updateValueAtIndex", "(ILjava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableUpdateValueAtIndex", "mutator", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;", "(ILjava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "updateNodeAtIndex", "newNode", "mutableUpdateNodeAtIndex", "removeNodeAtIndex", "mutableRemoveNodeAtIndex", "bufferMoveEntryToNode", "newKeyHash", "newKey", "newValue", "shift", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)[Ljava/lang/Object;", "moveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableMoveEntryToNode", "(IIILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "makeNode", "keyHash1", "key1", "value1", "keyHash2", "key2", "value2", "(ILjava/lang/Object;Ljava/lang/Object;ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/internal/MutabilityOwnership;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "removeEntryAtIndex", "mutableRemoveEntryAtIndex", "collisionRemoveEntryAtIndex", RXScreenCaptureService.KEY_INDEX, "mutableCollisionRemoveEntryAtIndex", "collisionContainsKey", "(Ljava/lang/Object;)Z", "collisionGet", "(Ljava/lang/Object;)Ljava/lang/Object;", "collisionPut", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "mutableCollisionPut", "(Ljava/lang/Object;Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "collisionRemove", "(Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionRemove", "(Ljava/lang/Object;Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "(Ljava/lang/Object;Ljava/lang/Object;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableCollisionPutAll", "otherNode", "intersectionCounter", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/internal/DeltaCounter;", "mutablePutAllFromOtherNodeCell", "calculateSize", "elementsIdentityEquals", "containsKey", "keyHash", "(ILjava/lang/Object;I)Z", MonitorConstants.CONNECT_TYPE_GET, "(ILjava/lang/Object;I)Ljava/lang/Object;", "mutablePutAll", "put", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "mutablePut", "(ILjava/lang/Object;Ljava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "remove", "(ILjava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "replaceNode", "targetNode", "mutableRemove", "(ILjava/lang/Object;ILandroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/PersistentHashMapBuilder;)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "mutableReplaceNode", "(ILjava/lang/Object;Ljava/lang/Object;I)Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "accept", "", "visitor", "Lkotlin/Function5;", "Lkotlin/ParameterName;", "name", "node", w.BLOB_ELEM_IMAGE_HASHCODE, "accept$runtime", "ModificationResult", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TrieNode<K, V> {
    public static final int $stable = 0;
    public static final Companion Companion = null;
    private static final TrieNode EMPTY = null;
    private Object[] buffer;
    private int dataMap;
    private int nodeMap;
    private final MutabilityOwnership ownedBy;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0001\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R \u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$Companion;", "", "<init>", "()V", "EMPTY", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "", "getEMPTY$runtime", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public final TrieNode getEMPTY$runtime() {
            return TrieNode.access$getEMPTY$cp();
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u00020\u0003B#\u0012\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJA\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00002*\u0010\u0011\u001a&\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u00050\u0012H\u0086\bR&\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00028\u0002\u0012\u0004\u0012\u00028\u00030\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0013"}, d2 = {"Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode$ModificationResult;", "K", "V", "", "node", "Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "sizeDelta", "", "<init>", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;I)V", "getNode", "()Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;", "setNode", "(Landroidx/compose/runtime/external/kotlinx/collections/immutable/implementations/immutableMap/TrieNode;)V", "getSizeDelta", "()I", "replaceNode", WikiFolderPushPlugin.OPT, "Lkotlin/Function1;", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ModificationResult<K, V> {
        public static final int $stable = 8;
        private TrieNode<K, V> node;
        private final int sizeDelta;

        public final TrieNode<K, V> getNode() {
            return this.node;
        }

        public final int getSizeDelta() {
            return this.sizeDelta;
        }

        public final ModificationResult<K, V> replaceNode(Function1<? super TrieNode<K, V>, TrieNode<K, V>> r100) {
            setNode(r100.invoke(getNode()));
            return this;
        }

        public final void setNode(TrieNode<K, V> r100) {
            this.node = r100;
        }

        public ModificationResult(TrieNode<K, V> r100, int r101) {
            this.node = r100;
            this.sizeDelta = r101;
        }
    }

    static {
        Companion = new Companion(null);
        $stable = 8;
        EMPTY = new TrieNode(0, 0, new Object[0]);
    }

    private final ModificationResult<K, V> asInsertResult() {
        return new ModificationResult(this, 1);
    }

    private final ModificationResult<K, V> asUpdateResult() {
        return new ModificationResult(this, 0);
    }

    private final int calculateSize() {
        if (this.nodeMap == 0) goto L5;
        int r100 = Integer.bitCount(this.dataMap);
        int r101 = r100 * 2;
        int r102 = this.buffer.length;
    L7:
        if (r101 >= r102) goto L9;
        r100 = r100 + nodeAtIndex$runtime(r101).calculateSize();
        r101 = r101 + 1;
        goto L7
    L9:
        return r100;
    L5:
        return this.buffer.length / 2;
    }

    public final int entryCount$runtime() {
        return Integer.bitCount(this.dataMap);
    }

    public static final /* synthetic */ TrieNode access$getEMPTY$cp() {
        return EMPTY;
    }

    public final Object[] getBuffer$runtime() {
        return this.buffer;
    }

    private final boolean collisionContainsKey(K r100) {
        IntProgression r101 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        int r104 = r101.getStep();
        if (r104 <= 0) goto L5;
        if (r102 > r103) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, this.buffer[r102]) == true) goto L9;
        if (r102 == r103) goto L13;
        r102 = r102 + r104;
    L13:
        return false;
    L9:
        return true;
    L5:
        if (r104 >= 0) goto L13;
        if (r103 > r102) goto L13;
        goto L13
    }

    private final V collisionGet(K r100) {
        IntProgression r101 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        int r104 = r101.getStep();
        if (r104 <= 0) goto L5;
        if (r102 > r103) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, keyAtIndex(r102)) == true) goto L10;
        if (r102 == r103) goto L19;
        r102 = r102 + r104;
        goto L8
    L19:
        return null;
    L10:
        return valueAtKeyIndex(r102);
    L5:
        if (r104 >= 0) goto L13;
        if (r103 <= r102) goto L8;
        return null;
    L13:
        return null;
    }

    private final TrieNode<K, V> collisionRemove(K r100) {
        IntProgression r101 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r102 = r101.getFirst();
        int r103 = r101.getLast();
        int r104 = r101.getStep();
        if (r104 <= 0) goto L5;
        if (r102 > r103) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, keyAtIndex(r102)) == true) goto L10;
        if (r102 == r103) goto L13;
        r102 = r102 + r104;
    L13:
        return this;
    L10:
        return collisionRemoveEntryAtIndex(r102);
    L5:
        if (r104 >= 0) goto L13;
        if (r103 > r102) goto L13;
        goto L13
    }

    private final TrieNode<K, V> collisionRemoveEntryAtIndex(int r100) {
        Object[] r101 = this.buffer;
        if (r101.length != 2) goto L7;
        return null;
    L7:
        return new TrieNode(0, 0, TrieNodeKt.access$removeEntryAtIndex(r101, r100));
    }

    private final boolean elementsIdentityEquals(TrieNode<K, V> r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (this.nodeMap == r100.nodeMap) goto L9;
        return false;
    L9:
        if (this.dataMap == r100.dataMap) goto L11;
        return false;
    L11:
        int r101 = this.buffer.length;
        int r102 = 0;
    L12:
        if (r102 >= r101) goto L17;
        if (this.buffer[r102] != r100.buffer[r102]) goto L15;
        r102 = r102 + 1;
        goto L12
    L15:
        return false;
    L17:
        return true;
    }

    private final boolean hasNodeAt(int r100) {
        if ((r100 & this.nodeMap) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final K keyAtIndex(int r100) {
        return (K) this.buffer[r100];
    }

    private final V valueAtKeyIndex(int r100) {
        return (V) this.buffer[r100 + 1];
    }

    public final void accept$runtime(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r100) {
        accept(r100, 0, 0);
    }

    public final int entryKeyIndex$runtime(int r100) {
        return Integer.bitCount((r100 - 1) & this.dataMap) * 2;
    }

    public final boolean hasEntryAt$runtime(int r100) {
        if ((r100 & this.dataMap) == 0) goto L5;
        return true;
    L5:
        return false;
    }

    public final TrieNode<K, V> nodeAtIndex$runtime(int r100) {
        Object r101 = this.buffer[r100];
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) r101;
    }

    public final int nodeIndex$runtime(int r100) {
        return (this.buffer.length - 1) - Integer.bitCount((r100 - 1) & this.nodeMap);
    }

    private final ModificationResult<K, V> collisionPut(K r100, V r101) {
        IntProgression r102 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r103 = r102.getFirst();
        int r104 = r102.getLast();
        int r105 = r102.getStep();
        if (r105 <= 0) goto L5;
        if (r103 > r104) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, keyAtIndex(r103)) == true) goto L10;
        if (r103 == r104) goto L18;
        r103 = r103 + r105;
    L18:
        return new TrieNode(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, r100, r101)).asInsertResult();
    L10:
        if (r101 != valueAtKeyIndex(r103)) goto L13;
        return null;
    L13:
        Object[] r106 = this.buffer;
        Object[] r107 = Arrays.copyOf(r106, r106.length);
        r107[r103 + 1] = r101;
        return new TrieNode(0, 0, r107).asUpdateResult();
    L5:
        if (r105 >= 0) goto L18;
        if (r104 > r103) goto L18;
        goto L8
    }

    private final TrieNode<K, V> collisionRemove(K r100, V r101) {
        IntProgression r102 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r103 = r102.getFirst();
        int r104 = r102.getLast();
        int r105 = r102.getStep();
        if (r105 <= 0) goto L5;
        if (r103 > r104) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, keyAtIndex(r103)) == true) goto L10;
    L13:
        if (r103 == r104) goto L15;
        r103 = r103 + r105;
    L15:
        return this;
    L10:
        if (Intrinsics.areEqual(r101, valueAtKeyIndex(r103)) == false) goto L13;
        return collisionRemoveEntryAtIndex(r103);
    L5:
        if (r105 >= 0) goto L15;
        if (r104 > r103) goto L15;
        goto L15
    }

    private final TrieNode<K, V> mutableCollisionRemove(K r100, PersistentHashMapBuilder<K, V> r101) {
        IntProgression r102 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r103 = r102.getFirst();
        int r104 = r102.getLast();
        int r105 = r102.getStep();
        if (r105 <= 0) goto L5;
        if (r103 > r104) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, keyAtIndex(r103)) == true) goto L10;
        if (r103 == r104) goto L13;
        r103 = r103 + r105;
    L13:
        return this;
    L10:
        return mutableCollisionRemoveEntryAtIndex(r103, r101);
    L5:
        if (r105 >= 0) goto L13;
        if (r104 > r103) goto L13;
        goto L13
    }

    private final TrieNode<K, V> mutableCollisionRemoveEntryAtIndex(int r100, PersistentHashMapBuilder<K, V> r101) {
        r101.setSize(r101.size() - 1);
        r101.setOperationResult$runtime(valueAtKeyIndex(r100));
        if (this.buffer.length != 2) goto L7;
        return null;
    L7:
        if (this.ownedBy != r101.getOwnership()) goto L11;
        this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, r100);
        return this;
    L11:
        return new TrieNode(0, 0, TrieNodeKt.access$removeEntryAtIndex(this.buffer, r100), r101.getOwnership());
    }

    private final TrieNode<K, V> removeEntryAtIndex(int r100, int r101) {
        Object[] r102 = this.buffer;
        if (r102.length != 2) goto L6;
        return null;
    L6:
        Object[] r103 = TrieNodeKt.access$removeEntryAtIndex(r102, r100);
        return new TrieNode(r101 ^ this.dataMap, this.nodeMap, r103);
    }

    private final TrieNode<K, V> removeNodeAtIndex(int r100, int r101) {
        Object[] r102 = this.buffer;
        if (r102.length != 1) goto L6;
        return null;
    L6:
        Object[] r103 = TrieNodeKt.access$removeNodeAtIndex(r102, r100);
        return new TrieNode(this.dataMap, r101 ^ this.nodeMap, r103);
    }

    private final TrieNode<K, V> updateValueAtIndex(int r100, V r101) {
        Object[] r102 = this.buffer;
        Object[] r103 = Arrays.copyOf(r102, r102.length);
        r103[r100 + 1] = r101;
        return new TrieNode(this.dataMap, this.nodeMap, r103);
    }

    public TrieNode(int r100, int r101, Object[] r102) {
        this(r100, r101, r102, null);
    }

    private final void accept(Function5<? super TrieNode<K, V>, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r100, int r101, int r102) {
        r100.invoke(this, Integer.valueOf(r102), Integer.valueOf(r101), Integer.valueOf(this.dataMap), Integer.valueOf(this.nodeMap));
        int r103 = this.nodeMap;
    L3:
        if (r103 == 0) goto L5;
        int r104 = Integer.lowestOneBit(r103);
        int r105 = Integer.numberOfTrailingZeros(r104);
        nodeAtIndex$runtime(nodeIndex$runtime(r104)).accept(r100, (r105 << r102) + r101, r102 + 5);
        r103 = r103 - r104;
        goto L3
    }

    private final TrieNode<K, V> insertEntryAt(int r100, K r101, V r102) {
        int r103 = entryKeyIndex$runtime(r100);
        Object[] r104 = TrieNodeKt.access$insertEntryAtIndex(this.buffer, r103, r101, r102);
        return new TrieNode(r100 | this.dataMap, this.nodeMap, r104);
    }

    private final TrieNode<K, V> mutableCollisionPut(K r100, V r101, PersistentHashMapBuilder<K, V> r102) {
        IntProgression r103 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r104 = r103.getFirst();
        int r105 = r103.getLast();
        int r106 = r103.getStep();
        if (r106 <= 0) goto L5;
        if (r104 > r105) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, keyAtIndex(r104)) == true) goto L9;
        if (r104 == r105) goto L17;
        r104 = r104 + r106;
    L17:
        r102.setSize(r102.size() + 1);
        return new TrieNode(0, 0, TrieNodeKt.access$insertEntryAtIndex(this.buffer, 0, r100, r101), r102.getOwnership());
    L9:
        r102.setOperationResult$runtime(valueAtKeyIndex(r104));
        if (this.ownedBy != r102.getOwnership()) goto L13;
        this.buffer[r104 + 1] = r101;
        return this;
    L13:
        r102.setModCount$runtime(r102.getModCount$runtime() + 1);
        Object[] r107 = this.buffer;
        Object[] r108 = Arrays.copyOf(r107, r107.length);
        r108[r104 + 1] = r101;
        return new TrieNode(0, 0, r108, r102.getOwnership());
    L5:
        if (r106 >= 0) goto L17;
        if (r105 > r104) goto L17;
        goto L17
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final TrieNode<K, V> mutableCollisionPutAll(TrieNode<K, V> r110, DeltaCounter r111, MutabilityOwnership r112) {
        if (this.nodeMap != 0) goto L5;
        boolean r100 = true;
    L6:
        CommonFunctionsKt.m4281assert(r100);
        if (this.dataMap != 0) goto L9;
        boolean r101 = true;
    L10:
        CommonFunctionsKt.m4281assert(r101);
        if (r110.nodeMap != 0) goto L13;
        boolean r102 = true;
    L14:
        CommonFunctionsKt.m4281assert(r102);
        if (r110.dataMap != 0) goto L17;
        boolean r103 = true;
    L18:
        CommonFunctionsKt.m4281assert(r103);
        Object[] r104 = this.buffer;
        Object[] r105 = Arrays.copyOf(r104, r104.length + r110.buffer.length);
        int r106 = this.buffer.length;
        IntProgression r107 = RangesKt.step(RangesKt.until(0, r110.buffer.length), 2);
        int r108 = r107.getFirst();
        int r109 = r107.getLast();
        int r113 = r107.getStep();
        if (r113 <= 0) goto L21;
        if (r108 > r109) goto L21;
    L24:
        if (collisionContainsKey(r110.buffer[r108]) == true) goto L26;
        Object[] r114 = r110.buffer;
        r105[r106] = r114[r108];
        r105[r106 + 1] = r114[r108 + 1];
        r106 = r106 + 2;
    L27:
        if (r108 == r109) goto L30;
        r108 = r108 + r113;
    L30:
        if (r106 != this.buffer.length) goto L33;
        return this;
    L33:
        if (r106 != r110.buffer.length) goto L36;
        return r110;
    L36:
        if (r106 != r105.length) goto L39;
        return new TrieNode(0, 0, r105, r112);
    L39:
        return new TrieNode(0, 0, Arrays.copyOf(r105, r106), r112);
    L26:
        r111.setCount(r111.getCount() + 1);
    L21:
        if (r113 >= 0) goto L30;
        if (r109 > r108) goto L30;
    L17:
        r103 = false;
        goto L18
    L13:
        r102 = false;
        goto L14
    L9:
        r101 = false;
        goto L10
    L5:
        r100 = false;
        goto L6
    }

    private final TrieNode<K, V> mutableCollisionRemove(K r100, V r101, PersistentHashMapBuilder<K, V> r102) {
        IntProgression r103 = RangesKt.step(RangesKt.until(0, this.buffer.length), 2);
        int r104 = r103.getFirst();
        int r105 = r103.getLast();
        int r106 = r103.getStep();
        if (r106 <= 0) goto L5;
        if (r104 > r105) goto L5;
    L8:
        if (Intrinsics.areEqual(r100, keyAtIndex(r104)) == true) goto L10;
    L13:
        if (r104 == r105) goto L15;
        r104 = r104 + r106;
    L15:
        return this;
    L10:
        if (Intrinsics.areEqual(r101, valueAtKeyIndex(r104)) == false) goto L13;
        return mutableCollisionRemoveEntryAtIndex(r104, r102);
    L5:
        if (r106 >= 0) goto L15;
        if (r105 > r104) goto L15;
        goto L15
    }

    private final TrieNode<K, V> mutableRemoveEntryAtIndex(int r100, int r101, PersistentHashMapBuilder<K, V> r102) {
        r102.setSize(r102.size() - 1);
        r102.setOperationResult$runtime(valueAtKeyIndex(r100));
        if (this.buffer.length != 2) goto L7;
        return null;
    L7:
        if (this.ownedBy != r102.getOwnership()) goto L11;
        this.buffer = TrieNodeKt.access$removeEntryAtIndex(this.buffer, r100);
        this.dataMap ^= r101;
        return this;
    L11:
        return new TrieNode(r101 ^ this.dataMap, this.nodeMap, TrieNodeKt.access$removeEntryAtIndex(this.buffer, r100), r102.getOwnership());
    }

    private final TrieNode<K, V> mutableRemoveNodeAtIndex(int r100, int r101, MutabilityOwnership r102) {
        Object[] r103 = this.buffer;
        if (r103.length != 1) goto L7;
        return null;
    L7:
        if (this.ownedBy != r102) goto L11;
        this.buffer = TrieNodeKt.access$removeNodeAtIndex(r103, r100);
        this.nodeMap ^= r101;
        return this;
    L11:
        return new TrieNode(this.dataMap, r101 ^ this.nodeMap, TrieNodeKt.access$removeNodeAtIndex(r103, r100), r102);
    }

    private final TrieNode<K, V> mutableUpdateNodeAtIndex(int r100, TrieNode<K, V> r101, MutabilityOwnership r102) {
        Object[] r103 = this.buffer;
        if (r103.length != 1) goto L11;
        if (r101.buffer.length != 2) goto L11;
        if (r101.nodeMap != 0) goto L11;
        r101.dataMap = this.nodeMap;
        return r101;
    L11:
        if (this.ownedBy != r102) goto L14;
        r103[r100] = r101;
        return this;
    L14:
        Object[] r104 = Arrays.copyOf(r103, r103.length);
        r104[r100] = r101;
        return new TrieNode(this.dataMap, this.nodeMap, r104, r102);
    }

    private final TrieNode<K, V> mutableUpdateValueAtIndex(int r100, V r101, PersistentHashMapBuilder<K, V> r102) {
        if (this.ownedBy != r102.getOwnership()) goto L6;
        this.buffer[r100 + 1] = r101;
        return this;
    L6:
        r102.setModCount$runtime(r102.getModCount$runtime() + 1);
        Object[] r103 = this.buffer;
        Object[] r104 = Arrays.copyOf(r103, r103.length);
        r104[r100 + 1] = r101;
        return new TrieNode(this.dataMap, this.nodeMap, r104, r102.getOwnership());
    }

    private final TrieNode<K, V> updateNodeAtIndex(int r100, int r101, TrieNode<K, V> r102) {
        Object[] r103 = r102.buffer;
        if (r103.length == 2) goto L5;
    L12:
        Object[] r104 = this.buffer;
        Object[] r105 = Arrays.copyOf(r104, r104.length);
        r105[r100] = r102;
        return new TrieNode(this.dataMap, this.nodeMap, r105);
    L5:
        if (r102.nodeMap != 0) goto L12;
        if (this.buffer.length != 1) goto L10;
        r102.dataMap = this.nodeMap;
        return r102;
    L10:
        int r106 = entryKeyIndex$runtime(r101);
        Object[] r107 = TrieNodeKt.access$replaceNodeWithEntry(this.buffer, r100, r106, r103[0], r103[1]);
        return new TrieNode(this.dataMap ^ r101, r101 ^ this.nodeMap, r107);
    }

    public final boolean containsKey(int r100, K r101, int r102) {
        int r103 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasEntryAt$runtime(r103) == false) goto L7;
        return Intrinsics.areEqual(r101, keyAtIndex(entryKeyIndex$runtime(r103)));
    L7:
        if (hasNodeAt(r103) == false) goto L14;
        TrieNode<K, V> r104 = nodeAtIndex$runtime(nodeIndex$runtime(r103));
        if (r102 != 30) goto L13;
        return r104.collisionContainsKey(r101);
    L13:
        return r104.containsKey(r100, r101, r102 + 5);
    L14:
        return false;
    }

    public final V get(int r100, K r101, int r102) {
        int r103 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasEntryAt$runtime(r103) == false) goto L10;
        int r104 = entryKeyIndex$runtime(r103);
        if (Intrinsics.areEqual(r101, keyAtIndex(r104)) == true) goto L7;
        return null;
    L7:
        return valueAtKeyIndex(r104);
    L10:
        if (hasNodeAt(r103) == false) goto L17;
        TrieNode<K, V> r105 = nodeAtIndex$runtime(nodeIndex$runtime(r103));
        if (r102 != 30) goto L16;
        return r105.collisionGet(r101);
    L16:
        return r105.get(r100, r101, r102 + 5);
    L17:
        return null;
    }

    public final TrieNode<K, V> remove(int r100, K r101, int r102) {
        int r103 = 1 << TrieNodeKt.indexSegment(r100, r102);
        if (hasEntryAt$runtime(r103) == false) goto L10;
        int r104 = entryKeyIndex$runtime(r103);
        if (Intrinsics.areEqual(r101, keyAtIndex(r104)) == true) goto L7;
        return this;
    L7:
        return removeEntryAtIndex(r104, r103);
    L10:
        if (hasNodeAt(r103) == false) goto L17;
        int r105 = nodeIndex$runtime(r103);
        TrieNode<K, V> r106 = nodeAtIndex$runtime(r105);
        if (r102 != 30) goto L14;
        TrieNode<K, V> r107 = r106.collisionRemove(r101);
    L16:
        return replaceNode(r106, r107, r105, r103);
    L14:
        r107 = r106.remove(r100, r101, r102 + 5);
        goto L16
    L17:
        return this;
    }

    public TrieNode(int r100, int r101, Object[] r102, MutabilityOwnership r103) {
        this.dataMap = r100;
        this.nodeMap = r101;
        this.ownedBy = r103;
        this.buffer = r102;
    }

    private final TrieNode<K, V> mutableInsertEntryAt(int r100, K r101, V r102, MutabilityOwnership r103) {
        int r104 = entryKeyIndex$runtime(r100);
        if (this.ownedBy != r103) goto L6;
        this.buffer = TrieNodeKt.access$insertEntryAtIndex(this.buffer, r104, r101, r102);
        this.dataMap = r100 | this.dataMap;
        return this;
    L6:
        Object[] r105 = TrieNodeKt.access$insertEntryAtIndex(this.buffer, r104, r101, r102);
        return new TrieNode(r100 | this.dataMap, this.nodeMap, r105, r103);
    }

    private final TrieNode<K, V> replaceNode(TrieNode<K, V> r100, TrieNode<K, V> r101, int r102, int r103) {
        if (r101 == null) goto L8;
        if (r100 == r101) goto L7;
        return updateNodeAtIndex(r102, r103, r101);
    L7:
        return this;
    L8:
        return removeNodeAtIndex(r102, r103);
    }

    public final TrieNode<K, V> mutablePutAll(TrieNode<K, V> r210, int r211, DeltaCounter r212, PersistentHashMapBuilder<K, V> r213) {
        if (this != r210) goto L7;
        r212.plusAssign(calculateSize());
        return this;
    L7:
        if (r211 > 30) goto L9;
        int r100 = this.nodeMap | r210.nodeMap;
        int r101 = this.dataMap;
        int r102 = r210.dataMap;
        int r103 = (r101 ^ r102) & (~r100);
        int r104 = r101 & r102;
        int r110 = r103;
    L11:
        if (r104 == 0) goto L17;
        int r105 = Integer.lowestOneBit(r104);
        if (Intrinsics.areEqual(keyAtIndex(entryKeyIndex$runtime(r105)), r210.keyAtIndex(r210.entryKeyIndex$runtime(r105))) == false) goto L15;
        r110 = r110 | r105;
    L16:
        r104 = r104 ^ r105;
        goto L11
    L15:
        r100 = r100 | r105;
        goto L16
    L17:
        int r111 = 0;
        if ((r100 & r110) != 0) goto L20;
        boolean r106 = true;
    L21:
        if (r106 == true) goto L24;
        PreconditionsKt.throwIllegalStateException("Check failed.");
    L24:
        if (Intrinsics.areEqual(this.ownedBy, r213.getOwnership()) == true) goto L26;
    L30:
        TrieNode<K, V> r112 = new TrieNode(r110, r100, new Object[(Integer.bitCount(r110) * 2) + Integer.bitCount(r100)]);
    L31:
        int r113 = r100;
        int r114 = 0;
    L32:
        if (r113 == 0) goto L34;
        int r115 = Integer.lowestOneBit(r113);
        Object[] r107 = r112.buffer;
        r107[(r107.length - 1) - r114] = mutablePutAllFromOtherNodeCell(r210, r115, r211, r212, r213);
        r114 = r114 + 1;
        r113 = r113 ^ r115;
    L34:
        if (r110 == 0) goto L43;
        int r108 = Integer.lowestOneBit(r110);
        int r109 = r111 * 2;
        if (r210.hasEntryAt$runtime(r108) == true) goto L38;
        int r116 = entryKeyIndex$runtime(r108);
        r112.buffer[r109] = keyAtIndex(r116);
        r112.buffer[r109 + 1] = valueAtKeyIndex(r116);
    L41:
        r111 = r111 + 1;
        r110 = r110 ^ r108;
        goto L34
    L38:
        int r117 = r210.entryKeyIndex$runtime(r108);
        r112.buffer[r109] = r210.keyAtIndex(r117);
        r112.buffer[r109 + 1] = r210.valueAtKeyIndex(r117);
        if (hasEntryAt$runtime(r108) == false) goto L41;
        r212.setCount(r212.getCount() + 1);
        goto L41
    L43:
        if (elementsIdentityEquals(r112) == false) goto L46;
        return this;
    L46:
        if (r210.elementsIdentityEquals(r112) == true) goto L48;
        return r112;
    L48:
        return r210;
    L26:
        if (this.dataMap != r110) goto L30;
        if (this.nodeMap != r100) goto L30;
        r112 = this;
        goto L31
    L20:
        r106 = false;
        goto L21
    L9:
        return mutableCollisionPutAll(r210, r212, r213.getOwnership());
    }

    public final TrieNode<K, V> mutableRemove(int r100, K r110, int r111, PersistentHashMapBuilder<K, V> r112) {
        int r101 = 1 << TrieNodeKt.indexSegment(r100, r111);
        if (hasEntryAt$runtime(r101) == false) goto L10;
        int r102 = entryKeyIndex$runtime(r101);
        if (Intrinsics.areEqual(r110, keyAtIndex(r102)) == true) goto L7;
        return this;
    L7:
        return mutableRemoveEntryAtIndex(r102, r101, r112);
    L10:
        if (hasNodeAt(r101) == false) goto L17;
        int r103 = nodeIndex$runtime(r101);
        TrieNode<K, V> r104 = nodeAtIndex$runtime(r103);
        if (r111 != 30) goto L14;
        TrieNode<K, V> r105 = r104.mutableCollisionRemove(r110, r112);
    L16:
        return mutableReplaceNode(r104, r105, r103, r101, r112.getOwnership());
    L14:
        r105 = r104.mutableRemove(r100, r110, r111 + 5, r112);
        goto L16
    L17:
        return this;
    }

    public final ModificationResult<K, V> put(int r110, K r111, V r112, int r113) {
        int r100 = 1 << TrieNodeKt.indexSegment(r110, r113);
        if (hasEntryAt$runtime(r100) == false) goto L14;
        int r101 = entryKeyIndex$runtime(r100);
        if (Intrinsics.areEqual(r111, keyAtIndex(r101)) == false) goto L12;
        if (valueAtKeyIndex(r101) != r112) goto L10;
        return null;
    L10:
        return updateValueAtIndex(r101, r112).asUpdateResult();
    L12:
        return moveEntryToNode(r101, r100, r110, r111, r112, r113).asInsertResult();
    L14:
        if (hasNodeAt(r100) == false) goto L26;
        int r102 = nodeIndex$runtime(r100);
        TrieNode<K, V> r103 = nodeAtIndex$runtime(r102);
        if (r113 != 30) goto L20;
        ModificationResult<K, V> r114 = r103.collisionPut(r111, r112);
        if (r114 != null) goto L23;
        return null;
    L23:
        r114.setNode(updateNodeAtIndex(r102, r100, r114.getNode()));
        return r114;
    L20:
        r114 = r103.put(r110, r111, r112, r113 + 5);
        if (r114 != null) goto L23;
        return null;
    L26:
        return insertEntryAt(r100, r111, r112).asInsertResult();
    }

    public final TrieNode<K, V> remove(int r100, K r101, V r102, int r103) {
        int r104 = 1 << TrieNodeKt.indexSegment(r100, r103);
        if (hasEntryAt$runtime(r104) == false) goto L12;
        int r105 = entryKeyIndex$runtime(r104);
        if (Intrinsics.areEqual(r101, keyAtIndex(r105)) == true) goto L7;
    L10:
        return this;
    L7:
        if (Intrinsics.areEqual(r102, valueAtKeyIndex(r105)) == false) goto L10;
        return removeEntryAtIndex(r105, r104);
    L12:
        if (hasNodeAt(r104) == false) goto L19;
        int r106 = nodeIndex$runtime(r104);
        TrieNode<K, V> r107 = nodeAtIndex$runtime(r106);
        if (r103 != 30) goto L16;
        TrieNode<K, V> r108 = r107.collisionRemove(r101, r102);
    L18:
        return replaceNode(r107, r108, r106, r104);
    L16:
        r108 = r107.remove(r100, r101, r102, r103 + 5);
        goto L18
    L19:
        return this;
    }

    private final TrieNode<K, V> mutablePutAllFromOtherNodeCell(TrieNode<K, V> r110, int r111, int r112, DeltaCounter r210, PersistentHashMapBuilder<K, V> r211) {
        int r100 = 0;
        if (hasNodeAt(r111) == false) goto L17;
        TrieNode<K, V> r113 = nodeAtIndex$runtime(nodeIndex$runtime(r111));
        if (r110.hasNodeAt(r111) == false) goto L8;
        return r113.mutablePutAll(r110.nodeAtIndex$runtime(r110.nodeIndex$runtime(r111)), r112 + 5, r210, r211);
    L8:
        if (r110.hasEntryAt$runtime(r111) == false) goto L42;
        int r101 = r110.entryKeyIndex$runtime(r111);
        K r114 = r110.keyAtIndex(r101);
        V r115 = r110.valueAtKeyIndex(r101);
        int r102 = r211.size();
        if (r114 == null) goto L12;
        int r116 = r114.hashCode();
    L13:
        TrieNode<K, V> r117 = r113.mutablePut(r116, r114, r115, r112 + 5, r211);
        if (r211.size() != r102) goto L43;
        r210.setCount(r210.getCount() + 1);
        return r117;
    L43:
        return r117;
    L12:
        r116 = 0;
        goto L13
    L42:
        return r113;
    L17:
        if (r110.hasNodeAt(r111) == false) goto L33;
        TrieNode<K, V> r103 = r110.nodeAtIndex$runtime(r110.nodeIndex$runtime(r111));
        if (hasEntryAt$runtime(r111) == false) goto L46;
        int r104 = entryKeyIndex$runtime(r111);
        K r105 = keyAtIndex(r104);
        if (r105 == null) goto L23;
        int r106 = r105.hashCode();
    L24:
        int r107 = r112 + 5;
        if (r103.containsKey(r106, r105, r107) == false) goto L27;
        r210.setCount(r210.getCount() + 1);
        goto L46
    L27:
        V r108 = valueAtKeyIndex(r104);
        if (r105 == null) goto L30;
        int r109 = r105.hashCode();
    L45:
        return r103.mutablePut(r109, r105, r108, r107, r211);
    L30:
        r109 = 0;
        goto L45
    L23:
        r106 = 0;
    L46:
        return r103;
    L33:
        int r118 = entryKeyIndex$runtime(r111);
        K r119 = keyAtIndex(r118);
        V r120 = valueAtKeyIndex(r118);
        int r121 = r110.entryKeyIndex$runtime(r111);
        K r122 = r110.keyAtIndex(r121);
        V r123 = r110.valueAtKeyIndex(r121);
        if (r119 == null) goto L36;
        int r124 = r119.hashCode();
    L37:
        if (r122 == null) goto L40;
        r100 = r122.hashCode();
    L40:
        return makeNode(r124, r119, r120, r100, r122, r123, r112 + 5, r211.getOwnership());
    L36:
        r124 = 0;
        goto L37
    }

    private final TrieNode<K, V> mutableReplaceNode(TrieNode<K, V> r100, TrieNode<K, V> r101, int r102, int r103, MutabilityOwnership r104) {
        if (r101 != null) goto L5;
        return mutableRemoveNodeAtIndex(r102, r103, r104);
    L5:
        if (this.ownedBy == r104) goto L10;
        if (r100 != r101) goto L10;
        return this;
    L10:
        return mutableUpdateNodeAtIndex(r102, r101, r104);
    }

    public final TrieNode<K, V> mutablePut(int r110, K r111, V r112, int r113, PersistentHashMapBuilder<K, V> r114) {
        int r100 = 1 << TrieNodeKt.indexSegment(r110, r113);
        if (hasEntryAt$runtime(r100) == false) goto L14;
        int r101 = entryKeyIndex$runtime(r100);
        if (Intrinsics.areEqual(r111, keyAtIndex(r101)) == false) goto L11;
        r114.setOperationResult$runtime(valueAtKeyIndex(r101));
        if (valueAtKeyIndex(r101) != r112) goto L10;
        return this;
    L10:
        return mutableUpdateValueAtIndex(r101, r112, r114);
    L11:
        r114.setSize(r114.size() + 1);
        return mutableMoveEntryToNode(r101, r100, r110, r111, r112, r113, r114.getOwnership());
    L14:
        if (hasNodeAt(r100) == false) goto L23;
        int r102 = nodeIndex$runtime(r100);
        TrieNode<K, V> r103 = nodeAtIndex$runtime(r102);
        if (r113 != 30) goto L18;
        TrieNode<K, V> r115 = r103.mutableCollisionPut(r111, r112, r114);
    L19:
        if (r103 != r115) goto L22;
        return this;
    L22:
        return mutableUpdateNodeAtIndex(r102, r115, r114.getOwnership());
    L18:
        r115 = r103.mutablePut(r110, r111, r112, r113 + 5, r114);
        goto L19
    L23:
        r114.setSize(r114.size() + 1);
        return mutableInsertEntryAt(r100, r111, r112, r114.getOwnership());
    }

    public final TrieNode<K, V> mutableRemove(int r110, K r111, V r112, int r113, PersistentHashMapBuilder<K, V> r114) {
        int r100 = 1 << TrieNodeKt.indexSegment(r110, r113);
        if (hasEntryAt$runtime(r100) == false) goto L12;
        int r101 = entryKeyIndex$runtime(r100);
        if (Intrinsics.areEqual(r111, keyAtIndex(r101)) == true) goto L7;
    L10:
        return this;
    L7:
        if (Intrinsics.areEqual(r112, valueAtKeyIndex(r101)) == false) goto L10;
        return mutableRemoveEntryAtIndex(r101, r100, r114);
    L12:
        if (hasNodeAt(r100) == false) goto L19;
        int r102 = nodeIndex$runtime(r100);
        TrieNode<K, V> r115 = nodeAtIndex$runtime(r102);
        if (r113 != 30) goto L16;
        TrieNode<K, V> r103 = r115.mutableCollisionRemove(r111, r112, r114);
    L18:
        return mutableReplaceNode(r115, r103, r102, r100, r114.getOwnership());
    L16:
        r103 = r115.mutableRemove(r110, r111, r112, r113 + 5, r114);
        goto L18
    L19:
        return this;
    }

    private final TrieNode<K, V> moveEntryToNode(int r100, int r110, int r111, K r112, V r113, int r114) {
        Object[] r101 = bufferMoveEntryToNode(r100, r110, r111, r112, r113, r114, null);
        return new TrieNode(this.dataMap ^ r110, r110 | this.nodeMap, r101);
    }

    private final Object[] bufferMoveEntryToNode(int r110, int r111, int r112, K r113, V r114, int r115, MutabilityOwnership r116) {
        K r100 = keyAtIndex(r110);
        if (r100 == null) goto L5;
        int r101 = r100.hashCode();
    L6:
        TrieNode<K, V> r102 = makeNode(r101, r100, valueAtKeyIndex(r110), r112, r113, r114, r115 + 5, r116);
        int r103 = nodeIndex$runtime(r111) + 1;
        return TrieNodeKt.access$replaceEntryWithNode(this.buffer, r110, r103, r102);
    L5:
        r101 = 0;
        goto L6
    }

    private final TrieNode<K, V> mutableMoveEntryToNode(int r100, int r101, int r102, K r103, V r104, int r105, MutabilityOwnership r106) {
        if (this.ownedBy != r106) goto L7;
        this.buffer = bufferMoveEntryToNode(r100, r101, r102, r103, r104, r105, r106);
        this.dataMap ^= r101;
        this.nodeMap |= r101;
        return this;
    L7:
        return new TrieNode(this.dataMap ^ r101, r101 | this.nodeMap, bufferMoveEntryToNode(r100, r101, r102, r103, r104, r105, r106), r106);
    }

    private final TrieNode<K, V> makeNode(int r110, K r111, V r112, int r113, K r114, V r115, int r210, MutabilityOwnership r211) {
        if (r210 > 30) goto L5;
        int r116 = TrieNodeKt.indexSegment(r110, r210);
        int r100 = TrieNodeKt.indexSegment(r113, r210);
        if (r116 == r100) goto L14;
        if (r116 >= r100) goto L10;
        Object[] r101 = {r111, r112, r114, r115};
    L12:
        return new TrieNode((1 << r116) | (1 << r100), 0, r101, r211);
    L10:
        r101 = new Object[]{r114, r115, r111, r112};
        goto L12
    L14:
        return new TrieNode(0, 1 << r116, new Object[]{makeNode(r110, r111, r112, r113, r114, r115, r210 + 5, r211)}, r211);
    L5:
        return new TrieNode(0, 0, new Object[]{r111, r112, r114, r115}, r211);
    }
}
