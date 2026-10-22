package com.android.contacts.forcetouch;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import com.android.contacts.ContactLoader;
import com.android.contacts.R;
import com.android.contacts.calllog.CallLogAdapter;
import com.android.contacts.dialpad.ContactItem;
import com.android.contacts.dialpad.T9Search;
import com.android.contacts.list.ContactDetailCacheManager;
import com.android.contacts.list.ContactTileAdapter;
import com.android.contacts.list.ContactsListBaseAdapter;
import com.android.contacts.list.FavoriteAdapter;
import com.android.contacts.list.SamContact;
import com.android.contacts.list.SearchResultAdapter;
import com.android.contacts.util.HanziToPinyin;
import com.android.contacts.util.ShareContactByText;
import com.android.contacts.util.SidebarDragHelper;
import com.android.contacts.widget.AvatarImageView;

/* JADX INFO: loaded from: classes.dex */
public class ForceTouchController implements View.OnTouchListener {
    protected BaseAdapter mAdapter;
    protected Context mContext;
    protected ForceTouchDetector mForceTouchDetector;
    protected ListView mListView;
    protected SidebarDragHelper mSidebarDragHelper;

    public ForceTouchController(ListView r1, Context r2) {
        this.mListView = r1;
        this.mContext = r2;
        this.mSidebarDragHelper = SidebarDragHelper.getInstance(r2);
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View r1, MotionEvent r2) {
        initForceTouchDetectorIfNeed(r1, r2);
        this.mForceTouchDetector.onTouchEvent(r1, r2);
        return false;
    }

    protected void initForceTouchDetectorIfNeed(View r1, MotionEvent r2) {
        if (this.mForceTouchDetector != null) goto L6;
        BytedanceosForceTouchDetector r3 = new BytedanceosForceTouchDetector(r1.getContext());
        this.mForceTouchDetector = r3;
        r3.setOnForceTouchListener(new AnonymousClass1(this));
        return;
    }

    protected int viewIdHitPosition(MotionEvent r4) {
        int r0 = (int) r4.getX();
        int r5 = (int) r4.getY();
        int r6 = this.mListView.pointToPosition(r0, r5);
        int r1 = this.mListView.getHeaderViewsCount();
        int r2 = this.mListView.getFooterViewsCount();
        int r3 = this.mListView.getCount();
        if (r6 == (-1)) goto L8;
        if (r6 < r1) goto L8;
        if (r6 >= (r3 - r2)) goto L8;
        return r6;
    L8:
        return -1;
    }

    protected void startDragDataItem(int r11) {
        ListView r0 = this.mListView;
        View r1 = r0.getChildAt(r11 - r0.getFirstVisiblePosition());
        if (r1 != null) goto L5;
        return;
    L5:
        BaseAdapter r2 = this.mAdapter;
        if ((r2 instanceof ContactsListBaseAdapter) == false) goto L15;
        SamContact r12 = ((ContactsListBaseAdapter) r2).getItem(r11);
        if (r12 == null) goto L70;
        Uri r13 = getContactUri(r12);
        ContactDetailCacheManager.getInstance().loadResultData(r13);
        ContactLoader.Result r14 = ContactDetailCacheManager.getInstance().getResult(r13);
        String r3 = ShareContactByText.toShareText(r1.getContext(), r14);
        if (r14 != null) goto L12;
        return;
    L12:
        if (TextUtils.isEmpty(r3) == true) goto L72;
        this.mSidebarDragHelper.dragText(r1, r3, true);
        return;
    L72:
        return;
    L70:
        return;
    L15:
        if ((r2 instanceof CallLogAdapter) == false) goto L26;
        if (r1.getTag() != null) goto L19;
        return;
    L19:
        if ((r1.getTag() instanceof CallLogAdapter.PrimaryActionListener) == false) goto L75;
        CallLogAdapter.PrimaryActionListener r15 = (CallLogAdapter.PrimaryActionListener) r1.getTag();
        if (TextUtils.isEmpty(r15.getName()) == false) goto L23;
        String r16 = r15.getNumber();
    L24:
        this.mSidebarDragHelper.dragText(r1, r16, true);
        return;
    L23:
        r16 = r15.getName() + HanziToPinyin.Token.SEPARATOR + r15.getNumber();
        goto L24
    L75:
        return;
    L26:
        if ((r2 instanceof FavoriteAdapter) == false) goto L42;
        TextView r17 = (TextView) r1.findViewById(R.id.contactlistsingle_contactpanel_name);
        TextView r4 = (TextView) r1.findViewById(R.id.contactlistsingle_contactpanel_number);
        StringBuilder r5 = new StringBuilder();
        if (r17 != null) goto L30;
    L32:
        if (r4 == null) goto L40;
        if (TextUtils.isEmpty(r4.getText()) == true) goto L40;
        if (r5.length() <= 0) goto L38;
        r5.append(HanziToPinyin.Token.SEPARATOR);
    L38:
        r5.append(r4.getText());
    L40:
        if (r5.length() <= 0) goto L77;
        this.mSidebarDragHelper.dragText(r1, r5, true);
        return;
    L77:
        return;
    L30:
        if (TextUtils.isEmpty(r17.getText()) == true) goto L32;
        r5.append(r17.getText());
        goto L32
    L42:
        Bitmap r7 = null;
        if ((r2 instanceof ContactTileAdapter) == false) goto L53;
        AvatarImageView r6 = (AvatarImageView) r1.findViewById(R.id.photo);
        if (r6 != null) goto L47;
    L51:
        this.mSidebarDragHelper.dragContact(r1, ((ContactTileAdapter.ContactEntry) this.mAdapter.getItem(r11)).lookupUri, r7, true);
        return;
    L47:
        if (r6.getPhotoID() <= 0) goto L51;
        if (r6.getDrawable() == null) goto L51;
        r7 = ((BitmapDrawable) r6.getDrawable()).getBitmap();
        goto L51
    L53:
        if ((r2 instanceof T9Search.T9Adapter) == false) goto L60;
        ContactItem r18 = ((T9Search.T9Adapter) r2).getItem(r11);
        if (TextUtils.isEmpty(r18.name) == false) goto L57;
        String r19 = r18.getNumber();
    L58:
        this.mSidebarDragHelper.dragText(r1, r19, true);
        return;
    L57:
        r19 = r18.name + HanziToPinyin.Token.SEPARATOR + r18.getNumber();
        goto L58
    L60:
        if ((r2 instanceof SearchResultAdapter) == false) goto L81;
        AvatarImageView r8 = (AvatarImageView) r1.findViewById(R.id.photo);
        if (r8 != null) goto L64;
    L68:
        this.mSidebarDragHelper.dragContact(r1, getContactUri(((SearchResultAdapter) this.mAdapter).getItem(r11)), r7, true);
        return;
    L64:
        if (r8.getPhotoID() <= 0) goto L68;
        if (r8.getDrawable() == null) goto L68;
        r7 = ((BitmapDrawable) r8.getDrawable()).getBitmap();
        goto L68
    }

    public Uri getContactUri(SamContact r3) {
        return ContactsContract.Contacts.getLookupUri(r3.contactId, r3.LookKey);
    }

    public void setAdapter(BaseAdapter r1) {
        this.mAdapter = r1;
    }
}
