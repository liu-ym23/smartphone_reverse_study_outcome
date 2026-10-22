package com.bytedance.applog.tracker;

import android.app.Activity;
import android.app.Dialog;
import android.app.Fragment;
import android.app.ListFragment;
import android.app.Presentation;
import android.content.DialogInterface;
import android.location.Location;
import android.preference.PreferenceFragment;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.WebViewFragment;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ExpandableListView;
import android.widget.RadioGroup;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.TextView;
import com.bytedance.applog.event.AutoTrackEventType;
import com.bytedance.applog.log.IAppLogLogger;
import com.bytedance.applog.log.LoggerImpl;
import com.bytedance.bdtracker.b;
import com.bytedance.bdtracker.b5;
import com.bytedance.bdtracker.d;
import com.bytedance.bdtracker.g4;
import com.bytedance.bdtracker.l0;
import com.bytedance.bdtracker.l5;
import com.bytedance.bdtracker.o4;
import com.bytedance.bdtracker.r;
import com.bytedance.bdtracker.v5;
import com.bytedance.bdtracker.w;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class Tracker {
    public static float b;
    public static float c;
    public static final List<String> a = Collections.singletonList("Tracker");
    public static int[] d = new int[2];

    public static class a implements b.f {
        public final /* synthetic */ View a;
        public final /* synthetic */ g4 b;

        public a(View view, g4 g4Var) {
            this.a = view;
            this.b = g4Var;
        }

        @Override // com.bytedance.bdtracker.b.f
        public void a(d dVar) {
            if (dVar.isBavEnabled() && !dVar.isAutoTrackClickIgnored(this.a)) {
                if (dVar.getInitConfig() == null || AutoTrackEventType.a(dVar.getInitConfig().getAutoTrackEventType(), 4)) {
                    this.b.o = dVar.getViewProperties(this.a);
                    dVar.receive(this.b.m321clone());
                }
            }
        }
    }

    public static void dismiss(Dialog dialog) {
    }

    public static void dispatchTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 1) {
            b = motionEvent.getRawX();
            c = motionEvent.getRawY();
        }
    }

    public static void hide(Dialog dialog) {
    }

    public static void loadData(Object obj, String str, String str2, String str3) {
        if (obj == null) {
            return;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            if (b5.a(view)) {
                WebViewUtil.injectWebViewBridges(view, "");
            }
        }
        try {
            obj.getClass().getMethod("loadData", String.class, String.class, String.class).invoke(obj, str, str2, str3);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Reflect loadData failed", th, new Object[0]);
        }
    }

    public static void loadDataWithBaseURL(Object obj, String str, String str2, String str3, String str4, String str5) {
        if (obj == null) {
            return;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            if (b5.a(view)) {
                WebViewUtil.injectWebViewBridges(view, str);
            }
        }
        try {
            obj.getClass().getMethod("loadDataWithBaseURL", String.class, String.class, String.class, String.class, String.class).invoke(obj, str, str2, str3, str4, str5);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Reflect loadDataWithBaseURL failed", th, new Object[0]);
        }
    }

    public static void loadUrl(Object obj, String str) {
        if (obj == null) {
            return;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            if (b5.a(view)) {
                WebViewUtil.injectWebViewBridges(view, str);
            }
        }
        try {
            obj.getClass().getMethod("loadUrl", String.class).invoke(obj, str);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Reflect loadUrl:{} failed", th, str);
        }
    }

    public static void loadUrl(Object obj, String str, Map<String, String> map) {
        if (obj == null) {
            return;
        }
        if (obj instanceof View) {
            View view = (View) obj;
            if (b5.a(view)) {
                WebViewUtil.injectWebViewBridges(view, str);
            }
        }
        try {
            obj.getClass().getMethod("loadUrl", String.class, Map.class).invoke(obj, str, map);
        } catch (Throwable th) {
            LoggerImpl.global().error(a, "Reflect loadUrl:{} with header failed", th, str);
        }
    }

    public static void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        onClick(compoundButton);
    }

    public static void onCheckedChanged(RadioGroup radioGroup, int i) {
        onClick(radioGroup.findViewById(radioGroup.getCheckedRadioButtonId()));
    }

    public static boolean onChildClick(ExpandableListView expandableListView, View view, int i, int i2, long j) {
        onClick(view);
        return false;
    }

    public static void onClick(DialogInterface dialogInterface, int i) {
        try {
            Class[] clsArr = new Class[0];
            onClick((Button) dialogInterface.getClass().getMethod("getButton", null).invoke(dialogInterface, Integer.valueOf(i)));
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static void onClick(View view) {
        if (view == null || b.a(b.a).isEmpty()) {
            return;
        }
        g4 g4VarA = r.a(view, true);
        if (g4VarA == null) {
            LoggerImpl.global().error(a, "Cannot get view info", new Object[0]);
            return;
        }
        view.getLocationOnScreen(d);
        int[] iArr = d;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = (int) (b - i);
        int i4 = (int) (c - i2);
        if (i3 >= 0 && i3 <= view.getWidth() && i4 >= 0 && i4 <= view.getHeight()) {
            g4VarA.E = i3;
            g4VarA.F = i4;
        }
        b = 0.0f;
        c = 0.0f;
        IAppLogLogger iAppLogLoggerGlobal = LoggerImpl.global();
        List<String> list = a;
        StringBuilder sbA = com.bytedance.bdtracker.a.a("tracker:on click: width = ");
        sbA.append(view.getWidth());
        sbA.append(" height = ");
        sbA.append(view.getHeight());
        sbA.append(" touchX = ");
        sbA.append(g4VarA.E);
        sbA.append(" touchY = ");
        sbA.append(g4VarA.F);
        iAppLogLoggerGlobal.debug(list, sbA.toString(), new Object[0]);
        b.a(new a(view, g4VarA));
    }

    public static void onFocusChange(View view, boolean z) {
        if (view instanceof TextView) {
            onClick(view);
        }
    }

    public static boolean onGroupClick(ExpandableListView expandableListView, View view, int i, long j) {
        onClick(view);
        return true;
    }

    public static void onHiddenChanged(Fragment fragment, boolean z) {
        if (z) {
            w.c(fragment);
        } else {
            w.a((Object) fragment, true);
        }
    }

    public static void onHiddenChanged(ListFragment listFragment, boolean z) {
        if (z) {
            w.c(listFragment);
        } else {
            w.a((Object) listFragment, true);
        }
    }

    public static void onHiddenChanged(PreferenceFragment preferenceFragment, boolean z) {
        if (z) {
            w.c(preferenceFragment);
        } else {
            w.a((Object) preferenceFragment, true);
        }
    }

    public static void onHiddenChanged(WebViewFragment webViewFragment, boolean z) {
        if (z) {
            w.c(webViewFragment);
        } else {
            w.a((Object) webViewFragment, true);
        }
    }

    public static void onHiddenChanged(androidx.fragment.app.Fragment fragment, boolean z) {
        if (z) {
            w.c(fragment);
        } else {
            w.a((Object) fragment, true);
        }
    }

    public static void onHiddenChanged(Object obj, boolean z) {
        if (obj == null || !r.a(obj, "android.support.v4.app.Fragment")) {
            return;
        }
        if (z) {
            w.c(obj);
        } else {
            w.a(obj, true);
        }
    }

    public static void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        onClick(view);
    }

    public static boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
        return false;
    }

    public static void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        onItemClick(adapterView, view, i, j);
    }

    public static void onLocationChanged(Location location) {
    }

    public static void onLongClick(View view) {
    }

    public static boolean onMenuItemClick(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException {
        View viewA;
        View view = null;
        if (menuItem != null) {
            v5.b();
            View[] viewArrA = v5.a();
            try {
                int length = viewArrA.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    View view2 = viewArrA[i];
                    if (view2.getClass() == v5.e && (viewA = r.a(view2, menuItem)) != null) {
                        view = viewA;
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                LoggerImpl.global().error(Collections.singletonList("ViewHelper"), "getMenuItemView failed", th, new Object[0]);
            }
        }
        onClick(view);
        return false;
    }

    public static void onOptionsItemSelected(MenuItem menuItem) throws IllegalAccessException, IllegalArgumentException {
        onMenuItemClick(menuItem);
    }

    public static void onPause(Fragment fragment) {
        w.c(fragment);
    }

    public static void onPause(ListFragment listFragment) {
        w.c(listFragment);
    }

    public static void onPause(PreferenceFragment preferenceFragment) {
        w.c(preferenceFragment);
    }

    public static void onPause(WebViewFragment webViewFragment) {
        w.c(webViewFragment);
    }

    public static void onPause(androidx.fragment.app.Fragment fragment) {
        w.c(fragment);
    }

    public static void onPause(Object obj) {
        if (obj == null || !r.a(obj, "android.support.v4.app.Fragment")) {
            return;
        }
        w.c(obj);
    }

    public static void onProgressChanged(Object obj, View view, int i) {
        if (b5.a(view)) {
            try {
                Class[] clsArr = new Class[0];
                Object objInvoke = view.getClass().getMethod("getUrl", null).invoke(view, null);
                if (objInvoke != null) {
                    WebViewUtil.injectWebViewJsCode(view, String.valueOf(objInvoke));
                }
            } catch (Throwable th) {
                LoggerImpl.global().error(a, "Inject onProgressChanged failed", th, new Object[0]);
            }
        }
    }

    public static void onRatingChanged(RatingBar ratingBar, float f, boolean z) {
        if (z) {
            onClick(ratingBar);
        }
    }

    public static void onResume(Fragment fragment) {
        w.d(fragment);
    }

    public static void onResume(ListFragment listFragment) {
        w.d(listFragment);
    }

    public static void onResume(PreferenceFragment preferenceFragment) {
        w.d(preferenceFragment);
    }

    public static void onResume(WebViewFragment webViewFragment) {
        w.d(webViewFragment);
    }

    public static void onResume(androidx.fragment.app.Fragment fragment) {
        w.d(fragment);
    }

    public static void onResume(Object obj) {
        if (obj == null || !r.a(obj, "android.support.v4.app.Fragment")) {
            return;
        }
        w.d(obj);
    }

    public static void onStart(Presentation presentation) {
        List<o4> list;
        int iA = w.a(presentation);
        if (w.k.containsKey(Integer.valueOf(iA))) {
            list = w.k.get(Integer.valueOf(iA));
        } else {
            LinkedList linkedList = new LinkedList();
            w.k.put(Integer.valueOf(iA), linkedList);
            list = linkedList;
        }
        String name = presentation.getClass().getName();
        long jCurrentTimeMillis = System.currentTimeMillis();
        Activity ownerActivity = presentation.getOwnerActivity();
        o4 o4VarA = w.a(ownerActivity != null ? ownerActivity.getClass() : presentation.getClass(), false, name, "", l5.d(ownerActivity), l5.c(ownerActivity), jCurrentTimeMillis, l5.e(ownerActivity));
        if (list == null) {
            new l0().initCause(new AssertionError()).printStackTrace();
        } else {
            list.add(o4VarA);
        }
    }

    public static void onStop(Presentation presentation) {
        int iA = w.a(presentation);
        if (w.k.containsKey(Integer.valueOf(iA))) {
            LinkedList linkedList = (LinkedList) w.k.get(Integer.valueOf(iA));
            if (linkedList != null && !linkedList.isEmpty()) {
                w.a(false, (o4) linkedList.removeLast(), System.currentTimeMillis());
            }
            if (linkedList == null || linkedList.isEmpty()) {
                w.k.remove(Integer.valueOf(iA));
            }
        }
    }

    public static void onStopTrackingTouch(SeekBar seekBar) {
        onClick(seekBar);
    }

    public static void setUserVisibleHint(Fragment fragment, boolean z) {
        if (z) {
            w.a((Object) fragment, true);
        } else {
            w.c(fragment);
        }
    }

    public static void setUserVisibleHint(ListFragment listFragment, boolean z) {
        if (z) {
            w.a((Object) listFragment, true);
        } else {
            w.c(listFragment);
        }
    }

    public static void setUserVisibleHint(PreferenceFragment preferenceFragment, boolean z) {
        if (z) {
            w.a((Object) preferenceFragment, true);
        } else {
            w.c(preferenceFragment);
        }
    }

    public static void setUserVisibleHint(WebViewFragment webViewFragment, boolean z) {
        if (z) {
            w.a((Object) webViewFragment, true);
        } else {
            w.c(webViewFragment);
        }
    }

    public static void setUserVisibleHint(androidx.fragment.app.Fragment fragment, boolean z) {
        if (z) {
            w.a((Object) fragment, true);
        } else {
            w.c(fragment);
        }
    }

    public static void setUserVisibleHint(Object obj, boolean z) {
        if (obj == null || !r.a(obj, "android.support.v4.app.Fragment")) {
            return;
        }
        if (z) {
            w.a(obj, true);
        } else {
            w.c(obj);
        }
    }

    public static void show(Dialog dialog) {
    }
}
