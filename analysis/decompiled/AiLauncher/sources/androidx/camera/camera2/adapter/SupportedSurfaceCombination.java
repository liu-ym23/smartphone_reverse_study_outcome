package androidx.camera.camera2.adapter;

import D.B;
import D.C0761b0;
import H.FpsRangeFeature;
import K.B0;
import K.C0;
import K.C0899w;
import K.SurfaceStreamSpecQueryResult;
import K.V;
import K.W;
import T.c;
import Y8.h;
import Y8.j;
import Z8.C;
import Z8.C1168p;
import Z8.C1173v;
import Z8.C1177z;
import Z8.F;
import Z8.r;
import android.content.Context;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.MediaRecorder;
import android.util.Log;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import androidx.camera.camera2.adapter.SupportedSurfaceCombination;
import androidx.camera.camera2.pipe.g;
import androidx.camera.core.featuregroup.impl.a;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.StreamUseCase;
import androidx.camera.core.impl.SurfaceConfig;
import androidx.camera.core.impl.b;
import androidx.camera.core.impl.stabilization.VideoStabilization;
import androidx.camera.core.impl.y;
import androidx.camera.core.impl.z;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import o.C4965E;
import p.q;
import p9.InterfaceC5063a;
import r.C5179A;
import r.C5182D;
import r.C5191i;
import r.y;
import t.C5473b;
import t.Q;
import u.C5556d;
import u.C5561i;
import u.C5564l;

@Metadata(d1 = {"\u0000®\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u001e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0010#\n\u0000\n\u0002\u0010!\n\u0002\b&\n\u0002\u0010\u0011\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u0093\u00012\u00020\u0001:\b×\u0001Ó\u0001\u008d\u0002Õ\u0001B'\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\b¢\u0006\u0004\b\n\u0010\u000bJ]\u0010\u0019\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0014\b\u0002\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u00112\u0012\b\u0002\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\u000e\b\u0002\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e¢\u0006\u0004\b\u0019\u0010\u001aJ-\u0010!\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010 \u001a\u00020\u001f¢\u0006\u0004\b!\u0010\"Je\u0010,\u001a\u00020+2\u0006\u0010\u001b\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u001c\u0010%\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00112\b\b\u0002\u0010'\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\u0018¢\u0006\u0004\b,\u0010-JU\u0010/\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00112\u001c\u0010%\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00112\u0006\u0010\r\u001a\u00020\f2\b\b\u0002\u0010.\u001a\u00020\u0018H\u0001¢\u0006\u0004\b/\u00100J+\u00102\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\f\u00101\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0006\u0010\u001c\u001a\u00020\u0016H\u0007¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u0002052\u0006\u00104\u001a\u00020\u0016H\u0007¢\u0006\u0004\b6\u00107J7\u0010=\u001a\u0004\u0018\u00010\u001d2\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010:\u001a\u00020\u00182\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;H\u0000¢\u0006\u0004\b=\u0010>JY\u0010A\u001a\u00020@2\u0006\u0010\r\u001a\u00020\f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u00120\u00112\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0002¢\u0006\u0004\bA\u0010BJ]\u0010F\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0006\u0010\r\u001a\u00020\f2\u0010\u0010\u0010\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u000f\u0018\u00010\u000e2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020#0C2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140CH\u0002¢\u0006\u0004\bF\u0010GJ\u001d\u0010I\u001a\b\u0012\u0004\u0012\u00020H0\u000e2\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0004\bI\u0010JJ\u008b\u0001\u0010O\u001a\u00020+2\u0006\u0010L\u001a\u00020K2\u0006\u0010\r\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u001c\u0010M\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00112\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0016\u0010N\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010*\u001a\u00020\u0018H\u0002¢\u0006\u0004\bO\u0010PJ\u0083\u0001\u0010Q\u001a\u00020+2\u0006\u0010\r\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u001c\u0010M\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00112\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0016\u0010N\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010*\u001a\u00020\u0018H\u0002¢\u0006\u0004\bQ\u0010RJE\u0010X\u001a\u00020K2\f\u0010T\u001a\b\u0012\u0004\u0012\u00020\u00120S2\u000e\u0010V\u001a\n\u0012\u0004\u0012\u00020\u0016\u0018\u00010U2\u0006\u0010'\u001a\u00020&2\u0006\u0010W\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u0018H\u0002¢\u0006\u0004\bX\u0010YJu\u0010^\u001a\u00020\f2\u0006\u0010\u001b\u001a\u00020\u00162\u0006\u0010(\u001a\u00020\u00182\u0016\u0010N\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010'\u001a\u00020&2\u0006\u0010W\u001a\u00020\u00182\u0006\u0010Z\u001a\u00020\u00182\u0006\u0010)\u001a\u00020\u00182\u0006\u0010[\u001a\u00020\u00182\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00160U2\u0006\u0010]\u001a\u00020\u0018H\u0002¢\u0006\u0004\b^\u0010_J\u0013\u0010`\u001a\u00020\f*\u00020\fH\u0002¢\u0006\u0004\b`\u0010aJC\u0010b\u001a\u00020\u00182\u0006\u0010\r\u001a\u00020\f2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u001c\u0010%\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u0011H\u0002¢\u0006\u0004\bb\u0010cJ\u008d\u0001\u0010e\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0012\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010\r\u001a\u00020\f2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020#0C2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140CH\u0002¢\u0006\u0004\be\u0010fJ\u008d\u0001\u0010n\u001a\u00020m2\u0006\u0010h\u001a\u00020g2\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0012\u0010k\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020j0C2\u0016\u0010l\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020j0C2\u0012\u0010D\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020#0C2\u0016\u0010E\u001a\u0012\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140CH\u0002¢\u0006\u0004\bn\u0010oJY\u0010p\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u000e2\u001c\u0010%\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u00112\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0002¢\u0006\u0004\bp\u0010qJK\u0010r\u001a\b\u0012\u0004\u0012\u00020\u00160U2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010]\u001a\u00020\u0018H\u0002¢\u0006\u0004\br\u0010sJ/\u0010t\u001a\u00020\u00182\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000eH\u0002¢\u0006\u0004\bt\u0010uJ%\u0010v\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0006\u0010Z\u001a\u00020\u0018H\u0002¢\u0006\u0004\bv\u0010wJg\u0010~\u001a\u00020m2\u0006\u0010\r\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010x\u001a\u00020\u00162\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\u00182\u0018\u0010{\u001a\u0014\u0012\u0004\u0012\u00020y\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160z0C2\f\u0010}\u001a\b\u0012\u0004\u0012\u00020\u001d0|H\u0002¢\u0006\u0004\b~\u0010\u007fJ\u0098\u0001\u0010\u0082\u0001\u001a\u0004\u0018\u00010g2\u0012\u0010d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u000e2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\u0007\u0010\u0080\u0001\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0006\u0010\r\u001a\u00020\f2\u000e\u0010i\u001a\n\u0012\u0004\u0012\u00020\u000f\u0018\u00010\u000e2\u0016\u0010N\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00120\u00112\u0007\u0010\u0081\u0001\u001a\u00020\u0018H\u0002¢\u0006\u0006\b\u0082\u0001\u0010\u0083\u0001J2\u0010\u0085\u0001\u001a\u00020\u00182\u0007\u0010\u0080\u0001\u001a\u00020\u00162\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020\u00160U2\u0007\u0010\u0084\u0001\u001a\u00020\u0016H\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001Jj\u0010\u0087\u0001\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020j0C2\u0006\u0010h\u001a\u00020g2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0016\u0010N\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\r\u001a\u00020\fH\u0002¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J*\u0010\u0089\u0001\u001a\u00020\u00162\u0016\u0010N\u001a\u0012\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0096\u0001\u0010\u008d\u0001\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u001b\u001a\u00020\u00162\f\u0010$\u001a\b\u0012\u0004\u0012\u00020#0\u000e2\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0014\u0010D\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020#\u0018\u00010C2\u0018\u0010E\u001a\u0014\u0012\u0004\u0012\u00020\u0016\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0014\u0018\u00010C2\u0007\u0010\u008c\u0001\u001a\u00020\u0018H\u0002¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001JR\u0010\u008f\u0001\u001a\u00020\u00162\r\u0010\u008b\u0001\u001a\b\u0012\u0004\u0012\u00020\u001d0\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000e2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0007\u0010\u0084\u0001\u001a\u00020\u00162\u0006\u0010Z\u001a\u00020\u0018H\u0002¢\u0006\u0006\b\u008f\u0001\u0010\u0090\u0001J2\u0010\u0091\u0001\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010Z\u001a\u00020\u00182\u0006\u0010x\u001a\u00020\u0016H\u0002¢\u0006\u0006\b\u0091\u0001\u0010\u0092\u0001J\"\u0010\u0093\u0001\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001dH\u0002¢\u0006\u0006\b\u0093\u0001\u0010\u0094\u0001J!\u0010\u0096\u0001\u001a\u00020\u00162\r\u0010\u0095\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160UH\u0002¢\u0006\u0006\b\u0096\u0001\u0010\u0097\u0001J0\u0010\u009a\u0001\u001a\u00020\u00162\r\u0010\u0098\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\r\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160UH\u0002¢\u0006\u0006\b\u009a\u0001\u0010\u009b\u0001JE\u0010\u009f\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\r\u0010\u009c\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\r\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\r\u0010\u009e\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160UH\u0002¢\u0006\u0006\b\u009f\u0001\u0010 \u0001JJ\u0010¥\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\r\u0010¡\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\u0007\u0010¢\u0001\u001a\u00020\u00162\u0018\u0010¤\u0001\u001a\u0013\u0012\f\b\u0001\u0012\b\u0012\u0004\u0012\u00020\u00160U\u0018\u00010£\u0001H\u0002¢\u0006\u0006\b¥\u0001\u0010¦\u0001J>\u0010©\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\r\u0010§\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\r\u0010¨\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160U2\u0006\u0010]\u001a\u00020\u0018H\u0002¢\u0006\u0006\b©\u0001\u0010ª\u0001J&\u0010\u00ad\u0001\u001a\u00020\u00182\u0007\u0010«\u0001\u001a\u00020\u00182\t\u0010¬\u0001\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0006\b\u00ad\u0001\u0010®\u0001J;\u0010°\u0001\u001a\u00020\u00162\u0007\u0010¯\u0001\u001a\u00020\u00162\u0006\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001d2\u0006\u0010Z\u001a\u00020\u00182\u0006\u0010x\u001a\u00020\u0016H\u0002¢\u0006\u0006\b°\u0001\u0010±\u0001J\u0012\u0010²\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b²\u0001\u0010³\u0001J\u0012\u0010´\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b´\u0001\u0010³\u0001J\u0012\u0010µ\u0001\u001a\u00020mH\u0002¢\u0006\u0006\bµ\u0001\u0010³\u0001J\u0012\u0010¶\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b¶\u0001\u0010³\u0001J\u0012\u0010·\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b·\u0001\u0010³\u0001J\u0012\u0010¸\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b¸\u0001\u0010³\u0001J\u0012\u0010¹\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b¹\u0001\u0010³\u0001J\u0012\u0010º\u0001\u001a\u00020mH\u0002¢\u0006\u0006\bº\u0001\u0010³\u0001J\u0012\u0010»\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b»\u0001\u0010³\u0001J\u0012\u0010¼\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b¼\u0001\u0010³\u0001J\u0012\u0010½\u0001\u001a\u00020mH\u0002¢\u0006\u0006\b½\u0001\u0010³\u0001J8\u0010À\u0001\u001a\u00020m2\u0013\u0010¾\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0C2\u0007\u0010¿\u0001\u001a\u00020\u001d2\u0006\u00104\u001a\u00020\u0016H\u0002¢\u0006\u0006\bÀ\u0001\u0010Á\u0001J;\u0010Â\u0001\u001a\u00020m2\u0013\u0010¾\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0C2\u0006\u00104\u001a\u00020\u00162\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0006\bÂ\u0001\u0010Ã\u0001J/\u0010Ä\u0001\u001a\u00020m2\u0013\u0010¾\u0001\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001d0C2\u0006\u00104\u001a\u00020\u0016H\u0002¢\u0006\u0006\bÄ\u0001\u0010Å\u0001J\u0012\u0010Æ\u0001\u001a\u00020\u001dH\u0002¢\u0006\u0006\bÆ\u0001\u0010Ç\u0001J\u0013\u0010É\u0001\u001a\u00030È\u0001H\u0002¢\u0006\u0006\bÉ\u0001\u0010Ê\u0001J\u0014\u0010Ë\u0001\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0006\bË\u0001\u0010Ç\u0001J\u0014\u0010Ì\u0001\u001a\u0004\u0018\u00010\u001dH\u0002¢\u0006\u0006\bÌ\u0001\u0010Ç\u0001J*\u0010Í\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160\u000e2\u0010\u0010\u0015\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00140\u000eH\u0002¢\u0006\u0006\bÍ\u0001\u0010Î\u0001J9\u0010Ï\u0001\u001a\u000b\u0012\u0004\u0012\u00020\u001d\u0018\u00010£\u00012\b\u00109\u001a\u0004\u0018\u0001082\u0006\u0010\u001c\u001a\u00020\u00162\n\b\u0002\u0010<\u001a\u0004\u0018\u00010;H\u0002¢\u0006\u0006\bÏ\u0001\u0010Ð\u0001J3\u0010Ò\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0|0\u000e2\u0013\u0010Ñ\u0001\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001d0\u000e0\u000eH\u0002¢\u0006\u0006\bÒ\u0001\u0010Î\u0001R\u0016\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u0016\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u0016\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u0017\u0010Û\u0001\u001a\u00030Ù\u00018\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b2\u0010Ú\u0001R\u0016\u0010Ü\u0001\u001a\u00020\u00168\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b´\u0001\u0010vR\u001c\u0010Þ\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0019\u0010Ý\u0001R\u001d\u0010à\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bß\u0001\u0010Ý\u0001R\u001d\u0010á\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010Ý\u0001R\u001c\u0010â\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bA\u0010Ý\u0001R\u001c\u0010ã\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b^\u0010Ý\u0001R\u001c\u0010ä\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b/\u0010Ý\u0001R)\u0010æ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020H0\u000e0C8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0082\u0001\u0010å\u0001R\u001d\u0010è\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bç\u0001\u0010Ý\u0001R\u001d\u0010ê\u0001\u001a\b\u0012\u0004\u0012\u00020H0|8\u0002X\u0082\u0004¢\u0006\b\n\u0006\bé\u0001\u0010Ý\u0001R\u0018\u0010ë\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bº\u0001\u0010rR\u0018\u0010ì\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b·\u0001\u0010rR\u0016\u0010í\u0001\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¹\u0001\u0010rR\u0016\u0010î\u0001\u001a\u00020\u00188\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b¸\u0001\u0010rR\u0018\u0010ï\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¼\u0001\u0010rR\u0018\u0010ð\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0087\u0001\u0010rR\u0018\u0010ñ\u0001\u001a\u00020\u00188\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bµ\u0001\u0010rR)\u0010÷\u0001\u001a\u0002058\u0000@\u0000X\u0080.¢\u0006\u0018\n\u0006\b½\u0001\u0010ò\u0001\u001a\u0006\bó\u0001\u0010ô\u0001\"\u0006\bõ\u0001\u0010ö\u0001R\u001d\u0010ø\u0001\u001a\b\u0012\u0004\u0012\u00020\u00160|8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b»\u0001\u0010Ý\u0001R\u0018\u0010ú\u0001\u001a\u00030È\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010ù\u0001R\u0018\u0010ý\u0001\u001a\u00030û\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÒ\u0001\u0010ü\u0001R\u0018\u0010\u0080\u0002\u001a\u00030þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u00ad\u0001\u0010ÿ\u0001R\u0017\u0010\u0083\u0002\u001a\u00030\u0081\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\bX\u0010\u0082\u0002R\u0018\u0010\u0086\u0002\u001a\u00030\u0084\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¥\u0001\u0010\u0085\u0002R\u0018\u0010\u0089\u0002\u001a\u00030\u0087\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010\u0088\u0002R\u0018\u0010\u008c\u0002\u001a\u00030\u008a\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u008f\u0001\u0010\u008b\u0002¨\u0006\u008f\u0002²\u0006\r\u0010\u008e\u0002\u001a\u00020\u00188\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/camera/camera2/adapter/SupportedSurfaceCombination;", "", "Landroid/content/Context;", "context", "Landroidx/camera/camera2/pipe/g;", "cameraMetadata", "LK/V;", "encoderProfilesProvider", "Landroidx/camera/core/featuregroup/impl/a;", "featureCombinationQuery", "<init>", "(Landroid/content/Context;Landroidx/camera/camera2/pipe/g;LK/V;Landroidx/camera/core/featuregroup/impl/a;)V", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;", "featureSettings", "", "Landroidx/camera/core/impl/SurfaceConfig;", "surfaceConfigList", "", "LD/B;", "dynamicRangesBySurfaceConfig", "Landroidx/camera/core/impl/z;", "newUseCaseConfigs", "", "useCasesPriorityOrder", "", "f", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Z", "cameraMode", "imageFormat", "Landroid/util/Size;", ContentDisposition.Parameters.Size, "Landroidx/camera/core/impl/StreamUseCase;", "streamUseCase", "m0", "(IILandroid/util/Size;Landroidx/camera/core/impl/StreamUseCase;)Landroidx/camera/core/impl/SurfaceConfig;", "Landroidx/camera/core/impl/b;", "attachedSurfaces", "newUseCaseConfigsSupportedSizeMap", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "videoStabilization", "hasVideoCapture", "isFeatureComboInvocation", "findMaxSupportedFrameRate", "LK/D0;", "U", "(ILjava/util/List;Ljava/util/Map;Landroidx/camera/core/impl/stabilization/VideoStabilization;ZZZ)LK/D0;", "forceUniqueMaxFpsFiltering", "k", "(Ljava/util/Map;Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Z)Ljava/util/Map;", "sizeList", Const.INTENT_KEY_UMID, "(Ljava/util/List;I)Ljava/util/List;", "format", "LK/C0;", "a0", "(I)LK/C0;", "Landroid/hardware/camera2/params/StreamConfigurationMap;", C3081a.FOCUS_MAP_NAME, "highResolutionIncluded", "Landroid/util/Rational;", "aspectRatio", "G", "(Landroid/hardware/camera2/params/StreamConfigurationMap;IZLandroid/util/Rational;)Landroid/util/Size;", "useCasePriorityOrder", "Landroidx/camera/core/impl/SessionConfig;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Landroidx/camera/core/impl/SessionConfig;", "", "surfaceConfigIndexAttachedSurfaceInfoMap", "surfaceConfigIndexUseCaseConfigMap", "J", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "LK/B0;", ExifInterface.LONGITUDE_WEST, "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;)Ljava/util/List;", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$CheckingMethod;", "checkingMethod", "filteredNewUseCaseConfigsSupportedSizeMap", "resolvedDynamicRanges", "j0", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$CheckingMethod;Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Z)LK/D0;", "k0", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/List;Ljava/util/Map;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Z)LK/D0;", "", "dynamicRanges", "Landroid/util/Range;", "fps", "isUltraHdrOn", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "(Ljava/util/Collection;Landroid/util/Range;Landroidx/camera/core/impl/stabilization/VideoStabilization;ZZ)Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$CheckingMethod;", "isHighSpeedOn", "requiresFeatureComboQuery", "targetFpsRange", "isStrictFpsRequired", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(IZLjava/util/Map;Landroidx/camera/core/impl/stabilization/VideoStabilization;ZZZZLandroid/util/Range;Z)Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;", "r0", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;)Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;", "f0", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/List;Ljava/util/Map;)Z", "allPossibleSizeArrangements", "L", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/Map;Ljava/util/Map;)Ljava/util/List;", "Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$a;", "bestSizesAndMaxFps", "orderedSurfaceConfigListForStreamUseCase", "Landroidx/camera/core/impl/y;", "attachedSurfaceStreamSpecMap", "suggestedStreamSpecMap", "LY8/t;", "h0", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$a;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;Ljava/util/Map;)V", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "(Ljava/util/Map;Ljava/util/List;Ljava/util/List;)Ljava/util/List;", "Z", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;Z)Landroid/util/Range;", "e0", "(Ljava/util/List;Ljava/util/List;)Z", "I", "(Ljava/util/List;Z)I", "customMaxFps", "Landroidx/camera/core/impl/SurfaceConfig$ConfigSize;", "", "configSizeUniqueMaxFpsMap", "", "reducedSizeList", "g0", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Landroid/util/Size;IILandroidx/camera/core/impl/StreamUseCase;ZLjava/util/Map;Ljava/util/List;)V", "existingSurfaceFrameRateCeiling", "findMaxFpsForAllSizes", "l", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;ILjava/util/List;Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;Ljava/util/List;Ljava/util/Map;Z)Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$a;", "currentConfigFrameRateCeiling", "d0", "(ILandroid/util/Range;I)Z", "t", "(Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$a;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;)Ljava/util/Map;", ExifInterface.LATITUDE_SOUTH, "(Ljava/util/Map;)I", "possibleSizeList", "checkViaFeatureComboQuery", "X", "(ILjava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/List;Ljava/util/Map;Ljava/util/Map;Z)Ljava/util/List;", "D", "(Ljava/util/List;Ljava/util/List;Ljava/util/List;IZ)I", "F", "(ILandroid/util/Size;ZI)I", ExifInterface.LONGITUDE_EAST, "(ILandroid/util/Size;)I", "range", "O", "(Landroid/util/Range;)I", "firstRange", "secondRange", "N", "(Landroid/util/Range;Landroid/util/Range;)I", "targetFps", "storedRange", "newRange", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Landroid/util/Range;Landroid/util/Range;Landroid/util/Range;)Landroid/util/Range;", "targetFrameRate", "maxFps", "", "availableFpsRanges", "B", "(Landroid/util/Range;I[Landroid/util/Range;)Landroid/util/Range;", "newTargetFrameRate", "storedTargetFrameRate", "b0", "(Landroid/util/Range;Landroid/util/Range;Z)Landroid/util/Range;", "newIsStrictFpsRequired", "storedIsStrictFpsRequired", "z", "(ZLjava/lang/Boolean;)Z", "combinedMaxFps", "C", "(IILandroid/util/Size;ZI)I", "i0", "()V", "e", "u", "x", "p", "r", "q", "o", "w", "s", "v", "sizeMap", "targetSize", "p0", "(Ljava/util/Map;Landroid/util/Size;I)V", "n0", "(Ljava/util/Map;ILandroid/util/Rational;)V", "q0", "(Ljava/util/Map;I)V", "P", "()Landroid/util/Size;", "Lp/q;", ExifInterface.GPS_DIRECTION_TRUE, "()Lp/q;", "R", "Q", "c0", "(Ljava/util/List;)Ljava/util/List;", "M", "(Landroid/hardware/camera2/params/StreamConfigurationMap;ILandroid/util/Rational;)[Landroid/util/Size;", "supportedOutputSizesList", "y", Const.INTENT_KEY_APIKEY, "Landroidx/camera/camera2/pipe/g;", Const.INTENT_KEY_PKGNAME, "LK/V;", "c", "Landroidx/camera/core/featuregroup/impl/a;", "", "Ljava/lang/String;", "cameraId", "hardwareLevel", "Ljava/util/List;", "concurrentSurfaceCombinations", Const.INTENT_KEY_BACKGROUND_COMMAND, "surfaceCombinations", "surfaceCombinationsStreamUseCase", "ultraHighSurfaceCombinations", "previewStabilizationSurfaceCombinations", "highSpeedSurfaceCombinations", "Ljava/util/Map;", "featureSettingsToSupportedCombinationsMap", "m", "surfaceCombinations10Bit", "n", "surfaceCombinationsUltraHdr", "isRawSupported", "isBurstCaptureSupported", "isConcurrentCameraModeSupported", "isStreamUseCaseSupported", "isUltraHighResolutionSensorSupported", "isPreviewStabilizationSupported", "isManualSensorSupported", "LK/C0;", "Y", "()LK/C0;", "l0", "(LK/C0;)V", "surfaceSizeDefinition", "surfaceSizeDefinitionFormats", "Lp/q;", "streamConfigurationMapCompat", "Lr/i;", "Lr/i;", "extraSupportedSurfaceCombinationsContainer", "Lt/Q;", "Lt/Q;", "displayInfoManager", "Lr/A;", "Lr/A;", "resolutionCorrector", "Lr/D;", "Lr/D;", "targetAspectRatio", "Lu/d;", "Lu/d;", "dynamicRangeResolver", "Lu/i;", "Lu/i;", "highSpeedResolver", "CheckingMethod", "isSupported", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SupportedSurfaceCombination {

    /* renamed from: E, reason: collision with root package name and from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);

    /* renamed from: A, reason: collision with root package name and from kotlin metadata */
    public final C5179A resolutionCorrector;

    /* renamed from: B, reason: collision with root package name and from kotlin metadata */
    public final C5182D targetAspectRatio;

    /* renamed from: C, reason: collision with root package name and from kotlin metadata */
    public final C5556d dynamicRangeResolver;

    /* renamed from: D, reason: collision with root package name and from kotlin metadata */
    public final C5561i highSpeedResolver;

    /* renamed from: a, reason: collision with root package name and from kotlin metadata */
    public final g cameraMetadata;

    /* renamed from: b, reason: collision with root package name and from kotlin metadata */
    public final V encoderProfilesProvider;

    /* renamed from: c, reason: collision with root package name and from kotlin metadata */
    public final a featureCombinationQuery;

    /* renamed from: d, reason: collision with root package name and from kotlin metadata */
    public final String cameraId;

    /* renamed from: e, reason: collision with root package name and from kotlin metadata */
    public final int hardwareLevel;

    /* renamed from: f, reason: collision with root package name and from kotlin metadata */
    public final List<B0> concurrentSurfaceCombinations;

    /* renamed from: g, reason: collision with root package name and from kotlin metadata */
    public final List<B0> surfaceCombinations;

    /* renamed from: h, reason: collision with root package name and from kotlin metadata */
    public final List<B0> surfaceCombinationsStreamUseCase;

    /* renamed from: i, reason: collision with root package name and from kotlin metadata */
    public final List<B0> ultraHighSurfaceCombinations;

    /* renamed from: j, reason: collision with root package name and from kotlin metadata */
    public final List<B0> previewStabilizationSurfaceCombinations;

    /* renamed from: k, reason: collision with root package name and from kotlin metadata */
    public final List<B0> highSpeedSurfaceCombinations;

    /* renamed from: l, reason: collision with root package name and from kotlin metadata */
    public final Map<FeatureSettings, List<B0>> featureSettingsToSupportedCombinationsMap;

    /* renamed from: m, reason: collision with root package name and from kotlin metadata */
    public final List<B0> surfaceCombinations10Bit;

    /* renamed from: n, reason: collision with root package name and from kotlin metadata */
    public final List<B0> surfaceCombinationsUltraHdr;

    /* renamed from: o, reason: collision with root package name and from kotlin metadata */
    public boolean isRawSupported;

    /* renamed from: p, reason: collision with root package name and from kotlin metadata */
    public boolean isBurstCaptureSupported;

    /* renamed from: q, reason: collision with root package name and from kotlin metadata */
    public final boolean isConcurrentCameraModeSupported;

    /* renamed from: r, reason: collision with root package name and from kotlin metadata */
    public final boolean isStreamUseCaseSupported;

    /* renamed from: s, reason: collision with root package name and from kotlin metadata */
    public boolean isUltraHighResolutionSensorSupported;

    /* renamed from: t, reason: collision with root package name and from kotlin metadata */
    public boolean isPreviewStabilizationSupported;

    /* renamed from: u, reason: collision with root package name and from kotlin metadata */
    public boolean isManualSensorSupported;

    /* renamed from: v, reason: collision with root package name and from kotlin metadata */
    public C0 surfaceSizeDefinition;

    /* renamed from: w, reason: collision with root package name and from kotlin metadata */
    public final List<Integer> surfaceSizeDefinitionFormats;

    /* renamed from: x, reason: collision with root package name and from kotlin metadata */
    public final q streamConfigurationMapCompat;

    /* renamed from: y, reason: collision with root package name and from kotlin metadata */
    public final C5191i extraSupportedSurfaceCombinationsContainer;

    /* renamed from: z, reason: collision with root package name and from kotlin metadata */
    public final Q displayInfoManager;

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0080\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$CheckingMethod;", "", "<init>", "(Ljava/lang/String;I)V", "WITHOUT_FEATURE_COMBO", "WITH_FEATURE_COMBO", "WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class CheckingMethod {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ CheckingMethod[] $VALUES;
        public static final CheckingMethod WITHOUT_FEATURE_COMBO = new CheckingMethod("WITHOUT_FEATURE_COMBO", 0);
        public static final CheckingMethod WITH_FEATURE_COMBO = new CheckingMethod("WITH_FEATURE_COMBO", 1);
        public static final CheckingMethod WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT = new CheckingMethod("WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT", 2);

        private static final /* synthetic */ CheckingMethod[] $values() {
            return new CheckingMethod[]{WITHOUT_FEATURE_COMBO, WITH_FEATURE_COMBO, WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT};
        }

        static {
            CheckingMethod[] checkingMethodArr$values = $values();
            $VALUES = checkingMethodArr$values;
            $ENTRIES = kotlin.enums.a.a(checkingMethodArr$values);
        }

        private CheckingMethod(String str, int i10) {
        }

        public static InterfaceC4149a<CheckingMethod> getEntries() {
            return $ENTRIES;
        }

        public static CheckingMethod valueOf(String str) {
            return (CheckingMethod) Enum.valueOf(CheckingMethod.class, str);
        }

        public static CheckingMethod[] values() {
            return (CheckingMethod[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B=\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0002\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\r\u001a\u00020\fHÖ\u0001¢\u0006\u0004\b\r\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u000f\u0010\u0010J\u001a\u0010\u0013\u001a\u00020\u00122\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0013\u0010\u0014R\u001d\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00028\u0006¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0015\u0010\u0017R\u001f\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0018\u0010\u0016\u001a\u0004\b\u0018\u0010\u0017R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0019\u0010\u001a\u001a\u0004\b\u001b\u0010\u0010R\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001b\u0010\u001a\u001a\u0004\b\u001c\u0010\u0010R\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u001c\u0010\u001a\u001a\u0004\b\u0019\u0010\u0010¨\u0006\u001d"}, d2 = {"Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$a;", "", "", "Landroid/util/Size;", "bestSizes", "bestSizesForStreamUseCase", "", "maxFpsForBestSizes", "maxFpsForStreamUseCase", "maxFpsForAllSizes", "<init>", "(Ljava/util/List;Ljava/util/List;III)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", Const.INTENT_KEY_APIKEY, "Ljava/util/List;", "()Ljava/util/List;", Const.INTENT_KEY_PKGNAME, "c", "I", Const.INTENT_KEY_UMID, "e", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.adapter.SupportedSurfaceCombination$a, reason: from toString */
    public static final /* data */ class BestSizesAndMaxFpsForConfigs {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<Size> bestSizes;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final List<Size> bestSizesForStreamUseCase;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final int maxFpsForBestSizes;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final int maxFpsForStreamUseCase;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final int maxFpsForAllSizes;

        public BestSizesAndMaxFpsForConfigs(List<Size> bestSizes, List<Size> list, int i10, int i11, int i12) {
            p.i(bestSizes, "bestSizes");
            this.bestSizes = bestSizes;
            this.bestSizesForStreamUseCase = list;
            this.maxFpsForBestSizes = i10;
            this.maxFpsForStreamUseCase = i11;
            this.maxFpsForAllSizes = i12;
        }

        public final List<Size> a() {
            return this.bestSizes;
        }

        public final List<Size> b() {
            return this.bestSizesForStreamUseCase;
        }

        /* renamed from: c, reason: from getter */
        public final int getMaxFpsForAllSizes() {
            return this.maxFpsForAllSizes;
        }

        /* renamed from: d, reason: from getter */
        public final int getMaxFpsForBestSizes() {
            return this.maxFpsForBestSizes;
        }

        /* renamed from: e, reason: from getter */
        public final int getMaxFpsForStreamUseCase() {
            return this.maxFpsForStreamUseCase;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof BestSizesAndMaxFpsForConfigs)) {
                return false;
            }
            BestSizesAndMaxFpsForConfigs bestSizesAndMaxFpsForConfigs = (BestSizesAndMaxFpsForConfigs) other;
            return p.d(this.bestSizes, bestSizesAndMaxFpsForConfigs.bestSizes) && p.d(this.bestSizesForStreamUseCase, bestSizesAndMaxFpsForConfigs.bestSizesForStreamUseCase) && this.maxFpsForBestSizes == bestSizesAndMaxFpsForConfigs.maxFpsForBestSizes && this.maxFpsForStreamUseCase == bestSizesAndMaxFpsForConfigs.maxFpsForStreamUseCase && this.maxFpsForAllSizes == bestSizesAndMaxFpsForConfigs.maxFpsForAllSizes;
        }

        public int hashCode() {
            int iHashCode = this.bestSizes.hashCode() * 31;
            List<Size> list = this.bestSizesForStreamUseCase;
            return ((((((iHashCode + (list == null ? 0 : list.hashCode())) * 31) + Integer.hashCode(this.maxFpsForBestSizes)) * 31) + Integer.hashCode(this.maxFpsForStreamUseCase)) * 31) + Integer.hashCode(this.maxFpsForAllSizes);
        }

        public String toString() {
            return "BestSizesAndMaxFpsForConfigs(bestSizes=" + this.bestSizes + ", bestSizesForStreamUseCase=" + this.bestSizesForStreamUseCase + ", maxFpsForBestSizes=" + this.maxFpsForBestSizes + ", maxFpsForStreamUseCase=" + this.maxFpsForStreamUseCase + ", maxFpsForAllSizes=" + this.maxFpsForAllSizes + ')';
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J;\u0010\f\u001a\u00020\u000b2\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u001c\u0010\n\u001a\u0018\u0012\b\u0012\u0006\u0012\u0002\b\u00030\b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\u00040\u0007H\u0002¢\u0006\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$b;", "", "<init>", "()V", "", "Landroidx/camera/core/impl/b;", "attachedSurfaces", "", "Landroidx/camera/core/impl/z;", "Landroid/util/Size;", "newUseCaseConfigsSupportedSizeMap", "", Const.INTENT_KEY_PKGNAME, "(Ljava/util/List;Ljava/util/Map;)Z", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.adapter.SupportedSurfaceCombination$b, reason: from kotlin metadata */
    public static final class Companion {
        public /* synthetic */ Companion(i iVar) {
            this();
        }

        public final boolean b(List<? extends b> attachedSurfaces, Map<z<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap) {
            Iterator<? extends b> it = attachedSurfaces.iterator();
            while (it.hasNext()) {
                if (it.next().e() == 4101) {
                    return true;
                }
            }
            Iterator<z<?>> it2 = newUseCaseConfigsSupportedSizeMap.keySet().iterator();
            while (it2.hasNext()) {
                if (it2.next().o() == 4101) {
                    return true;
                }
            }
            return false;
        }

        public Companion() {
        }
    }

    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public static final /* synthetic */ class d {

        /* renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f9401a;

        static {
            int[] iArr = new int[CheckingMethod.values().length];
            try {
                iArr[CheckingMethod.WITHOUT_FEATURE_COMBO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CheckingMethod.WITH_FEATURE_COMBO.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CheckingMethod.WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            f9401a = iArr;
        }
    }

    public SupportedSurfaceCombination(Context context, g cameraMetadata, V encoderProfilesProvider, a featureCombinationQuery) throws NumberFormatException {
        p.i(context, "context");
        p.i(cameraMetadata, "cameraMetadata");
        p.i(encoderProfilesProvider, "encoderProfilesProvider");
        p.i(featureCombinationQuery, "featureCombinationQuery");
        this.cameraMetadata = cameraMetadata;
        this.encoderProfilesProvider = encoderProfilesProvider;
        this.featureCombinationQuery = featureCombinationQuery;
        this.cameraId = cameraMetadata.getCamera();
        CameraCharacteristics.Key INFO_SUPPORTED_HARDWARE_LEVEL = CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL;
        p.h(INFO_SUPPORTED_HARDWARE_LEVEL, "INFO_SUPPORTED_HARDWARE_LEVEL");
        Integer num = (Integer) cameraMetadata.e0(INFO_SUPPORTED_HARDWARE_LEVEL);
        this.hardwareLevel = num != null ? num.intValue() : 2;
        this.concurrentSurfaceCombinations = new ArrayList();
        this.surfaceCombinations = new ArrayList();
        this.surfaceCombinationsStreamUseCase = new ArrayList();
        this.ultraHighSurfaceCombinations = new ArrayList();
        this.previewStabilizationSurfaceCombinations = new ArrayList();
        this.highSpeedSurfaceCombinations = new ArrayList();
        this.featureSettingsToSupportedCombinationsMap = new LinkedHashMap();
        this.surfaceCombinations10Bit = new ArrayList();
        this.surfaceCombinationsUltraHdr = new ArrayList();
        this.isPreviewStabilizationSupported = g.INSTANCE.g(cameraMetadata);
        this.surfaceSizeDefinitionFormats = new ArrayList();
        this.streamConfigurationMapCompat = T();
        this.extraSupportedSurfaceCombinationsContainer = new C5191i();
        this.displayInfoManager = Q.INSTANCE.a(context);
        this.resolutionCorrector = new C5179A();
        this.targetAspectRatio = new C5182D();
        C5556d c5556d = new C5556d(cameraMetadata);
        this.dynamicRangeResolver = c5556d;
        this.highSpeedResolver = new C5561i(cameraMetadata);
        e();
        u();
        if (this.isUltraHighResolutionSensorSupported) {
            x();
        }
        boolean zHasSystemFeature = context.getPackageManager().hasSystemFeature("android.hardware.camera.concurrent");
        this.isConcurrentCameraModeSupported = zHasSystemFeature;
        if (zHasSystemFeature) {
            p();
        }
        if (c5556d.getIs10BitSupported()) {
            o();
        }
        if (this.isPreviewStabilizationSupported) {
            r();
        }
        boolean zI = C5564l.f42381a.i(cameraMetadata);
        this.isStreamUseCaseSupported = zI;
        if (zI) {
            s();
        }
        v();
    }

    public static /* synthetic */ Size H(SupportedSurfaceCombination supportedSurfaceCombination, StreamConfigurationMap streamConfigurationMap, int i10, boolean z10, Rational rational, int i11, Object obj) {
        if ((i11 & 8) != 0) {
            rational = null;
        }
        return supportedSurfaceCombination.G(streamConfigurationMap, i10, z10, rational);
    }

    public static final boolean K(SupportedSurfaceCombination supportedSurfaceCombination, List list) {
        return C5564l.f42381a.c(supportedSurfaceCombination.cameraMetadata, list);
    }

    public static /* synthetic */ boolean g(SupportedSurfaceCombination supportedSurfaceCombination, FeatureSettings featureSettings, List list, Map map, List list2, List list3, int i10, Object obj) {
        if ((i10 & 4) != 0) {
            map = kotlin.collections.a.i();
        }
        Map map2 = map;
        if ((i10 & 8) != 0) {
            list2 = C1173v.m();
        }
        List list4 = list2;
        if ((i10 & 16) != 0) {
            list3 = C1173v.m();
        }
        return supportedSurfaceCombination.f(featureSettings, list, map2, list4, list3);
    }

    public static final boolean m(SupportedSurfaceCombination supportedSurfaceCombination, FeatureSettings featureSettings, List list, Map map, List list2, List list3) {
        return supportedSurfaceCombination.f(featureSettings, list, map, list2, list3);
    }

    public static final boolean n(h<Boolean> hVar) {
        return hVar.getValue().booleanValue();
    }

    public static /* synthetic */ void o0(SupportedSurfaceCombination supportedSurfaceCombination, Map map, int i10, Rational rational, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            rational = null;
        }
        supportedSurfaceCombination.n0(map, i10, rational);
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x0028  */
    /* JADX WARN: Type inference failed for: r0v2, types: [boolean, int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.camera.camera2.adapter.SupportedSurfaceCombination.CheckingMethod A(java.util.Collection<D.B> r1, android.util.Range<java.lang.Integer> r2, androidx.camera.core.impl.stabilization.VideoStabilization r3, boolean r4, boolean r5) {
        /*
            r0 = this;
            if (r5 != 0) goto L5
            androidx.camera.camera2.adapter.SupportedSurfaceCombination$CheckingMethod r0 = androidx.camera.camera2.adapter.SupportedSurfaceCombination.CheckingMethod.WITHOUT_FEATURE_COMBO
            return r0
        L5:
            D.B r0 = D.B.f2000f
            boolean r0 = r1.contains(r0)
            if (r2 == 0) goto L20
            java.lang.Comparable r1 = r2.getUpper()
            java.lang.Integer r1 = (java.lang.Integer) r1
            if (r1 != 0) goto L16
            goto L20
        L16:
            int r1 = r1.intValue()
            r2 = 60
            if (r1 != r2) goto L20
            int r0 = r0 + 1
        L20:
            androidx.camera.core.impl.stabilization.VideoStabilization r1 = androidx.camera.core.impl.stabilization.VideoStabilization.ON
            if (r3 == r1) goto L28
            androidx.camera.core.impl.stabilization.VideoStabilization r1 = androidx.camera.core.impl.stabilization.VideoStabilization.PREVIEW
            if (r3 != r1) goto L2a
        L28:
            int r0 = r0 + 1
        L2a:
            if (r4 == 0) goto L2e
            int r0 = r0 + 1
        L2e:
            r1 = 1
            if (r0 <= r1) goto L34
            androidx.camera.camera2.adapter.SupportedSurfaceCombination$CheckingMethod r0 = androidx.camera.camera2.adapter.SupportedSurfaceCombination.CheckingMethod.WITH_FEATURE_COMBO
            return r0
        L34:
            if (r0 != r1) goto L39
            androidx.camera.camera2.adapter.SupportedSurfaceCombination$CheckingMethod r0 = androidx.camera.camera2.adapter.SupportedSurfaceCombination.CheckingMethod.WITHOUT_FEATURE_COMBO_FIRST_AND_THEN_WITH_IT
            return r0
        L39:
            androidx.camera.camera2.adapter.SupportedSurfaceCombination$CheckingMethod r0 = androidx.camera.camera2.adapter.SupportedSurfaceCombination.CheckingMethod.WITHOUT_FEATURE_COMBO
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.adapter.SupportedSurfaceCombination.A(java.util.Collection, android.util.Range, androidx.camera.core.impl.stabilization.VideoStabilization, boolean, boolean):androidx.camera.camera2.adapter.SupportedSurfaceCombination$CheckingMethod");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Range<java.lang.Integer> B(android.util.Range<java.lang.Integer> r8, int r9, android.util.Range<java.lang.Integer>[] r10) {
        /*
            r7 = this;
            android.util.Range<java.lang.Integer> r0 = androidx.camera.core.impl.y.f11539a
            boolean r1 = kotlin.jvm.internal.p.d(r8, r0)
            java.lang.String r2 = "FRAME_RATE_RANGE_UNSPECIFIED"
            if (r1 == 0) goto Le
            kotlin.jvm.internal.p.h(r0, r2)
            return r0
        Le:
            if (r10 != 0) goto L14
            kotlin.jvm.internal.p.h(r0, r2)
            return r0
        L14:
            android.util.Range r1 = new android.util.Range
            java.lang.Comparable r2 = r8.getLower()
            java.lang.String r3 = "getLower(...)"
            kotlin.jvm.internal.p.h(r2, r3)
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            int r2 = java.lang.Math.min(r2, r9)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Comparable r8 = r8.getUpper()
            java.lang.String r3 = "getUpper(...)"
            kotlin.jvm.internal.p.h(r8, r3)
            java.lang.Number r8 = (java.lang.Number) r8
            int r8 = r8.intValue()
            int r8 = java.lang.Math.min(r8, r9)
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r1.<init>(r2, r8)
            int r8 = r10.length
            r2 = 0
            r3 = r2
        L4a:
            if (r2 >= r8) goto Ldc
            r4 = r10[r2]
            java.lang.Comparable r5 = r4.getLower()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            if (r9 >= r5) goto L5c
            goto Ld8
        L5c:
            android.util.Range<java.lang.Integer> r5 = androidx.camera.core.impl.y.f11539a
            boolean r5 = kotlin.jvm.internal.p.d(r0, r5)
            if (r5 == 0) goto L65
            r0 = r4
        L65:
            boolean r5 = kotlin.jvm.internal.p.d(r4, r1)
            if (r5 == 0) goto L6e
            r0 = r4
            goto Ldc
        L6e:
            android.util.Range r5 = r4.intersect(r1)     // Catch: java.lang.IllegalArgumentException -> L95
            kotlin.jvm.internal.p.f(r5)     // Catch: java.lang.IllegalArgumentException -> L95
            int r5 = r7.O(r5)     // Catch: java.lang.IllegalArgumentException -> L95
            if (r3 != 0) goto L7e
            r0 = r4
            r3 = r5
            goto Ld8
        L7e:
            if (r5 < r3) goto Ld8
            kotlin.jvm.internal.p.f(r0)     // Catch: java.lang.IllegalArgumentException -> L95
            android.util.Range r0 = r7.h(r1, r0, r4)     // Catch: java.lang.IllegalArgumentException -> L95
            android.util.Range r5 = r1.intersect(r0)     // Catch: java.lang.IllegalArgumentException -> L95
            java.lang.String r6 = "intersect(...)"
            kotlin.jvm.internal.p.h(r5, r6)     // Catch: java.lang.IllegalArgumentException -> L95
            int r3 = r7.O(r5)     // Catch: java.lang.IllegalArgumentException -> L95
            goto Ld8
        L95:
            if (r3 == 0) goto L98
            goto Ld8
        L98:
            int r5 = r7.N(r4, r1)
            kotlin.jvm.internal.p.f(r0)
            int r6 = r7.N(r0, r1)
            if (r5 >= r6) goto La6
            goto Ld7
        La6:
            int r5 = r7.N(r4, r1)
            kotlin.jvm.internal.p.f(r0)
            int r6 = r7.N(r0, r1)
            if (r5 != r6) goto Ld8
            java.lang.Comparable r5 = r4.getLower()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            java.lang.Comparable r6 = r0.getUpper()
            java.lang.Number r6 = (java.lang.Number) r6
            int r6 = r6.intValue()
            if (r5 <= r6) goto Lca
            goto Ld7
        Lca:
            int r5 = r7.O(r4)
            kotlin.jvm.internal.p.f(r0)
            int r6 = r7.O(r0)
            if (r5 >= r6) goto Ld8
        Ld7:
            r0 = r4
        Ld8:
            int r2 = r2 + 1
            goto L4a
        Ldc:
            kotlin.jvm.internal.p.f(r0)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.adapter.SupportedSurfaceCombination.B(android.util.Range, int, android.util.Range[]):android.util.Range");
    }

    public final int C(int combinedMaxFps, int imageFormat, Size size, boolean isHighSpeedOn, int customMaxFps) {
        return Math.min(combinedMaxFps, F(imageFormat, size, isHighSpeedOn, customMaxFps));
    }

    public final int D(List<Size> possibleSizeList, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder, int currentConfigFrameRateCeiling, boolean isHighSpeedOn) {
        int i10 = 0;
        int iC = currentConfigFrameRateCeiling;
        for (Size size : possibleSizeList) {
            int i11 = i10 + 1;
            z<?> zVar = newUseCaseConfigs.get(useCasesPriorityOrder.get(i10).intValue());
            iC = C(iC, zVar.o(), size, isHighSpeedOn, zVar.W(size));
            i10 = i11;
        }
        return iC;
    }

    public final int E(int imageFormat, Size size) {
        long jE = T().e(imageFormat, size);
        if (jE > 0) {
            return (int) (1.0E9d / jE);
        }
        if (!this.isManualSensorSupported) {
            return Integer.MAX_VALUE;
        }
        C5473b c5473b = C5473b.f41865a;
        if (!C0761b0.k("CXCP")) {
            return 0;
        }
        Log.w(C5473b.TRUNCATED_TAG, "minFrameDuration: " + jE + " is invalid for imageFormat = " + imageFormat + ", size = " + size);
        return 0;
    }

    public final int F(int imageFormat, Size size, boolean isHighSpeedOn, int customMaxFps) {
        int iE;
        if (!isHighSpeedOn) {
            iE = E(imageFormat, size);
        } else {
            if (imageFormat != 34) {
                throw new IllegalStateException("Check failed.");
            }
            iE = this.highSpeedResolver.j(size);
        }
        return Math.min(customMaxFps, iE);
    }

    public final Size G(StreamConfigurationMap map, int imageFormat, boolean highResolutionIncluded, Rational aspectRatio) {
        Size[] sizeArrM = M(map, imageFormat, aspectRatio);
        if (sizeArrM == null || sizeArrM.length == 0) {
            return null;
        }
        M.d dVar = new M.d();
        Size size = (Size) Collections.max(C1168p.d(sizeArrM), dVar);
        Size size2 = c.f5823a;
        if (highResolutionIncluded) {
            Size[] highResolutionOutputSizes = map != null ? map.getHighResolutionOutputSizes(imageFormat) : null;
            if (highResolutionOutputSizes != null && highResolutionOutputSizes.length != 0) {
                size2 = (Size) Collections.max(C1168p.d(highResolutionOutputSizes), dVar);
            }
        }
        return (Size) Collections.max(C1173v.p(size, size2), dVar);
    }

    public final int I(List<? extends b> attachedSurfaces, boolean isHighSpeedOn) {
        int iC = Integer.MAX_VALUE;
        for (b bVar : attachedSurfaces) {
            int iE = bVar.e();
            Size sizeH = bVar.h();
            p.h(sizeH, "getSize(...)");
            iC = C(iC, iE, sizeH, isHighSpeedOn, bVar.c());
        }
        return iC;
    }

    public final List<SurfaceConfig> J(FeatureSettings featureSettings, List<SurfaceConfig> surfaceConfigList, Map<Integer, b> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, z<?>> surfaceConfigIndexUseCaseConfigMap) {
        if (!C5564l.f42381a.o(featureSettings)) {
            return null;
        }
        for (B0 b02 : this.surfaceCombinationsStreamUseCase) {
            p.f(surfaceConfigList);
            final List<SurfaceConfig> listD = b02.d(surfaceConfigList);
            if (listD != null) {
                boolean zA = C5564l.f42381a.a(surfaceConfigIndexAttachedSurfaceInfoMap, surfaceConfigIndexUseCaseConfigMap, listD);
                h hVarB = C4848b.b(new InterfaceC5063a() { // from class: o.N
                    @Override // p9.InterfaceC5063a
                    public final Object invoke() {
                        return Boolean.valueOf(SupportedSurfaceCombination.K(this.f37318a, listD));
                    }
                });
                if (zA && ((Boolean) hVarB.getValue()).booleanValue()) {
                    return listD;
                }
            }
        }
        return null;
    }

    public final List<SurfaceConfig> L(List<? extends List<Size>> allPossibleSizeArrangements, List<? extends b> attachedSurfaces, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder, FeatureSettings featureSettings, Map<Integer, b> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, z<?>> surfaceConfigIndexUseCaseConfigMap) {
        Iterator<? extends List<Size>> it = allPossibleSizeArrangements.iterator();
        List<SurfaceConfig> listJ = null;
        while (it.hasNext()) {
            listJ = J(featureSettings, X(featureSettings.getCameraMode(), attachedSurfaces, it.next(), newUseCaseConfigs, useCasesPriorityOrder, surfaceConfigIndexAttachedSurfaceInfoMap, surfaceConfigIndexUseCaseConfigMap, false), surfaceConfigIndexAttachedSurfaceInfoMap, surfaceConfigIndexUseCaseConfigMap);
            if (listJ != null) {
                return listJ;
            }
            surfaceConfigIndexAttachedSurfaceInfoMap.clear();
            surfaceConfigIndexUseCaseConfigMap.clear();
        }
        return listJ;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x0012  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Size[] M(android.hardware.camera2.params.StreamConfigurationMap r5, int r6, android.util.Rational r7) {
        /*
            r4 = this;
            r4 = 0
            kotlin.Result$a r0 = kotlin.Result.INSTANCE     // Catch: java.lang.Throwable -> L10
            r0 = 34
            if (r6 != r0) goto L14
            if (r5 == 0) goto L12
            java.lang.Class<android.graphics.SurfaceTexture> r6 = android.graphics.SurfaceTexture.class
            android.util.Size[] r5 = r5.getOutputSizes(r6)     // Catch: java.lang.Throwable -> L10
            goto L1a
        L10:
            r5 = move-exception
            goto L1f
        L12:
            r5 = r4
            goto L1a
        L14:
            if (r5 == 0) goto L12
            android.util.Size[] r5 = r5.getOutputSizes(r6)     // Catch: java.lang.Throwable -> L10
        L1a:
            java.lang.Object r5 = kotlin.Result.b(r5)     // Catch: java.lang.Throwable -> L10
            goto L29
        L1f:
            kotlin.Result$a r6 = kotlin.Result.INSTANCE
            java.lang.Object r5 = kotlin.C4849c.a(r5)
            java.lang.Object r5 = kotlin.Result.b(r5)
        L29:
            boolean r6 = kotlin.Result.g(r5)
            if (r6 == 0) goto L30
            r5 = r4
        L30:
            android.util.Size[] r5 = (android.util.Size[]) r5
            if (r5 == 0) goto L58
            if (r7 == 0) goto L57
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            int r6 = r5.length
            r0 = 0
            r1 = r0
        L3e:
            if (r1 >= r6) goto L4e
            r2 = r5[r1]
            boolean r3 = M.a.a(r2, r7)
            if (r3 == 0) goto L4b
            r4.add(r2)
        L4b:
            int r1 = r1 + 1
            goto L3e
        L4e:
            android.util.Size[] r5 = new android.util.Size[r0]
            java.lang.Object[] r4 = r4.toArray(r5)
            android.util.Size[] r4 = (android.util.Size[]) r4
            goto L58
        L57:
            r4 = r5
        L58:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.adapter.SupportedSurfaceCombination.M(android.hardware.camera2.params.StreamConfigurationMap, int, android.util.Rational):android.util.Size[]");
    }

    public final int N(Range<Integer> firstRange, Range<Integer> secondRange) {
        int iIntValue;
        int iIntValue2;
        if (firstRange.contains((Range<Integer>) secondRange.getUpper()) || firstRange.contains((Range<Integer>) secondRange.getLower())) {
            throw new IllegalArgumentException("Ranges must not intersect");
        }
        if (((Number) firstRange.getLower()).intValue() > ((Number) secondRange.getUpper()).intValue()) {
            iIntValue = ((Number) firstRange.getLower()).intValue();
            Object upper = secondRange.getUpper();
            p.h(upper, "getUpper(...)");
            iIntValue2 = ((Number) upper).intValue();
        } else {
            iIntValue = ((Number) secondRange.getLower()).intValue();
            Object upper2 = firstRange.getUpper();
            p.h(upper2, "getUpper(...)");
            iIntValue2 = ((Number) upper2).intValue();
        }
        return iIntValue - iIntValue2;
    }

    public final int O(Range<Integer> range) {
        int iIntValue = ((Number) range.getUpper()).intValue();
        Object lower = range.getLower();
        p.h(lower, "getLower(...)");
        return (iIntValue - ((Number) lower).intValue()) + 1;
    }

    public final Size P() throws NumberFormatException {
        try {
            Integer.parseInt(this.cameraId);
            Size sizeQ = Q();
            if (sizeQ != null) {
                return sizeQ;
            }
        } catch (NumberFormatException unused) {
        }
        Size sizeR = R();
        if (sizeR != null) {
            return sizeR;
        }
        Size RESOLUTION_480P = c.f5826d;
        p.h(RESOLUTION_480P, "RESOLUTION_480P");
        return RESOLUTION_480P;
    }

    public final Size Q() {
        W wB;
        Iterator it = C1173v.p(1, 13, 10, 8, 12, 6, 5, 4).iterator();
        while (it.hasNext()) {
            int iIntValue = ((Number) it.next()).intValue();
            if (this.encoderProfilesProvider.a(iIntValue) && (wB = this.encoderProfilesProvider.b(iIntValue)) != null) {
                List<W.c> listB = wB.b();
                p.h(listB, "getVideoProfiles(...)");
                if (!listB.isEmpty()) {
                    W.c cVar = wB.b().get(0);
                    p.f(cVar);
                    return cVar.k();
                }
            }
        }
        return null;
    }

    public final Size R() {
        Object objB;
        StreamConfigurationMap streamConfigurationMapG = this.streamConfigurationMapCompat.g();
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(streamConfigurationMapG != null ? streamConfigurationMapG.getOutputSizes(MediaRecorder.class) : null);
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Size[] sizeArr = (Size[]) objB;
        if (sizeArr == null) {
            return null;
        }
        Arrays.sort(sizeArr, new M.d(true));
        for (Size size : sizeArr) {
            int width = size.getWidth();
            Size size2 = c.f5828f;
            if (width <= size2.getWidth() && size.getHeight() <= size2.getHeight()) {
                return size;
            }
        }
        return null;
    }

    public final int S(Map<z<?>, B> resolvedDynamicRanges) {
        Iterator<B> it = resolvedDynamicRanges.values().iterator();
        while (it.hasNext()) {
            if (it.next().a() == 10) {
                return 10;
            }
        }
        return 8;
    }

    public final q T() {
        g gVar = this.cameraMetadata;
        CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP;
        p.h(SCALER_STREAM_CONFIGURATION_MAP, "SCALER_STREAM_CONFIGURATION_MAP");
        StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) gVar.e0(SCALER_STREAM_CONFIGURATION_MAP);
        if (streamConfigurationMap != null) {
            return new q(streamConfigurationMap, new y(this.cameraMetadata, streamConfigurationMap));
        }
        throw new IllegalArgumentException("Cannot retrieve SCALER_STREAM_CONFIGURATION_MAP");
    }

    public final SurfaceStreamSpecQueryResult U(int cameraMode, List<? extends b> attachedSurfaces, Map<z<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap, VideoStabilization videoStabilization, boolean hasVideoCapture, boolean isFeatureComboInvocation, boolean findMaxSupportedFrameRate) throws NumberFormatException {
        Pair pairA;
        Map<z<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap2 = newUseCaseConfigsSupportedSizeMap;
        p.i(attachedSurfaces, "attachedSurfaces");
        p.i(newUseCaseConfigsSupportedSizeMap2, "newUseCaseConfigsSupportedSizeMap");
        p.i(videoStabilization, "videoStabilization");
        i0();
        boolean zB = C5561i.INSTANCE.b(attachedSurfaces, newUseCaseConfigsSupportedSizeMap2.keySet());
        if (zB) {
            newUseCaseConfigsSupportedSizeMap2 = this.highSpeedResolver.f(newUseCaseConfigsSupportedSizeMap2);
        }
        Map<z<?>, ? extends List<Size>> map = newUseCaseConfigsSupportedSizeMap2;
        List<? extends z<?>> listM1 = F.m1(map.keySet());
        List<Integer> listC0 = c0(listM1);
        Map<z<?>, B> mapG = this.dynamicRangeResolver.g(attachedSurfaces, listM1, listC0);
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "resolvedDynamicRanges = " + mapG);
        }
        boolean zB2 = INSTANCE.b(attachedSurfaces, map);
        if (findMaxSupportedFrameRate) {
            pairA = j.a(Boolean.FALSE, androidx.camera.core.impl.y.f11539a);
        } else {
            boolean zE0 = e0(attachedSurfaces, listM1);
            pairA = j.a(Boolean.valueOf(zE0), Z(attachedSurfaces, listM1, listC0, zE0));
        }
        boolean zBooleanValue = ((Boolean) pairA.a()).booleanValue();
        Range<Integer> range = (Range) pairA.b();
        boolean z10 = videoStabilization == VideoStabilization.PREVIEW;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "getSuggestedStreamSpecifications: isPreviewStabilizationSupported = " + this.isPreviewStabilizationSupported + ", isFeatureComboInvocation = " + isFeatureComboInvocation);
        }
        if (z10 && !this.isPreviewStabilizationSupported && isFeatureComboInvocation) {
            throw new IllegalArgumentException("Preview stabilization is not supported by the camera.");
        }
        p.f(range);
        return j0(A(mapG.values(), range, videoStabilization, zB2, isFeatureComboInvocation), j(cameraMode, hasVideoCapture, mapG, videoStabilization, zB2, zB, isFeatureComboInvocation, false, range, zBooleanValue), attachedSurfaces, map, listM1, listC0, mapG, findMaxSupportedFrameRate);
    }

    public final List<List<Size>> V(Map<z<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder) {
        ArrayList arrayList = new ArrayList();
        Iterator<Integer> it = useCasesPriorityOrder.iterator();
        while (it.hasNext()) {
            int iIntValue = it.next().intValue();
            List<Size> list = newUseCaseConfigsSupportedSizeMap.get(newUseCaseConfigs.get(iIntValue));
            p.f(list);
            arrayList.add(d(list, newUseCaseConfigs.get(iIntValue).o()));
        }
        return arrayList;
    }

    public final List<B0> W(FeatureSettings featureSettings) {
        if (this.featureSettingsToSupportedCombinationsMap.containsKey(featureSettings)) {
            List<B0> list = this.featureSettingsToSupportedCombinationsMap.get(featureSettings);
            p.f(list);
            return list;
        }
        List<B0> arrayList = new ArrayList<>();
        if (featureSettings.getRequiresFeatureComboQuery()) {
            arrayList.addAll(C4965E.f37306a.t(this.cameraMetadata, featureSettings.getVideoStabilization()));
        } else if (featureSettings.getIsUltraHdrOn()) {
            if (this.surfaceCombinationsUltraHdr.isEmpty()) {
                w();
            }
            if (featureSettings.getCameraMode() == 0) {
                arrayList.addAll(this.surfaceCombinationsUltraHdr);
            }
        } else if (featureSettings.getIsHighSpeedOn()) {
            if (this.highSpeedSurfaceCombinations.isEmpty()) {
                q();
            }
            arrayList.addAll(this.highSpeedSurfaceCombinations);
        } else if (featureSettings.getRequiredMaxBitDepth() == 8) {
            int cameraMode = featureSettings.getCameraMode();
            if (cameraMode == 1) {
                arrayList = this.concurrentSurfaceCombinations;
            } else if (cameraMode != 2) {
                arrayList.addAll(featureSettings.getVideoStabilization() == VideoStabilization.PREVIEW ? this.previewStabilizationSurfaceCombinations : this.surfaceCombinations);
            } else {
                arrayList.addAll(this.ultraHighSurfaceCombinations);
                arrayList.addAll(this.surfaceCombinations);
            }
        } else if (featureSettings.getRequiredMaxBitDepth() == 10 && featureSettings.getCameraMode() == 0) {
            arrayList.addAll(this.surfaceCombinations10Bit);
        }
        this.featureSettingsToSupportedCombinationsMap.put(featureSettings, arrayList);
        return arrayList;
    }

    public final List<SurfaceConfig> X(int cameraMode, List<? extends b> attachedSurfaces, List<Size> possibleSizeList, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder, Map<Integer, b> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, z<?>> surfaceConfigIndexUseCaseConfigMap, boolean checkViaFeatureComboQuery) {
        ArrayList arrayList = new ArrayList();
        for (b bVar : attachedSurfaces) {
            SurfaceConfig surfaceConfigI = bVar.i();
            p.h(surfaceConfigI, "getSurfaceConfig(...)");
            arrayList.add(surfaceConfigI);
            if (surfaceConfigIndexAttachedSurfaceInfoMap != null) {
                surfaceConfigIndexAttachedSurfaceInfoMap.put(Integer.valueOf(arrayList.size() - 1), bVar);
            }
        }
        int i10 = 0;
        for (Size size : possibleSizeList) {
            int i11 = i10 + 1;
            z<?> zVar = newUseCaseConfigs.get(useCasesPriorityOrder.get(i10).intValue());
            int iO = zVar.o();
            StreamUseCase streamUseCaseU = zVar.U();
            p.h(streamUseCaseU, "getStreamUseCase(...)");
            arrayList.add(SurfaceConfig.INSTANCE.d(iO, size, a0(iO), cameraMode, checkViaFeatureComboQuery ? SurfaceConfig.ConfigSource.FEATURE_COMBINATION_TABLE : SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, streamUseCaseU));
            if (surfaceConfigIndexUseCaseConfigMap != null) {
                surfaceConfigIndexUseCaseConfigMap.put(Integer.valueOf(arrayList.size() - 1), zVar);
            }
            i10 = i11;
        }
        return arrayList;
    }

    public final C0 Y() {
        C0 c02 = this.surfaceSizeDefinition;
        if (c02 != null) {
            return c02;
        }
        p.A("surfaceSizeDefinition");
        return null;
    }

    public final Range<Integer> Z(List<? extends b> attachedSurfaces, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder, boolean isStrictFpsRequired) {
        Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = androidx.camera.core.impl.y.f11539a;
        p.h(FRAME_RATE_RANGE_UNSPECIFIED, "FRAME_RATE_RANGE_UNSPECIFIED");
        Iterator<? extends b> it = attachedSurfaces.iterator();
        while (it.hasNext()) {
            Range<Integer> rangeJ = it.next().j();
            p.h(rangeJ, "getTargetFrameRate(...)");
            FRAME_RATE_RANGE_UNSPECIFIED = b0(rangeJ, FRAME_RATE_RANGE_UNSPECIFIED, isStrictFpsRequired);
        }
        Iterator<Integer> it2 = useCasesPriorityOrder.iterator();
        while (it2.hasNext()) {
            Range<Integer> rangeA = newUseCaseConfigs.get(it2.next().intValue()).A(androidx.camera.core.impl.y.f11539a);
            p.f(rangeA);
            FRAME_RATE_RANGE_UNSPECIFIED = b0(rangeA, FRAME_RATE_RANGE_UNSPECIFIED, isStrictFpsRequired);
        }
        return FRAME_RATE_RANGE_UNSPECIFIED;
    }

    public final C0 a0(int format) {
        SupportedSurfaceCombination supportedSurfaceCombination;
        if (this.surfaceSizeDefinitionFormats.contains(Integer.valueOf(format))) {
            supportedSurfaceCombination = this;
        } else {
            Map<Integer, Size> mapN = Y().n();
            p.h(mapN, "getS720pSizeMap(...)");
            Size RESOLUTION_720P = c.f5827e;
            p.h(RESOLUTION_720P, "RESOLUTION_720P");
            p0(mapN, RESOLUTION_720P, format);
            Map<Integer, Size> mapL = Y().l();
            p.h(mapL, "getS1440pSizeMap(...)");
            Size RESOLUTION_1440P = c.f5829g;
            p.h(RESOLUTION_1440P, "RESOLUTION_1440P");
            p0(mapL, RESOLUTION_1440P, format);
            Map<Integer, Size> mapH = Y().h();
            p.h(mapH, "getMaximumSizeMap(...)");
            supportedSurfaceCombination = this;
            o0(supportedSurfaceCombination, mapH, format, null, 4, null);
            Map<Integer, Size> mapF = supportedSurfaceCombination.Y().f();
            p.h(mapF, "getMaximum4x3SizeMap(...)");
            supportedSurfaceCombination.n0(mapF, format, M.a.f4454a);
            Map<Integer, Size> mapD = supportedSurfaceCombination.Y().d();
            p.h(mapD, "getMaximum16x9SizeMap(...)");
            supportedSurfaceCombination.n0(mapD, format, M.a.f4456c);
            Map<Integer, Size> mapP = supportedSurfaceCombination.Y().p();
            p.h(mapP, "getUltraMaximumSizeMap(...)");
            supportedSurfaceCombination.q0(mapP, format);
            supportedSurfaceCombination.surfaceSizeDefinitionFormats.add(Integer.valueOf(format));
        }
        return supportedSurfaceCombination.Y();
    }

    public final Range<Integer> b0(Range<Integer> newTargetFrameRate, Range<Integer> storedTargetFrameRate, boolean isStrictFpsRequired) {
        Range<Integer> FRAME_RATE_RANGE_UNSPECIFIED = androidx.camera.core.impl.y.f11539a;
        if (p.d(storedTargetFrameRate, FRAME_RATE_RANGE_UNSPECIFIED) && p.d(newTargetFrameRate, FRAME_RATE_RANGE_UNSPECIFIED)) {
            p.h(FRAME_RATE_RANGE_UNSPECIFIED, "FRAME_RATE_RANGE_UNSPECIFIED");
            return FRAME_RATE_RANGE_UNSPECIFIED;
        }
        if (p.d(storedTargetFrameRate, FRAME_RATE_RANGE_UNSPECIFIED)) {
            return newTargetFrameRate;
        }
        if (!p.d(newTargetFrameRate, FRAME_RATE_RANGE_UNSPECIFIED)) {
            if (isStrictFpsRequired) {
                B0.h.i(p.d(newTargetFrameRate, storedTargetFrameRate), "All targetFrameRate should be the same if strict fps is required");
                return newTargetFrameRate;
            }
            try {
                Range rangeIntersect = storedTargetFrameRate.intersect(newTargetFrameRate);
                p.f(rangeIntersect);
                return rangeIntersect;
            } catch (IllegalArgumentException unused) {
            }
        }
        return storedTargetFrameRate;
    }

    public final List<Integer> c0(List<? extends z<?>> newUseCaseConfigs) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        Iterator<? extends z<?>> it = newUseCaseConfigs.iterator();
        while (it.hasNext()) {
            int iD = it.next().D(0);
            if (!arrayList2.contains(Integer.valueOf(iD))) {
                arrayList2.add(Integer.valueOf(iD));
            }
        }
        C1177z.B(arrayList2);
        C.Z(arrayList2);
        Iterator it2 = arrayList2.iterator();
        while (it2.hasNext()) {
            int iIntValue = ((Number) it2.next()).intValue();
            for (z<?> zVar : newUseCaseConfigs) {
                if (iIntValue == zVar.D(0)) {
                    arrayList.add(Integer.valueOf(newUseCaseConfigs.indexOf(zVar)));
                }
            }
        }
        return arrayList;
    }

    public final List<Size> d(List<Size> sizeList, int imageFormat) {
        Rational rational;
        List<Size> listP1;
        p.i(sizeList, "sizeList");
        int iA = this.targetAspectRatio.a(this.cameraMetadata, this.streamConfigurationMapCompat);
        if (iA == 0) {
            rational = M.a.f4454a;
        } else if (iA != 1) {
            rational = null;
            if (iA == 2) {
                Size sizeG = a0(256).g(256);
                if (sizeG != null) {
                    rational = new Rational(sizeG.getWidth(), sizeG.getHeight());
                }
            } else if (iA != 3) {
                throw new AssertionError("Undefined targetAspectRatio: " + this.targetAspectRatio);
            }
        } else {
            rational = M.a.f4456c;
        }
        if (rational == null) {
            listP1 = F.p1(sizeList);
        } else {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Size size : sizeList) {
                if (M.a.a(size, rational)) {
                    arrayList.add(size);
                } else {
                    arrayList2.add(size);
                }
            }
            arrayList2.addAll(0, arrayList);
            listP1 = arrayList2;
        }
        return this.resolutionCorrector.a(SurfaceConfig.INSTANCE.c(imageFormat), listP1);
    }

    public final boolean d0(int existingSurfaceFrameRateCeiling, Range<Integer> targetFpsRange, int currentConfigFrameRateCeiling) {
        return p.d(targetFpsRange, androidx.camera.core.impl.y.f11539a) || currentConfigFrameRateCeiling >= existingSurfaceFrameRateCeiling || currentConfigFrameRateCeiling >= ((Number) targetFpsRange.getUpper()).intValue();
    }

    public final void e() {
        g gVar = this.cameraMetadata;
        CameraCharacteristics.Key REQUEST_AVAILABLE_CAPABILITIES = CameraCharacteristics.REQUEST_AVAILABLE_CAPABILITIES;
        p.h(REQUEST_AVAILABLE_CAPABILITIES, "REQUEST_AVAILABLE_CAPABILITIES");
        int[] iArr = (int[]) gVar.e0(REQUEST_AVAILABLE_CAPABILITIES);
        if (iArr != null) {
            this.isRawSupported = r.P(iArr, 3);
            this.isBurstCaptureSupported = r.P(iArr, 6);
            this.isUltraHighResolutionSensorSupported = r.P(iArr, 16);
            this.isManualSensorSupported = r.P(iArr, 1);
        }
    }

    public final boolean e0(List<? extends b> attachedSurfaces, List<? extends z<?>> newUseCaseConfigs) {
        Iterator<? extends b> it = attachedSurfaces.iterator();
        Boolean boolValueOf = null;
        while (it.hasNext()) {
            boolValueOf = Boolean.valueOf(z(it.next().k(), boolValueOf));
        }
        Iterator<? extends z<?>> it2 = newUseCaseConfigs.iterator();
        while (it2.hasNext()) {
            boolValueOf = Boolean.valueOf(z(it2.next().G(), boolValueOf));
        }
        if (boolValueOf != null) {
            return boolValueOf.booleanValue();
        }
        return false;
    }

    public final boolean f(FeatureSettings featureSettings, List<SurfaceConfig> surfaceConfigList, Map<SurfaceConfig, B> dynamicRangesBySurfaceConfig, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder) {
        p.i(featureSettings, "featureSettings");
        p.i(surfaceConfigList, "surfaceConfigList");
        p.i(dynamicRangesBySurfaceConfig, "dynamicRangesBySurfaceConfig");
        p.i(newUseCaseConfigs, "newUseCaseConfigs");
        p.i(useCasesPriorityOrder, "useCasesPriorityOrder");
        List<B0> listW = W(featureSettings);
        boolean z10 = false;
        if (!(listW instanceof Collection) || !listW.isEmpty()) {
            Iterator<T> it = listW.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                if (((B0) it.next()).d(surfaceConfigList) != null) {
                    z10 = true;
                    break;
                }
            }
        }
        if (!z10 || !featureSettings.getRequiresFeatureComboQuery()) {
            return z10;
        }
        SessionConfig sessionConfigI = i(featureSettings, surfaceConfigList, dynamicRangesBySurfaceConfig, newUseCaseConfigs, useCasesPriorityOrder);
        boolean zA = this.featureCombinationQuery.a(sessionConfigI);
        List<DeferrableSurface> listP = sessionConfigI.p();
        p.h(listP, "getSurfaces(...)");
        Iterator<T> it2 = listP.iterator();
        while (it2.hasNext()) {
            ((DeferrableSurface) it2.next()).d();
        }
        return zA;
    }

    public final boolean f0(FeatureSettings featureSettings, List<? extends b> attachedSurfaces, Map<z<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap) {
        ArrayList arrayList = new ArrayList();
        Iterator<? extends b> it = attachedSurfaces.iterator();
        while (it.hasNext()) {
            SurfaceConfig surfaceConfigI = it.next().i();
            p.h(surfaceConfigI, "getSurfaceConfig(...)");
            arrayList.add(surfaceConfigI);
        }
        M.d dVar = new M.d();
        for (z<?> zVar : newUseCaseConfigsSupportedSizeMap.keySet()) {
            List<Size> list = newUseCaseConfigsSupportedSizeMap.get(zVar);
            if (list == null || list.isEmpty()) {
                throw new IllegalArgumentException(("No available output size is found for " + zVar + '.').toString());
            }
            Size size = (Size) Collections.min(list, dVar);
            int iO = zVar.o();
            StreamUseCase streamUseCaseU = zVar.U();
            p.h(streamUseCaseU, "getStreamUseCase(...)");
            SurfaceConfig.Companion companion = SurfaceConfig.INSTANCE;
            p.f(size);
            arrayList.add(companion.d(iO, size, a0(iO), featureSettings.getCameraMode(), SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, streamUseCaseU));
        }
        return g(this, featureSettings, arrayList, null, null, null, 28, null);
    }

    public final void g0(FeatureSettings featureSettings, Size size, int imageFormat, int customMaxFps, StreamUseCase streamUseCase, boolean forceUniqueMaxFpsFiltering, Map<SurfaceConfig.ConfigSize, Set<Integer>> configSizeUniqueMaxFpsMap, List<Size> reducedSizeList) {
        SurfaceConfig.ConfigSize configSize = SurfaceConfig.INSTANCE.d(imageFormat, size, a0(imageFormat), featureSettings.getCameraMode(), featureSettings.getRequiresFeatureComboQuery() ? SurfaceConfig.ConfigSource.FEATURE_COMBINATION_TABLE : SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, streamUseCase).getConfigSize();
        Range<Integer> rangeG = featureSettings.g();
        Range<Integer> range = androidx.camera.core.impl.y.f11539a;
        int iF = (!p.d(rangeG, range) || forceUniqueMaxFpsFiltering) ? F(imageFormat, size, featureSettings.getIsHighSpeedOn(), customMaxFps) : Integer.MAX_VALUE;
        if (featureSettings.getIsFeatureComboInvocation()) {
            if (configSize == SurfaceConfig.ConfigSize.NOT_SUPPORT) {
                return;
            }
            if (!p.d(featureSettings.g(), range) && iF < ((Number) featureSettings.g().getUpper()).intValue()) {
                return;
            }
        }
        Set<Integer> linkedHashSet = configSizeUniqueMaxFpsMap.get(configSize);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
            configSizeUniqueMaxFpsMap.put(configSize, linkedHashSet);
        }
        if (linkedHashSet.contains(Integer.valueOf(iF))) {
            return;
        }
        reducedSizeList.add(size);
        linkedHashSet.add(Integer.valueOf(iF));
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0064 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0065 A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.util.Range<java.lang.Integer> h(android.util.Range<java.lang.Integer> r10, android.util.Range<java.lang.Integer> r11, android.util.Range<java.lang.Integer> r12) {
        /*
            r9 = this;
            android.util.Range r0 = r11.intersect(r10)
            java.lang.String r1 = "intersect(...)"
            kotlin.jvm.internal.p.h(r0, r1)
            int r0 = r9.O(r0)
            double r2 = (double) r0
            android.util.Range r10 = r12.intersect(r10)
            kotlin.jvm.internal.p.h(r10, r1)
            int r10 = r9.O(r10)
            double r0 = (double) r10
            int r10 = r9.O(r12)
            double r4 = (double) r10
            double r4 = r0 / r4
            int r9 = r9.O(r11)
            double r9 = (double) r9
            double r9 = r2 / r9
            int r6 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            if (r6 <= 0) goto L37
            int r0 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r0 >= 0) goto L64
            int r9 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r9 < 0) goto L65
            goto L64
        L37:
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 != 0) goto L5c
            int r0 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r0 <= 0) goto L40
            goto L64
        L40:
            int r9 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r9 != 0) goto L5b
            java.lang.Comparable r9 = r12.getLower()
            java.lang.Number r9 = (java.lang.Number) r9
            int r9 = r9.intValue()
            java.lang.Comparable r10 = r11.getLower()
            java.lang.Number r10 = (java.lang.Number) r10
            int r10 = r10.intValue()
            if (r9 <= r10) goto L65
            goto L64
        L5b:
            return r11
        L5c:
            int r0 = (r9 > r7 ? 1 : (r9 == r7 ? 0 : -1))
            if (r0 >= 0) goto L65
            int r9 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r9 <= 0) goto L65
        L64:
            return r12
        L65:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.adapter.SupportedSurfaceCombination.h(android.util.Range, android.util.Range, android.util.Range):android.util.Range");
    }

    public final void h0(BestSizesAndMaxFpsForConfigs bestSizesAndMaxFps, List<SurfaceConfig> orderedSurfaceConfigListForStreamUseCase, List<? extends b> attachedSurfaces, Map<b, androidx.camera.core.impl.y> attachedSurfaceStreamSpecMap, Map<z<?>, androidx.camera.core.impl.y> suggestedStreamSpecMap, Map<Integer, b> surfaceConfigIndexAttachedSurfaceInfoMap, Map<Integer, z<?>> surfaceConfigIndexUseCaseConfigMap) {
        if (orderedSurfaceConfigListForStreamUseCase == null || bestSizesAndMaxFps.getMaxFpsForBestSizes() != bestSizesAndMaxFps.getMaxFpsForStreamUseCase()) {
            return;
        }
        int size = bestSizesAndMaxFps.a().size();
        List<Size> listB = bestSizesAndMaxFps.b();
        p.f(listB);
        if (size == listB.size()) {
            List<Pair> listW1 = F.w1(bestSizesAndMaxFps.a(), bestSizesAndMaxFps.b());
            if (!(listW1 instanceof Collection) || !listW1.isEmpty()) {
                for (Pair pair : listW1) {
                    if (!p.d(pair.e(), pair.f())) {
                        return;
                    }
                }
            }
            C5564l c5564l = C5564l.f42381a;
            if (c5564l.l(this.cameraMetadata, attachedSurfaces, suggestedStreamSpecMap, attachedSurfaceStreamSpecMap)) {
                return;
            }
            c5564l.m(suggestedStreamSpecMap, attachedSurfaceStreamSpecMap, surfaceConfigIndexAttachedSurfaceInfoMap, surfaceConfigIndexUseCaseConfigMap, orderedSurfaceConfigListForStreamUseCase);
        }
    }

    public final SessionConfig i(FeatureSettings featureSettings, List<SurfaceConfig> surfaceConfigList, Map<SurfaceConfig, B> dynamicRangesBySurfaceConfig, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasePriorityOrder) {
        SessionConfig.g gVar = new SessionConfig.g();
        int i10 = 0;
        for (Object obj : surfaceConfigList) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            SurfaceConfig surfaceConfig = (SurfaceConfig) obj;
            Size sizeE = surfaceConfig.e(a0(surfaceConfig.getImageFormat()));
            z<?> zVar = newUseCaseConfigs.get(useCasePriorityOrder.get(i10).intValue());
            a.Companion bVar = a.INSTANCE;
            B b10 = dynamicRangesBySurfaceConfig.get(surfaceConfig);
            if (b10 == null) {
                throw new IllegalArgumentException("Required value was null.");
            }
            SessionConfig.b bVarA = bVar.a(zVar, sizeE, b10);
            Range<Integer> rangeG = featureSettings.g();
            if (p.d(rangeG, androidx.camera.core.impl.y.f11539a)) {
                rangeG = null;
            }
            if (rangeG == null) {
                rangeG = FpsRangeFeature.f2908k;
            }
            bVarA.r(rangeG);
            if (featureSettings.getVideoStabilization() == VideoStabilization.PREVIEW) {
                bVarA.v(2);
            } else if (featureSettings.getVideoStabilization() == VideoStabilization.ON) {
                bVarA.y(2);
            }
            gVar.b(bVarA.o());
            B0.h.i(gVar.f(), "Cannot create a combined SessionConfig for feature combo after adding " + zVar + " with " + surfaceConfig + " due to [" + gVar.d() + "]; surfaceConfigList = " + surfaceConfigList + ", featureSettings = " + featureSettings + ", newUseCaseConfigs = " + newUseCaseConfigs);
            i10 = i11;
        }
        SessionConfig sessionConfigC = gVar.c();
        p.h(sessionConfigC, "build(...)");
        return sessionConfigC;
    }

    public final void i0() throws NumberFormatException {
        this.displayInfoManager.l();
        if (this.surfaceSizeDefinition == null) {
            v();
            return;
        }
        C0 c0A = C0.a(Y().b(), Y().n(), this.displayInfoManager.k(), Y().l(), Y().j(), Y().h(), Y().f(), Y().d(), Y().p());
        p.h(c0A, "create(...)");
        l0(c0A);
    }

    public final FeatureSettings j(int cameraMode, boolean hasVideoCapture, Map<z<?>, B> resolvedDynamicRanges, VideoStabilization videoStabilization, boolean isUltraHdrOn, boolean isHighSpeedOn, boolean isFeatureComboInvocation, boolean requiresFeatureComboQuery, Range<Integer> targetFpsRange, boolean isStrictFpsRequired) {
        return r0(new FeatureSettings(cameraMode, S(resolvedDynamicRanges), hasVideoCapture, videoStabilization, isUltraHdrOn, isHighSpeedOn, isFeatureComboInvocation, requiresFeatureComboQuery, targetFpsRange, isStrictFpsRequired));
    }

    public final SurfaceStreamSpecQueryResult j0(CheckingMethod checkingMethod, FeatureSettings featureSettings, List<? extends b> attachedSurfaces, Map<z<?>, ? extends List<Size>> filteredNewUseCaseConfigsSupportedSizeMap, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder, Map<z<?>, B> resolvedDynamicRanges, boolean findMaxSupportedFrameRate) {
        CheckingMethod checkingMethod2;
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            String str = C5473b.TRUNCATED_TAG;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("resolveSpecsByCheckingMethod: checkingMethod = ");
            checkingMethod2 = checkingMethod;
            sb2.append(checkingMethod2);
            Log.d(str, sb2.toString());
        } else {
            checkingMethod2 = checkingMethod;
        }
        int i10 = d.f9401a[checkingMethod2.ordinal()];
        if (i10 == 1) {
            return k0(r0(FeatureSettings.b(featureSettings, 0, 0, false, null, false, false, false, false, null, false, 895, null)), attachedSurfaces, filteredNewUseCaseConfigsSupportedSizeMap, newUseCaseConfigs, useCasesPriorityOrder, resolvedDynamicRanges, findMaxSupportedFrameRate);
        }
        if (i10 == 2) {
            Range<Integer> rangeG = (featureSettings.getIsFeatureComboInvocation() && featureSettings.g() == androidx.camera.core.impl.y.f11539a && featureSettings.getRequiresFeatureComboQuery()) ? FpsRangeFeature.f2908k : featureSettings.g();
            return k0(r0(FeatureSettings.b(featureSettings, 0, 0, false, null, false, false, false, true, rangeG, false, 639, null)), attachedSurfaces, filteredNewUseCaseConfigsSupportedSizeMap, newUseCaseConfigs, useCasesPriorityOrder, resolvedDynamicRanges, findMaxSupportedFrameRate);
        }
        if (i10 != 3) {
            throw new NoWhenBranchMatchedException();
        }
        try {
            return k0(r0(FeatureSettings.b(featureSettings, 0, 0, false, null, false, false, false, false, null, false, 895, null)), attachedSurfaces, filteredNewUseCaseConfigsSupportedSizeMap, newUseCaseConfigs, useCasesPriorityOrder, resolvedDynamicRanges, findMaxSupportedFrameRate);
        } catch (IllegalArgumentException e10) {
            C5473b c5473b2 = C5473b.f41865a;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "Failed to find a supported combination without feature combo, trying again with feature combo", e10);
            }
            return k0(r0(FeatureSettings.b(featureSettings, 0, 0, false, null, false, false, false, true, null, false, 895, null)), attachedSurfaces, filteredNewUseCaseConfigsSupportedSizeMap, newUseCaseConfigs, useCasesPriorityOrder, resolvedDynamicRanges, findMaxSupportedFrameRate);
        }
    }

    public final Map<z<?>, List<Size>> k(Map<z<?>, ? extends List<Size>> newUseCaseConfigsSupportedSizeMap, FeatureSettings featureSettings, boolean forceUniqueMaxFpsFiltering) {
        p.i(newUseCaseConfigsSupportedSizeMap, "newUseCaseConfigsSupportedSizeMap");
        p.i(featureSettings, "featureSettings");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (z<?> zVar : newUseCaseConfigsSupportedSizeMap.keySet()) {
            ArrayList arrayList = new ArrayList();
            LinkedHashMap linkedHashMap2 = new LinkedHashMap();
            List<Size> list = newUseCaseConfigsSupportedSizeMap.get(zVar);
            p.f(list);
            for (Size size : list) {
                int iO = zVar.o();
                int iW = zVar.W(size);
                StreamUseCase streamUseCaseU = zVar.U();
                p.h(streamUseCaseU, "getStreamUseCase(...)");
                g0(featureSettings, size, iO, iW, streamUseCaseU, forceUniqueMaxFpsFiltering, linkedHashMap2, arrayList);
            }
            linkedHashMap.put(zVar, arrayList);
        }
        return linkedHashMap;
    }

    public final SurfaceStreamSpecQueryResult k0(FeatureSettings featureSettings, List<? extends b> attachedSurfaces, Map<z<?>, ? extends List<Size>> filteredNewUseCaseConfigsSupportedSizeMap, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder, Map<z<?>, B> resolvedDynamicRanges, boolean findMaxSupportedFrameRate) {
        LinkedHashMap linkedHashMap;
        LinkedHashMap linkedHashMap2;
        List<SurfaceConfig> listL;
        C5473b c5473b = C5473b.f41865a;
        if (C0761b0.f("CXCP")) {
            Log.d(C5473b.TRUNCATED_TAG, "resolveSpecsBySettings: featureSettings = " + featureSettings);
        }
        if (!featureSettings.getIsFeatureComboInvocation() && !f0(featureSettings, attachedSurfaces, filteredNewUseCaseConfigsSupportedSizeMap)) {
            throw new IllegalArgumentException(("No supported surface combination is found for camera device - Id : " + this.cameraId + ". May be attempting to bind too many use cases. Existing surfaces: " + attachedSurfaces + ". New configs: " + newUseCaseConfigs + ". GroupableFeature settings: " + featureSettings + '.').toString());
        }
        List<List<Size>> listV = V(k(filteredNewUseCaseConfigsSupportedSizeMap, featureSettings, findMaxSupportedFrameRate), newUseCaseConfigs, useCasesPriorityOrder);
        LinkedHashMap linkedHashMap3 = new LinkedHashMap();
        LinkedHashMap linkedHashMap4 = new LinkedHashMap();
        List<List<Size>> listL2 = featureSettings.getIsHighSpeedOn() ? this.highSpeedResolver.l(listV) : y(listV);
        boolean zD = C5564l.f42381a.d(attachedSurfaces, newUseCaseConfigs);
        if (!this.isStreamUseCaseSupported || zD) {
            linkedHashMap = linkedHashMap3;
            linkedHashMap2 = linkedHashMap4;
            listL = null;
        } else {
            listL = L(listL2, attachedSurfaces, newUseCaseConfigs, useCasesPriorityOrder, featureSettings, linkedHashMap3, linkedHashMap4);
            linkedHashMap = linkedHashMap3;
            linkedHashMap2 = linkedHashMap4;
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "orderedSurfaceConfigListForStreamUseCase = " + listL);
            }
        }
        List<SurfaceConfig> list = listL;
        BestSizesAndMaxFpsForConfigs bestSizesAndMaxFpsForConfigsL = l(listL2, attachedSurfaces, newUseCaseConfigs, I(attachedSurfaces, featureSettings.getIsHighSpeedOn()), useCasesPriorityOrder, featureSettings, list, resolvedDynamicRanges, findMaxSupportedFrameRate);
        if (bestSizesAndMaxFpsForConfigsL != null) {
            if (C0761b0.f("CXCP")) {
                Log.d(C5473b.TRUNCATED_TAG, "resolveSpecsBySettings: bestSizesAndFps = " + bestSizesAndMaxFpsForConfigsL);
            }
            Map<z<?>, androidx.camera.core.impl.y> mapT = t(bestSizesAndMaxFpsForConfigsL, newUseCaseConfigs, useCasesPriorityOrder, resolvedDynamicRanges, featureSettings);
            LinkedHashMap linkedHashMap5 = new LinkedHashMap();
            h0(bestSizesAndMaxFpsForConfigsL, list, attachedSurfaces, linkedHashMap5, mapT, linkedHashMap, linkedHashMap2);
            return new SurfaceStreamSpecQueryResult(mapT, linkedHashMap5, bestSizesAndMaxFpsForConfigsL.getMaxFpsForAllSizes());
        }
        throw new IllegalArgumentException(("No supported surface combination is found for camera device - Id : " + this.cameraId + " and Hardware level: " + this.hardwareLevel + ". May be the specified resolution is too large and not supported. Existing surfaces: " + attachedSurfaces + ". New configs: " + newUseCaseConfigs + '.').toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:46:0x0110 A[PHI: r14 r15 r17
      0x0110: PHI (r14v3 int) = (r14v1 int), (r14v1 int), (r14v5 int), (r14v6 int) binds: [B:33:0x00ec, B:35:0x00f2, B:41:0x00ff, B:45:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x0110: PHI (r15v2 boolean) = (r15v1 boolean), (r15v1 boolean), (r15v1 boolean), (r15v3 boolean) binds: [B:33:0x00ec, B:35:0x00f2, B:41:0x00ff, B:45:0x010c] A[DONT_GENERATE, DONT_INLINE]
      0x0110: PHI (r17v3 java.util.List<android.util.Size>) = 
      (r17v1 java.util.List<android.util.Size>)
      (r17v1 java.util.List<android.util.Size>)
      (r17v5 java.util.List<android.util.Size>)
      (r17v6 java.util.List<android.util.Size>)
     binds: [B:33:0x00ec, B:35:0x00f2, B:41:0x00ff, B:45:0x010c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:62:0x013c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.camera.camera2.adapter.SupportedSurfaceCombination.BestSizesAndMaxFpsForConfigs l(java.util.List<? extends java.util.List<android.util.Size>> r25, java.util.List<? extends androidx.camera.core.impl.b> r26, final java.util.List<? extends androidx.camera.core.impl.z<?>> r27, int r28, final java.util.List<java.lang.Integer> r29, final androidx.camera.camera2.adapter.SupportedSurfaceCombination.FeatureSettings r30, java.util.List<androidx.camera.core.impl.SurfaceConfig> r31, java.util.Map<androidx.camera.core.impl.z<?>, D.B> r32, boolean r33) {
        /*
            Method dump skipped, instructions count: 387
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.adapter.SupportedSurfaceCombination.l(java.util.List, java.util.List, java.util.List, int, java.util.List, androidx.camera.camera2.adapter.SupportedSurfaceCombination$c, java.util.List, java.util.Map, boolean):androidx.camera.camera2.adapter.SupportedSurfaceCombination$a");
    }

    public final void l0(C0 c02) {
        p.i(c02, "<set-?>");
        this.surfaceSizeDefinition = c02;
    }

    public final SurfaceConfig m0(int cameraMode, int imageFormat, Size size, StreamUseCase streamUseCase) {
        p.i(size, "size");
        p.i(streamUseCase, "streamUseCase");
        return SurfaceConfig.INSTANCE.d(imageFormat, size, a0(imageFormat), cameraMode, SurfaceConfig.ConfigSource.CAPTURE_SESSION_TABLES, streamUseCase);
    }

    public final void n0(Map<Integer, Size> sizeMap, int format, Rational aspectRatio) {
        Size sizeG = G(this.streamConfigurationMapCompat.g(), format, true, aspectRatio);
        if (sizeG != null) {
            sizeMap.put(Integer.valueOf(format), sizeG);
        }
    }

    public final void o() {
        this.surfaceCombinations10Bit.addAll(C4965E.j());
    }

    public final void p() {
        this.concurrentSurfaceCombinations.addAll(C4965E.l());
    }

    public final void p0(Map<Integer, Size> sizeMap, Size targetSize, int format) {
        if (this.isConcurrentCameraModeSupported) {
            Size sizeH = H(this, this.streamConfigurationMapCompat.g(), format, false, null, 8, null);
            Integer numValueOf = Integer.valueOf(format);
            if (sizeH != null) {
                targetSize = (Size) Collections.min(C1173v.p(targetSize, sizeH), new M.d());
            }
            sizeMap.put(numValueOf, targetSize);
        }
    }

    public final void q() {
        if (this.highSpeedResolver.o()) {
            this.highSpeedSurfaceCombinations.clear();
            Size sizeK = this.highSpeedResolver.k();
            if (sizeK != null) {
                this.highSpeedSurfaceCombinations.addAll(C4965E.g(sizeK, a0(34)));
            }
        }
    }

    public final void q0(Map<Integer, Size> sizeMap, int format) {
        Size sizeH;
        if (this.isUltraHighResolutionSensorSupported) {
            g gVar = this.cameraMetadata;
            CameraCharacteristics.Key SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION = CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION;
            p.h(SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION, "SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION");
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) gVar.e0(SCALER_STREAM_CONFIGURATION_MAP_MAXIMUM_RESOLUTION);
            if (streamConfigurationMap == null || (sizeH = H(this, streamConfigurationMap, format, true, null, 8, null)) == null) {
                return;
            }
            sizeMap.put(Integer.valueOf(format), sizeH);
        }
    }

    public final void r() {
        this.previewStabilizationSurfaceCombinations.addAll(C4965E.q());
    }

    public final FeatureSettings r0(FeatureSettings featureSettings) {
        if (featureSettings.getCameraMode() != 0 && featureSettings.getIsUltraHdrOn()) {
            throw new IllegalArgumentException(("Camera device Id is " + this.cameraId + ". Ultra HDR is not currently supported in " + C0899w.a(featureSettings.getCameraMode()) + " camera mode.").toString());
        }
        if (featureSettings.getCameraMode() != 0 && featureSettings.getRequiredMaxBitDepth() == 10) {
            throw new IllegalArgumentException(("Camera device Id is " + this.cameraId + ". 10 bit dynamic range is not currently supported in " + C0899w.a(featureSettings.getCameraMode()) + " camera mode.").toString());
        }
        if (featureSettings.getCameraMode() == 0 || !featureSettings.getIsFeatureComboInvocation()) {
            if (featureSettings.getIsHighSpeedOn() && featureSettings.getIsFeatureComboInvocation()) {
                throw new IllegalArgumentException("High-speed session is not supported with feature combination");
            }
            if (!featureSettings.getIsHighSpeedOn() || this.highSpeedResolver.o()) {
                return featureSettings;
            }
            throw new IllegalArgumentException("High-speed session is not supported on this device.");
        }
        throw new IllegalArgumentException(("Camera device Id is " + this.cameraId + ". feature combination is not currently supported in " + C0899w.a(featureSettings.getCameraMode()) + " camera mode.").toString());
    }

    public final void s() {
        this.surfaceCombinationsStreamUseCase.addAll(C4965E.f37306a.v());
    }

    public final Map<z<?>, androidx.camera.core.impl.y> t(BestSizesAndMaxFpsForConfigs bestSizesAndMaxFps, List<? extends z<?>> newUseCaseConfigs, List<Integer> useCasesPriorityOrder, Map<z<?>, B> resolvedDynamicRanges, FeatureSettings featureSettings) {
        Range<Integer>[] rangeArrH;
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Range<Integer> rangeB = androidx.camera.core.impl.y.f11539a;
        if (!p.d(featureSettings.g(), rangeB)) {
            if (featureSettings.getIsHighSpeedOn()) {
                rangeArrH = this.highSpeedResolver.h(bestSizesAndMaxFps.a());
            } else {
                g gVar = this.cameraMetadata;
                CameraCharacteristics.Key CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES = CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES;
                p.h(CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, "CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES");
                rangeArrH = (Range[]) gVar.e0(CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
            }
            Range<Integer> rangeB2 = B(featureSettings.g(), bestSizesAndMaxFps.getMaxFpsForBestSizes(), rangeArrH);
            if ((featureSettings.getIsFeatureComboInvocation() || featureSettings.getIsStrictFpsRequired()) && !p.d(rangeB2, featureSettings.g())) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append("Target FPS range ");
                sb2.append(featureSettings.g());
                sb2.append(" is not supported. Max FPS supported by the calculated best combination: ");
                sb2.append(bestSizesAndMaxFps.getMaxFpsForBestSizes());
                sb2.append(". Calculated best FPS range for device: ");
                sb2.append(rangeB2);
                sb2.append(". Device supported FPS ranges: ");
                String string = Arrays.toString(rangeArrH);
                p.h(string, "toString(...)");
                sb2.append(string);
                sb2.append('.');
                throw new IllegalArgumentException(sb2.toString().toString());
            }
            rangeB = rangeB2;
        } else if (featureSettings.getIsHighSpeedOn()) {
            rangeB = B(C5561i.INSTANCE.a(), bestSizesAndMaxFps.getMaxFpsForBestSizes(), this.highSpeedResolver.h(bestSizesAndMaxFps.a()));
        }
        int i10 = 0;
        for (z<?> zVar : newUseCaseConfigs) {
            int i11 = i10 + 1;
            y.a aVarG = androidx.camera.core.impl.y.a(bestSizesAndMaxFps.a().get(useCasesPriorityOrder.indexOf(Integer.valueOf(i10)))).g(featureSettings.getIsHighSpeedOn() ? 1 : 0);
            B b10 = resolvedDynamicRanges.get(zVar);
            if (b10 == null) {
                throw new IllegalStateException("Required value was null.");
            }
            y.a aVarH = aVarG.b(b10).d(C5564l.f42381a.f(zVar)).h(featureSettings.getHasVideoCapture());
            p.h(aVarH, "setZslDisabled(...)");
            if (!p.d(rangeB, androidx.camera.core.impl.y.f11539a)) {
                aVarH.c(rangeB);
            }
            linkedHashMap.put(zVar, aVarH.a());
            i10 = i11;
        }
        return linkedHashMap;
    }

    public final void u() {
        this.surfaceCombinations.addAll(C4965E.h(this.hardwareLevel, this.isRawSupported, this.isBurstCaptureSupported));
        this.surfaceCombinations.addAll(this.extraSupportedSurfaceCombinationsContainer.a(this.cameraId));
    }

    public final void v() throws NumberFormatException {
        C0 c0A = C0.a(c.f5825c, new LinkedHashMap(), this.displayInfoManager.k(), new LinkedHashMap(), P(), new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap(), new LinkedHashMap());
        p.h(c0A, "create(...)");
        l0(c0A);
    }

    public final void w() {
        this.surfaceCombinationsUltraHdr.addAll(C4965E.w());
    }

    public final void x() {
        this.ultraHighSurfaceCombinations.addAll(C4965E.x());
    }

    public final List<List<Size>> y(List<? extends List<Size>> supportedOutputSizesList) {
        Iterator<? extends List<Size>> it = supportedOutputSizesList.iterator();
        int size = 1;
        while (it.hasNext()) {
            size *= it.next().size();
        }
        if (size == 0) {
            throw new IllegalArgumentException("Failed to find supported resolutions.");
        }
        ArrayList arrayList = new ArrayList();
        for (int i10 = 0; i10 < size; i10++) {
            arrayList.add(new ArrayList());
        }
        int size2 = size / supportedOutputSizesList.get(0).size();
        int size3 = supportedOutputSizesList.size();
        int i11 = size;
        for (int i12 = 0; i12 < size3; i12++) {
            List<Size> list = supportedOutputSizesList.get(i12);
            for (int i13 = 0; i13 < size; i13++) {
                ((List) arrayList.get(i13)).add(list.get((i13 % i11) / size2));
            }
            if (i12 < supportedOutputSizesList.size() - 1) {
                i11 = size2;
                size2 /= supportedOutputSizesList.get(i12 + 1).size();
            }
        }
        return arrayList;
    }

    public final boolean z(boolean newIsStrictFpsRequired, Boolean storedIsStrictFpsRequired) {
        if (storedIsStrictFpsRequired == null || p.d(storedIsStrictFpsRequired, Boolean.valueOf(newIsStrictFpsRequired))) {
            return newIsStrictFpsRequired;
        }
        throw new IllegalStateException("All isStrictFpsRequired should be the same");
    }

    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u001a\b\u0086\b\u0018\u00002\u00020\u0001Bm\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005¢\u0006\u0004\b\u0010\u0010\u0011Jz\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00022\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\u000e\b\u0002\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r2\b\b\u0002\u0010\u000f\u001a\u00020\u0005HÆ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0015\u001a\u00020\u0014HÖ\u0001¢\u0006\u0004\b\u0015\u0010\u0016J\u0010\u0010\u0017\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0017\u0010\u0018J\u001a\u0010\u001a\u001a\u00020\u00052\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001c\u001a\u0004\b\u001d\u0010\u0018R\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u001e\u0010\u001c\u001a\u0004\b\u001f\u0010\u0018R\u0017\u0010\u0006\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001d\u0010 \u001a\u0004\b!\u0010\"R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b!\u0010#\u001a\u0004\b$\u0010%R\u0017\u0010\t\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b\u001f\u0010 \u001a\u0004\b&\u0010\"R\u0017\u0010\n\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010\"R\u0017\u0010\u000b\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b)\u0010 \u001a\u0004\b*\u0010\"R\u0017\u0010\f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b$\u0010 \u001a\u0004\b'\u0010\"R\u001d\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00020\r8\u0006¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b)\u0010,R\u0017\u0010\u000f\u001a\u00020\u00058\u0006¢\u0006\f\n\u0004\b(\u0010 \u001a\u0004\b-\u0010\"¨\u0006."}, d2 = {"Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;", "", "", "cameraMode", "requiredMaxBitDepth", "", "hasVideoCapture", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", "videoStabilization", "isUltraHdrOn", "isHighSpeedOn", "isFeatureComboInvocation", "requiresFeatureComboQuery", "Landroid/util/Range;", "targetFpsRange", "isStrictFpsRequired", "<init>", "(IIZLandroidx/camera/core/impl/stabilization/VideoStabilization;ZZZZLandroid/util/Range;Z)V", Const.INTENT_KEY_APIKEY, "(IIZLandroidx/camera/core/impl/stabilization/VideoStabilization;ZZZZLandroid/util/Range;Z)Landroidx/camera/camera2/adapter/SupportedSurfaceCombination$c;", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "I", "c", Const.INTENT_KEY_PKGNAME, "e", "Z", Const.INTENT_KEY_UMID, "()Z", "Landroidx/camera/core/impl/stabilization/VideoStabilization;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "()Landroidx/camera/core/impl/stabilization/VideoStabilization;", "l", "f", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, Const.INTENT_KEY_BACKGROUND_COMMAND, Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "Landroid/util/Range;", "()Landroid/util/Range;", "k", "camera-camera2"}, k = 1, mv = {2, 1, 0}, xi = 48)
    /* renamed from: androidx.camera.camera2.adapter.SupportedSurfaceCombination$c, reason: from toString */
    public static final /* data */ class FeatureSettings {

        /* renamed from: a, reason: collision with root package name and from kotlin metadata and from toString */
        public final int cameraMode;

        /* renamed from: b, reason: collision with root package name and from kotlin metadata and from toString */
        public final int requiredMaxBitDepth;

        /* renamed from: c, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean hasVideoCapture;

        /* renamed from: d, reason: collision with root package name and from kotlin metadata and from toString */
        public final VideoStabilization videoStabilization;

        /* renamed from: e, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isUltraHdrOn;

        /* renamed from: f, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isHighSpeedOn;

        /* renamed from: g, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isFeatureComboInvocation;

        /* renamed from: h, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean requiresFeatureComboQuery;

        /* renamed from: i, reason: collision with root package name and from kotlin metadata and from toString */
        public final Range<Integer> targetFpsRange;

        /* renamed from: j, reason: collision with root package name and from kotlin metadata and from toString */
        public final boolean isStrictFpsRequired;

        public FeatureSettings(int i10, int i11, boolean z10, VideoStabilization videoStabilization, boolean z11, boolean z12, boolean z13, boolean z14, Range<Integer> targetFpsRange, boolean z15) {
            p.i(videoStabilization, "videoStabilization");
            p.i(targetFpsRange, "targetFpsRange");
            this.cameraMode = i10;
            this.requiredMaxBitDepth = i11;
            this.hasVideoCapture = z10;
            this.videoStabilization = videoStabilization;
            this.isUltraHdrOn = z11;
            this.isHighSpeedOn = z12;
            this.isFeatureComboInvocation = z13;
            this.requiresFeatureComboQuery = z14;
            this.targetFpsRange = targetFpsRange;
            this.isStrictFpsRequired = z15;
        }

        public static /* synthetic */ FeatureSettings b(FeatureSettings featureSettings, int i10, int i11, boolean z10, VideoStabilization videoStabilization, boolean z11, boolean z12, boolean z13, boolean z14, Range range, boolean z15, int i12, Object obj) {
            if ((i12 & 1) != 0) {
                i10 = featureSettings.cameraMode;
            }
            if ((i12 & 2) != 0) {
                i11 = featureSettings.requiredMaxBitDepth;
            }
            if ((i12 & 4) != 0) {
                z10 = featureSettings.hasVideoCapture;
            }
            if ((i12 & 8) != 0) {
                videoStabilization = featureSettings.videoStabilization;
            }
            if ((i12 & 16) != 0) {
                z11 = featureSettings.isUltraHdrOn;
            }
            if ((i12 & 32) != 0) {
                z12 = featureSettings.isHighSpeedOn;
            }
            if ((i12 & 64) != 0) {
                z13 = featureSettings.isFeatureComboInvocation;
            }
            if ((i12 & 128) != 0) {
                z14 = featureSettings.requiresFeatureComboQuery;
            }
            if ((i12 & 256) != 0) {
                range = featureSettings.targetFpsRange;
            }
            if ((i12 & 512) != 0) {
                z15 = featureSettings.isStrictFpsRequired;
            }
            Range range2 = range;
            boolean z16 = z15;
            boolean z17 = z13;
            boolean z18 = z14;
            boolean z19 = z11;
            boolean z20 = z12;
            return featureSettings.a(i10, i11, z10, videoStabilization, z19, z20, z17, z18, range2, z16);
        }

        public final FeatureSettings a(int cameraMode, int requiredMaxBitDepth, boolean hasVideoCapture, VideoStabilization videoStabilization, boolean isUltraHdrOn, boolean isHighSpeedOn, boolean isFeatureComboInvocation, boolean requiresFeatureComboQuery, Range<Integer> targetFpsRange, boolean isStrictFpsRequired) {
            p.i(videoStabilization, "videoStabilization");
            p.i(targetFpsRange, "targetFpsRange");
            return new FeatureSettings(cameraMode, requiredMaxBitDepth, hasVideoCapture, videoStabilization, isUltraHdrOn, isHighSpeedOn, isFeatureComboInvocation, requiresFeatureComboQuery, targetFpsRange, isStrictFpsRequired);
        }

        /* renamed from: c, reason: from getter */
        public final int getCameraMode() {
            return this.cameraMode;
        }

        /* renamed from: d, reason: from getter */
        public final boolean getHasVideoCapture() {
            return this.hasVideoCapture;
        }

        /* renamed from: e, reason: from getter */
        public final int getRequiredMaxBitDepth() {
            return this.requiredMaxBitDepth;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof FeatureSettings)) {
                return false;
            }
            FeatureSettings featureSettings = (FeatureSettings) other;
            return this.cameraMode == featureSettings.cameraMode && this.requiredMaxBitDepth == featureSettings.requiredMaxBitDepth && this.hasVideoCapture == featureSettings.hasVideoCapture && this.videoStabilization == featureSettings.videoStabilization && this.isUltraHdrOn == featureSettings.isUltraHdrOn && this.isHighSpeedOn == featureSettings.isHighSpeedOn && this.isFeatureComboInvocation == featureSettings.isFeatureComboInvocation && this.requiresFeatureComboQuery == featureSettings.requiresFeatureComboQuery && p.d(this.targetFpsRange, featureSettings.targetFpsRange) && this.isStrictFpsRequired == featureSettings.isStrictFpsRequired;
        }

        /* renamed from: f, reason: from getter */
        public final boolean getRequiresFeatureComboQuery() {
            return this.requiresFeatureComboQuery;
        }

        public final Range<Integer> g() {
            return this.targetFpsRange;
        }

        /* renamed from: h, reason: from getter */
        public final VideoStabilization getVideoStabilization() {
            return this.videoStabilization;
        }

        public int hashCode() {
            return (((((((((((((((((Integer.hashCode(this.cameraMode) * 31) + Integer.hashCode(this.requiredMaxBitDepth)) * 31) + Boolean.hashCode(this.hasVideoCapture)) * 31) + this.videoStabilization.hashCode()) * 31) + Boolean.hashCode(this.isUltraHdrOn)) * 31) + Boolean.hashCode(this.isHighSpeedOn)) * 31) + Boolean.hashCode(this.isFeatureComboInvocation)) * 31) + Boolean.hashCode(this.requiresFeatureComboQuery)) * 31) + this.targetFpsRange.hashCode()) * 31) + Boolean.hashCode(this.isStrictFpsRequired);
        }

        /* renamed from: i, reason: from getter */
        public final boolean getIsFeatureComboInvocation() {
            return this.isFeatureComboInvocation;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsHighSpeedOn() {
            return this.isHighSpeedOn;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getIsStrictFpsRequired() {
            return this.isStrictFpsRequired;
        }

        /* renamed from: l, reason: from getter */
        public final boolean getIsUltraHdrOn() {
            return this.isUltraHdrOn;
        }

        public String toString() {
            return "FeatureSettings(cameraMode=" + this.cameraMode + ", requiredMaxBitDepth=" + this.requiredMaxBitDepth + ", hasVideoCapture=" + this.hasVideoCapture + ", videoStabilization=" + this.videoStabilization + ", isUltraHdrOn=" + this.isUltraHdrOn + ", isHighSpeedOn=" + this.isHighSpeedOn + ", isFeatureComboInvocation=" + this.isFeatureComboInvocation + ", requiresFeatureComboQuery=" + this.requiresFeatureComboQuery + ", targetFpsRange=" + this.targetFpsRange + ", isStrictFpsRequired=" + this.isStrictFpsRequired + ')';
        }

        /* JADX WARN: Illegal instructions before constructor call */
        public /* synthetic */ FeatureSettings(int i10, int i11, boolean z10, VideoStabilization videoStabilization, boolean z11, boolean z12, boolean z13, boolean z14, Range FRAME_RATE_RANGE_UNSPECIFIED, boolean z15, int i12, i iVar) {
            z10 = (i12 & 4) != 0 ? false : z10;
            videoStabilization = (i12 & 8) != 0 ? VideoStabilization.UNSPECIFIED : videoStabilization;
            z11 = (i12 & 16) != 0 ? false : z11;
            z12 = (i12 & 32) != 0 ? false : z12;
            z13 = (i12 & 64) != 0 ? false : z13;
            z14 = (i12 & 128) != 0 ? false : z14;
            if ((i12 & 256) != 0) {
                FRAME_RATE_RANGE_UNSPECIFIED = androidx.camera.core.impl.y.f11539a;
                p.h(FRAME_RATE_RANGE_UNSPECIFIED, "FRAME_RATE_RANGE_UNSPECIFIED");
            }
            this(i10, i11, z10, videoStabilization, z11, z12, z13, z14, FRAME_RATE_RANGE_UNSPECIFIED, (i12 & 512) != 0 ? false : z15);
        }
    }
}
