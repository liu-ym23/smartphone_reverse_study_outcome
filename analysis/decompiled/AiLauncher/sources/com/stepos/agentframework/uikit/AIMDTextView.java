package com.stepos.agentframework.uikit;

import L8.b;
import Ua.C1060i;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.Layout;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.util.LruCache;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.widget.FrameLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.widget.NestedScrollView;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.AMapLocationStaticsEntity;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.agentframework.uikit.AIMDTextView;
import com.stepos.agentframework.uikit.MarkdownBlockSpacing;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import e9.InterfaceC4014c;
import g9.InterfaceC4112d;
import h8.C4148a;
import h9.InterfaceC4149a;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import kotlin.C4848b;
import kotlin.C4849c;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.sequences.SequencesKt___SequencesKt;
import kotlin.text.Regex;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import t0.C5502d;
import v9.C5685n;

@Metadata(d1 = {"\u0000Æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0015\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010 \n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\u0018\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b*\u0002þ\u0001\u0018\u0000 ©\u00022\u00020\u0001:\u0006ª\u0002«\u0002¬\u0002B'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u000f\u0010\u000b\u001a\u00020\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0011\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0011\u0010\fJ\u000f\u0010\u0012\u001a\u00020\nH\u0002¢\u0006\u0004\b\u0012\u0010\fJ\u0017\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0013H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u001a\u001a\u00020\n2\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010!\u001a\u00020\n2\u0006\u0010 \u001a\u00020\u0013H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010#\u001a\u00020\u00062\u0006\u0010\u0019\u001a\u00020\u0018H\u0002¢\u0006\u0004\b#\u0010$J\u0019\u0010%\u001a\u00020\n2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b%\u0010\u001bJ\u0017\u0010(\u001a\u00020\u00132\u0006\u0010'\u001a\u00020&H\u0002¢\u0006\u0004\b(\u0010)J\u0017\u0010,\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b,\u0010-J\u0017\u0010.\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\b.\u0010-J\u000f\u0010/\u001a\u00020\nH\u0002¢\u0006\u0004\b/\u0010\fJ\u000f\u00100\u001a\u00020\nH\u0002¢\u0006\u0004\b0\u0010\fJ\u0019\u00102\u001a\u00020\u00132\b\u00101\u001a\u0004\u0018\u00010\u001cH\u0002¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\nH\u0002¢\u0006\u0004\b4\u0010\fJ\u0011\u00106\u001a\u0004\u0018\u000105H\u0002¢\u0006\u0004\b6\u00107J\u0019\u00109\u001a\u0004\u0018\u00010\u00062\u0006\u00108\u001a\u00020\u001cH\u0002¢\u0006\u0004\b9\u0010:J\u0017\u0010=\u001a\u00020\u001c2\u0006\u0010<\u001a\u00020;H\u0002¢\u0006\u0004\b=\u0010>J\u0011\u0010@\u001a\u0004\u0018\u00010?H\u0002¢\u0006\u0004\b@\u0010AJ\u000f\u0010B\u001a\u00020\nH\u0002¢\u0006\u0004\bB\u0010\fJ\u000f\u0010C\u001a\u00020\nH\u0002¢\u0006\u0004\bC\u0010\fJ\u000f\u0010D\u001a\u00020\nH\u0002¢\u0006\u0004\bD\u0010\fJ\u000f\u0010E\u001a\u00020\nH\u0002¢\u0006\u0004\bE\u0010\fJ\u000f\u0010F\u001a\u00020\nH\u0002¢\u0006\u0004\bF\u0010\fJ\u0017\u0010H\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\rH\u0002¢\u0006\u0004\bH\u0010IJ\u0017\u0010J\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bJ\u00103J\u0017\u0010K\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bK\u00103J\u0017\u0010L\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bL\u00103J\u0017\u0010M\u001a\u00020\u00132\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bM\u00103J\u0017\u0010N\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bN\u0010OJ\u000f\u0010P\u001a\u00020\nH\u0002¢\u0006\u0004\bP\u0010\fJ\u000f\u0010Q\u001a\u00020\nH\u0002¢\u0006\u0004\bQ\u0010\fJ\u0017\u0010R\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bR\u0010\u001fJ\u0017\u0010S\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bS\u0010\u001fJ\u000f\u0010T\u001a\u00020\nH\u0002¢\u0006\u0004\bT\u0010\fJ\u0017\u0010U\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bU\u0010-J\u000f\u0010W\u001a\u00020VH\u0002¢\u0006\u0004\bW\u0010XJ%\u0010[\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020\u00060YH\u0002¢\u0006\u0004\b[\u0010\\J\u0017\u0010]\u001a\u00020\n2\u0006\u0010Z\u001a\u00020VH\u0002¢\u0006\u0004\b]\u0010^J'\u0010`\u001a\u00020\n2\u0006\u0010+\u001a\u00020*2\u0006\u0010Z\u001a\u00020V2\u0006\u0010_\u001a\u00020VH\u0002¢\u0006\u0004\b`\u0010aJ\u0017\u0010b\u001a\u00020\n2\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bb\u0010-J\u0017\u0010e\u001a\u00020\n2\u0006\u0010d\u001a\u00020cH\u0002¢\u0006\u0004\be\u0010fJ\u0017\u0010i\u001a\u00020\n2\u0006\u0010h\u001a\u00020gH\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010m\u001a\u00020l2\u0006\u0010k\u001a\u00020\u0006H\u0002¢\u0006\u0004\bm\u0010nJ\u0017\u0010o\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001cH\u0002¢\u0006\u0004\bo\u0010\u001fJ\u0017\u0010p\u001a\u00020\u00132\u0006\u0010+\u001a\u00020*H\u0002¢\u0006\u0004\bp\u0010qJ\u0017\u0010t\u001a\u00020\u00062\u0006\u0010s\u001a\u00020rH\u0002¢\u0006\u0004\bt\u0010uJ\u0017\u0010x\u001a\u0004\u0018\u00010w2\u0006\u0010v\u001a\u00020\u0013¢\u0006\u0004\bx\u0010yJ\u0015\u0010{\u001a\u00020\n2\u0006\u0010z\u001a\u00020\u0013¢\u0006\u0004\b{\u0010\"J\u0015\u0010|\u001a\u00020\n2\u0006\u0010z\u001a\u00020\u0013¢\u0006\u0004\b|\u0010\"J\u0015\u0010~\u001a\u00020\n2\u0006\u0010}\u001a\u00020\u0006¢\u0006\u0004\b~\u0010\u007fJ\u0018\u0010\u0081\u0001\u001a\u00020\n2\u0007\u0010\u0080\u0001\u001a\u00020\u0013¢\u0006\u0005\b\u0081\u0001\u0010\"J$\u0010\u0084\u0001\u001a\u00020\n2\u0007\u0010\u0082\u0001\u001a\u00020\u001c2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010\u001c¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u001e\u0010\u0088\u0001\u001a\u00020\n2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u0086\u0001H\u0016¢\u0006\u0006\b\u0088\u0001\u0010\u0089\u0001J\u001e\u0010\u008b\u0001\u001a\u00020\n2\n\u0010\u0087\u0001\u001a\u0005\u0018\u00010\u008a\u0001H\u0016¢\u0006\u0006\b\u008b\u0001\u0010\u008c\u0001J\u0018\u0010\u008e\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\u001c¢\u0006\u0005\b\u008e\u0001\u0010\u001fJ\u0018\u0010\u0090\u0001\u001a\u00020\n2\u0007\u0010\u008f\u0001\u001a\u00020\u0013¢\u0006\u0005\b\u0090\u0001\u0010\"J\u0018\u0010\u0091\u0001\u001a\u00020\n2\u0007\u0010\u008d\u0001\u001a\u00020\u001c¢\u0006\u0005\b\u0091\u0001\u0010\u001fJ\u000f\u0010\u0092\u0001\u001a\u00020\n¢\u0006\u0005\b\u0092\u0001\u0010\fJ\u0011\u0010\u0093\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b\u0093\u0001\u0010\fJ\u0011\u0010\u0094\u0001\u001a\u00020\nH\u0014¢\u0006\u0005\b\u0094\u0001\u0010\fJ\u0018\u0010\u0096\u0001\u001a\u00020\u00132\u0007\u0010\u0095\u0001\u001a\u00020\u001c¢\u0006\u0005\b\u0096\u0001\u00103J\u0011\u0010\u0097\u0001\u001a\u00020\nH\u0016¢\u0006\u0005\b\u0097\u0001\u0010\fJ\u001a\u0010\u0099\u0001\u001a\u00020\n2\u0007\u0010\u0098\u0001\u001a\u00020\u0006H\u0014¢\u0006\u0005\b\u0099\u0001\u0010\u007fJ\u0019\u0010\u009a\u0001\u001a\u00020\u00132\u0006\u0010G\u001a\u00020\rH\u0016¢\u0006\u0005\b\u009a\u0001\u0010IJ\u001b\u0010\u009b\u0001\u001a\u00020\u00132\b\u0010\u000e\u001a\u0004\u0018\u00010\rH\u0016¢\u0006\u0005\b\u009b\u0001\u0010IJ\u0017\u0010\u009d\u0001\u001a\t\u0012\u0004\u0012\u00020\u001c0\u009c\u0001¢\u0006\u0006\b\u009d\u0001\u0010\u009e\u0001J\u0018\u0010 \u0001\u001a\u00020\n2\u0007\u0010\u009f\u0001\u001a\u00020\u0006¢\u0006\u0005\b \u0001\u0010\u007fJ\"\u0010£\u0001\u001a\u00020\n2\u0007\u0010¡\u0001\u001a\u00020\u00062\u0007\u0010¢\u0001\u001a\u00020r¢\u0006\u0006\b£\u0001\u0010¤\u0001J\"\u0010§\u0001\u001a\u00020\n2\u0007\u0010¥\u0001\u001a\u00020r2\u0007\u0010¦\u0001\u001a\u00020r¢\u0006\u0006\b§\u0001\u0010¨\u0001R\u001c\u0010©\u0001\u001a\u0005\u0018\u00010\u0086\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u001c\u0010«\u0001\u001a\u0005\u0018\u00010\u008a\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010¬\u0001R\u0018\u0010®\u0001\u001a\u00030\u00ad\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R\u0017\u0010°\u0001\u001a\u00020\u00158\u0002X\u0082\u0004¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R \u0010¶\u0001\u001a\u00020\u00158BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b²\u0001\u0010³\u0001\u001a\u0006\b´\u0001\u0010µ\u0001R\u0018\u0010¸\u0001\u001a\u00030·\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010¹\u0001R\u0017\u0010º\u0001\u001a\u0002058\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R\u0018\u0010½\u0001\u001a\u00030¼\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b½\u0001\u0010¾\u0001R\u0018\u0010À\u0001\u001a\u00030¿\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Â\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010Ã\u0001R*\u0010Å\u0001\u001a\u00030Ä\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÅ\u0001\u0010Æ\u0001\u001a\u0006\bÇ\u0001\u0010È\u0001\"\u0006\bÉ\u0001\u0010Ê\u0001R\u0018\u0010Ì\u0001\u001a\u00030Ë\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÌ\u0001\u0010Í\u0001R\u001c\u0010Ï\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010Ð\u0001R\u001c\u0010Ñ\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ð\u0001R\u001a\u0010Ó\u0001\u001a\u00030Ò\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ô\u0001R\u0019\u0010Õ\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÕ\u0001\u0010Ö\u0001R\u0019\u0010×\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b×\u0001\u0010Ø\u0001R\u0019\u0010Ù\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010Ø\u0001R\u0019\u0010Ú\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÚ\u0001\u0010Ã\u0001R\u0018\u0010Û\u0001\u001a\u00030Î\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÛ\u0001\u0010Ð\u0001R\u0019\u0010Ü\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ã\u0001R\u0019\u0010Ý\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÝ\u0001\u0010Ã\u0001R\u0019\u0010Þ\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÞ\u0001\u0010Ö\u0001R\u001b\u0010ß\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010Ö\u0001R\u0019\u0010à\u0001\u001a\u00020\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bà\u0001\u0010Ö\u0001R\u001b\u0010á\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bá\u0001\u0010Ö\u0001R(\u0010ã\u0001\u001a\u0011\u0012\u0004\u0012\u00020w\u0012\u0004\u0012\u00020w\u0018\u00010â\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R@\u0010ç\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060å\u00012\u000e\u0010æ\u0001\u001a\t\u0012\u0004\u0012\u00020\u00060å\u00018\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bç\u0001\u0010è\u0001\u001a\u0006\bé\u0001\u0010ê\u0001\"\u0006\bë\u0001\u0010ì\u0001R1\u0010í\u0001\u001a\u00020\u00132\u0007\u0010æ\u0001\u001a\u00020\u00138\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\bí\u0001\u0010Ã\u0001\u001a\u0006\bî\u0001\u0010ï\u0001\"\u0005\bð\u0001\u0010\"R\u001a\u0010ò\u0001\u001a\u00030ñ\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ó\u0001R\u001b\u0010ô\u0001\u001a\u0004\u0018\u00010\u001c8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bô\u0001\u0010Ö\u0001R\u001a\u0010ö\u0001\u001a\u00030õ\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bö\u0001\u0010÷\u0001R\u001b\u0010ø\u0001\u001a\u0004\u0018\u0001058\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010»\u0001R\u0019\u0010ù\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bù\u0001\u0010Ã\u0001R\u001b\u0010ú\u0001\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010û\u0001R\u001c\u0010ü\u0001\u001a\u0005\u0018\u00010Î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bü\u0001\u0010Ð\u0001R\u0019\u0010ý\u0001\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010Ã\u0001R\u0018\u0010ÿ\u0001\u001a\u00030þ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÿ\u0001\u0010\u0080\u0002R%\u0010\u0083\u0002\u001a\u0010\u0012\u0004\u0012\u00020\u001c\u0012\u0005\u0012\u00030\u0082\u00020\u0081\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u001b\u0010\u0085\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010û\u0001R\u001b\u0010\u0086\u0002\u001a\u0004\u0018\u00010\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0086\u0002\u0010û\u0001R\u001b\u0010\u0087\u0002\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0087\u0002\u0010\u0088\u0002R\u001b\u0010\u0089\u0002\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010\u0088\u0002R\u001b\u0010\u008a\u0002\u001a\u0004\u0018\u00010r8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010\u0088\u0002R\u0019\u0010\u008b\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010Ã\u0001R\u0019\u0010\u008c\u0002\u001a\u00020\u00138\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010Ã\u0001R \u0010\u0090\u0002\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u008d\u0002\u0010³\u0001\u001a\u0006\b\u008e\u0002\u0010\u008f\u0002R \u0010\u0093\u0002\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0091\u0002\u0010³\u0001\u001a\u0006\b\u0092\u0002\u0010\u008f\u0002R \u0010\u0096\u0002\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0094\u0002\u0010³\u0001\u001a\u0006\b\u0095\u0002\u0010\u008f\u0002R \u0010\u0099\u0002\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u0097\u0002\u0010³\u0001\u001a\u0006\b\u0098\u0002\u0010\u008f\u0002R \u0010\u009c\u0002\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b\u009a\u0002\u0010³\u0001\u001a\u0006\b\u009b\u0002\u0010\u008f\u0002R\u0019\u0010\u009d\u0002\u001a\u00020V8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u009d\u0002\u0010\u009e\u0002R\u001a\u0010 \u0002\u001a\u00030\u009f\u00028\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b \u0002\u0010¡\u0002R8\u0010£\u0002\u001a\u0011\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u0013\u0018\u00010¢\u00028\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b£\u0002\u0010¤\u0002\u001a\u0006\b¥\u0002\u0010¦\u0002\"\u0006\b§\u0002\u0010¨\u0002¨\u0006\u00ad\u0002"}, d2 = {"Lcom/stepos/agentframework/uikit/AIMDTextView;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "LY8/t;", "U", "()V", "Landroid/view/MotionEvent;", "event", "e0", "(Landroid/view/MotionEvent;)V", ExifInterface.LONGITUDE_WEST, "N", "", "useRecyclerTablePlugin", "Lu8/e;", "p0", "(Z)Lu8/e;", "", "text", "setPlainTextWithLinks", "(Ljava/lang/CharSequence;)V", "", "markdown", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;)V", "plainText", "A0", "(Z)V", "X", "(Ljava/lang/CharSequence;)I", "m0", "Landroid/text/Spanned;", "spanned", "N0", "(Landroid/text/Spanned;)Z", "Landroid/view/View;", "view", "o0", "(Landroid/view/View;)V", "P0", "n0", "O0", "destination", "t0", "(Ljava/lang/String;)Z", "L0", "Landroidx/recyclerview/widget/RecyclerView;", "i0", "()Landroidx/recyclerview/widget/RecyclerView;", "target", "h0", "(Ljava/lang/String;)Ljava/lang/Integer;", "LYb/u;", "n", "y0", "(LYb/u;)Ljava/lang/String;", "Landroid/view/ViewGroup;", "j0", "()Landroid/view/ViewGroup;", "k0", "l0", "f1", "E0", "F0", "ev", "f0", "(Landroid/view/MotionEvent;)Z", "T0", "U0", "c0", "d0", "K0", "(Ljava/lang/String;)Ljava/lang/String;", "W0", "V0", "C0", "P", "O", ExifInterface.GPS_DIRECTION_TRUE, "", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "()[I", "", "offsets", "a0", "(Landroid/view/View;Ljava/util/List;)V", "H0", "([I)V", "index", "G0", "(Landroid/view/View;[I[I)V", "R", "Landroid/widget/TableLayout;", "tableLayout", "Y0", "(Landroid/widget/TableLayout;)V", "Landroid/widget/TextView;", "cell", "B0", "(Landroid/widget/TextView;)V", "textColor", "Lcom/stepos/agentframework/uikit/AIMDTextView$e;", "e1", "(I)Lcom/stepos/agentframework/uikit/AIMDTextView$e;", "b0", "u0", "(Landroid/view/View;)Z", "", "dp", "g0", "(F)I", AMapLocationStaticsEntity.FIRST_LOCATE, "Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", "v0", "(Z)Lcom/stepos/agentframework/uikit/MarkdownBlockSpacing$Kind;", x5.d.EXTRA_ENABLED, "setSelectionEnabled", "setTableHorizontalScrollEnabled", "px", "setCodeBlockMaxHeight", "(I)V", "selectable", "setCodeBlockSelectable", "source", "language", "R0", "(Ljava/lang/String;Ljava/lang/String;)V", "Landroid/view/View$OnLongClickListener;", "l", "setOnLongClickListener", "(Landroid/view/View$OnLongClickListener;)V", "Landroid/view/View$OnTouchListener;", "setOnTouchListener", "(Landroid/view/View$OnTouchListener;)V", "markdownStr", "setMarkdownAllOnce", "streaming", "setStreaming", "setMarkdown", "X0", "onDetachedFromWindow", "onAttachedToWindow", "rawFragment", "M0", "requestLayout", "visibility", "onWindowVisibilityChanged", "dispatchTouchEvent", "onTouchEvent", "", "Y", "()Ljava/util/List;", "color", "setTextColor", "unit", ContentDisposition.Parameters.Size, "S0", "(IF)V", "add", "mult", "Q0", "(FF)V", "externalLongClickListener", "Landroid/view/View$OnLongClickListener;", "externalTouchListener", "Landroid/view/View$OnTouchListener;", "Landroid/view/GestureDetector;", "longPressDetector", "Landroid/view/GestureDetector;", "textMarkwon", "Lu8/e;", "recyclerMarkwon$delegate", "LY8/h;", "getRecyclerMarkwon", "()Lu8/e;", "recyclerMarkwon", "Landroidx/appcompat/widget/AppCompatTextView;", "markdownTextView", "Landroidx/appcompat/widget/AppCompatTextView;", "markdownRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "LK8/a;", "markdownAdapter", "LK8/a;", "Lcom/stepos/agentframework/uikit/u;", "codeEntry", "Lcom/stepos/agentframework/uikit/u;", "recyclerContentSelectable", "Z", "Lcom/stepos/agentframework/uikit/y;", "dynamicTypeAnimator", "Lcom/stepos/agentframework/uikit/y;", "getDynamicTypeAnimator", "()Lcom/stepos/agentframework/uikit/y;", "setDynamicTypeAnimator", "(Lcom/stepos/agentframework/uikit/y;)V", "Landroid/os/Handler;", "updateHandler", "Landroid/os/Handler;", "Ljava/lang/Runnable;", "pendingUpdate", "Ljava/lang/Runnable;", "pendingTableUpdate", "Lcom/stepos/agentframework/uikit/AIMDTextView$RenderMode;", "currentMode", "Lcom/stepos/agentframework/uikit/AIMDTextView$RenderMode;", "lastRenderedMarkdown", "Ljava/lang/String;", "renderedTextLength", "I", "renderedClickableSpanCount", "renderedAsPlainText", "restoreVisibleContent", "isStreaming", "plainCodeActive", "plainCodeSource", "plainCodeLanguage", "lastImageSourceMarkdown", "spacingSource", "Lkotlin/Pair;", "spacingBoundaryKinds", "Lkotlin/Pair;", "", UxipConstants.f30680s, "supplementaryParagraphIndices", "Ljava/util/Set;", "getSupplementaryParagraphIndices", "()Ljava/util/Set;", "setSupplementaryParagraphIndices", "(Ljava/util/Set;)V", "hasPrecedingContent", "getHasPrecedingContent", "()Z", "setHasPrecedingContent", "", "lastTableRenderAt", "J", "latestPendingTableMarkdown", "Lcom/stepos/agentframework/uikit/l0;", "streamingReveal", "Lcom/stepos/agentframework/uikit/l0;", "hostScrollView", "isHostScrolling", "preFreezeHeight", "Ljava/lang/Integer;", "pendingHostIdleFlush", "layoutRequestedWhileFrozen", "com/stepos/agentframework/uikit/AIMDTextView$g", "hostScrollListener", "Lcom/stepos/agentframework/uikit/AIMDTextView$g;", "Landroid/util/LruCache;", "Landroid/graphics/drawable/Drawable;", "latexResultCache", "Landroid/util/LruCache;", "contentTextColor", "contentTextUnit", "contentTextSize", "Ljava/lang/Float;", "contentLineSpacingAdd", "contentLineSpacingMult", "selectionEnabled", "tableHorizontalScrollEnabled", "tableCellPaddingStartPx$delegate", "getTableCellPaddingStartPx", "()I", "tableCellPaddingStartPx", "tableCellPaddingTopPx$delegate", "getTableCellPaddingTopPx", "tableCellPaddingTopPx", "tableCellPaddingEndPx$delegate", "getTableCellPaddingEndPx", "tableCellPaddingEndPx", "tableCellPaddingBottomPx$delegate", "getTableCellPaddingBottomPx", "tableCellPaddingBottomPx", "tableBorderWidthPx$delegate", "getTableBorderWidthPx", "tableBorderWidthPx", "recyclerBlockGaps", "[I", "", "recyclerImageOnlyFlags", "[Z", "Lkotlin/Function1;", "onLinkClick", "Lp9/l;", "getOnLinkClick", "()Lp9/l;", "setOnLinkClick", "(Lp9/l;)V", "Companion", "RenderMode", Const.INTENT_KEY_UMID, "e", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AIMDTextView extends FrameLayout {
    private static final String CODE_HEADER_TAG = "agent_md_code_header";
    private static final String CODE_TEXT_TAG = "agent_md_code";
    private static final long DEBOUNCE_DELAY_MS = 30;
    private static final long DEBOUNCE_TABLE_DELAY_MS = 250;
    private static final long HOST_SCROLL_IDLE_DEBOUNCE_MS = 500;
    private static final int MARKDOWN_DISPLAY_MAX_CHARS = 65536;
    private static final String MARKDOWN_TRUNCATION_SUFFIX = "\n\n…（内容过长，已截断显示）";
    private static final long TABLE_RENDER_THROTTLE_MS = 300;
    private final C2146u codeEntry;
    private Float contentLineSpacingAdd;
    private Float contentLineSpacingMult;
    private Integer contentTextColor;
    private Float contentTextSize;
    private Integer contentTextUnit;
    private RenderMode currentMode;
    public C2150y dynamicTypeAnimator;
    private View.OnLongClickListener externalLongClickListener;
    private View.OnTouchListener externalTouchListener;
    private boolean hasPrecedingContent;
    private final g hostScrollListener;
    private RecyclerView hostScrollView;
    private boolean isHostScrolling;
    private boolean isStreaming;
    private String lastImageSourceMarkdown;
    private String lastRenderedMarkdown;
    private long lastTableRenderAt;
    private String latestPendingTableMarkdown;
    private final LruCache<String, Drawable> latexResultCache;
    private boolean layoutRequestedWhileFrozen;
    private final GestureDetector longPressDetector;
    private final K8.a markdownAdapter;
    private final RecyclerView markdownRecyclerView;
    private final AppCompatTextView markdownTextView;
    private InterfaceC5074l<? super String, Boolean> onLinkClick;
    private Runnable pendingHostIdleFlush;
    private Runnable pendingTableUpdate;
    private Runnable pendingUpdate;
    private boolean plainCodeActive;
    private String plainCodeLanguage;
    private String plainCodeSource;
    private Integer preFreezeHeight;
    private int[] recyclerBlockGaps;
    private boolean recyclerContentSelectable;
    private boolean[] recyclerImageOnlyFlags;

    /* renamed from: recyclerMarkwon$delegate, reason: from kotlin metadata */
    private final Y8.h recyclerMarkwon;
    private boolean renderedAsPlainText;
    private int renderedClickableSpanCount;
    private int renderedTextLength;
    private final Runnable restoreVisibleContent;
    private boolean selectionEnabled;
    private Pair<? extends MarkdownBlockSpacing.Kind, ? extends MarkdownBlockSpacing.Kind> spacingBoundaryKinds;
    private String spacingSource;
    private l0 streamingReveal;
    private Set<Integer> supplementaryParagraphIndices;

    /* renamed from: tableBorderWidthPx$delegate, reason: from kotlin metadata */
    private final Y8.h tableBorderWidthPx;

    /* renamed from: tableCellPaddingBottomPx$delegate, reason: from kotlin metadata */
    private final Y8.h tableCellPaddingBottomPx;

    /* renamed from: tableCellPaddingEndPx$delegate, reason: from kotlin metadata */
    private final Y8.h tableCellPaddingEndPx;

    /* renamed from: tableCellPaddingStartPx$delegate, reason: from kotlin metadata */
    private final Y8.h tableCellPaddingStartPx;

    /* renamed from: tableCellPaddingTopPx$delegate, reason: from kotlin metadata */
    private final Y8.h tableCellPaddingTopPx;
    private boolean tableHorizontalScrollEnabled;
    private final u8.e textMarkwon;
    private final Handler updateHandler;
    private static final Regex MARKDOWN_IMAGE_REGEX = new Regex("!\\[[^]\\n]*]\\([^)\\s]+(?:\\s+\"[^\"]*\")?\\)");
    private static final Regex MARKDOWN_IMAGE_URL_REGEX = new Regex("!\\[[^]\\n]*]\\(([^)\\s]+)(?:\\s+\"[^\"]*\")?\\)");

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/stepos/agentframework/uikit/AIMDTextView$RenderMode;", "", "<init>", "(Ljava/lang/String;I)V", "TEXT", "RECYCLER", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class RenderMode {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ RenderMode[] $VALUES;
        public static final RenderMode TEXT = new RenderMode("TEXT", 0);
        public static final RenderMode RECYCLER = new RenderMode("RECYCLER", 1);

        private static final /* synthetic */ RenderMode[] $values() {
            return new RenderMode[]{TEXT, RECYCLER};
        }

        static {
            RenderMode[] renderModeArr$values = $values();
            $VALUES = renderModeArr$values;
            $ENTRIES = kotlin.enums.a.a(renderModeArr$values);
        }

        private RenderMode(String str, int i10) {
        }

        public static InterfaceC4149a<RenderMode> getEntries() {
            return $ENTRIES;
        }

        public static RenderMode valueOf(String str) {
            return (RenderMode) Enum.valueOf(RenderMode.class, str);
        }

        public static RenderMode[] values() {
            return (RenderMode[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0007\u0010\u0006¨\u0006\b"}, d2 = {"com/stepos/agentframework/uikit/AIMDTextView$a", "Landroidx/recyclerview/widget/RecyclerView$OnChildAttachStateChangeListener;", "Landroid/view/View;", "view", "LY8/t;", "onChildViewAttachedToWindow", "(Landroid/view/View;)V", "onChildViewDetachedFromWindow", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class a implements RecyclerView.OnChildAttachStateChangeListener {
        public a() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewAttachedToWindow(View view) {
            kotlin.jvm.internal.p.i(view, "view");
            AIMDTextView.this.T(view);
            AIMDTextView.this.R(view);
            AIMDTextView.this.P0(view);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnChildAttachStateChangeListener
        public void onChildViewDetachedFromWindow(View view) {
            kotlin.jvm.internal.p.i(view, "view");
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/uikit/AIMDTextView$b", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "LY8/t;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.OnScrollListener {
        public b() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            if (newState != 0) {
                AIMDTextView.this.U();
            }
        }
    }

    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J/\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/agentframework/uikit/AIMDTextView$c", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.ItemDecoration {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.p.i(outRect, "outRect");
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition == -1) {
                return;
            }
            int[] iArr = AIMDTextView.this.recyclerBlockGaps;
            if (childAdapterPosition < 0 || childAdapterPosition >= iArr.length) {
                return;
            }
            outRect.top = iArr[childAdapterPosition];
        }
    }

    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0004\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0002¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u000b\u0010\fJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\fR\u0017\u0010\u0004\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0004\u0010\u0011\u001a\u0004\b\u0013\u0010\fR\u0017\u0010\u0005\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0011\u001a\u0004\b\u0014\u0010\f¨\u0006\u0015"}, d2 = {"Lcom/stepos/agentframework/uikit/AIMDTextView$e;", "", "", "headerBackground", "outerBackground", "divider", "<init>", "(III)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_PKGNAME, "c", Const.INTENT_KEY_APIKEY, "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.agentframework.uikit.AIMDTextView$e, reason: from toString */
    public static final /* data */ class TablePalette {
        private final int divider;
        private final int headerBackground;
        private final int outerBackground;

        public TablePalette(int i10, int i11, int i12) {
            this.headerBackground = i10;
            this.outerBackground = i11;
            this.divider = i12;
        }

        /* renamed from: a, reason: from getter */
        public final int getDivider() {
            return this.divider;
        }

        /* renamed from: b, reason: from getter */
        public final int getHeaderBackground() {
            return this.headerBackground;
        }

        /* renamed from: c, reason: from getter */
        public final int getOuterBackground() {
            return this.outerBackground;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TablePalette)) {
                return false;
            }
            TablePalette tablePalette = (TablePalette) other;
            return this.headerBackground == tablePalette.headerBackground && this.outerBackground == tablePalette.outerBackground && this.divider == tablePalette.divider;
        }

        public int hashCode() {
            return (((Integer.hashCode(this.headerBackground) * 31) + Integer.hashCode(this.outerBackground)) * 31) + Integer.hashCode(this.divider);
        }

        public String toString() {
            return "TablePalette(headerBackground=" + this.headerBackground + ", outerBackground=" + this.outerBackground + ", divider=" + this.divider + ")";
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class f {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[RenderMode.values().length];
            try {
                iArr[RenderMode.TEXT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[RenderMode.RECYCLER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(d1 = {"\u0000\u001d\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"com/stepos/agentframework/uikit/AIMDTextView$g", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "newState", "LY8/t;", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends RecyclerView.OnScrollListener {
        public g() {
        }

        public static final void b(AIMDTextView aIMDTextView, RecyclerView recyclerView) {
            aIMDTextView.pendingHostIdleFlush = null;
            if (recyclerView.getScrollState() != 0) {
                return;
            }
            aIMDTextView.isHostScrolling = false;
            aIMDTextView.f1();
            aIMDTextView.k0();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(final RecyclerView recyclerView, int newState) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            if (newState == 0) {
                if (AIMDTextView.this.isHostScrolling) {
                    Runnable runnable = AIMDTextView.this.pendingHostIdleFlush;
                    if (runnable != null) {
                        AIMDTextView.this.updateHandler.removeCallbacks(runnable);
                    }
                    final AIMDTextView aIMDTextView = AIMDTextView.this;
                    aIMDTextView.pendingHostIdleFlush = new Runnable() { // from class: com.stepos.agentframework.uikit.s
                        @Override // java.lang.Runnable
                        public final void run() {
                            AIMDTextView.g.b(aIMDTextView, recyclerView);
                        }
                    };
                    Handler handler = AIMDTextView.this.updateHandler;
                    Runnable runnable2 = AIMDTextView.this.pendingHostIdleFlush;
                    kotlin.jvm.internal.p.f(runnable2);
                    handler.postDelayed(runnable2, 500L);
                    return;
                }
                return;
            }
            Runnable runnable3 = AIMDTextView.this.pendingHostIdleFlush;
            if (runnable3 != null) {
                AIMDTextView.this.updateHandler.removeCallbacks(runnable3);
            }
            AIMDTextView.this.pendingHostIdleFlush = null;
            if (AIMDTextView.this.isHostScrolling) {
                return;
            }
            AIMDTextView.this.isHostScrolling = true;
            Runnable runnable4 = AIMDTextView.this.pendingTableUpdate;
            if (runnable4 != null) {
                AIMDTextView.this.updateHandler.removeCallbacks(runnable4);
            }
            AIMDTextView.this.pendingTableUpdate = null;
            AIMDTextView.this.l0();
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006J\u0017\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\b\u0010\t¨\u0006\n"}, d2 = {"com/stepos/agentframework/uikit/AIMDTextView$h", "Landroid/view/GestureDetector$SimpleOnGestureListener;", "Landroid/view/MotionEvent;", "e", "LY8/t;", "onLongPress", "(Landroid/view/MotionEvent;)V", "", "onSingleTapUp", "(Landroid/view/MotionEvent;)Z", "uikit_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class h extends GestureDetector.SimpleOnGestureListener {
        public h() {
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public void onLongPress(MotionEvent e10) {
            kotlin.jvm.internal.p.i(e10, "e");
            View.OnLongClickListener onLongClickListener = AIMDTextView.this.externalLongClickListener;
            if (onLongClickListener != null) {
                AIMDTextView aIMDTextView = AIMDTextView.this;
                aIMDTextView.performHapticFeedback(0);
                onLongClickListener.onLongClick(aIMDTextView);
            }
        }

        @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
        public boolean onSingleTapUp(MotionEvent e10) {
            kotlin.jvm.internal.p.i(e10, "e");
            return AIMDTextView.this.f0(e10);
        }
    }

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0002\u001a\u00020\u0001*\u00020\u0000H\n¢\u0006\u0004\b\u0002\u0010\u0003"}, d2 = {"LUa/M;", "LY8/t;", "<anonymous>", "(LUa/M;)V"}, k = 3, mv = {2, 2, 0})
    @InterfaceC4112d(c = "com.stepos.agentframework.uikit.AIMDTextView$setMarkdownAllOnce$1", f = "AIMDTextView.kt", l = {522}, m = "invokeSuspend", v = 1)
    /* renamed from: com.stepos.agentframework.uikit.AIMDTextView$setMarkdownAllOnce$1, reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p9.p<Ua.M, InterfaceC4014c<? super Y8.t>, Object> {
        final /* synthetic */ String $markdownStr;
        final /* synthetic */ StringBuilder $stringBuilder;
        char C$0;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        int label;
        final /* synthetic */ AIMDTextView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public AnonymousClass1(String str, StringBuilder sb2, AIMDTextView aIMDTextView, InterfaceC4014c<? super AnonymousClass1> interfaceC4014c) {
            super(2, interfaceC4014c);
            this.$markdownStr = str;
            this.$stringBuilder = sb2;
            this.this$0 = aIMDTextView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final InterfaceC4014c<Y8.t> create(Object obj, InterfaceC4014c<?> interfaceC4014c) {
            return new AnonymousClass1(this.$markdownStr, this.$stringBuilder, this.this$0, interfaceC4014c);
        }

        @Override // p9.p
        public final Object invoke(Ua.M m10, InterfaceC4014c<? super Y8.t> interfaceC4014c) {
            return ((AnonymousClass1) create(m10, interfaceC4014c)).invokeSuspend(Y8.t.f7040a);
        }

        /* JADX WARN: Removed duplicated region for block: B:10:0x0030  */
        /* JADX WARN: Removed duplicated region for block: B:14:0x007d  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0078 -> B:13:0x007b). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r10) throws java.lang.Throwable {
            /*
                r9 = this;
                java.lang.Object r0 = f9.C4063a.g()
                int r1 = r9.label
                r2 = 1
                if (r1 == 0) goto L23
                if (r1 != r2) goto L1b
                int r1 = r9.I$1
                int r3 = r9.I$0
                java.lang.Object r4 = r9.L$1
                java.lang.String r4 = (java.lang.String) r4
                java.lang.Object r4 = r9.L$0
                java.lang.String r4 = (java.lang.String) r4
                kotlin.C4849c.b(r10)
                goto L7b
            L1b:
                java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
                java.lang.String r10 = "call to 'resume' before 'invoke' with coroutine"
                r9.<init>(r10)
                throw r9
            L23:
                kotlin.C4849c.b(r10)
                java.lang.String r10 = r9.$markdownStr
                int r1 = r10.length()
                r3 = 0
                r4 = r10
            L2e:
                if (r3 >= r1) goto L7d
                char r10 = r4.charAt(r3)
                java.lang.StringBuilder r5 = r9.$stringBuilder
                char r6 = (char) r10
                r5.append(r6)
                java.lang.StringBuilder r5 = r9.$stringBuilder
                java.lang.String r5 = r5.toString()
                java.lang.String r6 = "toString(...)"
                kotlin.jvm.internal.p.h(r5, r6)
                java.lang.String r5 = La.w.n(r5)
                com.stepos.agentframework.uikit.AIMDTextView r6 = r9.this$0
                u8.e r6 = com.stepos.agentframework.uikit.AIMDTextView.F(r6)
                com.stepos.agentframework.uikit.AIMDTextView r7 = r9.this$0
                androidx.appcompat.widget.AppCompatTextView r7 = com.stepos.agentframework.uikit.AIMDTextView.B(r7)
                com.stepos.agentframework.uikit.AIMDTextView r8 = r9.this$0
                u8.e r8 = com.stepos.agentframework.uikit.AIMDTextView.F(r8)
                android.text.Spanned r8 = r8.h(r5)
                r6.g(r7, r8)
                r9.L$0 = r4
                java.lang.Object r5 = g9.h.a(r5)
                r9.L$1 = r5
                r9.I$0 = r3
                r9.I$1 = r1
                r9.C$0 = r10
                r9.label = r2
                r5 = 30
                java.lang.Object r10 = Ua.U.a(r5, r9)
                if (r10 != r0) goto L7b
                return r0
            L7b:
                int r3 = r3 + r2
                goto L2e
            L7d:
                Y8.t r9 = Y8.t.f7040a
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.AIMDTextView.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public AIMDTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
        kotlin.jvm.internal.p.i(context, "context");
    }

    public static final void D0(AIMDTextView aIMDTextView) {
        String str = aIMDTextView.latestPendingTableMarkdown;
        aIMDTextView.latestPendingTableMarkdown = null;
        aIMDTextView.pendingTableUpdate = null;
        if (str == null || str.length() == 0) {
            return;
        }
        aIMDTextView.P(str);
    }

    public static final void I0(View view, int i10) {
        ((AgentMarkdownTableHorizontalScrollView) view).scrollTo(i10, 0);
    }

    public static final void J0(AIMDTextView aIMDTextView) {
        if (aIMDTextView.isAttachedToWindow() && aIMDTextView.getWindowVisibility() == 0) {
            aIMDTextView.E0();
            aIMDTextView.markdownTextView.invalidate();
            aIMDTextView.markdownRecyclerView.invalidate();
            aIMDTextView.invalidate();
        }
    }

    public static final void Q(AIMDTextView aIMDTextView, int[] iArr) {
        aIMDTextView.O();
        aIMDTextView.H0(iArr);
        aIMDTextView.O0();
    }

    public static final String Z(La.m it) {
        kotlin.jvm.internal.p.i(it, "it");
        String str = (String) Z8.F.t0(it.c(), 1);
        if (str == null || La.H.x0(str)) {
            return null;
        }
        return str;
    }

    public static final int Z0(AIMDTextView aIMDTextView) {
        return C5685n.f(aIMDTextView.g0(0.5f), 1);
    }

    public static final int a1(AIMDTextView aIMDTextView) {
        return aIMDTextView.g0(12.0f);
    }

    public static final int b1(AIMDTextView aIMDTextView) {
        return aIMDTextView.g0(24.0f);
    }

    public static final int c1(AIMDTextView aIMDTextView) {
        return aIMDTextView.g0(12.0f);
    }

    public static final int d1(AIMDTextView aIMDTextView) {
        return aIMDTextView.g0(12.0f);
    }

    private final u8.e getRecyclerMarkwon() {
        return (u8.e) this.recyclerMarkwon.getValue();
    }

    private final int getTableBorderWidthPx() {
        return ((Number) this.tableBorderWidthPx.getValue()).intValue();
    }

    private final int getTableCellPaddingBottomPx() {
        return ((Number) this.tableCellPaddingBottomPx.getValue()).intValue();
    }

    private final int getTableCellPaddingEndPx() {
        return ((Number) this.tableCellPaddingEndPx.getValue()).intValue();
    }

    private final int getTableCellPaddingStartPx() {
        return ((Number) this.tableCellPaddingStartPx.getValue()).intValue();
    }

    private final int getTableCellPaddingTopPx() {
        return ((Number) this.tableCellPaddingTopPx.getValue()).intValue();
    }

    public static final boolean q0(AIMDTextView aIMDTextView) {
        return !aIMDTextView.hasPrecedingContent;
    }

    public static final boolean r0(AIMDTextView aIMDTextView, Yb.u node) {
        kotlin.jvm.internal.p.i(node, "node");
        return (node.f() instanceof Yb.h) && aIMDTextView.supplementaryParagraphIndices.contains(Integer.valueOf(MarkdownBlockSpacing.INSTANCE.a(node)));
    }

    public static final void s(b.InterfaceC0074b builder) {
        kotlin.jvm.internal.p.i(builder, "builder");
        builder.a(R$layout.agent_markdown_table_entry, R$id.table_layout).b(R$layout.agent_markdown_table_cell);
    }

    public static final void s0(String code) {
        kotlin.jvm.internal.p.i(code, "code");
    }

    private final void setPlainTextWithLinks(CharSequence text) {
        C2148w.b(this.markdownTextView, text, 0, null, 12, null);
        A0(true);
    }

    public static final Y8.t t(AIMDTextView aIMDTextView, String it) {
        kotlin.jvm.internal.p.i(it, "it");
        aIMDTextView.S(it);
        return Y8.t.f7040a;
    }

    public static final Yb.u w0(Yb.u it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it.e();
    }

    public static final boolean x0(Yb.u it) {
        kotlin.jvm.internal.p.i(it, "it");
        return it instanceof Yb.r;
    }

    public static final u8.e z0(AIMDTextView aIMDTextView) {
        return aIMDTextView.p0(true);
    }

    public final void A0(boolean plainText) {
        CharSequence text = this.markdownTextView.getText();
        this.renderedTextLength = text.length();
        kotlin.jvm.internal.p.f(text);
        this.renderedClickableSpanCount = X(text);
        this.renderedAsPlainText = plainText;
    }

    public final void B0(TextView cell) {
        Spannable spannableStringBuilder;
        CharSequence text = cell.getText();
        if (text instanceof Spannable) {
            spannableStringBuilder = (Spannable) text;
        } else if (!(text instanceof Spanned)) {
            return;
        } else {
            spannableStringBuilder = new SpannableStringBuilder(text);
        }
        Object[] spans = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), x8.i.class);
        kotlin.jvm.internal.p.h(spans, "getSpans(...)");
        for (Object obj : spans) {
            spannableStringBuilder.removeSpan(obj);
        }
        Object[] spans2 = spannableStringBuilder.getSpans(0, spannableStringBuilder.length(), StyleSpan.class);
        kotlin.jvm.internal.p.h(spans2, "getSpans(...)");
        ArrayList<StyleSpan> arrayList = new ArrayList();
        for (Object obj2 : spans2) {
            if ((((StyleSpan) obj2).getStyle() & 1) != 0) {
                arrayList.add(obj2);
            }
        }
        for (StyleSpan styleSpan : arrayList) {
            int spanStart = spannableStringBuilder.getSpanStart(styleSpan);
            int spanEnd = spannableStringBuilder.getSpanEnd(styleSpan);
            int spanFlags = spannableStringBuilder.getSpanFlags(styleSpan);
            spannableStringBuilder.removeSpan(styleSpan);
            if ((styleSpan.getStyle() & 2) != 0) {
                spannableStringBuilder.setSpan(new StyleSpan(2), spanStart, spanEnd, spanFlags);
            }
        }
        if (spannableStringBuilder != text) {
            cell.setText(spannableStringBuilder);
        }
    }

    public final void C0(String markdown) {
        if (kotlin.jvm.internal.p.d(markdown, this.lastRenderedMarkdown)) {
            return;
        }
        if (this.isHostScrolling) {
            this.latestPendingTableMarkdown = markdown;
            return;
        }
        long jCurrentTimeMillis = System.currentTimeMillis() - this.lastTableRenderAt;
        if (jCurrentTimeMillis >= 300) {
            P(markdown);
            return;
        }
        this.latestPendingTableMarkdown = markdown;
        long j10 = 300 - jCurrentTimeMillis;
        if (this.pendingTableUpdate == null) {
            Runnable runnable = new Runnable() { // from class: com.stepos.agentframework.uikit.d
                @Override // java.lang.Runnable
                public final void run() {
                    AIMDTextView.D0(this.f23315a);
                }
            };
            this.pendingTableUpdate = runnable;
            Handler handler = this.updateHandler;
            kotlin.jvm.internal.p.f(runnable);
            handler.postDelayed(runnable, j10);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x0047  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void E0() {
        /*
            r5 = this;
            com.stepos.agentframework.uikit.AIMDTextView$RenderMode r0 = r5.currentMode
            com.stepos.agentframework.uikit.AIMDTextView$RenderMode r1 = com.stepos.agentframework.uikit.AIMDTextView.RenderMode.TEXT
            if (r0 == r1) goto L7
            goto L53
        L7:
            androidx.appcompat.widget.AppCompatTextView r0 = r5.markdownTextView
            android.text.method.MovementMethod r0 = r0.getMovementMethod()
            boolean r0 = r0 instanceof android.text.method.LinkMovementMethod
            if (r0 != 0) goto L1a
            androidx.appcompat.widget.AppCompatTextView r0 = r5.markdownTextView
            android.text.method.MovementMethod r1 = android.text.method.LinkMovementMethod.getInstance()
            r0.setMovementMethod(r1)
        L1a:
            androidx.appcompat.widget.AppCompatTextView r0 = r5.markdownTextView
            r1 = 1
            r0.setLinksClickable(r1)
            boolean r0 = r5.plainCodeActive
            if (r0 == 0) goto L28
            r5.F0()
            return
        L28:
            java.lang.String r0 = r5.lastRenderedMarkdown
            int r2 = r0.length()
            if (r2 != 0) goto L31
            return
        L31:
            androidx.appcompat.widget.AppCompatTextView r2 = r5.markdownTextView
            java.lang.CharSequence r2 = r2.getText()
            int r3 = r5.renderedClickableSpanCount
            if (r3 <= 0) goto L47
            kotlin.jvm.internal.p.f(r2)
            int r3 = r5.X(r2)
            int r4 = r5.renderedClickableSpanCount
            if (r3 >= r4) goto L47
            goto L48
        L47:
            r1 = 0
        L48:
            int r2 = r2.length()
            int r3 = r5.renderedTextLength
            if (r2 != r3) goto L54
            if (r1 == 0) goto L53
            goto L54
        L53:
            return
        L54:
            boolean r1 = r5.renderedAsPlainText
            if (r1 == 0) goto L5c
            r5.setPlainTextWithLinks(r0)
            return
        L5c:
            r5.S(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.agentframework.uikit.AIMDTextView.E0():void");
    }

    public final void F0() {
        if (this.plainCodeSource.length() == 0) {
            return;
        }
        CharSequence text = this.markdownTextView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned != null) {
            D[] dArr = (D[]) spanned.getSpans(0, ((Spanned) text).length(), D.class);
            if (dArr != null) {
                if (!(dArr.length == 0)) {
                    return;
                }
            }
        }
        R0(this.plainCodeSource, this.plainCodeLanguage);
    }

    public final void G0(final View view, int[] offsets, int[] index) {
        int i10;
        if ((view instanceof AgentMarkdownTableHorizontalScrollView) && (i10 = index[0]) < offsets.length) {
            final int i11 = offsets[i10];
            index[0] = i10 + 1;
            if (i11 > 0) {
                AgentMarkdownTableHorizontalScrollView agentMarkdownTableHorizontalScrollView = (AgentMarkdownTableHorizontalScrollView) view;
                agentMarkdownTableHorizontalScrollView.scrollTo(i11, 0);
                if (agentMarkdownTableHorizontalScrollView.getScrollX() != i11) {
                    view.post(new Runnable() { // from class: com.stepos.agentframework.uikit.h
                        @Override // java.lang.Runnable
                        public final void run() {
                            AIMDTextView.I0(view, i11);
                        }
                    });
                }
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = viewGroup.getChildAt(i12);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                G0(childAt, offsets, index);
            }
        }
    }

    public final void H0(int[] offsets) {
        if (offsets.length == 0) {
            return;
        }
        int[] iArr = {0};
        int childCount = this.markdownRecyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.markdownRecyclerView.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            G0(childAt, offsets, iArr);
        }
    }

    public final String K0(String markdown) {
        return Q.INSTANCE.h(markdown);
    }

    public final void L0() {
        removeCallbacks(this.restoreVisibleContent);
        post(this.restoreVisibleContent);
    }

    public final boolean M0(String rawFragment) {
        ViewGroup viewGroupJ0;
        Layout layout;
        View itemView;
        kotlin.jvm.internal.p.i(rawFragment, "rawFragment");
        String strDecode = Uri.decode(La.H.R0(rawFragment, Const.STR_MART_WELL));
        if (strDecode.length() == 0 || (viewGroupJ0 = j0()) == null) {
            return false;
        }
        Rect rect = new Rect();
        int i10 = f.$EnumSwitchMapping$0[this.currentMode.ordinal()];
        if (i10 == 1) {
            CharSequence text = this.markdownTextView.getText();
            Object obj = null;
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            if (spanned == null) {
                return false;
            }
            Object[] spans = spanned.getSpans(0, spanned.length(), x8.f.class);
            kotlin.jvm.internal.p.h(spans, "getSpans(...)");
            int length = spans.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                }
                Object obj2 = spans[i11];
                x8.f fVar = (x8.f) obj2;
                if (kotlin.jvm.internal.p.d(MarkwonHelper.w0(spanned.subSequence(spanned.getSpanStart(fVar), spanned.getSpanEnd(fVar)).toString()), strDecode)) {
                    obj = obj2;
                    break;
                }
                i11++;
            }
            x8.f fVar2 = (x8.f) obj;
            if (fVar2 == null || (layout = this.markdownTextView.getLayout()) == null) {
                return false;
            }
            int lineForOffset = layout.getLineForOffset(spanned.getSpanStart(fVar2));
            rect.set(0, layout.getLineTop(lineForOffset), this.markdownTextView.getWidth(), layout.getLineBottom(lineForOffset));
            itemView = this.markdownTextView;
        } else {
            if (i10 != 2) {
                throw new NoWhenBranchMatchedException();
            }
            kotlin.jvm.internal.p.f(strDecode);
            Integer numH0 = h0(strDecode);
            if (numH0 == null) {
                return false;
            }
            RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = this.markdownRecyclerView.findViewHolderForAdapterPosition(numH0.intValue());
            if (viewHolderFindViewHolderForAdapterPosition == null) {
                return false;
            }
            itemView = viewHolderFindViewHolderForAdapterPosition.itemView;
            kotlin.jvm.internal.p.h(itemView, "itemView");
            rect.set(0, 0, itemView.getWidth(), itemView.getHeight());
        }
        viewGroupJ0.offsetDescendantRectToMyCoords(itemView, rect);
        int iG0 = g0(8.0f);
        if (viewGroupJ0 instanceof NestedScrollView) {
            ((NestedScrollView) viewGroupJ0).Q(0, C5685n.f(rect.top - iG0, 0));
        } else if (viewGroupJ0 instanceof ScrollView) {
            ((ScrollView) viewGroupJ0).smoothScrollTo(0, C5685n.f(rect.top - iG0, 0));
        } else if (viewGroupJ0 instanceof RecyclerView) {
            ((RecyclerView) viewGroupJ0).smoothScrollBy(0, rect.top - iG0);
        }
        return true;
    }

    public final void N() {
        this.markdownTextView.setTextColor((getContext().getResources().getConfiguration().uiMode & 48) == 32 ? MarkwonHelper.T() : MarkwonHelper.S());
        this.markdownTextView.setTextSize(2, 12.0f);
        this.markdownTextView.setTypeface(Typeface.MONOSPACE);
        this.markdownTextView.setLineSpacing(TypedValue.applyDimension(1, 4.0f, getResources().getDisplayMetrics()), 1.0f);
    }

    public final boolean N0(Spanned spanned) {
        Drawable drawable;
        io.noties.markwon.image.e[] eVarArr = (io.noties.markwon.image.e[]) spanned.getSpans(0, spanned.length(), io.noties.markwon.image.e.class);
        kotlin.jvm.internal.p.f(eVarArr);
        boolean z10 = false;
        for (io.noties.markwon.image.e eVar : eVarArr) {
            io.noties.markwon.image.a aVarA = eVar.a();
            kotlin.jvm.internal.p.h(aVarA, "getDrawable(...)");
            if (!aVarA.h() && t0(aVarA.b()) && (drawable = this.latexResultCache.get(aVarA.b())) != null) {
                aVarA.p(drawable);
                z10 = true;
            }
        }
        return z10;
    }

    public final void O() {
        int childCount = this.markdownRecyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.markdownRecyclerView.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            T(childAt);
            View childAt2 = this.markdownRecyclerView.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt2, "getChildAt(...)");
            R(childAt2);
        }
    }

    public final void O0() {
        int childCount = this.markdownRecyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.markdownRecyclerView.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            P0(childAt);
        }
    }

    public final void P(String markdown) {
        n0();
        final int[] iArrV = V();
        b0(markdown);
        this.markdownAdapter.e(getRecyclerMarkwon(), markdown);
        this.markdownAdapter.notifyDataSetChanged();
        this.markdownRecyclerView.post(new Runnable() { // from class: com.stepos.agentframework.uikit.c
            @Override // java.lang.Runnable
            public final void run() {
                AIMDTextView.Q(this.f23312a, iArrV);
            }
        });
        this.lastRenderedMarkdown = markdown;
        this.lastTableRenderAt = System.currentTimeMillis();
    }

    public final void P0(View view) {
        if (view instanceof TextView) {
            CharSequence text = ((TextView) view).getText();
            Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
            if (spanned != null && N0(spanned)) {
                view.invalidate();
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                P0(childAt);
            }
        }
    }

    public final void Q0(float add, float mult) {
        this.contentLineSpacingAdd = Float.valueOf(add);
        this.contentLineSpacingMult = Float.valueOf(mult);
        this.markdownTextView.setLineSpacing(add, mult);
        O();
    }

    public final void R(View view) {
        if (view instanceof AgentMarkdownTableHorizontalScrollView) {
            AgentMarkdownTableHorizontalScrollView agentMarkdownTableHorizontalScrollView = (AgentMarkdownTableHorizontalScrollView) view;
            agentMarkdownTableHorizontalScrollView.setTrailingNonContentPaddingPx(getTableCellPaddingEndPx());
            agentMarkdownTableHorizontalScrollView.setHorizontalScrollEnabled(this.tableHorizontalScrollEnabled);
        }
        if (view instanceof TableLayout) {
            Y0((TableLayout) view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                R(childAt);
            }
        }
    }

    public final void R0(String source, String language) {
        String string;
        kotlin.jvm.internal.p.i(source, "source");
        if (source.length() == 0) {
            return;
        }
        W0();
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        u8.e eVar = this.textMarkwon;
        String str = null;
        String string2 = language != null ? La.H.D1(language).toString() : null;
        if (string2 == null) {
            string2 = "";
        }
        CharSequence charSequenceF0 = MarkwonHelper.f0(context, eVar, string2, source);
        N();
        boolean z10 = this.codeEntry.getCodeSelectable() || this.recyclerContentSelectable;
        this.markdownTextView.setTextIsSelectable(z10);
        if (!z10) {
            this.markdownTextView.setMovementMethod(LinkMovementMethod.getInstance());
        }
        if (language != null && (string = La.H.D1(language).toString()) != null && string.length() > 0) {
            str = string;
        }
        this.plainCodeLanguage = str;
        this.plainCodeSource = source;
        this.plainCodeActive = true;
        AppCompatTextView appCompatTextView = this.markdownTextView;
        Context context2 = getContext();
        kotlin.jvm.internal.p.h(context2, "getContext(...)");
        appCompatTextView.setText(MarkwonHelper.B0(context2, charSequenceF0, 0, 0, 12, null));
    }

    public final void S(String markdown) {
        Object objB;
        m0(this.markdownTextView.getText());
        if (this.currentMode != RenderMode.TEXT) {
            W0();
        }
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(this.textMarkwon.h(markdown));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        Throwable thE = Result.e(objB);
        if (thE != null) {
            C4148a.t("AIMDTextView", "applyTextMarkdown parse failed", thE, false, 8, null);
            return;
        }
        kotlin.jvm.internal.p.h(objB, "getOrElse(...)");
        Spanned spanned = (Spanned) objB;
        N0(spanned);
        this.textMarkwon.g(this.markdownTextView, spanned);
        this.lastRenderedMarkdown = markdown;
        A0(false);
    }

    public final void S0(int unit, float size) {
        this.contentTextUnit = Integer.valueOf(unit);
        this.contentTextSize = Float.valueOf(size);
        this.markdownTextView.setTextSize(unit, size);
        O();
    }

    public final void T(View view) {
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (kotlin.jvm.internal.p.d(textView.getTag(), CODE_HEADER_TAG)) {
                return;
            }
            if (kotlin.jvm.internal.p.d(textView.getTag(), CODE_TEXT_TAG)) {
                if (textView.getMovementMethod() instanceof LinkMovementMethod) {
                    return;
                }
                textView.setMovementMethod(LinkMovementMethod.getInstance());
                return;
            }
            Integer num = this.contentTextColor;
            if (num != null) {
                textView.setTextColor(num.intValue());
            }
            Integer num2 = this.contentTextUnit;
            Float f10 = this.contentTextSize;
            if (num2 != null && f10 != null) {
                textView.setTextSize(num2.intValue(), f10.floatValue());
            }
            Float f11 = this.contentLineSpacingAdd;
            Float f12 = this.contentLineSpacingMult;
            if (u0(view)) {
                textView.setLineSpacing(0.0f, 1.0f);
            } else if (f11 != null && f12 != null) {
                textView.setLineSpacing(f11.floatValue(), f12.floatValue());
            }
            boolean zIsTextSelectable = textView.isTextSelectable();
            boolean z10 = this.recyclerContentSelectable;
            if (zIsTextSelectable != z10) {
                textView.setTextIsSelectable(z10);
            }
            if (this.recyclerContentSelectable) {
                textView.setLinksClickable(true);
                return;
            } else {
                if (!(textView.getMovementMethod() instanceof LinkMovementMethod)) {
                    textView.setMovementMethod(LinkMovementMethod.getInstance());
                }
                textView.setLinksClickable(true);
            }
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                T(childAt);
            }
        }
    }

    public final boolean T0(String markdown) {
        return Q.INSTANCE.e(markdown);
    }

    public final void U() {
        long jUptimeMillis = SystemClock.uptimeMillis();
        MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
        this.longPressDetector.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final boolean U0(String markdown) {
        return O.INSTANCE.c(markdown);
    }

    public final int[] V() {
        ArrayList arrayList = new ArrayList();
        int childCount = this.markdownRecyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.markdownRecyclerView.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            a0(childAt, arrayList);
        }
        return Z8.F.l1(arrayList);
    }

    public final void V0() {
        RenderMode renderMode = this.currentMode;
        RenderMode renderMode2 = RenderMode.RECYCLER;
        if (renderMode == renderMode2) {
            return;
        }
        this.currentMode = renderMode2;
        this.markdownTextView.setVisibility(8);
        this.markdownRecyclerView.setVisibility(0);
    }

    public final void W() {
        this.plainCodeActive = false;
        this.plainCodeSource = "";
        this.plainCodeLanguage = null;
    }

    public final void W0() {
        RenderMode renderMode = this.currentMode;
        RenderMode renderMode2 = RenderMode.TEXT;
        if (renderMode == renderMode2) {
            return;
        }
        this.currentMode = renderMode2;
        this.markdownTextView.setVisibility(0);
        this.markdownRecyclerView.setVisibility(8);
    }

    public final int X(CharSequence text) {
        ClickableSpan[] clickableSpanArr;
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null || (clickableSpanArr = (ClickableSpan[]) spanned.getSpans(0, text.length(), ClickableSpan.class)) == null) {
            return 0;
        }
        return clickableSpanArr.length;
    }

    public final void X0() {
        if (this.markdownTextView.getVisibility() == 0) {
            getDynamicTypeAnimator().a();
        }
    }

    public final List<String> Y() {
        return SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.S(Regex.f(MARKDOWN_IMAGE_URL_REGEX, this.lastImageSourceMarkdown, 0, 2, null), new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.i
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AIMDTextView.Z((La.m) obj);
            }
        }));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r9v10 */
    /* JADX WARN: Type inference failed for: r9v3, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r9v4 */
    public final void Y0(TableLayout tableLayout) {
        Drawable drawableMutate;
        Drawable drawableMutate2;
        Integer num = this.contentTextColor;
        int iIntValue = num != null ? num.intValue() : this.markdownTextView.getCurrentTextColor();
        TablePalette tablePaletteE1 = e1(iIntValue);
        Drawable drawableE = androidx.core.content.a.e(getContext(), R$drawable.agent_markdown_table_divider);
        if (drawableE == null || (drawableMutate = drawableE.mutate()) == null) {
            drawableMutate = null;
        } else {
            GradientDrawable gradientDrawable = drawableMutate instanceof GradientDrawable ? (GradientDrawable) drawableMutate : null;
            if (gradientDrawable != null) {
                gradientDrawable.setColor(tablePaletteE1.getDivider());
            }
        }
        int i10 = 2;
        tableLayout.setShowDividers(2);
        tableLayout.setDividerDrawable(drawableMutate);
        Drawable drawableE2 = androidx.core.content.a.e(getContext(), R$drawable.agent_markdown_table_outer_top_rounded);
        if (drawableE2 == null || (drawableMutate2 = drawableE2.mutate()) == null) {
            drawableMutate2 = null;
        } else {
            GradientDrawable gradientDrawable2 = drawableMutate2 instanceof GradientDrawable ? (GradientDrawable) drawableMutate2 : null;
            if (gradientDrawable2 != null) {
                gradientDrawable2.setColor(tablePaletteE1.getOuterBackground());
                gradientDrawable2.setStroke(getTableBorderWidthPx(), tablePaletteE1.getDivider());
            }
        }
        tableLayout.setBackground(drawableMutate2);
        tableLayout.setOutlineProvider(ViewOutlineProvider.BACKGROUND);
        boolean z10 = true;
        tableLayout.setClipToOutline(true);
        tableLayout.setClipChildren(true);
        tableLayout.setClipToPadding(true);
        int childCount = tableLayout.getChildCount();
        boolean z11 = false;
        int i11 = 0;
        while (i11 < childCount) {
            View childAt = tableLayout.getChildAt(i11);
            TableRow tableRow = childAt instanceof TableRow ? (TableRow) childAt : null;
            if (tableRow != null) {
                tableRow.setShowDividers(i10);
                tableRow.setDividerDrawable(drawableMutate);
                tableRow.setBackgroundColor(z11 ? 1 : 0);
                int childCount2 = tableRow.getChildCount();
                int i12 = z11 ? 1 : 0;
                ?? r92 = z11;
                while (i12 < childCount2) {
                    View childAt2 = tableRow.getChildAt(i12);
                    TextView textView = childAt2 instanceof TextView ? (TextView) childAt2 : 0;
                    if (textView != 0) {
                        textView.setTextColor(iIntValue);
                        textView.setGravity(8388627);
                        textView.setTextAlignment(5);
                        textView.setTypeface(MarkwonHelper.z0(C2145t.a()));
                        if (!z10 && i12 == 0) {
                            B0(textView);
                            textView.getPaint().setFakeBoldText(r92);
                        }
                        textView.setIncludeFontPadding(!z10);
                        if (z10) {
                            textView.setTextSize(i10, 16.0f);
                        } else {
                            textView.setTextSize(i10, 14.0f);
                        }
                        if (z10) {
                            textView.setBackgroundColor(tablePaletteE1.getHeaderBackground());
                        } else {
                            textView.setBackgroundColor(r92);
                        }
                        textView.setPaddingRelative(getTableCellPaddingStartPx(), getTableCellPaddingTopPx() + (z10 ? g0(2.0f) : r92), getTableCellPaddingEndPx(), getTableCellPaddingBottomPx());
                    }
                    i12++;
                    i10 = 2;
                    r92 = 0;
                }
                z10 = false;
            }
            i11++;
            i10 = 2;
            z11 = false;
        }
        tableLayout.requestLayout();
    }

    public final void a0(View view, List<Integer> offsets) {
        if (view instanceof AgentMarkdownTableHorizontalScrollView) {
            offsets.add(Integer.valueOf(((AgentMarkdownTableHorizontalScrollView) view).getScrollX()));
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                a0(childAt, offsets);
            }
        }
    }

    public final void b0(String markdown) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getRecyclerMarkwon().d(markdown));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Yb.u uVar = (Yb.u) objB;
        if (uVar == null) {
            this.recyclerBlockGaps = new int[0];
            this.recyclerImageOnlyFlags = new boolean[0];
            return;
        }
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        boolean z10 = false;
        for (Yb.u uVarC = uVar.c(); uVarC != null; uVarC = uVarC.e()) {
            if (!(uVarC instanceof Yb.r)) {
                if (arrayList.isEmpty() && (uVarC instanceof Yb.l) && ((Yb.l) uVarC).n() == 1) {
                    z10 = true;
                }
                arrayList.add(uVarC);
                arrayList2.add(Boolean.valueOf(J.INSTANCE.b(uVarC)));
            }
        }
        int iG0 = g0(MarkwonHelper.v());
        int[] iArr = new int[arrayList.size()];
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            Object obj = arrayList.get(i10);
            kotlin.jvm.internal.p.h(obj, "get(...)");
            Yb.u uVar2 = (Yb.u) obj;
            if (i10 == 0) {
                iArr[i10] = (!z10 || this.hasPrecedingContent) ? 0 : iG0;
            } else {
                kotlin.jvm.internal.p.h(arrayList.get(i10 - 1), "get(...)");
                iArr[i10] = g0(MarkdownBlockSpacing.INSTANCE.b((Yb.u) r9, uVar2, this.supplementaryParagraphIndices.contains(Integer.valueOf(i10))));
            }
        }
        this.recyclerBlockGaps = iArr;
        this.recyclerImageOnlyFlags = Z8.F.h1(arrayList2);
    }

    public final boolean c0(String markdown) {
        Iterator<String> it = La.H.E0(markdown).iterator();
        while (it.hasNext()) {
            String string = La.H.H1(it.next()).toString();
            if (La.D.X(string, "```", false, 2, null) || La.D.X(string, "~~~", false, 2, null)) {
                return true;
            }
        }
        return false;
    }

    public final boolean d0(String markdown) {
        if (La.H.g0(markdown, "![", false, 2, null)) {
            return MARKDOWN_IMAGE_REGEX.b(markdown);
        }
        return false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View.OnTouchListener onTouchListener;
        kotlin.jvm.internal.p.i(ev, "ev");
        if (ev.getActionMasked() == 0 && (onTouchListener = this.externalTouchListener) != null) {
            onTouchListener.onTouch(this, ev);
        }
        e0(ev);
        return super.dispatchTouchEvent(ev);
    }

    public final void e0(MotionEvent event) {
        if (event.getActionMasked() != 0 || event.getDownTime() == event.getEventTime()) {
            this.longPressDetector.onTouchEvent(event);
            return;
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(event.getEventTime(), event.getEventTime(), 0, event.getX(), event.getY(), event.getMetaState());
        this.longPressDetector.onTouchEvent(motionEventObtain);
        motionEventObtain.recycle();
    }

    public final TablePalette e1(int textColor) {
        return C5502d.d(C5502d.k(textColor, 255)) >= 0.5d ? new TablePalette(527725696, 352321535, 234881023) : new TablePalette(1308622847, 654311423, 218103808);
    }

    public final boolean f0(MotionEvent ev) {
        Layout layout;
        if (!this.selectionEnabled || this.markdownTextView.hasSelection() || (layout = this.markdownTextView.getLayout()) == null) {
            return false;
        }
        CharSequence text = this.markdownTextView.getText();
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return false;
        }
        this.markdownTextView.getLocationOnScreen(new int[2]);
        float rawX = ((ev.getRawX() - r3[0]) - this.markdownTextView.getTotalPaddingLeft()) + this.markdownTextView.getScrollX();
        float rawY = ((ev.getRawY() - r3[1]) - this.markdownTextView.getTotalPaddingTop()) + this.markdownTextView.getScrollY();
        if (rawY >= 0.0f && rawY <= layout.getHeight()) {
            int lineForVertical = layout.getLineForVertical((int) rawY);
            if (rawX >= layout.getLineLeft(lineForVertical) && rawX <= layout.getLineRight(lineForVertical)) {
                int offsetForHorizontal = layout.getOffsetForHorizontal(lineForVertical, rawX);
                Object[] spans = spanned.getSpans(offsetForHorizontal, offsetForHorizontal, ClickableSpan.class);
                kotlin.jvm.internal.p.h(spans, "getSpans(...)");
                ClickableSpan clickableSpan = (ClickableSpan) Z8.r.Z(spans);
                if (clickableSpan == null) {
                    return false;
                }
                clickableSpan.onClick(this.markdownTextView);
                return true;
            }
        }
        return false;
    }

    public final void f1() {
        Integer num = this.preFreezeHeight;
        if (num != null) {
            int iIntValue = num.intValue();
            this.preFreezeHeight = null;
            boolean z10 = this.layoutRequestedWhileFrozen;
            this.layoutRequestedWhileFrozen = false;
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams == null) {
                return;
            }
            layoutParams.height = iIntValue;
            if (z10) {
                setLayoutParams(layoutParams);
            }
        }
    }

    public final int g0(float dp) {
        return (int) TypedValue.applyDimension(1, dp, getResources().getDisplayMetrics());
    }

    public final C2150y getDynamicTypeAnimator() {
        C2150y c2150y = this.dynamicTypeAnimator;
        if (c2150y != null) {
            return c2150y;
        }
        kotlin.jvm.internal.p.A("dynamicTypeAnimator");
        return null;
    }

    public final boolean getHasPrecedingContent() {
        return this.hasPrecedingContent;
    }

    public final InterfaceC5074l<String, Boolean> getOnLinkClick() {
        return this.onLinkClick;
    }

    public final Set<Integer> getSupplementaryParagraphIndices() {
        return this.supplementaryParagraphIndices;
    }

    public final Integer h0(String target) {
        Object objB;
        try {
            Result.Companion companion = Result.INSTANCE;
            objB = Result.b(getRecyclerMarkwon().d(this.lastRenderedMarkdown));
        } catch (Throwable th) {
            Result.Companion companion2 = Result.INSTANCE;
            objB = Result.b(C4849c.a(th));
        }
        if (Result.g(objB)) {
            objB = null;
        }
        Yb.u uVar = (Yb.u) objB;
        if (uVar == null) {
            return null;
        }
        Yb.u uVarC = uVar.c();
        int i10 = 0;
        while (uVarC != null) {
            if (uVarC instanceof Yb.r) {
                uVarC = ((Yb.r) uVarC).e();
            } else {
                if ((uVarC instanceof Yb.l) && kotlin.jvm.internal.p.d(MarkwonHelper.w0(y0(uVarC)), target)) {
                    return Integer.valueOf(i10);
                }
                i10++;
                uVarC = uVarC.e();
            }
        }
        return null;
    }

    public final RecyclerView i0() {
        Object parent = getParent();
        while (parent != null) {
            if (parent instanceof RecyclerView) {
                return (RecyclerView) parent;
            }
            View view = parent instanceof View ? (View) parent : null;
            parent = view != null ? view.getParent() : null;
        }
        return null;
    }

    public final ViewGroup j0() {
        Object parent = getParent();
        while (parent != null) {
            if ((parent instanceof NestedScrollView) || (parent instanceof ScrollView) || (parent instanceof RecyclerView)) {
                return (ViewGroup) parent;
            }
            View view = parent instanceof View ? (View) parent : null;
            parent = view != null ? view.getParent() : null;
        }
        return null;
    }

    public final void k0() {
        if (this.currentMode != RenderMode.RECYCLER) {
            return;
        }
        String str = this.latestPendingTableMarkdown;
        this.latestPendingTableMarkdown = null;
        if (str == null || str.length() == 0 || kotlin.jvm.internal.p.d(str, this.lastRenderedMarkdown)) {
            return;
        }
        P(str);
    }

    public final void l0() {
        int height;
        ViewGroup.LayoutParams layoutParams;
        if (this.preFreezeHeight == null && (height = getHeight()) > 0 && (layoutParams = getLayoutParams()) != null) {
            this.preFreezeHeight = Integer.valueOf(layoutParams.height);
            this.layoutRequestedWhileFrozen = false;
            layoutParams.height = height;
        }
    }

    public final void m0(CharSequence text) {
        Spanned spanned = text instanceof Spanned ? (Spanned) text : null;
        if (spanned == null) {
            return;
        }
        io.noties.markwon.image.e[] eVarArr = (io.noties.markwon.image.e[]) spanned.getSpans(0, spanned.length(), io.noties.markwon.image.e.class);
        kotlin.jvm.internal.p.f(eVarArr);
        for (io.noties.markwon.image.e eVar : eVarArr) {
            io.noties.markwon.image.a aVarA = eVar.a();
            kotlin.jvm.internal.p.h(aVarA, "getDrawable(...)");
            if (aVarA.h()) {
                String strB = aVarA.b();
                kotlin.jvm.internal.p.h(strB, "getDestination(...)");
                if (t0(strB)) {
                    this.latexResultCache.put(strB, aVarA.g());
                }
            }
        }
    }

    public final void n0() {
        int childCount = this.markdownRecyclerView.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            View childAt = this.markdownRecyclerView.getChildAt(i10);
            kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
            o0(childAt);
        }
    }

    public final void o0(View view) {
        if (view instanceof TextView) {
            m0(((TextView) view).getText());
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i10 = 0; i10 < childCount; i10++) {
                View childAt = viewGroup.getChildAt(i10);
                kotlin.jvm.internal.p.h(childAt, "getChildAt(...)");
                o0(childAt);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RecyclerView recyclerView = this.hostScrollView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.hostScrollListener);
        }
        RecyclerView recyclerViewI0 = i0();
        if (recyclerViewI0 != null) {
            recyclerViewI0.addOnScrollListener(this.hostScrollListener);
        } else {
            recyclerViewI0 = null;
        }
        this.hostScrollView = recyclerViewI0;
        L0();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeCallbacks(this.restoreVisibleContent);
        Runnable runnable = this.pendingUpdate;
        if (runnable != null) {
            this.updateHandler.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.pendingTableUpdate;
        if (runnable2 != null) {
            this.updateHandler.removeCallbacks(runnable2);
        }
        Runnable runnable3 = this.pendingHostIdleFlush;
        if (runnable3 != null) {
            this.updateHandler.removeCallbacks(runnable3);
        }
        this.pendingHostIdleFlush = null;
        RecyclerView recyclerView = this.hostScrollView;
        if (recyclerView != null) {
            recyclerView.removeOnScrollListener(this.hostScrollListener);
        }
        this.hostScrollView = null;
        this.isHostScrolling = false;
        f1();
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return false;
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int visibility) {
        super.onWindowVisibilityChanged(visibility);
        if (visibility == 0) {
            L0();
        } else {
            removeCallbacks(this.restoreVisibleContent);
        }
    }

    public final u8.e p0(boolean useRecyclerTablePlugin) {
        MarkwonHelper markwonHelper = MarkwonHelper.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        return markwonHelper.Z(context, this.markdownTextView, true, useRecyclerTablePlugin, new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.e
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Boolean.valueOf(AIMDTextView.q0(this.f23316a));
            }
        }, new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.f
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return Boolean.valueOf(AIMDTextView.r0(this.f23317a, (Yb.u) obj));
            }
        }, new Consumer() { // from class: com.stepos.agentframework.uikit.g
            @Override // java.util.function.Consumer
            public final void accept(Object obj) {
                AIMDTextView.s0((String) obj);
            }
        });
    }

    @Override // android.view.View, android.view.ViewParent
    public void requestLayout() {
        if (this.preFreezeHeight != null) {
            this.layoutRequestedWhileFrozen = true;
        }
        super.requestLayout();
    }

    public final void setCodeBlockMaxHeight(int px) {
        this.codeEntry.k(Integer.valueOf(px));
    }

    public final void setCodeBlockSelectable(boolean selectable) {
        this.codeEntry.l(selectable);
        this.recyclerContentSelectable = selectable;
        O();
    }

    public final void setDynamicTypeAnimator(C2150y c2150y) {
        kotlin.jvm.internal.p.i(c2150y, "<set-?>");
        this.dynamicTypeAnimator = c2150y;
    }

    public final void setHasPrecedingContent(boolean z10) {
        if (this.hasPrecedingContent == z10) {
            return;
        }
        this.hasPrecedingContent = z10;
        if (this.lastImageSourceMarkdown.length() > 0) {
            this.lastRenderedMarkdown = "";
            setMarkdown(this.lastImageSourceMarkdown);
        }
    }

    public final void setMarkdown(String markdownStr) {
        kotlin.jvm.internal.p.i(markdownStr, "markdownStr");
        W();
        String strK0 = K0(La.w.n(markdownStr));
        if (strK0.length() == 0) {
            return;
        }
        l0 l0Var = null;
        if (strK0.length() > 65536) {
            C4148a.u("AIMDTextView", "markdown too long for display: len=" + strK0.length() + ", truncate to 65536", false, 4, null);
            strK0 = La.K.R1(strK0, 65536) + MARKDOWN_TRUNCATION_SUFFIX;
        }
        this.lastImageSourceMarkdown = strK0;
        if (c0(strK0) || U0(strK0) || d0(strK0)) {
            if (!this.isStreaming && kotlin.jvm.internal.p.d(strK0, this.lastRenderedMarkdown) && this.currentMode == RenderMode.RECYCLER) {
                return;
            }
            l0 l0Var2 = this.streamingReveal;
            if (l0Var2 == null) {
                kotlin.jvm.internal.p.A("streamingReveal");
            } else {
                l0Var = l0Var2;
            }
            l0Var.i();
            V0();
            if (this.isStreaming) {
                C0(strK0);
                return;
            } else {
                P(strK0);
                return;
            }
        }
        if (T0(strK0)) {
            W0();
            if (kotlin.jvm.internal.p.d(strK0, this.lastRenderedMarkdown)) {
                return;
            }
            setPlainTextWithLinks(strK0);
            this.lastRenderedMarkdown = strK0;
            return;
        }
        W0();
        CharSequence text = this.markdownTextView.getText();
        boolean z10 = text == null || text.length() == 0;
        if (!kotlin.jvm.internal.p.d(strK0, this.lastRenderedMarkdown) || z10) {
            if (!this.isStreaming) {
                l0 l0Var3 = this.streamingReveal;
                if (l0Var3 == null) {
                    kotlin.jvm.internal.p.A("streamingReveal");
                } else {
                    l0Var = l0Var3;
                }
                l0Var.i();
                S(strK0);
                return;
            }
            if (z10) {
                l0 l0Var4 = this.streamingReveal;
                if (l0Var4 == null) {
                    kotlin.jvm.internal.p.A("streamingReveal");
                } else {
                    l0Var = l0Var4;
                }
                l0Var.h(strK0);
                return;
            }
            l0 l0Var5 = this.streamingReveal;
            if (l0Var5 == null) {
                kotlin.jvm.internal.p.A("streamingReveal");
            } else {
                l0Var = l0Var5;
            }
            l0Var.e(strK0);
        }
    }

    public final void setMarkdownAllOnce(String markdownStr) {
        kotlin.jvm.internal.p.i(markdownStr, "markdownStr");
        StringBuilder sb2 = new StringBuilder();
        if (markdownStr.length() > 0) {
            C1060i.d(kotlinx.coroutines.d.a(Ua.Y.c()), null, null, new AnonymousClass1(markdownStr, sb2, this, null), 3, null);
        }
    }

    public final void setOnLinkClick(InterfaceC5074l<? super String, Boolean> interfaceC5074l) {
        this.onLinkClick = interfaceC5074l;
    }

    @Override // android.view.View
    public void setOnLongClickListener(View.OnLongClickListener l10) {
        this.externalLongClickListener = l10;
        super.setOnLongClickListener(l10);
    }

    @Override // android.view.View
    public void setOnTouchListener(View.OnTouchListener l10) {
        this.externalTouchListener = l10;
        super.setOnTouchListener(l10);
        this.markdownTextView.setOnTouchListener(l10);
        this.markdownRecyclerView.setOnTouchListener(l10);
    }

    public final void setSelectionEnabled(boolean enabled) {
        this.selectionEnabled = enabled;
        this.markdownTextView.setTextIsSelectable(enabled);
        this.markdownTextView.setMovementMethod(LinkMovementMethod.getInstance());
        boolean z10 = true;
        this.markdownTextView.setLinksClickable(true);
        AppCompatTextView appCompatTextView = this.markdownTextView;
        if (!enabled && this.externalLongClickListener == null) {
            z10 = false;
        }
        appCompatTextView.setLongClickable(z10);
    }

    public final void setStreaming(boolean streaming) {
        if (this.isStreaming == streaming) {
            return;
        }
        this.isStreaming = streaming;
        l0 l0Var = null;
        if (streaming) {
            l0 l0Var2 = this.streamingReveal;
            if (l0Var2 == null) {
                kotlin.jvm.internal.p.A("streamingReveal");
            } else {
                l0Var = l0Var2;
            }
            l0Var.i();
            return;
        }
        l0 l0Var3 = this.streamingReveal;
        if (l0Var3 == null) {
            kotlin.jvm.internal.p.A("streamingReveal");
        } else {
            l0Var = l0Var3;
        }
        l0Var.d();
    }

    public final void setSupplementaryParagraphIndices(Set<Integer> value) {
        kotlin.jvm.internal.p.i(value, "value");
        ArrayList arrayList = new ArrayList();
        for (Object obj : value) {
            if (((Number) obj).intValue() >= 0) {
                arrayList.add(obj);
            }
        }
        Set<Integer> setR1 = Z8.F.r1(arrayList);
        if (kotlin.jvm.internal.p.d(this.supplementaryParagraphIndices, setR1)) {
            return;
        }
        this.supplementaryParagraphIndices = setR1;
        if (this.lastImageSourceMarkdown.length() > 0) {
            this.lastRenderedMarkdown = "";
            setMarkdown(this.lastImageSourceMarkdown);
        }
    }

    public final void setTableHorizontalScrollEnabled(boolean enabled) {
        this.tableHorizontalScrollEnabled = enabled;
        O();
    }

    public final void setTextColor(int color) {
        this.contentTextColor = Integer.valueOf(color);
        this.markdownTextView.setTextColor(color);
        O();
    }

    public final boolean t0(String destination) {
        return (destination == null || destination.length() == 0 || La.D.X(destination, "http", false, 2, null) || La.D.X(destination, "content:", false, 2, null) || La.D.X(destination, "file:", false, 2, null) || La.D.X(destination, "/", false, 2, null)) ? false : true;
    }

    public final boolean u0(View view) {
        int childAdapterPosition;
        View viewFindContainingItemView = this.markdownRecyclerView.findContainingItemView(view);
        if (viewFindContainingItemView == null || (childAdapterPosition = this.markdownRecyclerView.getChildAdapterPosition(viewFindContainingItemView)) == -1) {
            return false;
        }
        boolean[] zArr = this.recyclerImageOnlyFlags;
        return childAdapterPosition >= 0 && childAdapterPosition < zArr.length && zArr[childAdapterPosition];
    }

    public final MarkdownBlockSpacing.Kind v0(boolean first) {
        MarkdownBlockSpacing.Kind kindF;
        Pair<? extends MarkdownBlockSpacing.Kind, ? extends MarkdownBlockSpacing.Kind> pairA;
        if (!kotlin.jvm.internal.p.d(this.spacingSource, this.lastImageSourceMarkdown)) {
            String str = this.lastImageSourceMarkdown;
            this.spacingSource = str;
            Yb.u uVarD = this.textMarkwon.d(str);
            kotlin.jvm.internal.p.h(uVarD, "parse(...)");
            List listD0 = SequencesKt___SequencesKt.d0(SequencesKt___SequencesKt.G(Ka.t.q(uVarD.c(), new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.a
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return AIMDTextView.w0((Yb.u) obj);
                }
            }), new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.j
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return Boolean.valueOf(AIMDTextView.x0((Yb.u) obj));
                }
            }));
            if (listD0.isEmpty()) {
                pairA = null;
            } else {
                MarkdownBlockSpacing markdownBlockSpacing = MarkdownBlockSpacing.INSTANCE;
                pairA = Y8.j.a(markdownBlockSpacing.f((Yb.u) Z8.F.q0(listD0)), markdownBlockSpacing.f((Yb.u) Z8.F.C0(listD0)));
            }
            this.spacingBoundaryKinds = pairA;
        }
        Pair<? extends MarkdownBlockSpacing.Kind, ? extends MarkdownBlockSpacing.Kind> pair = this.spacingBoundaryKinds;
        if (first) {
            if (pair == null) {
                return null;
            }
            kindF = pair.e();
        } else {
            if (pair == null) {
                return null;
            }
            kindF = pair.f();
        }
        return kindF;
    }

    public final String y0(Yb.u n10) {
        StringBuilder sb2 = new StringBuilder();
        for (Yb.u uVarC = n10.c(); uVarC != null; uVarC = uVarC.e()) {
            if (uVarC instanceof Yb.z) {
                sb2.append(((Yb.z) uVarC).m());
            } else if (uVarC instanceof Yb.e) {
                sb2.append(((Yb.e) uVarC).m());
            } else {
                sb2.append(y0(uVarC));
            }
        }
        return sb2.toString();
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AIMDTextView(Context context, AttributeSet attributeSet, int i10) {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        this.longPressDetector = new GestureDetector(context, new h());
        this.recyclerMarkwon = C4848b.a(LazyThreadSafetyMode.NONE, new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.k
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return AIMDTextView.z0(this.f23321a);
            }
        });
        C2146u c2146u = new C2146u();
        this.codeEntry = c2146u;
        Handler handler = new Handler(Looper.getMainLooper());
        this.updateHandler = handler;
        this.currentMode = RenderMode.TEXT;
        this.lastRenderedMarkdown = "";
        this.restoreVisibleContent = new Runnable() { // from class: com.stepos.agentframework.uikit.l
            @Override // java.lang.Runnable
            public final void run() {
                AIMDTextView.J0(this.f23323a);
            }
        };
        this.plainCodeSource = "";
        this.lastImageSourceMarkdown = "";
        this.supplementaryParagraphIndices = Z8.Y.e();
        this.hostScrollListener = new g();
        this.latexResultCache = new LruCache<>(64);
        this.selectionEnabled = true;
        this.tableHorizontalScrollEnabled = true;
        this.tableCellPaddingStartPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.m
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(AIMDTextView.c1(this.f23324a));
            }
        });
        this.tableCellPaddingTopPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.n
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(AIMDTextView.d1(this.f23325a));
            }
        });
        this.tableCellPaddingEndPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.o
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(AIMDTextView.b1(this.f23326a));
            }
        });
        this.tableCellPaddingBottomPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.p
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(AIMDTextView.a1(this.f23327a));
            }
        });
        this.tableBorderWidthPx = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.uikit.q
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return Integer.valueOf(AIMDTextView.Z0(this.f23328a));
            }
        });
        this.recyclerBlockGaps = new int[0];
        this.recyclerImageOnlyFlags = new boolean[0];
        AppCompatTextView appCompatTextView = new AppCompatTextView(context);
        appCompatTextView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        appCompatTextView.setTextIsSelectable(true);
        appCompatTextView.setMovementMethod(LinkMovementMethod.getInstance());
        appCompatTextView.setLinksClickable(true);
        appCompatTextView.setSaveEnabled(false);
        appCompatTextView.setLayerType(0, null);
        this.markdownTextView = appCompatTextView;
        addView(appCompatTextView);
        RecyclerView recyclerView = new RecyclerView(context);
        recyclerView.setLayoutParams(new FrameLayout.LayoutParams(-1, -2));
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setItemAnimator(null);
        recyclerView.setSaveEnabled(false);
        recyclerView.setVisibility(8);
        recyclerView.addOnChildAttachStateChangeListener(new a());
        recyclerView.addOnScrollListener(new b());
        recyclerView.addItemDecoration(new c());
        this.markdownRecyclerView = recyclerView;
        addView(recyclerView);
        K8.a aVarBuild = K8.a.d(R$layout.agent_markdown_default_entry).a(Yb.j.class, c2146u).a(Rb.a.class, L8.b.h(new b.c() { // from class: com.stepos.agentframework.uikit.r
            @Override // L8.b.c
            public final void a(b.InterfaceC0074b interfaceC0074b) {
                AIMDTextView.s(interfaceC0074b);
            }
        })).build();
        kotlin.jvm.internal.p.h(aVarBuild, "build(...)");
        this.markdownAdapter = aVarBuild;
        recyclerView.setAdapter(aVarBuild);
        u8.e eVarP0 = p0(false);
        this.textMarkwon = eVarP0;
        setDynamicTypeAnimator(new C2150y(eVarP0, appCompatTextView));
        this.streamingReveal = new l0(appCompatTextView, handler, new InterfaceC5074l() { // from class: com.stepos.agentframework.uikit.b
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return AIMDTextView.t(this.f23311a, (String) obj);
            }
        });
    }

    public /* synthetic */ AIMDTextView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }
}
