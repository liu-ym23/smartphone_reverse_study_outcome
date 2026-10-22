package com.android.contacts.list;

import android.app.ActivityOptions;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.ContentProviderOperation;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.database.ContentObserver;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemProperties;
import android.os.Vibrator;
import android.provider.CallLog;
import android.provider.ContactsContract;
import android.provider.Settings;
import android.provider.Telephony;
import android.security.bytedance.guard.BDSettingsEvent;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.text.InputFilter;
import android.text.TextUtils;
import android.util.Pair;
import android.util.TypedValue;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.TranslateAnimation;
import android.view.inputmethod.InputMethodManager;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckedTextView;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;
import android.widget.HeaderViewListAdapter;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.res.ResourcesCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.fragment.app.FragmentActivity;
import androidx.room.FtsOptions;
import bytedanceos.app.voiceassistant.ContactStruct;
import bytedanceos.app.voiceassistant.IVoiceAssistantCallback;
import bytedanceos.app.voiceassistant.IVoiceAssistantService;
import bytedanceos.util.NameAvatarController;
import com.GlobalProxyLancet;
import com.android.contacts.AbstractFragment;
import com.android.contacts.BlacklistManager;
import com.android.contacts.ContactFragmentsCallback;
import com.android.contacts.ContactLoader;
import com.android.contacts.ContactPhotoManager;
import com.android.contacts.ContactSaveService;
import com.android.contacts.ContactsApplication;
import com.android.contacts.ContactsSettingActivity;
import com.android.contacts.ContactsUtils;
import com.android.contacts.DSUtils;
import com.android.contacts.PinnedHeaderList.HeadersAdapter;
import com.android.contacts.PinnedHeaderList.HeadersListView;
import com.android.contacts.PreferencesCallback;
import com.android.contacts.R;
import com.android.contacts.TrackOptUtils;
import com.android.contacts.activities.ContactEditorActivity;
import com.android.contacts.activities.DialtactsActivity;
import com.android.contacts.activities.GroupBrowseListActivity;
import com.android.contacts.activities.GroupBrowserActivity;
import com.android.contacts.activities.GroupEditorActivity;
import com.android.contacts.bytedanceosquickcontact.QuickContactExpandableListView;
import com.android.contacts.bytedanceosquickcontact.QuickContactListView;
import com.android.contacts.calllog.blocked.BlockedCallAdapter;
import com.android.contacts.common.MoreContactUtils;
import com.android.contacts.common.SimContactsConstants;
import com.android.contacts.common.SimContactsOperation;
import com.android.contacts.common.dialog.CallSubjectDialog;
import com.android.contacts.dialpad.search.T9SearchLocaleUtils;
import com.android.contacts.editor.ContactEditorFragment;
import com.android.contacts.editor.ContactEditorUtils;
import com.android.contacts.editor.SelectAccountDialogFragment;
import com.android.contacts.forcetouch.ForceTouchController;
import com.android.contacts.group.GroupBrowseListAdapter;
import com.android.contacts.group.GroupBrowseListFragment;
import com.android.contacts.group.GroupListItem;
import com.android.contacts.group.GroupSelectionActivity;
import com.android.contacts.model.AccountType;
import com.android.contacts.model.AccountTypeManager;
import com.android.contacts.model.AccountWithDataSet;
import com.android.contacts.model.BytedanceAccountType;
import com.android.contacts.numberassistant.MarkInfoUtil;
import com.android.contacts.pick.PickerFragment;
import com.android.contacts.search.anim.SearchSwitchAnimHelper;
import com.android.contacts.setting.ImportExportFragment;
import com.android.contacts.util.AccountSelectionMenuDialog;
import com.android.contacts.util.AccountSelectionUtil;
import com.android.contacts.util.AnimationUtil;
import com.android.contacts.util.AsyncImageLoader;
import com.android.contacts.util.AvatarImageHelper;
import com.android.contacts.util.BytedanceContactContract;
import com.android.contacts.util.Constants;
import com.android.contacts.util.ContactsFpsMonitorFactory;
import com.android.contacts.util.ContactsFpsScenes;
import com.android.contacts.util.ContactsIntentUtils;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.MemoryCardUtil;
import com.android.contacts.util.MenuItem;
import com.android.contacts.util.MenuUtilsKt;
import com.android.contacts.util.NameSortComparator;
import com.android.contacts.util.OAlertDialogUtils;
import com.android.contacts.util.ProductUtils;
import com.android.contacts.util.SearchUtils;
import com.android.contacts.util.ShareContactByText;
import com.android.contacts.util.SidebarDragHelper;
import com.android.contacts.vcard.ImportSimContacts;
import com.android.contacts.widget.AvatarImageView;
import com.android.contacts.widget.SelectAllState;
import com.android.vcard.VCardConfig;
import com.android.vcard.VCardConstants;
import com.bytedance.apm.battery.config.BatteryTypeInf;
import com.bytedance.apm.constant.PerfConsts;
import com.bytedance.common.utility.UIUtils;
import com.bytedance.frameworks.baselib.network.http.BaseHttpRequestInfo;
import com.bytedance.framwork.core.sdklib.DBHelper;
import com.google.android.collect.Lists;
import com.obric.anim.ListAnimator;
import com.obric.capabilitykit.entity.app.AppEntity;
import com.obric.capabilitykit.entity.app.ContactEntity;
import com.obric.capabilitykit.entity.memory.MemorySourceLinkType;
import com.obric.capabilitykit.entity.meta.MetaTelephone;
import com.obric.capabilitykit.entity.search.InAppSearchEntity;
import com.obric.capabilitykit.entity.search.InAppSearchRequest;
import com.obric.capabilitykit.search.InAppSearchClient;
import com.obric.contactsdk.loader.ContractKt;
import com.obric.matrix.platform.sdk.ones.commonmonitor.fps.FPSSceneMonitor;
import com.obric.oui.button.OButton;
import com.obric.oui.button.OIconButtonFloating;
import com.obric.oui.checkbox.OCheckBox;
import com.obric.oui.common.util.ViewExtensionsKt;
import com.obric.oui.dialog.v2.action.OActionDialog;
import com.obric.oui.dialog.v2.alert.OAlertDialog;
import com.obric.oui.dialog.v2.alert.style.ButtonStyleController;
import com.obric.oui.dialog.v2.misc.StatusDialog;
import com.obric.oui.forms.OEditText;
import com.obric.oui.indexscrollbar.OIndexScrollbar;
import com.obric.oui.layout.OUILinearLayout;
import com.obric.oui.popover.v2.OPopover;
import com.obric.oui.searchbar.v2.OSearchBar;
import com.obric.oui.segmentedtab.OBottomNavigationBar;
import com.obric.oui.status.OPageStatus;
import com.obric.oui.text.OTextView;
import com.obric.oui.titlebar.OCTitleBar;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.obric.privacy.PermissionUtils;
import com.obric.privacy.PrivacyConstantsKt;
import com.obric.tracker.EventTrackerManager;
import com.obric.tracker.event.ContactPageShowEvent;
import com.obric.ui.ListTouchHelper;
import com.obric.ui.OFloatingTitleBarHolder;
import com.obric.ui.OUIHelper;
import com.obric.ui.dialog.OUIDialogHelper;
import com.obric.ui.dialog.action.ActionButtonStyle;
import com.obric.ui.dialog.action.ActionDialogItemData;
import com.obric.utils.ClickUtilsKt;
import com.obric.utils.OAutoSecurityGuardUtils;
import com.obric.utils.views.ObricBottomDeleteBarView;
import com.obric.utils.views.commonitemview.ContactsCommonListItem;
import com.obricOld.contacts.menus.LongMenuHelper;
import com.obricOld.recognition.VoiceSearchResultAdapter;
import com.ttnet.org.chromium.base.BaseSwitches;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.ListIterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.io.CloseableKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.math.MathKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import obric.app.tracker.Agent;
import obric.util.NavigationBarHelper;

/* JADX INFO: compiled from: NewContactListFragment.kt */
/* JADX INFO: loaded from: classes2.dex */
@Metadata(d1 = {"\u0000¤\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\b\u0005\n\u0002\u0010%\n\u0000\n\u0002\u0010!\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0016\n\u0002\b&\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\bh*\u0002,4\u0018\u0000 ý\u00042\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u00052\u00020\u00062\u00020\u00072\u00020\b2\u00020\t2\u00020\n2\u00020\u000b2\u00020\f2\u00020\r2\u00020\u000e2\u00020\u000f:*ú\u0004û\u0004ü\u0004ý\u0004þ\u0004ÿ\u0004\u0080\u0005\u0081\u0005\u0082\u0005\u0083\u0005\u0084\u0005\u0085\u0005\u0086\u0005\u0087\u0005\u0088\u0005\u0089\u0005\u008a\u0005\u008b\u0005\u008c\u0005\u008d\u0005\u008e\u0005B\u0005¢\u0006\u0002\u0010\u0010J\u0014\u0010à\u0002\u001a\u00030£\u00022\b\u0010á\u0002\u001a\u00030£\u0002H\u0002J\t\u0010â\u0002\u001a\u00020\u0012H\u0016J\n\u0010ã\u0002\u001a\u00030ä\u0002H\u0016J\n\u0010å\u0002\u001a\u00030ä\u0002H\u0002J\n\u0010æ\u0002\u001a\u00030ä\u0002H\u0016J\u0012\u0010ç\u0002\u001a\u00020\u00122\u0007\u0010è\u0002\u001a\u00020\u0014H\u0002J\n\u0010é\u0002\u001a\u00030ä\u0002H\u0002J\u0016\u0010ê\u0002\u001a\u00030ä\u00022\n\u0010ë\u0002\u001a\u0005\u0018\u00010Ü\u0002H\u0002J\u0013\u0010ì\u0002\u001a\u00030ä\u00022\u0007\u0010í\u0002\u001a\u00020\u0012H\u0002J\u0016\u0010î\u0002\u001a\u00030ï\u00022\n\u0010ð\u0002\u001a\u0005\u0018\u00010¦\u0001H\u0002J\u0012\u0010ñ\u0002\u001a\u00020\u00122\u0007\u0010ò\u0002\u001a\u00020\u0014H\u0002J\u0013\u0010ó\u0002\u001a\u00030ä\u00022\u0007\u0010ô\u0002\u001a\u00020\u0012H\u0002J\n\u0010õ\u0002\u001a\u00030ä\u0002H\u0002J\n\u0010ö\u0002\u001a\u00030ä\u0002H\u0002J\n\u0010÷\u0002\u001a\u00030ä\u0002H\u0002J\u0015\u0010ø\u0002\u001a\u00030ä\u00022\t\u0010ù\u0002\u001a\u0004\u0018\u000100H\u0002J+\u0010ú\u0002\u001a\u00030ä\u00022\n\u0010û\u0002\u001a\u0005\u0018\u00010\u0095\u00012\u0007\u0010ü\u0002\u001a\u00020\u00142\n\u0010ý\u0002\u001a\u0005\u0018\u00010þ\u0002H\u0002J\n\u0010ÿ\u0002\u001a\u00030ä\u0002H\u0002J\n\u0010\u0080\u0003\u001a\u00030ä\u0002H\u0016J\n\u0010\u0081\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010\u0082\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010\u0083\u0003\u001a\u00030ä\u0002H\u0002J\u0018\u0010\u0084\u0003\u001a\u0005\u0018\u00010\u0085\u00032\n\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u0082\u0001H\u0002J1\u0010\u0087\u0003\u001a\u00020\u00142\b\u0010û\u0002\u001a\u00030\u0095\u00012\r\u0010\u0088\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\r\u0010\u0089\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u001f\u0010\u008a\u0003\u001a\u0004\u0018\u00010O2\u0007\u0010\u008b\u0003\u001a\u00020O2\t\u0010\u008c\u0003\u001a\u0004\u0018\u00010OH\u0004J\u0015\u0010\u008d\u0003\u001a\u0005\u0018\u00010£\u00022\t\u0010\u008e\u0003\u001a\u0004\u0018\u00010\u0017J#\u0010\u008f\u0003\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u0001000&2\b\u0010û\u0002\u001a\u00030\u0095\u0001H\u0002J#\u0010\u0090\u0003\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0007\u0010ò\u0002\u001a\u00020\u00142\u0007\u0010\u0091\u0003\u001a\u00020\u0012H\u0002J\f\u0010\u0092\u0003\u001a\u0005\u0018\u00010¡\u0002H\u0002J\u0016\u0010\u0093\u0003\u001a\u0004\u0018\u0001002\t\u0010\u0094\u0003\u001a\u0004\u0018\u000100H\u0002J\u0015\u0010\u0095\u0003\u001a\u0004\u0018\u0001002\b\u0010û\u0002\u001a\u00030\u0095\u0001H\u0002J\f\u0010\u0096\u0003\u001a\u0005\u0018\u00010\u0097\u0003H\u0002J\f\u0010\u0098\u0003\u001a\u0005\u0018\u00010ï\u0001H\u0016J&\u0010\u0099\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0015\u0010\u009a\u0003\u001a\u0010\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0017\u0018\u000109H\u0002J\f\u0010\u009b\u0003\u001a\u0005\u0018\u00010í\u0001H\u0016J\u0018\u0010\u009c\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0007\u0010\u009d\u0003\u001a\u00020\u0014H\u0002J4\u0010\u009e\u0003\u001a\u0004\u0018\u00010a2\u0007\u0010\u009f\u0003\u001a\u00020\u00142\u0007\u0010 \u0003\u001a\u00020\u00122\n\u0010¡\u0003\u001a\u0005\u0018\u00010ë\u00012\t\u0010¢\u0003\u001a\u0004\u0018\u00010aH\u0002J\b\u0010£\u0003\u001a\u00030ä\u0002J\u001e\u0010¤\u0003\u001a\u00030ä\u00022\b\u0010\u0086\u0003\u001a\u00030\u0082\u00012\b\u0010¥\u0003\u001a\u00030¦\u0003H\u0002J@\u0010§\u0003\u001a\u00020\u00122\f\u0010¨\u0003\u001a\u0007\u0012\u0002\b\u00030©\u00032\n\u0010\u0086\u0003\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010ª\u0003\u001a\u00020\u00142\u0007\u0010«\u0003\u001a\u00020\u00142\t\u0010¬\u0003\u001a\u0004\u0018\u00010\u0017H\u0002J\n\u0010\u00ad\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010®\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010¯\u0003\u001a\u00030ä\u0002H\u0016J\n\u0010°\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010±\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010²\u0003\u001a\u00030ä\u0002H\u0002J\u0012\u0010³\u0003\u001a\u00020\u00122\u0007\u0010ü\u0002\u001a\u00020\u0014H\u0002J7\u0010´\u0003\u001a\u0005\u0018\u00010\u0082\u00012\b\u0010µ\u0003\u001a\u00030¶\u00032\n\u0010·\u0003\u001a\u0005\u0018\u00010\u0084\u00012\n\u0010¸\u0003\u001a\u0005\u0018\u00010¹\u00032\u0007\u0010º\u0003\u001a\u00020\u0014H\u0004J\n\u0010»\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010¼\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010½\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010¾\u0003\u001a\u00030ä\u0002H\u0002J\u0016\u0010¿\u0003\u001a\u00030ä\u00022\n\u0010û\u0002\u001a\u0005\u0018\u00010\u0095\u0001H\u0002J$\u0010À\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00170\u00160\u00162\u000f\u0010\u0088\u0003\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016J\u001c\u0010Á\u0003\u001a\u00030ä\u00022\u0007\u0010è\u0002\u001a\u00020\u00142\u0007\u0010\u0091\u0003\u001a\u00020\u0012H\u0002J\b\u0010Â\u0003\u001a\u00030ä\u0002J\u0013\u0010Ã\u0003\u001a\u00030ä\u00022\u0007\u0010ò\u0002\u001a\u00020\u0014H\u0002J\n\u0010Ä\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010Å\u0003\u001a\u00030ä\u0002H\u0002J\u001e\u0010Æ\u0003\u001a\u00020\u00122\u0007\u0010Ç\u0003\u001a\u00020\u00142\n\u0010È\u0003\u001a\u0005\u0018\u00010É\u0003H\u0002J\u0014\u0010Ê\u0003\u001a\u00020\u00122\t\u0010Ë\u0003\u001a\u0004\u0018\u000100H\u0002J\u001d\u0010Ì\u0003\u001a\u00020\u00122\b\u0010\u0086\u0003\u001a\u00030\u0082\u00012\b\u0010¥\u0003\u001a\u00030¦\u0003H\u0002J\u001f\u0010Í\u0003\u001a\u00020\u00122\t\u0010Î\u0003\u001a\u0004\u0018\u0001002\t\u0010Ï\u0003\u001a\u0004\u0018\u000100H\u0002J\u001f\u0010Ð\u0003\u001a\u00020\u00122\n\u0010ë\u0002\u001a\u0005\u0018\u00010Ü\u00022\b\u0010Ñ\u0003\u001a\u00030¦\u0003H\u0002J\u001f\u0010Ò\u0003\u001a\u00030ä\u00022\u0013\u0010\u009a\u0003\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001709H\u0002J#\u0010Ó\u0003\u001a\u00020\u00122\t\u0010Ô\u0003\u001a\u0004\u0018\u0001002\r\u0010Õ\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u0018\u0010Ö\u0003\u001a\u00020\u00122\r\u0010\u0088\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\u001f\u0010×\u0003\u001a\u00030ä\u00022\u0007\u0010Ø\u0003\u001a\u00020\u00122\n\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u0002H\u0002J$\u0010Ù\u0003\u001a\u00030ä\u00022\u000f\u0010Ú\u0003\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u00162\u0007\u0010Û\u0003\u001a\u00020\u0014H\u0002J \u0010Ü\u0003\u001a\u00030ä\u00022\n\u0010ý\u0002\u001a\u0005\u0018\u00010þ\u00022\b\u0010Ý\u0003\u001a\u00030¹\u0003H\u0016J\n\u0010Þ\u0003\u001a\u00030ä\u0002H\u0016J(\u0010ß\u0003\u001a\u00030ä\u00022\u0007\u0010à\u0003\u001a\u00020\u00142\u0007\u0010á\u0003\u001a\u00020\u00142\n\u0010â\u0003\u001a\u0005\u0018\u00010ã\u0003H\u0016J\n\u0010ä\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010å\u0003\u001a\u00030ä\u0002H\u0002J;\u0010æ\u0003\u001a\u00030ä\u00022\u0007\u0010Ø\u0003\u001a\u00020\u00122\n\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u00022\u0007\u0010ç\u0003\u001a\u00020\u00122\b\u0010è\u0003\u001a\u00030é\u00032\u0007\u0010ô\u0002\u001a\u00020\u0012H\u0002J\u0014\u0010ê\u0003\u001a\u00030ä\u00022\b\u0010û\u0002\u001a\u00030\u0095\u0001H\u0016J\n\u0010ë\u0003\u001a\u00030ä\u0002H\u0016J\b\u0010ì\u0003\u001a\u00030ä\u0002J\n\u0010í\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010î\u0003\u001a\u00030ä\u0002H\u0002J\u0014\u0010ï\u0003\u001a\u00030ä\u00022\b\u0010\u0086\u0003\u001a\u00030\u0082\u0001H\u0016J\b\u0010ð\u0003\u001a\u00030ä\u0002J\n\u0010ñ\u0003\u001a\u00030ä\u0002H\u0016J\u0016\u0010ò\u0003\u001a\u00030ä\u00022\n\u0010¸\u0003\u001a\u0005\u0018\u00010¹\u0003H\u0016J.\u0010ó\u0003\u001a\u0005\u0018\u00010\u0082\u00012\b\u0010µ\u0003\u001a\u00030¶\u00032\n\u0010·\u0003\u001a\u0005\u0018\u00010\u0084\u00012\n\u0010¸\u0003\u001a\u0005\u0018\u00010¹\u0003H\u0016J\n\u0010ô\u0003\u001a\u00030ä\u0002H\u0016J\n\u0010õ\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010ö\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010÷\u0003\u001a\u00030ä\u0002H\u0016J\n\u0010ø\u0003\u001a\u00030ä\u0002H\u0016J\n\u0010ù\u0003\u001a\u00030ä\u0002H\u0002J\n\u0010ú\u0003\u001a\u00030ä\u0002H\u0002J\u0013\u0010û\u0003\u001a\u00030ä\u00022\u0007\u0010ü\u0003\u001a\u00020\u0012H\u0002J\n\u0010ý\u0003\u001a\u00030ä\u0002H\u0002J\u001f\u0010þ\u0003\u001a\u00030ä\u00022\n\u0010ÿ\u0003\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0080\u0004\u001a\u00020\u0012H\u0016J6\u0010\u0081\u0004\u001a\u00030ä\u00022\f\u0010ÿ\u0003\u001a\u0007\u0012\u0002\b\u00030©\u00032\n\u0010\u0080\u0004\u001a\u0005\u0018\u00010\u0082\u00012\u0007\u0010\u0082\u0004\u001a\u00020\u00142\u0007\u0010\u0083\u0004\u001a\u00020'H\u0016J\u0012\u0010\u0084\u0004\u001a\u00020\u00122\u0007\u0010è\u0002\u001a\u00020\u0014H\u0016J\u0013\u0010\u0085\u0004\u001a\u00030ä\u00022\u0007\u0010è\u0002\u001a\u00020\u0014H\u0002J\n\u0010\u0086\u0004\u001a\u00030ä\u0002H\u0016J\n\u0010\u0087\u0004\u001a\u00030ä\u0002H\u0016J\n\u0010\u0088\u0004\u001a\u00030ä\u0002H\u0016J\b\u0010\u0089\u0004\u001a\u00030ä\u0002J\u0015\u0010\u008a\u0004\u001a\u00030ä\u00022\t\u0010\u008b\u0004\u001a\u0004\u0018\u000100H\u0016J\u001c\u0010\u008a\u0004\u001a\u00030ä\u00022\t\u0010\u008b\u0004\u001a\u0004\u0018\u0001002\u0007\u0010\u008c\u0004\u001a\u00020\u0012J4\u0010\u008d\u0004\u001a\u00030ä\u00022\u0007\u0010à\u0003\u001a\u00020\u00142\u000f\u0010\u008e\u0004\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001000/2\b\u0010\u008f\u0004\u001a\u00030\u0090\u0004H\u0016¢\u0006\u0003\u0010\u0091\u0004J\n\u0010\u0092\u0004\u001a\u00030ä\u0002H\u0016J\u0014\u0010\u0093\u0004\u001a\u00030ä\u00022\b\u0010\u0094\u0004\u001a\u00030¹\u0003H\u0016J1\u0010\u0095\u0004\u001a\u00030ä\u00022\n\u0010ÿ\u0003\u001a\u0005\u0018\u00010\u0096\u00042\u0007\u0010\u0080\u0004\u001a\u00020\u00142\u0007\u0010\u0097\u0004\u001a\u00020\u00142\u0007\u0010\u0098\u0004\u001a\u00020\u0014H\u0016J\u001d\u0010\u0099\u0004\u001a\u00030ä\u00022\b\u0010ÿ\u0003\u001a\u00030\u0096\u00042\u0007\u0010\u0080\u0004\u001a\u00020\u0014H\u0016J\n\u0010\u009a\u0004\u001a\u00030ä\u0002H\u0016J\n\u0010\u009b\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010\u009c\u0004\u001a\u00030ä\u0002H\u0016J\n\u0010\u009d\u0004\u001a\u00030ä\u0002H\u0016J\n\u0010\u009e\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010\u009f\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010 \u0004\u001a\u00030ä\u00022\u0007\u0010¡\u0004\u001a\u00020\u0012H\u0016J9\u0010¢\u0004\u001a\u00030ä\u00022\u0007\u0010Ø\u0003\u001a\u00020\u00122\b\u0010Û\u0002\u001a\u00030Ü\u00022\u0007\u0010ç\u0003\u001a\u00020\u00122\b\u0010è\u0003\u001a\u00030é\u00032\u0007\u0010ô\u0002\u001a\u00020\u0012H\u0002J\n\u0010£\u0004\u001a\u00030ä\u0002H\u0002J\u001c\u0010¤\u0004\u001a\u00030ä\u00022\u0007\u0010Ø\u0003\u001a\u00020\u00122\u0007\u0010¥\u0004\u001a\u00020\u0012H\u0002J.\u0010¤\u0004\u001a\u00030ä\u00022\u0007\u0010Ø\u0003\u001a\u00020\u00122\u0007\u0010¥\u0004\u001a\u00020\u00122\u0007\u0010ç\u0003\u001a\u00020\u00122\u0007\u0010ô\u0002\u001a\u00020\u0012H\u0002J\u0016\u0010¦\u0004\u001a\u00030ä\u00022\n\u0010È\u0003\u001a\u0005\u0018\u00010§\u0004H\u0002J\u001f\u0010¨\u0004\u001a\u00030ä\u00022\u0007\u0010\u0083\u0004\u001a\u00020'2\n\u0010©\u0004\u001a\u0005\u0018\u00010\u0085\u0003H\u0002J\n\u0010ª\u0004\u001a\u00030ä\u0002H\u0016J\t\u0010«\u0004\u001a\u00020\u0012H\u0002J\u0013\u0010¬\u0004\u001a\u00030ä\u00022\u0007\u0010Ø\u0003\u001a\u00020\u0012H\u0002J\n\u0010\u00ad\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010®\u0004\u001a\u00030ä\u00022\u0007\u0010¯\u0004\u001a\u00020\u0014H\u0002J\u0015\u0010°\u0004\u001a\u00030ä\u00022\t\u0010\u008e\u0003\u001a\u0004\u0018\u00010\u0017H\u0002J\n\u0010±\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010²\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010³\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010´\u0004\u001a\u00030ä\u0002H\u0016J\u0014\u0010µ\u0004\u001a\u00030ä\u00022\n\u0010¶\u0004\u001a\u0005\u0018\u00010£\u0002J\u0016\u0010·\u0004\u001a\u00030ä\u00022\n\u0010¶\u0004\u001a\u0005\u0018\u00010£\u0002H\u0002J\u0014\u0010¸\u0004\u001a\u0004\u0018\u00010O2\u0007\u0010¹\u0004\u001a\u000200H\u0002J\n\u0010º\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010»\u0004\u001a\u00030ä\u0002H\u0002J-\u0010¼\u0004\u001a\u00030ä\u00022\r\u0010½\u0004\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\t\u0010Ô\u0003\u001a\u0004\u0018\u0001002\u0007\u0010¾\u0004\u001a\u00020\u0012H\u0002J\n\u0010¿\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010À\u0004\u001a\u00030ä\u00022\u0007\u0010ò\u0002\u001a\u00020\u0014H\u0002J\n\u0010Á\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010Â\u0004\u001a\u00030ä\u00022\t\u0010Ã\u0004\u001a\u0004\u0018\u00010_J\u0013\u0010Ä\u0004\u001a\u00030ä\u00022\u0007\u0010Å\u0004\u001a\u00020\u0014H\u0002J\u0013\u0010Æ\u0004\u001a\u00030ä\u00022\t\u0010Ç\u0004\u001a\u0004\u0018\u00010wJ,\u0010È\u0004\u001a\u00030ä\u00022\b\u0010û\u0002\u001a\u00030\u0095\u00012\r\u0010\u0088\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u00162\u0007\u0010É\u0004\u001a\u00020\u0014H\u0002J)\u0010Ê\u0004\u001a\u00030ä\u00022\b\u0010û\u0002\u001a\u00030\u0095\u00012\u0013\u0010Ë\u0004\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u001409H\u0002J\u0016\u0010Ì\u0004\u001a\u00030ä\u00022\n\u0010Õ\u0003\u001a\u0005\u0018\u00010Ü\u0002H\u0002J\u001c\u0010Í\u0004\u001a\u00030ä\u00022\u0007\u0010¡\u0004\u001a\u00020\u00122\u0007\u0010Î\u0004\u001a\u00020\u0012H\u0016J\u0012\u0010Ï\u0004\u001a\u00030ä\u00022\b\u0010Ð\u0004\u001a\u00030¨\u0001J\u0013\u0010Ñ\u0004\u001a\u00030ä\u00022\u0007\u0010Ò\u0004\u001a\u00020\u0012H\u0002J\u0011\u0010Ó\u0004\u001a\u00030ä\u00022\u0007\u0010Ô\u0004\u001a\u00020\u0012J\u001c\u0010Õ\u0004\u001a\u00030ä\u00022\u0007\u0010ò\u0002\u001a\u00020\u00142\u0007\u0010Ö\u0004\u001a\u00020\u0012H\u0002J\u0013\u0010×\u0004\u001a\u00030ä\u00022\u0007\u0010Ø\u0004\u001a\u00020\u0012H\u0002J\u0014\u0010Ù\u0004\u001a\u00030ä\u00022\n\u0010Ð\u0004\u001a\u0005\u0018\u00010\u0085\u0002J,\u0010Ú\u0004\u001a\u00030ä\u00022\b\u0010û\u0002\u001a\u00030\u0095\u00012\u0007\u0010ò\u0002\u001a\u00020\u00142\r\u0010\u0088\u0003\u001a\b\u0012\u0004\u0012\u00020\u00170\u0016H\u0002J\n\u0010Û\u0004\u001a\u00030ä\u0002H\u0016J\n\u0010Ü\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010Ý\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010Þ\u0004\u001a\u00030ä\u00022\u0007\u0010ü\u0002\u001a\u00020\u0014H\u0002J\n\u0010ß\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010à\u0004\u001a\u00030ä\u00022\u0007\u0010á\u0004\u001a\u00020'H\u0002J\n\u0010â\u0004\u001a\u00030ä\u0002H\u0002J\u0012\u0010ã\u0004\u001a\u00030ä\u00022\b\u0010ä\u0004\u001a\u00030ã\u0003J\n\u0010å\u0004\u001a\u00030ä\u0002H\u0016J\n\u0010æ\u0004\u001a\u00030ä\u0002H\u0002J=\u0010ç\u0004\u001a\u00030ä\u00022\n\u0010è\u0004\u001a\u0005\u0018\u00010£\u00022\u0011\u0010é\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u000100\u0018\u00010\u00162\u0007\u0010ê\u0004\u001a\u00020\u00122\t\b\u0002\u0010ë\u0004\u001a\u00020\u0012H\u0002J\n\u0010ì\u0004\u001a\u00030ä\u0002H\u0002J\u001c\u0010í\u0004\u001a\u00030ä\u00022\u0007\u0010¬\u0003\u001a\u00020\u00172\u0007\u0010î\u0004\u001a\u00020'H\u0002J\n\u0010ï\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010ð\u0004\u001a\u00030ä\u00022\u0007\u0010ñ\u0004\u001a\u00020\u0012H\u0002J\u0015\u0010ò\u0004\u001a\u00030ä\u00022\t\b\u0002\u0010\u008c\u0004\u001a\u00020\u0012H\u0002J'\u0010ó\u0004\u001a\u00030ä\u00022\u0007\u0010è\u0002\u001a\u00020\u00142\u0007\u0010\u0091\u0003\u001a\u00020\u00122\t\b\u0002\u0010ô\u0004\u001a\u00020\u0012H\u0002J\n\u0010õ\u0004\u001a\u00030ä\u0002H\u0002J\n\u0010ö\u0004\u001a\u00030ä\u0002H\u0002J\u0013\u0010÷\u0004\u001a\u00030ä\u00022\u0007\u0010ø\u0004\u001a\u00020\u0012H\u0002J\u001b\u0010ù\u0004\u001a\u00030ä\u00022\u0006\u0010G\u001a\u00020\u00122\u0007\u0010è\u0002\u001a\u00020\u0014H\u0002R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082D¢\u0006\u0002\n\u0000R$\u0010\u0015\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u001aR$\u0010\u001b\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001aR$\u0010\u001d\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001aR\u0016\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R$\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\u001aR0\u0010%\u001a\u001e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u00140&j\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u0014`(8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b)\u0010*R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u001a\u0010.\u001a\b\u0012\u0004\u0012\u0002000/8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b1\u00102R\u0010\u00103\u001a\u000204X\u0082\u0004¢\u0006\u0004\n\u0002\u00105R$\u00106\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b7\u0010\u001aR\u001a\u00108\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020\u001709X\u0082\u0004¢\u0006\u0002\n\u0000R\u0019\u0010:\u001a\n\u0012\u0004\u0012\u00020'\u0018\u00010;8F¢\u0006\u0006\u001a\u0004\b<\u0010=R\u001a\u0010>\u001a\b\u0012\u0004\u0012\u00020'0;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b?\u0010=R\u0010\u0010@\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010A\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bA\u0010BR\u0014\u0010C\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bC\u0010BR\u000e\u0010D\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010E\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bE\u0010BR\u001e\u0010G\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bG\u0010BR\u000e\u0010H\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010I\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bI\u0010BR\u001e\u0010J\u001a\u00020\u00122\u0006\u0010F\u001a\u00020\u0012@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\bJ\u0010BR\u0014\u0010K\u001a\u00020\u00128BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bK\u0010BR\u001a\u0010L\u001a\b\u0012\u0004\u0012\u00020'0;8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bM\u0010=R\u0016\u0010N\u001a\u0004\u0018\u00010O8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bP\u0010QR\u0010\u0010R\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010S\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010U\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010V\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010W\u001a\u0004\u0018\u00010XX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010Y\u001a\b\u0018\u00010ZR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\\\u001a\u0004\u0018\u00010]X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010^\u001a\u0004\u0018\u00010_X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010`\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010b\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010c\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010d\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010e\u001a\u0004\u0018\u00010aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010f\u001a\u0004\u0018\u00010gX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010h\u001a\u00020iX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010j\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010k\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010l\u001a\u0004\u0018\u00010mX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010n\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010p\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u000100\u0012\u0006\u0012\u0004\u0018\u0001000&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010q\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010s\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010t\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010v\u001a\u0004\u0018\u00010wX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010x\u001a\u0004\u0018\u00010yX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010z\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010|\u001a\b\u0018\u00010}R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010~\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u007f\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0081\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0083\u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0085\u0001\u001a\u0014\u0012\u0004\u0012\u00020'0\u0086\u0001j\t\u0012\u0004\u0012\u00020'`\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0088\u0001\u001a\u0014\u0012\u0004\u0012\u00020'0\u0086\u0001j\t\u0012\u0004\u0012\u00020'`\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0089\u0001\u001a\u0014\u0012\u0004\u0012\u00020'0\u0086\u0001j\t\u0012\u0004\u0012\u00020'`\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u008a\u0001\u001a\u0014\u0012\u0004\u0012\u00020'0\u0086\u0001j\t\u0012\u0004\u0012\u00020'`\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u008b\u0001\u001a\u0014\u0012\u0004\u0012\u00020'0\u0086\u0001j\t\u0012\u0004\u0012\u00020'`\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008c\u0001\u001a\u00030\u008d\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u008e\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0090\u0001\u001a\u00030\u0091\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0092\u0001\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0093\u0001\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0094\u0001\u001a\u0005\u0018\u00010\u0095\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0096\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0097\u0001\u001a\u00030\u0098\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0099\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009a\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009b\u0001\u001a\u0005\u0018\u00010\u009c\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u009d\u0001\u001a\u0005\u0018\u00010\u009e\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u009f\u0001\u001a\u00020'X\u0082D¢\u0006\u0002\n\u0000R\u0012\u0010 \u0001\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¡\u0001\u001a\u0005\u0018\u00010\u008f\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010¢\u0001\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010'\u0012\u0006\u0012\u0004\u0018\u00010\u00140&X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010£\u0001\u001a\u00030¤\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010¥\u0001\u001a\u0005\u0018\u00010¦\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010§\u0001\u001a\u0005\u0018\u00010¨\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010©\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ª\u0001\u001a\u0005\u0018\u00010«\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¬\u0001\u001a\u0005\u0018\u00010\u0080\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u00ad\u0001\u001a\u00030®\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¯\u0001\u001a\u00030°\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010±\u0001\u001a\u0005\u0018\u00010\u0082\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010²\u0001\u001a\u0004\u0018\u00010{X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010³\u0001\u001a\u00030´\u0001X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bµ\u0001\u0010¶\u0001\"\u0006\b·\u0001\u0010¸\u0001R\u000f\u0010¹\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010º\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010»\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¼\u0001\u001a\u00030½\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010¾\u0001\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010¿\u0001\u001a\t\u0012\u0005\u0012\u00030À\u00010;X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010Á\u0001\u001a\t\u0018\u00010Â\u0001R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ã\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ä\u0001\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010Å\u0001\u001a\t\u0012\u0005\u0012\u00030À\u00010;X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Æ\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ç\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010È\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010É\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ê\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ë\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ì\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Í\u0001\u001a\u00030Î\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ï\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ð\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ñ\u0001\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ò\u0001\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Ó\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010Ô\u0001\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R#\u0010Õ\u0001\u001a\u0013\u0012\r\u0012\u000b\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010/\u0018\u00010/X\u0082\u000e¢\u0006\u0005\n\u0003\u0010×\u0001R#\u0010Ø\u0001\u001a\u0013\u0012\r\u0012\u000b\u0012\u0007\u0012\u0005\u0018\u00010Ö\u00010/\u0018\u00010/X\u0082\u000e¢\u0006\u0005\n\u0003\u0010×\u0001R\u001d\u0010Ù\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010Ö\u0001\u0018\u00010/X\u0082\u000e¢\u0006\u0005\n\u0003\u0010Ú\u0001R\u001d\u0010Û\u0001\u001a\r\u0012\u0007\u0012\u0005\u0018\u00010Ö\u0001\u0018\u00010/X\u0082\u000e¢\u0006\u0005\n\u0003\u0010Ú\u0001R\u0012\u0010Ü\u0001\u001a\u0005\u0018\u00010Ý\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010Þ\u0001\u001a\u00020\u0012X\u0082D¢\u0006\u0002\n\u0000R\u000f\u0010ß\u0001\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010à\u0001\u001a\u00020\u0014X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bá\u0001\u0010â\u0001\"\u0006\bã\u0001\u0010ä\u0001R\u000f\u0010å\u0001\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010æ\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010ç\u0001\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010è\u0001\u001a\u0005\u0018\u00010é\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ê\u0001\u001a\u0005\u0018\u00010ë\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010ì\u0001\u001a\u0005\u0018\u00010í\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010î\u0001\u001a\u0005\u0018\u00010ï\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010ð\u0001\u001a\u0004\u0018\u00010rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ñ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ò\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ó\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ô\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010õ\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ö\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010÷\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ø\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010ù\u0001\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ú\u0001\u001a\u00030û\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010ü\u0001\u001a\u0005\u0018\u00010é\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010ý\u0001\u001a\u0014\u0012\u0004\u0012\u00020'0\u0086\u0001j\t\u0012\u0004\u0012\u00020'`\u0087\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010þ\u0001\u001a\u0005\u0018\u00010ÿ\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0080\u0002\u001a\u00030\u0081\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0082\u0002\u001a\u0005\u0018\u00010\u0083\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0084\u0002\u001a\u0005\u0018\u00010\u0085\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0086\u0002\u001a\u0005\u0018\u00010\u0087\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u0088\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0089\u0002\u001a\t\u0018\u00010Â\u0001R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008a\u0002\u001a\u00030\u008b\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u008c\u0002\u001a\u0005\u0018\u00010\u008d\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010\u008e\u0002\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u008f\u0002\u001a\u00030\u0090\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0091\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0092\u0002\u001a\u00030\u0090\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010\u0093\u0002\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0094\u0002\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0095\u0002\u001a\u0005\u0018\u00010¦\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0096\u0002\u001a\u0004\u0018\u00010oX\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0097\u0002\u001a\u0004\u0018\u000100X\u0082\u000e¢\u0006\u0002\n\u0000R!\u0010\u0098\u0002\u001a\u0014\u0012\u0004\u0012\u00020'\u0012\n\u0012\b\u0012\u0004\u0012\u0002000;09X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0099\u0002\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009a\u0002\u001a\u0005\u0018\u00010\u009b\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009c\u0002\u001a\u0005\u0018\u00010\u0084\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u009d\u0002\u001a\u0005\u0018\u00010\u009e\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u009f\u0002\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010 \u0002\u001a\u0005\u0018\u00010¡\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¢\u0002\u001a\u0005\u0018\u00010£\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010¤\u0002\u001a\r\u0012\u0004\u0012\u00020'0¥\u0002R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010¦\u0002\u001a\t\u0018\u00010§\u0002R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010¨\u0002\u001a\u0005\u0018\u00010©\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010ª\u0002\u001a\u00030«\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¬\u0002\u001a\u00030\u00ad\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010®\u0002\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010¯\u0002\u001a\u00030\u0090\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010°\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010±\u0002\u001a\u00020'X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010²\u0002\u001a\u00030³\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010´\u0002\u001a\u00030\u0090\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010µ\u0002\u001a\u0005\u0018\u00010¶\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010·\u0002\u001a\u00030¸\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010¹\u0002\u001a\u00030º\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010»\u0002\u001a\u0005\u0018\u00010¼\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u000f\u0010½\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010¾\u0002\u001a\u00070¿\u0002R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010À\u0002\u001a\u00030Á\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010Â\u0002\u001a\u0005\u0018\u00010Ã\u0002X\u0086\u000e¢\u0006\u0012\n\u0000\u001a\u0006\bÄ\u0002\u0010Å\u0002\"\u0006\bÆ\u0002\u0010Ç\u0002R\u000f\u0010È\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010É\u0002\u001a\u00030\u0090\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u000f\u0010Ê\u0002\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010Ë\u0002\u001a\u0005\u0018\u00010\u0082\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ì\u0002\u001a\u00030Í\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010Î\u0002\u001a\u0012\u0012\u0004\u0012\u00020\u00170\u0016j\b\u0012\u0004\u0012\u00020\u0017`\u00188BX\u0082\u0004¢\u0006\u0007\u001a\u0005\bÏ\u0002\u0010\u001aR\u0017\u0010Ð\u0002\u001a\u0005\u0018\u00010ÿ\u00018F¢\u0006\b\u001a\u0006\bÑ\u0002\u0010Ò\u0002R\u001a\u0010Ó\u0002\u001a\u0005\u0018\u00010\u0087\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÔ\u0002\u0010Õ\u0002R\u0012\u0010Ö\u0002\u001a\u0005\u0018\u00010×\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010Ø\u0002\u001a\u00030Ù\u0002X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010Ú\u0002\u001a\u0005\u0018\u00010×\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010Û\u0002\u001a\u0005\u0018\u00010Ü\u00028BX\u0082\u0004¢\u0006\b\u001a\u0006\bÝ\u0002\u0010Þ\u0002R\u0011\u0010ß\u0002\u001a\u0004\u0018\u00010uX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u008f\u0005"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment;", "Lcom/android/contacts/AbstractFragment;", "Landroid/widget/AdapterView$OnItemClickListener;", "Landroid/view/View$OnClickListener;", "Landroid/view/View$OnFocusChangeListener;", "Lcom/android/contacts/list/IContactSearchBarView;", "Lcom/android/contacts/activities/DialtactsActivity$ViewPagerVisibilityListener;", "Landroid/widget/AbsListView$OnScrollListener;", "Lcom/android/contacts/editor/SelectAccountDialogFragment$Listener;", "Lcom/android/contacts/activities/DialtactsActivity$PageEnableListener;", "Lcom/android/contacts/activities/DialtactsActivity$ReleaseResourceListener;", "Lcom/android/contacts/activities/DialtactsActivity$onBackPressListener;", "Landroid/os/IBinder$DeathRecipient;", "Lcom/android/contacts/util/AvatarImageHelper$OnAvatarTextFontChangeListener;", "Lcom/android/contacts/list/ContactListFilterController$ContactListFilterListener;", "Lcom/android/contacts/activities/DialtactsActivity$OnDBDataChangeListener;", "()V", "DEBUG", "", "TIME_NEED_TO_TIP", "", "addedTimeContacts", "Ljava/util/ArrayList;", "Lcom/android/contacts/list/SamContact;", "Lkotlin/collections/ArrayList;", "getAddedTimeContacts", "()Ljava/util/ArrayList;", "allCityContacts", "getAllCityContacts", "allContactsWithCompany", "getAllContactsWithCompany", "asyncImageLoader", "Lcom/android/contacts/util/AsyncImageLoader;", "getAsyncImageLoader", "()Lcom/android/contacts/util/AsyncImageLoader;", "businessCardContacts", "getBusinessCardContacts", "contactFrequence", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "getContactFrequence", "()Ljava/util/HashMap;", "contactListViewClickListener", "com/android/contacts/list/NewContactListFragment$contactListViewClickListener$1", "Lcom/android/contacts/list/NewContactListFragment$contactListViewClickListener$1;", "contactProjection", "", "", "getContactProjection", "()[Ljava/lang/String;", "contactSearchListViewClickListener", "com/android/contacts/list/NewContactListFragment$contactSearchListViewClickListener$1", "Lcom/android/contacts/list/NewContactListFragment$contactSearchListViewClickListener$1;", "contactsTimes", "getContactsTimes", "curContactsMap", "", "currentVisibleContact", "", "getCurrentVisibleContact", "()Ljava/util/List;", "groupListVisibleList", "getGroupListVisibleList", "importFlag", "isContactsListViewStateIdle", "()Z", "isEmpty", "isEnableSelectContacts", "isResultDialogShown", "<set-?>", "isSearch", "isSearchAnimationing", "isSearchBarPopupShowing", "isShowGroup", "isShowQuickContact", "listVisibleList", "getListVisibleList", BatteryTypeInf.BATTERY_LOC_API, "Landroid/location/Location;", "getLocation", "()Landroid/location/Location;", "mAccountsFilterQueryParameter", "mActivity", "Landroidx/fragment/app/FragmentActivity;", "mAllContactsSelected", "mAsyncImageLoader", "mBcrDataObserver", "Landroid/database/ContentObserver;", "mBlacklistChangeListener", "Lcom/android/contacts/list/NewContactListFragment$BlacklistChangeListener;", "mBlacklistHasChanged", "mBlacklistManager", "Lcom/android/contacts/BlacklistManager;", "mBottomDeleteLayoutListener", "Lcom/android/contacts/list/BottomDeleteLayoutListener;", "mBtnGroupLeft", "Lcom/obric/oui/button/OButton;", "mBtnGroupMenu", "mBtnGroupRightDelete", "mBtnImportContacts", "mBtnOpenCamera", "mBtnVoiceSearchContacts", "Landroid/widget/ImageButton;", "mCallback", "Lbytedanceos/app/voiceassistant/IVoiceAssistantCallback;", "mCancelRecognizeByTooShortTime", "mCityChanged", "mCityListView", "Lcom/android/contacts/bytedanceosquickcontact/QuickContactExpandableListView;", "mCityListViewFrame", "Landroid/widget/FrameLayout;", "mCityPinYinMap", "mCloseVoiceDialog", "Landroid/app/AlertDialog;", "mCollapseAllGroup", "mContactBody", "Landroid/widget/RelativeLayout;", "mContactListFilterController", "Lcom/android/contacts/list/ContactListFilterController;", "mContactListView", "Lcom/android/contacts/PinnedHeaderList/HeadersListView;", "mContactSelectAllBtn", "Lcom/android/contacts/widget/SelectAllState;", "mContactsContent", "Lcom/android/contacts/list/NewContactListFragment$ContactsContent;", "mContactsEmptyView", "mContactsEmptyViewStub", "Landroid/view/ViewStub;", "mContactsFragment", "Landroid/view/View;", "mContactsFrameView", "Landroid/view/ViewGroup;", "mContactsIdBCR", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "mContactsIdForLocation", "mContactsIdList", "mContactsIdSIM1", "mContactsIdSIM2", "mContactsListAnimator", "Lcom/obric/anim/ListAnimator;", "mContactsListEmptyView", "Lcom/obric/oui/status/OPageStatus;", "mContactsSelectionListener", "Lcom/android/contacts/list/ContactsSelectionListener;", "mContactsTipEmptyView", "mContactsTipEmptyViewStub", "mContext", "Landroid/content/Context;", "mCover", "mCoverAnimationTracker", "Landroid/view/animation/Animation$AnimationListener;", "mCoverDismiss", "mDataIsReady", "mDecelerateInterpolator", "Landroid/view/animation/DecelerateInterpolator;", "mDeleteDialog", "Lcom/obric/oui/dialog/v2/alert/OAlertDialog;", "mDuration", "mEmptyResultDialog", "mEmptyView", "mExpandGroups", "mExpandableListItemLongClickedListener", "Lcom/android/contacts/list/HorizontalScrollExpandableListView$ItemLongClickedListener;", "mForceTouchController", "Lcom/android/contacts/forcetouch/ForceTouchController;", "mFragmentsCallback", "Lcom/android/contacts/ContactFragmentsCallback;", "mFrequentContacts", "mGroupBrowseListFragment", "Lcom/android/contacts/group/GroupBrowseListFragment;", "mGroupBrowseStub", "mGroupCollapseListener", "Landroid/widget/ExpandableListView$OnGroupCollapseListener;", "mGroupExpandListener", "Landroid/widget/ExpandableListView$OnGroupExpandListener;", "mGroupFlipperView", "mGroupSelectAllBtn", "mHandler", "Landroid/os/Handler;", "getMHandler", "()Landroid/os/Handler;", "setMHandler", "(Landroid/os/Handler;)V", "mHasOccupied", "mHasQuickBar", "mHasResult", "mIccStateListener", "Lcom/android/contacts/DSUtils$IccStateListener;", "mImportSimId", "mInAppSearchResultList", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntity;", "mInAppSearchThread", "Lcom/android/contacts/list/NewContactListFragment$SearchThread;", "mInContacts", "mIntentsSearch", "mIntentsSearchResultList", "mIsClickBtnAddContact", "mIsDeletingContacts", "mIsEdit", "mIsHasPhoneNum", "mIsListScrollFpsSampling", "mIsNavigationShown", "mIsPreloading", "mItemLongClickedListener", "Lcom/android/contacts/list/HorizontalScrollListView$ItemLongClickedListener;", "mKeepDisplayedSearchNumber", "mKeepSearchState", "mLastRenderedSearchKey", "mLastStartTime", "mLazyLoadFirstStart", "mLetter", "mLetterProfileBitmaps", "Landroid/graphics/Bitmap;", "[[Landroid/graphics/Bitmap;", "mLetterProfileNewBitmaps", "mLetterProfileSelectedBitmaps", "[Landroid/graphics/Bitmap;", "mLetterProfileSelectedNewBitmaps", "mLocationManager", "Landroid/location/LocationManager;", "mLocationRegistered", "mMayDeletedPosition", "mModeState", "getMModeState", "()I", "setMModeState", "(I)V", "mNavigationBarHeight", "mNeedRefreshAfterVisible", "mNoContactsSelected", "mNorAdapter", "Lcom/android/contacts/list/ContactsListSortByNameAdapter;", "mOGroupTitleBar", "Lcom/obric/oui/titlebar/OCTitleBar;", "mOSearchRightButton", "Lcom/obric/oui/button/OIconButtonFloating;", "mOSearchbar", "Lcom/obric/oui/searchbar/v2/OSearchBar;", "mOccupiedDialog", "mOldContactAddedTimeItems", "mOldContactCityItems", "mOldContactTimesItems", "mOldContacts", "mOldContactsBCRItems", "mOldContactsCompanyItems", "mOldContactsPhoneItems", "mOldContactsSim1Items", "mOldContactsSim2Items", "mOutSize", "Landroid/graphics/Point;", "mPhoneContactsAdapter", "mPhoneContactsIdList", "mPhotoManager", "Lcom/android/contacts/ContactPhotoManager;", "mPool", "Ljava/util/concurrent/ExecutorService;", "mPopover", "Lcom/obric/oui/popover/v2/OPopover;", "mPrefsCallback", "Lcom/android/contacts/PreferencesCallback;", "mPresenter", "Lcom/android/contacts/list/IContactSearchBarPresenter;", "mProviderIsNormal", "mProviderSearchThread", "mQBListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$QBListener;", "mQuickBar", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar;", "mQuickBarState", "mRefreshProfileRunnable", "Ljava/lang/Runnable;", "mResetContactListView", "mScrollIdle", "mSearchAnimationGeneration", "mSearchContainer", "mSearchController", "mSearchFiledBarContainer", "mSearchKey", "mSearchKeyList", "mSearchOptionBar", "mSearchResultAdapter", "Lcom/android/contacts/list/SearchResultAdapter;", "mSearchResultDialog", "mSearchResultList", "Lcom/android/contacts/bytedanceosquickcontact/QuickContactListView;", "mSearchResultView", "mSearchSwitchANimHelper", "Lcom/android/contacts/search/anim/SearchSwitchAnimHelper;", "mSelectedGroupUri", "Landroid/net/Uri;", "mSelectedSet", "Lcom/android/contacts/list/NewContactListFragment$SelectionSet;", "mShowResultThread", "Lcom/android/contacts/list/NewContactListFragment$ShowResultThread;", "mSidebarDragHelper", "Lcom/android/contacts/util/SidebarDragHelper;", "mSlideListener", "Lcom/android/contacts/list/SlideListView$Listener;", "mSlideListenerForExpandable", "Lcom/android/contacts/list/ExpandListView$SlideListener;", "mSortMode", "mStartRecord", "mStartedRecongnize", "mStartedRecongnizeTime", "mSurnameListener", "Lcom/obric/oui/indexscrollbar/OIndexScrollbar$SurnameListener;", "mTimeoutThread", "mTitleBarHolder", "Lcom/obric/ui/OFloatingTitleBarHolder;", "mTouchMonitorListener", "Lcom/android/contacts/list/SlideListView$TouchMonitorListener;", "mTouchMonitorListenerForExpandable", "Lcom/android/contacts/list/ExpandListView$TouchMonitorListener;", "mVibrator", "Landroid/os/Vibrator;", "mVisible", "mVoiceAssistantServiceConnection", "Lcom/android/contacts/list/NewContactListFragment$VoiceServiceConnection;", "mVoiceBtnCallBack", "Lcom/android/contacts/list/ContactsListBaseAdapter$VoiceBtnCallBack;", "mVoiceInterface", "Lbytedanceos/app/voiceassistant/IVoiceAssistantService;", "getMVoiceInterface", "()Lbytedanceos/app/voiceassistant/IVoiceAssistantService;", "setMVoiceInterface", "(Lbytedanceos/app/voiceassistant/IVoiceAssistantService;)V", "mVoiceSearchConnected", "mVoiceUiRunnable", "mWaitingScrollIdle", "mWave", "mlistener", "Landroid/location/LocationListener;", "phoneContacts", "getPhoneContacts", "photoManager", "getPhotoManager", "()Lcom/android/contacts/ContactPhotoManager;", "presenter", "getPresenter", "()Lcom/android/contacts/list/IContactSearchBarPresenter;", "primaryHint", "Landroid/widget/TextView;", "scrollFpsMonitor", "Lcom/obric/matrix/platform/sdk/ones/commonmonitor/fps/FPSSceneMonitor;", "secondaryHint", "targetListView", "Landroid/widget/ListView;", "getTargetListView", "()Landroid/widget/ListView;", "voiceSearchContainer", "appendAccountsFilterQueryParameter", "uri", "backToTopState", "binderDied", "", "cancelSearch", "cancelSearchWithoutAnimation", "checkPermission", "sortMode", "clearModeState", "closeSwipedViewsForList", "listView", "contactsSelectAll", "isChecked", "createCloseSwipeTouchListener", "Landroid/view/View$OnTouchListener;", "controller", "dataIsReady", "mode", "deleteContacts", "isContactsEmpty", "dismissCloseVoiceDialog", "dismissCover", "dismissWave", "doImportContactsAction", "flag", "doImportInEmpty", "context", "resId", ImportSimContacts.EXTRA_ACCOUNT, "Lcom/android/contacts/model/AccountWithDataSet;", "doRemoveAction", "endContactAnimationIView", "enterSearch", "exitSearch", "expandSearchResultViewForSearchTranslation", "findContactsCommonListItem", "Lcom/obric/utils/views/commonitemview/ContactsCommonListItem;", "view", "getAll", "contactsList", "lastContactsList", "getBetterLocation", "newLocation", "currentBestLocation", "getContactUri", "samContact", "getLastInsertContact", "getListDataBySortMode", "isChanged", "getOrCreateSearchAnimHelper", "getPinYinCityName", "cityName", "getProfileNumber", "getRealAdapter", "Landroid/widget/ListAdapter;", "getSearchBar", "getSearchMergeList", "obj", "getSearchRightButton", "getSimContacts", DSUtils.SUBSCRIPTION_KEY, "getTitleBtn", "resource", "isLeft", "titleBar", "obtn", GroupEditorActivity.ACTION_SAVE_COMPLETED, "handleActionMove", "motionEvent", "Landroid/view/MotionEvent;", "handleContactEvent", "parent", "Landroid/widget/AdapterView;", BaseHttpRequestInfo.KEY_EXCEPTION, "ey", "contact", "hideCityListView", "hideQuickContact", "hideQuickContactViewIView", "hideSoftKeyboard", "hideVoiceSearchBtn", "hideWaitTipView", "importContactsInEmpty", "inflateAndSetupView", "inflater", "Landroid/view/LayoutInflater;", "container", "savedInstanceState", "Landroid/os/Bundle;", "layoutResourceId", "inflateVoiceButton", "init", "initAnimation", "initCityListView", "initCloseVoiceDialog", "initCompanyExpandableData", "initData", "initGroupView", "initLetter", "initSearchViews", "initStart", "isGroupAllSelected", "groupIndex", "adapter", "Lcom/android/contacts/list/ExpandAdapter;", "isNumberMatchSearchKey", "number", "isOutSideVoiceButton", "isSameProvider", "provider1", "provider2", "isTouchOnNonDataArea", "event", "keepDisplayedSearchNumbers", "loadContactsFromFile", "fileName", "list", "loadContactsSortByName", "notPerformAnimationForEdit", "isEdit", "notifyDataSetChangedBySortMode", ContractKt.PARAM_ACTION_DOMAIN_CONTACTS, "softMode", "onAccountChosen", "extraArgs", "onAccountSelectorCancelled", "onActivityResult", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onAddGroupClicked", "onAddNewContactClicked", "onAnimationEnd", "delete", "ids", "", "onAttach", "onAvatarTextFontChanged", "onBackPressed", "onCancelEditContactClicked", "onCancelEditGroupClicked", "onClick", "onClickDelete", "onContactListFilterChanged", "onCreate", "onCreateView", "onDBDataChanged", "onDeleteContactClicked", "onDeleteGroupClicked", "onDestroy", "onDestroyView", "onEditContactClicked", "onEditGroupClicked", "onEnterSearchAnimEnd", "success", "onEnterSearchAnimFailed", "onFocusChange", "arg0", "arg1", "onItemClick", "position", "id", "onModeChangeIView", "onModeChanged", "onModeWillChangeIView", "onPause", "onPopupDismissIView", "onPreferencesChanged", "onQueryTextChangeIView", "newString", "clearData", "onRequestPermissionsResult", "permissions", "grantResults", "", "(I[Ljava/lang/String;[I)V", "onResume", "onSaveInstanceState", "outState", "onScroll", "Landroid/widget/AbsListView;", "arg2", "arg3", "onScrollStateChanged", "onSearchAnimationStartIView", "onSettingsTitleClick", "onStart", "onStop", "onTabAllClicked", "onTabGroupClicked", "onVisibilityChanged", "visible", "performAnimationForEdit", "preloadContactsData", "processEditContacts", "performAnimation", "processGroupExpandableState", "Landroid/widget/ExpandableListAdapter;", "processSelectOnItemClicked", "child", "recoverQuickBarIView", "recoveryFromGroupEdit", "refreshAdapter", "refreshBcrCount", "refreshOptionBar", "count", "refreshProfileDetailCache", "refreshVisibleListItems", "registerBcrDataObserver", "registerObserver", "release", "removeItemFromList", "delUri", "removeItemFromSearchList", "requestUpdatesFromProvider", "provider", "resetRecognizeByTooShortTime", "resetSearchBar", "saveContactsToFile", "orgList", "includeLastAdded", "searchAnimationEnd", "sendWaitTipMessage", "setAccountFilterQuerySelection", "setBottomDeleteLayoutListener", "listener", "setButtonVisibility", "show", "setContactListFilterController", "filterController", "setContactsListFooter", "excludeCount", "setContactsStatistics", "statisticMap", "setEmptyView", "setEnable", "triggerload", "setFragmentsCallback", "callback", "setGroupEditState", "toEdit", "setKeepSearchState", "keepSearchState", "setModeState", "complete", "setObserverToWork", "needWork", "setPrefsCallback", "setProfileData", "setSoftKeyboardHideIView", "showDeleteContactsDialog", "showImportContactsInEmptyDialog", "showSimSelectDialog", "showVoiceSearchBtn", "showVoiceSearchBtnDelayed", DBHelper.COL_TIME, "showWaitTipView", "startActivityAndForwardResult", MemorySourceLinkType.INTENT, "startContactAnimationIView", "startCreateNewContactActivity", "startDetailActivity", "lookupUri", "specialNumbers", "isCached", "isProfile", "startListScrollFpsSampling", "startProfileDetail", "delayTime", "stopListScrollFpsSampling", "stopRecord", "immediete", "stopSearch", "triggerLoad", "cityChanged", "unregisterBcrDataObserver", "unregisterObserver", "updateBtnGroupRightDeleteStatus", "isVisible", "updateListViewConfig", "AddedTimeSortComparator", "BlacklistChangeListener", "CityNameSortComparator", "Companion", "CompanySortComparator", "ContactQuery", "ContactedTimesSortComparator", "ContactsContent", "ContactsWithCompany", "DeleteContactsTask", "ExpandableSortComparator", "Listener", "LocationToken", "NumberAdapter", "OnGroupActionListener", "PhoneQuery", "SearchResultPayload", "SearchThread", "SelectionSet", "ShowResultThread", "VoiceServiceConnection", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NewContactListFragment extends AbstractFragment implements AdapterView.OnItemClickListener, View.OnClickListener, View.OnFocusChangeListener, IContactSearchBarView, DialtactsActivity.ViewPagerVisibilityListener, AbsListView.OnScrollListener, SelectAccountDialogFragment.Listener, DialtactsActivity.PageEnableListener, DialtactsActivity.ReleaseResourceListener, DialtactsActivity.onBackPressListener, IBinder.DeathRecipient, AvatarImageHelper.OnAvatarTextFontChangeListener, ContactListFilterController.ContactListFilterListener, DialtactsActivity.OnDBDataChangeListener {
    private static final String ACCOUNTS_FILTERS_PARAM = "account_filters";
    public static final int ACCOUNT_NAME = 16;
    public static final int ACCOUNT_TYPE = 15;
    public static final String AUTONOMOUS_REGION = "自治区";
    private static final String CACHE_FILE_NAME = "contactslist.par";
    private static final byte CACHE_VERSION = 2;
    private static final Uri CALLLOG_COUNT_URI = null;
    private static final boolean CHECKED_CORRECT_INFO = false;
    private static final int CHECK_CUR_LOCATION_REFRESHED = 1007;
    public static final char CITY = 24066;
    public static final int CONTACTDELETED = 3;
    public static final int CONTACTSAVED = 1;
    private static final Uri CONTACTS_STATISTICS = null;
    private static final Uri CONTACTS_WITH_COMPANY_URI = null;
    public static final int CONTACTUPDATA = 2;
    private static final String CONTACT_CITY_QUERY = null;
    private static final String CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY = null;
    private static final String[] CONTACT_FREQUENCE_PROJECTION = null;
    private static final String CONTACT_FREQUENCE_SELECTION = "lookup_uri not null";
    private static final String CONTACT_QUERY = null;
    private static final String CONTACT_SEARCH_SORT = null;
    private static final String CONTACT_SORT = null;
    public static final Companion Companion = null;
    private static final int DEFAULT_IMPORT_SHEET_SELECT = 0;
    private static final String EXTRA_KEY_GROUP_URI = "groups.groupUri";
    private static final int H24r = 0;
    public static final String HUIZU_AUTONOMOUS_REGION = "回族自治区";
    private static final String KEY_RES_ID = "resourceId";
    private static final int LETTER_NEW_SYMBOL = 2;
    private static final int LETTER_NORMAL = 0;
    private static final int LETTER_PROFILE = 1;
    private static final int LETTER_PROFILE_NEW = 2;
    private static final int LETTER_PROFILE_SYMBOL = 1;
    private static final int MAX_LAST_INSERT_COUNT = 3;
    private static final int MSG_TRIGGER_LOAD = 1008;
    private static final String MULTI_ACCOUNTS_FLAG = "multi_accouts_flag";
    private static final int NOTIFY_DATA_SET_CHANGE_BY_SORT_MODE = 1001;
    private static final int NOTIFY_LONG_WAIT_TIP = 1003;
    private static final int NOTIFY_REFRESH_BCR_COUNT = 1006;
    private static final int NOTIFY_SET_SEARCH_RESULT = 1004;
    private static final String NO_ACCOUNTS_SELECTION = null;
    public static final int PHONE_CONTACT_ID = 1;
    public static final int PHONE_DISPLAY_NAME = 8;
    public static final int PHONE_ID = 12;
    private static final String PHONE_ID_SELECTION = null;
    private static final String[] PHONE_ID_SELECTION_ARGS = null;
    public static final int PHONE_IS_SUPER_PRIMARY = 2;
    public static final int PHONE_LABEL = 4;
    public static final int PHONE_LOCATION_NAME = 13;
    public static final int PHONE_LOCATION_NAME_PINYIN = 14;
    public static final int PHONE_LOOKUP_KEY = 9;
    public static final int PHONE_NORMALIZED_NUMBER = 6;
    public static final int PHONE_NUMBER = 0;
    public static final int PHONE_PHONEBOOK_LABEL = 11;
    public static final int PHONE_PHOTO_ID = 10;
    public static final int PHONE_RAW_CONTACT_ID = 7;
    public static final int PHONE_SORT_KEY_PRIMARY = 5;
    public static final int PHONE_TYPE = 3;
    private static final Uri PROFILE_QUERY_URI = null;
    public static final char PROVINCE = 30465;
    private static final int REFRESH_VISIBLE_LIST_ITEMS = 1005;
    private static final int REQUEST_DELETE_CONTACT = 21;
    private static final int REQUEST_GET_BCR_CONTACTS = 22;
    private static final int SHOW_BUTTON_EDIT_MODE = 2;
    private static final int SHOW_BUTTON_NORMAL_MODE = 1;
    private static final String TAG = "NewContactListFragment";
    private static final int TEN_METERS = 10;
    private static final int TEN_SECONDS = 10000;
    private static final int TOUCH_STATE_NUMS = 5;
    private static final int TWO_MINUTES = 0;
    private static final int WAVE_COVER_DELAY_MILLIS = 150;
    public static final String WEIWUER_AUTONOMOUS_REGION = "维吾尔自治区";
    public static final String ZHUANGZU_AUTONOMOUS_REGION = "壮族自治区";
    private static final LongMenuHelper.MenuType[] sLongMenuItems = null;
    private static NewContactListFragment sPerLoadMe;
    private static boolean sVoiceEnabled;
    private final boolean DEBUG;
    private final int TIME_NEED_TO_TIP;
    private final NewContactListFragment$contactListViewClickListener$1 contactListViewClickListener;
    private final NewContactListFragment$contactSearchListViewClickListener$1 contactSearchListViewClickListener;
    private final Map<Long, SamContact> curContactsMap;
    private String importFlag;
    private boolean isEnableSelectContacts;
    private boolean isSearch;
    private boolean isSearchAnimationing;
    private boolean isShowGroup;
    private String mAccountsFilterQueryParameter;
    private FragmentActivity mActivity;
    private boolean mAllContactsSelected;
    private AsyncImageLoader mAsyncImageLoader;
    private ContentObserver mBcrDataObserver;
    private BlacklistChangeListener mBlacklistChangeListener;
    private boolean mBlacklistHasChanged;
    private BlacklistManager mBlacklistManager;
    private BottomDeleteLayoutListener mBottomDeleteLayoutListener;
    private OButton mBtnGroupLeft;
    private OButton mBtnGroupMenu;
    private OButton mBtnGroupRightDelete;
    private OButton mBtnImportContacts;
    private OButton mBtnOpenCamera;
    private ImageButton mBtnVoiceSearchContacts;
    private final IVoiceAssistantCallback mCallback;
    private volatile boolean mCancelRecognizeByTooShortTime;
    private boolean mCityChanged;
    private QuickContactExpandableListView mCityListView;
    private FrameLayout mCityListViewFrame;
    private final HashMap<String, String> mCityPinYinMap;
    private AlertDialog mCloseVoiceDialog;
    private boolean mCollapseAllGroup;
    private RelativeLayout mContactBody;
    private ContactListFilterController mContactListFilterController;
    private HeadersListView mContactListView;
    private SelectAllState mContactSelectAllBtn;
    private ContactsContent mContactsContent;
    private RelativeLayout mContactsEmptyView;
    private ViewStub mContactsEmptyViewStub;
    private View mContactsFragment;
    private ViewGroup mContactsFrameView;
    private HashSet<Long> mContactsIdBCR;
    private HashSet<Long> mContactsIdForLocation;
    private HashSet<Long> mContactsIdList;
    private HashSet<Long> mContactsIdSIM1;
    private HashSet<Long> mContactsIdSIM2;
    private final ListAnimator mContactsListAnimator;
    private OPageStatus mContactsListEmptyView;
    private final ContactsSelectionListener mContactsSelectionListener;
    private RelativeLayout mContactsTipEmptyView;
    private ViewStub mContactsTipEmptyViewStub;
    private Context mContext;
    private View mCover;
    private final Animation.AnimationListener mCoverAnimationTracker;
    private boolean mCoverDismiss;
    private boolean mDataIsReady;
    private final DecelerateInterpolator mDecelerateInterpolator;
    private OAlertDialog mDeleteDialog;
    private final long mDuration;
    private ViewGroup mEmptyResultDialog;
    private OPageStatus mEmptyView;
    private final HashMap<Long, Integer> mExpandGroups;
    private final HorizontalScrollExpandableListView.ItemLongClickedListener mExpandableListItemLongClickedListener;
    private ForceTouchController mForceTouchController;
    private ContactFragmentsCallback mFragmentsCallback;
    private boolean mFrequentContacts;
    private GroupBrowseListFragment mGroupBrowseListFragment;
    private ViewStub mGroupBrowseStub;
    private final ExpandableListView.OnGroupCollapseListener mGroupCollapseListener;
    private final ExpandableListView.OnGroupExpandListener mGroupExpandListener;
    private View mGroupFlipperView;
    private SelectAllState mGroupSelectAllBtn;
    private Handler mHandler;
    private boolean mHasOccupied;
    private boolean mHasQuickBar;
    private boolean mHasResult;
    private final DSUtils.IccStateListener mIccStateListener;
    private int mImportSimId;
    private List<InAppSearchEntity> mInAppSearchResultList;
    private SearchThread mInAppSearchThread;
    private boolean mInContacts;
    private final boolean mIntentsSearch;
    private final List<InAppSearchEntity> mIntentsSearchResultList;
    private boolean mIsClickBtnAddContact;
    private boolean mIsDeletingContacts;
    private boolean mIsEdit;
    private boolean mIsHasPhoneNum;
    private boolean mIsListScrollFpsSampling;
    private boolean mIsNavigationShown;
    private boolean mIsPreloading;
    private final HorizontalScrollListView.ItemLongClickedListener mItemLongClickedListener;
    private boolean mKeepDisplayedSearchNumber;
    private boolean mKeepSearchState;
    private String mLastRenderedSearchKey;
    private long mLastStartTime;
    private boolean mLazyLoadFirstStart;
    private String mLetter;
    private Bitmap[][] mLetterProfileBitmaps;
    private Bitmap[][] mLetterProfileNewBitmaps;
    private Bitmap[] mLetterProfileSelectedBitmaps;
    private Bitmap[] mLetterProfileSelectedNewBitmaps;
    private LocationManager mLocationManager;
    private final boolean mLocationRegistered;
    private int mMayDeletedPosition;
    private int mModeState;
    private int mNavigationBarHeight;
    private boolean mNeedRefreshAfterVisible;
    private boolean mNoContactsSelected;
    private ContactsListSortByNameAdapter mNorAdapter;
    private OCTitleBar mOGroupTitleBar;
    private OIconButtonFloating mOSearchRightButton;
    private OSearchBar mOSearchbar;
    private AlertDialog mOccupiedDialog;
    private ArrayList<SamContact> mOldContactAddedTimeItems;
    private ArrayList<SamContact> mOldContactCityItems;
    private ArrayList<SamContact> mOldContactTimesItems;
    private ArrayList<SamContact> mOldContacts;
    private ArrayList<SamContact> mOldContactsBCRItems;
    private ArrayList<SamContact> mOldContactsCompanyItems;
    private ArrayList<SamContact> mOldContactsPhoneItems;
    private ArrayList<SamContact> mOldContactsSim1Items;
    private ArrayList<SamContact> mOldContactsSim2Items;
    private final Point mOutSize;
    private ContactsListSortByNameAdapter mPhoneContactsAdapter;
    private HashSet<Long> mPhoneContactsIdList;
    private ContactPhotoManager mPhotoManager;
    private final ExecutorService mPool;
    private OPopover mPopover;
    private PreferencesCallback mPrefsCallback;
    private IContactSearchBarPresenter mPresenter;
    private boolean mProviderIsNormal;
    private SearchThread mProviderSearchThread;
    private final OIndexScrollbar.QBListener mQBListener;
    private OIndexScrollbar mQuickBar;
    private int mQuickBarState;
    private final Runnable mRefreshProfileRunnable;
    private boolean mResetContactListView;
    private final Runnable mScrollIdle;
    private long mSearchAnimationGeneration;
    private ViewGroup mSearchContainer;
    private ForceTouchController mSearchController;
    private FrameLayout mSearchFiledBarContainer;
    private String mSearchKey;
    private Map<Long, List<String>> mSearchKeyList;
    private ViewGroup mSearchOptionBar;
    private SearchResultAdapter mSearchResultAdapter;
    private ViewGroup mSearchResultDialog;
    private QuickContactListView mSearchResultList;
    private RelativeLayout mSearchResultView;
    private SearchSwitchAnimHelper mSearchSwitchANimHelper;
    private Uri mSelectedGroupUri;
    private final SelectionSet<Long> mSelectedSet;
    private ShowResultThread mShowResultThread;
    private SidebarDragHelper mSidebarDragHelper;
    private final SlideListView.Listener mSlideListener;
    private final ExpandListView.SlideListener mSlideListenerForExpandable;
    private int mSortMode;
    private final Runnable mStartRecord;
    private boolean mStartedRecongnize;
    private long mStartedRecongnizeTime;
    private final OIndexScrollbar.SurnameListener mSurnameListener;
    private final Runnable mTimeoutThread;
    private OFloatingTitleBarHolder mTitleBarHolder;
    private final SlideListView.TouchMonitorListener mTouchMonitorListener;
    private final ExpandListView.TouchMonitorListener mTouchMonitorListenerForExpandable;
    private Vibrator mVibrator;
    private boolean mVisible;
    private final VoiceServiceConnection mVoiceAssistantServiceConnection;
    private final ContactsListBaseAdapter.VoiceBtnCallBack mVoiceBtnCallBack;
    private IVoiceAssistantService mVoiceInterface;
    private boolean mVoiceSearchConnected;
    private final Runnable mVoiceUiRunnable;
    private boolean mWaitingScrollIdle;
    private View mWave;
    private final LocationListener mlistener;
    private TextView primaryHint;
    private final FPSSceneMonitor scrollFpsMonitor;
    private TextView secondaryHint;
    private RelativeLayout voiceSearchContainer;

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$AddedTimeSortComparator;", "Ljava/util/Comparator;", "Lcom/android/contacts/list/SamContact;", "Lkotlin/Comparator;", "(Lcom/android/contacts/list/NewContactListFragment;)V", "mNameSortComparator", "Lcom/android/contacts/util/NameSortComparator;", "getMNameSortComparator", "()Lcom/android/contacts/util/NameSortComparator;", "setMNameSortComparator", "(Lcom/android/contacts/util/NameSortComparator;)V", "compare", "", "lhs", "rhs", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class AddedTimeSortComparator implements Comparator<SamContact> {
        private NameSortComparator mNameSortComparator;
        final /* synthetic */ NewContactListFragment this$0;

        public AddedTimeSortComparator(NewContactListFragment r1) {
            this.this$0 = r1;
            this.mNameSortComparator = new NameSortComparator();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare2(r1, r2);
        }

        public final NameSortComparator getMNameSortComparator() {
            return this.mNameSortComparator;
        }

        public final void setMNameSortComparator(NameSortComparator r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mNameSortComparator = r2;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(SamContact r3, SamContact r4) {
            Intrinsics.checkNotNullParameter(r3, "lhs");
            Intrinsics.checkNotNullParameter(r4, "rhs");
            if (TextUtils.isEmpty(r4.addedTime) == false) goto L8;
            if (TextUtils.isEmpty(r3.addedTime) == true) goto L8;
            return -1;
        L8:
            if (TextUtils.isEmpty(r4.addedTime) == true) goto L13;
            if (TextUtils.isEmpty(r3.addedTime) == false) goto L13;
            return 1;
        L13:
            if (TextUtils.isEmpty(r4.addedTime) == true) goto L15;
        L17:
            String r2 = r4.addedTime;
            Intrinsics.checkNotNullExpressionValue(r2, "rhs.addedTime");
            String r5 = r3.addedTime;
            Intrinsics.checkNotNullExpressionValue(r5, "lhs.addedTime");
            return StringsKt.compareTo(r2, r5, true);
        L15:
            if (TextUtils.isEmpty(r3.addedTime) == false) goto L17;
            return this.mNameSortComparator.compare2(r3, r4);
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016¨\u0006\u0005"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$BlacklistChangeListener;", "Lcom/android/contacts/BlacklistManager$OnBlacklistChangeListener;", "(Lcom/android/contacts/list/NewContactListFragment;)V", "onBlacklistChanged", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class BlacklistChangeListener implements BlacklistManager.OnBlacklistChangeListener {
        final /* synthetic */ NewContactListFragment this$0;

        public BlacklistChangeListener(NewContactListFragment r1) {
            this.this$0 = r1;
        }

        @Override // com.android.contacts.BlacklistManager.OnBlacklistChangeListener
        public void onBlacklistChanged() {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "onBlacklistChanged");
            NewContactListFragment.access$setMBlacklistHasChanged$p(this.this$0, true);
            ContactsListSortByNameAdapter r0 = NewContactListFragment.access$getMNorAdapter$p(this.this$0);
            if (r0 != null) goto L6;
            return;
        L6:
            if (NewContactListFragment.access$getMContactListView$p(this.this$0) != null) goto L8;
            return;
        L8:
            r0.notifyDataSetChanged();
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0004\u0018\u00002\u00060\u0001R\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0018\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\rH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$CityNameSortComparator;", "Lcom/android/contacts/list/NewContactListFragment$ExpandableSortComparator;", "Lcom/android/contacts/list/NewContactListFragment;", "(Lcom/android/contacts/list/NewContactListFragment;)V", "mUnknownLocation", "", "getMUnknownLocation", "()Ljava/lang/String;", "setMUnknownLocation", "(Ljava/lang/String;)V", "compare", "", "lhs", "Lcom/android/contacts/list/SamContact;", "rhs", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class CityNameSortComparator extends ExpandableSortComparator {
        private String mUnknownLocation;
        final /* synthetic */ NewContactListFragment this$0;

        public CityNameSortComparator(NewContactListFragment r2) {
            this.this$0 = r2;
            super(r2);
            String r3 = ContactsUtils.getUnknownLocationLabel();
            Intrinsics.checkNotNullExpressionValue(r3, "getUnknownLocationLabel()");
            this.mUnknownLocation = r3;
        }

        @Override // com.android.contacts.list.NewContactListFragment.ExpandableSortComparator, java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare(r1, r2);
        }

        public final String getMUnknownLocation() {
            return this.mUnknownLocation;
        }

        public final void setMUnknownLocation(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mUnknownLocation = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.android.contacts.list.NewContactListFragment.ExpandableSortComparator
        public int compare(SamContact r5, SamContact r6) {
            Intrinsics.checkNotNullParameter(r5, "lhs");
            Intrinsics.checkNotNullParameter(r6, "rhs");
            int r1 = 1;
            if (TextUtils.isEmpty(r5.headerData) == false) goto L5;
        L9:
            int r0 = 1;
        L11:
            if (TextUtils.isEmpty(r6.headerData) == false) goto L13;
        L17:
            int r2 = r0 - r1;
            if (r2 != 0) goto L20;
            r2 = (Intrinsics.areEqual(this.mUnknownLocation, r5.headerData) ? 1 : 0) - (Intrinsics.areEqual(this.mUnknownLocation, r6.headerData) ? 1 : 0);
        L20:
            if (r2 == 0) goto L22;
            return r2;
        L22:
            return super.compare(r5, r6);
        L13:
            if (r6.headerData.length() <= 0) goto L17;
            if (T9SearchLocaleUtils.isChinese(r6.headerData.charAt(0)) == false) goto L17;
            r1 = 0;
            goto L17
        L5:
            if (r5.headerData.length() <= 0) goto L9;
            if (T9SearchLocaleUtils.isChinese(r5.headerData.charAt(0)) == false) goto L9;
            r0 = 0;
            goto L11
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0005\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\b\b\n\u0002\u0010\u0011\n\u0002\b8\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010S\u001a\u00020`2\u0006\u0010a\u001a\u00020bH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u0010\u001d\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u0016\u00107\u001a\b\u0012\u0004\u0012\u00020\u00040\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001cR\u000e\u00108\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010<\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010=\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010>\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010A\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010B\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010C\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010D\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010E\u001a\u00020\u0012X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010Q\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010R\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010S\u001a\u0004\u0018\u00010T8F¢\u0006\u0006\u001a\u0004\bU\u0010VR\u0018\u0010W\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010X0\u001bX\u0082\u0004¢\u0006\u0004\n\u0002\u0010YR\u0010\u0010Z\u001a\u0004\u0018\u00010TX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010[\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010]\"\u0004\b^\u0010_¨\u0006c"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$Companion;", "", "()V", "ACCOUNTS_FILTERS_PARAM", "", "ACCOUNT_NAME", "", "ACCOUNT_TYPE", "AUTONOMOUS_REGION", "CACHE_FILE_NAME", "CACHE_VERSION", "", "CALLLOG_COUNT_URI", "Landroid/net/Uri;", "CHECKED_CORRECT_INFO", "", "CHECK_CUR_LOCATION_REFRESHED", "CITY", "", "CONTACTDELETED", "CONTACTSAVED", "CONTACTS_STATISTICS", "CONTACTS_WITH_COMPANY_URI", "CONTACTUPDATA", "CONTACT_CITY_QUERY", "CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY", "CONTACT_FREQUENCE_PROJECTION", "", "[Ljava/lang/String;", "CONTACT_FREQUENCE_SELECTION", "CONTACT_QUERY", "CONTACT_SEARCH_SORT", "CONTACT_SORT", "DEFAULT_IMPORT_SHEET_SELECT", "EXTRA_KEY_GROUP_URI", "H24r", "HUIZU_AUTONOMOUS_REGION", "KEY_RES_ID", "LETTER_NEW_SYMBOL", "LETTER_NORMAL", "LETTER_PROFILE", "LETTER_PROFILE_NEW", "LETTER_PROFILE_SYMBOL", "MAX_LAST_INSERT_COUNT", "MSG_TRIGGER_LOAD", "MULTI_ACCOUNTS_FLAG", "NOTIFY_DATA_SET_CHANGE_BY_SORT_MODE", "NOTIFY_LONG_WAIT_TIP", "NOTIFY_REFRESH_BCR_COUNT", "NOTIFY_SET_SEARCH_RESULT", "NO_ACCOUNTS_SELECTION", "PHONE_CONTACT_ID", "PHONE_DISPLAY_NAME", "PHONE_ID", "PHONE_ID_SELECTION", "PHONE_ID_SELECTION_ARGS", "PHONE_IS_SUPER_PRIMARY", "PHONE_LABEL", "PHONE_LOCATION_NAME", "PHONE_LOCATION_NAME_PINYIN", "PHONE_LOOKUP_KEY", "PHONE_NORMALIZED_NUMBER", "PHONE_NUMBER", "PHONE_PHONEBOOK_LABEL", "PHONE_PHOTO_ID", "PHONE_RAW_CONTACT_ID", "PHONE_SORT_KEY_PRIMARY", "PHONE_TYPE", "PROFILE_QUERY_URI", "PROVINCE", "REFRESH_VISIBLE_LIST_ITEMS", "REQUEST_DELETE_CONTACT", "REQUEST_GET_BCR_CONTACTS", "SHOW_BUTTON_EDIT_MODE", "SHOW_BUTTON_NORMAL_MODE", "TAG", "TEN_METERS", "TEN_SECONDS", "TOUCH_STATE_NUMS", "TWO_MINUTES", "WAVE_COVER_DELAY_MILLIS", "WEIWUER_AUTONOMOUS_REGION", "ZHUANGZU_AUTONOMOUS_REGION", "preload", "Lcom/android/contacts/list/NewContactListFragment;", "getPreload", "()Lcom/android/contacts/list/NewContactListFragment;", "sLongMenuItems", "Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "[Lcom/obricOld/contacts/menus/LongMenuHelper$MenuType;", "sPerLoadMe", "sVoiceEnabled", "getSVoiceEnabled", "()Z", "setSVoiceEnabled", "(Z)V", "", "context", "Landroid/content/Context;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker r1) {
            this();
        }

        private Companion() {
        }

        public final boolean getSVoiceEnabled() {
            return NewContactListFragment.access$getSVoiceEnabled$cp();
        }

        public final void setSVoiceEnabled(boolean r1) {
            NewContactListFragment.access$setSVoiceEnabled$cp(r1);
        }

        @JvmStatic
        public final synchronized void preload(Context r2) {
            monitor-enter(this);
            Intrinsics.checkNotNullParameter(r2, "context");     // Catch: Throwable -> L11
            NewContactListFragment.access$setSPerLoadMe$cp(new NewContactListFragment());     // Catch: Throwable -> L11
            NewContactListFragment r0 = NewContactListFragment.access$getSPerLoadMe$cp();     // Catch: Throwable -> L11
            if (r0 == null) goto L6;
            r0.setContactListFilterController(ContactListFilterController.getInstance(r2));     // Catch: Throwable -> L11
        L6:
            NewContactListFragment r3 = NewContactListFragment.access$getSPerLoadMe$cp();     // Catch: Throwable -> L11
            if (r3 == null) goto L9;
            NewContactListFragment.access$preloadContactsData(r3);     // Catch: Throwable -> L11
        L9:
            monitor-exit(this);
            return;
        L11:
            th = move-exception;
            throw th;
        }

        public final synchronized NewContactListFragment getPreload() {
            monitor-enter(this);
            NewContactListFragment r0 = NewContactListFragment.access$getSPerLoadMe$cp();     // Catch: Throwable -> L6
            NewContactListFragment.access$setSPerLoadMe$cp(null);     // Catch: Throwable -> L6
            monitor-exit(this);
            return r0;
        L6:
            th = move-exception;
            throw th;
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u001e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u00020\u0001j\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00030\u0002`\u0004B\u0005¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u00020\u00072\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00030\u00022\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00030\u0002H\u0016¨\u0006\n"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$CompanySortComparator;", "Ljava/util/Comparator;", "Ljava/util/ArrayList;", "Lcom/android/contacts/list/SamContact;", "Lkotlin/Comparator;", "()V", "compare", "", "lhs", "rhs", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class CompanySortComparator implements Comparator<ArrayList<SamContact>> {
        public CompanySortComparator() {
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(ArrayList<SamContact> r1, ArrayList<SamContact> r2) {
            return compare2(r1, r2);
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(ArrayList<SamContact> r6, ArrayList<SamContact> r7) {
            Intrinsics.checkNotNullParameter(r6, "lhs");
            Intrinsics.checkNotNullParameter(r7, "rhs");
            SamContact r8 = r6.get(0);
            Intrinsics.checkNotNullExpressionValue(r8, "lhs.get(0)");
            SamContact r9 = r8;
            SamContact r10 = r7.get(0);
            Intrinsics.checkNotNullExpressionValue(r10, "rhs.get(0)");
            SamContact r11 = r10;
            boolean r0 = TextUtils.isEmpty(r9.headerData);
            boolean r1 = TextUtils.isEmpty(r11.headerData);
            if (r0 == true) goto L28;
            if (r1 == true) goto L28;
            String r5 = r9.headerSortSection;
            String r2 = r11.headerSortSection;
            boolean r12 = Intrinsics.areEqual(ContactsUtils.CHAR_POUND, r5);
            boolean r3 = Intrinsics.areEqual(ContactsUtils.CHAR_POUND, r2);
            String r4 = r9.headerSortData;
            String r13 = r11.headerSortData;
            if (r12 == false) goto L20;
            if (r3 == false) goto L20;
            String r14 = r9.headerData;
            String r15 = r11.headerData;
            boolean r16 = ContactsUtils.isPhoneNumber(r14);
            boolean r17 = ContactsUtils.isPhoneNumber(r15);
            if (r16 == false) goto L14;
            if (r17 == false) goto L14;
            Intrinsics.checkNotNullExpressionValue(r15, "rCompany");
            return r14.compareTo(r15);
        L14:
            if (r16 == false) goto L17;
            if (r17 == true) goto L17;
            return 1;
        L17:
            if (r16 == true) goto L26;
            if (r17 == false) goto L26;
            return -1;
        L26:
            Intrinsics.checkNotNullExpressionValue(r4, "lSortData");
            Intrinsics.checkNotNullExpressionValue(r13, "rSortData");
            return StringsKt.compareTo(r4, r13, true);
        L20:
            if (r12 == false) goto L23;
            if (r3 == true) goto L23;
            return 1;
        L23:
            if (r12 == true) goto L26;
            if (r3 == false) goto L26;
            return -1;
        L28:
            if (r0 == false) goto L31;
            if (r1 == true) goto L31;
            return 1;
        L31:
            if (r0 == true) goto L34;
            if (r1 == false) goto L34;
            return -1;
        L34:
            return 0;
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\f\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0019\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0011\u0010\u0012R\u0019\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0015\u0010\u0012R\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0017\u0010\u0012R\u0019\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f¢\u0006\n\n\u0002\u0010\u0013\u001a\u0004\b\u0019\u0010\u0012R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$ContactQuery;", "", "()V", "CONTACT_ACCOUNT_NAME", "", "CONTACT_ACCOUNT_TYPE", "CONTACT_DISPLAY_NAME", "CONTACT_HAS_PHONE_NUMEBER", "CONTACT_ID", "CONTACT_LOOKUP_KEY", "CONTACT_NAME_RAW_CONTACT_ID", "CONTACT_PHONEBOOK_LABEL", "CONTACT_PHOTO_ID", "CONTACT_PHOTO_URI", "CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE", "", "", "getCONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE", "()[Ljava/lang/String;", "[Ljava/lang/String;", "CONTACT_PROJECTION_ALTERNATIVE_PRIMARY", "getCONTACT_PROJECTION_ALTERNATIVE_PRIMARY", "CONTACT_PROJECTION_PRIMARY_ALTERNATIVE", "getCONTACT_PROJECTION_PRIMARY_ALTERNATIVE", "CONTACT_PROJECTION_PRIMARY_PRIMARY", "getCONTACT_PROJECTION_PRIMARY_PRIMARY", "CONTACT_SORT_KEY", "CONTACT_TIME_CONTACTED", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ContactQuery {
        public static final int CONTACT_ACCOUNT_NAME = 11;
        public static final int CONTACT_ACCOUNT_TYPE = 10;
        public static final int CONTACT_DISPLAY_NAME = 1;
        public static final int CONTACT_HAS_PHONE_NUMEBER = 8;
        public static final int CONTACT_ID = 0;
        public static final int CONTACT_LOOKUP_KEY = 6;
        public static final int CONTACT_NAME_RAW_CONTACT_ID = 7;
        public static final int CONTACT_PHONEBOOK_LABEL = 9;
        public static final int CONTACT_PHOTO_ID = 3;
        public static final int CONTACT_PHOTO_URI = 4;
        private static final String[] CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE = null;
        private static final String[] CONTACT_PROJECTION_ALTERNATIVE_PRIMARY = null;
        private static final String[] CONTACT_PROJECTION_PRIMARY_ALTERNATIVE = null;
        private static final String[] CONTACT_PROJECTION_PRIMARY_PRIMARY = null;
        public static final int CONTACT_SORT_KEY = 5;
        public static final int CONTACT_TIME_CONTACTED = 2;
        public static final ContactQuery INSTANCE = null;

        private ContactQuery() {
        }

        public final String[] getCONTACT_PROJECTION_PRIMARY_PRIMARY() {
            return CONTACT_PROJECTION_PRIMARY_PRIMARY;
        }

        static {
            INSTANCE = new ContactQuery();
            CONTACT_PROJECTION_PRIMARY_PRIMARY = new String[]{"_id", "display_name", "times_contacted", "photo_id", "photo_thumb_uri", PickerFragment.CONTACT_SORT_CNAME, "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_ALTERNATIVE, "account_type", "account_name"};
            CONTACT_PROJECTION_PRIMARY_ALTERNATIVE = new String[]{"_id", "display_name", "times_contacted", "photo_id", "photo_thumb_uri", "sort_key_alt", "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_ALTERNATIVE, "account_type", "account_name"};
            CONTACT_PROJECTION_ALTERNATIVE_PRIMARY = new String[]{"_id", "display_name_alt", "times_contacted", "photo_id", "photo_thumb_uri", PickerFragment.CONTACT_SORT_CNAME, "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, "account_type", "account_name"};
            CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE = new String[]{"_id", "display_name_alt", "times_contacted", "photo_id", "photo_thumb_uri", "sort_key_alt", "lookup", "name_raw_contact_id", "has_phone_number", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, "account_type", "account_name"};
        }

        public final String[] getCONTACT_PROJECTION_PRIMARY_ALTERNATIVE() {
            return CONTACT_PROJECTION_PRIMARY_ALTERNATIVE;
        }

        public final String[] getCONTACT_PROJECTION_ALTERNATIVE_PRIMARY() {
            return CONTACT_PROJECTION_ALTERNATIVE_PRIMARY;
        }

        public final String[] getCONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE() {
            return CONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE;
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$ContactedTimesSortComparator;", "Ljava/util/Comparator;", "Lcom/android/contacts/list/SamContact;", "Lkotlin/Comparator;", "()V", "mNameSortComparator", "Lcom/android/contacts/util/NameSortComparator;", "getMNameSortComparator", "()Lcom/android/contacts/util/NameSortComparator;", "setMNameSortComparator", "(Lcom/android/contacts/util/NameSortComparator;)V", "compare", "", "lhs", "rhs", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class ContactedTimesSortComparator implements Comparator<SamContact> {
        private NameSortComparator mNameSortComparator;

        public ContactedTimesSortComparator() {
            this.mNameSortComparator = new NameSortComparator();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare2(r1, r2);
        }

        public final NameSortComparator getMNameSortComparator() {
            return this.mNameSortComparator;
        }

        public final void setMNameSortComparator(NameSortComparator r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mNameSortComparator = r2;
        }

        /* JADX INFO: renamed from: compare, reason: avoid collision after fix types in other method */
        public int compare2(SamContact r3, SamContact r4) {
            Intrinsics.checkNotNullParameter(r3, "lhs");
            Intrinsics.checkNotNullParameter(r4, "rhs");
            int r0 = Integer.compare(r4.timesContacted, r3.timesContacted);
            if (r0 == 0) goto L5;
            return r0;
        L5:
            return this.mNameSortComparator.compare2(r3, r4);
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$ContactsContent;", "Landroid/database/ContentObserver;", "handler", "Landroid/os/Handler;", "(Lcom/android/contacts/list/NewContactListFragment;Landroid/os/Handler;)V", "onChange", "", "selfChange", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class ContactsContent extends ContentObserver {
        final /* synthetic */ NewContactListFragment this$0;

        public ContactsContent(NewContactListFragment r1, Handler r2) {
            this.this$0 = r1;
            super(r2);
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean r7) {
            if (this.this$0.isSearch() == true) goto L5;
        L7:
            NewContactListFragment.access$clearModeState(this.this$0);
            if (NewContactListFragment.access$getMProviderIsNormal$p(this.this$0) == true) goto L10;
            return;
        L10:
            ContactPhotoManager r8 = NewContactListFragment.access$getMPhotoManager$p(this.this$0);
            if (r8 == null) goto L14;
            r8.refreshCache();
        L14:
            if (NewContactListFragment.access$getMDataIsReady$p(this.this$0) == true) goto L17;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(NewContactListFragment.TAG, "Database changes but query is already in progress.");
            return;
        L17:
            NewContactListFragment.access$setMDataIsReady$p(this.this$0, false);
            if (NewContactListFragment.access$getDEBUG$p(this.this$0) == false) goto L21;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_v("ContactsContent", "ContactsContenttrue");
        L21:
            if (NewContactListFragment.access$getMIsDeletingContacts$p(this.this$0) == false) goto L23;
            return;
        L23:
            NewContactListFragment r0 = this.this$0;
            NewContactListFragment.triggerLoad$default(r0, NewContactListFragment.access$getMSortMode$p(r0), true, false, 4, null);
            return;
        L5:
            if (TextUtils.isEmpty(NewContactListFragment.access$getMSearchKey$p(this.this$0)) == true) goto L7;
            NewContactListFragment r9 = this.this$0;
            r9.onQueryTextChangeIView(NewContactListFragment.access$getMSearchKey$p(r9), false);
            goto L7
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u000e\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0006\u0010\u0013\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u0004¢\u0006\u0002\u0010\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\tR\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$ContactsWithCompany;", "", "()V", "ACCOUNT_NAME", "", "ACCOUNT_TYPE", "COLUMNS", "", "", "[Ljava/lang/String;", VCardConstants.PARAM_EXTRA_TYPE_COMPANY, "DISPLAY_NAME", "LOOKUP_KEY", "NAME_RAW_CONTACT_ID", "PHONE_PHONEBOOK_LABEL", CallSubjectDialog.ARG_PHOTO_ID, "SORT_KEY_PRIMARY", "_ID", "getProjection", "displayOrder", "sortOrder", "(II)[Ljava/lang/String;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class ContactsWithCompany {
        public static final int ACCOUNT_NAME = 8;
        public static final int ACCOUNT_TYPE = 7;
        private static final String[] COLUMNS = null;
        public static final int COMPANY = 6;
        public static final int DISPLAY_NAME = 1;
        public static final ContactsWithCompany INSTANCE = null;
        public static final int LOOKUP_KEY = 3;
        public static final int NAME_RAW_CONTACT_ID = 5;
        public static final int PHONE_PHONEBOOK_LABEL = 9;
        public static final int PHOTO_ID = 4;
        public static final int SORT_KEY_PRIMARY = 2;
        public static final int _ID = 0;

        private ContactsWithCompany() {
        }

        static {
            INSTANCE = new ContactsWithCompany();
            COLUMNS = new String[]{"_id", "display_name", PickerFragment.CONTACT_SORT_CNAME, "lookup", "photo_id", "name_raw_contact_id", "data1", "account_type", "account_name", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY};
        }

        public final String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            COLUMNS[1] = "display_name_alt";
        L6:
            if (r4 != 2) goto L8;
            COLUMNS[2] = "sort_key_alt";
        L10:
            return COLUMNS;
        L8:
            COLUMNS[2] = PickerFragment.CONTACT_SORT_CNAME;
            goto L10
        L5:
            COLUMNS[1] = "display_name";
            goto L6
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\b\u0006\b\u0082\u0004\u0018\u00002\u001a\u0012\u0006\u0012\u0004\u0018\u00010\u0002\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00030\u0001B\u0015\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0006\u0010\u000e\u001a\u00020\u000fJ'\u0010\u0010\u001a\u0004\u0018\u00010\u00032\u0016\u0010\u0011\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00020\u0012\"\u0004\u0018\u00010\u0002H\u0014¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u000fH\u0014J\u0012\u0010\u0015\u001a\u00020\u000f2\b\u0010\u0016\u001a\u0004\u0018\u00010\u0003H\u0014J\b\u0010\u0017\u001a\u00020\u000fH\u0014R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$DeleteContactsTask;", "Landroid/os/AsyncTask;", "", "Ljava/lang/Void;", "context", "Landroid/content/Context;", "mIsContactsEmpty", "", "(Lcom/android/contacts/list/NewContactListFragment;Landroid/content/Context;Z)V", "dismiss", "handler", "Landroid/os/Handler;", "progressDialog", "Lcom/obric/oui/dialog/v2/misc/StatusDialog;", "completed", "", "doInBackground", "params", "", "([[J)Ljava/lang/Void;", "onCancelled", "onPostExecute", "aVoid", "onPreExecute", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class DeleteContactsTask extends AsyncTask<long[], Void, Void> {
        private final Context context;
        private boolean dismiss;
        private final Handler handler;
        private final boolean mIsContactsEmpty;
        private StatusDialog progressDialog;
        final /* synthetic */ NewContactListFragment this$0;

        public DeleteContactsTask(NewContactListFragment r2, Context r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r3, "context");
            this.this$0 = r2;
            this.context = r3;
            this.mIsContactsEmpty = r4;
            this.handler = new Handler(Looper.getMainLooper());
        }

        public static final /* synthetic */ Context access$getContext$p(DeleteContactsTask r0) {
            return r0.context;
        }

        public static final /* synthetic */ boolean access$getDismiss$p(DeleteContactsTask r0) {
            return r0.dismiss;
        }

        public static final /* synthetic */ StatusDialog access$getProgressDialog$p(DeleteContactsTask r0) {
            return r0.progressDialog;
        }

        public static final /* synthetic */ void access$setProgressDialog$p(DeleteContactsTask r0, StatusDialog r1) {
            r0.progressDialog = r1;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(long[][] r1) {
            return doInBackground2(r1);
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ void onPostExecute(Void r1) {
            onPostExecute2(r1);
        }

        @Override // android.os.AsyncTask
        protected void onPreExecute() {
            this.dismiss = false;
            NewContactListFragment.access$setMIsDeletingContacts$p(this.this$0, true);
            Handler r0 = this.handler;
            final NewContactListFragment r2 = this.this$0;
            r0.post(new NewContactListFragment$DeleteContactsTask$onPreExecute$1(r2, this));
        }

        /* JADX INFO: renamed from: doInBackground, reason: avoid collision after fix types in other method */
        protected Void doInBackground2(long[]... r8) {
            Intrinsics.checkNotNullParameter(r8, "params");
            int r0 = 0;
            long[] r9 = (long[]) ArraysKt.getOrNull(r8, 0);
            if (r9 != null) goto L5;
            r9 = new long[0];
        L5:
            int r1 = r9.length;
            ArrayList r2 = new ArrayList(r1);
            int r3 = r9.length;
        L6:
            if (r0 >= r3) goto L8;
            Uri r4 = ContentUris.withAppendedId(ContactsContract.Contacts.CONTENT_URI, r9[r0]);
            Intrinsics.checkNotNullExpressionValue(r4, "withAppendedId(ContactsC…Contacts.CONTENT_URI, id)");
            r2.add(r4);
            r0 = r0 + 1;
            goto L6
        L8:
            ArrayList r10 = new ArrayList(r1);
            Iterator r5 = r2.iterator();
        L10:
            if (r5.hasNext() == false) goto L17;
            Uri r6 = (Uri) r5.next();
            MemoryCardUtil.deleteCardWithContactUri(NewContactListFragment.access$getMContext$p(this.this$0), r6);
            SimContactsOperation r7 = new SimContactsOperation(NewContactListFragment.access$getMContext$p(this.this$0));
            long r11 = ContentUris.parseId(r6);
            int r12 = SimContactsOperation.getSimSubscription(r11);
            if (r12 != (-1)) goto L14;
            r10.add(ContentProviderOperation.newDelete(r6).build());
            goto L10
        L14:
            if (r7.delete(SimContactsOperation.getSimAccountValues(r11), r12) <= 0) goto L10;
            r10.add(ContentProviderOperation.newDelete(r6).build());
            goto L10
        L17:
            ArrayList r13 = new ArrayList();
            ArrayList r14 = new ArrayList();
            Iterator r15 = r10.iterator();
        L19:
            if (r15.hasNext() == false) goto L24;
            Uri r16 = ((ContentProviderOperation) r15.next()).getUri();
            Intrinsics.checkNotNullExpressionValue(r16, "opt.getUri()");
            Uri r17 = ContactsContract.Contacts.getLookupUri(this.context.getContentResolver(), r16);
            if (r17 == null) goto L19;
            r13.add(r17.toString());
            r14.add(ContactSaveService.getDisplayNameFromLookupUri(this.context.getContentResolver(), r17));
            goto L19
        L24:
            ContactSaveService.sendDeleteContactsBroadCast(NewContactListFragment.access$getMContext$p(this.this$0), r13, r14);
            TrackOptUtils.trackDeleteOperation("li", String.valueOf(r10.size()));
            Context r18 = NewContactListFragment.access$getMContext$p(this.this$0);
            if (r18 == null) goto L27;
            ContentResolver r19 = r18.getContentResolver();
        L28:
            ContactsUtils.runApplyBatch(r19, "com.android.contacts", r10);
            return null;
        L27:
            r19 = null;
            goto L28
        }

        /* JADX INFO: renamed from: onPostExecute, reason: avoid collision after fix types in other method */
        protected void onPostExecute2(Void r1) {
            completed();
        }

        @Override // android.os.AsyncTask
        protected void onCancelled() {
            completed();
        }

        public final void completed() {
            NewContactListFragment.access$setMIsDeletingContacts$p(this.this$0, false);
            boolean r0 = true;
            this.dismiss = true;
            StatusDialog r3 = this.progressDialog;     // Catch: Throwable -> L16 IllegalArgumentException -> L18
            if (r3 == null) goto L14;
            if (r3 != null) goto L7;
        L9:
            r0 = false;
        L10:
            if (r0 == false) goto L14;
            StatusDialog r1 = this.progressDialog;     // Catch: Throwable -> L16 IllegalArgumentException -> L18
            if (r1 == null) goto L14;
            r1.dismiss();     // Catch: Throwable -> L16 IllegalArgumentException -> L18
            goto L14
        L7:
            if (r3.isShowing() != true) goto L9;
        L14:
            UIUtils.setViewVisibility(NewContactListFragment.access$getMEmptyView$p(this.this$0), 0);     // Catch: Throwable -> L16 IllegalArgumentException -> L18
        L20:
            this.progressDialog = null;
            NewContactListFragment r4 = this.this$0;
            NewContactListFragment.triggerLoad$default(r4, NewContactListFragment.access$getMSortMode$p(r4), true, false, 4, null);
            if (NewContactListFragment.access$getMActivity$p(this.this$0) != null) goto L23;
            return;
        L23:
            if ((NewContactListFragment.access$getMActivity$p(this.this$0) instanceof DialtactsActivity) == false) goto L32;
            FragmentActivity r9 = NewContactListFragment.access$getMActivity$p(this.this$0);
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type com.android.contacts.activities.DialtactsActivity");
            ((DialtactsActivity) r9).notifyDBDataChanged();
            return;
        L32:
            return;
        L18:
            e = move-exception;
            e.printStackTrace();     // Catch: Throwable -> L16
        L16:
            th = move-exception;
            this.progressDialog = null;
            throw th;
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0003\b\u0096\u0004\u0018\u00002\u0012\u0012\u0004\u0012\u00020\u00020\u0001j\b\u0012\u0004\u0012\u00020\u0002`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u00022\u0006\u0010\u000e\u001a\u00020\u0002H\u0016R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\n¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$ExpandableSortComparator;", "Ljava/util/Comparator;", "Lcom/android/contacts/list/SamContact;", "Lkotlin/Comparator;", "(Lcom/android/contacts/list/NewContactListFragment;)V", "mNameSortComparator", "Lcom/android/contacts/util/NameSortComparator;", "getMNameSortComparator", "()Lcom/android/contacts/util/NameSortComparator;", "setMNameSortComparator", "(Lcom/android/contacts/util/NameSortComparator;)V", "compare", "", "lhs", "rhs", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public class ExpandableSortComparator implements Comparator<SamContact> {
        private NameSortComparator mNameSortComparator;
        final /* synthetic */ NewContactListFragment this$0;

        public ExpandableSortComparator(NewContactListFragment r1) {
            this.this$0 = r1;
            this.mNameSortComparator = new NameSortComparator();
        }

        @Override // java.util.Comparator
        public /* bridge */ /* synthetic */ int compare(SamContact r1, SamContact r2) {
            return compare(r1, r2);
        }

        public final NameSortComparator getMNameSortComparator() {
            return this.mNameSortComparator;
        }

        public final void setMNameSortComparator(NameSortComparator r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.mNameSortComparator = r2;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        public int compare(SamContact r4, SamContact r5) {
            Intrinsics.checkNotNullParameter(r4, "lhs");
            Intrinsics.checkNotNullParameter(r5, "rhs");
            String r0 = r4.headerSectionData;
            String r1 = r5.headerSectionData;
            Intrinsics.checkNotNullExpressionValue(r1, "rhs.headerSectionData");
            int r2 = r0.compareTo(r1);
            if (r2 != 0) goto L5;
            String r3 = r4.headerSortData;
            Intrinsics.checkNotNullExpressionValue(r3, "lhs.headerSortData");
            String r6 = r5.headerSortData;
            Intrinsics.checkNotNullExpressionValue(r6, "rhs.headerSortData");
            r2 = StringsKt.compareTo(r3, r6, true);
        L5:
            if (r2 == 0) goto L7;
            return r2;
        L7:
            return this.mNameSortComparator.compare2(r4, r5);
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H&¨\u0006\b"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$Listener;", "", "onContactSelected", "", "contactUri", "Landroid/net/Uri;", "targetRect", "Landroid/graphics/Rect;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public interface Listener {
        void onContactSelected(Uri r1, Rect r2);
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010\u0015\u001a\u00020\u0016J\b\u0010\u0017\u001a\u00020\u0003H\u0016R\u001a\u0010\u0006\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u0004\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\b\"\u0004\b\f\u0010\nR\u001a\u0010\r\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\b\"\u0004\b\u000f\u0010\nR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\b\"\u0004\b\u0011\u0010\nR\u001a\u0010\u0012\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$LocationToken;", "", "province", "", "city", "(Lcom/android/contacts/list/NewContactListFragment;Ljava/lang/String;Ljava/lang/String;)V", "LiteProvinceCityPinyin", "getLiteProvinceCityPinyin", "()Ljava/lang/String;", "setLiteProvinceCityPinyin", "(Ljava/lang/String;)V", "getCity", "setCity", "fullProvinceCityPinyin", "getFullProvinceCityPinyin", "setFullProvinceCityPinyin", "getProvince", "setProvince", "sortCityPinyin", "getSortCityPinyin", "setSortCityPinyin", "removeProvinceCityCharacter", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class LocationToken {
        private String LiteProvinceCityPinyin;
        private String city;
        private String fullProvinceCityPinyin;
        private String province;
        private String sortCityPinyin;
        final /* synthetic */ NewContactListFragment this$0;

        public LocationToken(NewContactListFragment r2, String r3, String r4) {
            Intrinsics.checkNotNullParameter(r3, "province");
            Intrinsics.checkNotNullParameter(r4, "city");
            this.this$0 = r2;
            this.province = r3;
            this.city = r4;
            this.LiteProvinceCityPinyin = "";
            this.fullProvinceCityPinyin = this.province + this.city;
            this.sortCityPinyin = this.LiteProvinceCityPinyin;
        }

        public final String getCity() {
            return this.city;
        }

        public final String getProvince() {
            return this.province;
        }

        public final void setCity(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.city = r2;
        }

        public final void setProvince(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.province = r2;
        }

        public final String getSortCityPinyin() {
            return this.sortCityPinyin;
        }

        public final void setSortCityPinyin(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.sortCityPinyin = r2;
        }

        public final String getFullProvinceCityPinyin() {
            return this.fullProvinceCityPinyin;
        }

        public final void setFullProvinceCityPinyin(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.fullProvinceCityPinyin = r2;
        }

        public final String getLiteProvinceCityPinyin() {
            return this.LiteProvinceCityPinyin;
        }

        public final void setLiteProvinceCityPinyin(String r2) {
            Intrinsics.checkNotNullParameter(r2, "<set-?>");
            this.LiteProvinceCityPinyin = r2;
        }

        public final boolean removeProvinceCityCharacter() {
            this.LiteProvinceCityPinyin = "";
            String r7 = null;
            if (TextUtils.isEmpty(this.province) == false) goto L5;
            boolean r1 = false;
        L44:
            if (TextUtils.isEmpty(this.city) == true) goto L60;
            if (StringsKt.endsWith$default(this.city, "市", false, 2, null) == false) goto L60;
            if (this.city.length() <= 1) goto L60;
            String r2 = this.city;
            String r3 = r2.substring(0, r2.length() - 1);
            Intrinsics.checkNotNullExpressionValue(r3, "substring(...)");
            if (TextUtils.isEmpty(r3) == false) goto L52;
            return true;
        L52:
            if (NameAvatarController.hasChinese(r3) == false) goto L62;
            StringBuilder r4 = new StringBuilder().append(this.LiteProvinceCityPinyin);
            String r5 = NewContactListFragment.access$getPinYinCityName(this.this$0, r3);
            if (r5 == null) goto L58;
            Locale r6 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(r6, "getDefault()");
            String r8 = r5.toUpperCase(r6);
            Intrinsics.checkNotNullExpressionValue(r8, "toUpperCase(...)");
            if (r8 == null) goto L58;
            r7 = StringsKt.replace$default(r8, HanziToPinyin.Token.SEPARATOR, "", false, 4, null);
        L58:
            this.LiteProvinceCityPinyin = r4.append(r7).toString();
            return true;
        L62:
            return true;
        L60:
            return r1;
        L5:
            if (StringsKt.endsWith$default(this.province, "省", false, 2, null) == false) goto L10;
            if (this.province.length() <= 1) goto L10;
            String r9 = this.province;
            String r10 = r9.substring(0, r9.length() - 1);
            Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        L31:
            if (TextUtils.isEmpty(r10) == false) goto L33;
        L41:
            r1 = true;
            goto L44
        L33:
            if (NameAvatarController.hasChinese(r10) == false) goto L41;
            StringBuilder r11 = new StringBuilder().append(this.LiteProvinceCityPinyin);
            String r12 = NewContactListFragment.access$getPinYinCityName(this.this$0, r10);
            if (r12 == null) goto L39;
            Locale r13 = Locale.getDefault();
            Intrinsics.checkNotNullExpressionValue(r13, "getDefault()");
            String r14 = r12.toUpperCase(r13);
            Intrinsics.checkNotNullExpressionValue(r14, "toUpperCase(...)");
            if (r14 == null) goto L39;
            String r15 = StringsKt.replace$default(r14, HanziToPinyin.Token.SEPARATOR, "", false, 4, null);
        L40:
            this.LiteProvinceCityPinyin = r11.append(r15).toString();
        L39:
            r15 = null;
        L10:
            if (StringsKt.endsWith$default(this.province, NewContactListFragment.ZHUANGZU_AUTONOMOUS_REGION, false, 2, null) == false) goto L15;
            if (this.province.length() <= 5) goto L15;
            String r16 = this.province;
            r10 = r16.substring(0, r16.length() - 5);
            Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        L15:
            if (StringsKt.endsWith$default(this.province, NewContactListFragment.HUIZU_AUTONOMOUS_REGION, false, 2, null) == false) goto L20;
            if (this.province.length() <= 5) goto L20;
            String r17 = this.province;
            r10 = r17.substring(0, r17.length() - 5);
            Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        L20:
            if (StringsKt.endsWith$default(this.province, NewContactListFragment.WEIWUER_AUTONOMOUS_REGION, false, 2, null) == false) goto L25;
            if (this.province.length() <= 6) goto L25;
            String r18 = this.province;
            r10 = r18.substring(0, r18.length() - 6);
            Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
        L25:
            if (StringsKt.endsWith$default(this.province, NewContactListFragment.AUTONOMOUS_REGION, false, 2, null) == true) goto L27;
        L29:
            r10 = null;
            goto L31
        L27:
            if (this.province.length() <= 3) goto L29;
            String r19 = this.province;
            r10 = r19.substring(0, r19.length() - 3);
            Intrinsics.checkNotNullExpressionValue(r10, "substring(...)");
            goto L31
        }

        public String toString() {
            return "province:" + this.province + " city:" + this.city + " sortCityPinyin:" + this.sortCityPinyin + " LiteProvinceCityPinyin:" + this.LiteProvinceCityPinyin;
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\u0012\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\u0007H\u0016J$\u0010\r\u001a\u00020\u000e2\u0006\u0010\n\u001a\u00020\u00072\b\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016R\u0018\u0010\u0002\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0004\u0018\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$NumberAdapter;", "Landroid/widget/BaseAdapter;", "list", "", "", "(Lcom/android/contacts/list/NewContactListFragment;Ljava/util/List;)V", "getCount", "", "getItem", "", "position", "getItemId", "", "getView", "Landroid/view/View;", "convertView", "parent", "Landroid/view/ViewGroup;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class NumberAdapter extends BaseAdapter {
        private final List<String> list;
        final /* synthetic */ NewContactListFragment this$0;

        @Override // android.widget.Adapter
        public long getItemId(int r1) {
            return r1;
        }

        public NumberAdapter(NewContactListFragment r1, List<String> r2) {
            this.this$0 = r1;
            this.list = r2;
        }

        @Override // android.widget.Adapter
        public int getCount() {
            List<String> r0 = this.list;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.size();
        }

        @Override // android.widget.Adapter
        public Object getItem(int r1) {
            List<String> r0 = this.list;
            if (r0 == null) goto L6;
            return r0.get(r1);
        L6:
            return Integer.valueOf(r1);
        }

        @Override // android.widget.Adapter
        public View getView(int r3, View r4, ViewGroup r5) {
            if (r4 != null) goto L4;
            r4 = LayoutInflater.from(NewContactListFragment.access$getMContext$p(this.this$0)).inflate(R.layout.custom_spinner_dropdown_item, r5, false);
        L4:
            String r6 = null;
            if (r4 == null) goto L7;
            View r0 = r4.findViewById(R.id.custom_text1);
        L9:
            if ((r0 instanceof CheckedTextView) == false) goto L11;
            CheckedTextView r1 = (CheckedTextView) r0;
        L12:
            if (r1 == null) goto L17;
            List<String> r2 = this.list;
            if (r2 == null) goto L16;
            r6 = r2.get(r3);
        L16:
            r1.setText(r6);
        L17:
            Intrinsics.checkNotNullExpressionValue(r4, "view");
            return r4;
        L11:
            r1 = null;
            goto L12
        L7:
            r0 = null;
            goto L9
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\b\u0010\b\u001a\u00020\u0004H\u0016J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016¨\u0006\u000f"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$OnGroupActionListener;", "Lcom/android/contacts/group/GroupBrowseListFragment$OnGroupBrowserActionListener;", "(Lcom/android/contacts/list/NewContactListFragment;)V", "onChooseGroup", "", PerfConsts.PERF_DISK_FILE_SIZE, "", "onDataBinded", "onGroupDelete", "onViewGroupAction", "groupUri", "Landroid/net/Uri;", "setCanEdit", "isCanEdit", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class OnGroupActionListener implements GroupBrowseListFragment.OnGroupBrowserActionListener {
        final /* synthetic */ NewContactListFragment this$0;

        public OnGroupActionListener(NewContactListFragment r1) {
            this.this$0 = r1;
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onViewGroupAction(Uri r4) {
            Intent r0 = new Intent(NewContactListFragment.access$getMActivity$p(this.this$0), GroupBrowserActivity.class);
            r0.setData(r4);
            FragmentActivity r3 = NewContactListFragment.access$getMActivity$p(this.this$0);
            if (r3 == null) goto L6;
            r3.startActivity(r0);
            return;
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onChooseGroup(int r5) {
            if (NewContactListFragment.access$getMBottomDeleteLayoutListener$p(this.this$0) == null) goto L11;
            BottomDeleteLayoutListener r0 = NewContactListFragment.access$getMBottomDeleteLayoutListener$p(this.this$0);
            if (r0 == null) goto L11;
            if (r5 <= 0) goto L8;
            boolean r3 = true;
        L9:
            r0.setBottomBtnEnable(r3);
            goto L11
        L8:
            r3 = false;
        L11:
            if (NewContactListFragment.access$getMGroupBrowseListFragment$p(this.this$0) == null) goto L41;
            GroupBrowseListFragment r1 = NewContactListFragment.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r1 == null) goto L15;
            GroupBrowseListAdapter r2 = r1.getAdapter();
        L16:
            if (r2 == null) goto L41;
            if (NewContactListFragment.access$getMGroupSelectAllBtn$p(this.this$0) == null) goto L41;
            GroupBrowseListFragment r4 = NewContactListFragment.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r4 == null) goto L26;
            GroupBrowseListAdapter r6 = r4.getAdapter();
            if (r6 == null) goto L26;
            ArrayList<GroupListItem> r7 = r6.getGroupList();
            if (r7 == null) goto L26;
            int r8 = r7.size();
        L27:
            GroupBrowseListFragment r9 = NewContactListFragment.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r9 == null) goto L32;
            GroupBrowseListAdapter r10 = r9.getAdapter();
            if (r10 == null) goto L32;
            int r11 = r10.getReadOnlyItemSize();
        L33:
            int r12 = r8 - r11;
            SelectAllState r13 = NewContactListFragment.access$getMGroupSelectAllBtn$p(this.this$0);
            if (r13 == null) goto L41;
            if (r5 <= 0) goto L39;
            if (r12 != r5) goto L39;
            boolean r14 = true;
        L40:
            r13.setSelectAll(r14);
        L39:
            r14 = false;
        L32:
            r11 = 0;
        L26:
            r8 = 0;
            goto L27
        L15:
            r2 = null;
        L41:
            String r15 = this.this$0.getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r5)});
            Intrinsics.checkNotNullExpressionValue(r15, "getString(R.string.delet…ected_item_numbers, size)");
            OCTitleBar r16 = NewContactListFragment.access$getMOGroupTitleBar$p(this.this$0);
            if (r16 == null) goto L46;
            r16.setTitleText(r15);
            return;
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onGroupDelete() {
            NewContactListFragment.access$setGroupEditState(this.this$0, false);
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void setCanEdit(boolean r7) {
            if (r7 == true) goto L20;
            GroupBrowseListFragment r0 = NewContactListFragment.access$getMGroupBrowseListFragment$p(this.this$0);
            if (r0 == null) goto L6;
            r0.setGroupEdit(false);
        L6:
            NewContactListFragment r1 = this.this$0;
            NewContactListFragment.access$setMBtnGroupLeft$p(r1, NewContactListFragment.access$getTitleBtn(r1, R.drawable.standard_icon_multi_select_selector, true, NewContactListFragment.access$getMOGroupTitleBar$p(r1), NewContactListFragment.access$getMBtnGroupLeft$p(this.this$0)));
            if (NewContactListFragment.access$getMBtnGroupLeft$p(this.this$0) == null) goto L14;
            OButton r2 = NewContactListFragment.access$getMBtnGroupLeft$p(this.this$0);
            if (r2 == null) goto L11;
            r2.setContentDescription("选择");
        L11:
            OButton r3 = NewContactListFragment.access$getMBtnGroupLeft$p(this.this$0);
            if (r3 == null) goto L14;
            final NewContactListFragment r4 = this.this$0;
            r3.setOnClickListener(new NewContactListFragment$OnGroupActionListener$setCanEdit$1(r4));
        L14:
            OButton r5 = NewContactListFragment.access$getMBtnGroupRightDelete$p(this.this$0);
            if (r5 == null) goto L17;
            r5.setVisibility(8);
        L17:
            OButton r6 = NewContactListFragment.access$getMBtnGroupMenu$p(this.this$0);
            if (r6 == null) goto L20;
            r6.setVisibility(0);
        L20:
            OButton r8 = NewContactListFragment.access$getMBtnGroupLeft$p(this.this$0);
            if (r8 == null) goto L24;
            r8.setEnabled(r7);
            return;
        }

        @Override // com.android.contacts.group.GroupBrowseListFragment.OnGroupBrowserActionListener
        public void onDataBinded() {
            ProductUtils.isOpenTalkBack(this.this$0.getActivity());
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J!\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\t¢\u0006\u0002\u0010\u000bR\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\f"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$PhoneQuery;", "", "()V", "PHONE_PROJECTION", "", "", "[Ljava/lang/String;", "getProjection", "displayOrder", "", "sortOrder", "(II)[Ljava/lang/String;", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class PhoneQuery {
        public static final PhoneQuery INSTANCE = null;
        private static final String[] PHONE_PROJECTION = null;

        private PhoneQuery() {
        }

        static {
            INSTANCE = new PhoneQuery();
            PHONE_PROJECTION = new String[]{"data1", "contact_id", "is_super_primary", DBHelper.COL_DATA2, DBHelper.COL_DATA3, PickerFragment.CONTACT_SORT_CNAME, "data4", GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "display_name", "lookup", "photo_id", Constants.ContactsColumns.PHONEBOOK_LABEL_PRIMARY, "_id", BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME, BytedanceContactContract.BytedancePhoneColumn.NUMBER_LOCATION_NAME_PINYIN, "account_type", "account_name"};
        }

        public final String[] getProjection(int r3, int r4) {
            if (r3 != 2) goto L5;
            PHONE_PROJECTION[8] = "display_name_alt";
        L7:
            if (r4 != 2) goto L9;
            PHONE_PROJECTION[5] = "sort_key_alt";
        L11:
            return PHONE_PROJECTION;
        L9:
            PHONE_PROJECTION[5] = PickerFragment.CONTACT_SORT_CNAME;
            goto L11
        L5:
            PHONE_PROJECTION[8] = "display_name";
            goto L7
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B5\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003\u0012\u001a\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0003¢\u0006\u0002\u0010\tJ\u0015\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003HÆ\u0003J\u001d\u0010\u000e\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0003HÆ\u0003J=\u0010\u000f\u001a\u00020\u00002\u0014\b\u0002\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u001c\b\u0002\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\bHÖ\u0001R\u001d\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR%\u0010\u0006\u001a\u0016\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u0007\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$SearchResultPayload;", "", "contactsMap", "", "", "Lcom/android/contacts/list/SamContact;", "searchKeyMap", "", "", "(Ljava/util/Map;Ljava/util/Map;)V", "getContactsMap", "()Ljava/util/Map;", "getSearchKeyMap", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class SearchResultPayload {
        private final Map<Long, SamContact> contactsMap;
        private final Map<Long, List<String>> searchKeyMap;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ SearchResultPayload copy$default(SearchResultPayload r0, Map r1, Map r2, int r3, Object r4) {
            if ((r3 & 1) == 0) goto L6;
            r1 = r0.contactsMap;
        L6:
            if ((r3 & 2) == 0) goto L9;
            r2 = r0.searchKeyMap;
        L9:
            return r0.copy(r1, r2);
        }

        public final Map<Long, SamContact> component1() {
            return this.contactsMap;
        }

        public final Map<Long, List<String>> component2() {
            return this.searchKeyMap;
        }

        public final SearchResultPayload copy(Map<Long, SamContact> r1, Map<Long, List<String>> r2) {
            Intrinsics.checkNotNullParameter(r1, "contactsMap");
            return new SearchResultPayload(r1, r2);
        }

        public boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof SearchResultPayload) == true) goto L8;
            return false;
        L8:
            SearchResultPayload r6 = (SearchResultPayload) r5;
            if (Intrinsics.areEqual(this.contactsMap, r6.contactsMap) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.searchKeyMap, r6.searchKeyMap) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public int hashCode() {
            int r0 = this.contactsMap.hashCode() * 31;
            Map<Long, List<String>> r1 = this.searchKeyMap;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public String toString() {
            return "SearchResultPayload(contactsMap=" + this.contactsMap + ", searchKeyMap=" + this.searchKeyMap + ')';
        }

        public SearchResultPayload(Map<Long, SamContact> r2, Map<Long, List<String>> r3) {
            Intrinsics.checkNotNullParameter(r2, "contactsMap");
            this.contactsMap = r2;
            this.searchKeyMap = r3;
        }

        public final Map<Long, SamContact> getContactsMap() {
            return this.contactsMap;
        }

        public final Map<Long, List<String>> getSearchKeyMap() {
            return this.searchKeyMap;
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0082\u0004\u0018\u00002\u00020\u0001B9\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\u0006\u0010\u000b\u001a\u00020\f¢\u0006\u0002\u0010\rJ\"\u0010#\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tJ\b\u0010$\u001a\u00020%H\u0016J\u0012\u0010&\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000fJ\u000e\u0010'\u001a\u00020%2\u0006\u0010(\u001a\u00020\fJ\"\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f2\u000e\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tR\u001d\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00110\u000f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0018\u001a\u0016\u0012\u0004\u0012\u00020\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\t\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0004\u0018\u00010\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\"\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006*"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$SearchThread;", "Ljava/lang/Thread;", "uri", "Landroid/net/Uri;", "searchKey", "", "mode", "", "inAppSearchResultList", "", "Lcom/obric/capabilitykit/entity/search/InAppSearchEntity;", "isInAppSearch", "", "(Lcom/android/contacts/list/NewContactListFragment;Landroid/net/Uri;Ljava/lang/String;ILjava/util/List;Z)V", "inAppSearchResult", "", "", "Lcom/android/contacts/list/SamContact;", "getInAppSearchResult", "()Ljava/util/Map;", "mInAppSearchResultList", "mIsTrue", "mListSortMode", "mSearchKey", "mSearchKeyMapForResult", "mSearchUri", "getMSearchUri", "()Landroid/net/Uri;", "setMSearchUri", "(Landroid/net/Uri;)V", "searchDurationMs", "searchErrorCode", "searchErrorMsg", "searchSuccess", "searchType", "getProviderSearchResult", "run", "", "search", "setTrue", "isTrue", "updateInAppSearchArray", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SearchThread extends Thread {
        private boolean isInAppSearch;
        private List<InAppSearchEntity> mInAppSearchResultList;
        private boolean mIsTrue;
        private int mListSortMode;
        private String mSearchKey;
        private Map<Long, List<String>> mSearchKeyMapForResult;
        private Uri mSearchUri;
        private long searchDurationMs;
        private int searchErrorCode;
        private String searchErrorMsg;
        private boolean searchSuccess;
        private final String searchType;
        final /* synthetic */ NewContactListFragment this$0;

        public SearchThread(NewContactListFragment r1, Uri r2, String r3, int r4, List<InAppSearchEntity> r5, boolean r6) {
            this.this$0 = r1;
            this.mIsTrue = true;
            this.mSearchUri = r2;
            this.mSearchKey = r3;
            this.mListSortMode = r4;
            this.mInAppSearchResultList = r5;
            this.isInAppSearch = r6;
        }

        public static final /* synthetic */ List access$getMInAppSearchResultList$p(SearchThread r0) {
            return r0.mInAppSearchResultList;
        }

        public static final /* synthetic */ String access$getMSearchKey$p(SearchThread r0) {
            return r0.mSearchKey;
        }

        public static final /* synthetic */ void access$setSearchDurationMs$p(SearchThread r0, long r1) {
            r0.searchDurationMs = r1;
        }

        public static final /* synthetic */ void access$setSearchErrorCode$p(SearchThread r0, int r1) {
            r0.searchErrorCode = r1;
        }

        public static final /* synthetic */ void access$setSearchErrorMsg$p(SearchThread r0, String r1) {
            r0.searchErrorMsg = r1;
        }

        public static final /* synthetic */ void access$setSearchSuccess$p(SearchThread r0, boolean r1) {
            r0.searchSuccess = r1;
        }

        protected final Uri getMSearchUri() {
            return this.mSearchUri;
        }

        protected final void setMSearchUri(Uri r1) {
            this.mSearchUri = r1;
        }

        public final void setTrue(boolean r1) {
            this.mIsTrue = r1;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.mIsTrue == true) goto L6;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(NewContactListFragment.TAG, "mSearchThread isInterrupted");
            return;
        L6:
            Map<Long, SamContact> r0 = search();
            if (this.mIsTrue == false) goto L16;
            Handler r1 = this.this$0.getMHandler();
            if (r1 == null) goto L11;
            r1.removeMessages(1004);
        L11:
            Message r2 = new Message();
            r2.what = 1004;
            r2.obj = new SearchResultPayload(r0, this.mSearchKeyMapForResult);
            Handler r3 = this.this$0.getMHandler();
            if (r3 == null) goto L14;
            r3.sendMessage(r2);
        L14:
            SearchUtils.saveSearchState(r0.keySet().size(), this.isInAppSearch, this.searchSuccess, this.searchDurationMs, this.searchErrorMsg, this.searchErrorCode, this.mSearchKey, -1);
            EventTrackerManager.INSTANCE.track(new ContactPageShowEvent("", "ContactsSearch", null, null, 12, null));
            return;
        }

        public final Map<Long, SamContact> search() {
            this.mSearchKeyMapForResult = null;
            HashMap r0 = new HashMap();
            if (this.isInAppSearch == true) goto L5;
            r0.putAll(getProviderSearchResult(this.mInAppSearchResultList));
        L6:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "search_message: search final search contactsMap =  " + r0.size() + " isInAppSearch = " + this.isInAppSearch);
            return r0;
        L5:
            r0.putAll(getInAppSearchResult());
            goto L6
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v11 */
        /* JADX WARN: Type inference failed for: r6v3, types: [java.util.concurrent.CountDownLatch] */
        /* JADX WARN: Type inference failed for: r6v7, types: [java.lang.String] */
        public final Map<Long, SamContact> getInAppSearchResult() {
            CountDownLatch r10 = new CountDownLatch(1);
            HashMap r12 = new HashMap();
            final long r13 = System.currentTimeMillis();
            final AtomicBoolean r15 = new AtomicBoolean(false);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "search_message: searchUseInAppSearch start, searchKey = " + this.mSearchKey);
            String r1 = this.mSearchKey;     // Catch: Throwable -> L32
            String r2 = r1;     // Catch: Throwable -> L32
            if (r2 != null) goto L6;
        L9:
            boolean r3 = true;
        L10:
            if (r3 == false) goto L12;
            return r12;
        L12:
            InAppSearchRequest r22 = new InAppSearchRequest(r1, 0, true, false, 5);     // Catch: Throwable -> L32
            final String r6 = r10;
            SearchUtils.startSearchWithTimeOut(this.this$0.getContext(), r22, 10000, NewContactListFragment.TAG, new NewContactListFragment$SearchThread$inAppSearchResult$1(r15, r13, this, r6));     // Catch: Throwable -> L30
            boolean r4 = r10.await(15, TimeUnit.SECONDS);     // Catch: Throwable -> L30
            long r5 = System.currentTimeMillis() - r13;
            if (r4 == true) goto L20;
            r15.set(true);     // Catch: Throwable -> L30
            String r7 = "search_message: await TIMEOUT searchKey = " + this.mSearchKey + " ,totalElapsed = " + r5 + "ms ,searchSuccess = " + this.searchSuccess + " ,searchErrorCode = " + this.searchErrorCode + " ,searchErrorMsg = " + this.searchErrorMsg;     // Catch: Throwable -> L30
            Throwable r8 = new Throwable("InAppSearch await timeout stacktrace");     // Catch: Throwable -> L30
            String r9 = NewContactListFragment.TAG;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(r9, r7, r8);     // Catch: Throwable -> L28
            InAppSearchClient.INSTANCE.stopSearch();     // Catch: Throwable -> L28
            this.searchSuccess = false;     // Catch: Throwable -> L28
            this.searchErrorCode = -100;     // Catch: Throwable -> L28
            this.searchErrorMsg = "await timeout";     // Catch: Throwable -> L28
            r6 = r9;
        L22:
            if (this.searchSuccess == false) goto L26;
            List<InAppSearchEntity> r11 = this.mInAppSearchResultList;     // Catch: Throwable -> L28
            if (r11 == null) goto L26;
            this.mSearchKeyMapForResult = SearchUtils.getSearchKeyMap(r11);     // Catch: Throwable -> L28
            r12.putAll(updateInAppSearchArray(r11));     // Catch: Throwable -> L28
        L26:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r6, "search_message: inAppSearchResult final resultSize = " + r12.size());     // Catch: Throwable -> L28
            return r12;
        L20:
            String r14 = NewContactListFragment.TAG;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(r14, "search_message: await completed searchKey = " + this.mSearchKey + " ,totalElapsed = " + r5 + "ms ,searchSuccess = " + this.searchSuccess);     // Catch: Throwable -> L28
            r6 = r14;
        L28:
            th = th;
        L34:
            r15.set(true);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(r6, "search_message: searchUseInAppSearch exception ,elapsed = " + (System.currentTimeMillis() - r13) + "ms", th);
            return r12;
        L30:
            th = th;
            r6 = NewContactListFragment.TAG;
            goto L34
        L6:
            if (r2.length() == 0) goto L9;
            r3 = false;
        L32:
            th = th;
            r6 = NewContactListFragment.TAG;
            goto L34
        }

        /* JADX WARN: Multi-variable type inference failed */
        public final Map<Long, SamContact> getProviderSearchResult(List<InAppSearchEntity> r24) {
            Map<Long, SamContact> r2 = updateInAppSearchArray(r24);
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "search_message: getProviderSearchResult contactsMap =  " + r2.size() + " in = " + r24);
            long r5 = System.currentTimeMillis();
            if (this.mSearchUri == null) goto L99;
            String r0 = NewContactListFragment.access$getCONTACT_QUERY$cp();
            int r8 = 1;
            if (ContactsUtils.FEATURE_SIM_PHONEBOOK == false) goto L19;
            int r1 = this.mListSortMode;
            if (r1 != 32) goto L9;
            r0 = "account_type = 'com.android.sim' and account_name = '" + MoreContactUtils.getSimAccountName(0) + '\'';
            goto L19
        L9:
            if (r1 != 64) goto L11;
            r0 = "account_type = 'com.android.sim' and account_name = '" + MoreContactUtils.getSimAccountName(1) + '\'';
            goto L19
        L11:
            if (r1 == 256) goto L14;
            r0 = NewContactListFragment.access$getCONTACT_QUERY$cp();
            goto L19
        L14:
            if (NewContactListFragment.access$getMIsHasPhoneNum$p(this.this$0) == false) goto L16;
            r0 = NewContactListFragment.access$getCONTACT_CITY_QUERY$cp() + " and " + NewContactListFragment.access$getCONTACT_EXCLUDE_SIM_ACCOUNT_QUERY$cp();
            goto L19
        L16:
            r0 = NewContactListFragment.access$getCONTACT_EXCLUDE_SIM_ACCOUNT_QUERY$cp();
        L19:
            String r13 = r0;
            Uri r11 = this.mSearchUri;
            if (r11 != null) goto L22;
            return r2;
        L22:
            Cursor r7 = null;
            FragmentActivity r3 = this.this$0.getActivity();     // Catch: Throwable -> L90 Exception -> L92
            if (r3 == null) goto L29;
            ContentResolver r10 = r3.getContentResolver();     // Catch: Throwable -> L90 Exception -> L92
            if (r10 == null) goto L29;
            Cursor r12 = r10.query(r11, NewContactListFragment.access$getContactProjection(this.this$0), r13, null, NewContactListFragment.access$getCONTACT_SEARCH_SORT$cp());     // Catch: Throwable -> L90 Exception -> L92
        L30:
            if (r12 != null) goto L104;
        L82:
            boolean r4 = true;
        L83:
            this.searchSuccess = r4;     // Catch: Throwable -> L86 Exception -> L88
            if (r12 == null) goto L99;
            r12.close();
            goto L99
        L88:
            e = e;
            r7 = r12;
        L93:
            this.searchSuccess = false;     // Catch: Throwable -> L90
            this.searchErrorMsg = e.toString();     // Catch: Throwable -> L90
            this.searchErrorCode = -1;     // Catch: Throwable -> L90
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(NewContactListFragment.TAG, "search_message: searchWithoutInAppSearch", e);     // Catch: Throwable -> L90
            if (r7 == null) goto L99;
            r7.close();
        L86:
            th = th;
            r7 = r12;
        L96:
            if (r7 == null) goto L98;
            r7.close();
        L98:
            throw th;
        L104:
            if (r12.moveToFirst() == false) goto L82;
            String r14 = this.mSearchKey;     // Catch: Throwable -> L86 Exception -> L88
            if (r14 == null) goto L38;
            String r17 = StringsKt.replace$default(r14, HanziToPinyin.Token.SEPARATOR, "", false, 4, null);     // Catch: Throwable -> L86 Exception -> L88
            if (r17 == null) goto L38;
            String r6 = StringsKt.replace$default(r17, "-", "", false, 4, null);     // Catch: Throwable -> L86 Exception -> L88
        L39:
            SamContact r15 = new SamContact(0);     // Catch: Throwable -> L86 Exception -> L88
            r15.contactId = r12.getLong(0);     // Catch: Throwable -> L86 Exception -> L88
            String r16 = r12.getString(r8);     // Catch: Throwable -> L86 Exception -> L88
            r15.name = ContactsUtils.getContactName(this.this$0.getActivity(), r16);     // Catch: Throwable -> L86 Exception -> L88
            if (TextUtils.isEmpty(r16) == true) goto L42;
            boolean r18 = r8;
        L43:
            r15.hasname = r18;     // Catch: Throwable -> L86 Exception -> L88
            r15.LookKey = r12.getString(6);     // Catch: Throwable -> L86 Exception -> L88
            r15.photoId = r12.getLong(3);     // Catch: Throwable -> L86 Exception -> L88
            r15.raw_contactid = r12.getLong(7);     // Catch: Throwable -> L86 Exception -> L88
            FragmentActivity r19 = this.this$0.getActivity();     // Catch: Throwable -> L86 Exception -> L88
            if (r19 == null) goto L78;
            HashMap<Long, ArrayList<DialtactsActivity.DataItem>> r110 = ((DialtactsActivity) r19).getBriefContactList();     // Catch: Throwable -> L86 Exception -> L88
            if (r110 == null) goto L47;
            if (r110.isEmpty() == true) goto L78;
            if (r110.containsKey(Long.valueOf(r15.contactId)) == false) goto L78;
            ArrayList<DialtactsActivity.DataItem> r111 = r110.get(Long.valueOf(r15.contactId));     // Catch: Throwable -> L86 Exception -> L88
            if (r111 != null) goto L56;
        L74:
            if (r111 == null) goto L78;
            if (r111.size() != 1) goto L78;
            r15.number = r111.get(0).number;     // Catch: Throwable -> L86 Exception -> L88
            goto L78
        L56:
            if (r111.size() <= r8) goto L74;
            r15.number = r111.get(0).number;     // Catch: Throwable -> L86 Exception -> L88
            Iterator<DialtactsActivity.DataItem> r112 = r111.iterator();     // Catch: Throwable -> L86 Exception -> L88
        L59:
            if (r112.hasNext() == false) goto L78;
            DialtactsActivity.DataItem r113 = r112.next();     // Catch: Throwable -> L86 Exception -> L88
            if (r113.number == null) goto L59;
            String r114 = r6;     // Catch: Throwable -> L86 Exception -> L88
            if (r114 != null) goto L65;
        L68:
            int r115 = r8;
        L69:
            if (r115 != 0) goto L59;
            String r116 = PhoneNumberUtils.normalizeNumber(r113.number);     // Catch: Throwable -> L86 Exception -> L88
            Intrinsics.checkNotNullExpressionValue(r116, "normalizeNumber(item.number)");     // Catch: Throwable -> L86 Exception -> L88
            if (StringsKt.contains$default(r116, r6, false, 2, null) == true) goto L72;
            r8 = 1;
            goto L59
        L72:
            r15.number = r113.number;     // Catch: Throwable -> L86 Exception -> L88
            goto L78
        L65:
            if (r114.length() == 0) goto L68;
            r115 = 0;
            goto L69
        L47:
            r12.close();
            return r2;
        L78:
            r15.sortkey = r12.getString(5);     // Catch: Throwable -> L86 Exception -> L88
            r15.section = ContactsUtils.getContactSection(r15.sortkey);     // Catch: Throwable -> L86 Exception -> L88
            r2.put(Long.valueOf(r15.contactId), r15);     // Catch: Throwable -> L86 Exception -> L88
            if (r12.moveToNext() == false) goto L80;
            r8 = 1;
            goto L39
        L80:
            r4 = true;
            goto L83
        L42:
            r18 = 0;
        L38:
            r6 = null;
        L29:
            r12 = null;
        L92:
            e = e;
        L90:
            th = th;
        L99:
            this.searchDurationMs = System.currentTimeMillis() - r5;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "search_message: getProviderSearchResult contactsMap =  " + r2.size());
            return r2;
        }

        public final Map<Long, SamContact> updateInAppSearchArray(List<InAppSearchEntity> r19) {
            HashMap r2 = new HashMap();
            if (r19 != null) goto L5;
        L39:
            return r2;
        L5:
            if (r19.isEmpty() == true) goto L39;
            NewContactListFragment r3 = this.this$0;
            int r5 = 0;
            ArrayList r4 = NewContactListFragment.access$getListDataBySortMode(r3, NewContactListFragment.access$getMSortMode$p(r3), false);
            if (r4 == null) goto L39;
            if (r4.isEmpty() == true) goto L39;
            int r6 = r19.size();
            int r7 = 0;
        L13:
            if (r7 >= r6) goto L39;
            InAppSearchEntity r8 = r19.get(r7);
            if (r8 == null) goto L17;
            AppEntity r9 = r8.getAppEntity();
        L19:
            if ((r9 instanceof ContactEntity) == false) goto L21;
            ContactEntity r10 = (ContactEntity) r9;
        L22:
            if (r10 == null) goto L38;
            long r11 = Long.parseLong(r10.getId());
            int r12 = r4.size();
            int r13 = r5;
        L25:
            if (r13 >= r12) goto L38;
            SamContact r14 = (SamContact) r4.get(r13);
            if (r14 != null) goto L30;
        L36:
            long r16 = r11;
        L37:
            r13 = r13 + 1;
            r11 = r16;
            goto L25
        L30:
            if (r14.contactId != r11) goto L36;
            SamContact r15 = new SamContact(r14.getType());
            r15.contactId = r11;
            String r17 = r10.getName();
            r15.name = ContactsUtils.getContactName(this.this$0.getActivity(), r17);
            r15.hasname = !TextUtils.isEmpty(r17);
            r15.LookKey = r14.LookKey;
            r16 = r11;
            r15.photoId = r14.photoId;
            r15.raw_contactid = r14.raw_contactid;
            InAppSearchEntity r18 = r19.get(r7);
            List<MetaTelephone> r20 = r10.getTelephones();
            if (r20 == null) goto L34;
            List r21 = CollectionsKt.toMutableList(r20);
        L35:
            r15.number = SearchUtils.getPhoneNumberBySearch(r18, r21);
            r15.sortkey = r14.sortkey;
            r15.section = ContactsUtils.getContactSection(r15.sortkey);
            r2.put(Long.valueOf(r16), r15);
            goto L37
        L34:
            r21 = null;
        L38:
            r7 = r7 + 1;
            r5 = 0;
            goto L13
        L21:
            r10 = null;
            goto L22
        L17:
            r9 = null;
            goto L19
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\b\u0082\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u0012\u0012\u0004\u0012\u0002H\u00010\u0002j\b\u0012\u0004\u0012\u0002H\u0001`\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0018\u0010\t\u001a\u00020\u00062\u000e\u0010\n\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000bH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\u0015\u0010\u000e\u001a\u00020\u00062\u0006\u0010\u000f\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\bJ\u0016\u0010\u0010\u001a\u00020\u00062\f\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000bH\u0016¨\u0006\u0011"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$SelectionSet;", ExifInterface.GPS_DIRECTION_TRUE, "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "(Lcom/android/contacts/list/NewContactListFragment;)V", "add", "", "e", "(Ljava/lang/Object;)Z", "addAll", "c", "", "clear", "", "remove", "o", "removeAll", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class SelectionSet<T> extends HashSet<T> {
        final /* synthetic */ NewContactListFragment this$0;

        public SelectionSet(NewContactListFragment r1) {
            this.this$0 = r1;
        }

        public /* bridge */ int getSize() {
            return super.size();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public final /* bridge */ int size() {
            return getSize();
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(T r2) {
            boolean r3 = super.add(r2);
            if (r3 == false) goto L5;
            NewContactListFragment.access$refreshOptionBar(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object r2) {
            boolean r3 = super.remove(r2);
            if (r3 == false) goto L5;
            NewContactListFragment.access$refreshOptionBar(this.this$0, size());
        L5:
            return r3;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean addAll(Collection<? extends T> r2) {
            Intrinsics.checkNotNullParameter(r2, "c");
            boolean r3 = super.addAll(r2);
            if (r3 == false) goto L5;
            NewContactListFragment.access$refreshOptionBar(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection<? extends Object> r2) {
            Intrinsics.checkNotNullParameter(r2, "c");
            boolean r3 = super.removeAll(r2);
            if (r3 == false) goto L5;
            NewContactListFragment.access$refreshOptionBar(this.this$0, size());
        L5:
            return r3;
        }

        @Override // java.util.HashSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            super.clear();
            NewContactListFragment.access$refreshOptionBar(this.this$0, size());
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\u0006\u001a\u00020\u0007H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$ShowResultThread;", "Ljava/lang/Runnable;", "mContactlist", "", "Lbytedanceos/app/voiceassistant/ContactStruct;", "(Lcom/android/contacts/list/NewContactListFragment;Ljava/util/List;)V", "run", "", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private final class ShowResultThread implements Runnable {
        private final List<ContactStruct> mContactlist;
        final /* synthetic */ NewContactListFragment this$0;

        public ShowResultThread(NewContactListFragment r2, List<ContactStruct> r3) {
            Intrinsics.checkNotNullParameter(r3, "mContactlist");
            this.this$0 = r2;
            this.mContactlist = r3;
        }

        @Override // java.lang.Runnable
        public void run() {
            FragmentActivity r0 = this.this$0.getActivity();
            if (r0 != null) goto L5;
        L7:
            boolean r1 = false;
        L8:
            if (r1 == false) goto L11;
            return;
        L11:
            if (ContactsUtils.DEBUG == false) goto L13;
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "searchResult size  " + this.mContactlist.size());
        L13:
            LinkedHashMap<Long, LinkedHashSet<ContactStruct>> r2 = new LinkedHashMap();
            ArrayList<ContactStruct> r3 = new ArrayList();
            ArrayList<Long> r4 = new ArrayList();
            int r5 = this.mContactlist.size();
            if (r5 != 1) goto L16;
            LinkedHashSet<ContactStruct> r6 = new LinkedHashSet();
            r6.add(this.mContactlist.get(0));
            r2.put(Long.valueOf(this.mContactlist.get(0).contactId), r6);
            r4.add(Long.valueOf(this.mContactlist.get(0).contactId));
            r3.add(this.mContactlist.get(0));
        L53:
            VoiceSearchResultAdapter r7 = new VoiceSearchResultAdapter(this.this$0.getActivity());
            r7.setList(r2, r3, r4);
            AnimationUtil.stopRecordWithAnimation(NewContactListFragment.access$getMWave$p(this.this$0));
            if (NewContactListFragment.access$getMCoverDismiss$p(this.this$0) == false) goto L56;
            return;
        L56:
            if (NewContactListFragment.access$getMStartedRecongnize$p(this.this$0) == true) goto L59;
            return;
        L59:
            if (r5 != 0) goto L61;
            AnimationUtil.showCoverWithAnimation(NewContactListFragment.access$getMCover$p(this.this$0), null);
            AnimationUtil.showResultDialogWithAnim(NewContactListFragment.access$getMEmptyResultDialog$p(this.this$0));
        L66:
            NewContactListFragment.access$setMStartedRecongnize$p(this.this$0, false);
            return;
        L61:
            NewContactListFragment.access$setMHasResult$p(this.this$0, true);
            ViewGroup r8 = NewContactListFragment.access$getMSearchResultDialog$p(this.this$0);
            if (r8 == null) goto L64;
            View r9 = r8.findViewById(R.id.result_list_view);
        L65:
            Intrinsics.checkNotNull(r9, "null cannot be cast to non-null type android.widget.ListView");
            ((ListView) r9).setAdapter(r7);
            AnimationUtil.showCoverWithAnimation(NewContactListFragment.access$getMCover$p(this.this$0), null);
            AnimationUtil.showResultDialogWithAnim(NewContactListFragment.access$getMSearchResultDialog$p(this.this$0));
            goto L66
        L64:
            r9 = null;
            goto L65
        L16:
            int r10 = 0;
        L17:
            if (r10 >= r5) goto L49;
            ContactStruct r11 = this.mContactlist.get(r10);
            if (r10 != 0) goto L24;
            LinkedHashSet<ContactStruct> r12 = new LinkedHashSet();
            r12.add(r11);
            r2.put(Long.valueOf(r11.contactId), r12);
            if (r3.contains(r11) == true) goto L48;
            r3.add(r11);
        L48:
            r10 = r10 + 1;
            goto L17
        L24:
            if (r10 != (r5 - 1)) goto L35;
            if (r11.contactId != this.mContactlist.get(r10 - 1).contactId) goto L31;
            LinkedHashSet<ContactStruct> r13 = r2.get(Long.valueOf(r11.contactId));
            if (r13 == null) goto L30;
            r13.add(r11);
        L30:
            r2.put(Long.valueOf(r11.contactId), r13);
            goto L48
        L31:
            LinkedHashSet<ContactStruct> r14 = new LinkedHashSet();
            r14.add(r11);
            r2.put(Long.valueOf(r11.contactId), r14);
            if (r3.contains(r11) == true) goto L48;
            r3.add(r11);
            goto L48
        L35:
            if (r11.contactId != this.mContactlist.get(r10 - 1).contactId) goto L37;
        L42:
            LinkedHashSet<ContactStruct> r15 = r2.get(Long.valueOf(r11.contactId));
            if (r15 != null) goto L47;
            r15 = new LinkedHashSet();
            if (r3.contains(r11) == true) goto L47;
            r3.add(r11);
        L47:
            r15.add(r11);
            r2.put(Long.valueOf(r11.contactId), r15);
            goto L48
        L37:
            if (r11.contactId == this.mContactlist.get(r10 + 1).contactId) goto L42;
            LinkedHashSet<ContactStruct> r16 = new LinkedHashSet();
            r16.add(r11);
            r2.put(Long.valueOf(r11.contactId), r16);
            if (r3.contains(r11) == true) goto L48;
            r3.add(r11);
            goto L48
        L49:
            Iterator<Long> r17 = r2.keySet().iterator();
        L51:
            if (r17.hasNext() == false) goto L53;
            r4.add(r17.next());
            goto L51
        L5:
            if (r0.isFinishing() != true) goto L7;
            r1 = true;
            goto L8
        }
    }

    /* JADX INFO: compiled from: NewContactListFragment.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u0004H\u0016J\u0012\u0010\u000b\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/android/contacts/list/NewContactListFragment$VoiceServiceConnection;", "Landroid/content/ServiceConnection;", "(Lcom/android/contacts/list/NewContactListFragment;)V", "mService", "Landroid/os/IBinder;", "clear", "", "onServiceConnected", "name", "Landroid/content/ComponentName;", "service", "onServiceDisconnected", "app_QssiCnRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public final class VoiceServiceConnection implements ServiceConnection {
        private IBinder mService;
        final /* synthetic */ NewContactListFragment this$0;

        public VoiceServiceConnection(NewContactListFragment r1) {
            this.this$0 = r1;
        }

        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName r2, IBinder r3) {
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "mVoiceAssistantServiceConnection is binder");
            this.mService = r3;
            this.this$0.setMVoiceInterface(IVoiceAssistantService.Stub.asInterface(r3));
            if (r3 == null) goto L6;
            r3.linkToDeath(this.this$0, 0);     // Catch: RemoteException -> L16
        L16:
            e = move-exception;
            e.printStackTrace();
            return;
        L6:
            if (this.this$0.getMVoiceInterface() == null) goto L14;
            IVoiceAssistantService r4 = this.this$0.getMVoiceInterface();     // Catch: RemoteException -> L16
            if (r4 == null) goto L14;
            IVoiceAssistantCallback r5 = NewContactListFragment.access$getMCallback$p(this.this$0);     // Catch: RemoteException -> L16
            Context r0 = NewContactListFragment.access$getMContext$p(this.this$0);     // Catch: RemoteException -> L16
            if (r0 == null) goto L12;
            String r1 = r0.getPackageName();     // Catch: RemoteException -> L16
        L13:
            r4.registerCallback(r5, r1);     // Catch: RemoteException -> L16
            goto L14
        L12:
            r1 = null;
        L14:
            NewContactListFragment.access$setMVoiceSearchConnected$p(this.this$0, true);     // Catch: RemoteException -> L16
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName r1) {
            clear();
        }

        public final void clear() {
            if (this.this$0.getMVoiceInterface() != null) goto L18;
        L12:
            NewContactListFragment.access$setMVoiceSearchConnected$p(this.this$0, false);
            return;
        L18:
            IBinder r0 = this.mService;     // Catch: Exception -> L14
            if (r0 == null) goto L16;
            if (r0 == null) goto L16;
            r0.unlinkToDeath(this.this$0, 0);     // Catch: Exception -> L14
        L16:
            IVoiceAssistantService r1 = this.this$0.getMVoiceInterface();     // Catch: Exception -> L15
            if (r1 == null) goto L11;
            r1.unregisterCallback(NewContactListFragment.access$getMCallback$p(this.this$0));     // Catch: Exception -> L15
        L11:
            GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(NewContactListFragment.TAG, "mVoiceAssistantServiceConnection is binder onServiceDisconnected");
            this.this$0.setMVoiceInterface(null);
            goto L12
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$0N-8_0Qg5XcL2VBIgeyaJu15Jfg, reason: not valid java name */
    public static /* synthetic */ boolean m203$r8$lambda$0N8_0Qg5XcL2VBIgeyaJu15Jfg(NewContactListFragment r0, ForceTouchController r1, View r2, MotionEvent r3) {
        return createCloseSwipeTouchListener$lambda$3(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$8mQ6TWseo0VjAvoPuseQuPChAmI(NewContactListFragment r0) {
        mTouchMonitorListener$lambda$24(r0);
    }

    public static /* synthetic */ void $r8$lambda$AzyaB47hBJbJ8MTFRJDdJdOjt80(NewContactListFragment r0) {
        mTouchMonitorListenerForExpandable$lambda$26(r0);
    }

    public static /* synthetic */ void $r8$lambda$IU0SgzEe18Sz36OJZbfxkt0KVFQ(NewContactListFragment r0, View r1) {
        setEmptyView$lambda$0(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$JAOEO6CgoxNXJT2Q6pLPJ8GM6E4(NewContactListFragment r0, ViewGroup r1, int r2) {
        inflateAndSetupView$lambda$17$lambda$16(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$N1rCDScqdObMVj2fzG2IIC4J0d4(OEditText r0) {
        onEnterSearchAnimEnd$lambda$58$lambda$57(r0);
    }

    public static /* synthetic */ void $r8$lambda$NLU4m8LrjWLD5gZt23JEQAz689A(Ref.ObjectRef r0, NewContactListFragment r1, String r2, View r3) {
        showImportContactsInEmptyDialog$lambda$49$lambda$48(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$PqMhd9KbT1Ekl0bfcgL1J8X-j08, reason: not valid java name */
    public static /* synthetic */ void m204$r8$lambda$PqMhd9KbT1Ekl0bfcgL1J8Xj08(NewContactListFragment r0, View r1) {
        inflateAndSetupView$lambda$6(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$SXl3wOWAZJRS43Qz1tEiUEqpYCY(NewContactListFragment r0, View r1) {
        initGroupView$lambda$28(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$ULeTO0Bcxhd2mvPqOpTh-X0-OmQ, reason: not valid java name */
    public static /* synthetic */ void m205$r8$lambda$ULeTO0Bcxhd2mvPqOpThX0OmQ(NewContactListFragment r0, int r1, DialogInterface r2, int r3) {
        showDeleteContactsDialog$lambda$46(r0, r1, r2, r3);
    }

    /* JADX INFO: renamed from: $r8$lambda$X5-J6itAS-EKEPhnjyvakKvIZ2Q, reason: not valid java name */
    public static /* synthetic */ boolean m206$r8$lambda$X5J6itASEKEPhnjyvakKvIZ2Q(NewContactListFragment r0, AdapterView r1, View r2, int r3, long r4, int r6, int r7) {
        return mItemLongClickedListener$lambda$25(r0, r1, r2, r3, r4, r6, r7);
    }

    public static /* synthetic */ void $r8$lambda$XoGK0L99yheSYJKCpryd1GW5rDw(NewContactListFragment r0) {
        mVoiceUiRunnable$lambda$18(r0);
    }

    public static /* synthetic */ void $r8$lambda$_UAK3fkTmqmzomiVLKKPtg4CoX8(NewContactListFragment r0, int r1, DialogInterface r2, int r3) {
        showDeleteContactsDialog$lambda$47(r0, r1, r2, r3);
    }

    public static /* synthetic */ void $r8$lambda$aEa_Pgoc2EGXXqEl5xeqYUxJYPU(NewContactListFragment r0, View r1) {
        initGroupView$lambda$32(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$aexz2oNMfa9N9BJ4EU6FITDAHuY(NewContactListFragment r0, List r1, View r2) {
        initGroupView$lambda$30(r0, r1, r2);
    }

    /* JADX INFO: renamed from: $r8$lambda$c-WCd14l1zoANqw5FhwQ8ySDaWE, reason: not valid java name */
    public static /* synthetic */ void m207$r8$lambda$cWCd14l1zoANqw5FhwQ8ySDaWE(long r0, NewContactListFragment r2) {
        startContactAnimationIView$lambda$50(r0, r2);
    }

    public static /* synthetic */ void $r8$lambda$epzFlg4QGVIJSR_KarPTsQzUH4c(NewContactListFragment r0) {
        mStartRecord$lambda$22(r0);
    }

    public static /* synthetic */ void $r8$lambda$jaLJ0w5P3oo9wgzWHzD6uLxkacA(View r0) {
        inflateAndSetupView$lambda$10(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$kBrc_xzrmzWM34elW5X-1PYmwDg, reason: not valid java name */
    public static /* synthetic */ void m208$r8$lambda$kBrc_xzrmzWM34elW5X1PYmwDg(NewContactListFragment r0, View r1) {
        inflateAndSetupView$lambda$9$lambda$7(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$krGKTsww3EaZ9vxoYnpdrqQMS9M(NewContactListFragment r0) {
        mRefreshProfileRunnable$lambda$36(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$olX3Z38z6-mV4twkGHtl8Y-_2kk, reason: not valid java name */
    public static /* synthetic */ void m209$r8$lambda$olX3Z38z6mV4twkGHtl8Y_2kk(NewContactListFragment r0) {
        mTimeoutThread$lambda$23(r0);
    }

    public static /* synthetic */ void $r8$lambda$t5nC72ySCzCHJLxLMdgdITXL9oI(NewContactListFragment r0) {
        onResume$lambda$41(r0);
    }

    public static /* synthetic */ void $r8$lambda$vff72P0QnmHCTYUkZ0FoQEdaCNU(NewContactListFragment r0) {
        handleActionMove$lambda$21(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$wKxAorTxKkBxtFvQ1b37aktohhE(NewContactListFragment r0, View r1, MotionEvent r2) {
        return inflateAndSetupView$lambda$15(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$xfH4E11c4a_9F3_ziwDH4acwdkA(NewContactListFragment r0, View r1) {
        inflateAndSetupView$lambda$11(r0, r1);
    }

    /* JADX INFO: renamed from: $r8$lambda$yEOTMIO-ZRpr5jrZIBoA2hLlr78, reason: not valid java name */
    public static /* synthetic */ void m210$r8$lambda$yEOTMIOZRpr5jrZIBoA2hLlr78(NewContactListFragment r0, View r1) {
        setEmptyView$lambda$2(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$yaxjz5gmIP_t8GR_VQFl9hmpeB8(NewContactListFragment r0, View r1, boolean r2) {
        inflateAndSetupView$lambda$14(r0, r1, r2);
    }

    public static /* synthetic */ void $r8$lambda$z1P_4S8xtKRtR3x2SDjtjPFbWuA(NewContactListFragment r0, View r1) {
        inflateAndSetupView$lambda$5$lambda$4(r0, r1);
    }

    private static final void inflateAndSetupView$lambda$10(View r0) {
    }

    @JvmStatic
    public static final synchronized void preload(Context r2) {
        monitor-enter(NewContactListFragment.class);
        Companion.preload(r2);     // Catch: Throwable -> L7
        monitor-exit(NewContactListFragment.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public final void groupSaveCompleted() {
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountSelectorCancelled() {
    }

    public final void onBackPressed() {
    }

    @Override // android.view.View.OnFocusChangeListener
    public void onFocusChange(View r1, boolean r2) {
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onModeWillChangeIView() {
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScroll(AbsListView r1, int r2, int r3, int r4) {
    }

    /* JADX WARN: Type inference failed for: r1v37, types: [com.android.contacts.list.NewContactListFragment$contactListViewClickListener$1] */
    /* JADX WARN: Type inference failed for: r1v38, types: [com.android.contacts.list.NewContactListFragment$contactSearchListViewClickListener$1] */
    public NewContactListFragment() {
        this.mOutSize = new Point();
        this.mDuration = 200;
        this.mMayDeletedPosition = -1;
        this.mLazyLoadFirstStart = true;
        this.scrollFpsMonitor = ContactsFpsMonitorFactory.INSTANCE.create(ContactsFpsScenes.CONTACT_LIST_SCROLL);
        this.isEnableSelectContacts = true;
        this.mHandler = new NewContactListFragment$mHandler$1(this, Looper.getMainLooper());
        this.mInContacts = true;
        this.mLetter = "m";
        ExecutorService r1 = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(r1, "newSingleThreadExecutor()");
        this.mPool = r1;
        this.mQuickBarState = 1;
        this.mSelectedSet = new SelectionSet(this);
        this.mContactsIdList = new HashSet();
        this.mContactsIdSIM1 = new HashSet();
        this.mContactsIdSIM2 = new HashSet();
        this.mPhoneContactsIdList = new HashSet();
        this.mContactsIdBCR = new HashSet();
        this.mContactsIdForLocation = new HashSet();
        this.mVoiceUiRunnable = new NewContactListFragment$$ExternalSyntheticLambda6(this);
        this.mCoverAnimationTracker = new NewContactListFragment$mCoverAnimationTracker$1(this);
        this.mStartRecord = new NewContactListFragment$$ExternalSyntheticLambda7(this);
        this.mTimeoutThread = new NewContactListFragment$$ExternalSyntheticLambda8(this);
        this.mQBListener = new NewContactListFragment$mQBListener$1(this);
        this.mVoiceBtnCallBack = new NewContactListFragment$mVoiceBtnCallBack$1(this);
        this.mSurnameListener = new NewContactListFragment$mSurnameListener$1(this);
        this.mSlideListener = new NewContactListFragment$mSlideListener$1(this);
        this.mSlideListenerForExpandable = new NewContactListFragment$mSlideListenerForExpandable$1(this);
        this.mTouchMonitorListener = new NewContactListFragment$$ExternalSyntheticLambda9(this);
        this.mItemLongClickedListener = new NewContactListFragment$$ExternalSyntheticLambda10(this);
        this.mExpandableListItemLongClickedListener = new NewContactListFragment$mExpandableListItemLongClickedListener$1(this);
        this.mTouchMonitorListenerForExpandable = new NewContactListFragment$$ExternalSyntheticLambda12(this);
        this.mIccStateListener = new NewContactListFragment$mIccStateListener$1(this);
        this.mRefreshProfileRunnable = new NewContactListFragment$$ExternalSyntheticLambda13(this);
        this.TIME_NEED_TO_TIP = 200;
        this.mCityPinYinMap = new HashMap();
        this.contactListViewClickListener = new NewContactListFragment$contactListViewClickListener$1(this);
        this.contactSearchListViewClickListener = new NewContactListFragment$contactSearchListViewClickListener$1(this);
        this.mContactsListAnimator = new ListAnimator(new int[]{R.id.title_container, R.id.common_item_center_layout}, new int[]{R.id.sim_id_icon}, new int[]{R.id.custom_start_container});
        this.mScrollIdle = new NewContactListFragment$mScrollIdle$1(this);
        this.curContactsMap = new HashMap();
        this.mInAppSearchResultList = new ArrayList();
        this.mSearchKeyList = new HashMap();
        this.mIntentsSearchResultList = new ArrayList();
        this.mVoiceAssistantServiceConnection = new VoiceServiceConnection(this);
        this.mCallback = new NewContactListFragment$mCallback$1(this);
        this.mProviderIsNormal = true;
        this.mlistener = new NewContactListFragment$mlistener$1();
        this.mContactsSelectionListener = new NewContactListFragment$mContactsSelectionListener$1(this);
        this.mExpandGroups = new HashMap();
        this.mGroupExpandListener = new NewContactListFragment$mGroupExpandListener$1(this);
        this.mGroupCollapseListener = new NewContactListFragment$mGroupCollapseListener$1(this);
    }

    public static final /* synthetic */ void access$clearModeState(NewContactListFragment r0) {
        r0.clearModeState();
    }

    public static final /* synthetic */ View.OnTouchListener access$createCloseSwipeTouchListener(NewContactListFragment r0, ForceTouchController r1) {
        return r0.createCloseSwipeTouchListener(r1);
    }

    public static final /* synthetic */ void access$deleteContacts(NewContactListFragment r0, boolean r1) {
        r0.deleteContacts(r1);
    }

    public static final /* synthetic */ void access$dismissCloseVoiceDialog(NewContactListFragment r0) {
        r0.dismissCloseVoiceDialog();
    }

    public static final /* synthetic */ void access$dismissWave(NewContactListFragment r0) {
        r0.dismissWave();
    }

    public static final /* synthetic */ void access$expandSearchResultViewForSearchTranslation(NewContactListFragment r0) {
        r0.expandSearchResultViewForSearchTranslation();
    }

    public static final /* synthetic */ AsyncImageLoader access$getAsyncImageLoader(NewContactListFragment r0) {
        return r0.getAsyncImageLoader();
    }

    public static final /* synthetic */ String access$getCONTACT_CITY_QUERY$cp() {
        return CONTACT_CITY_QUERY;
    }

    public static final /* synthetic */ String access$getCONTACT_EXCLUDE_SIM_ACCOUNT_QUERY$cp() {
        return CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY;
    }

    public static final /* synthetic */ String access$getCONTACT_QUERY$cp() {
        return CONTACT_QUERY;
    }

    public static final /* synthetic */ String access$getCONTACT_SEARCH_SORT$cp() {
        return CONTACT_SEARCH_SORT;
    }

    public static final /* synthetic */ NewContactListFragment$contactListViewClickListener$1 access$getContactListViewClickListener$p(NewContactListFragment r0) {
        return r0.contactListViewClickListener;
    }

    public static final /* synthetic */ String[] access$getContactProjection(NewContactListFragment r0) {
        return r0.getContactProjection();
    }

    public static final /* synthetic */ boolean access$getDEBUG$p(NewContactListFragment r0) {
        return r0.DEBUG;
    }

    public static final /* synthetic */ ArrayList access$getListDataBySortMode(NewContactListFragment r0, int r1, boolean r2) {
        return r0.getListDataBySortMode(r1, r2);
    }

    public static final /* synthetic */ FragmentActivity access$getMActivity$p(NewContactListFragment r0) {
        return r0.mActivity;
    }

    public static final /* synthetic */ BottomDeleteLayoutListener access$getMBottomDeleteLayoutListener$p(NewContactListFragment r0) {
        return r0.mBottomDeleteLayoutListener;
    }

    public static final /* synthetic */ OButton access$getMBtnGroupLeft$p(NewContactListFragment r0) {
        return r0.mBtnGroupLeft;
    }

    public static final /* synthetic */ OButton access$getMBtnGroupMenu$p(NewContactListFragment r0) {
        return r0.mBtnGroupMenu;
    }

    public static final /* synthetic */ OButton access$getMBtnGroupRightDelete$p(NewContactListFragment r0) {
        return r0.mBtnGroupRightDelete;
    }

    public static final /* synthetic */ IVoiceAssistantCallback access$getMCallback$p(NewContactListFragment r0) {
        return r0.mCallback;
    }

    public static final /* synthetic */ boolean access$getMCancelRecognizeByTooShortTime$p(NewContactListFragment r0) {
        return r0.mCancelRecognizeByTooShortTime;
    }

    public static final /* synthetic */ QuickContactExpandableListView access$getMCityListView$p(NewContactListFragment r0) {
        return r0.mCityListView;
    }

    public static final /* synthetic */ FrameLayout access$getMCityListViewFrame$p(NewContactListFragment r0) {
        return r0.mCityListViewFrame;
    }

    public static final /* synthetic */ AlertDialog access$getMCloseVoiceDialog$p(NewContactListFragment r0) {
        return r0.mCloseVoiceDialog;
    }

    public static final /* synthetic */ ContactListFilterController access$getMContactListFilterController$p(NewContactListFragment r0) {
        return r0.mContactListFilterController;
    }

    public static final /* synthetic */ HeadersListView access$getMContactListView$p(NewContactListFragment r0) {
        return r0.mContactListView;
    }

    public static final /* synthetic */ RelativeLayout access$getMContactsEmptyView$p(NewContactListFragment r0) {
        return r0.mContactsEmptyView;
    }

    public static final /* synthetic */ View access$getMContactsFragment$p(NewContactListFragment r0) {
        return r0.mContactsFragment;
    }

    public static final /* synthetic */ OPageStatus access$getMContactsListEmptyView$p(NewContactListFragment r0) {
        return r0.mContactsListEmptyView;
    }

    public static final /* synthetic */ ContactsSelectionListener access$getMContactsSelectionListener$p(NewContactListFragment r0) {
        return r0.mContactsSelectionListener;
    }

    public static final /* synthetic */ Context access$getMContext$p(NewContactListFragment r0) {
        return r0.mContext;
    }

    public static final /* synthetic */ View access$getMCover$p(NewContactListFragment r0) {
        return r0.mCover;
    }

    public static final /* synthetic */ boolean access$getMCoverDismiss$p(NewContactListFragment r0) {
        return r0.mCoverDismiss;
    }

    public static final /* synthetic */ boolean access$getMDataIsReady$p(NewContactListFragment r0) {
        return r0.mDataIsReady;
    }

    public static final /* synthetic */ ViewGroup access$getMEmptyResultDialog$p(NewContactListFragment r0) {
        return r0.mEmptyResultDialog;
    }

    public static final /* synthetic */ OPageStatus access$getMEmptyView$p(NewContactListFragment r0) {
        return r0.mEmptyView;
    }

    public static final /* synthetic */ HashMap access$getMExpandGroups$p(NewContactListFragment r0) {
        return r0.mExpandGroups;
    }

    public static final /* synthetic */ ForceTouchController access$getMForceTouchController$p(NewContactListFragment r0) {
        return r0.mForceTouchController;
    }

    public static final /* synthetic */ ContactFragmentsCallback access$getMFragmentsCallback$p(NewContactListFragment r0) {
        return r0.mFragmentsCallback;
    }

    public static final /* synthetic */ boolean access$getMFrequentContacts$p(NewContactListFragment r0) {
        return r0.mFrequentContacts;
    }

    public static final /* synthetic */ GroupBrowseListFragment access$getMGroupBrowseListFragment$p(NewContactListFragment r0) {
        return r0.mGroupBrowseListFragment;
    }

    public static final /* synthetic */ SelectAllState access$getMGroupSelectAllBtn$p(NewContactListFragment r0) {
        return r0.mGroupSelectAllBtn;
    }

    public static final /* synthetic */ boolean access$getMHasOccupied$p(NewContactListFragment r0) {
        return r0.mHasOccupied;
    }

    public static final /* synthetic */ boolean access$getMHasQuickBar$p(NewContactListFragment r0) {
        return r0.mHasQuickBar;
    }

    public static final /* synthetic */ boolean access$getMIsDeletingContacts$p(NewContactListFragment r0) {
        return r0.mIsDeletingContacts;
    }

    public static final /* synthetic */ boolean access$getMIsEdit$p(NewContactListFragment r0) {
        return r0.mIsEdit;
    }

    public static final /* synthetic */ boolean access$getMIsHasPhoneNum$p(NewContactListFragment r0) {
        return r0.mIsHasPhoneNum;
    }

    public static final /* synthetic */ HorizontalScrollListView.ItemLongClickedListener access$getMItemLongClickedListener$p(NewContactListFragment r0) {
        return r0.mItemLongClickedListener;
    }

    public static final /* synthetic */ String access$getMLastRenderedSearchKey$p(NewContactListFragment r0) {
        return r0.mLastRenderedSearchKey;
    }

    public static final /* synthetic */ long access$getMLastStartTime$p(NewContactListFragment r2) {
        return r2.mLastStartTime;
    }

    public static final /* synthetic */ ContactsListSortByNameAdapter access$getMNorAdapter$p(NewContactListFragment r0) {
        return r0.mNorAdapter;
    }

    public static final /* synthetic */ OCTitleBar access$getMOGroupTitleBar$p(NewContactListFragment r0) {
        return r0.mOGroupTitleBar;
    }

    public static final /* synthetic */ AlertDialog access$getMOccupiedDialog$p(NewContactListFragment r0) {
        return r0.mOccupiedDialog;
    }

    public static final /* synthetic */ ArrayList access$getMOldContacts$p(NewContactListFragment r0) {
        return r0.mOldContacts;
    }

    public static final /* synthetic */ ContactsListSortByNameAdapter access$getMPhoneContactsAdapter$p(NewContactListFragment r0) {
        return r0.mPhoneContactsAdapter;
    }

    public static final /* synthetic */ ContactPhotoManager access$getMPhotoManager$p(NewContactListFragment r0) {
        return r0.mPhotoManager;
    }

    public static final /* synthetic */ OPopover access$getMPopover$p(NewContactListFragment r0) {
        return r0.mPopover;
    }

    public static final /* synthetic */ boolean access$getMProviderIsNormal$p(NewContactListFragment r0) {
        return r0.mProviderIsNormal;
    }

    public static final /* synthetic */ OIndexScrollbar access$getMQuickBar$p(NewContactListFragment r0) {
        return r0.mQuickBar;
    }

    public static final /* synthetic */ int access$getMQuickBarState$p(NewContactListFragment r0) {
        return r0.mQuickBarState;
    }

    public static final /* synthetic */ Runnable access$getMRefreshProfileRunnable$p(NewContactListFragment r0) {
        return r0.mRefreshProfileRunnable;
    }

    public static final /* synthetic */ boolean access$getMResetContactListView$p(NewContactListFragment r0) {
        return r0.mResetContactListView;
    }

    public static final /* synthetic */ long access$getMSearchAnimationGeneration$p(NewContactListFragment r2) {
        return r2.mSearchAnimationGeneration;
    }

    public static final /* synthetic */ ViewGroup access$getMSearchContainer$p(NewContactListFragment r0) {
        return r0.mSearchContainer;
    }

    public static final /* synthetic */ ForceTouchController access$getMSearchController$p(NewContactListFragment r0) {
        return r0.mSearchController;
    }

    public static final /* synthetic */ String access$getMSearchKey$p(NewContactListFragment r0) {
        return r0.mSearchKey;
    }

    public static final /* synthetic */ Map access$getMSearchKeyList$p(NewContactListFragment r0) {
        return r0.mSearchKeyList;
    }

    public static final /* synthetic */ SearchResultAdapter access$getMSearchResultAdapter$p(NewContactListFragment r0) {
        return r0.mSearchResultAdapter;
    }

    public static final /* synthetic */ ViewGroup access$getMSearchResultDialog$p(NewContactListFragment r0) {
        return r0.mSearchResultDialog;
    }

    public static final /* synthetic */ QuickContactListView access$getMSearchResultList$p(NewContactListFragment r0) {
        return r0.mSearchResultList;
    }

    public static final /* synthetic */ SelectionSet access$getMSelectedSet$p(NewContactListFragment r0) {
        return r0.mSelectedSet;
    }

    public static final /* synthetic */ ShowResultThread access$getMShowResultThread$p(NewContactListFragment r0) {
        return r0.mShowResultThread;
    }

    public static final /* synthetic */ int access$getMSortMode$p(NewContactListFragment r0) {
        return r0.mSortMode;
    }

    public static final /* synthetic */ Runnable access$getMStartRecord$p(NewContactListFragment r0) {
        return r0.mStartRecord;
    }

    public static final /* synthetic */ boolean access$getMStartedRecongnize$p(NewContactListFragment r0) {
        return r0.mStartedRecongnize;
    }

    public static final /* synthetic */ Runnable access$getMTimeoutThread$p(NewContactListFragment r0) {
        return r0.mTimeoutThread;
    }

    public static final /* synthetic */ Vibrator access$getMVibrator$p(NewContactListFragment r0) {
        return r0.mVibrator;
    }

    public static final /* synthetic */ boolean access$getMVisible$p(NewContactListFragment r0) {
        return r0.mVisible;
    }

    public static final /* synthetic */ ContactsListBaseAdapter.VoiceBtnCallBack access$getMVoiceBtnCallBack$p(NewContactListFragment r0) {
        return r0.mVoiceBtnCallBack;
    }

    public static final /* synthetic */ Runnable access$getMVoiceUiRunnable$p(NewContactListFragment r0) {
        return r0.mVoiceUiRunnable;
    }

    public static final /* synthetic */ View access$getMWave$p(NewContactListFragment r0) {
        return r0.mWave;
    }

    public static final /* synthetic */ String access$getNO_ACCOUNTS_SELECTION$cp() {
        return NO_ACCOUNTS_SELECTION;
    }

    public static final /* synthetic */ SearchSwitchAnimHelper access$getOrCreateSearchAnimHelper(NewContactListFragment r0) {
        return r0.getOrCreateSearchAnimHelper();
    }

    public static final /* synthetic */ String access$getPinYinCityName(NewContactListFragment r0, String r1) {
        return r0.getPinYinCityName(r1);
    }

    public static final /* synthetic */ IContactSearchBarPresenter access$getPresenter(NewContactListFragment r0) {
        return r0.getPresenter();
    }

    public static final /* synthetic */ NewContactListFragment access$getSPerLoadMe$cp() {
        return sPerLoadMe;
    }

    public static final /* synthetic */ boolean access$getSVoiceEnabled$cp() {
        return sVoiceEnabled;
    }

    public static final /* synthetic */ ArrayList access$getSearchMergeList(NewContactListFragment r0, Map r1) {
        return r0.getSearchMergeList(r1);
    }

    public static final /* synthetic */ OButton access$getTitleBtn(NewContactListFragment r0, int r1, boolean r2, OCTitleBar r3, OButton r4) {
        return r0.getTitleBtn(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$handleActionMove(NewContactListFragment r0, View r1, MotionEvent r2) {
        r0.handleActionMove(r1, r2);
    }

    public static final /* synthetic */ boolean access$handleContactEvent(NewContactListFragment r0, AdapterView r1, View r2, int r3, int r4, SamContact r5) {
        return r0.handleContactEvent(r1, r2, r3, r4, r5);
    }

    public static final /* synthetic */ void access$hideCityListView(NewContactListFragment r0) {
        r0.hideCityListView();
    }

    public static final /* synthetic */ void access$hideVoiceSearchBtn(NewContactListFragment r0) {
        r0.hideVoiceSearchBtn();
    }

    public static final /* synthetic */ void access$hideWaitTipView(NewContactListFragment r0) {
        r0.hideWaitTipView();
    }

    public static final /* synthetic */ boolean access$importContactsInEmpty(NewContactListFragment r0, int r1) {
        return r0.importContactsInEmpty(r1);
    }

    public static final /* synthetic */ void access$inflateVoiceButton(NewContactListFragment r0) {
        r0.inflateVoiceButton();
    }

    public static final /* synthetic */ void access$initData(NewContactListFragment r0, int r1, boolean r2) {
        r0.initData(r1, r2);
    }

    public static final /* synthetic */ void access$initLetter(NewContactListFragment r0, int r1) {
        r0.initLetter(r1);
    }

    public static final /* synthetic */ boolean access$isEnableSelectContacts$p(NewContactListFragment r0) {
        return r0.isEnableSelectContacts;
    }

    public static final /* synthetic */ boolean access$isResultDialogShown(NewContactListFragment r0) {
        return r0.isResultDialogShown();
    }

    public static final /* synthetic */ boolean access$isSearchAnimationing$p(NewContactListFragment r0) {
        return r0.isSearchAnimationing;
    }

    public static final /* synthetic */ void access$onAddGroupClicked(NewContactListFragment r0) {
        r0.onAddGroupClicked();
    }

    public static final /* synthetic */ void access$onEditContactClicked(NewContactListFragment r0) {
        r0.onEditContactClicked();
    }

    public static final /* synthetic */ void access$onEditGroupClicked(NewContactListFragment r0) {
        r0.onEditGroupClicked();
    }

    public static final /* synthetic */ void access$onEnterSearchAnimEnd(NewContactListFragment r0, boolean r1) {
        r0.onEnterSearchAnimEnd(r1);
    }

    public static final /* synthetic */ void access$onEnterSearchAnimFailed(NewContactListFragment r0) {
        r0.onEnterSearchAnimFailed();
    }

    public static final /* synthetic */ void access$onSettingsTitleClick(NewContactListFragment r0) {
        r0.onSettingsTitleClick();
    }

    public static final /* synthetic */ void access$preloadContactsData(NewContactListFragment r0) {
        r0.preloadContactsData();
    }

    public static final /* synthetic */ void access$processEditContacts(NewContactListFragment r0, boolean r1, boolean r2) {
        r0.processEditContacts(r1, r2);
    }

    public static final /* synthetic */ void access$processEditContacts(NewContactListFragment r0, boolean r1, boolean r2, boolean r3, boolean r4) {
        r0.processEditContacts(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$refreshBcrCount(NewContactListFragment r0) {
        r0.refreshBcrCount();
    }

    public static final /* synthetic */ void access$refreshOptionBar(NewContactListFragment r0, int r1) {
        r0.refreshOptionBar(r1);
    }

    public static final /* synthetic */ void access$refreshProfileDetailCache(NewContactListFragment r0, SamContact r1) {
        r0.refreshProfileDetailCache(r1);
    }

    public static final /* synthetic */ void access$refreshVisibleListItems(NewContactListFragment r0) {
        r0.refreshVisibleListItems();
    }

    public static final /* synthetic */ void access$searchAnimationEnd(NewContactListFragment r0) {
        r0.searchAnimationEnd();
    }

    public static final /* synthetic */ void access$setEmptyView(NewContactListFragment r0, ListView r1) {
        r0.setEmptyView(r1);
    }

    public static final /* synthetic */ void access$setEnableSelectContacts$p(NewContactListFragment r0, boolean r1) {
        r0.isEnableSelectContacts = r1;
    }

    public static final /* synthetic */ void access$setGroupEditState(NewContactListFragment r0, boolean r1) {
        r0.setGroupEditState(r1);
    }

    public static final /* synthetic */ void access$setMBlacklistHasChanged$p(NewContactListFragment r0, boolean r1) {
        r0.mBlacklistHasChanged = r1;
    }

    public static final /* synthetic */ void access$setMBtnGroupLeft$p(NewContactListFragment r0, OButton r1) {
        r0.mBtnGroupLeft = r1;
    }

    public static final /* synthetic */ void access$setMCancelRecognizeByTooShortTime$p(NewContactListFragment r0, boolean r1) {
        r0.mCancelRecognizeByTooShortTime = r1;
    }

    public static final /* synthetic */ void access$setMCoverDismiss$p(NewContactListFragment r0, boolean r1) {
        r0.mCoverDismiss = r1;
    }

    public static final /* synthetic */ void access$setMDataIsReady$p(NewContactListFragment r0, boolean r1) {
        r0.mDataIsReady = r1;
    }

    public static final /* synthetic */ void access$setMHasOccupied$p(NewContactListFragment r0, boolean r1) {
        r0.mHasOccupied = r1;
    }

    public static final /* synthetic */ void access$setMHasQuickBar$p(NewContactListFragment r0, boolean r1) {
        r0.mHasQuickBar = r1;
    }

    public static final /* synthetic */ void access$setMHasResult$p(NewContactListFragment r0, boolean r1) {
        r0.mHasResult = r1;
    }

    public static final /* synthetic */ void access$setMImportSimId$p(NewContactListFragment r0, int r1) {
        r0.mImportSimId = r1;
    }

    public static final /* synthetic */ void access$setMIsDeletingContacts$p(NewContactListFragment r0, boolean r1) {
        r0.mIsDeletingContacts = r1;
    }

    public static final /* synthetic */ void access$setMLastRenderedSearchKey$p(NewContactListFragment r0, String r1) {
        r0.mLastRenderedSearchKey = r1;
    }

    public static final /* synthetic */ void access$setMLastStartTime$p(NewContactListFragment r0, long r1) {
        r0.mLastStartTime = r1;
    }

    public static final /* synthetic */ void access$setMLetter$p(NewContactListFragment r0, String r1) {
        r0.mLetter = r1;
    }

    public static final /* synthetic */ void access$setMNorAdapter$p(NewContactListFragment r0, ContactsListSortByNameAdapter r1) {
        r0.mNorAdapter = r1;
    }

    public static final /* synthetic */ void access$setMOccupiedDialog$p(NewContactListFragment r0, AlertDialog r1) {
        r0.mOccupiedDialog = r1;
    }

    public static final /* synthetic */ void access$setMPhoneContactsAdapter$p(NewContactListFragment r0, ContactsListSortByNameAdapter r1) {
        r0.mPhoneContactsAdapter = r1;
    }

    public static final /* synthetic */ void access$setMPopover$p(NewContactListFragment r0, OPopover r1) {
        r0.mPopover = r1;
    }

    public static final /* synthetic */ void access$setMResetContactListView$p(NewContactListFragment r0, boolean r1) {
        r0.mResetContactListView = r1;
    }

    public static final /* synthetic */ void access$setMSearchKeyList$p(NewContactListFragment r0, Map r1) {
        r0.mSearchKeyList = r1;
    }

    public static final /* synthetic */ void access$setMShowResultThread$p(NewContactListFragment r0, ShowResultThread r1) {
        r0.mShowResultThread = r1;
    }

    public static final /* synthetic */ void access$setMStartedRecongnize$p(NewContactListFragment r0, boolean r1) {
        r0.mStartedRecongnize = r1;
    }

    public static final /* synthetic */ void access$setMVoiceSearchConnected$p(NewContactListFragment r0, boolean r1) {
        r0.mVoiceSearchConnected = r1;
    }

    public static final /* synthetic */ void access$setSPerLoadMe$cp(NewContactListFragment r0) {
        sPerLoadMe = r0;
    }

    public static final /* synthetic */ void access$setSVoiceEnabled$cp(boolean r0) {
        sVoiceEnabled = r0;
    }

    public static final /* synthetic */ void access$showVoiceSearchBtn(NewContactListFragment r0) {
        r0.showVoiceSearchBtn();
    }

    public static final /* synthetic */ void access$showVoiceSearchBtnDelayed(NewContactListFragment r0, long r1) {
        r0.showVoiceSearchBtnDelayed(r1);
    }

    public static final /* synthetic */ void access$showWaitTipView(NewContactListFragment r0) {
        r0.showWaitTipView();
    }

    public static final /* synthetic */ void access$startDetailActivity(NewContactListFragment r0, Uri r1, ArrayList r2, boolean r3, boolean r4) {
        r0.startDetailActivity(r1, r2, r3, r4);
    }

    public static final /* synthetic */ void access$stopRecord(NewContactListFragment r0, boolean r1) {
        r0.stopRecord(r1);
    }

    public static final /* synthetic */ void access$updateListViewConfig(NewContactListFragment r0, boolean r1, int r2) {
        r0.updateListViewConfig(r1, r2);
    }

    public final boolean isShowGroup() {
        return this.isShowGroup;
    }

    public final boolean isSearch() {
        return this.isSearch;
    }

    public final IVoiceAssistantService getMVoiceInterface() {
        return this.mVoiceInterface;
    }

    public final void setMVoiceInterface(IVoiceAssistantService r1) {
        this.mVoiceInterface = r1;
    }

    public final Handler getMHandler() {
        return this.mHandler;
    }

    public final void setMHandler(Handler r2) {
        Intrinsics.checkNotNullParameter(r2, "<set-?>");
        this.mHandler = r2;
    }

    public final void setFragmentsCallback(ContactFragmentsCallback r2) {
        Intrinsics.checkNotNullParameter(r2, "callback");
        this.mFragmentsCallback = r2;
    }

    private final void setEmptyView(ListView r9) {
        if (r9 != null) goto L5;
        return;
    L5:
        if (isAdded() == true) goto L7;
        return;
    L7:
        FragmentActivity r0 = getActivity();
        if (r0 != null) goto L11;
        return;
    L11:
        if (this.mContactsEmptyView != null) goto L13;
    L14:
        ViewStub r1 = this.mContactsEmptyViewStub;
        if (r1 == null) goto L17;
        r1.inflate();
    L17:
        View r2 = this.mContactsFragment;
        OButton r5 = null;
        if (r2 == null) goto L20;
        View r3 = r2.findViewById(R.id.contacts_empty);
    L21:
        this.mContactsEmptyView = (RelativeLayout) r3;
        View r4 = this.mContactsFragment;
        if (r4 == null) goto L24;
        View r6 = r4.findViewById(R.id.black_view);
    L25:
        OPageStatus r7 = (OPageStatus) r6;
        this.mEmptyView = r7;
        String r8 = "";
        if (r7 == null) goto L31;
        String r10 = r0.getString(R.string.no_contacts_list);
        if (r10 != null) goto L30;
        r10 = "";
    L30:
        r7.setTitle(r10);
    L31:
        OPageStatus r11 = this.mEmptyView;
        if (r11 == null) goto L34;
        OTextView r12 = r11.getTitleView();
    L35:
        this.primaryHint = r12;
        OPageStatus r13 = this.mEmptyView;
        if (r13 == null) goto L42;
        String r14 = r0.getString(R.string.business_card_hint);
        if (r14 == null) goto L41;
        r8 = r14;
    L41:
        r13.setMessage(r8);
    L42:
        OPageStatus r15 = this.mEmptyView;
        if (r15 == null) goto L45;
        OTextView r16 = r15.getMessageView();
    L46:
        OTextView r17 = r16;
        this.secondaryHint = r17;
        if (r17 == null) goto L50;
        r17.setVisibility(8);
    L50:
        OPageStatus r18 = this.mEmptyView;
        if (r18 == null) goto L53;
        r18.showButton(true);
    L53:
        OPageStatus r19 = this.mEmptyView;
        if (r19 == null) goto L56;
        r5 = r19.getButton();
    L56:
        this.mBtnImportContacts = r5;
        if (r5 == null) goto L59;
        r5.setText(R.string.common_import_contacts);
    L59:
        OButton r20 = this.mBtnImportContacts;
        if (r20 == null) goto L62;
        r20.setOnClickListener(new NewContactListFragment$$ExternalSyntheticLambda11(this));
    L62:
        OPageStatus r21 = this.mEmptyView;
        if (r21 == null) goto L65;
        this.mBtnOpenCamera = OButton.Companion.createNeutralButton(r0, r21);
    L65:
        OButton r22 = this.mBtnOpenCamera;
        if (r22 == null) goto L68;
        r22.setText(R.string.open_camera);
    L68:
        OButton r23 = this.mBtnOpenCamera;
        if (r23 == null) goto L71;
        r23.setOnClickListener(new NewContactListFragment$$ExternalSyntheticLambda20(this));
    L71:
        int r24 = this.mSortMode;
        if (r24 != 32) goto L74;
    L131:
        TextView r25 = this.primaryHint;
        if (r25 == null) goto L135;
        r25.setText(getString(R.string.no_contacts_list));
    L135:
        TextView r26 = this.secondaryHint;
        if (r26 == null) goto L139;
        r26.setVisibility(8);
    L139:
        OButton r27 = this.mBtnImportContacts;
        if (r27 == null) goto L143;
        r27.setVisibility(8);
    L143:
        OButton r28 = this.mBtnOpenCamera;
        if (r28 == null) goto L147;
        r28.setVisibility(8);
    L147:
        View r29 = r9.getEmptyView();
        RelativeLayout r30 = this.mContactsEmptyView;
        if (r29 == r30) goto L150;
        r9.setEmptyView(r30);
    L150:
        ImageButton r31 = this.mBtnVoiceSearchContacts;
        if (r31 == null) goto L155;
        if (r31 == null) goto L156;
        r31.setVisibility(8);
        return;
    L156:
        return;
    L155:
        return;
    L74:
        if (r24 == 64) goto L131;
        if (r24 != 128) goto L99;
        TextView r32 = this.primaryHint;
        if (r32 == null) goto L82;
        r32.setText(getString(R.string.no_contacts_from_bcr));
    L82:
        TextView r33 = this.secondaryHint;
        if (r33 == null) goto L86;
        r33.setVisibility(0);
    L86:
        TextView r34 = this.secondaryHint;
        if (r34 == null) goto L90;
        r34.setText(getString(R.string.business_card_hint));
    L90:
        OButton r35 = this.mBtnImportContacts;
        if (r35 == null) goto L94;
        r35.setVisibility(8);
    L94:
        OButton r36 = this.mBtnOpenCamera;
        if (r36 == null) goto L147;
        r36.setVisibility(0);
        goto L147
    L99:
        if (ContactsUtils.DEBUG == false) goto L101;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEmptyView mAllContactsSelected = " + this.mAllContactsSelected);
    L101:
        TextView r37 = this.primaryHint;
        if (r37 == null) goto L105;
        r37.setText(getString(R.string.contacts_empty));
    L105:
        TextView r38 = this.secondaryHint;
        if (r38 == null) goto L110;
        r38.setVisibility(0);
    L110:
        if (this.mAllContactsSelected == false) goto L119;
        TextView r39 = this.secondaryHint;
        if (r39 == null) goto L115;
        r39.setVisibility(8);
    L115:
        OButton r40 = this.mBtnImportContacts;
        if (r40 == null) goto L127;
        r40.setVisibility(0);
    L127:
        OButton r41 = this.mBtnOpenCamera;
        if (r41 == null) goto L147;
        r41.setVisibility(8);
        goto L147
    L119:
        TextView r42 = this.secondaryHint;
        if (r42 == null) goto L123;
        r42.setText(getString(R.string.contacts_empty_secondary_filter_contacts));
    L123:
        OButton r43 = this.mBtnImportContacts;
        if (r43 == null) goto L127;
        r43.setVisibility(8);
        goto L127
    L45:
        r16 = null;
        goto L46
    L34:
        r12 = null;
        goto L35
    L24:
        r6 = null;
        goto L25
    L20:
        r3 = null;
        goto L21
    L13:
        if (this.mEmptyView != null) goto L71;
        goto L14
    }

    private static final void setEmptyView$lambda$0(NewContactListFragment r1, View r2) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "import contacts btn clicked");
        if (ContactsUtils.isJustClicked() == true) goto L6;
        r1.showImportContactsInEmptyDialog();
        return;
    }

    private static final void setEmptyView$lambda$2(NewContactListFragment r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intent r5 = new Intent();
        r5.setComponent(new ComponentName(Constants.PACKAGE_NAME_CAMARA, "com.android.camera.FullScan"));
        r5.putExtra("contact_get_bcr", true);
        r3.startActivityForResult(r5, 22);
    }

    private final boolean isTouchOnNonDataArea(ListView r4, MotionEvent r5) {
        if (r4 != null) goto L5;
        return false;
    L5:
        int r0 = r4.pointToPosition((int) r5.getX(), (int) r5.getY());
        if (r0 == (-1)) goto L15;
        ListAdapter r1 = r4.getAdapter();
        if (r1 != null) goto L10;
    L12:
        boolean r2 = false;
    L13:
        if (r2 == false) goto L15;
        boolean r3 = true;
    L17:
        if (ListTouchHelper.isTouchOnFooterOrBlank(r4, r5) == true) goto L20;
        if (r3 == true) goto L20;
        return false;
    L20:
        return true;
    L10:
        if (r1.isEnabled(r0) == true) goto L12;
        r2 = true;
    L15:
        r3 = false;
        goto L17
    }

    private final void closeSwipedViewsForList(ListView r2) {
        HeaderViewListAdapter r1 = null;
        if (r2 == null) goto L5;
        ListAdapter r3 = r2.getAdapter();
    L7:
        if ((r3 instanceof HeaderViewListAdapter) == false) goto L9;
        r1 = (HeaderViewListAdapter) r3;
    L9:
        if (r1 == null) goto L15;
        ListAdapter r4 = r1.getWrappedAdapter();
        if (r4 == null) goto L15;
        r3 = r4;
    L15:
        if ((r3 instanceof SearchResultAdapter) == false) goto L18;
        ((SearchResultAdapter) r3).closeSwipedViews();
        return;
    L18:
        if ((r3 instanceof ContactsListSortByNameAdapter) == false) goto L22;
        ((ContactsListSortByNameAdapter) r3).closeSwipedViews();
        return;
    L22:
        return;
    L5:
        r3 = null;
        goto L7
    }

    private final View.OnTouchListener createCloseSwipeTouchListener(final ForceTouchController r2) {
        return new NewContactListFragment$$ExternalSyntheticLambda14(this, r2);
    }

    private static final boolean createCloseSwipeTouchListener$lambda$3(NewContactListFragment r2, ForceTouchController r3, View r4, MotionEvent r5) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r5.getActionMasked() == 0) goto L5;
    L11:
        if (r3 != null) goto L15;
        return false;
    L15:
        return r3.onTouch(r4, r5);
    L5:
        if ((r4 instanceof ListView) == false) goto L7;
        ListView r0 = (ListView) r4;
    L8:
        Intrinsics.checkNotNullExpressionValue(r5, "event");
        if (r2.isTouchOnNonDataArea(r0, r5) == false) goto L11;
        r2.closeSwipedViewsForList(r0);
        goto L11
    L7:
        r0 = null;
        goto L8
    }

    private final void showWaitTipView() {
        if (this.mContactsTipEmptyView != null) goto L12;
        ViewStub r0 = this.mContactsTipEmptyViewStub;
        if (r0 == null) goto L7;
        r0.inflate();
    L7:
        View r1 = this.mContactsFragment;
        if (r1 == null) goto L10;
        View r2 = r1.findViewById(R.id.contacts_tip_empty);
    L11:
        this.mContactsTipEmptyView = (RelativeLayout) r2;
        goto L12
    L10:
        r2 = null;
    L12:
        RelativeLayout r3 = this.mContactsTipEmptyView;
        if (r3 == null) goto L17;
        r3.setVisibility(0);
        return;
    }

    private final void hideWaitTipView() {
        RelativeLayout r0 = this.mContactsTipEmptyView;
        if (r0 == null) goto L16;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L17;
        RelativeLayout r2 = this.mContactsTipEmptyView;
        if (r2 == null) goto L18;
        r2.setVisibility(8);
        return;
    L18:
        return;
    L17:
        return;
    L7:
        if (r0.getVisibility() != 0) goto L9;
        r1 = true;
        goto L9
    }

    private final void updateListViewConfig(boolean r1, int r2) {
        if (r1 == true) goto L4;
        return;
    L4:
        if (this.mSearchResultList != null) goto L6;
        return;
    L6:
        if (getHost() != null) goto L9;
        return;
    L9:
        if (TextUtils.isEmpty(this.mSearchKey) == false) goto L13;
        QuickContactListView r0 = this.mSearchResultList;
        if (r0 == null) goto L19;
        r0.setDividerHeight(0);
        return;
    L19:
        return;
    L13:
        QuickContactListView r3 = this.mSearchResultList;
        if (r3 == null) goto L21;
        r3.setDividerHeight(getResources().getDimensionPixelSize(R.dimen.divider_height));
        return;
    }

    private final void hideCityListView() {
        FrameLayout r0 = this.mCityListViewFrame;
        if (r0 == null) goto L7;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        RelativeLayout r2 = this.mContactsEmptyView;
        if (r2 == null) goto L13;
        if (r2 == null) goto L14;
        r2.setVisibility(8);
        return;
    L14:
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public OSearchBar getSearchBar() {
        return this.mOSearchbar;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public OIconButtonFloating getSearchRightButton() {
        return this.mOSearchRightButton;
    }

    private final IContactSearchBarPresenter getPresenter() {
        if (this.mPresenter != null) goto L6;
        ContactSearchBarPresenter r0 = new ContactSearchBarPresenter();
        this.mPresenter = r0;
        r0.attachView(this, getActivity(), getActivity());
    L6:
        return this.mPresenter;
    }

    public final void setPrefsCallback(PreferencesCallback r1) {
        this.mPrefsCallback = r1;
    }

    private final String[] getContactProjection() {
        PreferencesCallback r0 = this.mPrefsCallback;
        if (r0 == null) goto L27;
        int r5 = r0.getDisplayOrder();
        int r1 = r0.getSortOrder();
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getContactProjection: displayOrder=" + r5 + ", sortOrder=" + r1);
        if (r5 != 1) goto L22;
        if (r1 != 1) goto L21;
        return ContactQuery.INSTANCE.getCONTACT_PROJECTION_PRIMARY_PRIMARY();
    L21:
        return ContactQuery.INSTANCE.getCONTACT_PROJECTION_PRIMARY_ALTERNATIVE();
    L22:
        if (r1 != 1) goto L26;
        return ContactQuery.INSTANCE.getCONTACT_PROJECTION_ALTERNATIVE_PRIMARY();
    L26:
        return ContactQuery.INSTANCE.getCONTACT_PROJECTION_ALTERNATIVE_ALTERNATIVE();
    L27:
        Context r2 = this.mContext;     // Catch: Exception -> L14
        ContentResolver r3 = null;
        if (r2 == null) goto L8;
        ContentResolver r4 = r2.getContentResolver();     // Catch: Exception -> L14
    L9:
        int r6 = Settings.System.getInt(r4, "android.contacts.DISPLAY_ORDER");     // Catch: Exception -> L14
        Context r7 = this.mContext;     // Catch: Exception -> L14
        if (r7 == null) goto L12;
        r3 = r7.getContentResolver();     // Catch: Exception -> L14
    L12:
        r1 = Settings.System.getInt(r3, "android.contacts.SORT_ORDER");     // Catch: Exception -> L14
        r5 = r6;
        goto L15
    L8:
        r4 = null;
    L14:
        r5 = 1;
        r1 = 1;
        goto L15
    }

    public final void onPreferencesChanged() {
        triggerLoad$default(this, this.mSortMode, true, false, 4, null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onAttach(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super.onAttach(r2);
        this.mActivity = getActivity();
        this.mContext = r2;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater r2, ViewGroup r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        initAnimation();
        this.mIsHasPhoneNum = ContactsUtils.contactsWithPhoneOnly(getActivity());
        this.mNavigationBarHeight = NavigationBarHelper.getNavigationBarHeight(this.mActivity);
        return inflateAndSetupView(r2, r3, r4, R.layout.contact_city_fragment);
    }

    private final void inflateVoiceButton() {
        View r0 = this.mContactsFragment;
        View r1 = null;
        if (r0 == null) goto L5;
        View r2 = r0.findViewById(R.id.stub_voice_button);
    L6:
        ViewStub r3 = (ViewStub) r2;
        if (r3 != null) goto L9;
        return;
    L9:
        r3.inflate();
        View r4 = this.mContactsFragment;
        if (r4 == null) goto L12;
        View r5 = r4.findViewById(R.id.voice_search_container);
    L13:
        RelativeLayout r6 = (RelativeLayout) r5;
        this.voiceSearchContainer = r6;
        if (r6 == null) goto L16;
        ViewGroup.LayoutParams r7 = r6.getLayoutParams();
    L17:
        Intrinsics.checkNotNull(r7, "null cannot be cast to non-null type android.widget.RelativeLayout.LayoutParams");
        RelativeLayout.LayoutParams r8 = (RelativeLayout.LayoutParams) r7;
        int r9 = ContactsUtils.getScreenWidth(this.mActivity);
        int r10 = r9 / 5;
        int r11 = r9 / 4;
        r8.leftMargin = (((r9 - (r10 * 4)) / 2) + r10) - ((r11 - r10) / 2);
        r8.width = r11;
        RelativeLayout r12 = this.voiceSearchContainer;
        if (r12 == null) goto L20;
        r12.setLayoutParams(r8);
    L20:
        View r13 = this.mContactsFragment;
        if (r13 == null) goto L23;
        View r14 = r13.findViewById(R.id.voice_search);
    L24:
        ImageButton r15 = (ImageButton) r14;
        this.mBtnVoiceSearchContacts = r15;
        if (r15 == null) goto L28;
        r15.setHapticFeedbackEnabled(true);
    L28:
        View r16 = this.mContactsFragment;
        if (r16 == null) goto L31;
        View r17 = r16.findViewById(R.id.stub_controller_layout);
    L32:
        ViewStub r18 = (ViewStub) r17;
        if (r18 == null) goto L35;
        r18.inflate();
    L35:
        View r19 = this.mContactsFragment;
        if (r19 == null) goto L38;
        View r20 = r19.findViewById(R.id.controller_layout);
    L39:
        this.mSearchResultDialog = (ViewGroup) r20;
        View r21 = this.mContactsFragment;
        if (r21 == null) goto L42;
        View r22 = r21.findViewById(R.id.stub_empty_layout);
    L43:
        ViewStub r23 = (ViewStub) r22;
        if (r23 == null) goto L46;
        r23.inflate();
    L46:
        View r24 = this.mContactsFragment;
        if (r24 == null) goto L49;
        View r25 = r24.findViewById(R.id.empty_layout);
    L50:
        this.mEmptyResultDialog = (ViewGroup) r25;
        View r26 = this.mContactsFragment;
        if (r26 == null) goto L53;
        View r27 = r26.findViewById(R.id.cover);
    L54:
        this.mCover = r27;
        if (r27 == null) goto L57;
        r27.setOnClickListener(this);
    L57:
        View r28 = this.mContactsFragment;
        if (r28 == null) goto L60;
        r1 = r28.findViewById(R.id.wave);
    L60:
        this.mWave = r1;
        ImageButton r29 = this.mBtnVoiceSearchContacts;
        if (r29 == null) goto L63;
        r29.setOnTouchListener(new ViewOnTouchListenerC01931(this));
    L63:
        initCloseVoiceDialog(this.mContext);
        showVoiceSearchBtn();
        return;
    L53:
        r27 = null;
        goto L54
    L49:
        r25 = null;
        goto L50
    L42:
        r22 = null;
        goto L43
    L38:
        r20 = null;
        goto L39
    L31:
        r17 = null;
        goto L32
    L23:
        r14 = null;
        goto L24
    L16:
        r7 = null;
        goto L17
    L12:
        r5 = null;
        goto L13
    L5:
        r2 = null;
        goto L6
    }

    protected final View inflateAndSetupView(LayoutInflater r10, ViewGroup r11, Bundle r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "inflater");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "inflateAndSetupView start");
        FragmentActivity r0 = getActivity();
        View r2 = null;
        if (r0 != null) goto L5;
        return null;
    L5:
        WindowManager r1 = r0.getWindowManager();
        if (r1 == null) goto L10;
        Display r3 = r1.getDefaultDisplay();
        if (r3 == null) goto L10;
        r3.getSize(this.mOutSize);
    L10:
        boolean r4 = false;
        this.mContactsFragment = r10.inflate(r13, r11, false);
        if (r12 == null) goto L13;
        this.mSelectedGroupUri = (Uri) r12.getParcelable(EXTRA_KEY_GROUP_URI);
    L13:
        this.mSortMode = 1;
        View r14 = this.mContactsFragment;
        if (r14 == null) goto L16;
        OFloatingTitleBar r15 = (OFloatingTitleBar) r14.findViewById(R.id.sct_contact_otitlebar);
    L17:
        Intrinsics.checkNotNull(r15);
        OFloatingTitleBarHolder r16 = new OFloatingTitleBarHolder(r15);
        this.mTitleBarHolder = r16;
        OFloatingTitleBar r17 = r16.getTitleBar();
        if (r17 == null) goto L20;
        r17.setStartTitle(getResources().getString(R.string.common_contacts));
    L20:
        OFloatingTitleBarHolder r18 = this.mTitleBarHolder;
        if (r18 == null) goto L23;
        r18.addStartAction(OFloatingTitleBarHolder.STATE_EDIT, R.drawable.icon_cancel_22_22, new NewContactListFragment$$ExternalSyntheticLambda25(this)).setContentDescription(getString(R.string.accessibility_btn_cancel));
        r18.removeStartAction();
    L23:
        OFloatingTitleBarHolder r19 = this.mTitleBarHolder;
        if (r19 == null) goto L26;
        View r110 = r19.addEndAction(OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.standard_icon_common_add_selector, new NewContactListFragment$$ExternalSyntheticLambda26(this));
    L27:
        if (r110 == null) goto L30;
        r110.setContentDescription(getString(R.string.menu_newContact));
    L30:
        OFloatingTitleBarHolder r5 = this.mTitleBarHolder;
        if (r5 == null) goto L33;
        View r6 = OFloatingTitleBarHolder.addEndAction$default(r5, OFloatingTitleBarHolder.STATE_NORMAL, R.drawable.icon_menu_more, null, 4, null);
    L34:
        if (r6 == null) goto L36;
        r6.setContentDescription(getString(R.string.more_btn));
    L36:
        if (r6 == null) goto L38;
        ClickUtilsKt.setOnDebouncedClickListener$default(r6, 0, new AnonymousClass2(this), 1, null);
    L38:
        OFloatingTitleBarHolder r111 = this.mTitleBarHolder;
        if (r111 == null) goto L54;
        String r112 = getResources().getString(R.string.select_all);
        Intrinsics.checkNotNullExpressionValue(r112, "resources.getString(R.string.select_all)");
        View r113 = r111.addEndAction(OFloatingTitleBarHolder.STATE_EDIT, r112, new NewContactListFragment$$ExternalSyntheticLambda27(this));
        if ((r113 instanceof ViewGroup) == false) goto L43;
        ViewGroup r114 = (ViewGroup) r113;
    L44:
        if (r114 == null) goto L46;
        View r115 = r114.getChildAt(0);
    L48:
        if ((r115 instanceof OTextView) == false) goto L50;
        OTextView r116 = (OTextView) r115;
    L51:
        if (r116 == null) goto L53;
        r116.setTextColor(ResourcesCompat.getColor(getResources(), R.color.oui_functional_blue_6, null));
        this.mContactSelectAllBtn = new SelectAllState(r116);
    L53:
        r111.removeEndAction();
        goto L54
    L50:
        r116 = null;
        goto L51
    L46:
        r115 = null;
        goto L48
    L43:
        r114 = null;
    L54:
        View r117 = this.mContactsFragment;
        if (r117 == null) goto L57;
        ViewGroup r118 = (ViewGroup) r117.findViewById(R.id.search_or_option_bar);
    L58:
        this.mSearchOptionBar = r118;
        View r119 = this.mContactsFragment;
        if (r119 == null) goto L61;
        ViewGroup r120 = (ViewGroup) r119.findViewById(R.id.search_container);
    L62:
        this.mSearchContainer = r120;
        if (r120 == null) goto L65;
        r120.setOnClickListener(new NewContactListFragment$$ExternalSyntheticLambda1());
    L65:
        View r121 = this.mContactsFragment;
        if (r121 == null) goto L68;
        FrameLayout r122 = (FrameLayout) r121.findViewById(R.id.search_filed_bar_container);
    L69:
        this.mSearchFiledBarContainer = r122;
        View r123 = this.mContactsFragment;
        if (r123 == null) goto L72;
        OIconButtonFloating r124 = (OIconButtonFloating) r123.findViewById(R.id.search_field_button);
    L73:
        this.mOSearchRightButton = r124;
        if (r124 == null) goto L76;
        r124.setOnClickListener(new NewContactListFragment$$ExternalSyntheticLambda2(this));
    L76:
        OIconButtonFloating r125 = this.mOSearchRightButton;
        if (r125 == null) goto L80;
        r125.setVisibility(4);
    L80:
        OIconButtonFloating r126 = this.mOSearchRightButton;
        if (r126 == null) goto L84;
        r126.setAlpha(0.0f);
    L84:
        OIconButtonFloating r127 = this.mOSearchRightButton;
        if (r127 == null) goto L88;
        r127.setEnabled(false);
    L88:
        OIconButtonFloating r128 = this.mOSearchRightButton;
        if (r128 == null) goto L92;
        r128.setClickable(false);
    L92:
        View r129 = this.mContactsFragment;
        if (r129 == null) goto L95;
        OSearchBar r130 = (OSearchBar) r129.findViewById(R.id.search_field_bar);
    L96:
        this.mOSearchbar = r130;
        if (r130 == null) goto L99;
        r130.setOverridePressColor(0);
        r130.refreshColors("");
    L99:
        OSearchBar r131 = this.mOSearchbar;
        if (r131 == null) goto L102;
        View r132 = r131.getChildAt(0);
    L104:
        if ((r132 instanceof OUILinearLayout) == false) goto L106;
        OUILinearLayout r133 = (OUILinearLayout) r132;
    L107:
        if (r133 == null) goto L109;
        r133.setOverridePressColor(0);
        r133.refreshColors("");
    L109:
        OSearchBar r134 = this.mOSearchbar;
        if (r134 == null) goto L118;
        OEditText r135 = r134.getInputView();
        if (r135 == null) goto L118;
        Context r136 = this.mContext;
        if (r136 == null) goto L116;
        String r137 = r136.getString(R.string.contact_list_search_hint);
    L117:
        r135.setHint(r137);
        goto L118
    L116:
        r137 = null;
    L118:
        OSearchBar r138 = this.mOSearchbar;
        if (r138 == null) goto L121;
        OEditText r139 = r138.getInputView();
    L122:
        if (r139 == null) goto L124;
        r139.setSingleLine(true);
    L124:
        if (r139 == null) goto L127;
        r139.setSaveEnabled(false);
    L127:
        if (r139 == null) goto L130;
        r139.setImeOptions(6);
    L130:
        if (r139 == null) goto L133;
        r139.setFilters(new InputFilter[]{new InputFilter.LengthFilter(100)});
    L133:
        if (r139 == null) goto L135;
        r139.setOnFocusChangeListener(new NewContactListFragment$$ExternalSyntheticLambda3(this));
    L135:
        OSearchBar r140 = this.mOSearchbar;
        if (r140 == null) goto L138;
        r140.setContentDescription("搜索");
    L138:
        View r141 = this.mContactsFragment;
        if (r141 == null) goto L141;
        HeadersListView r142 = (HeadersListView) r141.findViewById(R.id.main_list);
    L142:
        this.mContactListView = r142;
        if (r142 == null) goto L145;
        r142.setVisibility(0);
    L145:
        HeadersListView r143 = this.mContactListView;
        if (r143 == null) goto L148;
        r143.setSlideListener(this.mSlideListener);
    L148:
        HeadersListView r144 = this.mContactListView;
        if (r144 == null) goto L151;
        r144.setTouchMonitorListener(this.mTouchMonitorListener);
    L151:
        HeadersListView r145 = this.mContactListView;
        if (r145 == null) goto L154;
        r145.setItemLongClickedListener(this.mItemLongClickedListener);
    L154:
        View r146 = this.mContactsFragment;
        if (r146 == null) goto L157;
        View r147 = r146.findViewById(R.id.listview_emptyview_stub);
    L158:
        this.mContactsEmptyViewStub = (ViewStub) r147;
        View r148 = this.mContactsFragment;
        if (r148 == null) goto L161;
        View r149 = r148.findViewById(R.id.listview_tip_emptyview_stub);
    L162:
        this.mContactsTipEmptyViewStub = (ViewStub) r149;
        View r150 = this.mContactsFragment;
        if (r150 == null) goto L165;
        View r151 = r150.findViewById(R.id.contacts_body);
    L166:
        this.mContactBody = (RelativeLayout) r151;
        initSearchViews();
        View r152 = this.mContactsFragment;
        if (r152 == null) goto L169;
        View r153 = r152.findViewById(R.id.group_browse_stub);
    L170:
        Intrinsics.checkNotNull(r153, "null cannot be cast to non-null type android.view.ViewStub");
        this.mGroupBrowseStub = (ViewStub) r153;
        View r154 = this.mContactsFragment;
        if (r154 == null) goto L173;
        ViewGroup r155 = (ViewGroup) r154.findViewById(R.id.contacts_frame_view);
    L174:
        this.mContactsFrameView = r155;
        this.mPhotoManager = ContactPhotoManager.getInstance(this.mContext);
        HeadersListView r156 = this.mContactListView;
        if (r156 == null) goto L177;
        r156.setOnScrollListener(this);
    L177:
        HeadersListView r157 = this.mContactListView;
        if (r157 == null) goto L180;
        r157.setOnItemClickListener(this);
    L180:
        ForceTouchController r158 = new ForceTouchController(this.mContactListView, getActivity());
        this.mForceTouchController = r158;
        HeadersListView r159 = this.mContactListView;
        if (r159 == null) goto L183;
        r159.setOnTouchListener(createCloseSwipeTouchListener(r158));
    L183:
        RelativeLayout r160 = this.mContactBody;
        if (r160 == null) goto L187;
        r160.setVisibility(0);
    L187:
        View r161 = this.mContactsFragment;
        if (r161 == null) goto L190;
        r2 = r161.findViewById(R.id.main_quickcontactbar);
    L190:
        OIndexScrollbar r7 = (OIndexScrollbar) r2;
        this.mQuickBar = r7;
        if (r7 == null) goto L193;
        r7.setQBListener(this.mQBListener);
    L193:
        OIndexScrollbar r162 = this.mQuickBar;
        if (r162 == null) goto L196;
        r162.setSurnameListener(this.mSurnameListener);
    L196:
        OIndexScrollbar r163 = this.mQuickBar;
        if (r163 == null) goto L199;
        r163.setOnTouchListener(new NewContactListFragment$$ExternalSyntheticLambda4(this));
    L199:
        OIndexScrollbar r164 = this.mQuickBar;
        if (r164 == null) goto L202;
        r164.setContentDescription(this.mLetter);
    L202:
        HeadersListView r165 = this.mContactListView;
        if (r165 == null) goto L205;
        r165.setCompareHasAddedTime(true);
    L205:
        HeadersListView r166 = this.mContactListView;
        if (r166 == null) goto L208;
        r166.setQuickBar(this.mQuickBar);
    L208:
        init();
        if (this.mOldContacts != null) goto L211;
    L219:
        final ViewGroup r167 = this.mContactsFrameView;
        if (r167 == null) goto L222;
        r167.setOnSystemUiVisibilityChangeListener(new NewContactListFragment$$ExternalSyntheticLambda5(this, r167));
    L222:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "inflateAndSetupView end");
        return this.mContactsFragment;
    L211:
        if (1 != this.mSortMode) goto L219;
        Handler r168 = this.mHandler;
        if (r168 != null) goto L215;
    L217:
        if (r4 == false) goto L219;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "inflateAndSetupView notifyDataSetChangedBySortMode");
        notifyDataSetChangedBySortMode(this.mOldContacts, 1);
        goto L219
    L215:
        if (r168.hasMessages(1001) == true) goto L217;
        r4 = true;
        goto L217
    L173:
        r155 = null;
        goto L174
    L169:
        r153 = null;
        goto L170
    L165:
        r151 = null;
        goto L166
    L161:
        r149 = null;
        goto L162
    L157:
        r147 = null;
        goto L158
    L141:
        r142 = null;
        goto L142
    L121:
        r139 = null;
        goto L122
    L106:
        r133 = null;
        goto L107
    L102:
        r132 = null;
        goto L104
    L95:
        r130 = null;
        goto L96
    L72:
        r124 = null;
        goto L73
    L68:
        r122 = null;
        goto L69
    L61:
        r120 = null;
        goto L62
    L57:
        r118 = null;
        goto L58
    L33:
        r6 = null;
        goto L34
    L26:
        r110 = null;
        goto L27
    L16:
        r15 = null;
        goto L17
    }

    private static final void inflateAndSetupView$lambda$5$lambda$4(NewContactListFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onCancelEditContactClicked();
    }

    private static final void inflateAndSetupView$lambda$6(NewContactListFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onAddNewContactClicked();
    }

    private static final void inflateAndSetupView$lambda$9$lambda$7(NewContactListFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        SelectAllState r2 = r0.mContactSelectAllBtn;
        if (r2 == null) goto L12;
        if (r2 == null) goto L6;
        r2.toggle();
    L6:
        SelectAllState r3 = r0.mContactSelectAllBtn;
        if (r3 == null) goto L9;
        boolean r4 = r3.isSelectAll();
    L10:
        r0.contactsSelectAll(r4);
        return;
    L9:
        r4 = false;
        goto L10
    }

    private static final void inflateAndSetupView$lambda$11(NewContactListFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.cancelSearch();
    }

    private static final void inflateAndSetupView$lambda$14(NewContactListFragment r0, View r1, boolean r2) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        if (r2 == false) goto L9;
        r0.hideQuickContactViewIView();
        IContactSearchBarPresenter r3 = r0.getPresenter();
        if (r3 == null) goto L7;
        r3.startSearch();
    L7:
        r0.startContactAnimationIView();
        return;
    }

    private static final boolean inflateAndSetupView$lambda$15(NewContactListFragment r1, View r2, MotionEvent r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        if (r3.getActionMasked() != 0) goto L5;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.QUICK_BAR);
    L5:
        HeadersListView r4 = r1.mContactListView;
        if (r4 == null) goto L8;
        r4.restoreScrollState(false);
    L8:
        return false;
    }

    private static final void inflateAndSetupView$lambda$17$lambda$16(NewContactListFragment r3, ViewGroup r4, int r5) {
        Intrinsics.checkNotNullParameter(r3, "this$0");
        Intrinsics.checkNotNullParameter(r4, "$it");
        RelativeLayout r0 = r3.mSearchResultView;
        if (r0 != null) goto L6;
        int r1 = 8;
    L5:
        Integer r2 = Integer.valueOf(r1);
    L9:
        if (r2 != null) goto L12;
        return;
    L12:
        if (r2.intValue() == 0) goto L14;
        return;
    L14:
        if (r5 == 2) goto L16;
    L18:
        if (r5 == 0) goto L20;
        return;
    L20:
        if (r3.mIsNavigationShown == true) goto L26;
        r4.setLayoutParams(new FrameLayout.LayoutParams(r3.mOutSize.x, r4.getHeight() - r3.mNavigationBarHeight));
        r3.mIsNavigationShown = true;
        return;
    L26:
        return;
    L16:
        if (r3.mIsNavigationShown == false) goto L18;
        r4.setLayoutParams(new FrameLayout.LayoutParams(r3.mOutSize.x, r4.getHeight() + r3.mNavigationBarHeight));
        r3.mIsNavigationShown = false;
        return;
    L6:
        if (r0 == null) goto L8;
        r1 = r0.getVisibility();
        goto L5
    L8:
        r2 = null;
        goto L9
    }

    private final OButton getTitleBtn(int r3, boolean r4, OCTitleBar r5, OButton r6) {
        FragmentActivity r2 = getActivity();
        if (r5 == null) goto L16;
        if (r2 == null) goto L18;
        LinearLayout r0 = r5.getMLeftContainer();
        if (r4 == true) goto L9;
        r0 = r5.getMRightContainer();
    L9:
        if (r6 == null) goto L14;
        if (r0 == null) goto L14;
        OButton r7 = r6;
        if (r0.indexOfChild(r7) == (-1)) goto L14;
        r0.removeView(r7);
    L14:
        OButton r8 = r5.createTransIconButton(r2, r0);
        r8.setMIcon(r2.getDrawable(r3));
        return r8;
    L18:
        return null;
    L16:
        return null;
    }

    private final void contactsSelectAll(boolean r3) {
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.hideLetterGrid();
    L6:
        if (r3 == false) goto L23;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SELECT_ALL_CONTACTS);
        int r4 = this.mSortMode;
        if (r4 != 2) goto L11;
        this.mSelectedSet.addAll(this.mContactsIdForLocation);
    L24:
        refreshAdapter(true);
        return;
    L11:
        if (r4 != 32) goto L14;
        this.mSelectedSet.addAll(this.mContactsIdSIM1);
        goto L24
    L14:
        if (r4 != 64) goto L17;
        this.mSelectedSet.addAll(this.mContactsIdSIM2);
        goto L24
    L17:
        if (r4 != 128) goto L20;
        this.mSelectedSet.addAll(this.mContactsIdBCR);
        goto L24
    L20:
        if (r4 != 256) goto L22;
        this.mSelectedSet.addAll(this.mPhoneContactsIdList);
        goto L24
    L22:
        this.mSelectedSet.addAll(this.mContactsIdList);
        goto L24
    L23:
        this.mSelectedSet.clear();
        goto L24
    }

    private static final void mVoiceUiRunnable$lambda$18(NewContactListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        AnimationUtil.showCoverWithAnimation(r2.mCover, r2.mCoverAnimationTracker);
        AnimationUtil.startRecordWithAnimation(r2.mWave);
    }

    private final boolean isOutSideVoiceButton(View r3, MotionEvent r4) {
        float r2 = r4.getX();
        float r5 = r4.getY();
        if (r2 > (r3.getLeft() - 50)) goto L5;
    L14:
        return true;
    L5:
        if (r2 >= (r3.getRight() + 50)) goto L14;
        if (r5 <= (r3.getTop() - 50)) goto L14;
        if (r5 >= (r3.getBottom() + 50)) goto L14;
        return false;
    }

    private final void handleActionMove(View r3, MotionEvent r4) {
        if (isOutSideVoiceButton(r3, r4) == false) goto L34;
        ImageButton r5 = this.mBtnVoiceSearchContacts;
        if (r5 != null) goto L7;
        return;
    L7:
        if (r5 == null) goto L9;
        r5.setEnabled(false);
    L9:
        ImageButton r6 = this.mBtnVoiceSearchContacts;
        if (r6 == null) goto L13;
        r6.setPressed(false);
    L13:
        if (isResultDialogShown() == true) goto L30;
        AnimationUtil.stopRecordWithAnimation(this.mWave);
        dismissWave();
        Handler r7 = this.mHandler;
        if (r7 == null) goto L17;
        r7.removeCallbacks(this.mVoiceUiRunnable);
    L17:
        dismissCover();
        stopRecord(true);
        Runnable r8 = this.mStartRecord;
        if (r8 == null) goto L22;
        Handler r9 = this.mHandler;
        if (r9 == null) goto L22;
        r9.removeCallbacks(r8);
    L22:
        ShowResultThread r10 = this.mShowResultThread;
        if (r10 == null) goto L27;
        Handler r11 = this.mHandler;
        if (r11 == null) goto L27;
        r11.removeCallbacks(r10);
    L27:
        Handler r12 = this.mHandler;
        if (r12 == null) goto L30;
        r12.removeCallbacks(this.mTimeoutThread);
    L30:
        Handler r13 = this.mHandler;
        if (r13 == null) goto L36;
        r13.postDelayed(new NewContactListFragment$$ExternalSyntheticLambda16(this), 100);
        return;
    L36:
        return;
    }

    private static final void handleActionMove$lambda$21(NewContactListFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        ImageButton r2 = r1.mBtnVoiceSearchContacts;
        if (r2 == null) goto L6;
        r2.setEnabled(true);
        return;
    }

    private final void stopRecord(boolean r9) {
        IVoiceAssistantService r4 = this.mVoiceInterface;     // Catch: Throwable -> L13 RemoteException -> L19
        if (r4 == null) goto L10;
        if (r4 == null) goto L7;
        r4.stopRecongnize(r9);     // Catch: Throwable -> L13 RemoteException -> L19
    L7:
        if (r9 == false) goto L10;
        this.mStartedRecongnize = false;     // Catch: Throwable -> L13 RemoteException -> L19
    L10:
        if ((System.currentTimeMillis() - this.mStartedRecongnizeTime) > 150) goto L12;
    L11:
        this.mCancelRecognizeByTooShortTime = true;
        dismissWave();
        dismissCover();
        resetRecognizeByTooShortTime();
        return;
    L12:
        this.mCancelRecognizeByTooShortTime = false;
        return;
    L13:
        th = move-exception;
        if ((System.currentTimeMillis() - this.mStartedRecongnizeTime) > 150) goto L17;
        this.mCancelRecognizeByTooShortTime = true;
        dismissWave();
        dismissCover();
        resetRecognizeByTooShortTime();
    L18:
        throw th;
    L17:
        this.mCancelRecognizeByTooShortTime = false;
    L20:
        if ((System.currentTimeMillis() - this.mStartedRecongnizeTime) > 150) goto L12;
        goto L12
    }

    private final void resetRecognizeByTooShortTime() {
        TimerTask r0 = new NewContactListFragment$resetRecognizeByTooShortTime$task$1(this);
        new Timer().schedule(r0, 200);
    }

    private final void dismissWave() {
        View r0 = this.mWave;
        if (r0 == null) goto L12;
        AnimationUtil.cancelAnimation(r0);
        View r1 = this.mWave;
        if (r1 == null) goto L7;
        r1.clearAnimation();
    L7:
        View r2 = this.mWave;
        if (r2 == null) goto L13;
        r2.setVisibility(8);
        return;
    L13:
        return;
    }

    private final void dismissCover() {
        View r0 = this.mCover;
        if (r0 == null) goto L13;
        AnimationUtil.cancelAnimation(r0);
        View r1 = this.mCover;
        if (r1 == null) goto L7;
        r1.clearAnimation();
    L7:
        View r2 = this.mCover;
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        this.mCoverDismiss = true;
        return;
    }

    private final boolean isResultDialogShown() {
        ViewGroup r0 = this.mSearchResultDialog;
        if (r0 == null) goto L10;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L10;
        return true;
    L6:
        if (r0.getVisibility() != 0) goto L8;
        r1 = true;
    L10:
        ViewGroup r3 = this.mEmptyResultDialog;
        if (r3 == null) goto L20;
        if (r3 != null) goto L14;
    L16:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L20;
        return true;
    L14:
        if (r3.getVisibility() != 0) goto L16;
        r4 = true;
    L20:
        return false;
    }

    private static final void mStartRecord$lambda$22(NewContactListFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        r4.mHasResult = false;
        r4.mHasOccupied = false;
        r4.mCoverDismiss = false;
        r4.mStartedRecongnizeTime = System.currentTimeMillis();
        IVoiceAssistantService r0 = r4.mVoiceInterface;     // Catch: RemoteException -> L16
        if (r0 == null) goto L11;
        if (r0 == null) goto L11;
        Context r2 = r4.mContext;     // Catch: RemoteException -> L16
        if (r2 == null) goto L9;
        String r3 = r2.getPackageName();     // Catch: RemoteException -> L16
    L10:
        r0.startRecongnize(r3, 1, null);     // Catch: RemoteException -> L16
        goto L11
    L9:
        r3 = null;
    L11:
        Handler r1 = r4.mHandler;     // Catch: RemoteException -> L16
        if (r1 == null) goto L14;
        r1.removeCallbacks(r4.mTimeoutThread);     // Catch: RemoteException -> L16
    L14:
        r4.mStartedRecongnize = true;     // Catch: RemoteException -> L16
        return;
    }

    private static final void mTimeoutThread$lambda$23(NewContactListFragment r2) {
        Intrinsics.checkNotNullParameter(r2, "this$0");
        if (r2.mStartedRecongnize == true) goto L5;
        return;
    L5:
        if (r2.mHasResult == false) goto L7;
        return;
    L7:
        if (r2.mHasOccupied == false) goto L9;
        return;
    L9:
        if (r2.mCoverDismiss == false) goto L11;
        return;
    L11:
        if (ContactsUtils.DEBUG == false) goto L13;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "overtime show empty dialog");
    L13:
        Handler r0 = r2.mHandler;
        if (r0 == null) goto L16;
        r0.removeCallbacks(r2.mStartRecord);
    L16:
        AnimationUtil.showResultDialogWithAnim(r2.mEmptyResultDialog);
        r2.mStartedRecongnize = false;
    }

    private final boolean isSearchBarPopupShowing() {
        IContactSearchBarPresenter r0 = getPresenter();
        if (r0 != null) goto L7;
        return false;
    L7:
        return r0.isPopupWindowShowing();
    }

    private final void showVoiceSearchBtn() {
        if (this.mBtnVoiceSearchContacts != null) goto L6;
        return;
    L6:
        if (isResumed() == true) goto L8;
        return;
    L8:
        if (this.mIsEdit == false) goto L10;
        return;
    L10:
        if (this.isSearch == true) goto L48;
        OIndexScrollbar r0 = this.mQuickBar;
        int r2 = 0;
        if (r0 == null) goto L19;
        if (r0 != null) goto L15;
    L17:
        boolean r1 = false;
    L18:
        if (r1 == true) goto L19;
        return;
    L15:
        if (r0.isLetterGridHide() != true) goto L17;
        r1 = true;
    L19:
        RelativeLayout r3 = this.mContactsEmptyView;
        if (r3 == null) goto L28;
        if (r3 != null) goto L23;
    L25:
        boolean r4 = false;
    L26:
        if (r4 == false) goto L28;
        return;
    L23:
        if (r3.getVisibility() != 0) goto L25;
        r4 = true;
    L28:
        if (isSearchBarPopupShowing() == false) goto L30;
        return;
    L30:
        if (this.mSortMode != 1) goto L34;
        if (ContactsUtils.isOnlyIncludeProfile(this.mOldContacts) == false) goto L34;
        return;
    L34:
        if (isContactsListViewStateIdle() == true) goto L36;
        return;
    L36:
        if (getTargetListView() == null) goto L54;
        ListView r5 = getTargetListView();
        if (r5 == null) goto L40;
        r2 = r5.getCount();
    L40:
        if (r2 <= 0) goto L55;
        ImageButton r6 = this.mBtnVoiceSearchContacts;
        if (r6 == null) goto L44;
        r6.setEnabled(true);
    L44:
        AnimationUtil.showVoiceBtnWithAnimation(this.mBtnVoiceSearchContacts);
        return;
    L55:
        return;
    L54:
        return;
    }

    private final void hideVoiceSearchBtn() {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L5;
        r0.removeCallbacks(this.mScrollIdle);
    L5:
        ImageButton r1 = this.mBtnVoiceSearchContacts;
        if (r1 == null) goto L11;
        if (r1 == null) goto L9;
        r1.setEnabled(false);
    L9:
        AnimationUtil.hideVoiceBtnWithAnimation(this.mBtnVoiceSearchContacts);
        return;
    }

    private final void showVoiceSearchBtnDelayed(long r3) {
        new Handler().postDelayed(new RunnableC02031(this), r3);
    }

    private final boolean isContactsListViewStateIdle() {
        ListView r2 = getTargetListView();
        if (r2 != null) goto L6;
        return true;
    L6:
        if ((r2 instanceof HorizontalScrollListView) == false) goto L10;
        return ((HorizontalScrollListView) r2).isStateIdle();
    L10:
        if ((r2 instanceof HorizontalScrollExpandableListView) == true) goto L12;
        return true;
    L12:
        return ((HorizontalScrollExpandableListView) r2).isStateIdle();
    }

    private static final void mTouchMonitorListener$lambda$24(NewContactListFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (r4.mIsEdit == false) goto L14;
        Handler r0 = r4.mHandler;
        boolean r2 = false;
        if (r0 != null) goto L7;
    L9:
        if (r2 == false) goto L15;
        Handler r5 = r4.mHandler;
        if (r5 == null) goto L16;
        r5.sendEmptyMessageDelayed(1005, 100);
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r0.hasMessages(1005) == true) goto L9;
        r2 = true;
        goto L9
    }

    private static final boolean mItemLongClickedListener$lambda$25(NewContactListFragment r8, AdapterView r9, View r10, int r11, long r12, int r14, int r15) {
        Intrinsics.checkNotNullParameter(r8, "this$0");
        boolean r13 = false;
        if (r11 >= 0) goto L5;
        return false;
    L5:
        SamContact r1 = null;
        if (r9.getId() != R.id.main_list) goto L45;
        int r16 = r8.mSortMode;
        if (r16 != 1) goto L10;
        ContactsListSortByNameAdapter r17 = r8.mNorAdapter;
        if (r17 != null) goto L32;
    L49:
        SamContact r7 = r1;
    L50:
        Intrinsics.checkNotNullExpressionValue(r9, "parent");
        return r8.handleContactEvent(r9, r10, r14, r15, r7);
    L32:
        if (r17.getCount() <= 0) goto L49;
        ArrayList<SamContact> r18 = r17.getList();
        if (r11 >= 0) goto L37;
    L39:
        if (r13 == false) goto L49;
        SamContact r19 = r18.get(r11);
        if (r19.getType() != 0) goto L49;
        r7 = r19;
        goto L50
    L37:
        if (r11 >= r18.size()) goto L39;
        r13 = true;
        goto L39
    L10:
        if (r16 != 256) goto L49;
        ContactsListSortByNameAdapter r110 = r8.mPhoneContactsAdapter;
        if (r110 == null) goto L49;
        if (r110 == null) goto L16;
        int r111 = r110.getCount();
    L17:
        if (r111 <= 0) goto L49;
        ContactsListSortByNameAdapter r112 = r8.mPhoneContactsAdapter;
        if (r112 == null) goto L21;
        ArrayList<SamContact> r113 = r112.getList();
    L22:
        if (r113 == null) goto L49;
        if (r11 >= 0) goto L25;
    L27:
        if (r13 == false) goto L49;
        r1 = r113.get(r11);
        goto L49
    L25:
        if (r11 >= r113.size()) goto L27;
        r13 = true;
        goto L27
    L21:
        r113 = null;
        goto L22
    L16:
        r111 = 0;
        goto L17
    L45:
        if (r9.getId() != R.id.search_listview) goto L49;
        Object r114 = r9.getItemAtPosition(r11);
        if ((r114 instanceof SamContact) == false) goto L49;
        r1 = (SamContact) r114;
        goto L49
    }

    private final boolean handleContactEvent(AdapterView<?> r14, View r15, int r16, int r17, SamContact r18) {
        if (r15 == null) goto L43;
        if (r18 == null) goto L43;
        Bitmap r6 = null;
        if (r14.getId() == R.id.city_list) goto L9;
        Uri r3 = getContactUri(r18);
        ContactDetailCacheManager.getInstance().loadResultData(r3);
        ContactLoader.Result r4 = ContactDetailCacheManager.getInstance().getResult(r3);
    L10:
        SidebarDragHelper r5 = this.mSidebarDragHelper;
        if (r5 != null) goto L13;
    L15:
        boolean r7 = false;
    L16:
        if (r7 == false) goto L19;
        this.mLongMenuHelper.setMenuItemDatas(r15, R.id.item_foreground, r18, r16, r17, sLongMenuItems);
        this.mLongMenuHelper.show();
        return true;
    L19:
        String r8 = ShareContactByText.toShareText(this.mContext, r4);
        if (r4 == null) goto L32;
        String r9 = r8;
        if (TextUtils.isEmpty(r9) == true) goto L32;
        byte[] r10 = r4.getPhotoBinaryData();
        if (r10 == null) goto L28;
        Bitmap r1 = BitmapFactory.decodeByteArray(r10, 0, r10.length);
        SidebarDragHelper r0 = this.mSidebarDragHelper;
        if (r0 == null) goto L31;
        r0.dragContact(r15, r9, r1);
    L31:
        return true;
    L28:
        SidebarDragHelper r2 = this.mSidebarDragHelper;
        if (r2 == null) goto L31;
        r2.dragContact(r15, r9);
    L32:
        AvatarImageView r11 = (AvatarImageView) r15.findViewById(R.id.photo);
        if (r11 != null) goto L35;
    L39:
        Uri r12 = getContactUri(r18);
        SidebarDragHelper r13 = this.mSidebarDragHelper;
        if (r13 == null) goto L42;
        r13.dragContact(r15, r12, r6, false);
    L42:
        return true;
    L35:
        if (r11.getPhotoID() <= 0) goto L39;
        if (r11.getDrawable() == null) goto L39;
        Drawable r19 = r11.getDrawable();
        Intrinsics.checkNotNull(r19, "null cannot be cast to non-null type android.graphics.drawable.BitmapDrawable");
        r6 = ((BitmapDrawable) r19).getBitmap();
        goto L39
    L13:
        if (r5.isSidebarShowing(r15) == true) goto L15;
        r7 = true;
        goto L16
    L9:
        r4 = null;
    L43:
        return false;
    }

    private static final void mTouchMonitorListenerForExpandable$lambda$26(final NewContactListFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (r4.mIsEdit == false) goto L8;
        Handler r0 = r4.mHandler;
        if (r0 == null) goto L9;
        r0.postDelayed(new NewContactListFragment$mTouchMonitorListenerForExpandable$1$1(r4), 100);
        return;
    L9:
        return;
    }

    private final void refreshVisibleListItems() {
        int r0 = this.mSortMode;
        if (r0 != 1) goto L5;
    L45:
        HeadersListView r1 = this.mContactListView;
        if (r1 != null) goto L48;
        return;
    L48:
        int r3 = r1.getFirstVisiblePosition();
        int r4 = r1.getLastVisiblePosition();
        int r5 = r3;
    L49:
        if (r5 > r4) goto L75;
        View r6 = r1.getChildAt(r5 - r3);
        if (r6 == null) goto L53;
        OCheckBox r7 = (OCheckBox) r6.findViewById(R.id.checkBox);
    L54:
        if (r7 == null) goto L55;
        HeadersListView r8 = this.mContactListView;
        if (r8 == null) goto L55;
        HeadersAdapter r9 = r8.getAdapter();
        if (r9 == null) goto L55;
        r7.setChecked(this.mSelectedSet.contains(Long.valueOf(r9.getItemId(r5))));
    L55:
        r5 = r5 + 1;
        goto L49
    L53:
        r7 = null;
        goto L54
    L75:
        return;
    L5:
        if (r0 != 2) goto L7;
    L21:
        QuickContactExpandableListView r2 = this.mCityListView;
        if (r2 != null) goto L24;
        return;
    L24:
        int r10 = r2.getFirstVisiblePosition();
        int r11 = r2.getLastVisiblePosition();
        int r12 = r10;
    L25:
        if (r12 > r11) goto L74;
        View r13 = r2.getChildAt(r12 - r10);
        if (r13 == null) goto L28;
        OCheckBox r14 = (OCheckBox) r13.findViewById(R.id.checkBox);
        if (r14 == null) goto L28;
        ExpandableListAdapter r15 = r2.getExpandableListAdapter();
        long r16 = r2.getExpandableListPosition(r12);
        int r17 = ExpandableListView.getPackedPositionGroup(r16);
        int r18 = ExpandableListView.getPackedPositionChild(r16);
        if (r17 == (-1)) goto L28;
        if (r18 == (-1)) goto L28;
        if (r15 == null) goto L38;
        Object r19 = r15.getChild(r17, r18);
    L40:
        if ((r19 instanceof SamContact) == false) goto L42;
        SamContact r20 = (SamContact) r19;
    L43:
        if (r20 == null) goto L28;
        r14.setChecked(this.mSelectedSet.contains(Long.valueOf(r20.contactId)));
        goto L28
    L42:
        r20 = null;
        goto L43
    L38:
        r19 = null;
    L28:
        r12 = r12 + 1;
        goto L25
    L74:
        return;
    L7:
        if (r0 == 4) goto L45;
        if (r0 == 8) goto L45;
        if (r0 == 16) goto L21;
        if (r0 == 32) goto L45;
        if (r0 == 64) goto L45;
        if (r0 == 128) goto L45;
        if (r0 == 256) goto L45;
    }

    public final ContactPhotoManager getPhotoManager() {
        return this.mPhotoManager;
    }

    private final void onTabAllClicked() {
        recoveryFromGroupEdit();
        setObserverToWork(true);
        triggerLoad$default(this, this.mSortMode, true, false, 4, null);
        View r1 = this.mGroupFlipperView;
        if (r1 == null) goto L7;
        if (r1 == null) goto L7;
        r1.setVisibility(8);
    L7:
        RelativeLayout r2 = this.mContactBody;
        if (r2 == null) goto L11;
        r2.setVisibility(0);
    L11:
        IContactSearchBarPresenter r3 = getPresenter();
        if (r3 == null) goto L14;
        r3.requestSeachViewFocus();
    L14:
        this.isShowGroup = false;
        this.mInContacts = true;
        Agent.getInstance().onAttach(TAG);
        showVoiceSearchBtn();
    }

    private final void onTabGroupClicked() {
        if (this.isSearch == true) goto L45;
        IContactSearchBarPresenter r0 = getPresenter();
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L13;
        return;
    L13:
        if (this.mGroupFlipperView != null) goto L20;
        initGroupView();
        GroupBrowseListFragment r2 = (GroupBrowseListFragment) getChildFragmentManager().findFragmentById(R.id.groupbrowseview);
        this.mGroupBrowseListFragment = r2;
        if (r2 == null) goto L17;
        r2.setListener(new OnGroupActionListener(this));
    L17:
        GroupBrowseListFragment r3 = this.mGroupBrowseListFragment;
        if (r3 == null) goto L20;
        r3.setFragmentsCallback(this.mFragmentsCallback);
    L20:
        View r4 = this.mGroupFlipperView;
        if (r4 == null) goto L24;
        r4.setVisibility(0);
    L24:
        RelativeLayout r5 = this.mContactBody;
        if (r5 == null) goto L27;
        r5.setVisibility(8);
    L27:
        setObserverToWork(false);
        this.isShowGroup = true;
        this.mInContacts = false;
        HeadersListView r6 = this.mContactListView;
        if (r6 != null) goto L30;
    L32:
        boolean r7 = false;
    L33:
        if (r7 == false) goto L38;
        HeadersListView r8 = this.mContactListView;
        if (r8 == null) goto L38;
        r8.hideQuickContact();
    L38:
        if (this.mIsEdit == false) goto L40;
        processEditContacts(false, true);
    L40:
        resetSearchBar();
        OIndexScrollbar r9 = this.mQuickBar;
        if (r9 == null) goto L43;
        r9.hideLetterGrid();
    L43:
        Agent.getInstance().onAttach("GroupBrowseListFragment");
        return;
    L30:
        if (r6.isShowQuickContact() != true) goto L32;
        r7 = true;
        goto L33
    L7:
        if (r0.isPlayingSearchAnimation() != true) goto L9;
        r1 = true;
        goto L10
    }

    public final void initGroupView() {
        ViewStub r1 = this.mGroupBrowseStub;
        if (r1 == null) goto L5;
        r1.inflate();
    L5:
        View r2 = this.mContactsFragment;
        View r3 = null;
        if (r2 == null) goto L8;
        OCTitleBar r4 = (OCTitleBar) r2.findViewById(R.id.sct_group_otitlebar);
    L9:
        this.mOGroupTitleBar = r4;
        OButton r5 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, true, r4, this.mBtnGroupLeft);
        this.mBtnGroupLeft = r5;
        if (r5 == null) goto L16;
        if (r5 == null) goto L13;
        r5.setContentDescription("选择");
    L13:
        OButton r6 = this.mBtnGroupLeft;
        if (r6 == null) goto L16;
        r6.setOnClickListener(new NewContactListFragment$$ExternalSyntheticLambda17(this));
    L16:
        OButton r7 = getTitleBtn(R.drawable.icon_menu_more, false, r4, this.mBtnGroupMenu);
        this.mBtnGroupMenu = r7;
        if (r7 == null) goto L23;
        if (r7 == null) goto L20;
        r7.setContentDescription(getString(R.string.more_btn));
    L20:
        final ArrayList r8 = new ArrayList();
        String r9 = getString(R.string.menu_newGroup);
        Intrinsics.checkNotNullExpressionValue(r9, "getString(R.string.menu_newGroup)");
        r8.add(new MenuItem(r9, null, null, new C01952(this), 6, null));
        String r13 = getString(R.string.btn_select);
        Intrinsics.checkNotNullExpressionValue(r13, "getString(R.string.btn_select)");
        r8.add(new MenuItem(r13, null, null, new AnonymousClass3(this), 6, null));
        String r10 = getString(R.string.common_settings);
        Intrinsics.checkNotNullExpressionValue(r10, "getString(R.string.common_settings)");
        r8.add(new MenuItem(r10, null, null, new AnonymousClass4(this), 6, null));
        OButton r11 = this.mBtnGroupMenu;
        if (r11 == null) goto L23;
        r11.setOnClickListener(new NewContactListFragment$$ExternalSyntheticLambda18(this, r8));
    L23:
        FragmentActivity r12 = getActivity();
        if (r12 == null) goto L29;
        if (r4 == null) goto L27;
        OButton r14 = r4.createNeutralButton(r12, r4.getMRightContainer());
    L28:
        this.mBtnGroupRightDelete = r14;
        goto L29
    L27:
        r14 = null;
    L29:
        OButton r15 = this.mBtnGroupRightDelete;
        if (r15 == null) goto L33;
        r15.setVisibility(8);
    L33:
        OButton r16 = this.mBtnGroupRightDelete;
        if (r16 == null) goto L36;
        r16.setText(R.string.common_cancel);
    L36:
        OButton r17 = this.mBtnGroupRightDelete;
        if (r17 == null) goto L39;
        r17.setContentDescription(getString(R.string.common_cancel));
    L39:
        OButton r18 = this.mBtnGroupRightDelete;
        if (r18 == null) goto L42;
        r18.setOnClickListener(new NewContactListFragment$$ExternalSyntheticLambda19(this));
    L42:
        View r19 = this.mContactsFragment;
        if (r19 == null) goto L45;
        r3 = r19.findViewById(R.id.groupview);
    L45:
        this.mGroupFlipperView = r3;
        return;
    L8:
        r4 = null;
        goto L9
    }

    private static final void initGroupView$lambda$28(NewContactListFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onEditGroupClicked();
    }

    private static final void initGroupView$lambda$30(NewContactListFragment r1, List r2, View r3) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$menuItems");
        FragmentActivity r4 = r1.getActivity();
        if (r4 == null) goto L6;
        Intrinsics.checkNotNullExpressionValue(r3, BaseSwitches.V);
        MenuUtilsKt.show(r4, r3, r2);
        return;
    }

    private static final void initGroupView$lambda$32(NewContactListFragment r0, View r1) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.onCancelEditGroupClicked();
    }

    private final boolean isShowQuickContact() {
        HeadersListView r0 = this.mContactListView;
        if (r0 != null) goto L5;
    L4:
        boolean r1 = false;
    L9:
        if (r1 == true) goto L21;
        QuickContactExpandableListView r3 = this.mCityListView;
        if (r3 != null) goto L13;
    L12:
        boolean r4 = false;
    L17:
        if (r4 == false) goto L20;
        return true;
    L20:
        return false;
    L13:
        if (r3 == null) goto L12;
        if (r3.isShowQuickContact() != true) goto L12;
        r4 = true;
        goto L17
    L21:
        return true;
    L5:
        if (r0 == null) goto L4;
        if (r0.isShowQuickContact() != true) goto L4;
        r1 = true;
        goto L9
    }

    private final void cancelSearch() {
        IContactSearchBarPresenter r0 = getPresenter();
        if (r0 == null) goto L6;
        r0.cancelSearch();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle r2) {
        Intrinsics.checkNotNullParameter(r2, "outState");
        super.onSaveInstanceState(r2);
        r2.putParcelable(EXTRA_KEY_GROUP_URI, this.mSelectedGroupUri);
    }

    private final HashMap<Long, String> getLastInsertContact(Context r11) {
        HashMap<Long, String> r10 = new HashMap();
        Uri.Builder r0 = ContactsContract.Data.CONTENT_URI.buildUpon();
        r0.appendQueryParameter("limit", "3");
        Cursor r12 = r11.getContentResolver().query(r0.build(), new String[]{"contact_id", "data1"}, " mimetype=? and data15 >= ?", new String[]{"vnd.android.cursor.item/added_time", String.valueOf(System.currentTimeMillis() - ((long) H24r))}, "data1 desc");
        if (r12 != null) goto L16;
    L13:
        if (r12 == null) goto L15;
        r12.close();
    L15:
        return r10;
    L16:
    L9:
        th = move-exception;
        if (r12 == null) goto L12;
        r12.close();
    L12:
        throw th;
    L5:
        if (r12.moveToFirst() == false) goto L13;
    L6:
        r10.put(Long.valueOf(r12.getLong(0)), r12.getString(1));     // Catch: Throwable -> L9
        if (r12.moveToNext() == true) goto L6;
        goto L13
    }

    private final int getAll(Context r12, ArrayList<SamContact> r13, ArrayList<SamContact> r14) {
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "getAll: start");
        r13.clear();
        r14.clear();
        HashSet<Long> r0 = new HashSet();
        HashMap<Long, String> r2 = getLastInsertContact(r12);
        if (this.mIsHasPhoneNum == false) goto L5;
        String r3 = CONTACT_CITY_QUERY;
    L6:
        Uri r4 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mNoContactsSelected == false) goto L9;
        r3 = NO_ACCOUNTS_SELECTION;
    L10:
        String r8 = r3;
        String[] r7 = getContactProjection();
        StringBuilder r5 = new StringBuilder("getAll queryUri=").append(r4).append(", proj=");
        String r6 = Arrays.toString(r7);
        Intrinsics.checkNotNullExpressionValue(r6, "toString(...)");
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, r5.append(r6).append(", selection=").append(r8).toString());
        Cursor r9 = r12.getContentResolver().query(r4, r7, r8, null, CONTACT_SORT);     // Catch: Exception -> L13
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getAll after queryUri=" + r4);
        int r10 = 0;
        if (r9 != null) goto L45;
    L43:
        this.mContactsIdList = r0;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getAll: end ids: " + r0);
        return r10;
    L45:
        this.mDataIsReady = true;     // Catch: Throwable -> L40
        int r11 = 0;
    L19:
        if (r9.moveToNext() == false) goto L39;
        SamContact r15 = new SamContact(0);     // Catch: Throwable -> L40
        r15.contactId = r9.getLong(0);     // Catch: Throwable -> L40
        r0.add(Long.valueOf(r15.contactId));     // Catch: Throwable -> L40
        String r16 = r9.getString(1);     // Catch: Throwable -> L40
        r15.name = ContactsUtils.getContactName(r12, r16);     // Catch: Throwable -> L40
        if (TextUtils.isEmpty(r16) == true) goto L24;
        boolean r17 = true;
    L25:
        r15.hasname = r17;     // Catch: Throwable -> L40
        r15.sortkey = r9.getString(5);     // Catch: Throwable -> L40
        r15.phoneBookLabel = r9.getString(9);     // Catch: Throwable -> L40
        r15.section = ContactsUtils.getContactSection(r15.sortkey, r15.phoneBookLabel);     // Catch: Throwable -> L40
        r15.LookKey = r9.getString(6);     // Catch: Throwable -> L40
        r15.photoId = r9.getLong(3);     // Catch: Throwable -> L40
        r15.raw_contactid = r9.getLong(7);     // Catch: Throwable -> L40
        r15.accountType = r9.getString(10);     // Catch: Throwable -> L40
        r15.accountName = r9.getString(11);     // Catch: Throwable -> L40
        if (r9.getCount() >= 30) goto L28;
    L34:
        SamContact r18 = ContactsUtils.generateIfFamilyNameNeedPolyphone(r15);     // Catch: Throwable -> L40
        if (r18 == null) goto L37;
        r13.add(r18);     // Catch: Throwable -> L40
        r11 = r11 + 1;     // Catch: Throwable -> L40
    L37:
        r13.add(r15);     // Catch: Throwable -> L40
        goto L19
    L28:
        if (r14.size() >= 3) goto L34;
        if ((!r2.isEmpty()) == false) goto L34;
        if (r2.containsKey(Long.valueOf(r15.contactId)) == false) goto L34;
        SamContact r19 = r15.getCopy();     // Catch: Throwable -> L40
        r19.section = r12.getString(R.string.latest_contact);     // Catch: Throwable -> L40
        r19.addedTime = r2.remove(Long.valueOf(r19.contactId));     // Catch: Throwable -> L40
        r19.hasAddedTime = true;     // Catch: Throwable -> L40
        r14.add(r19);     // Catch: Throwable -> L40
        goto L34
    L24:
        r17 = false;
        goto L25
    L39:
        r9.close();
        r10 = r11;
    L40:
        th = move-exception;
        r9.close();
        throw th;
    L13:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getAll error:" + e);
        r9 = null;
        goto L15
    L9:
        Intrinsics.checkNotNullExpressionValue(r4, "queryUri");
        r4 = appendAccountsFilterQueryParameter(r4);
        goto L10
    L5:
        r3 = CONTACT_QUERY;
        goto L6
    }

    private final void setContactsListFooter(Context r6, ArrayList<SamContact> r7, int r8) {
        if (r7.size() != 0) goto L8;
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == true) goto L8;
        return;
    L8:
        if (r7.size() == 1) goto L10;
    L14:
        HashMap r0 = new HashMap();
        setContactsStatistics(r6, r0);
        SamContact r5 = new SamContact(2);
        r5.section = r7.get(r7.size() - 1).section;
        r5.count = r7.size() - r8;
        r5.statisticMap = r0;
        r7.add(r5);
        return;
    L10:
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == false) goto L14;
        SamContact r1 = r7.get(0);
        Intrinsics.checkNotNullExpressionValue(r1, "contactsList.get(0)");
        SamContact r2 = r1;
        if (ContactsUtils.DEBUG == false) goto L14;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Judge unique contact: " + r2.raw_contactid);
        goto L14
    }

    private final void setContactsStatistics(Context r17, Map<String, Integer> r18) {
        AccountTypeManager r2 = AccountTypeManager.getInstance(this.mContext);
        HashMap r3 = new HashMap();
        ContactListFilterController r4 = this.mContactListFilterController;
        if (r4 == null) goto L5;
        Set<ContactListFilter> r5 = r4.getFilters();
    L6:
        String r10 = "";
        if (r5 != null) goto L33;
        List<AccountWithDataSet> r6 = r2.getAccounts(false);
        if (r6 != null) goto L11;
    L22:
        if (r6 != null) goto L24;
    L43:
        Uri r7 = CONTACTS_STATISTICS;
        if (this.mIsHasPhoneNum == false) goto L46;
        r7 = r7.buildUpon().appendQueryParameter("has_phone_number", "true").build();
        Intrinsics.checkNotNullExpressionValue(r7, "statisticsQueryUri.build…                 .build()");
    L46:
        Cursor r8 = r17.getContentResolver().query(r7, null, null, null, null);
        if (r8 == null) goto L79;
    L82:
        if (r8.moveToNext() == false) goto L74;
        Pair r9 = Pair.create(r8.getString(0), r8.getString(1));     // Catch: Throwable -> L75
        int r11 = r8.getInt(2);     // Catch: Throwable -> L75
        if (r3.containsKey(r9) == false) goto L82;
        if (r11 <= 0) goto L82;
        AccountType r12 = (AccountType) r3.get(r9);     // Catch: Throwable -> L75
        if (Intrinsics.areEqual(ContactsUtils.LOCAL_ACCOUNT_TYPE, r9.first) == false) goto L58;
        String r13 = r17.getResources().getString(R.string.local_bytedance_contact);     // Catch: Throwable -> L75
    L56:
        String r14 = r13;
    L67:
        if (r14 == null) goto L82;
        Integer r15 = r18.get(r14);     // Catch: Throwable -> L75
        if (r15 == null) goto L71;
        r11 = r11 + r15.intValue();     // Catch: Throwable -> L75
    L71:
        Integer r16 = r18.put(r14, Integer.valueOf(r11));     // Catch: Throwable -> L75
        goto L82
    L58:
        if (Intrinsics.areEqual("com.android.sim", r9.first) == false) goto L60;
        r13 = ContactsUtils.getAccountName(this.mContext, (String) r9.first, (String) r9.second);     // Catch: Throwable -> L75
        goto L56
    L60:
        if (r12 == null) goto L62;
        CharSequence r19 = r12.getDisplayLabel(r17);     // Catch: Throwable -> L75
    L64:
        if ((r19 instanceof String) == false) goto L66;
        r14 = (String) r19;     // Catch: Throwable -> L75
        goto L67
    L66:
        r14 = null;
        goto L67
    L62:
        r19 = null;
        goto L64
    L74:
        r8.close();
    L75:
        th = move-exception;
        r8.close();
        throw th;
    L79:
        if (ContactsUtils.DEBUG == false) goto L99;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "Contacts statistics: " + r18);
        return;
    L99:
        return;
    L24:
        if (r6.size() != 0) goto L43;
        ContactListFilter r20 = ContactListFilter.createAccountFilter(ContactsUtils.LOCAL_ACCOUNT_TYPE, "default", null);
        String r110 = r20.accountType;
        if (r110 != null) goto L28;
        r110 = "";
    L28:
        String r111 = r20.accountName;
        if (r111 == null) goto L32;
        r10 = r111;
    L32:
        Pair r112 = Pair.create(r110, r10);
        Intrinsics.checkNotNullExpressionValue(r112, "create<String, String>(\n… \"\"\n                    )");
        AccountType r21 = r2.getAccountType(r20.accountType, r20.dataSet);
        Intrinsics.checkNotNullExpressionValue(r21, "accountTypeManager.getAc…ountType, filter.dataSet)");
        r3.put(r112, r21);
        goto L43
    L11:
        if (r6.size() <= 0) goto L22;
        Iterator<AccountWithDataSet> r113 = r6.iterator();
    L14:
        if (r113.hasNext() == false) goto L22;
        AccountWithDataSet r114 = r113.next();
        String r115 = r114.type;
        if (r115 != null) goto L18;
        r115 = "";
    L18:
        String r116 = r114.name;
        if (r116 != null) goto L21;
        r116 = "";
    L21:
        Pair r117 = Pair.create(r115, r116);
        Intrinsics.checkNotNullExpressionValue(r117, "create<String, String>(\n…                        )");
        AccountType r118 = r2.getAccountTypeForAccount(r114);
        Intrinsics.checkNotNullExpressionValue(r118, "accountTypeManager.getAc…ntTypeForAccount(account)");
        r3.put(r117, r118);
        goto L14
    L33:
        Iterator<ContactListFilter> r22 = r5.iterator();
    L35:
        if (r22.hasNext() == false) goto L43;
        ContactListFilter r119 = r22.next();
        String r120 = r119.accountType;
        if (r120 != null) goto L39;
        r120 = "";
    L39:
        String r121 = r119.accountName;
        if (r121 != null) goto L42;
        r121 = "";
    L42:
        Pair r122 = Pair.create(r120, r121);
        Intrinsics.checkNotNullExpressionValue(r122, "create<String, String>(\n… \"\"\n                    )");
        AccountType r123 = r2.getAccountType(r119.accountType, r119.dataSet);
        Intrinsics.checkNotNullExpressionValue(r123, "accountTypeManager.getAc…ountType, filter.dataSet)");
        r3.put(r122, r123);
        goto L35
    L5:
        r5 = null;
        goto L6
    }

    private final void setProfileData(Context r9, int r10, ArrayList<SamContact> r11) {
        if (r10 == 1) goto L6;
        return;
    L6:
        if (ContactsUtils.isBytedanceFeatureVersion_3_0_Enabled() == false) goto L8;
    L10:
        Cursor r12 = null;
        r12 = r9.getContentResolver().query(PROFILE_QUERY_URI, new String[]{GroupSelectionActivity.EXTRA_RAW_CONTACT_ID, "display_name", "photo_id", "data1", "mimetype"}, null, null, null);     // Catch: Throwable -> L57
        SamContact r1 = new SamContact(1);     // Catch: Throwable -> L57
        r1.section = r9.getResources().getString(R.string.common_i);     // Catch: Throwable -> L57
        if (r12 != null) goto L14;
    L32:
        r1.name = r9.getResources().getString(R.string.profile_display_name);     // Catch: Throwable -> L57
        r1.contactId = -1;     // Catch: Throwable -> L57
        if (DSUtils.isMultiSimEnabled() == true) goto L35;
        r1.number = getProfileNumber(r9);     // Catch: Throwable -> L57
        r1.normalized_number = ContactsUtils.formatNumber(r1.number);     // Catch: Throwable -> L57
    L53:
        r11.add(0, r1);     // Catch: Throwable -> L57
        SamContact r8 = new SamContact(1);     // Catch: Throwable -> L57
        r8.name = r9.getResources().getString(R.string.mine_group);     // Catch: Throwable -> L57
        r8.contactId = -2;     // Catch: Throwable -> L57
        r8.photoId = 0;     // Catch: Throwable -> L57
        r8.section = r9.getResources().getString(R.string.common_i);     // Catch: Throwable -> L57
        r11.add(1, r8);     // Catch: Throwable -> L57
        if (r12 == null) goto L65;
        r12.close();
        return;
    L65:
        return;
    L35:
        String r13 = r9.getString(R.string.unknown_number);     // Catch: Throwable -> L57
        Intrinsics.checkNotNullExpressionValue(r13, "context.getString(R.string.unknown_number)");     // Catch: Throwable -> L57
        String r4 = DSUtils.getSimNumber(r9, 0);     // Catch: Throwable -> L57
        String r5 = DSUtils.getSimNumber(r9, 1);     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r4) == false) goto L38;
    L40:
        boolean r6 = false;
    L42:
        if (TextUtils.isEmpty(r5) == false) goto L44;
    L46:
        boolean r14 = false;
    L47:
        if (r6 == false) goto L51;
        r1.number = r4;     // Catch: Throwable -> L57
        if (r14 == false) goto L53;
        r1.normalized_number = r5;     // Catch: Throwable -> L57
        goto L53
    L51:
        if (r14 == false) goto L53;
        r1.number = r5;     // Catch: Throwable -> L57
        goto L53
    L44:
        if (TextUtils.equals(r13, r5) == true) goto L46;
        r14 = true;
        goto L47
    L38:
        if (TextUtils.equals(r13, r4) == true) goto L40;
        r6 = true;
        goto L42
    L14:
        if (r12.moveToFirst() == false) goto L32;
        r1.name = ContactsUtils.getContactName(r9, r12.getString(1));     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r12.getString(1)) == true) goto L18;
        boolean r15 = true;
    L19:
        r1.hasname = r15;     // Catch: Throwable -> L57
        r1.contactId = r12.getLong(0);     // Catch: Throwable -> L57
        r1.photoId = r12.getLong(2);     // Catch: Throwable -> L57
    L21:
        if (Intrinsics.areEqual("vnd.android.cursor.item/phone_v2", r12.getString(4)) == false) goto L30;
        String r16 = r12.getString(3);     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r16) == true) goto L30;
        StringBuilder r7 = new StringBuilder();     // Catch: Throwable -> L57
        if (TextUtils.isEmpty(r1.number) == false) goto L27;
        String r17 = "";
    L28:
        r1.number = r7.append(r17).append(r16).toString();     // Catch: Throwable -> L57
        goto L30
    L27:
        r17 = r1.number + ':';     // Catch: Throwable -> L57
    L30:
        if (r12.moveToNext() == true) goto L21;
    L18:
        r15 = false;
    L57:
        th = move-exception;
        if (r12 == null) goto L60;
        r12.close();
    L60:
        throw th;
    L8:
        if (r11.size() != 0) goto L10;
    }

    private static final void mRefreshProfileRunnable$lambda$36(NewContactListFragment r5) {
        Intrinsics.checkNotNullParameter(r5, "this$0");
        ArrayList<SamContact> r0 = new ArrayList();
        ArrayList<SamContact> r1 = r5.mOldContacts;
        if (r1 == null) goto L10;
        Iterator<SamContact> r2 = r1.iterator();
    L6:
        if (r2.hasNext() == false) goto L10;
        SamContact r3 = r2.next();
        if (r3.getType() == 1) goto L6;
        r0.add(r3);
    L10:
        FragmentActivity r4 = r5.getActivity();
        if (r4 == null) goto L13;
        r5.setProfileData(r4, 1, r0);
    L13:
        r5.mOldContacts = r0;
        r5.notifyDataSetChangedBySortMode(r0, 1);
    }

    private final void notifyDataSetChangedBySortMode(ArrayList<SamContact> r3, int r4) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L5;
        r0.removeMessages(1001);
    L5:
        Message r1 = new Message();
        r1.what = 1001;
        r1.obj = r3;
        r1.arg1 = r4;
        Handler r2 = this.mHandler;
        if (r2 == null) goto L9;
        r2.sendMessage(r1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        stopListScrollFpsSampling();
        this.mHandler.removeCallbacksAndMessages(null);
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onDestroy() {
        SearchUtils.reportSearchEventAndClear();
        super.onDestroy();
        if (DSUtils.isMultiSimEnabled() == false) goto L5;
        DSUtils.unregisterIccStateListener(this.mIccStateListener);
    L5:
        unregisterObserver();
        unregisterBcrDataObserver();
        AvatarImageHelper.getIntance().removeAvatarTextFontChangeListener(this);
        ContactListFilterController r0 = this.mContactListFilterController;
        if (r0 == null) goto L9;
        if (r0 == null) goto L9;
        r0.removeListener(this);
    L9:
        SearchResultAdapter r1 = this.mSearchResultAdapter;
        if (r1 == null) goto L13;
        if (r1 == null) goto L13;
        r1.destory();
    L13:
        IContactSearchBarPresenter r2 = this.mPresenter;
        if (r2 == null) goto L17;
        if (r2 == null) goto L17;
        r2.detachView();
    L17:
        SearchUtils.stopSearchAsync("onDestroy");
        BlacklistChangeListener r3 = this.mBlacklistChangeListener;
        if (r3 == null) goto L24;
        BlacklistManager r4 = this.mBlacklistManager;
        if (r4 == null) goto L23;
        if (r4 == null) goto L23;
        r4.removeOnBlacklistChangeListener(r3);
    L23:
        this.mBlacklistChangeListener = null;
    L24:
        this.mPool.shutdownNow();
    }

    private final String getProfileNumber(Context r7) {
        Object r6 = r7.getSystemService("phone");
        Intrinsics.checkNotNull(r6, "null cannot be cast to non-null type android.telephony.TelephonyManager");
        String r8 = ((TelephonyManager) r6).getLine1Number();
        if (ContactsUtils.isFeatureUSEnabled() == false) goto L5;
        return r8;
    L5:
        if (TextUtils.isEmpty(r8) == false) goto L7;
        return r8;
    L7:
        if (r8 != null) goto L9;
    L11:
        boolean r2 = false;
    L12:
        if (r2 == false) goto L47;
        if (r8 == null) goto L34;
        String r9 = r8.substring(3);
        Intrinsics.checkNotNullExpressionValue(r9, "substring(...)");
        if (r9 == null) goto L34;
        String r10 = r9;
        int r11 = r10.length() - 1;
        int r3 = 0;
        boolean r4 = false;
    L17:
        if (r3 > r11) goto L48;
        if (r4 == true) goto L20;
        int r5 = r3;
    L22:
        if (Intrinsics.compare(r10.charAt(r5), 32) > 0) goto L24;
        boolean r12 = true;
    L25:
        if (r4 == false) goto L26;
        if (r12 == false) goto L48;
        r11 = r11 - 1;
        goto L17
    L26:
        if (r12 == false) goto L27;
        r3 = r3 + 1;
        goto L17
    L27:
        r4 = true;
        goto L17
    L24:
        r12 = false;
        goto L25
    L20:
        r5 = r11;
    L48:
        return r10.subSequence(r3, r11 + 1).toString();
    L34:
        return null;
    L47:
        return r8;
    L9:
        if (StringsKt.startsWith$default(r8, "+86", false, 2, null) != true) goto L11;
        r2 = true;
        goto L12
    }

    private final void init() {
        Thread r0 = new Thread(new NewContactListFragment$init$loadThread$1(this));
        this.mPool.submit(r0);
    }

    private final void initData(int r7, boolean r8) {
        ArrayList<SamContact> r9 = getListDataBySortMode(r7, r8);     // Catch: Throwable -> L39
        if (this.mIsEdit == true) goto L6;
    L37:
        this.mDataIsReady = true;
        notifyDataSetChangedBySortMode(r9, r7);
        return;
    L6:
        if ((!this.mSelectedSet.isEmpty()) == false) goto L37;
        Iterator<Long> r1 = this.mSelectedSet.iterator();     // Catch: Throwable -> L39
        if (r1 != null) goto L11;
        this.mDataIsReady = true;
        return;
    L11:
        if (r1.hasNext() == false) goto L37;
        Long r2 = r1.next();     // Catch: Throwable -> L39
        Intrinsics.checkNotNullExpressionValue(r2, "iterator.next()");     // Catch: Throwable -> L39
        long r3 = r2.longValue();     // Catch: Throwable -> L39
        if (r7 != 32) goto L19;
        if (this.mContactsIdSIM1.contains(Long.valueOf(r3)) == true) goto L19;
        r1.remove();     // Catch: Throwable -> L39
    L19:
        if (r7 != 64) goto L24;
        if (this.mContactsIdSIM2.contains(Long.valueOf(r3)) == true) goto L24;
        r1.remove();     // Catch: Throwable -> L39
    L24:
        if (r7 != 128) goto L29;
        if (this.mContactsIdBCR.contains(Long.valueOf(r3)) == true) goto L29;
        r1.remove();     // Catch: Throwable -> L39
    L29:
        if (r7 != 256) goto L34;
        if (this.mPhoneContactsIdList.contains(Long.valueOf(r3)) == true) goto L34;
        r1.remove();     // Catch: Throwable -> L39
    L34:
        if (this.mContactsIdList.contains(Long.valueOf(r3)) == true) goto L11;
        r1.remove();     // Catch: Throwable -> L39
    L39:
        th = move-exception;
        this.mDataIsReady = true;
        throw th;
    }

    private final void preloadContactsData() {
        this.mIsPreloading = true;
        this.mIsHasPhoneNum = ContactsUtils.contactsWithPhoneOnly(ContactsApplication.getInstance());
        ArrayList<SamContact> r1 = new ArrayList();
        boolean r2 = loadContactsFromFile(CACHE_FILE_NAME, r1);
        if (this.mOldContacts != null) goto L9;
        this.mOldContacts = r1;
        if (r2 == false) goto L7;
        int r3 = 2;
    L8:
        this.mQuickBarState = r3;
        notifyDataSetChangedBySortMode(r1, 1);
        goto L9
    L7:
        r3 = 1;
    L9:
        this.mIsPreloading = false;
    }

    private final void saveContactsToFile(final ArrayList<SamContact> r3, final String r4, final boolean r5) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "saveContactsToFile: " + r3.size());
    L5:
        Thread r0 = new Thread(new NewContactListFragment$saveContactsToFile$t$1(r3, this, r4, r5));
        r0.setPriority(10);
        r0.start();
    }

    private final boolean loadContactsFromFile(String r9, ArrayList<SamContact> r10) {
        Parcel r3 = Parcel.obtain();
        Intrinsics.checkNotNullExpressionValue(r3, "obtain()");
        boolean r4 = false;
        FileInputStream r11 = ContactsApplication.getInstance().getApplicationContext().openFileInput(r9);     // Catch: Throwable -> L30
        FileInputStream r5 = r11;     // Catch: Throwable -> L25
        int r6 = r5.available();     // Catch: Throwable -> L25
        ContactsUtils.debugLogD(TAG, "file size: " + r6);     // Catch: Throwable -> L25
        byte[] r2 = new byte[r6];     // Catch: Throwable -> L25
        int r7 = r5.read(r2);     // Catch: Throwable -> L25
        ContactsUtils.debugLogD(TAG, "readed size: " + r7);     // Catch: Throwable -> L25
        r3.unmarshall(r2, 0, r7);     // Catch: Throwable -> L25
        r3.setDataPosition(0);     // Catch: Throwable -> L25
        if (r3.readByte() == 2) goto L11;
        ContactsUtils.debugLogD(TAG, "version not match 2 : " + r7);     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L30
        r3.recycle();
        return false;
    L11:
        if (r3.readByte() <= 0) goto L13;
        r4 = true;
    L13:
        int r0 = r3.readInt();     // Catch: Throwable -> L25
    L15:
        if (r3.dataAvail() <= 0) goto L20;
        SamContact r8 = SamContact.CREATOR.createFromParcel(r3);     // Catch: Throwable -> L25
        if (r8 == null) goto L20;
        r10.add(r8);     // Catch: Throwable -> L25
    L20:
        if (r10.size() <= 0) goto L22;
        r10.get(r10.size() - 1).count = r0;     // Catch: Throwable -> L25
    L22:
        Unit r1 = Unit.INSTANCE;     // Catch: Throwable -> L25
        CloseableKt.closeFinally(r11, null);     // Catch: Throwable -> L30
    L34:
        r3.recycle();
        ContactsUtils.debugLogD(TAG, "loadContactsFromFile: " + r10.size());
        return r4;
    L25:
        th = move-exception;
        throw th;     // Catch: Throwable -> L27
    L27:
        th = move-exception;
        CloseableKt.closeFinally(r11, th);     // Catch: Throwable -> L30
        throw th;     // Catch: Throwable -> L30
    L30:
        th = move-exception;
    L36:
        th = move-exception;
        r3.recycle();
        throw th;
    L32:
        if (ContactsUtils.DEBUG == false) goto L34;
        th.printStackTrace();     // Catch: Throwable -> L36
        goto L34
    }

    private final boolean loadContactsSortByName(ArrayList<SamContact> r9) {
        ArrayList<SamContact> r2 = new ArrayList();
        FragmentActivity r3 = getActivity();     // Catch: Exception -> L12
        boolean r4 = false;
        if (r3 != null) goto L6;
        return false;
    L6:
        FragmentActivity r5 = r3;     // Catch: Exception -> L12
        int r6 = getAll(r5, r9, r2);     // Catch: Exception -> L12
        Collections.sort(r9, new NameSortComparator());     // Catch: Exception -> L12
        setContactsListFooter(r5, r9, r6);     // Catch: Exception -> L12
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "loadContactsSortByName after setContactsListFooter " + r6);     // Catch: Exception -> L12
        if ((!r2.isEmpty()) == false) goto L9;
        Collections.sort(r2, new AddedTimeSortComparator(this));     // Catch: Exception -> L12
        r9.addAll(0, r2);     // Catch: Exception -> L12
        r4 = true;
    L9:
        setProfileData(r5, 1, r9);     // Catch: Exception -> L12
        saveContactsToFile(r9, CACHE_FILE_NAME, r4);     // Catch: Exception -> L12
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "loadContactsSortByName: end");
        return r4;
    L12:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "loadContactsSortByName error:" + e);
        throw e;
    }

    private final ArrayList<SamContact> getListDataBySortMode(int r5, boolean r6) {
        ArrayList<SamContact> r0 = new ArrayList();
        int r1 = 2;
        if (r5 == 1) goto L86;
        if (r5 == 2) goto L78;
        if (r5 == 4) goto L70;
        if (r5 == 8) goto L62;
        if (r5 == 16) goto L54;
        if (r5 == 32) goto L46;
        if (r5 == 64) goto L38;
        if (r5 == 128) goto L30;
        if (r5 == 256) goto L21;
        return r0;
    L21:
        if (dataIsReady(r5) == false) goto L28;
        if (r6 == true) goto L28;
        ArrayList<SamContact> r4 = this.mOldContactsPhoneItems;
        if (r4 != null) goto L98;
        return r0;
    L98:
        return r4;
    L28:
        ArrayList<SamContact> r2 = getPhoneContacts();
        this.mQuickBarState = 0;
        Collections.sort(r2, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsPhoneItems = r2;
        return r2;
    L30:
        if (dataIsReady(r5) == false) goto L36;
        if (r6 == true) goto L36;
        r4 = this.mOldContactsBCRItems;
        if (r4 != null) goto L98;
        return r0;
    L36:
        ArrayList<SamContact> r3 = getBusinessCardContacts();
        this.mQuickBarState = 0;
        Collections.sort(r3, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsBCRItems = r3;
        return r3;
    L38:
        if (dataIsReady(r5) == false) goto L44;
        if (r6 == true) goto L44;
        r4 = this.mOldContactsSim2Items;
        if (r4 != null) goto L98;
        return r0;
    L44:
        ArrayList<SamContact> r7 = getSimContacts(1);
        Collections.sort(r7, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsSim2Items = r7;
        return r7;
    L46:
        if (dataIsReady(r5) == false) goto L52;
        if (r6 == true) goto L52;
        r4 = this.mOldContactsSim1Items;
        if (r4 != null) goto L98;
        return r0;
    L52:
        ArrayList<SamContact> r8 = getSimContacts(0);
        Collections.sort(r8, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsSim1Items = r8;
        return r8;
    L54:
        if (dataIsReady(r5) == false) goto L60;
        if (r6 == true) goto L60;
        r4 = this.mOldContactsCompanyItems;
        if (r4 != null) goto L98;
        return r0;
    L60:
        ArrayList<SamContact> r9 = getAllContactsWithCompany();
        Collections.sort(r9, new ExpandableSortComparator(this));
        setModeState(r5, true);
        this.mOldContactsCompanyItems = r9;
        return r9;
    L62:
        if (dataIsReady(r5) == false) goto L68;
        if (r6 == true) goto L68;
        r4 = this.mOldContactAddedTimeItems;
        if (r4 != null) goto L98;
        return r0;
    L68:
        ArrayList<SamContact> r10 = getAddedTimeContacts();
        Collections.sort(r10, new AddedTimeSortComparator(this));
        setModeState(r5, true);
        this.mOldContactAddedTimeItems = r10;
        return r10;
    L70:
        if (dataIsReady(r5) == false) goto L76;
        if (r6 == true) goto L76;
        r4 = this.mOldContactTimesItems;
        if (r4 != null) goto L98;
        return r0;
    L76:
        ArrayList<SamContact> r11 = getContactsTimes();
        Collections.sort(r11, new ContactedTimesSortComparator());
        setModeState(r5, true);
        this.mOldContactTimesItems = r11;
        return r11;
    L78:
        if (dataIsReady(r5) == false) goto L84;
        if (r6 == true) goto L84;
        r4 = this.mOldContactCityItems;
        if (r4 != null) goto L98;
        return r0;
    L84:
        ContactsUtils.setCpuBoost(1000);
        ArrayList<SamContact> r12 = getAllCityContacts();
        Collections.sort(r12, new CityNameSortComparator(this));
        setModeState(r5, true);
        this.mOldContactCityItems = r12;
        return r12;
    L86:
        if (dataIsReady(r5) == false) goto L93;
        if (r6 == true) goto L93;
        r4 = this.mOldContacts;
        if (r4 != null) goto L98;
        return r0;
    L93:
        if (loadContactsSortByName(r0) == true) goto L96;
        r1 = 1;
    L96:
        this.mQuickBarState = r1;
        setModeState(r5, true);
        this.mOldContacts = r0;
        return r0;
    }

    private final String getPinYinCityName(String r10) {
        if (TextUtils.isEmpty(r10) == false) goto L5;
        return "";
    L5:
        if (this.mCityPinYinMap.containsKey(r10) == true) goto L10;
        String r0 = ContactsUtils.getPinyinName(r10);
        Intrinsics.checkNotNullExpressionValue(r0, "getPinyinName(cityName)");
        Locale r1 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r1, "getDefault()");
        String r3 = r0.toUpperCase(r1);
        Intrinsics.checkNotNullExpressionValue(r3, "toUpperCase(...)");
        String r2 = StringsKt.replace$default(r3, HanziToPinyin.Token.SEPARATOR, "", false, 4, null);
        this.mCityPinYinMap.put(r10, r2);
        return r2;
    L10:
        return this.mCityPinYinMap.get(r10);
    }

    private final void sendWaitTipMessage(int r3) {
        this.mHandler.removeMessages(1003);
        Message r0 = new Message();
        r0.what = 1003;
        r0.arg1 = r3;
        this.mHandler.sendMessage(r0);
    }

    private final ArrayList<SamContact> getAllCityContacts() {
        HashSet<Long> r1 = new HashSet();
        long r2 = System.currentTimeMillis();
        ArrayList<SamContact> r4 = new ArrayList();
        Uri r7 = ContactsContract.CommonDataKinds.Phone.CONTENT_URI.buildUpon().appendQueryParameter("directory", "0").build().buildUpon().appendQueryParameter("remove_duplicate_entries", "true").build();
        PreferencesCallback r5 = this.mPrefsCallback;
        if (r5 == null) goto L5;
        Integer r6 = Integer.valueOf(r5.getDisplayOrder());
    L6:
        PreferencesCallback r8 = this.mPrefsCallback;
        if (r8 == null) goto L9;
        Integer r9 = Integer.valueOf(r8.getSortOrder());
    L10:
        String r10 = PHONE_ID_SELECTION;
        String[] r11 = PHONE_ID_SELECTION_ARGS;
        boolean r13 = false;
        if (this.mNoContactsSelected == false) goto L14;
        String r12 = NO_ACCOUNTS_SELECTION;
        String[] r14 = null;
    L25:
        if (r6 == null) goto L83;
        if (r9 == null) goto L83;
        FragmentActivity r15 = this.mActivity;
        if (r15 == null) goto L83;
        ContentResolver r16 = r15.getContentResolver();
        if (r16 == null) goto L83;
        Cursor r17 = r16.query(r7, PhoneQuery.INSTANCE.getProjection(r6.intValue(), r9.intValue()), r12, r14, "contact_id, data12");
        if (r17 == null) goto L83;
        boolean r18 = true;
        this.mDataIsReady = true;
        ArrayList r19 = new ArrayList();
        String r20 = ContactsUtils.getUnknownLocationLabel();
        long r21 = -1;
        boolean r110 = false;
    L37:
        if (r17.moveToNext() == false) goto L82;
        if (r110 == true) goto L51;
        ArrayList<SamContact> r111 = this.mOldContactCityItems;
        if (r111 == null) goto L48;
        if (r111 != null) goto L44;
    L46:
        boolean r112 = r13;
    L47:
        if (r112 == false) goto L51;
    L44:
        if (r111.size() != 0) goto L46;
        r112 = r18;
    L48:
        r19 = r19;
        if ((System.currentTimeMillis() - r2) <= this.TIME_NEED_TO_TIP) goto L52;
        sendWaitTipMessage(2);
        int r22 = 1;
        r110 = true;
    L53:
        long r113 = r17.getLong(r22);
        String r114 = r17.getString(0);
        String r23 = r17.getString(13);
        long r115 = r17.getLong(12);
        if (r113 != r21) goto L55;
        SamContact r24 = r4.get(r4.size() - 1);
        Intrinsics.checkNotNullExpressionValue(r24, "contactCityItems.get(contactCityItems.size - 1)");
        SamContact r25 = r24;
        long r26 = r2;
        if (TextUtils.equals(r25.headerData, r23) == false) goto L60;
        r25.numbersMap.put(Long.valueOf(r115), r114);
        r2 = r26;
        r18 = true;
        r13 = false;
    L60:
        if (ContactsUtils.isExistInList(r19, r114) == false) goto L62;
        r18 = true;
        boolean r27 = false;
    L81:
        r13 = r27;
        r2 = r26;
        goto L37
    L62:
        SamContact r3 = new SamContact(0);
        r3.number = r114;
        r3.numbersMap = new HashMap();
        r3.numbersMap.put(Long.valueOf(r115), r114);
        r3.contactId = r113;
        r1.add(Long.valueOf(r3.contactId));
        r3.phoneId = r17.getLong(12);
        if (r17.getInt(2) <= 0) goto L65;
        boolean r28 = true;
    L66:
        r3.isSuperPrimary = r28;
        r3.labelType = r17.getInt(3);
        r3.label = r17.getString(4);
        FragmentActivity r29 = this.mActivity;
        if (r29 == null) goto L69;
        Resources r30 = r29.getResources();
    L70:
        r3.groupType = ContactsContract.CommonDataKinds.Phone.getTypeLabel(r30, r3.labelType, r3.label);
        r3.name = ContactsUtils.getContactName(this.mActivity, r17.getString(8));
        r3.sortkey = r17.getString(5);
        r3.phoneBookLabel = r17.getString(11);
        r3.section = ContactsUtils.getContactSection(r3.sortkey, r3.phoneBookLabel);
        r3.accountType = r17.getString(15);
        r3.accountName = r17.getString(16);
        r3.normalized_number = r17.getString(6);
        r18 = true;
        r3.hasname = !TextUtils.isEmpty(r3.name);
        r3.LookKey = r17.getString(9);
        r3.photoId = r17.getLong(10);
        if (ContactsUtils.isUnknownLocation(r23) == false) goto L73;
        r3.headerData = r20;
        r3.headerSortData = "WEIZHIDIDIAN";
    L75:
        if (TextUtils.isEmpty(r3.headerSortData) == true) goto L79;
        r27 = false;
        char r31 = r3.headerSortData.charAt(0);
        if (Character.isLetter(r31) == false) goto L80;
        String r32 = String.valueOf(r31);
        Locale r116 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(r116, "getDefault()");
        String r33 = r32.toUpperCase(r116);
        Intrinsics.checkNotNullExpressionValue(r33, "toUpperCase(...)");
        r3.headerSectionData = r33;
    L80:
        r4.add(r3);
        goto L81
    L79:
        r27 = false;
        goto L80
    L73:
        r3.headerData = r23;
        r3.headerSortData = r17.getString(14);
        goto L75
    L69:
        r30 = null;
        goto L70
    L65:
        r28 = false;
        goto L66
    L55:
        r19.clear();
        r26 = r2;
        r21 = r113;
    L52:
        r22 = 1;
    L51:
        r19 = r19;
        goto L52
    L82:
        r17.close();
        this.mContactsIdForLocation = r1;
    L83:
        return r4;
    L14:
        if (TextUtils.isEmpty(this.mAccountsFilterQueryParameter) == true) goto L23;
        List<AccountWithDataSet> r34 = AccountWithDataSet.unstringifyList(this.mAccountsFilterQueryParameter);
        ArrayList r117 = new ArrayList();
        Iterator<AccountWithDataSet> r35 = r34.iterator();
        String r118 = "";
    L17:
        if (r35.hasNext() == false) goto L22;
        AccountWithDataSet r119 = r35.next();
        if (r118.length() == 0) goto L21;
        r118 = r118 + " OR ";
    L21:
        r118 = r118 + "(account_name = ? AND account_type = ?)";
        String r120 = r119.name;
        Intrinsics.checkNotNullExpressionValue(r120, "account.name");
        r117.add(r120);
        String r121 = r119.type;
        Intrinsics.checkNotNullExpressionValue(r121, "account.type");
        r117.add(r121);
        goto L17
    L22:
        String[] r36 = (String[]) r117.toArray(new String[0]);
        r10 = r10 + " AND (" + r118 + ')';
        r14 = new String[0];
        String[] r122 = PHONE_ID_SELECTION_ARGS;
        System.arraycopy(r122, 0, r14, 0, r122.length);
        System.arraycopy(r36, 0, r14, r122.length, r36.length);
    L24:
        r12 = r10;
        goto L25
    L23:
        r14 = r11;
        goto L24
    L9:
        r9 = null;
        goto L10
    L5:
        r6 = null;
        goto L6
    }

    private final ArrayList<SamContact> getAllContactsWithCompany() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        PreferencesCallback r2 = this.mPrefsCallback;
        if (r2 != null) goto L5;
        return r1;
    L5:
        FragmentActivity r3 = this.mActivity;
        if (r3 == null) goto L10;
        ContentResolver r4 = r3.getContentResolver();
        if (r4 == null) goto L10;
        Cursor r5 = r4.query(CONTACTS_WITH_COMPANY_URI, ContactsWithCompany.INSTANCE.getProjection(r2.getDisplayOrder(), r2.getSortOrder()), null, null, null, null);
    L11:
        if (r5 != null) goto L31;
        return r1;
    L31:
        if (r5.moveToNext() == false) goto L26;
        SamContact r6 = new SamContact(0);     // Catch: Throwable -> L28
        r6.contactId = r5.getLong(0);     // Catch: Throwable -> L28
        r0.add(Long.valueOf(r6.contactId));     // Catch: Throwable -> L28
        boolean r7 = true;
        String r8 = r5.getString(1);     // Catch: Throwable -> L28
        r6.name = ContactsUtils.getContactName(this.mActivity, r8);     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r8) == false) goto L19;
        r7 = false;
    L19:
        r6.hasname = r7;     // Catch: Throwable -> L28
        r6.sortkey = r5.getString(2);     // Catch: Throwable -> L28
        r6.phoneBookLabel = r5.getString(9);     // Catch: Throwable -> L28
        r6.section = ContactsUtils.getContactSection(r6.sortkey, r6.sortkey);     // Catch: Throwable -> L28
        r6.LookKey = r5.getString(3);     // Catch: Throwable -> L28
        r6.photoId = r5.getLong(4);     // Catch: Throwable -> L28
        r6.raw_contactid = r5.getLong(5);     // Catch: Throwable -> L28
        r6.accountType = r5.getString(7);     // Catch: Throwable -> L28
        r6.accountName = r5.getString(8);     // Catch: Throwable -> L28
        r6.headerData = r5.getString(6);     // Catch: Throwable -> L28
        r6.headerSortData = ContactsUtils.getPinyinName(r6.headerData);     // Catch: Throwable -> L28
        r6.headerSortSection = ContactsUtils.CHAR_POUND;     // Catch: Throwable -> L28
        if (TextUtils.isEmpty(r6.headerSortData) == true) goto L24;
        char r9 = r6.headerSortData.charAt(0);     // Catch: Throwable -> L28
        String r10 = String.valueOf(r9);     // Catch: Throwable -> L28
        Locale r11 = Locale.getDefault();     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r11, "getDefault()");     // Catch: Throwable -> L28
        String r12 = r10.toUpperCase(r11);     // Catch: Throwable -> L28
        Intrinsics.checkNotNullExpressionValue(r12, "toUpperCase(...)");     // Catch: Throwable -> L28
        r6.headerSectionData = r12;     // Catch: Throwable -> L28
        if (Character.isLetter(r9) == false) goto L24;
        r6.headerSortSection = String.valueOf(r9);     // Catch: Throwable -> L28
    L24:
        r1.add(r6);     // Catch: Throwable -> L28
        goto L31
    L26:
        r5.close();
        this.mContactsIdList = r0;
        return r1;
    L28:
        th = move-exception;
        r5.close();
        throw th;
    L10:
        r5 = null;
        goto L11
    }

    private final ArrayList<SamContact> getPhoneContacts() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        Uri r3 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mIsHasPhoneNum == false) goto L5;
        String r2 = CONTACT_CITY_QUERY + " and " + CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY;
    L6:
        String r5 = r2;
        Context r4 = this.mContext;
        if (r4 == null) goto L25;
        ContentResolver r6 = r4.getContentResolver();
        if (r6 == null) goto L25;
        Cursor r7 = r6.query(r3, getContactProjection(), r5, null, CONTACT_SORT);
        if (r7 == null) goto L25;
    L26:
    L22:
        th = move-exception;
        r7.close();
        throw th;
    L14:
        if (r7.moveToNext() == false) goto L20;
        boolean r8 = false;
        SamContact r9 = new SamContact(0);     // Catch: Throwable -> L22
        r9.contactId = r7.getLong(0);     // Catch: Throwable -> L22
        r0.add(Long.valueOf(r9.contactId));     // Catch: Throwable -> L22
        String r10 = r7.getString(1);     // Catch: Throwable -> L22
        r9.name = ContactsUtils.getContactName(this.mActivity, r10);     // Catch: Throwable -> L22
        if (TextUtils.isEmpty(r10) == true) goto L18;
        r8 = true;
    L18:
        r9.hasname = r8;     // Catch: Throwable -> L22
        r9.sortkey = r7.getString(5);     // Catch: Throwable -> L22
        r9.phoneBookLabel = r7.getString(9);     // Catch: Throwable -> L22
        r9.section = ContactsUtils.getContactSection(r9.sortkey, r9.phoneBookLabel);     // Catch: Throwable -> L22
        r9.LookKey = r7.getString(6);     // Catch: Throwable -> L22
        r9.photoId = r7.getLong(3);     // Catch: Throwable -> L22
        r9.raw_contactid = r7.getLong(7);     // Catch: Throwable -> L22
        r9.accountType = r7.getString(10);     // Catch: Throwable -> L22
        r9.accountName = r7.getString(11);     // Catch: Throwable -> L22
        r1.add(r9);     // Catch: Throwable -> L22
        goto L26
    L20:
        r7.close();
        this.mPhoneContactsIdList = r0;
        return r1;
    L25:
        return r1;
    L5:
        r2 = CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY;
        goto L6
    }

    private final ArrayList<SamContact> getSimContacts(int r10) {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        Uri r3 = ContactsContract.Contacts.CONTENT_URI;
        String r2 = MoreContactUtils.getSimAccountName(r10);
        Context r4 = this.mContext;
        if (r4 == null) goto L27;
        ContentResolver r5 = r4.getContentResolver();
        if (r5 == null) goto L27;
        Cursor r6 = r5.query(r3, null, "account_type = 'com.android.sim' and account_name = '" + r2 + '\'', null, null);
        if (r6 == null) goto L27;
    L28:
        boolean r7 = true;
        if (r6.moveToNext() == false) goto L17;
        SamContact r8 = new SamContact(0);     // Catch: Throwable -> L24
        r8.contactId = r6.getLong(r6.getColumnIndex("_id"));     // Catch: Throwable -> L24
        r0.add(Long.valueOf(r8.contactId));     // Catch: Throwable -> L24
        String r9 = r6.getString(r6.getColumnIndex("display_name"));     // Catch: Throwable -> L24
        r8.name = ContactsUtils.getContactName(this.mActivity, r9);     // Catch: Throwable -> L24
        if (TextUtils.isEmpty(r9) == false) goto L15;
        r7 = false;
    L15:
        r8.hasname = r7;     // Catch: Throwable -> L24
        r8.sortkey = r6.getString(r6.getColumnIndex(PickerFragment.CONTACT_SORT_CNAME));     // Catch: Throwable -> L24
        r8.section = ContactsUtils.getContactSection(r8.sortkey);     // Catch: Throwable -> L24
        r8.LookKey = r6.getString(r6.getColumnIndex("lookup"));     // Catch: Throwable -> L24
        r8.photoId = r6.getLong(r6.getColumnIndex("photo_id"));     // Catch: Throwable -> L24
        r8.raw_contactid = r6.getLong(r6.getColumnIndex("name_raw_contact_id"));     // Catch: Throwable -> L24
        r8.accountType = r6.getString(r6.getColumnIndex("account_type"));     // Catch: Throwable -> L24
        r8.accountName = r6.getString(r6.getColumnIndex("account_name"));     // Catch: Throwable -> L24
        r1.add(r8);     // Catch: Throwable -> L24
        goto L28
    L17:
        r6.close();
        if (r10 == 0) goto L22;
        if (r10 != 1) goto L23;
        this.mContactsIdSIM2 = r0;
    L23:
        return r1;
    L22:
        this.mContactsIdSIM1 = r0;
    L24:
        th = move-exception;
        r6.close();
        throw th;
    L27:
        return r1;
    }

    private final ArrayList<SamContact> getBusinessCardContacts() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        Uri r2 = ContactsContract.Contacts.CONTENT_URI;
        Cursor r4 = null;
        if (this.mNoContactsSelected == false) goto L5;
        Uri r6 = r2;
        String r8 = NO_ACCOUNTS_SELECTION;
    L6:
        FragmentActivity r3 = this.mActivity;
        if (r3 == null) goto L11;
        ContentResolver r5 = r3.getContentResolver();
        if (r5 == null) goto L11;
        Cursor r7 = r5.query(r6, getContactProjection(), r8, null, null);
    L12:
        this.mDataIsReady = true;
        if (r7 != null) goto L15;
    L18:
        FragmentActivity r9 = this.mActivity;
        if (r9 == null) goto L23;
        ContentResolver r10 = r9.getContentResolver();
        if (r10 == null) goto L23;
        r4 = r10.query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id"}, "mimetype='vnd.android.cursor.item/added_time' AND data4='1'", null, null);
    L23:
        ArrayList r11 = new ArrayList();
        if (r4 != null) goto L40;
    L33:
        Iterator<SamContact> r12 = r1.iterator();
        Intrinsics.checkNotNullExpressionValue(r12, "contactBCRItems.iterator()");
    L35:
        if (r12.hasNext() == false) goto L39;
        SamContact r13 = r12.next();
        Intrinsics.checkNotNull(r13, "null cannot be cast to non-null type com.android.contacts.list.SamContact");
        SamContact r14 = r13;
        if (r11.contains(Long.valueOf(r14.contactId)) == true) goto L35;
        this.mContactsIdBCR.remove(Long.valueOf(r14.contactId));
        r12.remove();
        goto L35
    L39:
        return r1;
    L40:
    L30:
        th = move-exception;
        r4.close();
        throw th;
    L26:
        if (r4.moveToFirst() == false) goto L29;
    L27:
        r11.add(Long.valueOf(r4.getLong(0)));     // Catch: Throwable -> L30
        if (r4.moveToNext() == true) goto L27;
    L29:
        r4.close();
    L15:
        if (r7.moveToNext() == false) goto L17;
        SamContact r15 = new SamContact(0);
        long r16 = r7.getLong(0);
        String r17 = r7.getString(1);
        r15.name = ContactsUtils.getContactName(this.mActivity, r17);
        r15.sortkey = r7.getString(5);
        r15.phoneBookLabel = r7.getString(9);
        r15.section = ContactsUtils.getContactSection(r15.sortkey, r15.phoneBookLabel);
        r15.LookKey = r7.getString(6);
        r15.photoId = r7.getLong(3);
        r15.contactId = r16;
        r0.add(Long.valueOf(r15.contactId));
        r15.hasname = !TextUtils.isEmpty(r17);
        r15.raw_contactid = r7.getLong(7);
        r15.headerData = getResources().getString(R.string.contacts_list_sortbyaddedtime_label);
        r15.accountType = r7.getString(10);
        r15.accountName = r7.getString(11);
        r1.add(r15);
        goto L15
    L17:
        this.mContactsIdBCR = r0;
        r7.close();
    L11:
        r7 = null;
        goto L12
    L5:
        Intrinsics.checkNotNullExpressionValue(r2, "queryUri");
        r6 = appendAccountsFilterQueryParameter(r2);
        r8 = null;
        goto L6
    }

    public final ArrayList<ArrayList<SamContact>> initCompanyExpandableData(ArrayList<SamContact> r7) {
        if (r7 == null) goto L4;
        ArrayList<SamContact> r6 = new ArrayList();
        ArrayList<ArrayList<SamContact>> r0 = new ArrayList();
        Iterator<SamContact> r8 = r7.iterator();
        String r1 = null;
        boolean r2 = true;
    L7:
        if (r8.hasNext() == false) goto L25;
        SamContact r3 = r8.next();
        if (r2 == false) goto L16;
        if (TextUtils.isEmpty(r1) == false) goto L15;
        if (TextUtils.isEmpty(r3.headerData) == false) goto L15;
        r6.add(r3);
        r0.add(r6);
        r2 = false;
    L15:
        r2 = false;
    L16:
        String r4 = r1;
        if (TextUtils.equals(r4, r3.headerData) == true) goto L24;
        if (TextUtils.isEmpty(r4) == false) goto L23;
        if (TextUtils.isEmpty(r3.headerData) == true) goto L24;
    L23:
        r1 = r3.headerData;
        r6 = new ArrayList();
        r6.add(r3);
        r0.add(r6);
    L24:
        r6.add(r3);
        goto L7
    L25:
        Collections.sort(r0, new CompanySortComparator());
        return r0;
    L4:
        return new ArrayList();
    }

    private final ArrayList<SamContact> getContactsTimes() {
        HashSet<Long> r0 = new HashSet();
        HashMap<Long, Integer> r1 = getContactFrequence();
        ArrayList<SamContact> r2 = new ArrayList();
        if (this.mIsHasPhoneNum == false) goto L5;
        String r3 = CONTACT_CITY_QUERY;
    L6:
        Uri r4 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mNoContactsSelected == false) goto L9;
        r3 = NO_ACCOUNTS_SELECTION;
    L10:
        String r8 = r3;
        Uri r6 = r4;
        FragmentActivity r5 = this.mActivity;
        if (r5 == null) goto L35;
        ContentResolver r7 = r5.getContentResolver();
        if (r7 == null) goto L35;
        Cursor r9 = r7.query(r6, getContactProjection(), r8, null, CONTACT_SORT);
        if (r9 == null) goto L35;
        this.mDataIsReady = true;
    L19:
        if (r9.moveToNext() == false) goto L32;
        int r10 = 0;
        SamContact r11 = new SamContact(0);
        r11.contactId = r9.getLong(0);
        r0.add(Long.valueOf(r11.contactId));
        String r12 = r9.getString(1);
        r11.name = ContactsUtils.getContactName(getActivity(), r12);
        r11.hasname = !TextUtils.isEmpty(r12);
        r11.sortkey = r9.getString(5);
        r11.phoneBookLabel = r9.getString(9);
        r11.section = ContactsUtils.getContactSection(r11.sortkey, r11.phoneBookLabel);
        r11.LookKey = r9.getString(6);
        r11.photoId = r9.getLong(3);
        r11.raw_contactid = r9.getLong(7);
        r11.timesContacted = r9.getInt(2);
        String r13 = null;
        if (r9 == null) goto L23;
        String r14 = r9.getString(10);
    L24:
        r11.accountType = r14;
        if (r9 == null) goto L27;
        r13 = r9.getString(11);
    L27:
        r11.accountName = r13;
        Integer r15 = r1.get(Long.valueOf(r11.contactId));
        if (r15 == null) goto L31;
        r10 = r15.intValue();
    L31:
        r11.timesContacted = r10;
        r11.headerData = getResources().getString(R.string.contacts_list_sortbytimes_label);
        r2.add(r11);
        goto L19
    L23:
        r14 = null;
        goto L24
    L32:
        if (r9 == null) goto L34;
        r9.close();
    L34:
        this.mContactsIdList = r0;
    L35:
        return r2;
    L9:
        Intrinsics.checkNotNullExpressionValue(r4, "queryUri");
        r4 = appendAccountsFilterQueryParameter(r4);
        goto L10
    L5:
        r3 = CONTACT_QUERY;
        goto L6
    }

    private final HashMap<Long, Integer> getContactFrequence() {
        HashMap<Long, Integer> r1 = new HashMap();
        FragmentActivity r2 = this.mActivity;
        Cursor r3 = null;
        if (r2 == null) goto L7;
        ContentResolver r4 = r2.getContentResolver();
        if (r4 == null) goto L7;
        Cursor r5 = r4.query(CALLLOG_COUNT_URI, CONTACT_FREQUENCE_PROJECTION, CONTACT_FREQUENCE_SELECTION, null, "date DESC LIMIT 500");
    L8:
        Cursor r6 = r5;
        Cursor r7 = r6;     // Catch: Throwable -> L98
        if (r7 != null) goto L12;
    L15:
        Unit r8 = Unit.INSTANCE;     // Catch: Throwable -> L98
        CloseableKt.closeFinally(r6, null);
        HashMap r9 = new HashMap();
        FragmentActivity r10 = this.mActivity;
        if (r10 == null) goto L21;
        ContentResolver r11 = r10.getContentResolver();
        if (r11 == null) goto L21;
        Cursor r12 = r11.query(Uri.parse("content://mms-sms/canonical-addresses"), null, null, null, null);
    L23:
        if (r12 != null) goto L25;
    L32:
        HashMap r13 = new HashMap();
        if (Constants.ANDROID60 == false) goto L35;
        Uri r14 = Telephony.Threads.CONTENT_URI.buildUpon().appendQueryParameter(FtsOptions.TOKENIZER_SIMPLE, "true").build();
    L36:
        Uri r15 = r14;
        FragmentActivity r16 = this.mActivity;
        if (r16 == null) goto L41;
        ContentResolver r17 = r16.getContentResolver();
        if (r17 == null) goto L41;
        Cursor r18 = r17.query(r15, new String[]{"recipient_ids", "message_count"}, "type_cs = 0", null, null);
    L42:
        if (r18 != null) goto L44;
    L73:
        FragmentActivity r0 = this.mActivity;
        if (r0 == null) goto L78;
        ContentResolver r19 = r0.getContentResolver();
        if (r19 == null) goto L78;
        r3 = r19.query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "data1"}, "mimetype = 'vnd.android.cursor.item/phone_v2'", null, null);
    L78:
        if (r3 != null) goto L80;
    L97:
        return r1;
    L80:
        if (r3.moveToNext() == false) goto L96;
        long r20 = r3.getLong(0);
        String r110 = r3.getString(1);
        Intrinsics.checkNotNullExpressionValue(r110, "phone.getString(1)");
        StringBuilder r21 = new StringBuilder(StringsKt.replace$default(StringsKt.replace$default(r110, HanziToPinyin.Token.SEPARATOR, "", false, 4, null), "-", "", false, 4, null));
        if (r21.toString().length() < 7) goto L84;
        String r22 = r21.reverse().substring(0, 7);
    L86:
        if (r13.containsKey(r22) == false) goto L88;
        Object r23 = r13.getOrDefault(r22, 0);
        Intrinsics.checkNotNullExpressionValue(r23, "tempMaps.getOrDefault(number, 0)");
        int r24 = ((Number) r23).intValue();
    L90:
        if (r1.containsKey(Long.valueOf(r20)) == true) goto L91;
        r1.put(Long.valueOf(r20), Integer.valueOf(r24));
        goto L80
    L91:
        Integer r25 = r1.get(Long.valueOf(r20));
        if (r25 != null) goto L94;
        r25 = 0;
    L94:
        r1.put(Long.valueOf(r20), Integer.valueOf(r24 + r25.intValue()));
        goto L80
    L88:
        r24 = 0;
        goto L90
    L84:
        r22 = r21.toString();
        goto L86
    L96:
        r3.close();
    L44:
        if (r18.moveToNext() == false) goto L72;
        String r26 = r18.getString(0);
        int r111 = r18.getInt(1);
        Intrinsics.checkNotNullExpressionValue(r26, "recipients");
        List<String> r27 = new Regex(HanziToPinyin.Token.SEPARATOR).split(r26, 0);
        if (r27.isEmpty() == true) goto L56;
        ListIterator<String> r112 = r27.listIterator(r27.size());
    L49:
        if (r112.hasPrevious() == false) goto L56;
        if (r112.previous().length() != 0) goto L53;
        boolean r113 = true;
    L54:
        if (r113 == true) goto L49;
        List r28 = CollectionsKt.take(r27, r112.nextIndex() + 1);
    L57:
        String[] r29 = (String[]) r28.toArray(new String[0]);
        int r114 = r111 / r29.length;
        int r115 = r29.length;
        int r116 = 0;
    L58:
        if (r116 >= r115) goto L44;
        String r117 = (String) r9.get(Long.valueOf(Long.parseLong(r29[r116])));
        String r118 = r117;
        if (r118 != null) goto L62;
    L65:
        boolean r119 = true;
    L66:
        if (r119 == false) goto L68;
    L71:
        r116 = r116 + 1;
        goto L58
    L68:
        if (r13.containsKey(r117) == false) goto L70;
        Object r120 = r13.getOrDefault(r117, 0);
        Intrinsics.checkNotNullExpressionValue(r120, "tempMaps.getOrDefault(key, 0)");
        r13.put(r117, Integer.valueOf(((Number) r120).intValue() + r114));
        goto L71
    L70:
        r13.put(r117, Integer.valueOf(r114));
        goto L71
    L62:
        if (r118.length() == 0) goto L65;
        r119 = false;
        goto L66
    L53:
        r113 = false;
    L56:
        r28 = CollectionsKt.emptyList();
        goto L57
    L72:
        r18.close();
    L41:
        r18 = null;
        goto L42
    L35:
        r14 = Uri.parse("content://mms-sms/threads");
    L25:
        if (r12.moveToNext() == false) goto L31;
        long r30 = r12.getLong(0);
        String r121 = r12.getString(1);
        Intrinsics.checkNotNullExpressionValue(r121, "address.getString(1)");
        StringBuilder r122 = new StringBuilder(StringsKt.replace$default(StringsKt.replace$default(r121, HanziToPinyin.Token.SEPARATOR, "", false, 4, null), "-", "", false, 4, null));
        Long r31 = Long.valueOf(r30);
        if (r122.toString().length() < 7) goto L29;
        String r32 = r122.reverse().substring(0, 7);
    L30:
        r9.put(r31, r32);
        goto L25
    L29:
        r32 = r122.toString();
        goto L30
    L31:
        r12.close();
    L21:
        r12 = null;
        goto L23
    L12:
        if (r7.moveToFirst() == false) goto L15;
    L13:
        r1.put(Long.valueOf(ContentUris.parseId(Uri.parse(r7.getString(1)))), Integer.valueOf(r7.getInt(0)));     // Catch: Throwable -> L98
        if (r7.moveToNext() == true) goto L13;
    L98:
        th = move-exception;
        throw th;     // Catch: Throwable -> L101
    L101:
        th = move-exception;
        CloseableKt.closeFinally(r6, th);
        throw th;
    L7:
        r5 = null;
        goto L8
    }

    private final ArrayList<SamContact> getAddedTimeContacts() {
        HashSet<Long> r0 = new HashSet();
        ArrayList<SamContact> r1 = new ArrayList();
        if (this.mIsHasPhoneNum == false) goto L5;
        String r2 = CONTACT_CITY_QUERY;
    L6:
        Uri r3 = ContactsContract.Contacts.CONTENT_URI;
        if (this.mNoContactsSelected == false) goto L9;
        r2 = NO_ACCOUNTS_SELECTION;
    L10:
        String r7 = r2;
        Uri r5 = r3;
        FragmentActivity r4 = this.mActivity;
        if (r4 == null) goto L47;
        ContentResolver r6 = r4.getContentResolver();
        if (r6 == null) goto L47;
        Cursor r8 = r6.query(r5, getContactProjection(), r7, null, CONTACT_SORT);
        if (r8 == null) goto L47;
        this.mDataIsReady = true;
    L19:
        if (r8.moveToNext() == false) goto L21;
        SamContact r9 = new SamContact(0);
        long r10 = r8.getLong(0);
        String r11 = r8.getString(1);
        r9.name = ContactsUtils.getContactName(getActivity(), r11);
        r9.sortkey = r8.getString(5);
        r9.phoneBookLabel = r8.getString(9);
        r9.section = ContactsUtils.getContactSection(r9.sortkey, r9.phoneBookLabel);
        r9.LookKey = r8.getString(6);
        r9.photoId = r8.getLong(3);
        r9.contactId = r10;
        r0.add(Long.valueOf(r9.contactId));
        r9.hasname = !TextUtils.isEmpty(r11);
        r9.raw_contactid = r8.getLong(7);
        r9.headerData = getResources().getString(R.string.contacts_list_sortbyaddedtime_label);
        r9.accountType = r8.getString(10);
        r9.accountName = r8.getString(11);
        r1.add(r9);
        goto L19
    L21:
        this.mContactsIdList = r0;
        r8.close();
        FragmentActivity r12 = this.mActivity;
        if (r12 == null) goto L26;
        ContentResolver r13 = r12.getContentResolver();
        if (r13 == null) goto L26;
        Cursor r14 = r13.query(ContactsContract.Data.CONTENT_URI, new String[]{"contact_id", "data1"}, " mimetype='vnd.android.cursor.item/added_time'", null, null);
    L27:
        if (r14 != null) goto L29;
        return r1;
    L29:
        HashMap r15 = new HashMap();
    L44:
        th = move-exception;
        r14.close();
        throw th;
    L31:
        if (r14.moveToFirst() == false) goto L34;
    L32:
        r15.put(Long.valueOf(r14.getLong(0)), r14.getString(1));     // Catch: Throwable -> L44
        if (r14.moveToNext() == true) goto L32;
    L34:
        r14.close();
        Iterator<SamContact> r16 = r1.iterator();
    L36:
        if (r16.hasNext() == false) goto L43;
        SamContact r17 = r16.next();
        if (r15.size() == 0) goto L43;
        if (r15.containsKey(Long.valueOf(r17.contactId)) == false) goto L36;
        r17.addedTime = (String) r15.remove(Long.valueOf(r17.contactId));
    L43:
        return r1;
    L26:
        r14 = null;
    L47:
        return r1;
    L9:
        Intrinsics.checkNotNullExpressionValue(r3, "queryUri");
        r3 = appendAccountsFilterQueryParameter(r3);
        goto L10
    L5:
        r2 = CONTACT_QUERY;
        goto L6
    }

    @Override // androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        setObserverToWork(true);
        initStart();
        if (ContactsUtils.isVoiceSearchEnabled() == false) goto L9;
        Intent r1 = new Intent(ContactsUtils.LAUNCH_RECONGNIZE_SERVICE);
        r1.setPackage(ContactsUtils.VOICE_ASSISTANT_PACKAGE);
        if (ContactsUtils.DEBUG == false) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "bindService ");
    L7:
        ContactsApplication.getInstance().bindService(r1, this.mVoiceAssistantServiceConnection, 1);
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        SearchUtils.prepareSearchAsync();
        refreshBcrCount();
        BlacklistManager r0 = this.mBlacklistManager;
        if (r0 == null) goto L5;
        r0.clearCache();
    L5:
        BlacklistManager r1 = this.mBlacklistManager;
        if (r1 == null) goto L8;
        r1.resume();
    L8:
        boolean r2 = ContactsUtils.isVoiceSearchEnabled();
        boolean r3 = false;
        if (r2 == false) goto L14;
        RelativeLayout r4 = this.voiceSearchContainer;
        if (r4 == null) goto L14;
        if (r4 == null) goto L14;
        r4.setVisibility(0);
    L14:
        ImageButton r5 = this.mBtnVoiceSearchContacts;
        if (r5 != null) goto L20;
        if (r2 == false) goto L20;
        Handler r6 = this.mHandler;
        if (r6 == null) goto L24;
        r6.postDelayed(new RunnableC01971(this), 400);
    L24:
        ContactDetailCacheManager.getInstance().cacheView(this.mContext);
        FragmentActivity r7 = this.mActivity;
        if (r7 == null) goto L27;
        Intent r8 = r7.getIntent();
    L28:
        if (r8 == null) goto L30;
        String r9 = r8.getAction();
    L32:
        if (Intrinsics.areEqual(DialtactsActivity.ADD_CONTACTS, r9) == false) goto L37;
        if (r8 == null) goto L35;
        r8.setAction(null);
    L35:
        startCreateNewContactActivity();
    L37:
        if (Intrinsics.areEqual(DialtactsActivity.SEARCH_CONTACTS, r9) == false) goto L44;
        if (r8 == null) goto L40;
        r8.setAction(null);
    L40:
        View r10 = getView();
        if (r10 == null) goto L44;
        r10.post(new NewContactListFragment$$ExternalSyntheticLambda0(this));
    L44:
        if (Intrinsics.areEqual(DialtactsActivity.FREQUENT_CONTACTS, r9) == false) goto L50;
        if (r8 == null) goto L47;
        r8.setAction(null);
    L47:
        this.mFrequentContacts = true;
        IContactSearchBarPresenter r11 = getPresenter();
        if (r11 == null) goto L50;
        r11.switchSortMode(4);
    L50:
        GroupBrowseListFragment r12 = this.mGroupBrowseListFragment;
        if (r12 == null) goto L58;
        if (r12 != null) goto L54;
    L56:
        if (r3 == false) goto L58;
        setGroupEditState(true);
        goto L58
    L54:
        if (r12.isEdit() != true) goto L56;
        r3 = true;
    L58:
        EventTrackerManager.INSTANCE.track(new ContactPageShowEvent("", TAG, null, null, 12, null));
        return;
    L30:
        r9 = null;
        goto L32
    L27:
        r8 = null;
    L20:
        if (r5 == null) goto L24;
        if (r2 == true) goto L24;
        if (r5 == null) goto L24;
        r5.setVisibility(8);
        goto L24
    }

    private static final void onResume$lambda$41(NewContactListFragment r1) {
        Intrinsics.checkNotNullParameter(r1, "this$0");
        IContactSearchBarPresenter r2 = r1.getPresenter();
        if (r2 == null) goto L6;
        r2.startSearch();
        return;
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        super.onPause();
        stopListScrollFpsSampling();
        BottomDeleteLayoutListener r0 = this.mBottomDeleteLayoutListener;
        if (r0 != null) goto L5;
        return;
    L5:
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L14;
        processEditContacts(false, true);
        return;
    L14:
        return;
    L7:
        if (r0.isBottomBarVisible() != true) goto L9;
        r1 = true;
        goto L10
    }

    private final void initStart() {
        if (this.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_v(TAG, "ContactListFragment onStart");
    L5:
        boolean r0 = this.mKeepSearchState;
        this.mKeepSearchState = false;
        if (this.mContactBody != null) goto L15;
        View r2 = this.mContactsFragment;
        RelativeLayout r3 = null;
        if (r2 == null) goto L10;
        View r4 = r2.findViewById(R.id.contacts_body);
    L12:
        if ((r4 instanceof RelativeLayout) == false) goto L14;
        r3 = (RelativeLayout) r4;
    L14:
        this.mContactBody = r3;
        goto L15
    L10:
        r4 = null;
    L15:
        this.mIsHasPhoneNum = ContactsUtils.contactsWithPhoneOnly(getActivity());
        boolean r5 = true;
        if (this.mLazyLoadFirstStart == false) goto L18;
        Handler r6 = this.mHandler;
        r6.sendMessageDelayed(r6.obtainMessage(1008, this.mSortMode, 1), 500);
        this.mLazyLoadFirstStart = false;
    L19:
        RelativeLayout r7 = this.mContactBody;
        if (r7 != null) goto L22;
    L24:
        r5 = false;
    L25:
        if (r5 == false) goto L30;
        IContactSearchBarPresenter r8 = getPresenter();
        if (r8 == null) goto L30;
        r8.requestSeachViewFocus();
    L30:
        if (this.isSearch == true) goto L32;
        return;
    L32:
        if (TextUtils.isEmpty(this.mSearchKey) == true) goto L37;
        if (r0 == true) goto L38;
        onQueryTextChangeIView(this.mSearchKey, false);
        return;
    L38:
        return;
    L37:
        return;
    L22:
        if (r7.getVisibility() != 0) goto L24;
    L18:
        triggerLoad$default(this, this.mSortMode, true, false, 4, null);
        goto L19
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        hideQuickContact();
        SearchUtils.stopSearchAsync("onStop");
        if (this.mKeepSearchState == true) goto L6;
        setObserverToWork(false);
    L6:
        if (this.mIsClickBtnAddContact == false) goto L8;
        hideSoftKeyboard();
        this.mIsClickBtnAddContact = false;
    L8:
        OAlertDialog r0 = this.mDeleteDialog;
        if (r0 == null) goto L19;
        if (r0 == null) goto L14;
        boolean r2 = true;
        if (r0.isShowing() != true) goto L14;
    L15:
        if (r2 == false) goto L19;
        OAlertDialog r1 = this.mDeleteDialog;
        if (r1 == null) goto L19;
        r1.dismiss();
    L14:
        r2 = false;
    L19:
        PermissionUtils.dismissPermissionGuideDialog();
        if (this.mIsEdit == false) goto L22;
        processEditContacts(false, false);
    L22:
        GroupBrowseListFragment r3 = this.mGroupBrowseListFragment;
        if (r3 == null) goto L27;
        if (r3 == null) goto L26;
        r3.setGroupEdit(false);
    L26:
        setGroupEditState(false);
    L27:
        ShowResultThread r4 = this.mShowResultThread;
        if (r4 == null) goto L32;
        Handler r5 = this.mHandler;
        if (r5 == null) goto L32;
        r5.removeCallbacks(r4);
    L32:
        Handler r6 = this.mHandler;
        if (r6 == null) goto L35;
        r6.removeCallbacks(this.mTimeoutThread);
    L35:
        ViewGroup r7 = this.mSearchResultDialog;
        if (r7 == null) goto L51;
        if (r7 == null) goto L39;
        View r8 = r7.findViewById(R.id.result_list_view);
    L40:
        ListView r9 = (ListView) r8;
        if (r9 != null) goto L43;
    L45:
        AnimationUtil.cancelAnimation(this.mSearchResultDialog);
        ViewGroup r10 = this.mSearchResultDialog;
        if (r10 == null) goto L48;
        r10.clearAnimation();
    L48:
        ViewGroup r11 = this.mSearchResultDialog;
        if (r11 == null) goto L51;
        r11.setVisibility(8);
        goto L51
    L43:
        if (r9.getAdapter() == null) goto L45;
        ListAdapter r12 = r9.getAdapter();
        Intrinsics.checkNotNull(r12, "null cannot be cast to non-null type com.obricOld.recognition.VoiceSearchResultAdapter");
        ((VoiceSearchResultAdapter) r12).dismissShareDialog();
        goto L45
    L39:
        r8 = null;
    L51:
        ViewGroup r13 = this.mEmptyResultDialog;
        if (r13 == null) goto L59;
        AnimationUtil.cancelAnimation(r13);
        ViewGroup r14 = this.mEmptyResultDialog;
        if (r14 == null) goto L56;
        r14.clearAnimation();
    L56:
        ViewGroup r15 = this.mEmptyResultDialog;
        if (r15 == null) goto L59;
        r15.setVisibility(8);
    L59:
        View r16 = this.mCover;
        if (r16 == null) goto L67;
        AnimationUtil.cancelAnimation(r16);
        View r17 = this.mCover;
        if (r17 == null) goto L64;
        r17.clearAnimation();
    L64:
        View r18 = this.mCover;
        if (r18 == null) goto L67;
        r18.setVisibility(8);
    L67:
        dismissWave();
        ImageButton r19 = this.mBtnVoiceSearchContacts;
        if (r19 == null) goto L71;
        if (r19 == null) goto L71;
        r19.setVisibility(8);
    L71:
        dismissCloseVoiceDialog();
        if (ContactsUtils.isVoiceSearchEnabled() == true) goto L74;
    L76:
        this.mStartedRecongnize = false;
        dismissLongMenu();
        return;
    L74:
        if (this.mVoiceSearchConnected == false) goto L76;
        this.mVoiceAssistantServiceConnection.clear();     // Catch: Exception -> L78
        ContactsApplication.getInstance().unbindService(this.mVoiceAssistantServiceConnection);     // Catch: Exception -> L78
        goto L76
    }

    private final void setObserverToWork(boolean r2) {
        if (getActivity() != null) goto L5;
        return;
    L5:
        if (r2 == false) goto L7;
        registerObserver();
        clearModeState();
        return;
    L7:
        unregisterObserver();
    }

    private final void registerObserver() {
        if (this.mContactsContent != null) goto L15;
        ContactsContent r0 = new ContactsContent(this, new Handler());
        this.mContactsContent = r0;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        ContentResolver r2 = r1.getContentResolver();
        if (r2 == null) goto L9;
        r2.registerContentObserver(ContactsContract.Contacts.CONTENT_URI, true, r0);
    L9:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L16;
        ContentResolver r6 = r5.getContentResolver();
        if (r6 == null) goto L17;
        r6.registerContentObserver(ContactsContract.Data.CONTENT_URI, true, r0);
        return;
    L17:
        return;
    L16:
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

    private final void registerBcrDataObserver() {
        if (this.mBcrDataObserver != null) goto L10;
        final Handler r0 = new Handler();
        this.mBcrDataObserver = new C01991(this, r0);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L11;
        ContentResolver r2 = r1.getContentResolver();
        if (r2 == null) goto L12;
        Uri r3 = ContactsContract.Data.CONTENT_URI;
        ContentObserver r4 = this.mBcrDataObserver;
        Intrinsics.checkNotNull(r4);
        r2.registerContentObserver(r3, true, r4);
        return;
    L12:
        return;
    L11:
        return;
    }

    private final void unregisterBcrDataObserver() {
        ContentObserver r0 = this.mBcrDataObserver;
        if (r0 == null) goto L11;
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L9;
        ContentResolver r2 = r1.getContentResolver();
        if (r2 == null) goto L9;
        r2.unregisterContentObserver(r0);
    L9:
        this.mBcrDataObserver = null;
        return;
    }

    private final void hideQuickContact() {
        HeadersListView r0 = this.mContactListView;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.hideQuickContact();
    L6:
        QuickContactExpandableListView r1 = this.mCityListView;
        if (r1 == null) goto L10;
        if (r1 == null) goto L10;
        r1.hideQuickContact();
    L10:
        QuickContactListView r2 = this.mSearchResultList;
        if (r2 == null) goto L15;
        if (r2 == null) goto L16;
        r2.hideQuickContact();
        return;
    L16:
        return;
    }

    @Override // com.android.contacts.AbstractFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle r3) {
        super.onCreate(r3);
        FragmentActivity r4 = getActivity();
        Object r0 = null;
        if (r4 == null) goto L5;
        Object r5 = r4.getSystemService(BatteryTypeInf.BATTERY_LOC_API);
    L6:
        Intrinsics.checkNotNull(r5, "null cannot be cast to non-null type android.location.LocationManager");
        this.mLocationManager = (LocationManager) r5;
        if (DSUtils.isMultiSimEnabled() == false) goto L9;
        DSUtils.registerIccStateListener(this.mIccStateListener);
    L9:
        registerBcrDataObserver();
        FragmentActivity r6 = getActivity();
        if (r6 == null) goto L12;
        r0 = r6.getSystemService("vibrator");
    L12:
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.os.Vibrator");
        this.mVibrator = (Vibrator) r0;
        AvatarImageHelper.getIntance().addAvatarTextFontChangeListener(this);
        this.mBlacklistManager = BlacklistManager.getInstances(getActivity());
        ContactListFilterController r7 = ContactListFilterController.getInstance(getActivity());
        this.mContactListFilterController = r7;
        if (r7 == null) goto L15;
        r7.checkFilterValidity(false);
    L15:
        setAccountFilterQuerySelection();
        ContactListFilterController r8 = this.mContactListFilterController;
        if (r8 == null) goto L18;
        r8.addListener(this);
    L18:
        this.mSidebarDragHelper = SidebarDragHelper.getInstance(getActivity());
        setupLongMenu();
        if (this.mBlacklistChangeListener != null) goto L24;
        BlacklistChangeListener r9 = new BlacklistChangeListener(this);
        this.mBlacklistChangeListener = r9;
        BlacklistManager r2 = this.mBlacklistManager;
        if (r2 == null) goto L25;
        r2.addOnBlacklistChangeListener(r9);
        return;
    L25:
        return;
    L24:
        return;
    L5:
        r5 = null;
        goto L6
    }

    public final Uri getContactUri(SamContact r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if (r5.contactId > 0) goto L9;
        return null;
    L9:
        return ContactsContract.Contacts.getLookupUri(r5.contactId, r5.LookKey);
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> r13, View r14, int r15, long r16) {
        Intrinsics.checkNotNullParameter(r13, "arg0");
        if (ContactsUtils.isJustClicked() == true) goto L5;
    L7:
        int r5 = r13.getId();
        boolean r9 = true;
        if (r5 != R.id.main_list) goto L10;
        hideSoftKeyboard();
        OIndexScrollbar r6 = this.mQuickBar;
        if (r6 != null) goto L29;
    L31:
        boolean r7 = false;
    L32:
        if (r7 == false) goto L34;
        long r10 = 0;
    L35:
        OIndexScrollbar r8 = this.mQuickBar;
        if (r8 == null) goto L38;
        r8.hideLetterGrid();
    L38:
        int r11 = this.mSortMode;
        if (r11 == 1) goto L61;
        if (r11 == 256) goto L44;
        return;
    L44:
        if (this.mIsEdit == false) goto L47;
        processSelectOnItemClicked(r16, findContactsCommonListItem(r14));
        return;
    L47:
        ContactsListSortByNameAdapter r1 = this.mPhoneContactsAdapter;
        if (r1 != null) goto L50;
        return;
    L50:
        if (r1.getCount() <= 0) goto L109;
        ArrayList<SamContact> r2 = r1.getList();
        if (r2 == null) goto L110;
        if (r15 >= 0) goto L55;
    L57:
        r9 = false;
    L58:
        if (r9 == false) goto L111;
        startDetailActivity$default(this, getContactUri(r2.get(r15)), null, true, false, 8, null);
        return;
    L111:
        return;
    L55:
        if (r15 >= r2.size()) goto L57;
    L110:
        return;
    L109:
        return;
    L61:
        if (this.mIsEdit == false) goto L64;
        processSelectOnItemClicked(r16, findContactsCommonListItem(r14));
        return;
    L64:
        ContactsListSortByNameAdapter r3 = this.mNorAdapter;
        if (r3 != null) goto L67;
        return;
    L67:
        if (r3.getCount() <= 0) goto L120;
        ContactsUtils.setCpuBoost(1000);
        ArrayList<SamContact> r4 = r3.getList();
        if (r4 == null) goto L114;
        if (r15 >= 0) goto L73;
    L75:
        boolean r12 = false;
    L76:
        if (r12 == false) goto L121;
        SamContact r17 = r4.get(r15);
        if (r17 != null) goto L81;
    L83:
        boolean r18 = false;
    L84:
        if (r18 == true) goto L86;
        if (r17 != null) goto L92;
    L94:
        r9 = false;
    L95:
        if (r9 == false) goto L97;
        return;
    L97:
        this.mMayDeletedPosition = r15;
        final Uri r19 = getContactUri(r17);
        if (r10 <= 0) goto L102;
        Handler r20 = this.mHandler;
        if (r20 == null) goto L116;
        r20.postDelayed(new RunnableC01961(this, r19), r10);
        return;
    L116:
        return;
    L102:
        startDetailActivity$default(this, r19, null, true, false, 8, null);
        return;
    L92:
        if (3 != r17.getType()) goto L94;
    L86:
        if (r17.contactId != (-2)) goto L89;
        startActivity(new Intent(getActivity(), GroupBrowseListActivity.class));
        return;
    L89:
        startProfileDetail(r17, r10);
        return;
    L81:
        if (1 != r17.getType()) goto L83;
        r18 = true;
        goto L84
    L121:
        return;
    L73:
        if (r15 >= r4.size()) goto L75;
        r12 = true;
        goto L76
    L114:
        return;
    L120:
        return;
    L34:
        r10 = 100;
        goto L35
    L29:
        if (r6.isLetterGridHidden() != true) goto L31;
        r7 = true;
        goto L32
    L10:
        if (r5 == R.id.search_listview) goto L13;
        return;
    L13:
        if (this.mSearchResultAdapter != null) goto L15;
        return;
    L15:
        if (getRealAdapter() != this.mSearchResultAdapter) goto L105;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_SEARCH_RESULT_ITEM);
        SearchUtils.reportSearchEventAndClear();
        this.mKeepSearchState = true;
        hideSoftKeyboard();
        SearchResultAdapter r21 = this.mSearchResultAdapter;
        if (r21 == null) goto L19;
        SamContact r22 = r21.getItem(r15);
    L20:
        if (r22 != null) goto L23;
        return;
    L23:
        if (1 != r22.getType()) goto L25;
        startProfileDetail(r22, 0);
        return;
    L25:
        startDetailActivity$default(this, getContactUri(r22), null, true, false, 8, null);
        return;
    L19:
        r22 = null;
        goto L20
    L105:
        return;
    L5:
        if (this.mIsEdit == true) goto L7;
    }

    private final ListAdapter getRealAdapter() {
        QuickContactListView r2 = this.mSearchResultList;
        HeaderViewListAdapter r0 = null;
        if (r2 == null) goto L5;
        ListAdapter r3 = r2.getAdapter();
    L6:
        if (r3 != null) goto L9;
        return null;
    L9:
        if ((r3 instanceof HeaderViewListAdapter) == false) goto L11;
        r0 = (HeaderViewListAdapter) r3;
    L11:
        if (r0 == null) goto L17;
        ListAdapter r1 = r0.getWrappedAdapter();
        if (r1 != null) goto L16;
        return r3;
    L16:
        return r1;
    L17:
        return r3;
    L5:
        r3 = null;
        goto L6
    }

    private final void startProfileDetail(SamContact r5, long r6) {
        if (r5.contactId != (-1)) goto L23;
        final Intent r0 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        r0.setPackage("com.android.contacts");
        r0.putExtra(ContactEditorFragment.INTENT_EXTRA_NEW_LOCAL_PROFILE, true);
        r0.putExtra("enter_from", "new_contact_list_create");
        if (DSUtils.isMultiSimEnabled() == false) goto L15;
        if (TextUtils.isEmpty(r5.number) == true) goto L12;
        r0.putExtra("phone", ContactsUtils.formatNumber(r5.number));
        if (TextUtils.isEmpty(r5.normalized_number) == true) goto L20;
        r0.putExtra("secondary_phone", ContactsUtils.formatNumber(r5.normalized_number));
    L20:
        Handler r7 = this.mHandler;
        if (r7 == null) goto L27;
        r7.postDelayed(new RunnableC02041(this, r0), r6);
        return;
    L27:
        return;
    L12:
        if (TextUtils.isEmpty(r5.normalized_number) == true) goto L20;
        r0.putExtra("phone", ContactsUtils.formatNumber(r5.normalized_number));
        goto L20
    L15:
        if (TextUtils.isEmpty(r5.normalized_number) == true) goto L18;
        r0.putExtra("phone", r5.normalized_number);
        goto L20
    L18:
        if (TextUtils.isEmpty(r5.number) == true) goto L20;
        r0.putExtra("phone", r5.number);
        goto L20
    L23:
        final Uri r8 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r5.contactId);
        Intrinsics.checkNotNullExpressionValue(r8, "withAppendedId(personUri, contact.contactId)");
        Handler r1 = this.mHandler;
        if (r1 == null) goto L29;
        r1.postDelayed(new RunnableC02052(this, r8), r6);
        return;
    }

    public final void removeItemFromList(Uri r4) {
        int r0 = this.mMayDeletedPosition;
        ContactsListSortByNameAdapter r1 = this.mNorAdapter;
        if (r1 == null) goto L18;
        if (r1 == null) goto L6;
        ArrayList<SamContact> r2 = r1.getList();
    L7:
        if (r2 == null) goto L18;
        if (r2.size() <= r0) goto L18;
        if (r0 < 0) goto L18;
        Uri r3 = getContactUri(r2.get(r0));
        if (r4 == null) goto L18;
        if (Intrinsics.areEqual(r4, r3) == false) goto L18;
        r2.remove(r0);
        ContactsListSortByNameAdapter r5 = this.mNorAdapter;
        if (r5 == null) goto L18;
        r5.notifyDataSetChanged();
        goto L18
    L6:
        r2 = null;
    L18:
        removeItemFromSearchList(r4);
    }

    private final void removeItemFromSearchList(Uri r11) {
        SearchResultAdapter r0 = this.mSearchResultAdapter;
        if (r0 == null) goto L28;
        if (r11 == null) goto L30;
        ArrayList<SamContact> r1 = new ArrayList();
        int r2 = r0.getCount();
        int r5 = 0;
        long r6 = -1;
    L7:
        if (r5 >= r2) goto L17;
        SamContact r8 = r0.getItem(r5);
        if (r8 == null) goto L15;
        if (Intrinsics.areEqual(r11, getContactUri(r8)) == false) goto L14;
        r6 = r8.contactId;
        goto L15
    L14:
        r1.add(r8);
    L15:
        r5 = r5 + 1;
        goto L7
    L17:
        if (r6 != (-1)) goto L19;
        return;
    L19:
        this.curContactsMap.remove(Long.valueOf(r6));
        this.mSearchKeyList.remove(Long.valueOf(r6));
        if (this.mSearchKeyList.isEmpty() == false) goto L22;
        r0.setList(r1, this.mSearchKey);
        return;
    L22:
        r0.setListMap(r1, this.mSearchKeyList, this.mSearchKey);
        return;
    L30:
        return;
    }

    private final void processSelectOnItemClicked(long r3, ContactsCommonListItem r5) {
        if (ContactsContract.isProfileId(r3) == false) goto L5;
        return;
    L5:
        if (r5 != null) goto L8;
        return;
    L8:
        if (this.mSelectedSet.contains(Long.valueOf(r3)) == false) goto L10;
        this.mSelectedSet.remove(Long.valueOf(r3));
        r5.setChecked(false);
        return;
    L10:
        this.mSelectedSet.add(Long.valueOf(r3));
        r5.setChecked(true);
    }

    private final ContactsCommonListItem findContactsCommonListItem(View r5) {
        if (r5 != null) goto L6;
        return null;
    L6:
        if ((r5 instanceof ContactsCommonListItem) == false) goto L10;
        return (ContactsCommonListItem) r5;
    L10:
        if ((r5 instanceof ViewGroup) == false) goto L17;
        ViewGroup r6 = (ViewGroup) r5;
        int r1 = r6.getChildCount();
        int r2 = 0;
    L12:
        if (r2 >= r1) goto L17;
        ContactsCommonListItem r3 = findContactsCommonListItem(r6.getChildAt(r2));
        if (r3 != null) goto L15;
        r2 = r2 + 1;
        goto L12
    L15:
        return r3;
    L17:
        return null;
    }

    private final void hideSoftKeyboard() {
        FragmentActivity r0 = this.mActivity;
        IBinder r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("input_method");
    L6:
        Intrinsics.checkNotNull(r2, "null cannot be cast to non-null type android.view.inputmethod.InputMethodManager");
        InputMethodManager r3 = (InputMethodManager) r2;
        if (this.mInContacts == false) goto L12;
        HeadersListView r4 = this.mContactListView;
        if (r4 == null) goto L11;
        r1 = r4.getWindowToken();
    L11:
        r3.hideSoftInputFromWindow(r1, 0);
        return;
    L12:
        QuickContactListView r5 = this.mSearchResultList;
        if (r5 == null) goto L19;
        if (r5 == null) goto L16;
        r1 = r5.getWindowToken();
    L16:
        r3.hideSoftInputFromWindow(r1, 0);
        return;
    L19:
        return;
    L5:
        r2 = null;
        goto L6
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View r2) {
        Intrinsics.checkNotNullParameter(r2, "view");
        if (getActivity() != null) goto L5;
        return;
    L5:
        int r3 = r2.getId();
        if (r3 != R.id.btn_import_contacts_in_footer) goto L8;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "import contacts btn clicked");
        if (ContactsUtils.isJustClicked() == true) goto L24;
        showImportContactsInEmptyDialog();
        return;
    L24:
        return;
    L8:
        if (r3 != R.id.cover) goto L25;
        this.mCoverDismiss = true;
        Handler r4 = this.mHandler;
        if (r4 == null) goto L13;
        r4.removeCallbacks(this.mTimeoutThread);
    L13:
        ShowResultThread r5 = this.mShowResultThread;
        if (r5 == null) goto L18;
        Handler r0 = this.mHandler;
        if (r0 == null) goto L18;
        r0.removeCallbacks(r5);
    L18:
        AnimationUtil.hideResultDialogWithAnim(this.mSearchResultDialog);
        AnimationUtil.hideResultDialogWithAnim(this.mEmptyResultDialog);
        AnimationUtil.hideCoverWithAnimation(this.mCover);
        return;
    }

    private final void onDeleteGroupClicked() {
        GroupBrowseListFragment r0 = this.mGroupBrowseListFragment;
        if (r0 == null) goto L6;
        r0.deleteCheckedGroups();
        return;
    }

    private final void onCancelEditGroupClicked() {
        GroupBrowseListFragment r0 = this.mGroupBrowseListFragment;
        if (r0 == null) goto L5;
        r0.setGroupEdit(false);
    L5:
        setGroupEditState(false);
        showVoiceSearchBtn();
        SelectAllState r1 = this.mGroupSelectAllBtn;
        if (r1 == null) goto L10;
        if (r1 == null) goto L10;
        r1.setSelectAll(false);
    L10:
        BottomDeleteLayoutListener r2 = this.mBottomDeleteLayoutListener;
        if (r2 == null) goto L15;
        if (r2 == null) goto L16;
        r2.setBottomBtnEnable(false);
        return;
    L16:
        return;
    }

    private final void onAddGroupClicked() {
        if (ContactsUtils.isJustClicked() == true) goto L8;
        GroupBrowseListFragment r1 = this.mGroupBrowseListFragment;
        if (r1 == null) goto L9;
        r1.createNewGroupWithAccountDisambiguation();
        return;
    L9:
        return;
    }

    private final void onEditGroupClicked() {
        setGroupEditState(true);
        GroupBrowseListFragment r1 = this.mGroupBrowseListFragment;
        if (r1 == null) goto L6;
        r1.setGroupEdit(true);
        return;
    }

    private final void onCancelEditContactClicked() {
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.hideLetterGrid();
    L6:
        OFloatingTitleBarHolder r1 = this.mTitleBarHolder;
        if (r1 == null) goto L11;
        OTextView r2 = r1.getCenterTitleView();
        if (r2 == null) goto L11;
        r2.setVisibility(8);
    L11:
        processEditContacts(false, true);
    }

    private final void onDeleteContactClicked() {
        if (ContactsUtils.isJustClicked() == true) goto L6;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_DELETE_CONTACTS);
        showDeleteContactsDialog();
        return;
    }

    private final void onEditContactClicked() {
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.hideLetterGrid();
    L6:
        IContactSearchBarPresenter r1 = getPresenter();
        boolean r2 = false;
        if (r1 != null) goto L9;
    L11:
        if (r2 == false) goto L13;
        return;
    L13:
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_EDIT_ALL_CONTACTS);
        processEditContacts(true, true);
        return;
    L9:
        if (r1.isInSearchMode() != true) goto L11;
        r2 = true;
        goto L11
    }

    private final void onSettingsTitleClick() {
        if (getActivity() != null) goto L5;
        return;
    L5:
        startActivity(new Intent(getActivity(), ContactsSettingActivity.class));
    }

    private final void onAddNewContactClicked() {
        if (ContactsUtils.isJustClicked() == true) goto L6;
        Agent.getInstance().onClick(TAG, Constants.ContactsTracker.EVENT_NEW_CONTACT);
        this.mIsClickBtnAddContact = true;
        ContactsUtils.setCpuBoost(1000);
        startCreateNewContactActivity();
        return;
    }

    private final void processEditContacts(boolean r3, boolean r4) {
        ContactsListSortByNameAdapter r0 = this.mNorAdapter;
        if (r0 == null) goto L5;
        ArrayList<SamContact> r1 = r0.getList();
    L6:
        ArrayList<SamContact> r2 = r1;
        if (r2 != null) goto L9;
    L12:
        boolean r5 = true;
    L13:
        processEditContacts(r3, r4, false, r5);
        return;
    L9:
        if (r2.isEmpty() == true) goto L12;
        r5 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    private final void processEditContacts(boolean r11, boolean r12, boolean r13, boolean r14) {
        this.mIsEdit = r11;
        IContactSearchBarPresenter r0 = getPresenter();
        if (r0 == null) goto L5;
        r0.setSearchEnable(!this.mIsEdit);
    L5:
        ListView r5 = getTargetListView();
        if (r5 != null) goto L9;
        return;
    L9:
        if ((r5 instanceof HorizontalScrollListView) == false) goto L14;
        if (r11 == false) goto L12;
        ((HorizontalScrollListView) r5).restoreScrollState(false);
    L12:
        ((HorizontalScrollListView) r5).setScrollEnabled(!r11);
    L18:
        long[] r7 = new long[this.mSelectedSet.size()];
        Iterator<Long> r1 = this.mSelectedSet.iterator();
        Intrinsics.checkNotNullExpressionValue(r1, "mSelectedSet.iterator()");
        int r3 = 0;
    L20:
        if (r1.hasNext() == false) goto L22;
        Long r6 = r1.next();
        Intrinsics.checkNotNullExpressionValue(r6, "iterator.next()");
        r7[r3] = r6.longValue();
        r3 = r3 + 1;
        goto L20
    L22:
        if (r11 == false) goto L26;
        BottomDeleteLayoutListener r2 = this.mBottomDeleteLayoutListener;
        if (r2 == null) goto L26;
        String r4 = getResources().getString(R.string.delete_btn);
        Intrinsics.checkNotNullExpressionValue(r4, "resources.getString(R.string.delete_btn)");
        r2.setButtonText(r4);
    L26:
        if (r12 == false) goto L28;
        performAnimationForEdit(r11, r5, r13, r7, r14);
    L29:
        if (r11 == false) goto L37;
        setButtonVisibility(2);
        refreshOptionBar(0);
        OSearchBar r15 = this.mOSearchbar;
        if (r15 == null) goto L34;
        r15.setAlpha(0.3f);
    L34:
        BottomDeleteLayoutListener r16 = this.mBottomDeleteLayoutListener;
        if (r16 == null) goto L44;
        r16.setLayoutVisible(true);
    L44:
        IContactSearchBarPresenter r10 = getPresenter();
        if (r10 == null) goto L49;
        r10.freezeSearchView(r11);
        return;
    L49:
        return;
    L37:
        setButtonVisibility(1);
        this.mSelectedSet.clear();
        OSearchBar r17 = this.mOSearchbar;
        if (r17 == null) goto L41;
        r17.setAlpha(1.0f);
    L41:
        BottomDeleteLayoutListener r18 = this.mBottomDeleteLayoutListener;
        if (r18 == null) goto L44;
        r18.setLayoutVisible(false);
        goto L44
    L28:
        notPerformAnimationForEdit(r11, r5);
        goto L29
    L14:
        if ((r5 instanceof HorizontalScrollExpandableListView) == false) goto L18;
        if (r11 == false) goto L17;
        ((HorizontalScrollExpandableListView) r5).restoreScrollState(false);
    L17:
        ((HorizontalScrollExpandableListView) r5).setScrollEnabled(!r11);
        goto L18
    }

    private final ListView getTargetListView() {
        int r0 = this.mSortMode;
        if (r0 == 1) goto L25;
        if (r0 == 2) goto L23;
        if (r0 == 4) goto L25;
        if (r0 == 8) goto L25;
        if (r0 == 16) goto L23;
        if (r0 == 32) goto L25;
        if (r0 == 64) goto L25;
        if (r0 == 128) goto L25;
        if (r0 == 256) goto L25;
        return null;
    L23:
        return this.mCityListView;
    L25:
        return this.mContactListView;
    }

    private final void notPerformAnimationForEdit(boolean r2, ListView r3) {
        if (r2 == false) goto L6;
        BottomDeleteLayoutListener r4 = this.mBottomDeleteLayoutListener;
        if (r4 == null) goto L9;
        r4.setLayoutVisible(true);
    L9:
        refreshAdapter(r2);
        return;
    L6:
        BottomDeleteLayoutListener r5 = this.mBottomDeleteLayoutListener;
        if (r5 == null) goto L9;
        r5.setLayoutVisible(false);
        goto L9
    }

    private final void performAnimationForEdit(boolean r3, ListView r4, boolean r5, long[] r6, boolean r7) {
        refreshAdapter(r3);
        if (r3 == false) goto L5;
        this.mContactsListAnimator.startEdit(r4);
    L6:
        onAnimationEnd(r3, r4, r5, r6, r7);
        return;
    L5:
        this.mContactsListAnimator.finishEdit(r4);
        goto L6
    }

    private final void onAnimationEnd(boolean r3, ListView r4, boolean r5, long[] r6, boolean r7) {
        if (this.mSearchController == null) goto L7;
        IContactSearchBarPresenter r8 = getPresenter();
        if (r8 == null) goto L7;
        r8.setLayerType(0, null);
    L7:
        BottomDeleteLayoutListener r9 = this.mBottomDeleteLayoutListener;
        if (r9 == null) goto L14;
        if (r9 == null) goto L11;
        r9.startTransition(r3);
    L11:
        BottomDeleteLayoutListener r10 = this.mBottomDeleteLayoutListener;
        if (r10 == null) goto L14;
        r10.setLayoutVisible(r3);
    L14:
        if (r5 == false) goto L20;
        FragmentActivity r11 = getActivity();
        if (r11 != null) goto L18;
        return;
    L18:
        new DeleteContactsTask(this, r11, r7).execute(new long[][]{r6});
        return;
    }

    private final void refreshAdapter(boolean r3) {
        int r0 = this.mSortMode;
        if (r0 != 1) goto L5;
        ContactsListSortByNameAdapter r1 = this.mNorAdapter;
        if (r1 == null) goto L24;
        if (r1 == null) goto L21;
        r1.setEdit(r3);
    L21:
        ContactsListSortByNameAdapter r2 = this.mNorAdapter;
        if (r2 == null) goto L24;
        r2.notifyDataSetChanged();
    L24:
        HeadersListView r4 = this.mContactListView;
        if (r4 == null) goto L30;
        r4.setSlideEnable(r3);
        return;
    L30:
        return;
    L5:
        if (r0 != 256) goto L31;
        ContactsListSortByNameAdapter r5 = this.mPhoneContactsAdapter;
        if (r5 == null) goto L14;
        if (r5 == null) goto L11;
        r5.setEdit(r3);
    L11:
        ContactsListSortByNameAdapter r6 = this.mPhoneContactsAdapter;
        if (r6 == null) goto L14;
        r6.notifyDataSetChanged();
    L14:
        HeadersListView r7 = this.mContactListView;
        if (r7 == null) goto L28;
        r7.setSlideEnable(r3);
        return;
    L28:
        return;
    }

    private final boolean isEmpty() {
        int r0 = this.mSortMode;
        if (r0 != 1) goto L5;
        ArrayList<SamContact> r1 = this.mOldContacts;
        if (r1 == null) goto L138;
        if (r1 != null) goto L113;
    L115:
        boolean r2 = false;
    L116:
        if (r2 == false) goto L118;
        return true;
    L118:
        if (ContactsUtils.isOnlyIncludeProfile(this.mOldContacts) == false) goto L121;
        return true;
    L121:
        return false;
    L113:
        if (r1.size() != 0) goto L115;
        r2 = true;
        goto L116
    L138:
        return true;
    L5:
        if (r0 != 2) goto L7;
        ArrayList<SamContact> r4 = this.mOldContactCityItems;
        if (r4 == null) goto L136;
        if (r4 != null) goto L102;
    L104:
        boolean r5 = false;
    L105:
        if (r5 == false) goto L108;
        return true;
    L108:
        return false;
    L102:
        if (r4.size() != 0) goto L104;
        r5 = true;
        goto L105
    L136:
        return true;
    L7:
        if (r0 != 4) goto L9;
        ArrayList<SamContact> r6 = this.mOldContactTimesItems;
        if (r6 == null) goto L134;
        if (r6 != null) goto L91;
    L93:
        boolean r7 = false;
    L94:
        if (r7 == false) goto L97;
        return true;
    L97:
        return false;
    L91:
        if (r6.size() != 0) goto L93;
        r7 = true;
        goto L94
    L134:
        return true;
    L9:
        if (r0 != 8) goto L11;
        ArrayList<SamContact> r8 = this.mOldContactAddedTimeItems;
        if (r8 == null) goto L132;
        if (r8 != null) goto L80;
    L82:
        boolean r9 = false;
    L83:
        if (r9 == false) goto L86;
        return true;
    L86:
        return false;
    L80:
        if (r8.size() != 0) goto L82;
        r9 = true;
        goto L83
    L132:
        return true;
    L11:
        if (r0 != 16) goto L13;
        ArrayList<SamContact> r10 = this.mOldContactsCompanyItems;
        if (r10 == null) goto L130;
        if (r10 != null) goto L69;
    L71:
        boolean r11 = false;
    L72:
        if (r11 == false) goto L75;
        return true;
    L75:
        return false;
    L69:
        if (r10.size() != 0) goto L71;
        r11 = true;
        goto L72
    L130:
        return true;
    L13:
        if (r0 != 32) goto L15;
        ArrayList<SamContact> r12 = this.mOldContactsSim1Items;
        if (r12 == null) goto L128;
        if (r12 != null) goto L58;
    L60:
        boolean r13 = false;
    L61:
        if (r13 == false) goto L64;
        return true;
    L64:
        return false;
    L58:
        if (r12.size() != 0) goto L60;
        r13 = true;
        goto L61
    L128:
        return true;
    L15:
        if (r0 != 64) goto L17;
        ArrayList<SamContact> r14 = this.mOldContactsSim2Items;
        if (r14 == null) goto L126;
        if (r14 != null) goto L47;
    L49:
        boolean r15 = false;
    L50:
        if (r15 == false) goto L53;
        return true;
    L53:
        return false;
    L47:
        if (r14.size() != 0) goto L49;
        r15 = true;
        goto L50
    L126:
        return true;
    L17:
        if (r0 != 128) goto L19;
        ArrayList<SamContact> r16 = this.mOldContactsBCRItems;
        if (r16 == null) goto L124;
        if (r16 != null) goto L36;
    L38:
        boolean r17 = false;
    L39:
        if (r17 == false) goto L42;
        return true;
    L42:
        return false;
    L36:
        if (r16.size() != 0) goto L38;
        r17 = true;
        goto L39
    L124:
        return true;
    L19:
        if (r0 == 256) goto L21;
        return false;
    L21:
        ArrayList<SamContact> r18 = this.mOldContactsPhoneItems;
        if (r18 == null) goto L122;
        if (r18 != null) goto L25;
    L27:
        boolean r19 = false;
    L28:
        if (r19 == false) goto L31;
        return true;
    L31:
        return false;
    L25:
        if (r18.size() != 0) goto L27;
        r19 = true;
        goto L28
    L122:
        return true;
    }

    private final void refreshOptionBar(int r7) {
        int r0 = this.mSortMode;
        boolean r1 = true;
        if (r0 != 1) goto L5;
    L26:
        int r2 = this.mContactsIdList.size();
    L27:
        String r3 = getResources().getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r7)});
        Intrinsics.checkNotNullExpressionValue(r3, "getResources().getString…cted_item_numbers, count)");
        if (this.mIsEdit == false) goto L35;
        OFloatingTitleBarHolder r4 = this.mTitleBarHolder;
        if (r4 == null) goto L35;
        OFloatingTitleBar r5 = r4.getTitleBar();
        if (r5 == null) goto L35;
        r5.setCenterTitle(r3);
    L35:
        if (this.mIsEdit == false) goto L45;
        SelectAllState r6 = this.mContactSelectAllBtn;
        if (r6 == null) goto L45;
        if (r6 == null) goto L45;
        if (r7 != r2) goto L42;
        boolean r8 = true;
    L43:
        r6.setSelectAll(r8);
        goto L45
    L42:
        r8 = false;
    L45:
        if (this.mIsEdit == false) goto L54;
        BottomDeleteLayoutListener r9 = this.mBottomDeleteLayoutListener;
        if (r9 == null) goto L55;
        if (r9 == null) goto L56;
        if (r7 != 0) goto L52;
        r1 = false;
    L52:
        r9.setBottomBtnEnable(r1);
        return;
    L56:
        return;
    L55:
        return;
    L54:
        return;
    L5:
        if (r0 != 2) goto L7;
        r2 = this.mContactsIdForLocation.size();
        goto L27
    L7:
        if (r0 == 4) goto L26;
        if (r0 == 8) goto L26;
        if (r0 == 16) goto L26;
        if (r0 != 32) goto L15;
        r2 = this.mContactsIdSIM1.size();
        goto L27
    L15:
        if (r0 != 64) goto L17;
        r2 = this.mContactsIdSIM2.size();
        goto L27
    L17:
        if (r0 != 128) goto L19;
        r2 = this.mContactsIdBCR.size();
        goto L27
    L19:
        if (r0 == 256) goto L21;
        r2 = 0;
        goto L27
    L21:
        r2 = this.mPhoneContactsIdList.size();
        goto L27
    }

    private final void showDeleteContactsDialog() {
        final int r0 = BDSettingsEvent.EVENT_TYPE_CONTACT_DELETE.getType();
        OAlertDialogUtils r1 = OAlertDialogUtils.INSTANCE;
        Context r2 = requireContext();
        String r3 = getString(R.string.sheet_title_remove_number);
        String r4 = getString(R.string.btn_confirm_delete);
        DialogInterface.OnClickListener r6 = new NewContactListFragment$$ExternalSyntheticLambda23(this, r0);
        String r5 = getString(R.string.common_cancel);
        ButtonStyleController.TextColorType r7 = ButtonStyleController.TextColorType.Negative;
        DialogInterface.OnClickListener r9 = new NewContactListFragment$$ExternalSyntheticLambda24(this, r0);
        Intrinsics.checkNotNullExpressionValue(r2, "requireContext()");
        OAlertDialog r8 = OAlertDialogUtils.showConfirmationDialog$default(r2, r3, null, r4, r6, r7, r5, r9, null, 256, null);
        this.mDeleteDialog = r8;
        if (r8 == null) goto L5;
        r8.setCanceledOnTouchOutside(true);
    L5:
        OAlertDialog r13 = this.mDeleteDialog;
        if (r13 == null) goto L9;
        r13.show();
        return;
    }

    private static final void showDeleteContactsDialog$lambda$46(NewContactListFragment r0, int r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        r0.doRemoveAction();
        OAlertDialog r4 = r0.mDeleteDialog;
        if (r4 == null) goto L6;
        if (r4 == null) goto L6;
        r4.dismiss();
    L6:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r0.getContext(), r1, false, true);
        if (ContactsUtils.DEBUG == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "ContactsDeleteDialog click confirm button");
        return;
    }

    private static final void showDeleteContactsDialog$lambda$47(NewContactListFragment r0, int r1, DialogInterface r2, int r3) {
        Intrinsics.checkNotNullParameter(r0, "this$0");
        OAlertDialog r4 = r0.mDeleteDialog;
        if (r4 == null) goto L6;
        if (r4 == null) goto L6;
        r4.dismiss();
    L6:
        OAutoSecurityGuardUtils.sendSecurityGuardEvent(r0.getContext(), r1, false, false);
        if (ContactsUtils.DEBUG == false) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_i(TAG, "ContactsDeleteDialog click close button");
        return;
    }

    private final void doRemoveAction() {
        if (this.mSelectedSet.isEmpty() == false) goto L5;
        return;
    L5:
        int r0 = this.mSortMode;
        boolean r2 = true;
        if (r0 != 1) goto L8;
        ArrayList<SamContact> r1 = this.mOldContacts;
        if (r1 != null) goto L18;
        return;
    L18:
        Intrinsics.checkNotNull(r1);
        Object r3 = r1.clone();
        Intrinsics.checkNotNull(r3, "null cannot be cast to non-null type java.util.ArrayList<com.android.contacts.list.SamContact>");
        final ArrayList r4 = (ArrayList) r3;
        final ContactsListSortByNameAdapter r5 = this.mNorAdapter;
    L19:
        HashSet<String> r6 = new HashSet();
        ArrayList<Integer> r7 = new ArrayList();
        ArrayList<Integer> r8 = new ArrayList();
        Iterator r9 = r4.iterator();
        Intrinsics.checkNotNullExpressionValue(r9, "contacts.iterator()");
        int r10 = 0;
    L21:
        if (r9.hasNext() == false) goto L31;
        Object r11 = r9.next();
        Intrinsics.checkNotNullExpressionValue(r11, "iterator.next()");
        SamContact r12 = (SamContact) r11;
        if (this.mSelectedSet.contains(Long.valueOf(r12.contactId)) == false) goto L28;
        r7.add(Integer.valueOf(r10));
        if (r6.contains(r12.section) == true) goto L27;
        r6.add(r12.section);
    L27:
        r9.remove();
    L29:
        r10 = r10 + 1;
        goto L21
    L28:
        r8.add(Integer.valueOf(r10));
        goto L29
    L31:
        if (this.mSortMode != 1) goto L40;
        Iterator r13 = r4.iterator();
    L34:
        if (r13.hasNext() == false) goto L38;
        if (((SamContact) r13.next()).getType() != 0) goto L34;
        r2 = false;
    L38:
        if (r2 == false) goto L40;
        r4.clear();
    L40:
        HashSet r14 = new HashSet();
        Iterator<String> r15 = r6.iterator();
    L42:
        if (r15.hasNext() == false) goto L49;
        String r16 = r15.next();
        Iterator r17 = r4.iterator();
    L45:
        if (r17.hasNext() == false) goto L42;
        if (TextUtils.equals(((SamContact) r17.next()).section, r16) == false) goto L45;
        r14.add(r16);
        goto L45
    L49:
        r6.removeAll(r14);
        HeadersListView r18 = this.mContactListView;
        if (r18 == null) goto L52;
        r18.setDeletedHeaderSections(r6);
    L52:
        final HeadersListView r19 = this.mContactListView;
        new C01901(this, r5, r4, r19).setResultListSize(r4.size()).setDeletedHeaderSection(r6).start(r7, r8);
        return;
    L8:
        if (r0 != 256) goto L14;
        ArrayList<SamContact> r20 = this.mOldContactsPhoneItems;
        if (r20 != null) goto L12;
        return;
    L12:
        Intrinsics.checkNotNull(r20);
        Object r21 = r20.clone();
        Intrinsics.checkNotNull(r21, "null cannot be cast to non-null type java.util.ArrayList<com.android.contacts.list.SamContact>");
        r4 = (ArrayList) r21;
        r5 = this.mPhoneContactsAdapter;
        goto L19
    L14:
        throw new IllegalArgumentException("sort mode is illegal!");
    }

    private final boolean isGroupAllSelected(int r8, ExpandAdapter r9) {
        if (r9 != null) goto L5;
        return false;
    L5:
        int r1 = r9.getChildrenCount(r8);
        int r2 = 0;
    L6:
        if (r2 >= r1) goto L13;
        SamContact r3 = r9.getChild(r8, r2);
        if (r3 == null) goto L12;
        if (this.mSelectedSet.contains(Long.valueOf(r3.contactId)) == true) goto L12;
        return false;
    L12:
        r2 = r2 + 1;
        goto L6
    L13:
        return true;
    }

    private final void setButtonVisibility(int r4) {
        if (r4 != 1) goto L5;
        OFloatingTitleBarHolder r5 = this.mTitleBarHolder;
        if (r5 == null) goto L26;
        r5.stateTo(OFloatingTitleBarHolder.STATE_NORMAL);
    L26:
        OFloatingTitleBarHolder r6 = this.mTitleBarHolder;
        if (r6 == null) goto L31;
        OTextView r7 = r6.getStartTitleView();
        if (r7 == null) goto L31;
        ViewExtensionsKt.setVisibility(r7, true);
    L31:
        BottomDeleteLayoutListener r8 = this.mBottomDeleteLayoutListener;
        if (r8 == null) goto L34;
        r8.setLayoutVisible(false);
    L34:
        SelectAllState r9 = this.mContactSelectAllBtn;
        if (r9 == null) goto L38;
        r9.setSelectAll(false);
    L38:
        showVoiceSearchBtn();
        OFloatingTitleBarHolder r3 = this.mTitleBarHolder;
        if (r3 == null) goto L45;
        OTextView r10 = r3.getCenterTitleView();
        if (r10 == null) goto L46;
        r10.setVisibility(8);
        return;
    L46:
        return;
    L45:
        return;
    L5:
        if (r4 != 2) goto L47;
        OFloatingTitleBarHolder r11 = this.mTitleBarHolder;
        if (r11 == null) goto L10;
        r11.stateTo(OFloatingTitleBarHolder.STATE_EDIT);
    L10:
        OFloatingTitleBarHolder r12 = this.mTitleBarHolder;
        if (r12 == null) goto L15;
        OTextView r13 = r12.getStartTitleView();
        if (r13 == null) goto L15;
        ViewExtensionsKt.setVisibility(r13, false);
    L15:
        BottomDeleteLayoutListener r14 = this.mBottomDeleteLayoutListener;
        if (r14 == null) goto L18;
        r14.setLayoutVisible(true);
    L18:
        SelectAllState r15 = this.mContactSelectAllBtn;
        if (r15 == null) goto L22;
        r15.setSelectAll(false);
    L22:
        hideVoiceSearchBtn();
        return;
    }

    private final void setGroupEditState(boolean r6) {
        BottomDeleteLayoutListener r0 = this.mBottomDeleteLayoutListener;
        if (r0 == null) goto L6;
        if (r0 == null) goto L6;
        r0.startTransition(r6);
    L6:
        FragmentActivity r1 = getActivity();
        if (r1 != null) goto L9;
        return;
    L9:
        OCTitleBar r2 = this.mOGroupTitleBar;
        if (r2 != null) goto L13;
        return;
    L13:
        if (r6 == false) goto L53;
        BottomDeleteLayoutListener r7 = this.mBottomDeleteLayoutListener;
        if (r7 == null) goto L18;
        r7.setLayoutVisible(true);
    L18:
        if (r2.getMLeftContainer().getChildCount() < 1) goto L20;
        r2.getMLeftContainer().removeAllViews();
    L20:
        BottomDeleteLayoutListener r8 = this.mBottomDeleteLayoutListener;
        if (r8 == null) goto L24;
        if (r8 == null) goto L24;
        r8.setBottomBtnEnable(false);
    L24:
        OButton r9 = r2.createNeutralButton(r1, r2.getMLeftContainer());
        this.mBtnGroupLeft = r9;
        if (r9 == null) goto L35;
        OButton r3 = this.mBtnGroupLeft;
        Intrinsics.checkNotNull(r3);
        this.mGroupSelectAllBtn = new SelectAllState(r3);
        OButton r10 = this.mBtnGroupLeft;
        if (r10 == null) goto L29;
        r10.setText(R.string.select_all);
    L29:
        OButton r11 = this.mBtnGroupLeft;
        if (r11 == null) goto L32;
        r11.setContentDescription(getString(R.string.select_all));
    L32:
        OButton r12 = this.mBtnGroupLeft;
        if (r12 == null) goto L35;
        r12.setOnClickListener(new ViewOnClickListenerC02001(this));
    L35:
        OButton r13 = this.mBtnGroupRightDelete;
        if (r13 == null) goto L38;
        r13.setVisibility(0);
    L38:
        OButton r14 = this.mBtnGroupMenu;
        if (r14 == null) goto L41;
        r14.setVisibility(8);
    L41:
        updateBtnGroupRightDeleteStatus(true);
        GroupBrowseListFragment r15 = this.mGroupBrowseListFragment;
        if (r15 == null) goto L48;
        GroupBrowseListAdapter r16 = r15.getAdapter();
        if (r16 == null) goto L48;
        ArrayList<Long> r17 = r16.getCheckedGroupIds();
        if (r17 == null) goto L48;
        int r18 = r17.size();
    L49:
        String r19 = getString(R.string.delete_selected_item_numbers, new Object[]{Integer.valueOf(r18)});
        Intrinsics.checkNotNullExpressionValue(r19, "getString(R.string.delet…ected_item_numbers, size)");
        OCTitleBar r5 = this.mOGroupTitleBar;
        if (r5 == null) goto L78;
        r5.setTitleText(r19);
        return;
    L78:
        return;
    L48:
        r18 = 0;
        goto L49
    L53:
        BottomDeleteLayoutListener r20 = this.mBottomDeleteLayoutListener;
        if (r20 == null) goto L56;
        r20.setLayoutVisible(false);
    L56:
        OButton r21 = getTitleBtn(R.drawable.standard_icon_multi_select_selector, true, this.mOGroupTitleBar, this.mBtnGroupLeft);
        this.mBtnGroupLeft = r21;
        if (r21 == null) goto L63;
        if (r21 == null) goto L60;
        r21.setContentDescription("选择");
    L60:
        OButton r22 = this.mBtnGroupLeft;
        if (r22 == null) goto L63;
        r22.setOnClickListener(new ViewOnClickListenerC02012(this));
    L63:
        this.mGroupSelectAllBtn = null;
        OButton r23 = this.mBtnGroupRightDelete;
        if (r23 == null) goto L66;
        r23.setVisibility(8);
    L66:
        OButton r24 = this.mBtnGroupMenu;
        if (r24 == null) goto L69;
        r24.setVisibility(0);
    L69:
        updateBtnGroupRightDeleteStatus(false);
        OCTitleBar r25 = this.mOGroupTitleBar;
        if (r25 == null) goto L76;
        TextView r26 = r25.getMTitleView();
        if (r26 == null) goto L77;
        r26.setVisibility(8);
        return;
    L77:
        return;
    }

    private final void updateBtnGroupRightDeleteStatus(boolean r4) {
        if (r4 == false) goto L30;
        GroupBrowseListFragment r5 = this.mGroupBrowseListFragment;
        if (r5 == null) goto L36;
        Integer r0 = null;
        if (r5 == null) goto L8;
        GroupBrowseListAdapter r6 = r5.getAdapter();
    L9:
        if (r6 == null) goto L37;
        GroupBrowseListFragment r7 = this.mGroupBrowseListFragment;
        if (r7 == null) goto L15;
        GroupBrowseListAdapter r8 = r7.getAdapter();
        if (r8 == null) goto L15;
        Integer r9 = Integer.valueOf(r8.getCount());
    L16:
        GroupBrowseListFragment r1 = this.mGroupBrowseListFragment;
        if (r1 == null) goto L21;
        GroupBrowseListAdapter r2 = r1.getAdapter();
        if (r2 == null) goto L21;
        r0 = Integer.valueOf(r2.getReadOnlyItemSize());
    L21:
        SelectAllState r3 = this.mGroupSelectAllBtn;
        if (r3 == null) goto L27;
        if (r3 == null) goto L27;
        TextView r10 = r3.getBtn();
        if (r10 == null) goto L27;
        r10.setEnabled(!Intrinsics.areEqual(r9, r0));
    L27:
        BottomDeleteLayoutListener r11 = this.mBottomDeleteLayoutListener;
        if (r11 == null) goto L38;
        r11.setBottomBtnEnable(!Intrinsics.areEqual(r9, r0));
        return;
    L38:
        return;
    L15:
        r9 = null;
        goto L16
    L37:
        return;
    L8:
        r6 = null;
        goto L9
    L36:
        return;
    L30:
        SelectAllState r12 = this.mGroupSelectAllBtn;
        if (r12 == null) goto L40;
        if (r12 == null) goto L41;
        r12.setSelectAll(false);
        return;
    L41:
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r8v2, types: [T, com.obric.oui.dialog.v2.action.OActionDialog] */
    private final void showImportContactsInEmptyDialog() {
        ArrayList r0 = new ArrayList();
        if (ContactsUtils.isBytedanceCloudExist() == false) goto L5;
        String r1 = getString(R.string.import_from_cloud);
        Intrinsics.checkNotNullExpressionValue(r1, "getString(R.string.import_from_cloud)");
        r0.add(r1);
    L5:
        String r2 = getString(R.string.import_from_sdcard);
        Intrinsics.checkNotNullExpressionValue(r2, "getString(R.string.import_from_sdcard)");
        r0.add(r2);
        if (ContactsUtils.getExternalSdcardExportDirectoryPath() == null) goto L8;
        String r3 = getString(R.string.import_from_external_sdcard);
        Intrinsics.checkNotNullExpressionValue(r3, "getString(R.string.import_from_external_sdcard)");
        r0.add(r3);
    L8:
        String r4 = getString(R.string.import_from_sim);
        Intrinsics.checkNotNullExpressionValue(r4, "getString(R.string.import_from_sim)");
        r0.add(r4);
        String r5 = getString(R.string.import_from_other_phone);
        Intrinsics.checkNotNullExpressionValue(r5, "getString(R.string.import_from_other_phone)");
        r0.add(r5);
        String r6 = getString(R.string.common_cancel);
        Intrinsics.checkNotNullExpressionValue(r6, "getString(R.string.common_cancel)");
        r0.add(r6);
        this.importFlag = getString(R.string.import_from_cloud);
        FragmentActivity r7 = getActivity();
        if (r7 != null) goto L11;
        return;
    L11:
        final Ref.ObjectRef r8 = new Ref.ObjectRef();
        ArrayList r9 = r0;
        ArrayList r10 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r9, 10));
        Iterator r11 = r9.iterator();
    L13:
        if (r11.hasNext() == false) goto L15;
        final String r12 = (String) r11.next();
        r10.add(new ActionDialogItemData(r12, ActionButtonStyle.Neutral, new NewContactListFragment$$ExternalSyntheticLambda22(r8, this, r12)));
        goto L13
    L15:
        FragmentActivity r13 = r7;
        String r14 = getString(R.string.common_import_contacts);
        Intrinsics.checkNotNullExpressionValue(r14, "getString(R.string.common_import_contacts)");
        r8.element = OUIDialogHelper.getActionDialog(r13, r14, "", r10, true);
        ((OActionDialog) r8.element).setCanceledOnTouchOutside(true);
        ((OActionDialog) r8.element).show();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void showImportContactsInEmptyDialog$lambda$49$lambda$48(Ref.ObjectRef r0, NewContactListFragment r1, String r2, View r3) {
        Intrinsics.checkNotNullParameter(r0, "$dialog");
        Intrinsics.checkNotNullParameter(r1, "this$0");
        Intrinsics.checkNotNullParameter(r2, "$title");
        OActionDialog r4 = (OActionDialog) r0.element;
        if (r4 == null) goto L5;
        r4.dismiss();
    L5:
        r1.doImportContactsAction(r2);
    }

    private final void doImportContactsAction(String r3) {
        if (Intrinsics.areEqual(getString(R.string.common_cancel), r3) == false) goto L6;
        return;
    L6:
        if (Intrinsics.areEqual(getString(R.string.import_from_cloud), r3) == false) goto L9;
        AnimationUtil.startActivity(this.mContext, ContactsIntentUtils.getBytedanceCloudLoginIntent());
        return;
    L9:
        if (Intrinsics.areEqual(getString(R.string.import_from_third_part_accout), r3) == false) goto L12;
        ArrayList<String> r4 = new ArrayList();
        r4.add(BytedanceAccountType.ACCOUNT_TYPE);
        startActivity(ContactEditorUtils.getInstance(this.mContext).createAddWritableAccountIntent(r4));
        return;
    L12:
        if (Intrinsics.areEqual(getString(R.string.import_from_sdcard), r3) == false) goto L15;
        AccountSelectionUtil.doImport(getActivity(), R.id.btn_import_from_sdcard, null);
        return;
    L15:
        if (Intrinsics.areEqual(getString(R.string.import_from_external_sdcard), r3) == false) goto L18;
        AccountSelectionUtil.doImport(getActivity(), R.id.btn_import_from_external_sdcard, null);
        return;
    L18:
        if (Intrinsics.areEqual(getString(R.string.import_from_sim), r3) == false) goto L33;
        if (DSUtils.isMultiSimEnabled() == true) goto L22;
        importContactsInEmpty(R.id.btn_import_from_sim);
        return;
    L22:
        if (DSUtils.isAllSimsEnable() == false) goto L25;
        showSimSelectDialog(R.id.btn_import_from_sim);
        return;
    L25:
        if (DSUtils.isSim1Enalbe() == false) goto L28;
        this.mImportSimId = 0;
    L30:
        importContactsInEmpty(R.id.btn_import_from_sim);
        return;
    L28:
        if (DSUtils.isSim2Eanble() == false) goto L30;
        this.mImportSimId = 1;
        goto L30
    L33:
        if (Intrinsics.areEqual(getString(R.string.import_from_other_phone), r3) == false) goto L46;
        Intent r5 = new Intent();
        r5.setClassName(ContactsUtils.IMPORT_OTHER_PHONE_PACKAGE_NAME, ContactsUtils.IMPORT_OTHER_PHONE_ACTIVITY_NAME);
        r5.setAction("android.intent.action.MAIN");
        r5.setFlags(MarkInfoUtil.MARK_CLASSIFY_ZTE_BLACKLIST);
        FragmentActivity r0 = getActivity();
        if (r0 == null) goto L37;
        r0.startActivity(r5);
    L37:
        AnimationUtil.switchActivityAnimation(getActivity(), 5);
        return;
    }

    private final void showSimSelectDialog(final int r6) {
        AccountSelectionMenuDialog r0 = new AccountSelectionMenuDialog(this.mContext);
        Context r1 = this.mContext;
        if (r1 == null) goto L5;
        String r2 = r1.getString(R.string.sim_select_dialog_title);
    L6:
        r0.setTitle(r2);
        r0.setAdapter(new ImportExportFragment.SimSelectAdapter(new ImportExportFragment(), this.mContext, this), new DialogInterfaceOnClickListenerC02021(this, r6));
        r0.show();
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final boolean importContactsInEmpty(int r3) {
        doImportInEmpty(getActivity(), r3, null);
        return true;
    }

    private final void doImportInEmpty(Context r2, int r3, AccountWithDataSet r4) {
        if (r3 == R.id.btn_import_from_sim) goto L5;
        AccountSelectionUtil.doImport(getActivity(), R.id.btn_import_from_sdcard, r4);
        return;
    L5:
        if (ContactsUtils.isNoSim(getActivity()) == false) goto L8;
        Toast.makeText(getActivity(), R.string.toast_no_sim, 0).show();
        return;
    L8:
        Intent r5 = new Intent(getActivity(), ImportSimContacts.class);
        r5.putExtra(ImportSimContacts.EXTRA_ACCOUNT, r4);
        if (DSUtils.isMultiSimEnabled() == false) goto L11;
        r5.putExtra(DSUtils.SUBSCRIPTION_KEY, this.mImportSimId);
    L11:
        startActivity(r5);
    }

    private final void startCreateNewContactActivity() {
        Intent r0 = new Intent("android.intent.action.INSERT", ContactsContract.Contacts.CONTENT_URI);
        r0.setPackage("com.android.contacts");
        r0.putExtra("scan_barcode", true);
        r0.putExtra("enter_from", "new_contact_list_create");
        startActivityAndForwardResult(r0);
    }

    public final void startActivityAndForwardResult(Intent r4) {
        Intrinsics.checkNotNullParameter(r4, MemorySourceLinkType.INTENT);
        ActivityOptions r0 = ActivityOptions.makeCustomAnimation(getActivity(), R.anim.activity_slide_in_from_bottom, R.anim.activity_slide_do_nothing);
        r4.setFlags(VCardConfig.FLAG_REFRAIN_PHONE_NUMBER_FORMATTING);
        FragmentActivity r1 = getActivity();
        if (r1 == null) goto L7;
        Intent r2 = r1.getIntent();
        if (r2 == null) goto L7;
        Bundle r3 = r2.getExtras();
    L8:
        if (r3 == null) goto L10;
        r4.putExtras(r3);
    L10:
        startActivity(r4, r0.toBundle());
        return;
    L7:
        r3 = null;
        goto L8
    }

    @Override // android.widget.AbsListView.OnScrollListener
    public void onScrollStateChanged(AbsListView r3, int r4) {
        Intrinsics.checkNotNullParameter(r3, "arg0");
        if (r3 != this.mContactListView) goto L5;
    L6:
        if (r4 != 0) goto L8;
        stopListScrollFpsSampling();
    L10:
        if (r4 != 1) goto L12;
    L38:
        Handler r5 = this.mHandler;
        if (r5 == null) goto L41;
        r5.removeCallbacks(this.mScrollIdle);
    L41:
        hideSoftKeyboard();
        this.mWaitingScrollIdle = true;
        ContactPhotoManager r6 = this.mPhotoManager;
        if (r6 == null) goto L45;
        r6.pause();
    L45:
        if (this.mIsEdit == false) goto L47;
    L49:
        BlacklistManager r2 = this.mBlacklistManager;
        if (r2 == null) goto L55;
        r2.pause();
        return;
    L55:
        return;
    L47:
        if (this.isSearch == true) goto L49;
        hideVoiceSearchBtn();
        goto L49
    L12:
        if (r4 == 2) goto L38;
        boolean r7 = false;
        this.mWaitingScrollIdle = false;
        OIndexScrollbar r1 = this.mQuickBar;
        if (r1 != null) goto L16;
    L18:
        if (r7 == false) goto L22;
        ContactPhotoManager r8 = this.mPhotoManager;
        if (r8 == null) goto L22;
        r8.resume();
    L22:
        BlacklistManager r9 = this.mBlacklistManager;
        if (r9 == null) goto L25;
        r9.resume();
    L25:
        int r10 = this.mSortMode;
        if (r10 != 1) goto L28;
    L31:
        ContactDetailCacheManager.getInstance().refreshCache(r3);
    L32:
        Handler r11 = this.mHandler;
        if (r11 == null) goto L35;
        r11.removeCallbacks(this.mScrollIdle);
    L35:
        Handler r12 = this.mHandler;
        if (r12 == null) goto L53;
        r12.postDelayed(this.mScrollIdle, 150);
        return;
    L53:
        return;
    L28:
        if (r10 == 8) goto L31;
        if (r10 != 4) goto L32;
    L16:
        if (r1.isPerformingAnim() == true) goto L18;
        r7 = true;
        goto L18
    L8:
        startListScrollFpsSampling();
        goto L10
    L5:
        if (r3 != this.mCityListView) goto L10;
        goto L6
    }

    private final void startListScrollFpsSampling() {
        if (this.mIsListScrollFpsSampling == false) goto L5;
        return;
    L5:
        this.mIsListScrollFpsSampling = true;
        this.scrollFpsMonitor.start();
    }

    private final void stopListScrollFpsSampling() {
        if (this.mIsListScrollFpsSampling == true) goto L5;
        return;
    L5:
        this.mIsListScrollFpsSampling = false;
        this.scrollFpsMonitor.stop();
    }

    public final int getMModeState() {
        return this.mModeState;
    }

    public final void setMModeState(int r1) {
        this.mModeState = r1;
    }

    private final boolean dataIsReady(int r1) {
        if ((this.mModeState & r1) <= 0) goto L5;
        return true;
    L5:
        return false;
    }

    private final void setModeState(int r1, boolean r2) {
        if (r2 == false) goto L4;
        this.mModeState = r1 | this.mModeState;
        return;
    L4:
        int r3 = this.mModeState;
        this.mModeState = (~r1) & r3;
    }

    private final void clearModeState() {
        this.mModeState = 0;
    }

    private final void resetSearchBar() {
        if (this.mSearchContainer != null) goto L5;
        return;
    L5:
        if (this.isSearch == false) goto L7;
        cancelSearch();
    L7:
        IContactSearchBarPresenter r1 = getPresenter();
        if (r1 == null) goto L12;
        r1.returnToSortByName();
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onPopupDismissIView() {
        showVoiceSearchBtnDelayed(100);
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public boolean onModeChangeIView(int r3) {
        if (isResumed() == true) goto L6;
        return false;
    L6:
        if (checkPermission(r3) == true) goto L8;
        return false;
    L8:
        onModeChanged(r3);
        return true;
    }

    private final void onModeChanged(int r9) {
        if (r9 == 2) goto L7;
        if (r9 == 16) goto L7;
    L12:
        int r2 = this.mSortMode;
        if (r2 != 2) goto L16;
        if (r2 == r9) goto L16;
        this.mResetContactListView = true;
    L16:
        HeadersListView r0 = this.mContactListView;
        if (r0 == null) goto L19;
        r0.restoreScrollState(false);
    L19:
        this.mSortMode = r9;
        triggerLoad$default(this, r9, false, false, 4, null);
        showVoiceSearchBtnDelayed(100);
        return;
    L7:
        if (this.mSortMode == r9) goto L12;
        if (this.mCityListViewFrame != null) goto L11;
        initCityListView();
    L11:
        this.mCollapseAllGroup = true;
        goto L12
    }

    private final boolean checkPermission(int r4) {
        if (r4 == 4) goto L5;
        return true;
    L5:
        return PermissionUtils.checkPermission(this, 11, (String[]) PrivacyConstantsKt.PERMS_FOR_SMS.toArray(new String[0]), getString(R.string.permission_guide_sms_msg), null);
    }

    @Override // androidx.fragment.app.Fragment
    public void onRequestPermissionsResult(int r2, String[] r3, int[] r4) {
        Intrinsics.checkNotNullParameter(r3, "permissions");
        Intrinsics.checkNotNullParameter(r4, "grantResults");
        if (r2 != 11) goto L11;
        PermissionUtils.setPermsUserSet(getContext(), r2);
        if (PermissionUtils.granted(r4) == false) goto L12;
        IContactSearchBarPresenter r5 = this.mPresenter;
        if (r5 == null) goto L9;
        r5.setSortMode(4);
    L9:
        onModeChanged(4);
        return;
    L12:
        return;
    }

    private final void initCityListView() {
        View r0 = this.mContactsFragment;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(R.id.contact_stub_city_list);
    L6:
        ViewStub r2 = (ViewStub) r1;
        if (r2 == null) goto L27;
        View r3 = r2.inflate();
        this.mCityListViewFrame = (FrameLayout) r3.findViewById(R.id.city_list_frame);
        QuickContactExpandableListView r4 = (QuickContactExpandableListView) r3.findViewById(R.id.city_list);
        this.mCityListView = r4;
        if (r4 == null) goto L11;
        r4.setOnScrollListener(this);
    L11:
        QuickContactExpandableListView r5 = this.mCityListView;
        if (r5 == null) goto L14;
        r5.setOnGroupExpandListener(this.mGroupExpandListener);
    L14:
        QuickContactExpandableListView r6 = this.mCityListView;
        if (r6 == null) goto L17;
        r6.setOnGroupCollapseListener(this.mGroupCollapseListener);
    L17:
        QuickContactExpandableListView r7 = this.mCityListView;
        if (r7 == null) goto L20;
        r7.setItemLongClickedListener(this.mExpandableListItemLongClickedListener);
    L20:
        QuickContactExpandableListView r8 = this.mCityListView;
        if (r8 == null) goto L23;
        r8.setSlideListener(this.mSlideListenerForExpandable);
    L23:
        QuickContactExpandableListView r9 = this.mCityListView;
        if (r9 == null) goto L28;
        r9.setTouchMonitorListener(this.mTouchMonitorListenerForExpandable);
        return;
    L28:
        return;
    L27:
        return;
    L5:
        r1 = null;
        goto L6
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void setSoftKeyboardHideIView() {
        hideSoftKeyboard();
    }

    private final void initAnimation() {
        AnimationSet r1 = new AnimationSet(true);
        TranslateAnimation r12 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AnimationSet r3 = new AnimationSet(true);
        TranslateAnimation r4 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AnimationSet r5 = new AnimationSet(true);
        TranslateAnimation r6 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AlphaAnimation r7 = new AlphaAnimation(0.0f, 1.0f);
        AnimationSet r10 = new AnimationSet(true);
        TranslateAnimation r11 = new TranslateAnimation(1, 0.0f, 1, 0.0f, 0, 0.0f, 0, 0.0f);
        AlphaAnimation r13 = new AlphaAnimation(1.0f, 0.0f);
        r1.addAnimation(r12);
        r1.setDuration(this.mDuration);
        r1.setFillAfter(true);
        r3.addAnimation(r4);
        r3.setDuration(this.mDuration);
        r5.addAnimation(r6);
        r5.addAnimation(r7);
        r5.setDuration(this.mDuration);
        r10.addAnimation(r11);
        r10.addAnimation(r13);
        r10.setDuration(this.mDuration);
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onSearchAnimationStartIView() {
        ContactFragmentsCallback r0 = this.mFragmentsCallback;
        if (r0 == null) goto L6;
        r0.coverVeil();
        return;
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void startContactAnimationIView() {
        final long r0 = this.mSearchAnimationGeneration + 1;
        this.mSearchAnimationGeneration = r0;
        hideVoiceSearchBtn();
        FragmentActivity r2 = getActivity();
        Unit r4 = null;
        if ((r2 instanceof DialtactsActivity) == false) goto L5;
        DialtactsActivity r3 = (DialtactsActivity) r2;
    L6:
        if (r3 == null) goto L8;
        OBottomNavigationBar r5 = r3.getMBottomNavigationBar();
    L9:
        if (r5 == null) goto L13;
        r5.setVisibility(8);
    L13:
        if (this.mSearchResultView != null) goto L15;
        initSearchViews();
    L15:
        OIconButtonFloating r6 = this.mOSearchRightButton;
        if (r6 == null) goto L19;
        r6.setVisibility(0);
    L19:
        OIconButtonFloating r7 = this.mOSearchRightButton;
        if (r7 == null) goto L23;
        r7.setEnabled(true);
    L23:
        OIconButtonFloating r8 = this.mOSearchRightButton;
        if (r8 == null) goto L27;
        r8.setClickable(true);
    L27:
        ContactsUtils.setAnimatorScale(this.mActivity);
        RelativeLayout r9 = this.mSearchResultView;
        if (r9 == null) goto L30;
        r9.setVisibility(0);
    L30:
        this.mSearchSwitchANimHelper = null;
        OIconButtonFloating r10 = this.mOSearchRightButton;
        if (r10 == null) goto L33;
        r10.postOnAnimation(new NewContactListFragment$$ExternalSyntheticLambda21(r0, this));
        r4 = Unit.INSTANCE;
    L33:
        if (r4 != null) goto L36;
        enterSearch();
        return;
    L36:
        return;
    L8:
        r5 = null;
        goto L9
    L5:
        r3 = null;
        goto L6
    }

    private static final void startContactAnimationIView$lambda$50(long r2, NewContactListFragment r4) {
        Intrinsics.checkNotNullParameter(r4, "this$0");
        if (r2 != r4.mSearchAnimationGeneration) goto L6;
        r4.enterSearch();
        return;
    }

    private final SearchSwitchAnimHelper getOrCreateSearchAnimHelper() {
        SearchSwitchAnimHelper r0 = this.mSearchSwitchANimHelper;
        if (r0 == null) goto L5;
        return r0;
    L5:
        OIconButtonFloating r1 = this.mOSearchRightButton;
        if (r1 == null) goto L8;
        r1.measure(0, 0);
    L8:
        OIconButtonFloating r2 = this.mOSearchRightButton;
        if (r2 == null) goto L11;
        int r3 = r2.getMeasuredWidth();
    L12:
        OSearchBar r4 = this.mOSearchbar;
        if (r4 == null) goto L15;
        int r5 = r4.getWidth();
    L16:
        OSearchBar r6 = this.mOSearchbar;
        if (r6 == null) goto L19;
        int r7 = r6.getMeasuredWidth();
    L20:
        int r8 = Math.max(r5, r7);
        OFloatingTitleBarHolder r9 = this.mTitleBarHolder;
        if (r9 == null) goto L25;
        OFloatingTitleBar r10 = r9.getTitleBar();
        if (r10 == null) goto L25;
        int r11 = r10.getHeight();
    L26:
        OFloatingTitleBarHolder r12 = this.mTitleBarHolder;
        if (r12 == null) goto L31;
        OFloatingTitleBar r13 = r12.getTitleBar();
        if (r13 == null) goto L31;
        int r14 = r13.getMeasuredHeight();
    L32:
        int r15 = Math.max(r11, r14);
        SearchSwitchAnimHelper r16 = null;
        if (r8 <= 0) goto L59;
        if (r15 <= 0) goto L59;
        if (this.mOSearchbar == null) goto L59;
        int r17 = Math.max(0, (r8 - r3) - MathKt.roundToInt(TypedValue.applyDimension(1, 8, Resources.getSystem().getDisplayMetrics())));
        SearchSwitchAnimHelper r18 = new SearchSwitchAnimHelper();
        OSearchBar r19 = this.mOSearchbar;
        Intrinsics.checkNotNull(r19);
        SearchSwitchAnimHelper r20 = r18.setSearchBox(r19, r8, r17, -r15);
        if (r20 == null) goto L58;
        OIconButtonFloating r21 = this.mOSearchRightButton;
        if (r21 == null) goto L43;
        r20.setCancelButton(r21, false);
    L43:
        RelativeLayout r22 = this.mContactBody;
        if (r22 == null) goto L46;
        r20.setSearchPageContainer(r22);
    L46:
        RelativeLayout r23 = this.mSearchResultView;
        if (r23 == null) goto L49;
        r20.setSearchResultContainer(r23);
    L49:
        OFloatingTitleBarHolder r24 = this.mTitleBarHolder;
        if (r24 == null) goto L54;
        OFloatingTitleBar r25 = r24.getTitleBar();
        if (r25 == null) goto L54;
        r20.addSearchBoxParentContent(r25, true);
    L54:
        HeadersListView r26 = this.mContactListView;
        if (r26 == null) goto L57;
        r20.addSearchBoxParentContent(r26, false);
    L57:
        r16 = r20;
    L58:
        this.mSearchSwitchANimHelper = r16;
    L59:
        return r16;
    L31:
        r14 = 0;
    L25:
        r11 = 0;
        goto L26
    L19:
        r7 = 0;
        goto L20
    L15:
        r5 = 0;
        goto L16
    L11:
        r3 = 0;
        goto L12
    }

    private final void onEnterSearchAnimEnd(boolean r3) {
        this.isSearchAnimationing = false;
        ContactFragmentsCallback r1 = this.mFragmentsCallback;
        if (r1 == null) goto L5;
        r1.liftVeil();
    L5:
        if (r3 == false) goto L22;
        OFloatingTitleBarHolder r4 = this.mTitleBarHolder;
        if (r4 == null) goto L11;
        OFloatingTitleBar r5 = r4.getTitleBar();
        if (r5 == null) goto L11;
        r5.setVisibility(4);
    L11:
        OFloatingTitleBarHolder r6 = this.mTitleBarHolder;
        if (r6 == null) goto L16;
        OFloatingTitleBar r7 = r6.getTitleBar();
        if (r7 == null) goto L16;
        ViewExtensionsKt.setEnable(r7, false);
    L16:
        OSearchBar r2 = this.mOSearchbar;
        if (r2 == null) goto L23;
        final OEditText r8 = r2.getInputView();
        if (r8 == null) goto L24;
        r8.postOnAnimation(new NewContactListFragment$$ExternalSyntheticLambda15(r8));
        return;
    L24:
        return;
    L23:
        return;
    }

    private static final void onEnterSearchAnimEnd$lambda$58$lambda$57(OEditText r3) {
        Intrinsics.checkNotNullParameter(r3, "$this_apply");
        r3.requestFocus();
        Context r0 = r3.getContext();
        InputMethodManager r1 = null;
        if (r0 == null) goto L5;
        Object r2 = r0.getSystemService("input_method");
    L7:
        if ((r2 instanceof InputMethodManager) == false) goto L9;
        r1 = (InputMethodManager) r2;
    L9:
        if (r1 == null) goto L12;
        r1.showSoftInput(r3, 0);
        return;
    L12:
        return;
    L5:
        r2 = null;
        goto L7
    }

    private final void onEnterSearchAnimFailed() {
        this.isSearch = false;
        this.isSearchAnimationing = false;
        OFloatingTitleBarHolder r1 = this.mTitleBarHolder;
        if (r1 == null) goto L5;
        OFloatingTitleBar r2 = r1.getTitleBar();
    L6:
        if (r2 == null) goto L9;
        r2.setVisibility(0);
    L9:
        OFloatingTitleBarHolder r0 = this.mTitleBarHolder;
        if (r0 == null) goto L14;
        OFloatingTitleBar r3 = r0.getTitleBar();
        if (r3 == null) goto L14;
        ViewExtensionsKt.setEnable(r3, true);
    L14:
        searchAnimationEnd();
        return;
    L5:
        r2 = null;
        goto L6
    }

    private final void enterSearch() {
        final long r0 = this.mSearchAnimationGeneration;
        this.isSearch = true;
        this.isSearchAnimationing = true;
        HeadersListView r2 = this.mContactListView;
        if (r2 == null) goto L5;
        r2.invalidate();
    L5:
        SearchSwitchAnimHelper r3 = getOrCreateSearchAnimHelper();
        if (r3 == null) goto L9;
        r3.playEnterAnim(new C01911(r0, this));
        return;
    L9:
        ViewGroup r4 = this.mContactBody;
        Unit r5 = null;
        if (r4 == null) goto L12;
    L11:
        ViewGroup r6 = r4;
        if (r6 == null) goto L39;
        ViewGroup r7 = r6;
        if (ViewCompat.isLaidOut(r7) == true) goto L23;
    L37:
        r7.addOnLayoutChangeListener(new NewContactListFragment$enterSearch$$inlined$doOnLayout$1(r0, this));
    L38:
        r5 = Unit.INSTANCE;
        goto L39
    L23:
        if (r7.isLayoutRequested() == true) goto L37;
        if (r0 != access$getMSearchAnimationGeneration$p(this)) goto L38;
        if (isAdded() == true) goto L30;
    L36:
        access$onEnterSearchAnimFailed(this);
        goto L38
    L30:
        if (isSearch() == false) goto L36;
        SearchSwitchAnimHelper r8 = access$getOrCreateSearchAnimHelper(this);
        if (r8 == null) goto L35;
        r8.playEnterAnim(new NewContactListFragment$enterSearch$2$1(r0, this));
        goto L38
    L35:
        access$onEnterSearchAnimFailed(this);
    L39:
        if (r5 != null) goto L42;
        onEnterSearchAnimFailed();
        return;
    L42:
        return;
    L12:
        OFloatingTitleBarHolder r9 = this.mTitleBarHolder;
        if (r9 == null) goto L15;
        r4 = r9.getTitleBar();
    L16:
        if (r4 != null) goto L11;
        r4 = this.mOSearchbar;
        goto L11
    L15:
        r4 = null;
        goto L16
    }

    private final void exitSearch() {
        this.isSearch = false;
        OFloatingTitleBarHolder r1 = this.mTitleBarHolder;
        Unit r2 = null;
        if (r1 == null) goto L5;
        OFloatingTitleBar r3 = r1.getTitleBar();
    L6:
        if (r3 == null) goto L9;
        r3.setVisibility(0);
    L9:
        OFloatingTitleBarHolder r0 = this.mTitleBarHolder;
        if (r0 == null) goto L14;
        OFloatingTitleBar r4 = r0.getTitleBar();
        if (r4 == null) goto L14;
        ViewExtensionsKt.setEnable(r4, true);
    L14:
        final long r5 = this.mSearchAnimationGeneration;
        SearchSwitchAnimHelper r6 = this.mSearchSwitchANimHelper;
        if (r6 == null) goto L17;
        r6.playExitAnim(new C01921(r5, this));
        r2 = Unit.INSTANCE;
    L17:
        if (r2 == null) goto L19;
        return;
    L19:
        if (r5 == this.mSearchAnimationGeneration) goto L21;
        return;
    L21:
        if (this.isSearch == false) goto L23;
        return;
    L23:
        if (this.isSearchAnimationing == true) goto L30;
        searchAnimationEnd();
        SearchUtils.reportSearchEventAndClear();
        return;
    L30:
        return;
    L5:
        r3 = null;
        goto L6
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void cancelSearchWithoutAnimation() {
        OSearchBar r0 = this.mOSearchbar;
        if (r0 == null) goto L5;
        r0.refreshDrawableState();
    L5:
        ContactsUtils.setAnimatorScale(this.mActivity);
        stopSearch$default(this, false, 1, null);
        this.mSearchKey = null;
        ViewGroup r1 = this.mContactsFrameView;
        if (r1 == null) goto L8;
        r1.setY(0.0f);
    L8:
        this.isSearch = false;
        OFloatingTitleBarHolder r2 = this.mTitleBarHolder;
        if (r2 == null) goto L13;
        OFloatingTitleBar r3 = r2.getTitleBar();
        if (r3 == null) goto L13;
        r3.setVisibility(0);
    L13:
        searchAnimationEnd();
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void endContactAnimationIView() {
        OSearchBar r0 = this.mOSearchbar;
        if (r0 == null) goto L5;
        r0.refreshDrawableState();
    L5:
        ContactsUtils.setAnimatorScale(this.mActivity);
        stopSearch$default(this, false, 1, null);
        this.mSearchKey = null;
        exitSearch();
    }

    private final void searchAnimationEnd() {
        IContactSearchBarPresenter r0 = getPresenter();
        if (r0 == null) goto L5;
        r0.setCursorVisible(false);
    L5:
        OIconButtonFloating r1 = this.mOSearchRightButton;
        if (r1 == null) goto L9;
        r1.setVisibility(4);
    L9:
        OIconButtonFloating r2 = this.mOSearchRightButton;
        if (r2 == null) goto L13;
        r2.setAlpha(0.0f);
    L13:
        OIconButtonFloating r3 = this.mOSearchRightButton;
        if (r3 == null) goto L17;
        r3.setEnabled(false);
    L17:
        OIconButtonFloating r4 = this.mOSearchRightButton;
        if (r4 == null) goto L21;
        r4.setClickable(false);
    L21:
        DialtactsActivity r5 = null;
        if (this.mSearchResultView == null) goto L36;
        QuickContactListView r6 = this.mSearchResultList;
        if (r6 == null) goto L26;
        r6.setEmptyView(null);
    L26:
        RelativeLayout r7 = this.mSearchResultView;
        if (r7 == null) goto L29;
        r7.setVisibility(4);
    L29:
        QuickContactListView r8 = this.mSearchResultList;
        if (r8 == null) goto L32;
        r8.setVisibility(8);
    L32:
        OPageStatus r9 = this.mContactsListEmptyView;
        if (r9 == null) goto L36;
        r9.setVisibility(8);
    L36:
        FragmentActivity r10 = getActivity();
        if ((r10 instanceof DialtactsActivity) == false) goto L39;
        r5 = (DialtactsActivity) r10;
    L39:
        if (r5 == null) goto L51;
        ObricBottomDeleteBarView r11 = r5.getMBottomDeleteBar();
        if (r11 != null) goto L43;
    L45:
        boolean r12 = false;
    L46:
        if (r12 == true) goto L51;
        OBottomNavigationBar r13 = r5.getMBottomNavigationBar();
        if (r13 == null) goto L51;
        r13.setVisibility(0);
        goto L51
    L43:
        if (r11.getVisibility() != 0) goto L45;
        r12 = true;
    L51:
        showVoiceSearchBtn();
        ContactFragmentsCallback r14 = this.mFragmentsCallback;
        if (r14 == null) goto L55;
        r14.liftVeil();
        return;
    }

    static /* synthetic */ void stopSearch$default(NewContactListFragment r0, boolean r1, int r2, Object r3) {
        if ((r2 & 1) == 0) goto L5;
        r1 = true;
    L5:
        r0.stopSearch(r1);
    }

    private final void stopSearch(boolean r4) {
        SearchThread r0 = this.mProviderSearchThread;
        if (r0 == null) goto L7;
        if (r0 == null) goto L6;
        r0.setTrue(false);
    L6:
        this.mProviderSearchThread = null;
    L7:
        SearchThread r1 = this.mInAppSearchThread;
        if (r1 == null) goto L12;
        if (r1 == null) goto L11;
        r1.setTrue(false);
    L11:
        this.mInAppSearchThread = null;
    L12:
        if (r4 == false) goto L14;
        this.curContactsMap.clear();
        this.mInAppSearchResultList.clear();
    L14:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "search_message: stopSearch call mProviderSearchThread  " + this.mProviderSearchThread + " mInAppSearchResultList size = " + this.mInAppSearchResultList.size());
    }

    private final ArrayList<SamContact> getSearchMergeList(Map<Long, SamContact> r5) {
        ArrayList<SamContact> r0 = new ArrayList();
        if (r5 != null) goto L5;
    L8:
        Iterator<Long> r6 = this.curContactsMap.keySet().iterator();
    L10:
        if (r6.hasNext() == false) goto L14;
        long r1 = r6.next().longValue();
        SamContact r2 = this.curContactsMap.get(Long.valueOf(r1));
        if (r2 == null) goto L10;
        r0.add(r2);
        goto L10
    L14:
        CollectionsKt.sortWith(r0, new NameSortComparator());
        return r0;
    L5:
        if (this.mKeepDisplayedSearchNumber == false) goto L7;
        keepDisplayedSearchNumbers(r5);
    L7:
        this.curContactsMap.putAll(r5);
        goto L8
    }

    private final void keepDisplayedSearchNumbers(Map<Long, SamContact> r5) {
        Iterator<Map.Entry<Long, SamContact>> r6 = r5.entrySet().iterator();
    L4:
        if (r6.hasNext() == false) goto L13;
        Map.Entry<Long, SamContact> r0 = r6.next();
        long r1 = r0.getKey().longValue();
        SamContact r2 = r0.getValue();
        SamContact r3 = this.curContactsMap.get(Long.valueOf(r1));
        if (r3 == null) goto L4;
        String r4 = r3.number;
        if (TextUtils.equals(r4, r2.number) == true) goto L4;
        if (isNumberMatchSearchKey(r4) == false) goto L4;
        r2.number = r4;
        goto L4
    }

    private final boolean isNumberMatchSearchKey(String r5) {
        String r4 = PhoneNumberUtils.normalizeNumber(this.mSearchKey);
        String r0 = r5;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L20;
        String r3 = r4;
        if (r3 != null) goto L13;
    L16:
        if (r1 == true) goto L20;
        String r6 = PhoneNumberUtils.normalizeNumber(r5);
        Intrinsics.checkNotNullExpressionValue(r6, "normalizeNumber(number)");
        Intrinsics.checkNotNullExpressionValue(r4, "normalizedSearchKey");
        return StringsKt.contains$default(r6, r3, false, 2, null);
    L13:
        if (r3.length() == 0) goto L16;
        r1 = false;
    L20:
        return false;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }

    @Override // com.android.contacts.activities.DialtactsActivity.OnDBDataChangeListener
    public void onDBDataChanged() {
        if (TextUtils.isEmpty(this.mSearchKey) == true) goto L6;
        onQueryTextChangeIView(this.mSearchKey, false);
    L6:
        if (this.mVisible == true) goto L8;
    L9:
        this.mNeedRefreshAfterVisible = true;
        return;
    L8:
        if (this.mContactsContent == null) goto L9;
    }

    private final void initSearchViews() {
        View r0 = this.mContactsFragment;
        if (r0 == null) goto L5;
        View r1 = r0.findViewById(R.id.contact_stub_search);
    L6:
        ViewStub r2 = (ViewStub) r1;
        if (r2 == null) goto L35;
        View r3 = r2.inflate();
        RelativeLayout r4 = (RelativeLayout) r3.findViewById(R.id.seachresultview);
        this.mSearchResultView = r4;
        if (r4 == null) goto L12;
        r4.setAlpha(0.0f);
    L12:
        expandSearchResultViewForSearchTranslation();
        QuickContactListView r5 = (QuickContactListView) r3.findViewById(R.id.search_listview);
        this.mSearchResultList = r5;
        if (r5 == null) goto L15;
        r5.setOnScrollListener(this);
    L15:
        QuickContactListView r6 = this.mSearchResultList;
        if (r6 == null) goto L18;
        r6.setOnItemClickListener(this);
    L18:
        SearchResultAdapter r7 = new SearchResultAdapter(getActivity(), null, null, null);
        this.mSearchResultAdapter = r7;
        r7.setQuickContactListener(this.mSearchResultList);
        QuickContactListView r8 = this.mSearchResultList;
        if (r8 == null) goto L21;
        r8.setAdapter(this.mSearchResultAdapter);
    L21:
        QuickContactListView r9 = this.mSearchResultList;
        if (r9 == null) goto L24;
        r9.setItemLongClickedListener(this.mItemLongClickedListener);
    L24:
        SearchResultAdapter r10 = this.mSearchResultAdapter;
        if (r10 == null) goto L27;
        r10.setContactListViewClickListener(this.contactSearchListViewClickListener);
    L27:
        ForceTouchController r11 = new ForceTouchController(this.mSearchResultList, getActivity());
        this.mSearchController = r11;
        QuickContactListView r12 = this.mSearchResultList;
        if (r12 == null) goto L30;
        r12.setOnTouchListener(createCloseSwipeTouchListener(r11));
    L30:
        QuickContactListView r13 = this.mSearchResultList;
        if (r13 == null) goto L33;
        LayoutInflater r14 = getLayoutInflater();
        Intrinsics.checkNotNullExpressionValue(r14, "layoutInflater");
        OUIHelper.OUIList.setFooter(r14, r13, Integer.valueOf(OUIHelper.OUIList.getFooterHeight100()));
    L33:
        this.mContactsListEmptyView = (OPageStatus) r3.findViewById(R.id.contacts_list_empty_view);
        return;
    L35:
        return;
    L5:
        r1 = null;
        goto L6
    }

    private final void expandSearchResultViewForSearchTranslation() {
        RelativeLayout r0 = this.mSearchResultView;
        if (r0 != null) goto L5;
        return;
    L5:
        OFloatingTitleBarHolder r1 = this.mTitleBarHolder;
        int r2 = 0;
        if (r1 == null) goto L10;
        OFloatingTitleBar r3 = r1.getTitleBar();
        if (r3 == null) goto L10;
        int r4 = r3.getHeight();
    L11:
        OFloatingTitleBarHolder r5 = this.mTitleBarHolder;
        if (r5 == null) goto L16;
        OFloatingTitleBar r6 = r5.getTitleBar();
        if (r6 == null) goto L16;
        r2 = r6.getMeasuredHeight();
    L16:
        int r7 = Math.max(r4, r2);
        if (r7 > 0) goto L29;
        OFloatingTitleBarHolder r8 = this.mTitleBarHolder;
        if (r8 == null) goto L39;
        OFloatingTitleBar r9 = r8.getTitleBar();
        if (r9 == null) goto L40;
        OFloatingTitleBar r10 = r9;
        if (ViewCompat.isLaidOut(r10) == true) goto L25;
    L27:
        r10.addOnLayoutChangeListener(new NewContactListFragment$expandSearchResultViewForSearchTranslation$$inlined$doOnLayout$1(this));
        return;
    L25:
        if (r10.isLayoutRequested() == true) goto L27;
        access$expandSearchResultViewForSearchTranslation(this);
        return;
    L40:
        return;
    L39:
        return;
    L29:
        ViewGroup.LayoutParams r11 = r0.getLayoutParams();
        if ((r11 instanceof RelativeLayout.LayoutParams) == false) goto L32;
        RelativeLayout.LayoutParams r12 = (RelativeLayout.LayoutParams) r11;
    L33:
        if (r12 != null) goto L35;
        return;
    L35:
        int r13 = -r7;
        if (r12.bottomMargin == r13) goto L42;
        r12.bottomMargin = r13;
        r0.setLayoutParams(r12);
        return;
    L42:
        return;
    L32:
        r12 = null;
    L10:
        r4 = 0;
        goto L11
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void onQueryTextChangeIView(String r2) {
        onQueryTextChangeIView(r2, true);
    }

    public final void onQueryTextChangeIView(String r8, boolean r9) {
        this.mSearchKey = r8;
        if (r9 == false) goto L5;
    L7:
        boolean r0 = false;
    L8:
        this.mKeepDisplayedSearchNumber = r0;
        stopSearch(r9);
        if (TextUtils.isEmpty(r8) == false) goto L21;
        SearchUtils.stopSearchAsync("emptyQuery");
        if (isResumed() == true) goto L16;
        QuickContactListView r10 = this.mSearchResultList;
        if (r10 == null) goto L16;
        if (r10 == null) goto L16;
        r10.setVisibility(8);
    L16:
        SearchResultAdapter r7 = this.mSearchResultAdapter;
        if (r7 == null) goto L29;
        if (r7 == null) goto L30;
        r7.setList(null, null);
        return;
    L30:
        return;
    L29:
        return;
    L21:
        if (this.mProviderSearchThread != null) goto L24;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "search_message: onQueryTextChangeIView intentsSearch = " + this.mIntentsSearch + " call size = " + this.mInAppSearchResultList.size() + " searchKey = " + this.mSearchKey + " ,sortMode = " + this.mSortMode);
        this.mInAppSearchResultList = new ArrayList(this.mIntentsSearchResultList);
        this.mSearchKeyList.clear();
        this.mSearchKeyList = SearchUtils.getSearchKeyMap(this.mInAppSearchResultList);
        SearchThread r11 = new SearchThread(this, Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(this.mSearchKey)), this.mSearchKey, this.mSortMode, this.mInAppSearchResultList, false);
        this.mProviderSearchThread = r11;
        r11.start();
    L24:
        if (this.mIntentsSearch == false) goto L26;
        return;
    L26:
        if (this.mInAppSearchThread != null) goto L33;
        SearchThread r12 = new SearchThread(this, Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(this.mSearchKey)), this.mSearchKey, this.mSortMode, new ArrayList(), true);
        this.mInAppSearchThread = r12;
        r12.start();
        return;
    L33:
        return;
    L5:
        if (TextUtils.equals(r8, this.mLastRenderedSearchKey) == false) goto L7;
        r0 = true;
        goto L8
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void hideQuickContactViewIView() {
        hideQuickContact();
        hideVoiceSearchBtn();
    }

    @Override // com.android.contacts.list.IContactSearchBarView
    public void recoverQuickBarIView() {
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L6;
        r0.hideLetterGrid();
        return;
    }

    static /* synthetic */ void triggerLoad$default(NewContactListFragment r0, int r1, boolean r2, boolean r3, int r4, Object r5) {
        if ((r4 & 4) == 0) goto L5;
        r3 = false;
    L5:
        r0.triggerLoad(r1, r2, r3);
    }

    private final void triggerLoad(final int r3, final boolean r4, boolean r5) {
        if (getActivity() != null) goto L7;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getActivity is null, it's maybe relaunch.");
        return;
    L7:
        if (this.mProviderIsNormal == true) goto L10;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "Provider status is not normal");
        return;
    L10:
        this.mCityChanged = r5;
        Thread r6 = new Thread(new NewContactListFragment$triggerLoad$loadThread$1(this, r3, r4), "contactInitLoad");
        this.mPool.submit(r6);
    }

    private final void refreshBcrCount() {
        new Thread(new RunnableC01981(this)).start();
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ViewPagerVisibilityListener
    public void onVisibilityChanged(boolean r10) {
        if (this.mVisible == r10) goto L98;
        boolean r1 = true;
        if (r10 == false) goto L7;
        setObserverToWork(true);
        if (this.mSearchContainer == null) goto L67;
        IContactSearchBarPresenter r2 = getPresenter();
        if (r2 == null) goto L67;
        r2.requestSeachViewFocus();
    L67:
        boolean r3 = ContactsUtils.isVoiceSearchEnabled();
        if (r3 == false) goto L74;
        RelativeLayout r4 = this.voiceSearchContainer;
        if (r4 == null) goto L74;
        if (r4 == null) goto L73;
        r4.setVisibility(0);
    L73:
        showVoiceSearchBtn();
    L80:
        if (this.mBlacklistHasChanged == false) goto L92;
        if (this.mContactsContent == null) goto L92;
        BlacklistManager r0 = this.mBlacklistManager;
        if (r0 == null) goto L87;
        if (r0 == null) goto L87;
        r0.clearCache();
    L87:
        ContactsContent r5 = this.mContactsContent;
        if (r5 == null) goto L90;
        r5.onChange(false);
    L90:
        this.mBlacklistHasChanged = false;
    L92:
        if (this.mNeedRefreshAfterVisible == false) goto L98;
        if (this.mIsEdit == true) goto L98;
        if (this.mProviderIsNormal == false) goto L98;
        this.mNeedRefreshAfterVisible = false;
        triggerLoad$default(this, this.mSortMode, true, false, 4, null);
    L74:
        if (r3 == true) goto L80;
        RelativeLayout r6 = this.voiceSearchContainer;
        if (r6 == null) goto L80;
        if (r6 == null) goto L80;
        r6.setVisibility(8);
        goto L80
    L7:
        if (this.mIsEdit == false) goto L19;
        BottomDeleteLayoutListener r7 = this.mBottomDeleteLayoutListener;
        if (r7 == null) goto L17;
        if (r7 != null) goto L12;
    L14:
        boolean r8 = false;
    L15:
        if (r8 == false) goto L17;
        boolean r9 = true;
    L18:
        processEditContacts(false, r9);
        goto L19
    L12:
        if (r7.isBottomBarVisible() != true) goto L14;
        r8 = true;
    L17:
        r9 = false;
    L19:
        setObserverToWork(false);
        HeadersListView r11 = this.mContactListView;
        if (r11 == null) goto L30;
        if (r11 != null) goto L23;
    L25:
        boolean r12 = false;
    L26:
        if (r12 == false) goto L30;
        HeadersListView r13 = this.mContactListView;
        if (r13 == null) goto L41;
        r13.hideQuickContact();
    L41:
        OIndexScrollbar r14 = this.mQuickBar;
        if (r14 == null) goto L45;
        if (r14 == null) goto L45;
        r14.hideLetterGrid();
    L45:
        resetSearchBar();
        recoveryFromGroupEdit();
        ViewGroup r15 = this.mSearchResultDialog;
        if (r15 == null) goto L49;
        if (r15 == null) goto L49;
        r15.setVisibility(8);
    L49:
        ViewGroup r16 = this.mEmptyResultDialog;
        if (r16 == null) goto L53;
        if (r16 == null) goto L53;
        r16.setVisibility(8);
    L53:
        View r17 = this.mCover;
        if (r17 == null) goto L57;
        if (r17 == null) goto L57;
        r17.setVisibility(8);
    L57:
        ImageButton r18 = this.mBtnVoiceSearchContacts;
        if (r18 == null) goto L61;
        if (r18 == null) goto L61;
        r18.setVisibility(8);
    L61:
        dismissLongMenu();
        goto L98
    L23:
        if (r11.isShowQuickContact() != true) goto L25;
        r12 = true;
    L30:
        QuickContactExpandableListView r19 = this.mCityListView;
        if (r19 == null) goto L41;
        if (r19 != null) goto L34;
    L36:
        r1 = false;
    L37:
        if (r1 == false) goto L41;
        QuickContactExpandableListView r20 = this.mCityListView;
        if (r20 == null) goto L41;
        r20.hideQuickContact();
        goto L41
    L34:
        if (r19.isShowQuickContact() != true) goto L36;
    L98:
        this.mVisible = r10;
    }

    @Override // android.os.IBinder.DeathRecipient
    public void binderDied() {
        this.mVoiceSearchConnected = false;
    }

    private final AsyncImageLoader getAsyncImageLoader() {
        FragmentActivity r0 = getActivity();
        if (this.mAsyncImageLoader != null) goto L7;
        if (r0 == null) goto L7;
        this.mAsyncImageLoader = AsyncImageLoader.getInstances(r0);
    L7:
        return this.mAsyncImageLoader;
    }

    @Override // com.android.contacts.editor.SelectAccountDialogFragment.Listener
    public void onAccountChosen(AccountWithDataSet r3, Bundle r4) {
        Intrinsics.checkNotNullParameter(r4, "extraArgs");
        doImportInEmpty(getActivity(), r4.getInt(KEY_RES_ID), r3);
    }

    @Override // com.android.contacts.activities.DialtactsActivity.PageEnableListener
    public void setEnable(boolean r7, boolean r8) {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setEnable visible:" + r7 + "; mProviderIsNormal:" + this.mProviderIsNormal);
    L5:
        this.mProviderIsNormal = r7;
        if (r7 == true) goto L8;
        return;
    L8:
        if (isResumed() == false) goto L13;
        if (r8 == false) goto L14;
        triggerLoad$default(this, this.mSortMode, true, false, 4, null);
        return;
    L14:
        return;
    }

    private final Location getLocation() {
        LocationManager r1 = this.mLocationManager;     // Catch: Exception -> L24
        if (r1 == null) goto L6;
        r1.removeUpdates(this.mlistener);     // Catch: Exception -> L24
    L6:
        LocationManager r2 = this.mLocationManager;     // Catch: Exception -> L24
        if (r2 == null) goto L10;
        boolean r3 = r2.isProviderEnabled("gps");     // Catch: Exception -> L24
    L11:
        if (r3 == false) goto L21;
        Location r4 = requestUpdatesFromProvider("gps");     // Catch: Exception -> L24
        Location r5 = requestUpdatesFromProvider("network");     // Catch: Exception -> L24
        if (r4 == null) goto L16;
        if (r5 == null) goto L16;
        return getBetterLocation(r4, r5);
    L16:
        if (r4 != null) goto L30;
        if (r5 != null) goto L31;
    L26:
        return null;
    L31:
        return r5;
    L30:
        return r4;
    L21:
        if (ContactsUtils.DEBUG == false) goto L26;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "getLocation fail, gps is disable.");     // Catch: Exception -> L24
        goto L26
    L10:
        r3 = false;
    L24:
        e = move-exception;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "getLocation e:" + e);
        goto L26
    }

    private final Location requestUpdatesFromProvider(String r9) {
        LocationManager r0 = this.mLocationManager;
        boolean r1 = false;
        if (r0 == null) goto L8;
        if (r0.isProviderEnabled(r9) != true) goto L8;
        r1 = true;
    L8:
        if (r1 == false) goto L15;
        LocationManager r2 = this.mLocationManager;
        if (r2 == null) goto L12;
        r2.requestLocationUpdates(r9, 10000, 10.0f, this.mlistener);
    L12:
        LocationManager r8 = this.mLocationManager;
        if (r8 != null) goto L18;
        return null;
    L18:
        return r8.getLastKnownLocation(r9);
    L15:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_e(TAG, "get provider is failure." + r9);
        return null;
    }

    protected final Location getBetterLocation(Location r9, Location r10) {
        Intrinsics.checkNotNullParameter(r9, "newLocation");
        if (r10 != null) goto L5;
        return r9;
    L5:
        long r0 = r9.getTime() - r10.getTime();
        int r2 = TWO_MINUTES;
        boolean r4 = true;
        if (r0 <= r2) goto L8;
        boolean r3 = true;
    L10:
        if (r0 >= (-r2)) goto L12;
        boolean r5 = true;
    L14:
        if (r0 <= 0) goto L16;
        boolean r1 = true;
    L17:
        if (r3 == false) goto L19;
        return r9;
    L19:
        if (r5 == false) goto L21;
        return r10;
    L21:
        int r6 = (int) (r9.getAccuracy() - r10.getAccuracy());
        if (r6 <= 0) goto L24;
        boolean r7 = true;
    L25:
        if (r6 >= 0) goto L27;
        boolean r8 = true;
    L29:
        if (r6 > 200) goto L32;
        r4 = false;
    L32:
        boolean r11 = isSameProvider(r9.getProvider(), r10.getProvider());
        if (r8 == false) goto L35;
        return r9;
    L35:
        if (r1 == false) goto L38;
        if (r7 == true) goto L38;
        return r9;
    L38:
        if (r1 == false) goto L42;
        if (r4 == true) goto L42;
        if (r11 == false) goto L42;
        return r9;
    L42:
        return r10;
    L27:
        r8 = false;
        goto L29
    L24:
        r7 = false;
        goto L25
    L16:
        r1 = false;
        goto L17
    L12:
        r5 = false;
        goto L14
    L8:
        r3 = false;
        goto L10
    }

    private final boolean isSameProvider(String r1, String r2) {
        if (r1 != null) goto L8;
        if (r2 != null) goto L5;
        return true;
    L5:
        return false;
    L8:
        return Intrinsics.areEqual(r1, r2);
    }

    @Override // com.android.contacts.activities.DialtactsActivity.ReleaseResourceListener
    public void release() {
        if (this.mVisible == true) goto L34;
        OIndexScrollbar r0 = this.mQuickBar;
        if (r0 == null) goto L7;
        r0.setVisibility(8);
    L7:
        clearModeState();
        HeadersListView r1 = this.mContactListView;
        if (r1 == null) goto L11;
        r1.setAdapter(null);
    L11:
        if (this.mCityListView == null) goto L15;
        ExpandAdapter r2 = new ExpandAdapter(getActivity(), null, this.mPhotoManager, this.mCityListView);
        QuickContactExpandableListView r3 = this.mCityListView;
        if (r3 == null) goto L15;
        r3.setAdapter(r2);
    L15:
        ContactsListSortByNameAdapter r4 = this.mNorAdapter;
        if (r4 == null) goto L24;
        if (r4 == null) goto L19;
        r4.setList(null);
    L19:
        this.mNorAdapter = null;
        ArrayList<SamContact> r5 = this.mOldContacts;
        if (r5 == null) goto L24;
        if (r5 == null) goto L23;
        r5.clear();
    L23:
        this.mOldContacts = null;
    L24:
        ContactsListSortByNameAdapter r6 = this.mPhoneContactsAdapter;
        if (r6 == null) goto L35;
        if (r6 == null) goto L28;
        r6.setList(null);
    L28:
        this.mPhoneContactsAdapter = null;
        ArrayList<SamContact> r7 = this.mOldContactsPhoneItems;
        if (r7 == null) goto L36;
        if (r7 == null) goto L32;
        r7.clear();
    L32:
        this.mOldContactsPhoneItems = null;
        return;
    L36:
        return;
    L35:
        return;
    }

    @Override // com.android.contacts.activities.DialtactsActivity.onBackPressListener
    public boolean backToTopState() {
        ViewGroup r0 = this.mSearchResultDialog;
        boolean r2 = true;
        if (r0 == null) goto L11;
        if (r0 != null) goto L6;
    L8:
        boolean r1 = false;
    L9:
        if (r1 == false) goto L11;
        AnimationUtil.hideResultDialogWithAnim(this.mSearchResultDialog);
        AnimationUtil.hideCoverWithAnimation(this.mCover);
        this.mCoverDismiss = true;
    L34:
        r2 = false;
    L59:
        if (recoveryFromGroupEdit() == false) goto L62;
        return false;
    L62:
        return r2;
    L6:
        if (r0.getVisibility() != 0) goto L8;
        r1 = true;
    L11:
        ViewGroup r3 = this.mEmptyResultDialog;
        if (r3 == null) goto L20;
        if (r3 != null) goto L15;
    L17:
        boolean r4 = false;
    L18:
        if (r4 == false) goto L20;
        AnimationUtil.hideResultDialogWithAnim(this.mEmptyResultDialog);
        AnimationUtil.hideCoverWithAnimation(this.mCover);
        this.mCoverDismiss = true;
        goto L34
    L15:
        if (r3.getVisibility() != 0) goto L17;
        r4 = true;
    L20:
        OIndexScrollbar r5 = this.mQuickBar;
        if (r5 == null) goto L32;
        if (r5 != null) goto L24;
    L26:
        boolean r6 = false;
    L27:
        if (r6 == false) goto L32;
        OIndexScrollbar r7 = this.mQuickBar;
        if (r7 == null) goto L34;
        r7.hideLetterGrid();
        goto L34
    L24:
        if (r5.isLetterGridShown() != true) goto L26;
        r6 = true;
    L32:
        if (isShowQuickContact() == false) goto L36;
        hideQuickContact();
        goto L34
    L36:
        if (this.isSearch == false) goto L41;
        if (this.isSearchAnimationing == true) goto L41;
        cancelSearch();
    L41:
        if (this.mIsEdit == false) goto L59;
        HeadersListView r8 = this.mContactListView;
        if (r8 != null) goto L45;
    L47:
        boolean r9 = false;
    L48:
        if (r9 == false) goto L34;
        QuickContactExpandableListView r10 = this.mCityListView;
        if (r10 == null) goto L57;
        if (r10 != null) goto L53;
    L55:
        boolean r11 = false;
    L56:
        if (r11 == false) goto L34;
    L53:
        if (r10.isSelecting() == true) goto L55;
        r11 = true;
    L57:
        processEditContacts(false, true);
        goto L34
    L45:
        if (r8.isSelecting() == true) goto L47;
        r9 = true;
        goto L48
    }

    private final boolean recoveryFromGroupEdit() {
        GroupBrowseListFragment r0 = this.mGroupBrowseListFragment;
        if (r0 != null) goto L5;
    L23:
        return false;
    L5:
        if (r0 != null) goto L7;
    L9:
        boolean r1 = false;
    L10:
        if (r1 == false) goto L23;
        GroupBrowseListFragment r2 = this.mGroupBrowseListFragment;
        if (r2 != null) goto L14;
    L16:
        boolean r3 = false;
    L17:
        if (r3 == false) goto L22;
        GroupBrowseListFragment r4 = this.mGroupBrowseListFragment;
        if (r4 == null) goto L21;
        r4.setGroupEdit(false);
    L21:
        setGroupEditState(false);
    L22:
        return true;
    L14:
        if (r2.isSelecting() == true) goto L16;
        r3 = true;
        goto L17
    L7:
        if (r0.isEdit() != true) goto L9;
        r1 = true;
        goto L10
    }

    static /* synthetic */ void startDetailActivity$default(NewContactListFragment r0, Uri r1, ArrayList r2, boolean r3, boolean r4, int r5, Object r6) {
        if ((r5 & 8) == 0) goto L5;
        r4 = false;
    L5:
        r0.startDetailActivity(r1, r2, r3, r4);
    }

    private final void startDetailActivity(Uri r3, ArrayList<String> r4, boolean r5, boolean r6) {
        if (r5 == false) goto L4;
        ContactDetailCacheManager.getInstance().loadResultData(r3);
    L4:
        Intent r7 = ContactsIntentUtils.launchContactDetailIntent(this.mActivity, r3, true, "new_contact_list");
        if (r4 == null) goto L10;
        if (r4.isEmpty() == true) goto L10;
        r7.putStringArrayListExtra(ContactsUtils.EXTRA_PHONE_NUMBERS_HIGHLIGHT, r4);
    L10:
        if (this.isSearch == false) goto L12;
        String r8 = Constants.ContactsTracker.SUFFIX_FROM_LIST_SEARCH_RESULT_ITEM;
    L26:
        if (TextUtils.isEmpty(r8) == true) goto L28;
        r7.putExtra(Constants.ContactsTracker.EXTRA_SOURCE_FOR_TRACKER, r8);
    L28:
        if (r6 == false) goto L30;
        startActivity(r7);
    L31:
        AnimationUtil.switchActivityAnimation(this.mActivity, 5);
        return;
    L30:
        startActivityForResult(r7, 21);
        goto L31
    L12:
        int r9 = this.mSortMode;
        if (r9 != 1) goto L15;
        r8 = Constants.ContactsTracker.FROM_SORT_BY_NAME;
        goto L26
    L15:
        if (r9 != 2) goto L17;
        r8 = Constants.ContactsTracker.FROM_SORT_BY_LOCATION;
        goto L26
    L17:
        if (r9 != 4) goto L19;
        r8 = Constants.ContactsTracker.FROM_SORT_BY_FREQUENCY;
        goto L26
    L19:
        if (r9 == 8) goto L21;
        r8 = null;
        goto L26
    L21:
        r8 = Constants.ContactsTracker.FROM_SORT_BY_DATE;
        goto L26
    }

    @Override // androidx.fragment.app.Fragment
    public void onActivityResult(int r2, int r3, Intent r4) {
        if (r3 == (-1)) goto L6;
        return;
    L6:
        if (r2 == 21) goto L19;
        if (r2 != 22) goto L30;
        if (r4 == null) goto L12;
        r4.setAction("android.intent.action.INSERT");
    L12:
        FragmentActivity r5 = getActivity();
        if (r5 == null) goto L16;
        if (r4 == null) goto L16;
        r4.setClass(r5, ContactEditorActivity.class);
    L16:
        if (r4 == null) goto L26;
        startActivity(r4);
        return;
    L26:
        return;
    L30:
        return;
    L19:
        if (isAdded() == false) goto L28;
        if (r4 == null) goto L22;
        Uri r6 = r4.getData();
    L23:
        if (r6 == null) goto L29;
        removeItemFromList(r6);
        return;
    L29:
        return;
    L22:
        r6 = null;
        goto L23
    }

    private final void refreshProfileDetailCache(SamContact r5) {
        if (r5 != null) goto L4;
        return;
    L4:
        if (r5.contactId == (-1)) goto L9;
        Uri r6 = ContentUris.withAppendedId(Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_LOOKUP_URI, "profile"), r5.contactId);
        ContactDetailCacheManager.getInstance().initProfileCache(this.mActivity, r6);
        return;
    }

    public final void setKeepSearchState(boolean r1) {
        this.mKeepSearchState = r1;
    }

    private final void processGroupExpandableState(ExpandableListAdapter r8) {
        if (r8 != null) goto L5;
        return;
    L5:
        if (this.mCollapseAllGroup == false) goto L14;
        int r9 = r8.getGroupCount();
        int r0 = 0;
    L7:
        if (r0 >= r9) goto L12;
        QuickContactExpandableListView r2 = this.mCityListView;
        if (r2 == null) goto L11;
        r2.collapseGroup(r0);
    L11:
        r0 = r0 + 1;
        goto L7
    L12:
        this.mExpandGroups.clear();
        this.mCollapseAllGroup = false;
        return;
    L14:
        int r1 = r8.getGroupCount();
        int r3 = 0;
    L15:
        if (r3 >= r1) goto L26;
        long r4 = r8.getGroupId(r3);
        if (this.mExpandGroups.containsKey(Long.valueOf(r4)) == false) goto L22;
        QuickContactExpandableListView r5 = this.mCityListView;
        if (r5 == null) goto L21;
        r5.expandGroup(r3);
    L21:
        this.mExpandGroups.put(Long.valueOf(r4), 1);
    L25:
        r3 = r3 + 1;
        goto L15
    L22:
        QuickContactExpandableListView r6 = this.mCityListView;
        if (r6 == null) goto L25;
        r6.collapseGroup(r3);
        goto L25
    L26:
        ArrayList r10 = new ArrayList();
        Iterator<Long> r7 = this.mExpandGroups.keySet().iterator();
    L28:
        if (r7.hasNext() == false) goto L36;
        Long r11 = r7.next();
        Integer r12 = this.mExpandGroups.get(r11);
        if (r12 == null) goto L35;
        if (r12.intValue() != 0) goto L35;
        r10.add(r11);
    L35:
        this.mExpandGroups.put(r11, 0);
        goto L28
    L36:
        Iterator r13 = r10.iterator();
    L38:
        if (r13.hasNext() == false) goto L40;
        this.mExpandGroups.remove((Long) r13.next());
        goto L38
    }

    private final void deleteContacts(final boolean r3) {
        Handler r0 = this.mHandler;
        if (r0 == null) goto L6;
        r0.post(new AnonymousClass1(this, r3));
        return;
    }

    private final void initLetter(int r7) {
        if (r7 != 0) goto L4;
        OIndexScrollbar r6 = this.mQuickBar;
        if (r6 == null) goto L63;
        r6.initLetters();
        return;
    L63:
        return;
    L4:
        if (r7 == 1) goto L32;
        if (r7 == 2) goto L8;
        return;
    L8:
        if (this.mLetterProfileNewBitmaps != null) goto L23;
        Integer[] r8 = new Integer[1];
        Integer.valueOf(3);
        Bitmap[][] r9 = {new Bitmap[3]};
        this.mLetterProfileNewBitmaps = r9;
        Bitmap[] r10 = (Bitmap[]) ArraysKt.getOrNull(r9, 0);
        if (r10 == null) goto L12;
        r10[0] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L12:
        Bitmap[][] r11 = this.mLetterProfileNewBitmaps;
        if (r11 == null) goto L17;
        Bitmap[] r12 = (Bitmap[]) ArraysKt.getOrNull(r11, 0);
        if (r12 == null) goto L17;
        r12[1] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L17:
        Bitmap[][] r13 = this.mLetterProfileNewBitmaps;
        if (r13 == null) goto L23;
        Bitmap[] r14 = (Bitmap[]) ArraysKt.getOrNull(r13, 0);
        if (r14 == null) goto L23;
        r14[2] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L23:
        if (this.mLetterProfileSelectedNewBitmaps != null) goto L25;
        this.mLetterProfileSelectedNewBitmaps = new Bitmap[]{BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_user_avatar_big)};
    L25:
        OIndexScrollbar r15 = this.mQuickBar;
        if (r15 == null) goto L28;
        r15.initSpecialIcons(new int[]{1}, this.mLetterProfileNewBitmaps);
    L28:
        OIndexScrollbar r16 = this.mQuickBar;
        if (r16 == null) goto L59;
        r16.initSpecialSelectedIcons(this.mLetterProfileSelectedNewBitmaps);
        return;
    L59:
        return;
    L32:
        if (this.mLetterProfileBitmaps != null) goto L47;
        Bitmap[][] r17 = {new Bitmap[3]};
        this.mLetterProfileBitmaps = r17;
        Bitmap[] r18 = (Bitmap[]) ArraysKt.getOrNull(r17, 0);
        if (r18 == null) goto L36;
        r18[0] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L36:
        Bitmap[][] r19 = this.mLetterProfileBitmaps;
        if (r19 == null) goto L41;
        Bitmap[] r20 = (Bitmap[]) ArraysKt.getOrNull(r19, 0);
        if (r20 == null) goto L41;
        r20[1] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L41:
        Bitmap[][] r21 = this.mLetterProfileBitmaps;
        if (r21 == null) goto L47;
        Bitmap[] r22 = (Bitmap[]) ArraysKt.getOrNull(r21, 0);
        if (r22 == null) goto L47;
        r22[2] = BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_me);
    L47:
        if (this.mLetterProfileSelectedBitmaps != null) goto L49;
        this.mLetterProfileSelectedBitmaps = new Bitmap[]{BitmapFactory.decodeResource(ContactsApplication.getInstance().getResources(), R.drawable.o_indexscroll_user_avatar_big)};
    L49:
        OIndexScrollbar r23 = this.mQuickBar;
        if (r23 == null) goto L52;
        r23.initSpecialIcons(new int[]{1}, this.mLetterProfileBitmaps);
    L52:
        OIndexScrollbar r24 = this.mQuickBar;
        if (r24 == null) goto L61;
        r24.initSpecialSelectedIcons(this.mLetterProfileSelectedBitmaps);
        return;
    }

    @Override // com.android.contacts.util.AvatarImageHelper.OnAvatarTextFontChangeListener
    public void onAvatarTextFontChanged() {
        Handler r1 = this.mHandler;
        if (r1 == null) goto L6;
        r1.sendEmptyMessage(R.id.msg_loadedphotos);
        return;
    }

    private final void initCloseVoiceDialog(Context r3) {
        AlertDialog.Builder r0 = new AlertDialog.Builder(r3, 5);
        r0.setTitle(R.string.common_prompt);
        r0.setMessage(R.string.close_voice_dialog_message);
        r0.setPositiveButton(R.string.common_ok, new DialogInterfaceOnClickListenerC01941());
        this.mCloseVoiceDialog = r0.create();
    }

    private final void dismissCloseVoiceDialog() {
        AlertDialog r0 = this.mCloseVoiceDialog;
        if (r0 == null) goto L14;
        boolean r1 = false;
        if (r0 != null) goto L7;
    L9:
        if (r1 == false) goto L15;
        AlertDialog r3 = this.mCloseVoiceDialog;
        if (r3 == null) goto L16;
        r3.dismiss();
        return;
    L16:
        return;
    L15:
        return;
    L7:
        if (r0.isShowing() != true) goto L9;
        r1 = true;
        goto L9
    }

    @Override // com.android.contacts.list.ContactListFilterController.ContactListFilterListener
    public void onContactListFilterChanged() {
        setAccountFilterQuerySelection();
    }

    public final void setContactListFilterController(ContactListFilterController r1) {
        this.mContactListFilterController = r1;
    }

    private final void setAccountFilterQuerySelection() {
        if (ContactsUtils.DEBUG == false) goto L5;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "setAccountFilterQuerySelection");
    L5:
        ContactListFilterController r0 = this.mContactListFilterController;
        boolean r1 = true;
        boolean r2 = false;
        if (r0 != null) goto L8;
    L27:
        r2 = true;
        r1 = false;
    L28:
        this.mNoContactsSelected = r1;
        this.mAllContactsSelected = r2;
        return;
    L8:
        if (r0 == null) goto L10;
        Set<ContactListFilter> r3 = r0.getFilters();
    L11:
        if (r3 == null) goto L27;
        if (r3.size() == 0) goto L28;
        ArrayList r4 = Lists.newArrayList();
        Intrinsics.checkNotNullExpressionValue(r4, "newArrayList<AccountWithDataSet?>()");
        ArrayList r5 = r4;
        Iterator<ContactListFilter> r6 = r3.iterator();
    L17:
        if (r6.hasNext() == false) goto L22;
        ContactListFilter r7 = r6.next();
        if (Intrinsics.areEqual("com.android.sim", r7.accountType) == true) goto L20;
        r5.add(new AccountWithDataSet(r7.accountName, r7.accountType, r7.dataSet));
        goto L17
    L20:
        r5.add(new AccountWithDataSet(r7.accountName, r7.accountType, null));
        r5.add(new AccountWithDataSet(r7.accountName, r7.accountType, SimContactsConstants.SIM_NAME));
        r5.add(new AccountWithDataSet(r7.accountName, r7.accountType, "USIM"));
        goto L17
    L22:
        this.mAccountsFilterQueryParameter = AccountWithDataSet.stringifyList(r5);
        List<AccountWithDataSet> r8 = AccountTypeManager.getInstance(this.mContext).getAccounts(false);
        if (r8 == null) goto L27;
        if (r8.size() <= r3.size()) goto L27;
        r1 = false;
        goto L28
    L10:
        r3 = null;
        goto L11
    }

    private final Uri appendAccountsFilterQueryParameter(Uri r3) {
        if (TextUtils.isEmpty(this.mAccountsFilterQueryParameter) == true) goto L6;
        Uri.Builder r4 = r3.buildUpon();
        r4.appendQueryParameter(MULTI_ACCOUNTS_FLAG, "true");
        r4.appendQueryParameter(ACCOUNTS_FILTERS_PARAM, this.mAccountsFilterQueryParameter);
        Uri r2 = r4.build();
        Intrinsics.checkNotNullExpressionValue(r2, "uriBuilder.build()");
        return r2;
    L6:
        return r3;
    }

    public final List<Long> getCurrentVisibleContact() {
        HeadersListView r0 = this.mContactListView;
        if (r0 == null) goto L5;
        int r1 = r0.getChildCount();
    L7:
        if (r1 > 0) goto L9;
        return null;
    L9:
        int r2 = this.mSortMode;
        if (r2 != 1) goto L12;
    L19:
        ArrayList r3 = new ArrayList(getListVisibleList());
    L20:
        if (r3 != null) goto L22;
    L24:
        return null;
    L22:
        if (r3.size() <= 0) goto L24;
        return r3;
    L12:
        if (r2 != 2) goto L14;
        r3 = new ArrayList(getGroupListVisibleList());
        goto L20
    L14:
        if (r2 == 4) goto L19;
        if (r2 == 8) goto L19;
        r3 = null;
        goto L20
    L5:
        r1 = 0;
        goto L7
    }

    private final List<Long> getListVisibleList() {
        ArrayList r1 = new ArrayList();
        HeadersListView r2 = this.mContactListView;
        if (r2 == null) goto L7;
        HeadersAdapter r3 = r2.getAdapter();
        if (r3 == null) goto L7;
        int r4 = r3.getCount();
    L8:
        HeadersListView r5 = this.mContactListView;
        if (r5 == null) goto L11;
        int r6 = r5.getFirstVisiblePosition();
    L12:
        HeadersListView r7 = this.mContactListView;
        if (r7 == null) goto L15;
        int r8 = r7.getLastVisiblePosition();
    L16:
        if (r6 > r8) goto L54;
        int r9 = r6;
    L19:
        if (r9 < r4) goto L22;
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_w(TAG, "getListVisibleList IndexOutOfBounds i = " + r9 + " ,count = " + r4);
    L21:
        r6 = r6;
    L52:
        if (r9 == r8) goto L54;
        r9 = r9 + 1;
        r8 = r8;
        r6 = r6;
        goto L19
    L22:
        HeadersListView r10 = this.mContactListView;
        if (r10 == null) goto L25;
        View r11 = r10.getChildAt(r9 - r6);
    L26:
        if (r11 == null) goto L21;
        HeadersListView r12 = this.mContactListView;
        if (r12 == null) goto L33;
        HeadersAdapter r13 = r12.getAdapter();
        if (r13 == null) goto L33;
        long r14 = r13.getItemId(r9);
    L34:
        HeadersListView r15 = this.mContactListView;
        if (r15 == null) goto L37;
        int r16 = r15.getHeight();
    L38:
        int r17 = r11.getTop();
        int r18 = r11.getBottom();
        if (r17 >= 0) goto L41;
        double r19 = (((double) (r17 + 180)) * 1.0d) / (((double) 180) * 1.0d);
    L42:
        if (r18 <= r16) goto L45;
        r19 = (((double) (180 - (r18 - r16))) * 1.0d) / (((double) 180) * 1.0d);
    L45:
        if (r14 > 0) goto L47;
    L51:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onProvideAssistContent: getCurrentVisibleContact id = " + r14 + " height = " + r16 + " itemTop = " + r17 + " itemBottom = " + r18 + " position = " + r9);
        goto L52
    L47:
        if (r1.contains(Long.valueOf(r14)) == true) goto L51;
        if (r19 <= 0.5d) goto L51;
        r1.add(Long.valueOf(r14));
        goto L51
    L41:
        r19 = 1.0d;
        goto L42
    L37:
        r16 = 0;
    L33:
        r14 = 0;
        goto L34
    L25:
        r11 = null;
    L54:
        return r1;
    L15:
        r8 = 0;
        goto L16
    L11:
        r6 = 0;
    L7:
        r4 = 0;
        goto L8
    }

    private final List<Long> getGroupListVisibleList() {
        ArrayList r1 = new ArrayList();
        QuickContactExpandableListView r2 = this.mCityListView;
        if (r2 == null) goto L5;
        int r3 = r2.getFirstVisiblePosition();
    L6:
        QuickContactExpandableListView r4 = this.mCityListView;
        if (r4 == null) goto L9;
        int r5 = r4.getLastVisiblePosition();
    L10:
        if (r3 > r5) goto L54;
        int r6 = r3;
    L12:
        QuickContactExpandableListView r7 = this.mCityListView;
        Object r8 = null;
        if (r7 == null) goto L15;
        View r9 = r7.getChildAt(r6 - r3);
    L16:
        if (r9 == null) goto L52;
        QuickContactExpandableListView r10 = this.mCityListView;
        if (r10 == null) goto L21;
        ExpandableListAdapter r11 = r10.getExpandableListAdapter();
    L22:
        QuickContactExpandableListView r12 = this.mCityListView;
        if (r12 == null) goto L25;
        long r13 = r12.getExpandableListPosition(r6);
    L26:
        int r14 = ExpandableListView.getPackedPositionGroup(r13);
        int r15 = ExpandableListView.getPackedPositionChild(r13);
        if (r14 == (-1)) goto L52;
        if (r15 == (-1)) goto L52;
        if (r11 == null) goto L32;
        r8 = r11.getChild(r14, r15);
    L32:
        Intrinsics.checkNotNull(r8, "null cannot be cast to non-null type com.android.contacts.list.SamContact");
        long r16 = ((SamContact) r8).contactId;
        HeadersListView r17 = this.mContactListView;
        if (r17 == null) goto L35;
        int r18 = r17.getHeight();
    L36:
        int r19 = r9.getMeasuredHeight();
        int r110 = r9.getTop() - ContactsUtils.dipTopx(getActivity(), 45.0d);
        int r20 = r9.getBottom();
        if (r110 >= 0) goto L39;
        double r111 = (((double) (r19 + r110)) * 1.0d) / (((double) r19) * 1.0d);
    L40:
        if (r20 <= r18) goto L43;
        r111 = (((double) (r19 - (r20 - r18))) * 1.0d) / (((double) r19) * 1.0d);
    L43:
        if (r16 > 0) goto L45;
    L49:
        GlobalProxyLancet.com_obric_utils_ContactsLogHook_d(TAG, "onProvideAssistContent: getGroupListVisibleList id = " + r16 + " height = " + r18 + " itemTop = " + r110 + " itemBottom = " + r20 + " position = " + r6);
        goto L52
    L45:
        if (r1.contains(Long.valueOf(r16)) == true) goto L49;
        if (r111 <= 0.5d) goto L49;
        r1.add(Long.valueOf(r16));
        goto L49
    L39:
        r111 = 1.0d;
        goto L40
    L35:
        r18 = 0;
        goto L36
    L25:
        r13 = 0;
        goto L26
    L21:
        r11 = null;
    L52:
        if (r6 == r5) goto L54;
        r6 = r6 + 1;
        r5 = r5;
        goto L12
    L15:
        r9 = null;
    L54:
        return r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r3 = 0;
        goto L6
    }

    public final void setBottomDeleteLayoutListener(BottomDeleteLayoutListener r1) {
        this.mBottomDeleteLayoutListener = r1;
    }

    public final void onClickDelete() {
        if (this.isShowGroup == false) goto L5;
        onDeleteGroupClicked();
        return;
    L5:
        onDeleteContactClicked();
    }

    static {
        Companion = new Companion(null);
        if (SystemProperties.getInt("ro.voice_assistant_enable", 0) != 1) goto L5;
        boolean r0 = true;
    L6:
        sVoiceEnabled = r0;
        sLongMenuItems = new LongMenuHelper.MenuType[]{LongMenuHelper.MenuType.MENU_PHONE, LongMenuHelper.MenuType.MENU_PHONE1, LongMenuHelper.MenuType.MENU_PHONE2, LongMenuHelper.MenuType.MENU_MESSAGE, LongMenuHelper.MenuType.MENU_STAR, LongMenuHelper.MenuType.MENU_WECHAT};
        Uri r1 = Uri.withAppendedPath(ContactsContract.Profile.CONTENT_URI, "data");
        Intrinsics.checkNotNullExpressionValue(r1, "withAppendedPath(Contact…file.CONTENT_URI, \"data\")");
        PROFILE_QUERY_URI = r1;
        Uri r2 = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "contacts_statistics");
        Intrinsics.checkNotNullExpressionValue(r2, "withAppendedPath(Contact…I, \"contacts_statistics\")");
        CONTACTS_STATISTICS = r2;
        NO_ACCOUNTS_SELECTION = "account_name IS NULL";
        PHONE_ID_SELECTION = "mimetype = ? ";
        PHONE_ID_SELECTION_ARGS = new String[]{"vnd.android.cursor.item/phone_v2"};
        CONTACT_CITY_QUERY = "has_phone_number >0 ";
        CONTACT_SORT = PickerFragment.CONTACT_SORT_CNAME;
        CONTACT_SEARCH_SORT = PickerFragment.CONTACT_SORT_CNAME;
        CONTACT_EXCLUDE_SIM_ACCOUNT_QUERY = "account_type <> 'com.android.sim'";
        H24r = 86400000;
        Uri r3 = Uri.withAppendedPath(ContactsContract.AUTHORITY_URI, "contacts_with_company");
        Intrinsics.checkNotNullExpressionValue(r3, "withAppendedPath(Contact… \"contacts_with_company\")");
        CONTACTS_WITH_COMPANY_URI = r3;
        Uri r4 = Uri.withAppendedPath(CallLog.CONTENT_URI, "calls/count_group_by_lookup_uri");
        Intrinsics.checkNotNullExpressionValue(r4, "withAppendedPath(CallLog…unt_group_by_lookup_uri\")");
        CALLLOG_COUNT_URI = r4;
        CONTACT_FREQUENCE_PROJECTION = new String[]{"count(*) as count", BlockedCallAdapter.KEY_LOOKUP_URI};
        TWO_MINUTES = 120000;
        return;
    L5:
        r0 = false;
        goto L6
    }
}
