package com.stepos.widget.list;

import C0.f;
import Y8.t;
import Z8.C1168p;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.core.view.N;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.contract.api.homegesture.HomeGestureEligibilityContract;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.databinding.SteposSwipeActionBinding;
import com.stepos.widget.list.StepOSSwipeActionLayout;
import f.C4027a;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.i;
import kotlin.jvm.internal.p;
import n9.C4946a;
import v9.C5685n;

@Metadata(d1 = {"\u0000Ú\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\r\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b>\b\u0007\u0018\u0000 ÷\u00012\u00020\u0001:\f÷\u0001ø\u0001ù\u0001ú\u0001û\u0001ü\u0001B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0003\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0003\u0010\b\u001a\u00020\u0006¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\f\u0010\rJ\u0017\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u000f\u0010\u0010J\u000f\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\u0012\u0010\u0013J\u0017\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0016\u0010\u0017J\u0017\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0015\u001a\u00020\u0014H\u0002¢\u0006\u0004\b\u0018\u0010\u0017J\u001f\u0010\u001b\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ!\u0010 \u001a\u00020\u00112\u0006\u0010\u001e\u001a\u00020\u001d2\b\b\u0002\u0010\u001f\u001a\u00020\u000eH\u0002¢\u0006\u0004\b \u0010!J\u001f\u0010$\u001a\u00020\u000e2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010#\u001a\u00020\u001dH\u0002¢\u0006\u0004\b$\u0010%J\u000f\u0010&\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010\u0013J\u0017\u0010)\u001a\u00020\u00112\u0006\u0010(\u001a\u00020'H\u0002¢\u0006\u0004\b)\u0010*J\u000f\u0010+\u001a\u00020\u0011H\u0002¢\u0006\u0004\b+\u0010\u0013J\u000f\u0010,\u001a\u00020\u0011H\u0002¢\u0006\u0004\b,\u0010\u0013J\u000f\u0010-\u001a\u00020\u0011H\u0002¢\u0006\u0004\b-\u0010\u0013J\u000f\u0010.\u001a\u00020\u0011H\u0002¢\u0006\u0004\b.\u0010\u0013J\u000f\u0010/\u001a\u00020\u0011H\u0002¢\u0006\u0004\b/\u0010\u0013J\u001b\u00102\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0004\b2\u00103J\u0017\u00106\u001a\u00020\u00112\b\u00105\u001a\u0004\u0018\u000104¢\u0006\u0004\b6\u00107J\u0017\u00108\u001a\u0004\u0018\u0001002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b8\u00109J\u001f\u0010;\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010:\u001a\u0004\u0018\u000100¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010=\u001a\u00020\u0006¢\u0006\u0004\b>\u0010?J\u0017\u0010A\u001a\u0004\u0018\u00010@2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\bA\u0010BJ\u001f\u0010D\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010C\u001a\u0004\u0018\u00010@¢\u0006\u0004\bD\u0010EJ\u0017\u0010F\u001a\u0004\u0018\u0001002\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\bF\u00109J\u001f\u0010H\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010G\u001a\u0004\u0018\u000100¢\u0006\u0004\bH\u0010<J\u0017\u0010J\u001a\u0004\u0018\u00010I2\u0006\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\bJ\u0010KJ\u001f\u0010M\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\b\u0010L\u001a\u0004\u0018\u00010I¢\u0006\u0004\bM\u0010NJ\u001f\u0010O\u001a\u00020\u00112\u0006\u0010\u000b\u001a\u00020\u00062\b\b\u0001\u0010=\u001a\u00020\u0006¢\u0006\u0004\bO\u0010?J\u0017\u0010Q\u001a\u00020\u00112\b\u00105\u001a\u0004\u0018\u00010P¢\u0006\u0004\bQ\u0010RJ\u0015\u0010U\u001a\u00020\u00112\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bU\u0010VJ\u0015\u0010W\u001a\u00020\u000e2\u0006\u0010T\u001a\u00020S¢\u0006\u0004\bW\u0010XJ\u0017\u0010Y\u001a\u00020\u00112\b\b\u0001\u0010=\u001a\u00020\u0006¢\u0006\u0004\bY\u0010ZJ\u0017\u0010[\u001a\u00020\u00112\b\b\u0001\u0010=\u001a\u00020\u0006¢\u0006\u0004\b[\u0010ZJ\u0017\u0010\\\u001a\u00020\u00112\b\b\u0001\u0010=\u001a\u00020\u0006¢\u0006\u0004\b\\\u0010ZJ\u0017\u0010]\u001a\u00020\u00112\b\b\u0001\u0010=\u001a\u00020\u0006¢\u0006\u0004\b]\u0010ZJ\u0019\u0010\u0019\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000eH\u0007¢\u0006\u0004\b\u0019\u0010^J\u0019\u0010_\u001a\u00020\u00112\b\b\u0002\u0010\u001a\u001a\u00020\u000eH\u0007¢\u0006\u0004\b_\u0010^J'\u0010d\u001a\u00020\u00112\u0006\u0010`\u001a\u00020'2\u0006\u0010a\u001a\u00020\u00062\u0006\u0010c\u001a\u00020bH\u0016¢\u0006\u0004\bd\u0010eJ\u0017\u0010f\u001a\u00020\u00112\u0006\u0010`\u001a\u00020'H\u0016¢\u0006\u0004\bf\u0010*J7\u0010l\u001a\u00020\u00112\u0006\u0010g\u001a\u00020\u000e2\u0006\u0010h\u001a\u00020\u00062\u0006\u0010i\u001a\u00020\u00062\u0006\u0010j\u001a\u00020\u00062\u0006\u0010k\u001a\u00020\u0006H\u0014¢\u0006\u0004\bl\u0010mJ'\u0010r\u001a\u00020\u000e2\u0006\u0010o\u001a\u00020n2\u0006\u0010`\u001a\u00020'2\u0006\u0010q\u001a\u00020pH\u0014¢\u0006\u0004\br\u0010sJ\u0017\u0010t\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\bt\u0010uJ\u0017\u0010v\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\bv\u0010uJ\u0017\u0010w\u001a\u00020\u000e2\u0006\u0010\u0015\u001a\u00020\u0014H\u0016¢\u0006\u0004\bw\u0010uJ\u000f\u0010x\u001a\u00020\u000eH\u0016¢\u0006\u0004\bx\u0010yJ\u0017\u0010{\u001a\u00020\u00112\u0006\u0010z\u001a\u00020\u000eH\u0016¢\u0006\u0004\b{\u0010^J\u0017\u0010}\u001a\u00020\u00112\u0006\u0010|\u001a\u00020\u0006H\u0016¢\u0006\u0004\b}\u0010ZJ\u000f\u0010~\u001a\u00020\u0011H\u0014¢\u0006\u0004\b~\u0010\u0013J\u000f\u0010\u007f\u001a\u00020\u0011H\u0014¢\u0006\u0004\b\u007f\u0010\u0013J\u0013\u0010\u0081\u0001\u001a\u00030\u0080\u0001H\u0014¢\u0006\u0006\b\u0081\u0001\u0010\u0082\u0001J\u001e\u0010\u0084\u0001\u001a\u00020\u00112\n\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0080\u0001H\u0014¢\u0006\u0006\b\u0084\u0001\u0010\u0085\u0001J\u0011\u0010\u0087\u0001\u001a\u00020\u0011H\u0001¢\u0006\u0005\b\u0086\u0001\u0010\u0013J\u0015\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u0088\u0001H\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001R\u0019\u0010\u008c\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0001\u0010\u008d\u0001R\u001b\u0010\u008e\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008e\u0001\u0010\u008f\u0001R\u0018\u0010\u0091\u0001\u001a\u00030\u0090\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0091\u0001\u0010\u0092\u0001R\u001e\u0010\u0094\u0001\u001a\t\u0012\u0004\u0012\u00020'0\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0094\u0001\u0010\u0095\u0001R\u001f\u0010\u0097\u0001\u001a\n\u0012\u0005\u0012\u00030\u0096\u00010\u0093\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0097\u0001\u0010\u0098\u0001R\u0017\u0010\u0099\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0099\u0001\u0010\u009a\u0001R\u0017\u0010\u009b\u0001\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009a\u0001R\u0017\u0010\u009c\u0001\u001a\u00020\u001d8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009c\u0001\u0010\u009d\u0001R\u0018\u0010\u009f\u0001\u001a\u00030\u009e\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009f\u0001\u0010 \u0001R\u0018\u0010¢\u0001\u001a\u00030¡\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¢\u0001\u0010£\u0001R\u0017\u0010¤\u0001\u001a\u00020p8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¤\u0001\u0010¥\u0001R\u001c\u0010§\u0001\u001a\u0005\u0018\u00010¦\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b§\u0001\u0010¨\u0001R\u0019\u0010©\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b©\u0001\u0010\u009a\u0001R\u0019\u0010ª\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bª\u0001\u0010\u009d\u0001R\u0019\u0010«\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b«\u0001\u0010\u008d\u0001R\u001b\u0010¬\u0001\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u001b\u0010®\u0001\u001a\u0004\u0018\u0001048\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b®\u0001\u0010¯\u0001R \u0010°\u0001\u001a\t\u0012\u0004\u0012\u00020S0\u0093\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001c\u0010³\u0001\u001a\u0005\u0018\u00010²\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u0019\u0010µ\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010\u009d\u0001R\u0019\u0010¶\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¶\u0001\u0010\u009d\u0001R\u0019\u0010·\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b·\u0001\u0010\u009d\u0001R\u0019\u0010¸\u0001\u001a\u00020\u001d8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¸\u0001\u0010\u009d\u0001R\u0019\u0010¹\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¹\u0001\u0010\u008d\u0001R\u0019\u0010º\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bº\u0001\u0010\u008d\u0001R\u0019\u0010»\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b»\u0001\u0010\u008d\u0001R\u0019\u0010¼\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¼\u0001\u0010\u008d\u0001R\u0019\u0010½\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b½\u0001\u0010\u008d\u0001R\u0019\u0010¾\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010\u008d\u0001R\u001c\u0010À\u0001\u001a\u0005\u0018\u00010¿\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010Á\u0001R\u0019\u0010Â\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010\u008d\u0001R\u0019\u0010Ã\u0001\u001a\u00020\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÃ\u0001\u0010\u008d\u0001R\u001b\u0010Ä\u0001\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÄ\u0001\u0010Å\u0001R\u001b\u0010Æ\u0001\u001a\u0004\u0018\u00010'8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010\u008f\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u00068\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010\u009a\u0001R/\u0010È\u0001\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\u000e8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\bÈ\u0001\u0010\u008d\u0001\u001a\u0005\bÈ\u0001\u0010y\"\u0005\bÉ\u0001\u0010^R2\u0010Ê\u0001\u001a\u00020\u00062\b\b\u0001\u0010\u001e\u001a\u00020\u00068G@FX\u0086\u000e¢\u0006\u0017\n\u0006\bÊ\u0001\u0010\u009a\u0001\u001a\u0006\bË\u0001\u0010Ì\u0001\"\u0005\bÍ\u0001\u0010ZR\u0017\u0010Ð\u0001\u001a\u00020'8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÎ\u0001\u0010Ï\u0001R\u0017\u0010Ó\u0001\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÑ\u0001\u0010Ò\u0001R\u0017\u0010Õ\u0001\u001a\u00020\u001d8BX\u0082\u0004¢\u0006\b\u001a\u0006\bÔ\u0001\u0010Ò\u0001R\u0013\u0010Ö\u0001\u001a\u00020\u000e8F¢\u0006\u0007\u001a\u0005\bÖ\u0001\u0010yR-\u0010Û\u0001\u001a\u0004\u0018\u0001002\b\u0010\u001e\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\b×\u0001\u0010Ø\u0001\"\u0006\bÙ\u0001\u0010Ú\u0001R-\u0010Þ\u0001\u001a\u0004\u0018\u0001002\b\u0010\u001e\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bÜ\u0001\u0010Ø\u0001\"\u0006\bÝ\u0001\u0010Ú\u0001R-\u0010ã\u0001\u001a\u0004\u0018\u00010I2\b\u0010\u001e\u001a\u0004\u0018\u00010I8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bß\u0001\u0010à\u0001\"\u0006\bá\u0001\u0010â\u0001R-\u0010æ\u0001\u001a\u0004\u0018\u00010I2\b\u0010\u001e\u001a\u0004\u0018\u00010I8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bä\u0001\u0010à\u0001\"\u0006\bå\u0001\u0010â\u0001R-\u0010é\u0001\u001a\u0004\u0018\u0001002\b\u0010\u001e\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bç\u0001\u0010Ø\u0001\"\u0006\bè\u0001\u0010Ú\u0001R-\u0010î\u0001\u001a\u0004\u0018\u00010@2\b\u0010\u001e\u001a\u0004\u0018\u00010@8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bê\u0001\u0010ë\u0001\"\u0006\bì\u0001\u0010í\u0001R-\u0010ñ\u0001\u001a\u0004\u0018\u0001002\b\u0010\u001e\u001a\u0004\u0018\u0001008F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bï\u0001\u0010Ø\u0001\"\u0006\bð\u0001\u0010Ú\u0001R-\u0010ô\u0001\u001a\u0004\u0018\u00010I2\b\u0010\u001e\u001a\u0004\u0018\u00010I8F@FX\u0086\u000e¢\u0006\u0010\u001a\u0006\bò\u0001\u0010à\u0001\"\u0006\bó\u0001\u0010â\u0001R\u001a\u0010ö\u0001\u001a\u0005\u0018\u00010\u0088\u00018AX\u0080\u0004¢\u0006\b\u001a\u0006\bõ\u0001\u0010\u008a\u0001¨\u0006ý\u0001"}, d2 = {"Lcom/stepos/widget/list/StepOSSwipeActionLayout;", "Landroid/widget/FrameLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "defStyleRes", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "actionId", "checkedActionId", "(I)I", "", "isActionVisible", "(I)Z", "LY8/t;", "updateActionVisibility", "()V", "Landroid/view/MotionEvent;", "event", "detectDrag", "(Landroid/view/MotionEvent;)V", "applyDragPosition", "open", "animate", "transitionTo", "(ZZ)V", "", UxipConstants.f30680s, "notify", "applyProgress", "(FZ)V", "x", "y", "inAction", "(FF)Z", "updateActionAvailability", "Landroid/view/View;", "view", "clearAccessibilityActions", "(Landroid/view/View;)V", "cancelAnimator", "finishTouch", "acquireParentIntercept", "releaseParentIntercept", "abortInteraction", "Landroid/graphics/drawable/Drawable;", "drawable", "ownedDrawable", "(Landroid/graphics/drawable/Drawable;)Landroid/graphics/drawable/Drawable;", "Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnActionClickListener;", "listener", "setOnActionClickListener", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnActionClickListener;)V", "getActionIcon", "(I)Landroid/graphics/drawable/Drawable;", "icon", "setActionIcon", "(ILandroid/graphics/drawable/Drawable;)V", "resourceId", "setActionIconResource", "(II)V", "Landroid/content/res/ColorStateList;", "getActionIconTint", "(I)Landroid/content/res/ColorStateList;", "tint", "setActionIconTint", "(ILandroid/content/res/ColorStateList;)V", "getActionBackground", "background", "setActionBackground", "", "getActionContentDescription", "(I)Ljava/lang/CharSequence;", "description", "setActionContentDescription", "(ILjava/lang/CharSequence;)V", "setActionContentDescriptionResource", "Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnDeleteClickListener;", "setOnDeleteClickListener", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnDeleteClickListener;)V", "Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnSwipeCallback;", "callback", "registerOnSwipeCallback", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnSwipeCallback;)V", "unregisterOnSwipeCallback", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnSwipeCallback;)Z", "setSwipeDeleteIconResource", "(I)V", "setSwipeDeleteIconTintResource", "setSwipeDeleteBackgroundResource", "setSwipeDeleteContentDescriptionResource", "(Z)V", "close", "child", "index", "Landroid/view/ViewGroup$LayoutParams;", "params", "addView", "(Landroid/view/View;ILandroid/view/ViewGroup$LayoutParams;)V", "onViewRemoved", "changed", "left", "top", "right", "bottom", "onLayout", "(ZIIII)V", "Landroid/graphics/Canvas;", "canvas", "", "drawingTime", "drawChild", "(Landroid/graphics/Canvas;Landroid/view/View;J)Z", "dispatchTouchEvent", "(Landroid/view/MotionEvent;)Z", "onInterceptTouchEvent", "onTouchEvent", "performClick", "()Z", x5.d.EXTRA_ENABLED, "setEnabled", "layoutDirection", "onRtlPropertiesChanged", "onDetachedFromWindow", "onAttachedToWindow", "Landroid/os/Parcelable;", "onSaveInstanceState", "()Landroid/os/Parcelable;", VoiceWakeupReceiver.EXTRA_STATE, "onRestoreInstanceState", "(Landroid/os/Parcelable;)V", "notifyContentPressedChanged$StepOSWidget_release", "notifyContentPressedChanged", "Lcom/stepos/widget/list/StepOSListItem;", "rowAbove$StepOSWidget_release", "()Lcom/stepos/widget/list/StepOSListItem;", "rowAbove", "inflatingInternal", "Z", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "Landroid/view/View;", "Lcom/stepos/widget/databinding/SteposSwipeActionBinding;", "binding", "Lcom/stepos/widget/databinding/SteposSwipeActionBinding;", "", "actionTargets", "[Landroid/view/View;", "Landroid/widget/ImageView;", "actionIcons", "[Landroid/widget/ImageView;", "iconSize", "I", "iconGap", "contentCorner", "F", "Landroid/graphics/Path;", "contentClipPath", "Landroid/graphics/Path;", "Landroid/view/ViewConfiguration;", "configuration", "Landroid/view/ViewConfiguration;", "duration", "J", "Landroid/animation/ValueAnimator;", "animator", "Landroid/animation/ValueAnimator;", HomeGestureEligibilityContract.EXTRA_GENERATION, "progress", "openTarget", "deleteListener", "Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnDeleteClickListener;", "actionListener", "Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnActionClickListener;", "callbacks", "[Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnSwipeCallback;", "Landroid/view/VelocityTracker;", "tracker", "Landroid/view/VelocityTracker;", "downX", "downY", "startProgress", "dragSlopOffset", "startOpen", "dragging", "vertical", "multiTouch", "consumeContentTap", "touchActive", "Landroid/view/ViewParent;", "interceptParent", "Landroid/view/ViewParent;", "constructed", "actionWasAvailable", "accessibilityOpen", "Ljava/lang/Boolean;", "accessibilityContent", "accessibilityActionId", "isSwipeEnabled", "setSwipeEnabled", "swipeActionCount", "getSwipeActionCount", "()I", "setSwipeActionCount", "getAction", "()Landroid/view/View;", "action", "getRevealWidth", "()F", "revealWidth", "getOpeningSign", "openingSign", "isOpen", "getSwipePrimaryIcon", "()Landroid/graphics/drawable/Drawable;", "setSwipePrimaryIcon", "(Landroid/graphics/drawable/Drawable;)V", "swipePrimaryIcon", "getSwipeSecondaryIcon", "setSwipeSecondaryIcon", "swipeSecondaryIcon", "getSwipePrimaryContentDescription", "()Ljava/lang/CharSequence;", "setSwipePrimaryContentDescription", "(Ljava/lang/CharSequence;)V", "swipePrimaryContentDescription", "getSwipeSecondaryContentDescription", "setSwipeSecondaryContentDescription", "swipeSecondaryContentDescription", "getSwipeDeleteIcon", "setSwipeDeleteIcon", "swipeDeleteIcon", "getSwipeDeleteIconTint", "()Landroid/content/res/ColorStateList;", "setSwipeDeleteIconTint", "(Landroid/content/res/ColorStateList;)V", "swipeDeleteIconTint", "getSwipeDeleteBackground", "setSwipeDeleteBackground", "swipeDeleteBackground", "getSwipeDeleteContentDescription", "setSwipeDeleteContentDescription", "swipeDeleteContentDescription", "getContentListItem$StepOSWidget_release", "contentListItem", "Companion", "ActionId", "OnActionClickListener", "OnDeleteClickListener", "OnSwipeCallback", "SavedState", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSSwipeActionLayout extends FrameLayout {
    public static final int ACTION_DELETE = 2;
    public static final int ACTION_PRIMARY = 0;
    public static final int ACTION_SECONDARY = 1;
    private int accessibilityActionId;
    private View accessibilityContent;
    private Boolean accessibilityOpen;
    private final ImageView[] actionIcons;
    private OnActionClickListener actionListener;
    private final View[] actionTargets;
    private boolean actionWasAvailable;
    private ValueAnimator animator;
    private final SteposSwipeActionBinding binding;
    private OnSwipeCallback[] callbacks;
    private final ViewConfiguration configuration;
    private boolean constructed;
    private boolean consumeContentTap;
    private View content;
    private final Path contentClipPath;
    private final float contentCorner;
    private OnDeleteClickListener deleteListener;
    private float downX;
    private float downY;
    private float dragSlopOffset;
    private boolean dragging;
    private final long duration;
    private int generation;
    private final int iconGap;
    private final int iconSize;
    private boolean inflatingInternal;
    private ViewParent interceptParent;
    private boolean isSwipeEnabled;
    private boolean multiTouch;
    private boolean openTarget;
    private float progress;
    private boolean startOpen;
    private float startProgress;
    private int swipeActionCount;
    private boolean touchActive;
    private VelocityTracker tracker;
    private boolean vertical;

    @Retention(RetentionPolicy.SOURCE)
    @Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002"}, d2 = {"Lcom/stepos/widget/list/StepOSSwipeActionLayout$ActionId;", "", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public @interface ActionId {
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u001f\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H&¢\u0006\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnActionClickListener;", "", "Lcom/stepos/widget/list/StepOSSwipeActionLayout;", "layout", "", "actionId", "LY8/t;", "onActionClick", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout;I)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnActionClickListener {
        void onActionClick(StepOSSwipeActionLayout layout, int actionId);
    }

    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bæ\u0080\u0001\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnDeleteClickListener;", "", "Lcom/stepos/widget/list/StepOSSwipeActionLayout;", "layout", "LY8/t;", "onDeleteClick", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout;)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public interface OnDeleteClickListener {
        void onDeleteClick(StepOSSwipeActionLayout layout);
    }

    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b&\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0007\u0010\bJ!\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\b\b\u0001\u0010\n\u001a\u00020\tH\u0016¢\u0006\u0004\b\u000b\u0010\fJ\u001f\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\rH\u0016¢\u0006\u0004\b\u000f\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/stepos/widget/list/StepOSSwipeActionLayout$OnSwipeCallback;", "", "<init>", "()V", "Lcom/stepos/widget/list/StepOSSwipeActionLayout;", "layout", "LY8/t;", "onSwipeStarted", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout;)V", "", "progress", "onSwipeProgressChanged", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout;F)V", "", "isOpen", "onOpenChanged", "(Lcom/stepos/widget/list/StepOSSwipeActionLayout;Z)V", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static abstract class OnSwipeCallback {
        public void onOpenChanged(StepOSSwipeActionLayout layout, boolean isOpen) {
            p.i(layout, "layout");
        }

        public void onSwipeProgressChanged(StepOSSwipeActionLayout layout, float progress) {
            p.i(layout, "layout");
        }

        public void onSwipeStarted(StepOSSwipeActionLayout layout) {
            p.i(layout, "layout");
        }
    }

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\b\b\u0001\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0013\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u0004\u0010\u0005B\u001b\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\u0004\u0010\nJ\u001f\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u000b\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\"\u0010\u0012\u001a\u00020\u00118\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\u0019"}, d2 = {"Lcom/stepos/widget/list/StepOSSwipeActionLayout$SavedState;", "Landroidx/customview/view/AbsSavedState;", "Landroid/os/Parcelable;", "superState", "<init>", "(Landroid/os/Parcelable;)V", "Landroid/os/Parcel;", "source", "Ljava/lang/ClassLoader;", "loader", "(Landroid/os/Parcel;Ljava/lang/ClassLoader;)V", "out", "", "flags", "LY8/t;", "writeToParcel", "(Landroid/os/Parcel;I)V", "", "open", "Z", "getOpen", "()Z", "setOpen", "(Z)V", "Companion", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class SavedState extends AbsSavedState {
        private boolean open;
        public static final Parcelable.ClassLoaderCreator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() { // from class: com.stepos.widget.list.StepOSSwipeActionLayout$SavedState$Companion$CREATOR$1
            @Override // android.os.Parcelable.Creator
            public StepOSSwipeActionLayout.SavedState[] newArray(int size) {
                return new StepOSSwipeActionLayout.SavedState[size];
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.ClassLoaderCreator
            public StepOSSwipeActionLayout.SavedState createFromParcel(Parcel source, ClassLoader loader) {
                p.i(source, "source");
                return new StepOSSwipeActionLayout.SavedState(source, loader);
            }

            @Override // android.os.Parcelable.Creator
            public StepOSSwipeActionLayout.SavedState createFromParcel(Parcel source) {
                p.i(source, "source");
                return new StepOSSwipeActionLayout.SavedState(source, null);
            }
        };

        public SavedState(Parcelable parcelable) {
            super(parcelable == null ? AbsSavedState.EMPTY_STATE : parcelable);
        }

        public final boolean getOpen() {
            return this.open;
        }

        public final void setOpen(boolean z10) {
            this.open = z10;
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public void writeToParcel(Parcel out, int flags) {
            p.i(out, "out");
            super.writeToParcel(out, flags);
            out.writeInt(this.open ? 1 : 0);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public SavedState(Parcel source, ClassLoader classLoader) {
            super(source, classLoader);
            p.i(source, "source");
            this.open = source.readInt() != 0;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwipeActionLayout(Context context) {
        this(context, null, 0, 0, 14, null);
        p.i(context, "context");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void _init_$lambda$2(StepOSSwipeActionLayout stepOSSwipeActionLayout, int i10, View view) {
        OnDeleteClickListener onDeleteClickListener;
        if (stepOSSwipeActionLayout.isEnabled() && stepOSSwipeActionLayout.isSwipeEnabled && stepOSSwipeActionLayout.isActionVisible(i10) && stepOSSwipeActionLayout.progress == 1.0f && !stepOSSwipeActionLayout.dragging) {
            OnActionClickListener onActionClickListener = stepOSSwipeActionLayout.actionListener;
            if (onActionClickListener != null) {
                onActionClickListener.onActionClick(stepOSSwipeActionLayout, i10);
            } else {
                if (i10 != 2 || (onDeleteClickListener = stepOSSwipeActionLayout.deleteListener) == null) {
                    return;
                }
                onDeleteClickListener.onDeleteClick(stepOSSwipeActionLayout);
            }
        }
    }

    private final void abortInteraction() {
        finishTouch();
        transitionTo(false, false);
    }

    private final void acquireParentIntercept() {
        ViewParent parent = getParent();
        if (parent == null || this.interceptParent == parent) {
            return;
        }
        releaseParentIntercept();
        this.interceptParent = parent;
        parent.requestDisallowInterceptTouchEvent(true);
    }

    private final void applyDragPosition(MotionEvent event) {
        applyProgress$default(this, C5685n.m(this.startProgress + ((getOpeningSign() * ((event.getX() - this.downX) - this.dragSlopOffset)) / getRevealWidth()), 0.0f, 1.0f), false, 2, null);
    }

    private final void applyProgress(float value, boolean notify) {
        boolean z10 = this.progress == value;
        this.progress = value;
        View view = this.content;
        if (view != null) {
            view.setTranslationX(getOpeningSign() * getRevealWidth() * value);
        }
        StepOSListItem contentListItem$StepOSWidget_release = getContentListItem$StepOSWidget_release();
        if (contentListItem$StepOSWidget_release != null) {
            contentListItem$StepOSWidget_release.setSwipeAppearanceActive$StepOSWidget_release(value > 0.0f);
        }
        getAction().setVisibility(this.swipeActionCount == 0 ? 8 : value == 0.0f ? 4 : 0);
        updateActionAvailability();
        invalidate();
        if (z10 || !notify) {
            return;
        }
        for (OnSwipeCallback onSwipeCallback : this.callbacks) {
            onSwipeCallback.onSwipeProgressChanged(this, value);
        }
    }

    public static /* synthetic */ void applyProgress$default(StepOSSwipeActionLayout stepOSSwipeActionLayout, float f10, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = true;
        }
        stepOSSwipeActionLayout.applyProgress(f10, z10);
    }

    private final void cancelAnimator() {
        this.generation++;
        ValueAnimator valueAnimator = this.animator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.animator;
        if (valueAnimator2 != null) {
            valueAnimator2.removeAllListeners();
        }
        ValueAnimator valueAnimator3 = this.animator;
        if (valueAnimator3 != null) {
            valueAnimator3.cancel();
        }
        this.animator = null;
    }

    private final int checkedActionId(int actionId) {
        if (actionId >= 0 && actionId < 3) {
            return actionId;
        }
        throw new IllegalArgumentException(("actionId must be ACTION_PRIMARY, ACTION_SECONDARY or ACTION_DELETE but was " + actionId).toString());
    }

    private final void clearAccessibilityActions(View view) {
        int i10;
        if (view != this.accessibilityContent || (i10 = this.accessibilityActionId) == -1) {
            return;
        }
        N.b0(view, i10);
        this.accessibilityActionId = -1;
    }

    public static /* synthetic */ void close$default(StepOSSwipeActionLayout stepOSSwipeActionLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        stepOSSwipeActionLayout.close(z10);
    }

    private final void detectDrag(MotionEvent event) {
        if (this.dragging || this.vertical || this.multiTouch) {
            return;
        }
        float x10 = event.getX() - this.downX;
        float y10 = event.getY() - this.downY;
        if (Math.abs(y10) > this.configuration.getScaledTouchSlop() && Math.abs(y10) >= Math.abs(x10)) {
            this.vertical = true;
            return;
        }
        if (Math.abs(x10) <= this.configuration.getScaledTouchSlop() || Math.abs(x10) <= Math.abs(y10)) {
            return;
        }
        if (this.progress != 0.0f || getOpeningSign() * x10 > 0.0f) {
            this.dragging = true;
            this.dragSlopOffset = Math.signum(x10) * this.configuration.getScaledTouchSlop();
            View view = this.content;
            if (view != null) {
                view.setPressed(false);
            }
            for (View view2 : this.actionTargets) {
                view2.setPressed(false);
            }
            acquireParentIntercept();
            updateActionAvailability();
            for (OnSwipeCallback onSwipeCallback : this.callbacks) {
                onSwipeCallback.onSwipeStarted(this);
            }
        }
    }

    private final void finishTouch() {
        VelocityTracker velocityTracker = this.tracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.tracker = null;
        this.touchActive = false;
        this.dragging = false;
        this.consumeContentTap = false;
        releaseParentIntercept();
        updateActionAvailability();
    }

    private final View getAction() {
        LinearLayout steposSwipeActionPanel = this.binding.steposSwipeActionPanel;
        p.h(steposSwipeActionPanel, "steposSwipeActionPanel");
        return steposSwipeActionPanel;
    }

    private final float getOpeningSign() {
        return getLayoutDirection() == 1 ? 1.0f : -1.0f;
    }

    private final float getRevealWidth() {
        return SwipeActionPolicy.INSTANCE.width(this.swipeActionCount, this.iconSize, this.iconGap);
    }

    private final boolean inAction(float x10, float y10) {
        if (this.progress == 1.0f) {
            for (View view : this.actionTargets) {
                if (view.getVisibility() == 0 && x10 >= getAction().getLeft() + r4.getLeft() && x10 < getAction().getLeft() + r4.getRight() && y10 >= getAction().getTop() + r4.getTop() && y10 < getAction().getTop() + r4.getBottom()) {
                    return true;
                }
            }
        }
        return false;
    }

    private final boolean isActionVisible(int actionId) {
        return SwipeActionPolicy.INSTANCE.isVisible(actionId, this.swipeActionCount);
    }

    public static /* synthetic */ void open$default(StepOSSwipeActionLayout stepOSSwipeActionLayout, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        stepOSSwipeActionLayout.open(z10);
    }

    private final Drawable ownedDrawable(Drawable drawable) {
        Drawable.ConstantState constantState;
        Drawable drawableNewDrawable;
        if (drawable != null && (constantState = drawable.getConstantState()) != null && (drawableNewDrawable = constantState.newDrawable(getResources(), getContext().getTheme())) != null) {
            drawable = drawableNewDrawable;
        }
        if (drawable != null) {
            return drawable.mutate();
        }
        return null;
    }

    private final void releaseParentIntercept() {
        ViewParent viewParent = this.interceptParent;
        if (viewParent == null) {
            return;
        }
        this.interceptParent = null;
        viewParent.requestDisallowInterceptTouchEvent(false);
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0073  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void transitionTo(boolean r11, boolean r12) {
        /*
            r10 = this;
            r10.cancelAnimator()
            int r0 = r10.generation
            boolean r1 = r10.openTarget
            r2 = 1
            r3 = 0
            if (r1 == r11) goto Ld
            r1 = r2
            goto Le
        Ld:
            r1 = r3
        Le:
            r10.openTarget = r11
            r4 = 1065353216(0x3f800000, float:1.0)
            r5 = 0
            if (r11 == 0) goto L17
            r6 = r4
            goto L18
        L17:
            r6 = r5
        L18:
            if (r1 == 0) goto L28
            com.stepos.widget.list.StepOSSwipeActionLayout$OnSwipeCallback[] r1 = r10.callbacks
            int r7 = r1.length
            r8 = r3
        L1e:
            if (r8 >= r7) goto L28
            r9 = r1[r8]
            r9.onOpenChanged(r10, r11)
            int r8 = r8 + 1
            goto L1e
        L28:
            int r11 = r10.generation
            if (r0 == r11) goto L2d
            return
        L2d:
            r11 = 2
            if (r12 == 0) goto L73
            boolean r12 = r10.isLaidOut()
            if (r12 == 0) goto L73
            boolean r12 = android.animation.ValueAnimator.areAnimatorsEnabled()
            if (r12 == 0) goto L73
            float r12 = r10.progress
            int r1 = (r12 > r6 ? 1 : (r12 == r6 ? 0 : -1))
            if (r1 != 0) goto L43
            goto L73
        L43:
            float[] r11 = new float[r11]
            r11[r3] = r12
            r11[r2] = r6
            android.animation.ValueAnimator r11 = android.animation.ValueAnimator.ofFloat(r11)
            long r1 = r10.duration
            r11.setDuration(r1)
            android.view.animation.PathInterpolator r12 = new android.view.animation.PathInterpolator
            r1 = 1045220557(0x3e4ccccd, float:0.2)
            r12.<init>(r1, r5, r5, r4)
            r11.setInterpolator(r12)
            com.stepos.widget.list.e r12 = new com.stepos.widget.list.e
            r12.<init>()
            r11.addUpdateListener(r12)
            com.stepos.widget.list.StepOSSwipeActionLayout$transitionTo$running$1$2 r12 = new com.stepos.widget.list.StepOSSwipeActionLayout$transitionTo$running$1$2
            r12.<init>()
            r11.addListener(r12)
            r10.animator = r11
            r11.start()
            goto L77
        L73:
            r12 = 0
            applyProgress$default(r10, r6, r3, r11, r12)
        L77:
            r10.updateActionAvailability()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.list.StepOSSwipeActionLayout.transitionTo(boolean, boolean):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void transitionTo$lambda$12$lambda$11(int i10, StepOSSwipeActionLayout stepOSSwipeActionLayout, ValueAnimator it) {
        p.i(it, "it");
        if (i10 == stepOSSwipeActionLayout.generation) {
            Object animatedValue = it.getAnimatedValue();
            p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
            applyProgress$default(stepOSSwipeActionLayout, ((Float) animatedValue).floatValue(), false, 2, null);
        }
    }

    private final void updateActionAvailability() {
        boolean z10 = isEnabled() && this.isSwipeEnabled && this.swipeActionCount > 0 && this.progress == 1.0f && !this.dragging && this.content != null;
        getAction().setEnabled(z10);
        int length = this.actionTargets.length;
        for (int i10 = 0; i10 < length; i10++) {
            View view = this.actionTargets[i10];
            boolean z11 = z10 && isActionVisible(i10);
            view.setEnabled(z11);
            view.setClickable(z11);
            view.setFocusable(z11);
            if (!z11) {
                view.clearFocus();
            }
        }
        getAction().setImportantForAccessibility(z10 ? 1 : 4);
        if (!z10 && this.actionWasAvailable) {
            getAction().clearFocus();
        }
        this.actionWasAvailable = z10;
        Boolean boolValueOf = (isEnabled() && this.isSwipeEnabled && this.swipeActionCount > 0) ? Boolean.valueOf(this.openTarget) : null;
        if (this.accessibilityContent == this.content && p.d(this.accessibilityOpen, boolValueOf)) {
            return;
        }
        View view2 = this.accessibilityContent;
        if (view2 != null) {
            clearAccessibilityActions(view2);
        }
        View view3 = this.content;
        this.accessibilityContent = view3;
        this.accessibilityOpen = boolValueOf;
        if (view3 == null || boolValueOf == null) {
            return;
        }
        String string = getContext().getString(boolValueOf.booleanValue() ? R.string.stepos_swipe_action_hide : R.string.stepos_swipe_action_show);
        p.h(string, "getString(...)");
        this.accessibilityActionId = N.b(view3, string, new C0.f() { // from class: com.stepos.widget.list.d
            @Override // C0.f
            public final boolean a(View view4, f.a aVar) {
                return StepOSSwipeActionLayout.updateActionAvailability$lambda$14(this.f31265a, view4, aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean updateActionAvailability$lambda$14(StepOSSwipeActionLayout stepOSSwipeActionLayout, View view, f.a aVar) {
        p.i(view, "<unused var>");
        if (!stepOSSwipeActionLayout.isEnabled() || !stepOSSwipeActionLayout.isSwipeEnabled || stepOSSwipeActionLayout.swipeActionCount <= 0) {
            return false;
        }
        if (stepOSSwipeActionLayout.getOpenTarget()) {
            close$default(stepOSSwipeActionLayout, false, 1, null);
        } else {
            open$default(stepOSSwipeActionLayout, false, 1, null);
        }
        return true;
    }

    private final void updateActionVisibility() {
        int length = this.actionTargets.length;
        int i10 = 0;
        int i11 = 0;
        while (true) {
            int i12 = 8;
            if (i11 >= length) {
                break;
            }
            View view = this.actionTargets[i11];
            if (isActionVisible(i11)) {
                i12 = 0;
            }
            view.setVisibility(i12);
            i11++;
        }
        View action = getAction();
        if (this.swipeActionCount == 0) {
            i10 = 8;
        } else if (this.progress == 0.0f) {
            i10 = 4;
        }
        action.setVisibility(i10);
        updateActionAvailability();
    }

    @Override // android.view.ViewGroup
    public void addView(View child, int index, ViewGroup.LayoutParams params) {
        p.i(child, "child");
        p.i(params, "params");
        boolean z10 = this.inflatingInternal;
        if (!z10 && this.content != null) {
            throw new IllegalStateException("StepOSSwipeActionLayout supports exactly one content child");
        }
        if (!z10) {
            index = -1;
        }
        super.addView(child, index, params);
        if (this.inflatingInternal) {
            return;
        }
        this.content = child;
        applyProgress(this.progress, false);
        updateActionAvailability();
    }

    public final void close() {
        close$default(this, false, 1, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        p.i(event, "event");
        if (event.getActionMasked() == 0 && isEnabled() && this.isSwipeEnabled && this.swipeActionCount > 0) {
            VelocityTracker velocityTracker = this.tracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
            }
            this.tracker = VelocityTracker.obtain();
            this.downX = event.getX();
            this.downY = event.getY();
            float f10 = this.progress;
            this.startProgress = f10;
            this.startOpen = this.openTarget;
            this.dragging = false;
            this.vertical = false;
            this.multiTouch = false;
            this.touchActive = true;
            this.consumeContentTap = f10 > 0.0f && !inAction(event.getX(), event.getY());
            cancelAnimator();
        }
        VelocityTracker velocityTracker2 = this.tracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(event);
        }
        if (this.touchActive && event.getActionMasked() == 5) {
            this.multiTouch = true;
            this.dragging = false;
            transitionTo(this.startOpen, true);
            releaseParentIntercept();
        }
        boolean zDispatchTouchEvent = super.dispatchTouchEvent(event);
        if (event.getActionMasked() != 1 && event.getActionMasked() != 3) {
            return zDispatchTouchEvent;
        }
        if (this.touchActive && event.getActionMasked() == 3) {
            transitionTo(this.startOpen, true);
        } else if (this.touchActive && this.animator == null) {
            float f11 = this.progress;
            boolean z10 = this.openTarget;
            if (f11 != (z10 ? 1.0f : 0.0f)) {
                transitionTo(z10, true);
            }
        }
        finishTouch();
        return zDispatchTouchEvent;
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View child, long drawingTime) {
        p.i(canvas, "canvas");
        p.i(child, "child");
        if (child != this.content || this.progress <= 0.0f) {
            if (child != getAction()) {
                return super.drawChild(canvas, child, drawingTime);
            }
            int iSave = canvas.save();
            float paddingLeft = getOpeningSign() > 0.0f ? getPaddingLeft() : getWidth() - getPaddingRight();
            if (getOpeningSign() > 0.0f) {
                canvas.clipRect(paddingLeft, 0.0f, (getRevealWidth() * this.progress) + paddingLeft, getHeight());
            } else {
                canvas.clipRect(paddingLeft - (getRevealWidth() * this.progress), 0.0f, paddingLeft, getHeight());
            }
            boolean zDrawChild = super.drawChild(canvas, child, drawingTime);
            canvas.restoreToCount(iSave);
            return zDrawChild;
        }
        int iSave2 = canvas.save();
        this.contentClipPath.rewind();
        float left = child.getLeft() + child.getTranslationX();
        float top = child.getTop() + child.getTranslationY();
        float f10 = this.contentCorner;
        this.contentClipPath.addRoundRect(left, top, left + child.getWidth(), top + child.getHeight(), f10, f10, Path.Direction.CW);
        canvas.clipPath(this.contentClipPath);
        boolean zDrawChild2 = super.drawChild(canvas, child, drawingTime);
        canvas.restoreToCount(iSave2);
        return zDrawChild2;
    }

    public final Drawable getActionBackground(int actionId) {
        return this.actionIcons[checkedActionId(actionId)].getBackground();
    }

    public final CharSequence getActionContentDescription(int actionId) {
        return this.actionTargets[checkedActionId(actionId)].getContentDescription();
    }

    public final Drawable getActionIcon(int actionId) {
        return this.actionIcons[checkedActionId(actionId)].getDrawable();
    }

    public final ColorStateList getActionIconTint(int actionId) {
        return this.actionIcons[checkedActionId(actionId)].getImageTintList();
    }

    public final StepOSListItem getContentListItem$StepOSWidget_release() {
        View view = this.content;
        if (view instanceof StepOSListItem) {
            return (StepOSListItem) view;
        }
        return null;
    }

    public final int getSwipeActionCount() {
        return this.swipeActionCount;
    }

    public final Drawable getSwipeDeleteBackground() {
        return this.binding.steposSwipeActionDeleteIcon.getBackground();
    }

    public final CharSequence getSwipeDeleteContentDescription() {
        return getActionContentDescription(2);
    }

    public final Drawable getSwipeDeleteIcon() {
        return this.binding.steposSwipeActionDeleteIcon.getDrawable();
    }

    public final ColorStateList getSwipeDeleteIconTint() {
        return this.binding.steposSwipeActionDeleteIcon.getImageTintList();
    }

    public final CharSequence getSwipePrimaryContentDescription() {
        return getActionContentDescription(0);
    }

    public final Drawable getSwipePrimaryIcon() {
        return getActionIcon(0);
    }

    public final CharSequence getSwipeSecondaryContentDescription() {
        return getActionContentDescription(1);
    }

    public final Drawable getSwipeSecondaryIcon() {
        return getActionIcon(1);
    }

    /* renamed from: isOpen, reason: from getter */
    public final boolean getOpenTarget() {
        return this.openTarget;
    }

    /* renamed from: isSwipeEnabled, reason: from getter */
    public final boolean getIsSwipeEnabled() {
        return this.isSwipeEnabled;
    }

    public final void notifyContentPressedChanged$StepOSWidget_release() {
        ViewParent parent = getParent();
        RecyclerView recyclerView = parent instanceof RecyclerView ? (RecyclerView) parent : null;
        if (recyclerView != null) {
            recyclerView.invalidate();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        updateActionAvailability();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        this.deleteListener = null;
        this.actionListener = null;
        this.callbacks = new OnSwipeCallback[0];
        abortInteraction();
        View view = this.accessibilityContent;
        if (view != null) {
            clearAccessibilityActions(view);
        }
        this.accessibilityContent = null;
        this.accessibilityOpen = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent event) {
        p.i(event, "event");
        if (!this.touchActive || !isEnabled() || !this.isSwipeEnabled) {
            return false;
        }
        if (this.multiTouch) {
            return true;
        }
        if (event.getActionMasked() == 2) {
            detectDrag(event);
            if (this.dragging) {
                applyDragPosition(event);
            }
        }
        return this.dragging || this.consumeContentTap;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        View view = this.content;
        if (view != null) {
            view.setTranslationX(getOpeningSign() * getRevealWidth() * this.progress);
        }
    }

    @Override // android.view.View
    public void onRestoreInstanceState(Parcelable state) {
        if (!(state instanceof SavedState)) {
            super.onRestoreInstanceState(state);
            return;
        }
        SavedState savedState = (SavedState) state;
        super.onRestoreInstanceState(savedState.getSuperState());
        cancelAnimator();
        boolean z10 = savedState.getOpen() && isEnabled() && this.isSwipeEnabled && this.swipeActionCount > 0;
        this.openTarget = z10;
        applyProgress(z10 ? 1.0f : 0.0f, false);
    }

    @Override // android.view.View
    public void onRtlPropertiesChanged(int layoutDirection) {
        super.onRtlPropertiesChanged(layoutDirection);
        if (this.constructed) {
            finishTouch();
            transitionTo(this.openTarget, false);
        }
    }

    @Override // android.view.View
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.setOpen(this.openTarget);
        return savedState;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        p.i(event, "event");
        if (!this.touchActive) {
            return super.onTouchEvent(event);
        }
        if (!this.multiTouch) {
            int actionMasked = event.getActionMasked();
            if (actionMasked != 1) {
                if (actionMasked == 2) {
                    detectDrag(event);
                    if (this.dragging) {
                        applyDragPosition(event);
                    }
                }
            } else if (this.dragging) {
                VelocityTracker velocityTracker = this.tracker;
                if (velocityTracker != null) {
                    velocityTracker.computeCurrentVelocity(1000, this.configuration.getScaledMaximumFlingVelocity());
                }
                VelocityTracker velocityTracker2 = this.tracker;
                float xVelocity = (velocityTracker2 != null ? velocityTracker2.getXVelocity() : 0.0f) * getOpeningSign();
                VelocityTracker velocityTracker3 = this.tracker;
                boolean zShouldOpen = SwipeActionPolicy.INSTANCE.shouldOpen(this.progress, xVelocity, Math.abs(velocityTracker3 != null ? velocityTracker3.getYVelocity() : 0.0f), this.configuration.getScaledMinimumFlingVelocity());
                this.dragging = false;
                transitionTo(zShouldOpen, true);
            } else if (this.consumeContentTap && !this.vertical) {
                performClick();
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup
    public void onViewRemoved(View child) {
        p.i(child, "child");
        super.onViewRemoved(child);
        if (child != this.content) {
            return;
        }
        StepOSListItem contentListItem$StepOSWidget_release = getContentListItem$StepOSWidget_release();
        if (contentListItem$StepOSWidget_release != null) {
            contentListItem$StepOSWidget_release.setSwipeAppearanceActive$StepOSWidget_release(false);
        }
        child.setTranslationX(0.0f);
        clearAccessibilityActions(child);
        this.content = null;
        abortInteraction();
    }

    public final void open() {
        open$default(this, false, 1, null);
    }

    @Override // android.view.View
    public boolean performClick() {
        super.performClick();
        close$default(this, false, 1, null);
        return true;
    }

    public final void registerOnSwipeCallback(OnSwipeCallback callback) {
        p.i(callback, "callback");
        for (OnSwipeCallback onSwipeCallback : this.callbacks) {
            if (onSwipeCallback == callback) {
                return;
            }
        }
        this.callbacks = (OnSwipeCallback[]) C1168p.F(this.callbacks, callback);
    }

    public final StepOSListItem rowAbove$StepOSWidget_release() {
        int childAdapterPosition;
        StepOSListItem contentListItem$StepOSWidget_release;
        ViewParent parent = getParent();
        RecyclerView recyclerView = parent instanceof RecyclerView ? (RecyclerView) parent : null;
        if (recyclerView == null || (childAdapterPosition = recyclerView.getChildAdapterPosition(this)) <= 0) {
            return null;
        }
        RecyclerView.ViewHolder viewHolderFindViewHolderForAdapterPosition = recyclerView.findViewHolderForAdapterPosition(childAdapterPosition - 1);
        View view = viewHolderFindViewHolderForAdapterPosition != null ? viewHolderFindViewHolderForAdapterPosition.itemView : null;
        StepOSSwipeActionLayout stepOSSwipeActionLayout = view instanceof StepOSSwipeActionLayout ? (StepOSSwipeActionLayout) view : null;
        if (stepOSSwipeActionLayout != null && (contentListItem$StepOSWidget_release = stepOSSwipeActionLayout.getContentListItem$StepOSWidget_release()) != null) {
            return contentListItem$StepOSWidget_release;
        }
        if (view instanceof StepOSListItem) {
            return (StepOSListItem) view;
        }
        return null;
    }

    public final void setActionBackground(int actionId, Drawable background) {
        this.actionIcons[checkedActionId(actionId)].setBackground(ownedDrawable(background));
    }

    public final void setActionContentDescription(int actionId, CharSequence description) {
        checkedActionId(actionId);
        int i10 = actionId != 0 ? actionId != 1 ? R.string.stepos_swipe_action_delete : R.string.stepos_swipe_action_secondary : R.string.stepos_swipe_action_primary;
        View view = this.actionTargets[actionId];
        if (description == null) {
            description = getContext().getText(i10);
            p.h(description, "getText(...)");
        }
        view.setContentDescription(description);
    }

    public final void setActionContentDescriptionResource(int actionId, int resourceId) {
        checkedActionId(actionId);
        setActionContentDescription(actionId, resourceId == 0 ? null : getContext().getText(resourceId));
    }

    public final void setActionIcon(int actionId, Drawable icon) {
        this.actionIcons[checkedActionId(actionId)].setImageDrawable(ownedDrawable(icon));
    }

    public final void setActionIconResource(int actionId, int resourceId) {
        checkedActionId(actionId);
        setActionIcon(actionId, resourceId == 0 ? null : C4027a.b(getContext(), resourceId));
    }

    public final void setActionIconTint(int actionId, ColorStateList tint) {
        this.actionIcons[checkedActionId(actionId)].setImageTintList(tint);
    }

    @Override // android.view.View
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        if (this.constructed) {
            if (!enabled) {
                abortInteraction();
            }
            updateActionAvailability();
        }
    }

    public final void setOnActionClickListener(OnActionClickListener listener) {
        this.actionListener = listener;
    }

    public final void setOnDeleteClickListener(OnDeleteClickListener listener) {
        this.deleteListener = listener;
    }

    public final void setSwipeActionCount(int i10) {
        if (i10 < 0 || i10 >= 4) {
            throw new IllegalArgumentException(("swipeActionCount must be in 0..3 but was " + i10).toString());
        }
        if (this.swipeActionCount == i10) {
            return;
        }
        this.swipeActionCount = i10;
        abortInteraction();
        updateActionVisibility();
        requestLayout();
    }

    public final void setSwipeDeleteBackground(Drawable drawable) {
        this.binding.steposSwipeActionDeleteIcon.setBackground(ownedDrawable(drawable));
    }

    public final void setSwipeDeleteBackgroundResource(int resourceId) {
        setSwipeDeleteBackground(resourceId == 0 ? null : C4027a.b(getContext(), resourceId));
    }

    public final void setSwipeDeleteContentDescription(CharSequence charSequence) {
        setActionContentDescription(2, charSequence);
    }

    public final void setSwipeDeleteContentDescriptionResource(int resourceId) {
        setSwipeDeleteContentDescription(resourceId == 0 ? null : getContext().getText(resourceId));
    }

    public final void setSwipeDeleteIcon(Drawable drawable) {
        this.binding.steposSwipeActionDeleteIcon.setImageDrawable(ownedDrawable(drawable));
    }

    public final void setSwipeDeleteIconResource(int resourceId) {
        setSwipeDeleteIcon(resourceId == 0 ? null : C4027a.b(getContext(), resourceId));
    }

    public final void setSwipeDeleteIconTint(ColorStateList colorStateList) {
        this.binding.steposSwipeActionDeleteIcon.setImageTintList(colorStateList);
    }

    public final void setSwipeDeleteIconTintResource(int resourceId) {
        setSwipeDeleteIconTint(resourceId == 0 ? null : C4027a.a(getContext(), resourceId));
    }

    public final void setSwipeEnabled(boolean z10) {
        if (this.isSwipeEnabled == z10) {
            return;
        }
        this.isSwipeEnabled = z10;
        if (!z10) {
            abortInteraction();
        }
        updateActionAvailability();
    }

    public final void setSwipePrimaryContentDescription(CharSequence charSequence) {
        setActionContentDescription(0, charSequence);
    }

    public final void setSwipePrimaryIcon(Drawable drawable) {
        setActionIcon(0, drawable);
    }

    public final void setSwipeSecondaryContentDescription(CharSequence charSequence) {
        setActionContentDescription(1, charSequence);
    }

    public final void setSwipeSecondaryIcon(Drawable drawable) {
        setActionIcon(1, drawable);
    }

    public final boolean unregisterOnSwipeCallback(OnSwipeCallback callback) {
        p.i(callback, "callback");
        for (OnSwipeCallback onSwipeCallback : this.callbacks) {
            if (onSwipeCallback == callback) {
                OnSwipeCallback[] onSwipeCallbackArr = this.callbacks;
                ArrayList arrayList = new ArrayList();
                for (OnSwipeCallback onSwipeCallback2 : onSwipeCallbackArr) {
                    if (onSwipeCallback2 != callback) {
                        arrayList.add(onSwipeCallback2);
                    }
                }
                this.callbacks = (OnSwipeCallback[]) arrayList.toArray(new OnSwipeCallback[0]);
                return true;
            }
        }
        return false;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwipeActionLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 0, 12, null);
        p.i(context, "context");
    }

    public final void close(boolean animate) {
        finishTouch();
        transitionTo(false, animate);
    }

    public final void open(boolean animate) {
        if (!isEnabled() || !this.isSwipeEnabled) {
            throw new IllegalStateException("Enable the view and steposSwipeEnabled before open()");
        }
        if (this.swipeActionCount <= 0) {
            throw new IllegalStateException("Set swipeActionCount to 1, 2 or 3 before open()");
        }
        if (this.content == null) {
            throw new IllegalStateException("Add exactly one content child before open()");
        }
        finishTouch();
        transitionTo(true, animate);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public StepOSSwipeActionLayout(Context context, AttributeSet attributeSet, int i10) {
        this(context, attributeSet, i10, 0, 8, null);
        p.i(context, "context");
    }

    public /* synthetic */ StepOSSwipeActionLayout(Context context, AttributeSet attributeSet, int i10, int i11, int i12, i iVar) {
        this(context, (i12 & 2) != 0 ? null : attributeSet, (i12 & 4) != 0 ? R.attr.steposSwipeActionLayoutStyle : i10, (i12 & 8) != 0 ? R.style.StepOSWidget_SwipeActionLayout : i11);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public StepOSSwipeActionLayout(Context context, AttributeSet attributeSet, int i10, int i11) throws Exception {
        super(context, attributeSet, i10, i11);
        p.i(context, "context");
        this.inflatingInternal = true;
        SteposSwipeActionBinding steposSwipeActionBindingInflate = SteposSwipeActionBinding.inflate(LayoutInflater.from(context), this);
        p.h(steposSwipeActionBindingInflate, "inflate(...)");
        this.binding = steposSwipeActionBindingInflate;
        this.actionTargets = new View[]{steposSwipeActionBindingInflate.steposSwipeActionPrimaryTarget, steposSwipeActionBindingInflate.steposSwipeActionSecondaryTarget, steposSwipeActionBindingInflate.steposSwipeActionDeleteTarget};
        ImageView[] imageViewArr = {steposSwipeActionBindingInflate.steposSwipeActionPrimaryIcon, steposSwipeActionBindingInflate.steposSwipeActionSecondaryIcon, steposSwipeActionBindingInflate.steposSwipeActionDeleteIcon};
        this.actionIcons = imageViewArr;
        this.iconSize = getResources().getDimensionPixelSize(R.dimen.stepos_swipe_action_icon_size);
        int dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.stepos_swipe_action_icon_margin);
        this.iconGap = dimensionPixelSize;
        this.contentCorner = getResources().getDimension(R.dimen.stepos_swipe_action_content_corner);
        this.contentClipPath = new Path();
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        p.h(viewConfiguration, "get(...)");
        this.configuration = viewConfiguration;
        this.duration = getResources().getInteger(R.integer.stepos_swipe_action_settle_duration);
        this.callbacks = new OnSwipeCallback[0];
        this.accessibilityActionId = -1;
        this.isSwipeEnabled = true;
        this.swipeActionCount = 1;
        this.inflatingInternal = false;
        setMinimumHeight(Math.max(getMinimumHeight(), getResources().getDimensionPixelSize(R.dimen.stepos_swipe_action_touch_min)));
        getAction().setPaddingRelative(dimensionPixelSize - (dimensionPixelSize / 2), 0, dimensionPixelSize / 2, 0);
        for (ImageView imageView : imageViewArr) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            p.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
            layoutParams2.setMarginStart(this.iconGap / 2);
            int i12 = this.iconGap;
            layoutParams2.setMarginEnd(i12 - (i12 / 2));
            imageView.setLayoutParams(layoutParams2);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.StepOSSwipeActionLayout, i10, i11);
        try {
            setSwipePrimaryIcon(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSwipeActionLayout_steposSwipePrimaryIcon));
            setSwipeSecondaryIcon(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSwipeActionLayout_steposSwipeSecondaryIcon));
            setSwipePrimaryContentDescription(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSwipeActionLayout_steposSwipePrimaryContentDescription));
            setSwipeSecondaryContentDescription(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSwipeActionLayout_steposSwipeSecondaryContentDescription));
            setSwipeDeleteIcon(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSwipeActionLayout_steposSwipeDeleteIcon));
            setSwipeDeleteIconTint(typedArrayObtainStyledAttributes.getColorStateList(R.styleable.StepOSSwipeActionLayout_steposSwipeDeleteIconTint));
            setSwipeDeleteBackground(typedArrayObtainStyledAttributes.getDrawable(R.styleable.StepOSSwipeActionLayout_steposSwipeDeleteBackground));
            setSwipeDeleteContentDescription(typedArrayObtainStyledAttributes.getText(R.styleable.StepOSSwipeActionLayout_steposSwipeDeleteContentDescription));
            setSwipeEnabled(typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSSwipeActionLayout_steposSwipeEnabled, true));
            setSwipeActionCount(typedArrayObtainStyledAttributes.getInt(R.styleable.StepOSSwipeActionLayout_steposSwipeActionCount, 1));
            t tVar = t.f7040a;
            C4946a.a(typedArrayObtainStyledAttributes, null);
            int length = this.actionTargets.length;
            for (final int i13 = 0; i13 < length; i13++) {
                this.actionTargets[i13].setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.list.f
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view) {
                        StepOSSwipeActionLayout._init_$lambda$2(this.f31268a, i13, view);
                    }
                });
            }
            this.constructed = true;
            updateActionVisibility();
            updateActionAvailability();
        } finally {
        }
    }
}
