package com.obricOld.contacts.menus;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Entity;
import android.net.Uri;
import android.provider.ContactsContract;
import android.telephony.PhoneNumberUtils;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.view.menu.MenuBuilder;
import com.android.contacts.ContactLoader;
import com.android.contacts.DSUtils;
import com.android.contacts.R;
import com.android.contacts.bytedanceosquickcontact.Action;
import com.android.contacts.bytedanceosquickcontact.ActionMultiMap;
import com.android.contacts.bytedanceosquickcontact.QuickContactHandle;
import com.android.contacts.calllog.CallLogAdapter;
import com.android.contacts.calllog.blocked.BlockedCallActivity;
import com.android.contacts.calllog.v2.CallLogItem;
import com.android.contacts.dialpad.ContactItem;
import com.android.contacts.list.ContactTileAdapter;
import com.android.contacts.list.FavoriteContact;
import com.android.contacts.list.SamContact;
import com.android.contacts.recyclebin.RecycleItem;
import com.obric.oui.common.style.IOUIAlpha;
import com.obric.oui.lisitem.OCardListItem;
import com.obric.oui.popover.v2.OPopover;
import com.obric.ui.popover.Direct;
import com.obric.ui.popover.ItemType;
import com.obric.ui.popover.MenuItemData;
import com.obric.ui.popover.OUIPopoverHelper;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class LongMenuHelper implements MenuItem.OnMenuItemClickListener {
    private static int sGroupId;
    private ActionMultiMap mActions;
    private View mAnchor;
    private int mAnchorAlphaBgId;
    private long mContactId;
    private Activity mContext;
    private Object mData;
    private boolean mDismissed;
    private OnMenuItemClickedListener mListener;
    private MenuBuilder mMenuBuilder;
    private MenuType[] mMenuTypes;
    private int mMenuX;
    private int mMenuY;
    private OPopover mPopover;
    private MenuDataQueryHandler mQueryHandler;
    private QuickContactHandle mQuickContactHandle;
    private boolean mShowAfterDataloaded;

    /* JADX INFO: renamed from: com.obricOld.contacts.menus.LongMenuHelper$6, reason: invalid class name */
    static /* synthetic */ class AnonymousClass6 {
        static final /* synthetic */ int[] $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = null;

        static {
            int[] r0 = new int[MenuType.values().length];
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType = r0;
            r0[MenuType.MENU_PHONE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L17
        L34:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_PHONE1.ordinal()] = 2;     // Catch: NoSuchFieldError -> L18
        L40:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_PHONE2.ordinal()] = 3;     // Catch: NoSuchFieldError -> L19
        L54:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_STAR.ordinal()] = 4;     // Catch: NoSuchFieldError -> L20
        L36:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_BLACK.ordinal()] = 5;     // Catch: NoSuchFieldError -> L21
        L42:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_FLAG.ordinal()] = 6;     // Catch: NoSuchFieldError -> L22
        L46:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_DELETE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L23
        L50:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_MESSAGE.ordinal()] = 8;     // Catch: NoSuchFieldError -> L24
        L32:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_RESTORE.ordinal()] = 9;     // Catch: NoSuchFieldError -> L25
        L38:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_COPY_NUMBER.ordinal()] = 10;     // Catch: NoSuchFieldError -> L26
        L44:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_CREATE_CONTACTS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L27
        L48:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_LINE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L28
        L30:
            $SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[MenuType.MENU_WECHAT.ordinal()] = 13;     // Catch: NoSuchFieldError -> L29
            return;
        }
    }

    private class ContactQueryCallback implements MenuDataQueryHandler.MenuContactQueryCallback {
        private Object data;
        private String number;
        final /* synthetic */ LongMenuHelper this$0;

        public ContactQueryCallback(LongMenuHelper r2, Object r3) {
            this(r2, r3, null);
        }

        public ContactQueryCallback(LongMenuHelper r1, Object r2, String r3) {
            this.this$0 = r1;
            this.data = r2;
            this.number = r3;
        }

        @Override // com.obricOld.contacts.menus.MenuDataQueryHandler.MenuContactQueryCallback
        public void onComplete(Map<Long, List<ContentValues>> r12) {
            if (this.data == LongMenuHelper.access$100(this.this$0)) goto L5;
            return;
        L5:
            Iterator<Map.Entry<Long, List<ContentValues>>> r13 = r12.entrySet().iterator();
        L7:
            if (r13.hasNext() == false) goto L30;
            Map.Entry<Long, List<ContentValues>> r0 = r13.next();
            LongMenuHelper.access$202(this.this$0, r0.getKey().longValue());
            Iterator<ContentValues> r1 = r0.getValue().iterator();
        L10:
            if (r1.hasNext() == false) goto L7;
            ContentValues r7 = r1.next();
            String r2 = r7.getAsString("mimetype");
            if ("vnd.android.cursor.item/phone_v2".equals(r2) == true) goto L16;
            if ("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile".equals(r2) == false) goto L10;
        L16:
            MenuDataAction r10 = new MenuDataAction();
            r10.setDataAction(LongMenuHelper.access$300(this.this$0), r2, LongMenuHelper.access$200(this.this$0), r7, this.data);
            int r3 = 0;
            if ("vnd.android.cursor.item/phone_v2".equals(r10.getMimeType()) == false) goto L28;
            ArrayList<Action> r4 = LongMenuHelper.access$400(this.this$0).get(r2);
            if (r4 == null) goto L28;
            int r5 = 0;
        L22:
            if (r3 >= r4.size()) goto L27;
            if (PhoneNumberUtils.compare(r4.get(r3).getData(), r10.getData()) == false) goto L26;
            r5 = 1;
        L26:
            r3 = r3 + 1;
            goto L22
        L27:
            r3 = r5;
        L28:
            if (r3 != 0) goto L10;
            LongMenuHelper.access$400(this.this$0).put(r2, r10);
            goto L10
        L30:
            LongMenuHelper.access$500(this.this$0);
            if (LongMenuHelper.access$600(this.this$0) == false) goto L46;
            this.this$0.show();
            return;
        }
    }

    public static final enum MenuType extends Enum<MenuType> {
        private static final /* synthetic */ MenuType[] $VALUES = null;
        public static final MenuType MENU_BLACK = null;
        public static final MenuType MENU_COPY_NUMBER = null;
        public static final MenuType MENU_CREATE_CONTACTS = null;
        public static final MenuType MENU_DELETE = null;
        public static final MenuType MENU_FLAG = null;
        public static final MenuType MENU_LINE = null;
        public static final MenuType MENU_MESSAGE = null;
        public static final MenuType MENU_PHONE = null;
        public static final MenuType MENU_PHONE1 = null;
        public static final MenuType MENU_PHONE2 = null;
        public static final MenuType MENU_RESTORE = null;
        public static final MenuType MENU_STAR = null;
        public static final MenuType MENU_WECHAT = null;
        public int drawable;
        public int id;
        public boolean isHighLight;
        public int text;

        private static /* synthetic */ MenuType[] $values() {
            return new MenuType[]{MENU_PHONE, MENU_PHONE1, MENU_PHONE2, MENU_STAR, MENU_BLACK, MENU_DELETE, MENU_MESSAGE, MENU_RESTORE, MENU_CREATE_CONTACTS, MENU_FLAG, MENU_COPY_NUMBER, MENU_LINE, MENU_WECHAT};
        }

        public static MenuType valueOf(String r1) {
            return (MenuType) Enum.valueOf(MenuType.class, r1);
        }

        public static MenuType[] values() {
            return (MenuType[]) $VALUES.clone();
        }

        static {
            MENU_PHONE = new MenuType("MENU_PHONE", 0, R.drawable.menu_icon_phone, R.string.menu_phone);
            MENU_PHONE1 = new MenuType("MENU_PHONE1", 1, R.drawable.menu_icon_phone1, R.string.menu_phone1);
            MENU_PHONE2 = new MenuType("MENU_PHONE2", 2, R.drawable.menu_icon_phone2, R.string.menu_phone2);
            MENU_STAR = new MenuType("MENU_STAR", 3, R.drawable.menu_icon_starred, R.string.common_remove_from_favorites);
            MENU_BLACK = new MenuType("MENU_BLACK", 4, R.drawable.menu_icon_blacked, R.string.common_remove_from_blocklist);
            MENU_DELETE = new MenuType("MENU_DELETE", 5, R.drawable.menu_icon_delete, R.string.common_delete);
            MENU_MESSAGE = new MenuType("MENU_MESSAGE", 6, R.drawable.menu_icon_message, R.string.common_send_sms);
            MENU_RESTORE = new MenuType("MENU_RESTORE", 7, R.drawable.menu_icon_restore, R.string.common_restore);
            MENU_CREATE_CONTACTS = new MenuType("MENU_CREATE_CONTACTS", 8, R.drawable.menu_icon_create_contacts, R.string.menu_create_contacts);
            MENU_FLAG = new MenuType("MENU_FLAG", 9, R.drawable.menu_icon_flag, R.string.common_tag);
            MENU_COPY_NUMBER = new MenuType("MENU_COPY_NUMBER", 10, R.drawable.menu_icon_copy_number, R.string.menu_copy_number);
            MENU_LINE = new MenuType("MENU_LINE", 11, R.drawable.menu_icon_line, R.string.menu_line);
            MENU_WECHAT = new MenuType("MENU_WECHAT", 12, R.drawable.menu_icon_wechat, R.string.menu_wechat);
            $VALUES = $values();
        }

        private MenuType(String r7, int r8, int r9, int r10) {
            this(r7, r8, r9, r10, false);
        }

        private MenuType(String r1, int r2, int r3, int r4, boolean r5) {
            super(r1, r2);
            this.drawable = r3;
            this.text = r4;
            this.id = r3;
            this.isHighLight = r5;
        }

        public MenuType withFlag(boolean r3) {
            if (this != MENU_STAR) goto L13;
            if (r3 == false) goto L6;
            int r0 = R.drawable.menu_icon_starred;
        L7:
            this.drawable = r0;
            if (r3 == false) goto L10;
            int r1 = R.string.common_remove_from_favorites;
        L11:
            this.text = r1;
            this.id = r0;
        L28:
            this.isHighLight = r3;
            return this;
        L10:
            r1 = R.string.common_favorites;
            goto L11
        L6:
            r0 = R.drawable.menu_icon_unstarred;
            goto L7
        L13:
            if (this != MENU_BLACK) goto L19;
            if (r3 == false) goto L16;
            int r2 = R.string.common_remove_from_blocklist;
        L17:
            this.text = r2;
            this.id = this.drawable;
            goto L28
        L16:
            r2 = R.string.common_add_to_blacklist;
            goto L17
        L19:
            if (this != MENU_FLAG) goto L28;
            if (r3 == true) goto L22;
            int r4 = R.drawable.menu_icon_flag;
        L23:
            this.drawable = r4;
            if (r3 == true) goto L26;
            int r5 = R.string.common_tag;
        L27:
            this.text = r5;
            this.id = r4;
            goto L28
        L26:
            r5 = R.string.common_untag;
            goto L27
        L22:
            r4 = R.drawable.menu_icon_unflag;
            goto L23
        }

        public MenuItem toMenu(MenuBuilder r5) {
            return r5.add(LongMenuHelper.access$008(), this.id, 0, this.text).setIcon(this.drawable);
        }

        public static MenuType toMeyType(int r4) {
            MenuType[] r0 = values();
            int r1 = 0;
        L4:
            if (r1 >= r0.length) goto L9;
            MenuType r2 = r0[r1];
            if (r2.id == r4) goto L7;
            r1 = r1 + 1;
            goto L4
        L7:
            return r2;
        L9:
            return null;
        }

        public MenuType updateMenuText(int r1) {
            this.text = r1;
            return this;
        }
    }

    public interface OnMenuItemClickedListener {
        boolean onMenuItemClicked(MenuType r1, View r2, Object r3);
    }

    static {
    }

    static /* synthetic */ int access$008() {
        int r0 = sGroupId;
        sGroupId = r0 + 1;
        return r0;
    }

    static /* synthetic */ Object access$100(LongMenuHelper r0) {
        return r0.mData;
    }

    static /* synthetic */ long access$200(LongMenuHelper r2) {
        return r2.mContactId;
    }

    static /* synthetic */ long access$202(LongMenuHelper r0, long r1) {
        r0.mContactId = r1;
        return r1;
    }

    static /* synthetic */ Activity access$300(LongMenuHelper r0) {
        return r0.mContext;
    }

    static /* synthetic */ ActionMultiMap access$400(LongMenuHelper r0) {
        return r0.mActions;
    }

    static /* synthetic */ void access$500(LongMenuHelper r0) {
        r0.buildMenus();
    }

    static /* synthetic */ boolean access$600(LongMenuHelper r0) {
        return r0.mShowAfterDataloaded;
    }

    static /* synthetic */ boolean access$700(LongMenuHelper r0) {
        return r0.mDismissed;
    }

    static /* synthetic */ boolean access$702(LongMenuHelper r0, boolean r1) {
        r0.mDismissed = r1;
        return r1;
    }

    static /* synthetic */ void access$800(LongMenuHelper r0, boolean r1) {
        r0.reset(r1);
    }

    public LongMenuHelper(Activity r2) {
        this(r2, null);
    }

    public LongMenuHelper(Activity r2, OnMenuItemClickedListener r3) {
        this.mDismissed = false;
        this.mActions = new ActionMultiMap();
        this.mContext = r2;
        this.mListener = r3;
        this.mQuickContactHandle = new QuickContactHandle(r2);
        this.mQueryHandler = new MenuDataQueryHandler(this.mContext.getContentResolver());
    }

    public void setMenItemClickedListener(OnMenuItemClickedListener r1) {
        this.mListener = r1;
    }

    private void addMenu(List<MenuType> r1, MenuType r2) {
        if (r1.contains(r2) == true) goto L6;
        r1.add(r2);
        return;
    }

    private void buildMenus() {
        if (this.mMenuTypes != null) goto L5;
        return;
    L5:
        if (this.mActions == null) goto L71;
        ArrayList r0 = new ArrayList();
        MenuType[] r1 = this.mMenuTypes;
        int r2 = r1.length;
        int r4 = 0;
    L8:
        if (r4 >= r2) goto L49;
        MenuType r5 = r1[r4];
        boolean r8 = true;
        switch(AnonymousClass6.$SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[r5.ordinal()]) {
            case 1: goto L46;
            case 2: goto L43;
            case 3: goto L43;
            case 4: goto L32;
            case 5: goto L25;
            case 6: goto L18;
            case 7: goto L17;
            case 8: goto L17;
            case 9: goto L17;
            case 10: goto L17;
            case 11: goto L17;
            case 12: goto L17;
            case 13: goto L12;
            default: goto L48;
        };
    L12:
        ArrayList<Action> r6 = this.mActions.get("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        if (r6 == null) goto L48;
        if (r6.size() <= 0) goto L48;
        addMenu(r0, r5);
        goto L48
    L17:
        addMenu(r0, r5);
        goto L48
    L18:
        ArrayList<Action> r7 = this.mActions.get(MenuType.MENU_FLAG.name());
        if (r7 != null) goto L21;
    L23:
        boolean r9 = false;
    L24:
        addMenu(r0, r5.withFlag(r9));
        goto L48
    L21:
        if (r7.size() <= 0) goto L23;
        r9 = ((MenuDataAction) r7.get(0)).isMarked();
        goto L24
    L25:
        ArrayList<Action> r10 = this.mActions.get("vnd.android.cursor.item/phone_v2");
        if (r10 != null) goto L28;
    L30:
        boolean r11 = false;
    L31:
        addMenu(r0, r5.withFlag(r11));
        goto L48
    L28:
        if (r10.size() <= 0) goto L30;
        r11 = ((MenuDataAction) r10.get(0)).isBlacked();
        goto L31
    L32:
        ArrayList<Action> r12 = this.mActions.get("vnd.android.cursor.item/phone_v2");
        if (r12 == null) goto L40;
        Iterator<Action> r13 = r12.iterator();
    L36:
        if (r13.hasNext() == false) goto L40;
        if (r13.next().isStarred().booleanValue() == false) goto L36;
    L41:
        addMenu(r0, r5.withFlag(r8));
    L40:
        r8 = false;
        goto L41
    L43:
        if (DSUtils.useDSFeature() == false) goto L48;
        addMenu(r0, getSimMenuType(MenuType.MENU_PHONE1, 0));
        addMenu(r0, getSimMenuType(MenuType.MENU_PHONE2, 1));
        goto L48
    L46:
        if (DSUtils.useDSFeature() == true) goto L48;
        addMenu(r0, MenuType.MENU_PHONE);
    L48:
        r4 = r4 + 1;
        goto L8
    L49:
        this.mMenuBuilder = new MenuBuilder(this.mContext);
        Iterator<MenuType> r3 = r0.iterator();
    L51:
        if (r3.hasNext() == false) goto L72;
        r3.next().toMenu(this.mMenuBuilder).setOnMenuItemClickListener(this);
        goto L51
    L72:
        return;
    }

    private MenuType getSimMenuType(MenuType r2, int r3) {
        int r1 = DSUtils.getDefaultCallSim();
        if (r3 != 0) goto L5;
        int r0 = R.string.menu_phone1;
    L6:
        if (r3 != r1) goto L10;
        if (r1 != 0) goto L10;
        return r2.updateMenuText(R.string.menu_phone1_default);
    L10:
        if (r3 != r1) goto L16;
        if (r1 != 1) goto L16;
        return r2.updateMenuText(R.string.menu_phone2_default);
    L16:
        return r2.updateMenuText(r0);
    L5:
        r0 = R.string.menu_phone2;
        goto L6
    }

    public void setMenuItemDatas(View r10, int r11, Object r12, int r13, int r14, MenuType[] r15) {
        reset();
        this.mAnchor = r10;
        this.mAnchorAlphaBgId = r11;
        IOUIAlpha r16 = findIOUIAlpha();
        if (r16 == null) goto L5;
        r16.setKeepPressAlpha(true);
    L5:
        setAnchorChecked(true);
        this.mData = r12;
        this.mMenuX = r13;
        this.mMenuY = r14;
        this.mMenuTypes = r15;
        if ((r12 instanceof ContactLoader.Result) == false) goto L33;
        ContactLoader.Result r17 = (ContactLoader.Result) r12;
        this.mContactId = r17.getId();
        Iterator<Entity> r18 = r17.getEntities().iterator();
    L9:
        if (r18.hasNext() == false) goto L70;
        Iterator<Entity.NamedContentValues> r19 = r18.next().getSubValues().iterator();
    L12:
        if (r19.hasNext() == false) goto L9;
        ContentValues r5 = r19.next().values;
        String r110 = r5.getAsString("mimetype");
        if ("vnd.android.cursor.item/phone_v2".equals(r110) == true) goto L18;
        if ("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile".equals(r110) == false) goto L12;
    L18:
        MenuDataAction r8 = new MenuDataAction();
        r8.setDataAction(this.mContext, r110, r17.mId, r5, r12);
        int r1 = 0;
        if ("vnd.android.cursor.item/phone_v2".equals(r8.getMimeType()) == false) goto L30;
        ArrayList<Action> r0 = this.mActions.get(r110);
        if (r0 == null) goto L30;
        int r2 = 0;
    L24:
        if (r1 >= r0.size()) goto L29;
        if (PhoneNumberUtils.compare(r0.get(r1).getData(), r8.getData()) == false) goto L28;
        r2 = 1;
    L28:
        r1 = r1 + 1;
        goto L24
    L29:
        r1 = r2;
    L30:
        if (r1 != 0) goto L12;
        this.mActions.put(r110, r8);
    L70:
        buildMenus();
        return;
    L33:
        if ((r12 instanceof ContactTileAdapter.ContactEntry) == false) goto L37;
        ContactTileAdapter.ContactEntry r111 = (ContactTileAdapter.ContactEntry) r12;
        this.mQueryHandler.queryContact(r111.lookupUri, new ContactQueryCallback(this, r12, r111.phoneNumber));
        return;
    L37:
        if ((r12 instanceof SamContact) == false) goto L45;
        SamContact r112 = (SamContact) r12;
        Uri r113 = ContactsContract.Contacts.getLookupUri(r112.contactId, r112.LookKey);
        MenuDataQueryHandler r114 = this.mQueryHandler;
        if (r112.phoneId <= 0) goto L41;
        String r115 = r112.number;
    L42:
        r114.queryContact(r113, new ContactQueryCallback(this, r12, r115));
        return;
    L41:
        r115 = null;
        goto L42
    L45:
        if ((r12 instanceof CallLogAdapter.PrimaryActionListener) == false) goto L49;
        final CallLogAdapter.PrimaryActionListener r116 = (CallLogAdapter.PrimaryActionListener) r12;
        this.mQueryHandler.queryNumberBlacked(r116.getNumber(), new AnonymousClass1(this, r116));
        return;
    L49:
        if ((r12 instanceof CallLogItem) == false) goto L53;
        final CallLogItem r117 = (CallLogItem) r12;
        this.mQueryHandler.queryNumberBlacked(r117.getNumber(), new AnonymousClass2(this, r117));
        return;
    L53:
        if ((r12 instanceof FavoriteContact) == false) goto L57;
        FavoriteContact r118 = (FavoriteContact) r12;
        this.mQueryHandler.queryContact(ContactsContract.Contacts.getLookupUri(r118.contactid, r118.LookKey), new ContactQueryCallback(this, r12, r118.number));
        return;
    L57:
        if ((r12 instanceof RecycleItem) == false) goto L60;
        MenuDataAction r119 = new MenuDataAction();
        r119.setDataAction(r12);
        this.mActions.put(MenuType.MENU_RESTORE.name(), r119);
        this.mActions.put(MenuType.MENU_DELETE.name(), r119);
        goto L70
    L60:
        if ((r12 instanceof ContactItem) == false) goto L67;
        final ContactItem r120 = (ContactItem) r12;
        if (r120.getLookupUri() == null) goto L64;
        this.mQueryHandler.queryContact(r120.getLookupUri(), new ContactQueryCallback(this, r12, r120.getNumber()));
        return;
    L64:
        this.mQueryHandler.queryNumberBlacked(r120.getNumber(), new AnonymousClass3(this, r120));
        return;
    L67:
        if ((r12 instanceof BlockedCallActivity.MenuData) == false) goto L69;
        MenuDataAction r121 = new MenuDataAction();
        r121.setDataAction(r12);
        this.mActions.put(MenuType.MENU_DELETE.name(), r121);
        goto L70
    L69:
        MenuDataAction r122 = new MenuDataAction();
        r122.setDataAction(r12);
        this.mActions.put(MenuType.MENU_DELETE.name(), r122);
        goto L70
    }

    public void show() {
        if (this.mMenuBuilder != null) goto L5;
    L7:
        this.mShowAfterDataloaded = true;
        return;
    L5:
        if (this.mContext.isResumed() == false) goto L7;
        LinkedList r0 = new LinkedList(this.mMenuBuilder.getVisibleItems());
        OPopover r1 = OUIPopoverHelper.genPopover(this.mContext, getLongClickMenu(r0), false);
        this.mPopover = r1;
        r1.setOnDismissListener(new AnonymousClass4(this));
        int[] r2 = new int[2];
        this.mAnchor.getLocationOnScreen(r2);
        r2[0] = r2[0] + this.mMenuX;
        r2[1] = r2[1] + this.mMenuY;
        OUIPopoverHelper.showPopupAtAnchorView(this.mContext, this.mPopover, Direct.LEFT, this.mAnchor, r2);
    }

    private List<MenuItemData> getLongClickMenu(List<MenuItem> r21) {
        ArrayList r2 = new ArrayList();
        if (r21 != null) goto L5;
    L20:
        return r2;
    L5:
        if (r21.isEmpty() == true) goto L20;
        final int r4 = 0;
    L9:
        if (r4 >= r21.size()) goto L20;
        final MenuType r5 = MenuType.toMeyType(r21.get(r4).getItemId());
        if (r5 != MenuType.MENU_LINE) goto L13;
        r2.add(new MenuItemData(ItemType.DIVIDER, null, null, null, null, null, null, null, null, null));
    L19:
        r4 = r4 + 1;
        goto L9
    L13:
        if (r5 == null) goto L19;
        int r6 = r5.drawable;
        String r14 = this.mContext.getResources().getString(r5.text);
        if (r5 != MenuType.MENU_DELETE) goto L17;
        boolean r7 = true;
    L18:
        r2.add(new MenuItemData(ItemType.TEXT, Integer.valueOf(r6), null, null, r14, null, null, Boolean.valueOf(r7), null, new AnonymousClass5(this, r5, r4)));
        goto L19
    L17:
        r7 = false;
        goto L18
    }

    public boolean isShowing() {
        OPopover r0 = this.mPopover;
        if (r0 != null) goto L5;
    L7:
        return false;
    L5:
        if (r0.isShowing() == false) goto L7;
        return true;
    }

    public void dismiss() {
        reset(true);
    }

    private void reset() {
        reset(true);
    }

    private void reset(boolean r4) {
        IOUIAlpha r0 = findIOUIAlpha();
        if (r0 == null) goto L5;
        r0.setKeepPressAlpha(false);
    L5:
        setAnchorChecked(false);
        this.mAnchor = null;
        this.mAnchorAlphaBgId = 0;
        this.mActions.clear();
        sGroupId = 0;
        this.mShowAfterDataloaded = false;
        OPopover r1 = this.mPopover;
        if (r4 == false) goto L11;
        if (r1 == null) goto L11;
        if (r1.isShowing() == false) goto L11;
        this.mDismissed = true;
        r1.dismiss();
    L11:
        this.mPopover = null;
        MenuBuilder r5 = this.mMenuBuilder;
        if (r5 == null) goto L14;
        r5.clearAll();
    L14:
        this.mMenuBuilder = null;
        this.mQueryHandler.cancelOperation();
    }

    private void setAnchorChecked(boolean r2) {
        OCardListItem r1 = findCardListItem(this.mAnchor);
        if (r1 == null) goto L6;
        r1.setContentChecked(r2);
        return;
    }

    private OCardListItem findCardListItem(View r2) {
    L3:
        if (r2 == null) goto L12;
        if ((r2 instanceof OCardListItem) == true) goto L7;
        Object r3 = r2.getParent();
        if ((r3 instanceof View) == true) goto L10;
        r2 = null;
        goto L3
    L10:
        r2 = (View) r3;
        goto L3
    L7:
        return (OCardListItem) r2;
    L12:
        return null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private IOUIAlpha findIOUIAlpha() {
        View r0 = this.mAnchor;
        if (r0 != 0) goto L5;
        return null;
    L5:
        int r5 = this.mAnchorAlphaBgId;
        if (r5 == 0) goto L13;
        KeyEvent.Callback r6 = r0.findViewById(r5);
        if ((r6 instanceof IOUIAlpha) == true) goto L10;
        return null;
    L10:
        return (IOUIAlpha) r6;
    L13:
        if ((r0 instanceof IOUIAlpha) == false) goto L17;
        return (IOUIAlpha) r0;
    L17:
        if ((r0 instanceof ViewGroup) == true) goto L19;
        return null;
    L19:
        ViewGroup r1 = (ViewGroup) r0;
        int r7 = r1.getChildCount();
        int r2 = 0;
    L20:
        if (r2 >= r7) goto L26;
        KeyEvent.Callback r3 = r1.getChildAt(r2);
        if ((r3 instanceof IOUIAlpha) == true) goto L24;
        r2 = r2 + 1;
        goto L20
    L24:
        return (IOUIAlpha) r3;
    L26:
        return null;
    }

    private boolean tryToCallCustomListener(MenuType r4) {
        if (this.mListener != null) goto L5;
    L14:
        return false;
    L5:
        switch(AnonymousClass6.$SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[r4.ordinal()]) {
            case 4: goto L8;
            case 5: goto L8;
            case 6: goto L7;
            case 7: goto L7;
            case 8: goto L7;
            case 9: goto L7;
            case 10: goto L7;
            case 11: goto L7;
            case 12: goto L7;
            default: goto L6;
        };
    L6:
        ArrayList<Action> r0 = null;
    L9:
        if (r0 == null) goto L14;
        if (r0.size() <= 0) goto L14;
        return this.mListener.onMenuItemClicked(r4, this.mAnchor, ((MenuDataAction) r0.get(0)).getRawData());
    L7:
        r0 = this.mActions.get(r4.name());
        goto L9
    L8:
        r0 = this.mActions.get("vnd.android.cursor.item/phone_v2");
        goto L9
    }

    public void doItemClick(MenuType r7) {
        OPopover r0 = this.mPopover;
        if (r0 == null) goto L8;
        if (r0.isShowing() == false) goto L8;
        this.mPopover.dismiss();
    L8:
        if (tryToCallCustomListener(r7) == false) goto L10;
        return;
    L10:
        int r8 = AnonymousClass6.$SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[r7.ordinal()];
        int r1 = 1;
        int r2 = -1;
        if (r8 == 1) goto L44;
        int r5 = 0;
        if (r8 != 2) goto L15;
    L40:
        if (r5 == (-1)) goto L43;
        r1 = r5;
    L43:
        r2 = r1;
        goto L44
    L15:
        if (r8 != 3) goto L17;
        r5 = -1;
        goto L40
    L17:
        if (r8 != 4) goto L19;
        ArrayList r9 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList<Action> r4 = this.mActions.get("vnd.android.cursor.item/phone_v2");
        if (r4 == null) goto L38;
        Iterator<Action> r6 = r4.iterator();
    L33:
        if (r6.hasNext() == false) goto L38;
        Action r10 = r6.next();
        if (r10.isStarred().booleanValue() == true) goto L36;
        r3.add(r10);
        goto L33
    L36:
        r9.add(r10);
    L38:
        this.mQuickContactHandle.placeStarActions(r9, r3, null);
        return;
    L19:
        if (r8 != 8) goto L21;
        this.mQuickContactHandle.placeMmsActions(this.mActions.get("vnd.android.cursor.item/phone_v2"));
        return;
    L21:
        if (r8 != 13) goto L57;
        ArrayList<Action> r11 = this.mActions.get("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        if (r11 != null) goto L26;
        return;
    L26:
        if (r11.size() <= 0) goto L53;
        this.mQuickContactHandle.placeWechatActions(r11.get(0));
        return;
    L53:
        return;
    L57:
        return;
    L44:
        this.mQuickContactHandle.placeCallActions(this.mActions.get("vnd.android.cursor.item/phone_v2"), r2, null);
    }

    @Override // android.view.MenuItem.OnMenuItemClickListener
    public boolean onMenuItemClick(MenuItem r7) {
        MenuType r8 = MenuType.toMeyType(r7.getItemId());
        this.mPopover.dismiss();
        if (tryToCallCustomListener(r8) == false) goto L5;
        return true;
    L5:
        int r9 = AnonymousClass6.$SwitchMap$com$obricOld$contacts$menus$LongMenuHelper$MenuType[r8.ordinal()];
        int r2 = -1;
        if (r9 == 1) goto L38;
        int r5 = 0;
        if (r9 != 2) goto L10;
    L35:
        if (r5 != (-1)) goto L37;
        r2 = 1;
        goto L38
    L37:
        r2 = r5;
        goto L38
    L10:
        if (r9 != 3) goto L12;
        r5 = -1;
        goto L35
    L12:
        if (r9 != 4) goto L14;
        ArrayList r10 = new ArrayList();
        ArrayList r3 = new ArrayList();
        ArrayList<Action> r4 = this.mActions.get("vnd.android.cursor.item/phone_v2");
        if (r4 == null) goto L33;
        Iterator<Action> r6 = r4.iterator();
    L28:
        if (r6.hasNext() == false) goto L33;
        Action r11 = r6.next();
        if (r11.isStarred().booleanValue() == true) goto L31;
        r3.add(r11);
        goto L28
    L31:
        r10.add(r11);
    L33:
        this.mQuickContactHandle.placeStarActions(r10, r3, null);
    L39:
        return true;
    L14:
        if (r9 != 8) goto L16;
        this.mQuickContactHandle.placeMmsActions(this.mActions.get("vnd.android.cursor.item/phone_v2"));
        goto L39
    L16:
        if (r9 != 13) goto L39;
        ArrayList<Action> r12 = this.mActions.get("vnd.android.cursor.item/vnd.com.tencent.mm.chatting.profile");
        if (r12 == null) goto L39;
        if (r12.size() <= 0) goto L39;
        this.mQuickContactHandle.placeWechatActions(r12.get(0));
    L38:
        this.mQuickContactHandle.placeCallActions(this.mActions.get("vnd.android.cursor.item/phone_v2"), r2, null);
        goto L39
    }
}
