package com.stepos.agentbus.generated;

import C7.r;
import J7.c;
import S7.k;
import S7.n;
import android.util.Log;
import androidx.compose.runtime.ComposerKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.ItemTouchHelper;
import com.bytedance.apm.agent.v2.instrumentation.AppAgent;
import com.stepos.ability.beaninternal.task.GuiTaskProgressKt;
import com.stepos.agentbus.generated.HealthStatus;
import com.stepos.taskrobot.settingsprovider.SettingsConfig;
import j9.m;
import java.io.DataOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.intrinsics.CoroutineSingletons;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.e;
import kotlinx.coroutines.flow.d;
import kotlinx.coroutines.flow.i;
import m9.AbstractC1683A;
import m9.AbstractC1691I;
import m9.C1724q;
import m9.InterfaceC1723p;
import m9.InterfaceC1733z;
import m9.b0;
import m9.c0;
import m9.r0;
import o9.InterfaceC1779e;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p9.j;
import p9.t;
import w9.InterfaceC2108a;
import z2.l;

@Metadata(d1 = {"\u0000Þ\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0016\b\u0016\u0018\u0000 ±\u00012\u00020\u0001:\u0006²\u0001³\u0001±\u0001B¯\u0001\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0002\u0012\u0006\u0010\b\u001a\u00020\u0002\u0012\b\b\u0002\u0010\t\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u000b\u001a\u00020\n\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\"\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f\u0012\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\u0010\b\u0002\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0016\u001a\u00020\n¢\u0006\u0004\b\u0017\u0010\u0018J\r\u0010\u0019\u001a\u00020\u0012¢\u0006\u0004\b\u0019\u0010\u001aJ\r\u0010\u001b\u001a\u00020\u0012¢\u0006\u0004\b\u001b\u0010\u001aJ\u001a\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001c\u001a\u00020\nH\u0086@¢\u0006\u0004\b\u001e\u0010\u001fJ1\u0010#\u001a\u00020\"2\"\u0010!\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020 \u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f¢\u0006\u0004\b#\u0010$J0\u0010(\u001a\u00020\u00022\u0006\u0010%\u001a\u00020\u00022\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&H\u0086@¢\u0006\u0004\b(\u0010)J0\u0010,\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&H\u0086@¢\u0006\u0004\b,\u0010)J0\u0010-\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00022\u0016\b\u0002\u0010+\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&H\u0086@¢\u0006\u0004\b-\u0010)J\u0018\u0010/\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0002H\u0086@¢\u0006\u0004\b/\u00100J\r\u00101\u001a\u00020\u0002¢\u0006\u0004\b1\u00102J$\u00104\u001a\u0004\u0018\u00010\u00102\u0006\u00103\u001a\u00020\u00022\b\b\u0002\u0010\u001c\u001a\u00020\nH\u0086@¢\u0006\u0004\b4\u00105J:\u00107\u001a\u0002062\u0006\u0010%\u001a\u00020\u00022\u0016\b\u0002\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\b\b\u0002\u0010\u001c\u001a\u00020\nH\u0086@¢\u0006\u0004\b7\u00108J\r\u00109\u001a\u00020\u0012¢\u0006\u0004\b9\u0010\u001aJ\u0015\u0010<\u001a\u00020\u00122\u0006\u0010;\u001a\u00020:¢\u0006\u0004\b<\u0010=J\u0015\u0010?\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0002¢\u0006\u0004\b?\u0010@J#\u0010B\u001a\u00020\u00022\u0014\u0010A\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&¢\u0006\u0004\bB\u0010CJ\u0017\u0010E\u001a\u00020\u00012\b\u0010D\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bE\u0010FJ#\u0010H\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\u0006\u0010G\u001a\u00020\u0010¢\u0006\u0004\bH\u0010IJ\u0019\u0010J\u001a\u0004\u0018\u00010\u00012\b\u0010D\u001a\u0004\u0018\u00010\u0001¢\u0006\u0004\bJ\u0010FJ5\u0010Q\u001a\b\u0012\u0004\u0012\u00028\u00000P\"\u0004\b\u0000\u0010K2\u0006\u0010M\u001a\u00020L2\u0012\u0010O\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00028\u00000N¢\u0006\u0004\bQ\u0010RJ\u001b\u0010Q\u001a\b\u0012\u0004\u0012\u00020\u00020P2\u0006\u0010M\u001a\u00020L¢\u0006\u0004\bQ\u0010SJ\u000f\u0010T\u001a\u00020\u0002H\u0002¢\u0006\u0004\bT\u00102J\u000f\u0010U\u001a\u00020\u0012H\u0002¢\u0006\u0004\bU\u0010\u001aJ#\u0010W\u001a\u00020\u00122\u0012\u0010!\u001a\u000e\u0012\u0004\u0012\u00020V\u0012\u0004\u0012\u00020V0NH\u0002¢\u0006\u0004\bW\u0010XJ\u000f\u0010Y\u001a\u00020\u0012H\u0002¢\u0006\u0004\bY\u0010\u001aJ;\u0010Z\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\u0014\u0010'\u001a\u0010\u0012\u0004\u0012\u00020\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u00010&2\u0006\u00103\u001a\u00020\u0002H\u0002¢\u0006\u0004\bZ\u0010[J\u0010\u0010\\\u001a\u00020\u0012H\u0082@¢\u0006\u0004\b\\\u0010]J\u000f\u0010^\u001a\u00020\u0012H\u0002¢\u0006\u0004\b^\u0010\u001aJ\u0010\u0010_\u001a\u00020\u001dH\u0082@¢\u0006\u0004\b_\u0010]J\u0018\u0010a\u001a\u00020\u00122\u0006\u0010`\u001a\u00020\u0010H\u0082@¢\u0006\u0004\ba\u0010bJ\u0019\u0010c\u001a\u00020\u00122\b\u0010+\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0004\bc\u0010dJ\u0017\u0010f\u001a\u00020e2\u0006\u0010G\u001a\u00020\u0010H\u0002¢\u0006\u0004\bf\u0010gJ\u0018\u0010h\u001a\u00020\u00122\u0006\u0010.\u001a\u00020\u0002H\u0082@¢\u0006\u0004\bh\u00100R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010iR\u001a\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u0010jR\u0014\u0010\u0006\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u0010iR\u0014\u0010\u0007\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010iR\u0014\u0010\b\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u0010iR\u0014\u0010\t\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010iR\u0014\u0010\u000b\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u0010kR\u0014\u0010\r\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010lR\u0014\u0010\u000e\u001a\u00020\f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010lR0\u0010\u0013\u001a\u001e\b\u0001\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u000f8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0013\u0010mR\u001c\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0014\u0010jR\u001c\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0002\u0018\u00010\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0015\u0010jR\u0014\u0010\u0016\u001a\u00020\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0016\u0010kR\u0016\u0010n\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bn\u0010oR\u0018\u0010p\u001a\u0004\u0018\u00010\"8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bp\u0010qR\u0014\u0010s\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bs\u0010tR\u0018\u0010v\u001a\u0004\u0018\u00010u8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bv\u0010wR\u0014\u0010y\u001a\u00020x8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010zR\u001a\u0010|\u001a\b\u0012\u0004\u0012\u00020\u001d0{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b|\u0010}R\u001a\u0010~\u001a\b\u0012\u0004\u0012\u00020V0{8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b~\u0010}R\"\u0010\u0080\u0001\u001a\b\u0012\u0004\u0012\u00020V0\u007f8\u0006¢\u0006\u0010\n\u0006\b\u0080\u0001\u0010\u0081\u0001\u001a\u0006\b\u0082\u0001\u0010\u0083\u0001R\u0018\u0010\u0084\u0001\u001a\u00020\f8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0084\u0001\u0010lR\u0018\u0010\u0086\u0001\u001a\u00030\u0085\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0086\u0001\u0010\u0087\u0001R\u0016\u0010\u0088\u0001\u001a\u00020r8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0088\u0001\u0010tR\u001e\u0010\u008a\u0001\u001a\t\u0012\u0004\u0012\u00020\u00120\u0089\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008a\u0001\u0010\u008b\u0001R\u0018\u0010\u008c\u0001\u001a\u00020\n8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u008c\u0001\u0010kR\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R7\u0010\u0090\u0001\u001a\u0011\u0012\u0005\u0012\u00030\u008f\u0001\u0012\u0004\u0012\u00020\u0012\u0018\u00010N8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\b\u0090\u0001\u0010\u0091\u0001\u001a\u0006\b\u0092\u0001\u0010\u0093\u0001\"\u0005\b\u0094\u0001\u0010XR+\u0010\u0097\u0001\u001a\u0016\u0012\u0004\u0012\u00020\u0002\u0012\u000b\u0012\t\u0012\u0004\u0012\u00020\u00100\u0096\u00010\u0095\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u001c\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020e0{8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0099\u0001\u0010}R\u001c\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020e0{8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009a\u0001\u0010}R\u001c\u0010\u009b\u0001\u001a\b\u0012\u0004\u0012\u00020e0{8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009b\u0001\u0010}R\u001c\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020e0{8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009c\u0001\u0010}R\u001c\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020e0{8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009d\u0001\u0010}R\u001d\u0010\u009f\u0001\u001a\t\u0012\u0005\u0012\u00030\u009e\u00010{8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u009f\u0001\u0010}R\"\u0010 \u0001\u001a\b\u0012\u0004\u0012\u00020e0\u007f8\u0006¢\u0006\u0010\n\u0006\b \u0001\u0010\u0081\u0001\u001a\u0006\b¡\u0001\u0010\u0083\u0001R\"\u0010¢\u0001\u001a\b\u0012\u0004\u0012\u00020e0\u007f8\u0006¢\u0006\u0010\n\u0006\b¢\u0001\u0010\u0081\u0001\u001a\u0006\b£\u0001\u0010\u0083\u0001R\"\u0010¤\u0001\u001a\b\u0012\u0004\u0012\u00020e0\u007f8\u0006¢\u0006\u0010\n\u0006\b¤\u0001\u0010\u0081\u0001\u001a\u0006\b¥\u0001\u0010\u0083\u0001R\"\u0010¦\u0001\u001a\b\u0012\u0004\u0012\u00020e0\u007f8\u0006¢\u0006\u0010\n\u0006\b¦\u0001\u0010\u0081\u0001\u001a\u0006\b§\u0001\u0010\u0083\u0001R\"\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020e0\u007f8\u0006¢\u0006\u0010\n\u0006\b¨\u0001\u0010\u0081\u0001\u001a\u0006\b©\u0001\u0010\u0083\u0001R#\u0010ª\u0001\u001a\t\u0012\u0005\u0012\u00030\u009e\u00010\u007f8\u0006¢\u0006\u0010\n\u0006\bª\u0001\u0010\u0081\u0001\u001a\u0006\b«\u0001\u0010\u0083\u0001R\"\u0010¬\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u007f8\u0006¢\u0006\u0010\n\u0006\b¬\u0001\u0010\u0081\u0001\u001a\u0006\b\u00ad\u0001\u0010\u0083\u0001R\u0014\u0010®\u0001\u001a\u00020\u001d8F¢\u0006\b\u001a\u0006\b®\u0001\u0010¯\u0001R\u0014\u0010°\u0001\u001a\u00020\u001d8F¢\u0006\b\u001a\u0006\b°\u0001\u0010¯\u0001¨\u0006´\u0001"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase;", "", "", "socketName", "Lkotlin/Function0;", "clientIdProvider", "displayName", "version", "role", "reqIdPrefix", "", "reconnectDelayMs", "", "protocolMin", "protocolMax", "Lkotlin/Function2;", "Lorg/json/JSONObject;", "LH7/c;", "LC7/r;", "dispatchEvent", "clientExtra", "connectParamsExtra", "idleTimeoutMs", AppAgent.CONSTRUCT, "(Ljava/lang/String;LS7/a;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;JIILS7/n;LS7/a;LS7/a;J)V", "start", "()V", "stop", "timeoutMs", "", "awaitConnected", "(JLH7/c;)Ljava/lang/Object;", "Lm9/z;", "block", "Lm9/c0;", "launchOnScope", "(LS7/n;)Lm9/c0;", GuiTaskProgressKt.GuiTaskProgress_KEY_METHOD, "", "params", "sendReq", "(Ljava/lang/String;Ljava/util/Map;LH7/c;)Ljava/lang/Object;", NotificationCompat.CATEGORY_EVENT, "payload", "sendEvent", "sendNodeEvent", "json", "writeRawFrame", "(Ljava/lang/String;LH7/c;)Ljava/lang/Object;", "allocateReqId", "()Ljava/lang/String;", "frameId", "awaitResponse", "(Ljava/lang/String;JLH7/c;)Ljava/lang/Object;", "Lcom/stepos/agentbus/generated/InvokeResult;", "request", "(Ljava/lang/String;Ljava/util/Map;JLH7/c;)Ljava/lang/Object;", "reconnect", "Lcom/stepos/agentbus/generated/ChannelReadyContext;", "context", "wakeAndReconnect", "(Lcom/stepos/agentbus/generated/ChannelReadyContext;)V", "s", "jsonEscape", "(Ljava/lang/String;)Ljava/lang/String;", "map", "toJsonString", "(Ljava/util/Map;)Ljava/lang/String;", "v", "toJsonValue", "(Ljava/lang/Object;)Ljava/lang/Object;", "obj", "jsonObjectToMap", "(Lorg/json/JSONObject;)Ljava/util/Map;", "jsonValueToKotlin", ExifInterface.GPS_DIRECTION_TRUE, "Lorg/json/JSONArray;", "arr", "Lkotlin/Function1;", "parse", "", "arrToList", "(Lorg/json/JSONArray;LS7/k;)Ljava/util/List;", "(Lorg/json/JSONArray;)Ljava/util/List;", "clientId", "touchActivity", "Lcom/stepos/agentbus/generated/AgentBusBindingBase$ConnectionStatus;", "mutateStatus", "(LS7/k;)V", "launchHealthObserver", "injectTraceMeta", "(Ljava/util/Map;Ljava/lang/String;)Ljava/util/Map;", "runForever", "(LH7/c;)Ljava/lang/Object;", "notifyChannelReadyIfPending", "connectAndServe", TypedValues.AttributesType.S_FRAME, "dispatchIncoming", "(Lorg/json/JSONObject;LH7/c;)Ljava/lang/Object;", "applyHealthSnapshot", "(Lorg/json/JSONObject;)V", "Lcom/stepos/agentbus/generated/HealthStatus;", "parseHealth", "(Lorg/json/JSONObject;)Lcom/stepos/agentbus/generated/HealthStatus;", "writeFrame", "Ljava/lang/String;", "LS7/a;", "J", "I", "LS7/n;", "scope", "Lm9/z;", "serveJob", "Lm9/c0;", "Ljava/util/concurrent/atomic/AtomicLong;", "seq", "Ljava/util/concurrent/atomic/AtomicLong;", "Ljava/io/DataOutputStream;", "outputStream", "Ljava/io/DataOutputStream;", "Lw9/a;", "writeMutex", "Lw9/a;", "Lp9/j;", "connectedFlow", "Lp9/j;", "mutableStatus", "Lp9/t;", "status", "Lp9/t;", "getStatus", "()Lp9/t;", "pendingOutboxDepth", "Ljava/util/concurrent/atomic/AtomicInteger;", "pendingInboxDepth", "Ljava/util/concurrent/atomic/AtomicInteger;", "reconnectAttemptsCounter", "Lo9/e;", "reconnectSignal", "Lo9/e;", "lastActivityMs", "pendingReady", "Lcom/stepos/agentbus/generated/ChannelReadyContext;", "Lcom/stepos/agentbus/generated/ChannelReadyEvent;", "onChannelReady", "LS7/k;", "getOnChannelReady", "()LS7/k;", "setOnChannelReady", "Ljava/util/concurrent/ConcurrentHashMap;", "Lm9/p;", "pendingResponses", "Ljava/util/concurrent/ConcurrentHashMap;", "mutableServiceHealth", "mutableChatHealth", "mutableToolsHealth", "mutableUpstreamHealth", "mutableBffHealth", "Lcom/stepos/agentbus/generated/BffLinkStatus;", "mutableBffLinkState", "serviceHealth", "getServiceHealth", "chatHealth", "getChatHealth", "toolsHealth", "getToolsHealth", "upstreamHealth", "getUpstreamHealth", "bffHealth", "getBffHealth", "bffLinkState", "getBffLinkState", "connected", "getConnected", "isConnected", "()Z", "isScopeActive", "Companion", "ConnectionStatus", "FrameFingerprintCache", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public class AgentBusBindingBase {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final int FRAME_DEDUP_CAPACITY = 128;

    @Deprecated
    public static final long INBOUND_ENQUEUE_TIMEOUT_MS = 5000;

    @Deprecated
    public static final int INBOUND_QUEUE_CAPACITY = 64;

    @Deprecated
    public static final int MAX_INBOUND_FRAME_BYTES = 2097152;

    @Deprecated
    public static final String TAG = "AgentBusBindingBase";
    private final t bffHealth;
    private final t bffLinkState;
    private final t chatHealth;
    private final S7.a clientExtra;
    private final S7.a clientIdProvider;
    private final S7.a connectParamsExtra;
    private final t connected;
    private final j connectedFlow;
    private final n dispatchEvent;
    private final String displayName;
    private final long idleTimeoutMs;
    private volatile long lastActivityMs;
    private final j mutableBffHealth;
    private final j mutableBffLinkState;
    private final j mutableChatHealth;
    private final j mutableServiceHealth;
    private final j mutableStatus;
    private final j mutableToolsHealth;
    private final j mutableUpstreamHealth;
    private k onChannelReady;
    private volatile DataOutputStream outputStream;
    private final AtomicInteger pendingInboxDepth;
    private volatile int pendingOutboxDepth;
    private volatile ChannelReadyContext pendingReady;
    private final ConcurrentHashMap<String, InterfaceC1723p> pendingResponses;
    private final int protocolMax;
    private final int protocolMin;
    private final AtomicLong reconnectAttemptsCounter;
    private final long reconnectDelayMs;
    private final InterfaceC1779e reconnectSignal;
    private final String reqIdPrefix;
    private final String role;
    private InterfaceC1733z scope;
    private final AtomicLong seq;
    private c0 serveJob;
    private final t serviceHealth;
    private final String socketName;
    private final t status;
    private final t toolsHealth;
    private final t upstreamHealth;
    private final String version;
    private final InterfaceC2108a writeMutex;

    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0012\n\u0000\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\u000eR\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0007X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u000f"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase$Companion;", "", AppAgent.CONSTRUCT, "()V", "TAG", "", "MAX_INBOUND_FRAME_BYTES", "", "INBOUND_QUEUE_CAPACITY", "INBOUND_ENQUEUE_TIMEOUT_MS", "", "FRAME_DEDUP_CAPACITY", "fnv1a64", SettingsConfig.KEY_DATA, "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(e eVar) {
            this();
        }

        public final long fnv1a64(byte[] data) {
            kotlin.jvm.internal.k.f(data, "data");
            long j5 = -3750763034362895579L;
            for (byte b : data) {
                j5 = (j5 ^ (b & 255)) * 1099511628211L;
            }
            return j5;
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\"\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B_\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\t\u0012\b\b\u0002\u0010\u000b\u001a\u00020\t\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\r\u0010\u000eJ\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003J\u0010\u0010\u001f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\u0010\u0010 \u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012J\t\u0010!\u001a\u00020\u0005HÆ\u0003J\u0010\u0010\"\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u0018J\t\u0010#\u001a\u00020\tHÆ\u0003J\t\u0010$\u001a\u00020\tHÆ\u0003J\u0010\u0010%\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0012Jf\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\t2\b\b\u0002\u0010\u000b\u001a\u00020\t2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010'J\u0013\u0010(\u001a\u00020\u00032\b\u0010)\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010*\u001a\u00020\tHÖ\u0001J\t\u0010+\u001a\u00020,HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0014\u0010\u0012R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\n\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0011\u0010\u000b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001bR\u0015\u0010\f\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u001d\u0010\u0012¨\u0006-"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase$ConnectionStatus;", "", "connected", "", "lastConnectedAtMs", "", "lastDisconnectAtMs", "reconnectAttempts", "negotiatedProtocol", "", "outboxDepth", "inboxDepth", "lastWriteAtMs", AppAgent.CONSTRUCT, "(ZLjava/lang/Long;Ljava/lang/Long;JLjava/lang/Integer;IILjava/lang/Long;)V", "getConnected", "()Z", "getLastConnectedAtMs", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getLastDisconnectAtMs", "getReconnectAttempts", "()J", "getNegotiatedProtocol", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOutboxDepth", "()I", "getInboxDepth", "getLastWriteAtMs", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(ZLjava/lang/Long;Ljava/lang/Long;JLjava/lang/Integer;IILjava/lang/Long;)Lcom/stepos/agentbus/generated/AgentBusBindingBase$ConnectionStatus;", "equals", "other", "hashCode", "toString", "", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class ConnectionStatus {
        private final boolean connected;
        private final int inboxDepth;
        private final Long lastConnectedAtMs;
        private final Long lastDisconnectAtMs;
        private final Long lastWriteAtMs;
        private final Integer negotiatedProtocol;
        private final int outboxDepth;
        private final long reconnectAttempts;

        public ConnectionStatus() {
            this(false, null, null, 0L, null, 0, 0, null, 255, null);
        }

        public static /* synthetic */ ConnectionStatus copy$default(ConnectionStatus connectionStatus, boolean z10, Long l, Long l5, long j5, Integer num, int i, int i6, Long l9, int i10, Object obj) {
            if ((i10 & 1) != 0) {
                z10 = connectionStatus.connected;
            }
            if ((i10 & 2) != 0) {
                l = connectionStatus.lastConnectedAtMs;
            }
            if ((i10 & 4) != 0) {
                l5 = connectionStatus.lastDisconnectAtMs;
            }
            if ((i10 & 8) != 0) {
                j5 = connectionStatus.reconnectAttempts;
            }
            if ((i10 & 16) != 0) {
                num = connectionStatus.negotiatedProtocol;
            }
            if ((i10 & 32) != 0) {
                i = connectionStatus.outboxDepth;
            }
            if ((i10 & 64) != 0) {
                i6 = connectionStatus.inboxDepth;
            }
            if ((i10 & 128) != 0) {
                l9 = connectionStatus.lastWriteAtMs;
            }
            long j6 = j5;
            Long l10 = l5;
            return connectionStatus.copy(z10, l, l10, j6, num, i, i6, l9);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getConnected() {
            return this.connected;
        }

        /* renamed from: component2, reason: from getter */
        public final Long getLastConnectedAtMs() {
            return this.lastConnectedAtMs;
        }

        /* renamed from: component3, reason: from getter */
        public final Long getLastDisconnectAtMs() {
            return this.lastDisconnectAtMs;
        }

        /* renamed from: component4, reason: from getter */
        public final long getReconnectAttempts() {
            return this.reconnectAttempts;
        }

        /* renamed from: component5, reason: from getter */
        public final Integer getNegotiatedProtocol() {
            return this.negotiatedProtocol;
        }

        /* renamed from: component6, reason: from getter */
        public final int getOutboxDepth() {
            return this.outboxDepth;
        }

        /* renamed from: component7, reason: from getter */
        public final int getInboxDepth() {
            return this.inboxDepth;
        }

        /* renamed from: component8, reason: from getter */
        public final Long getLastWriteAtMs() {
            return this.lastWriteAtMs;
        }

        public final ConnectionStatus copy(boolean connected, Long lastConnectedAtMs, Long lastDisconnectAtMs, long reconnectAttempts, Integer negotiatedProtocol, int outboxDepth, int inboxDepth, Long lastWriteAtMs) {
            return new ConnectionStatus(connected, lastConnectedAtMs, lastDisconnectAtMs, reconnectAttempts, negotiatedProtocol, outboxDepth, inboxDepth, lastWriteAtMs);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectionStatus)) {
                return false;
            }
            ConnectionStatus connectionStatus = (ConnectionStatus) other;
            return this.connected == connectionStatus.connected && kotlin.jvm.internal.k.b(this.lastConnectedAtMs, connectionStatus.lastConnectedAtMs) && kotlin.jvm.internal.k.b(this.lastDisconnectAtMs, connectionStatus.lastDisconnectAtMs) && this.reconnectAttempts == connectionStatus.reconnectAttempts && kotlin.jvm.internal.k.b(this.negotiatedProtocol, connectionStatus.negotiatedProtocol) && this.outboxDepth == connectionStatus.outboxDepth && this.inboxDepth == connectionStatus.inboxDepth && kotlin.jvm.internal.k.b(this.lastWriteAtMs, connectionStatus.lastWriteAtMs);
        }

        public final boolean getConnected() {
            return this.connected;
        }

        public final int getInboxDepth() {
            return this.inboxDepth;
        }

        public final Long getLastConnectedAtMs() {
            return this.lastConnectedAtMs;
        }

        public final Long getLastDisconnectAtMs() {
            return this.lastDisconnectAtMs;
        }

        public final Long getLastWriteAtMs() {
            return this.lastWriteAtMs;
        }

        public final Integer getNegotiatedProtocol() {
            return this.negotiatedProtocol;
        }

        public final int getOutboxDepth() {
            return this.outboxDepth;
        }

        public final long getReconnectAttempts() {
            return this.reconnectAttempts;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.connected) * 31;
            Long l = this.lastConnectedAtMs;
            int iHashCode2 = (iHashCode + (l == null ? 0 : l.hashCode())) * 31;
            Long l5 = this.lastDisconnectAtMs;
            int iC = androidx.appfunctions.metadata.a.c((iHashCode2 + (l5 == null ? 0 : l5.hashCode())) * 31, 31, this.reconnectAttempts);
            Integer num = this.negotiatedProtocol;
            int iA = androidx.constraintlayout.core.dsl.a.a(this.inboxDepth, androidx.constraintlayout.core.dsl.a.a(this.outboxDepth, (iC + (num == null ? 0 : num.hashCode())) * 31, 31), 31);
            Long l9 = this.lastWriteAtMs;
            return iA + (l9 != null ? l9.hashCode() : 0);
        }

        public String toString() {
            return "ConnectionStatus(connected=" + this.connected + ", lastConnectedAtMs=" + this.lastConnectedAtMs + ", lastDisconnectAtMs=" + this.lastDisconnectAtMs + ", reconnectAttempts=" + this.reconnectAttempts + ", negotiatedProtocol=" + this.negotiatedProtocol + ", outboxDepth=" + this.outboxDepth + ", inboxDepth=" + this.inboxDepth + ", lastWriteAtMs=" + this.lastWriteAtMs + ")";
        }

        public ConnectionStatus(boolean z10, Long l, Long l5, long j5, Integer num, int i, int i6, Long l9) {
            this.connected = z10;
            this.lastConnectedAtMs = l;
            this.lastDisconnectAtMs = l5;
            this.reconnectAttempts = j5;
            this.negotiatedProtocol = num;
            this.outboxDepth = i;
            this.inboxDepth = i6;
            this.lastWriteAtMs = l9;
        }

        public /* synthetic */ ConnectionStatus(boolean z10, Long l, Long l5, long j5, Integer num, int i, int i6, Long l9, int i10, e eVar) {
            this((i10 & 1) != 0 ? false : z10, (i10 & 2) != 0 ? null : l, (i10 & 4) != 0 ? null : l5, (i10 & 8) != 0 ? 0L : j5, (i10 & 16) != 0 ? null : num, (i10 & 32) != 0 ? 0 : i, (i10 & 64) != 0 ? 0 : i6, (i10 & 128) != 0 ? null : l9);
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\b\u001a\u0012\u0012\u0004\u0012\u00020\n0\tj\b\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/stepos/agentbus/generated/AgentBusBindingBase$FrameFingerprintCache;", "", "capacity", "", AppAgent.CONSTRUCT, "(I)V", "order", "", "seen", "Ljava/util/HashSet;", "", "Lkotlin/collections/HashSet;", "next", "size", "rememberIfNew", "", "hash", "agentbus-client_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class FrameFingerprintCache {
        private final int capacity;
        private int next;
        private final long[] order;
        private final HashSet<Long> seen;
        private int size;

        public FrameFingerprintCache(int i) {
            this.capacity = i;
            this.order = new long[i];
            this.seen = new HashSet<>(i * 2);
        }

        public final boolean rememberIfNew(long hash) {
            if (!this.seen.add(Long.valueOf(hash))) {
                return false;
            }
            int i = this.size;
            if (i == this.capacity) {
                this.seen.remove(Long.valueOf(this.order[this.next]));
            } else {
                this.size = i + 1;
            }
            long[] jArr = this.order;
            int i6 = this.next;
            jArr[i6] = hash;
            this.next = (i6 + 1) % this.capacity;
            return true;
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {219}, m = "awaitConnected", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        long J$0;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.awaitConnected(0L, this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2", f = "AgentBusBindingBase.kt", l = {219}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "", "<anonymous>", "(Lm9/z;)Z"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2, reason: invalid class name */
    public static final class AnonymousClass2 extends SuspendLambda implements n {
        int label;

        @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2$1", f = "AgentBusBindingBase.kt", l = {}, m = "invokeSuspend", v = 1)
        @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "", "it"}, k = 3, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2$1, reason: invalid class name */
        public static final class AnonymousClass1 extends SuspendLambda implements n {
            /* synthetic */ boolean Z$0;
            int label;

            public AnonymousClass1(H7.c<? super AnonymousClass1> cVar) {
                super(2, cVar);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final H7.c<r> create(Object obj, H7.c<?> cVar) {
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(cVar);
                anonymousClass1.Z$0 = ((Boolean) obj).booleanValue();
                return anonymousClass1;
            }

            @Override // S7.n
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                return invoke(((Boolean) obj).booleanValue(), (H7.c<? super Boolean>) obj2);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                boolean z10 = this.Z$0;
                CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return Boolean.valueOf(z10);
            }

            public final Object invoke(boolean z10, H7.c<? super Boolean> cVar) {
                return ((AnonymousClass1) create(Boolean.valueOf(z10), cVar)).invokeSuspend(r.f317a);
            }
        }

        public AnonymousClass2(H7.c<? super AnonymousClass2> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AgentBusBindingBase.this.new AnonymousClass2(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                j jVar = AgentBusBindingBase.this.connectedFlow;
                AnonymousClass1 anonymousClass1 = new AnonymousClass1(null);
                this.label = 1;
                if (d.i(jVar, anonymousClass1, this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return Boolean.TRUE;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super Boolean> cVar) {
            return ((AnonymousClass2) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {282}, m = "awaitResponse", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10351 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public C10351(H7.c<? super C10351> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.awaitResponse(null, 0L, this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$2", f = "AgentBusBindingBase.kt", l = {282}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "Lorg/json/JSONObject;", "<anonymous>", "(Lm9/z;)Lorg/json/JSONObject;"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$2, reason: invalid class name and case insensitive filesystem */
    public static final class C10362 extends SuspendLambda implements n {
        final /* synthetic */ InterfaceC1723p $deferred;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10362(InterfaceC1723p interfaceC1723p, H7.c<? super C10362> cVar) {
            super(2, cVar);
            this.$deferred = interfaceC1723p;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return new C10362(this.$deferred, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                return obj;
            }
            kotlin.b.b(obj);
            InterfaceC1723p interfaceC1723p = this.$deferred;
            this.label = 1;
            Object objZ = ((C1724q) interfaceC1723p).z(this);
            return objZ == coroutineSingletons ? coroutineSingletons : objZ;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super JSONObject> cVar) {
            return ((C10362) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {450, 493, 498}, m = "connectAndServe", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$connectAndServe$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10371 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$11;
        Object L$12;
        Object L$13;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        public C10371(H7.c<? super C10371> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.connectAndServe(this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {546}, m = "dispatchIncoming", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$dispatchIncoming$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10381 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C10381(H7.c<? super C10381> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.dispatchIncoming(null, this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$launchHealthObserver$1", f = "AgentBusBindingBase.kt", l = {180}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$launchHealthObserver$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10391 extends SuspendLambda implements n {
        int label;

        public C10391(H7.c<? super C10391> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AgentBusBindingBase.this.new C10391(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
                throw new KotlinNothingValueException();
            }
            kotlin.b.b(obj);
            j jVar = AgentBusBindingBase.this.connectedFlow;
            final AgentBusBindingBase agentBusBindingBase = AgentBusBindingBase.this;
            p9.d dVar = new p9.d() { // from class: com.stepos.agentbus.generated.AgentBusBindingBase.launchHealthObserver.1.1
                @Override // p9.d
                public /* bridge */ /* synthetic */ Object emit(Object obj2, H7.c cVar) {
                    return emit(((Boolean) obj2).booleanValue(), (H7.c<? super r>) cVar);
                }

                /* JADX WARN: Multi-variable type inference failed */
                public final Object emit(boolean z10, H7.c<? super r> cVar) {
                    String str = null;
                    Object[] objArr = 0;
                    if (!z10) {
                        j jVar2 = agentBusBindingBase.mutableServiceHealth;
                        long jCurrentTimeMillis = System.currentTimeMillis();
                        RetryHint retryHint = RetryHint.Auto;
                        HealthStatus.Unavailable unavailable = new HealthStatus.Unavailable("agentbus disconnected", jCurrentTimeMillis, retryHint);
                        i iVar = (i) jVar2;
                        iVar.getClass();
                        iVar.j(null, unavailable);
                        j jVar3 = agentBusBindingBase.mutableUpstreamHealth;
                        HealthStatus.Unavailable unavailable2 = new HealthStatus.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint);
                        i iVar2 = (i) jVar3;
                        iVar2.getClass();
                        iVar2.j(null, unavailable2);
                        j jVar4 = agentBusBindingBase.mutableBffHealth;
                        HealthStatus.Unavailable unavailable3 = new HealthStatus.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint);
                        i iVar3 = (i) jVar4;
                        iVar3.getClass();
                        iVar3.j(null, unavailable3);
                        j jVar5 = agentBusBindingBase.mutableBffLinkState;
                        BffLinkStatus bffLinkStatus = new BffLinkStatus(false, false, 3, null);
                        i iVar4 = (i) jVar5;
                        iVar4.getClass();
                        iVar4.j(null, bffLinkStatus);
                    } else if (!(((i) agentBusBindingBase.mutableServiceHealth).getValue() instanceof HealthStatus.Available)) {
                        j jVar6 = agentBusBindingBase.mutableServiceHealth;
                        HealthStatus.Available available = new HealthStatus.Available(str, 1, objArr == true ? 1 : 0);
                        i iVar5 = (i) jVar6;
                        iVar5.getClass();
                        iVar5.j(null, available);
                    }
                    return r.f317a;
                }
            };
            this.label = 1;
            ((i) jVar).collect(dVar, this);
            return coroutineSingletons;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10391) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$notifyChannelReadyIfPending$1", f = "AgentBusBindingBase.kt", l = {}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$notifyChannelReadyIfPending$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10401 extends SuspendLambda implements n {
        final /* synthetic */ ChannelReadyEvent $event;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public C10401(ChannelReadyEvent channelReadyEvent, H7.c<? super C10401> cVar) {
            super(2, cVar);
            this.$event = channelReadyEvent;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            C10401 c10401 = AgentBusBindingBase.this.new C10401(this.$event, cVar);
            c10401.L$0 = obj;
            return c10401;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objA;
            r rVar = r.f317a;
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            kotlin.b.b(obj);
            AgentBusBindingBase agentBusBindingBase = AgentBusBindingBase.this;
            ChannelReadyEvent channelReadyEvent = this.$event;
            try {
                k onChannelReady = agentBusBindingBase.getOnChannelReady();
                if (onChannelReady != null) {
                    onChannelReady.invoke(channelReadyEvent);
                    objA = rVar;
                } else {
                    objA = null;
                }
            } catch (Throwable th) {
                objA = kotlin.b.a(th);
            }
            Throwable thA = Result.a(objA);
            if (thA != null) {
                Log.e(AgentBusBindingBase.TAG, "onChannelReady failed", thA);
            }
            return rVar;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10401) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {304, 305}, m = "request", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$request$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10411 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10411(H7.c<? super C10411> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.request(null, null, 0L, this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {329, 365}, m = "runForever", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$runForever$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10421 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        long J$0;
        int label;
        /* synthetic */ Object result;

        public C10421(H7.c<? super C10421> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.runForever(this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {242}, m = "sendEvent", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10431 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        public C10431(H7.c<? super C10431> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.sendEvent(null, null, this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {251}, m = "sendNodeEvent", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$sendNodeEvent$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10441 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C10441(H7.c<? super C10441> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.sendNodeEvent(null, null, this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {234}, m = "sendReq", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10451 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        public C10451(H7.c<? super C10451> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.sendReq(null, null, this);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase$start$1", f = "AgentBusBindingBase.kt", l = {ComposerKt.reuseKey}, m = "invokeSuspend", v = 1)
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"Lm9/z;", "LC7/r;", "<anonymous>", "(Lm9/z;)V"}, k = 3, mv = {2, 2, 0})
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$start$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10461 extends SuspendLambda implements n {
        int label;

        public C10461(H7.c<? super C10461> cVar) {
            super(2, cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final H7.c<r> create(Object obj, H7.c<?> cVar) {
            return AgentBusBindingBase.this.new C10461(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineSingletons coroutineSingletons = CoroutineSingletons.f4909a;
            int i = this.label;
            if (i == 0) {
                kotlin.b.b(obj);
                AgentBusBindingBase agentBusBindingBase = AgentBusBindingBase.this;
                this.label = 1;
                if (agentBusBindingBase.runForever(this) == coroutineSingletons) {
                    return coroutineSingletons;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                kotlin.b.b(obj);
            }
            return r.f317a;
        }

        @Override // S7.n
        public final Object invoke(InterfaceC1733z interfaceC1733z, H7.c<? super r> cVar) {
            return ((C10461) create(interfaceC1733z, cVar)).invokeSuspend(r.f317a);
        }
    }

    @c(c = "com.stepos.agentbus.generated.AgentBusBindingBase", f = "AgentBusBindingBase.kt", l = {592, 722}, m = "writeFrame", v = 1)
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentbus.generated.AgentBusBindingBase$writeFrame$1, reason: invalid class name and case insensitive filesystem */
    public static final class C10471 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        public C10471(H7.c<? super C10471> cVar) {
            super(cVar);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AgentBusBindingBase.this.writeFrame(null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public AgentBusBindingBase(String socketName, S7.a clientIdProvider, String displayName, String version, String role, String reqIdPrefix, long j5, int i, int i6, n dispatchEvent, S7.a aVar, S7.a aVar2, long j6) {
        kotlin.jvm.internal.k.f(socketName, "socketName");
        kotlin.jvm.internal.k.f(clientIdProvider, "clientIdProvider");
        kotlin.jvm.internal.k.f(displayName, "displayName");
        kotlin.jvm.internal.k.f(version, "version");
        kotlin.jvm.internal.k.f(role, "role");
        kotlin.jvm.internal.k.f(reqIdPrefix, "reqIdPrefix");
        kotlin.jvm.internal.k.f(dispatchEvent, "dispatchEvent");
        this.socketName = socketName;
        this.clientIdProvider = clientIdProvider;
        this.displayName = displayName;
        this.version = version;
        this.role = role;
        this.reqIdPrefix = reqIdPrefix;
        this.reconnectDelayMs = j5;
        this.protocolMin = i;
        this.protocolMax = i6;
        this.dispatchEvent = dispatchEvent;
        this.clientExtra = aVar;
        this.connectParamsExtra = aVar2;
        this.idleTimeoutMs = j6;
        r0 r0VarC = AbstractC1683A.c();
        u9.d dVar = AbstractC1691I.f5315a;
        this.scope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
        this.seq = new AtomicLong(0L);
        this.writeMutex = new kotlinx.coroutines.sync.a();
        i iVarC = p9.e.c(Boolean.FALSE);
        this.connectedFlow = iVarC;
        i iVarC2 = p9.e.c(new ConnectionStatus(false, null, null, 0L, null, 0, 0, null, 255, null));
        this.mutableStatus = iVarC2;
        this.status = iVarC2;
        this.pendingInboxDepth = new AtomicInteger(0);
        this.reconnectAttemptsCounter = new AtomicLong(0L);
        this.reconnectSignal = Z6.k.b(-1, 6, null);
        this.lastActivityMs = System.currentTimeMillis();
        this.pendingResponses = new ConcurrentHashMap<>();
        long jCurrentTimeMillis = System.currentTimeMillis();
        RetryHint retryHint = RetryHint.Auto;
        i iVarC3 = p9.e.c(new HealthStatus.Unavailable("agentbus disconnected", jCurrentTimeMillis, retryHint));
        this.mutableServiceHealth = iVarC3;
        int i10 = 1;
        i iVarC4 = p9.e.c(new HealthStatus.Available(null, i10, 0 == true ? 1 : 0));
        this.mutableChatHealth = iVarC4;
        i iVarC5 = p9.e.c(new HealthStatus.Available(0 == true ? 1 : 0, i10, 0 == true ? 1 : 0));
        this.mutableToolsHealth = iVarC5;
        i iVarC6 = p9.e.c(new HealthStatus.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint));
        this.mutableUpstreamHealth = iVarC6;
        i iVarC7 = p9.e.c(new HealthStatus.Unavailable("agentbus disconnected", System.currentTimeMillis(), retryHint));
        this.mutableBffHealth = iVarC7;
        i iVarC8 = p9.e.c(new BffLinkStatus(false, false, 3, null));
        this.mutableBffLinkState = iVarC8;
        this.serviceHealth = iVarC3;
        this.chatHealth = iVarC4;
        this.toolsHealth = iVarC5;
        this.upstreamHealth = iVarC6;
        this.bffHealth = iVarC7;
        this.bffLinkState = iVarC8;
        launchHealthObserver();
        this.connected = iVarC;
    }

    private final void applyHealthSnapshot(JSONObject payload) {
        JSONObject jSONObjectOptJSONObject;
        if (payload == null || (jSONObjectOptJSONObject = payload.optJSONObject("resources")) == null) {
            return;
        }
        JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject(NotificationCompat.CATEGORY_SERVICE);
        if (jSONObjectOptJSONObject2 != null) {
            ((i) this.mutableServiceHealth).i(parseHealth(jSONObjectOptJSONObject2));
        }
        JSONObject jSONObjectOptJSONObject3 = jSONObjectOptJSONObject.optJSONObject("chat");
        if (jSONObjectOptJSONObject3 != null) {
            ((i) this.mutableChatHealth).i(parseHealth(jSONObjectOptJSONObject3));
        }
        JSONObject jSONObjectOptJSONObject4 = jSONObjectOptJSONObject.optJSONObject("tools");
        if (jSONObjectOptJSONObject4 != null) {
            ((i) this.mutableToolsHealth).i(parseHealth(jSONObjectOptJSONObject4));
        }
        JSONObject jSONObjectOptJSONObject5 = jSONObjectOptJSONObject.optJSONObject("upstream");
        if (jSONObjectOptJSONObject5 != null) {
            ((i) this.mutableUpstreamHealth).i(parseHealth(jSONObjectOptJSONObject5));
        }
        JSONObject jSONObjectOptJSONObject6 = jSONObjectOptJSONObject.optJSONObject("bff");
        if (jSONObjectOptJSONObject6 != null) {
            ((i) this.mutableBffHealth).i(parseHealth(jSONObjectOptJSONObject6));
            j jVar = this.mutableBffLinkState;
            BffLinkStatus bffLinkStatus = new BffLinkStatus(jSONObjectOptJSONObject6.optBoolean("wsConnected", false), jSONObjectOptJSONObject6.optBoolean("authed", false));
            i iVar = (i) jVar;
            iVar.getClass();
            iVar.j(null, bffLinkStatus);
        }
    }

    public static /* synthetic */ Object awaitConnected$default(AgentBusBindingBase agentBusBindingBase, long j5, H7.c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitConnected");
        }
        if ((i & 1) != 0) {
            j5 = 5000;
        }
        return agentBusBindingBase.awaitConnected(j5, cVar);
    }

    public static /* synthetic */ Object awaitResponse$default(AgentBusBindingBase agentBusBindingBase, String str, long j5, H7.c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: awaitResponse");
        }
        if ((i & 2) != 0) {
            j5 = 10000;
        }
        return agentBusBindingBase.awaitResponse(str, j5, cVar);
    }

    private final String clientId() {
        return (String) this.clientIdProvider.invoke();
    }

    /*  JADX ERROR: Type inference failed
        jadx.core.utils.exceptions.JadxOverflowException: Type inference error: updates count limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        	at jadx.core.dex.visitors.typeinference.TypeInferenceVisitor.visit(TypeInferenceVisitor.java:77)
        */
    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:109:0x0496 -> B:73:0x02f3). Please report as a decompilation issue!!! */
    public final java.lang.Object connectAndServe(H7.c<? super java.lang.Boolean> r29) {
        /*
            Method dump skipped, instructions count: 1416
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.connectAndServe(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus connectAndServe$lambda$0(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, true, Long.valueOf(System.currentTimeMillis()), null, 0L, null, 0, 0, null, 252, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus connectAndServe$lambda$1(int i, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, 0L, Integer.valueOf(i), 0, 0, null, 239, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus connectAndServe$lambda$2(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, 0L, null, 0, agentBusBindingBase.pendingInboxDepth.incrementAndGet(), null, 191, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus connectAndServe$lambda$3(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        int iDecrementAndGet = agentBusBindingBase.pendingInboxDepth.decrementAndGet();
        if (iDecrementAndGet < 0) {
            iDecrementAndGet = 0;
        }
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, 0L, null, 0, iDecrementAndGet, null, 191, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus connectAndServe$lambda$4(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, 0L, null, 0, 0, null, 191, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object dispatchIncoming(org.json.JSONObject r8, H7.c<? super C7.r> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof com.stepos.agentbus.generated.AgentBusBindingBase.C10381
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentbus.generated.AgentBusBindingBase$dispatchIncoming$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase.C10381) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$dispatchIncoming$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$dispatchIncoming$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            C7.r r4 = C7.r.f317a
            if (r2 == 0) goto L49
            if (r2 != r3) goto L41
            java.lang.Object r7 = r0.L$4
            com.stepos.agentbus.generated.AgentBusBindingBase r7 = (com.stepos.agentbus.generated.AgentBusBindingBase) r7
            java.lang.Object r7 = r0.L$3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$1
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$0
            org.json.JSONObject r7 = (org.json.JSONObject) r7
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L3e
            goto Lc0
        L3e:
            r7 = move-exception
            goto Lc2
        L41:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L49:
            kotlin.b.b(r9)
            java.lang.String r9 = "type"
            java.lang.String r9 = r8.optString(r9)
            java.lang.String r2 = "method"
            java.lang.String r2 = r8.optString(r2)
            java.lang.String r5 = "event"
            r8.optString(r5)
            java.lang.String r6 = "res"
            boolean r9 = kotlin.jvm.internal.k.b(r9, r6)
            if (r9 == 0) goto L7b
            java.lang.String r9 = "id"
            java.lang.String r9 = r8.optString(r9)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m9.p> r7 = r7.pendingResponses
            java.lang.Object r7 = r7.remove(r9)
            m9.p r7 = (m9.InterfaceC1723p) r7
            if (r7 == 0) goto Ld3
            m9.q r7 = (m9.C1724q) r7
            r7.U(r8)
            return r4
        L7b:
            java.lang.String r9 = "node.event"
            boolean r9 = kotlin.jvm.internal.k.b(r2, r9)
            r2 = 0
            if (r9 == 0) goto La8
            java.lang.String r9 = "params"
            org.json.JSONObject r9 = r8.optJSONObject(r9)
            if (r9 == 0) goto L91
            java.lang.String r5 = r9.optString(r5)
            goto L92
        L91:
            r5 = r2
        L92:
            java.lang.String r6 = "stepclaw.status.change"
            boolean r5 = kotlin.jvm.internal.k.b(r5, r6)
            if (r5 == 0) goto La8
            java.lang.String r5 = "payload"
            org.json.JSONObject r9 = r9.optJSONObject(r5)     // Catch: java.lang.Throwable -> La4
            r7.applyHealthSnapshot(r9)     // Catch: java.lang.Throwable -> La4
            goto La8
        La4:
            r9 = move-exception
            kotlin.b.a(r9)
        La8:
            S7.n r7 = r7.dispatchEvent     // Catch: java.lang.Throwable -> L3e
            r0.L$0 = r2     // Catch: java.lang.Throwable -> L3e
            r0.L$1 = r2     // Catch: java.lang.Throwable -> L3e
            r0.L$2 = r2     // Catch: java.lang.Throwable -> L3e
            r0.L$3 = r2     // Catch: java.lang.Throwable -> L3e
            r0.L$4 = r2     // Catch: java.lang.Throwable -> L3e
            r9 = 0
            r0.I$0 = r9     // Catch: java.lang.Throwable -> L3e
            r0.label = r3     // Catch: java.lang.Throwable -> L3e
            java.lang.Object r7 = r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L3e
            if (r7 != r1) goto Lc0
            return r1
        Lc0:
            r7 = r4
            goto Lc6
        Lc2:
            kotlin.Result$Failure r7 = kotlin.b.a(r7)
        Lc6:
            java.lang.Throwable r7 = kotlin.Result.a(r7)
            if (r7 == 0) goto Ld3
            java.lang.String r8 = "AgentBusBindingBase"
            java.lang.String r9 = "dispatchEvent failed"
            android.util.Log.e(r8, r9, r7)
        Ld3:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.dispatchIncoming(org.json.JSONObject, H7.c):java.lang.Object");
    }

    private final Map<String, Object> injectTraceMeta(Map<String, ? extends Object> params, String frameId) {
        return params.containsKey("_meta") ? params : kotlin.collections.a.U(params, new Pair("_meta", kotlin.collections.a.Q(new Pair("trace", kotlin.collections.a.R(new Pair(AgentBusWakeContract.EXTRA_TRACE_ID, B7.a.k("tr-", frameId)), new Pair("spanId", "sp-1"))))));
    }

    private final void launchHealthObserver() {
        AbstractC1683A.n(this.scope, null, new C10391(null), 3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void mutateStatus(k block) {
        j jVar = this.mutableStatus;
        ((i) jVar).i(block.invoke(((i) jVar).getValue()));
    }

    private final void notifyChannelReadyIfPending() {
        ChannelReadyContext channelReadyContext = this.pendingReady;
        if (channelReadyContext == null) {
            return;
        }
        this.pendingReady = null;
        AbstractC1683A.n(this.scope, null, new C10401(new ChannelReadyEvent(channelReadyContext.getTrigger()), null), 3);
    }

    private final HealthStatus parseHealth(JSONObject obj) {
        String strOptString = obj.optString("status");
        long jOptLong = obj.optLong("sinceMs", System.currentTimeMillis());
        String strOptString2 = obj.optString("reason");
        if (strOptString2.length() == 0) {
            strOptString2 = "";
        }
        String strOptString3 = obj.optString("retryHint", "auto");
        RetryHint retryHint = kotlin.jvm.internal.k.b(strOptString3, "user_action") ? RetryHint.UserAction : kotlin.jvm.internal.k.b(strOptString3, "permanent") ? RetryHint.Permanent : RetryHint.Auto;
        if (!kotlin.jvm.internal.k.b(strOptString, "available")) {
            return kotlin.jvm.internal.k.b(strOptString, "degraded") ? new HealthStatus.Degraded(strOptString2, jOptLong) : new HealthStatus.Unavailable(strOptString2, jOptLong, retryHint);
        }
        if (strOptString2.length() <= 0) {
            strOptString2 = null;
        }
        return new HealthStatus.Available(strOptString2);
    }

    public static /* synthetic */ Object request$default(AgentBusBindingBase agentBusBindingBase, String str, Map map, long j5, H7.c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: request");
        }
        if ((i & 2) != 0) {
            map = kotlin.collections.a.M();
        }
        Map map2 = map;
        if ((i & 4) != 0) {
            j5 = 10000;
        }
        return agentBusBindingBase.request(str, map2, j5, cVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x016c, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:23:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00e7  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:55:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:52:0x0167 -> B:53:0x0168). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object runForever(H7.c<? super C7.r> r17) {
        /*
            Method dump skipped, instructions count: 379
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.runForever(H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus runForever$lambda$0(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, Long.valueOf(System.currentTimeMillis()), 0L, null, 0, 0, null, ItemTouchHelper.Callback.DEFAULT_SWIPE_ANIMATION_DURATION, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus runForever$lambda$1(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, agentBusBindingBase.reconnectAttemptsCounter.get(), null, 0, 0, null, 247, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendEvent$default(AgentBusBindingBase agentBusBindingBase, String str, Map map, H7.c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            map = kotlin.collections.a.M();
        }
        return agentBusBindingBase.sendEvent(str, map, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendNodeEvent$default(AgentBusBindingBase agentBusBindingBase, String str, Map map, H7.c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendNodeEvent");
        }
        if ((i & 2) != 0) {
            map = kotlin.collections.a.M();
        }
        return agentBusBindingBase.sendNodeEvent(str, map, cVar);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ Object sendReq$default(AgentBusBindingBase agentBusBindingBase, String str, Map map, H7.c cVar, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendReq");
        }
        if ((i & 2) != 0) {
            map = kotlin.collections.a.M();
        }
        return agentBusBindingBase.sendReq(str, map, cVar);
    }

    private final void touchActivity() {
        this.lastActivityMs = System.currentTimeMillis();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0017  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object writeFrame(java.lang.String r13, H7.c<? super C7.r> r14) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 272
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.writeFrame(java.lang.String, H7.c):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus writeFrame$lambda$0$0(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, 0L, null, agentBusBindingBase.pendingOutboxDepth, 0, null, 223, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus writeFrame$lambda$0$1(AgentBusBindingBase agentBusBindingBase, ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, 0L, null, agentBusBindingBase.pendingOutboxDepth, 0, null, 223, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ConnectionStatus writeFrame$lambda$2(ConnectionStatus mutateStatus) {
        kotlin.jvm.internal.k.f(mutateStatus, "$this$mutateStatus");
        return ConnectionStatus.copy$default(mutateStatus, false, null, null, 0L, null, 0, 0, Long.valueOf(System.currentTimeMillis()), 127, null);
    }

    public final String allocateReqId() {
        String string = UUID.randomUUID().toString();
        kotlin.jvm.internal.k.e(string, "toString(...)");
        String strN0 = m.N0(16, string);
        String str = this.reqIdPrefix + strN0 + "-" + this.seq.incrementAndGet();
        this.pendingResponses.put(str, new C1724q());
        return str;
    }

    public final <T> List<T> arrToList(JSONArray arr, k parse) {
        kotlin.jvm.internal.k.f(arr, "arr");
        kotlin.jvm.internal.k.f(parse, "parse");
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            JSONObject jSONObjectOptJSONObject = arr.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                arrayList.add(parse.invoke(jSONObjectOptJSONObject));
            }
        }
        return arrayList;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitConnected(long r5, H7.c<? super java.lang.Boolean> r7) {
        /*
            r4 = this;
            boolean r0 = r7 instanceof com.stepos.agentbus.generated.AgentBusBindingBase.AnonymousClass1
            if (r0 == 0) goto L13
            r0 = r7
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$1
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L2f
            if (r2 != r3) goto L27
            kotlin.b.b(r7)
            goto L43
        L27:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L2f:
            kotlin.b.b(r7)
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2 r7 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitConnected$2
            r2 = 0
            r7.<init>(r2)
            r0.J$0 = r5
            r0.label = r3
            java.lang.Object r7 = kotlinx.coroutines.a.p(r5, r7, r0)
            if (r7 != r1) goto L43
            return r1
        L43:
            java.lang.Boolean r7 = (java.lang.Boolean) r7
            if (r7 == 0) goto L4c
            boolean r4 = r7.booleanValue()
            goto L4d
        L4c:
            r4 = 0
        L4d:
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.awaitConnected(long, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object awaitResponse(java.lang.String r6, long r7, H7.c<? super org.json.JSONObject> r9) {
        /*
            r5 = this;
            boolean r0 = r9 instanceof com.stepos.agentbus.generated.AgentBusBindingBase.C10351
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase.C10351) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r6 = r0.L$1
            m9.p r6 = (m9.InterfaceC1723p) r6
            java.lang.Object r6 = r0.L$0
            java.lang.String r6 = (java.lang.String) r6
            kotlin.b.b(r9)     // Catch: java.lang.Throwable -> L30
            goto L5c
        L30:
            r7 = move-exception
            goto L6e
        L32:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L3a:
            kotlin.b.b(r9)
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m9.p> r9 = r5.pendingResponses
            java.lang.Object r9 = r9.get(r6)
            m9.p r9 = (m9.InterfaceC1723p) r9
            if (r9 != 0) goto L48
            return r4
        L48:
            com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$2 r2 = new com.stepos.agentbus.generated.AgentBusBindingBase$awaitResponse$2     // Catch: java.lang.Throwable -> L30
            r2.<init>(r9, r4)     // Catch: java.lang.Throwable -> L30
            r0.L$0 = r6     // Catch: java.lang.Throwable -> L30
            r0.L$1 = r4     // Catch: java.lang.Throwable -> L30
            r0.J$0 = r7     // Catch: java.lang.Throwable -> L30
            r0.label = r3     // Catch: java.lang.Throwable -> L30
            java.lang.Object r9 = kotlinx.coroutines.a.p(r7, r2, r0)     // Catch: java.lang.Throwable -> L30
            if (r9 != r1) goto L5c
            return r1
        L5c:
            org.json.JSONObject r9 = (org.json.JSONObject) r9     // Catch: java.lang.Throwable -> L30
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m9.p> r5 = r5.pendingResponses
            java.lang.Object r5 = r5.remove(r6)
            m9.p r5 = (m9.InterfaceC1723p) r5
            if (r5 == 0) goto L6d
            kotlinx.coroutines.c r5 = (kotlinx.coroutines.c) r5
            r5.cancel(r4)
        L6d:
            return r9
        L6e:
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m9.p> r5 = r5.pendingResponses
            java.lang.Object r5 = r5.remove(r6)
            m9.p r5 = (m9.InterfaceC1723p) r5
            if (r5 == 0) goto L7d
            kotlinx.coroutines.c r5 = (kotlinx.coroutines.c) r5
            r5.cancel(r4)
        L7d:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.awaitResponse(java.lang.String, long, H7.c):java.lang.Object");
    }

    public final t getBffHealth() {
        return this.bffHealth;
    }

    public final t getBffLinkState() {
        return this.bffLinkState;
    }

    public final t getChatHealth() {
        return this.chatHealth;
    }

    public final t getConnected() {
        return this.connected;
    }

    public final k getOnChannelReady() {
        return this.onChannelReady;
    }

    public final t getServiceHealth() {
        return this.serviceHealth;
    }

    public final t getStatus() {
        return this.status;
    }

    public final t getToolsHealth() {
        return this.toolsHealth;
    }

    public final t getUpstreamHealth() {
        return this.upstreamHealth;
    }

    public final boolean isConnected() {
        return ((Boolean) ((i) this.connectedFlow).getValue()).booleanValue();
    }

    public final boolean isScopeActive() {
        return AbstractC1683A.l(this.scope);
    }

    public final String jsonEscape(String s5) {
        kotlin.jvm.internal.k.f(s5, "s");
        String string = new JSONObject().put("v", s5).toString();
        kotlin.jvm.internal.k.c(string);
        String strSubstring = string.substring(m.p0(string, ':', 0, 6) + 1, m.v0(string, '}', 0, 6));
        kotlin.jvm.internal.k.e(strSubstring, "substring(...)");
        return strSubstring;
    }

    public final Map<String, Object> jsonObjectToMap(JSONObject obj) {
        kotlin.jvm.internal.k.f(obj, "obj");
        HashMap map = new HashMap(obj.length());
        Iterator<String> itKeys = obj.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            map.put(next, jsonValueToKotlin(obj.opt(next)));
        }
        return map;
    }

    public final Object jsonValueToKotlin(Object v10) {
        if (v10 == null || v10.equals(JSONObject.NULL)) {
            return null;
        }
        if (v10 instanceof JSONObject) {
            return jsonObjectToMap((JSONObject) v10);
        }
        if (!(v10 instanceof JSONArray)) {
            return v10;
        }
        JSONArray jSONArray = (JSONArray) v10;
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int length = jSONArray.length();
        for (int i = 0; i < length; i++) {
            arrayList.add(jsonValueToKotlin(jSONArray.opt(i)));
        }
        return arrayList;
    }

    public final c0 launchOnScope(n block) {
        kotlin.jvm.internal.k.f(block, "block");
        return AbstractC1683A.n(this.scope, null, block, 3);
    }

    public final void reconnect() {
        this.reconnectSignal.a(r.f317a);
        try {
            DataOutputStream dataOutputStream = this.outputStream;
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
        } catch (Throwable th) {
            kotlin.b.a(th);
        }
        this.outputStream = null;
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x007a  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00c7  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object request(java.lang.String r7, java.util.Map<java.lang.String, ? extends java.lang.Object> r8, long r9, H7.c<? super com.stepos.agentbus.generated.InvokeResult> r11) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.request(java.lang.String, java.util.Map, long, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendEvent(java.lang.String r8, java.util.Map<java.lang.String, ? extends java.lang.Object> r9, H7.c<? super java.lang.String> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.agentbus.generated.AgentBusBindingBase.C10431
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase.C10431) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$sendEvent$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L43
            if (r2 != r3) goto L3b
            java.lang.Object r7 = r0.L$4
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$3
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r7 = r0.L$2
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$1
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.b.b(r10)
            return r7
        L3b:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L43:
            kotlin.b.b(r10)
            java.util.concurrent.atomic.AtomicLong r10 = r7.seq
            long r4 = r10.incrementAndGet()
            java.lang.String r10 = "evt-"
            java.lang.String r10 = androidx.compose.foundation.b.p(r4, r10)
            java.util.Map r9 = r7.injectTraceMeta(r9, r10)
            java.lang.String r2 = r7.jsonEscape(r10)
            java.lang.String r8 = r7.jsonEscape(r8)
            java.lang.String r9 = r7.toJsonString(r9)
            java.lang.String r4 = ",\"event\":"
            java.lang.String r5 = ",\"payload\":"
            java.lang.String r6 = "{\"type\":\"event\",\"id\":"
            java.lang.StringBuilder r8 = B7.a.w(r6, r2, r4, r8, r5)
            java.lang.String r2 = "}"
            java.lang.String r8 = B7.a.q(r8, r9, r2)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.L$2 = r10
            r0.L$3 = r9
            r0.L$4 = r9
            r0.label = r3
            java.lang.Object r7 = r7.writeFrame(r8, r0)
            if (r7 != r1) goto L86
            return r1
        L86:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.sendEvent(java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendNodeEvent(java.lang.String r7, java.util.Map<java.lang.String, ? extends java.lang.Object> r8, H7.c<? super java.lang.String> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.stepos.agentbus.generated.AgentBusBindingBase.C10441
            if (r0 == 0) goto L13
            r0 = r9
            com.stepos.agentbus.generated.AgentBusBindingBase$sendNodeEvent$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase.C10441) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$sendNodeEvent$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$sendNodeEvent$1
            r0.<init>(r9)
        L18:
            java.lang.Object r9 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r6 = r0.L$5
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$4
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r0.L$3
            java.util.Map r6 = (java.util.Map) r6
            java.lang.Object r6 = r0.L$2
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r7 = r0.L$1
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r7 = r0.L$0
            java.lang.String r7 = (java.lang.String) r7
            kotlin.b.b(r9)
            return r6
        L3f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L47:
            kotlin.b.b(r9)
            java.util.concurrent.atomic.AtomicLong r9 = r6.seq
            long r4 = r9.incrementAndGet()
            java.lang.String r9 = "evt-"
            java.lang.String r9 = androidx.compose.foundation.b.p(r4, r9)
            java.util.Map r8 = r6.injectTraceMeta(r8, r9)
            kotlin.Pair r2 = new kotlin.Pair
            java.lang.String r4 = "event"
            r2.<init>(r4, r7)
            kotlin.Pair r7 = new kotlin.Pair
            java.lang.String r4 = "payload"
            r7.<init>(r4, r8)
            kotlin.Pair[] r7 = new kotlin.Pair[]{r2, r7}
            java.util.Map r7 = kotlin.collections.a.R(r7)
            java.lang.String r8 = r6.jsonEscape(r9)
            java.lang.String r7 = r6.toJsonString(r7)
            java.lang.String r2 = ",\"method\":\"node.event\",\"params\":"
            java.lang.String r4 = "}"
            java.lang.String r5 = "{\"type\":\"req\",\"id\":"
            java.lang.String r7 = androidx.appfunctions.metadata.a.m(r5, r8, r2, r7, r4)
            r8 = 0
            r0.L$0 = r8
            r0.L$1 = r8
            r0.L$2 = r9
            r0.L$3 = r8
            r0.L$4 = r8
            r0.L$5 = r8
            r0.label = r3
            java.lang.Object r6 = r6.writeFrame(r7, r0)
            if (r6 != r1) goto L98
            return r1
        L98:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.sendNodeEvent(java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object sendReq(java.lang.String r8, java.util.Map<java.lang.String, ? extends java.lang.Object> r9, H7.c<? super java.lang.String> r10) {
        /*
            r7 = this;
            boolean r0 = r10 instanceof com.stepos.agentbus.generated.AgentBusBindingBase.C10451
            if (r0 == 0) goto L13
            r0 = r10
            com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1 r0 = (com.stepos.agentbus.generated.AgentBusBindingBase.C10451) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.label = r1
            goto L18
        L13:
            com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1 r0 = new com.stepos.agentbus.generated.AgentBusBindingBase$sendReq$1
            r0.<init>(r10)
        L18:
            java.lang.Object r10 = r0.result
            kotlin.coroutines.intrinsics.CoroutineSingletons r1 = kotlin.coroutines.intrinsics.CoroutineSingletons.f4909a
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L47
            if (r2 != r3) goto L3f
            java.lang.Object r7 = r0.L$5
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r7 = r0.L$4
            java.util.Map r7 = (java.util.Map) r7
            java.lang.Object r7 = r0.L$3
            java.lang.String r7 = (java.lang.String) r7
            java.lang.Object r8 = r0.L$2
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r8 = r0.L$1
            java.util.Map r8 = (java.util.Map) r8
            java.lang.Object r8 = r0.L$0
            java.lang.String r8 = (java.lang.String) r8
            kotlin.b.b(r10)
            return r7
        L3f:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L47:
            kotlin.b.b(r10)
            java.util.UUID r10 = java.util.UUID.randomUUID()
            java.lang.String r10 = r10.toString()
            java.lang.String r2 = "toString(...)"
            kotlin.jvm.internal.k.e(r10, r2)
            r2 = 16
            java.lang.String r10 = j9.m.N0(r2, r10)
            java.lang.String r2 = r7.reqIdPrefix
            java.util.concurrent.atomic.AtomicLong r4 = r7.seq
            long r4 = r4.incrementAndGet()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            r6.append(r10)
            java.lang.String r10 = "-"
            r6.append(r10)
            r6.append(r4)
            java.lang.String r10 = r6.toString()
            java.util.concurrent.ConcurrentHashMap<java.lang.String, m9.p> r2 = r7.pendingResponses
            m9.q r4 = new m9.q
            r4.<init>()
            r2.put(r10, r4)
            java.util.Map r9 = r7.injectTraceMeta(r9, r10)
            java.lang.String r2 = r7.jsonEscape(r10)
            java.lang.String r8 = r7.jsonEscape(r8)
            java.lang.String r9 = r7.toJsonString(r9)
            java.lang.String r4 = ",\"method\":"
            java.lang.String r5 = ",\"params\":"
            java.lang.String r6 = "{\"type\":\"req\",\"id\":"
            java.lang.StringBuilder r8 = B7.a.w(r6, r2, r4, r8, r5)
            java.lang.String r2 = "}"
            java.lang.String r8 = B7.a.q(r8, r9, r2)
            r9 = 0
            r0.L$0 = r9
            r0.L$1 = r9
            r0.L$2 = r9
            r0.L$3 = r10
            r0.L$4 = r9
            r0.L$5 = r9
            r0.label = r3
            java.lang.Object r7 = r7.writeFrame(r8, r0)
            if (r7 != r1) goto Lbc
            return r1
        Lbc:
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentbus.generated.AgentBusBindingBase.sendReq(java.lang.String, java.util.Map, H7.c):java.lang.Object");
    }

    public final void setOnChannelReady(k kVar) {
        this.onChannelReady = kVar;
    }

    public final void start() {
        c0 c0Var = this.serveJob;
        if (c0Var == null || !c0Var.isActive()) {
            c0 c0Var2 = this.serveJob;
            if (c0Var2 != null && c0Var2.r()) {
                this.serveJob = null;
            }
            c0 c0Var3 = (c0) this.scope.getCoroutineContext().get(b0.f5325a);
            if (c0Var3 == null || !c0Var3.isActive()) {
                r0 r0VarC = AbstractC1683A.c();
                u9.d dVar = AbstractC1691I.f5315a;
                this.scope = AbstractC1683A.b(l.H(r0VarC, u9.c.f6743a));
                launchHealthObserver();
            }
            this.serveJob = AbstractC1683A.n(this.scope, null, new C10461(null), 3);
        }
    }

    public final void stop() {
        c0 c0Var = this.serveJob;
        if (c0Var != null) {
            c0Var.cancel(null);
        }
        this.serveJob = null;
        AbstractC1683A.e(this.scope, null);
    }

    public final String toJsonString(Map<String, ? extends Object> map) {
        kotlin.jvm.internal.k.f(map, "map");
        return toJsonValue(map).toString();
    }

    public final Object toJsonValue(Object v10) throws JSONException {
        if (v10 == null) {
            Object NULL = JSONObject.NULL;
            kotlin.jvm.internal.k.e(NULL, "NULL");
            return NULL;
        }
        if (v10 instanceof Map) {
            JSONObject jSONObject = new JSONObject();
            for (Map.Entry entry : ((Map) v10).entrySet()) {
                jSONObject.put(String.valueOf(entry.getKey()), toJsonValue(entry.getValue()));
            }
            return jSONObject;
        }
        if (v10 instanceof List) {
            JSONArray jSONArray = new JSONArray();
            Iterator it = ((List) v10).iterator();
            while (it.hasNext()) {
                jSONArray.put(toJsonValue(it.next()));
            }
            return jSONArray;
        }
        if (!(v10 instanceof Object[])) {
            if (!(v10 instanceof Set)) {
                return v10;
            }
            JSONArray jSONArray2 = new JSONArray();
            Iterator it2 = ((Set) v10).iterator();
            while (it2.hasNext()) {
                jSONArray2.put(toJsonValue(it2.next()));
            }
            return jSONArray2;
        }
        JSONArray jSONArray3 = new JSONArray();
        for (Object obj : (Object[]) v10) {
            jSONArray3.put(toJsonValue(obj));
        }
        return jSONArray3;
    }

    public final void wakeAndReconnect(ChannelReadyContext context) {
        kotlin.jvm.internal.k.f(context, "context");
        this.pendingReady = context;
        c0 c0Var = this.serveJob;
        if (c0Var == null || (c0Var != null && c0Var.r())) {
            this.serveJob = null;
            start();
        } else if (((Boolean) ((i) this.connectedFlow).getValue()).booleanValue()) {
            notifyChannelReadyIfPending();
        } else {
            reconnect();
        }
    }

    public final Object writeRawFrame(String str, H7.c<? super r> cVar) throws Throwable {
        Object objWriteFrame = writeFrame(str, cVar);
        return objWriteFrame == CoroutineSingletons.f4909a ? objWriteFrame : r.f317a;
    }

    public final List<String> arrToList(JSONArray arr) {
        kotlin.jvm.internal.k.f(arr, "arr");
        ArrayList arrayList = new ArrayList(arr.length());
        int length = arr.length();
        for (int i = 0; i < length; i++) {
            String strOptString = arr.optString(i);
            kotlin.jvm.internal.k.c(strOptString);
            if (strOptString.length() > 0) {
                arrayList.add(strOptString);
            }
        }
        return arrayList;
    }

    public /* synthetic */ AgentBusBindingBase(String str, S7.a aVar, String str2, String str3, String str4, String str5, long j5, int i, int i6, n nVar, S7.a aVar2, S7.a aVar3, long j6, int i10, e eVar) {
        this(str, aVar, str2, str3, str4, (i10 & 32) != 0 ? "as-" : str5, (i10 & 64) != 0 ? 1000L : j5, (i10 & 128) != 0 ? 3 : i, (i10 & 256) != 0 ? 3 : i6, nVar, (i10 & 1024) != 0 ? null : aVar2, (i10 & 2048) != 0 ? null : aVar3, (i10 & 4096) != 0 ? 0L : j6);
    }
}
