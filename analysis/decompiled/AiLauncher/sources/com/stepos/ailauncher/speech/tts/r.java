package com.stepos.ailauncher.speech.tts;

import La.C0951a;
import La.D;
import La.H;
import La.K;
import androidx.exifinterface.media.ExifInterface;
import com.autonavi.aps.amapapi.config.Const;
import com.stepos.aiengine.args.MultiFilesBundle;
import com.stepos.ailauncher.foundation.credential.api.AuthSessionDto;
import com.stepos.ame.sdk.SkillStoreKt;
import com.stepos.statsapp.v3.lib.plugin.constants.UxipConstants;
import java.lang.Character;
import kotlin.Metadata;
import kotlin.text.Regex;
import v9.C5685n;

@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\f\n\u0002\bJ\n\u0002\u0018\u0002\n\u0002\b\u0014\b\u0000\u0018\u0000 ~2\u00020\u0001:\u0004fu!\u001eB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0007\u0010\bJ\u001f\u0010\n\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\n\u0010\u000bJ\u0017\u0010\r\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0006H\u0002¢\u0006\u0004\b\r\u0010\u000eJ3\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u0017\u0010\u0018J3\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u00142\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b\u001a\u0010\u001bJ#\u0010\u001e\u001a\u00020\u001d2\u0006\u0010\u001c\u001a\u00020\u000f2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b\u001e\u0010\u001fJ\u0017\u0010\"\u001a\u00020\u00042\u0006\u0010!\u001a\u00020 H\u0002¢\u0006\u0004\b\"\u0010#J\u001f\u0010$\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b$\u0010%J\u001f\u0010&\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b&\u0010'J\u001f\u0010(\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b(\u0010'J'\u0010)\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b)\u0010*J'\u0010+\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b+\u0010*J'\u0010,\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b,\u0010*J'\u0010-\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b-\u0010*J\u001f\u0010.\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b.\u0010%J'\u00100\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010/\u001a\u00020\u0006H\u0002¢\u0006\u0004\b0\u00101J\u001f\u00102\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b2\u0010%J\u001f\u00103\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b3\u0010%J'\u00104\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b4\u0010*J'\u00105\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b5\u00106J+\u00107\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b7\u00108J\u001f\u00109\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b9\u0010%J'\u0010:\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\b:\u0010*J\u0017\u0010<\u001a\u00020\u00042\u0006\u0010;\u001a\u00020 H\u0002¢\u0006\u0004\b<\u0010#J\u0017\u0010=\u001a\u00020\u00042\u0006\u0010;\u001a\u00020 H\u0002¢\u0006\u0004\b=\u0010#J\u0017\u0010?\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0011H\u0002¢\u0006\u0004\b?\u0010@J+\u0010A\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bA\u00108J'\u0010B\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bB\u00106J\u001f\u0010C\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\bC\u0010%J-\u0010D\u001a\u0004\u0018\u00010 2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bD\u0010EJ!\u0010G\u001a\u0004\u0018\u00010 2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u0011H\u0002¢\u0006\u0004\bG\u0010HJ\u001b\u0010I\u001a\u00020\u001d2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bI\u0010JJ+\u0010L\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bL\u00108J-\u0010M\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bM\u0010NJ!\u0010O\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u0011H\u0002¢\u0006\u0004\bO\u0010PJ+\u0010Q\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010K\u001a\u00020\u00112\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bQ\u00108J\u001d\u0010R\u001a\u0004\u0018\u00010\u00062\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bR\u0010SJ\u0011\u0010T\u001a\u0004\u0018\u00010\u0006H\u0002¢\u0006\u0004\bT\u0010UJ'\u0010Y\u001a\u00020\u00112\u0006\u0010V\u001a\u00020\u00062\u0006\u0010W\u001a\u00020 2\u0006\u0010X\u001a\u00020\u0011H\u0002¢\u0006\u0004\bY\u0010ZJ\u001f\u0010[\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b[\u0010%J\u001f\u0010\\\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b\\\u0010%J\u001f\u0010]\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b]\u0010%J!\u0010^\u001a\u0004\u0018\u00010 2\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0011H\u0002¢\u0006\u0004\b^\u0010HJ\u0017\u0010_\u001a\u00020\u00042\u0006\u0010;\u001a\u00020 H\u0002¢\u0006\u0004\b_\u0010#J\u001b\u0010!\u001a\u00020\u001d2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b!\u0010JJ\u001b\u0010`\u001a\u00020\u001d2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\b`\u0010JJ\u001b\u0010a\u001a\u00020\u001d2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\ba\u0010JJ\u001f\u0010b\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u0011H\u0002¢\u0006\u0004\bb\u0010'J\u001f\u0010c\u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u000f2\u0006\u0010F\u001a\u00020\u0011H\u0002¢\u0006\u0004\bc\u0010'J\u0017\u0010d\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0011H\u0002¢\u0006\u0004\bd\u0010@J\u0017\u0010e\u001a\u00020\u00042\u0006\u0010>\u001a\u00020\u0011H\u0002¢\u0006\u0004\be\u0010@J\u001b\u0010f\u001a\u00020\u001d2\n\u0010\u0015\u001a\u00060\u0013j\u0002`\u0014H\u0002¢\u0006\u0004\bf\u0010JJ\u0017\u0010g\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006H\u0002¢\u0006\u0004\bg\u0010hJ\u000f\u0010i\u001a\u00020\u0011H\u0002¢\u0006\u0004\bi\u0010jJ\u0017\u0010l\u001a\u00020k2\u0006\u0010\u0005\u001a\u00020\u0004H\u0002¢\u0006\u0004\bl\u0010mJ'\u0010q\u001a\u00020\u00112\u0006\u0010n\u001a\u00020\u00112\u0006\u0010o\u001a\u00020 2\u0006\u0010p\u001a\u00020 H\u0002¢\u0006\u0004\bq\u0010rJ\u0017\u0010t\u001a\u00020\u00042\u0006\u0010s\u001a\u00020\u0006H\u0002¢\u0006\u0004\bt\u0010\u000eJ\u0015\u0010u\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0006¢\u0006\u0004\bu\u0010hJ\r\u0010v\u001a\u00020\u0006¢\u0006\u0004\bv\u0010UR\u0018\u0010w\u001a\u00060\u0013j\u0002`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u0018\u0010y\u001a\u00060\u0013j\u0002`\u00148\u0002X\u0082\u0004¢\u0006\u0006\n\u0004\by\u0010xR\u0016\u0010z\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\bz\u00105R\u0016\u0010{\u001a\u00020 8\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b{\u00102R\u0016\u0010|\u001a\u00020\u00118\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b|\u0010?R\u0016\u0010}\u001a\u00020\u00048\u0002@\u0002X\u0082\u000e¢\u0006\u0006\n\u0004\b}\u00105¨\u0006\u007f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r;", "", "<init>", "()V", "", MultiFilesBundle.EVENT_FINAL, "", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_ID, "(Z)Ljava/lang/String;", "text", ExifInterface.LATITUDE_SOUTH, "(Ljava/lang/String;Z)Ljava/lang/String;", "tail", "q", "(Ljava/lang/String;)Z", "", "source", "", "index", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "output", "Lcom/stepos/ailauncher/speech/tts/r$a;", "n", "(Ljava/lang/CharSequence;ILjava/lang/StringBuilder;Z)Lcom/stepos/ailauncher/speech/tts/r$a;", "Lcom/stepos/ailauncher/speech/tts/r$c;", "o", "(Ljava/lang/CharSequence;ILjava/lang/StringBuilder;Z)Lcom/stepos/ailauncher/speech/tts/r$c;", SkillStoreKt.SKILL_DOC_TYPE_CONTENT, "LY8/t;", Const.INTENT_KEY_UMID, "(Ljava/lang/CharSequence;Ljava/lang/StringBuilder;)V", "", "c", "B", "(C)Z", "s", "(Ljava/lang/CharSequence;I)Z", Const.INTENT_KEY_BACKGROUND_NOTIFICATION, "(Ljava/lang/CharSequence;I)I", "d0", "N", "(Ljava/lang/CharSequence;IZ)I", "Q", "O", "P", "D", "marker", "M", "(Ljava/lang/CharSequence;ILjava/lang/String;)Z", "C", "t", ExifInterface.GPS_DIRECTION_TRUE, "Z", "(Ljava/lang/CharSequence;IZ)Z", "z", "(Ljava/lang/CharSequence;ILjava/lang/StringBuilder;)Z", "J", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, "char", ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "y", "cp", "I", "(I)Z", ExifInterface.LONGITUDE_EAST, "a0", "F", "f", "(Ljava/lang/CharSequence;ILjava/lang/StringBuilder;)Ljava/lang/Character;", "start", "R", "(Ljava/lang/CharSequence;I)Ljava/lang/Character;", "e", "(Ljava/lang/StringBuilder;)V", "dashIndex", "v", "K", "(Ljava/lang/CharSequence;ILjava/lang/StringBuilder;)Ljava/lang/String;", "Y", "(Ljava/lang/CharSequence;I)Ljava/lang/String;", ExifInterface.LONGITUDE_WEST, "f0", "(Ljava/lang/StringBuilder;)Ljava/lang/String;", "g0", "()Ljava/lang/String;", "emitted", "previous", "previousRun", "e0", "(Ljava/lang/String;CI)I", "G", "H", "x", "X", "u", "m", "p", "c0", "b0", "w", "r", Const.INTENT_KEY_PKGNAME, Const.INTENT_KEY_BACKGROUND_COMMAND, "(Ljava/lang/String;)Ljava/lang/String;", "k", "()I", "Lcom/stepos/ailauncher/speech/tts/r$d;", "U", "(Z)Lcom/stepos/ailauncher/speech/tts/r$d;", "openIndex", "opener", "closer", Const.INTENT_KEY_BACKGROUND_NOTIFICATION_REMOVE, "(ICC)I", UxipConstants.f30680s, "L", Const.INTENT_KEY_APIKEY, "l", AuthSessionDto.STATUS_PENDING, "Ljava/lang/StringBuilder;", "speakableCarry", "inCodeBlock", "lastEmittedChar", "trailingDigitRun", "pendingLineBreak", "Companion", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
/* loaded from: classes3.dex */
public final class r {

    @Deprecated
    public static final int ARROWS_BLOCK_END = 8703;

    @Deprecated
    public static final int ARROWS_BLOCK_START = 8592;

    @Deprecated
    public static final String ARROW_PAUSE_MARKER = "【停顿】";
    private static final b Companion = new b(null);

    @Deprecated
    public static final int MAX_INLINE_CODE_CHARS = 200;

    @Deprecated
    public static final int MAX_LABEL_CHARS = 512;

    @Deprecated
    public static final char NOTHING_EMITTED = 0;

    @Deprecated
    public static final int SPEAKABLE_CARRY_MAX = 8;
    private boolean inCodeBlock;
    private char lastEmittedChar;
    private boolean pendingLineBreak;
    private int trailingDigitRun;
    private final StringBuilder pending = new StringBuilder();
    private final StringBuilder speakableCarry = new StringBuilder();

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$a;", "", "c", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "Lcom/stepos/ailauncher/speech/tts/r$a$a;", "Lcom/stepos/ailauncher/speech/tts/r$a$b;", "Lcom/stepos/ailauncher/speech/tts/r$a$c;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface a {

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$a$a;", "Lcom/stepos/ailauncher/speech/tts/r$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.speech.tts.r$a$a, reason: collision with other inner class name */
        public static final /* data */ class C0325a implements a {
            public static final C0325a INSTANCE = new C0325a();

            public boolean equals(Object other) {
                return this == other || (other instanceof C0325a);
            }

            public int hashCode() {
                return 640436810;
            }

            public String toString() {
                return "HoldBack";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$a$b;", "Lcom/stepos/ailauncher/speech/tts/r$a;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class b implements a {
            public static final b INSTANCE = new b();

            public boolean equals(Object other) {
                return this == other || (other instanceof b);
            }

            public int hashCode() {
                return -1160733179;
            }

            public String toString() {
                return "Output";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$a$c;", "Lcom/stepos/ailauncher/speech/tts/r$a;", "", "consumed", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.speech.tts.r$a$c, reason: from toString */
        public static final /* data */ class Skip implements a {
            private final int consumed;

            public Skip(int i10) {
                this.consumed = i10;
            }

            /* renamed from: a, reason: from getter */
            public final int getConsumed() {
                return this.consumed;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Skip) && this.consumed == ((Skip) other).consumed;
            }

            public int hashCode() {
                return Integer.hashCode(this.consumed);
            }

            public String toString() {
                return "Skip(consumed=" + this.consumed + ")";
            }
        }
    }

    @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\f\n\u0002\b\u0004\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0014\u0010\u0005\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0005\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0007\u0010\u0006R\u0014\u0010\t\u001a\u00020\b8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000b\u0010\u0006R\u0014\u0010\f\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\f\u0010\u0006R\u0014\u0010\u000e\u001a\u00020\r8\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u000e\u0010\u000fR\u0014\u0010\u0010\u001a\u00020\u00048\u0006X\u0086T¢\u0006\u0006\n\u0004\b\u0010\u0010\u0006¨\u0006\u0011"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$b;", "", "<init>", "()V", "", "MAX_LABEL_CHARS", "I", "SPEAKABLE_CARRY_MAX", "", "ARROW_PAUSE_MARKER", "Ljava/lang/String;", "ARROWS_BLOCK_START", "ARROWS_BLOCK_END", "", "NOTHING_EMITTED", "C", "MAX_INLINE_CODE_CHARS", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class b {
        public /* synthetic */ b(kotlin.jvm.internal.i iVar) {
            this();
        }

        public b() {
        }
    }

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0003\u0002\u0003\u0004\u0082\u0001\u0003\u0005\u0006\u0007¨\u0006\bÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$c;", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_PKGNAME, "c", "Lcom/stepos/ailauncher/speech/tts/r$c$a;", "Lcom/stepos/ailauncher/speech/tts/r$c$b;", "Lcom/stepos/ailauncher/speech/tts/r$c$c;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface c {

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0007\u001a\u00020\u0006HÖ\u0001¢\u0006\u0004\b\u0007\u0010\bJ\u0010\u0010\t\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\n¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$c$a;", "Lcom/stepos/ailauncher/speech/tts/r$c;", "", "consumed", "<init>", "(I)V", "", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.speech.tts.r$c$a, reason: from toString */
        public static final /* data */ class Consumed implements c {
            private final int consumed;

            public Consumed(int i10) {
                this.consumed = i10;
            }

            /* renamed from: a, reason: from getter */
            public final int getConsumed() {
                return this.consumed;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Consumed) && this.consumed == ((Consumed) other).consumed;
            }

            public int hashCode() {
                return Integer.hashCode(this.consumed);
            }

            public String toString() {
                return "Consumed(consumed=" + this.consumed + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$c$b;", "Lcom/stepos/ailauncher/speech/tts/r$c;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class b implements c {
            public static final b INSTANCE = new b();

            public boolean equals(Object other) {
                return this == other || (other instanceof b);
            }

            public int hashCode() {
                return -1218312578;
            }

            public String toString() {
                return "HoldBack";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$c$c;", "Lcom/stepos/ailauncher/speech/tts/r$c;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.speech.tts.r$c$c, reason: collision with other inner class name */
        public static final /* data */ class C0326c implements c {
            public static final C0326c INSTANCE = new C0326c();

            public boolean equals(Object other) {
                return this == other || (other instanceof C0326c);
            }

            public int hashCode() {
                return 1594916385;
            }

            public String toString() {
                return "NotInlineCode";
            }
        }
    }

    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\br\u0018\u00002\u00020\u0001:\u0004\u0002\u0003\u0004\u0005\u0082\u0001\u0004\u0006\u0007\b\t¨\u0006\nÀ\u0006\u0003"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$d;", "", Const.INTENT_KEY_APIKEY, Const.INTENT_KEY_UMID, Const.INTENT_KEY_PKGNAME, "c", "Lcom/stepos/ailauncher/speech/tts/r$d$a;", "Lcom/stepos/ailauncher/speech/tts/r$d$b;", "Lcom/stepos/ailauncher/speech/tts/r$d$c;", "Lcom/stepos/ailauncher/speech/tts/r$d$d;", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public interface d {

        @Metadata(d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0002\u0012\u0006\u0010\u0005\u001a\u00020\u0004¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\b\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\n\u0010\u000bJ\u001a\u0010\u000f\u001a\u00020\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\fHÖ\u0003¢\u0006\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0011\u001a\u0004\b\u0012\u0010\tR\u0017\u0010\u0005\u001a\u00020\u00048\u0006¢\u0006\f\n\u0004\b\u0005\u0010\u0013\u001a\u0004\b\u0014\u0010\u000b¨\u0006\u0015"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$d$a;", "Lcom/stepos/ailauncher/speech/tts/r$d;", "", "label", "", "consumedChars", "<init>", "(Ljava/lang/String;I)V", "toString", "()Ljava/lang/String;", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_PKGNAME, "I", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.speech.tts.r$d$a, reason: from toString */
        public static final /* data */ class Complete implements d {
            private final int consumedChars;
            private final String label;

            public Complete(String label, int i10) {
                kotlin.jvm.internal.p.i(label, "label");
                this.label = label;
                this.consumedChars = i10;
            }

            /* renamed from: a, reason: from getter */
            public final int getConsumedChars() {
                return this.consumedChars;
            }

            /* renamed from: b, reason: from getter */
            public final String getLabel() {
                return this.label;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Complete)) {
                    return false;
                }
                Complete complete = (Complete) other;
                return kotlin.jvm.internal.p.d(this.label, complete.label) && this.consumedChars == complete.consumedChars;
            }

            public int hashCode() {
                return (this.label.hashCode() * 31) + Integer.hashCode(this.consumedChars);
            }

            public String toString() {
                return "Complete(label=" + this.label + ", consumedChars=" + this.consumedChars + ")";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$d$b;", "Lcom/stepos/ailauncher/speech/tts/r$d;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class b implements d {
            public static final b INSTANCE = new b();

            public boolean equals(Object other) {
                return this == other || (other instanceof b);
            }

            public int hashCode() {
                return -1960002001;
            }

            public String toString() {
                return "Incomplete";
            }
        }

        @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bÆ\n\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0005\u001a\u00020\u0004HÖ\u0001¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u0010\b\u001a\u00020\u0007HÖ\u0001¢\u0006\u0004\b\b\u0010\tJ\u001a\u0010\r\u001a\u00020\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\nHÖ\u0003¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$d$c;", "Lcom/stepos/ailauncher/speech/tts/r$d;", "<init>", "()V", "", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        public static final /* data */ class c implements d {
            public static final c INSTANCE = new c();

            public boolean equals(Object other) {
                return this == other || (other instanceof c);
            }

            public int hashCode() {
                return 2015932921;
            }

            public String toString() {
                return "NotALink";
            }
        }

        @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u0002HÖ\u0001¢\u0006\u0004\b\u0006\u0010\u0007J\u0010\u0010\t\u001a\u00020\bHÖ\u0001¢\u0006\u0004\b\t\u0010\nJ\u001a\u0010\u000e\u001a\u00020\r2\b\u0010\f\u001a\u0004\u0018\u00010\u000bHÖ\u0003¢\u0006\u0004\b\u000e\u0010\u000fR\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0010\u001a\u0004\b\u0011\u0010\u0007¨\u0006\u0012"}, d2 = {"Lcom/stepos/ailauncher/speech/tts/r$d$d;", "Lcom/stepos/ailauncher/speech/tts/r$d;", "", "label", "<init>", "(Ljava/lang/String;)V", "toString", "()Ljava/lang/String;", "", "hashCode", "()I", "", "other", "", "equals", "(Ljava/lang/Object;)Z", "Ljava/lang/String;", Const.INTENT_KEY_APIKEY, "speech_release"}, k = 1, mv = {2, 2, 0}, xi = 48)
        /* renamed from: com.stepos.ailauncher.speech.tts.r$d$d, reason: collision with other inner class name and from toString */
        public static final /* data */ class Truncated implements d {
            private final String label;

            public Truncated(String label) {
                kotlin.jvm.internal.p.i(label, "label");
                this.label = label;
            }

            /* renamed from: a, reason: from getter */
            public final String getLabel() {
                return this.label;
            }

            public boolean equals(Object other) {
                if (this == other) {
                    return true;
                }
                return (other instanceof Truncated) && kotlin.jvm.internal.p.d(this.label, ((Truncated) other).label);
            }

            public int hashCode() {
                return this.label.hashCode();
            }

            public String toString() {
                return "Truncated(label=" + this.label + ")";
            }
        }
    }

    public final boolean A(char c10) {
        return (c10 == 0 || !Character.isLetter(c10) || y(c10)) ? false : true;
    }

    public final boolean B(char c10) {
        return c10 < 11904 && Character.isLetterOrDigit(c10);
    }

    public final boolean C(CharSequence source, int index) {
        if (index >= source.length()) {
            return false;
        }
        char cCharAt = source.charAt(index);
        return cCharAt == '*' || cCharAt == '_';
    }

    public final boolean D(CharSequence source, int index) {
        char cCharAt;
        if (index <= 0) {
            return true;
        }
        int i10 = index - 1;
        while (i10 >= 0 && (source.charAt(i10) == ' ' || source.charAt(i10) == '\t')) {
            i10--;
        }
        return i10 < 0 || (cCharAt = source.charAt(i10)) == '\n' || cCharAt == '\r' || cCharAt == 12290 || cCharAt == 65281 || cCharAt == 65311 || cCharAt == 65307 || cCharAt == '.' || cCharAt == '!' || cCharAt == '?' || cCharAt == ';' || cCharAt == 65306 || cCharAt == ':' || cCharAt == 65292 || cCharAt == ',';
    }

    public final boolean E(CharSequence source, int index, StringBuilder output) {
        Character chF;
        Character chR;
        if (F(source, index) && (chF = f(source, index, output)) != null && Character.isDigit(chF.charValue()) && (chR = R(source, Character.charCount(Character.codePointAt(source, index)) + index)) != null && Character.isDigit(chR.charValue())) {
            return !v(source, index, output);
        }
        return false;
    }

    public final boolean F(CharSequence source, int index) {
        if (index >= source.length() || M(source, index, "->")) {
            return false;
        }
        int iCodePointAt = Character.codePointAt(source, index);
        return I(iCodePointAt) || iCodePointAt == 45;
    }

    public final boolean G(CharSequence source, int index) {
        Character chX;
        if (index < source.length() && source.charAt(index) == '-' && (chX = X(source, index)) != null) {
            char cCharValue = chX.charValue();
            int i10 = index + 1;
            int iC0 = c0(source, i10);
            if (iC0 >= source.length() || iC0 == i10) {
                return false;
            }
            char cCharAt = source.charAt(iC0);
            if (index > 0 && C0951a.c(source.charAt(index - 1)) && u(cCharValue) && u(cCharAt)) {
                return true;
            }
        }
        return false;
    }

    public final boolean H(CharSequence source, int index) {
        int i10;
        int iC0;
        if (index >= source.length() || source.charAt(index) != '-' || index == 0) {
            return false;
        }
        int i11 = index - 1;
        if (!C0951a.c(source.charAt(i11)) && u(source.charAt(i11)) && (iC0 = c0(source, (i10 = index + 1))) < source.length() && iC0 != i10) {
            return u(source.charAt(iC0));
        }
        return false;
    }

    public final boolean I(int cp) {
        return cp == 8212 || cp == 8211 || cp == 8213;
    }

    public final boolean J(CharSequence source, int index) {
        if (index >= source.length()) {
            return false;
        }
        return I(Character.codePointAt(source, index));
    }

    public final String K(CharSequence source, int dashIndex, StringBuilder output) {
        String strG0;
        int i10 = dashIndex - 1;
        while (i10 >= 0 && C0951a.c(source.charAt(i10))) {
            i10--;
        }
        if (i10 < 0) {
            String strF0 = f0(output);
            return strF0 != null ? strF0 : g0();
        }
        boolean z10 = false;
        int i11 = i10;
        while (i11 >= 0) {
            char cCharAt = source.charAt(i11);
            if (Character.isDigit(cCharAt)) {
                i11--;
            } else {
                if (cCharAt != '.' || z10) {
                    break;
                }
                i11--;
                z10 = true;
            }
        }
        String string = source.subSequence(i11 + 1, i10 + 1).toString();
        if (i11 >= 0 || ((!Character.isDigit(this.lastEmittedChar) && this.lastEmittedChar != '.') || (strG0 = g0()) == null)) {
            return string;
        }
        return strG0 + string;
    }

    public final boolean L(String value) {
        String string = H.H1(value).toString();
        if (!D.X(string, "//", false, 2, null) && !D.X(string, "/", false, 2, null) && !D.X(string, Const.STR_MART_WELL, false, 2, null)) {
            int iT0 = H.t0(string, ':', 0, false, 6, null);
            if (iT0 <= 0 || !Character.isLetter(string.charAt(0))) {
                return false;
            }
            String strSubstring = string.substring(1, iT0);
            kotlin.jvm.internal.p.h(strSubstring, "substring(...)");
            for (int i10 = 0; i10 < strSubstring.length(); i10++) {
                char cCharAt = strSubstring.charAt(i10);
                if (!Character.isLetterOrDigit(cCharAt) && cCharAt != '+' && cCharAt != '-' && cCharAt != '.') {
                    return false;
                }
            }
        }
        return true;
    }

    public final boolean M(CharSequence source, int index, String marker) {
        if (marker.length() + index > source.length()) {
            return false;
        }
        int length = marker.length();
        for (int i10 = 0; i10 < length; i10++) {
            if (source.charAt(index + i10) != marker.charAt(i10)) {
                return false;
            }
        }
        return true;
    }

    public final int N(CharSequence source, int index, boolean z10) {
        if (index >= source.length() || source.charAt(index) != '#') {
            return 0;
        }
        int i10 = index;
        int i11 = 0;
        while (i10 < source.length() && source.charAt(i10) == '#' && i11 < 6) {
            i11++;
            i10++;
        }
        if (i11 == 0) {
            return 0;
        }
        if (i10 >= source.length()) {
            return z10 ? 0 : -1;
        }
        char cCharAt = source.charAt(i10);
        if (cCharAt != ' ' && cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\r') {
            return 0;
        }
        if (i11 != 1 || D(source, index)) {
            return c0(source, i10) - index;
        }
        return 0;
    }

    public final int O(CharSequence source, int index, boolean z10) {
        if (index >= source.length()) {
            return 0;
        }
        char cCharAt = source.charAt(index);
        if ((cCharAt != 8226 && cCharAt != 8227) || !D(source, index)) {
            return 0;
        }
        int i10 = index + 1;
        return i10 >= source.length() ? z10 ? 0 : -1 : c0(source, i10) - index;
    }

    public final int P(CharSequence source, int index, boolean z10) {
        if (index >= source.length() || source.charAt(index) != '-' || !D(source, index)) {
            return 0;
        }
        int i10 = index;
        while (i10 < source.length() && source.charAt(i10) == '-') {
            i10++;
        }
        int i11 = i10 - index;
        if (i11 < 3) {
            return (z10 || i10 < source.length() || i11 < 1) ? 0 : -1;
        }
        if (i10 < source.length()) {
            char cCharAt = source.charAt(i10);
            if (!C0951a.c(cCharAt) && cCharAt != '\n' && cCharAt != '\r') {
                return 0;
            }
        }
        return c0(source, i10) - index;
    }

    public final int Q(CharSequence source, int index, boolean z10) {
        int i10;
        if (index >= source.length()) {
            return 0;
        }
        char cCharAt = source.charAt(index);
        if (cCharAt != '-' && cCharAt != '*' && cCharAt != '+') {
            return 0;
        }
        if ((cCharAt == '-' && (i10 = index + 1) < source.length() && source.charAt(i10) == '-') || !D(source, index)) {
            return 0;
        }
        int i11 = index + 1;
        if (i11 >= source.length()) {
            return z10 ? 0 : -1;
        }
        char cCharAt2 = source.charAt(i11);
        if (cCharAt2 == ' ' || cCharAt2 == '\t') {
            return c0(source, i11) - index;
        }
        return 0;
    }

    public final Character R(CharSequence source, int start) {
        int iC0 = c0(source, start);
        if (iC0 < source.length()) {
            return Character.valueOf(source.charAt(iC0));
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0043  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String S(java.lang.String r8, boolean r9) {
        /*
            Method dump skipped, instructions count: 628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.r.S(java.lang.String, boolean):java.lang.String");
    }

    public final int T(CharSequence source, int index, boolean z10) {
        if (index < source.length() && source.charAt(index) == '.') {
            char cCharAt = index > 0 ? source.charAt(index - 1) : this.lastEmittedChar;
            if (cCharAt != 0 && Character.isDigit(cCharAt)) {
                int iC0 = c0(source, index + 1);
                if (iC0 >= source.length()) {
                    if (z10) {
                        return C5685n.f(iC0 - index, 1);
                    }
                    return -1;
                }
                if (Character.isDigit(source.charAt(iC0))) {
                    return 0;
                }
                return iC0 - index;
            }
        }
        return 0;
    }

    public final d U(boolean z10) {
        char c10;
        int iU0 = H.u0(this.pending, "]", 1, false, 4, null);
        if (iU0 < 0) {
            return (z10 || this.pending.length() > 512) ? d.c.INSTANCE : d.b.INSTANCE;
        }
        int i10 = iU0 + 1;
        if (i10 >= this.pending.length()) {
            return z10 ? d.c.INSTANCE : d.b.INSTANCE;
        }
        char cCharAt = this.pending.charAt(i10);
        if (cCharAt == '(') {
            c10 = ')';
        } else {
            if (cCharAt != 12304) {
                return d.c.INSTANCE;
            }
            c10 = 12305;
        }
        int iJ = j(i10, cCharAt, c10);
        if (iJ >= 0) {
            String strSubstring = this.pending.substring(iU0 + 2, iJ);
            if (cCharAt == 12304) {
                kotlin.jvm.internal.p.f(strSubstring);
                if (!L(strSubstring)) {
                    return d.c.INSTANCE;
                }
            }
            String strSubstring2 = this.pending.substring(1, iU0);
            kotlin.jvm.internal.p.h(strSubstring2, "substring(...)");
            return new d.Complete(strSubstring2, iJ + 1);
        }
        if (!z10) {
            return d.b.INSTANCE;
        }
        String strSubstring3 = this.pending.substring(iU0 + 2);
        kotlin.jvm.internal.p.f(strSubstring3);
        if (!L(strSubstring3)) {
            return d.c.INSTANCE;
        }
        String strSubstring4 = this.pending.substring(1, iU0);
        kotlin.jvm.internal.p.h(strSubstring4, "substring(...)");
        return new d.Truncated(strSubstring4);
    }

    public final int V(CharSequence source, int index, boolean z10) {
        if (index >= source.length() || source.charAt(index) != '+') {
            return 0;
        }
        int iC0 = c0(source, index + 1);
        if (iC0 >= source.length()) {
            return z10 ? 1 : -1;
        }
        Character chF = f(source, index, new StringBuilder());
        return (chF != null && Character.isDigit(chF.charValue()) && Character.isDigit(source.charAt(iC0))) ? 0 : 1;
    }

    public final boolean W(CharSequence source, int dashIndex, StringBuilder output) {
        Character chF;
        int i10 = dashIndex - 1;
        while (i10 >= 0 && C0951a.c(source.charAt(i10))) {
            i10--;
        }
        while (i10 >= 0 && (Character.isDigit(source.charAt(i10)) || source.charAt(i10) == '.')) {
            i10--;
        }
        while (i10 >= 0 && C0951a.c(source.charAt(i10))) {
            i10--;
        }
        if (i10 < 0) {
            return false;
        }
        return (I(Character.codePointAt(source, i10)) || source.charAt(i10) == '-') && (chF = f(source, i10, output)) != null && Character.isDigit(chF.charValue());
    }

    public final Character X(CharSequence source, int index) {
        int i10 = index - 1;
        while (i10 >= 0 && C0951a.c(source.charAt(i10))) {
            i10--;
        }
        if (i10 >= 0) {
            return Character.valueOf(source.charAt(i10));
        }
        return null;
    }

    public final String Y(CharSequence source, int start) {
        int i10;
        if (start >= source.length() || !Character.isDigit(source.charAt(start))) {
            return null;
        }
        boolean z10 = false;
        int i11 = start;
        while (i11 < source.length()) {
            char cCharAt = source.charAt(i11);
            if (Character.isDigit(cCharAt)) {
                i11++;
            } else {
                if (cCharAt != '.' || z10 || (i10 = i11 + 1) >= source.length() || !Character.isDigit(source.charAt(i10))) {
                    break;
                }
                i11 = i10;
                z10 = true;
            }
        }
        return source.subSequence(start, i11).toString();
    }

    public final boolean Z(CharSequence source, int index, boolean z10) {
        Character chF;
        return !z10 && J(source, index) && (chF = f(source, index, new StringBuilder())) != null && A(chF.charValue()) && R(source, index + Character.charCount(Character.codePointAt(source, index))) == null;
    }

    public final synchronized String a(String text) {
        try {
            kotlin.jvm.internal.p.i(text, "text");
            if (text.length() > 0) {
                this.pending.append(text);
            }
        } catch (Throwable th) {
            throw th;
        }
        return S(i(false), false);
    }

    public final boolean a0(CharSequence source, int index, boolean z10) {
        return !z10 && F(source, index) && R(source, index + Character.charCount(Character.codePointAt(source, index))) == null;
    }

    public final void b(StringBuilder output) {
        if ((output.length() > 0 ? K.P1(output) : this.lastEmittedChar) == 12305) {
            return;
        }
        output.append(ARROW_PAUSE_MARKER);
    }

    public final int b0(CharSequence source, int start) {
        while (start < source.length()) {
            int iCodePointAt = Character.codePointAt(source, start);
            int iCharCount = Character.charCount(iCodePointAt);
            if (!w(iCodePointAt) && iCodePointAt != 8205 && iCodePointAt != 65039 && (127995 > iCodePointAt || iCodePointAt >= 128000)) {
                return start;
            }
            start += iCharCount;
            if (start >= source.length() || Character.codePointAt(source, start) != 8205) {
                if (start < source.length() && Character.codePointAt(source, start) == 65039) {
                    start += Character.charCount(65039);
                }
                if (start >= source.length() || Character.codePointAt(source, start) != 8205) {
                    break;
                }
            } else {
                start += Character.charCount(8205);
            }
        }
        return start;
    }

    public final void c(StringBuilder output) {
        char cP1;
        this.pendingLineBreak = false;
        while (output.length() > 0 && ((cP1 = K.P1(output)) == ' ' || cP1 == '\t' || cP1 == 160)) {
            output.deleteCharAt(output.length() - 1);
        }
        char cP12 = output.length() > 0 ? K.P1(output) : this.lastEmittedChar;
        if (cP12 == 0 || cP12 == ',' || cP12 == '.' || cP12 == 12290 || cP12 == 65292) {
            return;
        }
        output.append((char) 65292);
    }

    public final int c0(CharSequence source, int start) {
        while (start < source.length() && (source.charAt(start) == ' ' || source.charAt(start) == '\t')) {
            start++;
        }
        return start;
    }

    public final void d(CharSequence content, StringBuilder output) {
        if (H.x0(content)) {
            return;
        }
        m(output);
        if (B(output.length() > 0 ? K.P1(output) : this.lastEmittedChar)) {
            output.append(' ');
        }
        int length = output.length();
        int i10 = 0;
        while (i10 < content.length()) {
            char cCharAt = content.charAt(i10);
            int i11 = i10 + 1;
            char cCharAt2 = i11 < content.length() ? content.charAt(i11) : (char) 0;
            int i12 = i10 + 2;
            char cCharAt3 = i12 < content.length() ? content.charAt(i12) : (char) 0;
            if (cCharAt == '=' && cCharAt2 == '=' && cCharAt3 == '=') {
                output.append(" 等于 ");
            } else {
                if (cCharAt == '=' && cCharAt2 == '=') {
                    output.append(" 等于 ");
                } else if (cCharAt == '!' && cCharAt2 == '=' && cCharAt3 == '=') {
                    output.append(" 不等于 ");
                } else if (cCharAt == '!' && cCharAt2 == '=') {
                    output.append(" 不等于 ");
                } else if (cCharAt == '>' && cCharAt2 == '=') {
                    output.append(" 大于等于 ");
                } else if (cCharAt == '<' && cCharAt2 == '=') {
                    output.append(" 小于等于 ");
                } else if ((cCharAt == '=' && cCharAt2 == '>') || (cCharAt == '-' && cCharAt2 == '>')) {
                    output.append(' ');
                    b(output);
                    output.append(' ');
                } else {
                    if (cCharAt == '=') {
                        output.append(" 等于 ");
                    } else if (cCharAt == '[' || cCharAt == ']' || cCharAt == '\'' || cCharAt == '\"') {
                        output.append(' ');
                    } else {
                        output.append(cCharAt);
                    }
                    i10 = i11;
                }
                i10 = i12;
            }
            i10 += 3;
        }
        while (output.length() > length && K.P1(output) == ' ') {
            output.deleteCharAt(output.length() - 1);
        }
    }

    public final int d0(CharSequence source, int index) {
        int i10 = index;
        while (i10 < source.length() && source.charAt(i10) != '\n' && source.charAt(i10) != '\r') {
            i10++;
        }
        if (i10 < source.length() && source.charAt(i10) == '\r') {
            i10++;
        }
        if (i10 < source.length() && source.charAt(i10) == '\n') {
            i10++;
        }
        return i10 - index;
    }

    public final void e(StringBuilder output) {
        char cP1;
        this.pendingLineBreak = false;
        while (output.length() > 0 && ((cP1 = K.P1(output)) == ' ' || cP1 == '\t' || cP1 == 160)) {
            output.deleteCharAt(output.length() - 1);
        }
        output.append((char) 21040);
    }

    public final int e0(String emitted, char previous, int previousRun) {
        int length = emitted.length() - 1;
        int i10 = 0;
        boolean z10 = false;
        while (length >= 0) {
            char cCharAt = emitted.charAt(length);
            if (Character.isDigit(cCharAt)) {
                i10++;
                length--;
            } else {
                if (cCharAt != '.' || z10) {
                    break;
                }
                length--;
                z10 = true;
            }
        }
        if (i10 == 0) {
            return 0;
        }
        return (length >= 0 || !(Character.isDigit(previous) || previous == '.')) ? i10 : previousRun + i10;
    }

    public final Character f(CharSequence source, int index, StringBuilder output) {
        int i10 = index - 1;
        while (i10 >= 0 && C0951a.c(source.charAt(i10))) {
            i10--;
        }
        if (i10 >= 0) {
            return Character.valueOf(source.charAt(i10));
        }
        int length = output.length() - 1;
        while (length >= 0 && C0951a.c(output.charAt(length))) {
            length--;
        }
        if (length >= 0) {
            return Character.valueOf(output.charAt(length));
        }
        char c10 = this.lastEmittedChar;
        Character chValueOf = Character.valueOf(c10);
        if (c10 == 0 || C0951a.c(c10)) {
            return null;
        }
        return chValueOf;
    }

    public final String f0(StringBuilder output) {
        if (output.length() == 0) {
            return null;
        }
        int length = output.length() - 1;
        while (length >= 0 && C0951a.c(output.charAt(length))) {
            length--;
        }
        if (length < 0 || !(Character.isDigit(output.charAt(length)) || output.charAt(length) == '.')) {
            return null;
        }
        boolean z10 = false;
        int i10 = length;
        while (i10 >= 0) {
            char cCharAt = output.charAt(i10);
            if (Character.isDigit(cCharAt)) {
                i10--;
            } else {
                if (cCharAt != '.' || z10) {
                    break;
                }
                i10--;
                z10 = true;
            }
        }
        return output.subSequence(i10 + 1, length + 1).toString();
    }

    public final String g(String text) {
        return text.length() == 0 ? text : new Regex("[ \\t\\u00A0]{2,}").l(text, " ");
    }

    public final String g0() {
        int i10;
        if (!Character.isDigit(this.lastEmittedChar) || (i10 = this.trailingDigitRun) <= 0) {
            return null;
        }
        return D.P("0", i10);
    }

    public final int h(CharSequence source, int index) {
        int i10 = index;
        while (i10 < source.length() && source.charAt(i10) == '`') {
            i10++;
        }
        return i10 - index;
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0080, code lost:
    
        r4 = r0.toString();
        kotlin.jvm.internal.p.h(r4, "toString(...)");
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x008a, code lost:
    
        return r4;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.String i(boolean r5) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L5:
            java.lang.StringBuilder r1 = r4.pending
            int r1 = r1.length()
            if (r1 <= 0) goto L80
            int r1 = r4.k()
            r2 = 0
            if (r1 >= 0) goto L1f
            java.lang.StringBuilder r5 = r4.pending
            r0.append(r5)
            java.lang.StringBuilder r4 = r4.pending
            r4.setLength(r2)
            goto L80
        L1f:
            if (r1 <= 0) goto L2b
            java.lang.StringBuilder r3 = r4.pending
            r0.append(r3, r2, r1)
            java.lang.StringBuilder r3 = r4.pending
            r3.delete(r2, r1)
        L2b:
            com.stepos.ailauncher.speech.tts.r$d r1 = r4.U(r5)
            boolean r3 = r1 instanceof com.stepos.ailauncher.speech.tts.r.d.Complete
            if (r3 == 0) goto L46
            com.stepos.ailauncher.speech.tts.r$d$a r1 = (com.stepos.ailauncher.speech.tts.r.d.Complete) r1
            java.lang.String r3 = r1.getLabel()
            r0.append(r3)
            java.lang.StringBuilder r3 = r4.pending
            int r1 = r1.getConsumedChars()
            r3.delete(r2, r1)
            goto L5
        L46:
            boolean r3 = r1 instanceof com.stepos.ailauncher.speech.tts.r.d.Truncated
            if (r3 == 0) goto L5b
            com.stepos.ailauncher.speech.tts.r$d$d r1 = (com.stepos.ailauncher.speech.tts.r.d.Truncated) r1
            java.lang.String r1 = r1.getLabel()
            r0.append(r1)
            java.lang.StringBuilder r1 = r4.pending
            r1.setLength(r2)
            Y8.t r1 = Y8.t.f7040a
            goto L5
        L5b:
            com.stepos.ailauncher.speech.tts.r$d$b r3 = com.stepos.ailauncher.speech.tts.r.d.b.INSTANCE
            boolean r3 = kotlin.jvm.internal.p.d(r1, r3)
            if (r3 != 0) goto L80
            com.stepos.ailauncher.speech.tts.r$d$c r3 = com.stepos.ailauncher.speech.tts.r.d.c.INSTANCE
            boolean r1 = kotlin.jvm.internal.p.d(r1, r3)
            if (r1 == 0) goto L7a
            java.lang.StringBuilder r1 = r4.pending
            char r1 = r1.charAt(r2)
            r0.append(r1)
            java.lang.StringBuilder r1 = r4.pending
            r1.deleteCharAt(r2)
            goto L5
        L7a:
            kotlin.NoWhenBranchMatchedException r4 = new kotlin.NoWhenBranchMatchedException
            r4.<init>()
            throw r4
        L80:
            java.lang.String r4 = r0.toString()
            java.lang.String r5 = "toString(...)"
            kotlin.jvm.internal.p.h(r4, r5)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.stepos.ailauncher.speech.tts.r.i(boolean):java.lang.String");
    }

    public final int j(int openIndex, char opener, char closer) {
        int length = this.pending.length();
        int i10 = 1;
        boolean z10 = false;
        for (int i11 = openIndex + 1; i11 < length; i11++) {
            char cCharAt = this.pending.charAt(i11);
            if (z10) {
                z10 = false;
            } else if (cCharAt == '\\') {
                z10 = true;
            } else if (cCharAt == opener) {
                i10++;
            } else if (cCharAt == closer && i10 - 1 == 0) {
                return i11;
            }
        }
        return -1;
    }

    public final int k() {
        return this.pending.indexOf("[");
    }

    public final synchronized String l() {
        String string;
        string = H.F1(S(i(true), true)).toString();
        this.inCodeBlock = false;
        this.lastEmittedChar = (char) 0;
        this.trailingDigitRun = 0;
        this.pendingLineBreak = false;
        return string;
    }

    public final void m(StringBuilder output) {
        if (this.pendingLineBreak) {
            p(output);
        }
    }

    public final a n(CharSequence source, int index, StringBuilder output, boolean z10) {
        if (!s(source, index)) {
            return a.b.INSTANCE;
        }
        int iH = h(source, index);
        if (iH >= 3) {
            this.inCodeBlock = !this.inCodeBlock;
            return new a.Skip(d0(source, index));
        }
        if (!this.inCodeBlock) {
            return (z10 || 1 > iH || iH >= 3 || index + iH < source.length()) ? a.b.INSTANCE : a.C0325a.INSTANCE;
        }
        if (!z10) {
            return new a.Skip(d0(source, index));
        }
        this.inCodeBlock = false;
        return new a.Skip(source.length() - index);
    }

    public final c o(CharSequence source, int index, StringBuilder output, boolean z10) {
        char cCharAt;
        if (index >= source.length() || source.charAt(index) != '`') {
            return c.C0326c.INSTANCE;
        }
        int iH = h(source, index);
        if (iH >= 3) {
            return new c.Consumed(iH);
        }
        int i10 = index + iH;
        int i11 = i10;
        while (i11 < source.length() && (cCharAt = source.charAt(i11)) != '\n' && cCharAt != '\r') {
            if (cCharAt == '`') {
                int iH2 = h(source, i11);
                if (iH2 == iH) {
                    d(source.subSequence(i10, i11), output);
                    return new c.Consumed((i11 + iH2) - index);
                }
                i11 += iH2;
            } else {
                i11++;
            }
        }
        return (z10 || !(i11 >= source.length()) || i11 - i10 >= 200) ? new c.Consumed(iH) : c.b.INSTANCE;
    }

    public final void p(StringBuilder output) {
        char cP1;
        this.pendingLineBreak = false;
        while (output.length() > 0 && ((cP1 = K.P1(output)) == ' ' || cP1 == '\t')) {
            output.deleteCharAt(output.length() - 1);
        }
        char cP12 = output.length() > 0 ? K.P1(output) : this.lastEmittedChar;
        if (cP12 == 0) {
            return;
        }
        switch (cP12) {
            case '!':
            case ',':
            case '.':
            case ':':
            case ';':
            case '?':
            case 12289:
            case 12290:
            case 65281:
            case 65292:
            case 65306:
            case 65307:
            case 65311:
                break;
            default:
                output.append((char) 65292);
                break;
        }
    }

    public final boolean q(String tail) {
        int i10 = 0;
        if (tail.length() == 0) {
            return false;
        }
        int iHashCode = tail.hashCode();
        if (iHashCode == 35 ? !tail.equals(Const.STR_MART_WELL) : !(iHashCode == 42 ? tail.equals("*") : iHashCode == 45 ? tail.equals(O6.l.DATE_SEPARATOR) : iHashCode == 62 ? tail.equals(">") : iHashCode == 95 && tail.equals("_"))) {
            if (!D.K(tail, "*", false, 2, null) && !D.K(tail, "_", false, 2, null) && !D.K(tail, ">", false, 2, null) && !D.K(tail, "\n", false, 2, null) && !D.K(tail, "\r", false, 2, null)) {
                int i11 = 0;
                while (true) {
                    if (i11 >= tail.length()) {
                        int length = tail.length();
                        if (1 <= length && length < 7) {
                            return true;
                        }
                    } else {
                        if (tail.charAt(i11) != '#') {
                            break;
                        }
                        i11++;
                    }
                }
                while (true) {
                    if (i10 >= tail.length()) {
                        int length2 = tail.length();
                        if (1 <= length2 && length2 < 3) {
                            return true;
                        }
                    } else {
                        if (tail.charAt(i10) != '-') {
                            break;
                        }
                        i10++;
                    }
                }
                return Character.isHighSurrogate(K.P1(tail));
            }
        }
        return true;
    }

    public final boolean r(int cp) {
        return 8592 <= cp && cp < 8704;
    }

    public final boolean s(CharSequence source, int index) {
        int i10 = index - 1;
        while (i10 >= 0 && (source.charAt(i10) == ' ' || source.charAt(i10) == '\t')) {
            i10--;
        }
        return i10 < 0 || source.charAt(i10) == '\n' || source.charAt(i10) == '\r';
    }

    public final boolean t(CharSequence source, int index) {
        char cCharAt;
        if (index >= source.length() || source.charAt(index) != '>') {
            return false;
        }
        int i10 = index + 1;
        if (i10 < source.length() && source.charAt(i10) == '>') {
            return false;
        }
        if (index != 0) {
            int i11 = index - 1;
            if (source.charAt(i11) != '\n' && source.charAt(i11) != '\r') {
                return false;
            }
        }
        return i10 >= source.length() || (cCharAt = source.charAt(i10)) == ' ' || cCharAt == '\t' || cCharAt == '\n' || cCharAt == '\r';
    }

    public final boolean u(char c10) {
        return Character.isLetter(c10) || Character.UnicodeScript.of(c10) == Character.UnicodeScript.HAN;
    }

    public final boolean v(CharSequence source, int dashIndex, StringBuilder output) {
        String strY;
        int length;
        int length2;
        String strK = K(source, dashIndex, output);
        if (strK != null && (strY = Y(source, c0(source, Character.charCount(Character.codePointAt(source, dashIndex)) + dashIndex))) != null && !H.f0(strK, '.', false, 2, null) && !H.f0(strY, '.', false, 2, null)) {
            if (strK.length() == 4 && 1 <= (length2 = strY.length()) && length2 < 3) {
                return true;
            }
            int length3 = strK.length();
            if (1 <= length3 && length3 < 3 && 1 <= (length = strY.length()) && length < 3 && W(source, dashIndex, output)) {
                return true;
            }
        }
        return false;
    }

    public final boolean w(int cp) {
        if (127744 <= cp && cp < 129792) {
            return true;
        }
        if (9728 <= cp && cp < 10176) {
            return true;
        }
        if (8960 <= cp && cp < 9216) {
            return true;
        }
        if (11008 <= cp && cp < 11264) {
            return true;
        }
        if (126976 <= cp && cp < 127024) {
            return true;
        }
        if ((127136 <= cp && cp < 127232) || cp == 8205 || cp == 65039 || (127995 <= cp && cp < 128000)) {
            return true;
        }
        Character.UnicodeBlock unicodeBlockOf = Character.UnicodeBlock.of(cp);
        if (unicodeBlockOf == null) {
            return false;
        }
        return kotlin.jvm.internal.p.d(unicodeBlockOf, Character.UnicodeBlock.EMOTICONS) || kotlin.jvm.internal.p.d(unicodeBlockOf, Character.UnicodeBlock.MISCELLANEOUS_SYMBOLS_AND_PICTOGRAPHS) || kotlin.jvm.internal.p.d(unicodeBlockOf, Character.UnicodeBlock.TRANSPORT_AND_MAP_SYMBOLS) || kotlin.jvm.internal.p.d(unicodeBlockOf, Character.UnicodeBlock.SUPPLEMENTAL_SYMBOLS_AND_PICTOGRAPHS);
    }

    public final boolean x(CharSequence source, int index) {
        int i10;
        if (index < source.length() && source.charAt(index) == '/' && index != 0) {
            int i11 = index - 1;
            if (!C0951a.c(source.charAt(i11)) && (i10 = index + 1) < source.length() && !C0951a.c(source.charAt(i10))) {
                char cCharAt = source.charAt(i11);
                char cCharAt2 = source.charAt(i10);
                if (u(cCharAt) && u(cCharAt2)) {
                    return true;
                }
            }
        }
        return false;
    }

    public final boolean y(char c10) {
        return c10 != 0 && Character.UnicodeScript.of(c10) == Character.UnicodeScript.HAN;
    }

    public final boolean z(CharSequence source, int index, StringBuilder output) {
        Character chF;
        Character chR;
        if (J(source, index) && (chF = f(source, index, output)) != null && A(chF.charValue()) && (chR = R(source, index + Character.charCount(Character.codePointAt(source, index)))) != null) {
            return y(chR.charValue());
        }
        return false;
    }
}
