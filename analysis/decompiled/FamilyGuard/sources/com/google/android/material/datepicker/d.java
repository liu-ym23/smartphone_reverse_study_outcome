package com.google.android.material.datepicker;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Collection;

/* loaded from: classes.dex */
public interface d<S> extends Parcelable {
    void C(long j5);

    String b(Context context);

    Collection<D.d<Long, Long>> e();

    View m(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, a aVar, s<S> sVar);

    String o(Context context);

    int q(Context context);

    boolean t();

    Collection<Long> u();

    S w();
}
