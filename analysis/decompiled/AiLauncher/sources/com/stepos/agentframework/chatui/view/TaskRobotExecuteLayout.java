package com.stepos.agentframework.chatui.view;

import Z8.C1173v;
import Z8.C1174w;
import android.animation.ValueAnimator;
import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;
import com.autonavi.aps.amapapi.config.Const;
import com.bumptech.glide.Glide;
import com.stepos.agentframework.R$drawable;
import com.stepos.agentframework.R$id;
import com.stepos.agentframework.R$layout;
import com.stepos.agentframework.R$string;
import com.stepos.agentframework.chatcore.utils.ExtKt;
import com.stepos.agentframework.chatui.TaskRobotExecuteThumbnailBean;
import com.stepos.agentframework.chatui.m2;
import com.stepos.agentframework.chatui.p2;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import f.C4027a;
import h8.C4148a;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.C4848b;
import kotlin.Metadata;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import v9.C5685n;

@Metadata(d1 = {"\u0000Ü\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0002\b\u0014\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u001e\u0018\u0000 õ\u00012\u00020\u0001:\u0004ö\u0001÷\u0001B\u001b\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u000f\u0010\t\u001a\u00020\bH\u0002¢\u0006\u0004\b\t\u0010\nJ\u0017\u0010\r\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\r\u0010\u000eJ\u000f\u0010\u000f\u001a\u00020\bH\u0002¢\u0006\u0004\b\u000f\u0010\nJ\u000f\u0010\u0010\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0010\u0010\nJ\u000f\u0010\u0011\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0011\u0010\nJ\u000f\u0010\u0012\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0012\u0010\nJ\u0017\u0010\u0013\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0013\u0010\u000eJ\u000f\u0010\u0014\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0014\u0010\nJ\u000f\u0010\u0015\u001a\u00020\u000bH\u0002¢\u0006\u0004\b\u0015\u0010\u0016J\u000f\u0010\u0017\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0017\u0010\nJ\u000f\u0010\u0018\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0018\u0010\nJ\u000f\u0010\u0019\u001a\u00020\bH\u0002¢\u0006\u0004\b\u0019\u0010\nJ\u000f\u0010\u001b\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u000f\u0010\u001d\u001a\u00020\bH\u0002¢\u0006\u0004\b\u001d\u0010\nJ\u000f\u0010\u001e\u001a\u00020\u001aH\u0002¢\u0006\u0004\b\u001e\u0010\u001cJ\u001f\u0010!\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020\u000bH\u0002¢\u0006\u0004\b!\u0010\"J\u000f\u0010#\u001a\u00020\bH\u0002¢\u0006\u0004\b#\u0010\nJ\u000f\u0010$\u001a\u00020\bH\u0002¢\u0006\u0004\b$\u0010\nJ\u000f\u0010%\u001a\u00020\bH\u0002¢\u0006\u0004\b%\u0010\nJ\u000f\u0010&\u001a\u00020\bH\u0002¢\u0006\u0004\b&\u0010\nJ\u000f\u0010'\u001a\u00020\bH\u0002¢\u0006\u0004\b'\u0010\nJ\u000f\u0010(\u001a\u00020\bH\u0002¢\u0006\u0004\b(\u0010\nJ\u000f\u0010)\u001a\u00020\bH\u0002¢\u0006\u0004\b)\u0010\nJ\u000f\u0010*\u001a\u00020\u000bH\u0002¢\u0006\u0004\b*\u0010\u0016J\u000f\u0010+\u001a\u00020\bH\u0002¢\u0006\u0004\b+\u0010\nJ\u0015\u0010-\u001a\u0004\u0018\u00010,*\u00020\u0002H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00100\u001a\u00020\b2\u0006\u0010/\u001a\u00020\u000bH\u0002¢\u0006\u0004\b0\u0010\u000eJ\u0011\u00102\u001a\u0004\u0018\u000101H\u0002¢\u0006\u0004\b2\u00103J\u0015\u00106\u001a\u00020\b2\u0006\u00105\u001a\u000204¢\u0006\u0004\b6\u00107J\u0015\u0010:\u001a\u00020\b2\u0006\u00109\u001a\u000208¢\u0006\u0004\b:\u0010;J\u001f\u0010>\u001a\u00020\b2\u0006\u0010<\u001a\u0002012\b\u0010=\u001a\u0004\u0018\u000101¢\u0006\u0004\b>\u0010?J\u000f\u0010@\u001a\u00020\bH\u0014¢\u0006\u0004\b@\u0010\nJ\u001b\u0010C\u001a\u00020\b2\f\u0010B\u001a\b\u0012\u0004\u0012\u0002010A¢\u0006\u0004\bC\u0010DJ\u0017\u0010E\u001a\u00020\b2\b\u0010<\u001a\u0004\u0018\u000101¢\u0006\u0004\bE\u0010FJ\u0017\u0010H\u001a\u00020\b2\b\u0010G\u001a\u0004\u0018\u000101¢\u0006\u0004\bH\u0010FJ\u0017\u0010J\u001a\u00020\b2\b\u0010I\u001a\u0004\u0018\u000101¢\u0006\u0004\bJ\u0010FJ\u0015\u0010L\u001a\u00020\b2\u0006\u0010K\u001a\u000201¢\u0006\u0004\bL\u0010FJ\u001b\u0010N\u001a\u00020\b2\f\u0010M\u001a\b\u0012\u0004\u0012\u0002010A¢\u0006\u0004\bN\u0010DJ\r\u0010O\u001a\u00020\b¢\u0006\u0004\bO\u0010\nJ\r\u0010P\u001a\u00020\b¢\u0006\u0004\bP\u0010\nJ\r\u0010Q\u001a\u00020\b¢\u0006\u0004\bQ\u0010\nJ\u001d\u0010T\u001a\u00020\b2\u0006\u0010R\u001a\u00020\u001a2\u0006\u0010S\u001a\u00020\u001a¢\u0006\u0004\bT\u0010UR\"\u0010W\u001a\u00020V8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bW\u0010X\u001a\u0004\bY\u0010Z\"\u0004\b[\u0010\\R\"\u0010^\u001a\u00020]8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b^\u0010_\u001a\u0004\b`\u0010a\"\u0004\bb\u0010cR\"\u0010e\u001a\u00020d8\u0006@\u0006X\u0086.¢\u0006\u0012\n\u0004\be\u0010f\u001a\u0004\bg\u0010h\"\u0004\bi\u0010jR$\u0010l\u001a\u0004\u0018\u00010k8\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bl\u0010m\u001a\u0004\bn\u0010o\"\u0004\bp\u0010qR$\u0010r\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\br\u0010s\u001a\u0004\bt\u00103\"\u0004\bu\u0010FR$\u0010v\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bv\u0010s\u001a\u0004\bw\u00103\"\u0004\bx\u0010FR$\u0010y\u001a\u0004\u0018\u0001018\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\by\u0010s\u001a\u0004\bz\u00103\"\u0004\b{\u0010FR%\u0010}\u001a\u00020|8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0004\b}\u0010~\u001a\u0005\b\u007f\u0010\u0080\u0001\"\u0006\b\u0081\u0001\u0010\u0082\u0001R*\u0010\u0084\u0001\u001a\u00030\u0083\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u0084\u0001\u0010\u0085\u0001\u001a\u0006\b\u0086\u0001\u0010\u0087\u0001\"\u0006\b\u0088\u0001\u0010\u0089\u0001R*\u0010\u008a\u0001\u001a\u00030\u0083\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b\u008a\u0001\u0010\u0085\u0001\u001a\u0006\b\u008b\u0001\u0010\u0087\u0001\"\u0006\b\u008c\u0001\u0010\u0089\u0001R\u001b\u0010\u008d\u0001\u001a\u0004\u0018\u0001088\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008d\u0001\u0010\u008e\u0001R\u001c\u0010\u0090\u0001\u001a\u0005\u0018\u00010\u008f\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0090\u0001\u0010\u0091\u0001R\u001c\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0092\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0093\u0001\u0010\u0094\u0001R0\u0010\u0096\u0001\u001a\u00020\u001a2\u0007\u0010\u0095\u0001\u001a\u00020\u001a8\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0005\b\u0096\u0001\u0010>\u001a\u0005\b\u0097\u0001\u0010\u001c\"\u0006\b\u0098\u0001\u0010\u0099\u0001R\u0018\u0010\u009b\u0001\u001a\u00030\u009a\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u009b\u0001\u0010\u009c\u0001R&\u0010\u009d\u0001\u001a\u00020V8\u0006@\u0006X\u0086\u000e¢\u0006\u0015\n\u0005\b\u009d\u0001\u0010X\u001a\u0005\b\u009e\u0001\u0010Z\"\u0005\b\u009f\u0001\u0010\\R\u0017\u0010¡\u0001\u001a\u00030 \u00018\u0002X\u0082D¢\u0006\u0007\n\u0005\b¡\u0001\u0010&R!\u0010§\u0001\u001a\u00030¢\u00018BX\u0082\u0084\u0002¢\u0006\u0010\n\u0006\b£\u0001\u0010¤\u0001\u001a\u0006\b¥\u0001\u0010¦\u0001R\u0018\u0010©\u0001\u001a\u00030¨\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b©\u0001\u0010ª\u0001R\u0018\u0010«\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b«\u0001\u0010\u000fR\u0018\u0010¬\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¬\u0001\u0010\u000fR\u0018\u0010\u00ad\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u00ad\u0001\u0010\u000fR\u0018\u0010®\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b®\u0001\u0010\u000fR\u0018\u0010¯\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010\u000fR\u0019\u0010°\u0001\u001a\u00030 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b°\u0001\u0010&R\u0019\u0010±\u0001\u001a\u00030 \u00018\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b±\u0001\u0010&R\u0018\u0010²\u0001\u001a\u00020\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b²\u0001\u0010\u000fR*\u0010´\u0001\u001a\u00030³\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b´\u0001\u0010µ\u0001\u001a\u0006\b¶\u0001\u0010·\u0001\"\u0006\b¸\u0001\u0010¹\u0001R\u0019\u0010º\u0001\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bº\u0001\u0010\u008e\u0001R\u0019\u0010»\u0001\u001a\u0002088\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\b»\u0001\u0010\u008e\u0001R*\u0010½\u0001\u001a\u00030¼\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\b½\u0001\u0010¾\u0001\u001a\u0006\b¿\u0001\u0010À\u0001\"\u0006\bÁ\u0001\u0010Â\u0001R*\u0010Ä\u0001\u001a\u00030Ã\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÄ\u0001\u0010Å\u0001\u001a\u0006\bÆ\u0001\u0010Ç\u0001\"\u0006\bÈ\u0001\u0010É\u0001R\u0019\u0010Ê\u0001\u001a\u00020\u00018\u0002@\u0002X\u0082.¢\u0006\b\n\u0006\bÊ\u0001\u0010Ë\u0001R*\u0010Ì\u0001\u001a\u00030\u0083\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÌ\u0001\u0010\u0085\u0001\u001a\u0006\bÍ\u0001\u0010\u0087\u0001\"\u0006\bÎ\u0001\u0010\u0089\u0001R*\u0010Ï\u0001\u001a\u00030\u0083\u00018\u0006@\u0006X\u0086.¢\u0006\u0018\n\u0006\bÏ\u0001\u0010\u0085\u0001\u001a\u0006\bÐ\u0001\u0010\u0087\u0001\"\u0006\bÑ\u0001\u0010\u0089\u0001R\u0018\u0010Ò\u0001\u001a\u00020|8\u0002@\u0002X\u0082.¢\u0006\u0007\n\u0005\bÒ\u0001\u0010~R2\u0010Ô\u0001\u001a\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010Ó\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÔ\u0001\u0010Õ\u0001\u001a\u0006\bÖ\u0001\u0010×\u0001\"\u0006\bØ\u0001\u0010Ù\u0001R8\u0010Û\u0001\u001a\u0011\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010Ú\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010Ü\u0001\u001a\u0006\bÝ\u0001\u0010Þ\u0001\"\u0006\bß\u0001\u0010à\u0001R2\u0010á\u0001\u001a\u000b\u0012\u0004\u0012\u00020\b\u0018\u00010Ó\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bá\u0001\u0010Õ\u0001\u001a\u0006\bâ\u0001\u0010×\u0001\"\u0006\bã\u0001\u0010Ù\u0001R8\u0010ä\u0001\u001a\u0011\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\b\u0018\u00010Ú\u00018\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bä\u0001\u0010Ü\u0001\u001a\u0006\bå\u0001\u0010Þ\u0001\"\u0006\bæ\u0001\u0010à\u0001R/\u0010ç\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\bç\u0001\u0010\u000f\u001a\u0005\bè\u0001\u0010\u0016\"\u0005\bé\u0001\u0010\u000eR(\u0010ê\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b8\u0002@BX\u0082\u000e¢\u0006\u000e\n\u0005\bê\u0001\u0010\u000f\"\u0005\bë\u0001\u0010\u000eR\u0018\u0010ì\u0001\u001a\u00020\u001a8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bì\u0001\u0010>R/\u0010í\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\bí\u0001\u0010\u000f\u001a\u0005\bí\u0001\u0010\u0016\"\u0005\bî\u0001\u0010\u000eR/\u0010ï\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\bï\u0001\u0010\u000f\u001a\u0005\bð\u0001\u0010\u0016\"\u0005\bñ\u0001\u0010\u000eR/\u0010ò\u0001\u001a\u00020\u000b2\u0007\u0010\u0095\u0001\u001a\u00020\u000b8\u0006@FX\u0086\u000e¢\u0006\u0015\n\u0005\bò\u0001\u0010\u000f\u001a\u0005\bó\u0001\u0010\u0016\"\u0005\bô\u0001\u0010\u000e¨\u0006ø\u0001"}, d2 = {"Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout;", "Landroid/widget/LinearLayout;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "LY8/t;", "u", "()V", "", "needShow", "Y", "(Z)V", "Z", "N", "J", ExifInterface.LATITUDE_SOUTH, "e0", "c0", "O", "()Z", "d0", "L", "G", "", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "()I", ExifInterface.GPS_DIRECTION_TRUE, "B", "index", "smoothScroll", "b0", "(IZ)V", "v", "w", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "F", "a0", "Q", "R", "C", "P", "Landroid/app/Activity;", "y", "(Landroid/content/Context;)Landroid/app/Activity;", "clickable", "setRobotContainerClickable", "", "z", "()Ljava/lang/String;", "Lcom/stepos/agentframework/chatui/appui/taskrobot/b;", "surfaceView", "setSurfaceView", "(Lcom/stepos/agentframework/chatui/appui/taskrobot/b;)V", "Landroid/view/View;", "renderView", "setRenderView", "(Landroid/view/View;)V", "taskId", "errorMessage", "I", "(Ljava/lang/String;Ljava/lang/String;)V", "onDetachedFromWindow", "", "images", "setExecuteImages", "(Ljava/util/List;)V", "setTaskId", "(Ljava/lang/String;)V", "statusText", ExifInterface.LONGITUDE_WEST, "stepText", "X", "imagePath", "s", "newImages", "t", "D", ExifInterface.LONGITUDE_EAST, "x", "width", "height", "H", "(II)V", "Landroidx/cardview/widget/CardView;", "appUILayout", "Landroidx/cardview/widget/CardView;", "getAppUILayout", "()Landroidx/cardview/widget/CardView;", "setAppUILayout", "(Landroidx/cardview/widget/CardView;)V", "Landroidx/viewpager2/widget/ViewPager2;", "executeImagesViewPager", "Landroidx/viewpager2/widget/ViewPager2;", "getExecuteImagesViewPager", "()Landroidx/viewpager2/widget/ViewPager2;", "setExecuteImagesViewPager", "(Landroidx/viewpager2/widget/ViewPager2;)V", "Lcom/stepos/agentframework/chatui/p2;", "adapter", "Lcom/stepos/agentframework/chatui/p2;", "getAdapter", "()Lcom/stepos/agentframework/chatui/p2;", "setAdapter", "(Lcom/stepos/agentframework/chatui/p2;)V", "Lcom/stepos/agentframework/chatui/view/N;", "errorListener", "Lcom/stepos/agentframework/chatui/view/N;", "getErrorListener", "()Lcom/stepos/agentframework/chatui/view/N;", "setErrorListener", "(Lcom/stepos/agentframework/chatui/view/N;)V", "currentTaskId", "Ljava/lang/String;", "getCurrentTaskId", "setCurrentTaskId", "currentErrorMessage", "getCurrentErrorMessage", "setCurrentErrorMessage", "latestScreenshotPath", "getLatestScreenshotPath", "setLatestScreenshotPath", "Landroid/widget/ImageView;", "ivExecuteStatus", "Landroid/widget/ImageView;", "getIvExecuteStatus", "()Landroid/widget/ImageView;", "setIvExecuteStatus", "(Landroid/widget/ImageView;)V", "Landroid/widget/TextView;", "tvExecuteStatus", "Landroid/widget/TextView;", "getTvExecuteStatus", "()Landroid/widget/TextView;", "setTvExecuteStatus", "(Landroid/widget/TextView;)V", "tvExecuteStep", "getTvExecuteStep", "setTvExecuteStep", "pipRenderView", "Landroid/view/View;", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f;", "textureView", "Lcom/stepos/agentframework/chatui/appui/taskrobot/f;", "Landroid/animation/ValueAnimator;", "executeStatusLoadingAnimator", "Landroid/animation/ValueAnimator;", UxipConstants.f30680s, "executeStatus", "getExecuteStatus", "setExecuteStatus", "(I)V", "Landroidx/constraintlayout/widget/ConstraintLayout;", "taskRobotRoot", "Landroidx/constraintlayout/widget/ConstraintLayout;", "robotContainer", "getRobotContainer", "setRobotContainer", "", "thumbnailItemWidthDp", "Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout$b;", "thumbnailLayoutManager$delegate", "LY8/h;", "getThumbnailLayoutManager", "()Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout$b;", "thumbnailLayoutManager", "Landroidx/recyclerview/widget/LinearSnapHelper;", "thumbnailSnapHelper", "Landroidx/recyclerview/widget/LinearSnapHelper;", "isSyncingFromTimeline", "isSyncingFromPager", "hasAttachedSnapHelper", "isTimelineScrollListenerAdded", "isTimelineScrollable", "indicatorDownRawX", "indicatorStartX", "isDraggingIndicator", "Landroid/widget/FrameLayout;", "thumbnailTimeline", "Landroid/widget/FrameLayout;", "getThumbnailTimeline", "()Landroid/widget/FrameLayout;", "setThumbnailTimeline", "(Landroid/widget/FrameLayout;)V", "timelineIndicator", "line", "Landroidx/recyclerview/widget/RecyclerView;", "thumbnailRecyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "getThumbnailRecyclerView", "()Landroidx/recyclerview/widget/RecyclerView;", "setThumbnailRecyclerView", "(Landroidx/recyclerview/widget/RecyclerView;)V", "Lcom/stepos/agentframework/chatui/m2;", "thumbnailAdapter", "Lcom/stepos/agentframework/chatui/m2;", "getThumbnailAdapter", "()Lcom/stepos/agentframework/chatui/m2;", "setThumbnailAdapter", "(Lcom/stepos/agentframework/chatui/m2;)V", "llExecutingActions", "Landroid/widget/LinearLayout;", "btnStopTask", "getBtnStopTask", "setBtnStopTask", "btnTakeoverTask", "getBtnTakeoverTask", "setBtnTakeoverTask", "ivArrowRight", "Lkotlin/Function0;", "onStopTaskClick", "Lp9/a;", "getOnStopTaskClick", "()Lp9/a;", "setOnStopTaskClick", "(Lp9/a;)V", "Lkotlin/Function1;", "onTakeoverTaskClick", "Lp9/l;", "getOnTakeoverTaskClick", "()Lp9/l;", "setOnTakeoverTaskClick", "(Lp9/l;)V", "onRobotContainerClick", "getOnRobotContainerClick", "setOnRobotContainerClick", "onCanceledStateApplied", "getOnCanceledStateApplied", "setOnCanceledStateApplied", "showLlmTakeoverActions", "getShowLlmTakeoverActions", "setShowLlmTakeoverActions", "isUserTakeoverActive", "setUserTakeoverActive", "currentImageIndex", "isCollapsedForForegroundApp", "setCollapsedForForegroundApp", "hideExecuteStatusStep", "getHideExecuteStatusStep", "setHideExecuteStatusStep", "pureVirtualScreen", "getPureVirtualScreen", "setPureVirtualScreen", "Companion", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class TaskRobotExecuteLayout extends LinearLayout {
    public static final int STATUS_CANCELED = 5;
    public static final int STATUS_COMPLETED = 2;
    public static final int STATUS_ERROR = -1;
    public static final int STATUS_EXECUTING_BACKEND = 4;
    public static final int STATUS_EXECUTING_FRONT = 3;
    public static final int STATUS_EXECUTING_PIP = 1;
    public static final int STATUS_NOT_STARTED = 0;
    public p2 adapter;
    private CardView appUILayout;
    public TextView btnStopTask;
    public TextView btnTakeoverTask;
    private String currentErrorMessage;
    private int currentImageIndex;
    private String currentTaskId;
    private N errorListener;
    private ViewPager2 executeImagesViewPager;
    private int executeStatus;
    private ValueAnimator executeStatusLoadingAnimator;
    private boolean hasAttachedSnapHelper;
    private boolean hideExecuteStatusStep;
    private float indicatorDownRawX;
    private float indicatorStartX;
    private boolean isCollapsedForForegroundApp;
    private boolean isDraggingIndicator;
    private boolean isSyncingFromPager;
    private boolean isSyncingFromTimeline;
    private boolean isTimelineScrollListenerAdded;
    private boolean isTimelineScrollable;
    private boolean isUserTakeoverActive;
    private ImageView ivArrowRight;
    private ImageView ivExecuteStatus;
    private String latestScreenshotPath;
    private View line;
    private LinearLayout llExecutingActions;
    private InterfaceC5074l<? super String, Y8.t> onCanceledStateApplied;
    private InterfaceC5063a<Y8.t> onRobotContainerClick;
    private InterfaceC5063a<Y8.t> onStopTaskClick;
    private InterfaceC5074l<? super Boolean, Y8.t> onTakeoverTaskClick;
    private View pipRenderView;
    private boolean pureVirtualScreen;
    private CardView robotContainer;
    private boolean showLlmTakeoverActions;
    private final ConstraintLayout taskRobotRoot;
    private com.stepos.agentframework.chatui.appui.taskrobot.f textureView;
    public m2 thumbnailAdapter;
    private final float thumbnailItemWidthDp;

    /* renamed from: thumbnailLayoutManager$delegate, reason: from kotlin metadata */
    private final Y8.h thumbnailLayoutManager;
    private RecyclerView thumbnailRecyclerView;
    private final LinearSnapHelper thumbnailSnapHelper;
    private FrameLayout thumbnailTimeline;
    private View timelineIndicator;
    private TextView tvExecuteStatus;
    private TextView tvExecuteStep;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\u0007\u0010\bR\"\u0010\t\u001a\u00020\u00068\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/stepos/agentframework/chatui/view/TaskRobotExecuteLayout$b;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroid/content/Context;", "context", "<init>", "(Landroid/content/Context;)V", "", "canScrollHorizontally", "()Z", "userScrollEnabled", "Z", "getUserScrollEnabled", "u", "(Z)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends LinearLayoutManager {
        private boolean userScrollEnabled;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Context context) {
            super(context, 0, false);
            kotlin.jvm.internal.p.i(context, "context");
            this.userScrollEnabled = true;
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public boolean canScrollHorizontally() {
            return this.userScrollEnabled && super.canScrollHorizontally();
        }

        public final void u(boolean z10) {
            this.userScrollEnabled = z10;
        }
    }

    @Metadata(d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J'\u0010\b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\b\u0010\tJ\u001f\u0010\u000b\u001a\u00020\u00072\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u000b\u0010\f¨\u0006\r"}, d2 = {"com/stepos/agentframework/chatui/view/TaskRobotExecuteLayout$c", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", "Landroidx/recyclerview/widget/RecyclerView;", "recyclerView", "", "dx", "dy", "LY8/t;", "onScrolled", "(Landroidx/recyclerview/widget/RecyclerView;II)V", "newState", "onScrollStateChanged", "(Landroidx/recyclerview/widget/RecyclerView;I)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.OnScrollListener {
        public c() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            super.onScrollStateChanged(recyclerView, newState);
            if (newState == 0) {
                TaskRobotExecuteLayout.this.S();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            kotlin.jvm.internal.p.i(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (!TaskRobotExecuteLayout.this.isTimelineScrollable || dx == 0) {
                return;
            }
            TaskRobotExecuteLayout.this.S();
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/agentframework/chatui/view/TaskRobotExecuteLayout$d", "Landroidx/viewpager2/widget/ViewPager2$i;", "", "position", "LY8/t;", "onPageSelected", "(I)V", "agentcore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class d extends ViewPager2.i {
        public d() {
        }

        @Override // androidx.viewpager2.widget.ViewPager2.i
        public void onPageSelected(int position) {
            if (TaskRobotExecuteLayout.this.isSyncingFromTimeline) {
                return;
            }
            TaskRobotExecuteLayout.this.isSyncingFromPager = true;
            TaskRobotExecuteLayout.this.b0(position, true);
            TaskRobotExecuteLayout.this.isSyncingFromPager = false;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TaskRobotExecuteLayout(final Context context, AttributeSet attributeSet) throws IllegalStateException {
        super(context, attributeSet);
        kotlin.jvm.internal.p.i(context, "context");
        this.thumbnailItemWidthDp = 22.0f;
        this.thumbnailLayoutManager = C4848b.b(new InterfaceC5063a() { // from class: com.stepos.agentframework.chatui.view.f0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TaskRobotExecuteLayout.U(context);
            }
        });
        this.thumbnailSnapHelper = new LinearSnapHelper();
        this.isTimelineScrollable = true;
        LayoutInflater.from(context).inflate(R$layout.layout_task_robot_execute, this);
        View viewFindViewById = findViewById(R$id.cl_preview_area);
        kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
        this.appUILayout = (CardView) viewFindViewById;
        View viewFindViewById2 = findViewById(R$id.robot_container);
        kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
        this.robotContainer = (CardView) viewFindViewById2;
        View viewFindViewById3 = findViewById(R$id.fl_thumbnail_timeline);
        kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
        this.thumbnailTimeline = (FrameLayout) viewFindViewById3;
        View viewFindViewById4 = findViewById(R$id.view_timeline_indicator);
        kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
        this.timelineIndicator = viewFindViewById4;
        View viewFindViewById5 = findViewById(R$id.rv_thumbnail);
        kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
        this.thumbnailRecyclerView = (RecyclerView) viewFindViewById5;
        View viewFindViewById6 = findViewById(R$id.ll_executing_actions);
        kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
        this.llExecutingActions = (LinearLayout) viewFindViewById6;
        View viewFindViewById7 = findViewById(R$id.btn_stop);
        kotlin.jvm.internal.p.h(viewFindViewById7, "findViewById(...)");
        setBtnStopTask((TextView) viewFindViewById7);
        View viewFindViewById8 = findViewById(R$id.btn_takeover);
        kotlin.jvm.internal.p.h(viewFindViewById8, "findViewById(...)");
        setBtnTakeoverTask((TextView) viewFindViewById8);
        this.robotContainer.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.g0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskRobotExecuteLayout.j(this.f23120a, view);
            }
        });
        getBtnStopTask().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.h0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskRobotExecuteLayout.k(this.f23121a, view);
            }
        });
        getBtnTakeoverTask().setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.i0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskRobotExecuteLayout.l(this.f23123a, view);
            }
        });
        a0();
        View viewFindViewById9 = findViewById(R$id.task_robot_root);
        kotlin.jvm.internal.p.h(viewFindViewById9, "findViewById(...)");
        this.taskRobotRoot = (ConstraintLayout) viewFindViewById9;
        View viewFindViewById10 = findViewById(R$id.execute_image_viewpager);
        kotlin.jvm.internal.p.h(viewFindViewById10, "findViewById(...)");
        this.executeImagesViewPager = (ViewPager2) viewFindViewById10;
        View viewFindViewById11 = findViewById(R$id.iv_execute_state);
        kotlin.jvm.internal.p.h(viewFindViewById11, "findViewById(...)");
        this.ivExecuteStatus = (ImageView) viewFindViewById11;
        View viewFindViewById12 = findViewById(R$id.tv_execute_status);
        kotlin.jvm.internal.p.h(viewFindViewById12, "findViewById(...)");
        this.tvExecuteStatus = (TextView) viewFindViewById12;
        View viewFindViewById13 = findViewById(R$id.tv_execute_step);
        kotlin.jvm.internal.p.h(viewFindViewById13, "findViewById(...)");
        TextView textView = (TextView) viewFindViewById13;
        this.tvExecuteStep = textView;
        ExtKt.m(textView);
        View viewFindViewById14 = findViewById(R$id.iv_arrow_right);
        kotlin.jvm.internal.p.h(viewFindViewById14, "findViewById(...)");
        this.ivArrowRight = (ImageView) viewFindViewById14;
        View viewFindViewById15 = findViewById(R$id.line);
        kotlin.jvm.internal.p.h(viewFindViewById15, "findViewById(...)");
        this.line = viewFindViewById15;
        ImageView imageView = this.ivArrowRight;
        if (imageView == null) {
            kotlin.jvm.internal.p.A("ivArrowRight");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.agentframework.chatui.view.j0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TaskRobotExecuteLayout.m(this.f23125a, view);
            }
        });
        J();
        N();
        L();
    }

    public static final Y8.t K(TaskRobotExecuteLayout taskRobotExecuteLayout, TaskRobotExecuteThumbnailBean taskRobotExecuteThumbnailBean, int i10) {
        kotlin.jvm.internal.p.i(taskRobotExecuteThumbnailBean, "<unused var>");
        if (taskRobotExecuteLayout.getAdapter().getItemCount() == 0 || taskRobotExecuteLayout.C()) {
            return Y8.t.f7040a;
        }
        taskRobotExecuteLayout.isSyncingFromTimeline = true;
        taskRobotExecuteLayout.currentImageIndex = i10;
        taskRobotExecuteLayout.executeImagesViewPager.m(i10, false);
        taskRobotExecuteLayout.b0(i10, true);
        taskRobotExecuteLayout.isSyncingFromTimeline = false;
        return Y8.t.f7040a;
    }

    public static final boolean M(TaskRobotExecuteLayout taskRobotExecuteLayout, View view, MotionEvent motionEvent) {
        if (!taskRobotExecuteLayout.O() || taskRobotExecuteLayout.getThumbnailAdapter().getItemCount() == 0) {
            return false;
        }
        int actionMasked = motionEvent.getActionMasked();
        View view2 = null;
        if (actionMasked == 0) {
            taskRobotExecuteLayout.indicatorDownRawX = motionEvent.getRawX();
            View view3 = taskRobotExecuteLayout.timelineIndicator;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("timelineIndicator");
            } else {
                view2 = view3;
            }
            taskRobotExecuteLayout.indicatorStartX = view2.getX();
            taskRobotExecuteLayout.isDraggingIndicator = true;
            ViewParent parent = taskRobotExecuteLayout.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
            return true;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                float rawX = taskRobotExecuteLayout.indicatorStartX + (motionEvent.getRawX() - taskRobotExecuteLayout.indicatorDownRawX);
                int width = taskRobotExecuteLayout.thumbnailTimeline.getWidth();
                View view4 = taskRobotExecuteLayout.timelineIndicator;
                if (view4 == null) {
                    kotlin.jvm.internal.p.A("timelineIndicator");
                    view4 = null;
                }
                float fM = C5685n.m(rawX, 0.0f, C5685n.f(width - view4.getWidth(), 0));
                View view5 = taskRobotExecuteLayout.timelineIndicator;
                if (view5 == null) {
                    kotlin.jvm.internal.p.A("timelineIndicator");
                } else {
                    view2 = view5;
                }
                view2.setX(fM);
                taskRobotExecuteLayout.T();
                return true;
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        taskRobotExecuteLayout.isDraggingIndicator = false;
        ViewParent parent2 = taskRobotExecuteLayout.getParent();
        if (parent2 != null) {
            parent2.requestDisallowInterceptTouchEvent(false);
        }
        taskRobotExecuteLayout.T();
        return true;
    }

    public static final b U(Context context) {
        return new b(context);
    }

    public static final void f0(TaskRobotExecuteLayout taskRobotExecuteLayout) {
        taskRobotExecuteLayout.d0();
        taskRobotExecuteLayout.b0(taskRobotExecuteLayout.currentImageIndex, false);
    }

    private final b getThumbnailLayoutManager() {
        return (b) this.thumbnailLayoutManager.getValue();
    }

    public static final void j(TaskRobotExecuteLayout taskRobotExecuteLayout, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = taskRobotExecuteLayout.onRobotContainerClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void k(TaskRobotExecuteLayout taskRobotExecuteLayout, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = taskRobotExecuteLayout.onStopTaskClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    public static final void l(TaskRobotExecuteLayout taskRobotExecuteLayout, View view) {
        InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l = taskRobotExecuteLayout.onTakeoverTaskClick;
        if (interfaceC5074l != null) {
            interfaceC5074l.invoke(Boolean.valueOf(taskRobotExecuteLayout.isUserTakeoverActive));
        }
    }

    public static final void m(TaskRobotExecuteLayout taskRobotExecuteLayout, View view) {
        InterfaceC5063a<Y8.t> interfaceC5063a = taskRobotExecuteLayout.onRobotContainerClick;
        if (interfaceC5063a != null) {
            interfaceC5063a.invoke();
        }
    }

    private final void setRobotContainerClickable(boolean clickable) {
        this.robotContainer.setClickable(clickable);
        this.robotContainer.setEnabled(clickable);
    }

    private final void setUserTakeoverActive(boolean z10) {
        if (this.isUserTakeoverActive == z10) {
            return;
        }
        this.isUserTakeoverActive = z10;
        a0();
        F();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupThumbnailTimeline$lambda$1(TaskRobotExecuteLayout taskRobotExecuteLayout) {
        taskRobotExecuteLayout.d0();
        taskRobotExecuteLayout.G();
    }

    public final int A() {
        int childAdapterPosition;
        if (getThumbnailAdapter().getItemCount() == 0) {
            return -1;
        }
        View view = this.timelineIndicator;
        View view2 = null;
        if (view == null) {
            kotlin.jvm.internal.p.A("timelineIndicator");
            view = null;
        }
        float x10 = view.getX();
        View view3 = this.timelineIndicator;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("timelineIndicator");
        } else {
            view2 = view3;
        }
        View viewFindChildViewUnder = this.thumbnailRecyclerView.findChildViewUnder((x10 + (view2.getWidth() / 2.0f)) - this.thumbnailRecyclerView.getX(), this.thumbnailRecyclerView.getHeight() / 2.0f);
        if (viewFindChildViewUnder != null && (childAdapterPosition = this.thumbnailRecyclerView.getChildAdapterPosition(viewFindChildViewUnder)) != -1) {
            return childAdapterPosition;
        }
        View viewFindSnapView = this.thumbnailSnapHelper.findSnapView(getThumbnailLayoutManager());
        if (viewFindSnapView == null) {
            return -1;
        }
        return getThumbnailLayoutManager().getPosition(viewFindSnapView);
    }

    public final int B() {
        if (getThumbnailAdapter().getItemCount() == 0) {
            return -1;
        }
        if (getThumbnailAdapter().getItemCount() == 1) {
            return 0;
        }
        int width = this.thumbnailTimeline.getWidth();
        View view = this.timelineIndicator;
        View view2 = null;
        if (view == null) {
            kotlin.jvm.internal.p.A("timelineIndicator");
            view = null;
        }
        int iF = C5685n.f(width - view.getWidth(), 0);
        if (iF <= 0) {
            return C5685n.n(this.currentImageIndex, 0, getThumbnailAdapter().getItemCount() - 1);
        }
        View view3 = this.timelineIndicator;
        if (view3 == null) {
            kotlin.jvm.internal.p.A("timelineIndicator");
        } else {
            view2 = view3;
        }
        return C5685n.n(C5227b.b(C5685n.m(view2.getX() / iF, 0.0f, 1.0f) * (getThumbnailAdapter().getItemCount() - 1)), 0, getThumbnailAdapter().getItemCount() - 1);
    }

    public final boolean C() {
        int i10 = this.executeStatus;
        return i10 == 1 || i10 == 3 || i10 == 4;
    }

    public final void D() {
        setShowLlmTakeoverActions(true);
    }

    public final void E() {
        setShowLlmTakeoverActions(true);
        setUserTakeoverActive(true);
    }

    public final void F() {
        LinearLayout linearLayout = null;
        if (this.showLlmTakeoverActions && C()) {
            LinearLayout linearLayout2 = this.llExecutingActions;
            if (linearLayout2 == null) {
                kotlin.jvm.internal.p.A("llExecutingActions");
            } else {
                linearLayout = linearLayout2;
            }
            ExtKt.C(linearLayout);
            return;
        }
        LinearLayout linearLayout3 = this.llExecutingActions;
        if (linearLayout3 == null) {
            kotlin.jvm.internal.p.A("llExecutingActions");
        } else {
            linearLayout = linearLayout3;
        }
        ExtKt.m(linearLayout);
    }

    public final void G() {
        if (this.thumbnailTimeline.getWidth() > 0) {
            View view = this.timelineIndicator;
            View view2 = null;
            if (view == null) {
                kotlin.jvm.internal.p.A("timelineIndicator");
                view = null;
            }
            if (view.getWidth() <= 0) {
                return;
            }
            View view3 = this.timelineIndicator;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("timelineIndicator");
                view3 = null;
            }
            int width = this.thumbnailTimeline.getWidth();
            View view4 = this.timelineIndicator;
            if (view4 == null) {
                kotlin.jvm.internal.p.A("timelineIndicator");
            } else {
                view2 = view4;
            }
            view3.setX(C5685n.e((width - view2.getWidth()) / 2.0f, 0.0f));
        }
    }

    public final void H(int width, int height) {
        com.stepos.agentframework.chatui.appui.taskrobot.f fVar;
        int i10 = (int) (8 * getResources().getDisplayMetrics().density);
        ConstraintLayout.b bVar = new ConstraintLayout.b(-2, -2);
        bVar.f12664t = 0;
        bVar.f12668v = 0;
        int i11 = R$id.tv_execute_step;
        bVar.f12644j = i11;
        ((ViewGroup.MarginLayoutParams) bVar).topMargin = i10;
        bVar.f12672x = i10;
        this.appUILayout.setLayoutParams(bVar);
        ConstraintLayout.b bVar2 = new ConstraintLayout.b(width, height);
        bVar2.f12664t = 0;
        bVar2.f12668v = 0;
        bVar2.f12644j = i11;
        this.robotContainer.setLayoutParams(bVar2);
        if (this.executeStatus == 1 && (fVar = this.textureView) != null) {
            fVar.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            fVar.requestLayout();
        }
        ConstraintLayout.b bVar3 = new ConstraintLayout.b(width, height);
        bVar3.f12664t = 0;
        bVar3.f12668v = 0;
        bVar3.f12644j = i11;
        this.executeImagesViewPager.setLayoutParams(bVar3);
    }

    public final void I(String taskId, String errorMessage) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.currentTaskId = taskId;
        this.currentErrorMessage = errorMessage;
    }

    public final void J() throws IllegalStateException {
        setThumbnailAdapter(new m2(new p9.p() { // from class: com.stepos.agentframework.chatui.view.l0
            @Override // p9.p
            public final Object invoke(Object obj, Object obj2) {
                return TaskRobotExecuteLayout.K(this.f23128a, (TaskRobotExecuteThumbnailBean) obj, ((Integer) obj2).intValue());
            }
        }));
        this.thumbnailRecyclerView.setLayoutManager(getThumbnailLayoutManager());
        this.thumbnailRecyclerView.setAdapter(getThumbnailAdapter());
        this.thumbnailRecyclerView.setItemAnimator(null);
        if (!this.hasAttachedSnapHelper) {
            this.thumbnailSnapHelper.attachToRecyclerView(this.thumbnailRecyclerView);
            this.hasAttachedSnapHelper = true;
        }
        if (!this.isTimelineScrollListenerAdded) {
            this.thumbnailRecyclerView.addOnScrollListener(new c());
            this.isTimelineScrollListenerAdded = true;
        }
        this.thumbnailRecyclerView.post(new Runnable() { // from class: com.stepos.agentframework.chatui.view.m0
            @Override // java.lang.Runnable
            public final void run() {
                TaskRobotExecuteLayout.setupThumbnailTimeline$lambda$1(this.f23130a);
            }
        });
    }

    public final void L() {
        View view = this.timelineIndicator;
        if (view == null) {
            kotlin.jvm.internal.p.A("timelineIndicator");
            view = null;
        }
        view.setOnTouchListener(new View.OnTouchListener() { // from class: com.stepos.agentframework.chatui.view.n0
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view2, MotionEvent motionEvent) {
                return TaskRobotExecuteLayout.M(this.f23132a, view2, motionEvent);
            }
        });
    }

    public final void N() {
        setAdapter(new p2());
        this.executeImagesViewPager.setAdapter(getAdapter());
        this.executeImagesViewPager.setOffscreenPageLimit(2);
        this.executeImagesViewPager.j(new d());
        this.executeImagesViewPager.setCurrentItem(0);
        this.executeImagesViewPager.setForeground(C4027a.b(getContext(), R$drawable.fg_task_robot_img));
    }

    public final boolean O() {
        return this.executeStatus == 2;
    }

    public final void P() {
        Y(false);
        String strZ = z();
        if (strZ == null || La.H.x0(strZ)) {
            this.robotContainer.removeAllViews();
            ExtKt.m(this.robotContainer);
            setRobotContainerClickable(false);
            ExtKt.m(this.appUILayout);
            return;
        }
        ExtKt.C(this.appUILayout);
        this.robotContainer.removeAllViews();
        AppCompatImageView appCompatImageView = new AppCompatImageView(getContext());
        appCompatImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
        appCompatImageView.setAdjustViewBounds(true);
        this.robotContainer.addView(appCompatImageView, new FrameLayout.LayoutParams(-1, -1));
        Context context = getContext();
        kotlin.jvm.internal.p.f(context);
        Activity activityY = y(context);
        if (activityY == null || !(activityY.isDestroyed() || activityY.isFinishing())) {
            Glide.with(context).load(strZ).placeholder(R$drawable.placeholder_task_robot_execute_img).into(appCompatImageView);
            ExtKt.C(this.robotContainer);
            setRobotContainerClickable(false);
        }
    }

    public final void Q() {
    }

    public final void R() {
    }

    public final void S() {
        int iA;
        if (this.isSyncingFromPager || getAdapter().getItemCount() == 0 || C() || (iA = A()) < 0 || iA >= getAdapter().getItemCount()) {
            return;
        }
        if (iA == this.executeImagesViewPager.getCurrentItem()) {
            getThumbnailAdapter().h(iA);
            this.currentImageIndex = iA;
            return;
        }
        this.isSyncingFromTimeline = true;
        this.currentImageIndex = iA;
        this.executeImagesViewPager.m(iA, false);
        getThumbnailAdapter().h(iA);
        this.isSyncingFromTimeline = false;
    }

    public final void T() {
        int iB;
        if (!this.isTimelineScrollable || this.isSyncingFromPager || getAdapter().getItemCount() == 0 || C() || (iB = B()) < 0 || iB >= getAdapter().getItemCount()) {
            return;
        }
        if (iB == this.executeImagesViewPager.getCurrentItem()) {
            getThumbnailAdapter().h(iB);
            this.currentImageIndex = iB;
            return;
        }
        this.isSyncingFromTimeline = true;
        this.currentImageIndex = iB;
        this.executeImagesViewPager.m(iB, false);
        b0(iB, false);
        this.isSyncingFromTimeline = false;
    }

    public final void V() {
        int i10 = this.executeStatus;
        if (i10 == -1) {
            P();
            this.ivExecuteStatus.setImageResource(R$drawable.ic_task_failed);
            R();
        } else if (i10 == 1) {
            ExtKt.C(this.appUILayout);
            Y(false);
            Z();
            this.ivExecuteStatus.setImageResource(R$drawable.ic_task_executing);
            Q();
        } else if (i10 == 3 || i10 == 4) {
            ExtKt.C(this.appUILayout);
            Y(false);
            this.ivExecuteStatus.setImageResource(R$drawable.ic_task_executing);
            Q();
        } else if (i10 != 5) {
            ExtKt.C(this.appUILayout);
            Y(true);
            this.robotContainer.removeAllViews();
            ExtKt.m(this.robotContainer);
            R();
            this.ivExecuteStatus.setImageResource(R$drawable.ic_task_finished);
        } else {
            String string = getContext().getString(R$string.task_manually_terminated);
            kotlin.jvm.internal.p.h(string, "getString(...)");
            X(string);
            P();
            this.ivExecuteStatus.setImageResource(R$drawable.ic_task_failed);
            R();
            InterfaceC5074l<? super String, Y8.t> interfaceC5074l = this.onCanceledStateApplied;
            if (interfaceC5074l != null) {
                interfaceC5074l.invoke(string);
            }
            x();
        }
        if (!C()) {
            setUserTakeoverActive(false);
            setShowLlmTakeoverActions(false);
        }
        F();
    }

    public final void W(String statusText) {
        if (statusText != null && !La.H.x0(statusText)) {
            this.tvExecuteStatus.setText(statusText);
        }
        if (this.hideExecuteStatusStep) {
            ExtKt.m(this.tvExecuteStatus);
        }
    }

    public final void X(String stepText) {
        if (this.hideExecuteStatusStep) {
            TextView textView = this.tvExecuteStep;
            if (stepText == null) {
                stepText = "";
            }
            textView.setText(stepText);
            ExtKt.m(this.tvExecuteStep);
            return;
        }
        if (stepText == null || La.H.x0(stepText)) {
            this.tvExecuteStep.setText("");
            ExtKt.m(this.tvExecuteStep);
        } else {
            this.tvExecuteStep.setText(stepText);
            ExtKt.C(this.tvExecuteStep);
        }
    }

    public final void Y(boolean needShow) {
        if (needShow) {
            ExtKt.C(this.executeImagesViewPager);
            e0(true);
        } else {
            ExtKt.p(this.executeImagesViewPager);
            ExtKt.m(this.thumbnailTimeline);
        }
    }

    public final void Z() {
        View view = this.pipRenderView;
        if (view == null) {
            return;
        }
        if (!kotlin.jvm.internal.p.d(view.getParent(), this.robotContainer)) {
            this.robotContainer.removeAllViews();
            this.robotContainer.addView(view, new FrameLayout.LayoutParams(-1, -1));
        }
        this.robotContainer.requestLayout();
        ExtKt.C(this.robotContainer);
        setRobotContainerClickable(true);
    }

    public final void a0() {
        getBtnTakeoverTask().setText(this.isUserTakeoverActive ? "退出接管" : "接管任务");
    }

    public final void b0(int index, boolean smoothScroll) {
        if (getThumbnailAdapter().getItemCount() == 0) {
            return;
        }
        int iN = C5685n.n(index, 0, getThumbnailAdapter().getItemCount() - 1);
        this.currentImageIndex = iN;
        getThumbnailAdapter().h(iN);
        if (this.isTimelineScrollable) {
            if (smoothScroll) {
                this.thumbnailRecyclerView.smoothScrollToPosition(iN);
            } else {
                getThumbnailLayoutManager().scrollToPositionWithOffset(iN, C5685n.f((this.thumbnailRecyclerView.getWidth() - ((int) (this.thumbnailItemWidthDp * getResources().getDisplayMetrics().density))) / 2, 0));
            }
        }
    }

    public final void c0() {
        List<String> listF = getAdapter().f();
        ArrayList arrayList = new ArrayList(C1174w.x(listF, 10));
        Iterator<T> it = listF.iterator();
        while (it.hasNext()) {
            arrayList.add(new TaskRobotExecuteThumbnailBean((String) it.next(), false, 2, null));
        }
        getThumbnailAdapter().g(arrayList);
        if (!arrayList.isEmpty()) {
            int iN = C5685n.n(this.executeImagesViewPager.getCurrentItem(), 0, C1173v.o(arrayList));
            this.currentImageIndex = iN;
            b0(iN, false);
        }
        e0(O());
    }

    public final void d0() {
        int width = this.thumbnailRecyclerView.getWidth();
        if (width <= 0) {
            return;
        }
        int i10 = (int) (this.thumbnailItemWidthDp * getResources().getDisplayMetrics().density);
        int itemCount = getThumbnailAdapter().getItemCount() * i10;
        this.isTimelineScrollable = itemCount > width;
        getThumbnailLayoutManager().u(this.isTimelineScrollable);
        ViewGroup.LayoutParams layoutParams = this.thumbnailRecyclerView.getLayoutParams();
        kotlin.jvm.internal.p.g(layoutParams, "null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) layoutParams;
        View view = null;
        if (this.isTimelineScrollable) {
            View view2 = this.timelineIndicator;
            if (view2 == null) {
                kotlin.jvm.internal.p.A("timelineIndicator");
            } else {
                view = view2;
            }
            ExtKt.C(view);
            layoutParams2.width = -1;
            layoutParams2.gravity = 8388611;
            this.thumbnailRecyclerView.setLayoutParams(layoutParams2);
        } else {
            View view3 = this.timelineIndicator;
            if (view3 == null) {
                kotlin.jvm.internal.p.A("timelineIndicator");
            } else {
                view = view3;
            }
            ExtKt.m(view);
            layoutParams2.width = C5685n.f(C5685n.j(itemCount, width), 0);
            layoutParams2.gravity = 1;
            this.thumbnailRecyclerView.setLayoutParams(layoutParams2);
        }
        int iF = this.isTimelineScrollable ? C5685n.f((width - i10) / 2, 0) : 0;
        RecyclerView recyclerView = this.thumbnailRecyclerView;
        recyclerView.setPadding(iF, recyclerView.getPaddingTop(), iF, this.thumbnailRecyclerView.getPaddingBottom());
        this.thumbnailRecyclerView.setClipToPadding(false);
        if (this.isTimelineScrollable) {
            return;
        }
        getThumbnailLayoutManager().scrollToPositionWithOffset(0, 0);
    }

    public final void e0(boolean needShow) {
        if (this.pureVirtualScreen) {
            ExtKt.m(this.thumbnailTimeline);
            return;
        }
        if (!needShow || !O() || getThumbnailAdapter().getItemCount() <= 0) {
            ExtKt.m(this.thumbnailTimeline);
        } else {
            ExtKt.C(this.thumbnailTimeline);
            this.thumbnailTimeline.post(new Runnable() { // from class: com.stepos.agentframework.chatui.view.k0
                @Override // java.lang.Runnable
                public final void run() {
                    TaskRobotExecuteLayout.f0(this.f23127a);
                }
            });
        }
    }

    public final p2 getAdapter() {
        p2 p2Var = this.adapter;
        if (p2Var != null) {
            return p2Var;
        }
        kotlin.jvm.internal.p.A("adapter");
        return null;
    }

    public final CardView getAppUILayout() {
        return this.appUILayout;
    }

    public final TextView getBtnStopTask() {
        TextView textView = this.btnStopTask;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.p.A("btnStopTask");
        return null;
    }

    public final TextView getBtnTakeoverTask() {
        TextView textView = this.btnTakeoverTask;
        if (textView != null) {
            return textView;
        }
        kotlin.jvm.internal.p.A("btnTakeoverTask");
        return null;
    }

    public final String getCurrentErrorMessage() {
        return this.currentErrorMessage;
    }

    public final String getCurrentTaskId() {
        return this.currentTaskId;
    }

    public final N getErrorListener() {
        return this.errorListener;
    }

    public final ViewPager2 getExecuteImagesViewPager() {
        return this.executeImagesViewPager;
    }

    public final int getExecuteStatus() {
        return this.executeStatus;
    }

    public final boolean getHideExecuteStatusStep() {
        return this.hideExecuteStatusStep;
    }

    public final ImageView getIvExecuteStatus() {
        return this.ivExecuteStatus;
    }

    public final String getLatestScreenshotPath() {
        return this.latestScreenshotPath;
    }

    public final InterfaceC5074l<String, Y8.t> getOnCanceledStateApplied() {
        return this.onCanceledStateApplied;
    }

    public final InterfaceC5063a<Y8.t> getOnRobotContainerClick() {
        return this.onRobotContainerClick;
    }

    public final InterfaceC5063a<Y8.t> getOnStopTaskClick() {
        return this.onStopTaskClick;
    }

    public final InterfaceC5074l<Boolean, Y8.t> getOnTakeoverTaskClick() {
        return this.onTakeoverTaskClick;
    }

    public final boolean getPureVirtualScreen() {
        return this.pureVirtualScreen;
    }

    public final CardView getRobotContainer() {
        return this.robotContainer;
    }

    public final boolean getShowLlmTakeoverActions() {
        return this.showLlmTakeoverActions;
    }

    public final m2 getThumbnailAdapter() {
        m2 m2Var = this.thumbnailAdapter;
        if (m2Var != null) {
            return m2Var;
        }
        kotlin.jvm.internal.p.A("thumbnailAdapter");
        return null;
    }

    public final RecyclerView getThumbnailRecyclerView() {
        return this.thumbnailRecyclerView;
    }

    public final FrameLayout getThumbnailTimeline() {
        return this.thumbnailTimeline;
    }

    public final TextView getTvExecuteStatus() {
        return this.tvExecuteStatus;
    }

    public final TextView getTvExecuteStep() {
        return this.tvExecuteStep;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        R();
    }

    public final void s(String imagePath) {
        kotlin.jvm.internal.p.i(imagePath, "imagePath");
        C4148a.k("TaskRobotExecuteLayout", "addExecuteImage currentTaskId:" + this.currentTaskId + ", imagePath:" + imagePath, false, 4, null);
        getAdapter().d(imagePath);
        c0();
    }

    public final void setAdapter(p2 p2Var) {
        kotlin.jvm.internal.p.i(p2Var, "<set-?>");
        this.adapter = p2Var;
    }

    public final void setAppUILayout(CardView cardView) {
        kotlin.jvm.internal.p.i(cardView, "<set-?>");
        this.appUILayout = cardView;
    }

    public final void setBtnStopTask(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.btnStopTask = textView;
    }

    public final void setBtnTakeoverTask(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.btnTakeoverTask = textView;
    }

    public final void setCollapsedForForegroundApp(boolean z10) {
        if (this.isCollapsedForForegroundApp == z10) {
            return;
        }
        this.isCollapsedForForegroundApp = z10;
        u();
    }

    public final void setCurrentErrorMessage(String str) {
        this.currentErrorMessage = str;
    }

    public final void setCurrentTaskId(String str) {
        this.currentTaskId = str;
    }

    public final void setErrorListener(N n10) {
        this.errorListener = n10;
    }

    public final void setExecuteImages(List<String> images) {
        kotlin.jvm.internal.p.i(images, "images");
        getAdapter().i(images);
        int iN = images.isEmpty() ? 0 : C5685n.n(this.executeImagesViewPager.getCurrentItem(), 0, C1173v.o(images));
        this.currentImageIndex = iN;
        this.executeImagesViewPager.m(iN, false);
        c0();
    }

    public final void setExecuteImagesViewPager(ViewPager2 viewPager2) {
        kotlin.jvm.internal.p.i(viewPager2, "<set-?>");
        this.executeImagesViewPager = viewPager2;
    }

    public final void setExecuteStatus(int i10) {
        if (this.executeStatus == i10) {
            return;
        }
        this.executeStatus = i10;
        V();
    }

    public final void setHideExecuteStatusStep(boolean z10) {
        if (this.hideExecuteStatusStep == z10) {
            return;
        }
        this.hideExecuteStatusStep = z10;
        v();
    }

    public final void setIvExecuteStatus(ImageView imageView) {
        kotlin.jvm.internal.p.i(imageView, "<set-?>");
        this.ivExecuteStatus = imageView;
    }

    public final void setLatestScreenshotPath(String str) {
        this.latestScreenshotPath = str;
    }

    public final void setOnCanceledStateApplied(InterfaceC5074l<? super String, Y8.t> interfaceC5074l) {
        this.onCanceledStateApplied = interfaceC5074l;
    }

    public final void setOnRobotContainerClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onRobotContainerClick = interfaceC5063a;
    }

    public final void setOnStopTaskClick(InterfaceC5063a<Y8.t> interfaceC5063a) {
        this.onStopTaskClick = interfaceC5063a;
    }

    public final void setOnTakeoverTaskClick(InterfaceC5074l<? super Boolean, Y8.t> interfaceC5074l) {
        this.onTakeoverTaskClick = interfaceC5074l;
    }

    public final void setPureVirtualScreen(boolean z10) {
        if (this.pureVirtualScreen == z10) {
            return;
        }
        this.pureVirtualScreen = z10;
        if (z10) {
            setHideExecuteStatusStep(true);
        }
        w();
    }

    public final void setRenderView(View renderView) {
        kotlin.jvm.internal.p.i(renderView, "renderView");
        this.pipRenderView = renderView;
        this.textureView = renderView instanceof com.stepos.agentframework.chatui.appui.taskrobot.f ? (com.stepos.agentframework.chatui.appui.taskrobot.f) renderView : null;
    }

    public final void setRobotContainer(CardView cardView) {
        kotlin.jvm.internal.p.i(cardView, "<set-?>");
        this.robotContainer = cardView;
    }

    public final void setShowLlmTakeoverActions(boolean z10) {
        if (this.showLlmTakeoverActions == z10) {
            return;
        }
        this.showLlmTakeoverActions = z10;
        F();
    }

    public final void setSurfaceView(com.stepos.agentframework.chatui.appui.taskrobot.b surfaceView) {
        kotlin.jvm.internal.p.i(surfaceView, "surfaceView");
        this.pipRenderView = surfaceView;
        this.textureView = null;
    }

    public final void setTaskId(String taskId) {
        this.currentTaskId = taskId;
    }

    public final void setThumbnailAdapter(m2 m2Var) {
        kotlin.jvm.internal.p.i(m2Var, "<set-?>");
        this.thumbnailAdapter = m2Var;
    }

    public final void setThumbnailRecyclerView(RecyclerView recyclerView) {
        kotlin.jvm.internal.p.i(recyclerView, "<set-?>");
        this.thumbnailRecyclerView = recyclerView;
    }

    public final void setThumbnailTimeline(FrameLayout frameLayout) {
        kotlin.jvm.internal.p.i(frameLayout, "<set-?>");
        this.thumbnailTimeline = frameLayout;
    }

    public final void setTvExecuteStatus(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.tvExecuteStatus = textView;
    }

    public final void setTvExecuteStep(TextView textView) {
        kotlin.jvm.internal.p.i(textView, "<set-?>");
        this.tvExecuteStep = textView;
    }

    public final void t(List<String> newImages) {
        kotlin.jvm.internal.p.i(newImages, "newImages");
        getAdapter().e(newImages);
        c0();
    }

    public final void u() {
        ImageView imageView = null;
        if (this.pureVirtualScreen) {
            ImageView imageView2 = this.ivArrowRight;
            if (imageView2 == null) {
                kotlin.jvm.internal.p.A("ivArrowRight");
            } else {
                imageView = imageView2;
            }
            ExtKt.m(imageView);
            return;
        }
        if (!this.isCollapsedForForegroundApp) {
            ImageView imageView3 = this.ivArrowRight;
            if (imageView3 == null) {
                kotlin.jvm.internal.p.A("ivArrowRight");
            } else {
                imageView = imageView3;
            }
            ExtKt.C(imageView);
            return;
        }
        ExtKt.m(this.appUILayout);
        ExtKt.m(this.thumbnailTimeline);
        ImageView imageView4 = this.ivArrowRight;
        if (imageView4 == null) {
            kotlin.jvm.internal.p.A("ivArrowRight");
        } else {
            imageView = imageView4;
        }
        ExtKt.m(imageView);
    }

    public final void v() {
        if (this.hideExecuteStatusStep) {
            ExtKt.m(this.tvExecuteStatus);
            ExtKt.m(this.tvExecuteStep);
        } else {
            ExtKt.C(this.tvExecuteStatus);
            CharSequence text = this.tvExecuteStep.getText();
            X(text != null ? text.toString() : null);
        }
    }

    public final void w() {
        if (this.pureVirtualScreen) {
            ImageView imageView = null;
            this.taskRobotRoot.setBackground(null);
            this.taskRobotRoot.setPadding(0, 0, 0, 0);
            ViewGroup.LayoutParams layoutParams = this.taskRobotRoot.getLayoutParams();
            ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
            if (marginLayoutParams != null) {
                marginLayoutParams.topMargin = 0;
                this.taskRobotRoot.setLayoutParams(marginLayoutParams);
            }
            ExtKt.m(this.ivExecuteStatus);
            ExtKt.m(this.tvExecuteStatus);
            ExtKt.m(this.tvExecuteStep);
            View view = this.line;
            if (view == null) {
                kotlin.jvm.internal.p.A("line");
                view = null;
            }
            ExtKt.m(view);
            ImageView imageView2 = this.ivArrowRight;
            if (imageView2 == null) {
                kotlin.jvm.internal.p.A("ivArrowRight");
            } else {
                imageView = imageView2;
            }
            ExtKt.m(imageView);
            ExtKt.m(this.thumbnailTimeline);
            ExtKt.p(this.executeImagesViewPager);
            F();
            this.appUILayout.setCardBackgroundColor(0);
            this.appUILayout.setRadius(0.0f);
        }
    }

    public final void x() {
        setUserTakeoverActive(false);
        setShowLlmTakeoverActions(false);
    }

    public final Activity y(Context context) {
        while (context instanceof ContextWrapper) {
            if (context instanceof Activity) {
                return (Activity) context;
            }
            context = ((ContextWrapper) context).getBaseContext();
        }
        return null;
    }

    public final String z() {
        List<String> listF = getAdapter().f();
        if (listF.isEmpty()) {
            return this.latestScreenshotPath;
        }
        String str = this.currentTaskId;
        Object next = null;
        if (str == null || La.H.x0(str)) {
            str = null;
        }
        if (str != null) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : listF) {
                if (La.H.e0((String) obj, str, true)) {
                    arrayList.add(obj);
                }
            }
            listF = arrayList;
        }
        if (listF.isEmpty()) {
            return this.latestScreenshotPath;
        }
        Iterator<T> it = listF.iterator();
        if (it.hasNext()) {
            next = it.next();
            if (it.hasNext()) {
                long jLastModified = new File((String) next).lastModified();
                do {
                    Object next2 = it.next();
                    long jLastModified2 = new File((String) next2).lastModified();
                    if (jLastModified < jLastModified2) {
                        next = next2;
                        jLastModified = jLastModified2;
                    }
                } while (it.hasNext());
            }
        }
        String str2 = (String) next;
        return str2 == null ? this.latestScreenshotPath : str2;
    }

    public /* synthetic */ TaskRobotExecuteLayout(Context context, AttributeSet attributeSet, int i10, kotlin.jvm.internal.i iVar) {
        this(context, (i10 & 2) != 0 ? null : attributeSet);
    }
}
