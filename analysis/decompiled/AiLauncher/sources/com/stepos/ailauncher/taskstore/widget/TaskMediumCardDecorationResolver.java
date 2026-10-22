package com.stepos.ailauncher.taskstore.widget;

import Z8.C1173v;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.QueryAlgorithmBundle;
import com.stepos.ailauncher.taskstore.R$drawable;
import com.stepos.ailauncher.taskstore.entity.TaskInfoCard;
import com.stepos.ailauncher.taskstore.entity.TaskInfoContentType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPart;
import com.stepos.ailauncher.taskstore.entity.TaskInfoPartType;
import com.stepos.ailauncher.taskstore.entity.TaskInfoStatus;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.sequences.SequencesKt___SequencesKt;

@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0003\bÀ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0019\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\u0007\u0010\bJ\u0019\u0010\u000b\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000b\u0010\fJ\u0017\u0010\r\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0007¢\u0006\u0004\b\r\u0010\u000eJ\u0017\u0010\u000f\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\tH\u0007¢\u0006\u0004\b\u000f\u0010\u0010J#\u0010\u0014\u001a\u00020\u00062\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0007¢\u0006\u0004\b\u0014\u0010\u0015J\u0017\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u0016\u0010\u000eJ\u0017\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u0019\u0010\u001aJ#\u0010\u001b\u001a\u00020\u00172\b\u0010\u0012\u001a\u0004\u0018\u00010\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b\u001b\u0010\u001cJ\u0017\u0010\u001d\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0003¢\u0006\u0004\b\u001d\u0010\u000eJ\u0017\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u001e\u0010\u001aJ\u0017\u0010\u001f\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u0017H\u0003¢\u0006\u0004\b\u001f\u0010\u001aJ\u0017\u0010\"\u001a\u00020\u00172\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u001b\u0010%\u001a\u0004\u0018\u00010\u00112\b\u0010$\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b%\u0010&J\u001b\u0010(\u001a\u0004\u0018\u00010\u00172\b\u0010'\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b(\u0010)J\u001b\u0010*\u001a\u0004\u0018\u00010\u00172\b\u0010\u0013\u001a\u0004\u0018\u00010\u0011H\u0002¢\u0006\u0004\b*\u0010)J%\u0010-\u001a\b\u0012\u0004\u0012\u00020 0+2\u000e\u0010,\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010+H\u0002¢\u0006\u0004\b-\u0010.J\u0017\u0010/\u001a\u00020\u00112\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b/\u00100J\u0017\u00102\u001a\u0002012\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b2\u00103R\u001a\u00106\u001a\b\u0012\u0004\u0012\u000205048\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\b6\u00107¨\u00068"}, d2 = {"Lcom/stepos/ailauncher/taskstore/widget/TaskMediumCardDecorationResolver;", "", "<init>", "()V", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;", "card", "", "m", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)Ljava/lang/Integer;", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;", "status", "p", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)Ljava/lang/Integer;", "s", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoCard;)I", "o", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoStatus;)I", "", "fileName", "mimeType", "n", "(Ljava/lang/String;Ljava/lang/String;)I", "q", "Lcom/stepos/ailauncher/taskstore/widget/MediumArtifactCategory;", QueryAlgorithmBundle.KEY_CATEGORY, Const.INTENT_KEY_PKGNAME, "(Lcom/stepos/ailauncher/taskstore/widget/MediumArtifactCategory;)I", Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/widget/MediumArtifactCategory;", "r", "c", Const.INTENT_KEY_UMID, "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;", "part", "e", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;)Lcom/stepos/ailauncher/taskstore/widget/MediumArtifactCategory;", "name", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(Ljava/lang/String;)Ljava/lang/String;", "ext", "f", "(Ljava/lang/String;)Lcom/stepos/ailauncher/taskstore/widget/MediumArtifactCategory;", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "", "parts", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Ljava/util/List;)Ljava/util/List;", "l", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;)Ljava/lang/String;", "", "k", "(Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPart;)Z", "", "Lcom/stepos/ailauncher/taskstore/entity/TaskInfoPartType;", "PRODUCT_INLINE_TYPES", "Ljava/util/Set;", "taskstore_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class TaskMediumCardDecorationResolver {
    public static final TaskMediumCardDecorationResolver INSTANCE = new TaskMediumCardDecorationResolver();
    private static final Set<TaskInfoPartType> PRODUCT_INLINE_TYPES = Z8.Y.j(TaskInfoPartType.IMAGE, TaskInfoPartType.VIDEO, TaskInfoPartType.AUDIO, TaskInfoPartType.FILE, TaskInfoPartType.SLIDES);

    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class a {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[TaskInfoStatus.values().length];
            try {
                iArr[TaskInfoStatus.FAILED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskInfoStatus.COMPLETED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[MediumArtifactCategory.values().length];
            try {
                iArr2[MediumArtifactCategory.DOC.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[MediumArtifactCategory.MD.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[MediumArtifactCategory.TXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr2[MediumArtifactCategory.PPT.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[MediumArtifactCategory.XLS.ordinal()] = 5;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[MediumArtifactCategory.PDF.ordinal()] = 6;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[MediumArtifactCategory.CODE.ordinal()] = 7;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[MediumArtifactCategory.ZIP.ordinal()] = 8;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[MediumArtifactCategory.FOLDER.ordinal()] = 9;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[MediumArtifactCategory.IMAGE.ordinal()] = 10;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[MediumArtifactCategory.AUDIO.ordinal()] = 11;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[MediumArtifactCategory.VIDEO.ordinal()] = 12;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[MediumArtifactCategory.GENERIC.ordinal()] = 13;
            } catch (NoSuchFieldError unused15) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public final int b(MediumArtifactCategory category) {
        switch (a.$EnumSwitchMapping$1[category.ordinal()]) {
            case 1:
            case 2:
            case 3:
                return R$drawable.ic_taskstore_artifact_color_word;
            case 4:
                return R$drawable.ic_taskstore_artifact_color_ppt;
            case 5:
                return R$drawable.ic_taskstore_artifact_color_excel;
            case 6:
                return R$drawable.ic_taskstore_artifact_color_pdf;
            case 7:
                return R$drawable.ic_taskstore_artifact_color_code;
            case 8:
                return R$drawable.ic_taskstore_artifact_color_zip;
            case 9:
                return R$drawable.ic_taskstore_artifact_color_folder;
            case 10:
                return R$drawable.ic_taskstore_tasktype_image;
            case 11:
            case 12:
            case 13:
                return R$drawable.ic_taskstore_tasktype_document;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int c(MediumArtifactCategory category) {
        switch (a.$EnumSwitchMapping$1[category.ordinal()]) {
            case 1:
                return R$drawable.ic_taskstore_artifact_glyph_document;
            case 2:
                return R$drawable.ic_taskstore_artifact_glyph_text;
            case 3:
                return R$drawable.ic_taskstore_artifact_glyph_text;
            case 4:
                return R$drawable.ic_taskstore_artifact_glyph_ppt;
            case 5:
                return R$drawable.ic_taskstore_artifact_glyph_table;
            case 6:
                return R$drawable.ic_home_space_artifact_glyph_pdf;
            case 7:
                return R$drawable.ic_taskstore_artifact_glyph_code;
            case 8:
            case 9:
                return R$drawable.ic_taskstore_artifact_glyph_multi;
            case 10:
                return R$drawable.ic_taskstore_artifact_glyph_image;
            case 11:
            case 12:
            case 13:
                return R$drawable.ic_taskstore_artifact_glyph_document;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final int d(MediumArtifactCategory category) {
        switch (a.$EnumSwitchMapping$1[category.ordinal()]) {
            case 1:
                return R$drawable.ic_taskstore_tasktype_document;
            case 2:
                return R$drawable.ic_taskstore_tasktype_text;
            case 3:
                return R$drawable.ic_taskstore_tasktype_text;
            case 4:
                return R$drawable.ic_taskstore_tasktype_presentation;
            case 5:
                return R$drawable.ic_taskstore_tasktype_table;
            case 6:
                return R$drawable.ic_taskstore_tasktype_pdf;
            case 7:
                return R$drawable.ic_taskstore_tasktype_code;
            case 8:
            case 9:
                return R$drawable.ic_taskstore_tasktype_multi;
            case 10:
                return R$drawable.ic_taskstore_tasktype_image;
            case 11:
            case 12:
            case 13:
                return R$drawable.ic_taskstore_tasktype_document;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public final MediumArtifactCategory e(TaskInfoPart part) {
        String fileName = part.getFileName();
        if (fileName == null) {
            fileName = part.getTitle();
        }
        if (M5.c.INSTANCE.y(fileName, part.getMimeType())) {
            return MediumArtifactCategory.FOLDER;
        }
        String strJ = j(part.getFileName());
        if (strJ == null) {
            strJ = j(part.getTitle());
        }
        MediumArtifactCategory mediumArtifactCategoryF = f(strJ);
        if (mediumArtifactCategoryF != null) {
            return mediumArtifactCategoryF;
        }
        MediumArtifactCategory mediumArtifactCategoryH = h(part.getMimeType());
        return mediumArtifactCategoryH != null ? mediumArtifactCategoryH : MediumArtifactCategory.GENERIC;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:101:0x015d, code lost:
    
        if (r2.equals("tif") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:104:0x0168, code lost:
    
        if (r2.equals("tar") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:107:0x0173, code lost:
    
        if (r2.equals("svg") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:110:0x017e, code lost:
    
        if (r2.equals("sql") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:113:0x0189, code lost:
    
        if (r2.equals("rtf") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:116:0x0194, code lost:
    
        if (r2.equals("rar") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:119:0x019f, code lost:
    
        if (r2.equals(com.stepos.ailauncher.chat.trace.ChatTracker.CONTENT_PPT) == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x001d, code lost:
    
        if (r2.equals("swift") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:122:0x01aa, code lost:
    
        if (r2.equals("pps") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:125:0x01b5, code lost:
    
        if (r2.equals("png") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:128:0x01c0, code lost:
    
        if (r2.equals("php") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:136:0x01d8, code lost:
    
        if (r2.equals("ogg") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:139:0x01e2, code lost:
    
        if (r2.equals("mov") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:142:0x01ec, code lost:
    
        if (r2.equals("mp4") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:145:0x01f6, code lost:
    
        if (r2.equals("mp3") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:148:0x0200, code lost:
    
        if (r2.equals("mkv") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0028, code lost:
    
        if (r2.equals("scala") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:151:0x020a, code lost:
    
        if (r2.equals("mdx") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:154:0x0214, code lost:
    
        if (r2.equals("lua") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x021e, code lost:
    
        if (r2.equals(com.stepos.statsapp.v3.lib.plugin.events.b.f30786f) == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0224, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.TXT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x022b, code lost:
    
        if (r2.equals("kts") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:165:0x0235, code lost:
    
        if (r2.equals("m4a") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:168:0x023f, code lost:
    
        if (r2.equals("key") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:171:0x0245, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.PPT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:173:0x024c, code lost:
    
        if (r2.equals("jsx") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:176:0x0256, code lost:
    
        if (r2.equals(u6.C5578a.DST_JPG) == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:179:0x0260, code lost:
    
        if (r2.equals("htm") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0033, code lost:
    
        if (r2.equals("yaml") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:182:0x026a, code lost:
    
        if (r2.equals("hpp") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:185:0x0274, code lost:
    
        if (r2.equals("gif") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:188:0x027e, code lost:
    
        if (r2.equals("flv") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:191:0x0288, code lost:
    
        if (r2.equals(com.stepos.ailauncher.chat.trace.ChatTracker.CONTENT_DOC) == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:194:0x028e, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.DOC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:196:0x0295, code lost:
    
        if (r2.equals("csv") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:199:0x029f, code lost:
    
        if (r2.equals("css") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:202:0x02a9, code lost:
    
        if (r2.equals("cpp") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:205:0x02b3, code lost:
    
        if (r2.equals("bmp") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:208:0x02b9, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.IMAGE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x003e, code lost:
    
        if (r2.equals("xlsx") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:210:0x02c0, code lost:
    
        if (r2.equals("avi") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:213:0x02c6, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.VIDEO;
     */
    /* JADX WARN: Code restructure failed: missing block: B:215:0x02cd, code lost:
    
        if (r2.equals("amr") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:218:0x02d7, code lost:
    
        if (r2.equals("aac") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:221:0x02dd, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.AUDIO;
     */
    /* JADX WARN: Code restructure failed: missing block: B:223:0x02e5, code lost:
    
        if (r2.equals("ts") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:226:0x02f0, code lost:
    
        if (r2.equals("sh") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:229:0x02fb, code lost:
    
        if (r2.equals("rs") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:232:0x0306, code lost:
    
        if (r2.equals("rb") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:235:0x0311, code lost:
    
        if (r2.equals("py") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:238:0x031b, code lost:
    
        if (r2.equals("md") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0049, code lost:
    
        if (r2.equals("webp") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:241:0x0321, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.MD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:243:0x0328, code lost:
    
        if (r2.equals("kt") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:246:0x0332, code lost:
    
        if (r2.equals("js") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:249:0x033b, code lost:
    
        if (r2.equals("gz") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:252:0x0344, code lost:
    
        if (r2.equals("go") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:255:0x034d, code lost:
    
        if (r2.equals("et") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:258:0x0352, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.XLS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:260:0x0359, code lost:
    
        if (r2.equals("cs") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:263:0x0362, code lost:
    
        if (r2.equals("cc") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:266:0x036b, code lost:
    
        if (r2.equals("7z") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:269:0x0370, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.ZIP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0054, code lost:
    
        if (r2.equals("webm") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:271:0x0378, code lost:
    
        if (r2.equals("r") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:274:0x0381, code lost:
    
        if (r2.equals("m") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:277:0x038a, code lost:
    
        if (r2.equals(com.autonavi.aps.amapapi.config.Const.INTENT_KEY_BACKGROUND_NOTIFICATION) == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:280:0x0393, code lost:
    
        if (r2.equals("c") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:283:0x0398, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.CODE;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x005f, code lost:
    
        if (r2.equals("tiff") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x006a, code lost:
    
        if (r2.equals("pptx") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x0075, code lost:
    
        if (r2.equals("ppsx") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0080, code lost:
    
        if (r2.equals("opus") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x008a, code lost:
    
        if (r2.equals("json") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x0094, code lost:
    
        if (r2.equals("jpeg") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x009e, code lost:
    
        if (r2.equals("java") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x00a8, code lost:
    
        if (r2.equals("html") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00b2, code lost:
    
        if (r2.equals("heif") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:56:0x00bc, code lost:
    
        if (r2.equals("heic") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00c6, code lost:
    
        if (r2.equals("flac") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00d0, code lost:
    
        if (r2.equals("docx") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00da, code lost:
    
        if (r2.equals("dart") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:68:0x00e4, code lost:
    
        if (r2.equals("bash") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00ef, code lost:
    
        if (r2.equals("zip") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00fa, code lost:
    
        if (r2.equals("yml") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0105, code lost:
    
        if (r2.equals("xml") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x0110, code lost:
    
        if (r2.equals("xls") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x011b, code lost:
    
        if (r2.equals("wps") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0126, code lost:
    
        if (r2.equals("wmv") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:89:0x0131, code lost:
    
        if (r2.equals("wav") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:8:0x0012, code lost:
    
        if (r2.equals("markdown") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:92:0x013c, code lost:
    
        if (r2.equals("vue") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:95:0x0147, code lost:
    
        if (r2.equals("txt") == false) goto L281;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x0152, code lost:
    
        if (r2.equals("tsx") == false) goto L281;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory f(java.lang.String r2) {
        /*
            Method dump skipped, instructions count: 1264
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TaskMediumCardDecorationResolver.f(java.lang.String):com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory");
    }

    public final MediumArtifactCategory g(String fileName, String mimeType) {
        if (M5.c.INSTANCE.y(fileName, mimeType)) {
            return MediumArtifactCategory.FOLDER;
        }
        MediumArtifactCategory mediumArtifactCategoryF = f(j(fileName));
        if (mediumArtifactCategoryF != null) {
            return mediumArtifactCategoryF;
        }
        MediumArtifactCategory mediumArtifactCategoryH = h(mimeType);
        return mediumArtifactCategoryH != null ? mediumArtifactCategoryH : MediumArtifactCategory.GENERIC;
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:111:0x0141, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.ZIP;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x0023, code lost:
    
        if (r4.equals("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x002d, code lost:
    
        if (r4.equals("application/x-7z-compressed") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0037, code lost:
    
        if (r4.equals("application/msword") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x0041, code lost:
    
        if (r4.equals("application/x-rar-compressed") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x004c, code lost:
    
        if (r4.equals("text/x-markdown") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0057, code lost:
    
        if (r4.equals("vnd.android.document/directory") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x0061, code lost:
    
        if (r4.equals("application/gzip") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x006b, code lost:
    
        if (r4.equals("application/vnd.ms-excel") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x0071, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.XLS;
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x0079, code lost:
    
        if (r4.equals("text/markdown") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x007f, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.MD;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x0093, code lost:
    
        if (r4.equals("application/vnd.openxmlformats-officedocument.wordprocessingml.document") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0098, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.DOC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x009f, code lost:
    
        if (r4.equals("application/vnd.ms-powerpoint") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00a8, code lost:
    
        if (r4.equals("application/vnd.openxmlformats-officedocument.presentationml.presentation") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00ad, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.PPT;
     */
    /* JADX WARN: Code restructure failed: missing block: B:63:0x00b4, code lost:
    
        if (r4.equals("application/zip") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00c9, code lost:
    
        if (r4.equals("inode/directory") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:74:0x00d2, code lost:
    
        if (r4.equals("application/x-tar") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x00db, code lost:
    
        if (r4.equals("application/x-directory") == false) goto L83;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x00e0, code lost:
    
        return com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory.FOLDER;
     */
    /* JADX WARN: Code restructure failed: missing block: B:82:0x00e7, code lost:
    
        if (r4.equals("application/x-zip-compressed") == false) goto L83;
     */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f6  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory h(java.lang.String r4) {
        /*
            Method dump skipped, instructions count: 400
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.taskstore.widget.TaskMediumCardDecorationResolver.h(java.lang.String):com.stepos.ailauncher.taskstore.widget.MediumArtifactCategory");
    }

    public final List<TaskInfoPart> i(List<TaskInfoPart> parts) {
        List<TaskInfoPart> list = parts;
        if (list == null || list.isEmpty()) {
            return C1173v.m();
        }
        ArrayList arrayList = new ArrayList();
        HashSet hashSet = new HashSet();
        for (TaskInfoPart taskInfoPart : SequencesKt___SequencesKt.F(Z8.F.d0(parts), new TaskMediumCardDecorationResolver$dedupProductParts$1(this))) {
            if (hashSet.add(INSTANCE.l(taskInfoPart))) {
                arrayList.add(taskInfoPart);
            }
        }
        return arrayList;
    }

    public final String j(String name) {
        return u6.j.INSTANCE.i(name, null, null);
    }

    public final boolean k(TaskInfoPart part) {
        if (part.getContentType() != TaskInfoContentType.INLINE) {
            return true;
        }
        return PRODUCT_INLINE_TYPES.contains(part.getType());
    }

    public final String l(TaskInfoPart part) {
        String partId = part.getPartId();
        if (partId != null) {
            if (La.H.x0(partId)) {
                partId = null;
            }
            if (partId != null) {
                return "id:" + partId;
            }
        }
        String fileId = part.getFileId();
        if (fileId != null) {
            if (La.H.x0(fileId)) {
                fileId = null;
            }
            if (fileId != null) {
                return "file:" + fileId;
            }
        }
        String sha256 = part.getSha256();
        if (sha256 != null) {
            String str = La.H.x0(sha256) ? null : sha256;
            if (str != null) {
                return "sha:" + str;
            }
        }
        String fileName = part.getFileName();
        if (fileName == null) {
            fileName = "";
        }
        return "nc:" + fileName + "|" + part.getContent();
    }

    public final Integer m(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        int i10 = a.$EnumSwitchMapping$0[card.getStatus().ordinal()];
        return i10 != 1 ? i10 != 2 ? Integer.valueOf(R$drawable.ic_taskstore_task_card_decoration_loading) : Integer.valueOf(q(card)) : Integer.valueOf(R$drawable.ic_taskstore_artifact_glyph_fail);
    }

    public final int n(String fileName, String mimeType) {
        return b(g(fileName, mimeType));
    }

    public final int o(TaskInfoStatus status) {
        kotlin.jvm.internal.p.i(status, "status");
        int i10 = a.$EnumSwitchMapping$0[status.ordinal()];
        return i10 != 1 ? i10 != 2 ? R$drawable.ic_taskstore_tasktype_loading : R$drawable.ic_taskstore_tasktype_none : R$drawable.ic_taskstore_tasktype_fail;
    }

    public final Integer p(TaskInfoStatus status) {
        kotlin.jvm.internal.p.i(status, "status");
        int i10 = a.$EnumSwitchMapping$0[status.ordinal()];
        return i10 != 1 ? i10 != 2 ? Integer.valueOf(R$drawable.ic_taskstore_live_card_decoration_loading) : Integer.valueOf(R$drawable.ic_taskstore_live_card_glyph_none) : Integer.valueOf(R$drawable.ic_taskstore_live_card_glyph_fail);
    }

    public final int q(TaskInfoCard card) {
        List<TaskInfoPart> listI = i(card.getResult());
        return listI.isEmpty() ? R$drawable.ic_taskstore_artifact_glyph_none : c(e((TaskInfoPart) Z8.F.q0(listI)));
    }

    public final int r(TaskInfoCard card) {
        List<TaskInfoPart> listI = i(card.getResult());
        return listI.isEmpty() ? R$drawable.ic_taskstore_tasktype_none : d(e((TaskInfoPart) Z8.F.q0(listI)));
    }

    public final int s(TaskInfoCard card) {
        kotlin.jvm.internal.p.i(card, "card");
        int i10 = a.$EnumSwitchMapping$0[card.getStatus().ordinal()];
        return i10 != 1 ? i10 != 2 ? R$drawable.ic_taskstore_tasktype_loading : r(card) : R$drawable.ic_taskstore_tasktype_fail;
    }
}
