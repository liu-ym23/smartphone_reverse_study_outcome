package com.stepos.ailauncher.taskstore.widget;

import Ua.C1060i;
import Z8.C1173v;
import Z8.C1174w;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Looper;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.exifinterface.media.ExifInterface;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.aps.amapapi.storage.SdCardDbCreator;
import com.stepos.agentframework.chatui.view.NestedScrollableHost;
import com.stepos.agentframework.display.k;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.chat.voicewakeup.VoiceWakeupReceiver;
import com.stepos.ailauncher.common.widget.SweepTextView;
import com.stepos.ailauncher.contract.model.ArtifactAvailability;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.ailauncher.taskstore.R$color;
import com.stepos.ailauncher.taskstore.R$dimen;
import com.stepos.ailauncher.taskstore.R$drawable;
import com.stepos.ailauncher.taskstore.R$id;
import com.stepos.ailauncher.taskstore.R$layout;
import com.stepos.ailauncher.taskstore.R$string;
import com.stepos.ailauncher.taskstore.TaskStoreModule;
import com.stepos.ailauncher.taskstore.artifact.TaskArtifactPartMerger;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCardKt;
import com.stepos.ailauncher.taskstore.entity.TaskInfoEventType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPartType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoProgress;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import com.stepos.ailauncher.taskstore.livenotification.ArtifactExposureNotificationCanceller;
import com.stepos.ailauncher.taskstore.livenotification.C3715c;
import com.stepos.ailauncher.taskstore.widget.TextToImageCardView;
import com.stepos.core.download.ModelFlowMeta;
import h9.InterfaceC4149a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.C4849c;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.jvm.internal.FunctionReferenceImpl;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import r9.C5227b;
import s.C5423E;
import u6.C5579b;
import v6.C5661b;
import v9.C5685n;

@Metadata(d1 = {"\u0000²\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\t\n\u0002\b7\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u0096\u00022\u00020\u00012\u00020\u0002:\n\u0097\u0002\u0098\u0002¢\u0001\u0099\u0002\u009a\u0002B'\b\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0007¢\u0006\u0004\b\t\u0010\nB%\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\f\u001a\u00020\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000b¢\u0006\u0004\b\t\u0010\u000eJ\u001d\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b\u0013\u0010\u0014J#\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00162\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J\u0013\u0010\u001a\u001a\u00020\u0019*\u00020\u0012H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0019\u0010\u001d\u001a\u00020\u001c2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000fH\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\u000f\u0010\u001f\u001a\u00020\u001cH\u0002¢\u0006\u0004\b\u001f\u0010 J\u0017\u0010\"\u001a\u00020\u001c2\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b\"\u0010#J\u000f\u0010$\u001a\u00020\u0007H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010&\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\u0007H\u0002¢\u0006\u0004\b(\u0010)J-\u0010-\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020*2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u00101\u001a\u00020\u001c2\u0006\u00100\u001a\u00020/H\u0002¢\u0006\u0004\b1\u00102J%\u00104\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b4\u00105J\u0017\u00106\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b6\u0010\u001eJ+\u0010;\u001a\u00020\u001c2\u0006\u00107\u001a\u00020\u00072\u0012\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020908H\u0002¢\u0006\u0004\b;\u0010<J\u000f\u0010=\u001a\u00020\u001cH\u0002¢\u0006\u0004\b=\u0010 J\u0017\u0010?\u001a\u00020\u00192\u0006\u0010>\u001a\u00020\u0007H\u0002¢\u0006\u0004\b?\u0010@J\u0015\u0010A\u001a\u0004\u0018\u00010\u000b*\u00020\u0012H\u0002¢\u0006\u0004\bA\u0010BJ\u001d\u0010C\u001a\u00020\u001c2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\bC\u0010DJ\u001f\u0010G\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020\u000b2\u0006\u0010F\u001a\u00020\u000bH\u0002¢\u0006\u0004\bG\u0010HJ%\u0010I\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\bI\u00105J!\u0010L\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u00072\b\b\u0002\u0010K\u001a\u00020\u0019H\u0002¢\u0006\u0004\bL\u0010MJ\u001f\u0010O\u001a\u00020\u001c2\u0006\u0010N\u001a\u00020\u00072\u0006\u0010J\u001a\u00020\u0007H\u0002¢\u0006\u0004\bO\u0010PJ%\u0010Q\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\bQ\u00105J\u001d\u0010R\u001a\u00020\u001c2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\bR\u0010DJ'\u0010T\u001a\u00020\u001c2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010S\u001a\u00020\u0019H\u0002¢\u0006\u0004\bT\u0010UJ#\u0010V\u001a\u00020\u001c2\u0006\u0010F\u001a\u00020\u000b2\n\b\u0002\u0010E\u001a\u0004\u0018\u00010\u000bH\u0002¢\u0006\u0004\bV\u0010HJ\u000f\u0010W\u001a\u00020\u001cH\u0002¢\u0006\u0004\bW\u0010 J\u000f\u0010X\u001a\u00020\u001cH\u0002¢\u0006\u0004\bX\u0010 J\u001d\u0010[\u001a\u00020\u001c2\f\u0010Z\u001a\b\u0012\u0004\u0012\u00020Y0\u0011H\u0002¢\u0006\u0004\b[\u0010DJ%\u0010\\\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u0002¢\u0006\u0004\b\\\u00105J\u0017\u0010]\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b]\u0010\u001eJ\u0017\u0010^\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002¢\u0006\u0004\b^\u0010\u001eJ\u0019\u0010a\u001a\u00020\u00072\b\u0010`\u001a\u0004\u0018\u00010_H\u0002¢\u0006\u0004\ba\u0010bJ\u0017\u0010d\u001a\u00020\u001c2\u0006\u0010c\u001a\u00020\u0007H\u0002¢\u0006\u0004\bd\u0010#J\u000f\u0010e\u001a\u00020\u001cH\u0002¢\u0006\u0004\be\u0010 J\u000f\u0010f\u001a\u00020\u001cH\u0002¢\u0006\u0004\bf\u0010 J!\u0010j\u001a\u00020\u001c2\u0006\u0010g\u001a\u00020\u00072\b\u0010i\u001a\u0004\u0018\u00010hH\u0002¢\u0006\u0004\bj\u0010kJ\u000f\u0010l\u001a\u00020\u001cH\u0002¢\u0006\u0004\bl\u0010 J\u0017\u0010n\u001a\u00020\u001c2\u0006\u0010m\u001a\u00020hH\u0002¢\u0006\u0004\bn\u0010oJ\u000f\u0010p\u001a\u00020\u001cH\u0002¢\u0006\u0004\bp\u0010 J\u000f\u0010q\u001a\u00020\u001cH\u0002¢\u0006\u0004\bq\u0010 J\u000f\u0010r\u001a\u00020\u001cH\u0002¢\u0006\u0004\br\u0010 J\u000f\u0010s\u001a\u00020\u001cH\u0002¢\u0006\u0004\bs\u0010 J\u000f\u0010t\u001a\u00020\u001cH\u0002¢\u0006\u0004\bt\u0010 J\u0019\u0010v\u001a\u00020\u001c2\b\b\u0002\u0010u\u001a\u00020\u0019H\u0002¢\u0006\u0004\bv\u0010wJ\u0017\u0010x\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u0007H\u0002¢\u0006\u0004\bx\u0010#J\u0015\u0010y\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0011H\u0002¢\u0006\u0004\by\u0010zJ!\u0010}\u001a\u00020\u00072\b\u0010{\u001a\u0004\u0018\u00010\u000b2\u0006\u0010|\u001a\u00020\u0007H\u0002¢\u0006\u0004\b}\u0010~J\u0019\u0010\u0080\u0001\u001a\u00020\u001c2\u0006\u0010\u007f\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0080\u0001\u0010#J\u0011\u0010\u0081\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u0081\u0001\u0010 J\u0019\u0010\u0082\u0001\u001a\u00020\u001c2\u0006\u0010\u007f\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0082\u0001\u0010#J\u001a\u0010\u0084\u0001\u001a\u00020\u001c2\u0007\u0010\u0083\u0001\u001a\u00020\u0007H\u0002¢\u0006\u0005\b\u0084\u0001\u0010#J\u0016\u0010\u0085\u0001\u001a\u00020\u0019*\u00020*H\u0002¢\u0006\u0006\b\u0085\u0001\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\u0019*\u00020\u0012H\u0002¢\u0006\u0005\b\u0087\u0001\u0010\u001bJ\u0011\u0010\u0088\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u0088\u0001\u0010 J\u0012\u0010\u0089\u0001\u001a\u00020\u0019H\u0002¢\u0006\u0006\b\u0089\u0001\u0010\u008a\u0001J\u0011\u0010\u008b\u0001\u001a\u00020\u001cH\u0002¢\u0006\u0005\b\u008b\u0001\u0010 J\u001a\u0010\u008d\u0001\u001a\u00020\u001c2\u0007\u0010\u008c\u0001\u001a\u00020\u0007H\u0016¢\u0006\u0005\b\u008d\u0001\u0010#J\u0018\u0010\u008e\u0001\u001a\u00020\u001c2\u0006\u0010\f\u001a\u00020\u000b¢\u0006\u0006\b\u008e\u0001\u0010\u008f\u0001J\"\u0010\u0091\u0001\u001a\u00020\u001c2\u0006\u0010{\u001a\u00020\u000b2\t\b\u0002\u0010\u0090\u0001\u001a\u00020\u0007¢\u0006\u0005\b\u0091\u0001\u0010)J,\u0010\u0094\u0001\u001a\u00020\u001c2\r\u0010\u0092\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00112\u000b\b\u0002\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u000f¢\u0006\u0006\b\u0094\u0001\u0010\u0095\u0001J\u0019\u0010\u0096\u0001\u001a\u00020\u001c2\b\b\u0002\u0010!\u001a\u00020\u0007¢\u0006\u0005\b\u0096\u0001\u0010#J\u0010\u0010\u0097\u0001\u001a\u00020\u0019¢\u0006\u0006\b\u0097\u0001\u0010\u008a\u0001J\u0018\u0010\u0098\u0001\u001a\u00020\u001c2\u0006\u0010{\u001a\u00020\u000b¢\u0006\u0006\b\u0098\u0001\u0010\u008f\u0001J\u001a\u0010\u009a\u0001\u001a\u00020\u001c2\t\b\u0002\u0010\u0099\u0001\u001a\u00020\u0019¢\u0006\u0005\b\u009a\u0001\u0010wJ\u0010\u0010\u009b\u0001\u001a\u00020\u0019¢\u0006\u0006\b\u009b\u0001\u0010\u008a\u0001J\u001d\u0010\u009c\u0001\u001a\u00020\u001c2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0005\b\u009c\u0001\u0010DJ\u0017\u0010\u009d\u0001\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f¢\u0006\u0005\b\u009d\u0001\u0010\u001eJ\u0012\u0010\u009e\u0001\u001a\u0004\u0018\u00010\u000b¢\u0006\u0006\b\u009e\u0001\u0010\u009f\u0001J&\u0010¢\u0001\u001a\u00020\u001c2\u0006\u0010\u0010\u001a\u00020\u000f2\n\u0010¡\u0001\u001a\u0005\u0018\u00010 \u0001H\u0016¢\u0006\u0006\b¢\u0001\u0010£\u0001J2\u0010¤\u0001\u001a\u00020\u001c2\u0006\u0010J\u001a\u00020\u00072\n\b\u0002\u0010i\u001a\u0004\u0018\u00010h2\n\b\u0002\u0010{\u001a\u0004\u0018\u00010\u000bH\u0007¢\u0006\u0006\b¤\u0001\u0010¥\u0001J\u000f\u0010¦\u0001\u001a\u00020\u001c¢\u0006\u0005\b¦\u0001\u0010 J\u0011\u0010§\u0001\u001a\u00020\u001cH\u0014¢\u0006\u0005\b§\u0001\u0010 J\u001a\u0010©\u0001\u001a\u00020\u001c2\u0007\u0010¨\u0001\u001a\u00020\u0019H\u0016¢\u0006\u0005\b©\u0001\u0010wJ\u0011\u0010ª\u0001\u001a\u00020\u001cH\u0014¢\u0006\u0005\bª\u0001\u0010 R\u0018\u0010¬\u0001\u001a\u00030«\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¬\u0001\u0010\u00ad\u0001R\u0019\u0010\f\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\f\u0010®\u0001R\u0019\u0010\r\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\r\u0010®\u0001R\u0018\u0010¯\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b¯\u0001\u0010$R\u0019\u0010°\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b°\u0001\u0010±\u0001R\u001b\u0010²\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b²\u0001\u0010®\u0001R\u001f\u0010³\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b³\u0001\u0010´\u0001R\u001b\u0010µ\u0001\u001a\u0004\u0018\u00010\u000f8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bµ\u0001\u0010¶\u0001R\u0018\u0010·\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b·\u0001\u0010$R)\u0010º\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b0¸\u0001j\t\u0012\u0004\u0012\u00020\u000b`¹\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bº\u0001\u0010»\u0001R5\u0010¾\u0001\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00070¼\u0001j\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u0007`½\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¾\u0001\u0010¿\u0001R\u0018\u0010Á\u0001\u001a\u00030À\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÁ\u0001\u0010Â\u0001R)\u0010Å\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b0Ã\u0001j\t\u0012\u0004\u0012\u00020\u000b`Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÅ\u0001\u0010Æ\u0001R+\u0010Ç\u0001\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0086\u000e¢\u0006\u0018\n\u0006\bÇ\u0001\u0010È\u0001\u001a\u0006\bÉ\u0001\u0010Ê\u0001\"\u0006\bË\u0001\u0010Ì\u0001R\u001a\u0010Î\u0001\u001a\u00030Í\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010Ï\u0001R\u001c\u0010Ñ\u0001\u001a\u0005\u0018\u00010Ð\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u0018\u0010Ó\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÓ\u0001\u0010$R\u0019\u0010Ô\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÔ\u0001\u0010±\u0001R\u0018\u0010Ö\u0001\u001a\u00030Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÖ\u0001\u0010×\u0001R\u0018\u0010Ù\u0001\u001a\u00030Ø\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÙ\u0001\u0010Ú\u0001R\u001a\u0010Ü\u0001\u001a\u00030Û\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÜ\u0001\u0010Ý\u0001R\u0018\u0010Þ\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bÞ\u0001\u0010$R\u0019\u0010ß\u0001\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u0018\u0010á\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bá\u0001\u0010$R\u0018\u0010â\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bâ\u0001\u0010$R\u001f\u0010ã\u0001\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bã\u0001\u0010ä\u0001R\u0018\u0010å\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bå\u0001\u0010$R\u0018\u0010æ\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bæ\u0001\u0010$R#\u0010é\u0001\u001a\f\u0018\u00010ç\u0001j\u0005\u0018\u0001`è\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bé\u0001\u0010ê\u0001R#\u0010ë\u0001\u001a\f\u0018\u00010ç\u0001j\u0005\u0018\u0001`è\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bë\u0001\u0010ê\u0001R\u0018\u0010ì\u0001\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bì\u0001\u0010$R\u0019\u0010í\u0001\u001a\u00020h8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bí\u0001\u0010à\u0001R\u001c\u0010ï\u0001\u001a\u0005\u0018\u00010î\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bï\u0001\u0010ð\u0001R\u0018\u0010ñ\u0001\u001a\u00030Õ\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bñ\u0001\u0010×\u0001R\u001f\u0010ò\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010ä\u0001R\u001f\u0010ó\u0001\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00118\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bó\u0001\u0010ä\u0001R)\u0010ô\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b0Ã\u0001j\t\u0012\u0004\u0012\u00020\u000b`Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bô\u0001\u0010Æ\u0001R)\u0010õ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b0Ã\u0001j\t\u0012\u0004\u0012\u00020\u000b`Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bõ\u0001\u0010Æ\u0001R\u0019\u0010ö\u0001\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bö\u0001\u0010±\u0001R\u001b\u0010÷\u0001\u001a\u0004\u0018\u00010\u000b8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b÷\u0001\u0010®\u0001R\u001e\u0010ù\u0001\u001a\t\u0012\u0004\u0012\u00020\u001c0ø\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bù\u0001\u0010ú\u0001R5\u0010ý\u0001\u001a \u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b0û\u0001j\u000f\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000b`ü\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bý\u0001\u0010þ\u0001R)\u0010ÿ\u0001\u001a\u0014\u0012\u0004\u0012\u00020\u000b0Ã\u0001j\t\u0012\u0004\u0012\u00020\u000b`Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\bÿ\u0001\u0010Æ\u0001R)\u0010\u0080\u0002\u001a\u0014\u0012\u0004\u0012\u00020\u000b0Ã\u0001j\t\u0012\u0004\u0012\u00020\u000b`Ä\u00018\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0080\u0002\u0010Æ\u0001R\u0018\u0010\u0081\u0002\u001a\u00020\u00198\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b\u0081\u0002\u0010$R\u0018\u0010\u0083\u0002\u001a\u00030\u0082\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0083\u0002\u0010\u0084\u0002R\u001b\u0010\u0085\u0002\u001a\u0004\u0018\u00010/8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010\u0086\u0002R\u0017\u0010\u0087\u0002\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0087\u0002\u0010±\u0001R\u0017\u0010\u0088\u0002\u001a\u00020\u00078\u0002X\u0082\u0004¢\u0006\b\n\u0006\b\u0088\u0002\u0010±\u0001R\u0019\u0010\u0089\u0002\u001a\u00020\u00078\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010±\u0001R\u0018\u0010\u008d\u0002\u001a\u00030\u008a\u00028TX\u0094\u0004¢\u0006\b\u001a\u0006\b\u008b\u0002\u0010\u008c\u0002R\u0018\u0010\u0091\u0002\u001a\u00030\u008e\u00028TX\u0094\u0004¢\u0006\b\u001a\u0006\b\u008f\u0002\u0010\u0090\u0002R\u0018\u0010\u0095\u0002\u001a\u00030\u0092\u00028TX\u0094\u0004¢\u0006\b\u001a\u0006\b\u0093\u0002\u0010\u0094\u0002¨\u0006\u009b\u0002"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView;", "Lcom/stepos/ailauncher/taskstore/widget/c;", "Lcom/stepos/agentframework/chatui/appui/d;", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "", "taskId", "versionId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "o0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/util/List;", "parts", "", "n0", "(Ljava/util/List;)Ljava/util/Set;", "", "p0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;)Z", "LY8/t;", "h0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "g0", "()V", "imageCount", "f0", "(I)V", "Z", "()I", "v0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "d0", "(Ljava/lang/String;I)V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", "result", "p1", "(Ljava/lang/String;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;Ljava/util/List;)Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "LUa/M;", "scope", "q1", "(LUa/M;)V", "imageParts", "F0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Ljava/util/List;)V", "O", "gen", "", "Lcom/stepos/ailauncher/contract/model/ArtifactAvailability;", C3081a.FOCUS_MAP_NAME, "Q", "(ILjava/util/Map;)V", "R", "index", "r0", "(I)Z", "i0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;)Ljava/lang/String;", "e1", "(Ljava/util/List;)V", "fileId", "url", "y0", "(Ljava/lang/String;Ljava/lang/String;)V", "R0", "percent", "showProgress", "U0", "(IZ)V", "count", "O0", "(II)V", "K0", "k0", "appendGenerationLoading", "M0", "(Ljava/util/List;Z)V", "W0", "S0", "T0", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$d;", DidiCardProvider.KEY_ITEMS, "P0", "L0", "l1", "m1", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;", "progress", "h1", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoProgress;)I", "realPercent", "r1", "z0", "U", "target", "", "durationMs", "c0", "(ILjava/lang/Long;)V", "s1", "nowMs", "C0", "(J)V", "i1", "B0", "b0", "a0", "u1", "clearToolCallProgress", "c1", "(Z)V", ExifInterface.GPS_DIRECTION_TRUE, "N", "()Ljava/util/List;", "toolCallId", "sharedPercent", "E0", "(Ljava/lang/String;I)I", "position", "D0", "b1", SdCardDbCreator.FIELD_LASTLOC_ID, "sizePx", ExifInterface.LATITUDE_SOUTH, "q0", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Z", "s0", "x1", "m0", "()Z", "t1", "insetPx", "setContentStartInset", "n1", "(Ljava/lang/String;)V", "activeToolCallCount", ExifInterface.LONGITUDE_WEST, "toolCallIds", "restoredBaseCard", "v1", "(Ljava/util/List;Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)V", "H0", "t0", "A0", "restorePreviousCard", "e0", "u0", "Y", "X", "getTaskId", "()Ljava/lang/String;", "Lcom/stepos/ailauncher/taskstore/widget/k;", "listener", "c", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;Lcom/stepos/ailauncher/taskstore/widget/k;)V", "j1", "(ILjava/lang/Long;Ljava/lang/String;)V", "J0", "onAttachedToWindow", "isVisible", "onVisibilityAggregated", "onDetachedFromWindow", "Lv6/b;", "binding", "Lv6/b;", "Ljava/lang/String;", "standaloneCard", "expectedImageCount", "I", "activeGenerationToolCallId", "generationStartFileIds", "Ljava/util/Set;", "generationBaseCard", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "revisionGenerationInFlight", "Ljava/util/LinkedHashSet;", "Lkotlin/collections/LinkedHashSet;", "pendingToolCallIds", "Ljava/util/LinkedHashSet;", "Ljava/util/LinkedHashMap;", "Lkotlin/collections/LinkedHashMap;", "toolCallProgressPercent", "Ljava/util/LinkedHashMap;", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "exposureTimer", "Lcom/stepos/ailauncher/taskstore/livenotification/c;", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "exposedFileIds", "Ljava/util/HashSet;", "imageProgressPercent", "Ljava/lang/Integer;", "getImageProgressPercent", "()Ljava/lang/Integer;", "setImageProgressPercent", "(Ljava/lang/Integer;)V", "", "displayedProgressPercent", "F", "Landroid/animation/ValueAnimator;", "progressAnimator", "Landroid/animation/ValueAnimator;", "tricklePosted", "lastAppliedProgressInt", "Ljava/lang/Runnable;", "trickleTick", "Ljava/lang/Runnable;", "Landroid/view/animation/Interpolator;", "catchUpInterpolator", "Landroid/view/animation/Interpolator;", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$AnimatorKind;", "animatorKind", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$AnimatorKind;", "isRunningProgress", "lastProgressAtElapsed", "J", "generatingStalled", "finishing", "pendingFinishParts", "Ljava/util/List;", "showingGeneratingUi", "generationUiSeen", "Ljava/lang/AutoCloseable;", "Lkotlin/AutoCloseable;", "waitPowerLease", "Ljava/lang/AutoCloseable;", "waitClockToken", "waitPowerReady", "lastTrickleAtMs", "Lcom/stepos/ailauncher/taskstore/widget/y0;", "lastVisualSignature", "Lcom/stepos/ailauncher/taskstore/widget/y0;", "staleProgressWatchdog", "currentImageUrls", "currentImageFileIds", "expiredFileIds", "blockedFileIds", "availabilityGeneration", "lastAvailabilityQueryKey", "Lkotlin/Function0;", "availabilityChangedListener", "Lp9/a;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "signedUrls", "Ljava/util/HashMap;", "resolvingFileIds", "failedImageFileIds", "isBinding", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c;", "multiImageAdapter", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c;", "ioScope", "LUa/M;", "multiItemGapPx", "multiItemSizePx", "contentInsetStartPx", "Landroid/widget/TextView;", "getTitleView", "()Landroid/widget/TextView;", "titleView", "Lcom/stepos/ailauncher/common/widget/SweepTextView;", "getSubtitleView", "()Lcom/stepos/ailauncher/common/widget/SweepTextView;", "subtitleView", "Landroid/widget/ImageView;", "getIconView", "()Landroid/widget/ImageView;", "iconView", "Companion", "AnimatorKind", Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_APIKEY, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TextToImageCardView extends AbstractC3737c implements com.stepos.agentframework.chatui.appui.d {
    private static final long FINISH_FULL_SPAN_MS = 8000;
    private static final long FINISH_MAX_DURATION_MS = 1600;
    private static final long FINISH_MIN_DURATION_MS = 900;
    private static final long RESULT_COMPLETE_HOLD_MS = 120;
    private static final long STALE_PROGRESS_TIMEOUT_MS = 300000;
    private static final String TAG = "TextToImageCardView";
    private static final int TRICKLE_CEILING_PERCENT = 99;
    private static final float TRICKLE_MIN_REMAINING = 0.3f;
    private static final float TRICKLE_MIN_STEP = 0.15f;
    private static final long TRICKLE_STEP_DURATION_MS = 1200;
    private static final float TRICKLE_STEP_FRACTION = 0.12f;
    private static final long TRICKLE_TICK_MS = 500;
    private String activeGenerationToolCallId;
    private AnimatorKind animatorKind;
    private final InterfaceC5063a<Y8.t> availabilityChangedListener;
    private int availabilityGeneration;
    private final C5661b binding;
    private final HashSet<String> blockedFileIds;
    private final Interpolator catchUpInterpolator;
    private int contentInsetStartPx;
    private List<String> currentImageFileIds;
    private List<String> currentImageUrls;
    private float displayedProgressPercent;
    private int expectedImageCount;
    private final HashSet<String> expiredFileIds;
    private final HashSet<String> exposedFileIds;
    private final C3715c exposureTimer;
    private final HashSet<String> failedImageFileIds;
    private boolean finishing;
    private boolean generatingStalled;
    private TaskInfoCard generationBaseCard;
    private Set<String> generationStartFileIds;
    private boolean generationUiSeen;
    private Integer imageProgressPercent;
    private Ua.M ioScope;
    private boolean isBinding;
    private boolean isRunningProgress;
    private int lastAppliedProgressInt;
    private String lastAvailabilityQueryKey;
    private long lastProgressAtElapsed;
    private long lastTrickleAtMs;
    private TtiCardVisualSignature lastVisualSignature;
    private final c multiImageAdapter;
    private final int multiItemGapPx;
    private final int multiItemSizePx;
    private List<TaskInfoPart> pendingFinishParts;
    private final LinkedHashSet<String> pendingToolCallIds;
    private ValueAnimator progressAnimator;
    private final HashSet<String> resolvingFileIds;
    private boolean revisionGenerationInFlight;
    private boolean showingGeneratingUi;
    private final HashMap<String, String> signedUrls;
    private final Runnable staleProgressWatchdog;
    private boolean standaloneCard;
    private String taskId;
    private final LinkedHashMap<String, Integer> toolCallProgressPercent;
    private boolean tricklePosted;
    private final Runnable trickleTick;
    private String versionId;
    private AutoCloseable waitClockToken;
    private AutoCloseable waitPowerLease;
    private boolean waitPowerReady;
    private static final Set<TaskInfoStatus> RUNNING_STATUSES = Z8.Y.j(TaskInfoStatus.RUNNING, TaskInfoStatus.IN_PROGRESS, TaskInfoStatus.PLANNING);
    private static final Set<TaskInfoStatus> WAITING_STATUSES = Z8.Y.j(TaskInfoStatus.WAITING, TaskInfoStatus.PENDING, TaskInfoStatus.PAUSED);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0082\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$AnimatorKind;", "", "<init>", "(Ljava/lang/String;I)V", ModelFlowMeta.PLAN_NONE, "TRICKLE", "FINISH", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class AnimatorKind {
        private static final /* synthetic */ InterfaceC4149a $ENTRIES;
        private static final /* synthetic */ AnimatorKind[] $VALUES;
        public static final AnimatorKind NONE = new AnimatorKind(ModelFlowMeta.PLAN_NONE, 0);
        public static final AnimatorKind TRICKLE = new AnimatorKind("TRICKLE", 1);
        public static final AnimatorKind FINISH = new AnimatorKind("FINISH", 2);

        private static final /* synthetic */ AnimatorKind[] $values() {
            return new AnimatorKind[]{NONE, TRICKLE, FINISH};
        }

        static {
            AnimatorKind[] animatorKindArr$values = $values();
            $VALUES = animatorKindArr$values;
            $ENTRIES = kotlin.enums.a.a(animatorKindArr$values);
        }

        private AnimatorKind(String str, int i10) {
        }

        public static InterfaceC4149a<AnimatorKind> getEntries() {
            return $ENTRIES;
        }

        public static AnimatorKind valueOf(String str) {
            return (AnimatorKind) Enum.valueOf(AnimatorKind.class, str);
        }

        public static AnimatorKind[] values() {
            return (AnimatorKind[]) $VALUES.clone();
        }
    }

    @Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J/\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\fH\u0016¢\u0006\u0004\b\u000f\u0010\u0010R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$b;", "Landroidx/recyclerview/widget/RecyclerView$ItemDecoration;", "", "gapPx", "<init>", "(I)V", "Landroid/graphics/Rect;", "outRect", "Landroid/view/View;", "view", "Landroidx/recyclerview/widget/RecyclerView;", "parent", "Landroidx/recyclerview/widget/RecyclerView$State;", VoiceWakeupReceiver.EXTRA_STATE, "LY8/t;", "getItemOffsets", "(Landroid/graphics/Rect;Landroid/view/View;Landroidx/recyclerview/widget/RecyclerView;Landroidx/recyclerview/widget/RecyclerView$State;)V", "I", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b extends RecyclerView.ItemDecoration {
        private final int gapPx;

        public b(int i10) {
            this.gapPx = i10;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
            kotlin.jvm.internal.p.i(outRect, "outRect");
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(parent, "parent");
            kotlin.jvm.internal.p.i(state, "state");
            int childAdapterPosition = parent.getChildAdapterPosition(view);
            if (childAdapterPosition != -1 && childAdapterPosition > 0) {
                outRect.left = this.gapPx;
            }
        }
    }

    @Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010$\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010!\n\u0002\u0010\u0000\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\b\u0010\b\u0002\u0018\u0000 J2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0002KLB+\u0012\u0014\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u0007¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000e\u001a\u00020\u00052\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0004\b\u000e\u0010\u000fJ)\u0010\u0014\u001a\u00020\u00052\u0006\u0010\u0011\u001a\u00020\u00102\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00100\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\u001d\u0010\u0018\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0010¢\u0006\u0004\b\u0018\u0010\u0019J\u0015\u0010\u001c\u001a\u00020\u00052\u0006\u0010\u001b\u001a\u00020\u001a¢\u0006\u0004\b\u001c\u0010\u001dJ\u001b\u0010 \u001a\u00020\u00052\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u00040\u001e¢\u0006\u0004\b \u0010!J\r\u0010\"\u001a\u00020\u0005¢\u0006\u0004\b\"\u0010#J\u001f\u0010'\u001a\u00020\u00022\u0006\u0010%\u001a\u00020$2\u0006\u0010&\u001a\u00020\u0010H\u0016¢\u0006\u0004\b'\u0010(J-\u0010.\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u00102\f\u0010-\u001a\b\u0012\u0004\u0012\u00020,0+H\u0016¢\u0006\u0004\b.\u0010/J\u001f\u00100\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020\u0010H\u0016¢\u0006\u0004\b0\u00101J\u0017\u00102\u001a\u00020\u00052\u0006\u0010)\u001a\u00020\u0002H\u0016¢\u0006\u0004\b2\u00103J\u000f\u00104\u001a\u00020\u0010H\u0016¢\u0006\u0004\b4\u00105R\"\u0010\u0006\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0012\u0004\u0012\u00020\u00050\u00038\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0006\u00106R\u001a\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00078\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\b\u00107R\u001a\u00108\u001a\b\u0012\u0004\u0012\u00020\f0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b8\u00109R\u001a\u0010;\u001a\b\u0012\u0004\u0012\u00020:0+8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b;\u00109R \u0010>\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020=0<8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b>\u0010?R\"\u0010@\u001a\u00020\u00108\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\b@\u0010A\u001a\u0004\bB\u00105\"\u0004\bC\u0010DR0\u0010E\u001a\u0010\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00038\u0006@\u0006X\u0086\u000e¢\u0006\u0012\n\u0004\bE\u00106\u001a\u0004\bF\u0010G\"\u0004\bH\u0010I¨\u0006M"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c$b;", "Lkotlin/Function1;", "", "LY8/t;", "onImageLoadFailed", "Lkotlin/Function0;", "onShaderRunningChanged", "<init>", "(Lp9/l;Lp9/a;)V", "", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$d;", "newItems", "m", "(Ljava/util/List;)V", "", "sharedPercent", "", "realByToolCall", "o", "(ILjava/util/Map;)V", "toolCallId", "percent", "p", "(Ljava/lang/String;I)V", "", "stalled", "e", "(Z)V", "", "expiredIds", "n", "(Ljava/util/Set;)V", Const.INTENT_KEY_UMID, "()V", "Landroid/view/ViewGroup;", "parent", "viewType", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Landroid/view/ViewGroup;I)Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c$b;", "holder", "position", "", "", "payloads", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c$b;ILjava/util/List;)V", "f", "(Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c$b;I)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c$b;)V", "getItemCount", "()I", "Lp9/l;", "Lp9/a;", DidiCardProvider.KEY_ITEMS, "Ljava/util/List;", "Landroid/widget/ImageView;", "boundResultViews", "", "", "slotStartedAtMs", "Ljava/util/Map;", "itemSizePx", "I", "getItemSizePx", "k", "(I)V", "onItemClickListener", "getOnItemClickListener", "()Lp9/l;", "l", "(Lp9/l;)V", "Companion", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class c extends RecyclerView.Adapter<b> {
        private static final a Companion = new a(null);

        @Deprecated
        public static final long NEW_SLOT_CATCH_UP_MS = 1000;

        @Deprecated
        public static final String PAYLOAD_EXPIRED = "payload_expired";

        @Deprecated
        public static final String PAYLOAD_PROGRESS = "payload_progress";

        @Deprecated
        public static final String PAYLOAD_STALL = "payload_stall";
        private final List<ImageView> boundResultViews;
        private int itemSizePx;
        private final List<TtiImageItem> items;
        private final InterfaceC5074l<String, Y8.t> onImageLoadFailed;
        private InterfaceC5074l<? super Integer, Y8.t> onItemClickListener;
        private final InterfaceC5063a<Y8.t> onShaderRunningChanged;
        private final Map<String, Long> slotStartedAtMs;

        @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\b\u0010\u0006R\u0014\u0010\n\u001a\u00020\t8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c$a;", "", "<init>", "()V", "", "PAYLOAD_PROGRESS", "Ljava/lang/String;", "PAYLOAD_STALL", "PAYLOAD_EXPIRED", "", "NEW_SLOT_CATCH_UP_MS", "J", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class a {
            public /* synthetic */ a(kotlin.jvm.internal.i iVar) {
                this();
            }

            public a() {
            }
        }

        @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0014\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u0004¢\u0006\u0004\b\b\u0010\tJ\u0015\u0010\f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\f\u0010\rJ\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000e\u0010\rJ\u0015\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n¢\u0006\u0004\b\u000f\u0010\rJ\u001f\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\n2\b\b\u0002\u0010\u0011\u001a\u00020\u0010¢\u0006\u0004\b\u0012\u0010\u0013J\r\u0010\u0014\u001a\u00020\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\u0006¢\u0006\u0004\b\u0016\u0010\u0015J\u000f\u0010\u0017\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\u0017\u0010\u0015R\"\u0010\u0007\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u0005\u0012\u0004\u0012\u00020\u00060\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u0018R\u0017\u0010\u001a\u001a\u00020\u00198\u0006¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u001e\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001fR\u0014\u0010!\u001a\u00020 8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b!\u0010\"R\u0017\u0010$\u001a\u00020#8\u0006¢\u0006\f\n\u0004\b$\u0010%\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b(\u0010\u001fR\u0014\u0010)\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b)\u0010\u001f¨\u0006*"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$c$b;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "Landroid/view/View;", "itemView", "Lkotlin/Function1;", "", "LY8/t;", "onImageLoadFailed", "<init>", "(Landroid/view/View;Lp9/l;)V", "Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$d;", "item", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$d;)V", Const.INTENT_KEY_UMID, "c", "", "showCompletionPercent", "e", "(Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$d;Z)V", "m", "()V", "n", "l", "Lp9/l;", "Landroid/widget/ImageView;", "resultView", "Landroid/widget/ImageView;", "k", "()Landroid/widget/ImageView;", "overlay", "Landroid/view/View;", "Landroid/widget/TextView;", "progressText", "Landroid/widget/TextView;", "Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;", "loadingShader", "Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Lcom/stepos/ailauncher/taskstore/widget/HalftoneShaderView;", "failOverlay", "expiredOverlay", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final class b extends RecyclerView.ViewHolder {
            private final View expiredOverlay;
            private final View failOverlay;
            private final HalftoneShaderView loadingShader;
            private final InterfaceC5074l<String, Y8.t> onImageLoadFailed;
            private final View overlay;
            private final TextView progressText;
            private final ImageView resultView;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            public b(View itemView, InterfaceC5074l<? super String, Y8.t> onImageLoadFailed) {
                super(itemView);
                kotlin.jvm.internal.p.i(itemView, "itemView");
                kotlin.jvm.internal.p.i(onImageLoadFailed, "onImageLoadFailed");
                this.onImageLoadFailed = onImageLoadFailed;
                View viewFindViewById = itemView.findViewById(R$id.iv_tti_item_result);
                kotlin.jvm.internal.p.h(viewFindViewById, "findViewById(...)");
                this.resultView = (ImageView) viewFindViewById;
                View viewFindViewById2 = itemView.findViewById(R$id.layout_tti_item_generating_overlay);
                kotlin.jvm.internal.p.h(viewFindViewById2, "findViewById(...)");
                this.overlay = viewFindViewById2;
                View viewFindViewById3 = itemView.findViewById(R$id.tv_tti_item_progress);
                kotlin.jvm.internal.p.h(viewFindViewById3, "findViewById(...)");
                this.progressText = (TextView) viewFindViewById3;
                View viewFindViewById4 = itemView.findViewById(R$id.shader_tti_item_loading);
                kotlin.jvm.internal.p.h(viewFindViewById4, "findViewById(...)");
                this.loadingShader = (HalftoneShaderView) viewFindViewById4;
                View viewFindViewById5 = itemView.findViewById(R$id.layout_tti_item_fail_overlay);
                kotlin.jvm.internal.p.h(viewFindViewById5, "findViewById(...)");
                this.failOverlay = viewFindViewById5;
                View viewFindViewById6 = itemView.findViewById(R$id.layout_tti_item_expired_overlay);
                kotlin.jvm.internal.p.h(viewFindViewById6, "findViewById(...)");
                this.expiredOverlay = viewFindViewById6;
            }

            public static /* synthetic */ void f(b bVar, TtiImageItem ttiImageItem, boolean z10, int i10, Object obj) {
                if ((i10 & 2) != 0) {
                    z10 = false;
                }
                bVar.e(ttiImageItem, z10);
            }

            public static final Y8.t g(final b bVar, TtiImageItem ttiImageItem, boolean z10, boolean z11) {
                if (!z11) {
                    bVar.onImageLoadFailed.invoke(ttiImageItem.getFileId());
                    bVar.l();
                    return Y8.t.f7040a;
                }
                if (!kotlin.jvm.internal.p.d(w0.g(bVar.resultView), ttiImageItem.getUrl())) {
                    return Y8.t.f7040a;
                }
                if (z10) {
                    bVar.progressText.setText(bVar.itemView.getContext().getString(R$string.taskstore_tti_progress_percent, 100));
                    bVar.overlay.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.t0
                        @Override // java.lang.Runnable
                        public final void run() {
                            TextToImageCardView.c.b.h(this.f29405a);
                        }
                    }, 120L);
                } else {
                    bVar.overlay.setVisibility(8);
                }
                return Y8.t.f7040a;
            }

            public static final void h(b bVar) {
                bVar.overlay.setVisibility(8);
            }

            public final void c(TtiImageItem item) {
                kotlin.jvm.internal.p.i(item, "item");
                this.itemView.setAlpha(1.0f);
                if (!item.getIsExpired()) {
                    this.expiredOverlay.setVisibility(8);
                    f(this, item, false, 2, null);
                    return;
                }
                this.overlay.setVisibility(8);
                n();
                this.resultView.setVisibility(8);
                this.failOverlay.setVisibility(8);
                this.expiredOverlay.setVisibility(0);
                w0.f(this.resultView);
            }

            public final void d(TtiImageItem item) {
                String url;
                kotlin.jvm.internal.p.i(item, "item");
                if (item.getIsLoading() || (url = item.getUrl()) == null || La.H.x0(url)) {
                    boolean isStalled = item.getIsStalled();
                    HalftoneShaderView halftoneShaderView = this.loadingShader;
                    if (isStalled) {
                        halftoneShaderView.k();
                    } else {
                        halftoneShaderView.t();
                    }
                }
            }

            public final void e(final TtiImageItem item, boolean showCompletionPercent) {
                String url;
                kotlin.jvm.internal.p.i(item, "item");
                this.itemView.setAlpha(1.0f);
                if (item.getIsExpired()) {
                    this.overlay.setVisibility(8);
                    n();
                    this.resultView.setVisibility(8);
                    this.failOverlay.setVisibility(8);
                    this.expiredOverlay.setVisibility(0);
                    w0.f(this.resultView);
                    return;
                }
                if (item.getIsFailed()) {
                    l();
                    return;
                }
                if (item.getIsLoading() || (url = item.getUrl()) == null || La.H.x0(url)) {
                    this.overlay.setVisibility(0);
                    this.resultView.setVisibility(8);
                    this.failOverlay.setVisibility(8);
                    this.expiredOverlay.setVisibility(8);
                    this.progressText.setVisibility(item.getShowProgress() ? 0 : 8);
                    if (item.getShowProgress()) {
                        this.progressText.setText(this.itemView.getContext().getString(R$string.taskstore_tti_progress_percent, Integer.valueOf(item.getProgressPercent())));
                    }
                    if (item.getIsStalled()) {
                        this.loadingShader.k();
                    } else {
                        m();
                    }
                    w0.f(this.resultView);
                    return;
                }
                boolean z10 = this.overlay.getVisibility() == 0;
                final boolean z11 = z10 && this.progressText.getVisibility() == 0 && showCompletionPercent;
                this.failOverlay.setVisibility(8);
                this.expiredOverlay.setVisibility(8);
                this.resultView.setVisibility(0);
                if (z10) {
                    m();
                }
                ImageView imageView = this.resultView;
                String url2 = item.getUrl();
                if (url2 == null) {
                    url2 = "";
                }
                w0.h(imageView, url2, this.loadingShader, item.getFileId(), new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.s0
                    @Override // p9.InterfaceC5074l
                    public final Object invoke(Object obj) {
                        return TextToImageCardView.c.b.g(this.f29398a, item, z11, ((Boolean) obj).booleanValue());
                    }
                });
            }

            public final void i(TtiImageItem item) {
                String url;
                kotlin.jvm.internal.p.i(item, "item");
                if (item.getIsLoading() || (url = item.getUrl()) == null || La.H.x0(url)) {
                    this.progressText.setVisibility(item.getShowProgress() ? 0 : 8);
                    if (item.getShowProgress()) {
                        this.progressText.setText(this.itemView.getContext().getString(R$string.taskstore_tti_progress_percent, Integer.valueOf(item.getProgressPercent())));
                    }
                }
            }

            /* renamed from: j, reason: from getter */
            public final HalftoneShaderView getLoadingShader() {
                return this.loadingShader;
            }

            /* renamed from: k, reason: from getter */
            public final ImageView getResultView() {
                return this.resultView;
            }

            public final void l() {
                this.itemView.setAlpha(1.0f);
                this.overlay.setVisibility(8);
                n();
                this.resultView.setVisibility(8);
                this.expiredOverlay.setVisibility(8);
                this.failOverlay.setVisibility(0);
                w0.f(this.resultView);
            }

            public final void m() {
                this.loadingShader.t();
            }

            public final void n() {
                this.loadingShader.u();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        public c(InterfaceC5074l<? super String, Y8.t> onImageLoadFailed, InterfaceC5063a<Y8.t> onShaderRunningChanged) {
            kotlin.jvm.internal.p.i(onImageLoadFailed, "onImageLoadFailed");
            kotlin.jvm.internal.p.i(onShaderRunningChanged, "onShaderRunningChanged");
            this.onImageLoadFailed = onImageLoadFailed;
            this.onShaderRunningChanged = onShaderRunningChanged;
            this.items = new ArrayList();
            this.boundResultViews = new ArrayList();
            this.slotStartedAtMs = new LinkedHashMap();
        }

        public static final void h(c cVar, int i10, View view) {
            String url;
            InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l;
            TtiImageItem ttiImageItem = (TtiImageItem) Z8.F.t0(cVar.items, i10);
            if (ttiImageItem == null || ttiImageItem.getIsLoading() || ttiImageItem.getIsFailed() || (url = ttiImageItem.getUrl()) == null || La.H.x0(url) || (interfaceC5074l = cVar.onItemClickListener) == null) {
                return;
            }
            interfaceC5074l.invoke(Integer.valueOf(i10));
        }

        public final void d() {
            for (ImageView imageView : this.boundResultViews) {
                try {
                    Result.Companion companion = Result.INSTANCE;
                    w0.f(imageView);
                    Result.b(Y8.t.f7040a);
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    Result.b(C4849c.a(th));
                }
            }
            this.boundResultViews.clear();
        }

        public final void e(boolean stalled) {
            if (this.items.isEmpty()) {
                return;
            }
            int size = this.items.size();
            boolean z10 = false;
            for (int i10 = 0; i10 < size; i10++) {
                TtiImageItem ttiImageItem = this.items.get(i10);
                if (ttiImageItem.getIsLoading() && ttiImageItem.getIsStalled() != stalled) {
                    this.items.set(i10, TtiImageItem.b(ttiImageItem, null, 0, false, false, false, stalled, null, false, null, 479, null));
                    z10 = true;
                }
            }
            if (z10) {
                notifyItemRangeChanged(0, this.items.size(), PAYLOAD_STALL);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b holder, final int position) {
            kotlin.jvm.internal.p.i(holder, "holder");
            if (this.itemSizePx > 0) {
                ViewGroup.LayoutParams layoutParams = holder.itemView.getLayoutParams();
                int i10 = layoutParams.width;
                int i11 = this.itemSizePx;
                if (i10 != i11 || layoutParams.height != i11) {
                    layoutParams.width = i11;
                    layoutParams.height = i11;
                    holder.itemView.setLayoutParams(layoutParams);
                }
            }
            holder.e(this.items.get(position), position == C1173v.o(this.items));
            if (!this.boundResultViews.contains(holder.getResultView())) {
                this.boundResultViews.add(holder.getResultView());
            }
            holder.itemView.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.r0
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    TextToImageCardView.c.h(this.f29396a, position, view);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onBindViewHolder(b holder, int position, List<Object> payloads) {
            kotlin.jvm.internal.p.i(holder, "holder");
            kotlin.jvm.internal.p.i(payloads, "payloads");
            List<Object> list = payloads;
            if (!list.isEmpty()) {
                List<Object> list2 = payloads;
                if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                    Iterator<T> it = list2.iterator();
                    while (it.hasNext()) {
                        if (!kotlin.jvm.internal.p.d(it.next(), PAYLOAD_PROGRESS)) {
                        }
                    }
                }
                holder.i(this.items.get(position));
                return;
            }
            if (!list.isEmpty()) {
                List<Object> list3 = payloads;
                if (!(list3 instanceof Collection) || !list3.isEmpty()) {
                    Iterator<T> it2 = list3.iterator();
                    while (it2.hasNext()) {
                        if (!kotlin.jvm.internal.p.d(it2.next(), PAYLOAD_STALL)) {
                        }
                    }
                }
                holder.d(this.items.get(position));
                return;
            }
            if (!list.isEmpty()) {
                List<Object> list4 = payloads;
                if (!(list4 instanceof Collection) || !list4.isEmpty()) {
                    Iterator<T> it3 = list4.iterator();
                    while (it3.hasNext()) {
                        if (!kotlin.jvm.internal.p.d(it3.next(), PAYLOAD_EXPIRED)) {
                        }
                    }
                }
                holder.c(this.items.get(position));
                return;
            }
            super.onBindViewHolder(holder, position, payloads);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public b onCreateViewHolder(ViewGroup parent, int viewType) {
            kotlin.jvm.internal.p.i(parent, "parent");
            View viewInflate = LayoutInflater.from(parent.getContext()).inflate(R$layout.item_taskstore_card_tti_image, parent, false);
            kotlin.jvm.internal.p.f(viewInflate);
            b bVar = new b(viewInflate, this.onImageLoadFailed);
            bVar.getLoadingShader().setOnRunningChanged(this.onShaderRunningChanged);
            return bVar;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        /* renamed from: j, reason: merged with bridge method [inline-methods] */
        public void onViewRecycled(b holder) {
            kotlin.jvm.internal.p.i(holder, "holder");
            holder.n();
            w0.f(holder.getResultView());
            this.boundResultViews.remove(holder.getResultView());
            super.onViewRecycled(holder);
        }

        public final void k(int i10) {
            this.itemSizePx = i10;
        }

        public final void l(InterfaceC5074l<? super Integer, Y8.t> interfaceC5074l) {
            this.onItemClickListener = interfaceC5074l;
        }

        public final void m(List<TtiImageItem> newItems) {
            kotlin.jvm.internal.p.i(newItems, "newItems");
            List<TtiImageItem> list = this.items;
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                TtiImageItem ttiImageItem = (TtiImageItem) it.next();
                String toolCallId = ttiImageItem.getToolCallId();
                Pair pairA = toolCallId != null ? Y8.j.a(toolCallId, Integer.valueOf(ttiImageItem.getProgressPercent())) : null;
                if (pairA != null) {
                    arrayList.add(pairA);
                }
            }
            Map mapY = kotlin.collections.a.y(arrayList);
            List<TtiImageItem> list2 = newItems;
            ArrayList arrayList2 = new ArrayList(C1174w.x(list2, 10));
            for (TtiImageItem ttiImageItemB : list2) {
                String toolCallId2 = ttiImageItemB.getToolCallId();
                Integer num = toolCallId2 != null ? (Integer) mapY.get(toolCallId2) : null;
                if (toolCallId2 != null && ttiImageItemB.getProgressPercent() == 0 && num != null && num.intValue() > 0) {
                    ttiImageItemB = TtiImageItem.b(ttiImageItemB, null, num.intValue(), false, false, false, false, null, false, null, 509, null);
                }
                arrayList2.add(ttiImageItemB);
            }
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            List<TtiImageItem> list3 = this.items;
            ArrayList arrayList3 = new ArrayList();
            Iterator<T> it2 = list3.iterator();
            while (it2.hasNext()) {
                String toolCallId3 = ((TtiImageItem) it2.next()).getToolCallId();
                if (toolCallId3 != null) {
                    arrayList3.add(toolCallId3);
                }
            }
            Set setR1 = Z8.F.r1(arrayList3);
            ArrayList arrayList4 = new ArrayList();
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                String toolCallId4 = ((TtiImageItem) it3.next()).getToolCallId();
                if (toolCallId4 != null) {
                    arrayList4.add(toolCallId4);
                }
            }
            Set setR12 = Z8.F.r1(arrayList4);
            ArrayList arrayList5 = new ArrayList();
            for (Object obj : setR12) {
                if (!setR1.contains((String) obj)) {
                    arrayList5.add(obj);
                }
            }
            Iterator it4 = arrayList5.iterator();
            while (it4.hasNext()) {
                this.slotStartedAtMs.put((String) it4.next(), Long.valueOf(jElapsedRealtime));
            }
            this.slotStartedAtMs.keySet().retainAll(setR12);
            if (kotlin.jvm.internal.p.d(this.items, arrayList2)) {
                return;
            }
            this.items.clear();
            this.items.addAll(arrayList2);
            notifyDataSetChanged();
        }

        public final void n(Set<String> expiredIds) {
            kotlin.jvm.internal.p.i(expiredIds, "expiredIds");
            if (this.items.isEmpty()) {
                return;
            }
            int size = this.items.size();
            for (int i10 = 0; i10 < size; i10++) {
                String fileId = this.items.get(i10).getFileId();
                boolean z10 = (fileId == null || La.H.x0(fileId) || !expiredIds.contains(fileId)) ? false : true;
                if (this.items.get(i10).getIsExpired() != z10) {
                    List<TtiImageItem> list = this.items;
                    list.set(i10, TtiImageItem.b(list.get(i10), null, 0, false, false, false, false, null, z10, null, 383, null));
                    notifyItemChanged(i10, PAYLOAD_EXPIRED);
                }
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
        /* JADX WARN: Removed duplicated region for block: B:35:0x00b7 A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void o(int r20, java.util.Map<java.lang.String, java.lang.Integer> r21) {
            /*
                r19 = this;
                r0 = r19
                r1 = r21
                java.lang.String r2 = "realByToolCall"
                kotlin.jvm.internal.p.i(r1, r2)
                java.util.List<com.stepos.ailauncher.taskstore.widget.TextToImageCardView$d> r2 = r0.items
                boolean r2 = r2.isEmpty()
                if (r2 == 0) goto L14
                goto Lbb
            L14:
                long r2 = android.os.SystemClock.elapsedRealtime()
                java.util.List<com.stepos.ailauncher.taskstore.widget.TextToImageCardView$d> r4 = r0.items
                java.util.Collection r4 = (java.util.Collection) r4
                int r4 = r4.size()
                r5 = 0
            L21:
                if (r5 >= r4) goto Lbb
                java.util.List<com.stepos.ailauncher.taskstore.widget.TextToImageCardView$d> r6 = r0.items
                java.lang.Object r6 = r6.get(r5)
                r7 = r6
                com.stepos.ailauncher.taskstore.widget.TextToImageCardView$d r7 = (com.stepos.ailauncher.taskstore.widget.TextToImageCardView.TtiImageItem) r7
                boolean r6 = r7.getIsLoading()
                if (r6 == 0) goto Lb7
                java.lang.String r6 = r7.getToolCallId()
                if (r6 == 0) goto L3f
                java.lang.Object r6 = r1.get(r6)
                java.lang.Integer r6 = (java.lang.Integer) r6
                goto L40
            L3f:
                r6 = 0
            L40:
                if (r6 == 0) goto L52
                int r8 = r7.getProgressPercent()
                int r6 = r6.intValue()
                int r6 = java.lang.Math.max(r8, r6)
                r12 = r20
            L50:
                r9 = r6
                goto L95
            L52:
                java.lang.String r6 = r7.getToolCallId()
                if (r6 != 0) goto L59
                goto L7d
            L59:
                java.util.Map<java.lang.String, java.lang.Long> r6 = r0.slotStartedAtMs
                java.lang.String r8 = r7.getToolCallId()
                java.lang.Object r6 = r6.get(r8)
                java.lang.Long r6 = (java.lang.Long) r6
                if (r6 != 0) goto L68
                goto L7d
            L68:
                long r8 = r6.longValue()
                long r8 = r2 - r8
                r10 = 1000(0x3e8, double:4.94E-321)
                int r6 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
                if (r6 < 0) goto L81
                java.util.Map<java.lang.String, java.lang.Long> r6 = r0.slotStartedAtMs
                java.lang.String r8 = r7.getToolCallId()
                r6.remove(r8)
            L7d:
                r9 = r20
                r12 = r9
                goto L95
            L81:
                int r6 = r7.getProgressPercent()
                r12 = r20
                float r13 = (float) r12
                float r8 = (float) r8
                float r13 = r13 * r8
                float r8 = (float) r10
                float r13 = r13 / r8
                int r8 = r9.C5227b.b(r13)
                int r6 = java.lang.Math.max(r6, r8)
                goto L50
            L95:
                int r6 = r7.getProgressPercent()
                if (r6 == r9) goto Lb7
                java.util.List<com.stepos.ailauncher.taskstore.widget.TextToImageCardView$d> r6 = r0.items
                r17 = 509(0x1fd, float:7.13E-43)
                r18 = 0
                r8 = 0
                r10 = 0
                r11 = 0
                r12 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                r16 = 0
                com.stepos.ailauncher.taskstore.widget.TextToImageCardView$d r7 = com.stepos.ailauncher.taskstore.widget.TextToImageCardView.TtiImageItem.b(r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
                r6.set(r5, r7)
                java.lang.String r6 = "payload_progress"
                r0.notifyItemChanged(r5, r6)
            Lb7:
                int r5 = r5 + 1
                goto L21
            Lbb:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TextToImageCardView.c.o(int, java.util.Map):void");
        }

        public final void p(String toolCallId, int percent) {
            kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
            if (this.items.isEmpty() || La.H.x0(toolCallId)) {
                return;
            }
            int size = this.items.size();
            for (int i10 = 0; i10 < size; i10++) {
                TtiImageItem ttiImageItem = this.items.get(i10);
                if (ttiImageItem.getIsLoading() && kotlin.jvm.internal.p.d(ttiImageItem.getToolCallId(), toolCallId) && ttiImageItem.getProgressPercent() != percent) {
                    this.slotStartedAtMs.remove(toolCallId);
                    this.items.set(i10, TtiImageItem.b(ttiImageItem, null, percent, false, false, false, false, null, false, null, 509, null));
                    notifyItemChanged(i10, PAYLOAD_PROGRESS);
                }
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class e {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskInfoStatus.values().length];
            try {
                iArr[TaskInfoStatus.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskInfoStatus.IN_PROGRESS.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class f implements Runnable {
        final /* synthetic */ int $gen$inlined;
        final /* synthetic */ Map $map$inlined;

        public f(int i10, Map map) {
            this.$gen$inlined = i10;
            this.$map$inlined = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextToImageCardView.this.Q(this.$gen$inlined, this.$map$inlined);
        }
    }

    @Metadata(d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0017\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016¢\u0006\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"com/stepos/ailauncher/taskstore/widget/TextToImageCardView$g", "Landroid/animation/AnimatorListenerAdapter;", "Landroid/animation/Animator;", "animation", "LY8/t;", "onAnimationEnd", "(Landroid/animation/Animator;)V", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class g extends AnimatorListenerAdapter {
        public g() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animation) {
            kotlin.jvm.internal.p.i(animation, "animation");
            if (TextToImageCardView.this.animatorKind == AnimatorKind.FINISH) {
                TextToImageCardView.this.animatorKind = AnimatorKind.NONE;
                TextToImageCardView.this.progressAnimator = null;
                TextToImageCardView.this.finishing = false;
                TextToImageCardView textToImageCardView = TextToImageCardView.this;
                TextToImageCardView.N0(textToImageCardView, textToImageCardView.pendingFinishParts, false, 2, null);
            }
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class h implements Runnable {
        final /* synthetic */ int $gen$inlined;
        final /* synthetic */ Map $map$inlined;

        public h(int i10, Map map) {
            this.$gen$inlined = i10;
            this.$map$inlined = map;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextToImageCardView.this.Q(this.$gen$inlined, this.$map$inlined);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class i implements Runnable {
        final /* synthetic */ String $fileId$inlined;
        final /* synthetic */ String $url$inlined;

        public i(String str, String str2) {
            this.$fileId$inlined = str;
            this.$url$inlined = str2;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TextToImageCardView.this.y0(this.$fileId$inlined, this.$url$inlined);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final class j implements Runnable {
        final /* synthetic */ Throwable $e$inlined;
        final /* synthetic */ String $fileId$inlined;

        public j(String str, Throwable th) {
            this.$fileId$inlined = str;
            this.$e$inlined = th;
        }

        @Override // java.lang.Runnable
        public final void run() {
            TaskInfoCard boundCard;
            TextToImageCardView.this.resolvingFileIds.remove(this.$fileId$inlined);
            TextToImageCardView.this.failedImageFileIds.add(this.$fileId$inlined);
            Log.w(TextToImageCardView.TAG, "sign artifact url failed fileId=" + this.$fileId$inlined, this.$e$inlined);
            if (TextToImageCardView.this.isBinding || (boundCard = TextToImageCardView.this.getBoundCard()) == null) {
                return;
            }
            AbstractC3737c.d(TextToImageCardView.this, boundCard, null, 2, null);
        }
    }

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class k implements k.a, kotlin.jvm.internal.l {
        public k() {
        }

        @Override // com.stepos.agentframework.display.k.a
        public final void a(long j10) {
            TextToImageCardView.this.C0(j10);
        }

        public final boolean equals(Object obj) {
            if ((obj instanceof k.a) && (obj instanceof kotlin.jvm.internal.l)) {
                return kotlin.jvm.internal.p.d(getFunctionDelegate(), ((kotlin.jvm.internal.l) obj).getFunctionDelegate());
            }
            return false;
        }

        @Override // kotlin.jvm.internal.l
        public final Y8.e<?> getFunctionDelegate() {
            return new FunctionReferenceImpl(1, TextToImageCardView.this, TextToImageCardView.class, "onWaitClock", "onWaitClock(J)V", 0);
        }

        public final int hashCode() {
            return getFunctionDelegate().hashCode();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TextToImageCardView(final Context context, AttributeSet attributeSet, int i10) throws Resources.NotFoundException {
        super(context, attributeSet, i10);
        kotlin.jvm.internal.p.i(context, "context");
        C5661b c5661bB = C5661b.b(LayoutInflater.from(context), this, true);
        kotlin.jvm.internal.p.h(c5661bB, "inflate(...)");
        this.binding = c5661bB;
        this.generationStartFileIds = Z8.Y.e();
        this.pendingToolCallIds = new LinkedHashSet<>();
        this.toolCallProgressPercent = new LinkedHashMap<>();
        this.exposureTimer = new C3715c(this, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.i0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TextToImageCardView.j0(context, this, (String) obj);
            }
        });
        this.exposedFileIds = new HashSet<>();
        this.lastAppliedProgressInt = Integer.MIN_VALUE;
        this.trickleTick = new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.j0
            @Override // java.lang.Runnable
            public final void run() {
                TextToImageCardView.y1(this.f29379a);
            }
        };
        this.catchUpInterpolator = new DecelerateInterpolator(1.0f);
        this.animatorKind = AnimatorKind.NONE;
        this.pendingFinishParts = C1173v.m();
        this.staleProgressWatchdog = new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.k0
            @Override // java.lang.Runnable
            public final void run() {
                TextToImageCardView.o1(this.f29380a);
            }
        };
        this.currentImageUrls = C1173v.m();
        this.currentImageFileIds = C1173v.m();
        this.expiredFileIds = new HashSet<>();
        this.blockedFileIds = new HashSet<>();
        this.availabilityChangedListener = new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.widget.l0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TextToImageCardView.V(this.f29383a);
            }
        };
        this.signedUrls = new HashMap<>();
        this.resolvingFileIds = new HashSet<>();
        this.failedImageFileIds = new HashSet<>();
        c cVar = new c(new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.m0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TextToImageCardView.w0(this.f29385a, (String) obj);
            }
        }, new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.widget.n0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TextToImageCardView.x0(this.f29387a);
            }
        });
        this.multiImageAdapter = cVar;
        int dimensionPixelSize = getResources().getDimensionPixelSize(R$dimen.taskstore_card_tti_multi_item_gap);
        this.multiItemGapPx = dimensionPixelSize;
        this.multiItemSizePx = getResources().getDimensionPixelSize(R$dimen.taskstore_card_tti_multi_item_size);
        c5661bB.layoutTtiCardHeader.setVisibility(8);
        c5661bB.hostTtiCardMultiImage.setAllowHorizontalParentHandoffAtBoundary(true);
        RecyclerView recyclerView = c5661bB.rvTtiCardMultiImage;
        recyclerView.setLayoutManager(new LinearLayoutManager(context, 0, false));
        recyclerView.setAdapter(cVar);
        recyclerView.setItemAnimator(null);
        recyclerView.setOverScrollMode(2);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.addItemDecoration(new b(dimensionPixelSize));
        c5661bB.btnTtiCardAction.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.o0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextToImageCardView.y(this.f29391a, view);
            }
        });
        setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.p0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextToImageCardView.z(this.f29394a, view);
            }
        });
        c5661bB.shaderTtiCardLoading.setOnRunningChanged(new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.widget.q0
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TextToImageCardView.A(this.f29395a);
            }
        });
        c5661bB.tvTtiCardSubtitle.setOnWaitFrameDrawn(new InterfaceC5063a() { // from class: com.stepos.ailauncher.taskstore.widget.Z
            @Override // p9.InterfaceC5063a
            public final Object invoke() {
                return TextToImageCardView.B();
            }
        });
    }

    public static final Y8.t A(TextToImageCardView textToImageCardView) throws Exception {
        textToImageCardView.x1();
        return Y8.t.f7040a;
    }

    public static final Y8.t B() {
        M6.c.INSTANCE.v();
        return Y8.t.f7040a;
    }

    public static final Y8.t G0(TextToImageCardView textToImageCardView, int i10, Map map) {
        kotlin.jvm.internal.p.i(map, "map");
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            textToImageCardView.Q(i10, map);
        } else {
            textToImageCardView.post(textToImageCardView.new h(i10, map));
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void I0(TextToImageCardView textToImageCardView, int i10, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            i10 = textToImageCardView.Z();
        }
        textToImageCardView.H0(i10);
    }

    public static /* synthetic */ void N0(TextToImageCardView textToImageCardView, List list, boolean z10, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            z10 = false;
        }
        textToImageCardView.M0(list, z10);
    }

    public static final Y8.t P(TextToImageCardView textToImageCardView, int i10, Map map) {
        kotlin.jvm.internal.p.i(map, "map");
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            textToImageCardView.Q(i10, map);
        } else {
            textToImageCardView.post(textToImageCardView.new f(i10, map));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t Q0(List list, TextToImageCardView textToImageCardView, int i10) {
        String url;
        TtiImageItem ttiImageItem = (TtiImageItem) Z8.F.t0(list, i10);
        if (ttiImageItem == null || !ttiImageItem.getIsExpired()) {
            List<TtiImageItem> listF1 = Z8.F.f1(list, i10 + 1);
            int i11 = 0;
            if (!(listF1 instanceof Collection) || !listF1.isEmpty()) {
                for (TtiImageItem ttiImageItem2 : listF1) {
                    if (!ttiImageItem2.getIsFailed() && !ttiImageItem2.getIsExpired() && (url = ttiImageItem2.getUrl()) != null && !La.H.x0(url) && (i11 = i11 + 1) < 0) {
                        C1173v.v();
                    }
                }
            }
            int i12 = i11 - 1;
            if (i12 >= 0) {
                textToImageCardView.D0(i12);
            }
        } else {
            C5579b c5579b = C5579b.INSTANCE;
            Context context = textToImageCardView.getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            c5579b.c(context);
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t V(TextToImageCardView textToImageCardView) {
        TaskInfoCard boundCard = textToImageCardView.getBoundCard();
        if (boundCard != null) {
            if (!boundCard.getStatus().isTerminal()) {
                boundCard = null;
            }
            if (boundCard != null) {
                textToImageCardView.O(boundCard);
            }
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void V0(TextToImageCardView textToImageCardView, int i10, boolean z10, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z10 = true;
        }
        textToImageCardView.U0(i10, z10);
    }

    public static final Y8.t X0(String str, final TextToImageCardView textToImageCardView, String str2, boolean z10, boolean z11) {
        if (!z11) {
            if (str != null) {
                textToImageCardView.failedImageFileIds.add(str);
            }
            textToImageCardView.T0();
            return Y8.t.f7040a;
        }
        ImageView ivTtiCardResultImage = textToImageCardView.binding.ivTtiCardResultImage;
        kotlin.jvm.internal.p.h(ivTtiCardResultImage, "ivTtiCardResultImage");
        if (!kotlin.jvm.internal.p.d(w0.g(ivTtiCardResultImage), str2)) {
            return Y8.t.f7040a;
        }
        if (z10) {
            textToImageCardView.displayedProgressPercent = 100.0f;
            textToImageCardView.T(100);
            textToImageCardView.u1();
            textToImageCardView.showingGeneratingUi = false;
            textToImageCardView.binding.layoutTtiCardGeneratingOverlay.postDelayed(new Runnable() { // from class: com.stepos.ailauncher.taskstore.widget.Y
                @Override // java.lang.Runnable
                public final void run() {
                    TextToImageCardView.Y0(this.f29354a);
                }
            }, 120L);
        } else {
            textToImageCardView.binding.layoutTtiCardGeneratingOverlay.setVisibility(8);
        }
        return Y8.t.f7040a;
    }

    public static final void Y0(TextToImageCardView textToImageCardView) {
        textToImageCardView.binding.layoutTtiCardGeneratingOverlay.setVisibility(8);
    }

    public static final void Z0(TextToImageCardView textToImageCardView, View view) {
        textToImageCardView.D0(0);
    }

    public static /* synthetic */ void d1(TextToImageCardView textToImageCardView, boolean z10, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            z10 = true;
        }
        textToImageCardView.c1(z10);
    }

    public static final Y8.t f1(TextToImageCardView textToImageCardView, String str, String url) {
        kotlin.jvm.internal.p.i(url, "url");
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            textToImageCardView.y0(str, url);
        } else {
            textToImageCardView.post(textToImageCardView.new i(str, url));
        }
        return Y8.t.f7040a;
    }

    public static final Y8.t g1(TextToImageCardView textToImageCardView, String str, Throwable th) {
        TaskInfoCard boundCard;
        if (kotlin.jvm.internal.p.d(Looper.myLooper(), Looper.getMainLooper())) {
            textToImageCardView.resolvingFileIds.remove(str);
            textToImageCardView.failedImageFileIds.add(str);
            Log.w(TAG, "sign artifact url failed fileId=" + str, th);
            if (!textToImageCardView.isBinding && (boundCard = textToImageCardView.getBoundCard()) != null) {
                AbstractC3737c.d(textToImageCardView, boundCard, null, 2, null);
            }
        } else {
            textToImageCardView.post(textToImageCardView.new j(str, th));
        }
        return Y8.t.f7040a;
    }

    private final void h0(TaskInfoCard card) {
        if (this.standaloneCard) {
            return;
        }
        if (card == null) {
            InterfaceC3745k actionListener = getActionListener();
            if (actionListener != null) {
                actionListener.a(null);
                return;
            }
            return;
        }
        if (this.currentImageFileIds.size() == 1 && r0(0)) {
            C5579b c5579b = C5579b.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            c5579b.c(context);
            return;
        }
        if (card.getStatus().isTerminal()) {
            com.stepos.ailauncher.taskstore.livenotification.A a10 = com.stepos.ailauncher.taskstore.livenotification.A.INSTANCE;
            Context context2 = getContext();
            kotlin.jvm.internal.p.h(context2, "getContext(...)");
            a10.a(context2, card.getTaskId());
            InterfaceC3745k actionListener2 = getActionListener();
            if (actionListener2 != null) {
                actionListener2.a(card);
            }
        }
    }

    public static final Y8.t j0(Context context, TextToImageCardView textToImageCardView, String exposedTaskId) {
        kotlin.jvm.internal.p.i(exposedTaskId, "exposedTaskId");
        ArtifactExposureNotificationCanceller.INSTANCE.b(context, exposedTaskId, TAG);
        textToImageCardView.b1();
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void k1(TextToImageCardView textToImageCardView, int i10, Long l10, String str, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            l10 = null;
        }
        if ((i11 & 4) != 0) {
            str = null;
        }
        textToImageCardView.j1(i10, l10, str);
    }

    public static final void l0(TextToImageCardView textToImageCardView, ValueAnimator anim) {
        kotlin.jvm.internal.p.i(anim, "anim");
        Object animatedValue = anim.getAnimatedValue();
        kotlin.jvm.internal.p.g(animatedValue, "null cannot be cast to non-null type kotlin.Float");
        float fFloatValue = ((Float) animatedValue).floatValue();
        textToImageCardView.displayedProgressPercent = fFloatValue;
        textToImageCardView.T(C5227b.b(fFloatValue));
    }

    private final void l1(TaskInfoCard card) {
        String summary = card.getSummary();
        if (summary == null || La.H.x0(summary)) {
            summary = null;
        }
        if (summary == null) {
            this.binding.tvTtiCardToolcallName.setText("");
            this.binding.tvTtiCardToolcallName.setVisibility(8);
        } else {
            this.binding.tvTtiCardToolcallName.setText(getContext().getString(R$string.taskstore_tti_completed_summary, summary));
            this.binding.tvTtiCardToolcallName.setVisibility(8);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void m1(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r5) {
        /*
            r4 = this;
            java.lang.String r0 = r5.getSummary()
            r1 = 0
            if (r0 == 0) goto L14
            boolean r2 = La.H.x0(r0)
            if (r2 != 0) goto Le
            goto Lf
        Le:
            r0 = r1
        Lf:
            if (r0 != 0) goto L12
            goto L14
        L12:
            r1 = r0
            goto L27
        L14:
            com.stepos.ailauncher.taskstore.entity.TaskInfoAnswer r5 = r5.getAnswer()
            if (r5 == 0) goto L27
            java.lang.String r5 = r5.getError()
            if (r5 == 0) goto L27
            boolean r0 = La.H.x0(r5)
            if (r0 != 0) goto L27
            r1 = r5
        L27:
            r5 = 8
            if (r1 != 0) goto L3c
            v6.b r0 = r4.binding
            android.widget.TextView r0 = r0.tvTtiCardToolcallName
            java.lang.String r1 = ""
            r0.setText(r1)
            v6.b r4 = r4.binding
            android.widget.TextView r4 = r4.tvTtiCardToolcallName
            r4.setVisibility(r5)
            return
        L3c:
            v6.b r0 = r4.binding
            android.widget.TextView r0 = r0.tvTtiCardToolcallName
            android.content.Context r2 = r4.getContext()
            int r3 = com.stepos.ailauncher.taskstore.R$string.taskstore_tti_failed_summary
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r1 = r2.getString(r3, r1)
            r0.setText(r1)
            v6.b r4 = r4.binding
            android.widget.TextView r4 = r4.tvTtiCardToolcallName
            r4.setVisibility(r5)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TextToImageCardView.m1(com.stepos.ailauncher.taskstore.entity.TaskInfoCard):void");
    }

    public static final void o1(TextToImageCardView textToImageCardView) {
        textToImageCardView.z0();
    }

    private final boolean q0(TaskInfoStatus taskInfoStatus) {
        int i10 = e.$EnumSwitchMapping$0[taskInfoStatus.ordinal()];
        return i10 == 1 || i10 == 2;
    }

    private final void q1(Ua.M scope) {
        String str = this.taskId;
        if (str == null) {
            return;
        }
        try {
            C1060i.d(scope, null, null, new TextToImageCardView$startObservingCard$1(TaskStoreModule.INSTANCE.n(), str, this, null), 3, null);
        } catch (IllegalStateException e10) {
            Log.w(TAG, "TaskStoreModule not initialized, skip observing taskId=" + str, e10);
        }
    }

    public static final Y8.t w0(TextToImageCardView textToImageCardView, String str) {
        if (str != null) {
            textToImageCardView.failedImageFileIds.add(str);
        }
        return Y8.t.f7040a;
    }

    public static /* synthetic */ void w1(TextToImageCardView textToImageCardView, List list, TaskInfoCard taskInfoCard, int i10, Object obj) {
        if ((i10 & 2) != 0) {
            taskInfoCard = null;
        }
        textToImageCardView.v1(list, taskInfoCard);
    }

    public static final Y8.t x0(TextToImageCardView textToImageCardView) throws Exception {
        textToImageCardView.x1();
        return Y8.t.f7040a;
    }

    public static final void y(TextToImageCardView textToImageCardView, View view) {
        textToImageCardView.h0(textToImageCardView.getBoundCard());
    }

    public static final void y1(TextToImageCardView textToImageCardView) {
        textToImageCardView.B0();
    }

    public static final void z(TextToImageCardView textToImageCardView, View view) {
        textToImageCardView.h0(textToImageCardView.getBoundCard());
    }

    public final void A0(String toolCallId) {
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        if (La.H.x0(toolCallId)) {
            return;
        }
        this.pendingToolCallIds.remove(toolCallId);
        this.toolCallProgressPercent.remove(toolCallId);
    }

    public final void B0() {
        this.tricklePosted = false;
        if (this.animatorKind == AnimatorKind.FINISH) {
            return;
        }
        if (!this.isRunningProgress || this.generatingStalled) {
            this.animatorKind = AnimatorKind.NONE;
            return;
        }
        float f10 = this.displayedProgressPercent;
        float f11 = 99 - f10;
        if (f11 < 0.3f) {
            this.animatorKind = AnimatorKind.NONE;
            return;
        }
        float fI = C5685n.i(f10 + C5685n.e(f11 * TRICKLE_STEP_FRACTION * 0.41666666f, 0.0625f), 99.0f);
        this.displayedProgressPercent = fI;
        T(C5227b.b(fI));
        this.animatorKind = AnimatorKind.TRICKLE;
        if (!this.isRunningProgress || this.generatingStalled) {
            return;
        }
        i1();
    }

    public final void C0(long nowMs) {
        this.binding.tvTtiCardSubtitle.advanceWaitFrame(nowMs);
        if (this.animatorKind != AnimatorKind.TRICKLE) {
            return;
        }
        long j10 = this.lastTrickleAtMs;
        if (j10 == 0) {
            this.lastTrickleAtMs = nowMs;
        } else {
            if (nowMs - j10 < 500) {
                return;
            }
            this.lastTrickleAtMs = nowMs;
            B0();
        }
    }

    public final void D0(int position) {
        if (r0(position)) {
            C5579b c5579b = C5579b.INSTANCE;
            Context context = getContext();
            kotlin.jvm.internal.p.h(context, "getContext(...)");
            c5579b.c(context);
            return;
        }
        List<String> list = this.currentImageUrls;
        if (list.isEmpty()) {
            return;
        }
        g0();
        int iN = C5685n.n(position, 0, list.size() - 1);
        a1(iN);
        com.stepos.agentframework.util.u.INSTANCE.i(this, list, iN, true);
    }

    public final int E0(String toolCallId, int sharedPercent) {
        if (toolCallId == null || La.H.x0(toolCallId)) {
            return sharedPercent;
        }
        Integer num = this.toolCallProgressPercent.get(toolCallId);
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final void F0(TaskInfoCard card, List<TaskInfoPart> imageParts) {
        if (card.getStatus().isTerminal()) {
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = imageParts.iterator();
            while (it.hasNext()) {
                String fileId = ((TaskInfoPart) it.next()).getFileId();
                if (fileId == null || La.H.x0(fileId)) {
                    fileId = null;
                }
                if (fileId != null) {
                    arrayList.add(fileId);
                }
            }
            List<String> listG0 = Z8.F.g0(arrayList);
            if (listG0.isEmpty()) {
                return;
            }
            String str = card.getTaskId() + "|" + Z8.F.A0(listG0, Const.STR_MART_COMMA, null, null, 0, null, null, 62, null);
            if (kotlin.jvm.internal.p.d(this.lastAvailabilityQueryKey, str)) {
                return;
            }
            this.lastAvailabilityQueryKey = str;
            final int i10 = this.availabilityGeneration + 1;
            this.availabilityGeneration = i10;
            com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.f(listG0, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.h0
                @Override // p9.InterfaceC5074l
                public final Object invoke(Object obj) {
                    return TextToImageCardView.G0(this.f29374a, i10, (Map) obj);
                }
            });
        }
    }

    public final void H0(int imageCount) {
        if (t0()) {
            this.expectedImageCount = x0.INSTANCE.a(this.expectedImageCount, imageCount, this.pendingToolCallIds.size());
        }
    }

    public final void J0() throws Exception {
        this.revisionGenerationInFlight = false;
        this.showingGeneratingUi = false;
        this.generationUiSeen = false;
        this.lastVisualSignature = null;
        this.exposureTimer.g();
        this.exposedFileIds.clear();
        u1();
        this.binding.shaderTtiCardLoading.u();
        this.binding.ivTtiCardResultImage.setOnClickListener(null);
        ImageView ivTtiCardResultImage = this.binding.ivTtiCardResultImage;
        kotlin.jvm.internal.p.h(ivTtiCardResultImage, "ivTtiCardResultImage");
        w0.f(ivTtiCardResultImage);
        this.multiImageAdapter.l(null);
        this.multiImageAdapter.m(C1173v.m());
        t1();
        this.multiImageAdapter.d();
        x1();
    }

    public final void K0(TaskInfoCard card, List<TaskInfoPart> imageParts) {
        if (t0()) {
            I0(this, 0, 1, null);
            R0(TaskInfoCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, 0, 0, false, TaskInfoStatus.RUNNING, null, null, null, null, null, null, null, null, 0L, null, null, 0L, null, null, null, null, null, null, null, null, -16785409, 3, null), imageParts);
            return;
        }
        e(getContext().getString(R$string.taskstore_tti_completed), androidx.core.content.a.c(getContext(), R$color.taskstore_card_status_success));
        SweepTextView tvTtiCardSubtitle = this.binding.tvTtiCardSubtitle;
        kotlin.jvm.internal.p.h(tvTtiCardSubtitle, "tvTtiCardSubtitle");
        SweepTextView.setSweepActive$default(tvTtiCardSubtitle, false, 0, 2, null);
        l1(card);
        this.binding.layoutTtiCardActionRow.setVisibility(8);
        k0(imageParts);
    }

    public final void L0(TaskInfoCard card, List<TaskInfoPart> imageParts) {
        u1();
        if (card.getStatus() == TaskInfoStatus.CANCELLED) {
            e(getContext().getString(R$string.taskstore_tti_cancelled), androidx.core.content.a.c(getContext(), R$color.taskstore_card_status_normal));
        } else {
            e(getContext().getString(R$string.taskstore_tti_failed), androidx.core.content.a.c(getContext(), R$color.taskstore_card_status_failed));
        }
        SweepTextView tvTtiCardSubtitle = this.binding.tvTtiCardSubtitle;
        kotlin.jvm.internal.p.h(tvTtiCardSubtitle, "tvTtiCardSubtitle");
        SweepTextView.setSweepActive$default(tvTtiCardSubtitle, false, 0, 2, null);
        m1(card);
        this.binding.layoutTtiCardActionRow.setVisibility(8);
        if (imageParts.isEmpty()) {
            T0();
            return;
        }
        TaskInfoProgress progress = card.getProgress();
        if ((progress != null && progress.getTotal() > 1) || this.expectedImageCount > 1 || imageParts.size() > 1) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : imageParts) {
                if (!s0((TaskInfoPart) obj)) {
                    arrayList.add(obj);
                }
            }
            imageParts = arrayList;
        }
        if (imageParts.isEmpty()) {
            T0();
        } else {
            N0(this, imageParts, false, 2, null);
        }
    }

    public final void M0(List<TaskInfoPart> imageParts, boolean appendGenerationLoading) {
        String str;
        boolean z10;
        ArrayList arrayList;
        String str2;
        boolean z11;
        String fileId;
        boolean z12 = (this.activeGenerationToolCallId == null || appendGenerationLoading) ? false : true;
        boolean z13 = appendGenerationLoading || z12;
        this.showingGeneratingUi = z13;
        if (z13) {
            this.generationUiSeen = true;
        }
        int iB = appendGenerationLoading ? x0.INSTANCE.b(imageParts.size(), this.pendingToolCallIds.size()) : 0;
        ArrayList arrayList2 = new ArrayList(imageParts.size() + iB);
        for (TaskInfoPart taskInfoPart : imageParts) {
            boolean zS0 = s0(taskInfoPart);
            String strI0 = zS0 ? null : i0(taskInfoPart);
            if (zS0 || strI0 != null || (fileId = taskInfoPart.getFileId()) == null || La.H.x0(fileId)) {
                str = null;
                z10 = false;
            } else {
                str = null;
                z10 = true;
            }
            String fileId2 = taskInfoPart.getFileId();
            String str3 = (fileId2 == null || La.H.x0(fileId2)) ? str : fileId2;
            int iB2 = z12 ? C5227b.b(this.displayedProgressPercent) : 100;
            if (zS0 || (strI0 == null && !z10)) {
                arrayList = arrayList2;
                str2 = strI0;
                z11 = true;
            } else {
                arrayList = arrayList2;
                str2 = strI0;
                z11 = false;
            }
            ArrayList arrayList3 = arrayList;
            arrayList3.add(new TtiImageItem(str2, iB2, z10, z11, z12, false, str3, str3 != null && this.expiredFileIds.contains(str3), null, 288, null));
            arrayList2 = arrayList3;
        }
        ArrayList arrayList4 = arrayList2;
        if (iB > 0) {
            int iB3 = C5227b.b(this.displayedProgressPercent);
            List<String> listN = N();
            for (int i10 = 0; i10 < iB; i10++) {
                String str4 = (String) Z8.F.t0(listN, i10);
                arrayList4.add(new TtiImageItem(null, E0(str4, iB3), true, false, false, false, null, false, str4, 240, null));
            }
        }
        if (arrayList4.isEmpty()) {
            T0();
            return;
        }
        if (arrayList4.size() != 1) {
            P0(arrayList4);
            return;
        }
        Object obj = arrayList4.get(0);
        kotlin.jvm.internal.p.h(obj, "get(...)");
        TtiImageItem ttiImageItem = (TtiImageItem) obj;
        if (ttiImageItem.getIsExpired()) {
            S0();
            return;
        }
        if (ttiImageItem.getIsFailed()) {
            T0();
            return;
        }
        if (ttiImageItem.getIsLoading()) {
            U0(ttiImageItem.getProgressPercent(), ttiImageItem.getShowProgress());
            return;
        }
        String url = ttiImageItem.getUrl();
        if (url == null) {
            url = "";
        }
        W0(url, ttiImageItem.getFileId());
    }

    public final List<String> N() {
        String str = this.taskId;
        List<String> listM = null;
        if (str != null) {
            if (La.H.x0(str)) {
                str = null;
            }
            if (str != null) {
                listM = com.stepos.ailauncher.taskstore.chat.B.INSTANCE.J(str, this.versionId);
            }
        }
        if (listM == null) {
            listM = C1173v.m();
        }
        return !listM.isEmpty() ? listM : Z8.F.m1(this.pendingToolCallIds);
    }

    public final void O(TaskInfoCard card) {
        List<TaskInfoPart> listO0 = o0(card);
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = listO0.iterator();
        while (it.hasNext()) {
            String fileId = ((TaskInfoPart) it.next()).getFileId();
            if (fileId == null || La.H.x0(fileId)) {
                fileId = null;
            }
            if (fileId != null) {
                arrayList.add(fileId);
            }
        }
        List<String> listG0 = Z8.F.g0(arrayList);
        if (listG0.isEmpty()) {
            return;
        }
        final int i10 = this.availabilityGeneration;
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.d(listG0, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.a0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TextToImageCardView.P(this.f29355a, i10, (Map) obj);
            }
        });
    }

    public final void O0(int count, int percent) {
        this.binding.layoutTtiCardSingleImage.setVisibility(8);
        this.binding.shaderTtiCardLoading.u();
        this.binding.hostTtiCardMultiImage.setVisibility(0);
        S(this.multiItemSizePx);
        List<String> listN = N();
        ArrayList arrayList = new ArrayList(count);
        for (int i10 = 0; i10 < count; i10++) {
            String str = (String) Z8.F.t0(listN, i10);
            arrayList.add(new TtiImageItem(null, E0(str, percent), true, false, false, this.generatingStalled, null, false, str, 208, null));
        }
        this.multiImageAdapter.m(arrayList);
    }

    public final void P0(final List<TtiImageItem> items) {
        this.binding.layoutTtiCardSingleImage.setVisibility(8);
        this.binding.layoutTtiCardSingleImage.setAlpha(1.0f);
        this.binding.shaderTtiCardLoading.u();
        this.binding.hostTtiCardMultiImage.setVisibility(0);
        this.binding.hostTtiCardMultiImage.setAlpha(1.0f);
        S(this.multiItemSizePx);
        this.multiImageAdapter.m(items);
        this.multiImageAdapter.l(new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.d0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TextToImageCardView.Q0(items, this, ((Integer) obj).intValue());
            }
        });
    }

    public final void Q(int gen, Map<String, ? extends ArtifactAvailability> map) {
        if (gen != this.availabilityGeneration) {
            return;
        }
        C5579b c5579b = C5579b.INSTANCE;
        Set<String> setE = c5579b.e(map);
        Set<String> setA = c5579b.a(map);
        boolean zD = kotlin.jvm.internal.p.d(setE, this.expiredFileIds);
        if (!zD) {
            this.expiredFileIds.clear();
            this.expiredFileIds.addAll(setE);
        }
        if (kotlin.jvm.internal.p.d(setA, this.blockedFileIds)) {
            if (zD) {
                return;
            }
            R();
            return;
        }
        this.blockedFileIds.clear();
        this.blockedFileIds.addAll(setA);
        TaskInfoCard boundCard = getBoundCard();
        if (boundCard != null) {
            if (!boundCard.getStatus().isTerminal()) {
                boundCard = null;
            }
            if (boundCard != null) {
                AbstractC3737c.d(this, boundCard, null, 2, null);
            }
        }
    }

    public final void R() {
        this.binding.hostTtiCardMultiImage.setAlpha(1.0f);
        this.multiImageAdapter.n(this.expiredFileIds);
        this.binding.layoutTtiCardSingleImage.setAlpha(1.0f);
        if (this.binding.layoutTtiCardSingleImage.getVisibility() == 0 && r0(0)) {
            S0();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:57:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void R0(com.stepos.ailauncher.taskstore.entity.TaskInfoCard r10, java.util.List<com.stepos.ailauncher.taskstore.entity.TaskInfoPart> r11) {
        /*
            Method dump skipped, instructions count: 360
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TextToImageCardView.R0(com.stepos.ailauncher.taskstore.entity.TaskInfoCard, java.util.List):void");
    }

    public final void S(int sizePx) {
        ViewGroup.LayoutParams layoutParams = this.binding.hostTtiCardMultiImage.getLayoutParams();
        if (layoutParams != null && layoutParams.height != sizePx) {
            layoutParams.height = sizePx;
            this.binding.hostTtiCardMultiImage.setLayoutParams(layoutParams);
        }
        ViewGroup.LayoutParams layoutParams2 = this.binding.rvTtiCardMultiImage.getLayoutParams();
        if (layoutParams2 == null) {
            return;
        }
        if (layoutParams2.height != sizePx) {
            layoutParams2.height = sizePx;
            this.binding.rvTtiCardMultiImage.setLayoutParams(layoutParams2);
        }
        this.multiImageAdapter.k(sizePx);
    }

    public final void S0() {
        this.showingGeneratingUi = false;
        this.binding.layoutTtiCardSingleImage.setVisibility(0);
        this.binding.layoutTtiCardSingleImage.setAlpha(1.0f);
        this.binding.hostTtiCardMultiImage.setVisibility(8);
        this.binding.layoutTtiCardGeneratingOverlay.setVisibility(8);
        this.binding.shaderTtiCardLoading.u();
        this.binding.ivTtiCardResultImage.setVisibility(8);
        this.binding.ivTtiCardResultImage.setOnClickListener(null);
        ImageView ivTtiCardResultImage = this.binding.ivTtiCardResultImage;
        kotlin.jvm.internal.p.h(ivTtiCardResultImage, "ivTtiCardResultImage");
        w0.f(ivTtiCardResultImage);
        this.binding.layoutTtiCardFailOverlay.setVisibility(8);
        this.binding.layoutTtiCardExpiredOverlay.setVisibility(0);
        this.multiImageAdapter.m(C1173v.m());
        t1();
    }

    public final void T(int percent) {
        if (percent == this.lastAppliedProgressInt) {
            return;
        }
        this.lastAppliedProgressInt = percent;
        this.binding.tvTtiCardGeneratingText.setText(getContext().getString(R$string.taskstore_tti_progress_percent, Integer.valueOf(percent)));
        this.multiImageAdapter.o(percent, this.toolCallProgressPercent);
    }

    public final void T0() {
        this.showingGeneratingUi = false;
        this.binding.layoutTtiCardSingleImage.setVisibility(0);
        this.binding.layoutTtiCardSingleImage.setAlpha(1.0f);
        this.binding.hostTtiCardMultiImage.setVisibility(8);
        this.binding.layoutTtiCardGeneratingOverlay.setVisibility(8);
        this.binding.shaderTtiCardLoading.u();
        this.binding.ivTtiCardResultImage.setVisibility(8);
        this.binding.ivTtiCardResultImage.setOnClickListener(null);
        ImageView ivTtiCardResultImage = this.binding.ivTtiCardResultImage;
        kotlin.jvm.internal.p.h(ivTtiCardResultImage, "ivTtiCardResultImage");
        w0.f(ivTtiCardResultImage);
        this.binding.layoutTtiCardExpiredOverlay.setVisibility(8);
        this.binding.layoutTtiCardFailOverlay.setVisibility(0);
        this.multiImageAdapter.m(C1173v.m());
        t1();
    }

    public final void U() {
        removeCallbacks(this.staleProgressWatchdog);
        if (!this.isRunningProgress || this.generatingStalled) {
            return;
        }
        long jElapsedRealtime = 300000 - (SystemClock.elapsedRealtime() - this.lastProgressAtElapsed);
        if (jElapsedRealtime <= 0) {
            z0();
        } else {
            postDelayed(this.staleProgressWatchdog, jElapsedRealtime);
        }
    }

    public final void U0(int percent, boolean showProgress) {
        this.binding.layoutTtiCardSingleImage.setVisibility(0);
        this.binding.layoutTtiCardSingleImage.setAlpha(1.0f);
        this.binding.hostTtiCardMultiImage.setVisibility(8);
        this.binding.layoutTtiCardGeneratingOverlay.setVisibility(0);
        this.binding.layoutTtiCardFailOverlay.setVisibility(8);
        this.binding.layoutTtiCardExpiredOverlay.setVisibility(8);
        this.binding.tvTtiCardGeneratingText.setVisibility(showProgress ? 0 : 8);
        if (showProgress) {
            this.binding.tvTtiCardGeneratingText.setText(getContext().getString(R$string.taskstore_tti_progress_percent, Integer.valueOf(percent)));
        }
        if (this.generatingStalled) {
            this.binding.shaderTtiCardLoading.k();
        } else {
            this.binding.shaderTtiCardLoading.t();
        }
        this.binding.ivTtiCardResultImage.setVisibility(8);
        this.binding.ivTtiCardResultImage.setOnClickListener(null);
        ImageView ivTtiCardResultImage = this.binding.ivTtiCardResultImage;
        kotlin.jvm.internal.p.h(ivTtiCardResultImage, "ivTtiCardResultImage");
        w0.f(ivTtiCardResultImage);
        this.multiImageAdapter.m(C1173v.m());
    }

    public final void W(String toolCallId, int activeToolCallCount) {
        List result;
        List list;
        TaskInfoCard boundCard;
        TaskInfoStatus status;
        kotlin.jvm.internal.p.i(toolCallId, "toolCallId");
        if (La.H.x0(toolCallId) || !this.pendingToolCallIds.add(toolCallId)) {
            return;
        }
        TaskInfoCard boundCard2 = getBoundCard();
        List<TaskInfoPart> listO0 = boundCard2 != null ? o0(boundCard2) : null;
        if (listO0 == null) {
            listO0 = C1173v.m();
        }
        int iMax = Math.max(activeToolCallCount, this.pendingToolCallIds.size());
        boolean z10 = this.activeGenerationToolCallId != null;
        boolean z11 = (z10 || (boundCard = getBoundCard()) == null || (status = boundCard.getStatus()) == null || !status.isTerminal()) ? false : true;
        this.revisionGenerationInFlight = z11;
        if (!z11) {
            iMax = x0.INSTANCE.a(this.expectedImageCount, listO0.size(), iMax);
        }
        this.expectedImageCount = iMax;
        if (!z10) {
            this.activeGenerationToolCallId = toolCallId;
            this.generationBaseCard = getBoundCard();
            this.generationStartFileIds = n0(listO0);
            c1(false);
            this.toolCallProgressPercent.keySet().retainAll(this.pendingToolCallIds);
        }
        TaskInfoCard boundCard3 = getBoundCard();
        if (boundCard3 == null) {
            String str = this.taskId;
            if (str == null) {
                str = "";
            }
            n1(str);
            return;
        }
        TaskInfoEventType taskInfoEventType = TaskInfoEventType.UPDATED;
        TaskInfoStatus taskInfoStatus = TaskInfoStatus.RUNNING;
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (z11) {
            List<TaskInfoPart> result2 = boundCard3.getResult();
            if (result2 == null) {
                list = null;
                AbstractC3737c.d(this, TaskInfoCard.copy$default(boundCard3, taskInfoEventType, null, null, null, null, null, null, null, null, null, 0, 0, false, taskInfoStatus, null, null, null, null, null, null, null, null, 0L, null, null, jCurrentTimeMillis, list, null, null, null, null, null, null, null, -117448706, 3, null), null, 2, null);
            }
            result = new ArrayList();
            for (Object obj : result2) {
                if (((TaskInfoPart) obj).getType() != TaskInfoPartType.IMAGE) {
                    result.add(obj);
                }
            }
        } else {
            result = boundCard3.getResult();
        }
        list = result;
        AbstractC3737c.d(this, TaskInfoCard.copy$default(boundCard3, taskInfoEventType, null, null, null, null, null, null, null, null, null, 0, 0, false, taskInfoStatus, null, null, null, null, null, null, null, null, 0L, null, null, jCurrentTimeMillis, list, null, null, null, null, null, null, null, -117448706, 3, null), null, 2, null);
    }

    public final void W0(final String url, final String fileId) {
        if (r0(0)) {
            S0();
            return;
        }
        this.binding.layoutTtiCardSingleImage.setVisibility(0);
        this.binding.layoutTtiCardSingleImage.setAlpha(1.0f);
        this.binding.hostTtiCardMultiImage.setVisibility(8);
        final boolean z10 = this.binding.layoutTtiCardGeneratingOverlay.getVisibility() == 0 && this.binding.tvTtiCardGeneratingText.getVisibility() == 0;
        this.binding.layoutTtiCardFailOverlay.setVisibility(8);
        this.binding.layoutTtiCardExpiredOverlay.setVisibility(8);
        this.binding.ivTtiCardResultImage.setVisibility(0);
        ImageView ivTtiCardResultImage = this.binding.ivTtiCardResultImage;
        kotlin.jvm.internal.p.h(ivTtiCardResultImage, "ivTtiCardResultImage");
        HalftoneShaderView shaderTtiCardLoading = this.binding.shaderTtiCardLoading;
        kotlin.jvm.internal.p.h(shaderTtiCardLoading, "shaderTtiCardLoading");
        w0.h(ivTtiCardResultImage, url, shaderTtiCardLoading, fileId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.e0
            @Override // p9.InterfaceC5074l
            public final Object invoke(Object obj) {
                return TextToImageCardView.X0(fileId, this, url, z10, ((Boolean) obj).booleanValue());
            }
        });
        this.multiImageAdapter.m(C1173v.m());
        t1();
        this.binding.ivTtiCardResultImage.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.ailauncher.taskstore.widget.f0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                TextToImageCardView.Z0(this.f29370a, view);
            }
        });
    }

    public final void X(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        if (getBoundCard() == null || com.stepos.ailauncher.taskstore.chat.B.INSTANCE.T(card.getTaskId(), this.versionId, this)) {
            this.standaloneCard = false;
            TaskInfoCard taskInfoCardV0 = v0(com.stepos.ailauncher.taskstore.chat.B.INSTANCE.X(card, this.versionId));
            int size = o0(taskInfoCardV0).size();
            if (taskInfoCardV0.getStatus().isTerminal()) {
                d0(taskInfoCardV0.getTaskId(), size);
            } else {
                f0(size);
            }
            AbstractC3737c.d(this, taskInfoCardV0, null, 2, null);
        }
    }

    public final void Y(List<TaskInfoPart> parts) {
        kotlin.jvm.internal.p.i(parts, "parts");
        if (parts.isEmpty()) {
            return;
        }
        this.standaloneCard = true;
        List<TaskInfoPart> list = parts;
        int i10 = 0;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                if (((TaskInfoPart) it.next()).getType() == TaskInfoPartType.IMAGE && (i10 = i10 + 1) < 0) {
                    C1173v.v();
                }
            }
        }
        f0(i10);
        TaskInfoStatus taskInfoStatus = t0() ? TaskInfoStatus.RUNNING : TaskInfoStatus.COMPLETED;
        String str = this.taskId;
        if (str == null) {
            str = "";
        }
        AbstractC3737c.d(this, p1(str, taskInfoStatus, parts), null, 2, null);
    }

    public final int Z() {
        List<TaskInfoPart> listO0;
        TaskInfoCard boundCard = getBoundCard();
        if (boundCard == null || (listO0 = o0(boundCard)) == null) {
            return 0;
        }
        return listO0.size();
    }

    public final void a0() {
        b0();
        ValueAnimator valueAnimator = this.progressAnimator;
        this.progressAnimator = null;
        this.animatorKind = AnimatorKind.NONE;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
    }

    public final void a1(int position) {
        String fileId;
        TaskInfoCard boundCard = getBoundCard();
        if (boundCard == null) {
            return;
        }
        List<TaskInfoPart> listO0 = o0(boundCard);
        ArrayList arrayList = new ArrayList();
        for (Object obj : listO0) {
            if (!s0((TaskInfoPart) obj)) {
                arrayList.add(obj);
            }
        }
        TaskInfoPart taskInfoPart = (TaskInfoPart) Z8.F.t0(arrayList, position);
        if (taskInfoPart == null || (fileId = taskInfoPart.getFileId()) == null || La.H.x0(fileId)) {
            return;
        }
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        String strB = C3738d.b(context);
        if (strB.length() <= 0) {
            strB = null;
        }
        String str = strB;
        M5.c.b(M5.c.INSTANCE, com.stepos.ailauncher.taskstore.chat.G.c(taskInfoPart, str, boundCard.getTaskId()), str, "chatview", null, M5.c.CARD_TYPE_PREVIEW, 8, null);
    }

    public final void b0() {
        removeCallbacks(this.trickleTick);
        this.tricklePosted = false;
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x009a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b1() {
        /*
            r11 = this;
            com.stepos.ailauncher.taskstore.entity.TaskInfoCard r0 = r11.getBoundCard()
            if (r0 != 0) goto L8
            goto Lc2
        L8:
            android.content.Context r1 = r11.getContext()
            java.lang.String r2 = "getContext(...)"
            kotlin.jvm.internal.p.h(r1, r2)
            java.lang.String r1 = com.stepos.ailauncher.taskstore.widget.C3738d.b(r1)
            int r2 = r1.length()
            r3 = 0
            if (r2 <= 0) goto L1d
            goto L1e
        L1d:
            r1 = r3
        L1e:
            java.util.List r2 = r11.o0(r0)
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r2 = r2.iterator()
        L2d:
            boolean r5 = r2.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r5 = r2.next()
            r6 = r5
            com.stepos.ailauncher.taskstore.entity.TaskInfoPart r6 = (com.stepos.ailauncher.taskstore.entity.TaskInfoPart) r6
            boolean r6 = r11.s0(r6)
            if (r6 != 0) goto L2d
            r4.add(r5)
            goto L2d
        L44:
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            java.util.Iterator r4 = r4.iterator()
        L4d:
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L64
            java.lang.Object r5 = r4.next()
            r6 = r5
            com.stepos.ailauncher.taskstore.entity.TaskInfoPart r6 = (com.stepos.ailauncher.taskstore.entity.TaskInfoPart) r6
            boolean r6 = r11.p0(r6)
            if (r6 != 0) goto L4d
            r2.add(r5)
            goto L4d
        L64:
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            java.util.Iterator r2 = r2.iterator()
            r5 = 0
        L6e:
            boolean r6 = r2.hasNext()
            if (r6 == 0) goto Lab
            java.lang.Object r6 = r2.next()
            int r7 = r5 + 1
            if (r5 >= 0) goto L7f
            Z8.C1173v.w()
        L7f:
            com.stepos.ailauncher.taskstore.entity.TaskInfoPart r6 = (com.stepos.ailauncher.taskstore.entity.TaskInfoPart) r6
            java.lang.String r8 = r6.getFileId()
            if (r8 == 0) goto L9a
            boolean r9 = La.H.x0(r8)
            if (r9 != 0) goto L8e
            goto L8f
        L8e:
            r8 = r3
        L8f:
            if (r8 != 0) goto L92
            goto L9a
        L92:
            java.util.HashSet<java.lang.String> r9 = r11.exposedFileIds
            boolean r8 = r9.add(r8)
            if (r8 != 0) goto L9c
        L9a:
            r5 = r3
            goto La4
        L9c:
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            kotlin.Pair r5 = Y8.j.a(r5, r6)
        La4:
            if (r5 == 0) goto La9
            r4.add(r5)
        La9:
            r5 = r7
            goto L6e
        Lab:
            boolean r2 = r4.isEmpty()
            if (r2 == 0) goto Lb2
            goto Lc2
        Lb2:
            Ua.M r5 = r11.ioScope
            if (r5 == 0) goto Lc2
            com.stepos.ailauncher.taskstore.widget.TextToImageCardView$reportChatCardExpose$1 r8 = new com.stepos.ailauncher.taskstore.widget.TextToImageCardView$reportChatCardExpose$1
            r8.<init>(r4, r0, r1, r3)
            r9 = 3
            r10 = 0
            r6 = 0
            r7 = 0
            Ua.C1056g.d(r5, r6, r7, r8, r9, r10)
        Lc2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TextToImageCardView.b1():void");
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public void c(TaskInfoCard card, InterfaceC3745k listener) throws Exception {
        List<TaskInfoPart> list;
        boolean z10;
        String str;
        ArrayList arrayList;
        TaskInfoCard taskInfoCardCopy$default;
        String fileId;
        TaskInfoStatus status;
        kotlin.jvm.internal.p.i(card, "card");
        TaskInfoCard boundCard = getBoundCard();
        List<TaskInfoPart> listO0 = o0(card);
        com.stepos.ailauncher.taskstore.chat.B b10 = com.stepos.ailauncher.taskstore.chat.B.INSTANCE;
        boolean zT = b10.T(card.getTaskId(), this.versionId, this);
        if (zT || boundCard == null) {
            if (zT && !t0() && q0(card.getStatus()) && listO0.isEmpty() && boundCard != null && (status = boundCard.getStatus()) != null && status.isTerminal() && o0(boundCard).size() == 1) {
                this.revisionGenerationInFlight = true;
                this.generationBaseCard = boundCard;
                this.generationStartFileIds = n0(o0(boundCard));
                return;
            }
            b10.e0(card);
            TaskInfoCard boundCard2 = getBoundCard();
            String taskId = boundCard2 != null ? boundCard2.getTaskId() : null;
            boolean z11 = (taskId == null || kotlin.jvm.internal.p.d(taskId, card.getTaskId())) ? false : true;
            super.c(card, listener);
            if (z11) {
                this.revisionGenerationInFlight = false;
                this.expectedImageCount = 0;
                this.pendingToolCallIds.clear();
                this.activeGenerationToolCallId = null;
                this.generationStartFileIds = Z8.Y.e();
                this.generationBaseCard = null;
                d1(this, false, 1, null);
                this.signedUrls.clear();
                this.resolvingFileIds.clear();
                this.failedImageFileIds.clear();
                this.expiredFileIds.clear();
                this.blockedFileIds.clear();
                this.exposedFileIds.clear();
                this.lastAvailabilityQueryKey = null;
                this.lastVisualSignature = null;
            }
            setIcon(R$drawable.ic_taskstore_tasktype_image);
            setVisibility(0);
            this.binding.layoutTtiCardHeader.setVisibility(8);
            this.binding.tvTtiCardToolcallName.setVisibility(8);
            this.binding.tvTtiCardToolcallName.setText("");
            this.binding.layoutTtiCardVisual.setVisibility(0);
            this.binding.layoutTtiCardFailOverlay.setVisibility(8);
            if (this.revisionGenerationInFlight && t0()) {
                ArrayList arrayList2 = new ArrayList();
                for (Object obj : listO0) {
                    String fileId2 = ((TaskInfoPart) obj).getFileId();
                    if (fileId2 != null) {
                        if (La.H.x0(fileId2)) {
                            fileId2 = null;
                        }
                        if (fileId2 == null || !this.generationStartFileIds.contains(fileId2)) {
                        }
                    }
                    arrayList2.add(obj);
                }
                list = arrayList2;
            } else {
                list = listO0;
            }
            List<TaskInfoPart> list2 = list;
            ArrayList arrayList3 = new ArrayList();
            for (Object obj2 : list2) {
                if (!p0((TaskInfoPart) obj2)) {
                    arrayList3.add(obj2);
                }
            }
            if (t0() && (!(list2 instanceof Collection) || !list2.isEmpty())) {
                Iterator<T> it = list2.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    String fileId3 = ((TaskInfoPart) it.next()).getFileId();
                    if (fileId3 != null) {
                        if (La.H.x0(fileId3)) {
                            fileId3 = null;
                        }
                        if (fileId3 != null && (!this.generationStartFileIds.contains(fileId3))) {
                            this.generationBaseCard = card;
                            break;
                        }
                    }
                }
            }
            if (t0()) {
                I0(this, 0, 1, null);
            }
            if (this.revisionGenerationInFlight && card.getStatus().isTerminal()) {
                z10 = z11;
                str = null;
                arrayList = arrayList3;
                taskInfoCardCopy$default = TaskInfoCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, 0, 0, false, TaskInfoStatus.RUNNING, null, null, null, null, null, null, null, null, 0L, null, null, 0L, null, null, null, null, null, null, null, null, -16785409, 3, null);
            } else {
                z10 = z11;
                str = null;
                arrayList = arrayList3;
                taskInfoCardCopy$default = card;
            }
            if (TaskInfoCardKt.shouldHideImageCard(taskInfoCardCopy$default)) {
                this.pendingToolCallIds.clear();
                this.activeGenerationToolCallId = str;
                this.revisionGenerationInFlight = false;
                this.currentImageUrls = C1173v.m();
                this.currentImageFileIds = C1173v.m();
                setVisibility(8);
                this.exposureTimer.b(str);
                return;
            }
            String taskId2 = card.getTaskId();
            TaskInfoStatus status2 = card.getStatus();
            TaskInfoStatus status3 = taskInfoCardCopy$default.getStatus();
            List<TaskInfoPart> result = card.getResult();
            int size = result != null ? result.size() : 0;
            Log.i(TAG, "bindData taskId=" + taskId2 + " status=" + status2 + " display=" + status3 + " resultSize=" + size + " imageSize=" + list.size() + " expected=" + this.expectedImageCount + " pending=" + this.pendingToolCallIds.size());
            this.isBinding = true;
            ArrayList<TaskInfoPart> arrayList4 = arrayList;
            try {
                e1(arrayList4);
                this.isBinding = false;
                if (taskInfoCardCopy$default.getStatus() == TaskInfoStatus.COMPLETED && !list.isEmpty() && arrayList4.isEmpty()) {
                    this.currentImageUrls = C1173v.m();
                    this.currentImageFileIds = C1173v.m();
                    setVisibility(8);
                    this.exposureTimer.b(str);
                    return;
                }
                ArrayList arrayList5 = new ArrayList();
                for (TaskInfoPart taskInfoPart : arrayList4) {
                    String strI0 = s0(taskInfoPart) ? str : i0(taskInfoPart);
                    if (strI0 != null) {
                        arrayList5.add(strI0);
                    }
                }
                this.currentImageUrls = arrayList5;
                ArrayList arrayList6 = new ArrayList();
                for (TaskInfoPart taskInfoPart2 : arrayList4) {
                    if (s0(taskInfoPart2) || (fileId = taskInfoPart2.getFileId()) == null || La.H.x0(fileId)) {
                        fileId = str;
                    }
                    if (fileId != null) {
                        arrayList6.add(fileId);
                    }
                }
                this.currentImageFileIds = arrayList6;
                List<TaskInfoPart> list3 = list;
                TtiCardVisualSignature y0VarA = TtiCardVisualSignature.INSTANCE.a(taskInfoCardCopy$default, list3, this.signedUrls, this.pendingToolCallIds, this.expectedImageCount, t0(), this.generatingStalled, this.standaloneCard);
                if (kotlin.jvm.internal.p.d(y0VarA, this.lastVisualSignature) && !z10) {
                    M6.c.INSTANCE.i();
                    this.exposureTimer.b(card.getTaskId());
                    F0(card, list3);
                    return;
                }
                this.lastVisualSignature = y0VarA;
                M6.c.INSTANCE.h(card.getTaskId(), taskInfoCardCopy$default.getStatus().name());
                if (taskInfoCardCopy$default.getStatus() == TaskInfoStatus.COMPLETED) {
                    K0(taskInfoCardCopy$default, arrayList4);
                } else if (taskInfoCardCopy$default.getStatus().isTerminal()) {
                    this.finishing = false;
                    L0(taskInfoCardCopy$default, arrayList4);
                } else {
                    this.finishing = false;
                    R0(taskInfoCardCopy$default, arrayList4);
                }
                this.exposureTimer.b(card.getTaskId());
                F0(card, list3);
                x1();
            } catch (Throwable th) {
                this.isBinding = false;
                throw th;
            }
        }
    }

    public final void c0(int target, Long durationMs) {
        int iN = C5685n.n(target, 0, 100);
        if (iN <= C5227b.b(this.displayedProgressPercent)) {
            s1();
            return;
        }
        if (this.animatorKind == AnimatorKind.FINISH) {
            return;
        }
        a0();
        this.displayedProgressPercent = iN;
        T(iN);
        if (this.isRunningProgress) {
            s1();
        }
    }

    public final void c1(boolean clearToolCallProgress) {
        a0();
        removeCallbacks(this.staleProgressWatchdog);
        this.finishing = false;
        this.pendingFinishParts = C1173v.m();
        this.isRunningProgress = false;
        this.generatingStalled = false;
        this.lastProgressAtElapsed = 0L;
        this.displayedProgressPercent = 0.0f;
        this.lastAppliedProgressInt = Integer.MIN_VALUE;
        this.imageProgressPercent = null;
        if (clearToolCallProgress) {
            this.toolCallProgressPercent.clear();
        }
    }

    public final void d0(String taskId, int imageCount) {
        com.stepos.ailauncher.taskstore.chat.B.D(com.stepos.ailauncher.taskstore.chat.B.INSTANCE, taskId, null, false, this.versionId, 2, null);
        this.expectedImageCount = imageCount;
    }

    public final void e0(boolean restorePreviousCard) {
        if (t0()) {
            TaskInfoCard taskInfoCard = this.generationBaseCard;
            this.revisionGenerationInFlight = false;
            this.activeGenerationToolCallId = null;
            this.generationStartFileIds = Z8.Y.e();
            this.generationBaseCard = null;
            this.pendingToolCallIds.clear();
            this.toolCallProgressPercent.clear();
            if (!restorePreviousCard || taskInfoCard == null) {
                return;
            }
            AbstractC3737c.d(this, taskInfoCard, null, 2, null);
        }
    }

    public final void e1(List<TaskInfoPart> imageParts) {
        final String fileId;
        for (TaskInfoPart taskInfoPart : imageParts) {
            if (!s0(taskInfoPart) && (fileId = taskInfoPart.getFileId()) != null) {
                if (La.H.x0(fileId)) {
                    fileId = null;
                }
                if (fileId != null && !this.failedImageFileIds.contains(fileId) && !this.signedUrls.containsKey(fileId) && this.resolvingFileIds.add(fileId)) {
                    com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.m(fileId, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.b0
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return TextToImageCardView.f1(this.f29358a, fileId, (String) obj);
                        }
                    }, new InterfaceC5074l() { // from class: com.stepos.ailauncher.taskstore.widget.c0
                        @Override // p9.InterfaceC5074l
                        public final Object invoke(Object obj) {
                            return TextToImageCardView.g1(this.f29360a, fileId, (Throwable) obj);
                        }
                    });
                }
            }
        }
    }

    public final void f0(int imageCount) {
        if (!t0() || imageCount <= 0) {
            return;
        }
        H0(imageCount);
        if (x0.INSTANCE.c(imageCount, this.pendingToolCallIds.size(), this.expectedImageCount)) {
            String str = this.taskId;
            if (str == null) {
                str = "";
            }
            String str2 = str;
            if (La.H.x0(str2)) {
                e0(false);
            } else {
                com.stepos.ailauncher.taskstore.chat.B.D(com.stepos.ailauncher.taskstore.chat.B.INSTANCE, str2, null, false, this.versionId, 2, null);
            }
        }
    }

    public final void g0() {
        String taskId;
        TaskInfoCard boundCard = getBoundCard();
        if ((boundCard == null || (taskId = boundCard.getTaskId()) == null) && (taskId = this.taskId) == null) {
            return;
        }
        com.stepos.ailauncher.taskstore.livenotification.A a10 = com.stepos.ailauncher.taskstore.livenotification.A.INSTANCE;
        Context context = getContext();
        kotlin.jvm.internal.p.h(context, "getContext(...)");
        a10.a(context, taskId);
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public ImageView getIconView() {
        ImageView ivTtiCardIcon = this.binding.ivTtiCardIcon;
        kotlin.jvm.internal.p.h(ivTtiCardIcon, "ivTtiCardIcon");
        return ivTtiCardIcon;
    }

    public final Integer getImageProgressPercent() {
        return this.imageProgressPercent;
    }

    public final String getTaskId() {
        return this.taskId;
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public TextView getTitleView() {
        TextView tvTtiCardTitle = this.binding.tvTtiCardTitle;
        kotlin.jvm.internal.p.h(tvTtiCardTitle, "tvTtiCardTitle");
        return tvTtiCardTitle;
    }

    public final int h1(TaskInfoProgress progress) {
        int total;
        Integer num = this.imageProgressPercent;
        if (num != null) {
            return C5685n.n(num.intValue(), 0, 99);
        }
        if (progress == null || (total = progress.getTotal()) <= 0) {
            return 0;
        }
        return C5685n.n((progress.getCompleted() * 100) / total, 0, 99);
    }

    public final String i0(TaskInfoPart taskInfoPart) {
        String fileId = taskInfoPart.getFileId();
        if (fileId != null) {
            if (La.H.x0(fileId)) {
                fileId = null;
            }
            if (fileId != null) {
                return this.signedUrls.get(fileId);
            }
        }
        String content = taskInfoPart.getContent();
        if (La.H.x0(content)) {
            return null;
        }
        return content;
    }

    public final void i1() {
        if (com.stepos.agentframework.display.j.INSTANCE.p(this)) {
            if (this.tricklePosted) {
                removeCallbacks(this.trickleTick);
                this.tricklePosted = false;
                return;
            }
            return;
        }
        if (this.tricklePosted) {
            return;
        }
        this.tricklePosted = true;
        postDelayed(this.trickleTick, 500L);
    }

    public final void j1(int percent, Long durationMs, String toolCallId) {
        int iN = C5685n.n(percent, 0, 99);
        this.isRunningProgress = true;
        this.lastProgressAtElapsed = SystemClock.elapsedRealtime();
        if (this.generatingStalled) {
            this.generatingStalled = false;
            this.multiImageAdapter.e(false);
            if (this.binding.layoutTtiCardSingleImage.getVisibility() == 0) {
                this.binding.shaderTtiCardLoading.t();
            }
        }
        U();
        if (toolCallId == null || La.H.x0(toolCallId)) {
            toolCallId = null;
        }
        if (toolCallId == null) {
            Integer num = this.imageProgressPercent;
            this.imageProgressPercent = Integer.valueOf(Math.max(num != null ? num.intValue() : 0, iN));
            c0(iN, durationMs);
            return;
        }
        LinkedHashMap<String, Integer> linkedHashMap = this.toolCallProgressPercent;
        Integer num2 = linkedHashMap.get(toolCallId);
        linkedHashMap.put(toolCallId, Integer.valueOf(Math.max(num2 != null ? num2.intValue() : 0, iN)));
        Integer num3 = this.toolCallProgressPercent.get(toolCallId);
        int iIntValue = num3 != null ? num3.intValue() : iN;
        this.multiImageAdapter.p(toolCallId, iIntValue);
        if (this.pendingToolCallIds.size() <= 1) {
            Integer num4 = this.imageProgressPercent;
            this.imageProgressPercent = Integer.valueOf(Math.max(num4 != null ? num4.intValue() : 0, iN));
            c0(iN, durationMs);
        } else if (this.binding.layoutTtiCardSingleImage.getVisibility() == 0 && this.binding.layoutTtiCardGeneratingOverlay.getVisibility() == 0) {
            this.binding.tvTtiCardGeneratingText.setText(getContext().getString(R$string.taskstore_tti_progress_percent, Integer.valueOf(iIntValue)));
        }
    }

    public final void k0(List<TaskInfoPart> imageParts) {
        if (this.finishing) {
            this.pendingFinishParts = imageParts;
            return;
        }
        float f10 = this.displayedProgressPercent;
        if (!this.showingGeneratingUi || C5227b.b(f10) >= 99) {
            if (this.showingGeneratingUi) {
                T(99);
            }
            u1();
            N0(this, imageParts, false, 2, null);
            return;
        }
        this.finishing = true;
        this.pendingFinishParts = imageParts;
        this.isRunningProgress = false;
        this.generatingStalled = false;
        removeCallbacks(this.staleProgressWatchdog);
        a0();
        long jO = C5685n.o((long) (((99.0f - f10) / 99) * 8000), FINISH_MIN_DURATION_MS, FINISH_MAX_DURATION_MS);
        this.animatorKind = AnimatorKind.FINISH;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(f10, 99.0f);
        valueAnimatorOfFloat.setDuration(jO);
        valueAnimatorOfFloat.setInterpolator(this.catchUpInterpolator);
        valueAnimatorOfFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.stepos.ailauncher.taskstore.widget.g0
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                TextToImageCardView.l0(this.f29372a, valueAnimator);
            }
        });
        valueAnimatorOfFloat.addListener(new g());
        valueAnimatorOfFloat.start();
        this.progressAnimator = valueAnimatorOfFloat;
    }

    public final boolean m0() {
        RecyclerView rvTtiCardMultiImage = this.binding.rvTtiCardMultiImage;
        kotlin.jvm.internal.p.h(rvTtiCardMultiImage, "rvTtiCardMultiImage");
        int childCount = rvTtiCardMultiImage.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView.ViewHolder childViewHolder = rvTtiCardMultiImage.getChildViewHolder(rvTtiCardMultiImage.getChildAt(i10));
            c.b bVar = childViewHolder instanceof c.b ? (c.b) childViewHolder : null;
            if (bVar != null && bVar.getLoadingShader().getAnimating()) {
                return true;
            }
        }
        return false;
    }

    public final Set<String> n0(List<TaskInfoPart> parts) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = parts.iterator();
        while (it.hasNext()) {
            String fileId = ((TaskInfoPart) it.next()).getFileId();
            if (fileId == null || La.H.x0(fileId)) {
                fileId = null;
            }
            if (fileId != null) {
                arrayList.add(fileId);
            }
        }
        return Z8.F.r1(arrayList);
    }

    public final void n1(String taskId) {
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.taskId = taskId;
        this.standaloneCard = true;
        AbstractC3737c.d(this, p1(taskId, TaskInfoStatus.RUNNING, C1173v.m()), null, 2, null);
    }

    public final List<TaskInfoPart> o0(TaskInfoCard card) {
        ArrayList arrayList;
        List<TaskInfoPart> result = card.getResult();
        if (result != null) {
            arrayList = new ArrayList();
            for (Object obj : result) {
                if (((TaskInfoPart) obj).getType() == TaskInfoPartType.IMAGE) {
                    arrayList.add(obj);
                }
            }
        } else {
            arrayList = null;
        }
        return arrayList == null ? C1173v.m() : arrayList;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() throws Exception {
        super.onAttachedToWindow();
        this.waitPowerReady = true;
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.a(this.availabilityChangedListener);
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null && layoutParams.width != -1) {
            layoutParams.width = -1;
            setLayoutParams(layoutParams);
        }
        TaskInfoCard boundCard = getBoundCard();
        if (boundCard != null) {
            if (boundCard.getStatus().isTerminal() && !t0()) {
                AbstractC3737c.d(this, boundCard, null, 2, null);
            } else if (t0()) {
                I0(this, 0, 1, null);
                AbstractC3737c.d(this, TaskInfoCard.copy$default(boundCard, TaskInfoEventType.UPDATED, null, null, null, null, null, null, null, null, null, 0, 0, false, TaskInfoStatus.RUNNING, null, null, null, null, null, null, null, null, 0L, null, null, 0L, null, null, null, null, null, null, null, null, -16785410, 3, null), null, 2, null);
            }
        }
        if (this.isRunningProgress) {
            s1();
            U();
        }
        if (this.ioScope == null) {
            Ua.M mB = kotlinx.coroutines.d.b();
            this.ioScope = mB;
            q1(mB);
        }
        this.exposureTimer.e(isShown());
        x1();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() throws Exception {
        com.stepos.ailauncher.taskstore.artifact.a.INSTANCE.l(this.availabilityChangedListener);
        a0();
        this.finishing = false;
        this.pendingFinishParts = C1173v.m();
        removeCallbacks(this.staleProgressWatchdog);
        Ua.M m10 = this.ioScope;
        if (m10 != null) {
            kotlinx.coroutines.d.e(m10, null, 1, null);
        }
        this.ioScope = null;
        this.exposureTimer.g();
        this.exposedFileIds.clear();
        this.lastVisualSignature = null;
        this.waitPowerReady = false;
        x1();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onVisibilityAggregated(boolean isVisible) throws Exception {
        super.onVisibilityAggregated(isVisible);
        this.exposureTimer.e(isVisible);
        x1();
    }

    public final boolean p0(TaskInfoPart taskInfoPart) {
        String fileId = taskInfoPart.getFileId();
        if (fileId != null) {
            if (La.H.x0(fileId)) {
                fileId = null;
            }
            if (fileId != null && this.blockedFileIds.contains(fileId)) {
                return true;
            }
        }
        return false;
    }

    public final TaskInfoCard p1(String taskId, TaskInfoStatus status, List<TaskInfoPart> result) {
        long jCurrentTimeMillis = System.currentTimeMillis();
        TaskInfoEventType taskInfoEventType = status.isTerminal() ? TaskInfoEventType.COMPLETED : TaskInfoEventType.UPDATED;
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        Long lValueOf2 = Long.valueOf(jCurrentTimeMillis);
        if (!status.isTerminal()) {
            lValueOf2 = null;
        }
        return new TaskInfoCard(taskInfoEventType, null, null, null, taskId, null, null, "image", null, null, 0, 0, false, status, null, null, null, null, null, null, null, null, jCurrentTimeMillis, lValueOf, lValueOf2, jCurrentTimeMillis, result, null, null, null, null, null, null, null, -130572434, 3, null);
    }

    public final boolean r0(int index) {
        String str = (String) Z8.F.t0(this.currentImageFileIds, index);
        if (str == null) {
            return false;
        }
        return this.expiredFileIds.contains(str);
    }

    public final void r1(int realPercent) {
        this.isRunningProgress = true;
        if (this.lastProgressAtElapsed == 0) {
            this.lastProgressAtElapsed = SystemClock.elapsedRealtime();
        }
        U();
        if (realPercent > C5227b.b(this.displayedProgressPercent)) {
            c0(realPercent, null);
        } else {
            s1();
        }
    }

    public final boolean s0(TaskInfoPart taskInfoPart) {
        String errorDetail;
        String fileId = taskInfoPart.getFileId();
        if ((fileId != null && this.failedImageFileIds.contains(fileId)) || La.D.L(taskInfoPart.getStatus(), "failed", true)) {
            return true;
        }
        String errorReason = taskInfoPart.getErrorReason();
        return ((errorReason == null || La.H.x0(errorReason)) && ((errorDetail = taskInfoPart.getErrorDetail()) == null || La.H.x0(errorDetail))) ? false : true;
    }

    public final void s1() {
        AnimatorKind animatorKind;
        if (!this.isRunningProgress || this.generatingStalled || (animatorKind = this.animatorKind) == AnimatorKind.FINISH) {
            return;
        }
        AnimatorKind animatorKind2 = AnimatorKind.TRICKLE;
        if (animatorKind == animatorKind2 && this.tricklePosted) {
            return;
        }
        if (99 - this.displayedProgressPercent >= 0.3f) {
            this.animatorKind = animatorKind2;
            i1();
        } else {
            b0();
            if (this.animatorKind == animatorKind2) {
                this.animatorKind = AnimatorKind.NONE;
            }
        }
    }

    @Override // com.stepos.agentframework.chatui.appui.d
    public void setContentStartInset(int insetPx) {
        int iF = C5685n.f(insetPx, 0);
        if (this.contentInsetStartPx == iF) {
            return;
        }
        this.contentInsetStartPx = iF;
        NestedScrollableHost layoutTtiCardSingleImage = this.binding.layoutTtiCardSingleImage;
        kotlin.jvm.internal.p.h(layoutTtiCardSingleImage, "layoutTtiCardSingleImage");
        ViewGroup.LayoutParams layoutParams = layoutTtiCardSingleImage.getLayoutParams();
        if (layoutParams == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar = (ConstraintLayout.b) layoutParams;
        bVar.setMarginStart(iF);
        layoutTtiCardSingleImage.setLayoutParams(bVar);
        NestedScrollableHost hostTtiCardMultiImage = this.binding.hostTtiCardMultiImage;
        kotlin.jvm.internal.p.h(hostTtiCardMultiImage, "hostTtiCardMultiImage");
        ViewGroup.LayoutParams layoutParams2 = hostTtiCardMultiImage.getLayoutParams();
        if (layoutParams2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
        }
        ConstraintLayout.b bVar2 = (ConstraintLayout.b) layoutParams2;
        bVar2.setMarginStart(iF);
        hostTtiCardMultiImage.setLayoutParams(bVar2);
    }

    public final void setImageProgress(int i10) {
        k1(this, i10, null, null, 6, null);
    }

    public final void setImageProgressPercent(Integer num) {
        this.imageProgressPercent = num;
    }

    public final boolean t0() {
        return (this.pendingToolCallIds.isEmpty() && this.activeGenerationToolCallId == null) ? false : true;
    }

    public final void t1() {
        RecyclerView rvTtiCardMultiImage = this.binding.rvTtiCardMultiImage;
        kotlin.jvm.internal.p.h(rvTtiCardMultiImage, "rvTtiCardMultiImage");
        int childCount = rvTtiCardMultiImage.getChildCount();
        for (int i10 = 0; i10 < childCount; i10++) {
            RecyclerView.ViewHolder childViewHolder = rvTtiCardMultiImage.getChildViewHolder(rvTtiCardMultiImage.getChildAt(i10));
            c.b bVar = childViewHolder instanceof c.b ? (c.b) childViewHolder : null;
            if (bVar != null) {
                bVar.n();
            }
        }
    }

    public final boolean u0() {
        TaskInfoProgress progress;
        TaskInfoCard boundCard = getBoundCard();
        return this.expectedImageCount > 1 || !(boundCard == null || (progress = boundCard.getProgress()) == null || progress.getTotal() <= 1) || (boundCard != null && o0(boundCard).size() > 1);
    }

    public final void u1() {
        this.isRunningProgress = false;
        this.generatingStalled = false;
        this.lastProgressAtElapsed = 0L;
        removeCallbacks(this.staleProgressWatchdog);
        a0();
    }

    public final TaskInfoCard v0(TaskInfoCard card) {
        if (o0(card).isEmpty()) {
            TaskInfoCard boundCard = getBoundCard();
            List<TaskInfoPart> listM = null;
            if (boundCard != null) {
                if (!kotlin.jvm.internal.p.d(boundCard.getTaskId(), card.getTaskId())) {
                    boundCard = null;
                }
                if (boundCard != null) {
                    listM = o0(boundCard);
                }
            }
            if (listM == null) {
                listM = C1173v.m();
            }
            if (!listM.isEmpty()) {
                return TaskInfoCard.copy$default(card, null, null, null, null, null, null, null, null, null, null, 0, 0, false, null, null, null, null, null, null, null, null, null, 0L, null, null, 0L, TaskArtifactPartMerger.INSTANCE.f(card.getResult(), listM), null, null, null, null, null, null, null, -67108865, 3, null);
            }
        }
        return card;
    }

    public final void v1(List<String> toolCallIds, TaskInfoCard restoredBaseCard) {
        TaskInfoCard boundCard;
        TaskInfoStatus status;
        kotlin.jvm.internal.p.i(toolCallIds, "toolCallIds");
        ArrayList arrayList = new ArrayList();
        for (Object obj : toolCallIds) {
            if (!La.H.x0((String) obj)) {
                arrayList.add(obj);
            }
        }
        if (arrayList.isEmpty()) {
            return;
        }
        this.pendingToolCallIds.clear();
        this.pendingToolCallIds.addAll(arrayList);
        if (this.activeGenerationToolCallId == null) {
            this.activeGenerationToolCallId = (String) Z8.F.q0(arrayList);
            if (restoredBaseCard == null) {
                boundCard = this.generationBaseCard;
                if (boundCard == null) {
                    boundCard = getBoundCard();
                }
            } else {
                boundCard = restoredBaseCard;
            }
            this.generationBaseCard = boundCard;
            List<TaskInfoPart> listO0 = boundCard != null ? o0(boundCard) : null;
            if (listO0 == null) {
                listO0 = C1173v.m();
            }
            this.generationStartFileIds = n0(listO0);
            TaskInfoCard taskInfoCard = this.generationBaseCard;
            this.revisionGenerationInFlight = (taskInfoCard == null || (status = taskInfoCard.getStatus()) == null || !status.isTerminal() || listO0.isEmpty()) ? false : true;
        }
        I0(this, 0, 1, null);
        TaskInfoCard boundCard2 = getBoundCard();
        if (boundCard2 != null) {
            AbstractC3737c.d(this, TaskInfoCard.copy$default(boundCard2, TaskInfoEventType.UPDATED, null, null, null, null, null, null, null, null, null, 0, 0, false, TaskInfoStatus.RUNNING, null, null, null, null, null, null, null, null, 0L, null, null, System.currentTimeMillis(), null, null, null, null, null, null, null, null, -50339842, 3, null), null, 2, null);
            return;
        }
        String str = this.taskId;
        if (str == null) {
            str = "";
        }
        n1(str);
    }

    public final void x1() throws Exception {
        if (!this.waitPowerReady) {
            AutoCloseable autoCloseable = this.waitPowerLease;
            if (autoCloseable != null) {
                C5423E.a(autoCloseable);
            }
            this.waitPowerLease = null;
            return;
        }
        boolean z10 = true;
        boolean z11 = this.binding.shaderTtiCardLoading.getAnimating() || m0();
        boolean z12 = (this.showingGeneratingUi || z11) && isAttachedToWindow() && isShown();
        if (!z12 || (!this.showingGeneratingUi && !this.generationUiSeen)) {
            z10 = false;
        }
        this.binding.tvTtiCardSubtitle.setExternalClockDriven(z10);
        if (!z10) {
            AutoCloseable autoCloseable2 = this.waitClockToken;
            if (autoCloseable2 != null) {
                C5423E.a(autoCloseable2);
            }
            this.waitClockToken = null;
            this.lastTrickleAtMs = 0L;
        } else if (this.waitClockToken == null) {
            this.lastTrickleAtMs = 0L;
            this.waitClockToken = com.stepos.agentframework.display.k.INSTANCE.e(new k());
        }
        if (!z10) {
            if (this.waitPowerLease != null) {
                M6.c cVar = M6.c.INSTANCE;
                TaskInfoCard boundCard = getBoundCard();
                cVar.g("ttiLease off taskId=" + (boundCard != null ? boundCard.getTaskId() : null));
            }
            AutoCloseable autoCloseable3 = this.waitPowerLease;
            if (autoCloseable3 != null) {
                C5423E.a(autoCloseable3);
            }
            this.waitPowerLease = null;
        } else if (this.waitPowerLease == null) {
            this.waitPowerLease = com.stepos.agentframework.display.j.INSTANCE.h(this);
            M6.c cVar2 = M6.c.INSTANCE;
            TaskInfoCard boundCard2 = getBoundCard();
            String taskId = boundCard2 != null ? boundCard2.getTaskId() : null;
            cVar2.g("ttiLease on taskId=" + taskId + " generating=" + this.showingGeneratingUi + " shader=" + z11);
        }
        if (z12) {
            return;
        }
        t1();
    }

    public final void y0(String fileId, String url) {
        TaskInfoCard boundCard;
        this.resolvingFileIds.remove(fileId);
        this.failedImageFileIds.remove(fileId);
        if (kotlin.jvm.internal.p.d(this.signedUrls.get(fileId), url)) {
            return;
        }
        this.signedUrls.put(fileId, url);
        if (this.isBinding || (boundCard = getBoundCard()) == null) {
            return;
        }
        AbstractC3737c.d(this, boundCard, null, 2, null);
    }

    public final void z0() {
        if (!this.isRunningProgress || this.generatingStalled) {
            return;
        }
        Log.i(TAG, "no progress frame for 300000ms, freeze generating visual");
        this.generatingStalled = true;
        a0();
        this.binding.shaderTtiCardLoading.k();
        this.multiImageAdapter.e(true);
    }

    @Override // com.stepos.ailauncher.taskstore.widget.AbstractC3737c
    public SweepTextView getSubtitleView() {
        SweepTextView tvTtiCardSubtitle = this.binding.tvTtiCardSubtitle;
        kotlin.jvm.internal.p.h(tvTtiCardSubtitle, "tvTtiCardSubtitle");
        return tvTtiCardSubtitle;
    }

    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b \b\u0082\b\u0018\u00002\u00020\u0001B_\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006\u0012\b\b\u0002\u0010\n\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0002\u0012\b\b\u0002\u0010\f\u001a\u00020\u0006\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002¢\u0006\u0004\b\u000e\u0010\u000fJp\u0010\u0010\u001a\u00020\u00002\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u00062\b\b\u0002\u0010\t\u001a\u00020\u00062\b\b\u0002\u0010\n\u001a\u00020\u00062\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\f\u001a\u00020\u00062\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0002HÆ\u0001¢\u0006\u0004\b\u0010\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0014\u0010\u0015J\u001a\u0010\u0017\u001a\u00020\u00062\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003¢\u0006\u0004\b\u0017\u0010\u0018R\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0019\u001a\u0004\b\u001a\u0010\u0013R\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u001b\u001a\u0004\b\u001c\u0010\u0015R\u0017\u0010\u0007\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0017\u0010\b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\b\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\t\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\t\u0010\u001d\u001a\u0004\b!\u0010\u001fR\u0017\u0010\n\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\n\u0010\u001d\u001a\u0004\b\"\u0010\u001fR\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000b\u0010\u0019\u001a\u0004\b#\u0010\u0013R\u0017\u0010\f\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\f\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u0019\u0010\r\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\r\u0010\u0019\u001a\u0004\b%\u0010\u0013¨\u0006&"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$d;", "", "", "url", "", "progressPercent", "", "isLoading", "isFailed", "showProgress", "isStalled", "fileId", "isExpired", "toolCallId", "<init>", "(Ljava/lang/String;IZZZZLjava/lang/String;ZLjava/lang/String;)V", Const.INTENT_KEY_APIKEY, "(Ljava/lang/String;IZZZZLjava/lang/String;ZLjava/lang/String;)Lcom/stepos/ailauncher/taskstore/widget/TextToImageCardView$d;", "toString", "()Ljava/lang/String;", "hashCode", "()I", "other", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_BACKGROUND_COMMAND, "I", Const.INTENT_KEY_UMID, "Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "e", "k", "c", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "f", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    /* renamed from: com.stepos.ailauncher.taskstore.widget.TextToImageCardView$d, reason: from toString */
    public static final /* data */ class TtiImageItem {
        private final String fileId;
        private final boolean isExpired;
        private final boolean isFailed;
        private final boolean isLoading;
        private final boolean isStalled;
        private final int progressPercent;
        private final boolean showProgress;
        private final String toolCallId;
        private final String url;

        public TtiImageItem(String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13, String str2, boolean z14, String str3) {
            this.url = str;
            this.progressPercent = i10;
            this.isLoading = z10;
            this.isFailed = z11;
            this.showProgress = z12;
            this.isStalled = z13;
            this.fileId = str2;
            this.isExpired = z14;
            this.toolCallId = str3;
        }

        public static /* synthetic */ TtiImageItem b(TtiImageItem ttiImageItem, String str, int i10, boolean z10, boolean z11, boolean z12, boolean z13, String str2, boolean z14, String str3, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = ttiImageItem.url;
            }
            if ((i11 & 2) != 0) {
                i10 = ttiImageItem.progressPercent;
            }
            if ((i11 & 4) != 0) {
                z10 = ttiImageItem.isLoading;
            }
            if ((i11 & 8) != 0) {
                z11 = ttiImageItem.isFailed;
            }
            if ((i11 & 16) != 0) {
                z12 = ttiImageItem.showProgress;
            }
            if ((i11 & 32) != 0) {
                z13 = ttiImageItem.isStalled;
            }
            if ((i11 & 64) != 0) {
                str2 = ttiImageItem.fileId;
            }
            if ((i11 & 128) != 0) {
                z14 = ttiImageItem.isExpired;
            }
            if ((i11 & 256) != 0) {
                str3 = ttiImageItem.toolCallId;
            }
            boolean z15 = z14;
            String str4 = str3;
            boolean z16 = z13;
            String str5 = str2;
            boolean z17 = z12;
            boolean z18 = z10;
            return ttiImageItem.a(str, i10, z18, z11, z17, z16, str5, z15, str4);
        }

        public final TtiImageItem a(String url, int progressPercent, boolean isLoading, boolean isFailed, boolean showProgress, boolean isStalled, String fileId, boolean isExpired, String toolCallId) {
            return new TtiImageItem(url, progressPercent, isLoading, isFailed, showProgress, isStalled, fileId, isExpired, toolCallId);
        }

        /* renamed from: c, reason: from getter */
        public final String getFileId() {
            return this.fileId;
        }

        /* renamed from: d, reason: from getter */
        public final int getProgressPercent() {
            return this.progressPercent;
        }

        /* renamed from: e, reason: from getter */
        public final boolean getShowProgress() {
            return this.showProgress;
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof TtiImageItem)) {
                return false;
            }
            TtiImageItem ttiImageItem = (TtiImageItem) other;
            return kotlin.jvm.internal.p.d(this.url, ttiImageItem.url) && this.progressPercent == ttiImageItem.progressPercent && this.isLoading == ttiImageItem.isLoading && this.isFailed == ttiImageItem.isFailed && this.showProgress == ttiImageItem.showProgress && this.isStalled == ttiImageItem.isStalled && kotlin.jvm.internal.p.d(this.fileId, ttiImageItem.fileId) && this.isExpired == ttiImageItem.isExpired && kotlin.jvm.internal.p.d(this.toolCallId, ttiImageItem.toolCallId);
        }

        /* renamed from: f, reason: from getter */
        public final String getToolCallId() {
            return this.toolCallId;
        }

        /* renamed from: g, reason: from getter */
        public final String getUrl() {
            return this.url;
        }

        /* renamed from: h, reason: from getter */
        public final boolean getIsExpired() {
            return this.isExpired;
        }

        public int hashCode() {
            String str = this.url;
            int iHashCode = (((((((((((str == null ? 0 : str.hashCode()) * 31) + Integer.hashCode(this.progressPercent)) * 31) + Boolean.hashCode(this.isLoading)) * 31) + Boolean.hashCode(this.isFailed)) * 31) + Boolean.hashCode(this.showProgress)) * 31) + Boolean.hashCode(this.isStalled)) * 31;
            String str2 = this.fileId;
            int iHashCode2 = (((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Boolean.hashCode(this.isExpired)) * 31;
            String str3 = this.toolCallId;
            return iHashCode2 + (str3 != null ? str3.hashCode() : 0);
        }

        /* renamed from: i, reason: from getter */
        public final boolean getIsFailed() {
            return this.isFailed;
        }

        /* renamed from: j, reason: from getter */
        public final boolean getIsLoading() {
            return this.isLoading;
        }

        /* renamed from: k, reason: from getter */
        public final boolean getIsStalled() {
            return this.isStalled;
        }

        public String toString() {
            return "TtiImageItem(url=" + this.url + ", progressPercent=" + this.progressPercent + ", isLoading=" + this.isLoading + ", isFailed=" + this.isFailed + ", showProgress=" + this.showProgress + ", isStalled=" + this.isStalled + ", fileId=" + this.fileId + ", isExpired=" + this.isExpired + ", toolCallId=" + this.toolCallId + ")";
        }

        /*  JADX ERROR: NullPointerException in pass: InitCodeVariables
            java.lang.NullPointerException
            */
        public /* synthetic */ TtiImageItem(java.lang.String r13, int r14, boolean r15, boolean r16, boolean r17, boolean r18, java.lang.String r19, boolean r20, java.lang.String r21, int r22, kotlin.jvm.internal.i r23) {
            /*
                r12 = this;
                r0 = r22
                r1 = r0 & 16
                if (r1 == 0) goto L9
                r1 = 1
                r7 = r1
                goto Lb
            L9:
                r7 = r17
            Lb:
                r1 = r0 & 32
                r2 = 0
                if (r1 == 0) goto L12
                r8 = r2
                goto L14
            L12:
                r8 = r18
            L14:
                r1 = r0 & 64
                r3 = 0
                if (r1 == 0) goto L1b
                r9 = r3
                goto L1d
            L1b:
                r9 = r19
            L1d:
                r1 = r0 & 128(0x80, float:1.8E-43)
                if (r1 == 0) goto L23
                r10 = r2
                goto L25
            L23:
                r10 = r20
            L25:
                r0 = r0 & 256(0x100, float:3.59E-43)
                if (r0 == 0) goto L31
                r11 = r3
                r2 = r12
                r4 = r14
                r5 = r15
                r6 = r16
                r3 = r13
                goto L39
            L31:
                r11 = r21
                r2 = r12
                r3 = r13
                r4 = r14
                r5 = r15
                r6 = r16
            L39:
                r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TextToImageCardView.TtiImageItem.<init>(java.lang.String, int, boolean, boolean, boolean, boolean, java.lang.String, boolean, java.lang.String, int, kotlin.jvm.internal.i):void");
        }
    }

    public /* synthetic */ TextToImageCardView(Context context, AttributeSet attributeSet, int i10, int i11, kotlin.jvm.internal.i iVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet, (i11 & 4) != 0 ? 0 : i10);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TextToImageCardView(Context context, String taskId, String str) {
        this(context, null, 0, 6, null);
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(taskId, "taskId");
        this.taskId = taskId;
        this.versionId = str;
    }
}
