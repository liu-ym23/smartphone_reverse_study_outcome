package com.stepos.alphame.persona.address.ui;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.stepos.alphame.persona.address.data.AddressEntity;
import com.stepos.alphame.persona.common.list.PersonalCommonDoubleViewHolder;
import com.stepos.alphame.persona.common.list.PersonalCommonListAdapter;
import com.stepos.alphame.persona.common.list.PersonalCommonSingleViewHolder;

/* loaded from: classes.dex */
public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11185a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11186b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ RecyclerView.Adapter f11187c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f11188d;

    public /* synthetic */ a(AddressListAdapter addressListAdapter, AddressEntity addressEntity, int i4) {
        this.f11185a = 0;
        this.f11187c = addressListAdapter;
        this.f11188d = addressEntity;
        this.f11186b = i4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        int i4 = this.f11185a;
        int i5 = this.f11186b;
        Object obj = this.f11188d;
        RecyclerView.Adapter adapter = this.f11187c;
        switch (i4) {
            case 0:
                AddressListAdapter.onBindViewHolder$lambda$0((AddressListAdapter) adapter, (AddressEntity) obj, i5, view);
                break;
            case 1:
                PersonalCommonListAdapter.onBindViewHolder$lambda$0((PersonalCommonListAdapter) adapter, i5, (PersonalCommonSingleViewHolder) obj, view);
                break;
            default:
                PersonalCommonListAdapter.onBindViewHolder$lambda$1((PersonalCommonListAdapter) adapter, i5, (PersonalCommonDoubleViewHolder) obj, view);
                break;
        }
    }

    public /* synthetic */ a(PersonalCommonListAdapter personalCommonListAdapter, int i4, RecyclerView.ViewHolder viewHolder, int i5) {
        this.f11185a = i5;
        this.f11187c = personalCommonListAdapter;
        this.f11186b = i4;
        this.f11188d = viewHolder;
    }
}
