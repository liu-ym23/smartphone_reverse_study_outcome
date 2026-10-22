package com.stepos.widget.dialog;

import Z8.C1173v;
import Z8.C1174w;
import Z8.F;
import Z8.r;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Cursor;
import android.graphics.Outline;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.text.method.MovementMethod;
import android.util.Pair;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewOutlineProvider;
import android.view.ViewParent;
import android.view.ViewStub;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.CursorAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.ailauncher.chat.voice.support.C3081a;
import com.stepos.ailauncher.foundation.appui.card.provider.didi.DidiCardProvider;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import com.stepos.widget.R;
import com.stepos.widget.button.StepOSButton;
import com.stepos.widget.glass.GlassEffectResolver;
import com.stepos.widget.list.StepOSListGroup;
import com.stepos.widget.list.StepOSListItem;
import io.requery.android.database.sqlite.SQLiteDatabase;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import v9.C5685n;

@Metadata(d1 = {"\u0000ò\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\r\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b@\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b)\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u0000 ³\u00022\u00020\u0001:\b´\u0002µ\u0002¶\u0002³\u0002B\u001f\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006¢\u0006\u0004\b\b\u0010\tJ\u0011\u0010\u000b\u001a\u0004\u0018\u00010\nH\u0002¢\u0006\u0004\b\u000b\u0010\fJ\u000f\u0010\u000e\u001a\u00020\rH\u0002¢\u0006\u0004\b\u000e\u0010\u000fJ\u000f\u0010\u0010\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0010\u0010\u000fJ\u000f\u0010\u0011\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0011\u0010\u000fJ\u000f\u0010\u0013\u001a\u00020\u0012H\u0003¢\u0006\u0004\b\u0013\u0010\u0014J\u000f\u0010\u0015\u001a\u00020\rH\u0002¢\u0006\u0004\b\u0015\u0010\u000fJ%\u0010\u001a\u001a\u0004\u0018\u00010\u00192\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010\u0018\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ\u0017\u0010\u001c\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u0019H\u0002¢\u0006\u0004\b\u001c\u0010\u001dJ\u0019\u0010\u001f\u001a\u00020\r2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b\u001f\u0010\u001dJ\u000f\u0010 \u001a\u00020\rH\u0002¢\u0006\u0004\b \u0010\u000fJ\u000f\u0010!\u001a\u00020\rH\u0002¢\u0006\u0004\b!\u0010\u000fJ\u0019\u0010#\u001a\u00020\r2\b\u0010\"\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b#\u0010\u001dJ\u001f\u0010%\u001a\u00020\r2\u0006\u0010\"\u001a\u00020\u00192\u0006\u0010$\u001a\u00020\u0012H\u0002¢\u0006\u0004\b%\u0010&J\u0019\u0010(\u001a\u00020\r2\b\u0010'\u001a\u0004\u0018\u00010\u0019H\u0002¢\u0006\u0004\b(\u0010\u001dJ\u000f\u0010)\u001a\u00020\rH\u0002¢\u0006\u0004\b)\u0010\u000fJ!\u0010.\u001a\u00020\r2\u0006\u0010+\u001a\u00020*2\b\u0010-\u001a\u0004\u0018\u00010,H\u0002¢\u0006\u0004\b.\u0010/JI\u00102\u001a\u00020\r2\u0006\u00100\u001a\u00020\u00162\b\u0010\u001e\u001a\u0004\u0018\u00010\u00162\b\u00101\u001a\u0004\u0018\u00010\u00162\b\u0010\"\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00162\b\u0010'\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\b2\u00103J#\u00106\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u00162\b\b\u0001\u00105\u001a\u00020\u0012H\u0002¢\u0006\u0004\b6\u00107J#\u00108\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u00162\b\b\u0001\u00105\u001a\u00020\u0012H\u0002¢\u0006\u0004\b8\u00107J\u0017\u0010;\u001a\u00020:2\u0006\u00109\u001a\u00020\u0012H\u0002¢\u0006\u0004\b;\u0010<J\u001f\u0010>\u001a\u00020\r2\u0006\u0010+\u001a\u00020*2\u0006\u0010=\u001a\u00020:H\u0002¢\u0006\u0004\b>\u0010?J\u0017\u0010@\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0003¢\u0006\u0004\b@\u0010AJ\u0017\u0010B\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0002¢\u0006\u0004\bB\u0010AJ\u0017\u0010C\u001a\u00020\u00122\u0006\u00109\u001a\u00020\u0012H\u0002¢\u0006\u0004\bC\u0010AJ\u000f\u0010D\u001a\u00020\rH\u0002¢\u0006\u0004\bD\u0010\u000fJ\u000f\u0010E\u001a\u00020\rH\u0002¢\u0006\u0004\bE\u0010\u000fJ\u000f\u0010F\u001a\u00020:H\u0002¢\u0006\u0004\bF\u0010GJ\u000f\u0010I\u001a\u00020HH\u0002¢\u0006\u0004\bI\u0010JJ\u000f\u0010K\u001a\u00020\u0012H\u0002¢\u0006\u0004\bK\u0010\u0014J\u000f\u0010L\u001a\u00020:H\u0002¢\u0006\u0004\bL\u0010GJ3\u0010T\u001a\u00020S2\u0018\u0010P\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020O0N0M2\b\u0010R\u001a\u0004\u0018\u00010QH\u0002¢\u0006\u0004\bT\u0010UJ\u0019\u0010V\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\bV\u0010WJ\u001b\u0010Y\u001a\u00020\r2\n\b\u0002\u0010X\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0004\bY\u0010WJ\u0017\u0010\\\u001a\u00020\u00162\u0006\u0010[\u001a\u00020ZH\u0002¢\u0006\u0004\b\\\u0010]J+\u0010a\u001a\u00020\r2\u0006\u00104\u001a\u00020^2\b\u0010_\u001a\u0004\u0018\u00010,2\b\b\u0001\u0010`\u001a\u00020\u0012H\u0002¢\u0006\u0004\ba\u0010bJ\r\u0010c\u001a\u00020\r¢\u0006\u0004\bc\u0010\u000fJ\r\u0010d\u001a\u00020\r¢\u0006\u0004\bd\u0010\u000fJ\u0017\u0010g\u001a\u00020\r2\b\u0010f\u001a\u0004\u0018\u00010e¢\u0006\u0004\bg\u0010hJ\u0017\u0010j\u001a\u00020\r2\b\u0010i\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\bj\u0010WJ\u0017\u0010l\u001a\u00020\r2\b\u0010k\u001a\u0004\u0018\u00010e¢\u0006\u0004\bl\u0010hJ\u0017\u0010o\u001a\u00020\r2\b\u0010n\u001a\u0004\u0018\u00010m¢\u0006\u0004\bo\u0010pJ\u0017\u0010r\u001a\u00020\r2\b\b\u0001\u0010q\u001a\u00020\u0012¢\u0006\u0004\br\u0010sJ\u0017\u0010r\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u0016¢\u0006\u0004\br\u0010WJ7\u0010r\u001a\u00020\r2\b\u00104\u001a\u0004\u0018\u00010\u00162\u0006\u0010t\u001a\u00020\u00122\u0006\u0010u\u001a\u00020\u00122\u0006\u0010v\u001a\u00020\u00122\u0006\u0010w\u001a\u00020\u0012¢\u0006\u0004\br\u0010xJ=\u0010}\u001a\u00020\r2\u0006\u0010y\u001a\u00020\u00122\b\u0010z\u001a\u0004\u0018\u00010e2\b\u0010R\u001a\u0004\u0018\u00010Q2\b\u0010|\u001a\u0004\u0018\u00010{2\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0004\b}\u0010~J\u0015\u0010\u007f\u001a\u00020\r2\u0006\u0010`\u001a\u00020\u0012¢\u0006\u0004\b\u007f\u0010sJ\u0018\u0010\u007f\u001a\u00020\r2\b\u0010-\u001a\u0004\u0018\u00010,¢\u0006\u0005\b\u007f\u0010\u0080\u0001J\u0018\u0010\u0082\u0001\u001a\u00020\u00122\u0007\u0010\u0081\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u0082\u0001\u0010AJ\u001a\u0010\u0083\u0001\u001a\u0004\u0018\u00010*2\u0006\u0010y\u001a\u00020\u0012¢\u0006\u0006\b\u0083\u0001\u0010\u0084\u0001J\u001a\u0010\u0087\u0001\u001a\u00020:2\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001¢\u0006\u0006\b\u0087\u0001\u0010\u0088\u0001J\u001a\u0010\u0089\u0001\u001a\u00020:2\b\u0010\u0086\u0001\u001a\u00030\u0085\u0001¢\u0006\u0006\b\u0089\u0001\u0010\u0088\u0001J\u001a\u0010\u008b\u0001\u001a\u00020\r2\t\b\u0001\u0010\u008a\u0001\u001a\u00020\u0012¢\u0006\u0005\b\u008b\u0001\u0010sJ!\u0010\u008d\u0001\u001a\u00020\r2\u0006\u0010y\u001a\u00020\u00122\u0007\u0010\u008c\u0001\u001a\u00020\u0012¢\u0006\u0006\b\u008d\u0001\u0010\u008e\u0001J!\u0010\u0090\u0001\u001a\u00020\r2\u0006\u0010y\u001a\u00020\u00122\u0007\u0010\u008f\u0001\u001a\u00020\u0012¢\u0006\u0006\b\u0090\u0001\u0010\u008e\u0001J\u0019\u0010\u0092\u0001\u001a\u00020\r2\u0007\u0010\u0091\u0001\u001a\u00020:¢\u0006\u0006\b\u0092\u0001\u0010\u0093\u0001J<\u0010\u0098\u0001\u001a\u00020\r2\t\b\u0001\u0010\u0094\u0001\u001a\u00020\u00122\t\b\u0001\u0010\u0095\u0001\u001a\u00020\u00122\t\b\u0001\u0010\u0096\u0001\u001a\u00020\u00122\t\b\u0001\u0010\u0097\u0001\u001a\u00020\u0012¢\u0006\u0006\b\u0098\u0001\u0010\u0099\u0001J\u000f\u0010\u009a\u0001\u001a\u00020\r¢\u0006\u0005\b\u009a\u0001\u0010\u000fJ\u0018\u0010\u009b\u0001\u001a\u00020\r2\u0006\u0010[\u001a\u00020Z¢\u0006\u0006\b\u009b\u0001\u0010\u009c\u0001J\u0018\u0010\u009d\u0001\u001a\u00020\r2\u0006\u0010[\u001a\u00020Z¢\u0006\u0006\b\u009d\u0001\u0010\u009c\u0001J\u0018\u0010\u009e\u0001\u001a\u00020\r2\u0006\u0010[\u001a\u00020Z¢\u0006\u0006\b\u009e\u0001\u0010\u009c\u0001JQ\u0010¢\u0001\u001a\u00020\r25\u0010¡\u0001\u001a0\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020O0N\u0018\u00010\u009f\u0001j\u0017\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020O0N\u0018\u0001` \u00012\b\u0010R\u001a\u0004\u0018\u00010Q¢\u0006\u0006\b¢\u0001\u0010£\u0001J\u0018\u0010¤\u0001\u001a\u00020\r2\u0006\u0010[\u001a\u00020Z¢\u0006\u0006\b¤\u0001\u0010\u009c\u0001Je\u0010¬\u0001\u001a\u00020\r2\t\u0010¥\u0001\u001a\u0004\u0018\u00010,2\t\b\u0001\u0010¦\u0001\u001a\u00020\u00122\t\u0010§\u0001\u001a\u0004\u0018\u00010e2\t\u0010¨\u0001\u001a\u0004\u0018\u00010,2\t\b\u0001\u0010©\u0001\u001a\u00020\u00122\t\u0010ª\u0001\u001a\u0004\u0018\u00010e2\u0007\u0010«\u0001\u001a\u00020\u00122\b\u0010R\u001a\u0004\u0018\u00010Q¢\u0006\u0006\b¬\u0001\u0010\u00ad\u0001R\u0015\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0003\u0010®\u0001R\u0015\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0005\u0010¯\u0001R\u0015\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0007\n\u0005\b\u0007\u0010°\u0001R\u0017\u0010±\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b±\u0001\u0010²\u0001R\u0017\u0010³\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b³\u0001\u0010²\u0001R\u0017\u0010´\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b´\u0001\u0010²\u0001R\u0017\u0010µ\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\bµ\u0001\u0010²\u0001R\u0017\u0010¶\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¶\u0001\u0010²\u0001R\u0017\u0010·\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b·\u0001\u0010²\u0001R\u0017\u0010¸\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¸\u0001\u0010²\u0001R\u0017\u0010¹\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¹\u0001\u0010²\u0001R\u0017\u0010º\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\bº\u0001\u0010²\u0001R\u0017\u0010»\u0001\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b»\u0001\u0010²\u0001R\u0017\u0010¼\u0001\u001a\u00020:8\u0002X\u0082\u0004¢\u0006\b\n\u0006\b¼\u0001\u0010½\u0001R\u0019\u0010¾\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b¾\u0001\u0010½\u0001R\u0019\u0010¿\u0001\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b¿\u0001\u0010²\u0001R\u0019\u0010À\u0001\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÀ\u0001\u0010²\u0001R\u0019\u0010Á\u0001\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÁ\u0001\u0010²\u0001R\u0019\u0010Â\u0001\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÂ\u0001\u0010²\u0001R\u0019\u0010f\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bf\u0010Ã\u0001R\u0019\u0010k\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bk\u0010Ã\u0001R\u0019\u0010i\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\bi\u0010Ä\u0001R\u001b\u0010Å\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÅ\u0001\u0010Ä\u0001R\u0019\u0010Æ\u0001\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\bÆ\u0001\u0010²\u0001R\u0019\u0010Ç\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÇ\u0001\u0010²\u0001R\u0019\u0010È\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÈ\u0001\u0010²\u0001R\u0019\u0010É\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÉ\u0001\u0010²\u0001R\u0019\u0010Ê\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÊ\u0001\u0010²\u0001R\u0019\u0010Ë\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bË\u0001\u0010½\u0001R\u0019\u0010Ì\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÌ\u0001\u0010½\u0001R\u0019\u0010Í\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÍ\u0001\u0010½\u0001R\u0019\u0010Î\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÎ\u0001\u0010½\u0001R\u0019\u0010Ï\u0001\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÏ\u0001\u0010½\u0001R\u0019\u0010Ð\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÐ\u0001\u0010²\u0001R\u001b\u0010Ñ\u0001\u001a\u0004\u0018\u00010Q8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÑ\u0001\u0010Ò\u0001R\u001b\u0010Ó\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÓ\u0001\u0010Ä\u0001R1\u0010Õ\u0001\u001a\u00020:2\u0007\u0010Ô\u0001\u001a\u00020:8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\bÕ\u0001\u0010½\u0001\u001a\u0005\bÖ\u0001\u0010G\"\u0006\b×\u0001\u0010\u0093\u0001R\u001b\u0010Ø\u0001\u001a\u0004\u0018\u00010\u00168\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bØ\u0001\u0010Ä\u0001R\u0019\u0010Ù\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÙ\u0001\u0010²\u0001R\u0019\u0010-\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\u0007\n\u0005\b-\u0010Ú\u0001R6\u0010Û\u0001\u001a\u0004\u0018\u00010,2\t\u0010Ô\u0001\u001a\u0004\u0018\u00010,8\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\bÛ\u0001\u0010Ú\u0001\u001a\u0006\bÜ\u0001\u0010Ý\u0001\"\u0006\bÞ\u0001\u0010\u0080\u0001R\u001b\u0010ß\u0001\u001a\u0004\u0018\u00010^8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bß\u0001\u0010à\u0001R\u001c\u0010â\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bâ\u0001\u0010ã\u0001R\u001c\u0010ä\u0001\u001a\u0005\u0018\u00010á\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bä\u0001\u0010ã\u0001R\u001b\u0010å\u0001\u001a\u0004\u0018\u00010m8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bå\u0001\u0010æ\u0001R\u001c\u0010è\u0001\u001a\u0005\u0018\u00010ç\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bè\u0001\u0010é\u0001R0\u0010ë\u0001\u001a\u0005\u0018\u00010ê\u00012\n\u0010Ô\u0001\u001a\u0005\u0018\u00010ê\u00018\u0006@BX\u0086\u000e¢\u0006\u0010\n\u0006\bë\u0001\u0010ì\u0001\u001a\u0006\bí\u0001\u0010î\u0001R\u001c\u0010ð\u0001\u001a\u0005\u0018\u00010ï\u00018\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bð\u0001\u0010ñ\u0001R\u0019\u0010ò\u0001\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bò\u0001\u0010²\u0001R(\u0010ó\u0001\u001a\u00020:8\u0006@\u0006X\u0086\u000e¢\u0006\u0017\n\u0006\bó\u0001\u0010½\u0001\u001a\u0005\bó\u0001\u0010G\"\u0006\bô\u0001\u0010\u0093\u0001R'\u0010õ\u0001\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\bõ\u0001\u0010²\u0001\u001a\u0005\bö\u0001\u0010\u0014\"\u0005\b÷\u0001\u0010sR\u001b\u0010ø\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bø\u0001\u0010ù\u0001R\u001b\u0010ú\u0001\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bú\u0001\u0010Ã\u0001R\u001b\u0010û\u0001\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bû\u0001\u0010ü\u0001R\u001b\u0010ý\u0001\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bý\u0001\u0010Ú\u0001R\u001b\u0010þ\u0001\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bþ\u0001\u0010ù\u0001R\u001b\u0010ÿ\u0001\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\bÿ\u0001\u0010Ã\u0001R\u001b\u0010\u0080\u0002\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0080\u0002\u0010ü\u0001R\u001b\u0010\u0081\u0002\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0081\u0002\u0010Ú\u0001R\u001b\u0010\u0082\u0002\u001a\u0004\u0018\u00010*8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0082\u0002\u0010ù\u0001R\u001b\u0010\u0083\u0002\u001a\u0004\u0018\u00010e8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0083\u0002\u0010Ã\u0001R\u001b\u0010\u0084\u0002\u001a\u0004\u0018\u00010{8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0084\u0002\u0010ü\u0001R\u001b\u0010\u0085\u0002\u001a\u0004\u0018\u00010,8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u0085\u0002\u0010Ú\u0001R'\u0010\u0086\u0002\u001a\u00020\u00128\u0006@\u0006X\u0086\u000e¢\u0006\u0016\n\u0006\b\u0086\u0002\u0010²\u0001\u001a\u0005\b\u0087\u0002\u0010\u0014\"\u0005\b\u0088\u0002\u0010sR\u0019\u0010\u0089\u0002\u001a\u00020\u00128\u0002@\u0002X\u0083\u000e¢\u0006\b\n\u0006\b\u0089\u0002\u0010²\u0001R\u0019\u0010\u008a\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008a\u0002\u0010²\u0001R\u0019\u0010\u008b\u0002\u001a\u00020\u00128\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008b\u0002\u0010²\u0001R\u0019\u0010\u008c\u0002\u001a\u00020:8\u0002@\u0002X\u0082\u000e¢\u0006\b\n\u0006\b\u008c\u0002\u0010½\u0001R0\u0010\u008d\u0002\u001a\u00020\u00122\u0007\u0010Ô\u0001\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u008d\u0002\u0010²\u0001\u001a\u0005\b\u008e\u0002\u0010\u0014\"\u0005\b\u008f\u0002\u0010sR0\u0010\u0090\u0002\u001a\u00020\u00122\u0007\u0010Ô\u0001\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u0016\n\u0006\b\u0090\u0002\u0010²\u0001\u001a\u0005\b\u0091\u0002\u0010\u0014\"\u0005\b\u0092\u0002\u0010sR7\u0010\u0093\u0002\u001a\u00020\u00122\u0007\u0010Ô\u0001\u001a\u00020\u00128\u0006@FX\u0086\u000e¢\u0006\u001d\n\u0006\b\u0093\u0002\u0010²\u0001\u0012\u0005\b\u0096\u0002\u0010\u000f\u001a\u0005\b\u0094\u0002\u0010\u0014\"\u0005\b\u0095\u0002\u0010sR1\u0010\u0097\u0002\u001a\u00020:2\u0007\u0010Ô\u0001\u001a\u00020:8\u0006@FX\u0086\u000e¢\u0006\u0017\n\u0006\b\u0097\u0002\u0010½\u0001\u001a\u0005\b\u0097\u0002\u0010G\"\u0006\b\u0098\u0002\u0010\u0093\u0001R8\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u0099\u00022\n\u0010Ô\u0001\u001a\u0005\u0018\u00010\u0099\u00028\u0006@FX\u0086\u000e¢\u0006\u0018\n\u0006\b\u009a\u0002\u0010\u009b\u0002\u001a\u0006\b\u009c\u0002\u0010\u009d\u0002\"\u0006\b\u009e\u0002\u0010\u009f\u0002R\u0017\u0010 \u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b \u0002\u0010²\u0001R\u0017\u0010¡\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¡\u0002\u0010²\u0001R\u0017\u0010¢\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¢\u0002\u0010²\u0001R\u0017\u0010£\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b£\u0002\u0010²\u0001R\u0017\u0010¤\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¤\u0002\u0010²\u0001R\u0017\u0010¥\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¥\u0002\u0010²\u0001R\u0017\u0010¦\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¦\u0002\u0010²\u0001R\u0017\u0010§\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b§\u0002\u0010²\u0001R\u0017\u0010¨\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¨\u0002\u0010²\u0001R\u0017\u0010©\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b©\u0002\u0010²\u0001R\u0017\u0010ª\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\bª\u0002\u0010²\u0001R\u0017\u0010«\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b«\u0002\u0010²\u0001R\u0017\u0010¬\u0002\u001a\u00020\u00128\u0002X\u0083\u0004¢\u0006\b\n\u0006\b¬\u0002\u0010²\u0001R\u0018\u0010®\u0002\u001a\u00030\u00ad\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b®\u0002\u0010¯\u0002R\u0018\u0010±\u0002\u001a\u00030°\u00028\u0002X\u0082\u0004¢\u0006\b\n\u0006\b±\u0002\u0010²\u0002¨\u0006·\u0002"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertController;", "", "Landroid/content/Context;", "context", "Lcom/stepos/widget/dialog/StepOSAlertDialog;", C3081a.FOCUS_DIALOG_NAME, "Landroid/view/Window;", "window", "<init>", "(Landroid/content/Context;Lcom/stepos/widget/dialog/StepOSAlertDialog;Landroid/view/Window;)V", "Lcom/stepos/widget/dialog/StepOSAlertDialogLayout;", "dialogPanel", "()Lcom/stepos/widget/dialog/StepOSAlertDialogLayout;", "LY8/t;", "clearListItemsMode", "()V", "clearIconContentMode", "refreshCustomContent", "", "defaultMaxHeight", "()I", "setupView", "Landroid/view/View;", "customPanel", "defaultPanel", "Landroid/view/ViewGroup;", "resolvePanel", "(Landroid/view/View;Landroid/view/View;)Landroid/view/ViewGroup;", "setupCustomContent", "(Landroid/view/ViewGroup;)V", "topPanel", "setupTitle", "refreshHeader", "refreshSectionGaps", "contentPanel", "setupContent", "indicators", "setScrollIndicators", "(Landroid/view/ViewGroup;I)V", "buttonPanel", "setupButtons", "refreshButtons", "Lcom/stepos/widget/button/StepOSButton;", "button", "Landroid/graphics/drawable/Drawable;", "icon", "applyButtonIcon", "(Lcom/stepos/widget/button/StepOSButton;Landroid/graphics/drawable/Drawable;)V", "parentPanel", "middlePanel", "setupSectionGaps", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "view", "margin", "setBottomMargin", "(Landroid/view/View;I)V", "setTopMargin", "whichButtons", "", "isButtonLayoutVertical", "(I)Z", "isHighlight", "applyButtonEmphasis", "(Lcom/stepos/widget/button/StepOSButton;Z)V", "calcButtonWidth", "(I)I", "calcButtonCount", "calcButtonHighLight", "applyStepOSStyle", "applyWindowInsetsPolicy", "hasEditText", "()Z", "", "computeDialogHeightRatio", "()D", "visibleButtonBits", "isButtonBarVertical", "", "Landroid/util/Pair;", "", "entries", "Landroid/content/DialogInterface$OnClickListener;", "listener", "Lcom/stepos/widget/list/StepOSListGroup;", "buildListItemsGroup", "(Ljava/util/List;Landroid/content/DialogInterface$OnClickListener;)Lcom/stepos/widget/list/StepOSListGroup;", "hideSystemVerticalScrollbar", "(Landroid/view/View;)V", "host", "applyListItemsScrollbar", "Lcom/stepos/widget/dialog/StepOSAlertParams;", "params", "buildIconContentView", "(Lcom/stepos/widget/dialog/StepOSAlertParams;)Landroid/view/View;", "Landroid/widget/ImageView;", "drawable", "resId", "bindIcon", "(Landroid/widget/ImageView;Landroid/graphics/drawable/Drawable;I)V", "installContent", "clearPendingMessages", "", "title", "setTitle", "(Ljava/lang/CharSequence;)V", "customTitleView", "setCustomTitle", "message", "setMessage", "Landroid/text/method/MovementMethod;", "movementMethod", "setMessageMovementMethod", "(Landroid/text/method/MovementMethod;)V", "layoutResId", "setView", "(I)V", "left", "top", "right", "bottom", "(Landroid/view/View;IIII)V", "whichButton", "text", "Landroid/os/Message;", "msg", "setButton", "(ILjava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;Landroid/os/Message;Landroid/graphics/drawable/Drawable;)V", "setIcon", "(Landroid/graphics/drawable/Drawable;)V", "attrId", "getIconAttributeResId", "getButton", "(I)Lcom/stepos/widget/button/StepOSButton;", "Landroid/view/KeyEvent;", "event", "onKeyDown", "(Landroid/view/KeyEvent;)Z", "onKeyUp", "height", "setMaxHeight", "color", "setHighLightButton", "(II)V", "colorResId", "setButtonTextColor", "show", "setAutoShowSoftInput", "(Z)V", "space1", "space2", "space3", "space4", "setCustomPaddingRule", "(IIII)V", "setUpAnimation", "createListView", "(Lcom/stepos/widget/dialog/StepOSAlertParams;)V", "createMultiLinesView", "createListItemsView", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", DidiCardProvider.KEY_ITEMS, "setListItems", "(Ljava/util/ArrayList;Landroid/content/DialogInterface$OnClickListener;)V", "createIconContentView", "leftIcon", "leftIconRes", "leftLabel", "rightIcon", "rightIconRes", "rightLabel", "selectedIndex", "setIconContent", "(Landroid/graphics/drawable/Drawable;ILjava/lang/CharSequence;Landroid/graphics/drawable/Drawable;ILjava/lang/CharSequence;ILandroid/content/DialogInterface$OnClickListener;)V", "Landroid/content/Context;", "Lcom/stepos/widget/dialog/StepOSAlertDialog;", "Landroid/view/Window;", "dialogLayout", "I", "listLayout", "listItemLayout", "singleChoiceItemLayout", "multiChoiceItemLayout", "centerListItemLayout", "multiLinesChoiceLayout", "multiLinesItemLayout", "multiLinesSingleItemLayout", "buttonIconSize", "isActionStyle", "Z", "useCustomPadding", "customSpace1", "customSpace2", "customSpace3", "customSpace4", "Ljava/lang/CharSequence;", "Landroid/view/View;", "contentView", "contentViewLayoutResId", "viewSpacingLeft", "viewSpacingTop", "viewSpacingRight", "viewSpacingBottom", "viewSpacingSpecified", "hasCustomView", "contentInstalled", "hasListItemsContent", "hasIconContent", "iconContentSelectedIndex", "iconContentListener", "Landroid/content/DialogInterface$OnClickListener;", "iconContentRoot", UxipConstants.f30680s, "listItemsScrollbarEnabled", "getListItemsScrollbarEnabled", "setListItemsScrollbarEnabled", "installedCustomView", "iconResId", "Landroid/graphics/drawable/Drawable;", "iconBadge", "getIconBadge", "()Landroid/graphics/drawable/Drawable;", "setIconBadge", "iconView", "Landroid/widget/ImageView;", "Landroid/widget/TextView;", "titleView", "Landroid/widget/TextView;", "messageView", "messageMovementMethod", "Landroid/text/method/MovementMethod;", "Landroidx/core/widget/NestedScrollView;", "scrollView", "Landroidx/core/widget/NestedScrollView;", "Landroid/widget/ListView;", "listView", "Landroid/widget/ListView;", "getListView", "()Landroid/widget/ListView;", "Landroid/widget/ListAdapter;", "adapter", "Landroid/widget/ListAdapter;", "checkedItem", "isMultiLines", "setMultiLines", "multiLinesItemCount", "getMultiLinesItemCount", "setMultiLinesItemCount", "buttonPositive", "Lcom/stepos/widget/button/StepOSButton;", "buttonPositiveText", "buttonPositiveMessage", "Landroid/os/Message;", "buttonPositiveIcon", "buttonNegative", "buttonNegativeText", "buttonNegativeMessage", "buttonNegativeIcon", "buttonNeutral", "buttonNeutralText", "buttonNeutralMessage", "buttonNeutralIcon", "gravity", "getGravity", "setGravity", "maxHeight", "highLightButton", "highLightColor", "autoShowSoftInput", "titleMaxLines", "getTitleMaxLines", "setTitleMaxLines", "messageMaxLines", "getMessageMaxLines", "setMessageMaxLines", "buttonLayout", "getButtonLayout", "setButtonLayout", "getButtonLayout$annotations", "isGlassEnabled", "setGlassEnabled", "Ly7/o;", "glassEffect", "Ly7/o;", "getGlassEffect", "()Ly7/o;", "setGlassEffect", "(Ly7/o;)V", "dialogWidth", "screenMargin", "screenMarginBottom", "horizontalPadding", "topPadding", "bottomPadding", "sectionGap", "messageCustomGap", "buttonSpacing", "buttonWordPadding", "buttonHeight", "listItemSpacing", "listChoicePadding", "Landroid/os/Handler;", "handler", "Landroid/os/Handler;", "Landroid/view/View$OnClickListener;", "buttonClickListener", "Landroid/view/View$OnClickListener;", "Companion", "MultiChoiceArrayAdapter", "MultiChoiceCursorAdapter", "ButtonHandler", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes4.dex */
public final class StepOSAlertController {
    private static final int BIT_BUTTON_NEGATIVE = 2;
    private static final int BIT_BUTTON_NEUTRAL = 4;
    private static final int BIT_BUTTON_POSITIVE = 1;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final double DIALOG_MEDIUM = 0.65d;
    private static final double DIALOG_SMALL = 0.33d;
    private static final double MAX_HEIGHT_SCREEN_RATIO = 0.6d;
    private static final int MSG_DISMISS_DIALOG = 1;
    private ListAdapter adapter;
    private boolean autoShowSoftInput;
    private final int bottomPadding;
    private final View.OnClickListener buttonClickListener;
    private final int buttonHeight;
    private final int buttonIconSize;
    private int buttonLayout;
    private StepOSButton buttonNegative;
    private Drawable buttonNegativeIcon;
    private Message buttonNegativeMessage;
    private CharSequence buttonNegativeText;
    private StepOSButton buttonNeutral;
    private Drawable buttonNeutralIcon;
    private Message buttonNeutralMessage;
    private CharSequence buttonNeutralText;
    private StepOSButton buttonPositive;
    private Drawable buttonPositiveIcon;
    private Message buttonPositiveMessage;
    private CharSequence buttonPositiveText;
    private final int buttonSpacing;
    private final int buttonWordPadding;
    private final int centerListItemLayout;
    private int checkedItem;
    private boolean contentInstalled;
    private View contentView;
    private int contentViewLayoutResId;
    private final Context context;
    private int customSpace1;
    private int customSpace2;
    private int customSpace3;
    private int customSpace4;
    private View customTitleView;
    private final StepOSAlertDialog dialog;
    private final int dialogLayout;
    private final int dialogWidth;
    private y7.o glassEffect;
    private int gravity;
    private final Handler handler;
    private boolean hasCustomView;
    private boolean hasIconContent;
    private boolean hasListItemsContent;
    private int highLightButton;
    private int highLightColor;
    private final int horizontalPadding;
    private Drawable icon;
    private Drawable iconBadge;
    private DialogInterface.OnClickListener iconContentListener;
    private View iconContentRoot;
    private int iconContentSelectedIndex;
    private int iconResId;
    private ImageView iconView;
    private View installedCustomView;
    private final boolean isActionStyle;
    private boolean isGlassEnabled;
    private boolean isMultiLines;
    private final int listChoicePadding;
    private final int listItemLayout;
    private final int listItemSpacing;
    private boolean listItemsScrollbarEnabled;
    private final int listLayout;
    private ListView listView;
    private int maxHeight;
    private CharSequence message;
    private final int messageCustomGap;
    private int messageMaxLines;
    private MovementMethod messageMovementMethod;
    private TextView messageView;
    private final int multiChoiceItemLayout;
    private final int multiLinesChoiceLayout;
    private int multiLinesItemCount;
    private final int multiLinesItemLayout;
    private final int multiLinesSingleItemLayout;
    private final int screenMargin;
    private final int screenMarginBottom;
    private NestedScrollView scrollView;
    private final int sectionGap;
    private final int singleChoiceItemLayout;
    private CharSequence title;
    private int titleMaxLines;
    private TextView titleView;
    private final int topPadding;
    private boolean useCustomPadding;
    private int viewSpacingBottom;
    private int viewSpacingLeft;
    private int viewSpacingRight;
    private boolean viewSpacingSpecified;
    private int viewSpacingTop;
    private final Window window;

    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016¢\u0006\u0004\b\t\u0010\nR\"\u0010\r\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00010\u00020\u00020\u000b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertController$ButtonHandler;", "Landroid/os/Handler;", "Landroid/content/DialogInterface;", C3081a.FOCUS_DIALOG_NAME, "<init>", "(Landroid/content/DialogInterface;)V", "Landroid/os/Message;", "msg", "LY8/t;", "handleMessage", "(Landroid/os/Message;)V", "Ljava/lang/ref/WeakReference;", "kotlin.jvm.PlatformType", "dialogRef", "Ljava/lang/ref/WeakReference;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class ButtonHandler extends Handler {
        private final WeakReference<DialogInterface> dialogRef;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public ButtonHandler(DialogInterface dialog) {
            super(Looper.getMainLooper());
            kotlin.jvm.internal.p.i(dialog, "dialog");
            this.dialogRef = new WeakReference<>(dialog);
        }

        @Override // android.os.Handler
        public void handleMessage(Message msg) {
            kotlin.jvm.internal.p.i(msg, "msg");
            int i10 = msg.what;
            if (i10 != -3 && i10 != -2 && i10 != -1) {
                if (i10 != 1) {
                    return;
                }
                Object obj = msg.obj;
                DialogInterface dialogInterface = obj instanceof DialogInterface ? (DialogInterface) obj : null;
                if (dialogInterface != null) {
                    dialogInterface.dismiss();
                    return;
                }
                return;
            }
            DialogInterface dialogInterface2 = this.dialogRef.get();
            if (dialogInterface2 == null) {
                return;
            }
            Object obj2 = msg.obj;
            DialogInterface.OnClickListener onClickListener = obj2 instanceof DialogInterface.OnClickListener ? (DialogInterface.OnClickListener) obj2 : null;
            if (onClickListener == null) {
                return;
            }
            onClickListener.onClick(dialogInterface2, msg.what);
        }
    }

    @Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0005\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J+\u0010\t\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00042\b\u0010\u0006\u001a\u0004\u0018\u00010\u00042\b\u0010\u0007\u001a\u0004\u0018\u00010\u0004H\u0002¢\u0006\u0004\b\t\u0010\nR\u0014\u0010\f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000e\u0010\rR\u0014\u0010\u000f\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u000f\u0010\rR\u0014\u0010\u0010\u001a\u00020\u000b8\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0010\u0010\rR\u0014\u0010\u0012\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0012\u0010\u0013R\u0014\u0010\u0014\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0014\u0010\u0013R\u0014\u0010\u0015\u001a\u00020\u00118\u0002X\u0082T¢\u0006\u0006\n\u0004\b\u0015\u0010\u0013¨\u0006\u0016"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertController$Companion;", "", "<init>", "()V", "Landroid/view/View;", "v", "up", "down", "LY8/t;", "manageScrollIndicators", "(Landroid/view/View;Landroid/view/View;Landroid/view/View;)V", "", "BIT_BUTTON_POSITIVE", "I", "BIT_BUTTON_NEGATIVE", "BIT_BUTTON_NEUTRAL", "MSG_DISMISS_DIALOG", "", "DIALOG_SMALL", "D", "DIALOG_MEDIUM", "MAX_HEIGHT_SCREEN_RATIO", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(kotlin.jvm.internal.i iVar) {
            this();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final void manageScrollIndicators(View v10, View up, View down) {
            if (up != null) {
                up.setVisibility(v10.canScrollVertically(-1) ? 0 : 4);
            }
            if (down != null) {
                down.setVisibility(v10.canScrollVertically(1) ? 0 : 4);
            }
        }

        private Companion() {
        }
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B;\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006\u0012\u000e\u0010\u0007\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\b\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0004\b\r\u0010\u000eJ\"\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0013\u001a\u00020\u0014H\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertController$MultiChoiceArrayAdapter;", "Landroid/widget/ArrayAdapter;", "", "context", "Landroid/content/Context;", "layout", "", "entries", "", "checkedItems", "", "listView", "Landroid/widget/ListView;", "<init>", "(Landroid/content/Context;I[Ljava/lang/CharSequence;[ZLandroid/widget/ListView;)V", "getView", "Landroid/view/View;", "position", "convertView", "parent", "Landroid/view/ViewGroup;", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MultiChoiceArrayAdapter extends ArrayAdapter<CharSequence> {
        private final boolean[] checkedItems;
        private final ListView listView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiChoiceArrayAdapter(Context context, int i10, CharSequence[] entries, boolean[] zArr, ListView listView) {
            super(context, i10, R.id.stepos_dialog_list_item_text, entries);
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(entries, "entries");
            kotlin.jvm.internal.p.i(listView, "listView");
            this.checkedItems = zArr;
            this.listView = listView;
        }

        @Override // android.widget.ArrayAdapter, android.widget.Adapter
        public View getView(int position, View convertView, ViewGroup parent) {
            kotlin.jvm.internal.p.i(parent, "parent");
            View view = super.getView(position, convertView, parent);
            kotlin.jvm.internal.p.h(view, "getView(...)");
            boolean[] zArr = this.checkedItems;
            if (zArr != null ? kotlin.jvm.internal.p.d(r.g0(zArr, position), Boolean.TRUE) : false) {
                this.listView.setItemChecked(position, true);
            }
            return view;
        }
    }

    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0002\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0006\u0010\u0007\u001a\u00020\u0006\u0012\b\b\u0001\u0010\t\u001a\u00020\b\u0012\u0006\u0010\u000b\u001a\u00020\n\u0012\u0006\u0010\f\u001a\u00020\n\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J'\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016¢\u0006\u0004\b\u0014\u0010\u0015J'\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0016H\u0016¢\u0006\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0007\u001a\u00020\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\u001aR\u0014\u0010\t\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u0010\u001bR\u0014\u0010\u000e\u001a\u00020\r8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u0010\u001cR\u0014\u0010\u001d\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001d\u0010\u001bR\u0014\u0010\u001e\u001a\u00020\b8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u001e\u0010\u001b¨\u0006\u001f"}, d2 = {"Lcom/stepos/widget/dialog/StepOSAlertController$MultiChoiceCursorAdapter;", "Landroid/widget/CursorAdapter;", "Landroid/content/Context;", "context", "Landroid/database/Cursor;", "cursor", "Landroid/view/LayoutInflater;", "inflater", "", "itemLayout", "", "labelColumn", "isCheckedColumn", "Landroid/widget/ListView;", "listView", "<init>", "(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/LayoutInflater;ILjava/lang/String;Ljava/lang/String;Landroid/widget/ListView;)V", "Landroid/view/View;", "view", "LY8/t;", "bindView", "(Landroid/view/View;Landroid/content/Context;Landroid/database/Cursor;)V", "Landroid/view/ViewGroup;", "parent", "newView", "(Landroid/content/Context;Landroid/database/Cursor;Landroid/view/ViewGroup;)Landroid/view/View;", "Landroid/view/LayoutInflater;", "I", "Landroid/widget/ListView;", "labelIndex", "isCheckedIndex", "StepOSWidget_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class MultiChoiceCursorAdapter extends CursorAdapter {
        private final LayoutInflater inflater;
        private final int isCheckedIndex;
        private final int itemLayout;
        private final int labelIndex;
        private final ListView listView;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public MultiChoiceCursorAdapter(Context context, Cursor cursor, LayoutInflater inflater, int i10, String labelColumn, String isCheckedColumn, ListView listView) {
            super(context, cursor, false);
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(cursor, "cursor");
            kotlin.jvm.internal.p.i(inflater, "inflater");
            kotlin.jvm.internal.p.i(labelColumn, "labelColumn");
            kotlin.jvm.internal.p.i(isCheckedColumn, "isCheckedColumn");
            kotlin.jvm.internal.p.i(listView, "listView");
            this.inflater = inflater;
            this.itemLayout = i10;
            this.listView = listView;
            this.labelIndex = cursor.getColumnIndexOrThrow(labelColumn);
            this.isCheckedIndex = cursor.getColumnIndexOrThrow(isCheckedColumn);
        }

        @Override // android.widget.CursorAdapter
        public void bindView(View view, Context context, Cursor cursor) {
            kotlin.jvm.internal.p.i(view, "view");
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(cursor, "cursor");
            ((CheckedTextView) view.findViewById(R.id.stepos_dialog_list_item_text)).setText(cursor.getString(this.labelIndex));
            this.listView.setItemChecked(cursor.getPosition(), cursor.getInt(this.isCheckedIndex) == 1);
        }

        @Override // android.widget.CursorAdapter
        public View newView(Context context, Cursor cursor, ViewGroup parent) {
            kotlin.jvm.internal.p.i(context, "context");
            kotlin.jvm.internal.p.i(cursor, "cursor");
            kotlin.jvm.internal.p.i(parent, "parent");
            View viewInflate = this.inflater.inflate(this.itemLayout, parent, false);
            kotlin.jvm.internal.p.h(viewInflate, "inflate(...)");
            return viewInflate;
        }
    }

    public StepOSAlertController(Context context, StepOSAlertDialog dialog, Window window) throws Resources.NotFoundException {
        kotlin.jvm.internal.p.i(context, "context");
        kotlin.jvm.internal.p.i(dialog, "dialog");
        kotlin.jvm.internal.p.i(window, "window");
        this.context = context;
        this.dialog = dialog;
        this.window = window;
        this.listItemsScrollbarEnabled = true;
        this.checkedItem = -1;
        this.highLightColor = 1;
        this.autoShowSoftInput = true;
        this.titleMaxLines = 2;
        this.messageMaxLines = 2;
        this.isGlassEnabled = true;
        this.handler = new ButtonHandler(dialog);
        this.buttonClickListener = new View.OnClickListener() { // from class: com.stepos.widget.dialog.i
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSAlertController.buttonClickListener$lambda$3(this.f31185a, view);
            }
        };
        Resources resources = context.getResources();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(null, R.styleable.StepOSAlertDialog, R.attr.steposAlertDialogStyle, R.style.StepOSWidget_AlertDialog);
        kotlin.jvm.internal.p.h(typedArrayObtainStyledAttributes, "obtainStyledAttributes(...)");
        try {
            this.dialogLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogLayout, R.layout.stepos_dialog_alert);
            this.listLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogListLayout, R.layout.stepos_dialog_select_list);
            this.listItemLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogListItemLayout, R.layout.stepos_dialog_select_item);
            this.singleChoiceItemLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogSingleChoiceItemLayout, R.layout.stepos_dialog_select_item_single);
            this.multiChoiceItemLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogMultiChoiceItemLayout, R.layout.stepos_dialog_select_item_multi);
            this.centerListItemLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogCenterListItemLayout, R.layout.stepos_dialog_select_item_center);
            this.multiLinesChoiceLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogMultiLinesChoiceLayout, R.layout.stepos_dialog_select_recycler);
            this.multiLinesItemLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogMultiLinesItemLayout, R.layout.stepos_dialog_multi_line_item);
            this.multiLinesSingleItemLayout = typedArrayObtainStyledAttributes.getResourceId(R.styleable.StepOSAlertDialog_steposDialogMultiLinesSingleItemLayout, R.layout.stepos_dialog_multi_line_item_single);
            this.buttonIconSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSAlertDialog_steposDialogButtonIconSize, resources.getDimensionPixelSize(R.dimen.stepos_dialog_button_icon_size));
            this.isActionStyle = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSAlertDialog_steposDialogActionStyle, false);
            this.useCustomPadding = typedArrayObtainStyledAttributes.getBoolean(R.styleable.StepOSAlertDialog_steposDialogCustomGaps, false);
            this.customSpace1 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSAlertDialog_steposDialogGapTop, 0);
            this.customSpace2 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSAlertDialog_steposDialogGapTitle, 0);
            this.customSpace3 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSAlertDialog_steposDialogGapContent, 0);
            this.customSpace4 = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.StepOSAlertDialog_steposDialogGapBottom, 0);
            setGlassEffect(GlassEffectResolver.INSTANCE.read$StepOSWidget_release(typedArrayObtainStyledAttributes, R.styleable.StepOSAlertDialog_steposGlassEffect));
            typedArrayObtainStyledAttributes.recycle();
            int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_margin_screen);
            this.screenMargin = dimensionPixelOffset;
            this.screenMarginBottom = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_margin_screen_bottom);
            this.horizontalPadding = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_padding_horizontal);
            this.topPadding = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_padding_top);
            this.bottomPadding = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_padding_bottom);
            this.sectionGap = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_section_gap);
            this.messageCustomGap = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_space_message_custom);
            this.buttonSpacing = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_button_spacing);
            this.buttonWordPadding = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_button_padding_horizontal);
            this.buttonHeight = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_button_height);
            this.listItemSpacing = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_list_item_spacing);
            this.listChoicePadding = resources.getDimensionPixelOffset(R.dimen.stepos_dialog_list_choice_padding);
            this.dialogWidth = C5685n.f(((WindowManager) context.getSystemService(WindowManager.class)).getCurrentWindowMetrics().getBounds().width() - (dimensionPixelOffset * 2), 1);
        } catch (Throwable th) {
            typedArrayObtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final void applyButtonEmphasis(StepOSButton button, boolean isHighlight) {
        button.setGlassEnabled(false);
        button.setSurfaceDrawable(androidx.core.content.a.e(this.context, R.drawable.stepos_bg_button_secondary));
        button.setTextColor(androidx.core.content.a.d(this.context, R.color.stepos_button_secondary_text_color));
        if (isHighlight) {
            int i10 = this.highLightColor;
            if (i10 == 1) {
                button.setSurfaceDrawable(androidx.core.content.a.e(this.context, R.drawable.stepos_bg_button_blue));
                button.setTextColor(androidx.core.content.a.d(this.context, R.color.stepos_button_blue_text_color));
            } else {
                if (i10 != 2) {
                    return;
                }
                button.setTextColor(androidx.core.content.a.d(this.context, R.color.stepos_button_secondary_destructive_text_color));
            }
        }
    }

    private final void applyButtonIcon(StepOSButton button, Drawable icon) {
        if (icon == null) {
            androidx.core.widget.i.g(button, null, null, null, null);
            return;
        }
        int i10 = this.buttonIconSize;
        icon.setBounds(0, 0, i10, i10);
        androidx.core.widget.i.g(button, icon, null, null, null);
    }

    private final void applyListItemsScrollbar(View host) {
        NestedScrollView nestedScrollView = host instanceof NestedScrollView ? (NestedScrollView) host : null;
        if (nestedScrollView == null && (nestedScrollView = (NestedScrollView) this.window.findViewById(R.id.stepos_dialog_custom_panel)) == null) {
            return;
        }
        nestedScrollView.setHorizontalScrollBarEnabled(false);
        if (!this.hasListItemsContent || !this.listItemsScrollbarEnabled) {
            nestedScrollView.setVerticalScrollBarEnabled(false);
            nestedScrollView.setScrollbarFadingEnabled(false);
        } else {
            nestedScrollView.setVerticalScrollBarEnabled(true);
            nestedScrollView.setScrollbarFadingEnabled(false);
            nestedScrollView.setVerticalScrollbarThumbDrawable(androidx.core.content.a.e(this.context, R.drawable.stepos_dialog_scrollbar_thumb));
        }
    }

    public static /* synthetic */ void applyListItemsScrollbar$default(StepOSAlertController stepOSAlertController, View view, int i10, Object obj) {
        if ((i10 & 1) != 0) {
            view = null;
        }
        stepOSAlertController.applyListItemsScrollbar(view);
    }

    private final void applyStepOSStyle() {
        StepOSAlertDialogLayout stepOSAlertDialogLayout;
        View viewFindEditText;
        TextView textView = this.titleView;
        boolean z10 = textView != null && textView.getVisibility() == 0;
        if (textView != null && z10) {
            textView.setGravity(8388611);
        }
        TextView textView2 = this.messageView;
        if (textView2 != null && textView2.getVisibility() == 0) {
            textView2.setGravity(8388611);
        }
        ListView listView = this.listView;
        if (listView != null && this.isActionStyle && listView != null) {
            listView.setDivider(null);
        }
        ViewGroup viewGroup = (ViewGroup) this.window.findViewById(R.id.stepos_dialog_custom_panel);
        if (viewGroup != null && viewGroup.getVisibility() != 8 && !this.viewSpacingSpecified && (viewFindEditText = StepOSDialogInternalKt.findEditText(viewGroup)) != null) {
            viewFindEditText.requestFocus();
        }
        if (this.maxHeight == 0) {
            this.maxHeight = defaultMaxHeight();
        }
        if (this.maxHeight > 0 && (stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.window.findViewById(R.id.stepos_dialog_parent_panel)) != null) {
            stepOSAlertDialogLayout.setMaxHeight(this.maxHeight);
        }
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        attributes.width = this.dialogWidth;
        int i10 = this.gravity;
        if (i10 == 0) {
            i10 = 80;
        }
        attributes.gravity = i10;
        if ((i10 & 112) == 80) {
            attributes.y = this.screenMarginBottom;
        } else if (i10 == 17 && this.context.getResources().getConfiguration().orientation == 2) {
            attributes.y = (-StepOSDialogInternalKt.statusBarHeightPx(this.context)) / 2;
        }
        this.window.setAttributes(attributes);
        applyWindowInsetsPolicy();
        this.window.setElevation(0.0f);
    }

    private final void applyWindowInsetsPolicy() {
        WindowManager.LayoutParams attributes = this.window.getAttributes();
        boolean z10 = (attributes.gravity & 112) == 80;
        View view = this.installedCustomView;
        boolean z11 = view != null && StepOSDialogInternalKt.canTextInput(view);
        if (z10) {
            attributes.setFitInsetsTypes(WindowInsets.Type.statusBars() | WindowInsets.Type.captionBar() | WindowInsets.Type.displayCutout() | (z11 ? WindowInsets.Type.ime() : 0));
            attributes.setFitInsetsIgnoringVisibility(false);
        }
        attributes.softInputMode = (z10 ? 16 : 48) | ((this.autoShowSoftInput && z11) ? 5 : 3);
        this.window.setAttributes(attributes);
        StepOSAlertDialogLayout stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.window.findViewById(R.id.stepos_dialog_parent_panel);
        if (stepOSAlertDialogLayout != null) {
            stepOSAlertDialogLayout.setBottomWindowMargin$StepOSWidget_release(z10 ? this.screenMarginBottom : 0);
            stepOSAlertDialogLayout.setFitInputMethod$StepOSWidget_release(z10 && z11);
            stepOSAlertDialogLayout.requestLayout();
        }
    }

    private final void bindIcon(ImageView view, Drawable drawable, int resId) {
        if (resId != 0) {
            view.setImageResource(resId);
        } else if (drawable != null) {
            view.setImageDrawable(drawable);
        } else {
            view.setImageDrawable(null);
        }
    }

    private final View buildIconContentView(StepOSAlertParams params) {
        View viewInflate = LayoutInflater.from(this.context).inflate(R.layout.stepos_dialog_icon_content, (ViewGroup) null, false);
        View viewFindViewById = viewInflate.findViewById(R.id.stepos_dialog_icon_content_left);
        View viewFindViewById2 = viewInflate.findViewById(R.id.stepos_dialog_icon_content_right);
        final View viewFindViewById3 = viewInflate.findViewById(R.id.stepos_dialog_icon_content_left_icon_frame);
        final View viewFindViewById4 = viewInflate.findViewById(R.id.stepos_dialog_icon_content_right_icon_frame);
        ImageView imageView = (ImageView) viewInflate.findViewById(R.id.stepos_dialog_icon_content_left_icon);
        ImageView imageView2 = (ImageView) viewInflate.findViewById(R.id.stepos_dialog_icon_content_right_icon);
        final TextView textView = (TextView) viewInflate.findViewById(R.id.stepos_dialog_icon_content_left_label);
        final TextView textView2 = (TextView) viewInflate.findViewById(R.id.stepos_dialog_icon_content_right_label);
        kotlin.jvm.internal.p.f(imageView);
        bindIcon(imageView, params.getIconContentLeftIcon(), params.getIconContentLeftIconId());
        kotlin.jvm.internal.p.f(imageView2);
        bindIcon(imageView2, params.getIconContentRightIcon(), params.getIconContentRightIconId());
        textView.setText(params.getIconContentLeftLabel());
        textView2.setText(params.getIconContentRightLabel());
        buildIconContentView$applySelection(this, viewFindViewById3, viewFindViewById4, textView, textView2, this.iconContentSelectedIndex);
        viewFindViewById.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.dialog.d
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSAlertController.buildIconContentView$lambda$48(this.f31165a, viewFindViewById3, viewFindViewById4, textView, textView2, view);
            }
        });
        viewFindViewById2.setOnClickListener(new View.OnClickListener() { // from class: com.stepos.widget.dialog.e
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                StepOSAlertController.buildIconContentView$lambda$49(this.f31170a, viewFindViewById3, viewFindViewById4, textView, textView2, view);
            }
        });
        kotlin.jvm.internal.p.f(viewInflate);
        return viewInflate;
    }

    private static final void buildIconContentView$applySelection(StepOSAlertController stepOSAlertController, View view, View view2, TextView textView, TextView textView2, int i10) {
        int iN = C5685n.n(i10, 0, 1);
        stepOSAlertController.iconContentSelectedIndex = iN;
        boolean z10 = iN == 0;
        view.setBackgroundResource(z10 ? R.drawable.stepos_bg_dialog_icon_content_selected : R.drawable.stepos_bg_dialog_icon_content_unselected);
        view2.setBackgroundResource(!z10 ? R.drawable.stepos_bg_dialog_icon_content_selected : R.drawable.stepos_bg_dialog_icon_content_unselected);
        int iC = androidx.core.content.a.c(stepOSAlertController.context, R.color.stepos_dialog_icon_content_label_selected);
        int iC2 = androidx.core.content.a.c(stepOSAlertController.context, R.color.stepos_dialog_icon_content_label_unselected);
        textView.setTextColor(z10 ? iC : iC2);
        if (z10) {
            iC = iC2;
        }
        textView2.setTextColor(iC);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildIconContentView$lambda$48(StepOSAlertController stepOSAlertController, View view, View view2, TextView textView, TextView textView2, View view3) {
        buildIconContentView$applySelection(stepOSAlertController, view, view2, textView, textView2, 0);
        DialogInterface.OnClickListener onClickListener = stepOSAlertController.iconContentListener;
        if (onClickListener != null) {
            onClickListener.onClick(stepOSAlertController.dialog, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildIconContentView$lambda$49(StepOSAlertController stepOSAlertController, View view, View view2, TextView textView, TextView textView2, View view3) {
        buildIconContentView$applySelection(stepOSAlertController, view, view2, textView, textView2, 1);
        DialogInterface.OnClickListener onClickListener = stepOSAlertController.iconContentListener;
        if (onClickListener != null) {
            onClickListener.onClick(stepOSAlertController.dialog, 1);
        }
    }

    private final StepOSListGroup buildListItemsGroup(List<? extends Pair<String, String>> entries, final DialogInterface.OnClickListener listener) throws Resources.NotFoundException {
        int dimensionPixelOffset = this.context.getResources().getDimensionPixelOffset(R.dimen.stepos_dialog_header_inset);
        StepOSListGroup stepOSListGroup = new StepOSListGroup(this.context, null, 0, 6, null);
        stepOSListGroup.setBackgroundMode(1);
        final int i10 = 0;
        stepOSListGroup.setPaddingRelative(dimensionPixelOffset, 0, dimensionPixelOffset, 0);
        for (Object obj : entries) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            Pair pair = (Pair) obj;
            StepOSListItem stepOSListItem = new StepOSListItem(this.context, null, 0, 6, null);
            stepOSListItem.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
            stepOSListItem.setTrailingType(1);
            String str = (String) pair.first;
            if (str == null) {
                str = "";
            }
            stepOSListItem.setTitle(str);
            String str2 = (String) pair.second;
            if (str2 == null || str2.length() == 0) {
                str2 = null;
            }
            stepOSListItem.setSubtitle(str2);
            stepOSListItem.setOnItemClickListener(new StepOSListItem.OnItemClickListener() { // from class: com.stepos.widget.dialog.f
                @Override // com.stepos.widget.list.StepOSListItem.OnItemClickListener
                public final void onItemClick(StepOSListItem stepOSListItem2) {
                    StepOSAlertController.buildListItemsGroup$lambda$45$lambda$44$lambda$43(listener, this, i10, stepOSListItem2);
                }
            });
            stepOSListGroup.addItem(stepOSListItem);
            i10 = i11;
        }
        return stepOSListGroup;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buildListItemsGroup$lambda$45$lambda$44$lambda$43(DialogInterface.OnClickListener onClickListener, StepOSAlertController stepOSAlertController, int i10, StepOSListItem it) {
        kotlin.jvm.internal.p.i(it, "it");
        if (onClickListener != null) {
            onClickListener.onClick(stepOSAlertController.dialog, i10);
        }
        stepOSAlertController.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void buttonClickListener$lambda$3(StepOSAlertController stepOSAlertController, View view) {
        Message message;
        Message message2;
        Message message3;
        Message messageObtain = (view != stepOSAlertController.buttonPositive || (message3 = stepOSAlertController.buttonPositiveMessage) == null) ? (view != stepOSAlertController.buttonNegative || (message2 = stepOSAlertController.buttonNegativeMessage) == null) ? (view != stepOSAlertController.buttonNeutral || (message = stepOSAlertController.buttonNeutralMessage) == null) ? null : Message.obtain(message) : Message.obtain(message2) : Message.obtain(message3);
        if (messageObtain != null) {
            messageObtain.sendToTarget();
        }
        stepOSAlertController.handler.obtainMessage(1, stepOSAlertController.dialog).sendToTarget();
    }

    private final int calcButtonCount(int whichButtons) {
        return Integer.bitCount(whichButtons & 7);
    }

    private final int calcButtonHighLight(int whichButtons) {
        int i10 = this.highLightButton;
        int i11 = i10 != -3 ? i10 != -2 ? i10 != -1 ? 0 : 1 : 2 : 4;
        if (i11 != 0 && (whichButtons & i11) != 0) {
            return i11;
        }
        if ((whichButtons & 1) != 0) {
            return 1;
        }
        if ((whichButtons & 4) != 0) {
            return 4;
        }
        return (whichButtons & 2) != 0 ? 2 : 0;
    }

    private final int calcButtonWidth(int whichButtons) {
        int iCalcButtonCount = calcButtonCount(whichButtons);
        int i10 = this.dialogWidth - (this.horizontalPadding * 2);
        return iCalcButtonCount == 0 ? i10 : (i10 - (this.buttonSpacing * (iCalcButtonCount - 1))) / iCalcButtonCount;
    }

    private final void clearIconContentMode() {
        this.hasIconContent = false;
        this.iconContentRoot = null;
        this.iconContentListener = null;
    }

    private final void clearListItemsMode() {
        this.hasListItemsContent = false;
    }

    private final double computeDialogHeightRatio() {
        ListAdapter adapter;
        double dCeil = this.title != null ? 0.106d + (Math.ceil(r0.length() / 15.0d) * 0.03d) : 0.106d;
        if (this.message != null) {
            dCeil += Math.ceil(r0.length() / 19.0d) * 0.023d;
        }
        if (this.hasCustomView) {
            dCeil += 0.3d;
        }
        if (this.customTitleView != null) {
            dCeil += 0.1d;
        }
        ListView listView = this.listView;
        if (listView != null && (adapter = listView.getAdapter()) != null) {
            dCeil += adapter.getCount() * 0.063d;
        }
        int i10 = this.multiLinesItemCount;
        if (i10 > 0) {
            dCeil = (dCeil + (i10 * 0.11d)) - 0.3d;
        }
        int iCalcButtonCount = calcButtonCount(visibleButtonBits()) - 1;
        return (iCalcButtonCount <= 0 || !isButtonBarVertical()) ? dCeil : dCeil + (iCalcButtonCount * 0.063d);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createListView$lambda$38(DialogInterface.OnClickListener onClickListener, StepOSAlertController stepOSAlertController, StepOSAlertParams stepOSAlertParams, AdapterView adapterView, View view, int i10, long j10) {
        onClickListener.onClick(stepOSAlertController.dialog, i10);
        if (stepOSAlertParams.getIsSingleChoice()) {
            return;
        }
        stepOSAlertController.dialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void createListView$lambda$40(StepOSAlertParams stepOSAlertParams, DialogInterface.OnMultiChoiceClickListener onMultiChoiceClickListener, StepOSAlertController stepOSAlertController, StepOSDialogListView stepOSDialogListView, AdapterView adapterView, View view, int i10, long j10) {
        boolean[] checkedItems = stepOSAlertParams.getCheckedItems();
        if (checkedItems != null) {
            checkedItems[i10] = stepOSDialogListView.isItemChecked(i10);
        }
        onMultiChoiceClickListener.onClick(stepOSAlertController.dialog, i10, stepOSDialogListView.isItemChecked(i10));
    }

    private final int defaultMaxHeight() {
        return (int) (StepOSDialogInternalKt.screenHeightPx(this.context) * MAX_HEIGHT_SCREEN_RATIO);
    }

    private final StepOSAlertDialogLayout dialogPanel() {
        return (StepOSAlertDialogLayout) this.window.findViewById(R.id.stepos_dialog_parent_panel);
    }

    public static /* synthetic */ void getButtonLayout$annotations() {
    }

    private final boolean hasEditText() {
        View view = this.installedCustomView;
        return ((view == null && (view = this.contentView) == null) || StepOSDialogInternalKt.findEditText(view) == null) ? false : true;
    }

    private final void hideSystemVerticalScrollbar(View view) {
        NestedScrollView nestedScrollView = view instanceof NestedScrollView ? (NestedScrollView) view : null;
        if (nestedScrollView == null) {
            return;
        }
        nestedScrollView.setVerticalScrollBarEnabled(false);
        nestedScrollView.setHorizontalScrollBarEnabled(false);
    }

    private final boolean isButtonBarVertical() {
        ViewParent parent;
        StepOSButton stepOSButton = this.buttonPositive;
        if (stepOSButton == null || (parent = stepOSButton.getParent()) == null) {
            StepOSButton stepOSButton2 = this.buttonNegative;
            parent = stepOSButton2 != null ? stepOSButton2.getParent() : null;
            if (parent == null) {
                StepOSButton stepOSButton3 = this.buttonNeutral;
                parent = stepOSButton3 != null ? stepOSButton3.getParent() : null;
            }
        }
        LinearLayout linearLayout = parent instanceof LinearLayout ? (LinearLayout) parent : null;
        return linearLayout != null && linearLayout.getOrientation() == 1;
    }

    private final boolean isButtonLayoutVertical(int whichButtons) {
        boolean z10;
        int iCalcButtonCount = calcButtonCount(whichButtons);
        int iCalcButtonWidth = calcButtonWidth(whichButtons) - (this.buttonWordPadding * 2);
        List<kotlin.Pair> listP = C1173v.p(Y8.j.a(this.buttonPositive, this.buttonPositiveText), Y8.j.a(this.buttonNegative, this.buttonNegativeText), Y8.j.a(this.buttonNeutral, this.buttonNeutralText));
        boolean z11 = true;
        if ((listP instanceof Collection) && listP.isEmpty()) {
            z10 = false;
        } else {
            for (kotlin.Pair pair : listP) {
                StepOSButton stepOSButton = (StepOSButton) pair.a();
                CharSequence charSequence = (CharSequence) pair.b();
                if (stepOSButton != null && stepOSButton.getVisibility() == 0 && StepOSDialogInternalKt.measureTextWidth(stepOSButton, charSequence) + stepOSButton.getCompoundPaddingStart() + stepOSButton.getCompoundPaddingEnd() > (this.buttonWordPadding * 2) + iCalcButtonWidth) {
                    z10 = true;
                    break;
                }
            }
            z10 = false;
        }
        StepOSDialogLayoutPolicy stepOSDialogLayoutPolicy = StepOSDialogLayoutPolicy.INSTANCE;
        int i10 = this.buttonLayout;
        if (!this.isActionStyle && this.listView == null && !this.isMultiLines) {
            z11 = false;
        }
        return stepOSDialogLayoutPolicy.isVertical$StepOSWidget_release(iCalcButtonCount, i10, z10, z11);
    }

    private final void refreshButtons() {
        if (this.buttonPositive == null) {
            return;
        }
        setupButtons((ViewGroup) this.window.findViewById(R.id.stepos_dialog_button_panel));
        refreshSectionGaps();
    }

    private final void refreshCustomContent() throws Resources.NotFoundException {
        ViewGroup viewGroup;
        if (this.contentInstalled && (viewGroup = (ViewGroup) this.window.findViewById(R.id.stepos_dialog_custom_panel)) != null) {
            FrameLayout frameLayout = (FrameLayout) this.window.findViewById(R.id.stepos_dialog_custom);
            if (frameLayout != null) {
                frameLayout.removeAllViews();
            }
            setupCustomContent(viewGroup);
            refreshHeader();
            refreshSectionGaps();
        }
    }

    private final void refreshHeader() throws Resources.NotFoundException {
        int dimensionPixelSize;
        CharSequence charSequence;
        ConstraintLayout constraintLayout = (ConstraintLayout) this.window.findViewById(R.id.stepos_dialog_title_template);
        if (constraintLayout == null) {
            return;
        }
        TextView textView = (TextView) constraintLayout.findViewById(R.id.stepos_dialog_title);
        TextView textView2 = (TextView) constraintLayout.findViewById(R.id.stepos_dialog_message);
        ImageView imageView = (ImageView) constraintLayout.findViewById(R.id.stepos_dialog_icon);
        FrameLayout frameLayout = (FrameLayout) constraintLayout.findViewById(R.id.stepos_dialog_icon_group);
        ImageView imageView2 = (ImageView) constraintLayout.findViewById(R.id.stepos_dialog_icon_badge);
        this.titleView = textView;
        this.messageView = textView2;
        this.iconView = imageView;
        boolean z10 = this.customTitleView != null;
        textView.setText(this.title);
        textView2.setText(this.message);
        textView2.setMovementMethod(this.messageMovementMethod);
        textView.setVisibility((z10 || (charSequence = this.title) == null || charSequence.length() == 0) ? 8 : 0);
        CharSequence charSequence2 = this.message;
        textView2.setVisibility((charSequence2 == null || charSequence2.length() == 0) ? 8 : 0);
        imageView.setVisibility((z10 || (this.iconResId == 0 && this.icon == null)) ? 8 : 0);
        int i10 = this.iconResId;
        if (i10 != 0) {
            imageView.setImageResource(i10);
        } else {
            imageView.setImageDrawable(this.icon);
        }
        frameLayout.setVisibility(imageView.getVisibility());
        imageView2.setImageDrawable(this.iconBadge);
        imageView2.setVisibility((imageView.getVisibility() != 0 || this.iconBadge == null) ? 8 : 0);
        int dimensionPixelSize2 = imageView2.getVisibility() == 0 ? (this.context.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_icon_badge_offset_top) + this.context.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_icon_badge_size)) - this.context.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_title_icon_size) : 0;
        androidx.core.widget.i.m(textView2, this.hasCustomView ? R.style.StepOSTextAppearance_Dialog_Message_Compact : R.style.StepOSTextAppearance_Dialog_Message);
        textView.setMaxLines(this.titleMaxLines);
        textView2.setMaxLines(this.messageMaxLines);
        List listS0 = F.S0(C1173v.q(this.customTitleView), C1173v.p(frameLayout, textView, textView2));
        ArrayList arrayList = new ArrayList();
        for (Object obj : listS0) {
            if (((View) obj).getVisibility() == 0) {
                arrayList.add(obj);
            }
        }
        int[] iArrHeaderGaps$StepOSWidget_release = StepOSDialogLayoutPolicy.INSTANCE.headerGaps$StepOSWidget_release(imageView.getVisibility() == 0, textView.getVisibility() == 0, textView2.getVisibility() == 0, this.context.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_title_icon_gap), this.context.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_text_gap));
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        cVar.p(constraintLayout);
        View view = this.customTitleView;
        if (view != null) {
            cVar.s(view.getId(), 6, 0, 6);
            cVar.s(view.getId(), 7, 0, 7);
        }
        int i11 = 0;
        for (Object obj2 : arrayList) {
            int i12 = i11 + 1;
            if (i11 < 0) {
                C1173v.w();
            }
            View view2 = (View) obj2;
            cVar.n(view2.getId(), 3);
            View view3 = (View) F.t0(arrayList, i11 - 1);
            if (view3 == null) {
                dimensionPixelSize = 0;
            } else {
                dimensionPixelSize = view3 == this.customTitleView ? this.context.getResources().getDimensionPixelSize(R.dimen.stepos_dialog_text_gap) : iArrHeaderGaps$StepOSWidget_release[kotlin.jvm.internal.p.d(view2, frameLayout) ? (char) 0 : kotlin.jvm.internal.p.d(view2, textView) ? (char) 1 : (char) 2] - (view3 == frameLayout ? dimensionPixelSize2 : 0);
            }
            cVar.t(view2.getId(), 3, view3 != null ? view3.getId() : 0, view3 == null ? 3 : 4, dimensionPixelSize);
            i11 = i12;
        }
        cVar.i(constraintLayout);
        constraintLayout.setVisibility(arrayList.isEmpty() ? 8 : 0);
        View viewFindViewById = this.window.findViewById(R.id.stepos_dialog_top_panel);
        if (viewFindViewById != null) {
            viewFindViewById.setVisibility((z10 || !arrayList.isEmpty()) ? 0 : 8);
        }
        refreshSectionGaps();
    }

    private final void refreshSectionGaps() {
        View viewFindViewById = this.window.findViewById(R.id.stepos_dialog_parent_panel);
        if (viewFindViewById == null) {
            return;
        }
        View viewFindViewById2 = viewFindViewById.findViewById(R.id.stepos_dialog_middle_panel);
        View viewFindViewById3 = viewFindViewById.findViewById(R.id.stepos_dialog_content_panel);
        View viewFindViewById4 = viewFindViewById.findViewById(R.id.stepos_dialog_custom_panel);
        if (viewFindViewById2 != null) {
            viewFindViewById2.setVisibility(((viewFindViewById3 == null || viewFindViewById3.getVisibility() != 0) && (viewFindViewById4 == null || viewFindViewById4.getVisibility() != 0)) ? 8 : 0);
        }
        setupSectionGaps(viewFindViewById, viewFindViewById.findViewById(R.id.stepos_dialog_top_panel), viewFindViewById2, viewFindViewById3, viewFindViewById4, viewFindViewById.findViewById(R.id.stepos_dialog_button_panel));
    }

    private final ViewGroup resolvePanel(View customPanel, View defaultPanel) {
        if (customPanel == null) {
            if (defaultPanel instanceof ViewStub) {
                defaultPanel = ((ViewStub) defaultPanel).inflate();
            }
            if (defaultPanel instanceof ViewGroup) {
                return (ViewGroup) defaultPanel;
            }
            return null;
        }
        ViewParent parent = defaultPanel != null ? defaultPanel.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(defaultPanel);
        }
        if (customPanel instanceof ViewStub) {
            customPanel = ((ViewStub) customPanel).inflate();
        }
        if (customPanel instanceof ViewGroup) {
            return (ViewGroup) customPanel;
        }
        return null;
    }

    private final void setBottomMargin(View view, int margin) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.bottomMargin == margin) {
            return;
        }
        marginLayoutParams.bottomMargin = margin;
        view.setLayoutParams(marginLayoutParams);
    }

    private final void setScrollIndicators(ViewGroup contentPanel, int indicators) {
        final View viewFindViewById = this.window.findViewById(R.id.stepos_dialog_scroll_indicator_up);
        final View viewFindViewById2 = this.window.findViewById(R.id.stepos_dialog_scroll_indicator_down);
        if (viewFindViewById != null && (indicators & 1) == 0) {
            contentPanel.removeView(viewFindViewById);
            viewFindViewById = null;
        }
        if (viewFindViewById2 != null && (indicators & 2) == 0) {
            contentPanel.removeView(viewFindViewById2);
            viewFindViewById2 = null;
        }
        if (viewFindViewById == null && viewFindViewById2 == null) {
            return;
        }
        final NestedScrollView nestedScrollView = this.scrollView;
        final ListView listView = this.listView;
        if (this.message != null && nestedScrollView != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.e() { // from class: com.stepos.widget.dialog.a
                @Override // androidx.core.widget.NestedScrollView.e
                public final void a(NestedScrollView nestedScrollView2, int i10, int i11, int i12, int i13) {
                    StepOSAlertController.setScrollIndicators$lambda$17(viewFindViewById, viewFindViewById2, nestedScrollView2, i10, i11, i12, i13);
                }
            });
            nestedScrollView.post(new Runnable() { // from class: com.stepos.widget.dialog.b
                @Override // java.lang.Runnable
                public final void run() {
                    StepOSAlertController.setScrollIndicators$lambda$18(nestedScrollView, viewFindViewById, viewFindViewById2);
                }
            });
        } else {
            if (listView != null) {
                listView.setOnScrollListener(new AbsListView.OnScrollListener() { // from class: com.stepos.widget.dialog.StepOSAlertController.setScrollIndicators.3
                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScroll(AbsListView v10, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
                        kotlin.jvm.internal.p.i(v10, "v");
                        StepOSAlertController.INSTANCE.manageScrollIndicators(v10, viewFindViewById, viewFindViewById2);
                    }

                    @Override // android.widget.AbsListView.OnScrollListener
                    public void onScrollStateChanged(AbsListView view, int scrollState) {
                        kotlin.jvm.internal.p.i(view, "view");
                    }
                });
                listView.post(new Runnable() { // from class: com.stepos.widget.dialog.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        StepOSAlertController.setScrollIndicators$lambda$19(listView, viewFindViewById, viewFindViewById2);
                    }
                });
                return;
            }
            if (viewFindViewById != null) {
                contentPanel.removeView(viewFindViewById);
            }
            if (viewFindViewById2 != null) {
                contentPanel.removeView(viewFindViewById2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setScrollIndicators$lambda$17(View view, View view2, NestedScrollView v10, int i10, int i11, int i12, int i13) {
        kotlin.jvm.internal.p.i(v10, "v");
        INSTANCE.manageScrollIndicators(v10, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setScrollIndicators$lambda$18(NestedScrollView nestedScrollView, View view, View view2) {
        INSTANCE.manageScrollIndicators(nestedScrollView, view, view2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setScrollIndicators$lambda$19(ListView listView, View view, View view2) {
        INSTANCE.manageScrollIndicators(listView, view, view2);
    }

    private final void setTopMargin(View view, int margin) {
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : null;
        if (marginLayoutParams == null || marginLayoutParams.topMargin == margin) {
            return;
        }
        marginLayoutParams.topMargin = margin;
        view.setLayoutParams(marginLayoutParams);
    }

    private final void setupButtons(ViewGroup buttonPanel) {
        int i10;
        if (buttonPanel == null) {
            return;
        }
        StepOSButton stepOSButton = (StepOSButton) buttonPanel.findViewById(R.id.stepos_dialog_button_positive);
        this.buttonPositive = stepOSButton;
        stepOSButton.setOnClickListener(this.buttonClickListener);
        if (TextUtils.isEmpty(this.buttonPositiveText) && this.buttonPositiveIcon == null) {
            stepOSButton.setVisibility(8);
            i10 = 0;
        } else {
            stepOSButton.setText(this.buttonPositiveText);
            kotlin.jvm.internal.p.f(stepOSButton);
            applyButtonIcon(stepOSButton, this.buttonPositiveIcon);
            stepOSButton.setVisibility(0);
            i10 = 1;
        }
        StepOSButton stepOSButton2 = (StepOSButton) buttonPanel.findViewById(R.id.stepos_dialog_button_negative);
        this.buttonNegative = stepOSButton2;
        stepOSButton2.setOnClickListener(this.buttonClickListener);
        if (TextUtils.isEmpty(this.buttonNegativeText) && this.buttonNegativeIcon == null) {
            stepOSButton2.setVisibility(8);
        } else {
            stepOSButton2.setText(this.buttonNegativeText);
            kotlin.jvm.internal.p.f(stepOSButton2);
            applyButtonIcon(stepOSButton2, this.buttonNegativeIcon);
            stepOSButton2.setVisibility(0);
            i10 |= 2;
        }
        StepOSButton stepOSButton3 = (StepOSButton) buttonPanel.findViewById(R.id.stepos_dialog_button_neutral);
        this.buttonNeutral = stepOSButton3;
        stepOSButton3.setOnClickListener(this.buttonClickListener);
        if (TextUtils.isEmpty(this.buttonNeutralText) && this.buttonNeutralIcon == null) {
            stepOSButton3.setVisibility(8);
        } else {
            stepOSButton3.setText(this.buttonNeutralText);
            kotlin.jvm.internal.p.f(stepOSButton3);
            applyButtonIcon(stepOSButton3, this.buttonNeutralIcon);
            stepOSButton3.setVisibility(0);
            i10 |= 4;
        }
        if (i10 == 0) {
            buttonPanel.setVisibility(8);
            return;
        }
        buttonPanel.setVisibility(0);
        ViewParent parent = stepOSButton3.getParent();
        ConstraintLayout constraintLayout = parent instanceof ConstraintLayout ? (ConstraintLayout) parent : null;
        if (constraintLayout == null) {
            return;
        }
        int iCalcButtonHighLight = calcButtonHighLight(i10);
        boolean zIsButtonLayoutVertical = isButtonLayoutVertical(i10);
        List listP = C1173v.p(stepOSButton, stepOSButton3, stepOSButton2);
        StepOSDialogLayoutPolicy stepOSDialogLayoutPolicy = StepOSDialogLayoutPolicy.INSTANCE;
        StepOSButton stepOSButton4 = stepOSButton.getVisibility() == 0 ? stepOSButton : null;
        if (stepOSButton3.getVisibility() != 0) {
            stepOSButton3 = null;
        }
        List listOrderedButtons$StepOSWidget_release = stepOSDialogLayoutPolicy.orderedButtons$StepOSWidget_release(stepOSButton4, stepOSButton3, stepOSButton2.getVisibility() == 0 ? stepOSButton2 : null, zIsButtonLayoutVertical);
        androidx.constraintlayout.widget.c cVar = new androidx.constraintlayout.widget.c();
        Iterator it = listP.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            StepOSButton stepOSButton5 = (StepOSButton) it.next();
            cVar.w(stepOSButton5.getId(), 0);
            cVar.v(stepOSButton5.getId(), this.buttonHeight);
            cVar.b0(stepOSButton5.getId(), stepOSButton5.getVisibility());
            stepOSButton5.setMinimumWidth(0);
            stepOSButton5.setMinimumHeight(0);
            stepOSButton5.setGravity(17);
            int i11 = this.buttonWordPadding;
            stepOSButton5.setPaddingRelative(i11, 0, i11, 0);
            int i12 = kotlin.jvm.internal.p.d(stepOSButton5, stepOSButton) ? 1 : kotlin.jvm.internal.p.d(stepOSButton5, stepOSButton2) ? 2 : 4;
            kotlin.jvm.internal.p.f(stepOSButton5);
            applyButtonEmphasis(stepOSButton5, i12 == iCalcButtonHighLight);
        }
        List list = listOrderedButtons$StepOSWidget_release;
        int i13 = 0;
        for (Object obj : list) {
            int i14 = i13 + 1;
            if (i13 < 0) {
                C1173v.w();
            }
            StepOSButton stepOSButton6 = (StepOSButton) obj;
            StepOSButton stepOSButton7 = (StepOSButton) F.t0(listOrderedButtons$StepOSWidget_release, i13 - 1);
            cVar.t(stepOSButton6.getId(), 3, (!zIsButtonLayoutVertical || stepOSButton7 == null) ? 0 : stepOSButton7.getId(), (!zIsButtonLayoutVertical || stepOSButton7 == null) ? 3 : 4, (!zIsButtonLayoutVertical || stepOSButton7 == null) ? 0 : this.buttonSpacing);
            if (zIsButtonLayoutVertical) {
                cVar.s(stepOSButton6.getId(), 6, 0, 6);
                cVar.s(stepOSButton6.getId(), 7, 0, 7);
            }
            i13 = i14;
        }
        if (!zIsButtonLayoutVertical) {
            ArrayList arrayList = new ArrayList(C1174w.x(list, 10));
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                arrayList.add(Integer.valueOf(((StepOSButton) it2.next()).getId()));
            }
            int[] iArrL1 = F.l1(arrayList);
            int size = listOrderedButtons$StepOSWidget_release.size();
            float[] fArr = new float[size];
            for (int i15 = 0; i15 < size; i15++) {
                fArr[i15] = 1.0f;
            }
            cVar.z(0, 6, 0, 7, iArrL1, fArr, 0);
            Iterator it3 = F.h0(listOrderedButtons$StepOSWidget_release, 1).iterator();
            while (it3.hasNext()) {
                cVar.Y(((StepOSButton) it3.next()).getId(), 6, this.buttonSpacing);
            }
        }
        cVar.i(constraintLayout);
    }

    private final void setupContent(ViewGroup contentPanel) {
        if (contentPanel == null) {
            return;
        }
        NestedScrollView nestedScrollView = (NestedScrollView) this.window.findViewById(R.id.stepos_dialog_scroll_view);
        this.scrollView = nestedScrollView;
        nestedScrollView.setFocusable(false);
        nestedScrollView.setNestedScrollingEnabled(false);
        ListView listView = this.listView;
        if (listView == null) {
            contentPanel.setVisibility(8);
            return;
        }
        ViewParent parent = nestedScrollView.getParent();
        kotlin.jvm.internal.p.g(parent, "null cannot be cast to non-null type android.view.ViewGroup");
        ViewGroup viewGroup = (ViewGroup) parent;
        int iIndexOfChild = viewGroup.indexOfChild(nestedScrollView);
        viewGroup.removeViewAt(iIndexOfChild);
        viewGroup.addView(listView, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
    }

    private final void setupCustomContent(ViewGroup customPanel) {
        View viewInflate = this.contentView;
        if (viewInflate == null) {
            Integer numValueOf = Integer.valueOf(this.contentViewLayoutResId);
            if (numValueOf.intValue() == 0) {
                numValueOf = null;
            }
            viewInflate = numValueOf != null ? LayoutInflater.from(this.context).inflate(numValueOf.intValue(), customPanel, false) : null;
        }
        this.hasCustomView = viewInflate != null;
        this.installedCustomView = viewInflate;
        if (viewInflate == null || !StepOSDialogInternalKt.canTextInput(viewInflate)) {
            this.window.setFlags(SQLiteDatabase.OPEN_SHAREDCACHE, SQLiteDatabase.OPEN_SHAREDCACHE);
        } else {
            this.window.clearFlags(SQLiteDatabase.OPEN_SHAREDCACHE);
        }
        if (this.contentInstalled) {
            applyWindowInsetsPolicy();
        }
        if (viewInflate == null) {
            customPanel.setVisibility(8);
            applyListItemsScrollbar(customPanel);
            return;
        }
        FrameLayout frameLayout = (FrameLayout) this.window.findViewById(R.id.stepos_dialog_custom);
        customPanel.setVisibility(0);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        if (this.hasListItemsContent) {
            layoutParams.setMarginStart(-this.horizontalPadding);
            layoutParams.setMarginEnd(-this.horizontalPadding);
        }
        frameLayout.addView(viewInflate, layoutParams);
        if (this.viewSpacingSpecified) {
            frameLayout.setPadding(this.viewSpacingLeft, this.viewSpacingTop, this.viewSpacingRight, this.viewSpacingBottom);
        } else {
            frameLayout.setPaddingRelative(0, 0, 0, 0);
        }
        if (this.listView != null) {
            ViewGroup.LayoutParams layoutParams2 = customPanel.getLayoutParams();
            LinearLayoutCompat.a aVar = layoutParams2 instanceof LinearLayoutCompat.a ? (LinearLayoutCompat.a) layoutParams2 : null;
            if (aVar != null) {
                ((LinearLayout.LayoutParams) aVar).weight = 0.0f;
            }
        }
        applyListItemsScrollbar(customPanel);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0055 A[PHI: r2 r4 r5
      0x0055: PHI (r2v5 int) = (r2v3 int), (r2v3 int), (r2v8 int), (r2v8 int) binds: [B:48:0x0065, B:49:0x0067, B:38:0x004e, B:39:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0055: PHI (r4v2 int) = (r4v1 int), (r4v1 int), (r4v5 int), (r4v5 int) binds: [B:48:0x0065, B:49:0x0067, B:38:0x004e, B:39:0x0050] A[DONT_GENERATE, DONT_INLINE]
      0x0055: PHI (r5v1 int) = (r5v0 int), (r5v0 int), (r5v3 int), (r5v3 int) binds: [B:48:0x0065, B:49:0x0067, B:38:0x004e, B:39:0x0050] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void setupSectionGaps(android.view.View r7, android.view.View r8, android.view.View r9, android.view.View r10, android.view.View r11, android.view.View r12) {
        /*
            r6 = this;
            r0 = 1
            r1 = 0
            if (r8 == 0) goto Lc
            int r2 = r8.getVisibility()
            if (r2 != 0) goto Lc
            r2 = r0
            goto Ld
        Lc:
            r2 = r1
        Ld:
            if (r9 == 0) goto L17
            int r3 = r9.getVisibility()
            if (r3 != 0) goto L17
            r3 = r0
            goto L18
        L17:
            r3 = r1
        L18:
            if (r12 == 0) goto L22
            int r12 = r12.getVisibility()
            if (r12 != 0) goto L22
            r12 = r0
            goto L23
        L22:
            r12 = r1
        L23:
            if (r10 == 0) goto L2d
            int r10 = r10.getVisibility()
            if (r10 != 0) goto L2d
            r10 = r0
            goto L2e
        L2d:
            r10 = r1
        L2e:
            if (r11 == 0) goto L37
            int r4 = r11.getVisibility()
            if (r4 != 0) goto L37
            goto L38
        L37:
            r0 = r1
        L38:
            boolean r4 = r6.useCustomPadding
            if (r4 == 0) goto L57
            boolean r4 = r6.isMultiLines
            if (r4 != 0) goto L57
            int r4 = r6.customSpace1
            int r5 = r6.customSpace4
            if (r2 == 0) goto L4d
            if (r3 != 0) goto L4a
            if (r12 == 0) goto L4d
        L4a:
            int r2 = r6.customSpace2
            goto L4e
        L4d:
            r2 = r1
        L4e:
            if (r3 == 0) goto L55
            if (r12 == 0) goto L55
            int r12 = r6.customSpace3
            goto L6b
        L55:
            r12 = r1
            goto L6b
        L57:
            int r4 = r6.topPadding
            int r5 = r6.bottomPadding
            if (r2 == 0) goto L64
            if (r3 != 0) goto L61
            if (r12 == 0) goto L64
        L61:
            int r2 = r6.sectionGap
            goto L65
        L64:
            r2 = r1
        L65:
            if (r3 == 0) goto L55
            if (r12 == 0) goto L55
            int r12 = r6.sectionGap
        L6b:
            int r3 = r6.horizontalPadding
            r7.setPaddingRelative(r3, r4, r3, r5)
            r6.setBottomMargin(r8, r2)
            r6.setBottomMargin(r9, r12)
            if (r10 == 0) goto L7c
            if (r0 == 0) goto L7c
            int r1 = r6.messageCustomGap
        L7c:
            r6.setTopMargin(r11, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.widget.dialog.StepOSAlertController.setupSectionGaps(android.view.View, android.view.View, android.view.View, android.view.View, android.view.View, android.view.View):void");
    }

    private final void setupTitle(ViewGroup topPanel) throws Resources.NotFoundException {
        ConstraintLayout constraintLayout;
        if (topPanel == null || (constraintLayout = (ConstraintLayout) topPanel.findViewById(R.id.stepos_dialog_title_template)) == null) {
            return;
        }
        View view = this.customTitleView;
        if (view != null && view.getParent() != constraintLayout) {
            if (view.getId() == -1) {
                view.setId(View.generateViewId());
            }
            constraintLayout.addView(view, 0, new ConstraintLayout.b(0, -2));
        }
        ImageView imageView = (ImageView) this.window.findViewById(R.id.stepos_dialog_icon);
        this.iconView = imageView;
        TextView textView = (TextView) this.window.findViewById(R.id.stepos_dialog_title);
        this.titleView = textView;
        textView.setText(this.title);
        ImageView imageView2 = (ImageView) constraintLayout.findViewById(R.id.stepos_dialog_icon_badge);
        final float dimension = this.context.getResources().getDimension(R.dimen.stepos_dialog_icon_badge_corner_radius);
        imageView2.setOutlineProvider(new ViewOutlineProvider() { // from class: com.stepos.widget.dialog.StepOSAlertController.setupTitle.1
            @Override // android.view.ViewOutlineProvider
            public void getOutline(View view2, Outline outline) {
                kotlin.jvm.internal.p.i(view2, "view");
                kotlin.jvm.internal.p.i(outline, "outline");
                outline.setRoundRect(0, 0, view2.getWidth(), view2.getHeight(), dimension);
            }
        });
        imageView2.setClipToOutline(true);
        int i10 = this.iconResId;
        if (i10 != 0) {
            imageView.setImageResource(i10);
            imageView.setVisibility(0);
        } else {
            Drawable drawable = this.icon;
            if (drawable != null) {
                imageView.setImageDrawable(drawable);
                imageView.setVisibility(0);
            } else {
                imageView.setVisibility(8);
            }
        }
        refreshHeader();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void setupView() throws Resources.NotFoundException {
        NestedScrollView nestedScrollView;
        View viewFindViewById = this.window.findViewById(R.id.stepos_dialog_parent_panel);
        int i10 = R.id.stepos_dialog_top_panel;
        hideSystemVerticalScrollbar(viewFindViewById.findViewById(i10));
        hideSystemVerticalScrollbar(viewFindViewById.findViewById(R.id.stepos_dialog_scroll_view));
        int i11 = R.id.stepos_dialog_custom_panel;
        hideSystemVerticalScrollbar(viewFindViewById.findViewById(i11));
        View viewFindViewById2 = viewFindViewById.findViewById(i10);
        int i12 = R.id.stepos_dialog_content_panel;
        View viewFindViewById3 = viewFindViewById.findViewById(i12);
        int i13 = R.id.stepos_dialog_button_panel;
        View viewFindViewById4 = viewFindViewById.findViewById(i13);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById.findViewById(i11);
        kotlin.jvm.internal.p.f(viewGroup);
        setupCustomContent(viewGroup);
        ViewGroup viewGroupResolvePanel = resolvePanel(viewGroup.findViewById(i10), viewFindViewById2);
        ViewGroup viewGroupResolvePanel2 = resolvePanel(viewGroup.findViewById(i12), viewFindViewById3);
        ViewGroup viewGroupResolvePanel3 = resolvePanel(viewGroup.findViewById(i13), viewFindViewById4);
        setupContent(viewGroupResolvePanel2);
        setupButtons(viewGroupResolvePanel3);
        setupTitle(viewGroupResolvePanel);
        boolean z10 = viewGroup.getVisibility() != 8;
        boolean z11 = (viewGroupResolvePanel2 == null || viewGroupResolvePanel2.getVisibility() == 8) ? false : true;
        boolean z12 = (viewGroupResolvePanel == null || viewGroupResolvePanel.getVisibility() == 8) ? 0 : 1;
        boolean z13 = (viewGroupResolvePanel3 == null || viewGroupResolvePanel3.getVisibility() == 8) ? false : true;
        View viewFindViewById5 = viewFindViewById.findViewById(R.id.stepos_dialog_middle_panel);
        if (viewFindViewById5 != null) {
            viewFindViewById5.setVisibility((z11 || z10) ? 0 : 8);
        }
        if (z12 != 0 && (nestedScrollView = this.scrollView) != null) {
            nestedScrollView.setClipToPadding(true);
        }
        ListView listView = this.listView;
        StepOSDialogListView stepOSDialogListView = listView instanceof StepOSDialogListView ? (StepOSDialogListView) listView : null;
        if (stepOSDialogListView != null) {
            stepOSDialogListView.setHasDecor(z12, z13);
        }
        if (!z10 && !this.isActionStyle && this.listView == null && viewGroupResolvePanel2 != null && this.scrollView != null) {
            setScrollIndicators(viewGroupResolvePanel2, z12 | (z13 ? 2 : 0));
        }
        ListView listView2 = this.listView;
        ListAdapter listAdapter = this.adapter;
        if (listView2 != null && listAdapter != null) {
            listView2.setAdapter(listAdapter);
            int i14 = this.checkedItem;
            if (i14 > -1) {
                listView2.setItemChecked(i14, true);
                listView2.setSelection(this.checkedItem);
            }
        }
        kotlin.jvm.internal.p.f(viewFindViewById);
        setupSectionGaps(viewFindViewById, viewGroupResolvePanel, viewFindViewById5, viewGroupResolvePanel2, viewGroup, viewGroupResolvePanel3);
    }

    private final int visibleButtonBits() {
        int i10 = !TextUtils.isEmpty(this.buttonPositiveText) ? 1 : 0;
        if (!TextUtils.isEmpty(this.buttonNegativeText)) {
            i10 |= 2;
        }
        return !TextUtils.isEmpty(this.buttonNeutralText) ? i10 | 4 : i10;
    }

    public final void clearPendingMessages() {
        this.handler.removeCallbacksAndMessages(null);
    }

    public final void createIconContentView(StepOSAlertParams params) {
        kotlin.jvm.internal.p.i(params, "params");
        if (params.getHasIconContent()) {
            clearListItemsMode();
            this.hasIconContent = true;
            this.iconContentSelectedIndex = C5685n.n(params.getIconContentSelectedIndex(), 0, 1);
            this.iconContentListener = params.getIconContentListener();
            View viewBuildIconContentView = buildIconContentView(params);
            this.contentView = viewBuildIconContentView;
            this.iconContentRoot = viewBuildIconContentView;
            this.contentViewLayoutResId = 0;
            this.viewSpacingSpecified = false;
        }
    }

    public final void createListItemsView(StepOSAlertParams params) {
        kotlin.jvm.internal.p.i(params, "params");
        ArrayList<Pair<String, String>> listItems = params.getListItems();
        if (listItems == null) {
            return;
        }
        this.hasListItemsContent = true;
        setListItemsScrollbarEnabled(params.getListItemsScrollbarEnabled());
        this.contentView = buildListItemsGroup(listItems, params.getOnClickListener());
        this.contentViewLayoutResId = 0;
        this.viewSpacingSpecified = false;
    }

    public final void createListView(final StepOSAlertParams params) {
        ListAdapter adapter;
        int i10;
        ListAdapter stepOSDialogCenterItemAdapter;
        kotlin.jvm.internal.p.i(params, "params");
        View viewInflate = params.getInflater().inflate(this.listLayout, (ViewGroup) null);
        kotlin.jvm.internal.p.g(viewInflate, "null cannot be cast to non-null type com.stepos.widget.dialog.StepOSDialogListView");
        final StepOSDialogListView stepOSDialogListView = (StepOSDialogListView) viewInflate;
        if (params.getIsMultiChoice()) {
            i10 = this.multiChoiceItemLayout;
            Cursor cursor = params.getCursor();
            if (cursor == null) {
                adapter = new MultiChoiceArrayAdapter(this.context, this.multiChoiceItemLayout, StepOSAlertControllerKt.entriesOrEmpty(params), params.getCheckedItems(), stepOSDialogListView);
            } else {
                Context context = this.context;
                LayoutInflater inflater = params.getInflater();
                int i11 = this.multiChoiceItemLayout;
                String labelColumn = params.getLabelColumn();
                if (labelColumn == null) {
                    throw new IllegalArgumentException("labelColumn is required for a cursor");
                }
                String strIsCheckedColumn = params.getIsCheckedColumn();
                if (strIsCheckedColumn == null) {
                    throw new IllegalArgumentException("isCheckedColumn is required for a multi-choice cursor");
                }
                adapter = new MultiChoiceCursorAdapter(context, cursor, inflater, i11, labelColumn, strIsCheckedColumn, stepOSDialogListView);
                stepOSDialogListView = stepOSDialogListView;
            }
        } else if (params.getIsListItemCenter()) {
            i10 = this.centerListItemLayout;
            Cursor cursor2 = params.getCursor();
            adapter = params.getAdapter();
            if (cursor2 != null) {
                Context context2 = this.context;
                int i12 = this.centerListItemLayout;
                String labelColumn2 = params.getLabelColumn();
                if (labelColumn2 == null) {
                    throw new IllegalArgumentException("labelColumn is required for a cursor");
                }
                stepOSDialogCenterItemAdapter = new SimpleCursorAdapter(context2, i12, cursor2, new String[]{labelColumn2}, new int[]{R.id.stepos_dialog_list_item_text}, 0);
            } else {
                if (adapter == null) {
                    stepOSDialogCenterItemAdapter = new StepOSDialogCenterItemAdapter(this.context, this.centerListItemLayout, R.id.stepos_dialog_list_item_text, StepOSAlertControllerKt.entriesOrEmpty(params), params.getListItemColor(), params.getListItemColors());
                }
                i10 = 0;
            }
            adapter = stepOSDialogCenterItemAdapter;
        } else {
            int i13 = params.getIsSingleChoice() ? this.singleChoiceItemLayout : this.listItemLayout;
            Cursor cursor3 = params.getCursor();
            adapter = params.getAdapter();
            if (cursor3 != null) {
                Context context3 = this.context;
                String labelColumn3 = params.getLabelColumn();
                if (labelColumn3 == null) {
                    throw new IllegalArgumentException("labelColumn is required for a cursor");
                }
                adapter = new SimpleCursorAdapter(context3, i13, cursor3, new String[]{labelColumn3}, new int[]{R.id.stepos_dialog_list_item_text}, 0);
            } else {
                if (adapter == null) {
                    adapter = new StepOSDialogCheckedItemAdapter(this.context, i13, R.id.stepos_dialog_list_item_text, StepOSAlertControllerKt.entriesOrEmpty(params));
                }
                i10 = 0;
            }
            i10 = i13;
        }
        this.adapter = adapter;
        this.checkedItem = params.getCheckedItem();
        final DialogInterface.OnClickListener onClickListener = params.getOnClickListener();
        final DialogInterface.OnMultiChoiceClickListener onCheckboxClickListener = params.getOnCheckboxClickListener();
        if (onClickListener != null) {
            stepOSDialogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.stepos.widget.dialog.g
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i14, long j10) {
                    StepOSAlertController.createListView$lambda$38(onClickListener, this, params, adapterView, view, i14, j10);
                }
            });
        } else if (onCheckboxClickListener != null) {
            stepOSDialogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() { // from class: com.stepos.widget.dialog.h
                @Override // android.widget.AdapterView.OnItemClickListener
                public final void onItemClick(AdapterView adapterView, View view, int i14, long j10) {
                    StepOSAlertController.createListView$lambda$40(params, onCheckboxClickListener, this, stepOSDialogListView, adapterView, view, i14, j10);
                }
            });
        }
        AdapterView.OnItemSelectedListener onItemSelectedListener = params.getOnItemSelectedListener();
        if (onItemSelectedListener != null) {
            stepOSDialogListView.setOnItemSelectedListener(onItemSelectedListener);
        }
        if (i10 == this.singleChoiceItemLayout || i10 == this.multiChoiceItemLayout) {
            int i14 = this.listChoicePadding;
            stepOSDialogListView.setPaddingRelative(i14, 0, i14, 0);
            stepOSDialogListView.setSelector(androidx.core.content.a.e(this.context, android.R.color.transparent));
        }
        if (params.getIsSingleChoice()) {
            stepOSDialogListView.setChoiceMode(1);
        } else if (params.getIsMultiChoice()) {
            stepOSDialogListView.setChoiceMode(2);
        }
        stepOSDialogListView.setDividerHeight(this.listItemSpacing);
        this.listView = stepOSDialogListView;
    }

    public final void createMultiLinesView(StepOSAlertParams params) {
        StepOSDialogMultiLineAdapter stepOSDialogMultiLineAdapter;
        kotlin.jvm.internal.p.i(params, "params");
        ArrayList<Pair<String, String>> itemData = params.getItemData();
        if (itemData == null) {
            return;
        }
        View viewInflate = params.getInflater().inflate(this.multiLinesChoiceLayout, (ViewGroup) null);
        RecyclerView recyclerView = (RecyclerView) viewInflate.findViewById(R.id.stepos_dialog_recycler_view);
        boolean[] checkedItems = params.getCheckedItems();
        if (checkedItems != null) {
            stepOSDialogMultiLineAdapter = new StepOSDialogMultiLineAdapter(this.dialog, this.context, this.multiLinesItemLayout, itemData, checkedItems, params.getOnCheckboxClickListener());
        } else if (params.getCheckedItem() > itemData.size()) {
            return;
        } else {
            stepOSDialogMultiLineAdapter = new StepOSDialogMultiLineAdapter(this.dialog, this.context, this.multiLinesSingleItemLayout, itemData, params.getCheckedItem(), params.getOnClickListener());
        }
        recyclerView.setAdapter(stepOSDialogMultiLineAdapter);
        final int i10 = this.listItemSpacing;
        recyclerView.addItemDecoration(new RecyclerView.ItemDecoration() { // from class: com.stepos.widget.dialog.StepOSAlertController.createMultiLinesView.1
            @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
            public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
                kotlin.jvm.internal.p.i(outRect, "outRect");
                kotlin.jvm.internal.p.i(view, "view");
                kotlin.jvm.internal.p.i(parent, "parent");
                kotlin.jvm.internal.p.i(state, "state");
                if (parent.getChildAdapterPosition(view) != 0) {
                    outRect.top = i10;
                }
            }
        });
        recyclerView.setLayoutManager(new LinearLayoutManager(this.context));
        params.setView(viewInflate);
    }

    public final StepOSButton getButton(int whichButton) {
        if (whichButton == -3) {
            return this.buttonNeutral;
        }
        if (whichButton == -2) {
            return this.buttonNegative;
        }
        if (whichButton != -1) {
            return null;
        }
        return this.buttonPositive;
    }

    public final int getButtonLayout() {
        return this.buttonLayout;
    }

    public final y7.o getGlassEffect() {
        return this.glassEffect;
    }

    public final int getGravity() {
        return this.gravity;
    }

    public final int getIconAttributeResId(int attrId) {
        TypedValue typedValue = new TypedValue();
        this.context.getTheme().resolveAttribute(attrId, typedValue, true);
        return typedValue.resourceId;
    }

    public final Drawable getIconBadge() {
        return this.iconBadge;
    }

    public final boolean getListItemsScrollbarEnabled() {
        return this.listItemsScrollbarEnabled;
    }

    public final ListView getListView() {
        return this.listView;
    }

    public final int getMessageMaxLines() {
        return this.messageMaxLines;
    }

    public final int getMultiLinesItemCount() {
        return this.multiLinesItemCount;
    }

    public final int getTitleMaxLines() {
        return this.titleMaxLines;
    }

    public final void installContent() throws Resources.NotFoundException {
        this.dialog.setContentView(this.dialogLayout);
        setupView();
        this.contentInstalled = true;
        StepOSAlertDialogLayout stepOSAlertDialogLayoutDialogPanel = dialogPanel();
        if (stepOSAlertDialogLayoutDialogPanel != null) {
            stepOSAlertDialogLayoutDialogPanel.setGlassEnabled(this.isGlassEnabled);
            stepOSAlertDialogLayoutDialogPanel.setGlassEffect(this.glassEffect);
        }
        applyStepOSStyle();
    }

    /* renamed from: isGlassEnabled, reason: from getter */
    public final boolean getIsGlassEnabled() {
        return this.isGlassEnabled;
    }

    /* renamed from: isMultiLines, reason: from getter */
    public final boolean getIsMultiLines() {
        return this.isMultiLines;
    }

    public final boolean onKeyDown(KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        NestedScrollView nestedScrollView = this.scrollView;
        return nestedScrollView != null && nestedScrollView.n(event);
    }

    public final boolean onKeyUp(KeyEvent event) {
        kotlin.jvm.internal.p.i(event, "event");
        NestedScrollView nestedScrollView = this.scrollView;
        return nestedScrollView != null && nestedScrollView.n(event);
    }

    public final void setAutoShowSoftInput(boolean show) {
        this.autoShowSoftInput = show;
    }

    public final void setButton(int whichButton, CharSequence text, DialogInterface.OnClickListener listener, Message msg, Drawable icon) {
        if (msg == null) {
            msg = listener != null ? this.handler.obtainMessage(whichButton, listener) : null;
        }
        if (whichButton == -3) {
            this.buttonNeutralText = text;
            this.buttonNeutralMessage = msg;
            this.buttonNeutralIcon = icon;
        } else if (whichButton == -2) {
            this.buttonNegativeText = text;
            this.buttonNegativeMessage = msg;
            this.buttonNegativeIcon = icon;
        } else {
            if (whichButton != -1) {
                throw new IllegalArgumentException("whichButton must be one of DialogInterface.BUTTON_POSITIVE / BUTTON_NEGATIVE / BUTTON_NEUTRAL but was " + whichButton);
            }
            this.buttonPositiveText = text;
            this.buttonPositiveMessage = msg;
            this.buttonPositiveIcon = icon;
        }
        refreshButtons();
    }

    public final void setButtonLayout(int i10) {
        if (i10 >= 0 && i10 < 3) {
            this.buttonLayout = i10;
            refreshButtons();
        } else {
            throw new IllegalArgumentException(("buttonLayout must be AUTO, HORIZONTAL or VERTICAL but was " + i10).toString());
        }
    }

    public final void setButtonTextColor(int whichButton, int colorResId) {
        StepOSButton button = getButton(whichButton);
        if (button != null) {
            button.setTextColor(androidx.core.content.a.d(this.context, colorResId));
        }
    }

    public final void setCustomPaddingRule(int space1, int space2, int space3, int space4) {
        this.useCustomPadding = true;
        this.customSpace1 = space1;
        this.customSpace2 = space2;
        this.customSpace3 = space3;
        this.customSpace4 = space4;
        if (this.contentInstalled) {
            refreshSectionGaps();
        }
    }

    public final void setCustomTitle(View customTitleView) throws Resources.NotFoundException {
        View view = this.customTitleView;
        ViewParent parent = view != null ? view.getParent() : null;
        ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
        if (viewGroup != null) {
            viewGroup.removeView(this.customTitleView);
        }
        this.customTitleView = customTitleView;
        if (this.contentInstalled) {
            setupTitle((ViewGroup) this.window.findViewById(R.id.stepos_dialog_top_panel));
        }
    }

    public final void setGlassEffect(y7.o oVar) {
        if (kotlin.jvm.internal.p.d(this.glassEffect, oVar)) {
            return;
        }
        this.glassEffect = oVar;
        StepOSAlertDialogLayout stepOSAlertDialogLayoutDialogPanel = dialogPanel();
        if (stepOSAlertDialogLayoutDialogPanel != null) {
            stepOSAlertDialogLayoutDialogPanel.setGlassEffect(oVar);
        }
    }

    public final void setGlassEnabled(boolean z10) {
        this.isGlassEnabled = z10;
        StepOSAlertDialogLayout stepOSAlertDialogLayoutDialogPanel = dialogPanel();
        if (stepOSAlertDialogLayoutDialogPanel != null) {
            stepOSAlertDialogLayoutDialogPanel.setGlassEnabled(z10);
        }
    }

    public final void setGravity(int i10) {
        this.gravity = i10;
    }

    public final void setHighLightButton(int whichButton, int color) {
        if (whichButton != 0 && whichButton != -1 && whichButton != -2 && whichButton != -3) {
            throw new IllegalArgumentException(("whichButton must be 0 or one of DialogInterface.BUTTON_* but was " + whichButton).toString());
        }
        if (color < 0 || color >= 4) {
            throw new IllegalArgumentException(("color must be one of StepOSAlertDialog.COLOR_NORMAL / COLOR_BLUE / COLOR_RED / COLOR_POLESTAR but was " + color).toString());
        }
        this.highLightButton = whichButton;
        this.highLightColor = color;
        refreshButtons();
    }

    public final void setIcon(int resId) throws Resources.NotFoundException {
        this.icon = null;
        this.iconResId = resId;
        ImageView imageView = this.iconView;
        if (imageView != null) {
            if (resId != 0) {
                imageView.setVisibility(0);
                imageView.setImageResource(resId);
            } else {
                imageView.setVisibility(8);
            }
        }
        refreshHeader();
    }

    public final void setIconBadge(Drawable drawable) throws Resources.NotFoundException {
        this.iconBadge = drawable;
        refreshHeader();
    }

    public final void setIconContent(Drawable leftIcon, int leftIconRes, CharSequence leftLabel, Drawable rightIcon, int rightIconRes, CharSequence rightLabel, int selectedIndex, DialogInterface.OnClickListener listener) throws Resources.NotFoundException {
        clearListItemsMode();
        StepOSAlertParams stepOSAlertParams = new StepOSAlertParams(this.context);
        stepOSAlertParams.setHasIconContent(true);
        stepOSAlertParams.setIconContentLeftIcon(leftIcon);
        stepOSAlertParams.setIconContentLeftIconId(leftIconRes);
        stepOSAlertParams.setIconContentLeftLabel(leftLabel);
        stepOSAlertParams.setIconContentRightIcon(rightIcon);
        stepOSAlertParams.setIconContentRightIconId(rightIconRes);
        stepOSAlertParams.setIconContentRightLabel(rightLabel);
        stepOSAlertParams.setIconContentSelectedIndex(selectedIndex);
        stepOSAlertParams.setIconContentListener(listener);
        createIconContentView(stepOSAlertParams);
        if (this.contentInstalled) {
            refreshCustomContent();
        }
    }

    public final void setListItems(ArrayList<Pair<String, String>> items, DialogInterface.OnClickListener listener) throws Resources.NotFoundException {
        if (items == null || items.isEmpty()) {
            clearListItemsMode();
            this.contentView = null;
            this.contentViewLayoutResId = 0;
            if (this.contentInstalled) {
                refreshCustomContent();
                return;
            }
            return;
        }
        clearIconContentMode();
        StepOSAlertParams stepOSAlertParams = new StepOSAlertParams(this.context);
        stepOSAlertParams.setListItems(items);
        stepOSAlertParams.setOnClickListener(listener);
        stepOSAlertParams.setListItemsScrollbarEnabled(this.listItemsScrollbarEnabled);
        createListItemsView(stepOSAlertParams);
        if (this.contentInstalled) {
            refreshCustomContent();
        }
    }

    public final void setListItemsScrollbarEnabled(boolean z10) {
        this.listItemsScrollbarEnabled = z10;
        if (this.contentInstalled && this.hasListItemsContent) {
            applyListItemsScrollbar$default(this, null, 1, null);
        }
    }

    public final void setMaxHeight(int height) {
        StepOSAlertDialogLayout stepOSAlertDialogLayout;
        if (height < 0) {
            throw new IllegalArgumentException(("maxHeight must be >= 0 but was " + height).toString());
        }
        this.maxHeight = height;
        if (!this.contentInstalled || (stepOSAlertDialogLayout = (StepOSAlertDialogLayout) this.window.findViewById(R.id.stepos_dialog_parent_panel)) == null) {
            return;
        }
        if (height == 0) {
            height = defaultMaxHeight();
        }
        stepOSAlertDialogLayout.setMaxHeight(height);
    }

    public final void setMessage(CharSequence message) throws Resources.NotFoundException {
        this.message = message;
        refreshHeader();
    }

    public final void setMessageMaxLines(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("messageMaxLines must be > 0 but was " + i10).toString());
        }
        if (this.messageMaxLines == i10) {
            return;
        }
        this.messageMaxLines = i10;
        TextView textView = this.messageView;
        if (textView != null) {
            textView.setMaxLines(i10);
        }
    }

    public final void setMessageMovementMethod(MovementMethod movementMethod) {
        this.messageMovementMethod = movementMethod;
        TextView textView = this.messageView;
        if (textView != null) {
            textView.setMovementMethod(movementMethod);
        }
    }

    public final void setMultiLines(boolean z10) {
        this.isMultiLines = z10;
    }

    public final void setMultiLinesItemCount(int i10) {
        this.multiLinesItemCount = i10;
    }

    public final void setTitle(CharSequence title) throws Resources.NotFoundException {
        this.title = title;
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setText(title);
        }
        refreshHeader();
    }

    public final void setTitleMaxLines(int i10) {
        if (i10 <= 0) {
            throw new IllegalArgumentException(("titleMaxLines must be > 0 but was " + i10).toString());
        }
        if (this.titleMaxLines == i10) {
            return;
        }
        this.titleMaxLines = i10;
        TextView textView = this.titleView;
        if (textView != null) {
            textView.setMaxLines(i10);
        }
    }

    public final void setUpAnimation() {
        double dComputeDialogHeightRatio = computeDialogHeightRatio();
        boolean zHasEditText = hasEditText();
        int i10 = dComputeDialogHeightRatio < DIALOG_SMALL ? zHasEditText ? R.style.StepOSAnimation_Dialog_Alert_Input_Short : R.style.StepOSAnimation_Dialog_Alert_Short : dComputeDialogHeightRatio < DIALOG_MEDIUM ? zHasEditText ? R.style.StepOSAnimation_Dialog_Alert_Input_Medium : R.style.StepOSAnimation_Dialog_Alert_Medium : R.style.StepOSAnimation_Dialog_Alert_Tall;
        Window window = this.dialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(i10);
        }
    }

    public final void setView(int layoutResId) throws Resources.NotFoundException {
        this.contentView = null;
        this.contentViewLayoutResId = layoutResId;
        this.viewSpacingSpecified = false;
        if (layoutResId != 0) {
            clearListItemsMode();
            clearIconContentMode();
        }
        refreshCustomContent();
    }

    public final void setView(View view) throws Resources.NotFoundException {
        this.contentView = view;
        this.contentViewLayoutResId = 0;
        this.viewSpacingSpecified = false;
        if (view != null) {
            clearListItemsMode();
            clearIconContentMode();
        }
        refreshCustomContent();
    }

    public final void setIcon(Drawable icon) throws Resources.NotFoundException {
        this.icon = icon;
        this.iconResId = 0;
        ImageView imageView = this.iconView;
        if (imageView != null) {
            if (icon != null) {
                imageView.setVisibility(0);
                imageView.setImageDrawable(icon);
            } else {
                imageView.setVisibility(8);
            }
        }
        refreshHeader();
    }

    public final void setView(View view, int left, int top, int right, int bottom) throws Resources.NotFoundException {
        this.contentView = view;
        this.contentViewLayoutResId = 0;
        this.viewSpacingSpecified = true;
        this.viewSpacingLeft = left;
        this.viewSpacingTop = top;
        this.viewSpacingRight = right;
        this.viewSpacingBottom = bottom;
        if (view != null) {
            clearListItemsMode();
            clearIconContentMode();
        }
        refreshCustomContent();
    }
}
