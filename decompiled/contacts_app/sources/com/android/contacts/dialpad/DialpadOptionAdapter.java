package com.android.contacts.dialpad;

import android.content.Context;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import bytedanceos.util.NameAvatarController;
import com.android.contacts.ContactsApplication;
import com.android.contacts.R;
import com.android.contacts.calllog.PhoneNumberHelper;
import com.android.contacts.numberassistant.NumberInfosManager;
import com.android.contacts.widget.AvatarImageView;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DialpadOptionAdapter extends BaseAdapter {
    private Context mContext;
    private List<DialpadOptionItem> mList;
    private PhoneNumberHelper mPhoneNumberHelper;

    @Override // android.widget.Adapter
    public long getItemId(int r1) {
        return 0;
    }

    public DialpadOptionAdapter(Context r1, List<DialpadOptionItem> r2) {
        this.mContext = r1;
        this.mList = r2;
        this.mPhoneNumberHelper = new PhoneNumberHelper(r1.getResources());
    }

    public void setList(List<DialpadOptionItem> r1) {
        this.mList = r1;
    }

    @Override // android.widget.Adapter
    public int getCount() {
        List<DialpadOptionItem> r0 = this.mList;
        if (r0 != null) goto L6;
        return 0;
    L6:
        return r0.size();
    }

    @Override // android.widget.Adapter
    public Object getItem(int r1) {
        List<DialpadOptionItem> r0 = this.mList;
        if (r0 != null) goto L6;
        return null;
    L6:
        return r0.get(r1);
    }

    @Override // android.widget.Adapter
    public View getView(int r3, View r4, ViewGroup r5) {
        DialpadOptionItem r6 = this.mList.get(r3);
        if (r6.type != 1) goto L7;
        return getPublicNumberView(r6);
    L7:
        if (r3 == (getCount() - 1)) goto L9;
        View r7 = LayoutInflater.from(this.mContext).inflate(R.layout.dialpad_option_list_item, null);
    L10:
        ((ImageView) r7.findViewById(R.id.icon)).setImageDrawable(r6.icon);
        ((TextView) r7.findViewById(R.id.describe)).setText(r6.describe);
        r7.setEnabled(isEnabled(r3));
        return r7;
    L9:
        r7 = LayoutInflater.from(this.mContext).inflate(R.layout.dialpad_option_list_bottom_item, null);
        goto L10
    }

    @Override // android.widget.BaseAdapter, android.widget.ListAdapter
    public boolean isEnabled(int r4) {
        if (r4 >= 0) goto L5;
    L18:
        return true;
    L5:
        if (r4 >= this.mList.size()) goto L18;
        if (this.mList.get(r4).type != 3) goto L17;
        if (ContactsApplication.getInstance().getTelephonyUtil().isVoLteSupport() == true) goto L12;
        return false;
    L12:
        if (ContactsApplication.getInstance().getTelephonyUtil().isVtCapable() == false) goto L19;
        return true;
    L19:
        return false;
    L17:
        return super.isEnabled(r4);
    }

    private View getPublicNumberView(DialpadOptionItem r5) {
        View r4 = LayoutInflater.from(this.mContext).inflate(R.layout.dialpad_option_public_item, null);
        AvatarImageView r0 = (AvatarImageView) r4.findViewById(R.id.photo);
        r0.setPhotoID(r5.drawbleRes);
        r0.setImageDrawable(r5.icon);
        NumberInfosManager.getInstance().bindPublicNumberLogoAsync(r5.detail, r0, NameAvatarController.getCircleBitmap(((BitmapDrawable) r5.icon).getBitmap(), false));
        ((TextView) r4.findViewById(R.id.name)).setText(r5.describe);
        ((TextView) r4.findViewById(R.id.description)).setText(r5.detail);
        return r4;
    }
}
