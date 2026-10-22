package com.chad.library.adapter.base;

import android.animation.Animator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.annotation.IdRes;
import androidx.annotation.IntRange;
import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import com.bytedance.apm.constant.CommonKey;
import com.bytedanceos.common.toolbox.ServerElements;
import com.chad.library.adapter.base.animation.AlphaInAnimation;
import com.chad.library.adapter.base.animation.BaseAnimation;
import com.chad.library.adapter.base.animation.ScaleInAnimation;
import com.chad.library.adapter.base.animation.SlideInBottomAnimation;
import com.chad.library.adapter.base.animation.SlideInLeftAnimation;
import com.chad.library.adapter.base.animation.SlideInRightAnimation;
import com.chad.library.adapter.base.diff.BrvahAsyncDiffer;
import com.chad.library.adapter.base.diff.BrvahAsyncDifferConfig;
import com.chad.library.adapter.base.diff.BrvahListUpdateCallback;
import com.chad.library.adapter.base.listener.BaseListenerImp;
import com.chad.library.adapter.base.listener.GridSpanSizeLookup;
import com.chad.library.adapter.base.listener.OnItemChildClickListener;
import com.chad.library.adapter.base.listener.OnItemChildLongClickListener;
import com.chad.library.adapter.base.listener.OnItemClickListener;
import com.chad.library.adapter.base.listener.OnItemLongClickListener;
import com.chad.library.adapter.base.module.BaseDraggableModule;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import com.chad.library.adapter.base.module.BaseUpFetchModule;
import com.chad.library.adapter.base.module.DraggableModule;
import com.chad.library.adapter.base.module.LoadMoreModule;
import com.chad.library.adapter.base.module.UpFetchModule;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.tmall.wireless.tangram.dataparser.concrete.Card;
import com.tmall.wireless.tangram.structure.card.SlideCard;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.GenericSignatureFormatError;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.MalformedParameterizedTypeException;
import java.lang.reflect.Modifier;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ReplaceWith;
import kotlin.TypeCastException;
import kotlin.collections.b0;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.MutablePropertyReference0;
import kotlin.jvm.internal.q;
import kotlin.jvm.internal.u;
import kotlin.reflect.KDeclarationContainer;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: classes2.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0094\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\t\n\u0002\b$\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 ì\u0001*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00020\u00042\u00020\u00052\u00020\u0006:\u0004ë\u0001ì\u0001B#\b\u0007\u0012\b\b\u0001\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u0010\u0010n\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0002J\u0014\u0010r\u001a\u00020o2\f\b\u0001\u0010s\u001a\u00020t\"\u00020\bJ\u0014\u0010u\u001a\u00020o2\f\b\u0001\u0010s\u001a\u00020t\"\u00020\bJ\u0017\u0010v\u001a\u00020o2\b\b\u0001\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010wJ\u001f\u0010v\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ \u0010v\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\b2\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0016J\u0018\u0010v\u001a\u00020o2\u000e\b\u0001\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0016J%\u0010|\u001a\u00020\b2\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\b2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\bH\u0007J&\u0010\u0081\u0001\u001a\u00020\b2\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\b2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\bH\u0007J!\u0010\u0082\u0001\u001a\u00020o2\u0007\u0010\u0083\u0001\u001a\u00028\u00012\u0007\u0010\u0084\u0001\u001a\u00020\bH\u0014¢\u0006\u0003\u0010\u0085\u0001J\t\u0010\u0086\u0001\u001a\u00020oH\u0002J\u0012\u0010\u0087\u0001\u001a\u00020o2\u0007\u0010\u0088\u0001\u001a\u00020\bH\u0004J \u0010\u0089\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0007\u0010\u008a\u0001\u001a\u00028\u0000H$¢\u0006\u0003\u0010\u008b\u0001J1\u0010\u0089\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0007\u0010\u008a\u0001\u001a\u00028\u00002\u000f\u0010\u008c\u0001\u001a\n\u0012\u0005\u0012\u00030\u008e\u00010\u008d\u0001H\u0014¢\u0006\u0003\u0010\u008f\u0001J'\u0010\u0090\u0001\u001a\u0004\u0018\u00018\u00012\f\u0010\u0091\u0001\u001a\u0007\u0012\u0002\b\u00030\u0092\u00012\u0006\u0010}\u001a\u00020~H\u0002¢\u0006\u0003\u0010\u0093\u0001J\u0017\u0010\u0094\u0001\u001a\u00028\u00012\u0006\u0010}\u001a\u00020~H\u0014¢\u0006\u0003\u0010\u0095\u0001J#\u0010\u0094\u0001\u001a\u00028\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\b\b\u0001\u0010\u0007\u001a\u00020\bH\u0014¢\u0006\u0003\u0010\u0098\u0001J\r\u0010\u0099\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\r\u0010\u009a\u0001\u001a\b\u0012\u0004\u0012\u00020\b0\u001aJ\t\u0010\u009b\u0001\u001a\u00020\bH\u0014J\u0011\u0010\u009c\u0001\u001a\u00020\b2\u0006\u0010x\u001a\u00020\bH\u0014J\r\u0010\u009d\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000QJ\u001e\u0010\u009e\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0092\u00012\f\u0010\u0091\u0001\u001a\u0007\u0012\u0002\b\u00030\u0092\u0001H\u0002J\u0019\u0010\u009f\u0001\u001a\u00028\u00002\b\b\u0001\u0010x\u001a\u00020\bH\u0016¢\u0006\u0003\u0010 \u0001J\t\u0010¡\u0001\u001a\u00020\bH\u0016J\u0012\u0010¢\u0001\u001a\u00030£\u00012\u0006\u0010x\u001a\u00020\bH\u0016J\u001b\u0010¤\u0001\u001a\u0004\u0018\u00018\u00002\b\b\u0001\u0010x\u001a\u00020\bH\u0016¢\u0006\u0003\u0010 \u0001J\u001a\u0010¥\u0001\u001a\u00020\b2\t\u0010\u008a\u0001\u001a\u0004\u0018\u00018\u0000H\u0016¢\u0006\u0003\u0010¦\u0001J\u0011\u0010§\u0001\u001a\u00020\b2\u0006\u0010x\u001a\u00020\bH\u0016J\t\u0010¨\u0001\u001a\u0004\u0018\u00010YJ\t\u0010©\u0001\u001a\u0004\u0018\u00010[J\t\u0010ª\u0001\u001a\u0004\u0018\u00010]J\t\u0010«\u0001\u001a\u0004\u0018\u00010_J\u001c\u0010¬\u0001\u001a\u0004\u0018\u00010~2\u0006\u0010x\u001a\u00020\b2\t\b\u0001\u0010\u00ad\u0001\u001a\u00020\bJ\u0007\u0010®\u0001\u001a\u00020\u0014J\u0007\u0010¯\u0001\u001a\u00020\u0014J\u0007\u0010°\u0001\u001a\u00020\u0014J\u0012\u0010±\u0001\u001a\u00020\u00142\u0007\u0010²\u0001\u001a\u00020\bH\u0014J\u0012\u0010³\u0001\u001a\u00020o2\u0007\u0010´\u0001\u001a\u00020iH\u0016J\u001f\u0010µ\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0006\u0010x\u001a\u00020\bH\u0016¢\u0006\u0003\u0010\u0085\u0001J/\u0010µ\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u00012\u0006\u0010x\u001a\u00020\b2\u000e\u0010\u008c\u0001\u001a\t\u0012\u0005\u0012\u00030\u008e\u00010\nH\u0016¢\u0006\u0003\u0010¶\u0001J\"\u0010·\u0001\u001a\u00028\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0084\u0001\u001a\u00020\bH\u0014¢\u0006\u0003\u0010\u0098\u0001J\"\u0010¸\u0001\u001a\u00028\u00012\b\u0010\u0096\u0001\u001a\u00030\u0097\u00012\u0007\u0010\u0084\u0001\u001a\u00020\bH\u0016¢\u0006\u0003\u0010\u0098\u0001J!\u0010¹\u0001\u001a\u00020o2\u0007\u0010\u0083\u0001\u001a\u00028\u00012\u0007\u0010\u0084\u0001\u001a\u00020\bH\u0014¢\u0006\u0003\u0010\u0085\u0001J\u0017\u0010º\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00028\u0001H\u0016¢\u0006\u0003\u0010»\u0001J\u0016\u0010¼\u0001\u001a\u00020o2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010wJ\u0013\u0010¼\u0001\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\bH\u0017J\u0007\u0010½\u0001\u001a\u00020oJ\u0007\u0010¾\u0001\u001a\u00020oJ\u0013\u0010¿\u0001\u001a\u00020o2\b\b\u0001\u0010x\u001a\u00020\bH\u0016J\u0007\u0010À\u0001\u001a\u00020oJ\u0010\u0010Á\u0001\u001a\u00020o2\u0007\u0010Â\u0001\u001a\u00020~J\u0010\u0010Ã\u0001\u001a\u00020o2\u0007\u0010Ä\u0001\u001a\u00020~J\u0017\u0010Å\u0001\u001a\u00020o2\f\u0010z\u001a\b\u0012\u0004\u0012\u00028\u00000{H\u0017J\u0011\u0010Æ\u0001\u001a\u00020o2\b\u0010Ç\u0001\u001a\u00030È\u0001J \u0010É\u0001\u001a\u00020o2\b\b\u0001\u0010\u007f\u001a\u00020\b2\u0006\u0010\t\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010yJ\u0017\u0010Ê\u0001\u001a\u00020o2\u000e\u0010Ë\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ì\u0001J\u0017\u0010Í\u0001\u001a\u00020o2\u000e\u0010Î\u0001\u001a\t\u0012\u0004\u0012\u00028\u00000Ï\u0001J$\u0010Ð\u0001\u001a\u00020o2\n\b\u0001\u0010Ñ\u0001\u001a\u00030Ò\u00012\r\u0010Ó\u0001\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u001a\u0010Ð\u0001\u001a\u00020o2\u000f\u0010Ó\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0016J\u0010\u0010Ô\u0001\u001a\u00020o2\u0007\u0010Õ\u0001\u001a\u00020~J\u000f\u0010Ô\u0001\u001a\u00020o2\u0006\u0010\u0007\u001a\u00020\bJ&\u0010Ö\u0001\u001a\u00020\b2\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\b2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\bH\u0007J\u0011\u0010×\u0001\u001a\u00020o2\u0006\u0010p\u001a\u00020qH\u0014J\u0014\u0010Ø\u0001\u001a\u00020o2\t\u0010Ù\u0001\u001a\u0004\u0018\u00010aH\u0016J&\u0010Ú\u0001\u001a\u00020\b2\u0006\u0010}\u001a\u00020~2\b\b\u0002\u0010\u007f\u001a\u00020\b2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\bH\u0007J\u001a\u0010Û\u0001\u001a\u00020o2\u000f\u0010Ó\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010{H\u0016J\u0019\u0010Ü\u0001\u001a\u00020o2\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0017J\u001a\u0010Ý\u0001\u001a\u00020o2\u000f\u0010Ó\u0001\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\nH\u0016J\u001a\u0010Þ\u0001\u001a\u00020o2\u0007\u0010ß\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\bH\u0014J\u0014\u0010à\u0001\u001a\u00020o2\t\u0010á\u0001\u001a\u0004\u0018\u00010YH\u0016J\u001a\u0010â\u0001\u001a\u00020\u00142\u0007\u0010ß\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\bH\u0014J\u0014\u0010ã\u0001\u001a\u00020o2\t\u0010á\u0001\u001a\u0004\u0018\u00010[H\u0016J\u001a\u0010ä\u0001\u001a\u00020o2\u0007\u0010ß\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\bH\u0014J\u0014\u0010å\u0001\u001a\u00020o2\t\u0010á\u0001\u001a\u0004\u0018\u00010]H\u0016J\u001a\u0010æ\u0001\u001a\u00020\u00142\u0007\u0010ß\u0001\u001a\u00020~2\u0006\u0010x\u001a\u00020\bH\u0014J\u0014\u0010ç\u0001\u001a\u00020o2\t\u0010á\u0001\u001a\u0004\u0018\u00010_H\u0016J\u001b\u0010è\u0001\u001a\u00020o2\b\u0010é\u0001\u001a\u00030ê\u00012\u0006\u0010\u007f\u001a\u00020\bH\u0014R(\u0010\u000e\u001a\u0004\u0018\u00010\r2\b\u0010\f\u001a\u0004\u0018\u00010\r@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001a\u0010\u0013\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u001d@BX\u0084.¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R0\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\n@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&8F¢\u0006\u0006\u001a\u0004\b'\u0010(R\u0013\u0010)\u001a\u0004\u0018\u00010*8F¢\u0006\u0006\u001a\u0004\b+\u0010,R\u0013\u0010-\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\b/\u00100R\u0011\u00101\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b2\u00103R\u001a\u00104\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u0010\u0016\"\u0004\b6\u0010\u0018R\u0011\u00107\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b8\u00103R\u001a\u00109\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010\u0016\"\u0004\b;\u0010\u0018R\u0013\u0010<\u001a\u0004\u0018\u00010.8F¢\u0006\u0006\u001a\u0004\b=\u00100R\u0011\u0010>\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b?\u00103R\u001a\u0010@\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0016\"\u0004\bB\u0010\u0018R\u0011\u0010C\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\bD\u00103R\u001a\u0010E\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bF\u0010\u0016\"\u0004\bG\u0010\u0018R\u001a\u0010H\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010\u0016\"\u0004\bI\u0010\u0018R\u001a\u0010J\u001a\u00020\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010\u0016\"\u0004\bK\u0010\u0018R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010L\u001a\u00020M8F¢\u0006\u0006\u001a\u0004\bN\u0010OR\u0016\u0010P\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010QX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010R\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010S\u001a\u00020*X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010T\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020.X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010V\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010MX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010d\u001a\u00020c8F¢\u0006\u0006\u001a\u0004\be\u0010fR \u0010g\u001a\b\u0012\u0004\u0012\u00020i0hX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010k\"\u0004\bl\u0010m¨\u0006í\u0001"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter;", "T", "VH", "Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/chad/library/adapter/base/BaseQuickAdapterModuleImp;", "Lcom/chad/library/adapter/base/listener/BaseListenerImp;", "layoutResId", "", "data", "", "(ILjava/util/List;)V", CommonKey.KEY_VALUE, "Lcom/chad/library/adapter/base/animation/BaseAnimation;", "adapterAnimation", "getAdapterAnimation", "()Lcom/chad/library/adapter/base/animation/BaseAnimation;", "setAdapterAnimation", "(Lcom/chad/library/adapter/base/animation/BaseAnimation;)V", "animationEnable", "", "getAnimationEnable", "()Z", "setAnimationEnable", "(Z)V", "childClickViewIds", "Ljava/util/LinkedHashSet;", "childLongClickViewIds", "<set-?>", "Landroid/content/Context;", "context", "getContext", "()Landroid/content/Context;", "getData", "()Ljava/util/List;", "setData$com_github_CymChad_brvah", "(Ljava/util/List;)V", "draggableModule", "Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "getDraggableModule", "()Lcom/chad/library/adapter/base/module/BaseDraggableModule;", "emptyLayout", "Landroid/widget/FrameLayout;", "getEmptyLayout", "()Landroid/widget/FrameLayout;", "footerLayout", "Landroid/widget/LinearLayout;", "getFooterLayout", "()Landroid/widget/LinearLayout;", "footerLayoutCount", "getFooterLayoutCount", "()I", "footerViewAsFlow", "getFooterViewAsFlow", "setFooterViewAsFlow", "footerViewPosition", "getFooterViewPosition", "footerWithEmptyEnable", "getFooterWithEmptyEnable", "setFooterWithEmptyEnable", "headerLayout", "getHeaderLayout", "headerLayoutCount", "getHeaderLayoutCount", "headerViewAsFlow", "getHeaderViewAsFlow", "setHeaderViewAsFlow", "headerViewPosition", "getHeaderViewPosition", "headerWithEmptyEnable", "getHeaderWithEmptyEnable", "setHeaderWithEmptyEnable", "isAnimationFirstOnly", "setAnimationFirstOnly", "isUseEmpty", "setUseEmpty", "loadMoreModule", "Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "getLoadMoreModule", "()Lcom/chad/library/adapter/base/module/BaseLoadMoreModule;", "mDiffHelper", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDiffer;", "mDraggableModule", "mEmptyLayout", "mFooterLayout", "mHeaderLayout", "mLastPosition", "mLoadMoreModule", "mOnItemChildClickListener", "Lcom/chad/library/adapter/base/listener/OnItemChildClickListener;", "mOnItemChildLongClickListener", "Lcom/chad/library/adapter/base/listener/OnItemChildLongClickListener;", "mOnItemClickListener", "Lcom/chad/library/adapter/base/listener/OnItemClickListener;", "mOnItemLongClickListener", "Lcom/chad/library/adapter/base/listener/OnItemLongClickListener;", "mSpanSizeLookup", "Lcom/chad/library/adapter/base/listener/GridSpanSizeLookup;", "mUpFetchModule", "Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "upFetchModule", "getUpFetchModule", "()Lcom/chad/library/adapter/base/module/BaseUpFetchModule;", "weakRecyclerView", "Ljava/lang/ref/WeakReference;", "Landroidx/recyclerview/widget/RecyclerView;", "getWeakRecyclerView", "()Ljava/lang/ref/WeakReference;", "setWeakRecyclerView", "(Ljava/lang/ref/WeakReference;)V", "addAnimation", "", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "addChildClickViewIds", "viewIds", "", "addChildLongClickViewIds", "addData", "(Ljava/lang/Object;)V", "position", "(ILjava/lang/Object;)V", "newData", "", "addFooterView", "view", "Landroid/view/View;", SlideCard.KEY_INDEX, "orientation", "addHeaderView", "bindViewClickListener", "viewHolder", "viewType", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;I)V", "checkModule", "compatibilityDataSizeChanged", "size", "convert", "item", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;)V", "payloads", "", "", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;Ljava/lang/Object;Ljava/util/List;)V", "createBaseGenericKInstance", "z", "Ljava/lang/Class;", "(Ljava/lang/Class;Landroid/view/View;)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "createBaseViewHolder", "(Landroid/view/View;)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;I)Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;", "getChildClickViewIds", "getChildLongClickViewIds", "getDefItemCount", "getDefItemViewType", "getDiffHelper", "getInstancedGenericKClass", "getItem", "(I)Ljava/lang/Object;", "getItemCount", "getItemId", "", "getItemOrNull", "getItemPosition", "(Ljava/lang/Object;)I", "getItemViewType", "getOnItemChildClickListener", "getOnItemChildLongClickListener", "getOnItemClickListener", "getOnItemLongClickListener", "getViewByPosition", "viewId", "hasEmptyView", "hasFooterLayout", "hasHeaderLayout", "isFixedViewType", "type", "onAttachedToRecyclerView", "recyclerView", "onBindViewHolder", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;ILjava/util/List;)V", "onCreateDefViewHolder", "onCreateViewHolder", "onItemViewHolderCreated", "onViewAttachedToWindow", "(Lcom/chad/library/adapter/base/viewholder/BaseViewHolder;)V", "remove", "removeAllFooterView", "removeAllHeaderView", "removeAt", "removeEmptyView", "removeFooterView", Card.KEY_FOOTER, "removeHeaderView", "header", "replaceData", "setAnimationWithDefault", "animationType", "Lcom/chad/library/adapter/base/BaseQuickAdapter$AnimationType;", "setData", "setDiffCallback", "diffCallback", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "setDiffConfig", "config", "Lcom/chad/library/adapter/base/diff/BrvahAsyncDifferConfig;", "setDiffNewData", "diffResult", "Landroidx/recyclerview/widget/DiffUtil$DiffResult;", ServerElements.LIST, "setEmptyView", "emptyView", "setFooterView", "setFullSpan", "setGridSpanSizeLookup", "spanSizeLookup", "setHeaderView", "setList", "setNewData", "setNewInstance", "setOnItemChildClick", "v", "setOnItemChildClickListener", "listener", "setOnItemChildLongClick", "setOnItemChildLongClickListener", "setOnItemClick", "setOnItemClickListener", "setOnItemLongClick", "setOnItemLongClickListener", "startAnim", "anim", "Landroid/animation/Animator;", "AnimationType", "Companion", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
public abstract class BaseQuickAdapter<T, VH extends BaseViewHolder> extends RecyclerView.Adapter implements BaseQuickAdapterModuleImp, BaseListenerImp {
    public static final Companion Companion = null;
    public static final int EMPTY_VIEW = 268436821;
    public static final int FOOTER_VIEW = 268436275;
    public static final int HEADER_VIEW = 268435729;
    public static final int LOAD_MORE_VIEW = 268436002;

    @Nullable
    private BaseAnimation adapterAnimation;
    private boolean animationEnable;
    private final LinkedHashSet<Integer> childClickViewIds;
    private final LinkedHashSet<Integer> childLongClickViewIds;

    @NotNull
    private Context context;

    @NotNull
    private List<T> data;
    private boolean footerViewAsFlow;
    private boolean footerWithEmptyEnable;
    private boolean headerViewAsFlow;
    private boolean headerWithEmptyEnable;
    private boolean isAnimationFirstOnly;
    private boolean isUseEmpty;
    private final int layoutResId;
    private BrvahAsyncDiffer<T> mDiffHelper;
    private BaseDraggableModule mDraggableModule;
    private FrameLayout mEmptyLayout;
    private LinearLayout mFooterLayout;
    private LinearLayout mHeaderLayout;
    private int mLastPosition;
    private BaseLoadMoreModule mLoadMoreModule;
    private OnItemChildClickListener mOnItemChildClickListener;
    private OnItemChildLongClickListener mOnItemChildLongClickListener;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;
    private GridSpanSizeLookup mSpanSizeLookup;
    private BaseUpFetchModule mUpFetchModule;

    @NotNull
    public WeakReference<RecyclerView> weakRecyclerView;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter$AnimationType;", "", "(Ljava/lang/String;I)V", "AlphaIn", "ScaleIn", "SlideInBottom", "SlideInLeft", "SlideInRight", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public static final enum AnimationType extends Enum<AnimationType> {
        private static final /* synthetic */ AnimationType[] $VALUES = null;
        public static final AnimationType AlphaIn = null;
        public static final AnimationType ScaleIn = null;
        public static final AnimationType SlideInBottom = null;
        public static final AnimationType SlideInLeft = null;
        public static final AnimationType SlideInRight = null;

        static {
            AnimationType r10 = new AnimationType("AlphaIn", 0);
            AlphaIn = r10;
            AnimationType r11 = new AnimationType("ScaleIn", 1);
            ScaleIn = r11;
            AnimationType r12 = new AnimationType("SlideInBottom", 2);
            SlideInBottom = r12;
            AnimationType r13 = new AnimationType("SlideInLeft", 3);
            SlideInLeft = r13;
            AnimationType r14 = new AnimationType("SlideInRight", 4);
            SlideInRight = r14;
            $VALUES = new AnimationType[]{r10, r11, r12, r13, r14};
        }

        private AnimationType(String r10, int r11) {
            super(r10, r11);
        }

        public static AnimationType valueOf(String r10) {
            return (AnimationType) Enum.valueOf(AnimationType.class, r10);
        }

        public static AnimationType[] values() {
            return (AnimationType[]) $VALUES.clone();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/chad/library/adapter/base/BaseQuickAdapter$Companion;", "", "()V", "EMPTY_VIEW", "", "FOOTER_VIEW", "HEADER_VIEW", "LOAD_MORE_VIEW", "com.github.CymChad.brvah"}, k = 1, mv = {1, 1, 16})
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r10) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    public final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r10 = new int[AnimationType.values().length];
            $EnumSwitchMapping$0 = r10;
            r10[AnimationType.AlphaIn.ordinal()] = 1;
            r10[AnimationType.ScaleIn.ordinal()] = 2;
            r10[AnimationType.SlideInBottom.ordinal()] = 3;
            r10[AnimationType.SlideInLeft.ordinal()] = 4;
            r10[AnimationType.SlideInRight.ordinal()] = 5;
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$addFooterView$1, reason: invalid class name */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class AnonymousClass1 extends MutablePropertyReference0 {
        public AnonymousClass1(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMFooterLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mFooterLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMFooterLayout()Landroid/widget/LinearLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMFooterLayout$p((BaseQuickAdapter) this.receiver, (LinearLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$addHeaderView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04271 extends MutablePropertyReference0 {
        public C04271(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMHeaderLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mHeaderLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMHeaderLayout()Landroid/widget/LinearLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMHeaderLayout$p((BaseQuickAdapter) this.receiver, (LinearLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$hasEmptyView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04281 extends MutablePropertyReference0 {
        public C04281(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMEmptyLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mEmptyLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMEmptyLayout()Landroid/widget/FrameLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMEmptyLayout$p((BaseQuickAdapter) this.receiver, (FrameLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$hasFooterLayout$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04291 extends MutablePropertyReference0 {
        public C04291(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMFooterLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mFooterLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMFooterLayout()Landroid/widget/LinearLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMFooterLayout$p((BaseQuickAdapter) this.receiver, (LinearLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$hasHeaderLayout$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04301 extends MutablePropertyReference0 {
        public C04301(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMHeaderLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mHeaderLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMHeaderLayout()Landroid/widget/LinearLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMHeaderLayout$p((BaseQuickAdapter) this.receiver, (LinearLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$removeEmptyView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04321 extends MutablePropertyReference0 {
        public C04321(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMEmptyLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mEmptyLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMEmptyLayout()Landroid/widget/FrameLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMEmptyLayout$p((BaseQuickAdapter) this.receiver, (FrameLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$setEmptyView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04331 extends MutablePropertyReference0 {
        public C04331(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMEmptyLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mEmptyLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMEmptyLayout()Landroid/widget/FrameLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMEmptyLayout$p((BaseQuickAdapter) this.receiver, (FrameLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$setFooterView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04341 extends MutablePropertyReference0 {
        public C04341(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMFooterLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mFooterLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMFooterLayout()Landroid/widget/LinearLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMFooterLayout$p((BaseQuickAdapter) this.receiver, (LinearLayout) r10);
        }
    }

    /* JADX INFO: renamed from: com.chad.library.adapter.base.BaseQuickAdapter$setHeaderView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 1, 16})
    final /* synthetic */ class C04351 extends MutablePropertyReference0 {
        public C04351(BaseQuickAdapter r10) {
            super(r10);
        }

        @Override // kotlin.reflect.KProperty0
        @Nullable
        public Object get() {
            return BaseQuickAdapter.access$getMHeaderLayout$p((BaseQuickAdapter) this.receiver);
        }

        @Override // kotlin.jvm.internal.CallableReference, kotlin.reflect.KCallable
        public String getName() {
            return "mHeaderLayout";
        }

        @Override // kotlin.jvm.internal.CallableReference
        public KDeclarationContainer getOwner() {
            return u.b(BaseQuickAdapter.class);
        }

        @Override // kotlin.jvm.internal.CallableReference
        public String getSignature() {
            return "getMHeaderLayout()Landroid/widget/LinearLayout;";
        }

        @Override // kotlin.reflect.KMutableProperty0
        public void set(@Nullable Object r10) {
            BaseQuickAdapter.access$setMHeaderLayout$p((BaseQuickAdapter) this.receiver, (LinearLayout) r10);
        }
    }

    static {
        Companion = new Companion(null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @JvmOverloads
    public BaseQuickAdapter(@LayoutRes int r10) {
        this(r10, null, 2, 0 == true ? 1 : 0);
    }

    public static final /* synthetic */ FrameLayout access$getMEmptyLayout$p(BaseQuickAdapter r10) {
        FrameLayout r11 = r10.mEmptyLayout;
        if (r11 != null) goto L5;
        q.y("mEmptyLayout");
    L5:
        return r11;
    }

    public static final /* synthetic */ LinearLayout access$getMFooterLayout$p(BaseQuickAdapter r10) {
        LinearLayout r11 = r10.mFooterLayout;
        if (r11 != null) goto L5;
        q.y("mFooterLayout");
    L5:
        return r11;
    }

    public static final /* synthetic */ LinearLayout access$getMHeaderLayout$p(BaseQuickAdapter r10) {
        LinearLayout r11 = r10.mHeaderLayout;
        if (r11 != null) goto L5;
        q.y("mHeaderLayout");
    L5:
        return r11;
    }

    public static final /* synthetic */ GridSpanSizeLookup access$getMSpanSizeLookup$p(BaseQuickAdapter r10) {
        return r10.mSpanSizeLookup;
    }

    public static final /* synthetic */ void access$setMEmptyLayout$p(BaseQuickAdapter r10, FrameLayout r11) {
        r10.mEmptyLayout = r11;
    }

    public static final /* synthetic */ void access$setMFooterLayout$p(BaseQuickAdapter r10, LinearLayout r11) {
        r10.mFooterLayout = r11;
    }

    public static final /* synthetic */ void access$setMHeaderLayout$p(BaseQuickAdapter r10, LinearLayout r11) {
        r10.mHeaderLayout = r11;
    }

    public static final /* synthetic */ void access$setMSpanSizeLookup$p(BaseQuickAdapter r10, GridSpanSizeLookup r11) {
        r10.mSpanSizeLookup = r11;
    }

    private final void addAnimation(RecyclerView.ViewHolder r10) {
        if (this.animationEnable == true) goto L5;
        return;
    L5:
        if (this.isAnimationFirstOnly == true) goto L7;
    L8:
        BaseAnimation r11 = this.adapterAnimation;
        if (r11 != null) goto L12;
        int r12 = 1;
        r11 = new AlphaInAnimation(0.0f, r12, null);
    L12:
        View r13 = r10.itemView;
        q.c(r13, "holder.itemView");
        Animator[] r14 = r11.animators(r13);
        int r15 = r14.length;
        int r16 = 0;
    L13:
        if (r16 >= r15) goto L15;
        startAnim(r14[r16], r10.getLayoutPosition());
        r16 = r16 + 1;
        goto L13
    L15:
        this.mLastPosition = r10.getLayoutPosition();
        return;
    L7:
        if (r10.getLayoutPosition() > this.mLastPosition) goto L8;
    }

    public static /* synthetic */ int addFooterView$default(BaseQuickAdapter r10, View r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = -1;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = 1;
    L10:
        return r10.addFooterView(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addFooterView");
    }

    public static /* synthetic */ int addHeaderView$default(BaseQuickAdapter r10, View r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = -1;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = 1;
    L10:
        return r10.addHeaderView(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: addHeaderView");
    }

    private final void checkModule() {
        if ((this instanceof LoadMoreModule) == false) goto L6;
        this.mLoadMoreModule = addLoadMoreModule(this);
    L6:
        if ((this instanceof UpFetchModule) == false) goto L9;
        this.mUpFetchModule = addUpFetchModule(this);
    L9:
        if ((this instanceof DraggableModule) == false) goto L12;
        this.mDraggableModule = addDraggableModule(this);
        return;
    }

    private final VH createBaseGenericKInstance(Class<?> r10, View r11) {
    L14:
        e = move-exception;
        e.printStackTrace();
        return null;
    L12:
        e = move-exception;
        e.printStackTrace();
        return null;
    L16:
        e = move-exception;
        e.printStackTrace();
        return null;
    L10:
        e = move-exception;
        e.printStackTrace();
        return null;
    L4:
        if (r10.isMemberClass() == true) goto L6;
    L20:
        Constructor<?> r12 = r10.getDeclaredConstructor(new Class[]{View.class});     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        q.c(r12, "z.getDeclaredConstructor(View::class.java)");     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        r12.setAccessible(true);     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        Object r13 = r12.newInstance(new Object[]{r11});     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        if (r13 == null) goto L25;
        return (VH) r13;
    L25:
        throw new TypeCastException("null cannot be cast to non-null type VH");     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
    L6:
        if (Modifier.isStatic(r10.getModifiers()) == true) goto L20;
        Constructor<?> r14 = r10.getDeclaredConstructor(new Class[]{getClass(), View.class});     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        q.c(r14, "z.getDeclaredConstructor…aClass, View::class.java)");     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        r14.setAccessible(true);     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        Object r15 = r14.newInstance(new Object[]{this, r11});     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
        if (r15 == null) goto L19;
        return (VH) r15;
    L19:
        throw new TypeCastException("null cannot be cast to non-null type VH");     // Catch: InvocationTargetException -> L10 InstantiationException -> L12 IllegalAccessException -> L14 NoSuchMethodException -> L16
    }

    private final Class<?> getInstancedGenericKClass(Class<?> r10) {
        Type r11 = r10.getGenericSuperclass();     // Catch: MalformedParameterizedTypeException -> L13 TypeNotPresentException -> L15 GenericSignatureFormatError -> L17
        if ((r11 instanceof ParameterizedType) == false) goto L41;
        Type[] r12 = ((ParameterizedType) r11).getActualTypeArguments();     // Catch: MalformedParameterizedTypeException -> L13 TypeNotPresentException -> L15 GenericSignatureFormatError -> L17
        int r13 = r12.length;     // Catch: MalformedParameterizedTypeException -> L13 TypeNotPresentException -> L15 GenericSignatureFormatError -> L17
        int r14 = 0;
    L5:
        if (r14 >= r13) goto L44;
        Type r15 = r12[r14];     // Catch: MalformedParameterizedTypeException -> L13 TypeNotPresentException -> L15 GenericSignatureFormatError -> L17
        if ((r15 instanceof Class) == false) goto L20;
        if (BaseViewHolder.class.isAssignableFrom((Class) r15) == false) goto L27;
        return (Class) r15;
    L27:
        r14 = r14 + 1;
        goto L5
    L20:
        if ((r15 instanceof ParameterizedType) == false) goto L27;
        Type r16 = ((ParameterizedType) r15).getRawType();     // Catch: MalformedParameterizedTypeException -> L13 TypeNotPresentException -> L15 GenericSignatureFormatError -> L17
        if ((r16 instanceof Class) == false) goto L27;
        if (BaseViewHolder.class.isAssignableFrom((Class) r16) == false) goto L27;
        return (Class) r16;
    L44:
        return null;
    L41:
        return null;
    L15:
        e = move-exception;
        e.printStackTrace();
        return null;
    L17:
        e = move-exception;
        e.printStackTrace();
        return null;
    L13:
        e = move-exception;
        e.printStackTrace();
        return null;
    }

    public static /* synthetic */ int setFooterView$default(BaseQuickAdapter r10, View r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = 1;
    L10:
        return r10.setFooterView(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setFooterView");
    }

    public static /* synthetic */ int setHeaderView$default(BaseQuickAdapter r10, View r11, int r12, int r13, int r14, Object r15) {
        if (r15 != null) goto L12;
        if ((r14 & 2) == 0) goto L7;
        r12 = 0;
    L7:
        if ((r14 & 4) == 0) goto L10;
        r13 = 1;
    L10:
        return r10.setHeaderView(r11, r12, r13);
    L12:
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setHeaderView");
    }

    public final void addChildClickViewIds(@IdRes @NotNull int... r10) {
        q.h(r10, "viewIds");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r13 = r10[r12];
        this.childClickViewIds.add(Integer.valueOf(r13));
        r12 = r12 + 1;
        goto L3
    }

    public final void addChildLongClickViewIds(@IdRes @NotNull int... r10) {
        q.h(r10, "viewIds");
        int r11 = r10.length;
        int r12 = 0;
    L3:
        if (r12 >= r11) goto L5;
        int r13 = r10[r12];
        this.childLongClickViewIds.add(Integer.valueOf(r13));
        r12 = r12 + 1;
        goto L3
    }

    public void addData(@IntRange(from = 0) int r10, T r11) {
        this.data.add(r10, r11);
        notifyItemInserted(r10 + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapterModuleImp
    @NotNull
    public BaseDraggableModule addDraggableModule(@NotNull BaseQuickAdapter<?, ?> r10) {
        q.h(r10, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp.DefaultImpls.addDraggableModule(this, r10);
    }

    @JvmOverloads
    public final int addFooterView(@NotNull View r10) {
        return addFooterView$default(this, r10, 0, 0, 6, null);
    }

    @JvmOverloads
    public final int addHeaderView(@NotNull View r10) {
        return addHeaderView$default(this, r10, 0, 0, 6, null);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapterModuleImp
    @NotNull
    public BaseLoadMoreModule addLoadMoreModule(@NotNull BaseQuickAdapter<?, ?> r10) {
        q.h(r10, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp.DefaultImpls.addLoadMoreModule(this, r10);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapterModuleImp
    @NotNull
    public BaseUpFetchModule addUpFetchModule(@NotNull BaseQuickAdapter<?, ?> r10) {
        q.h(r10, "baseQuickAdapter");
        return BaseQuickAdapterModuleImp.DefaultImpls.addUpFetchModule(this, r10);
    }

    public void bindViewClickListener(@NotNull final VH r10, int r11) {
        q.h(r10, "viewHolder");
        if (this.mOnItemClickListener == null) goto L6;
        r10.itemView.setOnClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$1(this, r10));
    L6:
        if (this.mOnItemLongClickListener == null) goto L9;
        r10.itemView.setOnLongClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$2(this, r10));
    L9:
        if (this.mOnItemChildClickListener == null) goto L20;
        Iterator<Integer> r12 = getChildClickViewIds().iterator();
    L12:
        if (r12.hasNext() == false) goto L20;
        Integer r13 = r12.next();
        View r14 = r10.itemView;
        q.c(r13, "id");
        View r15 = r14.findViewById(r13.intValue());
        if (r15 == null) goto L12;
        if (r15.isClickable() == true) goto L18;
        r15.setClickable(true);
    L18:
        r15.setOnClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$3(this, r10));
    L20:
        if (this.mOnItemChildLongClickListener == null) goto L30;
        Iterator<Integer> r16 = getChildLongClickViewIds().iterator();
    L23:
        if (r16.hasNext() == false) goto L41;
        Integer r17 = r16.next();
        View r18 = r10.itemView;
        q.c(r17, "id");
        View r19 = r18.findViewById(r17.intValue());
        if (r19 == null) goto L23;
        if (r19.isLongClickable() == true) goto L29;
        r19.setLongClickable(true);
    L29:
        r19.setOnLongClickListener(new BaseQuickAdapter$bindViewClickListener$$inlined$let$lambda$4(this, r10));
        goto L23
    L41:
        return;
    }

    public final void compatibilityDataSizeChanged(int r10) {
        if (this.data.size() != r10) goto L6;
        notifyDataSetChanged();
        return;
    }

    public abstract void convert(@NotNull VH r10, T r11);

    public void convert(@NotNull VH r10, T r11, @NotNull List<? extends Object> r12) {
        q.h(r10, "holder");
        q.h(r12, "payloads");
    }

    @NotNull
    public VH createBaseViewHolder(@NotNull ViewGroup r10, @LayoutRes int r11) {
        q.h(r10, "parent");
        return (VH) createBaseViewHolder(AdapterUtilsKt.getItemView(r10, r11));
    }

    @Nullable
    public final BaseAnimation getAdapterAnimation() {
        return this.adapterAnimation;
    }

    public final boolean getAnimationEnable() {
        return this.animationEnable;
    }

    @NotNull
    public final LinkedHashSet<Integer> getChildClickViewIds() {
        return this.childClickViewIds;
    }

    @NotNull
    public final LinkedHashSet<Integer> getChildLongClickViewIds() {
        return this.childLongClickViewIds;
    }

    @NotNull
    public final Context getContext() {
        Context r10 = this.context;
        if (r10 != null) goto L5;
        q.y("context");
    L5:
        return r10;
    }

    @NotNull
    public final List<T> getData() {
        return this.data;
    }

    public int getDefItemCount() {
        return this.data.size();
    }

    public int getDefItemViewType(int r10) {
        return super.getItemViewType(r10);
    }

    @NotNull
    public final BrvahAsyncDiffer<T> getDiffHelper() {
        BrvahAsyncDiffer<T> r10 = this.mDiffHelper;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        q.s();
    L6:
        return r10;
    L8:
        throw new IllegalStateException("Please use setDiffCallback() or setDiffConfig() first!");
    }

    @NotNull
    public final BaseDraggableModule getDraggableModule() {
        BaseDraggableModule r10 = this.mDraggableModule;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        q.s();
    L6:
        return r10;
    L8:
        throw new IllegalStateException("Please first implements DraggableModule");
    }

    @Nullable
    public final FrameLayout getEmptyLayout() {
        FrameLayout r10 = this.mEmptyLayout;
        if (r10 == null) goto L6;
        if (r10 != null) goto L8;
        q.y("mEmptyLayout");
        return r10;
    L8:
        return r10;
    L6:
        return null;
    }

    @Nullable
    public final LinearLayout getFooterLayout() {
        LinearLayout r10 = this.mFooterLayout;
        if (r10 == null) goto L6;
        if (r10 != null) goto L8;
        q.y("mFooterLayout");
        return r10;
    L8:
        return r10;
    L6:
        return null;
    }

    public final int getFooterLayoutCount() {
        return hasFooterLayout() ? 1 : 0;
    }

    public final boolean getFooterViewAsFlow() {
        return this.footerViewAsFlow;
    }

    public final int getFooterViewPosition() {
        if (hasEmptyView() == false) goto L16;
        if (this.headerWithEmptyEnable == true) goto L7;
    L9:
        int r10 = 1;
    L11:
        if (this.footerWithEmptyEnable == false) goto L13;
        return r10;
    L13:
        return -1;
    L7:
        if (hasHeaderLayout() == false) goto L9;
        r10 = 2;
        goto L11
    L16:
        return getHeaderLayoutCount() + this.data.size();
    }

    public final boolean getFooterWithEmptyEnable() {
        return this.footerWithEmptyEnable;
    }

    @Nullable
    public final LinearLayout getHeaderLayout() {
        LinearLayout r10 = this.mHeaderLayout;
        if (r10 == null) goto L6;
        if (r10 != null) goto L8;
        q.y("mHeaderLayout");
        return r10;
    L8:
        return r10;
    L6:
        return null;
    }

    public final int getHeaderLayoutCount() {
        return hasHeaderLayout() ? 1 : 0;
    }

    public final boolean getHeaderViewAsFlow() {
        return this.headerViewAsFlow;
    }

    public final int getHeaderViewPosition() {
        if (hasEmptyView() == true) goto L5;
        return 0;
    L5:
        if (this.headerWithEmptyEnable == false) goto L7;
        return 0;
    L7:
        return -1;
    }

    public final boolean getHeaderWithEmptyEnable() {
        return this.headerWithEmptyEnable;
    }

    public T getItem(@IntRange(from = 0) int r10) {
        return this.data.get(r10);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        int r10 = 1;
        if (hasEmptyView() == true) goto L5;
        BaseLoadMoreModule r11 = this.mLoadMoreModule;
        if (r11 != null) goto L18;
    L20:
        r10 = 0;
    L22:
        return ((getHeaderLayoutCount() + getDefItemCount()) + getFooterLayoutCount()) + r10;
    L18:
        if (r11.hasLoadMoreView() != true) goto L20;
    L5:
        if (this.headerWithEmptyEnable == false) goto L10;
        if (hasHeaderLayout() == false) goto L10;
        r10 = 2;
    L10:
        if (this.footerWithEmptyEnable == true) goto L12;
        return r10;
    L12:
        if (hasFooterLayout() == true) goto L14;
        return r10;
    L14:
        return r10 + 1;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public long getItemId(int r10) {
        return r10;
    }

    @Nullable
    public T getItemOrNull(@IntRange(from = 0) int r10) {
        return (T) b0.a0(this.data, r10);
    }

    public int getItemPosition(@Nullable T r10) {
        if (r10 != null) goto L4;
    L6:
        return -1;
    L4:
        if (this.data.isEmpty() == true) goto L6;
        return this.data.indexOf(r10);
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [boolean] */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int r10) {
        if (hasEmptyView() == true) goto L5;
        boolean r11 = hasHeaderLayout();
        if (r11 == false) goto L25;
        if (r10 != 0) goto L25;
        return HEADER_VIEW;
    L25:
        if (r11 == false) goto L27;
        r10 = r10 - 1;
    L27:
        int r12 = this.data.size();
        if (r10 >= r12) goto L31;
        return getDefItemViewType(r10);
    L31:
        if ((r10 - r12) < hasFooterLayout()) goto L38;
        return LOAD_MORE_VIEW;
    L38:
        return FOOTER_VIEW;
    L5:
        if (this.headerWithEmptyEnable == true) goto L7;
    L9:
        boolean r13 = false;
    L11:
        if (r10 == 0) goto L19;
        if (r10 != 1) goto L14;
        if (r13 == false) goto L35;
    L20:
        return EMPTY_VIEW;
    L35:
        return FOOTER_VIEW;
    L14:
        if (r10 == 2) goto L35;
    L19:
        if (r13 == false) goto L20;
        return HEADER_VIEW;
    L7:
        if (hasHeaderLayout() == false) goto L9;
        r13 = true;
        goto L11
    }

    @NotNull
    public final BaseLoadMoreModule getLoadMoreModule() {
        BaseLoadMoreModule r10 = this.mLoadMoreModule;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        q.s();
    L6:
        return r10;
    L8:
        throw new IllegalStateException("Please first implements LoadMoreModule");
    }

    @Nullable
    public final OnItemChildClickListener getOnItemChildClickListener() {
        return this.mOnItemChildClickListener;
    }

    @Nullable
    public final OnItemChildLongClickListener getOnItemChildLongClickListener() {
        return this.mOnItemChildLongClickListener;
    }

    @Nullable
    public final OnItemClickListener getOnItemClickListener() {
        return this.mOnItemClickListener;
    }

    @Nullable
    public final OnItemLongClickListener getOnItemLongClickListener() {
        return this.mOnItemLongClickListener;
    }

    @NotNull
    public final BaseUpFetchModule getUpFetchModule() {
        BaseUpFetchModule r10 = this.mUpFetchModule;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        q.s();
    L6:
        return r10;
    L8:
        throw new IllegalStateException("Please first implements UpFetchModule");
    }

    @Nullable
    public final View getViewByPosition(int r10, @IdRes int r11) {
        WeakReference<RecyclerView> r12 = this.weakRecyclerView;
        if (r12 != null) goto L5;
        q.y("weakRecyclerView");
    L5:
        RecyclerView r13 = r12.get();
        if (r13 == null) goto L11;
        q.c(r13, "weakRecyclerView.get() ?: return null");
        BaseViewHolder r14 = (BaseViewHolder) r13.findViewHolderForLayoutPosition(r10);
        if (r14 == null) goto L11;
        return r14.getViewOrNull(r11);
    L11:
        return null;
    }

    @NotNull
    public final WeakReference<RecyclerView> getWeakRecyclerView() {
        WeakReference<RecyclerView> r10 = this.weakRecyclerView;
        if (r10 != null) goto L5;
        q.y("weakRecyclerView");
    L5:
        return r10;
    }

    public final boolean hasEmptyView() {
        FrameLayout r10 = this.mEmptyLayout;
        if (r10 == null) goto L14;
        if (r10 != null) goto L7;
        q.y("mEmptyLayout");
    L7:
        if (r10.getChildCount() == 0) goto L14;
        if (this.isUseEmpty == true) goto L13;
        return false;
    L13:
        return this.data.isEmpty();
    L14:
        return false;
    }

    public final boolean hasFooterLayout() {
        LinearLayout r10 = this.mFooterLayout;
        if (r10 == null) goto L10;
        if (r10 != null) goto L7;
        q.y("mFooterLayout");
    L7:
        if (r10.getChildCount() <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean hasHeaderLayout() {
        LinearLayout r10 = this.mHeaderLayout;
        if (r10 == null) goto L10;
        if (r10 != null) goto L7;
        q.y("mHeaderLayout");
    L7:
        if (r10.getChildCount() <= 0) goto L12;
        return true;
    L12:
        return false;
    L10:
        return false;
    }

    public final boolean isAnimationFirstOnly() {
        return this.isAnimationFirstOnly;
    }

    public boolean isFixedViewType(int r10) {
        if (r10 != 268436821) goto L5;
    L12:
        return true;
    L5:
        if (r10 == 268435729) goto L12;
        if (r10 == 268436275) goto L12;
        if (r10 == 268436002) goto L12;
        return false;
    }

    public final boolean isUseEmpty() {
        return this.isUseEmpty;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onAttachedToRecyclerView(@NotNull RecyclerView r10) {
        q.h(r10, "recyclerView");
        super.onAttachedToRecyclerView(r10);
        this.weakRecyclerView = new WeakReference(r10);
        Context r11 = r10.getContext();
        q.c(r11, "recyclerView.context");
        this.context = r11;
        BaseDraggableModule r12 = this.mDraggableModule;
        if (r12 == null) goto L5;
        r12.attachToRecyclerView(r10);
    L5:
        final RecyclerView.LayoutManager r13 = r10.getLayoutManager();
        if ((r13 instanceof GridLayoutManager) == false) goto L9;
        GridLayoutManager r14 = (GridLayoutManager) r13;
        final GridLayoutManager.b r15 = r14.M();
        r14.R(new C04311(this, r13, r15));
        return;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11) {
        onBindViewHolder((BaseViewHolder) r10, r11);
    }

    @NotNull
    public VH onCreateDefViewHolder(@NotNull ViewGroup r10, int r11) {
        q.h(r10, "parent");
        return (VH) createBaseViewHolder(r10, this.layoutResId);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ RecyclerView.ViewHolder onCreateViewHolder(ViewGroup r10, int r11) {
        return onCreateViewHolder(r10, r11);
    }

    public void onItemViewHolderCreated(@NotNull VH r10, int r11) {
        q.h(r10, "viewHolder");
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onViewAttachedToWindow(RecyclerView.ViewHolder r10) {
        onViewAttachedToWindow((BaseViewHolder) r10);
    }

    @Deprecated(message = "Please use removeAt()", replaceWith = @ReplaceWith(expression = "removeAt(position)", imports = {}))
    public void remove(@IntRange(from = 0) int r10) {
        removeAt(r10);
    }

    public final void removeAllFooterView() {
        if (hasFooterLayout() == true) goto L5;
        return;
    L5:
        LinearLayout r10 = this.mFooterLayout;
        if (r10 != null) goto L8;
        q.y("mFooterLayout");
    L8:
        r10.removeAllViews();
        int r11 = getFooterViewPosition();
        if (r11 == (-1)) goto L12;
        notifyItemRemoved(r11);
        return;
    }

    public final void removeAllHeaderView() {
        if (hasHeaderLayout() == true) goto L5;
        return;
    L5:
        LinearLayout r10 = this.mHeaderLayout;
        if (r10 != null) goto L8;
        q.y("mHeaderLayout");
    L8:
        r10.removeAllViews();
        int r11 = getHeaderViewPosition();
        if (r11 == (-1)) goto L12;
        notifyItemRemoved(r11);
        return;
    }

    public void removeAt(@IntRange(from = 0) int r10) {
        if (r10 < this.data.size()) goto L5;
        return;
    L5:
        this.data.remove(r10);
        int r11 = r10 + getHeaderLayoutCount();
        notifyItemRemoved(r11);
        compatibilityDataSizeChanged(0);
        notifyItemRangeChanged(r11, this.data.size() - r11);
    }

    public final void removeEmptyView() {
        FrameLayout r10 = this.mEmptyLayout;
        if (r10 == null) goto L8;
        if (r10 != null) goto L6;
        q.y("mEmptyLayout");
    L6:
        r10.removeAllViews();
        return;
    }

    public final void removeFooterView(@NotNull View r10) {
        q.h(r10, Card.KEY_FOOTER);
        if (hasFooterLayout() == true) goto L5;
        return;
    L5:
        LinearLayout r11 = this.mFooterLayout;
        if (r11 != null) goto L8;
        q.y("mFooterLayout");
    L8:
        r11.removeView(r10);
        LinearLayout r12 = this.mFooterLayout;
        if (r12 != null) goto L12;
        q.y("mFooterLayout");
    L12:
        if (r12.getChildCount() != 0) goto L17;
        int r13 = getFooterViewPosition();
        if (r13 == (-1)) goto L18;
        notifyItemRemoved(r13);
        return;
    L18:
        return;
    }

    public final void removeHeaderView(@NotNull View r10) {
        q.h(r10, "header");
        if (hasHeaderLayout() == true) goto L5;
        return;
    L5:
        LinearLayout r11 = this.mHeaderLayout;
        if (r11 != null) goto L8;
        q.y("mHeaderLayout");
    L8:
        r11.removeView(r10);
        LinearLayout r12 = this.mHeaderLayout;
        if (r12 != null) goto L12;
        q.y("mHeaderLayout");
    L12:
        if (r12.getChildCount() != 0) goto L17;
        int r13 = getHeaderViewPosition();
        if (r13 == (-1)) goto L18;
        notifyItemRemoved(r13);
        return;
    L18:
        return;
    }

    @Deprecated(message = "Please use setData()", replaceWith = @ReplaceWith(expression = "setData(newData)", imports = {}))
    public void replaceData(@NotNull Collection<? extends T> r10) {
        q.h(r10, "newData");
        setList(r10);
    }

    public final void setAdapterAnimation(@Nullable BaseAnimation r10) {
        this.animationEnable = true;
        this.adapterAnimation = r10;
    }

    public final void setAnimationEnable(boolean r10) {
        this.animationEnable = r10;
    }

    public final void setAnimationFirstOnly(boolean r10) {
        this.isAnimationFirstOnly = r10;
    }

    public final void setAnimationWithDefault(@NotNull AnimationType r10) {
        q.h(r10, "animationType");
        int r11 = WhenMappings.$EnumSwitchMapping$0[r10.ordinal()];
        DefaultConstructorMarker r12 = null;
        float r13 = 0.0f;
        int r14 = 1;
        if (r11 != 1) goto L5;
        BaseAnimation r15 = new AlphaInAnimation(r13, r14, r12);
    L19:
        setAdapterAnimation(r15);
        return;
    L5:
        if (r11 != 2) goto L7;
        r15 = new ScaleInAnimation(r13, r14, r12);
        goto L19
    L7:
        if (r11 != 3) goto L9;
        r15 = new SlideInBottomAnimation();
        goto L19
    L9:
        if (r11 != 4) goto L11;
        r15 = new SlideInLeftAnimation();
        goto L19
    L11:
        if (r11 != 5) goto L14;
        r15 = new SlideInRightAnimation();
        goto L19
    L14:
        throw new NoWhenBranchMatchedException();
    }

    public void setData(@IntRange(from = 0) int r10, T r11) {
        if (r10 < this.data.size()) goto L5;
        return;
    L5:
        this.data.set(r10, r11);
        notifyItemChanged(r10 + getHeaderLayoutCount());
    }

    public final void setData$com_github_CymChad_brvah(@NotNull List<T> r10) {
        q.h(r10, "<set-?>");
        this.data = r10;
    }

    public final void setDiffCallback(@NotNull DiffUtil.ItemCallback r10) {
        q.h(r10, "diffCallback");
        setDiffConfig(new BrvahAsyncDifferConfig.Builder(r10).build());
    }

    public final void setDiffConfig(@NotNull BrvahAsyncDifferConfig<T> r10) {
        q.h(r10, "config");
        this.mDiffHelper = new BrvahAsyncDiffer(this, r10);
    }

    public void setDiffNewData(@Nullable List<T> r10) {
        if (hasEmptyView() == false) goto L6;
        setNewInstance(r10);
        return;
    L6:
        BrvahAsyncDiffer<T> r11 = this.mDiffHelper;
        if (r11 == null) goto L10;
        BrvahAsyncDiffer.submitList$default(r11, r10, null, 2, null);
        return;
    }

    public final void setEmptyView(@NotNull View r10) {
        q.h(r10, "emptyView");
        int r11 = getItemCount();
        int r12 = 1;
        if (this.mEmptyLayout != null) goto L9;
        FrameLayout r13 = new FrameLayout(r10.getContext());
        this.mEmptyLayout = r13;
        ViewGroup.LayoutParams r14 = r10.getLayoutParams();
        if (r14 == null) goto L7;
        ViewGroup.LayoutParams r15 = new ViewGroup.LayoutParams(r14.width, r14.height);
    L8:
        r13.setLayoutParams(r15);
        boolean r16 = true;
    L19:
        FrameLayout r17 = this.mEmptyLayout;
        if (r17 != null) goto L22;
        q.y("mEmptyLayout");
    L22:
        r17.removeAllViews();
        FrameLayout r18 = this.mEmptyLayout;
        if (r18 != null) goto L25;
        q.y("mEmptyLayout");
    L25:
        r18.addView(r10);
        this.isUseEmpty = true;
        if (r16 == true) goto L28;
        return;
    L28:
        if (hasEmptyView() == true) goto L30;
        return;
    L30:
        if (this.headerWithEmptyEnable == true) goto L32;
    L34:
        r12 = 0;
    L36:
        if (getItemCount() <= r11) goto L38;
        notifyItemInserted(r12);
        return;
    L38:
        notifyDataSetChanged();
        return;
    L32:
        if (hasHeaderLayout() == false) goto L34;
    L7:
        r15 = new ViewGroup.LayoutParams(-1, -1);
        goto L8
    L9:
        ViewGroup.LayoutParams r19 = r10.getLayoutParams();
        if (r19 == null) goto L18;
        FrameLayout r20 = this.mEmptyLayout;
        if (r20 != null) goto L14;
        q.y("mEmptyLayout");
    L14:
        ViewGroup.LayoutParams r21 = r20.getLayoutParams();
        r21.width = r19.width;
        r21.height = r19.height;
        FrameLayout r22 = this.mEmptyLayout;
        if (r22 != null) goto L17;
        q.y("mEmptyLayout");
    L17:
        r22.setLayoutParams(r21);
    L18:
        r16 = false;
        goto L19
    }

    @JvmOverloads
    public final int setFooterView(@NotNull View r10) {
        return setFooterView$default(this, r10, 0, 0, 6, null);
    }

    public final void setFooterViewAsFlow(boolean r10) {
        this.footerViewAsFlow = r10;
    }

    public final void setFooterWithEmptyEnable(boolean r10) {
        this.footerWithEmptyEnable = r10;
    }

    public void setFullSpan(@NotNull RecyclerView.ViewHolder r10) {
        q.h(r10, "holder");
        View r11 = r10.itemView;
        q.c(r11, "holder.itemView");
        ViewGroup.LayoutParams r12 = r11.getLayoutParams();
        if ((r12 instanceof StaggeredGridLayoutManager.LayoutParams) == false) goto L6;
        ((StaggeredGridLayoutManager.LayoutParams) r12).b(true);
        return;
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setGridSpanSizeLookup(@Nullable GridSpanSizeLookup r10) {
        this.mSpanSizeLookup = r10;
    }

    @JvmOverloads
    public final int setHeaderView(@NotNull View r10) {
        return setHeaderView$default(this, r10, 0, 0, 6, null);
    }

    public final void setHeaderViewAsFlow(boolean r10) {
        this.headerViewAsFlow = r10;
    }

    public final void setHeaderWithEmptyEnable(boolean r10) {
        this.headerWithEmptyEnable = r10;
    }

    public void setList(@Nullable Collection<? extends T> r10) {
        List<T> r11 = this.data;
        if (r10 == r11) goto L10;
        r11.clear();
        if (r10 != null) goto L7;
    L16:
        BaseLoadMoreModule r12 = this.mLoadMoreModule;
        if (r12 == null) goto L19;
        r12.reset$com_github_CymChad_brvah();
    L19:
        this.mLastPosition = -1;
        notifyDataSetChanged();
        BaseLoadMoreModule r13 = this.mLoadMoreModule;
        if (r13 == null) goto L23;
        r13.checkDisableLoadMoreIfNotFullPage();
        return;
    L23:
        return;
    L7:
        if (r10.isEmpty() == true) goto L16;
        this.data.addAll(r10);
        goto L16
    L10:
        if (r10 != null) goto L12;
    L15:
        this.data.clear();
        goto L16
    L12:
        if (r10.isEmpty() == true) goto L15;
        ArrayList r14 = new ArrayList(r10);
        this.data.clear();
        this.data.addAll(r14);
        goto L16
    }

    @Deprecated(message = "Please use setNewInstance(), This method will be removed in the next version", replaceWith = @ReplaceWith(expression = "setNewInstance(data)", imports = {}))
    public void setNewData(@Nullable List<T> r10) {
        setNewInstance(r10);
    }

    public void setNewInstance(@Nullable List<T> r10) {
        if (r10 != this.data) goto L5;
        return;
    L5:
        if (r10 != null) goto L8;
        r10 = new ArrayList();
    L8:
        this.data = r10;
        BaseLoadMoreModule r11 = this.mLoadMoreModule;
        if (r11 == null) goto L11;
        r11.reset$com_github_CymChad_brvah();
    L11:
        this.mLastPosition = -1;
        notifyDataSetChanged();
        BaseLoadMoreModule r12 = this.mLoadMoreModule;
        if (r12 == null) goto L15;
        r12.checkDisableLoadMoreIfNotFullPage();
        return;
    }

    public void setOnItemChildClick(@NotNull View r10, int r11) {
        q.h(r10, "v");
        OnItemChildClickListener r12 = this.mOnItemChildClickListener;
        if (r12 == null) goto L6;
        r12.onItemChildClick(this, r10, r11);
        return;
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemChildClickListener(@Nullable OnItemChildClickListener r10) {
        this.mOnItemChildClickListener = r10;
    }

    public boolean setOnItemChildLongClick(@NotNull View r10, int r11) {
        q.h(r10, "v");
        OnItemChildLongClickListener r12 = this.mOnItemChildLongClickListener;
        if (r12 != null) goto L7;
        return false;
    L7:
        return r12.onItemChildLongClick(this, r10, r11);
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemChildLongClickListener(@Nullable OnItemChildLongClickListener r10) {
        this.mOnItemChildLongClickListener = r10;
    }

    public void setOnItemClick(@NotNull View r10, int r11) {
        q.h(r10, "v");
        OnItemClickListener r12 = this.mOnItemClickListener;
        if (r12 == null) goto L6;
        r12.onItemClick(this, r10, r11);
        return;
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemClickListener(@Nullable OnItemClickListener r10) {
        this.mOnItemClickListener = r10;
    }

    public boolean setOnItemLongClick(@NotNull View r10, int r11) {
        q.h(r10, "v");
        OnItemLongClickListener r12 = this.mOnItemLongClickListener;
        if (r12 != null) goto L7;
        return false;
    L7:
        return r12.onItemLongClick(this, r10, r11);
    }

    @Override // com.chad.library.adapter.base.listener.BaseListenerImp
    public void setOnItemLongClickListener(@Nullable OnItemLongClickListener r10) {
        this.mOnItemLongClickListener = r10;
    }

    public final void setUseEmpty(boolean r10) {
        this.isUseEmpty = r10;
    }

    public final void setWeakRecyclerView(@NotNull WeakReference<RecyclerView> r10) {
        q.h(r10, "<set-?>");
        this.weakRecyclerView = r10;
    }

    public void startAnim(@NotNull Animator r10, int r11) {
        q.h(r10, "anim");
        r10.start();
    }

    public /* synthetic */ BaseQuickAdapter(int r10, List r11, int r12, DefaultConstructorMarker r13) {
        if ((r12 & 2) == 0) goto L5;
        r11 = null;
    L5:
        this(r10, r11);
    }

    @JvmOverloads
    public final int addFooterView(@NotNull View r10, int r11) {
        return addFooterView$default(this, r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public final int addHeaderView(@NotNull View r10, int r11) {
        return addHeaderView$default(this, r10, r11, 0, 4, null);
    }

    @NotNull
    public VH createBaseViewHolder(@NotNull View r10) {
        q.h(r10, "view");
        Class<?> r11 = getClass();
        Class<?> r12 = null;
    L3:
        if (r12 != null) goto L6;
        if (r11 == null) goto L6;
        r12 = getInstancedGenericKClass(r11);
        r11 = r11.getSuperclass();
    L6:
        if (r12 != null) goto L8;
        VH r13 = (VH) new BaseViewHolder(r10);
    L9:
        if (r13 == null) goto L12;
        return r13;
    L12:
        return (VH) new BaseViewHolder(r10);
    L8:
        r13 = (VH) createBaseGenericKInstance(r12, r10);
        goto L9
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public /* bridge */ /* synthetic */ void onBindViewHolder(RecyclerView.ViewHolder r10, int r11, List r12) {
        onBindViewHolder((BaseViewHolder) r10, r11, r12);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    @NotNull
    public VH onCreateViewHolder(@NotNull ViewGroup r10, int r11) {
        q.h(r10, "parent");
        switch(r11) {
            case 268435729: goto L41;
            case 268436002: goto L34;
            case 268436275: goto L21;
            case 268436821: goto L8;
            default: goto L4;
        };
    L4:
        VH r12 = (VH) onCreateDefViewHolder(r10, r11);
        bindViewClickListener(r12, r11);
        BaseDraggableModule r13 = this.mDraggableModule;
        if (r13 == null) goto L7;
        r13.initView$com_github_CymChad_brvah(r12);
    L7:
        onItemViewHolderCreated(r12, r11);
        return r12;
    L8:
        FrameLayout r14 = this.mEmptyLayout;
        if (r14 != null) goto L11;
        q.y("mEmptyLayout");
    L11:
        ViewParent r15 = r14.getParent();
        if ((r15 instanceof ViewGroup) == false) goto L17;
        ViewGroup r16 = (ViewGroup) r15;
        FrameLayout r17 = this.mEmptyLayout;
        if (r17 != null) goto L16;
        q.y("mEmptyLayout");
    L16:
        r16.removeView(r17);
    L17:
        FrameLayout r18 = this.mEmptyLayout;
        if (r18 != null) goto L56;
        q.y("mEmptyLayout");
    L56:
        return (VH) createBaseViewHolder(r18);
    L21:
        LinearLayout r19 = this.mFooterLayout;
        if (r19 != null) goto L24;
        q.y("mFooterLayout");
    L24:
        ViewParent r20 = r19.getParent();
        if ((r20 instanceof ViewGroup) == false) goto L30;
        ViewGroup r21 = (ViewGroup) r20;
        LinearLayout r22 = this.mFooterLayout;
        if (r22 != null) goto L29;
        q.y("mFooterLayout");
    L29:
        r21.removeView(r22);
    L30:
        LinearLayout r23 = this.mFooterLayout;
        if (r23 != null) goto L57;
        q.y("mFooterLayout");
    L57:
        return (VH) createBaseViewHolder(r23);
    L34:
        BaseLoadMoreModule r24 = this.mLoadMoreModule;
        if (r24 != null) goto L37;
        q.s();
    L37:
        VH r25 = (VH) createBaseViewHolder(r24.getLoadMoreView().getRootView(r10));
        BaseLoadMoreModule r26 = this.mLoadMoreModule;
        if (r26 != null) goto L40;
        q.s();
    L40:
        r26.setupViewHolder$com_github_CymChad_brvah(r25);
        return r25;
    L41:
        LinearLayout r27 = this.mHeaderLayout;
        if (r27 != null) goto L44;
        q.y("mHeaderLayout");
    L44:
        ViewParent r28 = r27.getParent();
        if ((r28 instanceof ViewGroup) == false) goto L50;
        ViewGroup r29 = (ViewGroup) r28;
        LinearLayout r30 = this.mHeaderLayout;
        if (r30 != null) goto L49;
        q.y("mHeaderLayout");
    L49:
        r29.removeView(r30);
    L50:
        LinearLayout r31 = this.mHeaderLayout;
        if (r31 != null) goto L54;
        q.y("mHeaderLayout");
    L54:
        return (VH) createBaseViewHolder(r31);
    }

    public void onViewAttachedToWindow(@NotNull VH r10) {
        q.h(r10, "holder");
        super.onViewAttachedToWindow(r10);
        if (isFixedViewType(r10.getItemViewType()) == false) goto L5;
        setFullSpan(r10);
        return;
    L5:
        addAnimation(r10);
    }

    public void remove(T r10) {
        int r11 = this.data.indexOf(r10);
        if (r11 != (-1)) goto L5;
        return;
    L5:
        remove(r11);
    }

    @JvmOverloads
    public final int setFooterView(@NotNull View r10, int r11) {
        return setFooterView$default(this, r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public final int setHeaderView(@NotNull View r10, int r11) {
        return setHeaderView$default(this, r10, r11, 0, 4, null);
    }

    @JvmOverloads
    public BaseQuickAdapter(@LayoutRes int r10, @Nullable List<T> r11) {
        this.layoutResId = r10;
        if (r11 != null) goto L6;
        r11 = new ArrayList();
    L6:
        this.data = r11;
        this.isUseEmpty = true;
        this.isAnimationFirstOnly = true;
        this.mLastPosition = -1;
        checkModule();
        this.childClickViewIds = new LinkedHashSet();
        this.childLongClickViewIds = new LinkedHashSet();
    }

    @JvmOverloads
    public final int addFooterView(@NotNull View r10, int r11, int r12) {
        q.h(r10, "view");
        if (this.mFooterLayout != null) goto L12;
        LinearLayout r13 = new LinearLayout(r10.getContext());
        this.mFooterLayout = r13;
        r13.setOrientation(r12);
        LinearLayout r14 = this.mFooterLayout;
        if (r14 != null) goto L8;
        q.y("mFooterLayout");
    L8:
        if (r12 != 1) goto L10;
        RecyclerView.LayoutParams r15 = new RecyclerView.LayoutParams(-1, -2);
    L11:
        r14.setLayoutParams(r15);
        goto L12
    L10:
        r15 = new RecyclerView.LayoutParams(-2, -1);
    L12:
        LinearLayout r16 = this.mFooterLayout;
        if (r16 != null) goto L15;
        q.y("mFooterLayout");
    L15:
        int r17 = r16.getChildCount();
        if (r11 < 0) goto L18;
        if (r11 > r17) goto L18;
    L19:
        LinearLayout r18 = this.mFooterLayout;
        if (r18 != null) goto L22;
        q.y("mFooterLayout");
    L22:
        r18.addView(r10, r11);
        LinearLayout r19 = this.mFooterLayout;
        if (r19 != null) goto L26;
        q.y("mFooterLayout");
    L26:
        if (r19.getChildCount() != 1) goto L30;
        int r20 = getFooterViewPosition();
        if (r20 == (-1)) goto L30;
        notifyItemInserted(r20);
    L30:
        return r11;
    L18:
        r11 = r17;
        goto L19
    }

    @JvmOverloads
    public final int addHeaderView(@NotNull View r10, int r11, int r12) {
        q.h(r10, "view");
        if (this.mHeaderLayout != null) goto L12;
        LinearLayout r13 = new LinearLayout(r10.getContext());
        this.mHeaderLayout = r13;
        r13.setOrientation(r12);
        LinearLayout r14 = this.mHeaderLayout;
        if (r14 != null) goto L8;
        q.y("mHeaderLayout");
    L8:
        if (r12 != 1) goto L10;
        RecyclerView.LayoutParams r15 = new RecyclerView.LayoutParams(-1, -2);
    L11:
        r14.setLayoutParams(r15);
        goto L12
    L10:
        r15 = new RecyclerView.LayoutParams(-2, -1);
    L12:
        LinearLayout r16 = this.mHeaderLayout;
        if (r16 != null) goto L15;
        q.y("mHeaderLayout");
    L15:
        int r17 = r16.getChildCount();
        if (r11 < 0) goto L18;
        if (r11 > r17) goto L18;
    L19:
        LinearLayout r18 = this.mHeaderLayout;
        if (r18 != null) goto L22;
        q.y("mHeaderLayout");
    L22:
        r18.addView(r10, r11);
        LinearLayout r19 = this.mHeaderLayout;
        if (r19 != null) goto L26;
        q.y("mHeaderLayout");
    L26:
        if (r19.getChildCount() != 1) goto L30;
        int r20 = getHeaderViewPosition();
        if (r20 == (-1)) goto L30;
        notifyItemInserted(r20);
    L30:
        return r11;
    L18:
        r11 = r17;
        goto L19
    }

    public void onBindViewHolder(@NotNull VH r10, int r11) {
        q.h(r10, "holder");
        BaseUpFetchModule r12 = this.mUpFetchModule;
        if (r12 == null) goto L5;
        r12.autoUpFetch$com_github_CymChad_brvah(r11);
    L5:
        BaseLoadMoreModule r13 = this.mLoadMoreModule;
        if (r13 == null) goto L9;
        r13.autoLoadMore$com_github_CymChad_brvah(r11);
    L9:
        switch(r10.getItemViewType()) {
            case 268435729: goto L15;
            case 268436002: goto L11;
            case 268436275: goto L15;
            case 268436821: goto L15;
            default: goto L10;
        };
    L10:
        convert(r10, getItem(r11 - getHeaderLayoutCount()));
        return;
    L11:
        BaseLoadMoreModule r14 = this.mLoadMoreModule;
        if (r14 == null) goto L17;
        r14.getLoadMoreView().convert(r10, r11, r14.getLoadMoreStatus());
        return;
    L17:
        return;
    }

    @JvmOverloads
    public final int setFooterView(@NotNull View r10, int r11, int r12) {
        q.h(r10, "view");
        LinearLayout r13 = this.mFooterLayout;
        if (r13 == null) goto L18;
        if (r13 != null) goto L8;
        q.y("mFooterLayout");
    L8:
        if (r13.getChildCount() <= r11) goto L18;
        LinearLayout r14 = this.mFooterLayout;
        if (r14 != null) goto L13;
        q.y("mFooterLayout");
    L13:
        r14.removeViewAt(r11);
        LinearLayout r15 = this.mFooterLayout;
        if (r15 != null) goto L16;
        q.y("mFooterLayout");
    L16:
        r15.addView(r10, r11);
        return r11;
    L18:
        return addFooterView(r10, r11, r12);
    }

    @JvmOverloads
    public final int setHeaderView(@NotNull View r10, int r11, int r12) {
        q.h(r10, "view");
        LinearLayout r13 = this.mHeaderLayout;
        if (r13 == null) goto L18;
        if (r13 != null) goto L8;
        q.y("mHeaderLayout");
    L8:
        if (r13.getChildCount() <= r11) goto L18;
        LinearLayout r14 = this.mHeaderLayout;
        if (r14 != null) goto L13;
        q.y("mHeaderLayout");
    L13:
        r14.removeViewAt(r11);
        LinearLayout r15 = this.mHeaderLayout;
        if (r15 != null) goto L16;
        q.y("mHeaderLayout");
    L16:
        r15.addView(r10, r11);
        return r11;
    L18:
        return addHeaderView(r10, r11, r12);
    }

    public void addData(@NonNull T r10) {
        this.data.add(r10);
        notifyItemInserted(this.data.size() + getHeaderLayoutCount());
        compatibilityDataSizeChanged(1);
    }

    public void setDiffNewData(@NonNull @NotNull DiffUtil.DiffResult r10, @NotNull List<T> r11) {
        q.h(r10, "diffResult");
        q.h(r11, ServerElements.LIST);
        if (hasEmptyView() == false) goto L6;
        setNewInstance(r11);
        return;
    L6:
        r10.b(new BrvahListUpdateCallback(this));
        this.data = r11;
    }

    public void addData(@IntRange(from = 0) int r10, @NotNull Collection<? extends T> r11) {
        q.h(r11, "newData");
        this.data.addAll(r10, r11);
        notifyItemRangeInserted(r10 + getHeaderLayoutCount(), r11.size());
        compatibilityDataSizeChanged(r11.size());
    }

    public void onBindViewHolder(@NotNull VH r10, int r11, @NotNull List<Object> r12) {
        q.h(r10, "holder");
        q.h(r12, "payloads");
        if (r12.isEmpty() == false) goto L6;
        onBindViewHolder(r10, r11);
        return;
    L6:
        BaseUpFetchModule r13 = this.mUpFetchModule;
        if (r13 == null) goto L9;
        r13.autoUpFetch$com_github_CymChad_brvah(r11);
    L9:
        BaseLoadMoreModule r14 = this.mLoadMoreModule;
        if (r14 == null) goto L13;
        r14.autoLoadMore$com_github_CymChad_brvah(r11);
    L13:
        switch(r10.getItemViewType()) {
            case 268435729: goto L19;
            case 268436002: goto L15;
            case 268436275: goto L19;
            case 268436821: goto L19;
            default: goto L14;
        };
    L14:
        convert(r10, getItem(r11 - getHeaderLayoutCount()), r12);
        return;
    L15:
        BaseLoadMoreModule r15 = this.mLoadMoreModule;
        if (r15 == null) goto L21;
        r15.getLoadMoreView().convert(r10, r11, r15.getLoadMoreStatus());
        return;
    L21:
        return;
    }

    public void addData(@NonNull @NotNull Collection<? extends T> r10) {
        q.h(r10, "newData");
        this.data.addAll(r10);
        notifyItemRangeInserted((this.data.size() - r10.size()) + getHeaderLayoutCount(), r10.size());
        compatibilityDataSizeChanged(r10.size());
    }

    public final void setEmptyView(int r10) {
        WeakReference<RecyclerView> r11 = this.weakRecyclerView;
        if (r11 != null) goto L5;
        q.y("weakRecyclerView");
    L5:
        RecyclerView r12 = r11.get();
        if (r12 == null) goto L9;
        q.c(r12, "it");
        View r13 = LayoutInflater.from(r12.getContext()).inflate(r10, r12, false);
        q.c(r13, "view");
        setEmptyView(r13);
        return;
    }
}
