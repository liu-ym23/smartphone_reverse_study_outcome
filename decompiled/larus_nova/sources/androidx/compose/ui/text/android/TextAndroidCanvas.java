package androidx.compose.ui.text.android;

import android.graphics.Bitmap;
import android.graphics.BlendMode;
import android.graphics.Canvas;
import android.graphics.DrawFilter;
import android.graphics.Matrix;
import android.graphics.NinePatch;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Picture;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RenderNode;
import android.graphics.fonts.Font;
import android.graphics.text.MeasuredText;
import com.amap.api.col.s.ce;
import com.bytedance.android.livesdkapi.depend.live.ILiveRoomPlayFragmentConstant;
import com.bytedance.ee.bear.doc.follow.impl.rn.RNParamRegisterEventHandler;
import com.facebook.imagepipeline.common.SimplayerImageStrategy;
import com.lynx.jsbridge.LynxResourceModule;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.cert.manager.constants.BytedCertConstant;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;

/* JADX INFO: loaded from: classes17.dex */
@Metadata(d1 = {"\u0000ä\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u0015\n\u0002\b\u000b\n\u0002\u0010\u0014\n\u0002\b\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0019\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\r\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J%\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00012\u0012\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\r0\u0010H\u0086\bJ\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0012\u0010\u0015\u001a\u00020\r2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\b\u0010\u0018\u001a\u00020\rH\u0017J\b\u0010\u0019\u001a\u00020\rH\u0017J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\b\u0010\u001b\u001a\u00020\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001cH\u0016J\b\u0010\u001e\u001a\u00020\u001cH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u001cH\u0016J\b\u0010!\u001a\u00020\u001cH\u0016J\b\u0010\"\u001a\u00020\u001cH\u0016J\b\u0010#\u001a\u00020\u001cH\u0016J$\u0010$\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u001cH\u0017J\u001c\u0010$\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J:\u0010$\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020\u001cH\u0017J2\u0010$\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\"\u0010.\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001cH\u0017J\u001a\u0010.\u001a\u00020\u001c2\b\u0010\u0013\u001a\u0004\u0018\u00010%2\u0006\u0010/\u001a\u00020\u001cH\u0016J8\u0010.\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010/\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020\u001cH\u0017J0\u0010.\u001a\u00020\u001c2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010/\u001a\u00020\u001cH\u0016J\b\u00100\u001a\u00020\rH\u0016J\b\u00101\u001a\u00020\u001cH\u0016J\u0010\u00102\u001a\u00020\r2\u0006\u00103\u001a\u00020\u001cH\u0016J\u0018\u00104\u001a\u00020\r2\u0006\u00105\u001a\u00020*2\u0006\u00106\u001a\u00020*H\u0016J\u0018\u00107\u001a\u00020\r2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*H\u0016J\u0010\u0010:\u001a\u00020\r2\u0006\u0010;\u001a\u00020*H\u0016J\u0018\u0010<\u001a\u00020\r2\u0006\u00108\u001a\u00020*2\u0006\u00109\u001a\u00020*H\u0016J\u0012\u0010=\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0012\u0010@\u001a\u00020\r2\b\u0010>\u001a\u0004\u0018\u00010?H\u0016J\u0010\u0010A\u001a\u00020\r2\u0006\u0010B\u001a\u00020?H\u0017J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%2\u0006\u0010E\u001a\u00020FH\u0017J\u0018\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u00142\u0006\u0010E\u001a\u00020FH\u0017J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%H\u0016J\u0010\u0010C\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u0014H\u0016J0\u0010C\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010E\u001a\u00020FH\u0017J(\u0010C\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0016J(\u0010C\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0016J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%H\u0017J\u0010\u0010G\u001a\u00020\u00122\u0006\u0010D\u001a\u00020\u0014H\u0017J(\u0010G\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0017J(\u0010G\u001a\u00020\u00122\u0006\u0010)\u001a\u00020\u001c2\u0006\u0010+\u001a\u00020\u001c2\u0006\u0010,\u001a\u00020\u001c2\u0006\u0010-\u001a\u00020\u001cH\u0017J\u0018\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020J2\u0006\u0010E\u001a\u00020FH\u0017J\u0010\u0010H\u001a\u00020\u00122\u0006\u0010I\u001a\u00020JH\u0016J\u0010\u0010K\u001a\u00020\u00122\u0006\u0010I\u001a\u00020JH\u0017J\n\u0010L\u001a\u0004\u0018\u00010MH\u0016J\u0012\u0010N\u001a\u00020\r2\b\u0010O\u001a\u0004\u0018\u00010MH\u0016J\u0018\u0010P\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%2\u0006\u0010Q\u001a\u00020RH\u0017J\u0010\u0010P\u001a\u00020\u00122\u0006\u0010D\u001a\u00020%H\u0017J\u0018\u0010P\u001a\u00020\u00122\u0006\u0010I\u001a\u00020J2\u0006\u0010Q\u001a\u00020RH\u0017J\u0010\u0010P\u001a\u00020\u00122\u0006\u0010I\u001a\u00020JH\u0017J0\u0010P\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010Q\u001a\u00020RH\u0017J(\u0010P\u001a\u00020\u00122\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*H\u0017J\u0010\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020UH\u0016J\u0018\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020%H\u0016J\u0018\u0010S\u001a\u00020\r2\u0006\u0010T\u001a\u00020U2\u0006\u0010V\u001a\u00020\u0014H\u0016J0\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020%2\u0006\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0016JH\u0010W\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010Y\u001a\u00020*2\u0006\u0010Z\u001a\u00020*2\u0006\u0010[\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0016J(\u0010\\\u001a\u00020\r2\u0006\u0010]\u001a\u00020\u001c2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u001cH\u0016J*\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J,\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010b\u001a\u0004\u0018\u00010\u00142\u0006\u0010V\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J,\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010b\u001a\u0004\u0018\u00010\u00142\u0006\u0010V\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'H\u0016JR\u0010a\u001a\u00020\r2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010i\u001a\u00020\u001c2\u0006\u0010j\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0017JR\u0010a\u001a\u00020\r2\u0006\u0010c\u001a\u00020d2\u0006\u0010e\u001a\u00020\u001c2\u0006\u0010f\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020\u001c2\u0006\u0010h\u001a\u00020\u001c2\u0006\u0010i\u001a\u00020\u001c2\u0006\u0010j\u001a\u00020\u001c2\u0006\u0010k\u001a\u00020\u00122\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\"\u0010a\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010>\u001a\u00020?2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016JL\u0010l\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010m\u001a\u00020\u001c2\u0006\u0010n\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u001c2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010r\u001a\u00020\u001c2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J(\u0010s\u001a\u00020\r2\u0006\u0010t\u001a\u00020*2\u0006\u0010u\u001a\u00020*2\u0006\u0010v\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J\u0010\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u001cH\u0016J\u0010\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020yH\u0017J\u0018\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020{H\u0016J\u0018\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020\u001c2\u0006\u0010z\u001a\u00020|H\u0017J\u0018\u0010w\u001a\u00020\r2\u0006\u0010x\u001a\u00020y2\u0006\u0010z\u001a\u00020|H\u0017J2\u0010}\u001a\u00020\r2\u0006\u0010~\u001a\u00020*2\u0006\u0010\u007f\u001a\u00020*2\u0007\u0010\u0080\u0001\u001a\u00020*2\u0007\u0010\u0081\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J+\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020p2\u0006\u0010e\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010\u0082\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0016J\u0019\u0010\u0085\u0001\u001a\u00020\r2\u0006\u0010X\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J1\u0010\u0085\u0001\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J\u0011\u0010\u0086\u0001\u001a\u00020\r2\u0006\u0010&\u001a\u00020'H\u0016J%\u0010\u0087\u0001\u001a\u00020\r2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010V\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J%\u0010\u0087\u0001\u001a\u00020\r2\b\u0010\u0088\u0001\u001a\u00030\u0089\u00012\u0006\u0010V\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0017J\u0019\u0010\u008a\u0001\u001a\u00020\r2\u0006\u0010I\u001a\u00020J2\u0006\u0010&\u001a\u00020'H\u0016J!\u0010\u008b\u0001\u001a\u00020\r2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J-\u0010\u008c\u0001\u001a\u00020\r2\t\u0010\u0083\u0001\u001a\u0004\u0018\u00010p2\u0006\u0010e\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u001a\u0010\u008c\u0001\u001a\u00020\r2\u0007\u0010\u0083\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0016J6\u0010\u008d\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0007\u0010\u0091\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0017J$\u0010\u008d\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0007\u0010\u0091\u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0017J\u0019\u0010\u0093\u0001\u001a\u00020\r2\u0006\u0010D\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0016J\u0019\u0010\u0093\u0001\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u00142\u0006\u0010&\u001a\u00020'H\u0016J1\u0010\u0093\u0001\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J!\u0010\u0094\u0001\u001a\u00020\r2\u0006\u0010^\u001a\u00020\u001c2\u0006\u0010_\u001a\u00020\u001c2\u0006\u0010`\u001a\u00020\u001cH\u0016J+\u0010\u0095\u0001\u001a\u00020\r2\u0006\u0010D\u001a\u00020%2\u0007\u0010\u0096\u0001\u001a\u00020*2\u0007\u0010\u0097\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JC\u0010\u0095\u0001\u001a\u00020\r2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020*2\u0006\u0010,\u001a\u00020*2\u0006\u0010-\u001a\u00020*2\u0007\u0010\u0096\u0001\u001a\u00020*2\u0007\u0010\u0097\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JG\u0010\u0098\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020%2\u0007\u0010\u009a\u0001\u001a\u00020*2\u0007\u0010\u009b\u0001\u001a\u00020*2\u0007\u0010\u009c\u0001\u001a\u00020%2\u0007\u0010\u009d\u0001\u001a\u00020*2\u0007\u0010\u009e\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0017J5\u0010\u0098\u0001\u001a\u00020\r2\u0007\u0010\u0099\u0001\u001a\u00020%2\u0007\u0010\u009f\u0001\u001a\u00020p2\u0007\u0010\u009c\u0001\u001a\u00020%2\u0007\u0010 \u0001\u001a\u00020p2\u0006\u0010&\u001a\u00020'H\u0017JH\u0010¡\u0001\u001a\u00020\r2\u0007\u0010¢\u0001\u001a\u00020d2\u0007\u0010£\u0001\u001a\u00020\u001c2\u0007\u0010¤\u0001\u001a\u00020p2\u0007\u0010¥\u0001\u001a\u00020\u001c2\u0007\u0010¦\u0001\u001a\u00020\u001c2\b\u0010§\u0001\u001a\u00030¨\u00012\u0006\u0010&\u001a\u00020'H\u0017J=\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J+\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J=\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J=\u0010©\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030¬\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JG\u0010\u00ad\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0006\u0010I\u001a\u00020J2\u0007\u0010®\u0001\u001a\u00020*2\u0007\u0010¯\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016J5\u0010\u00ad\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u0092\u00012\u0006\u0010I\u001a\u00020J2\u0007\u0010®\u0001\u001a\u00020*2\u0007\u0010¯\u0001\u001a\u00020*2\u0006\u0010&\u001a\u00020'H\u0016JX\u0010°\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030\u008f\u00012\u0007\u0010\u0090\u0001\u001a\u00020\u001c2\u0007\u0010\u0084\u0001\u001a\u00020\u001c2\u0007\u0010±\u0001\u001a\u00020\u001c2\u0007\u0010²\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0007\u0010³\u0001\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017JX\u0010°\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030¬\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0007\u0010´\u0001\u001a\u00020\u001c2\u0007\u0010µ\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0007\u0010³\u0001\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017JX\u0010°\u0001\u001a\u00020\r2\b\u0010\u008e\u0001\u001a\u00030¶\u00012\u0007\u0010ª\u0001\u001a\u00020\u001c2\u0007\u0010«\u0001\u001a\u00020\u001c2\u0007\u0010´\u0001\u001a\u00020\u001c2\u0007\u0010µ\u0001\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020*2\u0006\u0010h\u001a\u00020*2\u0007\u0010³\u0001\u001a\u00020\u00122\u0006\u0010&\u001a\u00020'H\u0017Jw\u0010·\u0001\u001a\u00020\r2\u0007\u0010z\u001a\u00030¸\u00012\u0007\u0010¹\u0001\u001a\u00020\u001c2\u0006\u0010o\u001a\u00020p2\u0006\u0010q\u001a\u00020\u001c2\t\u0010º\u0001\u001a\u0004\u0018\u00010p2\u0007\u0010»\u0001\u001a\u00020\u001c2\b\u0010c\u001a\u0004\u0018\u00010d2\u0006\u0010r\u001a\u00020\u001c2\n\u0010¼\u0001\u001a\u0005\u0018\u00010½\u00012\u0007\u0010¾\u0001\u001a\u00020\u001c2\u0007\u0010¿\u0001\u001a\u00020\u001c2\u0006\u0010&\u001a\u00020'H\u0016J\u0013\u0010À\u0001\u001a\u00020\r2\b\u0010Á\u0001\u001a\u00030Â\u0001H\u0017R&\u0010\u0004\u001a\u0004\u0018\u00010\u00018\u0000@\u0000X\u0081\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0003\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0014\u0010\n\u001a\u00020\u00018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\u0007¨\u0006Ã\u0001"}, d2 = {"Landroidx/compose/ui/text/android/TextAndroidCanvas;", "Landroid/graphics/Canvas;", "<init>", "()V", "_nativeCanvas", "get_nativeCanvas$ui_text$annotations", "get_nativeCanvas$ui_text", "()Landroid/graphics/Canvas;", "set_nativeCanvas$ui_text", "(Landroid/graphics/Canvas;)V", "nativeCanvas", "getNativeCanvas", "withCanvas", "", "canvas", "block", "Lkotlin/Function1;", "getClipBounds", "", "bounds", "Landroid/graphics/Rect;", "setBitmap", SimplayerImageStrategy.RESULT_BITMAP, "Landroid/graphics/Bitmap;", "enableZ", "disableZ", "isOpaque", "getWidth", "", "getHeight", "getDensity", "setDensity", "density", "getMaximumBitmapWidth", "getMaximumBitmapHeight", SVGRenderEngine.SAVE, "saveLayer", "Landroid/graphics/RectF;", "paint", "Landroid/graphics/Paint;", "saveFlags", "left", "", "top", "right", "bottom", "saveLayerAlpha", "alpha", SVGRenderEngine.RESTORE, "getSaveCount", "restoreToCount", "saveCount", "translate", "dx", "dy", "scale", "sx", "sy", "rotate", "degrees", "skew", "concat", "matrix", "Landroid/graphics/Matrix;", "setMatrix", "getMatrix", "ctm", "clipRect", SVGRenderEngine.RECT, "op", "Landroid/graphics/Region$Op;", "clipOutRect", SVGRenderEngine.CLIP_PATH, "path", "Landroid/graphics/Path;", "clipOutPath", "getDrawFilter", "Landroid/graphics/DrawFilter;", "setDrawFilter", "filter", "quickReject", "type", "Landroid/graphics/Canvas$EdgeType;", "drawPicture", "picture", "Landroid/graphics/Picture;", "dst", "drawArc", "oval", "startAngle", "sweepAngle", "useCenter", "drawARGB", BytedCertConstant.ReflectionConfigKey.COLOR_ARRAY, "r", ce.f26391f, "b", "drawBitmap", "src", "colors", "", "offset", "stride", "x", "y", "width", "height", "hasAlpha", "drawBitmapMesh", "meshWidth", "meshHeight", "verts", "", "vertOffset", "colorOffset", "drawCircle", "cx", "cy", "radius", "drawColor", "color", "", "mode", "Landroid/graphics/PorterDuff$Mode;", "Landroid/graphics/BlendMode;", "drawLine", "startX", "startY", "stopX", "stopY", "drawLines", "pts", "count", "drawOval", "drawPaint", "drawPatch", "patch", "Landroid/graphics/NinePatch;", "drawPath", "drawPoint", "drawPoints", "drawPosText", "text", "", "index", ILiveRoomPlayFragmentConstant.EXTRA_ROOM_POSITION, "", "drawRect", "drawRGB", "drawRoundRect", "rx", "ry", "drawDoubleRoundRect", RNParamRegisterEventHandler.SRC_OUTER, "outerRx", "outerRy", RNParamRegisterEventHandler.SRC_INNER, "innerRx", "innerRy", "outerRadii", "innerRadii", "drawGlyphs", "glyphIds", "glyphIdOffset", "positions", "positionOffset", "glyphCount", LynxResourceModule.FONT_TYPE, "Landroid/graphics/fonts/Font;", "drawText", "start", "end", "", "drawTextOnPath", "hOffset", "vOffset", "drawTextRun", "contextIndex", "contextCount", "isRtl", "contextStart", "contextEnd", "Landroid/graphics/text/MeasuredText;", "drawVertices", "Landroid/graphics/Canvas$VertexMode;", "vertexCount", "texs", "texOffset", "indices", "", "indexOffset", "indexCount", "drawRenderNode", "renderNode", "Landroid/graphics/RenderNode;", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TextAndroidCanvas extends Canvas {
    public static final int $stable = 8;
    private Canvas _nativeCanvas;

    public static /* synthetic */ void get_nativeCanvas$ui_text$annotations() {
    }

    private final Canvas getNativeCanvas() {
        Canvas r100 = this._nativeCanvas;
        if (r100 == null) goto L6;
        return r100;
    L6:
        throw new IllegalStateException("Text drawing wrapper is missing a Canvas!".toString());
    }

    @Override // android.graphics.Canvas
    public void disableZ() {
        CanvasCompatQ.INSTANCE.disableZ(getNativeCanvas());
    }

    @Override // android.graphics.Canvas
    public void enableZ() {
        CanvasCompatQ.INSTANCE.enableZ(getNativeCanvas());
    }

    @Override // android.graphics.Canvas
    public int getDensity() {
        return getNativeCanvas().getDensity();
    }

    @Override // android.graphics.Canvas
    public DrawFilter getDrawFilter() {
        return getNativeCanvas().getDrawFilter();
    }

    @Override // android.graphics.Canvas
    public int getHeight() {
        return getNativeCanvas().getHeight();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapHeight() {
        return getNativeCanvas().getMaximumBitmapHeight();
    }

    @Override // android.graphics.Canvas
    public int getMaximumBitmapWidth() {
        return getNativeCanvas().getMaximumBitmapWidth();
    }

    @Override // android.graphics.Canvas
    public int getSaveCount() {
        return getNativeCanvas().getSaveCount();
    }

    @Override // android.graphics.Canvas
    public int getWidth() {
        return getNativeCanvas().getWidth();
    }

    @Override // android.graphics.Canvas
    public boolean isOpaque() {
        return getNativeCanvas().isOpaque();
    }

    @Override // android.graphics.Canvas
    public void restore() {
        getNativeCanvas().restore();
    }

    @Override // android.graphics.Canvas
    public int save() {
        return getNativeCanvas().save();
    }

    public TextAndroidCanvas() {
    }

    public final Canvas get_nativeCanvas$ui_text() {
        return this._nativeCanvas;
    }

    @Override // android.graphics.Canvas
    public boolean clipOutPath(Path r100) {
        return CanvasCompatO.INSTANCE.clipOutPath(getNativeCanvas(), r100);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(Rect r100) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), r100);
    }

    @Override // android.graphics.Canvas
    public boolean clipPath(Path r100) {
        return getNativeCanvas().clipPath(r100);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(Rect r100) {
        return getNativeCanvas().clipRect(r100);
    }

    @Override // android.graphics.Canvas
    public void concat(Matrix r100) {
        getNativeCanvas().concat(r100);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long r100) {
        CanvasCompatQ.INSTANCE.drawColor(getNativeCanvas(), r100);
    }

    @Override // android.graphics.Canvas
    public void drawPaint(Paint r100) {
        getNativeCanvas().drawPaint(r100);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture r100) {
        getNativeCanvas().drawPicture(r100);
    }

    @Override // android.graphics.Canvas
    public void drawRenderNode(RenderNode r100) {
        CanvasCompatQ.INSTANCE.drawRenderNode(getNativeCanvas(), r100);
    }

    @Override // android.graphics.Canvas
    public boolean getClipBounds(Rect r100) {
        boolean r101 = getNativeCanvas().getClipBounds(r100);
        if (r101 == false) goto L5;
        r100.set(0, 0, r100.width(), Integer.MAX_VALUE);
    L5:
        return r101;
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void getMatrix(Matrix r100) {
        getNativeCanvas().getMatrix(r100);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(Path r100) {
        return CanvasCompatR.INSTANCE.quickReject(getNativeCanvas(), r100);
    }

    @Override // android.graphics.Canvas
    public void restoreToCount(int r100) {
        getNativeCanvas().restoreToCount(r100);
    }

    @Override // android.graphics.Canvas
    public void rotate(float r100) {
        getNativeCanvas().rotate(r100);
    }

    @Override // android.graphics.Canvas
    public void setBitmap(Bitmap r100) {
        getNativeCanvas().setBitmap(r100);
    }

    @Override // android.graphics.Canvas
    public void setDensity(int r100) {
        getNativeCanvas().setDensity(r100);
    }

    @Override // android.graphics.Canvas
    public void setDrawFilter(DrawFilter r100) {
        getNativeCanvas().setDrawFilter(r100);
    }

    @Override // android.graphics.Canvas
    public void setMatrix(Matrix r100) {
        getNativeCanvas().setMatrix(r100);
    }

    public final void set_nativeCanvas$ui_text(Canvas r100) {
        this._nativeCanvas = r100;
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(RectF r100) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), r100);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(RectF r100) {
        return getNativeCanvas().clipRect(r100);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int r100) {
        getNativeCanvas().drawColor(r100);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(RectF r100) {
        return CanvasCompatR.INSTANCE.quickReject(getNativeCanvas(), r100);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipPath(Path r100, Region.Op r101) {
        return getNativeCanvas().clipPath(r100, r101);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(Rect r100, Region.Op r101) {
        return getNativeCanvas().clipRect(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int r100, BlendMode r101) {
        CanvasCompatQ.INSTANCE.drawColor(getNativeCanvas(), r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] r100, Paint r101) {
        getNativeCanvas().drawLines(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawOval(RectF r100, Paint r101) {
        getNativeCanvas().drawOval(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawPath(Path r100, Paint r101) {
        getNativeCanvas().drawPath(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture r100, Rect r101) {
        getNativeCanvas().drawPicture(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] r100, Paint r101) {
        getNativeCanvas().drawPoints(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawRect(Rect r100, Paint r101) {
        getNativeCanvas().drawRect(r100, r101);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(Path r100, Canvas.EdgeType r101) {
        return getNativeCanvas().quickReject(r100, r101);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(RectF r100, Paint r101) {
        return getNativeCanvas().saveLayer(r100, r101);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(RectF r100, int r101) {
        return getNativeCanvas().saveLayerAlpha(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void scale(float r100, float r101) {
        getNativeCanvas().scale(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void skew(float r100, float r101) {
        getNativeCanvas().skew(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void translate(float r100, float r101) {
        getNativeCanvas().translate(r100, r101);
    }

    public final void withCanvas(Canvas r100, Function1<? super Canvas, Unit> r101) {
        set_nativeCanvas$ui_text(r100);
        r101.invoke(this);     // Catch: Throwable -> L6
        InlineMarker.finallyStart(1);
        set_nativeCanvas$ui_text(null);
        InlineMarker.finallyEnd(1);
        return;
    L6:
        th = move-exception;
        InlineMarker.finallyStart(1);
        set_nativeCanvas$ui_text(null);
        InlineMarker.finallyEnd(1);
        throw th;
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(RectF r100, Region.Op r101) {
        return getNativeCanvas().clipRect(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawColor(long r100, BlendMode r101) {
        CanvasCompatQ.INSTANCE.drawColor(getNativeCanvas(), r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawPicture(Picture r100, RectF r101) {
        getNativeCanvas().drawPicture(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawRect(RectF r100, Paint r101) {
        getNativeCanvas().drawRect(r100, r101);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(RectF r100, Canvas.EdgeType r101) {
        return getNativeCanvas().quickReject(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawColor(int r100, PorterDuff.Mode r101) {
        getNativeCanvas().drawColor(r100, r101);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap r100, Matrix r101, Paint r102) {
        getNativeCanvas().drawBitmap(r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch r100, Rect r101, Paint r102) {
        CanvasCompatS.INSTANCE.drawPatch(getNativeCanvas(), r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    public void drawPoint(float r100, float r101, Paint r102) {
        getNativeCanvas().drawPoint(r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(String r100, float[] r101, Paint r102) {
        getNativeCanvas().drawPosText(r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    public void drawRGB(int r100, int r101, int r102) {
        getNativeCanvas().drawRGB(r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(RectF r100, Paint r101, int r102) {
        return getNativeCanvas().saveLayer(r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(RectF r100, int r101, int r102) {
        return getNativeCanvas().saveLayerAlpha(r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    public void drawPatch(NinePatch r100, RectF r101, Paint r102) {
        CanvasCompatS.INSTANCE.drawPatch(getNativeCanvas(), r100, r101, r102);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(float r100, float r101, float r102, float r110) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), r100, r101, r102, r110);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(float r100, float r101, float r102, float r103) {
        return getNativeCanvas().clipRect(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawARGB(int r100, int r101, int r102, int r103) {
        getNativeCanvas().drawARGB(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap r100, float r101, float r102, Paint r103) {
        getNativeCanvas().drawBitmap(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawCircle(float r100, float r101, float r102, Paint r103) {
        getNativeCanvas().drawCircle(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawLines(float[] r100, int r101, int r102, Paint r103) {
        getNativeCanvas().drawLines(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawPoints(float[] r100, int r101, int r102, Paint r103) {
        getNativeCanvas().drawPoints(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(RectF r100, float r101, float r102, Paint r103) {
        getNativeCanvas().drawRoundRect(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawText(String r100, float r101, float r102, Paint r103) {
        getNativeCanvas().drawText(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public boolean quickReject(float r100, float r101, float r102, float r110) {
        return CanvasCompatR.INSTANCE.quickReject(getNativeCanvas(), r100, r101, r102, r110);
    }

    @Override // android.graphics.Canvas
    public boolean clipOutRect(int r100, int r101, int r102, int r110) {
        return CanvasCompatO.INSTANCE.clipOutRect(getNativeCanvas(), r100, r101, r102, r110);
    }

    @Override // android.graphics.Canvas
    public boolean clipRect(int r100, int r101, int r102, int r103) {
        return getNativeCanvas().clipRect(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap r100, Rect r101, Rect r102, Paint r103) {
        getNativeCanvas().drawBitmap(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    public void drawBitmap(Bitmap r100, Rect r101, RectF r102, Paint r103) {
        getNativeCanvas().drawBitmap(r100, r101, r102, r103);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean clipRect(float r100, float r101, float r102, float r110, Region.Op r111) {
        return getNativeCanvas().clipRect(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public void drawArc(RectF r100, float r101, float r102, boolean r110, Paint r111) {
        getNativeCanvas().drawArc(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF r100, float[] r101, RectF r110, float[] r111, Paint r112) {
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(getNativeCanvas(), r100, r101, r110, r111, r112);
    }

    @Override // android.graphics.Canvas
    public void drawLine(float r100, float r101, float r102, float r110, Paint r111) {
        getNativeCanvas().drawLine(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public void drawOval(float r100, float r101, float r102, float r110, Paint r111) {
        getNativeCanvas().drawOval(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawPosText(char[] r100, int r101, int r102, float[] r110, Paint r111) {
        getNativeCanvas().drawPosText(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public void drawRect(float r100, float r101, float r102, float r110, Paint r111) {
        getNativeCanvas().drawRect(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(String r100, Path r101, float r102, float r110, Paint r111) {
        getNativeCanvas().drawTextOnPath(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public boolean quickReject(float r100, float r101, float r102, float r110, Canvas.EdgeType r111) {
        return getNativeCanvas().quickReject(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public int saveLayer(float r100, float r101, float r102, float r110, Paint r111) {
        return getNativeCanvas().saveLayer(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public int saveLayerAlpha(float r100, float r101, float r102, float r110, int r111) {
        return getNativeCanvas().saveLayerAlpha(r100, r101, r102, r110, r111);
    }

    @Override // android.graphics.Canvas
    public void drawText(CharSequence r100, int r101, int r110, float r111, float r112, Paint r113) {
        getNativeCanvas().drawText(r100, r101, r110, r111, r112, r113);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayer(float r100, float r101, float r110, float r111, Paint r112, int r113) {
        return getNativeCanvas().saveLayer(r100, r101, r110, r111, r112, r113);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public int saveLayerAlpha(float r100, float r101, float r110, float r111, int r112, int r113) {
        return getNativeCanvas().saveLayerAlpha(r100, r101, r110, r111, r112, r113);
    }

    @Override // android.graphics.Canvas
    public void drawText(String r100, int r101, int r110, float r111, float r112, Paint r113) {
        getNativeCanvas().drawText(r100, r101, r110, r111, r112, r113);
    }

    @Override // android.graphics.Canvas
    public void drawText(char[] r100, int r101, int r110, float r111, float r112, Paint r113) {
        getNativeCanvas().drawText(r100, r101, r110, r111, r112, r113);
    }

    @Override // android.graphics.Canvas
    public void drawDoubleRoundRect(RectF r110, float r111, float r112, RectF r113, float r114, float r115, Paint r116) {
        CanvasCompatQ.INSTANCE.drawDoubleRoundRect(getNativeCanvas(), r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.graphics.Canvas
    public void drawGlyphs(int[] r110, int r111, float[] r112, int r113, int r114, Font r115, Paint r116) {
        CanvasCompatS.INSTANCE.drawGlyphs(getNativeCanvas(), r110, r111, r112, r113, r114, r115, r116);
    }

    @Override // android.graphics.Canvas
    public void drawRoundRect(float r100, float r110, float r111, float r112, float r113, float r114, Paint r115) {
        getNativeCanvas().drawRoundRect(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // android.graphics.Canvas
    public void drawTextOnPath(char[] r100, int r110, int r111, Path r112, float r113, float r114, Paint r115) {
        getNativeCanvas().drawTextOnPath(r100, r110, r111, r112, r113, r114, r115);
    }

    @Override // android.graphics.Canvas
    public void drawArc(float r110, float r111, float r112, float r113, float r114, float r115, boolean r116, Paint r117) {
        getNativeCanvas().drawArc(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.graphics.Canvas
    public void drawBitmapMesh(Bitmap r110, int r111, int r112, float[] r113, int r114, int[] r115, int r116, Paint r117) {
        getNativeCanvas().drawBitmapMesh(r110, r111, r112, r113, r114, r115, r116, r117);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(int[] r110, int r111, int r112, float r113, float r114, int r115, int r116, boolean r117, Paint r118) {
        getNativeCanvas().drawBitmap(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(MeasuredText r110, int r111, int r112, int r113, int r114, float r115, float r116, boolean r117, Paint r210) {
        CanvasCompatQ.INSTANCE.drawTextRun(getNativeCanvas(), r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.graphics.Canvas
    @Deprecated(message = "Deprecated in Java")
    public void drawBitmap(int[] r110, int r111, int r112, int r113, int r114, int r115, int r116, boolean r117, Paint r118) {
        getNativeCanvas().drawBitmap(r110, r111, r112, r113, r114, r115, r116, r117, r118);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(CharSequence r110, int r111, int r112, int r113, int r114, float r115, float r116, boolean r117, Paint r210) {
        CanvasCompatM.INSTANCE.drawTextRun(getNativeCanvas(), r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.graphics.Canvas
    public void drawTextRun(char[] r110, int r111, int r112, int r113, int r114, float r115, float r116, boolean r117, Paint r210) {
        CanvasCompatM.INSTANCE.drawTextRun(getNativeCanvas(), r110, r111, r112, r113, r114, r115, r116, r117, r210);
    }

    @Override // android.graphics.Canvas
    public void drawVertices(Canvas.VertexMode r110, int r111, float[] r112, int r113, float[] r114, int r115, int[] r210, int r211, short[] r212, int r213, int r214, Paint r215) {
        getNativeCanvas().drawVertices(r110, r111, r112, r113, r114, r115, r210, r211, r212, r213, r214, r215);
    }
}
