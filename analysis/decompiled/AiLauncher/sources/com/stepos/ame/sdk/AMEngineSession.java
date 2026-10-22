package com.stepos.ame.sdk;

import La.H;
import Ua.C1056g;
import Ua.InterfaceC1066l;
import Ua.M;
import Ua.Y;
import Y8.t;
import Z8.C1168p;
import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.r;
import android.content.Context;
import android.util.Half;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.stepos.ailauncher.chat.trace.ChatTracker;
import com.stepos.ailauncher.chat.trace.a;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ame.AMEngineNative;
import com.stepos.ame.SearchResultWithMetadata;
import com.stepos.ame.api.FilterStrategy;
import com.stepos.ame.sdk.AMEngineResult;
import e9.InterfaceC4014c;
import f9.C4063a;
import g9.C4109a;
import g9.InterfaceC4112d;
import g9.f;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsJvmKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlinx.coroutines.c;
import p9.InterfaceC5063a;
import p9.p;
import v9.C5680i;
import x5.d;

@Metadata(d1 = {"\u0000è\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0016\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0003\n\u0000\n\u0002\u0010\u0001\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u001a\n\u0002\u0018\u0002\n\u0002\b%\n\u0002\u0018\u0002\n\u0002\b\u0010\u0018\u0000 Á\u00012\u00020\u0001:\u0002Á\u0001B\u0011\b\u0000\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001b\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\tH\u0002¢\u0006\u0004\b\u000b\u0010\fJ-\u0010\u0013\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J9\u0010\u0019\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u001a\u0010\u0017\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u0019\u0010\u001aJG\u0010\u001d\u001a\u00020\u001c2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00120\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u001a\u0010\u0017\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u000f\u0018\u00010\u0015H\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ5\u0010\"\u001a\u00020!2\u0006\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\r2\u0014\u0010\u0011\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\"\u0010#J\u001d\u0010'\u001a\b\u0012\u0004\u0012\u00020&0\u00152\u0006\u0010%\u001a\u00020$H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020*2\u0006\u0010%\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J%\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u0006\u0010-\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u0018H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00102\u001a\u0002012\u0006\u0010\u000e\u001a\u00020\r2\u0006\u00100\u001a\u00020\u001cH\u0002¢\u0006\u0004\b2\u00103J*\u00106\u001a\b\u0012\u0004\u0012\u00028\u00000\n\"\u0004\b\u0000\u0010\t2\f\u00105\u001a\b\u0012\u0004\u0012\u00028\u000004H\u0082\b¢\u0006\u0004\b6\u00107J\u001d\u0010;\u001a\b\u0012\u0004\u0012\u00020:0\n2\u0006\u00109\u001a\u000208H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010@\u001a\u00020=H\u0000¢\u0006\u0004\b>\u0010?J\u001e\u0010B\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010%\u001a\u00020AH\u0086@¢\u0006\u0004\bB\u0010CJ\u001e\u0010E\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u0006\u0010%\u001a\u00020DH\u0086@¢\u0006\u0004\bE\u0010FJ\u001e\u0010H\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010%\u001a\u00020GH\u0086@¢\u0006\u0004\bH\u0010IJ\u001e\u0010K\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010%\u001a\u00020JH\u0086@¢\u0006\u0004\bK\u0010LJ\u001e\u0010N\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010%\u001a\u00020MH\u0086@¢\u0006\u0004\bN\u0010OJ\u001e\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010%\u001a\u00020PH\u0086@¢\u0006\u0004\bQ\u0010RJ$\u0010S\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020&0\u00150\n2\u0006\u0010%\u001a\u00020$H\u0086@¢\u0006\u0004\bS\u0010TJ\u001e\u0010U\u001a\b\u0012\u0004\u0012\u00020*0\n2\u0006\u0010%\u001a\u00020)H\u0086@¢\u0006\u0004\bU\u0010VJ\u0016\u0010W\u001a\b\u0012\u0004\u0012\u00020\u001c0\nH\u0086@¢\u0006\u0004\bW\u0010XJ \u0010Y\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\n2\u0006\u0010\u001f\u001a\u00020\u0012H\u0086@¢\u0006\u0004\bY\u0010ZJ\u0016\u0010[\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0086@¢\u0006\u0004\b[\u0010XJ,\u0010\\\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u000f0\n2\u0006\u0010\u001f\u001a\u00020\u0012H\u0086@¢\u0006\u0004\b\\\u0010ZJ&\u0010_\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010]\u001a\u00020\u00102\u0006\u0010^\u001a\u00020\u0010H\u0086@¢\u0006\u0004\b_\u0010`J\u0018\u0010a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00100\nH\u0086@¢\u0006\u0004\ba\u0010XJ\u0016\u0010b\u001a\b\u0012\u0004\u0012\u00020=0\nH\u0086@¢\u0006\u0004\bb\u0010XJ\u0016\u0010c\u001a\b\u0012\u0004\u0012\u00020=0\nH\u0086@¢\u0006\u0004\bc\u0010XJ\u0016\u0010d\u001a\b\u0012\u0004\u0012\u00020=0\nH\u0086@¢\u0006\u0004\bd\u0010XJ*\u0010h\u001a\b\u0012\u0004\u0012\u00020=0\n2\b\b\u0002\u0010f\u001a\u00020e2\b\b\u0002\u0010g\u001a\u00020!H\u0087@¢\u0006\u0004\bh\u0010iJ\u0016\u0010j\u001a\b\u0012\u0004\u0012\u00020=0\nH\u0086@¢\u0006\u0004\bj\u0010XJ\u0084\u0001\u0010v\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010k\u001a\u00020\u001c2\b\b\u0002\u0010l\u001a\u00020\u001c2\u0006\u0010m\u001a\u00020\u001c2\b\b\u0002\u0010n\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020\u00102\b\b\u0002\u0010p\u001a\u00020!2\n\b\u0002\u0010r\u001a\u0004\u0018\u00010q2\n\b\u0002\u0010s\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010t\u001a\u0004\u0018\u00010\u00122\n\b\u0002\u0010u\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0004\bv\u0010wJ\u001e\u0010x\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010\u001f\u001a\u00020\u0010H\u0086@¢\u0006\u0004\bx\u0010yJ\u001c\u0010z\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00150\nH\u0086@¢\u0006\u0004\bz\u0010XJ2\u0010}\u001a\b\u0012\u0004\u0012\u00020\u00120\n2\u0006\u0010{\u001a\u00020\u00102\u0006\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010|\u001a\u0004\u0018\u00010\u0010H\u0086@¢\u0006\u0004\b}\u0010~J)\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010{\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u0018H\u0086@¢\u0006\u0006\b\u0080\u0001\u0010\u0081\u0001J:\u0010\u0083\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010{\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u00182\u0006\u0010\u000e\u001a\u00020\r2\u0007\u0010\u0082\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J@\u0010\u0085\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010{\u001a\u00020\u00102\u0006\u0010\u007f\u001a\u00020\u00182\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0007\u0010\u0082\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001JD\u0010\u0088\u0001\u001a\b\u0012\u0004\u0012\u00020\u00180\n2\u0006\u0010{\u001a\u00020\u00102\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0013\b\u0002\u0010\u0087\u0001\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0010\u0018\u00010\u0015H\u0086@¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J:\u0010\u008d\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010\u00150\n2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u008a\u0001\u001a\u00020\r2\u0007\u0010\u008b\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001JR\u0010\u0091\u0001\u001a\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010\u00150\n2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u008a\u0001\u001a\u00020\r2\u0007\u0010\u008b\u0001\u001a\u00020\u001c2\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00102\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J^\u0010\u0094\u0001\u001a\u0015\u0012\u0011\u0012\u000f\u0012\u000b\u0012\t\u0012\u0005\u0012\u00030\u008c\u00010\u00150\u00150\n2\u0006\u0010{\u001a\u00020\u00102\r\u0010\u0093\u0001\u001a\b\u0012\u0004\u0012\u00020\r0\u00152\u0007\u0010\u008b\u0001\u001a\u00020\u001c2\u000b\b\u0002\u0010\u008f\u0001\u001a\u0004\u0018\u00010\u00102\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J)\u0010\u0097\u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u0096\u0001\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b\u0097\u0001\u0010`J3\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u0096\u0001\u001a\u00020\u00102\u0007\u0010\u0098\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\b\u0099\u0001\u0010\u009a\u0001J)\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u0096\u0001\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b\u009b\u0001\u0010`J \u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010{\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b\u009c\u0001\u0010yJ \u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010{\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b\u009d\u0001\u0010yJ)\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010{\u001a\u00020\u00102\u0007\u0010\u0096\u0001\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b\u009e\u0001\u0010`J\"\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0007\u0010\u009f\u0001\u001a\u00020qH\u0086@¢\u0006\u0006\b \u0001\u0010¡\u0001JP\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020!0\n2\u0006\u0010{\u001a\u00020\u00102\t\b\u0002\u0010¢\u0001\u001a\u00020!2\u0007\u0010£\u0001\u001a\u00020\u001c2\u0007\u0010¤\u0001\u001a\u00020\u001c2\u0007\u0010¥\u0001\u001a\u00020\u00122\u0007\u0010¦\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\b§\u0001\u0010¨\u0001J<\u0010«\u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0007\u0010¢\u0001\u001a\u00020!2\u0007\u0010©\u0001\u001a\u00020\u001c2\u0006\u0010u\u001a\u00020\u00122\u0007\u0010ª\u0001\u001a\u00020\u0012H\u0086@¢\u0006\u0006\b«\u0001\u0010¬\u0001J \u0010\u00ad\u0001\u001a\b\u0012\u0004\u0012\u00020=0\n2\u0006\u0010u\u001a\u00020\u0012H\u0086@¢\u0006\u0005\b\u00ad\u0001\u0010ZJ \u0010®\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010{\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b®\u0001\u0010yJ\u0018\u0010¯\u0001\u001a\b\u0012\u0004\u0012\u00020=0\nH\u0086@¢\u0006\u0005\b¯\u0001\u0010XJ\u0018\u0010°\u0001\u001a\b\u0012\u0004\u0012\u00020!0\nH\u0086@¢\u0006\u0005\b°\u0001\u0010XJ \u0010±\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\u0006\u0010{\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b±\u0001\u0010yJ!\u0010³\u0001\u001a\t\u0012\u0005\u0012\u00030²\u00010\n2\u0006\u0010{\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b³\u0001\u0010yJ\u0018\u0010´\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0086@¢\u0006\u0005\b´\u0001\u0010XJ\u0018\u0010µ\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\nH\u0086@¢\u0006\u0005\bµ\u0001\u0010XJ \u0010¶\u0001\u001a\b\u0012\u0004\u0012\u00020\u00100\n2\u0006\u0010{\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b¶\u0001\u0010yJ&\u0010·\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u00150\n2\u0006\u0010{\u001a\u00020\u0010H\u0086@¢\u0006\u0005\b·\u0001\u0010yJ/\u0010º\u0001\u001a\b\u0012\u0004\u0012\u00020\u001c0\n2\t\b\u0002\u0010¸\u0001\u001a\u00020\u00122\t\b\u0002\u0010¹\u0001\u001a\u00020\u001cH\u0086@¢\u0006\u0006\bº\u0001\u0010»\u0001R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010¼\u0001R\u0019\u0010½\u0001\u001a\u00020!8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0014\u0010¿\u0001\u001a\u00020!8F¢\u0006\b\u001a\u0006\b¿\u0001\u0010À\u0001¨\u0006Â\u0001"}, d2 = {"Lcom/stepos/ame/sdk/AMEngineSession;", "", "Landroid/content/Context;", "appContext", "<init>", "(Landroid/content/Context;)V", "Lcom/stepos/ame/AMEngineNative;", C3081a.KEY_ENGINE, "()Lcom/stepos/ame/AMEngineNative;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/stepos/ame/sdk/AMEngineResult;", "notConnected", "()Lcom/stepos/ame/sdk/AMEngineResult;", "", "vector", "", "", "metadata", "", "insertDirect", "([FLjava/util/Map;)J", "", "vectors", "metadataList", "", "insertBatchRpc", "(Ljava/util/List;Ljava/util/List;)[J", "ids", "", "updateBatchRpc", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;)I", "id", "newVector", "", "updateDirect", "(J[FLjava/util/Map;)Z", "Lcom/stepos/ame/sdk/SearchArgs;", "args", "Lcom/stepos/ame/sdk/SearchResult;", "performSearch", "(Lcom/stepos/ame/sdk/SearchArgs;)Ljava/util/List;", "Lcom/stepos/ame/sdk/SearchBatchArgs;", "Lcom/stepos/ame/sdk/SearchBatchResult;", "performSearchBatch", "(Lcom/stepos/ame/sdk/SearchBatchArgs;)Lcom/stepos/ame/sdk/SearchBatchResult;", "expected", "finishInsertBatch", "(I[J)Lcom/stepos/ame/sdk/AMEngineResult;", "dim", "", "encodeFp16Aligned", "([FI)[B", "Lkotlin/Function0;", "block", "nativeCall", "(Lp9/a;)Lcom/stepos/ame/sdk/AMEngineResult;", "", "e", "", "nativeFailureFromThrowable", "(Ljava/lang/Throwable;)Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "invalidate$vector_release", "()V", "invalidate", "Lcom/stepos/ame/sdk/InsertArgs;", "insert", "(Lcom/stepos/ame/sdk/InsertArgs;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ame/sdk/InsertBatchArgs;", "insertBatch", "(Lcom/stepos/ame/sdk/InsertBatchArgs;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ame/sdk/UpdateArgs;", a.BUTTON_UPDATE, "(Lcom/stepos/ame/sdk/UpdateArgs;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ame/sdk/UpdateBatchArgs;", "updateBatch", "(Lcom/stepos/ame/sdk/UpdateBatchArgs;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ame/sdk/DeleteArgs;", ChatTracker.CLICK_DELETE, "(Lcom/stepos/ame/sdk/DeleteArgs;Le9/c;)Ljava/lang/Object;", "Lcom/stepos/ame/sdk/DeleteBatchArgs;", "deleteBatch", "(Lcom/stepos/ame/sdk/DeleteBatchArgs;Le9/c;)Ljava/lang/Object;", "search", "(Lcom/stepos/ame/sdk/SearchArgs;Le9/c;)Ljava/lang/Object;", "searchBatch", "(Lcom/stepos/ame/sdk/SearchBatchArgs;Le9/c;)Ljava/lang/Object;", "getVectorCount", "(Le9/c;)Ljava/lang/Object;", "getVectorById", "(JLe9/c;)Ljava/lang/Object;", "getMetadataCount", "getMetadata", "name", "type", "registerMetadataField", "(Ljava/lang/String;Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "getFieldSchemasJson", "save", "flushPersist", "reinitializeEngine", "", "minFragmentation", "rebuildIndex", "compactAsync", "(DZLe9/c;)Ljava/lang/Object;", "removeDbForTest", "rawDim", "storageDim", "metric", "dtype", "embeddingModel", "inputNormalized", "Lcom/stepos/ame/sdk/CollectionPersistConfig;", "persistOverride", "initialBytes", "stepBytes", "maxBytes", "createCollection", "(Ljava/lang/String;IIIILjava/lang/String;ZLcom/stepos/ame/sdk/CollectionPersistConfig;Ljava/lang/Long;Ljava/lang/Long;Ljava/lang/Long;Le9/c;)Ljava/lang/Object;", "dropCollection", "(Ljava/lang/String;Le9/c;)Ljava/lang/Object;", "listCollections", "collectionId", "metadataJson", "insertToCollection", "(Ljava/lang/String;[FLjava/lang/String;Le9/c;)Ljava/lang/Object;", "vectorIds", "deleteFromCollection", "(Ljava/lang/String;[JLe9/c;)Ljava/lang/Object;", "dimension", "updateInCollection", "(Ljava/lang/String;[J[FILe9/c;)Ljava/lang/Object;", "updateBatchInCollection", "(Ljava/lang/String;[JLjava/util/List;ILe9/c;)Ljava/lang/Object;", "metadataJsonArray", "insertBatchToCollection", "(Ljava/lang/String;Ljava/util/List;Ljava/util/List;Le9/c;)Ljava/lang/Object;", "query", "topK", "Lcom/stepos/ame/AMEngineNative$a;", "searchInCollection", "(Ljava/lang/String;[FILe9/c;)Ljava/lang/Object;", "filterJson", "overfetchRatio", "searchInCollectionWithFilter", "(Ljava/lang/String;[FILjava/lang/String;ILe9/c;)Ljava/lang/Object;", "queries", "searchBatchInCollection", "(Ljava/lang/String;Ljava/util/List;ILjava/lang/String;ILe9/c;)Ljava/lang/Object;", "indexId", "addShadowIndex", "typeOrdinal", "addShadowIndexTyped", "(Ljava/lang/String;Ljava/lang/String;ILe9/c;)Ljava/lang/Object;", "promoteIndex", "rollbackIndex", "removeRetiredIndexes", "triggerIvfTrain", "config", "setCollectionPersistConfig", "(Lcom/stepos/ame/sdk/CollectionPersistConfig;Le9/c;)Ljava/lang/Object;", d.EXTRA_ENABLED, "upgradeThreshold", "downgradeThreshold", "cooldownMs", "checkIntervalWrites", "setCollectionAutoSwitchConfig", "(Ljava/lang/String;ZIIJILe9/c;)Ljava/lang/Object;", "maxCount", "idleMs", "setCollectionResidencyConfig", "(ZIJJLe9/c;)Ljava/lang/Object;", "setGlobalCapacityMaxBytes", "getCollectionResidencyState", "triggerResidencyScan", "flushAllCollections", "collectionVectorCount", "Lcom/stepos/ame/sdk/CollectionRuntimeStats;", "getCollectionRuntimeStats", "totalIonAllocatedBytes", "getTotalCapacityBytes", "collectionPrimaryIndexId", "collectionQuarantinedFiles", "maxAgeMs", "maxFilesPerCollection", "pruneQuarantine", "(JILe9/c;)Ljava/lang/Object;", "Landroid/content/Context;", "active", "Z", "isConnected", "()Z", "Companion", "vector_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class AMEngineSession {
    public static final int MAX_BATCH_CHUNK = 200;
    public static final int MIN_SERVICE_VERSION = 5;
    private static final String TAG = "AMEngineSession";
    private volatile boolean active;
    private final Context appContext;

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$addShadowIndex$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$addShadowIndex$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $indexId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass2(String str, String str2, InterfaceC4014c<? super AnonymousClass2> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
            this.$indexId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new AnonymousClass2(this.$collectionId, this.$indexId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((AnonymousClass2) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().addShadowIndex(this.$collectionId, this.$indexId)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue()) {
                return AMEngineResult.INSTANCE.ok(t.f7040a);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "addShadowIndex '" + this.$collectionId + "/" + this.$indexId + "' returned false", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$addShadowIndexTyped$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$addShadowIndexTyped$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37602 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $indexId;
        final /* synthetic */ int $typeOrdinal;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37602(String str, String str2, int i10, InterfaceC4014c<? super C37602> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
            this.$indexId = str2;
            this.$typeOrdinal = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37602(this.$collectionId, this.$indexId, this.$typeOrdinal, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37602) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().addShadowIndex(this.$collectionId, this.$indexId, this.$typeOrdinal)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue()) {
                return AMEngineResult.INSTANCE.ok(t.f7040a);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "addShadowIndexTyped '" + this.$collectionId + "/" + this.$indexId + "' type=" + this.$typeOrdinal + " returned false", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$collectionPrimaryIndexId$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$collectionPrimaryIndexId$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37612 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends String>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37612(String str, InterfaceC4014c<? super C37612> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37612(this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<String>> interfaceC4014c) {
            return ((C37612) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().collectionPrimaryIndexId(this.$collectionId));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends String>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<String>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$collectionQuarantinedFiles$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$collectionQuarantinedFiles$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37622 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends List<? extends String>>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37622(String str, InterfaceC4014c<? super C37622> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37622(this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<String>>> interfaceC4014c) {
            return ((C37622) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().collectionQuarantinedFiles(this.$collectionId));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<? extends String>>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<? extends List<String>>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$collectionVectorCount$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$collectionVectorCount$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37632 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37632(String str, InterfaceC4014c<? super C37632> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37632(this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37632) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().collectionVectorCount(this.$collectionId)));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$compactAsync$2", f = "AMEngineSession.kt", l = {1150}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$compactAsync$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37642 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ double $minFragmentation;
        final /* synthetic */ boolean $rebuildIndex;
        double D$0;
        Object L$0;
        boolean Z$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37642(double d10, boolean z10, InterfaceC4014c<? super C37642> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$minFragmentation = d10;
            this.$rebuildIndex = z10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37642(this.$minFragmentation, this.$rebuildIndex, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37642) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objG = C4063a.g();
            int i10 = this.label;
            if (i10 != 0) {
                if (i10 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                C4849c.b(obj);
                return obj;
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            final AMEngineSession aMEngineSession = AMEngineSession.this;
            final double d10 = this.$minFragmentation;
            final boolean z10 = this.$rebuildIndex;
            this.L$0 = aMEngineSession;
            this.D$0 = d10;
            this.Z$0 = z10;
            this.label = 1;
            final c cVar = new c(IntrinsicsKt__IntrinsicsJvmKt.d(this), 1);
            cVar.I();
            Thread thread = new Thread(new Runnable() { // from class: com.stepos.ame.sdk.AMEngineSession$compactAsync$2$1$1
                @Override // java.lang.Runnable
                public final void run() {
                    AMEngineResult aMEngineResultFailure$default;
                    try {
                        boolean zCompact = aMEngineSession.engine().compact(d10, z10);
                        if (cVar.b()) {
                            InterfaceC1066l<AMEngineResult<t>> interfaceC1066l = cVar;
                            Result.Companion companion = Result.INSTANCE;
                            if (zCompact) {
                                Log.i("AMEngineSession", "compact succeeded");
                                aMEngineResultFailure$default = AMEngineResult.INSTANCE.ok(t.f7040a);
                            } else {
                                Log.e("AMEngineSession", "compact returned false");
                                aMEngineResultFailure$default = AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "compact returned false", null, 4, null);
                            }
                            interfaceC1066l.resumeWith(Result.b(aMEngineResultFailure$default));
                        }
                    } catch (Exception e10) {
                        Log.e("AMEngineSession", "compactAsync failed", e10);
                        if (cVar.b()) {
                            InterfaceC1066l<AMEngineResult<t>> interfaceC1066l2 = cVar;
                            Result.Companion companion2 = Result.INSTANCE;
                            interfaceC1066l2.resumeWith(Result.b(aMEngineSession.nativeFailureFromThrowable(e10)));
                        }
                    }
                }
            }, "ame-compact");
            thread.setDaemon(true);
            thread.start();
            Object objC = cVar.C();
            if (objC == C4063a.g()) {
                f.c(this);
            }
            return objC == objG ? objG : objC;
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$createCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$createCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37652 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ int $dtype;
        final /* synthetic */ String $embeddingModel;
        final /* synthetic */ String $id;
        final /* synthetic */ Long $initialBytes;
        final /* synthetic */ boolean $inputNormalized;
        final /* synthetic */ Long $maxBytes;
        final /* synthetic */ int $metric;
        final /* synthetic */ CollectionPersistConfig $persistOverride;
        final /* synthetic */ int $rawDim;
        final /* synthetic */ Long $stepBytes;
        final /* synthetic */ int $storageDim;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37652(String str, int i10, int i11, int i12, int i13, String str2, boolean z10, CollectionPersistConfig collectionPersistConfig, Long l10, Long l11, Long l12, InterfaceC4014c<? super C37652> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = str;
            this.$rawDim = i10;
            this.$storageDim = i11;
            this.$metric = i12;
            this.$dtype = i13;
            this.$embeddingModel = str2;
            this.$inputNormalized = z10;
            this.$persistOverride = collectionPersistConfig;
            this.$initialBytes = l10;
            this.$stepBytes = l11;
            this.$maxBytes = l12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37652(this.$id, this.$rawDim, this.$storageDim, this.$metric, this.$dtype, this.$embeddingModel, this.$inputNormalized, this.$persistOverride, this.$initialBytes, this.$stepBytes, this.$maxBytes, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37652) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            String str = this.$id;
            int i10 = this.$rawDim;
            int i11 = this.$storageDim;
            int i12 = this.$metric;
            int i13 = this.$dtype;
            String str2 = this.$embeddingModel;
            boolean z10 = this.$inputNormalized;
            CollectionPersistConfig collectionPersistConfig = this.$persistOverride;
            Long l10 = this.$initialBytes;
            Long l11 = this.$stepBytes;
            Long l12 = this.$maxBytes;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().createCollection(str, i10, i11, i12, i13, str2, z10, collectionPersistConfig, l10 != null ? l10.longValue() : -1L, l11 != null ? l11.longValue() : -1L, l12 != null ? l12.longValue() : -1L)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue()) {
                return AMEngineResult.INSTANCE.ok(t.f7040a);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "createCollection '" + this.$id + "' returned false", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$delete$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$delete$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37662 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ DeleteArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37662(DeleteArgs deleteArgs, InterfaceC4014c<? super C37662> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = deleteArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37662(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37662) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().delete(this.$args.getId())));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success) {
                return ((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue() ? AMEngineResult.INSTANCE.ok(t.f7040a) : AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_ID_NOT_FOUND, "删除失败，可能向量 ID 不存在或引擎错误", null, 4, null);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$deleteBatch$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$deleteBatch$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37672 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ DeleteBatchArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37672(DeleteBatchArgs deleteBatchArgs, InterfaceC4014c<? super C37672> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = deleteBatchArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37672(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37672) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEError aMEErrorValidate = this.$args.validate();
            if (aMEErrorValidate != null) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, aMEErrorValidate, aMEErrorValidate.getDesc(), null, 4, null);
            }
            List<Long> ids = this.$args.getIds();
            if (ids.size() <= 200) {
                AMEngineSession aMEngineSession = AMEngineSession.this;
                try {
                    return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().deleteBatch(F.m1(ids))));
                } catch (Exception e10) {
                    return aMEngineSession.nativeFailureFromThrowable(e10);
                }
            }
            int iIntValue = 0;
            for (List list : F.e0(ids, 200)) {
                AMEngineSession aMEngineSession2 = AMEngineSession.this;
                try {
                    aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession2.engine().deleteBatch(F.m1(list))));
                } catch (Exception e11) {
                    aMEngineResultNativeFailureFromThrowable = aMEngineSession2.nativeFailureFromThrowable(e11);
                }
                if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                    return aMEngineResultNativeFailureFromThrowable;
                }
                if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                iIntValue += ((Number) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).intValue();
            }
            return AMEngineResult.INSTANCE.ok(C4109a.f(iIntValue));
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$deleteFromCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$deleteFromCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37682 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ long[] $vectorIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37682(long[] jArr, String str, InterfaceC4014c<? super C37682> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$vectorIds = jArr;
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37682(this.$vectorIds, this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37682) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            long[] jArr = this.$vectorIds;
            if (jArr.length == 0) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_EMPTY_INPUT, "vectorIds is empty", null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().deleteFromCollection(this.$collectionId, jArr)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            AMEngineResult.Success success = (AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable;
            if (((Number) success.getValue()).intValue() >= 0) {
                return AMEngineResult.INSTANCE.ok(success.getValue());
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "deleteFromCollection '" + this.$collectionId + "' failed (native returned " + success.getValue() + ")", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$dropCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$dropCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37692 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ String $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37692(String str, InterfaceC4014c<? super C37692> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37692(this.$id, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37692) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().dropCollection(this.$id)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue()) {
                return AMEngineResult.INSTANCE.ok(t.f7040a);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "dropCollection '" + this.$id + "' returned false", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$flushAllCollections$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$flushAllCollections$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37702 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Boolean>>, Object> {
        int label;

        public C37702(InterfaceC4014c<? super C37702> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37702(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Boolean>> interfaceC4014c) {
            return ((C37702) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().flushAllCollections()));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Boolean>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Boolean>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$flushPersist$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$flushPersist$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37712 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        int label;

        public C37712(InterfaceC4014c<? super C37712> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37712(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37712) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                aMEngineSession.engine().flushPersist();
                return companion.ok(t.f7040a);
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getCollectionResidencyState$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getCollectionResidencyState$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37722 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37722(String str, InterfaceC4014c<? super C37722> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37722(this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37722) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().getCollectionResidencyState(this.$collectionId)));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "Lcom/stepos/ame/sdk/CollectionRuntimeStats;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getCollectionRuntimeStats$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getCollectionRuntimeStats$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37732 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends CollectionRuntimeStats>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37732(String str, InterfaceC4014c<? super C37732> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37732(this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<CollectionRuntimeStats>> interfaceC4014c) {
            return ((C37732) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(aMEngineSession.engine().getCollectionRuntimeStats(this.$collectionId));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            long[] jArr = (long[]) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue();
            if (jArr.length == 3) {
                return AMEngineResult.INSTANCE.ok(new CollectionRuntimeStats(jArr[0], jArr[1], jArr[2]));
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "getCollectionRuntimeStats returned size=" + jArr.length + ", expected 3", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends CollectionRuntimeStats>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<CollectionRuntimeStats>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getFieldSchemasJson$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getFieldSchemasJson$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37742 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends String>>, Object> {
        int label;

        public C37742(InterfaceC4014c<? super C37742> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37742(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<String>> interfaceC4014c) {
            return ((C37742) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().getFieldSchemasJson());
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends String>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<String>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0002\u0010\u0005\u001a\u0016\u0012\u0012\u0012\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0005\u0010\u0006"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getMetadata$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getMetadata$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37752 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Map<String, ? extends Object>>>, Object> {
        final /* synthetic */ long $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37752(long j10, InterfaceC4014c<? super C37752> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37752(this.$id, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Map<String, ? extends Object>>> interfaceC4014c) {
            return ((C37752) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().getMetadata(this.$id));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getMetadataCount$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getMetadataCount$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37762 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Long>>, Object> {
        int label;

        public C37762(InterfaceC4014c<? super C37762> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37762(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
            return ((C37762) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.g(aMEngineSession.engine().getMetadataCount()));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Long>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Long>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getTotalCapacityBytes$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getTotalCapacityBytes$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37772 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Long>>, Object> {
        int label;

        public C37772(InterfaceC4014c<? super C37772> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37772(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
            return ((C37772) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.g(aMEngineSession.engine().getTotalCapacityBytes()));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Long>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Long>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0014\n\u0002\b\u0002\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getVectorById$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getVectorById$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37782 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends float[]>>, Object> {
        final /* synthetic */ long $id;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37782(long j10, InterfaceC4014c<? super C37782> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$id = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37782(this.$id, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<float[]>> interfaceC4014c) {
            return ((C37782) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().getVectorById(this.$id));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends float[]>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<float[]>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$getVectorCount$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$getVectorCount$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37792 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        int label;

        public C37792(InterfaceC4014c<? super C37792> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37792(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37792) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().getVectorCount()));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$insert$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$insert$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37802 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Long>>, Object> {
        final /* synthetic */ InsertArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37802(InsertArgs insertArgs, InterfaceC4014c<? super C37802> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = insertArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37802(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
            return ((C37802) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEError aMEErrorValidate = this.$args.validate();
            if (aMEErrorValidate != null) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, aMEErrorValidate, aMEErrorValidate.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            InsertArgs insertArgs = this.$args;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.g(aMEngineSession.insertDirect(insertArgs.getVector(), insertArgs.getMetadata())));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            AMEngineResult.Success success = (AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable;
            return ((Number) success.getValue()).longValue() < 0 ? AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "插入失败（引擎返回无效 ID，可能为维度不匹配或存储错误）", null, 4, null) : AMEngineResult.INSTANCE.ok(success.getValue());
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Long>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Long>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$insertBatch$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$insertBatch$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37812 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends long[]>>, Object> {
        final /* synthetic */ InsertBatchArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37812(InsertBatchArgs insertBatchArgs, InterfaceC4014c<? super C37812> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = insertBatchArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37812(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<long[]>> interfaceC4014c) {
            return ((C37812) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            AMEngineResult aMEngineResultNativeFailureFromThrowable2;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEError aMEErrorValidate = this.$args.validate();
            if (aMEErrorValidate != null) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, aMEErrorValidate, aMEErrorValidate.getDesc(), null, 4, null);
            }
            List<float[]> vectors = this.$args.getVectors();
            List<Map<String, Object>> metadataList = this.$args.getMetadataList();
            if (vectors.size() <= 200) {
                AMEngineSession aMEngineSession = AMEngineSession.this;
                try {
                    aMEngineResultNativeFailureFromThrowable2 = AMEngineResult.INSTANCE.ok(aMEngineSession.insertBatchRpc(vectors, metadataList));
                } catch (Exception e10) {
                    aMEngineResultNativeFailureFromThrowable2 = aMEngineSession.nativeFailureFromThrowable(e10);
                }
                if (aMEngineResultNativeFailureFromThrowable2 instanceof AMEngineResult.Failure) {
                    return aMEngineResultNativeFailureFromThrowable2;
                }
                if (aMEngineResultNativeFailureFromThrowable2 instanceof AMEngineResult.Success) {
                    return AMEngineSession.this.finishInsertBatch(vectors.size(), (long[]) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable2).getValue());
                }
                throw new NoWhenBranchMatchedException();
            }
            ArrayList arrayList = new ArrayList();
            List listE0 = F.e0(vectors, 200);
            AMEngineSession aMEngineSession2 = AMEngineSession.this;
            int i10 = 0;
            for (Object obj2 : listE0) {
                int i11 = i10 + 1;
                if (i10 < 0) {
                    C1173v.w();
                }
                List list = (List) obj2;
                try {
                    aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(aMEngineSession2.insertBatchRpc(list, metadataList != null ? metadataList.subList(i10 * 200, Math.min(i11 * 200, metadataList.size())) : null));
                } catch (Exception e11) {
                    aMEngineResultNativeFailureFromThrowable = aMEngineSession2.nativeFailureFromThrowable(e11);
                }
                if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                    return aMEngineResultNativeFailureFromThrowable;
                }
                if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                AMEngineResult aMEngineResultFinishInsertBatch = aMEngineSession2.finishInsertBatch(list.size(), (long[]) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue());
                if (aMEngineResultFinishInsertBatch instanceof AMEngineResult.Failure) {
                    return aMEngineResultFinishInsertBatch;
                }
                if (!(aMEngineResultFinishInsertBatch instanceof AMEngineResult.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                arrayList.addAll(r.S0((long[]) ((AMEngineResult.Success) aMEngineResultFinishInsertBatch).getValue()));
                i10 = i11;
            }
            return AMEngineResult.INSTANCE.ok(F.n1(arrayList));
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends long[]>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<long[]>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$insertBatchToCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$insertBatchToCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37822 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends long[]>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ List<String> $metadataJsonArray;
        final /* synthetic */ List<float[]> $vectors;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37822(List<float[]> list, List<String> list2, String str, InterfaceC4014c<? super C37822> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$vectors = list;
            this.$metadataJsonArray = list2;
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37822(this.$vectors, this.$metadataJsonArray, this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<long[]>> interfaceC4014c) {
            return ((C37822) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            if (this.$vectors.isEmpty()) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_EMPTY_INPUT, "vectors list is empty", null, 4, null);
            }
            int length = this.$vectors.get(0).length;
            if (length == 0) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_EMPTY_INPUT, "vector dim is 0", null, 4, null);
            }
            Iterator<float[]> it = this.$vectors.iterator();
            int i10 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i10 = -1;
                    break;
                }
                if (it.next().length != length) {
                    break;
                }
                i10++;
            }
            if (i10 >= 0) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_DIMENSION_MISMATCH, "vectors[" + i10 + "].size=" + this.$vectors.get(i10).length + " != expected=" + length, null, 4, null);
            }
            List<String> list = this.$metadataJsonArray;
            if (list != null && list.size() != this.$vectors.size()) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_DIMENSION_MISMATCH, "metadataJsonArray.size=" + this.$metadataJsonArray.size() + " != vectors.size=" + this.$vectors.size(), null, 4, null);
            }
            float[] fArr = new float[this.$vectors.size() * length];
            int size = this.$vectors.size();
            for (int i11 = 0; i11 < size; i11++) {
                C1168p.k(this.$vectors.get(i11), fArr, i11 * length, 0, 0, 12, null);
            }
            List<String> list2 = this.$metadataJsonArray;
            String[] strArr = list2 != null ? (String[]) list2.toArray(new String[0]) : null;
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(aMEngineSession.engine().insertBatchToCollection(this.$collectionId, fArr, this.$vectors.size(), length, strArr));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            long[] jArr = (long[]) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue();
            if (jArr != null) {
                return AMEngineResult.INSTANCE.ok(jArr);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "insertBatchToCollection '" + this.$collectionId + "' returned null (collection 不存在 / 维度错 / 容量满)", null, 4, null);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends long[]>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<long[]>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$insertToCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$insertToCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37832 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Long>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $metadataJson;
        final /* synthetic */ float[] $vector;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37832(float[] fArr, String str, String str2, InterfaceC4014c<? super C37832> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$vector = fArr;
            this.$collectionId = str;
            this.$metadataJson = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37832(this.$vector, this.$collectionId, this.$metadataJson, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
            return ((C37832) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            float[] fArr = this.$vector;
            if (fArr.length == 0) {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                AMEError aMEError = AMEError.ARGS_EMPTY_INPUT;
                return AMEngineResult.Companion.failure$default(companion, aMEError, aMEError.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.g(aMEngineSession.engine().insertToCollection(this.$collectionId, fArr, this.$metadataJson)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            AMEngineResult.Success success = (AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable;
            if (((Number) success.getValue()).longValue() >= 0) {
                return AMEngineResult.INSTANCE.ok(success.getValue());
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "insertToCollection '" + this.$collectionId + "' failed (native returned " + success.getValue() + ")", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Long>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Long>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$listCollections$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$listCollections$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37842 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends List<? extends String>>>, Object> {
        int label;

        public C37842(InterfaceC4014c<? super C37842> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37842(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<String>>> interfaceC4014c) {
            return ((C37842) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().listCollections());
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<? extends String>>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<? extends List<String>>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$promoteIndex$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$promoteIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37852 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $indexId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37852(String str, String str2, InterfaceC4014c<? super C37852> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
            this.$indexId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37852(this.$collectionId, this.$indexId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37852) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().promoteIndex(this.$collectionId, this.$indexId)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue()) {
                return AMEngineResult.INSTANCE.ok(t.f7040a);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "promoteIndex '" + this.$collectionId + "/" + this.$indexId + "' returned false", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$pruneQuarantine$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$pruneQuarantine$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37862 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ long $maxAgeMs;
        final /* synthetic */ int $maxFilesPerCollection;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37862(long j10, int i10, InterfaceC4014c<? super C37862> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$maxAgeMs = j10;
            this.$maxFilesPerCollection = i10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37862(this.$maxAgeMs, this.$maxFilesPerCollection, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37862) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().pruneQuarantine(this.$maxAgeMs, this.$maxFilesPerCollection)));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$registerMetadataField$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$registerMetadataField$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37872 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ String $name;
        final /* synthetic */ String $type;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37872(String str, String str2, InterfaceC4014c<? super C37872> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$name = str;
            this.$type = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37872(this.$name, this.$type, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37872) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().registerMetadataFieldReturnCode(this.$name, this.$type)));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$reinitializeEngine$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$reinitializeEngine$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37882 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        int label;

        public C37882(InterfaceC4014c<? super C37882> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37882(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37882) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                AMEngineNative.Companion companion2 = AMEngineNative.INSTANCE;
                companion2.g();
                AMEngineNative.Companion.c(companion2, aMEngineSession.appContext, null, 2, null);
                aMEngineResultNativeFailureFromThrowable = companion.ok(C4109a.a(true));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success) {
                return ((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue() ? AMEngineResult.INSTANCE.ok(t.f7040a) : AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "重新初始化引擎失败", null, 4, null);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$removeDbForTest$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$removeDbForTest$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37892 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        int label;

        public C37892(InterfaceC4014c<? super C37892> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37892(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37892) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().removeDbForTest()));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success) {
                return ((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue() ? AMEngineResult.INSTANCE.ok(t.f7040a) : AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "removeDbForTest 执行失败", null, 4, null);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$removeRetiredIndexes$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$removeRetiredIndexes$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37902 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37902(String str, InterfaceC4014c<? super C37902> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37902(this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C37902) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().removeRetiredIndexes(this.$collectionId)));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$rollbackIndex$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$rollbackIndex$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37912 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ String $collectionId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37912(String str, InterfaceC4014c<? super C37912> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37912(this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37912) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().rollbackIndex(this.$collectionId)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue()) {
                return AMEngineResult.INSTANCE.ok(t.f7040a);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "rollbackIndex '" + this.$collectionId + "' returned false (no DEPRECATED target?)", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$save$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$save$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37922 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        int label;

        public C37922(InterfaceC4014c<? super C37922> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37922(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37922) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineNative aMEngineNativeEngine = AMEngineSession.this.engine();
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineNativeEngine.save(aMEngineNativeEngine.getVectorStoragePath())));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success) {
                return ((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue() ? AMEngineResult.INSTANCE.ok(t.f7040a) : AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "保存快照失败", null, 4, null);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "Lcom/stepos/ame/sdk/SearchResult;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$search$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$search$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37932 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends List<? extends SearchResult>>>, Object> {
        final /* synthetic */ SearchArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37932(SearchArgs searchArgs, InterfaceC4014c<? super C37932> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = searchArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37932(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<SearchResult>>> interfaceC4014c) {
            return ((C37932) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEError aMEErrorValidate = this.$args.validate();
            if (aMEErrorValidate != null) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, aMEErrorValidate, aMEErrorValidate.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.performSearch(this.$args));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<? extends SearchResult>>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<? extends List<SearchResult>>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "Lcom/stepos/ame/sdk/SearchBatchResult;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$searchBatch$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$searchBatch$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37942 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends SearchBatchResult>>, Object> {
        final /* synthetic */ SearchBatchArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37942(SearchBatchArgs searchBatchArgs, InterfaceC4014c<? super C37942> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = searchBatchArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37942(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<SearchBatchResult>> interfaceC4014c) {
            return ((C37942) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEError aMEErrorValidate = this.$args.validate();
            if (aMEErrorValidate != null) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, aMEErrorValidate, aMEErrorValidate.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.performSearchBatch(this.$args));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends SearchBatchResult>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<SearchBatchResult>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u0014\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "Lcom/stepos/ame/AMEngineNative$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$searchBatchInCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$searchBatchInCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37952 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends List<? extends List<? extends AMEngineNative.CollectionHit>>>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $filterJson;
        final /* synthetic */ int $overfetchRatio;
        final /* synthetic */ List<float[]> $queries;
        final /* synthetic */ int $topK;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37952(List<float[]> list, int i10, String str, String str2, int i11, InterfaceC4014c<? super C37952> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$queries = list;
            this.$topK = i10;
            this.$collectionId = str;
            this.$filterJson = str2;
            this.$overfetchRatio = i11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37952(this.$queries, this.$topK, this.$collectionId, this.$filterJson, this.$overfetchRatio, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<? extends List<AMEngineNative.CollectionHit>>>> interfaceC4014c) {
            return ((C37952) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            if (this.$queries.isEmpty()) {
                return AMEngineResult.INSTANCE.ok(C1173v.m());
            }
            int i10 = this.$topK;
            if (i10 <= 0) {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                AMEError aMEError = AMEError.ARGS_INVALID_TOPK;
                return AMEngineResult.Companion.failure$default(companion, aMEError, aMEError.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().searchBatchInCollection(this.$collectionId, this.$queries, i10, this.$filterJson, this.$overfetchRatio));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<? extends List<? extends AMEngineNative.CollectionHit>>>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<? extends List<? extends List<AMEngineNative.CollectionHit>>>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "Lcom/stepos/ame/AMEngineNative$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$searchInCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$searchInCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37962 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends List<? extends AMEngineNative.CollectionHit>>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ float[] $query;
        final /* synthetic */ int $topK;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37962(float[] fArr, int i10, String str, InterfaceC4014c<? super C37962> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$query = fArr;
            this.$topK = i10;
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37962(this.$query, this.$topK, this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<AMEngineNative.CollectionHit>>> interfaceC4014c) {
            return ((C37962) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            float[] fArr = this.$query;
            if (fArr.length == 0) {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                AMEError aMEError = AMEError.ARGS_EMPTY_INPUT;
                return AMEngineResult.Companion.failure$default(companion, aMEError, aMEError.getDesc(), null, 4, null);
            }
            int i10 = this.$topK;
            if (i10 <= 0) {
                AMEngineResult.Companion companion2 = AMEngineResult.INSTANCE;
                AMEError aMEError2 = AMEError.ARGS_INVALID_TOPK;
                return AMEngineResult.Companion.failure$default(companion2, aMEError2, aMEError2.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().searchInCollection(this.$collectionId, fArr, i10));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<? extends AMEngineNative.CollectionHit>>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<? extends List<AMEngineNative.CollectionHit>>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0004\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0004\u0010\u0005"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "Lcom/stepos/ame/AMEngineNative$a;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$searchInCollectionWithFilter$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$searchInCollectionWithFilter$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37972 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends List<? extends AMEngineNative.CollectionHit>>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $filterJson;
        final /* synthetic */ int $overfetchRatio;
        final /* synthetic */ float[] $query;
        final /* synthetic */ int $topK;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37972(float[] fArr, int i10, String str, String str2, int i11, InterfaceC4014c<? super C37972> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$query = fArr;
            this.$topK = i10;
            this.$collectionId = str;
            this.$filterJson = str2;
            this.$overfetchRatio = i11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37972(this.$query, this.$topK, this.$collectionId, this.$filterJson, this.$overfetchRatio, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<AMEngineNative.CollectionHit>>> interfaceC4014c) {
            return ((C37972) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            float[] fArr = this.$query;
            if (fArr.length == 0) {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                AMEError aMEError = AMEError.ARGS_EMPTY_INPUT;
                return AMEngineResult.Companion.failure$default(companion, aMEError, aMEError.getDesc(), null, 4, null);
            }
            int i10 = this.$topK;
            if (i10 <= 0) {
                AMEngineResult.Companion companion2 = AMEngineResult.INSTANCE;
                AMEError aMEError2 = AMEError.ARGS_INVALID_TOPK;
                return AMEngineResult.Companion.failure$default(companion2, aMEError2, aMEError2.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(aMEngineSession.engine().searchInCollectionWithFilter(this.$collectionId, fArr, i10, this.$filterJson, this.$overfetchRatio));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends List<? extends AMEngineNative.CollectionHit>>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<? extends List<AMEngineNative.CollectionHit>>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$setCollectionAutoSwitchConfig$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$setCollectionAutoSwitchConfig$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37982 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Boolean>>, Object> {
        final /* synthetic */ int $checkIntervalWrites;
        final /* synthetic */ String $collectionId;
        final /* synthetic */ long $cooldownMs;
        final /* synthetic */ int $downgradeThreshold;
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ int $upgradeThreshold;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37982(String str, boolean z10, int i10, int i11, long j10, int i12, InterfaceC4014c<? super C37982> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
            this.$enabled = z10;
            this.$upgradeThreshold = i10;
            this.$downgradeThreshold = i11;
            this.$cooldownMs = j10;
            this.$checkIntervalWrites = i12;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37982(this.$collectionId, this.$enabled, this.$upgradeThreshold, this.$downgradeThreshold, this.$cooldownMs, this.$checkIntervalWrites, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Boolean>> interfaceC4014c) {
            return ((C37982) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().setCollectionAutoSwitchConfig(this.$collectionId, this.$enabled, this.$upgradeThreshold, this.$downgradeThreshold, this.$cooldownMs, this.$checkIntervalWrites)));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Boolean>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Boolean>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$setCollectionPersistConfig$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$setCollectionPersistConfig$2, reason: invalid class name and case insensitive filesystem */
    public static final class C37992 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ CollectionPersistConfig $config;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C37992(CollectionPersistConfig collectionPersistConfig, InterfaceC4014c<? super C37992> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$config = collectionPersistConfig;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C37992(this.$config, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C37992) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            CollectionPersistConfig collectionPersistConfig = this.$config;
            try {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                aMEngineSession.engine().setCollectionPersistConfig(collectionPersistConfig);
                return companion.ok(t.f7040a);
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$setCollectionResidencyConfig$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$setCollectionResidencyConfig$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38002 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ boolean $enabled;
        final /* synthetic */ long $idleMs;
        final /* synthetic */ long $maxBytes;
        final /* synthetic */ int $maxCount;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38002(boolean z10, int i10, long j10, long j11, InterfaceC4014c<? super C38002> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$enabled = z10;
            this.$maxCount = i10;
            this.$maxBytes = j10;
            this.$idleMs = j11;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38002(this.$enabled, this.$maxCount, this.$maxBytes, this.$idleMs, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C38002) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            boolean z10 = this.$enabled;
            int i10 = this.$maxCount;
            long j10 = this.$maxBytes;
            long j11 = this.$idleMs;
            try {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                aMEngineSession.engine().setCollectionResidencyConfig(z10, i10, j10, j11);
                return companion.ok(t.f7040a);
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$setGlobalCapacityMaxBytes$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$setGlobalCapacityMaxBytes$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38012 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ long $maxBytes;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38012(long j10, InterfaceC4014c<? super C38012> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$maxBytes = j10;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38012(this.$maxBytes, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C38012) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            long j10 = this.$maxBytes;
            try {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                aMEngineSession.engine().setGlobalCapacityMaxBytes(j10);
                return companion.ok(t.f7040a);
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$totalIonAllocatedBytes$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$totalIonAllocatedBytes$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38022 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Long>>, Object> {
        int label;

        public C38022(InterfaceC4014c<? super C38022> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38022(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
            return ((C38022) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                return AMEngineResult.INSTANCE.ok(C4109a.g(aMEngineSession.engine().totalIonAllocatedBytes()));
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Long>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Long>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$triggerIvfTrain$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$triggerIvfTrain$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38032 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ String $indexId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38032(String str, String str2, InterfaceC4014c<? super C38032> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$collectionId = str;
            this.$indexId = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38032(this.$collectionId, this.$indexId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C38032) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.engine().triggerIvfTrain(this.$collectionId, this.$indexId)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            if (((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue()) {
                return AMEngineResult.INSTANCE.ok(t.f7040a);
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "triggerIvfTrain '" + this.$collectionId + "/" + this.$indexId + "' returned false (slot not found / not IVF_FLAT / count below threshold / kmeans failed)", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$triggerResidencyScan$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$triggerResidencyScan$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38042 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        int label;

        public C38042(InterfaceC4014c<? super C38042> interfaceC4014c) {
            super(2, interfaceC4014c);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38042(interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C38042) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
                aMEngineSession.engine().triggerResidencyScan();
                return companion.ok(t.f7040a);
            } catch (Exception e10) {
                return aMEngineSession.nativeFailureFromThrowable(e10);
            }
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "LY8/t;", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$update$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$update$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38052 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends t>>, Object> {
        final /* synthetic */ UpdateArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38052(UpdateArgs updateArgs, InterfaceC4014c<? super C38052> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = updateArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38052(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
            return ((C38052) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEError aMEErrorValidate = this.$args.validate();
            if (aMEErrorValidate != null) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, aMEErrorValidate, aMEErrorValidate.getDesc(), null, 4, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            UpdateArgs updateArgs = this.$args;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.a(aMEngineSession.updateDirect(updateArgs.getId(), updateArgs.getNewVector(), updateArgs.getMetadata())));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success) {
                return ((Boolean) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).booleanValue() ? AMEngineResult.INSTANCE.ok(t.f7040a) : AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_ID_NOT_FOUND, "更新失败，可能向量 ID 不存在或引擎错误", null, 4, null);
            }
            throw new NoWhenBranchMatchedException();
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends t>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<t>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$updateBatch$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$updateBatch$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38062 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ UpdateBatchArgs $args;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38062(UpdateBatchArgs updateBatchArgs, InterfaceC4014c<? super C38062> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$args = updateBatchArgs;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38062(this.$args, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C38062) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            AMEError aMEErrorValidate = this.$args.validate();
            if (aMEErrorValidate != null) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, aMEErrorValidate, aMEErrorValidate.getDesc(), null, 4, null);
            }
            int size = this.$args.getIds().size();
            if (size <= 200) {
                AMEngineSession aMEngineSession = AMEngineSession.this;
                UpdateBatchArgs updateBatchArgs = this.$args;
                try {
                    return AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.updateBatchRpc(updateBatchArgs.getIds(), updateBatchArgs.getVectors(), updateBatchArgs.getMetadataList())));
                } catch (Exception e10) {
                    return aMEngineSession.nativeFailureFromThrowable(e10);
                }
            }
            int i10 = 0;
            int iIntValue = 0;
            while (i10 < size) {
                int iMin = Math.min(i10 + 200, size);
                List<Long> listSubList = this.$args.getIds().subList(i10, iMin);
                List<float[]> listSubList2 = this.$args.getVectors().subList(i10, iMin);
                List<Map<String, Object>> metadataList = this.$args.getMetadataList();
                List<Map<String, Object>> listSubList3 = metadataList != null ? metadataList.subList(i10, iMin) : null;
                AMEngineSession aMEngineSession2 = AMEngineSession.this;
                try {
                    aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession2.updateBatchRpc(listSubList, listSubList2, listSubList3)));
                } catch (Exception e11) {
                    aMEngineResultNativeFailureFromThrowable = aMEngineSession2.nativeFailureFromThrowable(e11);
                }
                if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                    return aMEngineResultNativeFailureFromThrowable;
                }
                if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                    throw new NoWhenBranchMatchedException();
                }
                iIntValue += ((Number) ((AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable).getValue()).intValue();
                i10 = iMin;
            }
            return AMEngineResult.INSTANCE.ok(C4109a.f(iIntValue));
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$updateBatchInCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$updateBatchInCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38072 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ int $dimension;
        final /* synthetic */ long[] $vectorIds;
        final /* synthetic */ List<float[]> $vectors;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38072(long[] jArr, List<float[]> list, int i10, String str, InterfaceC4014c<? super C38072> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$vectorIds = jArr;
            this.$vectors = list;
            this.$dimension = i10;
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38072(this.$vectorIds, this.$vectors, this.$dimension, this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C38072) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            if (this.$vectorIds.length == 0 || this.$vectors.isEmpty() || this.$dimension <= 0) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_EMPTY_INPUT, "vectorIds/vectors empty or dimension<=0", null, 4, null);
            }
            if (this.$vectorIds.length != this.$vectors.size()) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_DIMENSION_MISMATCH, "vectorIds.size=" + this.$vectorIds.length + " != vectors.size=" + this.$vectors.size(), null, 4, null);
            }
            List<float[]> list = this.$vectors;
            int i10 = this.$dimension;
            Iterator<float[]> it = list.iterator();
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    i11 = -1;
                    break;
                }
                if (it.next().length != i10) {
                    break;
                }
                i11++;
            }
            if (i11 >= 0) {
                return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_DIMENSION_MISMATCH, "vectors[" + i11 + "].size=" + this.$vectors.get(i11).length + " != dimension=" + this.$dimension, null, 4, null);
            }
            int i12 = ((this.$dimension + 63) / 64) * 128;
            byte[] bArr = new byte[this.$vectors.size() * i12];
            int size = this.$vectors.size();
            for (int i13 = 0; i13 < size; i13++) {
                C1168p.j(AMEngineSession.this.encodeFp16Aligned(this.$vectors.get(i13), this.$dimension), bArr, i13 * i12, 0, 0, 12, null);
            }
            AMEngineSession aMEngineSession = AMEngineSession.this;
            try {
                aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().updateInCollection(this.$collectionId, this.$vectorIds, bArr, this.$dimension)));
            } catch (Exception e10) {
                aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
            }
            if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                return aMEngineResultNativeFailureFromThrowable;
            }
            if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                throw new NoWhenBranchMatchedException();
            }
            AMEngineResult.Success success = (AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable;
            if (((Number) success.getValue()).intValue() >= 0) {
                return AMEngineResult.INSTANCE.ok(success.getValue());
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "updateBatchInCollection '" + this.$collectionId + "' failed (native returned " + success.getValue() + ")", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    @Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0003\u0010\u0004"}, d2 = {"LUa/M;", "Lcom/stepos/ame/sdk/AMEngineResult;", "", "<anonymous>", "(LUa/M;)Lcom/stepos/ame/sdk/AMEngineResult;"}, k = 3, mv = {2, 0, 0})
    @InterfaceC4112d(c = "com.stepos.ame.sdk.AMEngineSession$updateInCollection$2", f = "AMEngineSession.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.stepos.ame.sdk.AMEngineSession$updateInCollection$2, reason: invalid class name and case insensitive filesystem */
    public static final class C38082 extends SuspendLambda implements p<M, InterfaceC4014c<? super AMEngineResult<? extends Integer>>, Object> {
        final /* synthetic */ String $collectionId;
        final /* synthetic */ int $dimension;
        final /* synthetic */ float[] $vector;
        final /* synthetic */ long[] $vectorIds;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C38082(long[] jArr, float[] fArr, int i10, String str, InterfaceC4014c<? super C38082> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$vectorIds = jArr;
            this.$vector = fArr;
            this.$dimension = i10;
            this.$collectionId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return AMEngineSession.this.new C38082(this.$vectorIds, this.$vector, this.$dimension, this.$collectionId, interfaceC4014c);
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(M m10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
            return ((C38082) create(m10, interfaceC4014c)).invokeSuspend(t.f7040a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            int i10;
            AMEngineResult aMEngineResultNativeFailureFromThrowable;
            C4063a.g();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            C4849c.b(obj);
            if (!AMEngineSession.this.active) {
                return AMEngineSession.this.notConnected();
            }
            if (this.$vectorIds.length != 0) {
                float[] fArr = this.$vector;
                if (fArr.length != 0 && (i10 = this.$dimension) > 0) {
                    byte[] bArrEncodeFp16Aligned = AMEngineSession.this.encodeFp16Aligned(fArr, i10);
                    AMEngineSession aMEngineSession = AMEngineSession.this;
                    try {
                        aMEngineResultNativeFailureFromThrowable = AMEngineResult.INSTANCE.ok(C4109a.f(aMEngineSession.engine().updateInCollection(this.$collectionId, this.$vectorIds, bArrEncodeFp16Aligned, this.$dimension)));
                    } catch (Exception e10) {
                        aMEngineResultNativeFailureFromThrowable = aMEngineSession.nativeFailureFromThrowable(e10);
                    }
                    if (aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Failure) {
                        return aMEngineResultNativeFailureFromThrowable;
                    }
                    if (!(aMEngineResultNativeFailureFromThrowable instanceof AMEngineResult.Success)) {
                        throw new NoWhenBranchMatchedException();
                    }
                    AMEngineResult.Success success = (AMEngineResult.Success) aMEngineResultNativeFailureFromThrowable;
                    if (((Number) success.getValue()).intValue() >= 0) {
                        return AMEngineResult.INSTANCE.ok(success.getValue());
                    }
                    return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "updateInCollection '" + this.$collectionId + "' failed (native returned " + success.getValue() + ")", null, 4, null);
                }
            }
            return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.ARGS_EMPTY_INPUT, "vectorIds/vector empty or dimension<=0", null, 4, null);
        }

        @Override // p9.p
        public /* bridge */ /* synthetic */ Object invoke(M m10, InterfaceC4014c<? super AMEngineResult<? extends Integer>> interfaceC4014c) {
            return invoke2(m10, (InterfaceC4014c<? super AMEngineResult<Integer>>) interfaceC4014c);
        }
    }

    public AMEngineSession(Context appContext) {
        kotlin.jvm.internal.p.i(appContext, "appContext");
        this.appContext = appContext;
        this.active = true;
    }

    public static /* synthetic */ Object compactAsync$default(AMEngineSession aMEngineSession, double d10, boolean z10, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            d10 = 0.1d;
        }
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        return aMEngineSession.compactAsync(d10, z10, interfaceC4014c);
    }

    public static /* synthetic */ Object createCollection$default(AMEngineSession aMEngineSession, String str, int i10, int i11, int i12, int i13, String str2, boolean z10, CollectionPersistConfig collectionPersistConfig, Long l10, Long l11, Long l12, InterfaceC4014c interfaceC4014c, int i14, Object obj) {
        if ((i14 & 4) != 0) {
            i11 = i10;
        }
        if ((i14 & 16) != 0) {
            i13 = 0;
        }
        if ((i14 & 64) != 0) {
            z10 = false;
        }
        if ((i14 & 128) != 0) {
            collectionPersistConfig = null;
        }
        if ((i14 & 256) != 0) {
            l10 = null;
        }
        if ((i14 & 512) != 0) {
            l11 = null;
        }
        if ((i14 & 1024) != 0) {
            l12 = null;
        }
        return aMEngineSession.createCollection(str, i10, i11, i12, i13, str2, z10, collectionPersistConfig, l10, l11, l12, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final byte[] encodeFp16Aligned(float[] vector, int dim) {
        byte[] bArr = new byte[((dim + 63) / 64) * 128];
        int iMin = Math.min(dim, vector.length);
        for (int i10 = 0; i10 < iMin; i10++) {
            short half = Half.toHalf(vector[i10]);
            int i11 = i10 * 2;
            bArr[i11] = (byte) (half & 255);
            bArr[i11 + 1] = (byte) ((half >>> 8) & 255);
        }
        return bArr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AMEngineNative engine() {
        if (this.active) {
            return AMEngineNative.Companion.c(AMEngineNative.INSTANCE, this.appContext, null, 2, null);
        }
        throw new IllegalStateException("session inactive");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AMEngineResult<long[]> finishInsertBatch(int expected, long[] ids) {
        if (expected == 0) {
            return AMEngineResult.INSTANCE.ok(new long[0]);
        }
        if (ids.length == expected) {
            for (long j10 : ids) {
                if (j10 < 0) {
                    return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_INTERNAL_ERROR, "批量插入失败：包含无效 ID", null, 4, null);
                }
            }
            return AMEngineResult.INSTANCE.ok(ids);
        }
        return AMEngineResult.Companion.failure$default(AMEngineResult.INSTANCE, AMEError.SERVICE_DIMENSION_MISMATCH, "批量插入失败：期望 " + expected + " 个 ID，实际 " + ids.length + "（常见原因为向量维度与引擎不一致）", null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long[] insertBatchRpc(List<float[]> vectors, List<? extends Map<String, ? extends Object>> metadataList) {
        if (vectors.isEmpty()) {
            return new long[0];
        }
        AMEngineNative aMEngineNativeEngine = engine();
        int dimension = aMEngineNativeEngine.getConfig().getDimension();
        List<float[]> list = vectors;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((float[]) it.next()).length != dimension) {
                    return new long[0];
                }
            }
        }
        try {
            if (metadataList == null) {
                return aMEngineNativeEngine.insertBatch(vectors);
            }
            if (metadataList.size() != vectors.size()) {
                return new long[0];
            }
            C5680i c5680iN = C1173v.n(vectors);
            ArrayList arrayList = new ArrayList(C1174w.x(c5680iN, 10));
            Iterator<Integer> it2 = c5680iN.iterator();
            while (it2.hasNext()) {
                arrayList.add(metadataList.get(((Z8.M) it2).nextInt()));
            }
            return aMEngineNativeEngine.insertBatch(vectors, arrayList);
        } catch (Exception e10) {
            Log.e(TAG, "insertBatch failed", e10);
            return new long[0];
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object insertBatchToCollection$default(AMEngineSession aMEngineSession, String str, List list, List list2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            list2 = null;
        }
        return aMEngineSession.insertBatchToCollection(str, list, list2, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final long insertDirect(float[] vector, Map<String, ? extends Object> metadata) {
        AMEngineNative aMEngineNativeEngine = engine();
        return metadata == null ? aMEngineNativeEngine.insert(vector) : aMEngineNativeEngine.insert(vector, metadata);
    }

    public static /* synthetic */ Object insertToCollection$default(AMEngineSession aMEngineSession, String str, float[] fArr, String str2, InterfaceC4014c interfaceC4014c, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            str2 = null;
        }
        return aMEngineSession.insertToCollection(str, fArr, str2, interfaceC4014c);
    }

    private final <T> AMEngineResult<T> nativeCall(InterfaceC5063a<? extends T> block) {
        try {
            return AMEngineResult.INSTANCE.ok(block.invoke());
        } catch (Exception e10) {
            return this.nativeFailureFromThrowable(e10);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final AMEngineResult nativeFailureFromThrowable(Throwable e10) {
        AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
        AMEError aMEError = AMEError.SERVICE_INTERNAL_ERROR;
        String message = e10.getMessage();
        if (message == null) {
            message = "引擎调用异常";
        }
        return companion.failure(aMEError, message, e10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final <T> AMEngineResult<T> notConnected() {
        AMEngineResult.Companion companion = AMEngineResult.INSTANCE;
        AMEError aMEError = AMEError.ARGS_NOT_CONNECTED;
        return AMEngineResult.Companion.failure$default(companion, aMEError, aMEError.getDesc(), null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<SearchResult> performSearch(SearchArgs args) {
        AMEngineNative aMEngineNativeEngine = engine();
        FilterStrategy filterStrategy = args.getFilterStrategy();
        String filterJson = args.getFilterJson();
        if ((filterJson == null || H.x0(filterJson)) && !args.getWithMetadata() && filterStrategy == FilterStrategy.POST_FILTER) {
            List<com.stepos.ame.SearchResult> listSearch = aMEngineNativeEngine.search(args.getQuery(), args.getTopK(), null, args.getOverfetchRatio());
            ArrayList arrayList = new ArrayList(C1174w.x(listSearch, 10));
            for (com.stepos.ame.SearchResult searchResult : listSearch) {
                arrayList.add(new SearchResult(searchResult.getId(), searchResult.getScore(), null));
            }
            return arrayList;
        }
        List<SearchResultWithMetadata> listSearchFull = aMEngineNativeEngine.searchFull(args.getQuery(), args.getTopK(), args.getFilterJson(), args.getOverfetchRatio(), args.getWithMetadata(), filterStrategy);
        ArrayList arrayList2 = new ArrayList(C1174w.x(listSearchFull, 10));
        for (SearchResultWithMetadata searchResultWithMetadata : listSearchFull) {
            arrayList2.add(new SearchResult(searchResultWithMetadata.getId(), searchResultWithMetadata.getScore(), args.getWithMetadata() ? searchResultWithMetadata.b() : null));
        }
        return arrayList2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchBatchResult performSearchBatch(SearchBatchArgs args) {
        List<float[]> queries = args.getQueries();
        if (queries.size() <= 0) {
            return new SearchBatchResult(C1173v.m());
        }
        AMEngineNative aMEngineNativeEngine = engine();
        int dimension = aMEngineNativeEngine.getConfig().getDimension();
        int length = queries.get(0).length;
        if (length == dimension) {
            List<float[]> list = queries;
            if (!(list instanceof Collection) || !list.isEmpty()) {
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    if (((float[]) it.next()).length != length) {
                    }
                }
            }
            try {
                List<List<SearchResultWithMetadata>> listSearchBatchFull = aMEngineNativeEngine.searchBatchFull(queries, args.getTopK(), args.getFilterJson(), args.getOverfetchRatio(), args.getWithMetadata(), args.getFilterStrategy());
                ArrayList arrayList = new ArrayList(C1174w.x(listSearchBatchFull, 10));
                Iterator<T> it2 = listSearchBatchFull.iterator();
                while (it2.hasNext()) {
                    List<SearchResultWithMetadata> list2 = (List) it2.next();
                    ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
                    for (SearchResultWithMetadata searchResultWithMetadata : list2) {
                        arrayList2.add(new SearchResult(searchResultWithMetadata.getId(), searchResultWithMetadata.getScore(), args.getWithMetadata() ? searchResultWithMetadata.b() : null));
                    }
                    arrayList.add(arrayList2);
                }
                return new SearchBatchResult(arrayList);
            } catch (Exception e10) {
                Log.e(TAG, "searchBatch failed", e10);
                return new SearchBatchResult(C1173v.m());
            }
        }
        Log.e(TAG, "searchBatch: query dimension mismatch with engine");
        return new SearchBatchResult(C1173v.m());
    }

    public static /* synthetic */ Object pruneQuarantine$default(AMEngineSession aMEngineSession, long j10, int i10, InterfaceC4014c interfaceC4014c, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            j10 = 604800000;
        }
        if ((i11 & 2) != 0) {
            i10 = 5;
        }
        return aMEngineSession.pruneQuarantine(j10, i10, interfaceC4014c);
    }

    public static /* synthetic */ Object searchBatchInCollection$default(AMEngineSession aMEngineSession, String str, List list, int i10, String str2, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return aMEngineSession.searchBatchInCollection(str, list, i10, str3, i11, interfaceC4014c);
    }

    public static /* synthetic */ Object searchInCollectionWithFilter$default(AMEngineSession aMEngineSession, String str, float[] fArr, int i10, String str2, int i11, InterfaceC4014c interfaceC4014c, int i12, Object obj) {
        if ((i12 & 8) != 0) {
            str2 = null;
        }
        String str3 = str2;
        if ((i12 & 16) != 0) {
            i11 = 2;
        }
        return aMEngineSession.searchInCollectionWithFilter(str, fArr, i10, str3, i11, interfaceC4014c);
    }

    public static /* synthetic */ Object setCollectionAutoSwitchConfig$default(AMEngineSession aMEngineSession, String str, boolean z10, int i10, int i11, long j10, int i12, InterfaceC4014c interfaceC4014c, int i13, Object obj) {
        if ((i13 & 2) != 0) {
            z10 = true;
        }
        return aMEngineSession.setCollectionAutoSwitchConfig(str, z10, i10, i11, j10, i12, interfaceC4014c);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0043, code lost:
    
        if (r11 != null) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0049, code lost:
    
        return r8.updateBatch(r9, r10);
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x0054, code lost:
    
        if (r11.size() == r9.size()) goto L26;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0056, code lost:
    
        return 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0057, code lost:
    
        r0 = r9.size();
        r2 = 0;
        r3 = 0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0060, code lost:
    
        if (r2 >= r0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x007c, code lost:
    
        if (r8.update(r9.get(r2).longValue(), r10.get(r2), r11.get(r2)) == false) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x007e, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0080, code lost:
    
        r2 = r2 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0083, code lost:
    
        return r3;
     */
    /* JADX WARN: Removed duplicated region for block: B:35:0x0043 A[EDGE_INSN: B:35:0x0043->B:18:0x0043 BREAK  A[LOOP:1: B:13:0x0033->B:40:?], EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int updateBatchRpc(java.util.List<java.lang.Long> r9, java.util.List<float[]> r10, java.util.List<? extends java.util.Map<java.lang.String, ? extends java.lang.Object>> r11) {
        /*
            r8 = this;
            boolean r0 = r9.isEmpty()
            r1 = 0
            if (r0 == 0) goto L8
            return r1
        L8:
            com.stepos.ame.AMEngineNative r8 = r8.engine()
            E6.a r0 = r8.getConfig()
            int r0 = r0.getDimension()
            int r2 = r9.size()
            int r3 = r10.size()
            if (r2 != r3) goto L8c
            r2 = r10
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            boolean r3 = r2 instanceof java.util.Collection
            if (r3 == 0) goto L2f
            r3 = r2
            java.util.Collection r3 = (java.util.Collection) r3
            boolean r3 = r3.isEmpty()
            if (r3 == 0) goto L2f
            goto L43
        L2f:
            java.util.Iterator r2 = r2.iterator()
        L33:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L43
            java.lang.Object r3 = r2.next()
            float[] r3 = (float[]) r3
            int r3 = r3.length
            if (r3 == r0) goto L33
            goto L8c
        L43:
            if (r11 != 0) goto L4c
            int r8 = r8.updateBatch(r9, r10)     // Catch: java.lang.Exception -> L4a
            return r8
        L4a:
            r8 = move-exception
            goto L84
        L4c:
            int r0 = r11.size()     // Catch: java.lang.Exception -> L4a
            int r2 = r9.size()     // Catch: java.lang.Exception -> L4a
            if (r0 == r2) goto L57
            return r1
        L57:
            r0 = r9
            java.util.Collection r0 = (java.util.Collection) r0     // Catch: java.lang.Exception -> L4a
            int r0 = r0.size()     // Catch: java.lang.Exception -> L4a
            r2 = r1
            r3 = r2
        L60:
            if (r2 >= r0) goto L83
            java.lang.Object r4 = r9.get(r2)     // Catch: java.lang.Exception -> L4a
            java.lang.Number r4 = (java.lang.Number) r4     // Catch: java.lang.Exception -> L4a
            long r4 = r4.longValue()     // Catch: java.lang.Exception -> L4a
            java.lang.Object r6 = r10.get(r2)     // Catch: java.lang.Exception -> L4a
            float[] r6 = (float[]) r6     // Catch: java.lang.Exception -> L4a
            java.lang.Object r7 = r11.get(r2)     // Catch: java.lang.Exception -> L4a
            java.util.Map r7 = (java.util.Map) r7     // Catch: java.lang.Exception -> L4a
            boolean r4 = r8.update(r4, r6, r7)     // Catch: java.lang.Exception -> L4a
            if (r4 == 0) goto L80
            int r3 = r3 + 1
        L80:
            int r2 = r2 + 1
            goto L60
        L83:
            return r3
        L84:
            java.lang.String r9 = "AMEngineSession"
            java.lang.String r10 = "updateBatch failed"
            android.util.Log.e(r9, r10, r8)
        L8c:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ame.sdk.AMEngineSession.updateBatchRpc(java.util.List, java.util.List, java.util.List):int");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final boolean updateDirect(long id, float[] newVector, Map<String, ? extends Object> metadata) {
        AMEngineNative aMEngineNativeEngine = engine();
        return metadata == null ? aMEngineNativeEngine.update(id, newVector) : aMEngineNativeEngine.update(id, newVector, metadata);
    }

    public final Object addShadowIndex(String str, String str2, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new AnonymousClass2(str, str2, null), interfaceC4014c);
    }

    public final Object addShadowIndexTyped(String str, String str2, int i10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37602(str, str2, i10, null), interfaceC4014c);
    }

    public final Object collectionPrimaryIndexId(String str, InterfaceC4014c<? super AMEngineResult<String>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37612(str, null), interfaceC4014c);
    }

    public final Object collectionQuarantinedFiles(String str, InterfaceC4014c<? super AMEngineResult<? extends List<String>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37622(str, null), interfaceC4014c);
    }

    public final Object collectionVectorCount(String str, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37632(str, null), interfaceC4014c);
    }

    public final Object compactAsync(double d10, boolean z10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37642(d10, z10, null), interfaceC4014c);
    }

    public final Object createCollection(String str, int i10, int i11, int i12, int i13, String str2, boolean z10, CollectionPersistConfig collectionPersistConfig, Long l10, Long l11, Long l12, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37652(str, i10, i11, i12, i13, str2, z10, collectionPersistConfig, l10, l11, l12, null), interfaceC4014c);
    }

    public final Object delete(DeleteArgs deleteArgs, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37662(deleteArgs, null), interfaceC4014c);
    }

    public final Object deleteBatch(DeleteBatchArgs deleteBatchArgs, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37672(deleteBatchArgs, null), interfaceC4014c);
    }

    public final Object deleteFromCollection(String str, long[] jArr, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37682(jArr, str, null), interfaceC4014c);
    }

    public final Object dropCollection(String str, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37692(str, null), interfaceC4014c);
    }

    public final Object flushAllCollections(InterfaceC4014c<? super AMEngineResult<Boolean>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37702(null), interfaceC4014c);
    }

    public final Object flushPersist(InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37712(null), interfaceC4014c);
    }

    public final Object getCollectionResidencyState(String str, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37722(str, null), interfaceC4014c);
    }

    public final Object getCollectionRuntimeStats(String str, InterfaceC4014c<? super AMEngineResult<CollectionRuntimeStats>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37732(str, null), interfaceC4014c);
    }

    public final Object getFieldSchemasJson(InterfaceC4014c<? super AMEngineResult<String>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37742(null), interfaceC4014c);
    }

    public final Object getMetadata(long j10, InterfaceC4014c<? super AMEngineResult<? extends Map<String, ? extends Object>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37752(j10, null), interfaceC4014c);
    }

    public final Object getMetadataCount(InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37762(null), interfaceC4014c);
    }

    public final Object getTotalCapacityBytes(InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37772(null), interfaceC4014c);
    }

    public final Object getVectorById(long j10, InterfaceC4014c<? super AMEngineResult<float[]>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37782(j10, null), interfaceC4014c);
    }

    public final Object getVectorCount(InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37792(null), interfaceC4014c);
    }

    public final Object insert(InsertArgs insertArgs, InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37802(insertArgs, null), interfaceC4014c);
    }

    public final Object insertBatch(InsertBatchArgs insertBatchArgs, InterfaceC4014c<? super AMEngineResult<long[]>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37812(insertBatchArgs, null), interfaceC4014c);
    }

    public final Object insertBatchToCollection(String str, List<float[]> list, List<String> list2, InterfaceC4014c<? super AMEngineResult<long[]>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37822(list, list2, str, null), interfaceC4014c);
    }

    public final Object insertToCollection(String str, float[] fArr, String str2, InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37832(fArr, str, str2, null), interfaceC4014c);
    }

    public final void invalidate$vector_release() {
        this.active = false;
    }

    /* renamed from: isConnected, reason: from getter */
    public final boolean getActive() {
        return this.active;
    }

    public final Object listCollections(InterfaceC4014c<? super AMEngineResult<? extends List<String>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37842(null), interfaceC4014c);
    }

    public final Object promoteIndex(String str, String str2, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37852(str, str2, null), interfaceC4014c);
    }

    public final Object pruneQuarantine(long j10, int i10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37862(j10, i10, null), interfaceC4014c);
    }

    public final Object registerMetadataField(String str, String str2, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37872(str, str2, null), interfaceC4014c);
    }

    public final Object reinitializeEngine(InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37882(null), interfaceC4014c);
    }

    public final Object removeDbForTest(InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37892(null), interfaceC4014c);
    }

    public final Object removeRetiredIndexes(String str, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37902(str, null), interfaceC4014c);
    }

    public final Object rollbackIndex(String str, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37912(str, null), interfaceC4014c);
    }

    public final Object save(InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37922(null), interfaceC4014c);
    }

    public final Object search(SearchArgs searchArgs, InterfaceC4014c<? super AMEngineResult<? extends List<SearchResult>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37932(searchArgs, null), interfaceC4014c);
    }

    public final Object searchBatch(SearchBatchArgs searchBatchArgs, InterfaceC4014c<? super AMEngineResult<SearchBatchResult>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37942(searchBatchArgs, null), interfaceC4014c);
    }

    public final Object searchBatchInCollection(String str, List<float[]> list, int i10, String str2, int i11, InterfaceC4014c<? super AMEngineResult<? extends List<? extends List<AMEngineNative.CollectionHit>>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37952(list, i10, str, str2, i11, null), interfaceC4014c);
    }

    public final Object searchInCollection(String str, float[] fArr, int i10, InterfaceC4014c<? super AMEngineResult<? extends List<AMEngineNative.CollectionHit>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37962(fArr, i10, str, null), interfaceC4014c);
    }

    public final Object searchInCollectionWithFilter(String str, float[] fArr, int i10, String str2, int i11, InterfaceC4014c<? super AMEngineResult<? extends List<AMEngineNative.CollectionHit>>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37972(fArr, i10, str, str2, i11, null), interfaceC4014c);
    }

    public final Object setCollectionAutoSwitchConfig(String str, boolean z10, int i10, int i11, long j10, int i12, InterfaceC4014c<? super AMEngineResult<Boolean>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37982(str, z10, i10, i11, j10, i12, null), interfaceC4014c);
    }

    public final Object setCollectionPersistConfig(CollectionPersistConfig collectionPersistConfig, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C37992(collectionPersistConfig, null), interfaceC4014c);
    }

    public final Object setCollectionResidencyConfig(boolean z10, int i10, long j10, long j11, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38002(z10, i10, j10, j11, null), interfaceC4014c);
    }

    public final Object setGlobalCapacityMaxBytes(long j10, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38012(j10, null), interfaceC4014c);
    }

    public final Object totalIonAllocatedBytes(InterfaceC4014c<? super AMEngineResult<Long>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38022(null), interfaceC4014c);
    }

    public final Object triggerIvfTrain(String str, String str2, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38032(str, str2, null), interfaceC4014c);
    }

    public final Object triggerResidencyScan(InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38042(null), interfaceC4014c);
    }

    public final Object update(UpdateArgs updateArgs, InterfaceC4014c<? super AMEngineResult<t>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38052(updateArgs, null), interfaceC4014c);
    }

    public final Object updateBatch(UpdateBatchArgs updateBatchArgs, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38062(updateBatchArgs, null), interfaceC4014c);
    }

    public final Object updateBatchInCollection(String str, long[] jArr, List<float[]> list, int i10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38072(jArr, list, i10, str, null), interfaceC4014c);
    }

    public final Object updateInCollection(String str, long[] jArr, float[] fArr, int i10, InterfaceC4014c<? super AMEngineResult<Integer>> interfaceC4014c) {
        return C1056g.j(Y.b(), new C38082(jArr, fArr, i10, str, null), interfaceC4014c);
    }
}
