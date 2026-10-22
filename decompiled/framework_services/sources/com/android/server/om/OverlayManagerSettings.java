package com.android.server.om;

import android.content.om.OverlayConstraint;
import android.content.om.OverlayIdentifier;
import android.content.om.OverlayInfo;
import android.util.ArrayMap;
import android.util.ArraySet;
import android.util.IndentingPrintWriter;
import android.util.Pair;
import android.util.Xml;
import com.android.internal.util.CollectionUtils;
import com.android.internal.util.XmlUtils;
import com.android.modules.utils.TypedXmlPullParser;
import com.android.modules.utils.TypedXmlSerializer;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import org.xmlpull.v1.XmlPullParserException;

/* JADX INFO: loaded from: classes2.dex */
final class OverlayManagerSettings {
    private final ArrayList<SettingsItem> mItems;

    static final class BadKeyException extends Exception {
        BadKeyException(OverlayIdentifier overlay, int userId) {
            super("Bad key '" + overlay + "' for user " + userId);
        }
    }

    static final class Serializer {
        private static final String ATTR_BASE_CODE_PATH = "baseCodePath";
        private static final String ATTR_CATEGORY = "category";
        private static final String ATTR_CONSTRAINT_TYPE = "type";
        private static final String ATTR_CONSTRAINT_VALUE = "value";
        private static final String ATTR_IS_ENABLED = "isEnabled";
        private static final String ATTR_IS_FABRICATED = "fabricated";
        private static final String ATTR_IS_STATIC = "isStatic";
        private static final String ATTR_OVERLAY_NAME = "overlayName";
        private static final String ATTR_PACKAGE_NAME = "packageName";
        private static final String ATTR_PRIORITY = "priority";
        private static final String ATTR_STATE = "state";
        private static final String ATTR_TARGET_OVERLAYABLE_NAME = "targetOverlayableName";
        private static final String ATTR_TARGET_PACKAGE_NAME = "targetPackageName";
        private static final String ATTR_USER_ID = "userId";
        private static final String ATTR_VERSION = "version";
        static final int CURRENT_VERSION = 5;
        private static final String TAG_CONSTRAINT = "constraint";
        private static final String TAG_ITEM = "item";
        private static final String TAG_OVERLAYS = "overlays";

        Serializer() {
        }

        public static void restore(ArrayList<SettingsItem> table, InputStream is) throws IOException, XmlPullParserException {
            table.clear();
            TypedXmlPullParser parser = Xml.resolvePullParser(is);
            XmlUtils.beginDocument(parser, TAG_OVERLAYS);
            int version = parser.getAttributeInt(null, ATTR_VERSION);
            if (version == 5) goto L5;
            upgrade(version);
        L5:
            int depth = parser.getDepth();
        L7:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L11;
            if ("item".equals(parser.getName()) == false) goto L7;
            SettingsItem item = restoreRow(parser, depth + 1);
            table.add(item);
            goto L7
        }

        private static void upgrade(int oldVersion) throws XmlPullParserException {
            switch(oldVersion) {
                case 0: goto L7;
                case 1: goto L7;
                case 2: goto L7;
                case 3: goto L5;
                case 4: goto L5;
                default: goto L4;
            };
        L5:
            return;
        L4:
            throw new XmlPullParserException("unrecognized version " + oldVersion);
        L7:
            throw new XmlPullParserException("old version " + oldVersion + "; ignoring");
        }

        private static SettingsItem restoreRow(TypedXmlPullParser parser, int depth) throws IOException, XmlPullParserException {
            OverlayIdentifier overlay = new OverlayIdentifier(XmlUtils.readStringAttribute(parser, "packageName"), XmlUtils.readStringAttribute(parser, ATTR_OVERLAY_NAME));
            int userId = parser.getAttributeInt(null, "userId");
            String targetPackageName = XmlUtils.readStringAttribute(parser, ATTR_TARGET_PACKAGE_NAME);
            String targetOverlayableName = XmlUtils.readStringAttribute(parser, ATTR_TARGET_OVERLAYABLE_NAME);
            String baseCodePath = XmlUtils.readStringAttribute(parser, ATTR_BASE_CODE_PATH);
            int state = parser.getAttributeInt(null, "state");
            boolean isEnabled = parser.getAttributeBoolean(null, ATTR_IS_ENABLED, false);
            boolean isStatic = parser.getAttributeBoolean(null, ATTR_IS_STATIC, false);
            int priority = parser.getAttributeInt(null, ATTR_PRIORITY);
            String category = XmlUtils.readStringAttribute(parser, ATTR_CATEGORY);
            boolean isFabricated = parser.getAttributeBoolean(null, ATTR_IS_FABRICATED, false);
            List<OverlayConstraint> constraints = new ArrayList();
        L4:
            if (XmlUtils.nextElementWithin(parser, depth) == false) goto L10;
            if (TAG_CONSTRAINT.equals(parser.getName()) == false) goto L4;
            OverlayConstraint constraint = new OverlayConstraint(parser.getAttributeInt(null, "type"), parser.getAttributeInt(null, ATTR_CONSTRAINT_VALUE));
            constraints.add(constraint);
            isStatic = isStatic;
            goto L4
        L10:
            return new SettingsItem(overlay, userId, targetPackageName, targetOverlayableName, baseCodePath, state, isEnabled, !isStatic, priority, category, isFabricated, constraints);
        }

        public static void persist(ArrayList<SettingsItem> table, OutputStream os) throws IOException {
            TypedXmlSerializer xml = Xml.resolveSerializer(os);
            xml.startDocument(null, true);
            xml.setFeature("http://xmlpull.org/v1/doc/features.html#indent-output", true);
            xml.startTag(null, TAG_OVERLAYS);
            xml.attributeInt(null, ATTR_VERSION, 5);
            int n = table.size();
            int i = 0;
        L3:
            if (i >= n) goto L5;
            SettingsItem item = table.get(i);
            persistRow(xml, item);
            i = i + 1;
            goto L3
        L5:
            xml.endTag(null, TAG_OVERLAYS);
            xml.endDocument();
        }

        private static void persistRow(TypedXmlSerializer xml, SettingsItem item) throws IOException {
            xml.startTag(null, "item");
            XmlUtils.writeStringAttribute(xml, "packageName", SettingsItem.m6363$$Nest$fgetmOverlay(item).getPackageName());
            XmlUtils.writeStringAttribute(xml, ATTR_OVERLAY_NAME, SettingsItem.m6363$$Nest$fgetmOverlay(item).getOverlayName());
            xml.attributeInt(null, "userId", SettingsItem.m6368$$Nest$fgetmUserId(item));
            XmlUtils.writeStringAttribute(xml, ATTR_TARGET_PACKAGE_NAME, SettingsItem.m6367$$Nest$fgetmTargetPackageName(item));
            XmlUtils.writeStringAttribute(xml, ATTR_TARGET_OVERLAYABLE_NAME, SettingsItem.m6366$$Nest$fgetmTargetOverlayableName(item));
            XmlUtils.writeStringAttribute(xml, ATTR_BASE_CODE_PATH, SettingsItem.m6357$$Nest$fgetmBaseCodePath(item));
            xml.attributeInt(null, "state", SettingsItem.m6365$$Nest$fgetmState(item));
            XmlUtils.writeBooleanAttribute(xml, ATTR_IS_ENABLED, SettingsItem.m6360$$Nest$fgetmIsEnabled(item));
            XmlUtils.writeBooleanAttribute(xml, ATTR_IS_STATIC, !SettingsItem.m6362$$Nest$fgetmIsMutable(item));
            xml.attributeInt(null, ATTR_PRIORITY, SettingsItem.m6364$$Nest$fgetmPriority(item));
            XmlUtils.writeStringAttribute(xml, ATTR_CATEGORY, SettingsItem.m6358$$Nest$fgetmCategory(item));
            XmlUtils.writeBooleanAttribute(xml, ATTR_IS_FABRICATED, SettingsItem.m6361$$Nest$fgetmIsFabricated(item));
            Iterator r2 = SettingsItem.m6359$$Nest$fgetmConstraints(item).iterator();
        L4:
            if (r2.hasNext() == false) goto L6;
            OverlayConstraint constraint = (OverlayConstraint) r2.next();
            xml.startTag(null, TAG_CONSTRAINT);
            xml.attributeInt(null, "type", constraint.getType());
            xml.attributeInt(null, ATTR_CONSTRAINT_VALUE, constraint.getValue());
            xml.endTag(null, TAG_CONSTRAINT);
            goto L4
        L6:
            xml.endTag(null, "item");
        }
    }

    private static final class SettingsItem {
        private String mBaseCodePath;
        private OverlayInfo mCache;
        private String mCategory;
        private List<OverlayConstraint> mConstraints;
        private boolean mIsEnabled;
        private final boolean mIsFabricated;
        private final boolean mIsMutable;
        private final OverlayIdentifier mOverlay;
        private int mPriority;
        private int mState;
        private final String mTargetOverlayableName;
        private final String mTargetPackageName;
        private final int mUserId;

        /* JADX INFO: renamed from: -$$Nest$fgetmBaseCodePath, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6357$$Nest$fgetmBaseCodePath(SettingsItem r0) {
            return r0.mBaseCodePath;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmCategory, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6358$$Nest$fgetmCategory(SettingsItem r0) {
            return r0.mCategory;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ List m6359$$Nest$fgetmConstraints(SettingsItem r0) {
            return r0.mConstraints;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6360$$Nest$fgetmIsEnabled(SettingsItem r0) {
            return r0.mIsEnabled;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsFabricated, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6361$$Nest$fgetmIsFabricated(SettingsItem r0) {
            return r0.mIsFabricated;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmIsMutable, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6362$$Nest$fgetmIsMutable(SettingsItem r0) {
            return r0.mIsMutable;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmOverlay, reason: not valid java name */
        static /* bridge */ /* synthetic */ OverlayIdentifier m6363$$Nest$fgetmOverlay(SettingsItem r0) {
            return r0.mOverlay;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmPriority, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6364$$Nest$fgetmPriority(SettingsItem r0) {
            return r0.mPriority;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6365$$Nest$fgetmState(SettingsItem r0) {
            return r0.mState;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTargetOverlayableName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6366$$Nest$fgetmTargetOverlayableName(SettingsItem r0) {
            return r0.mTargetOverlayableName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmTargetPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6367$$Nest$fgetmTargetPackageName(SettingsItem r0) {
            return r0.mTargetPackageName;
        }

        /* JADX INFO: renamed from: -$$Nest$fgetmUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6368$$Nest$fgetmUserId(SettingsItem r0) {
            return r0.mUserId;
        }

        /* JADX INFO: renamed from: -$$Nest$mgetBaseCodePath, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6369$$Nest$mgetBaseCodePath(SettingsItem r0) {
            return r0.getBaseCodePath();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetOverlayInfo, reason: not valid java name */
        static /* bridge */ /* synthetic */ OverlayInfo m6370$$Nest$mgetOverlayInfo(SettingsItem r0) {
            return r0.getOverlayInfo();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetPriority, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6371$$Nest$mgetPriority(SettingsItem r0) {
            return r0.getPriority();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetState, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6372$$Nest$mgetState(SettingsItem r0) {
            return r0.getState();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetTargetOverlayableName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6373$$Nest$mgetTargetOverlayableName(SettingsItem r0) {
            return r0.getTargetOverlayableName();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetTargetPackageName, reason: not valid java name */
        static /* bridge */ /* synthetic */ String m6374$$Nest$mgetTargetPackageName(SettingsItem r0) {
            return r0.getTargetPackageName();
        }

        /* JADX INFO: renamed from: -$$Nest$mgetUserId, reason: not valid java name */
        static /* bridge */ /* synthetic */ int m6375$$Nest$mgetUserId(SettingsItem r0) {
            return r0.getUserId();
        }

        /* JADX INFO: renamed from: -$$Nest$misEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6376$$Nest$misEnabled(SettingsItem r0) {
            return r0.isEnabled();
        }

        /* JADX INFO: renamed from: -$$Nest$misMutable, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6377$$Nest$misMutable(SettingsItem r0) {
            return r0.isMutable();
        }

        /* JADX INFO: renamed from: -$$Nest$msetBaseCodePath, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6378$$Nest$msetBaseCodePath(SettingsItem r0, String r1) {
            return r0.setBaseCodePath(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetCategory, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6379$$Nest$msetCategory(SettingsItem r0, String r1) {
            return r0.setCategory(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetConstraints, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6380$$Nest$msetConstraints(SettingsItem r0, List r1) {
            return r0.setConstraints(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetEnabled, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6381$$Nest$msetEnabled(SettingsItem r0, boolean r1) {
            return r0.setEnabled(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetPriority, reason: not valid java name */
        static /* bridge */ /* synthetic */ void m6382$$Nest$msetPriority(SettingsItem r0, int r1) {
            r0.setPriority(r1);
        }

        /* JADX INFO: renamed from: -$$Nest$msetState, reason: not valid java name */
        static /* bridge */ /* synthetic */ boolean m6383$$Nest$msetState(SettingsItem r0, int r1) {
            return r0.setState(r1);
        }

        SettingsItem(OverlayIdentifier overlay, int userId, String targetPackageName, String targetOverlayableName, String baseCodePath, int state, boolean isEnabled, boolean isMutable, int priority, String category, boolean isFabricated, List<OverlayConstraint> constraints) {
            this.mOverlay = overlay;
            this.mUserId = userId;
            this.mTargetPackageName = targetPackageName;
            this.mTargetOverlayableName = targetOverlayableName;
            this.mBaseCodePath = baseCodePath;
            this.mState = state;
            this.mIsEnabled = isEnabled;
            this.mCategory = category;
            this.mCache = null;
            this.mIsMutable = isMutable;
            this.mPriority = priority;
            this.mIsFabricated = isFabricated;
            constraints.getClass();
            this.mConstraints = constraints;
        }

        private String getTargetPackageName() {
            return this.mTargetPackageName;
        }

        private String getTargetOverlayableName() {
            return this.mTargetOverlayableName;
        }

        private int getUserId() {
            return this.mUserId;
        }

        private String getBaseCodePath() {
            return this.mBaseCodePath;
        }

        private boolean setBaseCodePath(String path) {
            if (this.mBaseCodePath.equals(path) == true) goto L6;
            this.mBaseCodePath = path;
            invalidateCache();
            return true;
        L6:
            return false;
        }

        private int getState() {
            return this.mState;
        }

        private boolean setState(int state) {
            if (this.mState == state) goto L6;
            this.mState = state;
            invalidateCache();
            return true;
        L6:
            return false;
        }

        private boolean isEnabled() {
            return this.mIsEnabled;
        }

        private boolean setEnabled(boolean enable) {
            if (this.mIsMutable == true) goto L6;
            return false;
        L6:
            if (this.mIsEnabled == enable) goto L9;
            this.mIsEnabled = enable;
            invalidateCache();
            return true;
        L9:
            return false;
        }

        private boolean setCategory(String category) {
            if (Objects.equals(this.mCategory, category) == true) goto L9;
            if (category != null) goto L6;
            String r0 = null;
        L7:
            this.mCategory = r0;
            invalidateCache();
            return true;
        L6:
            r0 = category.intern();
            goto L7
        L9:
            return false;
        }

        private boolean setConstraints(List<OverlayConstraint> constraints) {
            constraints.getClass();
            if (this.mIsMutable == true) goto L6;
            return false;
        L6:
            if (Objects.equals(this.mConstraints, constraints) == true) goto L9;
            this.mConstraints = constraints;
            invalidateCache();
            return true;
        L9:
            return false;
        }

        private OverlayInfo getOverlayInfo() {
            if (this.mCache != null) goto L6;
            this.mCache = new OverlayInfo(this.mOverlay.getPackageName(), this.mOverlay.getOverlayName(), this.mTargetPackageName, this.mTargetOverlayableName, this.mCategory, this.mBaseCodePath, this.mState, this.mUserId, this.mPriority, this.mIsMutable, this.mIsFabricated, this.mConstraints);
        L6:
            return this.mCache;
        }

        private void setPriority(int priority) {
            this.mPriority = priority;
            invalidateCache();
        }

        private void invalidateCache() {
            this.mCache = null;
        }

        private boolean isMutable() {
            return this.mIsMutable;
        }

        private int getPriority() {
            return this.mPriority;
        }
    }

    /* JADX INFO: renamed from: $r8$lambda$6J5BctW4NTBE-5Sr2bk1dTrDlVM, reason: not valid java name */
    public static /* synthetic */ boolean m6355$r8$lambda$6J5BctW4NTBE5Sr2bk1dTrDlVM(Predicate r0, int r1, OverlayInfo r2) {
        return lambda$removeIf$3(r0, r1, r2);
    }

    public static /* synthetic */ int $r8$lambda$6NW65LIpjrluanlvM01K9BiQbu8(SettingsItem r0) {
        return SettingsItem.m6375$$Nest$mgetUserId(r0);
    }

    public static /* synthetic */ void $r8$lambda$GrziuyWd_0e8rahaF8gtHiSxmwU(Set r0, SettingsItem r1) {
        lambda$getAllIdentifiersAndBaseCodePaths$2(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$XiKOgedvteNoND8T_MY8kR7wPf0(String r0, SettingsItem r1) {
        return lambda$selectWhereTarget$7(r0, r1);
    }

    public static /* synthetic */ List $r8$lambda$YzjH3ppJzDqsTP84tx6Vx4SWtMQ(String r0) {
        return lambda$getOverlaysForUser$0(r0);
    }

    public static /* synthetic */ boolean $r8$lambda$f4cxqh4I2c5FPrgQGdL_Zzht_eE(int r0, SettingsItem r1) {
        return lambda$removeUser$4(r0, r1);
    }

    public static /* synthetic */ void $r8$lambda$kDyA0E1XFyUdbniZy8flqK7NCTI(Set r0, SettingsItem r1) {
        lambda$getAllBaseCodePaths$1(r0, r1);
    }

    public static /* synthetic */ OverlayInfo $r8$lambda$kdu1J4VP2rTGaX3uyigDkFiHHyI(SettingsItem r0) {
        return SettingsItem.m6370$$Nest$mgetOverlayInfo(r0);
    }

    /* JADX INFO: renamed from: $r8$lambda$o_oiBrg4tQUBIPkPA79BFs-s6c0, reason: not valid java name */
    public static /* synthetic */ boolean m6356$r8$lambda$o_oiBrg4tQUBIPkPA79BFss6c0(String r0, SettingsItem r1) {
        return lambda$selectWhereOverlay$6(r0, r1);
    }

    public static /* synthetic */ boolean $r8$lambda$scuEqjBvlN8uZmEprohiNNb9JNI(int r0, SettingsItem r1) {
        return lambda$selectWhereUser$5(r0, r1);
    }

    OverlayManagerSettings() {
        this.mItems = new ArrayList();
    }

    OverlayInfo init(OverlayIdentifier overlay, int userId, String targetPackageName, String targetOverlayableName, String baseCodePath, boolean isMutable, boolean isEnabled, int priority, String overlayCategory, boolean isFabricated) {
        remove(overlay, userId);
        SettingsItem item = new SettingsItem(overlay, userId, targetPackageName, targetOverlayableName, baseCodePath, -1, isEnabled, isMutable, priority, overlayCategory, isFabricated, Collections.emptyList());
        insert(item);
        return SettingsItem.m6370$$Nest$mgetOverlayInfo(item);
    }

    boolean remove(OverlayIdentifier overlay, int userId) {
        int idx = select(overlay, userId);
        if (idx >= 0) goto L6;
        return false;
    L6:
        this.mItems.remove(idx);
        return true;
    }

    OverlayInfo getOverlayInfo(OverlayIdentifier overlay, int userId) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6370$$Nest$mgetOverlayInfo(this.mItems.get(idx));
    L7:
        throw new BadKeyException(overlay, userId);
    }

    OverlayInfo getNullableOverlayInfo(OverlayIdentifier overlay, int userId) {
        int idx = select(overlay, userId);
        if (idx >= 0) goto L7;
        return null;
    L7:
        return SettingsItem.m6370$$Nest$mgetOverlayInfo(this.mItems.get(idx));
    }

    boolean setBaseCodePath(OverlayIdentifier overlay, int userId, String path) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6378$$Nest$msetBaseCodePath(this.mItems.get(idx), path);
    L7:
        throw new BadKeyException(overlay, userId);
    }

    boolean setCategory(OverlayIdentifier overlay, int userId, String category) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6379$$Nest$msetCategory(this.mItems.get(idx), category);
    L7:
        throw new BadKeyException(overlay, userId);
    }

    boolean getEnabled(OverlayIdentifier overlay, int userId) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6376$$Nest$misEnabled(this.mItems.get(idx));
    L7:
        throw new BadKeyException(overlay, userId);
    }

    boolean setEnabled(OverlayIdentifier overlay, int userId, boolean enable) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6381$$Nest$msetEnabled(this.mItems.get(idx), enable);
    L7:
        throw new BadKeyException(overlay, userId);
    }

    boolean setConstraints(OverlayIdentifier overlay, int userId, List<OverlayConstraint> constraints) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6380$$Nest$msetConstraints(this.mItems.get(idx), constraints);
    L7:
        throw new BadKeyException(overlay, userId);
    }

    int getState(OverlayIdentifier overlay, int userId) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6372$$Nest$mgetState(this.mItems.get(idx));
    L7:
        throw new BadKeyException(overlay, userId);
    }

    boolean setState(OverlayIdentifier overlay, int userId, int state) throws BadKeyException {
        int idx = select(overlay, userId);
        if (idx < 0) goto L7;
        return SettingsItem.m6383$$Nest$msetState(this.mItems.get(idx), state);
    L7:
        throw new BadKeyException(overlay, userId);
    }

    List<OverlayInfo> getOverlaysForTarget(String targetPackageName, int userId) {
        List<SettingsItem> items = selectWhereTarget(targetPackageName, userId);
        return CollectionUtils.map(items, new OverlayManagerSettings$$ExternalSyntheticLambda5());
    }

    void forEachMatching(int userId, String overlayName, String targetPackageName, Consumer<OverlayInfo> consumer) {
        int i = 0;
        int n = this.mItems.size();
    L3:
        if (i >= n) goto L18;
        SettingsItem item = this.mItems.get(i);
        if (SettingsItem.m6375$$Nest$mgetUserId(item) != userId) goto L16;
        if (overlayName != null) goto L9;
    L11:
        if (targetPackageName != null) goto L13;
    L15:
        consumer.accept(SettingsItem.m6370$$Nest$mgetOverlayInfo(item));
        goto L16
    L13:
        if (SettingsItem.m6367$$Nest$fgetmTargetPackageName(item).equals(targetPackageName) == true) goto L15;
    L9:
        if (SettingsItem.m6363$$Nest$fgetmOverlay(item).getPackageName().equals(overlayName) == true) goto L11;
    L16:
        i = i + 1;
        goto L3
    }

    ArrayMap<String, List<OverlayInfo>> getOverlaysForUser(int userId) {
        List<SettingsItem> items = selectWhereUser(userId);
        ArrayMap<String, List<OverlayInfo>> targetInfos = new ArrayMap();
        int i = 0;
        int n = items.size();
    L3:
        if (i >= n) goto L6;
        SettingsItem item = items.get(i);
        targetInfos.computeIfAbsent(SettingsItem.m6367$$Nest$fgetmTargetPackageName(item), new OverlayManagerSettings$$ExternalSyntheticLambda8()).add(SettingsItem.m6370$$Nest$mgetOverlayInfo(item));
        i = i + 1;
        goto L3
    L6:
        return targetInfos;
    }

    private static /* synthetic */ List lambda$getOverlaysForUser$0(String String) {
        return new ArrayList();
    }

    Set<String> getAllBaseCodePaths() {
        final Set<String> paths = new ArraySet();
        this.mItems.forEach(new OverlayManagerSettings$$ExternalSyntheticLambda2(paths));
        return paths;
    }

    private static /* synthetic */ void lambda$getAllBaseCodePaths$1(Set paths, SettingsItem item) {
        paths.add(SettingsItem.m6357$$Nest$fgetmBaseCodePath(item));
    }

    Set<Pair<OverlayIdentifier, String>> getAllIdentifiersAndBaseCodePaths() {
        final Set<Pair<OverlayIdentifier, String>> set = new ArraySet();
        this.mItems.forEach(new OverlayManagerSettings$$ExternalSyntheticLambda3(set));
        return set;
    }

    private static /* synthetic */ void lambda$getAllIdentifiersAndBaseCodePaths$2(Set set, SettingsItem item) {
        set.add(new Pair(SettingsItem.m6363$$Nest$fgetmOverlay(item), SettingsItem.m6357$$Nest$fgetmBaseCodePath(item)));
    }

    Pair<OverlayIdentifier, String> getIdentifierAndBaseCodePath(DumpState dumpState) {
        if (dumpState.getPackageName() != null) goto L5;
        return null;
    L5:
        OverlayIdentifier id = new OverlayIdentifier(dumpState.getPackageName(), dumpState.getOverlayName());
        int userId = dumpState.getUserId();
        int i = 0;
    L7:
        if (i >= this.mItems.size()) goto L19;
        SettingsItem item = this.mItems.get(i);
        if (userId == (-1)) goto L14;
        if (userId == SettingsItem.m6368$$Nest$fgetmUserId(item)) goto L14;
    L15:
        i = i + 1;
    L14:
        if (id.equals(SettingsItem.m6363$$Nest$fgetmOverlay(item)) == false) goto L15;
        return new Pair(id, SettingsItem.m6357$$Nest$fgetmBaseCodePath(item));
    L19:
        return null;
    }

    private static /* synthetic */ boolean lambda$removeIf$3(Predicate predicate, int userId, OverlayInfo info) {
        if (predicate.test(info) == true) goto L5;
    L7:
        return false;
    L5:
        if (info.userId != userId) goto L7;
        return true;
    }

    List<OverlayInfo> removeIf(final Predicate<OverlayInfo> predicate, final int userId) {
        return removeIf(new OverlayManagerSettings$$ExternalSyntheticLambda7(predicate, userId));
    }

    List<OverlayInfo> removeIf(Predicate<OverlayInfo> predicate) {
        List<OverlayInfo> removed = null;
        int i = this.mItems.size() - 1;
    L3:
        if (i < 0) goto L9;
        OverlayInfo info = SettingsItem.m6370$$Nest$mgetOverlayInfo(this.mItems.get(i));
        if (predicate.test(info) == false) goto L7;
        this.mItems.remove(i);
        removed = CollectionUtils.add(removed, info);
    L7:
        i = i - 1;
        goto L3
    L9:
        return CollectionUtils.emptyIfNull(removed);
    }

    int[] getUsers() {
        return this.mItems.stream().mapToInt(new OverlayManagerSettings$$ExternalSyntheticLambda6()).distinct().toArray();
    }

    boolean removeUser(final int userId) {
        return this.mItems.removeIf(new OverlayManagerSettings$$ExternalSyntheticLambda1(userId));
    }

    private static /* synthetic */ boolean lambda$removeUser$4(int userId, SettingsItem item) {
        if (SettingsItem.m6375$$Nest$mgetUserId(item) != userId) goto L6;
        return true;
    L6:
        return false;
    }

    void setPriority(OverlayIdentifier overlay, int userId, int priority) throws BadKeyException {
        int moveIdx = select(overlay, userId);
        if (moveIdx < 0) goto L7;
        SettingsItem itemToMove = this.mItems.get(moveIdx);
        this.mItems.remove(moveIdx);
        SettingsItem.m6382$$Nest$msetPriority(itemToMove, priority);
        insert(itemToMove);
        return;
    L7:
        throw new BadKeyException(overlay, userId);
    }

    boolean setPriority(OverlayIdentifier overlay, OverlayIdentifier newOverlay, int userId) {
        if (overlay.equals(newOverlay) == false) goto L5;
        return false;
    L5:
        int moveIdx = select(overlay, userId);
        if (moveIdx >= 0) goto L8;
        return false;
    L8:
        int parentIdx = select(newOverlay, userId);
        if (parentIdx >= 0) goto L11;
        return false;
    L11:
        SettingsItem itemToMove = this.mItems.get(moveIdx);
        if (SettingsItem.m6374$$Nest$mgetTargetPackageName(itemToMove).equals(SettingsItem.m6374$$Nest$mgetTargetPackageName(this.mItems.get(parentIdx))) == true) goto L14;
        return false;
    L14:
        this.mItems.remove(moveIdx);
        int newParentIdx = select(newOverlay, userId) + 1;
        this.mItems.add(newParentIdx, itemToMove);
        if (moveIdx != newParentIdx) goto L17;
        return false;
    L17:
        return true;
    }

    boolean setLowestPriority(OverlayIdentifier overlay, int userId) {
        int idx = select(overlay, userId);
        if (idx > 0) goto L5;
        return false;
    L5:
        SettingsItem item = this.mItems.get(idx);
        this.mItems.remove(item);
        this.mItems.add(0, item);
        return true;
    }

    boolean setHighestPriority(OverlayIdentifier overlay, int userId) {
        int idx = select(overlay, userId);
        if (idx >= 0) goto L5;
        return false;
    L5:
        if (idx == (this.mItems.size() - 1)) goto L11;
        SettingsItem item = this.mItems.get(idx);
        this.mItems.remove(idx);
        this.mItems.add(item);
        return true;
    L11:
        return false;
    }

    private void insert(SettingsItem item) {
        int i = this.mItems.size() - 1;
    L3:
        if (i < 0) goto L8;
        SettingsItem parentItem = this.mItems.get(i);
        if (SettingsItem.m6364$$Nest$fgetmPriority(parentItem) <= SettingsItem.m6371$$Nest$mgetPriority(item)) goto L8;
        i = i - 1;
    L8:
        this.mItems.add(i + 1, item);
    }

    void dump(PrintWriter p, DumpState dumpState) {
        int userId = dumpState.getUserId();
        String packageName = dumpState.getPackageName();
        String overlayName = dumpState.getOverlayName();
        String field = dumpState.getField();
        IndentingPrintWriter pw = new IndentingPrintWriter(p, "  ");
        int i = 0;
    L4:
        if (i >= this.mItems.size()) goto L23;
        SettingsItem item = this.mItems.get(i);
        if (userId != (-1)) goto L8;
    L10:
        if (packageName != null) goto L12;
    L14:
        if (overlayName != null) goto L16;
    L18:
        if (field == null) goto L20;
        dumpSettingsItemField(pw, item, field);
    L21:
        i = i + 1;
        goto L4
    L20:
        dumpSettingsItem(pw, item);
        goto L21
    L16:
        if (overlayName.equals(SettingsItem.m6363$$Nest$fgetmOverlay(item).getOverlayName()) == true) goto L18;
    L12:
        if (packageName.equals(SettingsItem.m6363$$Nest$fgetmOverlay(item).getPackageName()) == true) goto L14;
    L8:
        if (userId == SettingsItem.m6368$$Nest$fgetmUserId(item)) goto L10;
    }

    private void dumpSettingsItem(IndentingPrintWriter pw, SettingsItem item) {
        pw.println(SettingsItem.m6363$$Nest$fgetmOverlay(item) + ":" + SettingsItem.m6375$$Nest$mgetUserId(item) + " {");
        pw.increaseIndent();
        StringBuilder r0 = new StringBuilder();
        r0.append("mPackageName...........: ");
        r0.append(SettingsItem.m6363$$Nest$fgetmOverlay(item).getPackageName());
        pw.println(r0.toString());
        pw.println("mOverlayName...........: " + SettingsItem.m6363$$Nest$fgetmOverlay(item).getOverlayName());
        pw.println("mUserId................: " + SettingsItem.m6375$$Nest$mgetUserId(item));
        pw.println("mTargetPackageName.....: " + SettingsItem.m6374$$Nest$mgetTargetPackageName(item));
        pw.println("mTargetOverlayableName.: " + SettingsItem.m6373$$Nest$mgetTargetOverlayableName(item));
        pw.println("mBaseCodePath..........: " + SettingsItem.m6369$$Nest$mgetBaseCodePath(item));
        pw.println("mState.................: " + OverlayInfo.stateToString(SettingsItem.m6372$$Nest$mgetState(item)));
        pw.println("mIsEnabled.............: " + SettingsItem.m6376$$Nest$misEnabled(item));
        pw.println("mIsMutable.............: " + SettingsItem.m6377$$Nest$misMutable(item));
        pw.println("mPriority..............: " + SettingsItem.m6364$$Nest$fgetmPriority(item));
        pw.println("mCategory..............: " + SettingsItem.m6358$$Nest$fgetmCategory(item));
        pw.println("mIsFabricated..........: " + SettingsItem.m6361$$Nest$fgetmIsFabricated(item));
        pw.println("mConstraints...........: " + OverlayConstraint.constraintsToString(SettingsItem.m6359$$Nest$fgetmConstraints(item)));
        pw.decreaseIndent();
        pw.println("}");
    }

    private void dumpSettingsItemField(IndentingPrintWriter pw, SettingsItem item, String field) {
        switch(field.hashCode()) {
            case -1750736508: goto L36;
            case -1248283232: goto L33;
            case -1165461084: goto L30;
            case -836029914: goto L27;
            case -831052100: goto L24;
            case -405989669: goto L21;
            case 50511102: goto L18;
            case 109757585: goto L15;
            case 440941271: goto L12;
            case 909712337: goto L9;
            case 1693907299: goto L6;
            default: goto L38;
        };
    L38:
        byte r0 = -1;
    L39:
        switch(r0) {
            case 0: goto L51;
            case 1: goto L50;
            case 2: goto L49;
            case 3: goto L48;
            case 4: goto L47;
            case 5: goto L46;
            case 6: goto L45;
            case 7: goto L44;
            case 8: goto L43;
            case 9: goto L42;
            case 10: goto L41;
            default: goto L63;
        };
    L41:
        pw.println(SettingsItem.m6358$$Nest$fgetmCategory(item));
        return;
    L42:
        pw.println(SettingsItem.m6364$$Nest$fgetmPriority(item));
        return;
    L43:
        pw.println(SettingsItem.m6362$$Nest$fgetmIsMutable(item));
        return;
    L44:
        pw.println(SettingsItem.m6360$$Nest$fgetmIsEnabled(item));
        return;
    L45:
        pw.println(OverlayInfo.stateToString(SettingsItem.m6365$$Nest$fgetmState(item)));
        return;
    L46:
        pw.println(SettingsItem.m6357$$Nest$fgetmBaseCodePath(item));
        return;
    L47:
        pw.println(SettingsItem.m6366$$Nest$fgetmTargetOverlayableName(item));
        return;
    L48:
        pw.println(SettingsItem.m6367$$Nest$fgetmTargetPackageName(item));
        return;
    L49:
        pw.println(SettingsItem.m6368$$Nest$fgetmUserId(item));
        return;
    L50:
        pw.println(SettingsItem.m6363$$Nest$fgetmOverlay(item).getOverlayName());
        return;
    L51:
        pw.println(SettingsItem.m6363$$Nest$fgetmOverlay(item).getPackageName());
        return;
    L63:
        return;
    L6:
        if (field.equals("basecodepath") == false) goto L38;
        r0 = 5;
        goto L39
    L9:
        if (field.equals("packagename") == false) goto L38;
        r0 = 0;
        goto L39
    L12:
        if (field.equals("isenabled") == false) goto L38;
        r0 = 7;
        goto L39
    L15:
        if (field.equals("state") == false) goto L38;
        r0 = 6;
        goto L39
    L18:
        if (field.equals("category") == false) goto L38;
        r0 = 10;
        goto L39
    L21:
        if (field.equals("overlayname") == false) goto L38;
        r0 = 1;
        goto L39
    L24:
        if (field.equals("ismutable") == false) goto L38;
        r0 = 8;
        goto L39
    L27:
        if (field.equals("userid") == false) goto L38;
        r0 = 2;
        goto L39
    L30:
        if (field.equals("priority") == false) goto L38;
        r0 = 9;
        goto L39
    L33:
        if (field.equals("targetpackagename") == false) goto L38;
        r0 = 3;
        goto L39
    L36:
        if (field.equals("targetoverlayablename") == false) goto L38;
        r0 = 4;
        goto L39
    }

    void restore(InputStream is) throws IOException, XmlPullParserException {
        Serializer.restore(this.mItems, is);
    }

    void persist(OutputStream os) throws IOException, XmlPullParserException {
        Serializer.persist(this.mItems, os);
    }

    private int select(OverlayIdentifier overlay, int userId) {
        int n = this.mItems.size();
        int i = 0;
    L3:
        if (i >= n) goto L10;
        SettingsItem item = this.mItems.get(i);
        if (SettingsItem.m6368$$Nest$fgetmUserId(item) != userId) goto L9;
        if (SettingsItem.m6363$$Nest$fgetmOverlay(item).equals(overlay) == false) goto L9;
        return i;
    L9:
        i = i + 1;
        goto L3
    L10:
        return -1;
    }

    private List<SettingsItem> selectWhereUser(final int userId) {
        List<SettingsItem> selectedItems = new ArrayList();
        CollectionUtils.addIf(this.mItems, selectedItems, new OverlayManagerSettings$$ExternalSyntheticLambda9(userId));
        return selectedItems;
    }

    private static /* synthetic */ boolean lambda$selectWhereUser$5(int userId, SettingsItem i) {
        if (SettingsItem.m6368$$Nest$fgetmUserId(i) != userId) goto L5;
        return true;
    L5:
        return false;
    }

    private List<SettingsItem> selectWhereOverlay(final String packageName, int userId) {
        List<SettingsItem> items = selectWhereUser(userId);
        items.removeIf(new OverlayManagerSettings$$ExternalSyntheticLambda4(packageName));
        return items;
    }

    private static /* synthetic */ boolean lambda$selectWhereOverlay$6(String packageName, SettingsItem i) {
        return !SettingsItem.m6363$$Nest$fgetmOverlay(i).getPackageName().equals(packageName);
    }

    private List<SettingsItem> selectWhereTarget(final String targetPackageName, int userId) {
        List<SettingsItem> items = selectWhereUser(userId);
        items.removeIf(new OverlayManagerSettings$$ExternalSyntheticLambda0(targetPackageName));
        return items;
    }

    private static /* synthetic */ boolean lambda$selectWhereTarget$7(String targetPackageName, SettingsItem i) {
        return !SettingsItem.m6374$$Nest$mgetTargetPackageName(i).equals(targetPackageName);
    }
}
