package androidx.navigation;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.core.app.TaskStackBuilder;
import androidx.core.os.BundleKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import com.baidu.platform.comapi.map.MapBundleKey;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.monitor.cloudmessage.consts.CloudControlInf;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.sequences.SequencesKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.e;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000â\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010%\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u001d\b\u0016\u0018\u0000 â\u00012\u00020\u0001:\u0006â\u0001ã\u0001ä\u0001B\u0011\u0012\u0006\u0010r\u001a\u00020q¢\u0006\u0006\bà\u0001\u0010á\u0001J\u0018\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H\u0002J[\u0010\u0014\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\r2#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u00050\u000fH\u0002JI\u0010\u0018\u001a\u00020\u0005*\n\u0012\u0006\b\u0001\u0012\u00020\b0\u00072\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u00162#\b\u0002\u0010\u0013\u001a\u001d\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00050\u000fH\u0002J$\u0010\u0018\u001a\u00020\u00162\b\b\u0001\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0003J*\u0010\u001f\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\b\b\u0002\u0010\u0017\u001a\u00020\u00162\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u0012\u0010 \u001a\u00020\u00162\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0003J\b\u0010!\u001a\u00020\u0016H\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\b\u0010#\u001a\u00020\u0016H\u0002J\u0012\u0010&\u001a\u00020\u00052\b\u0010%\u001a\u0004\u0018\u00010$H\u0003J\u0012\u0010*\u001a\u0004\u0018\u00010)2\u0006\u0010(\u001a\u00020'H\u0002J\u0018\u0010+\u001a\u0004\u0018\u00010\b*\u00020\b2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0002J.\u0010.\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\b2\b\u0010-\u001a\u0004\u0018\u00010$2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0003J.\u00100\u001a\u00020\u00162\u0006\u0010/\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010$2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0002J\u001e\u00102\u001a\b\u0012\u0004\u0012\u00020\u00020\t2\u000e\u00101\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001cH\u0002J2\u00105\u001a\u00020\u00052\u0006\u0010,\u001a\u00020\b2\b\u00103\u001a\u0004\u0018\u00010$2\u0006\u0010\u0012\u001a\u00020\u00022\u000e\b\u0002\u00104\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0002J\b\u00106\u001a\u00020\u0005H\u0002J\u0019\u00109\u001a\u0004\u0018\u00010\u00022\u0006\u0010\u0003\u001a\u00020\u0002H\u0000¢\u0006\u0004\b7\u00108J\u0010\u0010<\u001a\u00020\u00052\u0006\u0010;\u001a\u00020:H\u0016J\u0010\u0010=\u001a\u00020\u00052\u0006\u0010;\u001a\u00020:H\u0016J\b\u0010>\u001a\u00020\u0016H\u0017J\u001a\u0010>\u001a\u00020\u00162\b\b\u0001\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u0016H\u0017J\"\u0010>\u001a\u00020\u00162\b\b\u0001\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0017J\"\u0010>\u001a\u00020\u00162\u0006\u0010?\u001a\u00020)2\u0006\u0010\u001b\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u0016H\u0007J%\u0010D\u001a\u00020\u00052\u0006\u0010\u0015\u001a\u00020\u00022\f\u0010A\u001a\b\u0012\u0004\u0012\u00020\u00050@H\u0000¢\u0006\u0004\bB\u0010CJ\u0010\u0010E\u001a\u00020\u00162\u0006\u0010?\u001a\u00020)H\u0007J\u0012\u0010E\u001a\u00020\u00162\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0007J\b\u0010F\u001a\u00020\u0016H\u0017J\u000f\u0010I\u001a\u00020\u0005H\u0000¢\u0006\u0004\bG\u0010HJ\u0015\u0010L\u001a\b\u0012\u0004\u0012\u00020\u00020\tH\u0000¢\u0006\u0004\bJ\u0010KJ\u0012\u0010N\u001a\u00020\u00052\b\b\u0001\u0010M\u001a\u00020\u0019H\u0017J\u001c\u0010N\u001a\u00020\u00052\b\b\u0001\u0010M\u001a\u00020\u00192\b\u0010%\u001a\u0004\u0018\u00010$H\u0017J\u001a\u0010N\u001a\u00020\u00052\u0006\u0010P\u001a\u00020O2\b\u0010%\u001a\u0004\u0018\u00010$H\u0017J\u0012\u0010S\u001a\u00020\u00162\b\u0010R\u001a\u0004\u0018\u00010QH\u0017J\u0014\u0010+\u001a\u0004\u0018\u00010\b2\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0007J\u0012\u0010+\u001a\u0004\u0018\u00010\b2\u0006\u0010T\u001a\u00020)H\u0007J\u0012\u0010.\u001a\u00020\u00052\b\b\u0001\u0010U\u001a\u00020\u0019H\u0017J\u001c\u0010.\u001a\u00020\u00052\b\b\u0001\u0010U\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010$H\u0017J&\u0010.\u001a\u00020\u00052\b\b\u0001\u0010U\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010$2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017J0\u0010.\u001a\u00020\u00052\b\b\u0001\u0010U\u001a\u00020\u00192\b\u0010-\u001a\u0004\u0018\u00010$2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010(\u001a\u00020VH\u0017J\u001a\u0010.\u001a\u00020\u00052\u0006\u0010(\u001a\u00020V2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017J$\u0010.\u001a\u00020\u00052\u0006\u0010(\u001a\u00020V2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010X\u001a\u00020WH\u0017J\u001a\u0010.\u001a\u00020\u00052\u0006\u0010X\u001a\u00020W2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017J$\u0010.\u001a\u00020\u00052\u0006\u0010X\u001a\u00020W2\b\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0017J\u0010\u0010.\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020YH\u0017J\u001a\u0010.\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020Y2\b\u0010\f\u001a\u0004\u0018\u00010\u000bH\u0017J\u0018\u0010.\u001a\u00020\u00052\u0006\u0010Z\u001a\u00020Y2\u0006\u0010\u000e\u001a\u00020\rH\u0017J'\u0010.\u001a\u00020\u00052\u0006\u0010?\u001a\u00020)2\u0017\u0010]\u001a\u0013\u0012\u0004\u0012\u00020[\u0012\u0004\u0012\u00020\u00050\u000f¢\u0006\u0002\b\\J(\u0010.\u001a\u00020\u00052\u0006\u0010?\u001a\u00020)2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0007J\b\u0010_\u001a\u00020^H\u0016J\n\u0010\u0017\u001a\u0004\u0018\u00010$H\u0017J\u0012\u0010a\u001a\u00020\u00052\b\u0010`\u001a\u0004\u0018\u00010$H\u0017J\u0010\u0010d\u001a\u00020\u00052\u0006\u0010c\u001a\u00020bH\u0017J\u0010\u0010g\u001a\u00020\u00052\u0006\u0010f\u001a\u00020eH\u0017J\u0010\u0010i\u001a\u00020\u00052\u0006\u0010h\u001a\u00020\u0016H\u0017J\u0010\u0010l\u001a\u00020\u00052\u0006\u0010k\u001a\u00020jH\u0017J\u0012\u0010o\u001a\u00020n2\b\b\u0001\u0010m\u001a\u00020\u0019H\u0016J\u0012\u0010p\u001a\u00020\u00022\b\b\u0001\u0010\u001a\u001a\u00020\u0019H\u0016J\u000e\u0010p\u001a\u00020\u00022\u0006\u0010?\u001a\u00020)R\u0017\u0010r\u001a\u00020q8\u0007¢\u0006\f\n\u0004\br\u0010s\u001a\u0004\bt\u0010uR\u0018\u0010w\u001a\u0004\u0018\u00010v8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010z\u001a\u0004\u0018\u00010y8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u0010{R\u0018\u0010|\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010}R\u0018\u0010~\u001a\u0004\u0018\u00010$8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b~\u0010\u007fR#\u0010\u0082\u0001\u001a\f\u0012\u0005\u0012\u00030\u0081\u0001\u0018\u00010\u0080\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0019\u0010\u0084\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0001\u0010\u0085\u0001R%\u0010\u0086\u0001\u001a\b\u0012\u0004\u0012\u00020\u00020\u001c8WX\u0096\u0004¢\u0006\u0010\n\u0006\b\u0086\u0001\u0010\u0087\u0001\u001a\u0006\b\u0088\u0001\u0010\u0089\u0001R$\u0010\u008b\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u008a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008b\u0001\u0010\u008c\u0001R3\u0010\u008e\u0001\u001a\u000f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00020\t0\u008d\u00018\u0006X\u0087\u0004¢\u0006\u0017\n\u0006\b\u008e\u0001\u0010\u008f\u0001\u0012\u0005\b\u0092\u0001\u0010H\u001a\u0006\b\u0090\u0001\u0010\u0091\u0001R$\u0010\u0094\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R%\u0010\u0097\u0001\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0005\u0012\u00030\u0096\u00010\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0095\u0001R&\u0010\u0098\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u0019\u0012\u0006\u0012\u0004\u0018\u00010)0\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0098\u0001\u0010\u0095\u0001R*\u0010\u0099\u0001\u001a\u0015\u0012\u0004\u0012\u00020)\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u001c0\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u0095\u0001R\u001b\u0010\u009a\u0001\u001a\u0004\u0018\u00010b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009a\u0001\u0010\u009b\u0001R\u001b\u0010\u009c\u0001\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u001c\u0010\u009f\u0001\u001a\u0005\u0018\u00010\u009e\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u001e\u0010¢\u0001\u001a\t\u0012\u0004\u0012\u00020:0¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R*\u0010¥\u0001\u001a\u00030¤\u00018@@\u0000X\u0080\u000e¢\u0006\u0018\n\u0006\b¥\u0001\u0010¦\u0001\u001a\u0006\b§\u0001\u0010¨\u0001\"\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010¬\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0018\u0010¯\u0001\u001a\u00030®\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¯\u0001\u0010°\u0001R\u0019\u0010±\u0001\u001a\u00020\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b±\u0001\u0010\u0085\u0001R\u001a\u0010³\u0001\u001a\u00030²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R1\u0010¶\u0001\u001a\u001c\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\b0\u0007\u0012\t\u0012\u00070µ\u0001R\u00020\u00000\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010\u0095\u0001R6\u0010·\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010¸\u0001R6\u0010¹\u0001\u001a\u001f\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010¸\u0001R$\u0010º\u0001\u001a\u000f\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00160\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010\u0095\u0001R\u0019\u0010»\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010¼\u0001R\u001e\u0010¾\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R \u0010Ä\u0001\u001a\u00020y8VX\u0096\u0084\u0002¢\u0006\u0010\n\u0006\bÀ\u0001\u0010Á\u0001\u001a\u0006\bÂ\u0001\u0010Ã\u0001R\u001e\u0010Æ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020Å\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÆ\u0001\u0010Ç\u0001R#\u0010É\u0001\u001a\t\u0012\u0004\u0012\u00020\u00020È\u00018\u0006¢\u0006\u0010\n\u0006\bÉ\u0001\u0010Ê\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001R\u0017\u0010Ï\u0001\u001a\u00020\u00198BX\u0082\u0004¢\u0006\b\u001a\u0006\bÍ\u0001\u0010Î\u0001R'\u0010P\u001a\u00020O2\u0006\u0010P\u001a\u00020O8W@WX\u0096\u000e¢\u0006\u000f\u001a\u0006\bÐ\u0001\u0010Ñ\u0001\"\u0005\bN\u0010Ò\u0001R,\u0010Ó\u0001\u001a\u00030²\u00012\b\u0010Ó\u0001\u001a\u00030²\u00018V@WX\u0096\u000e¢\u0006\u0010\u001a\u0006\bÔ\u0001\u0010Õ\u0001\"\u0006\bÖ\u0001\u0010×\u0001R\u0019\u0010Ú\u0001\u001a\u0004\u0018\u00010\b8VX\u0096\u0004¢\u0006\b\u001a\u0006\bØ\u0001\u0010Ù\u0001R\u0019\u0010Ý\u0001\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÛ\u0001\u0010Ü\u0001R\u0019\u0010ß\u0001\u001a\u0004\u0018\u00010\u00028VX\u0096\u0004¢\u0006\b\u001a\u0006\bÞ\u0001\u0010Ü\u0001¨\u0006å\u0001"}, d2 = {"Landroidx/navigation/NavController;", "", "Landroidx/navigation/NavBackStackEntry;", MapBundleKey.OfflineMapKey.OFFLINE_CHILD, "parent", "", "linkChildToParent", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "", "entries", "Landroidx/navigation/NavOptions;", "navOptions", "Landroidx/navigation/Navigator$Extras;", "navigatorExtras", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "backStackEntry", "handler", "navigateInternal", "popUpTo", "", "saveState", "popBackStackInternal", "", "destinationId", "inclusive", "Lkotlin/collections/ArrayDeque;", "Landroidx/navigation/NavBackStackEntryState;", "savedState", "popEntryFromBackStack", "clearBackStackInternal", "tryRelaunchUpToExplicitStack", "tryRelaunchUpToGeneratedStack", "dispatchOnDestinationChanged", "Landroid/os/Bundle;", "startDestinationArgs", "onGraphCreated", "", "deepLink", "", "findInvalidDestinationDisplayNameInDeepLink", "findDestination", "node", "args", MusicAppletPage.ROUTE_MODE_NAVIGATION, "id", "restoreStateInternal", "backStackState", "instantiateBackStack", "finalArgs", "restoredEntries", "addEntryToBackStack", "updateOnBackPressedCallbackEnabled", "unlinkChildFromParent$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;)Landroidx/navigation/NavBackStackEntry;", "unlinkChildFromParent", "Landroidx/navigation/NavController$OnDestinationChangedListener;", "listener", "addOnDestinationChangedListener", "removeOnDestinationChangedListener", "popBackStack", CloudControlInf.ROUTE, "Lkotlin/Function0;", "onComplete", "popBackStackFromNavigator$navigation_runtime_release", "(Landroidx/navigation/NavBackStackEntry;Lkotlin/jvm/functions/Function0;)V", "popBackStackFromNavigator", "clearBackStack", "navigateUp", "updateBackStackLifecycle$navigation_runtime_release", "()V", "updateBackStackLifecycle", "populateVisibleEntries$navigation_runtime_release", "()Ljava/util/List;", "populateVisibleEntries", "graphResId", "setGraph", "Landroidx/navigation/NavGraph;", "graph", "Landroid/content/Intent;", "intent", "handleDeepLink", "destinationRoute", "resId", "Landroid/net/Uri;", "Landroidx/navigation/NavDeepLinkRequest;", "request", "Landroidx/navigation/NavDirections;", "directions", "Landroidx/navigation/NavOptionsBuilder;", "Lkotlin/ExtensionFunctionType;", "builder", "Landroidx/navigation/NavDeepLinkBuilder;", "createDeepLink", "navState", "restoreState", "Landroidx/lifecycle/LifecycleOwner;", "owner", "setLifecycleOwner", "Landroidx/activity/OnBackPressedDispatcher;", "dispatcher", "setOnBackPressedDispatcher", "enabled", "enableOnBackPressed", "Landroidx/lifecycle/ViewModelStore;", "viewModelStore", "setViewModelStore", "navGraphId", "Landroidx/lifecycle/ViewModelStoreOwner;", "getViewModelStoreOwner", "getBackStackEntry", "Landroid/content/Context;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "Landroid/app/Activity;", "activity", "Landroid/app/Activity;", "Landroidx/navigation/NavInflater;", "inflater", "Landroidx/navigation/NavInflater;", "_graph", "Landroidx/navigation/NavGraph;", "navigatorStateToRestore", "Landroid/os/Bundle;", "", "Landroid/os/Parcelable;", "backStackToRestore", "[Landroid/os/Parcelable;", "deepLinkHandled", "Z", "backQueue", "Lkotlin/collections/ArrayDeque;", "getBackQueue", "()Lkotlin/collections/ArrayDeque;", "Lkotlinx/coroutines/flow/z0;", "_visibleEntries", "Lkotlinx/coroutines/flow/z0;", "Lkotlinx/coroutines/flow/i1;", "visibleEntries", "Lkotlinx/coroutines/flow/i1;", "getVisibleEntries", "()Lkotlinx/coroutines/flow/i1;", "getVisibleEntries$annotations", "", "childToParentEntries", "Ljava/util/Map;", "Ljava/util/concurrent/atomic/AtomicInteger;", "parentToChildCount", "backStackMap", "backStackStates", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "onBackPressedDispatcher", "Landroidx/activity/OnBackPressedDispatcher;", "Landroidx/navigation/NavControllerViewModel;", "viewModel", "Landroidx/navigation/NavControllerViewModel;", "Ljava/util/concurrent/CopyOnWriteArrayList;", "onDestinationChangedListeners", "Ljava/util/concurrent/CopyOnWriteArrayList;", "Landroidx/lifecycle/Lifecycle$State;", "hostLifecycleState", "Landroidx/lifecycle/Lifecycle$State;", "getHostLifecycleState$navigation_runtime_release", "()Landroidx/lifecycle/Lifecycle$State;", "setHostLifecycleState$navigation_runtime_release", "(Landroidx/lifecycle/Lifecycle$State;)V", "Landroidx/lifecycle/LifecycleObserver;", "lifecycleObserver", "Landroidx/lifecycle/LifecycleObserver;", "Landroidx/activity/OnBackPressedCallback;", "onBackPressedCallback", "Landroidx/activity/OnBackPressedCallback;", "enableOnBackPressedCallback", "Landroidx/navigation/NavigatorProvider;", "_navigatorProvider", "Landroidx/navigation/NavigatorProvider;", "Landroidx/navigation/NavController$NavControllerNavigatorState;", "navigatorState", "addToBackStackHandler", "Lkotlin/jvm/functions/Function1;", "popFromBackStackHandler", "entrySavedState", "dispatchReentrantCount", "I", "", "backStackEntriesToDispatch", "Ljava/util/List;", "navInflater$delegate", "Lkotlin/Lazy;", "getNavInflater", "()Landroidx/navigation/NavInflater;", "navInflater", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "_currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lkotlinx/coroutines/flow/Flow;", "currentBackStackEntryFlow", "Lkotlinx/coroutines/flow/Flow;", "getCurrentBackStackEntryFlow", "()Lkotlinx/coroutines/flow/Flow;", "getDestinationCountOnBackStack", "()I", "destinationCountOnBackStack", "getGraph", "()Landroidx/navigation/NavGraph;", "(Landroidx/navigation/NavGraph;)V", "navigatorProvider", "getNavigatorProvider", "()Landroidx/navigation/NavigatorProvider;", "setNavigatorProvider", "(Landroidx/navigation/NavigatorProvider;)V", "getCurrentDestination", "()Landroidx/navigation/NavDestination;", "currentDestination", "getCurrentBackStackEntry", "()Landroidx/navigation/NavBackStackEntry;", "currentBackStackEntry", "getPreviousBackStackEntry", "previousBackStackEntry", "<init>", "(Landroid/content/Context;)V", "Companion", "NavControllerNavigatorState", "OnDestinationChangedListener", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0})
public class NavController {
    public static final Companion Companion = null;
    private static final String KEY_BACK_STACK = "android-support-nav:controller:backStack";
    private static final String KEY_BACK_STACK_DEST_IDS = "android-support-nav:controller:backStackDestIds";
    private static final String KEY_BACK_STACK_IDS = "android-support-nav:controller:backStackIds";
    private static final String KEY_BACK_STACK_STATES_IDS = "android-support-nav:controller:backStackStates";
    private static final String KEY_BACK_STACK_STATES_PREFIX = "android-support-nav:controller:backStackStates:";
    public static final String KEY_DEEP_LINK_ARGS = "android-support-nav:controller:deepLinkArgs";
    public static final String KEY_DEEP_LINK_EXTRAS = "android-support-nav:controller:deepLinkExtras";
    public static final String KEY_DEEP_LINK_HANDLED = "android-support-nav:controller:deepLinkHandled";
    public static final String KEY_DEEP_LINK_IDS = "android-support-nav:controller:deepLinkIds";
    public static final String KEY_DEEP_LINK_INTENT = "android-support-nav:controller:deepLinkIntent";
    private static final String KEY_NAVIGATOR_STATE = "android-support-nav:controller:navigatorState";
    private static final String KEY_NAVIGATOR_STATE_NAMES = "android-support-nav:controller:navigatorState:names";
    private static final String TAG = "NavController";
    private static boolean deepLinkSaveState;
    private final MutableSharedFlow<NavBackStackEntry> _currentBackStackEntryFlow;
    private NavGraph _graph;
    private NavigatorProvider _navigatorProvider;
    private final z0<List<NavBackStackEntry>> _visibleEntries;
    private Activity activity;
    private Function1<? super NavBackStackEntry, Unit> addToBackStackHandler;
    private final ArrayDeque<NavBackStackEntry> backQueue;
    private final List<NavBackStackEntry> backStackEntriesToDispatch;
    private final Map<Integer, String> backStackMap;
    private final Map<String, ArrayDeque<NavBackStackEntryState>> backStackStates;
    private Parcelable[] backStackToRestore;
    private final Map<NavBackStackEntry, NavBackStackEntry> childToParentEntries;
    private final Context context;
    private final Flow<NavBackStackEntry> currentBackStackEntryFlow;
    private boolean deepLinkHandled;
    private int dispatchReentrantCount;
    private boolean enableOnBackPressedCallback;
    private final Map<NavBackStackEntry, Boolean> entrySavedState;
    private Lifecycle.State hostLifecycleState;
    private NavInflater inflater;
    private final LifecycleObserver lifecycleObserver;
    private LifecycleOwner lifecycleOwner;
    private final Lazy navInflater$delegate;
    private final Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> navigatorState;
    private Bundle navigatorStateToRestore;
    private final OnBackPressedCallback onBackPressedCallback;
    private OnBackPressedDispatcher onBackPressedDispatcher;
    private final CopyOnWriteArrayList<OnDestinationChangedListener> onDestinationChangedListeners;
    private final Map<NavBackStackEntry, AtomicInteger> parentToChildCount;
    private Function1<? super NavBackStackEntry, Unit> popFromBackStackHandler;
    private NavControllerViewModel viewModel;
    private final i1<List<NavBackStackEntry>> visibleEntries;

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0013H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0016\u0010\n\u001a\u00020\u00048\u0006X\u0087T¢\u0006\b\n\u0000\u0012\u0004\b\u000b\u0010\u0002R\u0010\u0010\f\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u00048\u0006X\u0087T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Landroidx/navigation/NavController$Companion;", "", "()V", "KEY_BACK_STACK", "", "KEY_BACK_STACK_DEST_IDS", "KEY_BACK_STACK_IDS", "KEY_BACK_STACK_STATES_IDS", "KEY_BACK_STACK_STATES_PREFIX", "KEY_DEEP_LINK_ARGS", "KEY_DEEP_LINK_EXTRAS", "getKEY_DEEP_LINK_EXTRAS$annotations", "KEY_DEEP_LINK_HANDLED", "KEY_DEEP_LINK_IDS", "KEY_DEEP_LINK_INTENT", "KEY_NAVIGATOR_STATE", "KEY_NAVIGATOR_STATE_NAMES", "TAG", "deepLinkSaveState", "", "enableDeepLinkSaveState", "", "saveState", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }

        public static /* synthetic */ void getKEY_DEEP_LINK_EXTRAS$annotations() {
        }

        @JvmStatic
        @NavDeepLinkSaveStateControl
        public final void enableDeepLinkSaveState(boolean r100) {
            NavController.access$setDeepLinkSaveState$cp(r100);
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u000e\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bJ\u001a\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0018\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u0019\u0010\u0002\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0018"}, d2 = {"Landroidx/navigation/NavController$NavControllerNavigatorState;", "Landroidx/navigation/NavigatorState;", "navigator", "Landroidx/navigation/Navigator;", "Landroidx/navigation/NavDestination;", "(Landroidx/navigation/NavController;Landroidx/navigation/Navigator;)V", "getNavigator", "()Landroidx/navigation/Navigator;", "addInternal", "", "backStackEntry", "Landroidx/navigation/NavBackStackEntry;", "createBackStackEntry", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "arguments", "Landroid/os/Bundle;", "markTransitionComplete", "entry", "pop", "popUpTo", "saveState", "", "popWithTransition", "push", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public final class NavControllerNavigatorState extends NavigatorState {
        private final Navigator<? extends NavDestination> navigator;
        final /* synthetic */ NavController this$0;

        public final Navigator<? extends NavDestination> getNavigator() {
            return this.navigator;
        }

        public final void addInternal(NavBackStackEntry r100) {
            Intrinsics.checkNotNullParameter(r100, "backStackEntry");
            super.push(r100);
        }

        @Override // androidx.navigation.NavigatorState
        public void markTransitionComplete(NavBackStackEntry r100) {
            Intrinsics.checkNotNullParameter(r100, "entry");
            boolean r101 = Intrinsics.areEqual(NavController.access$getEntrySavedState$p(this.this$0).get(r100), Boolean.TRUE);
            super.markTransitionComplete(r100);
            NavController.access$getEntrySavedState$p(this.this$0).remove(r100);
            if (this.this$0.getBackQueue().contains(r100) == true) goto L26;
            this.this$0.unlinkChildFromParent$navigation_runtime_release(r100);
            if (r100.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.CREATED) == false) goto L7;
            r100.setMaxLifecycle(Lifecycle.State.DESTROYED);
        L7:
            ArrayDeque<NavBackStackEntry> r102 = this.this$0.getBackQueue();
            boolean r103 = true;
            if ((r102 instanceof Collection) == true) goto L10;
        L12:
            Iterator<NavBackStackEntry> r104 = r102.iterator();
        L14:
            if (r104.hasNext() == false) goto L18;
            if (Intrinsics.areEqual(r104.next().getId(), r100.getId()) == false) goto L14;
            r103 = false;
        L18:
            if (r103 == false) goto L24;
            if (r101 == true) goto L24;
            NavControllerViewModel r105 = NavController.access$getViewModel$p(this.this$0);
            if (r105 == null) goto L24;
            r105.clear(r100.getId());
        L24:
            this.this$0.updateBackStackLifecycle$navigation_runtime_release();
            NavController.access$get_visibleEntries$p(this.this$0).tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
            return;
        L10:
            if (r102.isEmpty() == false) goto L12;
        L26:
            if (isNavigating() == true) goto L33;
            this.this$0.updateBackStackLifecycle$navigation_runtime_release();
            NavController.access$get_visibleEntries$p(this.this$0).tryEmit(this.this$0.populateVisibleEntries$navigation_runtime_release());
            return;
        }

        @Override // androidx.navigation.NavigatorState
        public void push(NavBackStackEntry r100) {
            Intrinsics.checkNotNullParameter(r100, "backStackEntry");
            Navigator r101 = NavController.access$get_navigatorProvider$p(this.this$0).getNavigator(r100.getDestination().getNavigatorName());
            if (Intrinsics.areEqual(r101, this.navigator) == false) goto L8;
            Function1 r102 = NavController.access$getAddToBackStackHandler$p(this.this$0);
            if (r102 == null) goto L7;
            r102.invoke(r100);
            addInternal(r100);
            return;
        L7:
            Objects.toString(r100.getDestination());
            return;
        L8:
            Object r103 = NavController.access$getNavigatorState$p(this.this$0).get(r101);
            if (r103 == null) goto L13;
            ((NavControllerNavigatorState) r103).push(r100);
            return;
        L13:
            throw new IllegalStateException(("NavigatorBackStack for " + r100.getDestination().getNavigatorName() + " should already be created").toString());
        }

        public NavControllerNavigatorState(NavController r100, Navigator<? extends NavDestination> r101) {
            Intrinsics.checkNotNullParameter(r100, "this$0");
            Intrinsics.checkNotNullParameter(r101, "navigator");
            this.this$0 = r100;
            this.navigator = r101;
        }

        @Override // androidx.navigation.NavigatorState
        public NavBackStackEntry createBackStackEntry(NavDestination r110, Bundle r111) {
            Intrinsics.checkNotNullParameter(r110, com.bytedance.android.ec.core.event.a.KEY_DESTINATION);
            return NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.this$0.getContext(), r110, r111, this.this$0.getHostLifecycleState$navigation_runtime_release(), NavController.access$getViewModel$p(this.this$0), null, null, 96, null);
        }

        @Override // androidx.navigation.NavigatorState
        public void pop(final NavBackStackEntry r100, final boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "popUpTo");
            Navigator r102 = NavController.access$get_navigatorProvider$p(this.this$0).getNavigator(r100.getDestination().getNavigatorName());
            if (Intrinsics.areEqual(r102, this.navigator) == false) goto L8;
            Function1 r103 = NavController.access$getPopFromBackStackHandler$p(this.this$0);
            if (r103 == null) goto L7;
            r103.invoke(r100);
            super.pop(r100, r101);
            return;
        L7:
            this.this$0.popBackStackFromNavigator$navigation_runtime_release(r100, new NavController$NavControllerNavigatorState$pop$1(this, r100, r101));
            return;
        L8:
            Object r104 = NavController.access$getNavigatorState$p(this.this$0).get(r102);
            Intrinsics.checkNotNull(r104);
            ((NavControllerNavigatorState) r104).pop(r100, r101);
        }

        @Override // androidx.navigation.NavigatorState
        public void popWithTransition(NavBackStackEntry r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "popUpTo");
            super.popWithTransition(r100, r101);
            NavController.access$getEntrySavedState$p(this.this$0).put(r100, Boolean.valueOf(r101));
        }

        public static final /* synthetic */ void access$pop$s261051546(NavControllerNavigatorState r100, NavBackStackEntry r101, boolean r102) {
            super.pop(r101, r102);
        }
    }

    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&¨\u0006\n"}, d2 = {"Landroidx/navigation/NavController$OnDestinationChangedListener;", "", "onDestinationChanged", "", "controller", "Landroidx/navigation/NavController;", com.bytedance.android.ec.core.event.a.KEY_DESTINATION, "Landroidx/navigation/NavDestination;", "arguments", "Landroid/os/Bundle;", "navigation-runtime_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    public interface OnDestinationChangedListener {
        void onDestinationChanged(NavController r100, NavDestination r101, Bundle r102);
    }

    public static /* synthetic */ void a(NavController r100, LifecycleOwner r101, Lifecycle.Event r102) {
        m7813lifecycleObserver$lambda2(r100, r101, r102);
    }

    @JvmStatic
    @NavDeepLinkSaveStateControl
    public static final void enableDeepLinkSaveState(boolean r100) {
        Companion.enableDeepLinkSaveState(r100);
    }

    @NavControllerVisibleEntries
    public static /* synthetic */ void getVisibleEntries$annotations() {
    }

    public final void navigate(String r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        navigate$default(this, r100, null, null, 6, null);
    }

    public final void navigate(String r100, NavOptions r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        navigate$default(this, r100, r101, null, 4, null);
    }

    public final boolean popBackStack(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return popBackStack$default(this, r100, r101, false, 4, null);
    }

    static {
        Companion = new Companion(null);
        deepLinkSaveState = true;
    }

    private final boolean tryRelaunchUpToExplicitStack() {
        int r100 = 0;
        if (this.deepLinkHandled == true) goto L5;
        return false;
    L5:
        Activity r101 = this.activity;
        Intrinsics.checkNotNull(r101);
        Intent r102 = r101.getIntent();
        Bundle r103 = r102.getExtras();
        Intrinsics.checkNotNull(r103);
        int[] r104 = r103.getIntArray(KEY_DEEP_LINK_IDS);
        Intrinsics.checkNotNull(r104);
        List r105 = ArraysKt.toMutableList(r104);
        ArrayList r106 = r103.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        int r107 = ((Number) CollectionsKt.removeLast(r105)).intValue();
        if (r106 == null) goto L10;
        Bundle r108 = (Bundle) CollectionsKt.removeLast(r106);
    L10:
        if (r105.isEmpty() == false) goto L12;
        return false;
    L12:
        NavDestination r109 = findDestination(getGraph(), r107);
        if ((r109 instanceof NavGraph) == false) goto L15;
        r107 = NavGraph.Companion.findStartDestination((NavGraph) r109).getId();
    L15:
        NavDestination r110 = getCurrentDestination();
        if (r110 != null) goto L19;
    L17:
        boolean r111 = false;
    L21:
        if (r111 == true) goto L23;
        return false;
    L23:
        NavDeepLinkBuilder r112 = createDeepLink();
        Bundle r113 = BundleKt.bundleOf(new Pair[]{TuplesKt.to(KEY_DEEP_LINK_INTENT, r102)});
        Bundle r114 = r103.getBundle(KEY_DEEP_LINK_EXTRAS);
        if (r114 == null) goto L27;
        r113.putAll(r114);
    L27:
        r112.setArguments(r113);
        Iterator r115 = r105.iterator();
    L29:
        if (r115.hasNext() == false) goto L38;
        Object r116 = r115.next();
        int r117 = r100 + 1;
        if (r100 >= 0) goto L33;
        CollectionsKt.throwIndexOverflow();
    L33:
        int r118 = ((Number) r116).intValue();
        if (r106 != null) goto L36;
        Bundle r119 = null;
    L37:
        r112.addDestination(r118, r119);
        r100 = r117;
        goto L29
    L36:
        r119 = (Bundle) ListProtector.get(r106, r100);
        goto L37
    L38:
        r112.createTaskStackBuilder().startActivities();
        Activity r120 = this.activity;
        if (r120 == null) goto L42;
        r120.finish();
    L42:
        return true;
    L19:
        if (r107 != r110.getId()) goto L17;
        r111 = true;
        goto L21
    }

    private final void updateOnBackPressedCallbackEnabled() {
        OnBackPressedCallback r100 = this.onBackPressedCallback;
        if (this.enableOnBackPressedCallback == false) goto L7;
        boolean r101 = true;
        if (getDestinationCountOnBackStack() <= 1) goto L7;
    L8:
        r100.setEnabled(r101);
        return;
    L7:
        r101 = false;
        goto L8
    }

    public NavDeepLinkBuilder createDeepLink() {
        return new NavDeepLinkBuilder(this);
    }

    public NavGraph getGraph() {
        NavGraph r100 = this._graph;
        if (r100 == null) goto L9;
        if (r100 == null) goto L7;
        return r100;
    L7:
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavGraph");
    L9:
        throw new IllegalStateException("You must call setGraph() before calling getGraph()".toString());
    }

    public final Lifecycle.State getHostLifecycleState$navigation_runtime_release() {
        if (this.lifecycleOwner != null) goto L6;
        return Lifecycle.State.CREATED;
    L6:
        return this.hostLifecycleState;
    }

    public NavInflater getNavInflater() {
        return (NavInflater) this.navInflater$delegate.getValue();
    }

    public final List<NavBackStackEntry> populateVisibleEntries$navigation_runtime_release() {
        ArrayList r100 = new ArrayList();
        Iterator<T> r101 = this.navigatorState.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L17;
        Set<NavBackStackEntry> r102 = ((NavControllerNavigatorState) r101.next()).getTransitionsInProgress().getValue();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L7:
        if (r104.hasNext() == false) goto L16;
        Object r105 = r104.next();
        NavBackStackEntry r106 = (NavBackStackEntry) r105;
        if (r100.contains(r106) == false) goto L11;
    L13:
        boolean r107 = false;
    L14:
        if (r107 == false) goto L7;
        r103.add(r105);
        goto L7
    L11:
        if (r106.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L13;
        r107 = true;
        goto L14
    L16:
        CollectionsKt.addAll(r100, r103);
        goto L4
    L17:
        ArrayDeque<NavBackStackEntry> r108 = getBackQueue();
        ArrayList r109 = new ArrayList();
        Iterator<NavBackStackEntry> r110 = r108.iterator();
    L19:
        if (r110.hasNext() == false) goto L28;
        NavBackStackEntry r111 = r110.next();
        NavBackStackEntry r112 = r111;
        if (r100.contains(r112) == false) goto L23;
    L25:
        boolean r113 = false;
    L26:
        if (r113 == false) goto L19;
        r109.add(r111);
        goto L19
    L23:
        if (r112.getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == false) goto L25;
        r113 = true;
        goto L26
    L28:
        CollectionsKt.addAll(r100, r109);
        ArrayList r114 = new ArrayList();
        Iterator r115 = r100.iterator();
    L30:
        if (r115.hasNext() == false) goto L34;
        Object r116 = r115.next();
        if ((!(((NavBackStackEntry) r116).getDestination() instanceof NavGraph)) == false) goto L30;
        r114.add(r116);
        goto L30
    L34:
        return r114;
    }

    public Bundle saveState() {
        ArrayList<String> r100 = new ArrayList();
        Bundle r101 = new Bundle();
        Iterator<Map.Entry<String, Navigator<? extends NavDestination>>> r102 = this._navigatorProvider.getNavigators().entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry<String, Navigator<? extends NavDestination>> r103 = r102.next();
        String r104 = r103.getKey();
        Bundle r105 = r103.getValue().onSaveState();
        if (r105 == null) goto L4;
        r100.add(r104);
        r101.putBundle(r104, r105);
        goto L4
    L9:
        if ((!r100.isEmpty()) == false) goto L11;
        Bundle r106 = new Bundle();
        r101.putStringArrayList(KEY_NAVIGATOR_STATE_NAMES, r100);
        r106.putBundle(KEY_NAVIGATOR_STATE, r101);
    L13:
        if ((!getBackQueue().isEmpty()) == false) goto L22;
        if (r106 != null) goto L16;
        r106 = new Bundle();
    L16:
        Parcelable[] r107 = new Parcelable[getBackQueue().size()];
        Iterator<NavBackStackEntry> r108 = getBackQueue().iterator();
        int r109 = 0;
    L18:
        if (r108.hasNext() == false) goto L20;
        r107[r109] = new NavBackStackEntryState(r108.next());
        r109 = r109 + 1;
        goto L18
    L20:
        r106.putParcelableArray(KEY_BACK_STACK, r107);
    L22:
        if ((!this.backStackMap.isEmpty()) == false) goto L31;
        if (r106 != null) goto L25;
        r106 = new Bundle();
    L25:
        int[] r110 = new int[this.backStackMap.size()];
        ArrayList<String> r111 = new ArrayList();
        Iterator<Map.Entry<Integer, String>> r112 = this.backStackMap.entrySet().iterator();
        int r113 = 0;
    L27:
        if (r112.hasNext() == false) goto L29;
        Map.Entry<Integer, String> r114 = r112.next();
        int r115 = r114.getKey().intValue();
        String r116 = r114.getValue();
        r110[r113] = r115;
        r111.add(r116);
        r113 = r113 + 1;
        goto L27
    L29:
        r106.putIntArray(KEY_BACK_STACK_DEST_IDS, r110);
        r106.putStringArrayList(KEY_BACK_STACK_IDS, r111);
    L31:
        if ((!this.backStackStates.isEmpty()) == false) goto L47;
        if (r106 != null) goto L34;
        r106 = new Bundle();
    L34:
        ArrayList<String> r117 = new ArrayList();
        Iterator<Map.Entry<String, ArrayDeque<NavBackStackEntryState>>> r118 = this.backStackStates.entrySet().iterator();
    L36:
        if (r118.hasNext() == false) goto L45;
        Map.Entry<String, ArrayDeque<NavBackStackEntryState>> r119 = r118.next();
        String r120 = r119.getKey();
        ArrayDeque<NavBackStackEntryState> r121 = r119.getValue();
        r117.add(r120);
        Parcelable[] r122 = new Parcelable[r121.size()];
        Iterator<NavBackStackEntryState> r123 = r121.iterator();
        int r124 = 0;
    L39:
        if (r123.hasNext() == false) goto L44;
        NavBackStackEntryState r125 = r123.next();
        int r126 = r124 + 1;
        if (r124 >= 0) goto L43;
        CollectionsKt.throwIndexOverflow();
    L43:
        r122[r124] = r125;
        r124 = r126;
        goto L39
    L44:
        r106.putParcelableArray(Intrinsics.stringPlus(KEY_BACK_STACK_STATES_PREFIX, r120), r122);
        goto L36
    L45:
        r106.putStringArrayList(KEY_BACK_STACK_STATES_IDS, r117);
    L47:
        if (this.deepLinkHandled == false) goto L51;
        if (r106 != null) goto L50;
        r106 = new Bundle();
    L50:
        r106.putBoolean(KEY_DEEP_LINK_HANDLED, this.deepLinkHandled);
    L51:
        return r106;
    L11:
        r106 = null;
        goto L13
    }

    private final boolean dispatchOnDestinationChanged() {
    L3:
        if (getBackQueue().isEmpty() == true) goto L7;
        if ((getBackQueue().last().getDestination() instanceof NavGraph) == false) goto L7;
        popEntryFromBackStack$default(this, getBackQueue().last(), false, null, 6, null);
    L7:
        NavBackStackEntry r100 = getBackQueue().lastOrNull();
        if (r100 == null) goto L10;
        this.backStackEntriesToDispatch.add(r100);
    L10:
        this.dispatchReentrantCount++;
        updateBackStackLifecycle$navigation_runtime_release();
        int r101 = this.dispatchReentrantCount - 1;
        this.dispatchReentrantCount = r101;
        if (r101 != 0) goto L21;
        List r102 = CollectionsKt.toMutableList(this.backStackEntriesToDispatch);
        this.backStackEntriesToDispatch.clear();
        Iterator r103 = r102.iterator();
    L14:
        if (r103.hasNext() == false) goto L20;
        NavBackStackEntry r104 = (NavBackStackEntry) r103.next();
        Iterator<OnDestinationChangedListener> r105 = this.onDestinationChangedListeners.iterator();
    L17:
        if (r105.hasNext() == false) goto L19;
        r105.next().onDestinationChanged(this, r104.getDestination(), r104.getArguments());
        goto L17
    L19:
        this._currentBackStackEntryFlow.tryEmit(r104);
        goto L14
    L20:
        this._visibleEntries.tryEmit(populateVisibleEntries$navigation_runtime_release());
    L21:
        if (r100 != null) goto L29;
        return false;
    L29:
        return true;
    }

    private final int getDestinationCountOnBackStack() {
        ArrayDeque<NavBackStackEntry> r100 = getBackQueue();
        int r101 = 0;
        if ((r100 instanceof Collection) == true) goto L5;
    L7:
        Iterator<NavBackStackEntry> r102 = r100.iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        if ((!(r102.next().getDestination() instanceof NavGraph)) == false) goto L9;
        r101 = r101 + 1;
        if (r101 >= 0) goto L9;
        CollectionsKt.throwCountOverflow();
    L15:
        return r101;
    L5:
        if (r100.isEmpty() == false) goto L7;
        goto L7
    }

    private final boolean tryRelaunchUpToGeneratedStack() {
        NavDestination r100 = getCurrentDestination();
        Intrinsics.checkNotNull(r100);
        int r101 = r100.getId();
        NavGraph r102 = r100.getParent();
    L3:
        if (r102 == null) goto L22;
        if (r102.getStartDestinationId() != r101) goto L6;
        r101 = r102.getId();
        r102 = r102.getParent();
        goto L3
    L6:
        Bundle r103 = new Bundle();
        Activity r104 = this.activity;
        if (r104 == null) goto L15;
        Intrinsics.checkNotNull(r104);
        if (r104.getIntent() == null) goto L15;
        Activity r105 = this.activity;
        Intrinsics.checkNotNull(r105);
        if (r105.getIntent().getData() == null) goto L15;
        Activity r106 = this.activity;
        Intrinsics.checkNotNull(r106);
        r103.putParcelable(KEY_DEEP_LINK_INTENT, r106.getIntent());
        NavGraph r107 = this._graph;
        Intrinsics.checkNotNull(r107);
        Activity r108 = this.activity;
        Intrinsics.checkNotNull(r108);
        NavDestination.DeepLinkMatch r109 = r107.matchDeepLink(new NavDeepLinkRequest(r108.getIntent()));
        if (r109 == null) goto L15;
        r103.putAll(r109.getDestination().addInDefaultArgs(r109.getMatchingArgs()));
    L15:
        NavDeepLinkBuilder.setDestination$default(new NavDeepLinkBuilder(this), r102.getId(), null, 2, null).setArguments(r103).createTaskStackBuilder().startActivities();
        Activity r110 = this.activity;
        if (r110 == null) goto L26;
        r110.finish();
        return true;
    L26:
        return true;
    L22:
        return false;
    }

    public NavBackStackEntry getCurrentBackStackEntry() {
        return getBackQueue().lastOrNull();
    }

    public NavDestination getCurrentDestination() {
        NavBackStackEntry r100 = getCurrentBackStackEntry();
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.getDestination();
    }

    public NavBackStackEntry getPreviousBackStackEntry() {
        Iterator r100 = CollectionsKt.reversed(getBackQueue()).iterator();
        if (r100.hasNext() == false) goto L5;
        r100.next();
    L5:
        Iterator r101 = SequencesKt.asSequence(r100).iterator();
    L7:
        if (r101.hasNext() == false) goto L11;
        Object r102 = r101.next();
        if ((!(((NavBackStackEntry) r102).getDestination() instanceof NavGraph)) == false) goto L7;
    L13:
        return (NavBackStackEntry) r102;
    L11:
        r102 = null;
        goto L13
    }

    public boolean navigateUp() {
        if (getDestinationCountOnBackStack() != 1) goto L20;
        Activity r100 = this.activity;
        int[] r101 = null;
        if (r100 != null) goto L7;
    L6:
        Bundle r102 = null;
    L11:
        if (r102 == null) goto L14;
        r101 = r102.getIntArray(KEY_DEEP_LINK_IDS);
    L14:
        if (r101 == null) goto L18;
        return tryRelaunchUpToExplicitStack();
    L18:
        return tryRelaunchUpToGeneratedStack();
    L7:
        Intent r103 = r100.getIntent();
        if (r103 == null) goto L6;
        r102 = r103.getExtras();
        goto L11
    L20:
        return popBackStack();
    }

    public boolean popBackStack() {
        if (getBackQueue().isEmpty() == false) goto L5;
        return false;
    L5:
        NavDestination r100 = getCurrentDestination();
        Intrinsics.checkNotNull(r100);
        return popBackStack(r100.getId(), true);
    }

    public final void updateBackStackLifecycle$navigation_runtime_release() {
        List r100 = CollectionsKt.toMutableList(getBackQueue());
        if (r100.isEmpty() == false) goto L5;
        return;
    L5:
        NavDestination r101 = ((NavBackStackEntry) CollectionsKt.last(r100)).getDestination();
        if ((r101 instanceof FloatingWindow) == false) goto L15;
        Iterator r102 = CollectionsKt.reversed(r100).iterator();
    L9:
        if (r102.hasNext() == false) goto L15;
        NavDestination r103 = ((NavBackStackEntry) r102.next()).getDestination();
        if ((r103 instanceof NavGraph) == true) goto L9;
        if ((r103 instanceof FloatingWindow) == true) goto L9;
    L16:
        HashMap r104 = new HashMap();
        Iterator r105 = CollectionsKt.reversed(r100).iterator();
    L18:
        if (r105.hasNext() == false) goto L58;
        NavBackStackEntry r106 = (NavBackStackEntry) r105.next();
        Lifecycle.State r107 = r106.getMaxLifecycle();
        NavDestination r108 = r106.getDestination();
        if (r101 == null) goto L47;
        if (r108.getId() != r101.getId()) goto L47;
        Lifecycle.State r109 = Lifecycle.State.RESUMED;
        if (r107 == r109) goto L46;
        NavControllerNavigatorState r110 = this.navigatorState.get(getNavigatorProvider().getNavigator(r106.getDestination().getNavigatorName()));
        if (r110 != null) goto L28;
    L27:
        Boolean r111 = null;
    L36:
        if (Intrinsics.areEqual(r111, Boolean.TRUE) == true) goto L45;
        AtomicInteger r112 = this.parentToChildCount.get(r106);
        boolean r113 = false;
        if (r112 != null) goto L41;
    L43:
        if (r113 == true) goto L45;
        r104.put(r106, r109);
        goto L46
    L41:
        if (r112.get() != 0) goto L43;
        r113 = true;
    L45:
        r104.put(r106, Lifecycle.State.STARTED);
        goto L46
    L28:
        i1<Set<NavBackStackEntry>> r114 = r110.getTransitionsInProgress();
        if (r114 == null) goto L27;
        Set<NavBackStackEntry> r115 = r114.getValue();
        if (r115 == null) goto L27;
        r111 = Boolean.valueOf(r115.contains(r106));
    L46:
        r101 = r101.getParent();
    L47:
        if (r103 == null) goto L57;
        if (r108.getId() != r103.getId()) goto L57;
        if (r107 != Lifecycle.State.RESUMED) goto L53;
        r106.setMaxLifecycle(Lifecycle.State.STARTED);
    L56:
        r103 = r103.getParent();
        goto L18
    L53:
        Lifecycle.State r116 = Lifecycle.State.STARTED;
        if (r107 == r116) goto L56;
        r104.put(r106, r116);
    L57:
        r106.setMaxLifecycle(Lifecycle.State.CREATED);
        goto L18
    L58:
        Iterator r117 = r100.iterator();
    L60:
        if (r117.hasNext() == false) goto L65;
        NavBackStackEntry r118 = (NavBackStackEntry) r117.next();
        Lifecycle.State r119 = (Lifecycle.State) r104.get(r118);
        if (r119 != null) goto L63;
        r118.updateState();
        goto L60
    L63:
        r118.setMaxLifecycle(r119);
        goto L60
    L65:
        return;
    L15:
        r103 = null;
        goto L16
    }

    public static final /* synthetic */ boolean access$getDeepLinkSaveState$cp() {
        return deepLinkSaveState;
    }

    public ArrayDeque<NavBackStackEntry> getBackQueue() {
        return this.backQueue;
    }

    public final Context getContext() {
        return this.context;
    }

    public final Flow<NavBackStackEntry> getCurrentBackStackEntryFlow() {
        return this.currentBackStackEntryFlow;
    }

    public NavigatorProvider getNavigatorProvider() {
        return this._navigatorProvider;
    }

    public final i1<List<NavBackStackEntry>> getVisibleEntries() {
        return this.visibleEntries;
    }

    public NavController(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.context = r100;
        Iterator r101 = SequencesKt.generateSequence(r100, NavController$activity$1.INSTANCE).iterator();
    L4:
        if (r101.hasNext() == false) goto L8;
        Object r102 = r101.next();
        if ((((Context) r102) instanceof Activity) == false) goto L4;
    L9:
        this.activity = (Activity) r102;
        this.backQueue = new ArrayDeque();
        StateFlowImpl r103 = j1.a(CollectionsKt.emptyList());
        this._visibleEntries = r103;
        this.visibleEntries = e.b(r103);
        this.childToParentEntries = new LinkedHashMap();
        this.parentToChildCount = new LinkedHashMap();
        this.backStackMap = new LinkedHashMap();
        this.backStackStates = new LinkedHashMap();
        this.onDestinationChangedListeners = new CopyOnWriteArrayList();
        this.hostLifecycleState = Lifecycle.State.INITIALIZED;
        this.lifecycleObserver = new a(this);
        this.onBackPressedCallback = new NavController$onBackPressedCallback$1(this);
        this.enableOnBackPressedCallback = true;
        this._navigatorProvider = new NavigatorProvider();
        this.navigatorState = new LinkedHashMap();
        this.entrySavedState = new LinkedHashMap();
        NavigatorProvider r104 = this._navigatorProvider;
        r104.addNavigator(new NavGraphNavigator(r104));
        this._navigatorProvider.addNavigator(new ActivityNavigator(this.context));
        this.backStackEntriesToDispatch = new ArrayList();
        this.navInflater$delegate = LazyKt.lazy(new NavController$navInflater$2(this));
        MutableSharedFlow<NavBackStackEntry> r105 = SharedFlowKt.MutableSharedFlow$default(1, 0, BufferOverflow.DROP_OLDEST, 2, null);
        this._currentBackStackEntryFlow = r105;
        this.currentBackStackEntryFlow = e.a(r105);
        return;
    L8:
        r102 = null;
        goto L9
    }

    public static final /* synthetic */ Function1 access$getAddToBackStackHandler$p(NavController r100) {
        return r100.addToBackStackHandler;
    }

    public static final /* synthetic */ Map access$getBackStackMap$p(NavController r100) {
        return r100.backStackMap;
    }

    public static final /* synthetic */ Map access$getEntrySavedState$p(NavController r100) {
        return r100.entrySavedState;
    }

    public static final /* synthetic */ NavInflater access$getInflater$p(NavController r100) {
        return r100.inflater;
    }

    public static final /* synthetic */ Map access$getNavigatorState$p(NavController r100) {
        return r100.navigatorState;
    }

    public static final /* synthetic */ Function1 access$getPopFromBackStackHandler$p(NavController r100) {
        return r100.popFromBackStackHandler;
    }

    public static final /* synthetic */ NavControllerViewModel access$getViewModel$p(NavController r100) {
        return r100.viewModel;
    }

    public static final /* synthetic */ NavigatorProvider access$get_navigatorProvider$p(NavController r100) {
        return r100._navigatorProvider;
    }

    public static final /* synthetic */ z0 access$get_visibleEntries$p(NavController r100) {
        return r100._visibleEntries;
    }

    public static final /* synthetic */ void access$setDeepLinkSaveState$cp(boolean r100) {
        deepLinkSaveState = r100;
    }

    private final boolean clearBackStackInternal(int r100) {
        Iterator<T> r101 = this.navigatorState.values().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        ((NavControllerNavigatorState) r101.next()).setNavigating(true);
        goto L4
    L6:
        boolean r102 = restoreStateInternal(r100, null, null, null);
        Iterator<T> r103 = this.navigatorState.values().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        ((NavControllerNavigatorState) r103.next()).setNavigating(false);
        goto L8
    L10:
        if (r102 == true) goto L12;
    L14:
        return false;
    L12:
        if (popBackStackInternal(r100, true, false) == false) goto L14;
        return true;
    }

    private final String findInvalidDestinationDisplayNameInDeepLink(int[] r100) {
        NavGraph r101 = this._graph;
        int r102 = r100.length;
        int r103 = 0;
    L3:
        NavDestination r104 = null;
        if (r103 >= r102) goto L23;
        int r105 = r103 + 1;
        int r106 = r100[r103];
        if (r103 != 0) goto L10;
        NavGraph r107 = this._graph;
        Intrinsics.checkNotNull(r107);
        if (r107.getId() != r106) goto L11;
        r104 = this._graph;
    L11:
        if (r104 == null) goto L13;
        if (r103 == (r100.length - 1)) goto L22;
        if ((r104 instanceof NavGraph) == false) goto L22;
        r101 = (NavGraph) r104;
    L19:
        Intrinsics.checkNotNull(r101);
        if ((r101.findNode(r101.getStartDestinationId()) instanceof NavGraph) == false) goto L22;
        r101 = (NavGraph) r101.findNode(r101.getStartDestinationId());
    L22:
        r103 = r105;
        goto L3
    L13:
        return NavDestination.Companion.getDisplayName(this.context, r106);
    L10:
        Intrinsics.checkNotNull(r101);
        r104 = r101.findNode(r106);
        goto L11
    L23:
        return null;
    }

    private final List<NavBackStackEntry> instantiateBackStack(ArrayDeque<NavBackStackEntryState> r100) {
        ArrayList r101 = new ArrayList();
        NavBackStackEntry r102 = getBackQueue().lastOrNull();
        if (r102 != null) goto L5;
        NavDestination r103 = null;
    L6:
        if (r103 != null) goto L8;
        r103 = getGraph();
    L8:
        if (r100 == null) goto L18;
        Iterator<NavBackStackEntryState> r104 = r100.iterator();
    L12:
        if (r104.hasNext() == false) goto L18;
        NavBackStackEntryState r105 = r104.next();
        NavDestination r106 = findDestination(r103, r105.getDestinationId());
        if (r106 == null) goto L17;
        r101.add(r105.instantiate(getContext(), r106, getHostLifecycleState$navigation_runtime_release(), this.viewModel));
        r103 = r106;
        goto L12
    L17:
        throw new IllegalStateException(("Restore State failed: destination " + NavDestination.Companion.getDisplayName(getContext(), r105.getDestinationId()) + " cannot be found from the current destination " + r103).toString());
    L18:
        return r101;
    L5:
        r103 = r102.getDestination();
        goto L6
    }

    private final void onGraphCreated(Bundle r110) {
        Bundle r100 = this.navigatorStateToRestore;
        if (r100 == null) goto L13;
        ArrayList<String> r101 = r100.getStringArrayList(KEY_NAVIGATOR_STATE_NAMES);
        if (r101 == null) goto L13;
        Iterator<String> r102 = r101.iterator();
    L9:
        if (r102.hasNext() == false) goto L13;
        String r103 = r102.next();
        Navigator r104 = this._navigatorProvider.getNavigator(r103);
        Bundle r105 = r100.getBundle(r103);
        if (r105 == null) goto L9;
        r104.onRestoreState(r105);
    L13:
        Parcelable[] r106 = this.backStackToRestore;
        boolean r107 = false;
        if (r106 == null) goto L29;
        int r108 = r106.length;
        int r109 = 0;
    L17:
        if (r109 >= r108) goto L28;
        Parcelable r111 = r106[r109];
        r109 = r109 + 1;
        NavBackStackEntryState r112 = (NavBackStackEntryState) r111;
        NavDestination r113 = findDestination(r112.getDestinationId());
        if (r113 == null) goto L27;
        NavBackStackEntry r114 = r112.instantiate(getContext(), r113, getHostLifecycleState$navigation_runtime_release(), this.viewModel);
        Navigator<? extends NavDestination> r115 = this._navigatorProvider.getNavigator(r113.getNavigatorName());
        Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> r116 = this.navigatorState;
        NavControllerNavigatorState r117 = r116.get(r115);
        if (r117 != null) goto L23;
        r117 = new NavControllerNavigatorState(this, r115);
        r116.put(r115, r117);
    L23:
        getBackQueue().add(r114);
        r117.addInternal(r114);
        NavGraph r118 = r114.getDestination().getParent();
        if (r118 == null) goto L17;
        linkChildToParent(r114, getBackStackEntry(r118.getId()));
        goto L17
    L27:
        throw new IllegalStateException("Restoring the Navigation back stack failed: destination " + NavDestination.Companion.getDisplayName(getContext(), r112.getDestinationId()) + " cannot be found from the current destination " + getCurrentDestination());
    L28:
        updateOnBackPressedCallbackEnabled();
        this.backStackToRestore = null;
    L29:
        Collection<Navigator<? extends NavDestination>> r119 = this._navigatorProvider.getNavigators().values();
        ArrayList r120 = new ArrayList();
        Iterator<T> r121 = r119.iterator();
    L31:
        if (r121.hasNext() == false) goto L35;
        Object r122 = r121.next();
        if (((Navigator) r122).isAttached() == true) goto L31;
        r120.add(r122);
        goto L31
    L35:
        Iterator r123 = r120.iterator();
    L37:
        if (r123.hasNext() == false) goto L43;
        Navigator<? extends NavDestination> r124 = (Navigator) r123.next();
        Map<Navigator<? extends NavDestination>, NavControllerNavigatorState> r125 = this.navigatorState;
        NavControllerNavigatorState r126 = r125.get(r124);
        if (r126 != null) goto L41;
        r126 = new NavControllerNavigatorState(this, r124);
        r125.put(r124, r126);
    L41:
        r124.onAttach(r126);
        goto L37
    L43:
        if (this._graph != null) goto L45;
    L55:
        dispatchOnDestinationChanged();
        return;
    L45:
        if (getBackQueue().isEmpty() == false) goto L55;
        if (this.deepLinkHandled == true) goto L53;
        Activity r127 = this.activity;
        if (r127 == null) goto L53;
        Intrinsics.checkNotNull(r127);
        if (handleDeepLink(r127.getIntent()) == false) goto L53;
        r107 = true;
    L53:
        if (r107 == true) goto L76;
        NavGraph r128 = this._graph;
        Intrinsics.checkNotNull(r128);
        navigate(r128, r110, null, null);
        return;
    }

    public void addOnDestinationChangedListener(OnDestinationChangedListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.onDestinationChangedListeners.add(r100);
        if ((!getBackQueue().isEmpty()) == false) goto L6;
        NavBackStackEntry r101 = getBackQueue().last();
        r100.onDestinationChanged(this, r101.getDestination(), r101.getArguments());
        return;
    }

    public final boolean clearBackStack(String r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return clearBackStack(NavDestination.Companion.createRoute(r100).hashCode());
    }

    public void enableOnBackPressed(boolean r100) {
        this.enableOnBackPressedCallback = r100;
        updateOnBackPressedCallbackEnabled();
    }

    public final NavDestination findDestination(String r100) {
        Intrinsics.checkNotNullParameter(r100, "destinationRoute");
        NavGraph r101 = this._graph;
        NavGraph r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNull(r101);
        if (Intrinsics.areEqual(r101.getRoute(), r100) == true) goto L8;
        NavBackStackEntry r103 = getBackQueue().lastOrNull();
        if (r103 == null) goto L13;
        r102 = r103.getDestination();
    L13:
        if (r102 != null) goto L16;
        r102 = this._graph;
        Intrinsics.checkNotNull(r102);
    L16:
        if ((r102 instanceof NavGraph) == false) goto L18;
        NavGraph r104 = r102;
    L20:
        return r104.findNode(r100);
    L18:
        r104 = r102.getParent();
        Intrinsics.checkNotNull(r104);
        goto L20
    L8:
        return this._graph;
    }

    public final NavBackStackEntry getBackStackEntry(String r100) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        ArrayDeque<NavBackStackEntry> r101 = getBackQueue();
        ListIterator<NavBackStackEntry> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L8;
        NavBackStackEntry r103 = r102.previous();
        if (Intrinsics.areEqual(r103.getDestination().getRoute(), r100) == false) goto L4;
    L9:
        NavBackStackEntry r104 = r103;
        if (r104 == null) goto L13;
        return r104;
    L13:
        throw new IllegalArgumentException(("No destination with route " + r100 + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    L8:
        r103 = null;
        goto L9
    }

    public ViewModelStoreOwner getViewModelStoreOwner(int r100) {
        if (this.viewModel == null) goto L10;
        NavBackStackEntry r101 = getBackStackEntry(r100);
        if ((r101.getDestination() instanceof NavGraph) == false) goto L8;
        return r101;
    L8:
        throw new IllegalArgumentException(("No NavGraph with ID " + r100 + " is on the NavController's back stack").toString());
    L10:
        throw new IllegalStateException("You must call setViewModelStore() before calling getViewModelStoreOwner().".toString());
    }

    public boolean handleDeepLink(Intent r210) {
        int r100 = 0;
        if (r210 != null) goto L5;
        return false;
    L5:
        Bundle r101 = r210.getExtras();
        if (r101 != null) goto L8;
        int[] r102 = null;
    L9:
        if (r101 != null) goto L11;
        ArrayList r103 = null;
    L12:
        Bundle r104 = new Bundle();
        if (r101 != null) goto L15;
        Bundle r105 = null;
    L16:
        if (r105 == null) goto L19;
        r104.putAll(r105);
    L19:
        if (r102 != null) goto L21;
    L25:
        NavGraph r106 = this._graph;
        Intrinsics.checkNotNull(r106);
        NavDestination.DeepLinkMatch r107 = r106.matchDeepLink(new NavDeepLinkRequest(r210));
        if (r107 == null) goto L31;
        NavDestination r108 = r107.getDestination();
        int[] r109 = NavDestination.buildDeepLinkIds$default(r108, null, 1, null);
        Bundle r110 = r108.addInDefaultArgs(r107.getMatchingArgs());
        if (r110 == null) goto L30;
        r104.putAll(r110);
    L30:
        int[] r111 = r109;
        r103 = null;
    L32:
        if (r111 != null) goto L34;
    L94:
        return false;
    L34:
        if (r111.length != 0) goto L36;
        boolean r112 = true;
    L37:
        if (r112 == true) goto L94;
        if (findInvalidDestinationDisplayNameInDeepLink(r111) == null) goto L43;
        r210.toString();
        return false;
    L43:
        r104.putParcelable(KEY_DEEP_LINK_INTENT, r210);
        int r113 = r111.length;
        Bundle[] r114 = new Bundle[r113];
        int r115 = 0;
    L44:
        if (r115 >= r113) goto L51;
        int r116 = r115 + 1;
        Bundle r117 = new Bundle();
        r117.putAll(r104);
        if (r103 == null) goto L50;
        Bundle r118 = (Bundle) ListProtector.get(r103, r115);
        if (r118 == null) goto L50;
        r117.putAll(r118);
    L50:
        r114[r115] = r117;
        r115 = r116;
        goto L44
    L51:
        int r119 = r210.getFlags();
        int r120 = 268435456 & r119;
        if (r120 == 0) goto L61;
        if ((r119 & 32768) != 0) goto L61;
        r210.addFlags(32768);
        TaskStackBuilder.create(this.context).addNextIntentWithParentStack(r210).startActivities();
        Activity r121 = this.activity;
        if (r121 == null) goto L59;
        r121.finish();
        r121.overridePendingTransition(0, 0);
    L59:
        return true;
    L61:
        if (r120 != 0) goto L63;
        NavGraph r122 = this._graph;
        int r123 = r111.length;
        int r124 = 0;
    L74:
        if (r124 >= r123) goto L92;
        int r125 = r124 + 1;
        int r126 = r111[r124];
        Bundle r127 = r114[r124];
        if (r124 != 0) goto L78;
        NavDestination r128 = this._graph;
    L79:
        if (r128 == null) goto L91;
        if (r124 != (r111.length - 1)) goto L83;
        NavOptions.Builder r129 = new NavOptions.Builder();
        NavGraph r130 = this._graph;
        Intrinsics.checkNotNull(r130);
        navigate(r128, r127, NavOptions.Builder.setPopUpTo$default(r129, r130.getId(), true, false, 4, null).setEnterAnim(0).setExitAnim(0).build(), null);
    L89:
        r124 = r125;
        goto L74
    L83:
        if ((r128 instanceof NavGraph) == false) goto L89;
        r122 = (NavGraph) r128;
    L85:
        Intrinsics.checkNotNull(r122);
        if ((r122.findNode(r122.getStartDestinationId()) instanceof NavGraph) == false) goto L89;
        r122 = (NavGraph) r122.findNode(r122.getStartDestinationId());
        goto L85
    L91:
        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.Companion.getDisplayName(this.context, r126) + " cannot be found in graph " + r122);
    L78:
        Intrinsics.checkNotNull(r122);
        r128 = r122.findNode(r126);
        goto L79
    L92:
        this.deepLinkHandled = true;
        return true;
    L63:
        if (getBackQueue().isEmpty() == true) goto L66;
        NavGraph r131 = this._graph;
        Intrinsics.checkNotNull(r131);
        popBackStackInternal$default(this, r131.getId(), true, false, 4, null);
    L66:
        if (r100 >= r111.length) goto L72;
        int r132 = r111[r100];
        int r133 = r100 + 1;
        Bundle r134 = r114[r100];
        final NavDestination r135 = findDestination(r132);
        if (r135 == null) goto L71;
        navigate(r135, r134, NavOptionsBuilderKt.navOptions(new AnonymousClass2(r135, this)), null);
        r100 = r133;
        goto L66
    L71:
        throw new IllegalStateException("Deep Linking failed: destination " + NavDestination.Companion.getDisplayName(this.context, r132) + " cannot be found from the current destination " + getCurrentDestination());
    L72:
        return true;
    L36:
        r112 = false;
    L31:
        r111 = r102;
        goto L32
    L21:
        if (r102.length != 0) goto L23;
        boolean r136 = true;
    L24:
        if (r136 == false) goto L31;
    L23:
        r136 = false;
        goto L24
    L15:
        r105 = r101.getBundle(KEY_DEEP_LINK_EXTRAS);
        goto L16
    L11:
        r103 = r101.getParcelableArrayList(KEY_DEEP_LINK_ARGS);
        goto L12
    L8:
        r102 = r101.getIntArray(KEY_DEEP_LINK_IDS);
        goto L9
    }

    public void navigate(NavDirections r100) {
        Intrinsics.checkNotNullParameter(r100, "directions");
        navigate(r100.getActionId(), r100.getArguments(), null);
    }

    public void removeOnDestinationChangedListener(OnDestinationChangedListener r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.onDestinationChangedListeners.remove(r100);
    }

    public void restoreState(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setClassLoader(this.context.getClassLoader());
        this.navigatorStateToRestore = r100.getBundle(KEY_NAVIGATOR_STATE);
        this.backStackToRestore = r100.getParcelableArray(KEY_BACK_STACK);
        this.backStackStates.clear();
        int[] r101 = r100.getIntArray(KEY_BACK_STACK_DEST_IDS);
        ArrayList<String> r102 = r100.getStringArrayList(KEY_BACK_STACK_IDS);
        if (r101 == null) goto L10;
        if (r102 == null) goto L10;
        int r103 = r101.length;
        int r104 = 0;
        int r105 = 0;
    L8:
        if (r104 >= r103) goto L10;
        int r106 = r101[r104];
        r104 = r104 + 1;
        int r107 = r105 + 1;
        this.backStackMap.put(Integer.valueOf(r106), (String) ListProtector.get(r102, r105));
        r105 = r107;
    L10:
        ArrayList<String> r108 = r100.getStringArrayList(KEY_BACK_STACK_STATES_IDS);
        if (r108 == null) goto L27;
        Iterator<T> r109 = r108.iterator();
    L15:
        if (r109.hasNext() == false) goto L27;
        String r110 = (String) r109.next();
        Parcelable[] r111 = r100.getParcelableArray(Intrinsics.stringPlus(KEY_BACK_STACK_STATES_PREFIX, r110));
        if (r111 == null) goto L15;
        Map<String, ArrayDeque<NavBackStackEntryState>> r112 = this.backStackStates;
        ArrayDeque<NavBackStackEntryState> r113 = new ArrayDeque(r111.length);
        Iterator r114 = ArrayIteratorKt.iterator(r111);
    L20:
        if (r114.hasNext() == false) goto L26;
        Parcelable r115 = (Parcelable) r114.next();
        if (r115 == null) goto L25;
        r113.add((NavBackStackEntryState) r115);
        goto L20
    L25:
        throw new NullPointerException("null cannot be cast to non-null type androidx.navigation.NavBackStackEntryState");
    L26:
        Unit r116 = Unit.INSTANCE;
        r112.put(r110, r113);
    L27:
        this.deepLinkHandled = r100.getBoolean(KEY_DEEP_LINK_HANDLED);
    }

    public void setGraph(int r100) {
        setGraph(getNavInflater().inflate(r100), null);
    }

    public final void setHostLifecycleState$navigation_runtime_release(Lifecycle.State r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.hostLifecycleState = r100;
    }

    public void setLifecycleOwner(LifecycleOwner r100) {
        Intrinsics.checkNotNullParameter(r100, "owner");
        if (Intrinsics.areEqual(r100, this.lifecycleOwner) == false) goto L5;
        return;
    L5:
        LifecycleOwner r101 = this.lifecycleOwner;
        if (r101 == null) goto L12;
        Lifecycle r102 = r101.getLifecycle();
        if (r102 == null) goto L12;
        r102.removeObserver(this.lifecycleObserver);
    L12:
        this.lifecycleOwner = r100;
        r100.getLifecycle().addObserver(this.lifecycleObserver);
    }

    public void setNavigatorProvider(NavigatorProvider r100) {
        Intrinsics.checkNotNullParameter(r100, "navigatorProvider");
        if (getBackQueue().isEmpty() == false) goto L7;
        this._navigatorProvider = r100;
        return;
    L7:
        throw new IllegalStateException("NavigatorProvider must be set before setGraph call".toString());
    }

    public void setOnBackPressedDispatcher(OnBackPressedDispatcher r100) {
        Intrinsics.checkNotNullParameter(r100, "dispatcher");
        if (Intrinsics.areEqual(r100, this.onBackPressedDispatcher) == false) goto L5;
        return;
    L5:
        LifecycleOwner r101 = this.lifecycleOwner;
        if (r101 == null) goto L10;
        this.onBackPressedCallback.remove();
        this.onBackPressedDispatcher = r100;
        r100.addCallback(r101, this.onBackPressedCallback);
        Lifecycle r102 = r101.getLifecycle();
        r102.removeObserver(this.lifecycleObserver);
        r102.addObserver(this.lifecycleObserver);
        return;
    L10:
        throw new IllegalStateException("You must call setLifecycleOwner() before calling setOnBackPressedDispatcher()".toString());
    }

    public void setViewModelStore(ViewModelStore r100) {
        Intrinsics.checkNotNullParameter(r100, "viewModelStore");
        NavControllerViewModel r101 = this.viewModel;
        NavControllerViewModel.Companion r102 = NavControllerViewModel.Companion;
        if (Intrinsics.areEqual(r101, r102.getInstance(r100)) == false) goto L6;
        return;
    L6:
        if (getBackQueue().isEmpty() == false) goto L10;
        this.viewModel = r102.getInstance(r100);
        return;
    L10:
        throw new IllegalStateException("ViewModelStore should be set before setGraph call".toString());
    }

    public final NavBackStackEntry unlinkChildFromParent$navigation_runtime_release(NavBackStackEntry r100) {
        Intrinsics.checkNotNullParameter(r100, MapBundleKey.OfflineMapKey.OFFLINE_CHILD);
        NavBackStackEntry r101 = this.childToParentEntries.remove(r100);
        Integer r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        AtomicInteger r103 = this.parentToChildCount.get(r101);
        if (r103 == null) goto L9;
        r102 = Integer.valueOf(r103.decrementAndGet());
    L9:
        if (r102 != null) goto L12;
    L18:
        return r101;
    L12:
        if (r102.intValue() != 0) goto L18;
        Navigator r104 = this._navigatorProvider.getNavigator(r101.getDestination().getNavigatorName());
        NavControllerNavigatorState r105 = this.navigatorState.get(r104);
        if (r105 == null) goto L17;
        r105.markTransitionComplete(r101);
    L17:
        this.parentToChildCount.remove(r101);
        goto L18
    }

    public final boolean clearBackStack(int r100) {
        if (clearBackStackInternal(r100) == true) goto L5;
    L7:
        return false;
    L5:
        if (dispatchOnDestinationChanged() == false) goto L7;
        return true;
    }

    public final NavDestination findDestination(int r100) {
        NavGraph r101 = this._graph;
        NavDestination r102 = null;
        if (r101 != null) goto L5;
        return null;
    L5:
        Intrinsics.checkNotNull(r101);
        if (r101.getId() == r100) goto L8;
        NavBackStackEntry r103 = getBackQueue().lastOrNull();
        if (r103 == null) goto L13;
        r102 = r103.getDestination();
    L13:
        if (r102 != null) goto L16;
        r102 = this._graph;
        Intrinsics.checkNotNull(r102);
    L16:
        return findDestination(r102, r100);
    L8:
        return this._graph;
    }

    public NavBackStackEntry getBackStackEntry(int r100) {
        ArrayDeque<NavBackStackEntry> r101 = getBackQueue();
        ListIterator<NavBackStackEntry> r102 = r101.listIterator(r101.size());
    L4:
        if (r102.hasPrevious() == false) goto L11;
        NavBackStackEntry r103 = r102.previous();
        if (r103.getDestination().getId() != r100) goto L8;
        boolean r104 = true;
    L9:
        if (r104 == false) goto L4;
    L12:
        NavBackStackEntry r105 = r103;
        if (r105 == null) goto L16;
        return r105;
    L16:
        throw new IllegalArgumentException(("No destination with ID " + r100 + " is on the NavController's back stack. The current destination is " + getCurrentDestination()).toString());
    L8:
        r104 = false;
        goto L9
    L11:
        r103 = null;
        goto L12
    }

    public void navigate(Uri r100) {
        Intrinsics.checkNotNullParameter(r100, "deepLink");
        navigate(new NavDeepLinkRequest(r100, null, null));
    }

    public void setGraph(NavGraph r100) {
        Intrinsics.checkNotNullParameter(r100, "graph");
        setGraph(r100, null);
    }

    public void navigate(NavDeepLinkRequest r100) {
        Intrinsics.checkNotNullParameter(r100, "request");
        navigate(r100, null);
    }

    public void navigate(int r100) {
        navigate(r100, null);
    }

    private final NavDestination findDestination(NavDestination r100, int r101) {
        if (r100.getId() != r101) goto L6;
        return r100;
    L6:
        if ((r100 instanceof NavGraph) == false) goto L8;
        NavGraph r102 = (NavGraph) r100;
    L10:
        return r102.findNode(r101);
    L8:
        r102 = r100.getParent();
        Intrinsics.checkNotNull(r102);
        goto L10
    }

    private final void linkChildToParent(NavBackStackEntry r100, NavBackStackEntry r101) {
        this.childToParentEntries.put(r100, r101);
        if (this.parentToChildCount.get(r101) != null) goto L5;
        this.parentToChildCount.put(r101, new AtomicInteger(0));
    L5:
        AtomicInteger r102 = this.parentToChildCount.get(r101);
        Intrinsics.checkNotNull(r102);
        r102.incrementAndGet();
    }

    public void navigate(NavDirections r100, Navigator.Extras r101) {
        Intrinsics.checkNotNullParameter(r100, "directions");
        Intrinsics.checkNotNullParameter(r101, "navigatorExtras");
        navigate(r100.getActionId(), r100.getArguments(), null, r101);
    }

    public boolean popBackStack(int r100, boolean r101) {
        return popBackStack(r100, r101, false);
    }

    public final void popBackStackFromNavigator$navigation_runtime_release(NavBackStackEntry r110, Function0<Unit> r111) {
        Intrinsics.checkNotNullParameter(r110, "popUpTo");
        Intrinsics.checkNotNullParameter(r111, "onComplete");
        int r100 = getBackQueue().indexOf(r110);
        if (r100 >= 0) goto L6;
        Objects.toString(r110);
        return;
    L6:
        int r101 = r100 + 1;
        if (r101 == getBackQueue().size()) goto L9;
        popBackStackInternal(getBackQueue().get(r101).getDestination().getId(), true, false);
    L9:
        popEntryFromBackStack$default(this, r110, false, null, 6, null);
        r111.invoke();
        updateOnBackPressedCallbackEnabled();
        dispatchOnDestinationChanged();
    }

    public void setGraph(NavGraph r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "graph");
        if (Intrinsics.areEqual(this._graph, r110) == true) goto L13;
        NavGraph r100 = this._graph;
        if (r100 == null) goto L12;
        Iterator r101 = new ArrayList(this.backStackMap.keySet()).iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        clearBackStackInternal(((Integer) r101.next()).intValue());
        goto L9
    L11:
        popBackStackInternal$default(this, r100.getId(), true, false, 4, null);
    L12:
        this._graph = r110;
        onGraphCreated(r111);
        return;
    L13:
        int r112 = r110.getNodes().size();
        int r102 = 0;
    L14:
        if (r102 >= r112) goto L40;
        int r103 = r102 + 1;
        NavDestination r104 = r110.getNodes().valueAt(r102);
        NavGraph r105 = this._graph;
        Intrinsics.checkNotNull(r105);
        r105.getNodes().replace(r102, r104);
        ArrayDeque<NavBackStackEntry> r106 = getBackQueue();
        ArrayList r107 = new ArrayList();
        Iterator<NavBackStackEntry> r108 = r106.iterator();
    L17:
        if (r108.hasNext() == false) goto L26;
        NavBackStackEntry r109 = r108.next();
        int r113 = r109.getDestination().getId();
        if (r104 != null) goto L22;
    L20:
        boolean r114 = false;
    L24:
        if (r114 == false) goto L17;
        r107.add(r109);
        goto L17
    L22:
        if (r113 != r104.getId()) goto L20;
        r114 = true;
        goto L24
    L26:
        Iterator r115 = r107.iterator();
    L28:
        if (r115.hasNext() == false) goto L30;
        ((NavBackStackEntry) r115.next()).setDestination(r104);
        goto L28
    L30:
        r102 = r103;
        goto L14
    }

    public final void navigate(String r100, Function1<? super NavOptionsBuilder, Unit> r101) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        Intrinsics.checkNotNullParameter(r101, "builder");
        navigate$default(this, r100, NavOptionsBuilderKt.navOptions(r101), null, 4, null);
    }

    public void setGraph(int r100, Bundle r101) {
        setGraph(getNavInflater().inflate(r100), r101);
    }

    public void navigate(NavDirections r100, NavOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "directions");
        navigate(r100.getActionId(), r100.getArguments(), r101);
    }

    public void navigate(Uri r100, NavOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "deepLink");
        navigate(new NavDeepLinkRequest(r100, null, null), r101, null);
    }

    public void navigate(NavDeepLinkRequest r100, NavOptions r101) {
        Intrinsics.checkNotNullParameter(r100, "request");
        navigate(r100, r101, null);
    }

    public void navigate(int r100, Bundle r101) {
        navigate(r100, r101, null);
    }

    /* JADX INFO: renamed from: lifecycleObserver$lambda-2, reason: not valid java name */
    private static final void m7813lifecycleObserver$lambda2(NavController r100, LifecycleOwner r101, Lifecycle.Event r102) {
        Intrinsics.checkNotNullParameter(r100, "this$0");
        Intrinsics.checkNotNullParameter(r101, "$noName_0");
        Intrinsics.checkNotNullParameter(r102, "event");
        r100.hostLifecycleState = r102.getTargetState();
        if (r100._graph == null) goto L8;
        Iterator<NavBackStackEntry> r103 = r100.getBackQueue().iterator();
    L6:
        if (r103.hasNext() == false) goto L10;
        r103.next().handleLifecycleEvent(r102);
        goto L6
    L10:
        return;
    }

    private final boolean popBackStackInternal(int r110, boolean r111, final boolean r112) {
        if (getBackQueue().isEmpty() == false) goto L5;
        return false;
    L5:
        ArrayList r100 = new ArrayList();
        Iterator r101 = CollectionsKt.reversed(getBackQueue()).iterator();
    L7:
        if (r101.hasNext() == false) goto L16;
        NavDestination r102 = ((NavBackStackEntry) r101.next()).getDestination();
        Navigator r103 = this._navigatorProvider.getNavigator(r102.getNavigatorName());
        if (r111 == false) goto L11;
    L12:
        r100.add(r103);
    L14:
        if (r102.getId() != r110) goto L7;
        NavDestination r104 = r102;
    L17:
        if (r104 != null) goto L20;
        NavDestination.Companion.getDisplayName(this.context, r110);
        return false;
    L20:
        final Ref.BooleanRef r113 = new Ref.BooleanRef();
        final ArrayDeque<NavBackStackEntryState> r114 = new ArrayDeque();
        Iterator r115 = r100.iterator();
    L22:
        if (r115.hasNext() == false) goto L25;
        Navigator<? extends NavDestination> r116 = (Navigator) r115.next();
        final Ref.BooleanRef r117 = new Ref.BooleanRef();
        popBackStackInternal(r116, getBackQueue().last(), r112, new C87932(r117, r113, this, r112, r114));
        if (r117.element == true) goto L22;
    L25:
        if (r112 == false) goto L42;
        if (r111 == true) goto L36;
        Iterator r105 = SequencesKt.takeWhile(SequencesKt.generateSequence(r104, AnonymousClass3.INSTANCE), new C87944(this)).iterator();
    L29:
        if (r105.hasNext() == false) goto L36;
        NavDestination r106 = (NavDestination) r105.next();
        Map<Integer, String> r107 = this.backStackMap;
        Integer r108 = Integer.valueOf(r106.getId());
        NavBackStackEntryState r109 = r114.firstOrNull();
        if (r109 != null) goto L33;
        String r118 = null;
    L34:
        r107.put(r108, r118);
        goto L29
    L33:
        r118 = r109.getId();
    L36:
        if ((!r114.isEmpty()) == false) goto L42;
        NavBackStackEntryState r119 = r114.first();
        Iterator r120 = SequencesKt.takeWhile(SequencesKt.generateSequence(findDestination(r119.getDestinationId()), AnonymousClass6.INSTANCE), new AnonymousClass7(this)).iterator();
    L39:
        if (r120.hasNext() == false) goto L41;
        this.backStackMap.put(Integer.valueOf(((NavDestination) r120.next()).getId()), r119.getId());
        goto L39
    L41:
        this.backStackStates.put(r119.getId(), r114);
    L42:
        updateOnBackPressedCallbackEnabled();
        return r113.element;
    L11:
        if (r102.getId() == r110) goto L14;
    L16:
        r104 = null;
        goto L17
    }

    private final void popEntryFromBackStack(NavBackStackEntry r100, boolean r101, ArrayDeque<NavBackStackEntryState> r102) {
        NavBackStackEntry r103 = getBackQueue().last();
        if (Intrinsics.areEqual(r103, r100) == false) goto L36;
        getBackQueue().removeLast();
        NavControllerNavigatorState r104 = this.navigatorState.get(getNavigatorProvider().getNavigator(r103.getDestination().getNavigatorName()));
        boolean r105 = true;
        if (r104 != null) goto L7;
    L6:
        boolean r106 = false;
    L16:
        if (r106 == false) goto L18;
    L21:
        Lifecycle.State r107 = r103.getLifecycle().getCurrentState();
        Lifecycle.State r108 = Lifecycle.State.CREATED;
        if (r107.isAtLeast(r108) == false) goto L28;
        if (r101 == false) goto L25;
        r103.setMaxLifecycle(r108);
        r102.addFirst(new NavBackStackEntryState(r103));
    L25:
        if (r105 == true) goto L27;
        r103.setMaxLifecycle(Lifecycle.State.DESTROYED);
        unlinkChildFromParent$navigation_runtime_release(r103);
        goto L28
    L27:
        r103.setMaxLifecycle(r108);
    L28:
        if (r101 == true) goto L37;
        if (r105 == true) goto L38;
        NavControllerViewModel r109 = this.viewModel;
        if (r109 == null) goto L39;
        r109.clear(r103.getId());
        return;
    L39:
        return;
    L38:
        return;
    L37:
        return;
    L18:
        if (this.parentToChildCount.containsKey(r103) == true) goto L21;
        r105 = false;
        goto L21
    L7:
        i1<Set<NavBackStackEntry>> r110 = r104.getTransitionsInProgress();
        if (r110 == null) goto L6;
        Set<NavBackStackEntry> r111 = r110.getValue();
        if (r111 == null) goto L6;
        if (r111.contains(r103) != true) goto L6;
        r106 = true;
        goto L16
    L36:
        throw new IllegalStateException(("Attempted to pop " + r100.getDestination() + ", which is not the top of the back stack (" + r103.getDestination() + ')').toString());
    }

    public void navigate(NavDeepLinkRequest r100, NavOptions r101, Navigator.Extras r102) {
        Intrinsics.checkNotNullParameter(r100, "request");
        NavGraph r103 = this._graph;
        Intrinsics.checkNotNull(r103);
        NavDestination.DeepLinkMatch r104 = r103.matchDeepLink(r100);
        if (r104 == null) goto L10;
        Bundle r105 = r104.getDestination().addInDefaultArgs(r104.getMatchingArgs());
        if (r105 != null) goto L7;
        r105 = new Bundle();
    L7:
        NavDestination r106 = r104.getDestination();
        Intent r107 = new Intent();
        r107.setDataAndType(r100.getUri(), r100.getMimeType());
        r107.setAction(r100.getAction());
        r105.putParcelable(KEY_DEEP_LINK_INTENT, r107);
        navigate(r106, r105, r101, r102);
        return;
    L10:
        throw new IllegalArgumentException("Navigation destination that matches request " + r100 + " cannot be found in the navigation graph " + this._graph);
    }

    public final boolean popBackStack(String r100, boolean r101, boolean r102) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        return popBackStack(NavDestination.Companion.createRoute(r100).hashCode(), r101, r102);
    }

    public final void navigate(String r100, NavOptions r101, Navigator.Extras r102) {
        Intrinsics.checkNotNullParameter(r100, CloudControlInf.ROUTE);
        navigate(NavDeepLinkRequest.Builder.Companion.fromUri(UriProtector.parse(NavDestination.Companion.createRoute(r100))).build(), r101, r102);
    }

    public boolean popBackStack(int r100, boolean r101, boolean r102) {
        if (popBackStackInternal(r100, r101, r102) == true) goto L5;
    L7:
        return false;
    L5:
        if (dispatchOnDestinationChanged() == false) goto L7;
        return true;
    }

    public void navigate(Uri r100, NavOptions r101, Navigator.Extras r102) {
        Intrinsics.checkNotNullParameter(r100, "deepLink");
        navigate(new NavDeepLinkRequest(r100, null, null), r101, r102);
    }

    public void navigate(int r100, Bundle r101, NavOptions r102) {
        navigate(r100, r101, r102, null);
    }

    public static final /* synthetic */ void access$popEntryFromBackStack(NavController r100, NavBackStackEntry r101, boolean r102, ArrayDeque r103) {
        r100.popEntryFromBackStack(r101, r102, r103);
    }

    private final void addEntryToBackStack(NavDestination r310, Bundle r311, NavBackStackEntry r312, List<NavBackStackEntry> r313) {
        Bundle r110 = r311;
        NavBackStackEntry r111 = r312;
        List<NavBackStackEntry> r112 = r313;
        NavDestination r113 = r312.getDestination();
        if ((r113 instanceof FloatingWindow) == false) goto L5;
    L11:
        ArrayDeque r100 = new ArrayDeque();
        NavBackStackEntry r114 = null;
        if ((r310 instanceof NavGraph) == false) goto L38;
        NavDestination r101 = r113;
    L14:
        Intrinsics.checkNotNull(r101);
        NavGraph r102 = r101.getParent();
        if (r102 == null) goto L33;
        ListIterator<NavBackStackEntry> r103 = r112.listIterator(r313.size());
    L18:
        if (r103.hasPrevious() == false) goto L22;
        NavBackStackEntry r104 = r103.previous();
        if (Intrinsics.areEqual(r104.getDestination(), r102) == false) goto L18;
    L23:
        NavBackStackEntry r105 = r104;
        if (r105 != null) goto L26;
        NavBackStackEntry r106 = r111;
        r105 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, r102, r311, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    L27:
        r100.addFirst(r105);
        if ((!getBackQueue().isEmpty()) == false) goto L34;
        if (getBackQueue().last().getDestination() != r102) goto L34;
        popEntryFromBackStack$default(this, getBackQueue().last(), false, null, 6, null);
    L34:
        if (r102 == 0) goto L40;
        if (r102 == r310) goto L40;
        r111 = r106;
        r101 = r102;
        r100 = r100;
        r110 = r110;
        r112 = r112;
        r113 = r113;
    L40:
        if (r100.isEmpty() == false) goto L42;
        NavDestination r107 = r113;
    L43:
        if (r107 == null) goto L60;
        if (findDestination(r107.getId()) != null) goto L60;
        r107 = r107.getParent();
        if (r107 == null) goto L43;
        ListIterator<NavBackStackEntry> r108 = r112.listIterator(r313.size());
    L50:
        if (r108.hasPrevious() == false) goto L54;
        NavBackStackEntry r109 = r108.previous();
        if (Intrinsics.areEqual(r109.getDestination(), r107) == false) goto L50;
    L55:
        NavBackStackEntry r115 = r109;
        if (r115 != null) goto L58;
        r115 = NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, r107, r107.addInDefaultArgs(r110), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    L58:
        r100.addFirst(r115);
        goto L43
    L54:
        r109 = null;
    L60:
        if (r100.isEmpty() == true) goto L64;
        r113 = ((NavBackStackEntry) r100.last()).getDestination();
    L64:
        if (getBackQueue().isEmpty() == true) goto L70;
        if ((getBackQueue().last().getDestination() instanceof NavGraph) == false) goto L70;
        if (((NavGraph) getBackQueue().last().getDestination()).findNode(r113.getId(), false) != null) goto L70;
        popEntryFromBackStack$default(this, getBackQueue().last(), false, null, 6, null);
    L70:
        NavBackStackEntry r116 = getBackQueue().firstOrNull();
        if (r116 != null) goto L73;
        r116 = (NavBackStackEntry) r100.firstOrNull();
    L73:
        if (r116 != null) goto L75;
        NavDestination r117 = null;
    L77:
        if (Intrinsics.areEqual(r117, this._graph) == true) goto L88;
        ListIterator<NavBackStackEntry> r118 = r112.listIterator(r313.size());
    L80:
        if (r118.hasPrevious() == false) goto L84;
        NavBackStackEntry r119 = r118.previous();
        NavDestination r120 = r119.getDestination();
        NavGraph r121 = this._graph;
        Intrinsics.checkNotNull(r121);
        if (Intrinsics.areEqual(r120, r121) == false) goto L80;
        r114 = r119;
    L84:
        NavBackStackEntry r122 = r114;
        if (r122 != null) goto L87;
        NavBackStackEntry.Companion r123 = NavBackStackEntry.Companion;
        Context r124 = this.context;
        NavGraph r125 = this._graph;
        Intrinsics.checkNotNull(r125);
        NavGraph r126 = this._graph;
        Intrinsics.checkNotNull(r126);
        r122 = NavBackStackEntry.Companion.create$default(r123, r124, r125, r126.addInDefaultArgs(r110), getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null);
    L87:
        r100.addFirst(r122);
    L88:
        Iterator<E> r127 = r100.iterator();
    L90:
        if (r127.hasNext() == false) goto L96;
        NavBackStackEntry r128 = (NavBackStackEntry) r127.next();
        NavControllerNavigatorState r129 = this.navigatorState.get(this._navigatorProvider.getNavigator(r128.getDestination().getNavigatorName()));
        if (r129 == null) goto L95;
        r129.addInternal(r128);
        goto L90
    L95:
        throw new IllegalStateException(("NavigatorBackStack for " + r310.getNavigatorName() + " should already be created").toString());
    L96:
        getBackQueue().addAll(r100);
        getBackQueue().add(r106);
        Iterator r130 = CollectionsKt.plus(r100, r106).iterator();
    L98:
        if (r130.hasNext() == false) goto L102;
        NavBackStackEntry r131 = (NavBackStackEntry) r130.next();
        NavGraph r132 = r131.getDestination().getParent();
        if (r132 == null) goto L98;
        linkChildToParent(r131, getBackStackEntry(r132.getId()));
        goto L98
    L102:
        return;
    L75:
        r117 = r116.getDestination();
        goto L77
    L42:
        r107 = ((NavBackStackEntry) r100.first()).getDestination();
        goto L43
    L26:
        r106 = r111;
        goto L27
    L22:
        r104 = null;
        goto L23
    L33:
        r113 = r113;
        r106 = r111;
        goto L34
    L38:
        r100 = r100;
        r113 = r113;
        r112 = r112;
        r106 = r111;
        r110 = r110;
    L5:
        if (getBackQueue().isEmpty() == true) goto L11;
        if ((getBackQueue().last().getDestination() instanceof FloatingWindow) == false) goto L11;
        if (popBackStackInternal$default(this, getBackQueue().last().getDestination().getId(), true, false, 4, null) == false) goto L11;
        goto L11
    }

    private final void navigate(final NavDestination r210, Bundle r211, NavOptions r212, Navigator.Extras r213) {
        Iterator<T> r100 = this.navigatorState.values().iterator();
    L3:
        boolean r101 = true;
        if (r100.hasNext() == false) goto L6;
        ((NavControllerNavigatorState) r100.next()).setNavigating(true);
        goto L3
    L6:
        final Ref.BooleanRef r102 = new Ref.BooleanRef();
        if (r212 != null) goto L9;
    L11:
        boolean r103 = false;
    L12:
        final Bundle r104 = r210.addInDefaultArgs(r211);
        if (r212 != null) goto L16;
    L14:
        boolean r105 = false;
    L18:
        if (r105 == true) goto L20;
    L22:
        NavBackStackEntry r106 = getCurrentBackStackEntry();
        Navigator<? extends NavDestination> r107 = this._navigatorProvider.getNavigator(r210.getNavigatorName());
        if (r212 != null) goto L26;
    L24:
        boolean r110 = false;
    L28:
        if (r110 == false) goto L43;
        int r111 = r210.getId();
        if (r106 != null) goto L32;
    L31:
        boolean r112 = false;
    L38:
        if (r112 == false) goto L43;
        unlinkChildFromParent$navigation_runtime_release(getBackQueue().removeLast());
        NavBackStackEntry r108 = new NavBackStackEntry(r106, r104);
        getBackQueue().addLast(r108);
        NavGraph r109 = r108.getDestination().getParent();
        if (r109 == null) goto L42;
        linkChildToParent(r108, getBackStackEntry(r109.getId()));
    L42:
        r107.onLaunchSingleTop(r108);
    L45:
        updateOnBackPressedCallbackEnabled();
        Iterator<T> r113 = this.navigatorState.values().iterator();
    L47:
        if (r113.hasNext() == false) goto L49;
        ((NavControllerNavigatorState) r113.next()).setNavigating(false);
        goto L47
    L49:
        if (r103 == false) goto L51;
    L55:
        dispatchOnDestinationChanged();
        return;
    L51:
        if (r102.element == true) goto L55;
        if (r101 == true) goto L55;
        updateBackStackLifecycle$navigation_runtime_release();
        return;
    L32:
        NavDestination r114 = r106.getDestination();
        if (r114 == null) goto L31;
        if (r111 != r114.getId()) goto L31;
        r112 = true;
    L43:
        navigateInternal(r107, CollectionsKt.listOf(NavBackStackEntry.Companion.create$default(NavBackStackEntry.Companion, this.context, r210, r104, getHostLifecycleState$navigation_runtime_release(), this.viewModel, null, null, 96, null)), r212, r213, new AnonymousClass4(r102, this, r210, r104));
    L44:
        r101 = false;
        goto L45
    L26:
        if (r212.shouldLaunchSingleTop() != true) goto L24;
        r110 = true;
        goto L28
    L20:
        if (this.backStackMap.containsKey(Integer.valueOf(r210.getId())) == false) goto L22;
        r102.element = restoreStateInternal(r210.getId(), r104, r212, r213);
        goto L44
    L16:
        if (r212.shouldRestoreState() != true) goto L14;
        r105 = true;
        goto L18
    L9:
        if (r212.getPopUpToId() == (-1)) goto L11;
        r103 = popBackStackInternal(r212.getPopUpToId(), r212.isPopUpToInclusive(), r212.shouldPopUpToSaveState());
        goto L12
    }

    private final void popBackStackInternal(Navigator<? extends NavDestination> r100, NavBackStackEntry r101, boolean r102, Function1<? super NavBackStackEntry, Unit> r103) {
        this.popFromBackStackHandler = r103;
        r100.popBackStack(r101, r102);
        this.popFromBackStackHandler = null;
    }

    private final boolean restoreStateInternal(int r110, final Bundle r111, NavOptions r112, Navigator.Extras r113) {
        if (this.backStackMap.containsKey(Integer.valueOf(r110)) == true) goto L5;
        return false;
    L5:
        final String r114 = this.backStackMap.get(Integer.valueOf(r110));
        CollectionsKt.removeAll(this.backStackMap.values(), new C87951(r114));
        final List<NavBackStackEntry> r115 = instantiateBackStack(this.backStackStates.remove(r114));
        ArrayList r100 = new ArrayList();
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r115.iterator();
    L7:
        if (r102.hasNext() == false) goto L11;
        Object r103 = r102.next();
        if ((((NavBackStackEntry) r103).getDestination() instanceof NavGraph) == true) goto L7;
        r101.add(r103);
        goto L7
    L11:
        Iterator r104 = r101.iterator();
    L13:
        if (r104.hasNext() == false) goto L28;
        NavBackStackEntry r105 = (NavBackStackEntry) r104.next();
        List r106 = (List) CollectionsKt.lastOrNull(r100);
        String r107 = null;
        if (r106 == null) goto L25;
        NavBackStackEntry r108 = (NavBackStackEntry) CollectionsKt.last(r106);
        if (r108 == null) goto L25;
        NavDestination r109 = r108.getDestination();
        if (r109 == null) goto L25;
        r107 = r109.getNavigatorName();
    L25:
        if (Intrinsics.areEqual(r107, r105.getDestination().getNavigatorName()) == true) goto L26;
        r100.add(CollectionsKt.mutableListOf(new NavBackStackEntry[]{r105}));
        goto L13
    L26:
        r106.add(r105);
        goto L13
    L28:
        final Ref.BooleanRef r116 = new Ref.BooleanRef();
        Iterator r117 = r100.iterator();
    L30:
        if (r117.hasNext() == false) goto L33;
        List<NavBackStackEntry> r118 = (List) r117.next();
        Navigator<? extends NavDestination> r119 = this._navigatorProvider.getNavigator(((NavBackStackEntry) CollectionsKt.first(r118)).getDestination().getNavigatorName());
        final Ref.IntRef r120 = new Ref.IntRef();
        navigateInternal(r119, r118, r112, r113, new C87964(r116, r115, r120, this, r111));
        goto L30
    L33:
        return r116.element;
    }

    public void navigate(int r100, Bundle r101, NavOptions r102, Navigator.Extras r110) {
        if (getBackQueue().isEmpty() == false) goto L5;
        NavDestination r103 = this._graph;
    L6:
        if (r103 == null) goto L47;
        NavAction r104 = r103.getAction(r100);
        Bundle r105 = null;
        if (r104 == null) goto L14;
        if (r102 != null) goto L11;
        r102 = r104.getNavOptions();
    L11:
        int r106 = r104.getDestinationId();
        Bundle r107 = r104.getDefaultArguments();
        if (r107 == null) goto L15;
        r105 = new Bundle();
        r105.putAll(r107);
    L15:
        if (r101 == null) goto L19;
        if (r105 != null) goto L18;
        r105 = new Bundle();
    L18:
        r105.putAll(r101);
    L19:
        if (r106 != 0) goto L25;
        if (r102 == null) goto L25;
        if (r102.getPopUpToId() == (-1)) goto L25;
        popBackStack(r102.getPopUpToId(), r102.isPopUpToInclusive());
        return;
    L25:
        boolean r108 = true;
        if (r106 == 0) goto L28;
        boolean r109 = true;
    L29:
        if (r109 == false) goto L45;
        NavDestination r111 = findDestination(r106);
        if (r111 != null) goto L42;
        NavDestination.Companion r112 = NavDestination.Companion;
        String r113 = r112.getDisplayName(this.context, r106);
        if (r104 == null) goto L37;
        r108 = false;
    L37:
        if (r108 == true) goto L41;
        throw new IllegalArgumentException(("Navigation destination " + r113 + " referenced from action " + r112.getDisplayName(getContext(), r100) + " cannot be found from the current destination " + r103).toString());
    L41:
        throw new IllegalArgumentException("Navigation action/destination " + r113 + " cannot be found from the current destination " + r103);
    L42:
        navigate(r111, r105, r102, r110);
        return;
    L45:
        throw new IllegalArgumentException("Destination id == 0 can only be used in conjunction with a valid navOptions.popUpTo".toString());
    L28:
        r109 = false;
        goto L29
    L14:
        r106 = r100;
        goto L15
    L47:
        throw new IllegalStateException("no current navigation node");
    L5:
        r103 = getBackQueue().last().getDestination();
        goto L6
    }

    public static final /* synthetic */ void access$addEntryToBackStack(NavController r100, NavDestination r101, Bundle r102, NavBackStackEntry r103, List r104) {
        r100.addEntryToBackStack(r101, r102, r103, r104);
    }

    private final void navigateInternal(Navigator<? extends NavDestination> r100, List<NavBackStackEntry> r101, NavOptions r102, Navigator.Extras r103, Function1<? super NavBackStackEntry, Unit> r104) {
        this.addToBackStackHandler = r104;
        r100.navigate(r101, r102, r103);
        this.addToBackStackHandler = null;
    }

    public static /* synthetic */ void navigate$default(NavController r100, String r101, NavOptions r102, Navigator.Extras r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = null;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = null;
    L9:
        r100.navigate(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigate");
    }

    public static /* synthetic */ boolean popBackStack$default(NavController r100, String r101, boolean r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L7;
        r103 = false;
    L7:
        return r100.popBackStack(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStack");
    }

    public static /* synthetic */ boolean popBackStackInternal$default(NavController r100, int r101, boolean r102, boolean r103, int r104, Object r105) {
        if (r105 != null) goto L9;
        if ((r104 & 4) == 0) goto L7;
        r103 = false;
    L7:
        return r100.popBackStackInternal(r101, r102, r103);
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popEntryFromBackStack$default(NavController r100, NavBackStackEntry r101, boolean r102, ArrayDeque r103, int r104, Object r105) {
        if (r105 != null) goto L12;
        if ((r104 & 2) == 0) goto L7;
        r102 = false;
    L7:
        if ((r104 & 4) == 0) goto L9;
        r103 = new ArrayDeque();
    L9:
        r100.popEntryFromBackStack(r101, r102, r103);
        return;
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popEntryFromBackStack");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void addEntryToBackStack$default(NavController r100, NavDestination r101, Bundle r102, NavBackStackEntry r103, List r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 8) == 0) goto L6;
        r104 = CollectionsKt.emptyList();
    L6:
        r100.addEntryToBackStack(r101, r102, r103, r104);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addEntryToBackStack");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void popBackStackInternal$default(NavController r100, Navigator r101, NavBackStackEntry r102, boolean r103, Function1 r104, int r105, Object r106) {
        if (r106 != null) goto L9;
        if ((r105 & 4) == 0) goto L6;
        r104 = C87921.INSTANCE;
    L6:
        r100.popBackStackInternal(r101, r102, r103, r104);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: popBackStackInternal");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void navigateInternal$default(NavController r100, Navigator r101, List r102, NavOptions r103, Navigator.Extras r110, Function1 r111, int r112, Object r113) {
        if (r113 != null) goto L9;
        if ((r112 & 8) == 0) goto L6;
        r111 = AnonymousClass1.INSTANCE;
    L6:
        r100.navigateInternal(r101, r102, r103, r110, r111);
        return;
    L9:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateInternal");
    }
}
