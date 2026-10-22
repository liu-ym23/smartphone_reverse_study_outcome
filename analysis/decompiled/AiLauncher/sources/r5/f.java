package r5;

import La.H;
import Y8.t;
import Z8.C1173v;
import Z8.F;
import android.content.Context;
import android.graphics.Color;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.ailauncher.chat.model.ActionBar;
import com.stepos.ailauncher.chat.model.ActionComponent;
import com.stepos.ailauncher.chat.model.ActionComponentType;
import com.stepos.ailauncher.chat.model.ActionItem;
import com.stepos.ailauncher.chat.model.ActionOption;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.p;
import p9.InterfaceC5063a;
import p9.InterfaceC5074l;
import s5.C5444a;
import v5.C5659a;

@Metadata(d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\n\u0018\u00002\u00020\u0001Bi\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004\u0012\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\n\u0012\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u0006\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\n¢\u0006\u0004\b\u0010\u0010\u0011J\u0015\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\u0012¢\u0006\u0004\b\u0014\u0010\u0015J\r\u0010\u0016\u001a\u00020\b¢\u0006\u0004\b\u0016\u0010\u0017J\u0015\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0018¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u0004\u0018\u00010\u0018¢\u0006\u0004\b\u001c\u0010\u001dJ!\u0010!\u001a\u00020\u00182\u0006\u0010\u001f\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010\u0018H\u0002¢\u0006\u0004\b!\u0010\"J\u0017\u0010$\u001a\u00020#2\u0006\u0010\u0013\u001a\u00020\u0012H\u0002¢\u0006\u0004\b$\u0010%J\u0017\u0010'\u001a\u00020&2\u0006\u0010 \u001a\u00020\u0018H\u0002¢\u0006\u0004\b'\u0010(J\u0017\u0010+\u001a\u00020#2\u0006\u0010*\u001a\u00020)H\u0002¢\u0006\u0004\b+\u0010,J\u001f\u0010.\u001a\u00020#2\u0006\u0010*\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0018H\u0002¢\u0006\u0004\b.\u0010/J\u001f\u00102\u001a\u00020\b2\u0006\u00100\u001a\u00020&2\u0006\u00101\u001a\u00020\fH\u0002¢\u0006\u0004\b2\u00103J\u001f\u00104\u001a\u00020#2\u0006\u0010*\u001a\u00020)2\u0006\u0010-\u001a\u00020\u0018H\u0002¢\u0006\u0004\b4\u0010/R\u0014\u0010\u0003\u001a\u00020\u00028\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0003\u00105R\u0014\u0010\u0005\u001a\u00020\u00048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u0005\u00106R \u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\t\u00107R\u001a\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000b\u00108R\u001a\u0010\r\u001a\b\u0012\u0004\u0012\u00020\f0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\r\u00108R \u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\b0\u00068\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000e\u00107R\u001a\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\n8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b\u000f\u00108R(\u0010:\u001a\u0004\u0018\u00010\u00122\b\u00109\u001a\u0004\u0018\u00010\u00128\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b:\u0010;\u001a\u0004\b<\u0010=R&\u0010@\u001a\u0014\u0012\u0004\u0012\u00020\u0018\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00180?0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b@\u0010AR,\u0010B\u001a\u001a\u0012\u0004\u0012\u00020\u0018\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180>0>8\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bB\u0010AR$\u0010C\u001a\u00020\f2\u0006\u00109\u001a\u00020\f8\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\bC\u0010D\u001a\u0004\bE\u0010FR\u0011\u0010H\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bG\u0010F¨\u0006I"}, d2 = {"Lr5/f;", "", "Landroid/content/Context;", "context", "Landroid/widget/LinearLayout;", "container", "Lkotlin/Function1;", "Landroid/view/ViewGroup;", "LY8/t;", "attachImageRecyclerTo", "Lkotlin/Function0;", "restoreImageRecyclerToDefault", "", "hasImageItems", "onMediaPreviewChanged", "onCloseClicked", "<init>", "(Landroid/content/Context;Landroid/widget/LinearLayout;Lp9/l;Lp9/a;Lp9/a;Lp9/l;Lp9/a;)V", "Lcom/stepos/ailauncher/chat/model/ActionBar;", "action", "u", "(Lcom/stepos/ailauncher/chat/model/ActionBar;)V", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "()V", "", "inputText", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/String;)Ljava/lang/String;", "v", "()Ljava/lang/String;", "", "index", "title", Const.INTENT_KEY_BACKGROUND_COMMAND, "(ILjava/lang/String;)Ljava/lang/String;", "Landroid/view/View;", "n", "(Lcom/stepos/ailauncher/chat/model/ActionBar;)Landroid/view/View;", "Landroid/widget/TextView;", "q", "(Ljava/lang/String;)Landroid/widget/TextView;", "Lcom/stepos/ailauncher/chat/model/ActionComponent;", "component", "p", "(Lcom/stepos/ailauncher/chat/model/ActionComponent;)Landroid/view/View;", "sectionKey", "r", "(Lcom/stepos/ailauncher/chat/model/ActionComponent;Ljava/lang/String;)Landroid/view/View;", "textView", "selected", "f", "(Landroid/widget/TextView;Z)V", "k", "Landroid/content/Context;", "Landroid/widget/LinearLayout;", "Lp9/l;", "Lp9/a;", UxipConstants.f30680s, "currentAction", "Lcom/stepos/ailauncher/chat/model/ActionBar;", "getCurrentAction", "()Lcom/stepos/ailauncher/chat/model/ActionBar;", "", "Ljava/util/LinkedHashSet;", "selectBoxSelections", "Ljava/util/Map;", "dropdownSelections", "hasMediaPreview", "Z", "getHasMediaPreview", "()Z", "t", "isShowing", "chat_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class f {
    private final InterfaceC5074l<ViewGroup, t> attachImageRecyclerTo;
    private final LinearLayout container;
    private final Context context;
    private ActionBar currentAction;
    private final Map<String, Map<String, String>> dropdownSelections;
    private final InterfaceC5063a<Boolean> hasImageItems;
    private boolean hasMediaPreview;
    private final InterfaceC5063a<t> onCloseClicked;
    private final InterfaceC5074l<Boolean, t> onMediaPreviewChanged;
    private final InterfaceC5063a<t> restoreImageRecyclerToDefault;
    private final Map<String, LinkedHashSet<String>> selectBoxSelections;

    /* JADX WARN: Multi-variable type inference failed */
    public f(Context context, LinearLayout container, InterfaceC5074l<? super ViewGroup, t> attachImageRecyclerTo, InterfaceC5063a<t> restoreImageRecyclerToDefault, InterfaceC5063a<Boolean> hasImageItems, InterfaceC5074l<? super Boolean, t> onMediaPreviewChanged, InterfaceC5063a<t> onCloseClicked) {
        p.i(context, "context");
        p.i(container, "container");
        p.i(attachImageRecyclerTo, "attachImageRecyclerTo");
        p.i(restoreImageRecyclerToDefault, "restoreImageRecyclerToDefault");
        p.i(hasImageItems, "hasImageItems");
        p.i(onMediaPreviewChanged, "onMediaPreviewChanged");
        p.i(onCloseClicked, "onCloseClicked");
        this.context = context;
        this.container = container;
        this.attachImageRecyclerTo = attachImageRecyclerTo;
        this.restoreImageRecyclerToDefault = restoreImageRecyclerToDefault;
        this.hasImageItems = hasImageItems;
        this.onMediaPreviewChanged = onMediaPreviewChanged;
        this.onCloseClicked = onCloseClicked;
        this.selectBoxSelections = new LinkedHashMap();
        this.dropdownSelections = new LinkedHashMap();
    }

    public static final CharSequence i(Map.Entry it) {
        p.i(it, "it");
        Object key = it.getKey();
        Object value = it.getValue();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(key);
        sb2.append(value);
        return sb2.toString();
    }

    public static final void l(final List list, final TextView textView, final Map map, final String str, View view) {
        if (list.isEmpty()) {
            return;
        }
        PopupMenu popupMenu = new PopupMenu(textView.getContext(), view);
        int i10 = 0;
        for (Object obj : list) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            popupMenu.getMenu().add(0, i10, i10, (String) obj);
            i10 = i11;
        }
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() { // from class: r5.e
            @Override // android.widget.PopupMenu.OnMenuItemClickListener
            public final boolean onMenuItemClick(MenuItem menuItem) {
                return f.m(list, map, str, textView, menuItem);
            }
        });
        popupMenu.show();
    }

    public static final boolean m(List list, Map map, String str, TextView textView, MenuItem menuItem) {
        String str2 = (String) F.t0(list, menuItem.getItemId());
        if (str2 == null) {
            str2 = "";
        }
        map.put(str, str2);
        textView.setText(str + " " + str2 + "  ▾");
        return true;
    }

    public static final void o(f fVar, View view) {
        fVar.onCloseClicked.invoke();
    }

    public static final void s(TextView textView, ActionOption actionOption, LinkedHashSet linkedHashSet, f fVar, View view) {
        textView.setSelected(!textView.isSelected());
        String label = actionOption.getLabel();
        if (label == null) {
            label = "";
        }
        if (textView.isSelected()) {
            linkedHashSet.add(label);
        } else {
            linkedHashSet.remove(label);
        }
        fVar.f(textView, textView.isSelected());
    }

    public final void f(TextView textView, boolean selected) {
        C5444a c5444a = C5444a.INSTANCE;
        textView.setBackground(c5444a.a(this.context, selected));
        textView.setTextColor(c5444a.c());
    }

    public final String g(int index, String title) {
        if (title == null) {
            title = "";
        }
        return index + Const.STR_MART_WELL + title;
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String h(java.lang.String r21) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.f.h(java.lang.String):java.lang.String");
    }

    public final void j() {
        this.currentAction = null;
        this.hasMediaPreview = false;
        this.selectBoxSelections.clear();
        this.dropdownSelections.clear();
        this.restoreImageRecyclerToDefault.invoke();
        this.container.removeAllViews();
        this.container.setVisibility(8);
        this.onMediaPreviewChanged.invoke(Boolean.FALSE);
    }

    public final View k(ActionComponent component, String sectionKey) {
        Map<String, Map<String, String>> map = this.dropdownSelections;
        Map<String, String> linkedHashMap = map.get(sectionKey);
        if (linkedHashMap == null) {
            linkedHashMap = new LinkedHashMap<>();
            map.put(sectionKey, linkedHashMap);
        }
        final Map<String, String> map2 = linkedHashMap;
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        C5659a c5659a = C5659a.INSTANCE;
        Context context = linearLayout.getContext();
        p.h(context, "getContext(...)");
        int i10 = 8;
        linearLayout.setPadding(0, 0, 0, c5659a.a(context, 8));
        List<ActionOption> options = component.getOptions();
        if (options == null) {
            options = C1173v.m();
        }
        for (ActionOption actionOption : options) {
            final List<String> values = actionOption.getValues();
            if (values == null) {
                values = C1173v.m();
            }
            String str = (String) F.s0(values);
            if (str == null) {
                str = "";
            }
            String label = actionOption.getLabel();
            final String str2 = label != null ? label : "";
            if (!H.x0(str)) {
                map2.put(str2, str);
            }
            final TextView textView = new TextView(this.context);
            textView.setText(str2 + " " + str + "  ▾");
            textView.setTextSize(12.0f);
            C5444a c5444a = C5444a.INSTANCE;
            textView.setTextColor(c5444a.c());
            C5659a c5659a2 = C5659a.INSTANCE;
            Context context2 = textView.getContext();
            p.h(context2, "getContext(...)");
            int iA = c5659a2.a(context2, i10);
            Context context3 = textView.getContext();
            p.h(context3, "getContext(...)");
            int iA2 = c5659a2.a(context3, 6);
            Context context4 = textView.getContext();
            p.h(context4, "getContext(...)");
            int iA3 = c5659a2.a(context4, i10);
            Context context5 = textView.getContext();
            p.h(context5, "getContext(...)");
            textView.setPadding(iA, iA2, iA3, c5659a2.a(context5, 6));
            Context context6 = textView.getContext();
            p.h(context6, "getContext(...)");
            textView.setBackground(c5444a.a(context6, false));
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            Context context7 = textView.getContext();
            p.h(context7, "getContext(...)");
            layoutParams.setMarginEnd(c5659a2.a(context7, 8));
            textView.setLayoutParams(layoutParams);
            textView.setOnClickListener(new View.OnClickListener() { // from class: r5.d
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.l(values, textView, map2, str2, view);
                }
            });
            linearLayout.addView(textView);
            i10 = 8;
        }
        HorizontalScrollView horizontalScrollView = new HorizontalScrollView(this.context);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
        horizontalScrollView.setOverScrollMode(2);
        horizontalScrollView.addView(linearLayout, new ViewGroup.LayoutParams(-2, -2));
        return horizontalScrollView;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x009e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final android.view.View n(com.stepos.ailauncher.chat.model.ActionBar r10) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.f.n(com.stepos.ailauncher.chat.model.ActionBar):android.view.View");
    }

    public final View p(ActionComponent component) {
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(1);
        C5659a c5659a = C5659a.INSTANCE;
        Context context = linearLayout.getContext();
        p.h(context, "getContext(...)");
        linearLayout.setPadding(0, 0, 0, c5659a.a(context, 8));
        this.attachImageRecyclerTo.invoke(linearLayout);
        return linearLayout;
    }

    public final TextView q(String title) {
        TextView textView = new TextView(this.context);
        textView.setText(title);
        textView.setTextColor(Color.parseColor("#80FFFFFF"));
        textView.setTextSize(10.0f);
        C5659a c5659a = C5659a.INSTANCE;
        Context context = textView.getContext();
        p.h(context, "getContext(...)");
        int iA = c5659a.a(context, 8);
        Context context2 = textView.getContext();
        p.h(context2, "getContext(...)");
        textView.setPadding(0, iA, 0, c5659a.a(context2, 6));
        return textView;
    }

    public final View r(ActionComponent component, String sectionKey) {
        Map<String, LinkedHashSet<String>> map = this.selectBoxSelections;
        LinkedHashSet<String> linkedHashSet = map.get(sectionKey);
        if (linkedHashSet == null) {
            linkedHashSet = new LinkedHashSet<>();
            map.put(sectionKey, linkedHashSet);
        }
        final LinkedHashSet<String> linkedHashSet2 = linkedHashSet;
        LinearLayout linearLayout = new LinearLayout(this.context);
        linearLayout.setOrientation(0);
        C5659a c5659a = C5659a.INSTANCE;
        Context context = linearLayout.getContext();
        p.h(context, "getContext(...)");
        linearLayout.setPadding(0, 0, 0, c5659a.a(context, 8));
        List<ActionOption> options = component.getOptions();
        if (options == null) {
            options = C1173v.m();
        }
        for (final ActionOption actionOption : options) {
            final TextView textView = new TextView(this.context);
            CharSequence label = actionOption.getLabel();
            if (label == null) {
                label = "";
            }
            textView.setText(label);
            textView.setTextSize(12.0f);
            C5659a c5659a2 = C5659a.INSTANCE;
            Context context2 = textView.getContext();
            p.h(context2, "getContext(...)");
            int iA = c5659a2.a(context2, 8);
            Context context3 = textView.getContext();
            p.h(context3, "getContext(...)");
            int iA2 = c5659a2.a(context3, 6);
            Context context4 = textView.getContext();
            p.h(context4, "getContext(...)");
            int iA3 = c5659a2.a(context4, 8);
            Context context5 = textView.getContext();
            p.h(context5, "getContext(...)");
            textView.setPadding(iA, iA2, iA3, c5659a2.a(context5, 6));
            textView.setSelected(false);
            f(textView, false);
            textView.setOnClickListener(new View.OnClickListener() { // from class: r5.b
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    f.s(textView, actionOption, linkedHashSet2, this, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            Context context6 = textView.getContext();
            p.h(context6, "getContext(...)");
            layoutParams.setMarginEnd(c5659a2.a(context6, 6));
            textView.setLayoutParams(layoutParams);
            linearLayout.addView(textView);
        }
        return linearLayout;
    }

    public final boolean t() {
        return this.currentAction != null;
    }

    public final void u(ActionBar action) {
        p.i(action, "action");
        this.currentAction = action;
        this.restoreImageRecyclerToDefault.invoke();
        this.container.removeAllViews();
        int i10 = 0;
        this.container.setVisibility(0);
        this.hasMediaPreview = false;
        this.selectBoxSelections.clear();
        this.dropdownSelections.clear();
        this.container.addView(n(action));
        List<ActionItem> items = action.getItems();
        if (items == null) {
            items = C1173v.m();
        }
        for (Object obj : items) {
            int i11 = i10 + 1;
            if (i10 < 0) {
                C1173v.w();
            }
            ActionItem actionItem = (ActionItem) obj;
            String strG = g(i10, actionItem.getTitle());
            String title = actionItem.getTitle();
            if (title != null && !H.x0(title)) {
                LinearLayout linearLayout = this.container;
                String title2 = actionItem.getTitle();
                p.f(title2);
                linearLayout.addView(q(title2));
            }
            List<ActionComponent> components = actionItem.getComponents();
            if (components == null) {
                components = C1173v.m();
            }
            for (ActionComponent actionComponent : components) {
                String type = actionComponent.getType();
                if (type != null) {
                    int iHashCode = type.hashCode();
                    if (iHashCode != -1169589272) {
                        if (iHashCode != 350565393) {
                            if (iHashCode == 1337952813 && type.equals(ActionComponentType.MEDIA_PREVIEW)) {
                                this.hasMediaPreview = true;
                                this.container.addView(p(actionComponent));
                            }
                        } else if (type.equals(ActionComponentType.DROPDOWN)) {
                            this.container.addView(k(actionComponent, strG));
                        }
                    } else if (type.equals(ActionComponentType.SELECT_BOX)) {
                        this.container.addView(r(actionComponent, strG));
                    }
                }
            }
            i10 = i11;
        }
        this.onMediaPreviewChanged.invoke(Boolean.valueOf(this.hasMediaPreview));
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0113 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:88:0x013a A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0111 A[EDGE_INSN: B:89:0x0111->B:72:0x0111 BREAK  A[LOOP:1: B:25:0x005f->B:94:?], SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:94:? A[LOOP:1: B:25:0x005f->B:94:?, LOOP_END, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String v() {
        /*
            Method dump skipped, instructions count: 318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r5.f.v():java.lang.String");
    }
}
