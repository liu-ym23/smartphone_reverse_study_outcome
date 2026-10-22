package com.android.contacts.list;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.ContentResolver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Rect;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import androidx.core.content.res.ResourcesCompat;
import androidx.fragment.app.FragmentActivity;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsUtils;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.activities.ContactSelectionActivity;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.bytedanceosquickcontact.QuickContactClickedView;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.widget.ProgressDialog;
import com.android.contacts.widget.SelectAllState;
import com.android.contacts.widget.dslv.DragSortController;
import com.android.contacts.widget.dslv.DragSortListView;
import com.android.contacts.widget.dslv.ForceTouchAdapterController;
import com.android.vcard.VCardConfig;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.obric.anim.ListAnimator;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.ui.ListTouchHelper;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.OUIHelper;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obricOld.contacts.menus.LongMenuHelper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import obric.app.tracker.Agent;

/* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000æ\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u0014\u0018\u0000 »\u00012\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t:\u000eº\u0001»\u0001¼\u0001½\u0001¾\u0001¿\u0001À\u0001B\u0005¢\u0006\u0002\u0010\nJ\b\u0010]\u001a\u00020\u0016H\u0016J\b\u0010^\u001a\u00020_H\u0002J\b\u0010`\u001a\u00020_H\u0002J\b\u0010a\u001a\u00020_H\u0002J\b\u0010b\u001a\u00020_H\u0002J\b\u0010c\u001a\u00020_H\u0002J\u0006\u0010d\u001a\u00020_J2\u0010e\u001a\u00020\u00162\u001e\u0010f\u001a\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010/j\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`02\b\u0010g\u001a\u0004\u0018\u00010\fH\u0002J\u001a\u0010h\u001a\u00020\u00162\u0006\u0010i\u001a\u00020.2\b\u0010g\u001a\u0004\u0018\u00010\fH\u0002J\b\u0010j\u001a\u00020_H\u0002J,\u0010k\u001a\u00020\u001e2\u0006\u0010l\u001a\u00020m2\b\u0010n\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010q2\u0006\u0010r\u001a\u00020sH\u0004J\"\u0010t\u001a\u00020_2\u0006\u0010u\u001a\u00020s2\u0006\u0010v\u001a\u00020s2\b\u0010w\u001a\u0004\u0018\u00010xH\u0016J\u0010\u0010y\u001a\u00020_2\u0006\u0010z\u001a\u00020\u0018H\u0016J\u0012\u0010{\u001a\u00020_2\b\u0010|\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010}\u001a\u00020_H\u0002J\b\u0010~\u001a\u00020_H\u0002J\u0010\u0010\u007f\u001a\u00020_2\u0006\u0010|\u001a\u00020\u001eH\u0002J\u0011\u0010\u0080\u0001\u001a\u00020_2\u0006\u0010|\u001a\u00020\u001eH\u0002J\u0013\u0010\u0081\u0001\u001a\u00020_2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J%\u0010\u0082\u0001\u001a\u00020\u001e2\u0006\u0010l\u001a\u00020m2\b\u0010n\u001a\u0004\u0018\u00010o2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\t\u0010\u0083\u0001\u001a\u00020_H\u0016J\t\u0010\u0084\u0001\u001a\u00020_H\u0002J5\u0010\u0085\u0001\u001a\u00020_2\u000e\u0010\u0086\u0001\u001a\t\u0012\u0002\b\u0003\u0018\u00010\u0087\u00012\b\u0010|\u001a\u0004\u0018\u00010\u001e2\u0007\u0010\u0088\u0001\u001a\u00020s2\u0007\u0010\u0089\u0001\u001a\u00020.H\u0016J+\u0010\u008a\u0001\u001a\u00020\u00162\n\u0010\u008b\u0001\u001a\u0005\u0018\u00010\u008c\u00012\t\u0010\u008d\u0001\u001a\u0004\u0018\u00010\u001e2\t\u0010w\u001a\u0005\u0018\u00010\u008e\u0001H\u0016J\t\u0010\u008f\u0001\u001a\u00020_H\u0016J\u0007\u0010\u0090\u0001\u001a\u00020_J\t\u0010\u0091\u0001\u001a\u00020_H\u0016J0\u0010\u0092\u0001\u001a\u00020_2\n\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020s2\u0007\u0010\u0096\u0001\u001a\u00020s2\u0007\u0010\u0097\u0001\u001a\u00020sH\u0016J\u001c\u0010\u0098\u0001\u001a\u00020_2\b\u0010\u0093\u0001\u001a\u00030\u0094\u00012\u0007\u0010\u0095\u0001\u001a\u00020sH\u0016J\t\u0010\u0099\u0001\u001a\u00020_H\u0016J \u0010\u009a\u0001\u001a\u00020\u00162\t\u0010\u0093\u0001\u001a\u0004\u0018\u00010\u001e2\n\u0010\u0095\u0001\u001a\u0005\u0018\u00010\u009b\u0001H\u0016J\u001b\u0010\u009c\u0001\u001a\u00020_2\u0006\u0010|\u001a\u00020\u001e2\b\u0010p\u001a\u0004\u0018\u00010qH\u0016J\u0012\u0010\u009d\u0001\u001a\u00020_2\u0007\u0010\u009e\u0001\u001a\u00020\u0016H\u0016J\t\u0010\u009f\u0001\u001a\u00020_H\u0002J\t\u0010 \u0001\u001a\u00020_H\u0002J\t\u0010¡\u0001\u001a\u00020_H\u0016J\u0010\u0010¢\u0001\u001a\u00020_2\u0007\u0010£\u0001\u001a\u00020\u001cJ\u0010\u0010¤\u0001\u001a\u00020_2\u0007\u0010¥\u0001\u001a\u00020(J\t\u0010¦\u0001\u001a\u00020_H\u0002J\u001b\u0010§\u0001\u001a\u00020_2\u0007\u0010\u009e\u0001\u001a\u00020\u00162\u0007\u0010¨\u0001\u001a\u00020\u0016H\u0016J\u0010\u0010©\u0001\u001a\u00020_2\u0007\u0010ª\u0001\u001a\u000205J\u0013\u0010«\u0001\u001a\u00020_2\n\u0010¬\u0001\u001a\u0005\u0018\u00010\u00ad\u0001J\u0012\u0010®\u0001\u001a\u00020_2\u0007\u0010¯\u0001\u001a\u00020\u0016H\u0002J\u0010\u0010°\u0001\u001a\u00020_2\u0007\u0010ª\u0001\u001a\u00020TJ\u0007\u0010±\u0001\u001a\u00020_J\t\u0010²\u0001\u001a\u00020_H\u0002J\u0010\u0010³\u0001\u001a\u00020_2\u0007\u0010´\u0001\u001a\u00020xJ\t\u0010µ\u0001\u001a\u00020_H\u0002J\t\u0010¶\u0001\u001a\u00020_H\u0002J\t\u0010·\u0001\u001a\u00020_H\u0002J\u0007\u0010¸\u0001\u001a\u00020_J\t\u0010¹\u0001\u001a\u00020_H\u0002R\u0014\u0010\u000b\u001a\u00020\fX\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\fX\u0082D¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001f\u001a\b\u0018\u00010 R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010!\u001a\b\u0018\u00010\"R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010%\u001a\u0004\u0018\u00010&X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010*\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010+\u001a\u0004\u0018\u00010\u001eX\u0082\u000e¢\u0006\u0002\n\u0000R^\u0010,\u001aR\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010/j\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`00-j(\u0012\u0006\u0012\u0004\u0018\u00010.\u0012\u001c\u0012\u001a\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u00010/j\f\u0012\u0006\u0012\u0004\u0018\u00010\f\u0018\u0001`0`1X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u00104\u001a\u0004\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000207X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\u0016X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020=X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010>\u001a\u0004\u0018\u00010?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010A\u001a\u0004\u0018\u00010BX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020DX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020FX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020HX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020JX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020LX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010M\u001a\u0004\u0018\u00010NX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020PX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010Q\u001a\u0004\u0018\u00010RX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010U\u001a\u0004\u0018\u00010VX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010W\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010X\u001a\u0004\u0018\u00010YX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Z\u001a\u0004\u0018\u00010[X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Á\u0001"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment;", "Lcom/android/contacts/AbstractFragment;", "Landroid/view/View$OnTouchListener;", "Landroid/view/View$OnClickListener;", "Landroid/widget/AbsListView$OnScrollListener;", "Lcom/android/contacts/activities/DialtactsActivity$ViewPagerVisibilityListener;", "Lcom/android/contacts/activities/DialtactsActivity$PageEnableListener;", "Landroid/widget/AdapterView$OnItemClickListener;", "Lcom/android/contacts/activities/DialtactsActivity$ReleaseResourceListener;", "Lcom/android/contacts/activities/DialtactsActivity$onBackPressListener;", "()V", "STATE_EMPTY", "", "getSTATE_EMPTY", "()Ljava/lang/String;", "TAG_LIST", "allPhoneStared", "Ljava/util/Vector;", "Lcom/android/contacts/list/FavoriteContact;", "getAllPhoneStared", "()Ljava/util/Vector;", "dismissDialog", "", "mActivity", "Landroid/app/Activity;", "mAdapter", "Lcom/android/contacts/list/FavoriteAdapter;", "mBottomDeleteLayoutListener", "Lcom/android/contacts/list/BottomDeleteLayoutListener;", "mBtnDone", "Landroid/view/View;", "mChangeThread", "Lcom/android/contacts/list/NewPhoneFavoriteFragment$ChangeThread;", "mContactsContent", "Lcom/android/contacts/list/NewPhoneFavoriteFragment$ContactsContent;", "mCurMode", "Lcom/android/contacts/list/NewPhoneFavoriteFragment$UIMode;", "mDeleteDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "mDialtactsActivity", "Lcom/android/contacts/activities/DialtactsActivity;", "mDraging", "mFavoriteContacts", "mFavoriteFragment", "mFavoriteNumberMap", "Ljava/util/HashMap;", "", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "Lkotlin/collections/HashMap;", "mForceTouchController", "Lcom/android/contacts/widget/dslv/ForceTouchAdapterController;", "mFragmentsCallback", "Lcom/android/contacts/ContactFragmentsCallback;", "mHandler", "Landroid/os/Handler;", "mIsAnimationing", "mIsClickedBtnAdd", "mItemLongClickedListener", "Lcom/android/contacts/list/HorizontalScrollListView$ItemLongClickedListener;", "mListAnimator", "Lcom/obric/anim/ListAnimator;", "mListView", "Lcom/android/contacts/widget/dslv/DragSortListView;", "mNeedReloadData", "mOTitleBarHolder", "Lcom/obric/ui/OFloatingTitleBarHolder;", "mOnDrag", "Lcom/android/contacts/widget/dslv/DragSortListView$DragListener;", "mOnDragStart", "Lcom/android/contacts/widget/dslv/DragSortListView$DragStartListener;", "mOnDrop", "Lcom/android/contacts/widget/dslv/DragSortListView$DropListener;", "mOnMove", "Lcom/android/contacts/widget/dslv/DragSortListView$MoveListener;", "mOnRemove", "Lcom/android/contacts/widget/dslv/DragSortListView$RemoveListener;", "mPhotoManager", "Lcom/android/contacts/ContactPhotoManager;", "mPool", "Ljava/util/concurrent/ExecutorService;", "mPopover", "Lcom/obric/oui/popover/v2/OPopover;", "mPrefersCallback", "Lcom/android/contacts/PreferencesCallback;", "mProgressDialog", "Lcom/android/contacts/widget/ProgressDialog;", "mProviderIsNormal", "mQuickContactClickedView", "Lcom/android/contacts/bytedanceosquickcontact/QuickContactClickedView;", "mSelectedAll", "Lcom/android/contacts/widget/SelectAllState;", "mVisible", "backToTopState", "cancelAnimation", "", "clickedBtnCancel", "dismissProgressDialog", "doRemoveAction", "editAnimation", "exitEditMode", "hasExist", "list", "number", "hasExistInMap", "contact_id", "hideSoftKeyboard", "inflateAndSetupView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "layoutResourceId", "", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAttach", "activity", "onClick", "view", "onClickAdd", "onClickEdit", "onClickMenu", "onClickSelectAll", "onCreate", "onCreateView", "onDestroy", "onExitEditMode", "onItemClick", "parent", "Landroid/widget/AdapterView;", "position", "id", "onMenuItemClicked", "menuType", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "anchor", "", "onPause", "onPreferencesChanged", "onResume", "onScroll", "arg0", "Landroid/widget/AbsListView;", "arg1", "arg2", "arg3", "onScrollStateChanged", "onStop", "onTouch", "Landroid/view/MotionEvent;", "onViewCreated", "onVisibilityChanged", "visible", "refreshListView", "registerObserver", "release", "setBottomDeleteLayoutListener", "listener", "setDialtactsActivity", "dialtactsActivity", "setEmptyView", "setEnable", "triggerload", "setFragmentsCallback", "callback", "setListener", "mPhoneFavoriteListener", "Lcom/android/contacts/list/NewPhoneFavoriteFragment$Listener;", "setObserverToWork", "needWork", "setPrefsCallback", "showDeleteFavoriteDialog", "showProgressDialog", "startActivityAndForwardResult", MemorySourceLinkType.INTENT, "triggerLoad", "unregisterObserver", "updateButtonsState", "updateListViewState", "updateSelectedStatus", "ChangeThread", "Companion", "ContactsContent", "FavoriteQuery", "Listener", "RemoveTask", "UIMode", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewPhoneFavoriteFragment extends AbstractFragment implements View.OnTouchListener, View.OnClickListener, AbsListView.OnScrollListener, DialtactsActivity.ViewPagerVisibilityListener, DialtactsActivity.PageEnableListener, AdapterView.OnItemClickListener, DialtactsActivity.ReleaseResourceListener, DialtactsActivity.onBackPressListener {
    public static final Companion Companion = null;
    private static final int DELAY_TIME_TO_QUERY = 500;
    private static final int MSG_FAVORITE_EXIT_EDIT_MODE = 1;
    private static final int MSG_REFRESH_LISTVIEW = 4;
    private static final int MSG_RELOAD_FAVORITE_AFTER_DB_CHANGE = 2;
    private static final int PRELOAD_VIEW_COUNT = 10;
    public static final int REQUEST_CODE_PICK_UNFAVORITE = 30;
    private static final int SHOW_PROGRESS_DELAY = 1000;
    public static final String TAG = "NewPhoneFavoriteFragment";
    private static final LongMenuHelper.MenuType[] sLongMenuItems = null;
    private final String STATE_EMPTY;
    private final String TAG_LIST;
    private boolean dismissDialog;
    private Activity mActivity;
    private FavoriteAdapter mAdapter;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private View mBtnDone;
    private ChangeThread mChangeThread;
    private ContactsContent mContactsContent;
    private volatile UIMode mCurMode;
    private OAlertDialog mDeleteDialog;
    private DialtactsActivity mDialtactsActivity;
    private boolean mDraging;
    private Vector<FavoriteContact> mFavoriteContacts;
    private View mFavoriteFragment;
    private final HashMap<Long, ArrayList<String>> mFavoriteNumberMap;
    private ForceTouchAdapterController mForceTouchController;
    private ContactFragmentsCallback mFragmentsCallback;
    private final Handler mHandler;
    private final boolean mIsAnimationing;
    private boolean mIsClickedBtnAdd;
    private final HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private final ListAnimator mListAnimator;
    private DragSortListView mListView;
    private boolean mNeedReloadData;
    private OFloatingTitleBarHolder mOTitleBarHolder;
    private final DragSortListView.DragListener mOnDrag;
    private final DragSortListView.DragStartListener mOnDragStart;
    private final DragSortListView.DropListener mOnDrop;
    private final DragSortListView.MoveListener mOnMove;
    private final DragSortListView.RemoveListener mOnRemove;
    private ContactPhotoManager mPhotoManager;
    private final ExecutorService mPool;
    private OPopover mPopover;
    private PreferencesCallback mPrefersCallback;
    private ProgressDialog mProgressDialog;
    private boolean mProviderIsNormal;
    private QuickContactClickedView mQuickContactClickedView;
    private SelectAllState mSelectedAll;
    private boolean mVisible;

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment$ChangeThread;", "Ljava/lang/Thread;", "(Lcom/android/contacts/list/NewPhoneFavoriteFragment;)V", "run", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ChangeThread extends Thread {
        final /* synthetic */ NewPhoneFavoriteFragment this$0;

        public ChangeThread(NewPhoneFavoriteFragment r1) {
            this.this$0 = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            FavoriteAdapter r3 = NewPhoneFavoriteFragment.access$getMAdapter$p(this.this$0);     // Catch: Throwable -> L21
            if (r3 == null) goto L7;
            List<FavoriteContact> r4 = r3.getList();     // Catch: Throwable -> L21
        L8:
            if (r4 == null) goto L10;
            String[] r5 = new String[r4.size()];     // Catch: Throwable -> L21
            int r6 = r4.size();     // Catch: Throwable -> L21
            int r7 = 0;
        L14:
            if (r7 >= r6) goto L16;
            r5[r7] = r4.get(r7).number;     // Catch: Throwable -> L21
            r7 = r7 + 1;     // Catch: Throwable -> L21
            goto L14
        L16:
            ContactSaveService.setPhoneStarted(this.this$0.getActivity(), r5, ContactSaveService.FavoriteAction.RESET);     // Catch: Throwable -> L21
            if (NewPhoneFavoriteFragment.access$getMCurMode$p(this.this$0).isChanging() == true) goto L30;
            NewPhoneFavoriteFragment.access$getMHandler$p(this.this$0).sendEmptyMessageDelayed(1, 0);
            return;
        L30:
            return;
        L10:
            if (NewPhoneFavoriteFragment.access$getMCurMode$p(this.this$0).isChanging() == true) goto L29;
            NewPhoneFavoriteFragment.access$getMHandler$p(this.this$0).sendEmptyMessageDelayed(1, 0);
            return;
        L29:
            return;
        L7:
            r4 = null;
        L21:
            th = move-exception;
            if (NewPhoneFavoriteFragment.access$getMCurMode$p(this.this$0).isChanging() == true) goto L25;
            NewPhoneFavoriteFragment.access$getMHandler$p(this.this$0).sendEmptyMessageDelayed(1, 0);
        L25:
            throw th;
        }
    }

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0086T¢\u0006\u0002\n\u0000R\u0018\u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000f0\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment$Companion;", "", "()V", "DELAY_TIME_TO_QUERY", "", "MSG_FAVORITE_EXIT_EDIT_MODE", "MSG_REFRESH_LISTVIEW", "MSG_RELOAD_FAVORITE_AFTER_DB_CHANGE", "PRELOAD_VIEW_COUNT", "REQUEST_CODE_PICK_UNFAVORITE", "SHOW_PROGRESS_DELAY", "TAG", "", "sLongMenuItems", "", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "[Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment$ContactsContent;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "(Lcom/android/contacts/list/NewPhoneFavoriteFragment;Landroid/os/Handler;)V", "onChange", "", "selfChange", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ContactsContent extends ContentObserver {
        final /* synthetic */ NewPhoneFavoriteFragment this$0;

        public ContactsContent(NewPhoneFavoriteFragment r2, Handler r3) {
            Intrinsics.checkNotNullParameter(r3, "handler");
            this.this$0 = r2;
            super(r3);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r2) {
            super.onChange(r2);
            if (NewPhoneFavoriteFragment.access$getMAdapter$p(this.this$0) == null) goto L9;
            FavoriteAdapter r3 = NewPhoneFavoriteFragment.access$getMAdapter$p(this.this$0);
            if (r3 == null) goto L9;
            r3.setFavoriteCancleState(false);
        L9:
            if (this.this$0.getActivity() != null) goto L12;
            return;
        L12:
            if (NewPhoneFavoriteFragment.access$getMProviderIsNormal$p(this.this$0) == true) goto L18;
            if (ContactsUtils.DEBUG == false) goto L25;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewPhoneFavoriteFragment.TAG, "The contact database state hasn't ready.");
            return;
        L25:
            return;
        L18:
            if (NewPhoneFavoriteFragment.access$getMCurMode$p(this.this$0).isNormal() == false) goto L20;
            NewPhoneFavoriteFragment.access$getMHandler$p(this.this$0).removeMessages(2);
            NewPhoneFavoriteFragment.access$getMHandler$p(this.this$0).sendEmptyMessage(2);
            return;
        L20:
            if (ContactsUtils.DEBUG == false) goto L26;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewPhoneFavoriteFragment.TAG, "Database has change but status is edit, so return it");
            return;
        }
    }

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\b\u0005\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u00142\u0006\u0010\u0017\u001a\u00020\u0004¢\u0006\u0002\u0010\u0018R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00020\u0010X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00100\u0014X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0015¨\u0006\u0019"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment$FavoriteQuery;", "", "()V", "FAVORITE_CONTACT_ID", "", "FAVORITE_CUSTOM_LABEL_RES", "FAVORITE_DATA1", "FAVORITE_DATA4", "FAVORITE_DATA_ID", "FAVORITE_DISPLAY_NAME", "FAVORITE_INDEX", "FAVORITE_LOOKUP_KEY", "FAVORITE_PHONE_LABEL", "FAVORITE_PHOTO_ID", "FAVORITE_RAW_CONTACT_ID", "SELECTION", "", "getSELECTION", "()Ljava/lang/String;", "sFavoriteProjection", "", "[Ljava/lang/String;", "getFavoriteProjection", "displayOrder", "(I)[Ljava/lang/String;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class FavoriteQuery {
        public static final int FAVORITE_CONTACT_ID = 10;
        public static final int FAVORITE_CUSTOM_LABEL_RES = 3;
        public static final int FAVORITE_DATA1 = 1;
        public static final int FAVORITE_DATA4 = 4;
        public static final int FAVORITE_DATA_ID = 6;
        public static final int FAVORITE_DISPLAY_NAME = 9;
        public static final int FAVORITE_INDEX = 5;
        public static final int FAVORITE_LOOKUP_KEY = 8;
        public static final int FAVORITE_PHONE_LABEL = 2;
        public static final int FAVORITE_PHOTO_ID = 7;
        public static final int FAVORITE_RAW_CONTACT_ID = 0;
        public static final FavoriteQuery INSTANCE = null;
        private static final String SELECTION = null;
        private static final String[] sFavoriteProjection = null;

        private FavoriteQuery() {
        }

        static {
            INSTANCE = new FavoriteQuery();
            sFavoriteProjection = new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "data1", DBHelper.COL_DATA2, DBHelper.COL_DATA3, "data4", "data14", "_id", "photo_id", "lookup", "display_name", "contact_id"};
            SELECTION = "data15 = 1 AND mimetype='vnd.android.cursor.item/phone_v2'";
        }

        public final String[] getFavoriteProjection(int r2) {
            if (r2 != 2) goto L5;
            sFavoriteProjection[9] = "display_name_alt";
        L7:
            return sFavoriteProjection;
        L5:
            sFavoriteProjection[9] = "display_name";
            goto L7
        }

        public final String getSELECTION() {
            return SELECTION;
        }
    }

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment$Listener;", "", "onContactSelected", "", "contactUri", "Landroid/net/Uri;", "targetRect", "Landroid/graphics/Rect;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Listener {
        void onContactSelected(Uri r1, Rect r2);
    }

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0002\u0018\u000028\u0012$\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0001B\u0015\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJc\u0010\u0010\u001a\u0004\u0018\u00010\u00062R\u0010\u0011\u001a*\u0012&\b\u0001\u0012\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u00050\u0012\"\"\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0002j\u0010\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u0004\u0018\u0001`\u0005H\u0014¢\u0006\u0002\u0010\u0013J\u0012\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006H\u0014J\b\u0010\u0017\u001a\u00020\u0015H\u0014R\u0016\u0010\f\u001a\n \r*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0010\u0012\f\u0012\n \r*\u0004\u0018\u00010\b0\b0\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment$RemoveTask;", "Landroid/os/AsyncTask;", "Ljava/util/HashMap;", "", "Lcom/android/contacts/list/FavoriteContact;", "Lkotlin/collections/HashMap;", "Ljava/lang/Void;", "fragment", "Lcom/android/contacts/list/NewPhoneFavoriteFragment;", "context", "Landroid/content/Context;", "(Lcom/android/contacts/list/NewPhoneFavoriteFragment;Landroid/content/Context;)V", "appContext", "kotlin.jvm.PlatformType", "fragmentRef", "Ljava/lang/ref/WeakReference;", "doInBackground", "params", "", "([Ljava/util/HashMap;)Ljava/lang/Void;", "onPostExecute", "", "aVoid", "onPreExecute", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class RemoveTask extends AsyncTask<HashMap<Long, FavoriteContact>, Void, Void> {
        private final Context appContext;
        private final WeakReference<NewPhoneFavoriteFragment> fragmentRef;

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(HashMap<Long, FavoriteContact>[] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        public RemoveTask(NewPhoneFavoriteFragment r2, Context r3) {
            Intrinsics.checkNotNullParameter(r2, "fragment");
            Intrinsics.checkNotNullParameter(r3, "context");
            this.fragmentRef = new WeakReference(r2);
            this.appContext = r3.getApplicationContext();
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(HashMap<Long, FavoriteContact>... r9) {
            Intrinsics.checkNotNullParameter(r9, "params");
            int r0 = 0;
            HashMap r10 = (HashMap) ArraysKt.getOrNull(r9, 0);
            if (r10 != null) goto L5;
            return null;
        L5:
            int r2 = r10.size();
            if (r2 <= 0) goto L12;
            long[] r3 = new long[r2];
            String[] r4 = new String[r2];
            Iterator r5 = r10.values().iterator();
        L9:
            if (r5.hasNext() == false) goto L11;
            FavoriteContact r6 = (FavoriteContact) r5.next();
            r3[r0] = r6.contactid;
            r4[r0] = r6.number;
            r0 = r0 + 1;
            goto L9
        L11:
            r10.clear();
            ContactSaveService.removePhoneStarted(this.appContext, r3, r4);
        L12:
            return null;
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            NewPhoneFavoriteFragment r0 = this.fragmentRef.get();
            if (r0 == null) goto L6;
            NewPhoneFavoriteFragment.access$updateButtonsState(r0);
            NewPhoneFavoriteFragment.access$showProgressDialog(r0);
            return;
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            NewPhoneFavoriteFragment r0 = this.fragmentRef.get();
            if (r0 != null) goto L5;
            return;
        L5:
            NewPhoneFavoriteFragment.access$setMNeedReloadData$p(r0, true);
            if (r0.isAdded() == true) goto L8;
            return;
        L8:
            ContactFragmentsCallback r2 = NewPhoneFavoriteFragment.access$getMFragmentsCallback$p(r0);
            if (r2 == null) goto L11;
            r2.liftVeil();
        L11:
            View r3 = NewPhoneFavoriteFragment.access$getMBtnDone$p(r0);
            if (r3 == null) goto L15;
            r3.callOnClick();
        L15:
            if ((NewPhoneFavoriteFragment.access$getMActivity$p(r0) instanceof DialtactsActivity) == false) goto L18;
            Activity r4 = NewPhoneFavoriteFragment.access$getMActivity$p(r0);
            Intrinsics.checkNotNull(r4, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity");
            ((DialtactsActivity) r4).notifyDBDataChanged();
            return;
        }
    }

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\n\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0005R\u0011\u0010\u0006\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0005R\u0011\u0010\u0007\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\u0005R\u0011\u0010\b\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\b\u0010\u0005R\u0011\u0010\t\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\t\u0010\u0005j\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\r¨\u0006\u000e"}, d2 = {"Lcom/android/contacts/list/NewPhoneFavoriteFragment$UIMode;", "", "(Ljava/lang/String;I)V", "isChanging", "", "()Z", "isEdit", "isNormal", "isToEdit", "isToNormal", "MODE_NORMAL", "MODE_EDIT", "MODE_TO_NORMAL", "MODE_TO_EDIT", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final enum UIMode extends Enum<UIMode> {
        private static final /* synthetic */ UIMode[] $VALUES = null;
        public static final UIMode MODE_EDIT = null;
        public static final UIMode MODE_NORMAL = null;
        public static final UIMode MODE_TO_EDIT = null;
        public static final UIMode MODE_TO_NORMAL = null;

        private static final /* synthetic */ UIMode[] $values() {
            return new UIMode[]{MODE_NORMAL, MODE_EDIT, MODE_TO_NORMAL, MODE_TO_EDIT};
        }

        public static UIMode valueOf(String r1) {
            return (UIMode) Enum.valueOf(UIMode.class, r1);
        }

        public static UIMode[] values() {
            return (UIMode[]) $VALUES.clone();
        }

        private UIMode(String r1, int r2) {
            super(r1, r2);
        }

        static {
            MODE_NORMAL = new UIMode("MODE_NORMAL", 0);
            MODE_EDIT = new UIMode("MODE_EDIT", 1);
            MODE_TO_NORMAL = new UIMode("MODE_TO_NORMAL", 2);
            MODE_TO_EDIT = new UIMode("MODE_TO_EDIT", 3);
            $VALUES = $values();
        }

        public final boolean isEdit() {
            if (this != MODE_EDIT) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isNormal() {
            if (this != MODE_NORMAL) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isToNormal() {
            if (this != MODE_TO_NORMAL) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isToEdit() {
            if (this != MODE_TO_EDIT) goto L5;
            return true;
        L5:
            return false;
        }

        public final boolean isChanging() {
            if (this != MODE_TO_EDIT) goto L5;
        L8:
            return true;
        L5:
            if (this == MODE_TO_NORMAL) goto L8;
            return false;
        }
    }

    /* JADX INFO: compiled from: NewPhoneFavoriteFragment.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;

        static {
            int[] r0 = new int[UIMode.values().length];
            r0[UIMode.MODE_NORMAL.ordinal()] = 1;     // Catch: NoSuchFieldError -> L9
        L13:
            r0[UIMode.MODE_TO_NORMAL.ordinal()] = 2;     // Catch: NoSuchFieldError -> L10
        L19:
            r0[UIMode.MODE_EDIT.ordinal()] = 3;     // Catch: NoSuchFieldError -> L11
        L15:
            r0[UIMode.MODE_TO_EDIT.ordinal()] = 4;     // Catch: NoSuchFieldError -> L12
        L7:
            $EnumSwitchMapping$0 = r0;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$-5fDYzGun3Z1OOFZ3TB-TgPzVPo, reason: not valid java name */
    public static /* synthetic */ void m212$r8$lambda$5fDYzGun3Z1OOFZ3TBTgPzVPo(NewPhoneFavoriteFragment r0, View r1) {
        inflateAndSetupView$lambda$0(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$49uItehLvf-_QpxJWI0xDrDkLFA, reason: not valid java name */
    public static /* synthetic */ void m213$r8$lambda$49uItehLvf_QpxJWI0xDrDkLFA(NewPhoneFavoriteFragment r0, View r1) {
        inflateAndSetupView$lambda$4(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$97w_XNwBkGsW8RgRo8O-I__nlqU, reason: not valid java name */
    public static /* synthetic */ void m214$r8$lambda$97w_XNwBkGsW8RgRo8OI__nlqU(NewPhoneFavoriteFragment r0, DialogInterface r1, int r2) {
        showDeleteFavoriteDialog$lambda$14$lambda$13(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$BpxFp7KtL_VtVB8_wVyLVAAPyX0(NewPhoneFavoriteFragment r0) {
        showProgressDialog$lambda$21(r0);
    }

    public static /* synthetic */ void $r8$lambda$CO0_KoQOzcJ0RaivCrqW6wzgq4c(NewPhoneFavoriteFragment r0, View r1) {
        inflateAndSetupView$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$YipLQuPZuRcq8MEJv_42PyJ4IDE(NewPhoneFavoriteFragment r0) {
        triggerLoad$lambda$10(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$ZOyKNdaxhOkiaKbC-LcBnn4gsY8, reason: not valid java name */
    public static /* synthetic */ void m215$r8$lambda$ZOyKNdaxhOkiaKbCLcBnn4gsY8(NewPhoneFavoriteFragment r0, View r1) {
        inflateAndSetupView$lambda$3(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$bhY6nVWVCijzHBZMVjImAu8k77Y(NewPhoneFavoriteFragment r0, View r1, MotionEvent r2) {
        return inflateAndSetupView$lambda$6(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$fzUTtMG9WFjUgGcy1vlvW5DtA74(int r0, int r1) {
        mOnDrag$lambda$8(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$mzwI0ylNDS7FqmlAqcm0a6aOPUA(NewPhoneFavoriteFragment r0, int r1) {
        mOnRemove$lambda$9(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$t-KjP7b2v2msyanlJ1_QheAkLP4, reason: not valid java name */
    public static /* synthetic */ void m216$r8$lambda$tKjP7b2v2msyanlJ1_QheAkLP4(NewPhoneFavoriteFragment r0, ArrayList r1) {
        onActivityResult$lambda$19(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$uhwUmcGzdbb4xpqeyKgLQgOWCKw(NewPhoneFavoriteFragment r0, DialogInterface r1, int r2) {
        showDeleteFavoriteDialog$lambda$14$lambda$12(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$yDmJJXZYUoMkjzmams8oS01G4xQ(NewPhoneFavoriteFragment r0, View r1) {
        inflateAndSetupView$lambda$1(r0, r1);
    }

    private static final void mOnDrag$lambda$8(int r0, int r1) {
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r1) {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        return true;
    }

    public final void setListener(Listener r1) {
    }

    public NewPhoneFavoriteFragment() {
        this.mFavoriteContacts = new Vector();
        this.TAG_LIST = "TAG_LIST";
        this.STATE_EMPTY = "STATE_EMPTY";
        this.mCurMode = UIMode.MODE_NORMAL;
        this.mListAnimator = new ListAnimator(new int[]{R.id.common_avatar_layout, R.id.title_container}, new int[]{R.id.tail_icon}, new int[]{R.id.common_check_box});
        this.mHandler = new NewPhoneFavoriteFragment$mHandler$1(this);
        this.mItemLongClickedListener = new NewPhoneFavoriteFragment$mItemLongClickedListener$1(this);
        this.mOnDrag = new NewPhoneFavoriteFragment$$ExternalSyntheticLambda1();
        this.mOnDrop = new NewPhoneFavoriteFragment$mOnDrop$1(this);
        this.mOnDragStart = new NewPhoneFavoriteFragment$mOnDragStart$1(this);
        this.mOnMove = new NewPhoneFavoriteFragment$mOnMove$1(this);
        this.mOnRemove = new NewPhoneFavoriteFragment$$ExternalSyntheticLambda2(this);
        ExecutorService r0 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r0, "newSingleThreadExecutor()");
        this.mPool = r0;
        this.mFavoriteNumberMap = new HashMap();
        this.mProviderIsNormal = true;
    }

    public static final /* synthetic */ void access$dismissProgressDialog(NewPhoneFavoriteFragment r0) {
        r0.dismissProgressDialog();
    }

    public static final /* synthetic */ Activity access$getMActivity$p(NewPhoneFavoriteFragment r0) {
        return r0.mActivity;
    }

    public static final /* synthetic */ FavoriteAdapter access$getMAdapter$p(NewPhoneFavoriteFragment r0) {
        return r0.mAdapter;
    }

    public static final /* synthetic */ View access$getMBtnDone$p(NewPhoneFavoriteFragment r0) {
        return r0.mBtnDone;
    }

    public static final /* synthetic */ UIMode access$getMCurMode$p(NewPhoneFavoriteFragment r0) {
        return r0.mCurMode;
    }

    public static final /* synthetic */ ContactFragmentsCallback access$getMFragmentsCallback$p(NewPhoneFavoriteFragment r0) {
        return r0.mFragmentsCallback;
    }

    public static final /* synthetic */ Handler access$getMHandler$p(NewPhoneFavoriteFragment r0) {
        return r0.mHandler;
    }

    public static final /* synthetic */ DragSortListView access$getMListView$p(NewPhoneFavoriteFragment r0) {
        return r0.mListView;
    }

    /* JADX INFO: renamed from: access$getMLongMenuHelper$p$s-1475172358, reason: not valid java name */
    public static final /* synthetic */ LongMenuHelper m217access$getMLongMenuHelper$p$s1475172358(NewPhoneFavoriteFragment r0) {
        return r0.mLongMenuHelper;
    }

    public static final /* synthetic */ OPopover access$getMPopover$p(NewPhoneFavoriteFragment r0) {
        return r0.mPopover;
    }

    public static final /* synthetic */ boolean access$getMProviderIsNormal$p(NewPhoneFavoriteFragment r0) {
        return r0.mProviderIsNormal;
    }

    public static final /* synthetic */ LongMenuHelper.MenuType[] access$getSLongMenuItems$cp() {
        return sLongMenuItems;
    }

    public static final /* synthetic */ void access$onClickEdit(NewPhoneFavoriteFragment r0) {
        r0.onClickEdit();
    }

    public static final /* synthetic */ void access$refreshListView(NewPhoneFavoriteFragment r0) {
        r0.refreshListView();
    }

    public static final /* synthetic */ void access$setMDraging$p(NewPhoneFavoriteFragment r0, boolean r1) {
        r0.mDraging = r1;
    }

    public static final /* synthetic */ void access$setMNeedReloadData$p(NewPhoneFavoriteFragment r0, boolean r1) {
        r0.mNeedReloadData = r1;
    }

    public static final /* synthetic */ void access$showProgressDialog(NewPhoneFavoriteFragment r0) {
        r0.showProgressDialog();
    }

    public static final /* synthetic */ void access$triggerLoad(NewPhoneFavoriteFragment r0) {
        r0.triggerLoad();
    }

    public static final /* synthetic */ void access$updateButtonsState(NewPhoneFavoriteFragment r0) {
        r0.updateButtonsState();
    }

    public static final /* synthetic */ void access$updateSelectedStatus(NewPhoneFavoriteFragment r0) {
        r0.updateSelectedStatus();
    }

    public final String getSTATE_EMPTY() {
        return this.STATE_EMPTY;
    }

    public final void setFragmentsCallback(ContactFragmentsCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mFragmentsCallback = r2;
    }

    private final void refreshListView() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        FavoriteAdapter r0 = this.mAdapter;
        if (r0 != null) goto L23;
        FavoriteAdapter r1 = new FavoriteAdapter(getActivity(), this.mFavoriteContacts, this.mPhotoManager);
        this.mAdapter = r1;
        DragSortListView r2 = this.mListView;
        if (r2 == null) goto L10;
        r2.setAdapter(r1);
    L10:
        ForceTouchAdapterController r3 = this.mForceTouchController;
        if (r3 == null) goto L13;
        r3.setAdapter(this.mAdapter);
    L13:
        FavoriteAdapter r4 = this.mAdapter;
        if (r4 == null) goto L16;
        r4.setItemLongClickedListener(this.mItemLongClickedListener);
    L16:
        FavoriteAdapter r5 = this.mAdapter;
        if (r5 == null) goto L19;
        r5.setOnItemClickListener(this);
    L19:
        FavoriteAdapter r6 = this.mAdapter;
        if (r6 == null) goto L26;
        r6.mHSListView = this.mListView;
    L26:
        if (this.mCurMode.isNormal() == true) goto L28;
    L30:
        setEmptyView();
        ContactsApplication.reportLaunchEnd(TAG);
        dismissLongMenu();
        updateButtonsState();
        return;
    L28:
        if (this.mVisible == false) goto L30;
        ContactDetailCacheManager.getInstance().refreshCache(this.mListView);
        goto L30
    L23:
        if (r0 == null) goto L26;
        r0.setList(this.mFavoriteContacts);
        goto L26
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Activity r2) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        super.onAttach(r2);
        this.mActivity = r2;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r1) {
        super.onCreate(r1);
        this.mPhotoManager = ContactPhotoManager.getInstance(getActivity());
        setupLongMenu();
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        return inflateAndSetupView(r2, r3, r4, R.layout.favorite_fragment);
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View r1, Bundle r2) {
        Intrinsics.checkNotNullParameter(r1, "view");
        setObserverToWork(true);
    }

    protected final View inflateAndSetupView(LayoutInflater r10, ViewGroup r11, Bundle r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        View r14 = r10.inflate(r13, r11, false);
        this.mFavoriteFragment = r14;
        View r15 = null;
        if (r14 == null) goto L5;
        View r0 = r14.findViewById(R.id.main_list1);
    L7:
        if ((r0 instanceof DragSortListView) == false) goto L9;
        DragSortListView r1 = (DragSortListView) r0;
    L10:
        this.mListView = r1;
        View r2 = this.mFavoriteFragment;
        if (r2 == null) goto L13;
        OFloatingTitleBar r3 = (OFloatingTitleBar) r2.findViewById(R.id.otitlebar);
    L14:
        Intrinsics.checkNotNull(r3);
        this.mOTitleBarHolder = new OFloatingTitleBarHolder(r3);
        FragmentActivity r4 = getActivity();
        if (r4 != null) goto L18;
        Intrinsics.checkNotNullExpressionValue(r14, "favoriteFragment");
        return r14;
    L18:
        OFloatingTitleBarHolder r5 = this.mOTitleBarHolder;
        if (r5 == null) goto L23;
        OFloatingTitleBar r6 = r5.getTitleBar();
        if (r6 == null) goto L23;
        r6.setStartTitle(R.string.common_favorites);
    L23:
        OFloatingTitleBarHolder r7 = this.mOTitleBarHolder;
        if (r7 == null) goto L26;
        View r8 = r7.addStartAction(OFloatingTitleBarHolder.STATE_EDIT, R.drawable.icon_cancel_22_22, new NewPhoneFavoriteFragment$$ExternalSyntheticLambda0(this));
    L27:
        if (r8 == null) goto L29;
        r8.setContentDescription(getString(R.string.accessibility_btn_cancel));
    L29:
        this.mBtnDone = r8;
        OFloatingTitleBarHolder r9 = this.mOTitleBarHolder;
        if (r9 == null) goto L32;
        r9.removeStartAction();
    L32:
        OFloatingTitleBarHolder r16 = this.mOTitleBarHolder;
        if (r16 == null) goto L35;
        View r17 = r16.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_common_add_selector, new NewPhoneFavoriteFragment$$ExternalSyntheticLambda4(this));
    L37:
        if (r17 == null) goto L40;
        r17.setContentDescription(getString(R.string.recommend_favorite));
    L40:
        OFloatingTitleBarHolder r18 = this.mOTitleBarHolder;
        if (r18 == null) goto L43;
        View r19 = r18.addEndAction(this.STATE_EMPTY, R.drawable.standard_icon_common_add_selector, new NewPhoneFavoriteFragment$$ExternalSyntheticLambda5(this));
    L44:
        if (r19 == null) goto L47;
        r19.setContentDescription(getString(R.string.recommend_favorite));
    L47:
        OFloatingTitleBarHolder r20 = this.mOTitleBarHolder;
        if (r20 == null) goto L50;
        View r21 = r20.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_menu_more, new NewPhoneFavoriteFragment$$ExternalSyntheticLambda6(this));
    L51:
        if (r21 == null) goto L53;
        r21.setContentDescription(getString(R.string.more_btn));
    L53:
        OFloatingTitleBarHolder r22 = this.mOTitleBarHolder;
        if (r22 == null) goto L56;
        String r23 = getResources().getString(R.string.select_all);
        Intrinsics.checkNotNullExpressionValue(r23, "resources.getString(R.string.select_all)");
        View r24 = r22.addEndAction(OFloatingTitleBarHolder.STATE_EDIT, r23, new NewPhoneFavoriteFragment$$ExternalSyntheticLambda7(this));
    L57:
        if (r24 == null) goto L60;
        r24.setContentDescription(getString(R.string.select_all));
    L60:
        if ((r24 instanceof ViewGroup) == false) goto L62;
        ViewGroup r25 = (ViewGroup) r24;
    L63:
        if (r25 == null) goto L65;
        View r26 = r25.getChildAt(0);
    L67:
        if ((r26 instanceof OTextView) == false) goto L69;
        OTextView r27 = (OTextView) r26;
    L70:
        if (r27 == null) goto L72;
        r27.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        this.mSelectedAll = new SelectAllState(r27);
    L72:
        OFloatingTitleBarHolder r28 = this.mOTitleBarHolder;
        if (r28 == null) goto L75;
        r28.removeEndAction();
    L75:
        DragSortListView r29 = this.mListView;
        if (r29 == null) goto L78;
        r29.setAutoClose(false);
    L78:
        DragSortListView r110 = this.mListView;
        if (r110 == null) goto L81;
        r110.setDropListener(this.mOnDrop);
    L81:
        DragSortListView r111 = this.mListView;
        if (r111 == null) goto L84;
        r111.setRemoveListener(this.mOnRemove);
    L84:
        DragSortListView r112 = this.mListView;
        if (r112 == null) goto L87;
        r112.setDragListener(this.mOnDrag);
    L87:
        DragSortListView r113 = this.mListView;
        if (r113 == null) goto L90;
        r113.setDragStartListener(this.mOnDragStart);
    L90:
        DragSortListView r114 = this.mListView;
        if (r114 == null) goto L93;
        r114.setMoveListener(this.mOnMove);
    L93:
        DragSortListView r115 = this.mListView;
        if (r115 == null) goto L96;
        r115.setOnScrollListener(this);
    L96:
        DragSortListView r116 = this.mListView;
        if (r116 == null) goto L100;
        r116.setTag(this.TAG_LIST);
    L100:
        DragSortListView r117 = this.mListView;
        if (r117 == null) goto L104;
        r117.setOnItemClickListener(this);
    L104:
        DragSortListView r118 = this.mListView;
        if (r118 == null) goto L107;
        r118.setItemLongClickedListener(this.mItemLongClickedListener);
    L107:
        DragSortListView r30 = this.mListView;
        DragSortListView r31 = r30;
        FragmentActivity r32 = r4;
        if (r30 == null) goto L110;
        DragSortController r33 = r30.getController();
    L111:
        this.mForceTouchController = new ForceTouchAdapterController(r31, r32, r33);
        DragSortListView r119 = this.mListView;
        if (r119 == null) goto L114;
        r119.setOnTouchListener(new NewPhoneFavoriteFragment$$ExternalSyntheticLambda8(this));
    L114:
        View r120 = this.mFavoriteFragment;
        if (r120 == null) goto L117;
        r15 = r120.findViewById(R.id.quickcontactclickedview);
    L117:
        QuickContactClickedView r121 = (QuickContactClickedView) r15;
        this.mQuickContactClickedView = r121;
        DragSortListView r122 = this.mListView;
        if (r122 == null) goto L120;
        r122.setQuickContactClickedView(r121);
    L120:
        DragSortListView r34 = this.mListView;
        if (r34 == null) goto L123;
        OUIHelper.OUIList.setFooterAndHeader$default(r10, r34, null, Integer.valueOf(OUIHelper.OUIList.getFooterHeight100()), 4, null);
    L123:
        Intrinsics.checkNotNullExpressionValue(r14, "favoriteFragment");
        return r14;
    L110:
        r33 = null;
        goto L111
    L69:
        r27 = null;
        goto L70
    L65:
        r26 = null;
        goto L67
    L62:
        r25 = null;
        goto L63
    L56:
        r24 = null;
        goto L57
    L50:
        r21 = null;
        goto L51
    L43:
        r19 = null;
        goto L44
    L35:
        r17 = null;
        goto L37
    L26:
        r8 = null;
        goto L27
    L13:
        r3 = null;
        goto L14
    L9:
        r1 = null;
        goto L10
    L5:
        r0 = null;
        goto L7
    }

    private static final void inflateAndSetupView$lambda$0(NewPhoneFavoriteFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.clickedBtnCancel();
    }

    private static final void inflateAndSetupView$lambda$1(NewPhoneFavoriteFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClickAdd();
    }

    private static final void inflateAndSetupView$lambda$2(NewPhoneFavoriteFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onClickAdd();
    }

    private static final void inflateAndSetupView$lambda$3(NewPhoneFavoriteFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "view");
        r1.onClickMenu(r2);
    }

    private static final void inflateAndSetupView$lambda$4(NewPhoneFavoriteFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullExpressionValue(r2, "view");
        r1.onClickSelectAll(r2);
    }

    private static final boolean inflateAndSetupView$lambda$6(NewPhoneFavoriteFragment r2, View r3, MotionEvent r4) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r4.getActionMasked() == 0) goto L5;
    L13:
        ForceTouchAdapterController r5 = r2.mForceTouchController;
        if (r5 != null) goto L18;
        return false;
    L18:
        return r5.onTouch(r3, r4);
    L5:
        if ((r3 instanceof DragSortListView) == false) goto L7;
        DragSortListView r0 = (DragSortListView) r3;
    L8:
        Intrinsics.checkNotNullExpressionValue(r4, "event");
        if (ListTouchHelper.isTouchOnFooterOrBlank(r0, r4) == false) goto L13;
        FavoriteAdapter r1 = r2.mAdapter;
        if (r1 == null) goto L13;
        r1.closeSwipedViews();
        goto L13
    L7:
        r0 = null;
        goto L8
    }

    @Override // com.android.contacts.AbstractFragment, com.obricOld.contacts.menus.LongMenuHelper.OnMenuItemClickedListener
    public boolean onMenuItemClicked(LongMenuHelper.MenuType r2, View r3, Object r4) {
        if (r2 != LongMenuHelper.MenuType.MENU_STAR) goto L12;
        FavoriteAdapter r1 = this.mAdapter;
        if (r1 != null) goto L7;
        return true;
    L7:
        if ((r4 instanceof FavoriteContact) == false) goto L15;
        if (r1 == null) goto L16;
        r1.unstar(r3, (FavoriteContact) r4);
        return true;
    L16:
        return true;
    L15:
        return true;
    L12:
        return false;
    }

    private final void setEmptyView() {
        DragSortListView r0 = this.mListView;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.getEmptyView();
    L6:
        if (r2 != null) goto L17;
        View r3 = this.mFavoriteFragment;
        if (r3 == null) goto L10;
        View r4 = r3.findViewById(R.id.empty_view);
    L11:
        if (r4 == null) goto L13;
        r1 = r4.findViewById(R.id.black_view);
    L13:
        Intrinsics.checkNotNull(r1, "null cannot be cast to non-null type com.obric.oui.status.OPageStatus");
        OPageStatus r5 = (OPageStatus) r1;
        r5.setTitle(getString(R.string.listTotalContactsZeroStarred));
        r5.setMessage(getString(R.string.listTotalAllContactsZeroStarredHint));
        DragSortListView r6 = this.mListView;
        if (r6 == null) goto L18;
        r6.setEmptyView(r4);
        return;
    L18:
        return;
    L10:
        r4 = null;
        goto L11
    L17:
        return;
    L5:
        r2 = null;
        goto L6
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final void updateButtonsState() {
        int r0 = WhenMappings.$EnumSwitchMapping$0[this.mCurMode.ordinal()];
        OTextView r2 = null;
        Integer r3 = null;
        r3 = null;
        boolean r4 = true;
        if (r0 != 1) goto L5;
    L66:
        Vector<FavoriteContact> r1 = this.mFavoriteContacts;
        if (r1 != null) goto L69;
    L71:
        Object[] r5 = false;
    L72:
        if (r5 == false) goto L76;
        OFloatingTitleBarHolder r6 = this.mOTitleBarHolder;
        if (r6 == null) goto L79;
        r6.stateTo(this.STATE_EMPTY);
    L79:
        OFloatingTitleBarHolder r7 = this.mOTitleBarHolder;
        if (r7 == null) goto L82;
        OTextView r8 = r7.getStartTitleView();
    L83:
        if (r8 == null) goto L86;
        r8.setVisibility(0);
    L86:
        BottomDeleteLayoutListener r9 = this.mBottomDeleteLayoutListener;
        if (r9 == null) goto L89;
        r9.setLayoutVisible(false);
    L89:
        SelectAllState r10 = this.mSelectedAll;
        if (r10 == null) goto L93;
        r10.setSelectAll(false);
    L93:
        OFloatingTitleBarHolder r11 = this.mOTitleBarHolder;
        if (r11 == null) goto L96;
        r2 = r11.getCenterTitleView();
    L96:
        if (r2 == null) goto L99;
        r2.setVisibility(8);
    L99:
        DialtactsActivity r12 = this.mDialtactsActivity;
        if (r12 != null) goto L102;
        return;
    L102:
        if (this.mCurMode.isChanging() == false) goto L104;
    L106:
        r4 = false;
    L107:
        r12.setTabOnclickEnabled(r4);
        return;
    L104:
        if (this.mDraging == true) goto L106;
    L82:
        r8 = null;
        goto L83
    L76:
        OFloatingTitleBarHolder r13 = this.mOTitleBarHolder;
        if (r13 == null) goto L79;
        r13.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
        goto L79
    L69:
        if (r1.isEmpty() != true) goto L71;
        r5 = true;
        goto L72
    L5:
        if (r0 == 2) goto L66;
        if (r0 != 3) goto L9;
    L11:
        OFloatingTitleBarHolder r14 = this.mOTitleBarHolder;
        if (r14 == null) goto L14;
        r14.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
    L14:
        OFloatingTitleBarHolder r15 = this.mOTitleBarHolder;
        if (r15 == null) goto L17;
        OTextView r16 = r15.getStartTitleView();
    L18:
        if (r16 == null) goto L21;
        r16.setVisibility(8);
    L21:
        View r17 = this.mBtnDone;
        if (r17 != null) goto L24;
    L30:
        BottomDeleteLayoutListener r18 = this.mBottomDeleteLayoutListener;
        if (r18 == null) goto L33;
        String r19 = getResources().getString(R.string.common_remove_from_favorites);
        Intrinsics.checkNotNullExpressionValue(r19, "resources.getString(R.st…on_remove_from_favorites)");
        r18.setButtonText(r19);
    L33:
        BottomDeleteLayoutListener r20 = this.mBottomDeleteLayoutListener;
        if (r20 == null) goto L36;
        r20.setLayoutVisible(true);
    L36:
        BottomDeleteLayoutListener r21 = this.mBottomDeleteLayoutListener;
        if (r21 != null) goto L39;
    L56:
        OFloatingTitleBarHolder r22 = this.mOTitleBarHolder;
        if (r22 == null) goto L99;
        OFloatingTitleBar r23 = r22.getTitleBar();
        if (r23 == null) goto L99;
        Object[] r24 = new Object[1];
        FavoriteAdapter r25 = this.mAdapter;
        if (r25 == null) goto L65;
        HashMap<Long, FavoriteContact> r26 = r25.getRemoveCache();
        if (r26 == null) goto L65;
        r3 = Integer.valueOf(r26.size());
    L65:
        r24[0] = r3;
        r23.setCenterTitle(getString(R.string.delete_selected_item_numbers, r24));
        goto L99
    L39:
        if (this.mCurMode.isChanging() == false) goto L41;
    L54:
        boolean r27 = false;
    L55:
        r21.setBottomBtnEnable(r27);
        goto L56
    L41:
        if (this.mDraging == true) goto L54;
        FavoriteAdapter r28 = this.mAdapter;
        if (r28 == null) goto L54;
        if (r28 == null) goto L51;
        HashMap<Long, FavoriteContact> r29 = r28.getRemoveCache();
        if (r29 == null) goto L51;
        if (r29.isEmpty() == true) goto L51;
        Object[] r30 = true;
    L52:
        if (r30 == false) goto L54;
        r27 = true;
    L51:
        r30 = false;
        goto L52
    L24:
        if (this.mCurMode.isChanging() == false) goto L26;
    L28:
        boolean r31 = false;
    L29:
        r17.setEnabled(r31);
        goto L30
    L26:
        if (this.mDraging == true) goto L28;
        r31 = true;
        goto L29
    L17:
        r16 = null;
        goto L18
    L9:
        if (r0 == 4) goto L11;
        goto L11
    }

    public final void setDialtactsActivity(DialtactsActivity r2) {
        Intrinsics.checkNotNullParameter(r2, "dialtactsActivity");
        this.mDialtactsActivity = r2;
    }

    private static final void mOnRemove$lambda$9(NewPhoneFavoriteFragment r1, int r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        FavoriteAdapter r3 = r1.mAdapter;
        if (r3 == null) goto L6;
        r3.remove(r2);
        return;
    }

    private final void triggerLoad() {
        if (this.mProviderIsNormal == true) goto L6;
        updateButtonsState();
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "return triggerLoad mProviderIsNormal is false");
        return;
    L6:
        Thread r0 = new Thread(new NewPhoneFavoriteFragment$$ExternalSyntheticLambda3(this));
        this.mPool.submit(r0);
    }

    private static final void triggerLoad$lambda$10(NewPhoneFavoriteFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        r2.mFavoriteContacts = r2.getAllPhoneStared();
        r2.mHandler.removeMessages(4);
        r2.mHandler.sendEmptyMessage(4);
    }

    public final void setPrefsCallback(PreferencesCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mPrefersCallback = r2;
    }

    public final void onPreferencesChanged() {
        this.mHandler.removeMessages(2);
        this.mHandler.sendEmptyMessage(2);
    }

    private final boolean hasExistInMap(long r3, String r5) {
        ArrayList<String> r0 = this.mFavoriteNumberMap.get(Long.valueOf(r3));
        if (r0 != null) goto L7;
        ArrayList<String> r1 = new ArrayList();
        r1.add(r5);
        this.mFavoriteNumberMap.put(Long.valueOf(r3), r1);
        return false;
    L7:
        if (hasExist(r0, r5) == false) goto L10;
        return true;
    L10:
        r0.add(r5);
        return false;
    }

    private final boolean hasExist(ArrayList<String> r2, String r3) {
        if (r2 != null) goto L5;
        return false;
    L5:
        if (r2.isEmpty() == true) goto L18;
        Iterator<String> r4 = r2.iterator();
    L9:
        if (r4.hasNext() == false) goto L19;
        if (PhoneNumberUtils.compare(r4.next(), r3) == false) goto L9;
        return true;
    L19:
        return false;
    L18:
        return false;
    }

    private final synchronized Vector<FavoriteContact> getAllPhoneStared() {
        monitor-enter(this);
        this.mFavoriteNumberMap.clear();     // Catch: Throwable -> L38
        Vector<FavoriteContact> r0 = new Vector();     // Catch: Throwable -> L38
        FragmentActivity r1 = getActivity();     // Catch: Throwable -> L38
        if (r1 == null) goto L13;
        ContentResolver r2 = r1.getContentResolver();     // Catch: Throwable -> L38
        if (r2 == null) goto L13;
        Uri r3 = ContactsContract.Data.CONTENT_URI;     // Catch: Throwable -> L38
        FavoriteQuery r4 = FavoriteQuery.INSTANCE;     // Catch: Throwable -> L38
        PreferencesCallback r5 = this.mPrefersCallback;     // Catch: Throwable -> L38
        if (r5 == null) goto L10;
        int r6 = r5.getDisplayOrder();     // Catch: Throwable -> L38
    L11:
        Cursor r7 = r2.query(r3, r4.getFavoriteProjection(r6), FavoriteQuery.INSTANCE.getSELECTION(), null, "CAST(data14 AS DECIMAL)");     // Catch: Throwable -> L38
    L14:
        if (r7 != null) goto L42;
    L34:
        if (r7 == null) goto L36;
        r7.close();     // Catch: Throwable -> L38
    L36:
        monitor-exit(this);
        return r0;
    L42:
    L30:
        th = move-exception;
        if (r7 == null) goto L33;
        r7.close();     // Catch: Throwable -> L38
    L33:
        throw th;     // Catch: Throwable -> L38
    L16:
        if (r7.moveToFirst() == false) goto L34;
    L17:
        FavoriteContact r8 = new FavoriteContact();     // Catch: Throwable -> L30
        String r9 = r7.getString(5);     // Catch: Throwable -> L30
        if (r9 != null) goto L20;
        int r10 = 0;
    L21:
        r8.position = r10;     // Catch: Throwable -> L30
        r8.id = r7.getLong(6);     // Catch: Throwable -> L30
        r8.photoId = r7.getLong(7);     // Catch: Throwable -> L30
        r8.LookKey = r7.getString(8);     // Catch: Throwable -> L30
        r8.raw_contactid = r7.getLong(0);     // Catch: Throwable -> L30
        r8.number = r7.getString(1);     // Catch: Throwable -> L30
        r8.type = r7.getInt(2);     // Catch: Throwable -> L30
        if (r8.type != 0) goto L24;
        r8.label = r7.getString(3);     // Catch: Throwable -> L30
    L24:
        r8.name = r7.getString(9);     // Catch: Throwable -> L30
        r8.contactid = r7.getLong(10);     // Catch: Throwable -> L30
        if (hasExistInMap(r8.contactid, r8.number) == true) goto L28;
        r0.add(r8);     // Catch: Throwable -> L30
    L28:
        if (r7.moveToNext() == true) goto L17;
    L20:
        r10 = Integer.parseInt(r9);     // Catch: Throwable -> L30
        goto L21
    L10:
        r6 = -1;
    L13:
        r7 = null;
    L38:
        th = move-exception;
        throw th;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        this.mIsClickedBtnAdd = false;
        if (this.mCurMode.isNormal() == false) goto L5;
        triggerLoad();
    L5:
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent("", TAG, "", null, 8, null));
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        DragSortListView r0 = this.mListView;
        if (r0 == null) goto L7;
        if (r0 == null) goto L8;
        r0.hideQuickContact();
        return;
    L8:
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        boolean r1 = false;
        if (this.mDraging == false) goto L6;
        this.mDraging = false;
        updateButtonsState();
    L6:
        if (this.mCurMode.isNormal() == true) goto L18;
        exitEditMode();
        OAlertDialog r0 = this.mDeleteDialog;
        if (r0 == null) goto L18;
        if (r0 != null) goto L11;
    L13:
        if (r1 == false) goto L18;
        OAlertDialog r2 = this.mDeleteDialog;
        if (r2 == null) goto L17;
        r2.dismiss();
    L17:
        this.mDeleteDialog = null;
        goto L18
    L11:
        if (r0.isShowing() != true) goto L13;
        r1 = true;
    L18:
        dismissLongMenu();
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        setObserverToWork(false);
        this.mPool.shutdownNow();
    }

    private final void hideSoftKeyboard() {
        Activity r0 = this.mActivity;
        IBinder r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("input_method");
    L6:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r3 = (InputMethodManager) r2;
        DragSortListView r4 = this.mListView;
        if (r4 == null) goto L9;
        r1 = r4.getWindowToken();
    L9:
        r3.hideSoftInputFromWindow(r1, 0);
        return;
    L5:
        r2 = null;
        goto L6
    }

    public final void startActivityAndForwardResult(Intent r2) {
        Intrinsics.checkNotNullParameter(r2, MemorySourceLinkType.INTENT);
        r2.setFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L7;
        Intent r1 = r0.getIntent();
        if (r1 == null) goto L7;
        Bundle r3 = r1.getExtras();
    L8:
        if (r3 == null) goto L10;
        r2.putExtras(r3);
    L10:
        startActivity(r2);
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r2, int r3) {
        Intrinsics.checkNotNullParameter(r2, "arg0");
        hideSoftKeyboard();
        if (this.mCurMode.isNormal() == false) goto L7;
        if (r3 != 0) goto L8;
        ContactDetailCacheManager.getInstance().refreshCache(r2);
        return;
    L8:
        return;
    }

    private final void onClickAdd() {
        if (this.mIsClickedBtnAdd == true) goto L6;
        ActivityOptions r0 = ActivityOptions.makeCustomAnimation(getActivity(), R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_do_nothing);
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_STAR);
        Intent r1 = new Intent();
        r1.setAction(ContactSelectionActivity.ACTION_PICK_UNFAVORITE_NUMS);
        startActivityForResult(r1, 30, r0.toBundle());
        this.mIsClickedBtnAdd = true;
        return;
    }

    private final void onClickEdit() {
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_EDIT_FAVORITE);
        FavoriteAdapter r0 = this.mAdapter;
        if (r0 == null) goto L21;
        boolean r1 = true;
        if (r0 != null) goto L7;
    L9:
        boolean r2 = false;
    L10:
        if (r2 == false) goto L22;
        FavoriteAdapter r3 = this.mAdapter;
        if (r3 != null) goto L14;
    L16:
        r1 = false;
    L17:
        if (r1 == false) goto L19;
        return;
    L19:
        this.mCurMode = UIMode.MODE_TO_EDIT;
        updateListViewState();
        updateButtonsState();
        editAnimation();
        return;
    L14:
        if (r3.getFavoriteCancleState() != true) goto L16;
    L22:
        return;
    L7:
        if (r0.isEmpty() == true) goto L9;
        r2 = true;
        goto L10
    }

    private final void onClickMenu(View r20) {
        ArrayList r1 = new ArrayList();
        if (this.mCurMode.isChanging() == false) goto L5;
    L18:
        FragmentActivity r2 = getActivity();
        if (r2 == null) goto L22;
        FragmentActivity r3 = r2;
        OPopover r4 = OUIPopoverHelper.genPopover$default(r3, r1, false, 4, null);
        this.mPopover = r4;
        Intrinsics.checkNotNull(r4);
        OUIPopoverHelper.showPopupAtAnchorView(r3, r4, Direct.BOTTOM_LEFT, r20, null);
        return;
    L22:
        return;
    L5:
        if (this.mIsAnimationing == false) goto L16;
        FavoriteAdapter r5 = this.mAdapter;
        if (r5 == null) goto L16;
        final boolean r6 = true;
        if (r5 != null) goto L11;
    L13:
        boolean r7 = false;
    L14:
        if (r7 == false) goto L16;
    L17:
        r1.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(R.drawable.menu_item_multi_select_icon), null, null, getString(R.string.btn_select), null, null, null, null, new C02061(r6, this), false, 1024, null));
        goto L18
    L11:
        if (r5.isEmpty() == true) goto L13;
        r7 = true;
    L16:
        r6 = false;
        goto L17
    }

    private final void onClickSelectAll(View r5) {
        SelectAllState r6 = this.mSelectedAll;
        if (r6 == null) goto L5;
        r6.toggle();
    L5:
        SelectAllState r7 = this.mSelectedAll;
        if (r7 == null) goto L8;
        boolean r8 = r7.isSelectAll();
    L9:
        FavoriteAdapter r1 = this.mAdapter;
        if (r1 == null) goto L12;
        int r2 = r1.getCount();
    L13:
        int r3 = 0;
    L14:
        if (r3 >= r2) goto L19;
        FavoriteAdapter r4 = this.mAdapter;
        if (r4 == null) goto L18;
        r4.checkTo(r3, r8);
    L18:
        r3 = r3 + 1;
        goto L14
    L19:
        FavoriteAdapter r9 = this.mAdapter;
        if (r9 == null) goto L22;
        r9.notifyDataSetChanged();
    L22:
        SelectAllState r10 = this.mSelectedAll;
        if (r10 == null) goto L26;
        r10.setSelectAll(r8);
    L26:
        BottomDeleteLayoutListener r11 = this.mBottomDeleteLayoutListener;
        if (r11 == null) goto L29;
        r11.setBottomBtnEnable(r8);
    L29:
        OFloatingTitleBarHolder r12 = this.mOTitleBarHolder;
        if (r12 == null) goto L44;
        OFloatingTitleBar r13 = r12.getTitleBar();
        if (r13 == null) goto L45;
        Object[] r14 = new Object[1];
        FavoriteAdapter r15 = this.mAdapter;
        if (r15 == null) goto L38;
        HashMap<Long, FavoriteContact> r16 = r15.getRemoveCache();
        if (r16 == null) goto L38;
        Integer r17 = Integer.valueOf(r16.size());
    L39:
        r14[0] = r17;
        r13.setCenterTitle(getString(R.string.delete_selected_item_numbers, r14));
        return;
    L38:
        r17 = null;
        goto L39
    L45:
        return;
    L44:
        return;
    L12:
        r2 = 0;
        goto L13
    L8:
        r8 = false;
        goto L9
    }

    public final void showDeleteFavoriteDialog() {
        String r0 = getString(R.string.sheet_title_remove_favorite_number);
        Intrinsics.checkNotNullExpressionValue(r0, "getString(R.string.sheet…e_remove_favorite_number)");
        if (getActivity() == null) goto L11;
        OAlertDialogUtils r1 = OAlertDialogUtils.INSTANCE;
        Context r2 = requireContext();
        String r3 = getString(R.string.common_ok);
        DialogInterface.OnClickListener r6 = new NewPhoneFavoriteFragment$$ExternalSyntheticLambda10(this);
        String r4 = getString(R.string.common_cancel);
        ButtonStyleController.TextColorType r7 = ButtonStyleController.TextColorType.Negative;
        DialogInterface.OnClickListener r9 = new NewPhoneFavoriteFragment$$ExternalSyntheticLambda11(this);
        Intrinsics.checkNotNullExpressionValue(r2, "requireContext()");
        OAlertDialog r5 = OAlertDialogUtils.showConfirmationDialog$default(r2, r0, null, r3, r6, r7, r4, r9, null, 256, null);
        this.mDeleteDialog = r5;
        if (r5 == null) goto L7;
        r5.setCanceledOnTouchOutside(true);
    L7:
        OAlertDialog r13 = this.mDeleteDialog;
        if (r13 == null) goto L12;
        r13.show();
        return;
    L12:
        return;
    }

    private static final void showDeleteFavoriteDialog$lambda$14$lambda$12(NewPhoneFavoriteFragment r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.doRemoveAction();
        OAlertDialog r3 = r0.mDeleteDialog;
        if (r3 == null) goto L7;
        if (r3 == null) goto L8;
        r3.dismiss();
        return;
    L8:
        return;
    }

    private static final void showDeleteFavoriteDialog$lambda$14$lambda$13(NewPhoneFavoriteFragment r0, DialogInterface r1, int r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OAlertDialog r3 = r0.mDeleteDialog;
        if (r3 == null) goto L7;
        if (r3 == null) goto L8;
        r3.dismiss();
        return;
    L8:
        return;
    }

    private final void doRemoveAction() {
        Vector<FavoriteContact> r0 = this.mFavoriteContacts;
        HashMap<Long, FavoriteContact> r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.clone();
    L7:
        if ((r2 instanceof Vector) == false) goto L9;
        Vector r3 = (Vector) r2;
    L10:
        if (r3 != null) goto L12;
        return;
    L12:
        Context r4 = getContext();
        if (r4 == null) goto L15;
        final Context r5 = r4.getApplicationContext();
    L16:
        if (r5 != null) goto L18;
        return;
    L18:
        FavoriteAdapter r6 = this.mAdapter;
        if (r6 == null) goto L21;
        r1 = r6.getRemoveCache();
    L21:
        final HashMap<Long, FavoriteContact> r7 = r1;
        ArrayList<Integer> r8 = new ArrayList();
        ArrayList<Integer> r9 = new ArrayList();
        DragSortListView r10 = this.mListView;
        int r11 = 0;
        if (r10 == null) goto L24;
        int r12 = r10.getHeaderViewsCount();
    L25:
        int r13 = 0;
        int r14 = 0;
    L26:
        if (r13 >= r12) goto L28;
        r9.add(Integer.valueOf(r13));
        r14 = r14 + 1;
        r13 = r13 + 1;
        goto L26
    L28:
        Iterator r15 = r3.iterator();
        Intrinsics.checkNotNullExpressionValue(r15, "contacts.iterator()");
    L30:
        if (r15.hasNext() == false) goto L43;
        FavoriteContact r16 = (FavoriteContact) r15.next();
        if (r7 == null) goto L38;
        Set<Long> r17 = r7.keySet();
        if (r17 == null) goto L38;
        boolean r18 = r17.contains(Long.valueOf(r16.id));
        boolean r19 = true;
        if (r18 != true) goto L38;
    L39:
        if (r19 == false) goto L41;
        r8.add(Integer.valueOf(r14));
        r15.remove();
    L42:
        r14 = r14 + 1;
        goto L30
    L41:
        r9.add(Integer.valueOf(r14));
    L38:
        r19 = false;
        goto L39
    L43:
        DragSortListView r20 = this.mListView;
        if (r20 == null) goto L46;
        int r21 = r20.getFooterViewsCount();
    L47:
        if (r11 >= r21) goto L49;
        r9.add(Integer.valueOf(r11));
        r11 = r11 + 1;
        goto L47
    L49:
        final DragSortListView r22 = this.mListView;
        final Vector r23 = r3;
        new AnonymousClass1(this, r23, r5, r7, r22).setResultListSize(r3.size()).start(r8, r9);
        return;
    L46:
        r21 = 0;
        goto L47
    L24:
        r12 = 0;
        goto L25
    L15:
        r5 = null;
        goto L16
    L9:
        r3 = null;
        goto L10
    L5:
        r2 = null;
        goto L7
    }

    private final void clickedBtnCancel() {
        if (this.mCurMode.isEdit() == true) goto L5;
        return;
    L5:
        if (this.mDraging == true) goto L21;
        this.mCurMode = UIMode.MODE_TO_NORMAL;
        updateListViewState();
        BottomDeleteLayoutListener r0 = this.mBottomDeleteLayoutListener;
        boolean r1 = false;
        if (r0 == null) goto L10;
        r0.startTransition(false);
    L10:
        updateButtonsState();
        FavoriteAdapter r2 = this.mAdapter;
        if (r2 == null) goto L18;
        if (r2 != null) goto L14;
    L16:
        if (r1 == false) goto L18;
        showProgressDialog();
        ChangeThread r3 = new ChangeThread(this);
        this.mChangeThread = r3;
        r3.start();
        goto L18
    L14:
        if (r2.isDataChanged() != true) goto L16;
        r1 = true;
    L18:
        cancelAnimation();
        return;
    }

    private final void editAnimation() {
        if (this.mListView != null) goto L5;
        return;
    L5:
        if (this.mAdapter == null) goto L19;
        BottomDeleteLayoutListener r0 = this.mBottomDeleteLayoutListener;
        if (r0 == null) goto L10;
        r0.startTransition(true);
    L10:
        DragSortListView r1 = this.mListView;
        if (r1 == null) goto L13;
        this.mListAnimator.startEdit(r1);
    L13:
        this.mCurMode = UIMode.MODE_EDIT;
        FavoriteAdapter r2 = this.mAdapter;
        if (r2 == null) goto L16;
        r2.notifyDataSetChanged();
    L16:
        updateListViewState();
        updateButtonsState();
        return;
    }

    private final void cancelAnimation() {
        if (this.mListView != null) goto L5;
        return;
    L5:
        if (this.mAdapter != null) goto L8;
        return;
    L8:
        if (this.mCurMode != UIMode.MODE_TO_NORMAL) goto L18;
        this.mCurMode = UIMode.MODE_NORMAL;
        updateListViewState();
        ChangeThread r0 = this.mChangeThread;
        if (r0 == null) goto L17;
        boolean r1 = false;
        if (r0 != null) goto L14;
    L16:
        if (r1 == false) goto L18;
    L14:
        if (r0.isAlive() == true) goto L16;
        r1 = true;
    L17:
        onExitEditMode();
    L18:
        DragSortListView r2 = this.mListView;
        if (r2 == null) goto L23;
        this.mListAnimator.finishEdit(r2);
        return;
    }

    private final void setObserverToWork(boolean r2) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        registerObserver();
        return;
    L7:
        unregisterObserver();
    }

    private final void registerObserver() {
        if (this.mContactsContent != null) goto L10;
        ContactsContent r0 = new ContactsContent(this, new Handler());
        this.mContactsContent = r0;
        FragmentActivity r3 = getActivity();
        if (r3 == null) goto L11;
        ContentResolver r4 = r3.getContentResolver();
        if (r4 == null) goto L12;
        r4.registerContentObserver(Uri.withAppendedPath(ContactsContract.Data.CONTENT_URI, BytedanceContactContract.BytedancePhoneColumn.NUMBER_FAVORITE_TAG), true, r0);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void unregisterObserver() {
        ContactsContent r0 = this.mContactsContent;
        if (r0 == null) goto L11;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        ContentResolver r2 = r1.getContentResolver();
        if (r2 == null) goto L9;
        r2.unregisterContentObserver(r0);
    L9:
        this.mContactsContent = null;
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r4) {
        if (this.mVisible != r4) goto L5;
    L27:
        this.mVisible = r4;
        return;
    L5:
        if (r4 == true) goto L22;
        DragSortListView r1 = this.mListView;
        if (r1 == null) goto L21;
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L17;
        DragSortListView r3 = this.mListView;
        if (r3 == null) goto L17;
        r3.hideQuickContact();
    L17:
        DragSortListView r5 = this.mListView;
        if (r5 == null) goto L21;
        r5.setScrollEnabled(true);
        goto L21
    L10:
        if (r1.isShowQuickContact() != true) goto L12;
        r2 = true;
    L21:
        setObserverToWork(false);
        exitEditMode();
        dismissLongMenu();
        goto L27
    L22:
        setObserverToWork(true);
        if (isResumed() == false) goto L27;
        if (this.mCurMode.isNormal() == false) goto L27;
        triggerLoad();
        goto L27
    }

    public final void exitEditMode() {
        if (this.mCurMode.isNormal() == true) goto L5;
        this.mCurMode = UIMode.MODE_NORMAL;
    L5:
        this.mNeedReloadData = true;
        onExitEditMode();
    }

    private final void onExitEditMode() {
        if (this.mCurMode.isNormal() == false) goto L35;
        DragSortListView r0 = this.mListView;
        if (r0 == null) goto L12;
        if (r0 == null) goto L8;
        r0.stopScrolling();
    L8:
        DragSortListView r1 = this.mListView;
        if (r1 == null) goto L11;
        r1.cancelDrag();
    L11:
        updateListViewState();
    L12:
        FavoriteAdapter r2 = this.mAdapter;
        if (r2 == null) goto L31;
        if (r2 == null) goto L17;
        r2.setDataChanged(false);
    L17:
        FavoriteAdapter r3 = this.mAdapter;
        if (r3 == null) goto L20;
        HashMap<Long, FavoriteContact> r4 = r3.getRemoveCache();
    L21:
        if (r4 == null) goto L27;
        FavoriteAdapter r5 = this.mAdapter;
        if (r5 == null) goto L27;
        HashMap<Long, FavoriteContact> r6 = r5.getRemoveCache();
        if (r6 == null) goto L27;
        r6.clear();
    L27:
        FavoriteAdapter r7 = this.mAdapter;
        if (r7 == null) goto L31;
        r7.notifyDataSetInvalidated();
        goto L31
    L20:
        r4 = null;
    L31:
        if (this.mNeedReloadData == false) goto L33;
        this.mNeedReloadData = false;
        triggerLoad();
        return;
    L33:
        updateButtonsState();
        return;
    }

    public final void updateListViewState() {
        boolean r1 = true;
        if (this.mListView != null) goto L5;
    L37:
        FavoriteAdapter r0 = this.mAdapter;
        if (r0 == null) goto L48;
        if (r0 != null) goto L41;
        return;
    L41:
        if (this.mCurMode.isEdit() == false) goto L43;
    L46:
        r0.setIsEdit(r1);
        return;
    L43:
        if (this.mCurMode.isChanging() == true) goto L46;
        r1 = false;
        goto L46
    L48:
        return;
    L5:
        if (this.mCurMode.isChanging() == false) goto L19;
        DragSortListView r2 = this.mListView;
        if (r2 == null) goto L9;
        r2.setIsDoingAnimation(true);
    L9:
        DragSortListView r3 = this.mListView;
        if (r3 == null) goto L14;
        r3.setScrollEnabled(false);
    L14:
        if (this.mCurMode.isToEdit() == false) goto L33;
        DragSortListView r4 = this.mListView;
        if (r4 == null) goto L33;
        r4.restoreScrollState(false);
    L33:
        DragSortListView r5 = this.mListView;
        if (r5 == null) goto L37;
        r5.setDragEnabled(this.mCurMode.isEdit());
        goto L37
    L19:
        if (this.mCurMode.isEdit() == false) goto L25;
        DragSortListView r6 = this.mListView;
        if (r6 == null) goto L30;
        r6.setScrollEnabled(false);
    L30:
        DragSortListView r7 = this.mListView;
        if (r7 == null) goto L33;
        r7.setIsDoingAnimation(false);
        goto L33
    L25:
        if (this.mCurMode.isNormal() == false) goto L30;
        DragSortListView r8 = this.mListView;
        if (r8 == null) goto L30;
        r8.setScrollEnabled(true);
        goto L30
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r3, boolean r4) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r3 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r3;
        if (r3 == true) goto L8;
        return;
    L8:
        if (this.mCurMode.isNormal() == false) goto L13;
        if (r4 == false) goto L14;
        triggerLoad();
        return;
    L14:
        return;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r3, View r4, int r5, long r6) {
        FavoriteAdapter r7 = this.mAdapter;
        ContactsCommonListItem r8 = null;
        if (r7 == null) goto L5;
        FavoriteContact r9 = r7.getItem(r5);
    L6:
        if (r9 != null) goto L8;
        return;
    L8:
        FavoriteAdapter r10 = this.mAdapter;
        boolean r11 = true;
        if (r10 != null) goto L11;
    L13:
        boolean r12 = false;
    L14:
        if (r12 == false) goto L36;
        FavoriteAdapter r13 = this.mAdapter;
        if (r13 == null) goto L24;
        if (r13 != null) goto L19;
    L21:
        boolean r1 = false;
    L22:
        r13.checkTo(r5, r1);
        goto L24
    L19:
        if (r13.isChecked(r5) == true) goto L21;
        r1 = true;
    L24:
        if ((r4 instanceof ContactsCommonListItem) == false) goto L26;
        r8 = (ContactsCommonListItem) r4;
    L26:
        if (r8 == null) goto L34;
        FavoriteAdapter r14 = this.mAdapter;
        if (r14 != null) goto L30;
    L32:
        r11 = false;
    L33:
        r8.setChecked(r11);
        goto L34
    L30:
        if (r14.isChecked(r5) != true) goto L32;
    L34:
        updateButtonsState();
        updateSelectedStatus();
        return;
    L36:
        if (ContactsUtils.isJustClicked() == true) goto L42;
        FavoriteAdapter r2 = this.mAdapter;
        if (r2 == null) goto L43;
        r2.goCall(r5);
        return;
    L43:
        return;
    L42:
        return;
    L11:
        if (r10.getEditState() != true) goto L13;
        r12 = true;
        goto L14
    L5:
        r9 = null;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        super.onActivityResult(r2, r3, r4);
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 != 30) goto L21;
        if (r4 == null) goto L9;
        final ArrayList<String> r5 = r4.getStringArrayListExtra("com.android.contacts.extra.PHONE_URIS");
    L10:
        ArrayList<String> r6 = r5;
        if (r6 != null) goto L13;
    L16:
        boolean r7 = true;
    L17:
        if (r7 == false) goto L19;
        return;
    L19:
        new Thread(new NewPhoneFavoriteFragment$$ExternalSyntheticLambda9(this, r5)).start();
        return;
    L13:
        if (r6.isEmpty() == true) goto L16;
        r7 = false;
        goto L17
    L9:
        r5 = null;
        goto L10
    }

    private static final void onActivityResult$lambda$19(NewPhoneFavoriteFragment r1, ArrayList r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        ContactSaveService.setPhoneStarted(r1.getActivity(), (String[]) r2.toArray(new String[0]), ContactSaveService.FavoriteAction.ADD);
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ReleaseResourceListener
    public void release() {
        if (this.mVisible == true) goto L21;
        DragSortListView r0 = this.mListView;
        if (r0 == null) goto L11;
        if (r0 == null) goto L8;
        r0.setAdapter(null);
    L8:
        DragSortListView r1 = this.mListView;
        if (r1 == null) goto L11;
        r1.setOnScrollStateChangeListener(null);
    L11:
        FavoriteAdapter r2 = this.mAdapter;
        if (r2 == null) goto L22;
        if (r2 == null) goto L15;
        r2.setList(null);
    L15:
        FavoriteAdapter r3 = this.mAdapter;
        if (r3 == null) goto L19;
        r3.mHSListView = null;
    L19:
        this.mAdapter = null;
        this.mFavoriteContacts = null;
        return;
    L22:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        DragSortListView r0 = this.mListView;
        if (r0 != null) goto L5;
        return true;
    L5:
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L11:
        if (r1 == true) goto L13;
        DragSortListView r2 = this.mListView;
        if (r2 != null) goto L19;
    L21:
        boolean r3 = false;
    L22:
        if (r3 == false) goto L30;
        DragSortListView r4 = this.mListView;
        if (r4 == null) goto L27;
        r4.hideQuickContact();
    L27:
        if (ContactsUtils.DEBUG == false) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "QuickContact is showing...");
    L35:
        return false;
    L30:
        if (this.mCurMode.isEdit() == false) goto L37;
        clickedBtnCancel();
        if (ContactsUtils.DEBUG == false) goto L35;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "In edit mode...");
        goto L35
    L37:
        return true;
    L19:
        if (r2.isShowQuickContact() != true) goto L21;
        r3 = true;
        goto L22
    L13:
        if (ContactsUtils.DEBUG == false) goto L15;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "ListView is selecting...");
    L15:
        return false;
    L7:
        if (r0.isSelecting() != true) goto L9;
        r1 = true;
        goto L11
    }

    private final void showProgressDialog() {
        this.dismissDialog = false;
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L5;
    L9:
        this.mHandler.postDelayed(new NewPhoneFavoriteFragment$$ExternalSyntheticLambda12(this), 1000);
        return;
    L5:
        if (this.mProgressDialog != null) goto L9;
        ProgressDialog r2 = new ProgressDialog(r1);
        this.mProgressDialog = r2;
        r2.setMessage(R.string.progress_dialog_message_for_wait);
        ProgressDialog r3 = this.mProgressDialog;
        if (r3 == null) goto L9;
        r3.setCancelable(false);
        goto L9
    }

    private static final void showProgressDialog$lambda$21(NewPhoneFavoriteFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.dismissDialog == true) goto L14;
        ProgressDialog r0 = r2.mProgressDialog;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L15;
        ProgressDialog r3 = r2.mProgressDialog;
        if (r3 == null) goto L16;
        r3.show();
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r0.isShowing() == true) goto L9;
        r1 = true;
        goto L9
    }

    private final void dismissProgressDialog() {
        boolean r0 = true;
        this.dismissDialog = true;
        ProgressDialog r1 = this.mProgressDialog;
        if (r1 != null) goto L5;
        return;
    L5:
        if (r1 != null) goto L7;
    L9:
        r0 = false;
    L10:
        if (r0 == false) goto L16;
        ProgressDialog r3 = this.mProgressDialog;
        if (r3 == null) goto L17;
        r3.dismiss();
        return;
    L17:
        return;
    L16:
        return;
    L7:
        if (r1.isShowing() != true) goto L9;
        goto L9
    }

    public final void setBottomDeleteLayoutListener(BottomDeleteLayoutListener r2) {
        Intrinsics.checkNotNullParameter(r2, "listener");
        this.mBottomDeleteLayoutListener = r2;
    }

    private final void updateSelectedStatus() {
        FavoriteAdapter r0 = this.mAdapter;
        if (r0 == null) goto L5;
        int r1 = r0.getCount();
    L6:
        int r3 = 0;
        boolean r5 = false;
        boolean r4 = true;
    L7:
        if (r3 >= r1) goto L26;
        FavoriteAdapter r6 = this.mAdapter;
        if (r6 == null) goto L11;
        boolean r7 = r6.isChecked(r3);
    L12:
        if (r7 == false) goto L15;
        if (r4 == false) goto L15;
        r4 = true;
    L16:
        FavoriteAdapter r8 = this.mAdapter;
        if (r8 == null) goto L19;
        boolean r9 = r8.isChecked(r3);
    L20:
        if (r9 == true) goto L24;
        if (r5 == true) goto L24;
        r5 = false;
    L25:
        r3 = r3 + 1;
    L24:
        r5 = true;
        goto L25
    L19:
        r9 = false;
    L15:
        r4 = false;
        goto L16
    L11:
        r7 = false;
        goto L12
    L26:
        SelectAllState r2 = this.mSelectedAll;
        if (r2 == null) goto L30;
        r2.setSelectAll(r4);
    L30:
        BottomDeleteLayoutListener r10 = this.mBottomDeleteLayoutListener;
        if (r10 == null) goto L37;
        r10.setBottomBtnEnable(r5);
        return;
    L37:
        return;
    L5:
        r1 = 0;
        goto L6
    }

    static {
        Companion = new Companion(null);
        sLongMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_STAR, LongMenuHelper.MenuType.MENU_WECHAT};
    }
}
