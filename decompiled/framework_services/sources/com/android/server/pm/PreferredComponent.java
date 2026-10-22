package com.android.server.pm;

import android.content.ComponentName;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManagerInternal;
import android.content.pm.ResolveInfo;
import android.util.Slog;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import com.android.server.LocalServices;
import com.android.server.pm.pkg.PackageStateInternal;
import com.android.server.pm.pkg.PackageUserStateInternal;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
public class PreferredComponent {
    private static final String ATTR_ALWAYS = "always";
    private static final String ATTR_MATCH = "match";
    private static final String ATTR_NAME = "name";
    private static final String ATTR_SET = "set";
    private static final String TAG_SET = "set";
    public final boolean mAlways;
    private final Callbacks mCallbacks;
    public final ComponentName mComponent;
    public final int mMatch;
    private String mParseError;
    final String[] mSetClasses;
    final String[] mSetComponents;
    final String[] mSetPackages;
    final String mShortComponent;

    public interface Callbacks {
        boolean onReadTag(String r1, TypedXmlPullParser r2) throws XmlPullParserException, IOException;
    }

    public PreferredComponent(Callbacks callbacks, int match, ComponentName[] set, ComponentName component, boolean always) {
        this.mCallbacks = callbacks;
        this.mMatch = 268369920 & match;
        this.mComponent = component;
        this.mAlways = always;
        this.mShortComponent = component.flattenToShortString();
        this.mParseError = null;
        if (set == null) goto L12;
        int N = set.length;
        String[] myPackages = new String[N];
        String[] myClasses = new String[N];
        String[] myComponents = new String[N];
        int i = 0;
    L5:
        if (i >= N) goto L11;
        ComponentName cn = set[i];
        if (cn == null) goto L8;
        myPackages[i] = cn.getPackageName().intern();
        myClasses[i] = cn.getClassName().intern();
        myComponents[i] = cn.flattenToShortString();
        i = i + 1;
        goto L5
    L8:
        this.mSetPackages = null;
        this.mSetClasses = null;
        this.mSetComponents = null;
        return;
    L11:
        this.mSetPackages = myPackages;
        this.mSetClasses = myClasses;
        this.mSetComponents = myComponents;
        return;
    L12:
        this.mSetPackages = null;
        this.mSetClasses = null;
        this.mSetComponents = null;
    }

    public PreferredComponent(Callbacks callbacks, TypedXmlPullParser parser) throws XmlPullParserException, IOException {
        this.mCallbacks = callbacks;
        String r3 = null;
        this.mShortComponent = parser.getAttributeValue(null, "name");
        this.mComponent = ComponentName.unflattenFromString(this.mShortComponent);
        if (this.mComponent != null) goto L5;
        this.mParseError = "Bad activity name " + this.mShortComponent;
    L5:
        this.mMatch = parser.getAttributeIntHex(null, ATTR_MATCH, 0);
        int setCount = parser.getAttributeInt(null, "set", 0);
        int r8 = 1;
        this.mAlways = parser.getAttributeBoolean(null, ATTR_ALWAYS, true);
        if (setCount <= 0) goto L8;
        String[] myPackages = new String[setCount];
    L9:
        if (setCount <= 0) goto L11;
        String[] myClasses = new String[setCount];
    L12:
        if (setCount <= 0) goto L14;
        String[] myComponents = new String[setCount];
    L15:
        int setPos = 0;
        int outerDepth = parser.getDepth();
    L16:
        int type = parser.next();
        if (type == r8) goto L51;
        if (type == 3) goto L21;
    L23:
        if (type == 3) goto L50;
        if (type == 4) goto L50;
        String tagName = parser.getName();
        if (tagName.equals("set") == false) goto L47;
        String name = parser.getAttributeValue(r3, "name");
        if (name == null) goto L32;
        if (setPos >= setCount) goto L36;
        ComponentName cn = ComponentName.unflattenFromString(name);
        if (cn == null) goto L41;
        myPackages[setPos] = cn.getPackageName();
        myClasses[setPos] = cn.getClassName();
        myComponents[setPos] = name;
        setPos = setPos + 1;
    L44:
        XmlUtils.skipCurrentTag(parser);
    L49:
        r3 = null;
        r8 = 1;
        goto L16
    L41:
        if (this.mParseError != null) goto L44;
        this.mParseError = "Bad set name " + name + " in preferred activity " + this.mShortComponent;
        goto L44
    L36:
        if (this.mParseError != null) goto L44;
        this.mParseError = "Too many set tags in preferred activity " + this.mShortComponent;
        goto L44
    L32:
        if (this.mParseError != null) goto L44;
        this.mParseError = "No name in set tag in preferred activity " + this.mShortComponent;
        goto L44
    L47:
        if (this.mCallbacks.onReadTag(tagName, parser) == true) goto L49;
        Slog.w("PreferredComponent", "Unknown element: " + parser.getName());
        XmlUtils.skipCurrentTag(parser);
    L50:
        r3 = null;
        r8 = 1;
        goto L16
    L21:
        if (parser.getDepth() > outerDepth) goto L23;
    L51:
        if (setPos != setCount) goto L53;
    L55:
        this.mSetPackages = myPackages;
        this.mSetClasses = myClasses;
        this.mSetComponents = myComponents;
        return;
    L53:
        if (this.mParseError != null) goto L55;
        this.mParseError = "Not enough set tags (expected " + setCount + " but found " + setPos + ") in " + this.mShortComponent;
        goto L55
    L14:
        myComponents = null;
        goto L15
    L11:
        myClasses = null;
        goto L12
    L8:
        myPackages = null;
        goto L9
    }

    public String getParseError() {
        return this.mParseError;
    }

    public void writeToXml(TypedXmlSerializer serializer, boolean full) throws IOException {
        if (this.mSetClasses == null) goto L5;
        int NS = this.mSetClasses.length;
    L6:
        serializer.attribute(null, "name", this.mShortComponent);
        if (full == true) goto L9;
        return;
    L9:
        if (this.mMatch == 0) goto L11;
        serializer.attributeIntHex(null, ATTR_MATCH, this.mMatch);
    L11:
        serializer.attributeBoolean(null, ATTR_ALWAYS, this.mAlways);
        serializer.attributeInt(null, "set", NS);
        int s = 0;
    L12:
        if (s >= NS) goto L16;
        serializer.startTag(null, "set");
        serializer.attribute(null, "name", this.mSetComponents[s]);
        serializer.endTag(null, "set");
        s = s + 1;
        goto L12
    L16:
        return;
    L5:
        NS = 0;
        goto L6
    }

    public boolean sameSet(List<ResolveInfo> query, boolean excludeSetupWizardPackage, int userId) {
        List<ResolveInfo> r1 = query;
        boolean r3 = false;
        if (this.mSetPackages != null) goto L7;
        if (r1 != null) goto L52;
        return true;
    L52:
        return false;
    L7:
        if (r1 != null) goto L9;
        return false;
    L9:
        int NQ = r1.size();
        int NS = this.mSetPackages.length;
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        String setupWizardPackageName = pmi.getSetupWizardPackageName();
        int numMatch = 0;
        int i = 0;
    L10:
        if (i >= NQ) goto L36;
        ResolveInfo ri = r1.get(i);
        ActivityInfo ai = ri.activityInfo;
        boolean good = false;
        if (excludeSetupWizardPackage == true) goto L14;
    L16:
        PackageStateInternal ps = pmi.getPackageStateInternal(ai.packageName);
        if (ps != null) goto L19;
        boolean r16 = r3;
    L35:
        i = i + 1;
        r1 = query;
        r3 = r16;
        goto L10
    L19:
        PackageUserStateInternal pkgUserState = ps.getUserStates().get(userId);
        if (pkgUserState == null) goto L34;
        r16 = r3;
        if (pkgUserState.getInstallReason() == 3) goto L35;
        int j = 0;
    L25:
        if (j >= NS) goto L32;
        if (this.mSetPackages[j].equals(ai.packageName) == false) goto L31;
        if (this.mSetClasses[j].equals(ai.name) == false) goto L31;
        numMatch = numMatch + 1;
        good = true;
    L31:
        j = j + 1;
    L32:
        if (good == true) goto L35;
        return r16;
    L34:
        r16 = r3;
        goto L35
    L14:
        if (ai.packageName.equals(setupWizardPackageName) == false) goto L16;
        r16 = r3;
        goto L35
    L36:
        boolean r17 = r3;
        if (numMatch != NS) goto L40;
        return true;
    L40:
        return r17;
    }

    public boolean sameSet(ComponentName[] comps) {
        if (this.mSetPackages != null) goto L5;
        return false;
    L5:
        int NQ = comps.length;
        int NS = this.mSetPackages.length;
        int numMatch = 0;
        int i = 0;
    L6:
        if (i >= NQ) goto L19;
        ComponentName cn = comps[i];
        boolean good = false;
        int j = 0;
    L8:
        if (j >= NS) goto L15;
        if (this.mSetPackages[j].equals(cn.getPackageName()) == false) goto L14;
        if (this.mSetClasses[j].equals(cn.getClassName()) == false) goto L14;
        numMatch = numMatch + 1;
        good = true;
    L14:
        j = j + 1;
    L15:
        if (good == false) goto L16;
        i = i + 1;
        goto L6
    L16:
        return false;
    L19:
        if (numMatch != NS) goto L28;
        return true;
    L28:
        return false;
    }

    public boolean sameSet(PreferredComponent pc) {
        if (this.mSetPackages == null) goto L24;
        if (pc == null) goto L24;
        if (pc.mSetPackages == null) goto L24;
        if (sameComponent(pc.mComponent) == false) goto L24;
        int otherPackageCount = pc.mSetPackages.length;
        int packageCount = this.mSetPackages.length;
        if (otherPackageCount == packageCount) goto L13;
        return false;
    L13:
        int i = 0;
    L14:
        if (i >= packageCount) goto L22;
        if (this.mSetPackages[i].equals(pc.mSetPackages[i]) == false) goto L21;
        if (this.mSetClasses[i].equals(pc.mSetClasses[i]) == false) goto L21;
        i = i + 1;
    L21:
        return false;
    L22:
        return true;
    L24:
        return false;
    }

    private boolean sameComponent(ComponentName comp) {
        if (this.mComponent == null) goto L13;
        if (comp == null) goto L13;
        if (this.mComponent.getPackageName().equals(comp.getPackageName()) == true) goto L9;
    L12:
        return false;
    L9:
        if (this.mComponent.getClassName().equals(comp.getClassName()) == false) goto L12;
        return true;
    L13:
        return false;
    }

    public boolean isSuperset(List<ResolveInfo> query, boolean excludeSetupWizardPackage) {
        if (this.mSetPackages != null) goto L7;
        if (query == null) goto L6;
        return false;
    L6:
        return true;
    L7:
        if (query != null) goto L9;
        return true;
    L9:
        int NQ = query.size();
        int NS = this.mSetPackages.length;
        if (excludeSetupWizardPackage == true) goto L13;
        if (NS >= NQ) goto L13;
        return false;
    L13:
        PackageManagerInternal pmi = (PackageManagerInternal) LocalServices.getService(PackageManagerInternal.class);
        String setupWizardPackageName = pmi.getSetupWizardPackageName();
        int i = 0;
    L14:
        if (i >= NQ) goto L32;
        ResolveInfo ri = query.get(i);
        ActivityInfo ai = ri.activityInfo;
        boolean foundMatch = false;
        if (excludeSetupWizardPackage == true) goto L18;
    L20:
        int j = 0;
    L21:
        if (j >= NS) goto L28;
        if (this.mSetPackages[j].equals(ai.packageName) == false) goto L27;
        if (this.mSetClasses[j].equals(ai.name) == false) goto L27;
        foundMatch = true;
    L27:
        j = j + 1;
    L28:
        if (foundMatch == true) goto L30;
        return false;
    L30:
        i = i + 1;
        goto L14
    L18:
        if (ai.packageName.equals(setupWizardPackageName) == false) goto L20;
    L32:
        return true;
    }

    public ComponentName[] discardObsoleteComponents(List<ResolveInfo> query) {
        if (this.mSetPackages == null) goto L20;
        if (query == null) goto L20;
        int NQ = query.size();
        int NS = this.mSetPackages.length;
        ArrayList<ComponentName> aliveComponents = new ArrayList();
        int i = 0;
    L7:
        if (i >= NQ) goto L17;
        ResolveInfo ri = query.get(i);
        ActivityInfo ai = ri.activityInfo;
        int j = 0;
    L9:
        if (j >= NS) goto L16;
        if (this.mSetPackages[j].equals(ai.packageName) == false) goto L15;
        if (this.mSetClasses[j].equals(ai.name) == false) goto L15;
        aliveComponents.add(new ComponentName(this.mSetPackages[j], this.mSetClasses[j]));
    L15:
        j = j + 1;
    L16:
        i = i + 1;
        goto L7
    L17:
        int i2 = aliveComponents.size();
        return (ComponentName[]) aliveComponents.toArray(new ComponentName[i2]);
    L20:
        return new ComponentName[0];
    }

    public void dump(PrintWriter out, String prefix, Object ident) {
        out.print(prefix);
        out.print(Integer.toHexString(System.identityHashCode(ident)));
        out.print(' ');
        out.println(this.mShortComponent);
        out.print(prefix);
        out.print(" mMatch=0x");
        out.print(Integer.toHexString(this.mMatch));
        out.print(" mAlways=");
        out.println(this.mAlways);
        if (this.mSetComponents == null) goto L8;
        out.print(prefix);
        out.println("  Selected from:");
        int i = 0;
    L6:
        if (i >= this.mSetComponents.length) goto L10;
        out.print(prefix);
        out.print("    ");
        out.println(this.mSetComponents[i]);
        i = i + 1;
        goto L6
    L10:
        return;
    }
}
